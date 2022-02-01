package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import amtk;
import anbx;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import anho;
import ardx;
import arid;
import bfpx;
import bfpy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import mqq.os.MqqHandler;
import org.apache.http.ConnectionClosedException;
import org.apache.http.conn.ConnectTimeoutException;
import org.jetbrains.annotations.NotNull;

public abstract class FaceDownloader
{
  private static final int DEFAULT_CHECK_INTERVAL = 30000;
  private static int DPC_WAP_DIRECT_CONNECT = 1;
  public static final int HEAD_USERLOG_OUTPUT_COSTTIME_LIMIT = 3000;
  public static final int MSG_DOWNLOAD_FINISH = 100;
  public static final String STATISTIC_HEAD_GROUP_ACTIONTAG = "actGetGroupHead";
  public static final String STATISTIC_HEAD_NERABY_ACTIONTAG = "actGetNearbyHead";
  public static final String STATISTIC_HEAD_USER_ACTIONTAG = "actGetUserHead";
  private static final String TAG = "Q.qqhead.FaceDownloader";
  private static boolean forceDirect;
  private static String lastApn;
  protected AtomicInteger currThreadCount = new AtomicInteger(0);
  private int emptyCheckMax = 2;
  protected MqqHandler handler;
  protected AtomicInteger idleThreadCount = new AtomicInteger(0);
  protected AppInterface mApp;
  private FaceDownloader.FaceDownloadRunnable[] mDownRunnables;
  private Thread[] mDownThreads;
  LinkedList<FaceDownloader.FaceDownloadListener> mDownloadListener = new LinkedList();
  protected HashSet<String> mDownloadingUrlSet;
  protected byte mImageIndex;
  protected int mImageSize;
  protected ArrayList<FaceInfo> mRequestQueue;
  private FaceDownloader.FaceDownloadThreadInfo mThreadInfo;
  public int maxThreadCount = 6;
  private int priorDownloadQQheadThreshold = 10;
  public ArrayList<FaceDownloader.PendingTask> sPendingResultList = new ArrayList(100);
  
