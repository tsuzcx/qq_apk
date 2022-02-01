package com.tencent.biz.richframework.download;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.utils.SdCardUtil;
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
  private static Handler sDownLoadHandler;
  private static OkHttpClient sOkHttpClient;
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
      RFLog.d("RFWDownloader", RFLog.USR, "checkResource listener is null");
      return;
    }
    if (getDownloadSP() == null)
    {
      RFLog.d("RFWDownloader", RFLog.USR, "checkResource getSp is null");
      return;
    }
    String str = getDownloadSP().getString(getResourceSPKey(paramString), "");
    boolean bool = isFileDownLoaded(paramString);
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkResource url:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" isDownloaded:");
    localStringBuilder.append(bool);
    localStringBuilder.append("  preMd5");
    localStringBuilder.append(str);
    RFLog.d("RFWDownloader", i, localStringBuilder.toString());
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
        int i;
        if (localObject != null)
        {
          ((RFWDownloader.RFWDownloadListener)localObject).onRspCallback(paramBoolean, paramString2);
          localConcurrentHashMap.remove(Integer.valueOf(localObject.hashCode()));
          i = RFLog.USR;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("downloadUrl:");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("finish ");
          ((StringBuilder)localObject).append(paramBoolean);
          RFLog.e("RFWDownloader", i, ((StringBuilder)localObject).toString());
        }
        else
        {
          i = RFLog.USR;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("downloadUrl:");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("  getFileListener release");
          RFLog.e("RFWDownloader", i, ((StringBuilder)localObject).toString());
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
      RFLog.e("RFWDownloader", RFLog.USR, new Object[] { paramRFWDownloadInfo, paramRFWDownloadInfo.getMessage() });
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
        int i = RFLog.DEV;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start unzip file to folderPath:");
        localStringBuilder.append((String)localObject);
        RFLog.d("RFWDownloader", i, localStringBuilder.toString());
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
    RFLog.i("RFWDownloader", RFLog.USR, "is not zip file, not need upzip");
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
    RFLog.d("RFWDownloader", RFLog.DEV, new Object[] { paramRFWDownloadInfo.getUrl(), paramVarArgs });
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
    //   1: invokevirtual 249	com/tencent/biz/richframework/download/RFWDownloadInfo:getUrl	()Ljava/lang/String;
    //   4: astore 12
    //   6: aload_1
    //   7: invokevirtual 387	com/tencent/biz/richframework/download/RFWDownloadInfo:getFilePath	()Ljava/lang/String;
    //   10: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +4 -> 17
    //   16: return
    //   17: new 266	java/io/File
    //   20: dup
    //   21: aload_1
    //   22: invokevirtual 269	com/tencent/biz/richframework/download/RFWDownloadInfo:getTmpFilePath	()Ljava/lang/String;
    //   25: invokespecial 272	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore 13
    //   30: aload 13
    //   32: invokevirtual 276	java/io/File:length	()J
    //   35: lstore 4
    //   37: aconst_null
    //   38: astore 9
    //   40: aconst_null
    //   41: astore 8
    //   43: aload 13
    //   45: invokevirtual 462	java/io/File:getParentFile	()Ljava/io/File;
    //   48: invokevirtual 465	java/io/File:exists	()Z
    //   51: ifne +12 -> 63
    //   54: aload 13
    //   56: invokevirtual 462	java/io/File:getParentFile	()Ljava/io/File;
    //   59: invokevirtual 468	java/io/File:mkdirs	()Z
    //   62: pop
    //   63: aload 13
    //   65: invokevirtual 465	java/io/File:exists	()Z
    //   68: ifne +9 -> 77
    //   71: aload 13
    //   73: invokevirtual 471	java/io/File:createNewFile	()Z
    //   76: pop
    //   77: aload_2
    //   78: invokevirtual 477	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   81: invokevirtual 482	okhttp3/ResponseBody:contentLength	()J
    //   84: lstore 6
    //   86: aload_1
    //   87: aload_2
    //   88: invokevirtual 477	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   91: invokevirtual 482	okhttp3/ResponseBody:contentLength	()J
    //   94: invokevirtual 486	com/tencent/biz/richframework/download/RFWDownloadInfo:setTotalContentLength	(J)V
    //   97: aload_2
    //   98: invokevirtual 477	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   101: invokevirtual 490	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   104: astore 10
    //   106: new 492	java/io/FileOutputStream
    //   109: dup
    //   110: aload 13
    //   112: aload_0
    //   113: getfield 51	com/tencent/biz/richframework/download/RFWDownloader:mDownloadStrategy	Lcom/tencent/biz/richframework/download/RFWDownloadStrategy;
    //   116: invokevirtual 264	com/tencent/biz/richframework/download/RFWDownloadStrategy:supportBreakPointDownload	()Z
    //   119: invokespecial 495	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   122: astore_2
    //   123: aload_2
    //   124: astore 8
    //   126: aload_2
    //   127: astore 9
    //   129: sipush 4096
    //   132: newarray byte
    //   134: astore 11
    //   136: aload_2
    //   137: astore 8
    //   139: aload_2
    //   140: astore 9
    //   142: aload 10
    //   144: aload 11
    //   146: invokevirtual 501	java/io/InputStream:read	([B)I
    //   149: istore_3
    //   150: iload_3
    //   151: iconst_m1
    //   152: if_icmpeq +56 -> 208
    //   155: aload_2
    //   156: astore 8
    //   158: aload_2
    //   159: astore 9
    //   161: aload_2
    //   162: aload 11
    //   164: iconst_0
    //   165: iload_3
    //   166: invokevirtual 507	java/io/OutputStream:write	([BII)V
    //   169: iload_3
    //   170: i2l
    //   171: lload 4
    //   173: ladd
    //   174: lstore 4
    //   176: aload_2
    //   177: astore 8
    //   179: aload_2
    //   180: astore 9
    //   182: aload_1
    //   183: lload 4
    //   185: invokevirtual 510	com/tencent/biz/richframework/download/RFWDownloadInfo:setDownloadedLength	(J)V
    //   188: lload 6
    //   190: lconst_0
    //   191: lcmp
    //   192: ifle +274 -> 466
    //   195: aload_0
    //   196: aload 12
    //   198: lload 4
    //   200: lload 6
    //   202: invokespecial 512	com/tencent/biz/richframework/download/RFWDownloader:dispatchDownloadProgress	(Ljava/lang/String;JJ)V
    //   205: goto +261 -> 466
    //   208: aload_2
    //   209: astore 8
    //   211: aload_0
    //   212: aload_1
    //   213: iconst_1
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: ldc_w 514
    //   222: aastore
    //   223: invokespecial 84	com/tencent/biz/richframework/download/RFWDownloader:logDownloadInfo	(Lcom/tencent/biz/richframework/download/RFWDownloadInfo;[Ljava/lang/Object;)V
    //   226: aload 8
    //   228: invokevirtual 517	java/io/OutputStream:flush	()V
    //   231: new 266	java/io/File
    //   234: dup
    //   235: aload_1
    //   236: invokevirtual 387	com/tencent/biz/richframework/download/RFWDownloadInfo:getFilePath	()Ljava/lang/String;
    //   239: invokespecial 272	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: astore 9
    //   244: aload 9
    //   246: invokevirtual 465	java/io/File:exists	()Z
    //   249: ifeq +9 -> 258
    //   252: aload 9
    //   254: invokevirtual 520	java/io/File:delete	()Z
    //   257: pop
    //   258: aload 13
    //   260: aload 9
    //   262: invokevirtual 524	java/io/File:renameTo	(Ljava/io/File;)Z
    //   265: pop
    //   266: aload_0
    //   267: aload_1
    //   268: invokespecial 526	com/tencent/biz/richframework/download/RFWDownloader:handleDownloadFile	(Lcom/tencent/biz/richframework/download/RFWDownloadInfo;)V
    //   271: iconst_2
    //   272: anewarray 528	java/io/Closeable
    //   275: dup
    //   276: iconst_0
    //   277: aload 10
    //   279: aastore
    //   280: dup
    //   281: iconst_1
    //   282: aload 8
    //   284: aastore
    //   285: invokestatic 534	com/tencent/biz/richframework/download/RFWDownloadUtil:closeAll	([Ljava/io/Closeable;)V
    //   288: goto +121 -> 409
    //   291: aload_2
    //   292: astore_1
    //   293: astore_2
    //   294: goto +26 -> 320
    //   297: aload_2
    //   298: astore_1
    //   299: astore_2
    //   300: goto +30 -> 330
    //   303: astore_2
    //   304: aload 8
    //   306: astore_1
    //   307: goto +13 -> 320
    //   310: astore_2
    //   311: aload 9
    //   313: astore_1
    //   314: goto +16 -> 330
    //   317: astore_2
    //   318: aconst_null
    //   319: astore_1
    //   320: aload 10
    //   322: astore 8
    //   324: goto +106 -> 430
    //   327: astore_2
    //   328: aconst_null
    //   329: astore_1
    //   330: aload_2
    //   331: astore 8
    //   333: aload 10
    //   335: astore_2
    //   336: goto +24 -> 360
    //   339: astore_2
    //   340: aconst_null
    //   341: astore_1
    //   342: aload 9
    //   344: astore 8
    //   346: goto +84 -> 430
    //   349: astore 9
    //   351: aconst_null
    //   352: astore_1
    //   353: aload 8
    //   355: astore_2
    //   356: aload 9
    //   358: astore 8
    //   360: ldc 14
    //   362: getstatic 107	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   365: iconst_2
    //   366: anewarray 4	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: aload 8
    //   373: invokevirtual 535	java/io/IOException:getMessage	()Ljava/lang/String;
    //   376: aastore
    //   377: dup
    //   378: iconst_1
    //   379: aload 8
    //   381: aastore
    //   382: invokestatic 440	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   385: aload_0
    //   386: aload 12
    //   388: iconst_0
    //   389: ldc 125
    //   391: invokespecial 96	com/tencent/biz/richframework/download/RFWDownloader:dispatchGetFileResult	(Ljava/lang/String;ZLjava/lang/String;)V
    //   394: iconst_2
    //   395: anewarray 528	java/io/Closeable
    //   398: dup
    //   399: iconst_0
    //   400: aload_2
    //   401: aastore
    //   402: dup
    //   403: iconst_1
    //   404: aload_1
    //   405: aastore
    //   406: invokestatic 534	com/tencent/biz/richframework/download/RFWDownloadUtil:closeAll	([Ljava/io/Closeable;)V
    //   409: aload_0
    //   410: getfield 49	com/tencent/biz/richframework/download/RFWDownloader:mDownloadingUrlSet	Ljava/util/Set;
    //   413: aload 12
    //   415: invokeinterface 537 2 0
    //   420: pop
    //   421: return
    //   422: astore 9
    //   424: aload_2
    //   425: astore 8
    //   427: aload 9
    //   429: astore_2
    //   430: iconst_2
    //   431: anewarray 528	java/io/Closeable
    //   434: dup
    //   435: iconst_0
    //   436: aload 8
    //   438: aastore
    //   439: dup
    //   440: iconst_1
    //   441: aload_1
    //   442: aastore
    //   443: invokestatic 534	com/tencent/biz/richframework/download/RFWDownloadUtil:closeAll	([Ljava/io/Closeable;)V
    //   446: aload_0
    //   447: getfield 49	com/tencent/biz/richframework/download/RFWDownloader:mDownloadingUrlSet	Ljava/util/Set;
    //   450: aload 12
    //   452: invokeinterface 537 2 0
    //   457: pop
    //   458: goto +5 -> 463
    //   461: aload_2
    //   462: athrow
    //   463: goto -2 -> 461
    //   466: goto -330 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	this	RFWDownloader
    //   0	469	1	paramRFWDownloadInfo	RFWDownloadInfo
    //   0	469	2	paramResponse	okhttp3.Response
    //   149	21	3	i	int
    //   35	164	4	l1	long
    //   84	117	6	l2	long
    //   41	396	8	localObject1	Object
    //   38	305	9	localObject2	Object
    //   349	8	9	localIOException	java.io.IOException
    //   422	6	9	localObject3	Object
    //   104	230	10	localInputStream	java.io.InputStream
    //   134	29	11	arrayOfByte	byte[]
    //   4	447	12	str	String
    //   28	231	13	localFile	File
    // Exception table:
    //   from	to	target	type
    //   195	205	291	finally
    //   211	258	291	finally
    //   258	271	291	finally
    //   195	205	297	java/io/IOException
    //   211	258	297	java/io/IOException
    //   258	271	297	java/io/IOException
    //   129	136	303	finally
    //   142	150	303	finally
    //   161	169	303	finally
    //   182	188	303	finally
    //   129	136	310	java/io/IOException
    //   142	150	310	java/io/IOException
    //   161	169	310	java/io/IOException
    //   182	188	310	java/io/IOException
    //   106	123	317	finally
    //   106	123	327	java/io/IOException
    //   43	63	339	finally
    //   63	77	339	finally
    //   77	106	339	finally
    //   43	63	349	java/io/IOException
    //   63	77	349	java/io/IOException
    //   77	106	349	java/io/IOException
    //   360	394	422	finally
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