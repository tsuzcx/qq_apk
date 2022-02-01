package com.tencent.biz.richframework.download;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;

public class RFWDownloader
{
  private static final String COS_MD5 = "X-COS-META-MD5";
  private static final int MAX_FILE_NAME_LENGTH = 251;
  private static final String TAG = "RFWDownloader";
  private static final String TMP_FILE_SUFFIX = ".tmp";
  private static volatile Handler sDownLoadHandler;
  private static volatile OkHttpClient sOkHttpClient;
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<RFWDownloader.RFWDownloadListener>>> mDownloadCenter;
  private ConcurrentHashMap<String, RFWDownloadInfo> mDownloadInfoMap;
  private RFWDownloadStrategy mDownloadStrategy;
  private Set<String> mDownloadingUrlSet = Collections.synchronizedSet(new HashSet());
  
  public RFWDownloader(RFWDownloadStrategy paramRFWDownloadStrategy)
  {
    this.mDownloadStrategy = paramRFWDownloadStrategy;
    this.mDownloadCenter = new ConcurrentHashMap();
    this.mDownloadInfoMap = new ConcurrentHashMap();
  }
  
  private void checkResource(String paramString, RFWCheckResourceListener paramRFWCheckResourceListener)
  {
    if (paramRFWCheckResourceListener == null)
    {
      QLog.d("RFWDownloader", 1, "checkResource listener is null");
      return;
    }
    if (getDownloadSP() == null)
    {
      QLog.d("RFWDownloader", 1, "checkResource getSp is null");
      return;
    }
    String str = getDownloadSP().getString(getResourceSPKey(paramString), "");
    boolean bool = isFileDownLoaded(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkResource url:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" isDownloaded:");
    localStringBuilder.append(bool);
    localStringBuilder.append("  preMd5");
    localStringBuilder.append(str);
    QLog.d("RFWDownloader", 1, localStringBuilder.toString());
    getOkHttpClient().newCall(getFileUpdateRequest(paramString)).enqueue(new RFWDownloader.4(this, paramString, paramRFWCheckResourceListener, bool, str));
  }
  
  private void dispatchDownloadProgress(String paramString, long paramLong1, long paramLong2)
  {
    paramString = (ConcurrentHashMap)this.mDownloadCenter.get(paramString);
    if (paramString == null) {
      return;
    }
    paramString = paramString.values().iterator();
    while (paramString.hasNext())
    {
      Object localObject = (WeakReference)paramString.next();
      if (localObject != null)
      {
        localObject = (RFWDownloader.RFWDownloadListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((RFWDownloader.RFWDownloadListener)localObject).onDownloadProgress((float)paramLong1 * 1.0F / (float)paramLong2, paramLong1, paramLong2);
        }
      }
    }
  }
  