  public FaceDownloader(AppInterface paramAppInterface)
  {
    initFaceDownloadThreadInfo();
    initDPCFlag();
    if (this.mThreadInfo.maxThreadCount != -2147483648) {
      this.maxThreadCount = this.mThreadInfo.maxThreadCount;
    }
    String str = BaseApplicationImpl.processName;
    if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.mobileqq"))) {
      this.maxThreadCount = 4;
    }
    this.mApp = paramAppInterface;
    this.mRequestQueue = new ArrayList();
    this.mDownloadingUrlSet = new HashSet();
    this.currThreadCount.set(this.maxThreadCount);
    this.mDownThreads = new Thread[this.maxThreadCount];
    this.mDownRunnables = new FaceDownloader.FaceDownloadRunnable[this.maxThreadCount];
    int i = 0;
    for (;;)
    {
      if (i < this.mDownThreads.length)
      {
        this.mDownRunnables[i] = new FaceDownloader.FaceDownloadRunnable(this, i);
        this.mDownThreads[i] = ThreadManager.newFreeThread(this.mDownRunnables[i], "FaceDownloadThread", 5);
        if (anbx.a().c()) {
          this.mDownThreads[i].setPriority(1);
        }
        try
        {
          this.mDownThreads[i].start();
          i += 1;
        }
        catch (OutOfMemoryError paramAppInterface)
        {
          for (;;)
          {
            QLog.e("Q.qqhead.FaceDownloader", 1, "FaceDownloader() error, ", paramAppInterface);
          }
        }
      }
    }
    this.mImageSize = getFaceImageSize();
    switch (this.mImageSize)
    {
    }
    for (;;)
    {
      this.handler = new FaceDownloader.1(this, Looper.getMainLooper());
      return;
      this.mImageIndex = 3;
      continue;
      this.mImageIndex = 2;
      continue;
      this.mImageIndex = 0;
    }
  }
  
  private void cacheFile(FaceInfo paramFaceInfo, boolean paramBoolean, long paramLong, int paramInt)
  {
    int i = 0;
    FaceDownloader.PendingTask localPendingTask;
    if (paramBoolean)
    {
      localPendingTask = new FaceDownloader.PendingTask(this);
      localPendingTask.faceInfo = paramFaceInfo;
      if (paramInt == 0) {
        break label66;
      }
      paramFaceInfo.a(FaceInfo.o);
      localPendingTask.bitmap = null;
      this.sPendingResultList.add(localPendingTask);
      this.handler.obtainMessage(100, localPendingTask).sendToTarget();
    }
    label66:
    while (paramLong < 20480L) {
      return;
    }
    paramFaceInfo.a(FaceInfo.p);
    bfpy localbfpy = new bfpy();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = FaceConstant.FACE_BITMAP_CONFIG;
    anho localanho = (anho)this.mApp.getManager(216);
    paramInt = 0;
    for (;;)
    {
      bfpx.a(localanho.a(paramFaceInfo), localOptions, localbfpy);
      if (localbfpy.jdField_a_of_type_Int == 1)
      {
        NearbyAppInterface localNearbyAppInterface = (NearbyAppInterface)this.mApp;
        NearbyAppInterface.b();
      }
      paramInt += 1;
      if ((paramInt >= 2) || (localbfpy.jdField_a_of_type_Int != 1))
      {
        if (localbfpy.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          paramInt = i;
          if (paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo != null) {
            paramInt = paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.cHeadType;
          }
          localbfpy.jdField_a_of_type_AndroidGraphicsBitmap = QQAppInterface.genFaceBmpByShape((byte)paramFaceInfo.c, localbfpy.jdField_a_of_type_AndroidGraphicsBitmap, paramFaceInfo.jdField_a_of_type_JavaLangString, paramInt);
          localanho.a(paramFaceInfo.a(), localbfpy.jdField_a_of_type_AndroidGraphicsBitmap, anho.a(paramFaceInfo.jdField_a_of_type_Int));
        }
        paramFaceInfo.a(FaceInfo.q);
        localPendingTask.bitmap = localbfpy.jdField_a_of_type_AndroidGraphicsBitmap;
        this.sPendingResultList.add(localPendingTask);
        this.handler.obtainMessage(100, localPendingTask).sendToTarget();
        return;
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
    QLog.i("Q.qqhead.FaceDownloader", 1, "Download fail 1. url=" + paramURL + ",faceInfo=" + paramFaceInfo, paramIOException);
    if ((paramIOException instanceof UnknownHostException)) {
      return 10;
    }
    if (((paramIOException instanceof ConnectTimeoutException)) || ((paramIOException instanceof SocketTimeoutException))) {
      return 2;
    }
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
    boolean bool;
    long l;
    if ((paramFaceInfo.contains("EACCES")) || (paramFaceInfo.contains("ENOSPC")) || (paramFaceInfo.contains("Read-only")))
    {
      i = 33;
      bool = SystemUtil.isExistSDCard();
      if (!bool) {
        break label296;
      }
      l = SystemUtil.getSDCardAvailableSize();
      label177:
      paramURL = new StringBuilder().append("Download fail 1. tmpFilePath=");
      if (!paramFile.exists()) {
        break label304;
      }
      paramFaceInfo = paramFile.getAbsolutePath();
      label203:
      paramURL = paramURL.append(paramFaceInfo).append("tmpParentFilePath=");
      if ((paramFile.getParentFile() == null) || (!paramFile.getParentFile().exists())) {
        break label311;
      }
    }
    label296:
    label304:
    label311:
    for (paramFaceInfo = paramFile.getParentFile().getAbsolutePath();; paramFaceInfo = "notExit")
    {
      QLog.i("Q.qqhead.FaceDownloader", 1, paramFaceInfo + ", result=" + i + ",isExistSDCard=" + bool + ",availableSize=" + l);
      return i;
      i = 4;
      break;
      l = SystemUtil.getSystemAvailableSize();
      break label177;
      paramFaceInfo = "notExit";
      break label203;
    }
  }
  
  private void deleteTmpFile(int paramInt, File paramFile)
  {
    if ((paramInt != 0) && (paramFile != null)) {}
    try
    {
      getParentFile(paramFile);
      if (paramFile.exists())
      {
        boolean bool = paramFile.delete();
        QLog.i("Q.qqhead.FaceDownloader", 1, "delete file in finally: " + bool);
      }
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  /* Error */
  private void downloadFailedWaitAndTryAgain(String paramString1, FaceInfo paramFaceInfo, int paramInt1, Object paramObject, int paramInt2, boolean paramBoolean, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    // Byte code:
    //   0: iload_3
    //   1: ifeq +139 -> 140
    //   4: ldc 26
    //   6: iconst_1
    //   7: new 345	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 460
    //   17: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: iload_3
    //   21: invokevirtual 421	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: ldc_w 462
    //   27: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 464
    //   37: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 5
    //   42: invokevirtual 421	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: ldc_w 357
    //   48: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_2
    //   52: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   55: ldc_w 466
    //   58: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload 6
    //   63: invokevirtual 426	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   66: ldc_w 468
    //   69: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 7
    //   74: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc_w 470
    //   80: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: iload 8
    //   85: invokevirtual 421	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: ldc_w 472
    //   91: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: getstatic 474	com/tencent/mobileqq/app/face/FaceDownloader:forceDirect	Z
    //   97: invokevirtual 426	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   100: ldc_w 476
    //   103: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload 9
    //   108: invokevirtual 421	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: ldc_w 478
    //   114: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 10
    //   119: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc_w 480
    //   125: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: getstatic 63	com/tencent/mobileqq/app/face/FaceDownloader:DPC_WAP_DIRECT_CONNECT	I
    //   131: invokevirtual 421	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: invokevirtual 360	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 434	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: iload_3
    //   141: ifeq +34 -> 175
    //   144: iload 5
    //   146: iconst_2
    //   147: if_icmpge +28 -> 175
    //   150: aload 4
    //   152: monitorenter
    //   153: aload 4
    //   155: ldc2_w 481
    //   158: invokevirtual 486	java/lang/Object:wait	(J)V
    //   161: aload 4
    //   163: monitorexit
    //   164: return
    //   165: astore_1
    //   166: aload 4
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    //   171: astore_1
    //   172: goto -11 -> 161
    //   175: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	FaceDownloader
    //   0	176	1	paramString1	String
    //   0	176	2	paramFaceInfo	FaceInfo
    //   0	176	3	paramInt1	int
    //   0	176	4	paramObject	Object
    //   0	176	5	paramInt2	int
    //   0	176	6	paramBoolean	boolean
    //   0	176	7	paramString2	String
    //   0	176	8	paramInt3	int
    //   0	176	9	paramInt4	int
    //   0	176	10	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   153	161	165	finally
    //   161	164	165	finally
    //   166	169	165	finally
    //   153	161	171	java/lang/InterruptedException
  }
  
  private static void enableSNI(HttpsURLConnection paramHttpsURLConnection, URL paramURL, boolean paramBoolean)
  {
    FaceDownloader.2 local2 = new FaceDownloader.2(paramBoolean, paramURL);
    paramHttpsURLConnection.setRequestProperty("host", paramURL.getHost());
    paramHttpsURLConnection.setSSLSocketFactory(new SniSSLSocketFactory(paramURL.getHost(), local2));
    paramHttpsURLConnection.setHostnameVerifier(local2);
  }
  
  public static String get1080QQHeadDownLoadUrl(String paramString, byte paramByte)
  {
    String str = InnerDns.getInstance().reqDns("q.qlogo.cn", 1003);
    if (QLog.isColorLevel()) {
      QLog.i("InnerDns", 2, "get1080QQHeadDownLoadUrl.choosedIp=" + str);
    }
    StringBuilder localStringBuilder = new StringBuilder("https://");
    if (!TextUtils.isEmpty(str))
    {
      localStringBuilder.append(str);
      int i = paramString.indexOf("/", 8);
      str = paramString;
      if (i > 8)
      {
        localStringBuilder.append(paramString.substring(i));
        str = localStringBuilder.toString();
      }
      if ((paramByte & 0x20) == 0) {
        break label147;
      }
      paramByte = 0;
    }
    for (;;)
    {
      return str + paramByte;
      localStringBuilder.append("q.qlogo.cn");
      break;
      label147:
      if ((paramByte & 0x10) != 0) {
        paramByte = 640;
      } else if ((paramByte & 0x8) != 0) {
        paramByte = 140;
      } else if ((paramByte & 0x4) != 0) {
        paramByte = 100;
      } else {
        paramByte = 40;
      }
    }
  }
  
  public static String get640QQHeandDownLoadUrl(String paramString, byte paramByte)
  {
    String str = InnerDns.getInstance().reqDns("q.qlogo.cn", 1003);
    if (QLog.isColorLevel()) {
      QLog.i("InnerDns", 2, "get640QQHeandDownLoadUrl.choosedIp=" + str);
    }
    StringBuilder localStringBuilder = new StringBuilder("https://");
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append(str);
    }
    for (;;)
    {
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
      if (i == 0) {
        break;
      }
      return str + i;
      localStringBuilder.append("q.qlogo.cn");
    }
    return "";
  }
  
  private Bitmap getBitmapByShape(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap != null) {
      if (paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo == null) {
        break label77;
      }
    }
    label77:
    for (int i = paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.cHeadType;; i = 0)
    {
      localBitmap = QQAppInterface.genFaceBmpByShape((byte)paramFaceInfo.c, paramBitmap, paramFaceInfo.jdField_a_of_type_JavaLangString, i);
      ((anho)this.mApp.getManager(216)).a(paramFaceInfo.a(), localBitmap, anho.a(paramFaceInfo.jdField_a_of_type_Int));
      paramFaceInfo.a(FaceInfo.q);
      return localBitmap;
    }
  }
  
  @NotNull
  private String getDomain(String paramString, FaceInfo paramFaceInfo, int paramInt, QQHeadInfo paramQQHeadInfo)
  {
    String str = "q.qlogo.cn";
    if (paramQQHeadInfo.dstUsrType == 32) {
      if (paramQQHeadInfo.originUsrType == 1) {
        str = "q.qlogo.cn";
      }
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("https://");
      localStringBuilder.append(str);
      int i = paramString.indexOf("/", 8);
      paramQQHeadInfo = paramString;
      if (i > 8)
      {
        localStringBuilder.append(paramString.substring(i));
        paramQQHeadInfo = localStringBuilder.toString();
      }
      QLog.d("Q.qqhead.FaceDownloader", 1, "downloadData retry tryCount =" + paramInt + ",urlString=" + paramQQHeadInfo + ",faceInfo=" + paramFaceInfo);
      return paramQQHeadInfo;
      if (paramQQHeadInfo.originUsrType == 32)
      {
        str = "p.qlogo.cn";
        continue;
        if (paramQQHeadInfo.dstUsrType == 16) {
          str = "q.qlogo.cn";
        } else if ((paramQQHeadInfo.dstUsrType == 4) || (paramQQHeadInfo.dstUsrType == 8)) {
          str = "p.qlogo.cn";
        } else {
          str = "q.qlogo.cn";
        }
      }
    }
  }
  
  public static String getHeadActionTag(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "actGetUserHead";
    case 4: 
    case 8: 
      return "actGetGroupHead";
    case 16: 
    case 32: 
      return "actGetNearbyHead";
    }
    return "actGetUserHead";
  }
  
  public static String getHeadActionTagWithNetWork(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 8)) {
      return "";
    }
    String str2 = getHeadActionTag(paramInt);
    paramInt = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
    String str1;
    if (paramInt == 1) {
      str1 = "WIFI";
    }
    for (;;)
    {
      return str2 + str1;
      if (paramInt == 2) {
        str1 = "2G";
      } else if (paramInt == 3) {
        str1 = "3G";
      } else if (paramInt == 4) {
        str1 = "4G";
      } else {
        str1 = "Unknown";
      }
    }
  }
  
  private String getIp(String paramString, boolean paramBoolean)
  {
    int i = 28;
    boolean bool = amtk.a().a();
    int j = NetConnInfoCenter.getActiveNetIpFamily(true);
    Object localObject;
    if (j == 3)
    {
      localObject = InnerDns.getInstance();
      if (bool)
      {
        j = 28;
        localObject = ((InnerDns)localObject).reqDnsForIpList(paramString, 1003, true, j);
        if ((localObject != null) && (((ArrayList)localObject).size() != 0) && (!paramBoolean)) {
          break label215;
        }
        localObject = InnerDns.getInstance();
        if (bool) {
          i = 1;
        }
        paramString = ((InnerDns)localObject).reqDnsForIpList(paramString, 1003, true, i);
      }
    }
    for (;;)
    {
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("InnerDns", 2, "getQQHeandDownLoadUrl.choosedIp = " + (String)paramString.get(0));
        }
        return (String)paramString.get(0);
        j = 1;
        break;
        if (j == 2)
        {
          j = 1;
          label167:
          localObject = InnerDns.getInstance();
          if (j == 0) {
            break label198;
          }
        }
        for (;;)
        {
          paramString = ((InnerDns)localObject).reqDnsForIpList(paramString, 1003, true, i);
          break;
          j = 0;
          break label167;
          label198:
          i = 1;
        }
      }
      QLog.d("InnerDns", 1, "getQQHeandDownLoadUrl() ipList is null");
      return null;
      label215:
      paramString = (String)localObject;
    }
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
    if (TextUtils.isEmpty(BaseApplicationImpl.processName)) {}
    for (;;)
    {
      return;
      if (BaseApplicationImpl.processName.equals("com.tencent.mobileqq:tool")) {}
      for (this.mThreadInfo = getNearbyFaceDownloadThreadInfo(); QLog.isColorLevel(); this.mThreadInfo = new FaceDownloader.FaceDownloadThreadInfo(this))
      {
        QLog.i("Q.qqhead.FaceDownloader", 2, "initFaceDownloadThreadInfo, maxThreadCount=" + this.mThreadInfo.maxThreadCount + ",priority=" + this.mThreadInfo.priority);
        return;
      }
    }
  }
  
  private boolean isVerifyError(FaceInfo paramFaceInfo, int paramInt, ardx paramardx, HttpURLConnection paramHttpURLConnection, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (!TextUtils.isEmpty(paramString))
    {
      QLog.i("Q.qqhead.FaceDownloader", 1, "Download has X-ErrNo，X-ErrNo=" + paramString);
      printHeaderInfo(paramHttpURLConnection, paramFaceInfo);
      return bool2;
    }
    bool2 = bool1;
    if (paramardx.f == null) {
      if (paramardx.c != 200) {
        break label146;
      }
    }
    for (;;)
    {
      bool2 = true;
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.headVerify))
      {
        bool1 = bool2;
        if (paramardx.f != null)
        {
          bool1 = bool2;
          if (!paramardx.f.equals(paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.headVerify)) {
            bool1 = true;
          }
        }
      }
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      printHeaderInfo(paramHttpURLConnection, paramFaceInfo);
      return bool1;
      label146:
      paramInt = paramardx.c;
    }
  }
  
  private boolean needVerify(int paramInt)
  {
    return paramInt != 116;
  }
  
  private void printHeaderInfo(HttpURLConnection paramHttpURLConnection, FaceInfo paramFaceInfo)
  {
    if ((paramHttpURLConnection == null) || (paramFaceInfo == null) || (paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo == null)) {
      return;
    }
    try
    {
      QLog.i("Q.qqhead.FaceDownloader", 2, "headInfo=" + paramHttpURLConnection.getResponseCode() + "," + paramHttpURLConnection.getContentType() + "," + paramHttpURLConnection.getContentLength() + "," + paramHttpURLConnection.getHeaderField("Server") + "," + paramHttpURLConnection.getHeaderField("X-ErrNo") + "," + paramHttpURLConnection.getHeaderField("X-RtFlag") + "," + paramHttpURLConnection.getHeaderField("X-BCheck") + "," + paramHttpURLConnection.getHeaderField("X-BCheck") + "," + paramFaceInfo);
      return;
    }
    catch (Throwable paramHttpURLConnection) {}
  }
  
  /* Error */
  private int realDownloadData(String paramString, File paramFile1, FaceInfo paramFaceInfo, boolean paramBoolean, android.net.NetworkInfo paramNetworkInfo, URL paramURL, int paramInt1, Object paramObject, int paramInt2, OutputStream paramOutputStream, ardx paramardx, File paramFile2, int paramInt3, HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 27
    //   3: aload_1
    //   4: astore 31
    //   6: aload 10
    //   8: astore_1
    //   9: iload 13
    //   11: istore 17
    //   13: aload 14
    //   15: astore 10
    //   17: aload 31
    //   19: astore 14
    //   21: aload 14
    //   23: astore 33
    //   25: iload 17
    //   27: iconst_m1
    //   28: if_icmpeq +56 -> 84
    //   31: aload_3
    //   32: getfield 299	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   35: astore 31
    //   37: aload 31
    //   39: ifnonnull +32 -> 71
    //   42: iload 7
    //   44: istore 15
    //   46: lload 27
    //   48: lstore 29
    //   50: aload 11
    //   52: iload 15
    //   54: putfield 715	ardx:b	I
    //   57: aload_0
    //   58: aload_3
    //   59: iload 4
    //   61: lload 29
    //   63: iload 15
    //   65: invokespecial 717	com/tencent/mobileqq/app/face/FaceDownloader:cacheFile	(Lcom/tencent/mobileqq/app/face/FaceInfo;ZJI)V
    //   68: iload 15
    //   70: ireturn
    //   71: aload_0
    //   72: aload 14
    //   74: aload_3
    //   75: iload 17
    //   77: aload 31
    //   79: invokespecial 719	com/tencent/mobileqq/app/face/FaceDownloader:getDomain	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILAvatarInfo/QQHeadInfo;)Ljava/lang/String;
    //   82: astore 33
    //   84: iconst_5
    //   85: istore 13
    //   87: invokestatic 724	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   90: astore 34
    //   92: invokestatic 727	android/net/Proxy:getDefaultPort	()I
    //   95: istore 23
    //   97: aload 5
    //   99: ifnull +442 -> 541
    //   102: aload 5
    //   104: invokevirtual 732	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   107: astore 14
    //   109: aload 5
    //   111: ifnull +436 -> 547
    //   114: aload 5
    //   116: invokevirtual 735	android/net/NetworkInfo:getType	()I
    //   119: istore 18
    //   121: aload 14
    //   123: invokestatic 740	com/tencent/mobileqq/utils/httputils/PkgTools:getApnType	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 35
    //   128: aload_0
    //   129: aload 34
    //   131: iload 18
    //   133: aload 35
    //   135: invokespecial 743	com/tencent/mobileqq/app/face/FaceDownloader:setForceDirect	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_0
    //   139: aload 34
    //   141: iload 23
    //   143: aload 35
    //   145: iconst_0
    //   146: iload 17
    //   148: aload 33
    //   150: invokevirtual 747	com/tencent/mobileqq/app/face/FaceDownloader:setHttpConnAndUseProxy	(Ljava/lang/String;ILjava/lang/String;ZILjava/lang/String;)[Ljava/lang/Object;
    //   153: astore 14
    //   155: aload 14
    //   157: iconst_0
    //   158: aaload
    //   159: checkcast 749	java/lang/Boolean
    //   162: invokevirtual 752	java/lang/Boolean:booleanValue	()Z
    //   165: istore 24
    //   167: aload 14
    //   169: iconst_1
    //   170: aaload
    //   171: checkcast 333	java/net/HttpURLConnection
    //   174: astore 14
    //   176: iload 13
    //   178: istore 15
    //   180: iload 24
    //   182: istore 25
    //   184: iload 13
    //   186: istore 7
    //   188: aload 14
    //   190: astore 31
    //   192: aload_1
    //   193: astore 32
    //   195: aload 14
    //   197: invokevirtual 755	java/net/HttpURLConnection:connect	()V
    //   200: iload 13
    //   202: istore 15
    //   204: iload 24
    //   206: istore 25
    //   208: iload 13
    //   210: istore 7
    //   212: aload 14
    //   214: astore 31
    //   216: aload_1
    //   217: astore 32
    //   219: aload 11
    //   221: aload 14
    //   223: invokevirtual 689	java/net/HttpURLConnection:getResponseCode	()I
    //   226: putfield 677	ardx:c	I
    //   229: iload 13
    //   231: istore 15
    //   233: iload 24
    //   235: istore 25
    //   237: iload 13
    //   239: istore 7
    //   241: aload 14
    //   243: astore 31
    //   245: aload_1
    //   246: astore 32
    //   248: aload 11
    //   250: aload 14
    //   252: invokevirtual 697	java/net/HttpURLConnection:getContentLength	()I
    //   255: putfield 757	ardx:e	I
    //   258: iload 13
    //   260: istore 15
    //   262: iload 24
    //   264: istore 25
    //   266: iload 13
    //   268: istore 7
    //   270: aload 14
    //   272: astore 31
    //   274: aload_1
    //   275: astore 32
    //   277: aload 11
    //   279: aload 14
    //   281: invokevirtual 694	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   284: putfield 760	ardx:h	Ljava/lang/String;
    //   287: iload 13
    //   289: istore 15
    //   291: iload 24
    //   293: istore 25
    //   295: iload 13
    //   297: istore 7
    //   299: aload 14
    //   301: astore 31
    //   303: aload_1
    //   304: astore 32
    //   306: aload 11
    //   308: aload 14
    //   310: invokevirtual 763	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   313: putfield 765	ardx:i	Ljava/lang/String;
    //   316: iload 13
    //   318: istore 15
    //   320: iload 24
    //   322: istore 25
    //   324: iload 13
    //   326: istore 7
    //   328: aload 14
    //   330: astore 31
    //   332: aload_1
    //   333: astore 32
    //   335: aload 11
    //   337: aload 14
    //   339: ldc_w 709
    //   342: invokevirtual 703	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   345: putfield 676	ardx:f	Ljava/lang/String;
    //   348: iload 13
    //   350: istore 15
    //   352: iload 24
    //   354: istore 25
    //   356: iload 13
    //   358: istore 7
    //   360: aload 14
    //   362: astore 31
    //   364: aload_1
    //   365: astore 32
    //   367: aload 14
    //   369: ldc_w 705
    //   372: invokevirtual 703	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   375: astore 10
    //   377: iload 13
    //   379: istore 15
    //   381: iload 24
    //   383: istore 25
    //   385: iload 13
    //   387: istore 7
    //   389: aload 14
    //   391: astore 31
    //   393: aload_1
    //   394: astore 32
    //   396: iload 13
    //   398: istore 16
    //   400: aload_0
    //   401: aload_3
    //   402: getfield 318	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_Int	I
    //   405: invokespecial 767	com/tencent/mobileqq/app/face/FaceDownloader:needVerify	(I)Z
    //   408: ifeq +291 -> 699
    //   411: iload 13
    //   413: istore 15
    //   415: iload 24
    //   417: istore 25
    //   419: iload 13
    //   421: istore 7
    //   423: aload 14
    //   425: astore 31
    //   427: aload_1
    //   428: astore 32
    //   430: iload 13
    //   432: istore 16
    //   434: aload_0
    //   435: aload_3
    //   436: iconst_5
    //   437: aload 11
    //   439: aload 14
    //   441: aload 10
    //   443: invokespecial 769	com/tencent/mobileqq/app/face/FaceDownloader:isVerifyError	(Lcom/tencent/mobileqq/app/face/FaceInfo;ILardx;Ljava/net/HttpURLConnection;Ljava/lang/String;)Z
    //   446: istore 26
    //   448: iload 26
    //   450: ifeq +249 -> 699
    //   453: aload_0
    //   454: aload_1
    //   455: aload 14
    //   457: invokespecial 771	com/tencent/mobileqq/app/face/FaceDownloader:closeConn	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   460: aload_0
    //   461: iconst_5
    //   462: aload 12
    //   464: invokespecial 773	com/tencent/mobileqq/app/face/FaceDownloader:deleteTmpFile	(ILjava/io/File;)V
    //   467: iload 17
    //   469: iconst_1
    //   470: iadd
    //   471: istore 13
    //   473: aload_0
    //   474: aload 33
    //   476: aload_3
    //   477: iconst_5
    //   478: aload 8
    //   480: iload 13
    //   482: iload 24
    //   484: aload 34
    //   486: iload 23
    //   488: iload 18
    //   490: aload 35
    //   492: invokespecial 775	com/tencent/mobileqq/app/face/FaceDownloader:downloadFailedWaitAndTryAgain	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   495: aload 14
    //   497: astore 10
    //   499: iconst_5
    //   500: istore 7
    //   502: lload 27
    //   504: lstore 29
    //   506: iload 7
    //   508: istore 15
    //   510: iload 7
    //   512: ifeq -462 -> 50
    //   515: lload 27
    //   517: lstore 29
    //   519: iload 7
    //   521: istore 15
    //   523: iload 13
    //   525: iload 9
    //   527: if_icmpge -477 -> 50
    //   530: aload 33
    //   532: astore 14
    //   534: iload 13
    //   536: istore 17
    //   538: goto -517 -> 21
    //   541: aconst_null
    //   542: astore 14
    //   544: goto -435 -> 109
    //   547: iconst_m1
    //   548: istore 18
    //   550: goto -429 -> 121
    //   553: astore 10
    //   555: iload 13
    //   557: istore 15
    //   559: iload 24
    //   561: istore 25
    //   563: iload 13
    //   565: istore 7
    //   567: aload 14
    //   569: astore 31
    //   571: aload_1
    //   572: astore 32
    //   574: iload 13
    //   576: istore 16
    //   578: aload_0
    //   579: iload 24
    //   581: aload 34
    //   583: iload 23
    //   585: invokespecial 779	com/tencent/mobileqq/app/face/FaceDownloader:setForceDirectByUseProxy	(ZLjava/lang/String;I)V
    //   588: iload 13
    //   590: istore 15
    //   592: iload 24
    //   594: istore 25
    //   596: iload 13
    //   598: istore 7
    //   600: aload 14
    //   602: astore 31
    //   604: aload_1
    //   605: astore 32
    //   607: iload 13
    //   609: istore 16
    //   611: aload 10
    //   613: athrow
    //   614: astore 10
    //   616: iload 15
    //   618: istore 7
    //   620: iload 24
    //   622: istore 25
    //   624: aload 14
    //   626: astore 31
    //   628: aload_1
    //   629: astore 32
    //   631: aload_0
    //   632: aload_3
    //   633: aload 6
    //   635: aload 12
    //   637: aload 10
    //   639: invokespecial 781	com/tencent/mobileqq/app/face/FaceDownloader:dealDownloadExp	(Lcom/tencent/mobileqq/app/face/FaceInfo;Ljava/net/URL;Ljava/io/File;Ljava/io/IOException;)I
    //   642: istore 15
    //   644: aload_0
    //   645: aload_1
    //   646: aload 14
    //   648: invokespecial 771	com/tencent/mobileqq/app/face/FaceDownloader:closeConn	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   651: aload_0
    //   652: iload 15
    //   654: aload 12
    //   656: invokespecial 773	com/tencent/mobileqq/app/face/FaceDownloader:deleteTmpFile	(ILjava/io/File;)V
    //   659: iload 17
    //   661: iconst_1
    //   662: iadd
    //   663: istore 13
    //   665: aload_0
    //   666: aload 33
    //   668: aload_3
    //   669: iload 15
    //   671: aload 8
    //   673: iload 13
    //   675: iload 24
    //   677: aload 34
    //   679: iload 23
    //   681: iload 18
    //   683: aload 35
    //   685: invokespecial 775	com/tencent/mobileqq/app/face/FaceDownloader:downloadFailedWaitAndTryAgain	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   688: aload 14
    //   690: astore 10
    //   692: iload 15
    //   694: istore 7
    //   696: goto -194 -> 502
    //   699: iconst_0
    //   700: istore 19
    //   702: iconst_0
    //   703: istore 20
    //   705: iconst_0
    //   706: istore 13
    //   708: iconst_0
    //   709: istore 22
    //   711: iconst_0
    //   712: istore 21
    //   714: iload 21
    //   716: istore 15
    //   718: iload 24
    //   720: istore 25
    //   722: iload 13
    //   724: istore 7
    //   726: aload 14
    //   728: astore 31
    //   730: aload_1
    //   731: astore 32
    //   733: iload 22
    //   735: istore 16
    //   737: sipush 200
    //   740: aload 11
    //   742: getfield 677	ardx:c	I
    //   745: if_icmpne +633 -> 1378
    //   748: iload 21
    //   750: istore 15
    //   752: iload 24
    //   754: istore 25
    //   756: iload 13
    //   758: istore 7
    //   760: aload 14
    //   762: astore 31
    //   764: aload_1
    //   765: astore 32
    //   767: iload 22
    //   769: istore 16
    //   771: aload 11
    //   773: getfield 757	ardx:e	I
    //   776: istore 21
    //   778: iload 21
    //   780: i2l
    //   781: lstore 27
    //   783: iconst_0
    //   784: istore 15
    //   786: iload 24
    //   788: istore 25
    //   790: iload 13
    //   792: istore 7
    //   794: aload 14
    //   796: astore 31
    //   798: aload_1
    //   799: astore 32
    //   801: aload 12
    //   803: invokevirtual 407	java/io/File:exists	()Z
    //   806: ifeq +24 -> 830
    //   809: iload 24
    //   811: istore 25
    //   813: iload 13
    //   815: istore 7
    //   817: aload 14
    //   819: astore 31
    //   821: aload_1
    //   822: astore 32
    //   824: aload 12
    //   826: invokevirtual 449	java/io/File:delete	()Z
    //   829: pop
    //   830: iload 24
    //   832: istore 25
    //   834: iload 13
    //   836: istore 7
    //   838: aload 14
    //   840: astore 31
    //   842: aload_1
    //   843: astore 32
    //   845: aload 12
    //   847: invokevirtual 784	java/io/File:createNewFile	()Z
    //   850: pop
    //   851: iload 24
    //   853: istore 25
    //   855: iload 13
    //   857: istore 7
    //   859: aload 14
    //   861: astore 31
    //   863: aload_1
    //   864: astore 32
    //   866: new 786	java/io/BufferedOutputStream
    //   869: dup
    //   870: new 788	java/io/FileOutputStream
    //   873: dup
    //   874: aload 12
    //   876: invokespecial 790	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   879: invokespecial 793	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   882: astore 10
    //   884: aload 10
    //   886: astore 31
    //   888: aload 14
    //   890: invokevirtual 797	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   893: astore 32
    //   895: iload 4
    //   897: ifeq +336 -> 1233
    //   900: lload 27
    //   902: ldc2_w 252
    //   905: lcmp
    //   906: ifge +327 -> 1233
    //   909: aload 10
    //   911: astore 31
    //   913: ldc_w 798
    //   916: newarray byte
    //   918: astore_1
    //   919: iconst_0
    //   920: istore 7
    //   922: iconst_0
    //   923: istore 13
    //   925: aload 10
    //   927: astore 31
    //   929: aload 32
    //   931: aload_1
    //   932: iload 13
    //   934: sipush 1024
    //   937: invokevirtual 804	java/io/InputStream:read	([BII)I
    //   940: istore 15
    //   942: iload 15
    //   944: iconst_m1
    //   945: if_icmpeq +20 -> 965
    //   948: iload 13
    //   950: iload 15
    //   952: iadd
    //   953: istore 13
    //   955: iload 7
    //   957: iload 15
    //   959: iadd
    //   960: istore 7
    //   962: goto -37 -> 925
    //   965: aload 10
    //   967: astore 31
    //   969: aload_3
    //   970: getstatic 231	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   973: invokevirtual 233	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   976: iload 7
    //   978: i2l
    //   979: lload 27
    //   981: lcmp
    //   982: ifne +161 -> 1143
    //   985: aload 10
    //   987: astore 31
    //   989: aload_3
    //   990: getstatic 256	com/tencent/mobileqq/app/face/FaceInfo:p	I
    //   993: invokevirtual 233	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   996: aload 10
    //   998: astore 31
    //   1000: aload_0
    //   1001: aload_3
    //   1002: aload_1
    //   1003: iconst_0
    //   1004: iload 7
    //   1006: invokestatic 807	bfpx:a	([BII)Landroid/graphics/Bitmap;
    //   1009: invokespecial 809	com/tencent/mobileqq/app/face/FaceDownloader:getBitmapByShape	(Lcom/tencent/mobileqq/app/face/FaceInfo;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   1012: astore 32
    //   1014: aload 10
    //   1016: astore 31
    //   1018: invokestatic 536	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1021: ifeq +55 -> 1076
    //   1024: aload 10
    //   1026: astore 31
    //   1028: ldc 26
    //   1030: iconst_2
    //   1031: new 345	java/lang/StringBuilder
    //   1034: dup
    //   1035: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   1038: ldc_w 811
    //   1041: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: aload 32
    //   1046: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1049: ldc_w 813
    //   1052: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: aload 6
    //   1057: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1060: ldc_w 357
    //   1063: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: aload_3
    //   1067: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1070: invokevirtual 360	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1073: invokestatic 434	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1076: aload 10
    //   1078: astore 31
    //   1080: new 219	com/tencent/mobileqq/app/face/FaceDownloader$PendingTask
    //   1083: dup
    //   1084: aload_0
    //   1085: invokespecial 222	com/tencent/mobileqq/app/face/FaceDownloader$PendingTask:<init>	(Lcom/tencent/mobileqq/app/face/FaceDownloader;)V
    //   1088: astore 36
    //   1090: aload 10
    //   1092: astore 31
    //   1094: aload 36
    //   1096: aload_3
    //   1097: putfield 226	com/tencent/mobileqq/app/face/FaceDownloader$PendingTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   1100: aload 10
    //   1102: astore 31
    //   1104: aload 36
    //   1106: aload 32
    //   1108: putfield 237	com/tencent/mobileqq/app/face/FaceDownloader$PendingTask:bitmap	Landroid/graphics/Bitmap;
    //   1111: aload 10
    //   1113: astore 31
    //   1115: aload_0
    //   1116: getfield 95	com/tencent/mobileqq/app/face/FaceDownloader:sPendingResultList	Ljava/util/ArrayList;
    //   1119: aload 36
    //   1121: invokevirtual 240	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1124: pop
    //   1125: aload 10
    //   1127: astore 31
    //   1129: aload_0
    //   1130: getfield 201	com/tencent/mobileqq/app/face/FaceDownloader:handler	Lmqq/os/MqqHandler;
    //   1133: bipush 100
    //   1135: aload 36
    //   1137: invokevirtual 246	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   1140: invokevirtual 251	android/os/Message:sendToTarget	()V
    //   1143: aload 10
    //   1145: astore 31
    //   1147: aload 10
    //   1149: aload_1
    //   1150: iconst_0
    //   1151: iload 7
    //   1153: invokevirtual 817	java/io/OutputStream:write	([BII)V
    //   1156: aload 10
    //   1158: astore 31
    //   1160: aload 10
    //   1162: invokevirtual 820	java/io/OutputStream:flush	()V
    //   1165: aload 10
    //   1167: astore 31
    //   1169: aload_0
    //   1170: aload_2
    //   1171: aload 12
    //   1173: invokespecial 824	com/tencent/mobileqq/app/face/FaceDownloader:renameFile	(Ljava/io/File;Ljava/io/File;)V
    //   1176: iconst_0
    //   1177: istore 7
    //   1179: aload 10
    //   1181: astore_1
    //   1182: aload_0
    //   1183: aload_1
    //   1184: aload 14
    //   1186: invokespecial 771	com/tencent/mobileqq/app/face/FaceDownloader:closeConn	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   1189: aload_0
    //   1190: iload 7
    //   1192: aload 12
    //   1194: invokespecial 773	com/tencent/mobileqq/app/face/FaceDownloader:deleteTmpFile	(ILjava/io/File;)V
    //   1197: iload 17
    //   1199: iconst_1
    //   1200: iadd
    //   1201: istore 13
    //   1203: aload_0
    //   1204: aload 33
    //   1206: aload_3
    //   1207: iload 7
    //   1209: aload 8
    //   1211: iload 13
    //   1213: iload 24
    //   1215: aload 34
    //   1217: iload 23
    //   1219: iload 18
    //   1221: aload 35
    //   1223: invokespecial 775	com/tencent/mobileqq/app/face/FaceDownloader:downloadFailedWaitAndTryAgain	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   1226: aload 14
    //   1228: astore 10
    //   1230: goto -728 -> 502
    //   1233: aload 10
    //   1235: astore 31
    //   1237: sipush 1024
    //   1240: newarray byte
    //   1242: astore_1
    //   1243: iload 15
    //   1245: istore 7
    //   1247: aload 10
    //   1249: astore 31
    //   1251: aload 32
    //   1253: aload_1
    //   1254: invokevirtual 827	java/io/InputStream:read	([B)I
    //   1257: istore 13
    //   1259: iload 13
    //   1261: iconst_m1
    //   1262: if_icmpeq +86 -> 1348
    //   1265: iload 7
    //   1267: iload 13
    //   1269: iadd
    //   1270: istore 7
    //   1272: aload 10
    //   1274: astore 31
    //   1276: aload 10
    //   1278: aload_1
    //   1279: iconst_0
    //   1280: iload 13
    //   1282: invokevirtual 817	java/io/OutputStream:write	([BII)V
    //   1285: goto -38 -> 1247
    //   1288: astore_1
    //   1289: aload 10
    //   1291: astore_1
    //   1292: aload_1
    //   1293: astore 31
    //   1295: ldc 26
    //   1297: iconst_1
    //   1298: new 345	java/lang/StringBuilder
    //   1301: dup
    //   1302: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   1305: ldc_w 829
    //   1308: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: aload 12
    //   1313: invokevirtual 407	java/io/File:exists	()Z
    //   1316: invokevirtual 426	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1319: ldc_w 831
    //   1322: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: aload 12
    //   1327: invokevirtual 416	java/io/File:getParentFile	()Ljava/io/File;
    //   1330: invokevirtual 407	java/io/File:exists	()Z
    //   1333: invokevirtual 426	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1336: invokevirtual 360	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1339: invokestatic 434	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1342: iconst_4
    //   1343: istore 7
    //   1345: goto -163 -> 1182
    //   1348: aload 10
    //   1350: astore 31
    //   1352: aload_3
    //   1353: getstatic 231	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1356: invokevirtual 233	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   1359: goto -203 -> 1156
    //   1362: astore 31
    //   1364: aload 10
    //   1366: astore_1
    //   1367: aload 31
    //   1369: astore 10
    //   1371: iload 19
    //   1373: istore 7
    //   1375: goto -755 -> 620
    //   1378: iload 21
    //   1380: istore 15
    //   1382: iload 24
    //   1384: istore 25
    //   1386: iload 13
    //   1388: istore 7
    //   1390: aload 14
    //   1392: astore 31
    //   1394: aload_1
    //   1395: astore 32
    //   1397: iload 22
    //   1399: istore 16
    //   1401: aload 11
    //   1403: getfield 677	ardx:c	I
    //   1406: istore 13
    //   1408: iload 13
    //   1410: istore 7
    //   1412: goto -230 -> 1182
    //   1415: astore 31
    //   1417: aload 10
    //   1419: astore_1
    //   1420: aload 31
    //   1422: astore 10
    //   1424: iload 20
    //   1426: istore 7
    //   1428: iload 24
    //   1430: istore 25
    //   1432: aload 14
    //   1434: astore 31
    //   1436: aload_1
    //   1437: astore 32
    //   1439: ldc 26
    //   1441: iconst_1
    //   1442: new 345	java/lang/StringBuilder
    //   1445: dup
    //   1446: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   1449: ldc_w 833
    //   1452: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: aload 6
    //   1457: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1460: ldc_w 357
    //   1463: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: aload_3
    //   1467: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1470: invokevirtual 360	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1473: aload 10
    //   1475: invokestatic 363	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1478: aload_0
    //   1479: aload_1
    //   1480: aload 14
    //   1482: invokespecial 771	com/tencent/mobileqq/app/face/FaceDownloader:closeConn	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   1485: aload_0
    //   1486: iconst_5
    //   1487: aload 12
    //   1489: invokespecial 773	com/tencent/mobileqq/app/face/FaceDownloader:deleteTmpFile	(ILjava/io/File;)V
    //   1492: iload 17
    //   1494: iconst_1
    //   1495: iadd
    //   1496: istore 13
    //   1498: aload_0
    //   1499: aload 33
    //   1501: aload_3
    //   1502: iconst_5
    //   1503: aload 8
    //   1505: iload 13
    //   1507: iload 24
    //   1509: aload 34
    //   1511: iload 23
    //   1513: iload 18
    //   1515: aload 35
    //   1517: invokespecial 775	com/tencent/mobileqq/app/face/FaceDownloader:downloadFailedWaitAndTryAgain	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   1520: aload 14
    //   1522: astore 10
    //   1524: iconst_5
    //   1525: istore 7
    //   1527: goto -1025 -> 502
    //   1530: astore_2
    //   1531: iconst_0
    //   1532: istore 7
    //   1534: aload 31
    //   1536: astore_1
    //   1537: aload_0
    //   1538: aload_1
    //   1539: aload 14
    //   1541: invokespecial 771	com/tencent/mobileqq/app/face/FaceDownloader:closeConn	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   1544: aload_0
    //   1545: iload 7
    //   1547: aload 12
    //   1549: invokespecial 773	com/tencent/mobileqq/app/face/FaceDownloader:deleteTmpFile	(ILjava/io/File;)V
    //   1552: aload_0
    //   1553: aload 33
    //   1555: aload_3
    //   1556: iload 7
    //   1558: aload 8
    //   1560: iload 17
    //   1562: iconst_1
    //   1563: iadd
    //   1564: iload 24
    //   1566: aload 34
    //   1568: iload 23
    //   1570: iload 18
    //   1572: aload 35
    //   1574: invokespecial 775	com/tencent/mobileqq/app/face/FaceDownloader:downloadFailedWaitAndTryAgain	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   1577: aload_2
    //   1578: athrow
    //   1579: astore_2
    //   1580: aload 32
    //   1582: astore_1
    //   1583: iload 25
    //   1585: istore 24
    //   1587: aload 31
    //   1589: astore 14
    //   1591: goto -54 -> 1537
    //   1594: astore_2
    //   1595: iconst_0
    //   1596: istore 24
    //   1598: iconst_5
    //   1599: istore 7
    //   1601: aload 10
    //   1603: astore 14
    //   1605: goto -68 -> 1537
    //   1608: astore_2
    //   1609: iconst_5
    //   1610: istore 7
    //   1612: aload 10
    //   1614: astore 14
    //   1616: goto -79 -> 1537
    //   1619: astore 10
    //   1621: iload 20
    //   1623: istore 7
    //   1625: goto -197 -> 1428
    //   1628: astore 31
    //   1630: iconst_0
    //   1631: istore 24
    //   1633: aload 10
    //   1635: astore 14
    //   1637: aload 31
    //   1639: astore 10
    //   1641: iload 13
    //   1643: istore 7
    //   1645: goto -217 -> 1428
    //   1648: astore 31
    //   1650: aload 10
    //   1652: astore 14
    //   1654: aload 31
    //   1656: astore 10
    //   1658: iload 13
    //   1660: istore 7
    //   1662: goto -234 -> 1428
    //   1665: astore 10
    //   1667: iload 16
    //   1669: istore 7
    //   1671: goto -243 -> 1428
    //   1674: astore 10
    //   1676: iload 20
    //   1678: istore 7
    //   1680: goto -252 -> 1428
    //   1683: astore 10
    //   1685: iload 19
    //   1687: istore 7
    //   1689: goto -1069 -> 620
    //   1692: astore 31
    //   1694: iconst_0
    //   1695: istore 24
    //   1697: aload 10
    //   1699: astore 14
    //   1701: aload 31
    //   1703: astore 10
    //   1705: iload 13
    //   1707: istore 7
    //   1709: goto -1089 -> 620
    //   1712: astore 31
    //   1714: aload 10
    //   1716: astore 14
    //   1718: aload 31
    //   1720: astore 10
    //   1722: iload 13
    //   1724: istore 7
    //   1726: goto -1106 -> 620
    //   1729: astore 10
    //   1731: iload 19
    //   1733: istore 7
    //   1735: goto -1115 -> 620
    //   1738: astore 10
    //   1740: goto -448 -> 1292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1743	0	this	FaceDownloader
    //   0	1743	1	paramString	String
    //   0	1743	2	paramFile1	File
    //   0	1743	3	paramFaceInfo	FaceInfo
    //   0	1743	4	paramBoolean	boolean
    //   0	1743	5	paramNetworkInfo	android.net.NetworkInfo
    //   0	1743	6	paramURL	URL
    //   0	1743	7	paramInt1	int
    //   0	1743	8	paramObject	Object
    //   0	1743	9	paramInt2	int
    //   0	1743	10	paramOutputStream	OutputStream
    //   0	1743	11	paramardx	ardx
    //   0	1743	12	paramFile2	File
    //   0	1743	13	paramInt3	int
    //   0	1743	14	paramHttpURLConnection	HttpURLConnection
    //   44	1337	15	i	int
    //   398	1270	16	j	int
    //   11	1553	17	k	int
    //   119	1452	18	m	int
    //   700	1032	19	n	int
    //   703	974	20	i1	int
    //   712	667	21	i2	int
    //   709	689	22	i3	int
    //   95	1474	23	i4	int
    //   165	1531	24	bool1	boolean
    //   182	1402	25	bool2	boolean
    //   446	3	26	bool3	boolean
    //   1	979	27	l1	long
    //   48	470	29	l2	long
    //   4	1347	31	localObject1	Object
    //   1362	6	31	localIOException1	IOException
    //   1392	1	31	localHttpURLConnection1	HttpURLConnection
    //   1415	6	31	localThrowable1	Throwable
    //   1434	154	31	localHttpURLConnection2	HttpURLConnection
    //   1628	10	31	localThrowable2	Throwable
    //   1648	7	31	localThrowable3	Throwable
    //   1692	10	31	localIOException2	IOException
    //   1712	7	31	localIOException3	IOException
    //   193	1388	32	localObject2	Object
    //   23	1531	33	localObject3	Object
    //   90	1477	34	str1	String
    //   126	1447	35	str2	String
    //   1088	48	36	localPendingTask	FaceDownloader.PendingTask
    // Exception table:
    //   from	to	target	type
    //   195	200	553	java/lang/Throwable
    //   219	229	553	java/lang/Throwable
    //   248	258	553	java/lang/Throwable
    //   277	287	553	java/lang/Throwable
    //   306	316	553	java/lang/Throwable
    //   335	348	553	java/lang/Throwable
    //   367	377	553	java/lang/Throwable
    //   195	200	614	java/io/IOException
    //   219	229	614	java/io/IOException
    //   248	258	614	java/io/IOException
    //   277	287	614	java/io/IOException
    //   306	316	614	java/io/IOException
    //   335	348	614	java/io/IOException
    //   367	377	614	java/io/IOException
    //   400	411	614	java/io/IOException
    //   434	448	614	java/io/IOException
    //   578	588	614	java/io/IOException
    //   611	614	614	java/io/IOException
    //   737	748	614	java/io/IOException
    //   771	778	614	java/io/IOException
    //   1401	1408	614	java/io/IOException
    //   888	895	1288	java/io/FileNotFoundException
    //   913	919	1288	java/io/FileNotFoundException
    //   929	942	1288	java/io/FileNotFoundException
    //   969	976	1288	java/io/FileNotFoundException
    //   989	996	1288	java/io/FileNotFoundException
    //   1000	1014	1288	java/io/FileNotFoundException
    //   1018	1024	1288	java/io/FileNotFoundException
    //   1028	1076	1288	java/io/FileNotFoundException
    //   1080	1090	1288	java/io/FileNotFoundException
    //   1094	1100	1288	java/io/FileNotFoundException
    //   1104	1111	1288	java/io/FileNotFoundException
    //   1115	1125	1288	java/io/FileNotFoundException
    //   1129	1143	1288	java/io/FileNotFoundException
    //   1147	1156	1288	java/io/FileNotFoundException
    //   1160	1165	1288	java/io/FileNotFoundException
    //   1169	1176	1288	java/io/FileNotFoundException
    //   1237	1243	1288	java/io/FileNotFoundException
    //   1251	1259	1288	java/io/FileNotFoundException
    //   1276	1285	1288	java/io/FileNotFoundException
    //   1352	1359	1288	java/io/FileNotFoundException
    //   888	895	1362	java/io/IOException
    //   913	919	1362	java/io/IOException
    //   929	942	1362	java/io/IOException
    //   969	976	1362	java/io/IOException
    //   989	996	1362	java/io/IOException
    //   1000	1014	1362	java/io/IOException
    //   1018	1024	1362	java/io/IOException
    //   1028	1076	1362	java/io/IOException
    //   1080	1090	1362	java/io/IOException
    //   1094	1100	1362	java/io/IOException
    //   1104	1111	1362	java/io/IOException
    //   1115	1125	1362	java/io/IOException
    //   1129	1143	1362	java/io/IOException
    //   1147	1156	1362	java/io/IOException
    //   1160	1165	1362	java/io/IOException
    //   1169	1176	1362	java/io/IOException
    //   1237	1243	1362	java/io/IOException
    //   1251	1259	1362	java/io/IOException
    //   1276	1285	1362	java/io/IOException
    //   1352	1359	1362	java/io/IOException
    //   888	895	1415	java/lang/Throwable
    //   913	919	1415	java/lang/Throwable
    //   929	942	1415	java/lang/Throwable
    //   969	976	1415	java/lang/Throwable
    //   989	996	1415	java/lang/Throwable
    //   1000	1014	1415	java/lang/Throwable
    //   1018	1024	1415	java/lang/Throwable
    //   1028	1076	1415	java/lang/Throwable
    //   1080	1090	1415	java/lang/Throwable
    //   1094	1100	1415	java/lang/Throwable
    //   1104	1111	1415	java/lang/Throwable
    //   1115	1125	1415	java/lang/Throwable
    //   1129	1143	1415	java/lang/Throwable
    //   1147	1156	1415	java/lang/Throwable
    //   1160	1165	1415	java/lang/Throwable
    //   1169	1176	1415	java/lang/Throwable
    //   1237	1243	1415	java/lang/Throwable
    //   1251	1259	1415	java/lang/Throwable
    //   1276	1285	1415	java/lang/Throwable
    //   1352	1359	1415	java/lang/Throwable
    //   888	895	1530	finally
    //   913	919	1530	finally
    //   929	942	1530	finally
    //   969	976	1530	finally
    //   989	996	1530	finally
    //   1000	1014	1530	finally
    //   1018	1024	1530	finally
    //   1028	1076	1530	finally
    //   1080	1090	1530	finally
    //   1094	1100	1530	finally
    //   1104	1111	1530	finally
    //   1115	1125	1530	finally
    //   1129	1143	1530	finally
    //   1147	1156	1530	finally
    //   1160	1165	1530	finally
    //   1169	1176	1530	finally
    //   1237	1243	1530	finally
    //   1251	1259	1530	finally
    //   1276	1285	1530	finally
    //   1295	1342	1530	finally
    //   1352	1359	1530	finally
    //   195	200	1579	finally
    //   219	229	1579	finally
    //   248	258	1579	finally
    //   277	287	1579	finally
    //   306	316	1579	finally
    //   335	348	1579	finally
    //   367	377	1579	finally
    //   400	411	1579	finally
    //   434	448	1579	finally
    //   578	588	1579	finally
    //   611	614	1579	finally
    //   631	644	1579	finally
    //   737	748	1579	finally
    //   771	778	1579	finally
    //   801	809	1579	finally
    //   824	830	1579	finally
    //   845	851	1579	finally
    //   866	884	1579	finally
    //   1401	1408	1579	finally
    //   1439	1478	1579	finally
    //   128	167	1594	finally
    //   167	176	1608	finally
    //   1295	1342	1619	java/lang/Throwable
    //   128	167	1628	java/lang/Throwable
    //   167	176	1648	java/lang/Throwable
    //   400	411	1665	java/lang/Throwable
    //   434	448	1665	java/lang/Throwable
    //   578	588	1665	java/lang/Throwable
    //   611	614	1665	java/lang/Throwable
    //   737	748	1665	java/lang/Throwable
    //   771	778	1665	java/lang/Throwable
    //   1401	1408	1665	java/lang/Throwable
    //   801	809	1674	java/lang/Throwable
    //   824	830	1674	java/lang/Throwable
    //   845	851	1674	java/lang/Throwable
    //   866	884	1674	java/lang/Throwable
    //   1295	1342	1683	java/io/IOException
    //   128	167	1692	java/io/IOException
    //   167	176	1712	java/io/IOException
    //   801	809	1729	java/io/IOException
    //   824	830	1729	java/io/IOException
    //   845	851	1729	java/io/IOException
    //   866	884	1729	java/io/IOException
    //   801	809	1738	java/io/FileNotFoundException
    //   824	830	1738	java/io/FileNotFoundException
    //   845	851	1738	java/io/FileNotFoundException
    //   866	884	1738	java/io/FileNotFoundException
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
    if (!paramString2.equals(lastApn)) {
      if ((paramInt != 1) && (!paramString2.equals(PkgTools.APN_TYPE_CMWAP))) {
        break label63;
      }
    }
    label63:
    for (forceDirect = false;; forceDirect = true)
    {
      lastApn = paramString2;
      if ((paramInt == 1) && (("10.0.0.172".equals(paramString1)) || ("10.0.0.200".equals(paramString1)))) {
        forceDirect = true;
      }
      return;
    }
  }
  
  private void setForceDirectByUseProxy(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean) {
      forceDirect = true;
    }
    while ((paramString == null) || (paramInt <= 0)) {
      return;
    }
    forceDirect = false;
  }
  
  public void addDownloadRequest(FaceInfo paramFaceInfo)
  {
    smartSetThreadCount(this.maxThreadCount);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDownloader", 2, "addDownloadRequest, info=" + paramFaceInfo);
    }
    HashSet localHashSet = this.mDownloadingUrlSet;
    if (paramFaceInfo != null) {}
    for (;;)
    {
      try
      {
        ??? = paramFaceInfo.c();
        if ((TextUtils.isEmpty((CharSequence)???)) || (this.mDownloadingUrlSet.contains(???)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.FaceDownloader", 2, "addDownloadRequest url repeat, info=" + paramFaceInfo + ",urlUniq=" + (String)???);
          }
          return;
        }
        this.mDownloadingUrlSet.add(???);
        synchronized (this.mRequestQueue)
        {
          this.mRequestQueue.add(paramFaceInfo);
          this.mRequestQueue.notify();
          return;
        }
        ??? = "";
      }
      finally {}
    }
  }
  
  public void addFaceDownloadListener(FaceDownloader.FaceDownloadListener paramFaceDownloadListener)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "addFaceDownloadListener l=" + paramFaceDownloadListener);
      }
      this.mDownloadListener.add(paramFaceDownloadListener);
      return;
    }
    finally {}
  }
  
  public void close()
  {
    if (this.mDownloadingUrlSet != null) {
      this.mDownloadingUrlSet.clear();
    }
    int i = 0;
    while (i < this.mDownRunnables.length)
    {
      if (this.mDownRunnables[i] != null) {
        this.mDownRunnables[i].close();
      }
      i += 1;
    }
    if (this.mRequestQueue != null) {
      synchronized (this.mRequestQueue)
      {
        this.mRequestQueue.clear();
        this.mRequestQueue.notifyAll();
        return;
      }
    }
  }
  
  protected abstract void doDownloadFace(FaceInfo paramFaceInfo);
  
  /* Error */
  public int downloadData(String paramString, File paramFile, FaceInfo paramFaceInfo, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 900	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   3: astore 6
    //   5: aload 6
    //   7: ifnonnull +14 -> 21
    //   10: ldc 26
    //   12: iconst_1
    //   13: ldc_w 902
    //   16: invokestatic 434	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: iconst_1
    //   20: ireturn
    //   21: new 497	java/net/URL
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 903	java/net/URL:<init>	(Ljava/lang/String;)V
    //   29: astore 7
    //   31: invokestatic 842	java/lang/System:currentTimeMillis	()J
    //   34: pop2
    //   35: new 4	java/lang/Object
    //   38: dup
    //   39: invokespecial 70	java/lang/Object:<init>	()V
    //   42: astore 8
    //   44: aload_0
    //   45: aload_2
    //   46: invokespecial 446	com/tencent/mobileqq/app/face/FaceDownloader:getParentFile	(Ljava/io/File;)V
    //   49: new 673	ardx
    //   52: dup
    //   53: aload_1
    //   54: aconst_null
    //   55: iconst_0
    //   56: invokespecial 906	ardx:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   59: astore 5
    //   61: new 908	org/apache/http/client/methods/HttpGet
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 909	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   69: pop
    //   70: new 404	java/io/File
    //   73: dup
    //   74: new 345	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   81: aload_2
    //   82: invokevirtual 912	java/io/File:getPath	()Ljava/lang/String;
    //   85: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc_w 914
    //   91: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 360	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 915	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: astore 9
    //   102: aload 9
    //   104: invokevirtual 407	java/io/File:exists	()Z
    //   107: ifeq +9 -> 116
    //   110: aload 9
    //   112: invokevirtual 449	java/io/File:delete	()Z
    //   115: pop
    //   116: aload_0
    //   117: aload_1
    //   118: aload_2
    //   119: aload_3
    //   120: iload 4
    //   122: aload 6
    //   124: aload 7
    //   126: iconst_5
    //   127: aload 8
    //   129: iconst_2
    //   130: aconst_null
    //   131: aload 5
    //   133: aload 9
    //   135: iconst_m1
    //   136: aconst_null
    //   137: invokespecial 917	com/tencent/mobileqq/app/face/FaceDownloader:realDownloadData	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;ZLandroid/net/NetworkInfo;Ljava/net/URL;ILjava/lang/Object;ILjava/io/OutputStream;Lardx;Ljava/io/File;ILjava/net/HttpURLConnection;)I
    //   140: ireturn
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 918	java/net/MalformedURLException:printStackTrace	()V
    //   146: bipush 13
    //   148: ireturn
    //   149: astore_1
    //   150: ldc 26
    //   152: iconst_1
    //   153: ldc_w 920
    //   156: invokestatic 578	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: iconst_4
    //   160: ireturn
    //   161: astore 9
    //   163: aload_1
    //   164: invokestatic 925	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   167: astore_1
    //   168: goto -98 -> 70
    //   171: astore_1
    //   172: ldc 26
    //   174: iconst_1
    //   175: ldc_w 927
    //   178: invokestatic 578	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload 5
    //   183: bipush 13
    //   185: putfield 715	ardx:b	I
    //   188: bipush 13
    //   190: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	FaceDownloader
    //   0	191	1	paramString	String
    //   0	191	2	paramFile	File
    //   0	191	3	paramFaceInfo	FaceInfo
    //   0	191	4	paramBoolean	boolean
    //   59	123	5	localardx	ardx
    //   3	120	6	localNetworkInfo	android.net.NetworkInfo
    //   29	96	7	localURL	URL
    //   42	86	8	localObject	Object
    //   100	34	9	localFile	File
    //   161	1	9	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   21	31	141	java/net/MalformedURLException
    //   44	49	149	java/lang/Exception
    //   61	70	161	java/lang/IllegalArgumentException
    //   163	168	171	java/lang/IllegalArgumentException
  }
  
  public abstract String getChoosedIP();
  
  public abstract String getChoosedStrangerGroupIp();
  
  protected int getFaceImageSize()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    int i = Math.min(localBaseApplicationImpl.getResources().getDisplayMetrics().widthPixels, localBaseApplicationImpl.getResources().getDisplayMetrics().heightPixels);
    if (i > 720) {}
    while (i >= 640) {
      return 140;
    }
    return 40;
  }
  
  public FaceDownloader.FaceDownloadThreadInfo getNearbyFaceDownloadThreadInfo()
  {
    FaceDownloader.FaceDownloadThreadInfo localFaceDownloadThreadInfo = new FaceDownloader.FaceDownloadThreadInfo(this);
    int i = Runtime.getRuntime().availableProcessors();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDownloader", 2, "processor count:" + i);
    }
    if (i >= 4) {}
    do
    {
      return localFaceDownloadThreadInfo;
      localFaceDownloadThreadInfo.maxThreadCount = (i + 1);
    } while (i > 2);
    localFaceDownloadThreadInfo.priority = 10;
    return localFaceDownloadThreadInfo;
  }
  
  public String getQQHeadDownloadUrl(FaceInfo paramFaceInfo, boolean paramBoolean)
  {
    if (paramFaceInfo.jdField_a_of_type_Int == 116) {
      return getQQHeadDownloadUrlApollo(paramFaceInfo);
    }
    paramFaceInfo = paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo;
    paramFaceInfo = MsfSdkUtils.insertMtype("QQHeadIcon", getQQHeandDownLoadUrl(paramFaceInfo.downLoadUrl, paramFaceInfo.dwFaceFlgas, paramFaceInfo.dstUsrType, paramFaceInfo.originUsrType, paramBoolean));
    return paramFaceInfo + "&t=" + System.currentTimeMillis();
  }
  
  public String getQQHeadDownloadUrlApollo(FaceInfo paramFaceInfo)
  {
    return paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.downLoadUrl + arid.a(paramFaceInfo.d) + "?t=" + paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.dwTimestamp;
  }
  
  public int getQQHeadImageSize(byte paramByte)
  {
    byte b3 = paramByte;
    if (paramByte == 0) {
      b3 = 1;
    }
    paramByte = 1 << this.mImageIndex;
    if ((paramByte & b3) == paramByte) {
      return this.mImageSize;
    }
    byte b2 = 0;
    paramByte = this.mImageIndex - 1;
    byte b1 = b2;
    if (paramByte >= 0)
    {
      b1 = (byte)(1 << paramByte);
      if ((b1 & b3) == b1) {
        b1 = 1;
      }
    }
    else
    {
      b2 = paramByte;
      if (b1 != 0) {
        break label168;
      }
      paramByte = this.mImageIndex + 1;
      b2 = paramByte;
      if (paramByte >= 8) {
        break label168;
      }
      b2 = (byte)(1 << paramByte);
      if ((b2 & b3) != b2) {
        break label147;
      }
      b1 = 1;
    }
    for (;;)
    {
      if (b1 != 0) {}
      switch (paramByte)
      {
      case 1: 
      default: 
        return 140;
        paramByte -= 1;
        break;
        paramByte += 1;
        break;
      case 0: 
        return 40;
      case 2: 
        return 100;
      case 3: 
        return 140;
      case 4: 
        label147:
        return 640;
        label168:
        paramByte = b2;
      }
    }
  }
  
  public String getQQHeandDownLoadUrl(String paramString, byte paramByte1, byte paramByte2, int paramInt)
  {
    return getQQHeandDownLoadUrl(paramString, paramByte1, paramByte2, paramInt, false);
  }
  
  public String getQQHeandDownLoadUrl(String paramString, byte paramByte1, byte paramByte2, int paramInt, boolean paramBoolean)
  {
    String str1 = "q.qlogo.cn";
    StringBuilder localStringBuilder;
    if (paramByte2 == 32) {
      if (paramInt == 1)
      {
        str1 = "q.qlogo.cn";
        String str2 = getIp(str1, paramBoolean);
        localStringBuilder = new StringBuilder("https://");
        if (TextUtils.isEmpty(str2)) {
          break label194;
        }
        localStringBuilder.append(str2);
        label60:
        int i = paramString.indexOf("/", 8);
        str1 = paramString;
        if (i > 8)
        {
          localStringBuilder.append(paramString.substring(i));
          str1 = localStringBuilder.toString();
        }
        if (paramByte2 != 32) {
          break label212;
        }
        if (paramInt != 1) {
          break label205;
        }
        paramByte2 = getQQHeadImageSize(paramByte1);
      }
    }
    for (;;)
    {
      return str1 + paramByte2;
      if (paramInt != 32) {
        break;
      }
      str1 = "p.qlogo.cn";
      break;
      if (paramByte2 == 16)
      {
        str1 = "p.qlogo.cn";
        break;
      }
      if ((paramByte2 == 4) || (paramByte2 == 8))
      {
        str1 = "p.qlogo.cn";
        break;
      }
      str1 = "q.qlogo.cn";
      break;
      label194:
      localStringBuilder.append(str1);
      break label60;
      label205:
      paramByte2 = 140;
      continue;
      label212:
      if (paramByte2 == 16) {
        paramByte2 = 224;
      } else {
        paramByte2 = getQQHeadImageSize(paramByte1);
      }
    }
  }
  
  protected boolean isIpv6()
  {
    if (!AppSetting.a()) {}
    int i;
    do
    {
      return false;
      i = NetConnInfoCenter.getActiveNetIpFamily(true);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "isIpv6, getActiveNetIpFamily = " + i);
      }
    } while ((i != 2) && (i != 3));
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDownloader", 2, "iisIpv6, true");
    }
    return true;
  }
  
  public void removeFaceDownloadListener(FaceDownloader.FaceDownloadListener paramFaceDownloadListener)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "removeFaceDownloadListener l=" + paramFaceDownloadListener);
      }
      this.mDownloadListener.remove(paramFaceDownloadListener);
      return;
    }
    finally {}
  }
  
  public Object[] setHttpConnAndUseProxy(String paramString1, int paramInt1, String paramString2, boolean paramBoolean, int paramInt2, String paramString3)
  {
    if ((paramString1 != null) && (paramInt1 > 0) && (!forceDirect)) {
      if ((paramString2.equals(PkgTools.APN_TYPE_CMWAP)) || (paramString2.equals(PkgTools.APN_TYPE_UNIWAP)) || (paramString2.equals(PkgTools.APN_TYPE_3GWAP))) {
        if ((Math.abs(paramInt2 % 2) == 1) && (DPC_WAP_DIRECT_CONNECT == 1))
        {
          paramString1 = (HttpURLConnection)new URL(paramString3).openConnection();
          paramBoolean = false;
          if (!QLog.isDevelopLevel()) {
            break label265;
          }
          QLog.i("Q.qqhead.FaceDownloader", 4, "downloadData, wapconn, DPC_WAP_DIRECT_CONNECT=" + DPC_WAP_DIRECT_CONNECT + ", tryCount=" + paramInt2);
        }
      }
    }
    label259:
    label265:
    for (;;)
    {
      label126:
      paramString1.setRequestProperty("Accept-Encoding", "identity");
      paramString1.setConnectTimeout(30000);
      paramString1.setReadTimeout(30000);
      paramString1.setInstanceFollowRedirects(true);
      if ((paramString1 instanceof HttpsURLConnection))
      {
        paramString2 = (HttpsURLConnection)paramString1;
        paramString3 = new URL(paramString3);
        if (paramInt2 != -1) {
          break label259;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        enableSNI(paramString2, paramString3, bool);
        return new Object[] { Boolean.valueOf(paramBoolean), paramString1 };
        paramString1 = PkgTools.getConnectionWithXOnlineHost(paramString3, paramString1, paramInt1);
        paramBoolean = true;
        break;
        paramString1 = PkgTools.getConnectionWithDefaultProxy(paramString3, paramString1, paramInt1);
        paramBoolean = true;
        break label126;
        paramString1 = (HttpURLConnection)new URL(paramString3).openConnection();
        break label126;
      }
    }
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
      if (i >= this.maxThreadCount) {}
    }
    try
    {
      for (;;)
      {
        arrayOfThread = this.mDownThreads;
        j = 0;
        for (;;)
        {
          if (j >= i) {
            break label180;
          }
          try
          {
            if (this.mDownThreads[j] == null)
            {
              this.mDownRunnables[j] = new FaceDownloader.FaceDownloadRunnable(this, j);
              this.mDownThreads[j] = ThreadManager.newFreeThread(this.mDownRunnables[j], "FaceDownloadThread", 5);
              this.mDownThreads[j].start();
              this.currThreadCount.incrementAndGet();
            }
            j += 1;
          }
          finally {}
        }
        i = this.maxThreadCount;
      }
      label180:
      if ((this.mDownRunnables == null) || (this.mDownRunnables.length <= 0) || (this.mDownRunnables[0] == null)) {
        QLog.e("Q.qqhead.FaceDownloader", 2, "smartSetThreadCount fail, MAX_THREAD_COUNT=" + this.maxThreadCount + ",newThreadCount=" + paramInt + ",currThreadCount=" + this.currThreadCount + ",idleThreadCount=" + this.idleThreadCount + ",queueSize=" + k);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Thread[] arrayOfThread;
      QLog.e("Q.qqhead.FaceDownloader", 1, "smartSetThreadCount", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDownloader
 * JD-Core Version:    0.7.0.1
 */