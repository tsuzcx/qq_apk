package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.avatar.utils.ApolloUtil;
import com.tencent.mobileqq.avatar.utils.AvatarImplUtil;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadOptimizer;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.apache.http.ConnectionClosedException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;

public abstract class FaceDownloader
{
  private static final int DEFAULT_CHECK_INTERVAL = 30000;
  private static int DPC_WAP_DIRECT_CONNECT = 1;
  public static final int MSG_DOWNLOAD_FINISH = 100;
  private static final String TAG = "Q.qqhead.FaceDownloader";
  private static boolean forceDirect = false;
  private static String lastApn;
  protected AtomicInteger currThreadCount;
  private int emptyCheckMax;
  protected MqqHandler handler;
  protected AtomicInteger idleThreadCount;
  protected AppRuntime mApp;
  private FaceDownloader.FaceDownloadRunnable[] mDownRunnables;
  private Thread[] mDownThreads;
  LinkedList<FaceDownloader.FaceDownloadListener> mDownloadListener;
  protected HashSet<String> mDownloadingUrlSet;
  protected ArrayList<FaceInfo> mRequestQueue;
  private FaceDownloader.FaceDownloadThreadInfo mThreadInfo;
  public int maxThreadCount = 6;
  private int priorDownloadQQheadThreshold;
  public ArrayList<FaceDownloader.PendingTask> sPendingResultList;
  