  private void dispatchGetFileResult(String paramString1, boolean paramBoolean, String paramString2)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mDownloadCenter.get(paramString1);
    if (localConcurrentHashMap == null) {
      return;
    }
    Iterator localIterator = localConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      if (localObject != null)
      {
        localObject = (RFWDownloader.RFWDownloadListener)((WeakReference)localObject).get();
        if (localObject != null)
        {
          ((RFWDownloader.RFWDownloadListener)localObject).onRspCallback(paramBoolean, paramString2);
          localConcurrentHashMap.remove(Integer.valueOf(localObject.hashCode()));
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("downloadUrl:");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("finish ");
          ((StringBuilder)localObject).append(paramBoolean);
          QLog.e("RFWDownloader", 1, ((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("downloadUrl:");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("  getFileListener release");
          QLog.e("RFWDownloader", 1, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void downloadWithDownloadInfo(RFWDownloadInfo paramRFWDownloadInfo)
  {
    String str = paramRFWDownloadInfo.getUrl();
    Object localObject = new Request.Builder().url(paramRFWDownloadInfo.getUrl()).get();
    if (this.mDownloadStrategy.supportBreakPointDownload())
    {
      long l = new File(paramRFWDownloadInfo.getTmpFilePath()).length();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bytes=");
      localStringBuilder.append(l);
      localStringBuilder.append("-");
      ((Request.Builder)localObject).addHeader("RANGE", localStringBuilder.toString());
    }
    localObject = getOkHttpClient().newCall(((Request.Builder)localObject).build());
    try
    {
      ((Call)localObject).enqueue(new RFWDownloader.1(this, paramRFWDownloadInfo, SystemClock.uptimeMillis()));
      if (!this.mDownloadingUrlSet.contains(str))
      {
        this.mDownloadingUrlSet.add(str);
        return;
      }
    }
    catch (Exception paramRFWDownloadInfo)
    {
      paramRFWDownloadInfo.printStackTrace();
      QLog.e("RFWDownloader", 1, paramRFWDownloadInfo, new Object[] { paramRFWDownloadInfo.getMessage() });
    }
  }
  
  public static Handler getDownLoadHandler()
  {
    if (sDownLoadHandler == null) {
      try
      {
        if (sDownLoadHandler == null)
        {
          HandlerThread localHandlerThread = new HandlerThread("qcircle_download", 0);
          localHandlerThread.start();
          sDownLoadHandler = new Handler(localHandlerThread.getLooper());
        }
      }
      finally {}
    }
    return sDownLoadHandler;
  }
  
  private SharedPreferences getDownloadSP()
  {
    RFWDownloadStrategy localRFWDownloadStrategy = this.mDownloadStrategy;
    if (localRFWDownloadStrategy != null) {
      return localRFWDownloadStrategy.getSP();
    }
    return null;
  }
  
  private String getFileNameForKey(String paramString)
  {
    int i = paramString.length() / 2;
    int j = paramString.substring(0, i).hashCode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(j));
    localStringBuilder.append(String.valueOf(paramString.substring(i).hashCode()));
    return localStringBuilder.toString();
  }
  
  private Request getFileUpdateRequest(String paramString)
  {
    return new Request.Builder().url(paramString).head().build();
  }
  
  public static OkHttpClient getOkHttpClient()
  {
    if (sOkHttpClient == null) {
      try
      {
        if (sOkHttpClient == null) {
          sOkHttpClient = RFWOkHttpClientFactory.createDeFaultOKHttpClient();
        }
      }
      finally {}
    }
    return sOkHttpClient;
  }
  
  private String getPreMd5(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mDownloadStrategy.getSP() == null) {
        return "";
      }
      return this.mDownloadStrategy.getSP().getString(getResourceSPKey(paramString), "");
    }
    return "";
  }
  
  private String getResourceSPKey(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("X-COS-META-MD5");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private String getTmpSavePath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getDefaultSavePath(paramString));
    localStringBuilder.append(".tmp");
    return localStringBuilder.toString();
  }
  
  private void handleDownloadFile(RFWDownloadInfo paramRFWDownloadInfo)
  {
    String str1 = paramRFWDownloadInfo.getUrl();
    String str2 = paramRFWDownloadInfo.getFilePath();
    if (isZipFile(str1)) {
      try
      {
        localObject = getContentFilePath(str1);
        File localFile = new File(paramRFWDownloadInfo.getFilePath());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start unzip file to folderPath:");
        localStringBuilder.append((String)localObject);
        QLog.d("RFWDownloader", 4, localStringBuilder.toString());
        ZipUtils.unZipFile(localFile, (String)localObject);
        logDownloadInfo(paramRFWDownloadInfo, new Object[] { "unZip success" });
        updateFileMd5(str1, str2);
        dispatchGetFileResult(str1, true, (String)localObject);
        return;
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unZip failed");
        ((StringBuilder)localObject).append(localException.getMessage());
        logDownloadInfo(paramRFWDownloadInfo, new Object[] { ((StringBuilder)localObject).toString() });
        dispatchGetFileResult(str1, false, "");
        return;
      }
    }
    QLog.i("RFWDownloader", 1, "is not zip file, not need upzip");
    updateFileMd5(str1, localException);
    dispatchGetFileResult(str1, true, paramRFWDownloadInfo.getFilePath());
  }
  
  private RFWDownloadInfo initDownloadInfo(String paramString)
  {
    RFWDownloadInfo localRFWDownloadInfo = new RFWDownloadInfo();
    localRFWDownloadInfo.setUrl(paramString);
    localRFWDownloadInfo.setFilePath(getDefaultSavePath(paramString));
    localRFWDownloadInfo.setTmpFilePath(getTmpSavePath(paramString));
    this.mDownloadInfoMap.put(paramString, localRFWDownloadInfo);
    return localRFWDownloadInfo;
  }
  
  private boolean isZipFile(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.endsWith(".zip"));
  }
  
  private void logDownloadInfo(RFWDownloadInfo paramRFWDownloadInfo, Object... paramVarArgs)
  {
    QLog.d("RFWDownloader", 4, new Object[] { paramRFWDownloadInfo.getUrl(), paramVarArgs });
  }
  
  private void registerEachListener(String paramString, RFWDownloader.RFWDownloadListener paramRFWDownloadListener)
  {
    if (paramRFWDownloadListener == null) {
      return;
    }
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.mDownloadCenter.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramRFWDownloadListener.hashCode()), new WeakReference(paramRFWDownloadListener));
    this.mDownloadCenter.put(paramString, localConcurrentHashMap1);
  }
  
  private void updateFileMd5(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (getDownloadSP() != null)) {
      getDownloadSP().edit().putString(getResourceSPKey(paramString1), paramString2).apply();
    }
  }
  
  /* Error */
  private void writeFileFromResponse(RFWDownloadInfo paramRFWDownloadInfo, okhttp3.Response paramResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 246	com/tencent/biz/richframework/download/RFWDownloadInfo:getUrl	()Ljava/lang/String;
    //   4: astore 12
    //   6: aload_1
    //   7: invokevirtual 384	com/tencent/biz/richframework/download/RFWDownloadInfo:getFilePath	()Ljava/lang/String;
    //   10: invokestatic 376	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +4 -> 17
    //   16: return
    //   17: new 263	java/io/File
    //   20: dup
    //   21: aload_1
    //   22: invokevirtual 266	com/tencent/biz/richframework/download/RFWDownloadInfo:getTmpFilePath	()Ljava/lang/String;
    //   25: invokespecial 269	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore 13
    //   30: aload 13
    //   32: invokevirtual 273	java/io/File:length	()J
    //   35: lstore 4
    //   37: aconst_null
    //   38: astore 8
    //   40: aload 13
    //   42: invokevirtual 457	java/io/File:getParentFile	()Ljava/io/File;
    //   45: invokevirtual 460	java/io/File:exists	()Z
    //   48: ifne +12 -> 60
    //   51: aload 13
    //   53: invokevirtual 457	java/io/File:getParentFile	()Ljava/io/File;
    //   56: invokevirtual 463	java/io/File:mkdirs	()Z
    //   59: pop
    //   60: aload 13
    //   62: invokevirtual 460	java/io/File:exists	()Z
    //   65: ifne +9 -> 74
    //   68: aload 13
    //   70: invokevirtual 466	java/io/File:createNewFile	()Z
    //   73: pop
    //   74: aload_2
    //   75: invokevirtual 472	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   78: invokevirtual 477	okhttp3/ResponseBody:contentLength	()J
    //   81: lstore 6
    //   83: aload_1
    //   84: aload_2
    //   85: invokevirtual 472	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   88: invokevirtual 477	okhttp3/ResponseBody:contentLength	()J
    //   91: invokevirtual 481	com/tencent/biz/richframework/download/RFWDownloadInfo:setTotalContentLength	(J)V
    //   94: aload_2
    //   95: invokevirtual 472	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   98: invokevirtual 485	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   101: astore 10
    //   103: new 487	java/io/FileOutputStream
    //   106: dup
    //   107: aload 13
    //   109: aload_0
    //   110: getfield 51	com/tencent/biz/richframework/download/RFWDownloader:mDownloadStrategy	Lcom/tencent/biz/richframework/download/RFWDownloadStrategy;
    //   113: invokevirtual 261	com/tencent/biz/richframework/download/RFWDownloadStrategy:supportBreakPointDownload	()Z
    //   116: invokespecial 490	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   119: astore_2
    //   120: aload_2
    //   121: astore 8
    //   123: aload_2
    //   124: astore 9
    //   126: sipush 4096
    //   129: newarray byte
    //   131: astore 11
    //   133: aload_2
    //   134: astore 8
    //   136: aload_2
    //   137: astore 9
    //   139: aload 10
    //   141: aload 11
    //   143: invokevirtual 496	java/io/InputStream:read	([B)I
    //   146: istore_3
    //   147: iload_3
    //   148: iconst_m1
    //   149: if_icmpeq +56 -> 205
    //   152: aload_2
    //   153: astore 8
    //   155: aload_2
    //   156: astore 9
    //   158: aload_2
    //   159: aload 11
    //   161: iconst_0
    //   162: iload_3
    //   163: invokevirtual 502	java/io/OutputStream:write	([BII)V
    //   166: iload_3
    //   167: i2l
    //   168: lload 4
    //   170: ladd
    //   171: lstore 4
    //   173: aload_2
    //   174: astore 8
    //   176: aload_2
    //   177: astore 9
    //   179: aload_1
    //   180: lload 4
    //   182: invokevirtual 505	com/tencent/biz/richframework/download/RFWDownloadInfo:setDownloadedLength	(J)V
    //   185: lload 6
    //   187: lconst_0
    //   188: lcmp
    //   189: ifle +270 -> 459
    //   192: aload_0
    //   193: aload 12
    //   195: lload 4
    //   197: lload 6
    //   199: invokespecial 507	com/tencent/biz/richframework/download/RFWDownloader:dispatchDownloadProgress	(Ljava/lang/String;JJ)V
    //   202: goto +257 -> 459
    //   205: aload_2
    //   206: astore 8
    //   208: aload_0
    //   209: aload_1
    //   210: iconst_1
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: ldc_w 509
    //   219: aastore
    //   220: invokespecial 84	com/tencent/biz/richframework/download/RFWDownloader:logDownloadInfo	(Lcom/tencent/biz/richframework/download/RFWDownloadInfo;[Ljava/lang/Object;)V
    //   223: aload 8
    //   225: invokevirtual 512	java/io/OutputStream:flush	()V
    //   228: new 263	java/io/File
    //   231: dup
    //   232: aload_1
    //   233: invokevirtual 384	com/tencent/biz/richframework/download/RFWDownloadInfo:getFilePath	()Ljava/lang/String;
    //   236: invokespecial 269	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: astore 9
    //   241: aload 9
    //   243: invokevirtual 460	java/io/File:exists	()Z
    //   246: ifeq +9 -> 255
    //   249: aload 9
    //   251: invokevirtual 515	java/io/File:delete	()Z
    //   254: pop
    //   255: aload 13
    //   257: aload 9
    //   259: invokevirtual 519	java/io/File:renameTo	(Ljava/io/File;)Z
    //   262: pop
    //   263: aload_0
    //   264: aload_1
    //   265: invokespecial 521	com/tencent/biz/richframework/download/RFWDownloader:handleDownloadFile	(Lcom/tencent/biz/richframework/download/RFWDownloadInfo;)V
    //   268: iconst_2
    //   269: anewarray 523	java/io/Closeable
    //   272: dup
    //   273: iconst_0
    //   274: aload 10
    //   276: aastore
    //   277: dup
    //   278: iconst_1
    //   279: aload 8
    //   281: aastore
    //   282: invokestatic 529	com/tencent/biz/richframework/download/RFWDownloadUtil:closeAll	([Ljava/io/Closeable;)V
    //   285: goto +115 -> 400
    //   288: astore_1
    //   289: aload 10
    //   291: astore 8
    //   293: goto +130 -> 423
    //   296: aload_2
    //   297: astore_1
    //   298: astore_2
    //   299: goto +34 -> 333
    //   302: astore_1
    //   303: aload 8
    //   305: astore_2
    //   306: aload 10
    //   308: astore 8
    //   310: goto +113 -> 423
    //   313: astore_2
    //   314: aload 9
    //   316: astore_1
    //   317: goto +16 -> 333
    //   320: astore_1
    //   321: aconst_null
    //   322: astore_2
    //   323: aload 10
    //   325: astore 8
    //   327: goto +96 -> 423
    //   330: astore_2
    //   331: aconst_null
    //   332: astore_1
    //   333: aload_2
    //   334: astore 8
    //   336: aload 10
    //   338: astore_2
    //   339: goto +24 -> 363
    //   342: astore_1
    //   343: aconst_null
    //   344: astore 8
    //   346: aload 8
    //   348: astore_2
    //   349: goto +74 -> 423
    //   352: astore 9
    //   354: aconst_null
    //   355: astore_1
    //   356: aload 8
    //   358: astore_2
    //   359: aload 9
    //   361: astore 8
    //   363: ldc 14
    //   365: iconst_1
    //   366: aload 8
    //   368: invokevirtual 530	java/io/IOException:getMessage	()Ljava/lang/String;
    //   371: aload 8
    //   373: invokestatic 533	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   376: aload_0
    //   377: aload 12
    //   379: iconst_0
    //   380: ldc 122
    //   382: invokespecial 96	com/tencent/biz/richframework/download/RFWDownloader:dispatchGetFileResult	(Ljava/lang/String;ZLjava/lang/String;)V
    //   385: iconst_2
    //   386: anewarray 523	java/io/Closeable
    //   389: dup
    //   390: iconst_0
    //   391: aload_2
    //   392: aastore
    //   393: dup
    //   394: iconst_1
    //   395: aload_1
    //   396: aastore
    //   397: invokestatic 529	com/tencent/biz/richframework/download/RFWDownloadUtil:closeAll	([Ljava/io/Closeable;)V
    //   400: aload_0
    //   401: getfield 49	com/tencent/biz/richframework/download/RFWDownloader:mDownloadingUrlSet	Ljava/util/Set;
    //   404: aload 12
    //   406: invokeinterface 535 2 0
    //   411: pop
    //   412: return
    //   413: astore 9
    //   415: aload_2
    //   416: astore 8
    //   418: aload_1
    //   419: astore_2
    //   420: aload 9
    //   422: astore_1
    //   423: iconst_2
    //   424: anewarray 523	java/io/Closeable
    //   427: dup
    //   428: iconst_0
    //   429: aload 8
    //   431: aastore
    //   432: dup
    //   433: iconst_1
    //   434: aload_2
    //   435: aastore
    //   436: invokestatic 529	com/tencent/biz/richframework/download/RFWDownloadUtil:closeAll	([Ljava/io/Closeable;)V
    //   439: aload_0
    //   440: getfield 49	com/tencent/biz/richframework/download/RFWDownloader:mDownloadingUrlSet	Ljava/util/Set;
    //   443: aload 12
    //   445: invokeinterface 535 2 0
    //   450: pop
    //   451: goto +5 -> 456
    //   454: aload_1
    //   455: athrow
    //   456: goto -2 -> 454
    //   459: goto -326 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	RFWDownloader
    //   0	462	1	paramRFWDownloadInfo	RFWDownloadInfo
    //   0	462	2	paramResponse	okhttp3.Response
    //   146	21	3	i	int
    //   35	161	4	l1	long
    //   81	117	6	l2	long
    //   38	392	8	localObject1	Object
    //   124	191	9	localObject2	Object
    //   352	8	9	localIOException	java.io.IOException
    //   413	8	9	localObject3	Object
    //   101	236	10	localInputStream	java.io.InputStream
    //   131	29	11	arrayOfByte	byte[]
    //   4	440	12	str	String
    //   28	228	13	localFile	File
    // Exception table:
    //   from	to	target	type
    //   192	202	288	finally
    //   208	255	288	finally
    //   255	268	288	finally
    //   192	202	296	java/io/IOException
    //   208	255	296	java/io/IOException
    //   255	268	296	java/io/IOException
    //   126	133	302	finally
    //   139	147	302	finally
    //   158	166	302	finally
    //   179	185	302	finally
    //   126	133	313	java/io/IOException
    //   139	147	313	java/io/IOException
    //   158	166	313	java/io/IOException
    //   179	185	313	java/io/IOException
    //   103	120	320	finally
    //   103	120	330	java/io/IOException
    //   40	60	342	finally
    //   60	74	342	finally
    //   74	103	342	finally
    //   40	60	352	java/io/IOException
    //   60	74	352	java/io/IOException
    //   74	103	352	java/io/IOException
    //   363	385	413	finally
  }
  
  public void download(String paramString)
  {
    download(paramString, null);
  }
  
  public void download(String paramString, RFWDownloader.RFWDownloadListener paramRFWDownloadListener)
  {
    if (getDownLoadHandler() != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      getDownLoadHandler().post(new RFWDownloader.2(this, paramString, paramRFWDownloadListener));
    }
  }
  
  public void downloadOrUpdateFile(String paramString, RFWDownloader.RFWDownloadListener paramRFWDownloadListener)
  {
    if (getDownLoadHandler() != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      getDownLoadHandler().post(new RFWDownloader.3(this, paramRFWDownloadListener, paramString));
    }
  }
  
  public String getContentFilePath(String paramString)
  {
    if (isZipFile(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mDownloadStrategy.getDownloadRootPath());
      localStringBuilder.append(getFileNameForKey(paramString));
      localStringBuilder.append(File.separator);
      return localStringBuilder.toString();
    }
    return getDefaultSavePath(paramString);
  }
  
  public String getDefaultSavePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(this.mDownloadStrategy.getDownloadRootPath());
      localStringBuilder2.append(str);
      str = localStringBuilder2.toString();
      int i = str.length();
      int j = MAX_FILE_NAME_LENGTH;
      if (i <= j) {
        return str;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(this.mDownloadStrategy.getDownloadRootPath());
      localStringBuilder1.append(getFileNameForKey(paramString));
      localStringBuilder1.append(File.separator);
      localStringBuilder1.append(RFWDownloadUtil.getFileNameFromUrl(paramString));
      return localStringBuilder1.toString();
    }
  }
  
  public boolean isFileDownLoaded(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramString = new File(getContentFilePath(paramString));
    if (SdCardUtil.getSdCardDirectory() == null) {
      return false;
    }
    bool1 = bool2;
    if (paramString.exists()) {
      if (!paramString.isFile())
      {
        bool1 = bool2;
        if (paramString.isDirectory())
        {
          bool1 = bool2;
          if (paramString.listFiles() != null)
          {
            bool1 = bool2;
            if (paramString.listFiles().length <= 0) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isFileDownLoading(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return this.mDownloadingUrlSet.contains(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader
 * JD-Core Version:    0.7.0.1
 */