  public FaceDownloader(AppRuntime paramAppRuntime)
  {
    int i = 0;
    this.idleThreadCount = new AtomicInteger(0);
    this.currThreadCount = new AtomicInteger(0);
    this.mDownThreads = null;
    this.mDownRunnables = null;
    this.emptyCheckMax = 2;
    this.priorDownloadQQheadThreshold = 10;
    this.mDownloadListener = new LinkedList();
    this.sPendingResultList = new ArrayList(100);
    this.mApp = null;
    initFaceDownloadThreadInfo();
    initDPCFlag();
    if (this.mThreadInfo.maxThreadCount != -2147483648) {
      this.maxThreadCount = this.mThreadInfo.maxThreadCount;
    }
    String str = BaseApplication.processName;
    if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.mobileqq"))) {
      this.maxThreadCount = 4;
    }
    this.mApp = paramAppRuntime;
    this.mRequestQueue = new ArrayList();
    this.mDownloadingUrlSet = new HashSet();
    this.currThreadCount.set(this.maxThreadCount);
    int j = this.maxThreadCount;
    this.mDownThreads = new Thread[j];
    this.mDownRunnables = new FaceDownloader.FaceDownloadRunnable[j];
    while (i < this.mDownThreads.length)
    {
      this.mDownRunnables[i] = new FaceDownloader.FaceDownloadRunnable(this, i);
      this.mDownThreads[i] = ThreadManager.newFreeThread(this.mDownRunnables[i], "FaceDownloadThread", 5);
      if (ThreadOptimizer.a().f()) {
        this.mDownThreads[i].setPriority(1);
      }
      try
      {
        this.mDownThreads[i].start();
      }
      catch (OutOfMemoryError paramAppRuntime)
      {
        QLog.e("Q.qqhead.FaceDownloader", 1, "FaceDownloader() error, ", paramAppRuntime);
      }
      i += 1;
    }
    this.handler = new FaceDownloader.1(this, Looper.getMainLooper());
  }
  
  private void cacheFile(FaceInfo paramFaceInfo, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      FaceDownloader.PendingTask localPendingTask = new FaceDownloader.PendingTask(this);
      localPendingTask.faceInfo = paramFaceInfo;
      if (paramInt != 0)
      {
        paramFaceInfo.a(FaceInfo.A);
        localPendingTask.bitmap = null;
        this.sPendingResultList.add(localPendingTask);
        this.handler.obtainMessage(100, localPendingTask).sendToTarget();
        return;
      }
      if (paramLong >= 20480L)
      {
        paramFaceInfo.a(FaceInfo.B);
        BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = FaceConstant.HeadConfig.FACE_BITMAP_CONFIG;
        IQQAvatarManagerService localIQQAvatarManagerService = (IQQAvatarManagerService)this.mApp.getRuntimeService(IQQAvatarManagerService.class, "nearby");
        int i = 0;
        paramInt = 0;
        do
        {
          BitmapManager.a(localIQQAvatarManagerService.getFacePath(paramFaceInfo), localOptions, localBitmapDecodeResult);
          if ((localBitmapDecodeResult.b == 1) && (GlobalImageCache.a != null))
          {
            int j = GlobalImageCache.a.size() * 3 / 4;
            GlobalImageCache.a.trimToSize(j);
          }
          paramInt += 1;
        } while ((paramInt < 2) && (localBitmapDecodeResult.b == 1));
        if (localBitmapDecodeResult.a != null)
        {
          paramInt = i;
          if (paramFaceInfo.p != null) {
            paramInt = paramFaceInfo.p.cHeadType;
          }
          localBitmapDecodeResult.a = AvatarUtil.a((byte)paramFaceInfo.e, localBitmapDecodeResult.a, paramFaceInfo.c, paramInt);
          localIQQAvatarManagerService.putFaceToCache(paramFaceInfo.a(), localBitmapDecodeResult.a, AvatarImplUtil.a(paramFaceInfo.b));
        }
        paramFaceInfo.a(FaceInfo.C);
        localPendingTask.bitmap = localBitmapDecodeResult.a;
        this.sPendingResultList.add(localPendingTask);
        this.handler.obtainMessage(100, localPendingTask).sendToTarget();
      }
    }
  }
  
  private void closeConn(OutputStream paramOutputStream, HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.disconnect();
    }
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream) {}
  }
  
  private int dealDownloadExp(FaceInfo paramFaceInfo, URL paramURL, File paramFile, IOException paramIOException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Download fail 1. url=");
    localStringBuilder.append(paramURL);
    localStringBuilder.append(",faceInfo=");
    localStringBuilder.append(paramFaceInfo);
    QLog.i("Q.qqhead.FaceDownloader", 1, localStringBuilder.toString(), paramIOException);
    if ((paramIOException instanceof UnknownHostException)) {
      return 10;
    }
    if ((!(paramIOException instanceof ConnectTimeoutException)) && (!(paramIOException instanceof SocketTimeoutException)))
    {
      if ((paramIOException instanceof SocketException)) {
        return 11;
      }
      if ((paramIOException instanceof ConnectionClosedException)) {
        return 8;
      }
      if ((paramIOException instanceof ConnectException)) {
        return 17;
      }
      if ((paramIOException instanceof HttpRetryException)) {
        return 18;
      }
      if ((paramIOException instanceof EOFException)) {
        return 19;
      }
      paramFaceInfo = paramIOException.getMessage();
      int i;
      if ((!paramFaceInfo.contains("EACCES")) && (!paramFaceInfo.contains("ENOSPC")) && (!paramFaceInfo.contains("Read-only"))) {
        i = 4;
      } else {
        i = 33;
      }
      boolean bool1 = SystemUtil.a();
      long l;
      if (bool1) {
        l = SystemUtil.b();
      } else {
        l = SystemUtil.c();
      }
      paramIOException = new StringBuilder();
      paramIOException.append("Download fail 1. tmpFilePath=");
      boolean bool2 = paramFile.exists();
      paramURL = "notExit";
      if (bool2) {
        paramFaceInfo = paramFile.getAbsolutePath();
      } else {
        paramFaceInfo = "notExit";
      }
      paramIOException.append(paramFaceInfo);
      paramIOException.append("tmpParentFilePath=");
      paramFaceInfo = paramURL;
      if (paramFile.getParentFile() != null)
      {
        paramFaceInfo = paramURL;
        if (paramFile.getParentFile().exists()) {
          paramFaceInfo = paramFile.getParentFile().getAbsolutePath();
        }
      }
      paramIOException.append(paramFaceInfo);
      paramIOException.append(", result=");
      paramIOException.append(i);
      paramIOException.append(",isExistSDCard=");
      paramIOException.append(bool1);
      paramIOException.append(",availableSize=");
      paramIOException.append(l);
      QLog.i("Q.qqhead.FaceDownloader", 1, paramIOException.toString());
      return i;
    }
    return 2;
  }
  
  private void deleteTmpFile(int paramInt, File paramFile)
  {
    if ((paramInt != 0) && (paramFile != null)) {
      try
      {
        getParentFile(paramFile);
        if (paramFile.exists())
        {
          boolean bool = paramFile.delete();
          paramFile = new StringBuilder();
          paramFile.append("delete file in finally: ");
          paramFile.append(bool);
          QLog.i("Q.qqhead.FaceDownloader", 1, paramFile.toString());
          return;
        }
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
      }
    }
  }
  
  private void downloadFailedWaitAndTryAgain(String paramString1, FaceInfo paramFaceInfo, int paramInt1, Object paramObject, int paramInt2, boolean paramBoolean, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    if (paramInt1 != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Download. result=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", urlString=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", tryCount=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",faceInfo=");
      localStringBuilder.append(paramFaceInfo);
      localStringBuilder.append(",useProxy=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",defaultHost=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",defaultPort=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",forceDirect=");
      localStringBuilder.append(forceDirect);
      localStringBuilder.append(",type=");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(",apnType=");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(",dpcwap=");
      localStringBuilder.append(DPC_WAP_DIRECT_CONNECT);
      QLog.i("Q.qqhead.FaceDownloader", 1, localStringBuilder.toString());
    }
    if ((paramInt1 != 0) && (paramInt2 < 2)) {}
    try
    {
      try
      {
        paramObject.wait(500L);
      }
      finally
      {
        break label242;
      }
    }
    catch (InterruptedException paramString1)
    {
      label238:
      label242:
      break label238;
    }
    return;
    throw paramString1;
  }
  
  private static void enableSNI(HttpsURLConnection paramHttpsURLConnection, URL paramURL, boolean paramBoolean)
  {
    FaceDownloader.2 local2 = new FaceDownloader.2(paramBoolean, paramURL);
    paramHttpsURLConnection.setRequestProperty("host", paramURL.getHost());
    paramHttpsURLConnection.setSSLSocketFactory(new SniSSLSocketFactory(paramURL.getHost(), local2));
    paramHttpsURLConnection.setHostnameVerifier(local2);
  }
  
  public static String get640QQHeandDownLoadUrl(String paramString, byte paramByte)
  {
    String str = BaseInnerDns.getInstance().reqDns("q.qlogo.cn", 1003);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("get640QQHeandDownLoadUrl.choosedIp=");
      localStringBuilder.append(str);
      QLog.i("InnerDns", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder("https://");
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append(str);
    } else {
      localStringBuilder.append("q.qlogo.cn");
    }
    int i = paramString.indexOf("/", 8);
    str = paramString;
    if (i > 8)
    {
      localStringBuilder.append(paramString.substring(i));
      str = localStringBuilder.toString();
    }
    i = 0;
    if ((paramByte & 0x10) != 0) {
      i = 640;
    }
    if (i != 0)
    {
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(i);
      return paramString.toString();
    }
    return "";
  }
  
  private Bitmap getBitmapByShape(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      int i;
      if (paramFaceInfo.p != null) {
        i = paramFaceInfo.p.cHeadType;
      } else {
        i = 0;
      }
      localBitmap = AvatarUtil.a((byte)paramFaceInfo.e, paramBitmap, paramFaceInfo.c, i);
      ((IQQAvatarManagerService)this.mApp.getRuntimeService(IQQAvatarManagerService.class, "nearby")).putFaceToCache(paramFaceInfo.a(), localBitmap, AvatarImplUtil.a(paramFaceInfo.b));
      paramFaceInfo.a(FaceInfo.C);
    }
    return localBitmap;
  }
  
  private String getDomain(String paramString, FaceInfo paramFaceInfo, int paramInt, QQHeadInfo paramQQHeadInfo)
  {
    int i = paramQQHeadInfo.dstUsrType;
    String str = "q.qlogo.cn";
    if (i == 32 ? (paramQQHeadInfo.originUsrType == 1) && (paramQQHeadInfo.originUsrType != 32) : (paramQQHeadInfo.dstUsrType != 16) && ((paramQQHeadInfo.dstUsrType == 4) || (paramQQHeadInfo.dstUsrType == 8))) {
      str = "p.qlogo.cn";
    }
    StringBuilder localStringBuilder = new StringBuilder("https://");
    localStringBuilder.append(str);
    i = paramString.indexOf("/", 8);
    paramQQHeadInfo = paramString;
    if (i > 8)
    {
      localStringBuilder.append(paramString.substring(i));
      paramQQHeadInfo = localStringBuilder.toString();
    }
    paramString = new StringBuilder();
    paramString.append("downloadData retry tryCount =");
    paramString.append(paramInt);
    paramString.append(",urlString=");
    paramString.append(paramQQHeadInfo);
    paramString.append(",faceInfo=");
    paramString.append(paramFaceInfo);
    QLog.d("Q.qqhead.FaceDownloader", 1, paramString.toString());
    return paramQQHeadInfo;
  }
  
  private void getParentFile(File paramFile)
  {
    paramFile = paramFile.getParentFile();
    if ((paramFile != null) && (!paramFile.exists())) {
      paramFile.mkdirs();
    }
  }
  
  private void initDPCFlag()
  {
    ThreadManager.post(new FaceDownloader.3(this), 5, null, true);
  }
  
  private void initFaceDownloadThreadInfo()
  {
    if (TextUtils.isEmpty(BaseApplication.processName)) {
      return;
    }
    if (BaseApplication.processName.equals("com.tencent.mobileqq:tool")) {
      this.mThreadInfo = getNearbyFaceDownloadThreadInfo();
    } else {
      this.mThreadInfo = new FaceDownloader.FaceDownloadThreadInfo(this);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initFaceDownloadThreadInfo, maxThreadCount=");
      localStringBuilder.append(this.mThreadInfo.maxThreadCount);
      localStringBuilder.append(",priority=");
      localStringBuilder.append(this.mThreadInfo.priority);
      QLog.i("Q.qqhead.FaceDownloader", 2, localStringBuilder.toString());
    }
  }
  
  private boolean isVerifyError(FaceInfo paramFaceInfo, int paramInt, DownloadInfo paramDownloadInfo, HttpURLConnection paramHttpURLConnection, String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (!bool2)
    {
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append("Download has X-ErrNo，X-ErrNo=");
      paramDownloadInfo.append(paramString);
      QLog.i("Q.qqhead.FaceDownloader", 1, paramDownloadInfo.toString());
      printHeaderInfo(paramHttpURLConnection, paramFaceInfo);
      return false;
    }
    if (paramDownloadInfo.respVerifyString == null)
    {
      if (paramDownloadInfo.httpRespCode != 200) {
        paramInt = paramDownloadInfo.httpRespCode;
      }
      bool1 = true;
    }
    bool2 = bool1;
    if (!TextUtils.isEmpty(paramFaceInfo.p.headVerify))
    {
      bool2 = bool1;
      if (paramDownloadInfo.respVerifyString != null)
      {
        bool2 = bool1;
        if (!paramDownloadInfo.respVerifyString.equals(paramFaceInfo.p.headVerify)) {
          bool2 = true;
        }
      }
    }
    if (bool2) {
      printHeaderInfo(paramHttpURLConnection, paramFaceInfo);
    }
    return bool2;
  }
  
  private boolean needVerify(int paramInt)
  {
    return paramInt != 116;
  }
  
  private void printHeaderInfo(HttpURLConnection paramHttpURLConnection, FaceInfo paramFaceInfo)
  {
    if ((paramHttpURLConnection != null) && (paramFaceInfo != null)) {
      if (paramFaceInfo.p == null) {
        return;
      }
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("headInfo=");
      localStringBuilder.append(paramHttpURLConnection.getResponseCode());
      localStringBuilder.append(",");
      localStringBuilder.append(paramHttpURLConnection.getContentType());
      localStringBuilder.append(",");
      localStringBuilder.append(paramHttpURLConnection.getContentLength());
      localStringBuilder.append(",");
      localStringBuilder.append(paramHttpURLConnection.getHeaderField("Server"));
      localStringBuilder.append(",");
      localStringBuilder.append(paramHttpURLConnection.getHeaderField("X-ErrNo"));
      localStringBuilder.append(",");
      localStringBuilder.append(paramHttpURLConnection.getHeaderField("X-RtFlag"));
      localStringBuilder.append(",");
      localStringBuilder.append(paramHttpURLConnection.getHeaderField("X-BCheck"));
      localStringBuilder.append(",");
      localStringBuilder.append(paramHttpURLConnection.getHeaderField("X-BCheck"));
      localStringBuilder.append(",");
      localStringBuilder.append(paramFaceInfo);
      QLog.i("Q.qqhead.FaceDownloader", 2, localStringBuilder.toString());
      return;
    }
    catch (Throwable paramHttpURLConnection) {}
  }
  
  /* Error */
  private int realDownloadData(String paramString, File paramFile1, FaceInfo paramFaceInfo, boolean paramBoolean, NetworkInfo paramNetworkInfo, URL paramURL, int paramInt1, Object paramObject, int paramInt2, OutputStream paramOutputStream, DownloadInfo paramDownloadInfo, File paramFile2, int paramInt3, HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 28
    //   3: aload 6
    //   5: astore 29
    //   7: aload 12
    //   9: astore 25
    //   11: ldc_w 353
    //   14: astore 32
    //   16: ldc 15
    //   18: astore 30
    //   20: aload 10
    //   22: astore 26
    //   24: lconst_0
    //   25: lstore 23
    //   27: aload_1
    //   28: astore 31
    //   30: aload 14
    //   32: astore 27
    //   34: aload 28
    //   36: astore 14
    //   38: aload 32
    //   40: astore 10
    //   42: aload 30
    //   44: astore_1
    //   45: iload 13
    //   47: istore 15
    //   49: aload 11
    //   51: astore 32
    //   53: aload_3
    //   54: astore 34
    //   56: aload 31
    //   58: astore 30
    //   60: iload 15
    //   62: iconst_m1
    //   63: if_icmpeq +37 -> 100
    //   66: aload 34
    //   68: getfield 292	com/tencent/mobileqq/app/face/FaceInfo:p	LAvatarInfo/QQHeadInfo;
    //   71: astore 28
    //   73: aload 28
    //   75: ifnonnull +10 -> 85
    //   78: aload 32
    //   80: astore 11
    //   82: goto +2311 -> 2393
    //   85: aload 14
    //   87: aload 31
    //   89: aload 34
    //   91: iload 15
    //   93: aload 28
    //   95: invokespecial 647	com/tencent/mobileqq/app/face/FaceDownloader:getDomain	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILAvatarInfo/QQHeadInfo;)Ljava/lang/String;
    //   98: astore 30
    //   100: iconst_0
    //   101: istore 22
    //   103: iconst_0
    //   104: istore 21
    //   106: iconst_0
    //   107: istore 20
    //   109: invokestatic 652	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   112: astore 35
    //   114: invokestatic 655	android/net/Proxy:getDefaultPort	()I
    //   117: istore 18
    //   119: aload 5
    //   121: ifnull +13 -> 134
    //   124: aload 5
    //   126: invokevirtual 660	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   129: astore 28
    //   131: goto +6 -> 137
    //   134: aconst_null
    //   135: astore 28
    //   137: aload 5
    //   139: ifnull +13 -> 152
    //   142: aload 5
    //   144: invokevirtual 663	android/net/NetworkInfo:getType	()I
    //   147: istore 13
    //   149: goto +6 -> 155
    //   152: iconst_m1
    //   153: istore 13
    //   155: aload 28
    //   157: invokestatic 668	com/tencent/mobileqq/utils/httputils/PkgTools:getApnType	(Ljava/lang/String;)Ljava/lang/String;
    //   160: astore 33
    //   162: aload 14
    //   164: aload 35
    //   166: iload 13
    //   168: aload 33
    //   170: invokespecial 671	com/tencent/mobileqq/app/face/FaceDownloader:setForceDirect	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload 33
    //   175: astore 31
    //   177: iload 13
    //   179: istore 17
    //   181: aload_0
    //   182: aload 35
    //   184: iload 18
    //   186: aload 31
    //   188: iconst_0
    //   189: iload 15
    //   191: aload 30
    //   193: invokevirtual 675	com/tencent/mobileqq/app/face/FaceDownloader:setHttpConnAndUseProxy	(Ljava/lang/String;ILjava/lang/String;ZILjava/lang/String;)[Ljava/lang/Object;
    //   196: astore 28
    //   198: aload 28
    //   200: iconst_0
    //   201: aaload
    //   202: checkcast 677	java/lang/Boolean
    //   205: invokevirtual 680	java/lang/Boolean:booleanValue	()Z
    //   208: istore 21
    //   210: iload 21
    //   212: istore 20
    //   214: aload 28
    //   216: iconst_1
    //   217: aaload
    //   218: checkcast 329	java/net/HttpURLConnection
    //   221: astore 28
    //   223: aload 28
    //   225: invokevirtual 683	java/net/HttpURLConnection:connect	()V
    //   228: aload 32
    //   230: aload 28
    //   232: invokevirtual 621	java/net/HttpURLConnection:getResponseCode	()I
    //   235: putfield 609	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   238: aload 32
    //   240: aload 28
    //   242: invokevirtual 629	java/net/HttpURLConnection:getContentLength	()I
    //   245: putfield 686	com/tencent/mobileqq/emoticon/DownloadInfo:respContentLength	I
    //   248: aload 32
    //   250: aload 28
    //   252: invokevirtual 626	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   255: putfield 689	com/tencent/mobileqq/emoticon/DownloadInfo:respContentType	Ljava/lang/String;
    //   258: aload 32
    //   260: aload 28
    //   262: invokevirtual 692	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   265: putfield 695	com/tencent/mobileqq/emoticon/DownloadInfo:respContentEncoding	Ljava/lang/String;
    //   268: aload 32
    //   270: aload 28
    //   272: ldc_w 641
    //   275: invokevirtual 635	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   278: putfield 606	com/tencent/mobileqq/emoticon/DownloadInfo:respVerifyString	Ljava/lang/String;
    //   281: aload 28
    //   283: ldc_w 637
    //   286: invokevirtual 635	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   289: astore 36
    //   291: aload 14
    //   293: aload 34
    //   295: getfield 311	com/tencent/mobileqq/app/face/FaceInfo:b	I
    //   298: invokespecial 697	com/tencent/mobileqq/app/face/FaceDownloader:needVerify	(I)Z
    //   301: istore 22
    //   303: iload 22
    //   305: ifeq +195 -> 500
    //   308: aload 28
    //   310: astore 27
    //   312: aload_0
    //   313: aload_3
    //   314: iconst_5
    //   315: aload 11
    //   317: aload 28
    //   319: aload 36
    //   321: invokespecial 699	com/tencent/mobileqq/app/face/FaceDownloader:isVerifyError	(Lcom/tencent/mobileqq/app/face/FaceInfo;ILcom/tencent/mobileqq/emoticon/DownloadInfo;Ljava/net/HttpURLConnection;Ljava/lang/String;)Z
    //   324: istore 22
    //   326: iload 22
    //   328: ifeq +172 -> 500
    //   331: aload 14
    //   333: aload 26
    //   335: aload 27
    //   337: invokespecial 701	com/tencent/mobileqq/app/face/FaceDownloader:closeConn	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   340: aload 14
    //   342: iconst_5
    //   343: aload 25
    //   345: invokespecial 703	com/tencent/mobileqq/app/face/FaceDownloader:deleteTmpFile	(ILjava/io/File;)V
    //   348: iload 15
    //   350: iconst_1
    //   351: iadd
    //   352: istore 13
    //   354: aload_0
    //   355: aload 30
    //   357: aload_3
    //   358: iconst_5
    //   359: aload 8
    //   361: iload 13
    //   363: iload 20
    //   365: aload 35
    //   367: iload 18
    //   369: iload 17
    //   371: aload 31
    //   373: invokespecial 705	com/tencent/mobileqq/app/face/FaceDownloader:downloadFailedWaitAndTryAgain	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   376: aload_1
    //   377: astore 31
    //   379: iconst_5
    //   380: istore 7
    //   382: aload_0
    //   383: astore 14
    //   385: aload 6
    //   387: astore 29
    //   389: aload 25
    //   391: astore_1
    //   392: aload 10
    //   394: astore 25
    //   396: aload 27
    //   398: astore 28
    //   400: aload 31
    //   402: astore 10
    //   404: goto +1945 -> 2349
    //   407: astore_1
    //   408: aload_0
    //   409: astore 5
    //   411: aload 25
    //   413: astore 6
    //   415: aload 27
    //   417: astore 10
    //   419: goto +1542 -> 1961
    //   422: astore 31
    //   424: aload_0
    //   425: astore 14
    //   427: aload 10
    //   429: astore 25
    //   431: aload 27
    //   433: astore 10
    //   435: aload_1
    //   436: astore 28
    //   438: iconst_5
    //   439: istore 7
    //   441: aload 6
    //   443: astore 29
    //   445: aload 31
    //   447: astore 27
    //   449: aload 10
    //   451: astore_1
    //   452: aload 26
    //   454: astore 10
    //   456: aload 28
    //   458: astore 26
    //   460: goto +1598 -> 2058
    //   463: astore 29
    //   465: aload_0
    //   466: astore 14
    //   468: aload 10
    //   470: astore 28
    //   472: aload_1
    //   473: astore 31
    //   475: aload 26
    //   477: astore 10
    //   479: iconst_5
    //   480: istore 7
    //   482: aload 6
    //   484: astore 26
    //   486: aload 27
    //   488: astore_1
    //   489: aload 28
    //   491: astore 27
    //   493: aload 31
    //   495: astore 28
    //   497: goto +1753 -> 2250
    //   500: aload 28
    //   502: astore 14
    //   504: aload 26
    //   506: astore 27
    //   508: aload 32
    //   510: getfield 609	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   513: istore 7
    //   515: sipush 200
    //   518: iload 7
    //   520: if_icmpne +1084 -> 1604
    //   523: aload 32
    //   525: getfield 686	com/tencent/mobileqq/emoticon/DownloadInfo:respContentLength	I
    //   528: istore 7
    //   530: iload 7
    //   532: i2l
    //   533: lstore 23
    //   535: aload 12
    //   537: invokevirtual 403	java/io/File:exists	()Z
    //   540: istore 22
    //   542: iload 22
    //   544: ifeq +126 -> 670
    //   547: aload 12
    //   549: invokevirtual 442	java/io/File:delete	()Z
    //   552: pop
    //   553: goto +117 -> 670
    //   556: astore_1
    //   557: aload 25
    //   559: astore 6
    //   561: aload 27
    //   563: astore_2
    //   564: iconst_0
    //   565: istore 7
    //   567: aload_0
    //   568: astore 5
    //   570: aload 14
    //   572: astore 10
    //   574: goto +1859 -> 2433
    //   577: astore 32
    //   579: aload_0
    //   580: astore 25
    //   582: aload 27
    //   584: astore 29
    //   586: aload_1
    //   587: astore 26
    //   589: aload 10
    //   591: astore 28
    //   593: iconst_0
    //   594: istore 7
    //   596: aload 6
    //   598: astore 31
    //   600: aload 32
    //   602: astore 27
    //   604: aload 14
    //   606: astore_1
    //   607: aload 29
    //   609: astore 10
    //   611: aload 25
    //   613: astore 14
    //   615: aload 31
    //   617: astore 29
    //   619: aload 28
    //   621: astore 25
    //   623: goto +1435 -> 2058
    //   626: astore 29
    //   628: aload 27
    //   630: astore 31
    //   632: aload_1
    //   633: astore 28
    //   635: aload 10
    //   637: astore 27
    //   639: iconst_0
    //   640: istore 7
    //   642: aload_0
    //   643: astore 32
    //   645: aload 6
    //   647: astore 26
    //   649: aload 14
    //   651: astore_1
    //   652: aload 31
    //   654: astore 10
    //   656: aload 32
    //   658: astore 14
    //   660: goto +1590 -> 2250
    //   663: aload 27
    //   665: astore 26
    //   667: goto +607 -> 1274
    //   670: aload 12
    //   672: invokevirtual 708	java/io/File:createNewFile	()Z
    //   675: pop
    //   676: new 710	java/io/BufferedOutputStream
    //   679: dup
    //   680: new 712	java/io/FileOutputStream
    //   683: dup
    //   684: aload 25
    //   686: invokespecial 714	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   689: invokespecial 717	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   692: astore 26
    //   694: aload 14
    //   696: invokevirtual 721	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   699: astore 32
    //   701: iload 4
    //   703: ifeq +385 -> 1088
    //   706: lload 23
    //   708: ldc2_w 232
    //   711: lcmp
    //   712: ifge +376 -> 1088
    //   715: ldc_w 722
    //   718: newarray byte
    //   720: astore 36
    //   722: iconst_0
    //   723: istore 16
    //   725: iconst_0
    //   726: istore 7
    //   728: aload 32
    //   730: aload 36
    //   732: iload 16
    //   734: sipush 1024
    //   737: invokevirtual 728	java/io/InputStream:read	([BII)I
    //   740: istore 19
    //   742: iload 19
    //   744: iconst_m1
    //   745: if_icmpeq +20 -> 765
    //   748: iload 16
    //   750: iload 19
    //   752: iadd
    //   753: istore 16
    //   755: iload 7
    //   757: iload 19
    //   759: iadd
    //   760: istore 7
    //   762: goto -34 -> 728
    //   765: aload 34
    //   767: getstatic 211	com/tencent/mobileqq/app/face/FaceInfo:A	I
    //   770: invokevirtual 213	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   773: iload 7
    //   775: i2l
    //   776: lload 23
    //   778: lcmp
    //   779: ifne +1839 -> 2618
    //   782: aload 34
    //   784: getstatic 236	com/tencent/mobileqq/app/face/FaceInfo:B	I
    //   787: invokevirtual 213	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   790: aload 36
    //   792: iconst_0
    //   793: iload 7
    //   795: invokestatic 731	com/tencent/mobileqq/util/BitmapManager:a	([BII)Landroid/graphics/Bitmap;
    //   798: astore 27
    //   800: aload_0
    //   801: astore 32
    //   803: aload 32
    //   805: aload 34
    //   807: aload 27
    //   809: invokespecial 733	com/tencent/mobileqq/app/face/FaceDownloader:getBitmapByShape	(Lcom/tencent/mobileqq/app/face/FaceInfo;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   812: astore 37
    //   814: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   817: ifeq +1774 -> 2591
    //   820: new 341	java/lang/StringBuilder
    //   823: dup
    //   824: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   827: astore 38
    //   829: aload 38
    //   831: ldc_w 735
    //   834: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: pop
    //   838: aload 38
    //   840: aload 37
    //   842: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload 38
    //   848: ldc_w 737
    //   851: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: pop
    //   855: aload 14
    //   857: astore 28
    //   859: aload 26
    //   861: astore 27
    //   863: aload 38
    //   865: aload 6
    //   867: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload 10
    //   873: astore 29
    //   875: aload 26
    //   877: astore 27
    //   879: aload 38
    //   881: aload 29
    //   883: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: pop
    //   887: aload 26
    //   889: astore 27
    //   891: aload 38
    //   893: aload 34
    //   895: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: aload 26
    //   901: astore 27
    //   903: aload 38
    //   905: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: astore 38
    //   910: aload 26
    //   912: astore 27
    //   914: aload 26
    //   916: astore 28
    //   918: aload 26
    //   920: astore 29
    //   922: aload_1
    //   923: iconst_2
    //   924: aload 38
    //   926: invokestatic 432	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   929: goto +3 -> 932
    //   932: aload 26
    //   934: astore 27
    //   936: aload 26
    //   938: astore 28
    //   940: aload 26
    //   942: astore 29
    //   944: new 199	com/tencent/mobileqq/app/face/FaceDownloader$PendingTask
    //   947: dup
    //   948: aload 32
    //   950: invokespecial 202	com/tencent/mobileqq/app/face/FaceDownloader$PendingTask:<init>	(Lcom/tencent/mobileqq/app/face/FaceDownloader;)V
    //   953: astore 38
    //   955: aload 26
    //   957: astore 27
    //   959: aload 26
    //   961: astore 28
    //   963: aload 26
    //   965: astore 29
    //   967: aload 38
    //   969: aload 34
    //   971: putfield 206	com/tencent/mobileqq/app/face/FaceDownloader$PendingTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   974: aload 26
    //   976: astore 27
    //   978: aload 26
    //   980: astore 28
    //   982: aload 26
    //   984: astore 29
    //   986: aload 38
    //   988: aload 37
    //   990: putfield 217	com/tencent/mobileqq/app/face/FaceDownloader$PendingTask:bitmap	Landroid/graphics/Bitmap;
    //   993: aload 26
    //   995: astore 27
    //   997: aload 26
    //   999: astore 28
    //   1001: aload 26
    //   1003: astore 29
    //   1005: aload 32
    //   1007: getfield 84	com/tencent/mobileqq/app/face/FaceDownloader:sPendingResultList	Ljava/util/ArrayList;
    //   1010: aload 38
    //   1012: invokevirtual 220	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1015: pop
    //   1016: aload 26
    //   1018: astore 27
    //   1020: aload 26
    //   1022: astore 28
    //   1024: aload 26
    //   1026: astore 29
    //   1028: aload 32
    //   1030: getfield 180	com/tencent/mobileqq/app/face/FaceDownloader:handler	Lmqq/os/MqqHandler;
    //   1033: bipush 100
    //   1035: aload 38
    //   1037: invokevirtual 226	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   1040: invokevirtual 231	android/os/Message:sendToTarget	()V
    //   1043: goto +3 -> 1046
    //   1046: aload 26
    //   1048: astore 27
    //   1050: aload 26
    //   1052: astore 28
    //   1054: aload 26
    //   1056: astore 29
    //   1058: aload 26
    //   1060: aload 36
    //   1062: iconst_0
    //   1063: iload 7
    //   1065: invokevirtual 741	java/io/OutputStream:write	([BII)V
    //   1068: goto +79 -> 1147
    //   1071: astore_1
    //   1072: goto +143 -> 1215
    //   1075: astore 25
    //   1077: goto +150 -> 1227
    //   1080: astore 27
    //   1082: goto +158 -> 1240
    //   1085: goto +126 -> 1211
    //   1088: sipush 1024
    //   1091: newarray byte
    //   1093: astore 36
    //   1095: aload 32
    //   1097: aload 36
    //   1099: invokevirtual 744	java/io/InputStream:read	([B)I
    //   1102: istore 7
    //   1104: iload 7
    //   1106: iconst_m1
    //   1107: if_icmpeq +28 -> 1135
    //   1110: aload 26
    //   1112: astore 27
    //   1114: aload 26
    //   1116: astore 28
    //   1118: aload 26
    //   1120: astore 29
    //   1122: aload 26
    //   1124: aload 36
    //   1126: iconst_0
    //   1127: iload 7
    //   1129: invokevirtual 741	java/io/OutputStream:write	([BII)V
    //   1132: goto -37 -> 1095
    //   1135: aload 26
    //   1137: astore 27
    //   1139: aload 34
    //   1141: getstatic 211	com/tencent/mobileqq/app/face/FaceInfo:A	I
    //   1144: invokevirtual 213	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   1147: iconst_0
    //   1148: istore 7
    //   1150: aload 26
    //   1152: astore 27
    //   1154: aload 26
    //   1156: invokevirtual 747	java/io/OutputStream:flush	()V
    //   1159: aload 26
    //   1161: astore 27
    //   1163: aload 26
    //   1165: astore 28
    //   1167: aload 26
    //   1169: astore 29
    //   1171: aload_0
    //   1172: aload_2
    //   1173: aload 25
    //   1175: invokespecial 751	com/tencent/mobileqq/app/face/FaceDownloader:renameFile	(Ljava/io/File;Ljava/io/File;)V
    //   1178: goto +233 -> 1411
    //   1181: astore 27
    //   1183: goto +252 -> 1435
    //   1186: astore 29
    //   1188: goto +278 -> 1466
    //   1191: goto +83 -> 1274
    //   1194: astore_1
    //   1195: aload 26
    //   1197: astore_2
    //   1198: goto +220 -> 1418
    //   1201: astore 27
    //   1203: goto +232 -> 1435
    //   1206: astore 29
    //   1208: goto +258 -> 1466
    //   1211: goto +63 -> 1274
    //   1214: astore_1
    //   1215: aload 26
    //   1217: astore_2
    //   1218: aload 14
    //   1220: astore 10
    //   1222: goto +200 -> 1422
    //   1225: astore 25
    //   1227: aload 25
    //   1229: astore 27
    //   1231: aload 26
    //   1233: astore 28
    //   1235: goto +297 -> 1532
    //   1238: astore 27
    //   1240: aload 27
    //   1242: astore 29
    //   1244: aload_1
    //   1245: astore 28
    //   1247: aload 14
    //   1249: astore_1
    //   1250: aload 10
    //   1252: astore 27
    //   1254: goto +222 -> 1476
    //   1257: goto -590 -> 667
    //   1260: astore 25
    //   1262: goto +262 -> 1524
    //   1265: astore 29
    //   1267: goto +298 -> 1565
    //   1270: aload 27
    //   1272: astore 26
    //   1274: aload 26
    //   1276: astore 27
    //   1278: aload 26
    //   1280: astore 28
    //   1282: aload 26
    //   1284: astore 29
    //   1286: new 341	java/lang/StringBuilder
    //   1289: dup
    //   1290: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   1293: astore 32
    //   1295: aload 26
    //   1297: astore 27
    //   1299: aload 26
    //   1301: astore 28
    //   1303: aload 26
    //   1305: astore 29
    //   1307: aload 32
    //   1309: ldc_w 753
    //   1312: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: pop
    //   1316: aload 26
    //   1318: astore 27
    //   1320: aload 26
    //   1322: astore 28
    //   1324: aload 26
    //   1326: astore 29
    //   1328: aload 32
    //   1330: aload 12
    //   1332: invokevirtual 403	java/io/File:exists	()Z
    //   1335: invokevirtual 424	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1338: pop
    //   1339: aload 26
    //   1341: astore 27
    //   1343: aload 26
    //   1345: astore 28
    //   1347: aload 26
    //   1349: astore 29
    //   1351: aload 32
    //   1353: ldc_w 755
    //   1356: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: pop
    //   1360: aload 26
    //   1362: astore 27
    //   1364: aload 26
    //   1366: astore 28
    //   1368: aload 26
    //   1370: astore 29
    //   1372: aload 32
    //   1374: aload 12
    //   1376: invokevirtual 414	java/io/File:getParentFile	()Ljava/io/File;
    //   1379: invokevirtual 403	java/io/File:exists	()Z
    //   1382: invokevirtual 424	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1385: pop
    //   1386: aload 26
    //   1388: astore 27
    //   1390: aload 26
    //   1392: astore 28
    //   1394: aload 26
    //   1396: astore 29
    //   1398: aload_1
    //   1399: iconst_1
    //   1400: aload 32
    //   1402: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1405: invokestatic 432	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1408: iconst_4
    //   1409: istore 7
    //   1411: goto +215 -> 1626
    //   1414: astore_1
    //   1415: aload 27
    //   1417: astore_2
    //   1418: aload 14
    //   1420: astore 10
    //   1422: aload 25
    //   1424: astore 6
    //   1426: goto +87 -> 1513
    //   1429: astore 27
    //   1431: aload 28
    //   1433: astore 26
    //   1435: aload_1
    //   1436: astore 28
    //   1438: aload 10
    //   1440: astore 25
    //   1442: aload 14
    //   1444: astore_1
    //   1445: aload 26
    //   1447: astore 10
    //   1449: aload 28
    //   1451: astore 26
    //   1453: goto +93 -> 1546
    //   1456: astore 27
    //   1458: aload 29
    //   1460: astore 26
    //   1462: aload 27
    //   1464: astore 29
    //   1466: aload_1
    //   1467: astore 28
    //   1469: aload 14
    //   1471: astore_1
    //   1472: aload 10
    //   1474: astore 27
    //   1476: aload 6
    //   1478: astore 31
    //   1480: aload_0
    //   1481: astore 14
    //   1483: iload 21
    //   1485: istore 20
    //   1487: iconst_0
    //   1488: istore 7
    //   1490: aload 26
    //   1492: astore 10
    //   1494: aload 31
    //   1496: astore 26
    //   1498: goto +752 -> 2250
    //   1501: astore_1
    //   1502: aload 25
    //   1504: astore 6
    //   1506: aload 27
    //   1508: astore_2
    //   1509: aload 14
    //   1511: astore 10
    //   1513: aload_0
    //   1514: astore 5
    //   1516: iconst_0
    //   1517: istore 7
    //   1519: goto +914 -> 2433
    //   1522: astore 25
    //   1524: aload 27
    //   1526: astore 28
    //   1528: aload 25
    //   1530: astore 27
    //   1532: aload_1
    //   1533: astore 26
    //   1535: aload 10
    //   1537: astore 25
    //   1539: aload 28
    //   1541: astore 10
    //   1543: aload 14
    //   1545: astore_1
    //   1546: aload 6
    //   1548: astore 29
    //   1550: aload_0
    //   1551: astore 14
    //   1553: iload 21
    //   1555: istore 20
    //   1557: iconst_0
    //   1558: istore 7
    //   1560: goto +498 -> 2058
    //   1563: astore 29
    //   1565: aload_0
    //   1566: astore 28
    //   1568: aload 6
    //   1570: astore 26
    //   1572: aload 27
    //   1574: astore 32
    //   1576: aload_1
    //   1577: astore 31
    //   1579: aload 10
    //   1581: astore 27
    //   1583: iconst_0
    //   1584: istore 7
    //   1586: aload 14
    //   1588: astore_1
    //   1589: aload 32
    //   1591: astore 10
    //   1593: aload 28
    //   1595: astore 14
    //   1597: aload 31
    //   1599: astore 28
    //   1601: goto +649 -> 2250
    //   1604: aload 14
    //   1606: astore 28
    //   1608: aload_1
    //   1609: astore 29
    //   1611: aload 10
    //   1613: astore 29
    //   1615: aload 32
    //   1617: getfield 609	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   1620: istore 7
    //   1622: aload 27
    //   1624: astore 26
    //   1626: aload 6
    //   1628: astore 29
    //   1630: aload_0
    //   1631: astore 27
    //   1633: aload 27
    //   1635: aload 26
    //   1637: aload 14
    //   1639: invokespecial 701	com/tencent/mobileqq/app/face/FaceDownloader:closeConn	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   1642: aload 27
    //   1644: iload 7
    //   1646: aload 25
    //   1648: invokespecial 703	com/tencent/mobileqq/app/face/FaceDownloader:deleteTmpFile	(ILjava/io/File;)V
    //   1651: iload 15
    //   1653: iconst_1
    //   1654: iadd
    //   1655: istore 13
    //   1657: aload_0
    //   1658: aload 30
    //   1660: aload_3
    //   1661: iload 7
    //   1663: aload 8
    //   1665: iload 13
    //   1667: iload 20
    //   1669: aload 35
    //   1671: iload 18
    //   1673: iload 17
    //   1675: aload 31
    //   1677: invokespecial 705	com/tencent/mobileqq/app/face/FaceDownloader:downloadFailedWaitAndTryAgain	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   1680: aload 12
    //   1682: astore 25
    //   1684: aload 14
    //   1686: astore 28
    //   1688: aload_1
    //   1689: astore 31
    //   1691: aload 27
    //   1693: astore 14
    //   1695: aload 25
    //   1697: astore_1
    //   1698: aload 10
    //   1700: astore 25
    //   1702: aload 31
    //   1704: astore 10
    //   1706: goto +643 -> 2349
    //   1709: astore_1
    //   1710: aload 28
    //   1712: astore 10
    //   1714: goto +18 -> 1732
    //   1717: astore 25
    //   1719: goto +31 -> 1750
    //   1722: astore 29
    //   1724: goto +57 -> 1781
    //   1727: astore_1
    //   1728: aload 14
    //   1730: astore 10
    //   1732: aload 12
    //   1734: astore 6
    //   1736: aload_0
    //   1737: astore 5
    //   1739: aload 27
    //   1741: astore_2
    //   1742: iconst_0
    //   1743: istore 7
    //   1745: goto +688 -> 2433
    //   1748: astore 25
    //   1750: aload 14
    //   1752: astore 26
    //   1754: aload 6
    //   1756: astore 29
    //   1758: aload_0
    //   1759: astore 14
    //   1761: aload 27
    //   1763: astore 28
    //   1765: iconst_0
    //   1766: istore 7
    //   1768: aload 25
    //   1770: astore 27
    //   1772: aload 28
    //   1774: astore 25
    //   1776: goto +134 -> 1910
    //   1779: astore 29
    //   1781: aload 6
    //   1783: astore 27
    //   1785: aload_0
    //   1786: astore 28
    //   1788: iconst_0
    //   1789: istore 7
    //   1791: aload 14
    //   1793: astore 25
    //   1795: aload 28
    //   1797: astore 14
    //   1799: goto +45 -> 1844
    //   1802: astore 27
    //   1804: goto +95 -> 1899
    //   1807: astore_1
    //   1808: aload 12
    //   1810: astore 6
    //   1812: aload 28
    //   1814: astore 10
    //   1816: aload 14
    //   1818: astore 5
    //   1820: goto +141 -> 1961
    //   1823: astore 27
    //   1825: aload 28
    //   1827: astore 25
    //   1829: aload 27
    //   1831: astore 28
    //   1833: iconst_5
    //   1834: istore 7
    //   1836: aload 29
    //   1838: astore 27
    //   1840: aload 28
    //   1842: astore 29
    //   1844: aload_1
    //   1845: astore 28
    //   1847: aload 10
    //   1849: astore 31
    //   1851: aload 12
    //   1853: astore 32
    //   1855: aload 26
    //   1857: astore 10
    //   1859: aload 25
    //   1861: astore_1
    //   1862: aload 32
    //   1864: astore 25
    //   1866: aload 27
    //   1868: astore 26
    //   1870: aload 31
    //   1872: astore 27
    //   1874: goto +376 -> 2250
    //   1877: astore 25
    //   1879: aload 14
    //   1881: iload 20
    //   1883: aload 35
    //   1885: iload 18
    //   1887: invokespecial 759	com/tencent/mobileqq/app/face/FaceDownloader:setForceDirectByUseProxy	(ZLjava/lang/String;I)V
    //   1890: aload 25
    //   1892: athrow
    //   1893: astore_1
    //   1894: goto -86 -> 1808
    //   1897: astore 27
    //   1899: aload 26
    //   1901: astore 25
    //   1903: iconst_5
    //   1904: istore 7
    //   1906: aload 28
    //   1908: astore 26
    //   1910: aload_1
    //   1911: astore 28
    //   1913: aload 10
    //   1915: astore 31
    //   1917: aload 26
    //   1919: astore_1
    //   1920: aload 25
    //   1922: astore 10
    //   1924: aload 31
    //   1926: astore 25
    //   1928: aload 28
    //   1930: astore 26
    //   1932: goto +126 -> 2058
    //   1935: astore 27
    //   1937: aload 28
    //   1939: astore 25
    //   1941: aload 27
    //   1943: astore 28
    //   1945: goto -112 -> 1833
    //   1948: astore_1
    //   1949: aload 12
    //   1951: astore 6
    //   1953: aload 27
    //   1955: astore 10
    //   1957: aload 14
    //   1959: astore 5
    //   1961: aload 26
    //   1963: astore_2
    //   1964: iconst_5
    //   1965: istore 7
    //   1967: goto +466 -> 2433
    //   1970: astore 28
    //   1972: goto +61 -> 2033
    //   1975: astore 31
    //   1977: goto +18 -> 1995
    //   1980: astore_1
    //   1981: goto +22 -> 2003
    //   1984: astore 28
    //   1986: iload 22
    //   1988: istore 20
    //   1990: goto +43 -> 2033
    //   1993: astore 31
    //   1995: aload 26
    //   1997: astore 32
    //   1999: goto +222 -> 2221
    //   2002: astore_1
    //   2003: aload 12
    //   2005: astore 6
    //   2007: aload 27
    //   2009: astore 10
    //   2011: aload 26
    //   2013: astore_2
    //   2014: iconst_5
    //   2015: istore 7
    //   2017: iconst_0
    //   2018: istore 20
    //   2020: aload 14
    //   2022: astore 5
    //   2024: goto +409 -> 2433
    //   2027: astore 28
    //   2029: iload 22
    //   2031: istore 20
    //   2033: aload_1
    //   2034: astore 31
    //   2036: aload 10
    //   2038: astore 25
    //   2040: aload 27
    //   2042: astore_1
    //   2043: aload 26
    //   2045: astore 10
    //   2047: iconst_5
    //   2048: istore 7
    //   2050: aload 31
    //   2052: astore 26
    //   2054: aload 28
    //   2056: astore 27
    //   2058: new 341	java/lang/StringBuilder
    //   2061: dup
    //   2062: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   2065: astore 28
    //   2067: aload 28
    //   2069: ldc_w 761
    //   2072: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2075: pop
    //   2076: aload 28
    //   2078: aload 29
    //   2080: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2083: pop
    //   2084: aload 28
    //   2086: aload 25
    //   2088: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2091: pop
    //   2092: aload 28
    //   2094: aload 34
    //   2096: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2099: pop
    //   2100: aload 26
    //   2102: iconst_1
    //   2103: aload 28
    //   2105: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2108: aload 27
    //   2110: invokestatic 359	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2113: aload 14
    //   2115: aload 10
    //   2117: aload_1
    //   2118: invokespecial 701	com/tencent/mobileqq/app/face/FaceDownloader:closeConn	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   2121: aload 14
    //   2123: iconst_5
    //   2124: aload 12
    //   2126: invokespecial 703	com/tencent/mobileqq/app/face/FaceDownloader:deleteTmpFile	(ILjava/io/File;)V
    //   2129: iload 15
    //   2131: iconst_1
    //   2132: iadd
    //   2133: istore 7
    //   2135: aload 26
    //   2137: astore 27
    //   2139: aload_1
    //   2140: astore 28
    //   2142: aload_0
    //   2143: aload 30
    //   2145: aload_3
    //   2146: iconst_5
    //   2147: aload 8
    //   2149: iload 7
    //   2151: iload 20
    //   2153: aload 35
    //   2155: iload 18
    //   2157: iload 13
    //   2159: aload 33
    //   2161: invokespecial 705	com/tencent/mobileqq/app/face/FaceDownloader:downloadFailedWaitAndTryAgain	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   2164: aload 12
    //   2166: astore_1
    //   2167: iload 7
    //   2169: istore 13
    //   2171: iconst_5
    //   2172: istore 7
    //   2174: aload 10
    //   2176: astore 26
    //   2178: aload 27
    //   2180: astore 10
    //   2182: goto +167 -> 2349
    //   2185: astore 5
    //   2187: aload 12
    //   2189: astore 6
    //   2191: aload_1
    //   2192: astore 11
    //   2194: aload 10
    //   2196: astore_2
    //   2197: aload 5
    //   2199: astore_1
    //   2200: aload 14
    //   2202: astore 5
    //   2204: aload 11
    //   2206: astore 10
    //   2208: goto +225 -> 2433
    //   2211: astore 31
    //   2213: iload 21
    //   2215: istore 20
    //   2217: aload 26
    //   2219: astore 32
    //   2221: aload_1
    //   2222: astore 28
    //   2224: aload 12
    //   2226: astore 25
    //   2228: aload 27
    //   2230: astore_1
    //   2231: iconst_5
    //   2232: istore 7
    //   2234: aload 10
    //   2236: astore 27
    //   2238: aload 29
    //   2240: astore 26
    //   2242: aload 32
    //   2244: astore 10
    //   2246: aload 31
    //   2248: astore 29
    //   2250: aload 14
    //   2252: aload 34
    //   2254: aload 26
    //   2256: aload 25
    //   2258: aload 29
    //   2260: invokespecial 763	com/tencent/mobileqq/app/face/FaceDownloader:dealDownloadExp	(Lcom/tencent/mobileqq/app/face/FaceInfo;Ljava/net/URL;Ljava/io/File;Ljava/io/IOException;)I
    //   2263: istore 16
    //   2265: aload 14
    //   2267: aload 10
    //   2269: aload_1
    //   2270: invokespecial 701	com/tencent/mobileqq/app/face/FaceDownloader:closeConn	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   2273: aload 14
    //   2275: iload 16
    //   2277: aload 25
    //   2279: invokespecial 703	com/tencent/mobileqq/app/face/FaceDownloader:deleteTmpFile	(ILjava/io/File;)V
    //   2282: iload 15
    //   2284: iconst_1
    //   2285: iadd
    //   2286: istore 15
    //   2288: aload 25
    //   2290: astore 31
    //   2292: aload_0
    //   2293: aload 30
    //   2295: aload_3
    //   2296: iload 16
    //   2298: aload 8
    //   2300: iload 15
    //   2302: iload 20
    //   2304: aload 35
    //   2306: iload 18
    //   2308: iload 13
    //   2310: aload 33
    //   2312: invokespecial 705	com/tencent/mobileqq/app/face/FaceDownloader:downloadFailedWaitAndTryAgain	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   2315: iload 16
    //   2317: istore 7
    //   2319: iload 15
    //   2321: istore 13
    //   2323: aload 10
    //   2325: astore 32
    //   2327: aload 28
    //   2329: astore 10
    //   2331: aload_1
    //   2332: astore 28
    //   2334: aload 27
    //   2336: astore 25
    //   2338: aload 26
    //   2340: astore 29
    //   2342: aload 31
    //   2344: astore_1
    //   2345: aload 32
    //   2347: astore 26
    //   2349: iload 7
    //   2351: ifeq +42 -> 2393
    //   2354: iload 13
    //   2356: iload 9
    //   2358: if_icmplt +6 -> 2364
    //   2361: goto +32 -> 2393
    //   2364: aload_1
    //   2365: astore 27
    //   2367: aload 10
    //   2369: astore_1
    //   2370: aload 30
    //   2372: astore 31
    //   2374: iload 13
    //   2376: istore 15
    //   2378: aload 25
    //   2380: astore 10
    //   2382: aload 27
    //   2384: astore 25
    //   2386: aload 28
    //   2388: astore 27
    //   2390: goto -2341 -> 49
    //   2393: aload 11
    //   2395: iload 7
    //   2397: putfield 766	com/tencent/mobileqq/emoticon/DownloadInfo:resultCode	I
    //   2400: aload_0
    //   2401: aload_3
    //   2402: iload 4
    //   2404: lload 23
    //   2406: iload 7
    //   2408: invokespecial 768	com/tencent/mobileqq/app/face/FaceDownloader:cacheFile	(Lcom/tencent/mobileqq/app/face/FaceInfo;ZJI)V
    //   2411: iload 7
    //   2413: ireturn
    //   2414: astore 11
    //   2416: aload 25
    //   2418: astore 6
    //   2420: aload 10
    //   2422: astore_2
    //   2423: aload_1
    //   2424: astore 10
    //   2426: aload 14
    //   2428: astore 5
    //   2430: aload 11
    //   2432: astore_1
    //   2433: aload 5
    //   2435: aload_2
    //   2436: aload 10
    //   2438: invokespecial 701	com/tencent/mobileqq/app/face/FaceDownloader:closeConn	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   2441: aload 5
    //   2443: iload 7
    //   2445: aload 6
    //   2447: invokespecial 703	com/tencent/mobileqq/app/face/FaceDownloader:deleteTmpFile	(ILjava/io/File;)V
    //   2450: aload_0
    //   2451: aload 30
    //   2453: aload_3
    //   2454: iload 7
    //   2456: aload 8
    //   2458: iload 15
    //   2460: iconst_1
    //   2461: iadd
    //   2462: iload 20
    //   2464: aload 35
    //   2466: iload 18
    //   2468: iload 13
    //   2470: aload 33
    //   2472: invokespecial 705	com/tencent/mobileqq/app/face/FaceDownloader:downloadFailedWaitAndTryAgain	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   2475: goto +5 -> 2480
    //   2478: aload_1
    //   2479: athrow
    //   2480: goto -2 -> 2478
    //   2483: astore 26
    //   2485: goto -1215 -> 1270
    //   2488: astore 26
    //   2490: goto -1827 -> 663
    //   2493: astore 27
    //   2495: goto -1238 -> 1257
    //   2498: astore 27
    //   2500: goto -1415 -> 1085
    //   2503: astore 27
    //   2505: goto +110 -> 2615
    //   2508: astore 27
    //   2510: goto +78 -> 2588
    //   2513: astore 27
    //   2515: goto +60 -> 2575
    //   2518: astore 27
    //   2520: goto -1309 -> 1211
    //   2523: astore 27
    //   2525: goto -1334 -> 1191
    //   2528: astore 27
    //   2530: goto -1256 -> 1274
    //   2533: astore 27
    //   2535: aload 26
    //   2537: astore 10
    //   2539: aload 29
    //   2541: astore 25
    //   2543: aload_1
    //   2544: astore 26
    //   2546: aload 28
    //   2548: astore_1
    //   2549: goto -1003 -> 1546
    //   2552: astore 14
    //   2554: aload 29
    //   2556: astore 27
    //   2558: aload 28
    //   2560: astore 10
    //   2562: aload_1
    //   2563: astore 28
    //   2565: aload 14
    //   2567: astore 29
    //   2569: aload 10
    //   2571: astore_1
    //   2572: goto -1096 -> 1476
    //   2575: goto -1364 -> 1211
    //   2578: astore 27
    //   2580: goto -1349 -> 1231
    //   2583: astore 29
    //   2585: goto -1341 -> 1244
    //   2588: goto -1377 -> 1211
    //   2591: goto -1659 -> 932
    //   2594: astore_1
    //   2595: aload 26
    //   2597: astore_2
    //   2598: aload 14
    //   2600: astore 10
    //   2602: goto -1180 -> 1422
    //   2605: astore 25
    //   2607: goto -1380 -> 1227
    //   2610: astore 27
    //   2612: goto -1372 -> 1240
    //   2615: goto -1530 -> 1085
    //   2618: goto -1572 -> 1046
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2621	0	this	FaceDownloader
    //   0	2621	1	paramString	String
    //   0	2621	2	paramFile1	File
    //   0	2621	3	paramFaceInfo	FaceInfo
    //   0	2621	4	paramBoolean	boolean
    //   0	2621	5	paramNetworkInfo	NetworkInfo
    //   0	2621	6	paramURL	URL
    //   0	2621	7	paramInt1	int
    //   0	2621	8	paramObject	Object
    //   0	2621	9	paramInt2	int
    //   0	2621	10	paramOutputStream	OutputStream
    //   0	2621	11	paramDownloadInfo	DownloadInfo
    //   0	2621	12	paramFile2	File
    //   0	2621	13	paramInt3	int
    //   0	2621	14	paramHttpURLConnection	HttpURLConnection
    //   47	2415	15	i	int
    //   723	1593	16	j	int
    //   179	1495	17	k	int
    //   117	2350	18	m	int
    //   740	20	19	n	int
    //   107	2356	20	bool1	boolean
    //   104	2110	21	bool2	boolean
    //   101	1929	22	bool3	boolean
    //   25	2380	23	l	long
    //   9	676	25	localObject1	Object
    //   1075	99	25	localThrowable1	Throwable
    //   1225	3	25	localThrowable2	Throwable
    //   1260	163	25	localThrowable3	Throwable
    //   1440	63	25	localOutputStream	OutputStream
    //   1522	7	25	localThrowable4	Throwable
    //   1537	164	25	localObject2	Object
    //   1717	1	25	localThrowable5	Throwable
    //   1748	21	25	localThrowable6	Throwable
    //   1774	91	25	localObject3	Object
    //   1877	14	25	localThrowable7	Throwable
    //   1901	641	25	localObject4	Object
    //   2605	1	25	localThrowable8	Throwable
    //   22	2326	26	localObject5	Object
    //   2483	1	26	localFileNotFoundException1	java.io.FileNotFoundException
    //   2488	48	26	localFileNotFoundException2	java.io.FileNotFoundException
    //   2544	52	26	str1	String
    //   32	1017	27	localObject6	Object
    //   1080	1	27	localIOException1	IOException
    //   1112	50	27	localObject7	Object
    //   1181	1	27	localThrowable9	Throwable
    //   1201	1	27	localThrowable10	Throwable
    //   1229	1	27	localThrowable11	Throwable
    //   1238	3	27	localIOException2	IOException
    //   1252	164	27	localObject8	Object
    //   1429	1	27	localThrowable12	Throwable
    //   1456	7	27	localIOException3	IOException
    //   1474	310	27	localObject9	Object
    //   1802	1	27	localThrowable13	Throwable
    //   1823	7	27	localIOException4	IOException
    //   1838	35	27	localObject10	Object
    //   1897	1	27	localThrowable14	Throwable
    //   1935	106	27	localIOException5	IOException
    //   2056	333	27	localObject11	Object
    //   2493	1	27	localFileNotFoundException3	java.io.FileNotFoundException
    //   2498	1	27	localFileNotFoundException4	java.io.FileNotFoundException
    //   2503	1	27	localFileNotFoundException5	java.io.FileNotFoundException
    //   2508	1	27	localFileNotFoundException6	java.io.FileNotFoundException
    //   2513	1	27	localFileNotFoundException7	java.io.FileNotFoundException
    //   2518	1	27	localFileNotFoundException8	java.io.FileNotFoundException
    //   2523	1	27	localFileNotFoundException9	java.io.FileNotFoundException
    //   2528	1	27	localFileNotFoundException10	java.io.FileNotFoundException
    //   2533	1	27	localThrowable15	Throwable
    //   2556	1	27	localObject12	Object
    //   2578	1	27	localThrowable16	Throwable
    //   2610	1	27	localIOException6	IOException
    //   1	1943	28	localObject13	Object
    //   1970	1	28	localThrowable17	Throwable
    //   1984	1	28	localThrowable18	Throwable
    //   2027	28	28	localThrowable19	Throwable
    //   2065	499	28	localObject14	Object
    //   5	439	29	localURL1	URL
    //   463	1	29	localIOException7	IOException
    //   584	34	29	localObject15	Object
    //   626	1	29	localIOException8	IOException
    //   873	297	29	localObject16	Object
    //   1186	1	29	localIOException9	IOException
    //   1206	1	29	localIOException10	IOException
    //   1242	1	29	localObject17	Object
    //   1265	1	29	localIOException11	IOException
    //   1284	265	29	localObject18	Object
    //   1563	1	29	localIOException12	IOException
    //   1609	20	29	localObject19	Object
    //   1722	1	29	localIOException13	IOException
    //   1756	1	29	localURL2	URL
    //   1779	58	29	localIOException14	IOException
    //   1842	726	29	localObject20	Object
    //   2583	1	29	localIOException15	IOException
    //   18	2434	30	localObject21	Object
    //   28	373	31	localObject22	Object
    //   422	24	31	localThrowable20	Throwable
    //   473	1452	31	localObject23	Object
    //   1975	1	31	localIOException16	IOException
    //   1993	1	31	localIOException17	IOException
    //   2034	17	31	str2	String
    //   2211	36	31	localIOException18	IOException
    //   2290	83	31	localObject24	Object
    //   14	510	32	localObject25	Object
    //   577	24	32	localThrowable21	Throwable
    //   643	1703	32	localObject26	Object
    //   160	2311	33	str3	String
    //   54	2199	34	localFaceInfo	FaceInfo
    //   112	2353	35	str4	String
    //   289	836	36	localObject27	Object
    //   812	177	37	localBitmap	Bitmap
    //   827	209	38	localObject28	Object
    // Exception table:
    //   from	to	target	type
    //   312	326	407	finally
    //   312	326	422	java/lang/Throwable
    //   312	326	463	java/io/IOException
    //   547	553	556	finally
    //   547	553	577	java/lang/Throwable
    //   547	553	626	java/io/IOException
    //   715	722	1071	finally
    //   728	742	1071	finally
    //   765	773	1071	finally
    //   782	800	1071	finally
    //   715	722	1075	java/lang/Throwable
    //   728	742	1075	java/lang/Throwable
    //   765	773	1075	java/lang/Throwable
    //   782	800	1075	java/lang/Throwable
    //   715	722	1080	java/io/IOException
    //   728	742	1080	java/io/IOException
    //   765	773	1080	java/io/IOException
    //   782	800	1080	java/io/IOException
    //   1139	1147	1181	java/lang/Throwable
    //   1154	1159	1181	java/lang/Throwable
    //   1139	1147	1186	java/io/IOException
    //   1154	1159	1186	java/io/IOException
    //   1088	1095	1194	finally
    //   1095	1104	1194	finally
    //   1088	1095	1201	java/lang/Throwable
    //   1095	1104	1201	java/lang/Throwable
    //   1088	1095	1206	java/io/IOException
    //   1095	1104	1206	java/io/IOException
    //   694	701	1214	finally
    //   694	701	1225	java/lang/Throwable
    //   694	701	1238	java/io/IOException
    //   535	542	1260	java/lang/Throwable
    //   670	694	1260	java/lang/Throwable
    //   535	542	1265	java/io/IOException
    //   670	694	1265	java/io/IOException
    //   863	871	1414	finally
    //   879	887	1414	finally
    //   891	899	1414	finally
    //   903	910	1414	finally
    //   922	929	1414	finally
    //   944	955	1414	finally
    //   967	974	1414	finally
    //   986	993	1414	finally
    //   1005	1016	1414	finally
    //   1028	1043	1414	finally
    //   1058	1068	1414	finally
    //   1122	1132	1414	finally
    //   1139	1147	1414	finally
    //   1154	1159	1414	finally
    //   1171	1178	1414	finally
    //   1286	1295	1414	finally
    //   1307	1316	1414	finally
    //   1328	1339	1414	finally
    //   1351	1360	1414	finally
    //   1372	1386	1414	finally
    //   1398	1408	1414	finally
    //   922	929	1429	java/lang/Throwable
    //   944	955	1429	java/lang/Throwable
    //   967	974	1429	java/lang/Throwable
    //   986	993	1429	java/lang/Throwable
    //   1005	1016	1429	java/lang/Throwable
    //   1028	1043	1429	java/lang/Throwable
    //   1058	1068	1429	java/lang/Throwable
    //   1122	1132	1429	java/lang/Throwable
    //   1171	1178	1429	java/lang/Throwable
    //   1286	1295	1429	java/lang/Throwable
    //   1307	1316	1429	java/lang/Throwable
    //   1328	1339	1429	java/lang/Throwable
    //   1351	1360	1429	java/lang/Throwable
    //   1372	1386	1429	java/lang/Throwable
    //   1398	1408	1429	java/lang/Throwable
    //   922	929	1456	java/io/IOException
    //   944	955	1456	java/io/IOException
    //   967	974	1456	java/io/IOException
    //   986	993	1456	java/io/IOException
    //   1005	1016	1456	java/io/IOException
    //   1028	1043	1456	java/io/IOException
    //   1058	1068	1456	java/io/IOException
    //   1122	1132	1456	java/io/IOException
    //   1171	1178	1456	java/io/IOException
    //   1286	1295	1456	java/io/IOException
    //   1307	1316	1456	java/io/IOException
    //   1328	1339	1456	java/io/IOException
    //   1351	1360	1456	java/io/IOException
    //   1372	1386	1456	java/io/IOException
    //   1398	1408	1456	java/io/IOException
    //   523	530	1501	finally
    //   535	542	1501	finally
    //   670	694	1501	finally
    //   523	530	1522	java/lang/Throwable
    //   523	530	1563	java/io/IOException
    //   1615	1622	1709	finally
    //   1615	1622	1717	java/lang/Throwable
    //   1615	1622	1722	java/io/IOException
    //   508	515	1727	finally
    //   508	515	1748	java/lang/Throwable
    //   508	515	1779	java/io/IOException
    //   291	303	1802	java/lang/Throwable
    //   223	291	1807	finally
    //   291	303	1807	finally
    //   223	291	1823	java/io/IOException
    //   291	303	1823	java/io/IOException
    //   223	291	1877	java/lang/Throwable
    //   1879	1893	1893	finally
    //   1879	1893	1897	java/lang/Throwable
    //   1879	1893	1935	java/io/IOException
    //   214	223	1948	finally
    //   214	223	1970	java/lang/Throwable
    //   214	223	1975	java/io/IOException
    //   181	210	1980	finally
    //   181	210	1984	java/lang/Throwable
    //   181	210	1993	java/io/IOException
    //   162	173	2002	finally
    //   162	173	2027	java/lang/Throwable
    //   2058	2113	2185	finally
    //   162	173	2211	java/io/IOException
    //   2250	2265	2414	finally
    //   535	542	2483	java/io/FileNotFoundException
    //   670	694	2483	java/io/FileNotFoundException
    //   547	553	2488	java/io/FileNotFoundException
    //   694	701	2493	java/io/FileNotFoundException
    //   715	722	2498	java/io/FileNotFoundException
    //   728	742	2498	java/io/FileNotFoundException
    //   765	773	2498	java/io/FileNotFoundException
    //   782	800	2498	java/io/FileNotFoundException
    //   803	855	2503	java/io/FileNotFoundException
    //   863	871	2508	java/io/FileNotFoundException
    //   879	887	2513	java/io/FileNotFoundException
    //   891	899	2513	java/io/FileNotFoundException
    //   903	910	2513	java/io/FileNotFoundException
    //   922	929	2518	java/io/FileNotFoundException
    //   944	955	2518	java/io/FileNotFoundException
    //   967	974	2518	java/io/FileNotFoundException
    //   986	993	2518	java/io/FileNotFoundException
    //   1005	1016	2518	java/io/FileNotFoundException
    //   1028	1043	2518	java/io/FileNotFoundException
    //   1058	1068	2518	java/io/FileNotFoundException
    //   1088	1095	2518	java/io/FileNotFoundException
    //   1095	1104	2518	java/io/FileNotFoundException
    //   1122	1132	2523	java/io/FileNotFoundException
    //   1139	1147	2523	java/io/FileNotFoundException
    //   1154	1159	2523	java/io/FileNotFoundException
    //   1171	1178	2528	java/io/FileNotFoundException
    //   879	887	2533	java/lang/Throwable
    //   891	899	2533	java/lang/Throwable
    //   903	910	2533	java/lang/Throwable
    //   879	887	2552	java/io/IOException
    //   891	899	2552	java/io/IOException
    //   903	910	2552	java/io/IOException
    //   863	871	2578	java/lang/Throwable
    //   863	871	2583	java/io/IOException
    //   803	855	2594	finally
    //   803	855	2605	java/lang/Throwable
    //   803	855	2610	java/io/IOException
  }
  
  private void renameFile(File paramFile1, File paramFile2)
  {
    if (paramFile1.exists()) {
      paramFile1.delete();
    }
    paramFile2.renameTo(paramFile1);
    paramFile1.setLastModified(System.currentTimeMillis());
  }
  
  private void setForceDirect(String paramString1, int paramInt, String paramString2)
  {
    if (!paramString2.equals(lastApn))
    {
      if ((paramInt != 1) && (!paramString2.equals(PkgTools.APN_TYPE_CMWAP))) {
        forceDirect = true;
      } else {
        forceDirect = false;
      }
      lastApn = paramString2;
    }
    if ((paramInt == 1) && (("10.0.0.172".equals(paramString1)) || ("10.0.0.200".equals(paramString1)))) {
      forceDirect = true;
    }
  }
  
  private void setForceDirectByUseProxy(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      forceDirect = true;
      return;
    }
    if ((paramString != null) && (paramInt > 0)) {
      forceDirect = false;
    }
  }
  
  public void addDownloadRequest(FaceInfo paramFaceInfo)
  {
    smartSetThreadCount(this.maxThreadCount);
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("addDownloadRequest, info=");
      ((StringBuilder)???).append(paramFaceInfo);
      QLog.d("Q.qqhead.FaceDownloader", 2, ((StringBuilder)???).toString());
    }
    HashSet localHashSet = this.mDownloadingUrlSet;
    if (paramFaceInfo != null) {}
    for (;;)
    {
      try
      {
        ??? = paramFaceInfo.c();
        if ((!TextUtils.isEmpty((CharSequence)???)) && (!this.mDownloadingUrlSet.contains(???)))
        {
          this.mDownloadingUrlSet.add(???);
          synchronized (this.mRequestQueue)
          {
            this.mRequestQueue.add(paramFaceInfo);
            this.mRequestQueue.notify();
            return;
          }
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("addDownloadRequest url repeat, info=");
          localStringBuilder.append(paramFaceInfo);
          localStringBuilder.append(",urlUniq=");
          localStringBuilder.append((String)???);
          QLog.d("Q.qqhead.FaceDownloader", 2, localStringBuilder.toString());
        }
        return;
      }
      finally {}
      ??? = "";
    }
  }
  
  public void addFaceDownloadListener(FaceDownloader.FaceDownloadListener paramFaceDownloadListener)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addFaceDownloadListener l=");
        localStringBuilder.append(paramFaceDownloadListener);
        QLog.i("Q.qqhead.FaceDownloader", 2, localStringBuilder.toString());
      }
      this.mDownloadListener.add(paramFaceDownloadListener);
      return;
    }
    finally {}
  }
  
  public void close()
  {
    Object localObject1 = this.mDownloadingUrlSet;
    if (localObject1 != null) {
      ((HashSet)localObject1).clear();
    }
    int i = 0;
    for (;;)
    {
      localObject1 = this.mDownRunnables;
      if (i >= localObject1.length) {
        break;
      }
      if (localObject1[i] != null) {
        localObject1[i].close();
      }
      i += 1;
    }
    localObject1 = this.mRequestQueue;
    if (localObject1 != null) {
      try
      {
        this.mRequestQueue.clear();
        this.mRequestQueue.notifyAll();
        return;
      }
      finally {}
    }
  }
  
  protected abstract void doDownloadFace(FaceInfo paramFaceInfo);
  
  public int downloadData(String paramString, File paramFile, FaceInfo paramFaceInfo, boolean paramBoolean)
  {
    Object localObject1 = paramString;
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null)
    {
      QLog.i("Q.qqhead.FaceDownloader", 1, "downloadData failed-----------activeNetworkInfo is null");
      return 1;
    }
    for (;;)
    {
      try
      {
        localURL = new URL((String)localObject1);
        System.currentTimeMillis();
        localObject2 = new Object();
      }
      catch (MalformedURLException paramString)
      {
        URL localURL;
        Object localObject2;
        DownloadInfo localDownloadInfo;
        paramString.printStackTrace();
        return 13;
      }
      try
      {
        getParentFile(paramFile);
        localDownloadInfo = new DownloadInfo((String)localObject1, null, 0);
      }
      catch (Exception paramString)
      {
        continue;
      }
      try
      {
        new HttpGet((String)localObject1);
        paramString = (String)localObject1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        continue;
      }
      try
      {
        paramString = HttpDownloadUtil.getEscapeSequence(paramString);
      }
      catch (IllegalArgumentException paramString) {}
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramFile.getPath());
    ((StringBuilder)localObject1).append(".tmp");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
    return realDownloadData(paramString, paramFile, paramFaceInfo, paramBoolean, localNetworkInfo, localURL, 5, localObject2, 2, null, localDownloadInfo, (File)localObject1, -1, null);
    QLog.d("Q.qqhead.FaceDownloader", 1, "downloadData. result=DOWNLOAD_URL_STRING_ILLEGAL as new HttpGet exception.");
    localDownloadInfo.resultCode = 13;
    return 13;
    QLog.d("Q.qqhead.FaceDownloader", 1, "downloadData. result=DOWNLOAD_SAVE_FILE_FAIL as file exception.");
    return 4;
  }
  
  public abstract String getChoosedIP();
  
  public abstract String getChoosedStrangerGroupIp();
  
  public FaceDownloader.FaceDownloadThreadInfo getNearbyFaceDownloadThreadInfo()
  {
    FaceDownloader.FaceDownloadThreadInfo localFaceDownloadThreadInfo = new FaceDownloader.FaceDownloadThreadInfo(this);
    int i = Runtime.getRuntime().availableProcessors();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processor count:");
      localStringBuilder.append(i);
      QLog.i("Q.qqhead.FaceDownloader", 2, localStringBuilder.toString());
    }
    if (i >= 4) {
      return localFaceDownloadThreadInfo;
    }
    localFaceDownloadThreadInfo.maxThreadCount = (i + 1);
    if (i <= 2) {
      localFaceDownloadThreadInfo.priority = 10;
    }
    return localFaceDownloadThreadInfo;
  }
  
  public String getQQHeadDownloadUrl(FaceInfo paramFaceInfo, boolean paramBoolean)
  {
    if (paramFaceInfo.b == 116) {
      return getQQHeadDownloadUrlApollo(paramFaceInfo);
    }
    paramFaceInfo = paramFaceInfo.p;
    paramFaceInfo = MsfSdkUtils.insertMtype("QQHeadIcon", AvatarDownloadUtil.getQQAvatarDownLoadUrl(paramFaceInfo.downLoadUrl, paramFaceInfo.dwFaceFlgas, paramFaceInfo.dstUsrType, paramFaceInfo.originUsrType, paramBoolean));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFaceInfo);
    localStringBuilder.append("&t=");
    localStringBuilder.append(System.currentTimeMillis());
    return localStringBuilder.toString();
  }
  
  public String getQQHeadDownloadUrlApollo(FaceInfo paramFaceInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFaceInfo.p.downLoadUrl);
    localStringBuilder.append(ApolloUtil.a(paramFaceInfo.j));
    localStringBuilder.append("?t=");
    localStringBuilder.append(paramFaceInfo.p.dwTimestamp);
    return localStringBuilder.toString();
  }
  
  protected boolean isIpv6()
  {
    if (!AppSetting.a()) {
      return false;
    }
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isIpv6, getActiveNetIpFamily = ");
      localStringBuilder.append(i);
      QLog.i("Q.qqhead.FaceDownloader", 2, localStringBuilder.toString());
    }
    if ((i != 2) && (i != 3)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDownloader", 2, "iisIpv6, true");
    }
    return true;
  }
  
  public void removeFaceDownloadListener(FaceDownloader.FaceDownloadListener paramFaceDownloadListener)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeFaceDownloadListener l=");
        localStringBuilder.append(paramFaceDownloadListener);
        QLog.i("Q.qqhead.FaceDownloader", 2, localStringBuilder.toString());
      }
      this.mDownloadListener.remove(paramFaceDownloadListener);
      return;
    }
    finally {}
  }
  
  public Object[] setHttpConnAndUseProxy(String paramString1, int paramInt1, String paramString2, boolean paramBoolean, int paramInt2, String paramString3)
  {
    boolean bool;
    if ((paramString1 != null) && (paramInt1 > 0) && (!forceDirect))
    {
      if ((!paramString2.equals(PkgTools.APN_TYPE_CMWAP)) && (!paramString2.equals(PkgTools.APN_TYPE_UNIWAP)) && (!paramString2.equals(PkgTools.APN_TYPE_3GWAP)))
      {
        paramString1 = PkgTools.getConnectionWithDefaultProxy(paramString3, paramString1, paramInt1);
        paramBoolean = true;
      }
      else
      {
        if ((Math.abs(paramInt2 % 2) == 1) && (DPC_WAP_DIRECT_CONNECT == 1))
        {
          paramString2 = (HttpURLConnection)new URL(paramString3).openConnection();
          bool = false;
        }
        else
        {
          paramString2 = PkgTools.getConnectionWithXOnlineHost(paramString3, paramString1, paramInt1);
          bool = true;
        }
        paramString1 = paramString2;
        paramBoolean = bool;
        if (QLog.isDevelopLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("downloadData, wapconn, DPC_WAP_DIRECT_CONNECT=");
          paramString1.append(DPC_WAP_DIRECT_CONNECT);
          paramString1.append(", tryCount=");
          paramString1.append(paramInt2);
          QLog.i("Q.qqhead.FaceDownloader", 4, paramString1.toString());
          paramString1 = paramString2;
          paramBoolean = bool;
        }
      }
    }
    else {
      paramString1 = (HttpURLConnection)new URL(paramString3).openConnection();
    }
    paramString1.setRequestProperty("Accept-Encoding", "identity");
    paramString1.setConnectTimeout(30000);
    paramString1.setReadTimeout(30000);
    paramString1.setInstanceFollowRedirects(true);
    if ((paramString1 instanceof HttpsURLConnection))
    {
      paramString2 = (HttpsURLConnection)paramString1;
      paramString3 = new URL(paramString3);
      if (paramInt2 == -1) {
        bool = true;
      } else {
        bool = false;
      }
      enableSNI(paramString2, paramString3, bool);
    }
    return new Object[] { Boolean.valueOf(paramBoolean), paramString1 };
  }
  
  public void smartSetThreadCount(int paramInt)
  {
    int k = this.mRequestQueue.size();
    int j;
    int i;
    if ((paramInt == this.maxThreadCount) && (this.currThreadCount.get() < this.maxThreadCount) && (this.mRequestQueue.size() >= this.idleThreadCount.get()))
    {
      j = this.currThreadCount.get() + this.mRequestQueue.size() - this.idleThreadCount.get() + 1;
      i = j;
      if (j <= 0) {
        i = 1;
      }
      j = this.maxThreadCount;
      if (i >= j) {
        i = j;
      }
    }
    for (;;)
    {
      try
      {
        Thread[] arrayOfThread = this.mDownThreads;
        j = 0;
        if (j < i) {}
        try
        {
          if (this.mDownThreads[j] != null) {
            break label338;
          }
          this.mDownRunnables[j] = new FaceDownloader.FaceDownloadRunnable(this, j);
          this.mDownThreads[j] = ThreadManager.newFreeThread(this.mDownRunnables[j], "FaceDownloadThread", 5);
          this.mDownThreads[j].start();
          this.currThreadCount.incrementAndGet();
        }
        finally {}
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Q.qqhead.FaceDownloader", 1, "smartSetThreadCount", localThrowable);
        return;
      }
      Object localObject1 = this.mDownRunnables;
      if ((localObject1 == null) || (localObject1.length <= 0) || (localObject1[0] == null))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("smartSetThreadCount fail, MAX_THREAD_COUNT=");
        ((StringBuilder)localObject1).append(this.maxThreadCount);
        ((StringBuilder)localObject1).append(",newThreadCount=");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(",currThreadCount=");
        ((StringBuilder)localObject1).append(this.currThreadCount);
        ((StringBuilder)localObject1).append(",idleThreadCount=");
        ((StringBuilder)localObject1).append(this.idleThreadCount);
        ((StringBuilder)localObject1).append(",queueSize=");
        ((StringBuilder)localObject1).append(k);
        QLog.e("Q.qqhead.FaceDownloader", 2, ((StringBuilder)localObject1).toString());
      }
      return;
      label338:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDownloader
 * JD-Core Version:    0.7.0.1
 */