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
  private static final int MAX_FILE_NAME_LENGTH = 255 - ".tmp".length();
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
    RFLog.d("RFWDownloader", RFLog.USR, "checkResource url:" + paramString + " isDownloaded:" + bool + "  preMd5" + str);
    getOkHttpClient().newCall(getFileUpdateRequest(paramString)).enqueue(new RFWDownloader.4(this, paramString, paramRFWCheckResourceListener, bool, str));
  }
  
  private void dispatchDownloadProgress(String paramString, long paramLong1, long paramLong2)
  {
    paramString = (ConcurrentHashMap)this.mDownloadCenter.get(paramString);
    if (paramString == null) {}
    for (;;)
    {
      return;
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
  }
  
  private void dispatchGetFileResult(String paramString1, boolean paramBoolean, String paramString2)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mDownloadCenter.get(paramString1);
    if (localConcurrentHashMap == null) {}
    for (;;)
    {
      return;
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
            RFLog.e("RFWDownloader", RFLog.USR, "downloadUrl:" + paramString1 + "finish " + paramBoolean);
          }
          else
          {
            RFLog.e("RFWDownloader", RFLog.USR, "downloadUrl:" + paramString1 + "  getFileListener release");
          }
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
      ((Request.Builder)localObject).addHeader("RANGE", "bytes=" + l + "-");
    }
    localObject = getOkHttpClient().newCall(((Request.Builder)localObject).build());
    try
    {
      ((Call)localObject).enqueue(new RFWDownloader.1(this, paramRFWDownloadInfo, SystemClock.uptimeMillis()));
      if (!this.mDownloadingUrlSet.contains(str)) {
        this.mDownloadingUrlSet.add(str);
      }
      return;
    }
    catch (Exception paramRFWDownloadInfo)
    {
      paramRFWDownloadInfo.printStackTrace();
      RFLog.e("RFWDownloader", RFLog.USR, new Object[] { paramRFWDownloadInfo, paramRFWDownloadInfo.getMessage() });
    }
  }
  
  public static Handler getDownLoadHandler()
  {
    if (sDownLoadHandler == null) {}
    try
    {
      if (sDownLoadHandler == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("qcircle_download", 0);
        localHandlerThread.start();
        sDownLoadHandler = new Handler(localHandlerThread.getLooper());
      }
      return sDownLoadHandler;
    }
    finally {}
  }
  
  private SharedPreferences getDownloadSP()
  {
    if (this.mDownloadStrategy != null) {
      return this.mDownloadStrategy.getSP();
    }
    return null;
  }
  
  private String getFileNameForKey(String paramString)
  {
    int i = paramString.length() / 2;
    int j = paramString.substring(0, i).hashCode();
    return String.valueOf(j) + String.valueOf(paramString.substring(i).hashCode());
  }
  
  private Request getFileUpdateRequest(String paramString)
  {
    return new Request.Builder().url(paramString).head().build();
  }
  
  public static OkHttpClient getOkHttpClient()
  {
    if (sOkHttpClient == null) {}
    try
    {
      if (sOkHttpClient == null) {
        sOkHttpClient = RFWOkHttpClientFactory.createDeFaultOKHttpClient();
      }
      return sOkHttpClient;
    }
    finally {}
  }
  
  private String getPreMd5(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.mDownloadStrategy.getSP() == null)) {
      return "";
    }
    return this.mDownloadStrategy.getSP().getString(getResourceSPKey(paramString), "");
  }
  
  private String getResourceSPKey(String paramString)
  {
    return "X-COS-META-MD5" + paramString;
  }
  
  private String getTmpSavePath(String paramString)
  {
    return getDefaultSavePath(paramString) + ".tmp";
  }
  
  private void handleDownloadFile(RFWDownloadInfo paramRFWDownloadInfo)
  {
    String str1 = paramRFWDownloadInfo.getUrl();
    String str2 = paramRFWDownloadInfo.getFilePath();
    if (isZipFile(str1)) {
      try
      {
        String str3 = getContentFilePath(str1);
        File localFile = new File(paramRFWDownloadInfo.getFilePath());
        RFLog.d("RFWDownloader", RFLog.DEV, "start unzip file to folderPath:" + str3);
        ZipUtils.unZipFile(localFile, str3);
        logDownloadInfo(paramRFWDownloadInfo, new Object[] { "unZip success" });
        updateFileMd5(str1, str2);
        dispatchGetFileResult(str1, true, str3);
        return;
      }
      catch (Exception localException)
      {
        logDownloadInfo(paramRFWDownloadInfo, new Object[] { "unZip failed" + localException.getMessage() });
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
    //   0: aconst_null
    //   1: astore 15
    //   3: aconst_null
    //   4: astore 14
    //   6: aconst_null
    //   7: astore 16
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 12
    //   15: aload_1
    //   16: invokevirtual 255	com/tencent/biz/richframework/download/RFWDownloadInfo:getUrl	()Ljava/lang/String;
    //   19: astore 17
    //   21: aload_1
    //   22: invokevirtual 388	com/tencent/biz/richframework/download/RFWDownloadInfo:getFilePath	()Ljava/lang/String;
    //   25: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +4 -> 32
    //   31: return
    //   32: new 272	java/io/File
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual 275	com/tencent/biz/richframework/download/RFWDownloadInfo:getTmpFilePath	()Ljava/lang/String;
    //   40: invokespecial 278	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore 18
    //   45: aload 18
    //   47: invokevirtual 281	java/io/File:length	()J
    //   50: lstore 4
    //   52: aload 16
    //   54: astore 10
    //   56: aload 15
    //   58: astore 11
    //   60: aload 18
    //   62: invokevirtual 463	java/io/File:getParentFile	()Ljava/io/File;
    //   65: invokevirtual 466	java/io/File:exists	()Z
    //   68: ifne +20 -> 88
    //   71: aload 16
    //   73: astore 10
    //   75: aload 15
    //   77: astore 11
    //   79: aload 18
    //   81: invokevirtual 463	java/io/File:getParentFile	()Ljava/io/File;
    //   84: invokevirtual 469	java/io/File:mkdirs	()Z
    //   87: pop
    //   88: aload 16
    //   90: astore 10
    //   92: aload 15
    //   94: astore 11
    //   96: aload 18
    //   98: invokevirtual 466	java/io/File:exists	()Z
    //   101: ifne +17 -> 118
    //   104: aload 16
    //   106: astore 10
    //   108: aload 15
    //   110: astore 11
    //   112: aload 18
    //   114: invokevirtual 472	java/io/File:createNewFile	()Z
    //   117: pop
    //   118: aload 16
    //   120: astore 10
    //   122: aload 15
    //   124: astore 11
    //   126: aload_2
    //   127: invokevirtual 478	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   130: invokevirtual 483	okhttp3/ResponseBody:contentLength	()J
    //   133: lstore 8
    //   135: aload 16
    //   137: astore 10
    //   139: aload 15
    //   141: astore 11
    //   143: aload_1
    //   144: aload_2
    //   145: invokevirtual 478	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   148: invokevirtual 483	okhttp3/ResponseBody:contentLength	()J
    //   151: invokevirtual 487	com/tencent/biz/richframework/download/RFWDownloadInfo:setTotalContentLength	(J)V
    //   154: aload 16
    //   156: astore 10
    //   158: aload 15
    //   160: astore 11
    //   162: aload_2
    //   163: invokevirtual 478	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   166: invokevirtual 491	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   169: astore_2
    //   170: new 493	java/io/FileOutputStream
    //   173: dup
    //   174: aload 18
    //   176: aload_0
    //   177: getfield 58	com/tencent/biz/richframework/download/RFWDownloader:mDownloadStrategy	Lcom/tencent/biz/richframework/download/RFWDownloadStrategy;
    //   180: invokevirtual 270	com/tencent/biz/richframework/download/RFWDownloadStrategy:supportBreakPointDownload	()Z
    //   183: invokespecial 496	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   186: astore 10
    //   188: sipush 4096
    //   191: newarray byte
    //   193: astore 11
    //   195: aload_2
    //   196: aload 11
    //   198: invokevirtual 502	java/io/InputStream:read	([B)I
    //   201: istore_3
    //   202: iload_3
    //   203: iconst_m1
    //   204: if_icmpeq +139 -> 343
    //   207: aload 10
    //   209: aload 11
    //   211: iconst_0
    //   212: iload_3
    //   213: invokevirtual 508	java/io/OutputStream:write	([BII)V
    //   216: lload 4
    //   218: iload_3
    //   219: i2l
    //   220: ladd
    //   221: lstore 6
    //   223: aload_1
    //   224: lload 6
    //   226: invokevirtual 511	com/tencent/biz/richframework/download/RFWDownloadInfo:setDownloadedLength	(J)V
    //   229: lload 6
    //   231: lstore 4
    //   233: lload 8
    //   235: lconst_0
    //   236: lcmp
    //   237: ifle -42 -> 195
    //   240: aload_0
    //   241: aload 17
    //   243: lload 6
    //   245: lload 8
    //   247: invokespecial 513	com/tencent/biz/richframework/download/RFWDownloader:dispatchDownloadProgress	(Ljava/lang/String;JJ)V
    //   250: lload 6
    //   252: lstore 4
    //   254: goto -59 -> 195
    //   257: astore 11
    //   259: aload_2
    //   260: astore_1
    //   261: aload 10
    //   263: astore 12
    //   265: aload 11
    //   267: astore_2
    //   268: aload 12
    //   270: astore 10
    //   272: aload_1
    //   273: astore 11
    //   275: ldc 13
    //   277: getstatic 114	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   280: iconst_2
    //   281: anewarray 4	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: aload_2
    //   287: invokevirtual 514	java/io/IOException:getMessage	()Ljava/lang/String;
    //   290: aastore
    //   291: dup
    //   292: iconst_1
    //   293: aload_2
    //   294: aastore
    //   295: invokestatic 441	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   298: aload 12
    //   300: astore 10
    //   302: aload_1
    //   303: astore 11
    //   305: aload_0
    //   306: aload 17
    //   308: iconst_0
    //   309: ldc 132
    //   311: invokespecial 103	com/tencent/biz/richframework/download/RFWDownloader:dispatchGetFileResult	(Ljava/lang/String;ZLjava/lang/String;)V
    //   314: iconst_2
    //   315: anewarray 516	java/io/Closeable
    //   318: dup
    //   319: iconst_0
    //   320: aload_1
    //   321: aastore
    //   322: dup
    //   323: iconst_1
    //   324: aload 12
    //   326: aastore
    //   327: invokestatic 522	com/tencent/biz/richframework/download/RFWDownloadUtil:closeAll	([Ljava/io/Closeable;)V
    //   330: aload_0
    //   331: getfield 56	com/tencent/biz/richframework/download/RFWDownloader:mDownloadingUrlSet	Ljava/util/Set;
    //   334: aload 17
    //   336: invokeinterface 524 2 0
    //   341: pop
    //   342: return
    //   343: aload_0
    //   344: aload_1
    //   345: iconst_1
    //   346: anewarray 4	java/lang/Object
    //   349: dup
    //   350: iconst_0
    //   351: ldc_w 526
    //   354: aastore
    //   355: invokespecial 91	com/tencent/biz/richframework/download/RFWDownloader:logDownloadInfo	(Lcom/tencent/biz/richframework/download/RFWDownloadInfo;[Ljava/lang/Object;)V
    //   358: aload 10
    //   360: invokevirtual 529	java/io/OutputStream:flush	()V
    //   363: new 272	java/io/File
    //   366: dup
    //   367: aload_1
    //   368: invokevirtual 388	com/tencent/biz/richframework/download/RFWDownloadInfo:getFilePath	()Ljava/lang/String;
    //   371: invokespecial 278	java/io/File:<init>	(Ljava/lang/String;)V
    //   374: astore 11
    //   376: aload 11
    //   378: invokevirtual 466	java/io/File:exists	()Z
    //   381: ifeq +9 -> 390
    //   384: aload 11
    //   386: invokevirtual 532	java/io/File:delete	()Z
    //   389: pop
    //   390: aload 18
    //   392: aload 11
    //   394: invokevirtual 536	java/io/File:renameTo	(Ljava/io/File;)Z
    //   397: pop
    //   398: aload_0
    //   399: aload_1
    //   400: invokespecial 538	com/tencent/biz/richframework/download/RFWDownloader:handleDownloadFile	(Lcom/tencent/biz/richframework/download/RFWDownloadInfo;)V
    //   403: iconst_2
    //   404: anewarray 516	java/io/Closeable
    //   407: dup
    //   408: iconst_0
    //   409: aload_2
    //   410: aastore
    //   411: dup
    //   412: iconst_1
    //   413: aload 10
    //   415: aastore
    //   416: invokestatic 522	com/tencent/biz/richframework/download/RFWDownloadUtil:closeAll	([Ljava/io/Closeable;)V
    //   419: aload_0
    //   420: getfield 56	com/tencent/biz/richframework/download/RFWDownloader:mDownloadingUrlSet	Ljava/util/Set;
    //   423: aload 17
    //   425: invokeinterface 524 2 0
    //   430: pop
    //   431: return
    //   432: astore_1
    //   433: iconst_2
    //   434: anewarray 516	java/io/Closeable
    //   437: dup
    //   438: iconst_0
    //   439: aload 11
    //   441: aastore
    //   442: dup
    //   443: iconst_1
    //   444: aload 10
    //   446: aastore
    //   447: invokestatic 522	com/tencent/biz/richframework/download/RFWDownloadUtil:closeAll	([Ljava/io/Closeable;)V
    //   450: aload_0
    //   451: getfield 56	com/tencent/biz/richframework/download/RFWDownloader:mDownloadingUrlSet	Ljava/util/Set;
    //   454: aload 17
    //   456: invokeinterface 524 2 0
    //   461: pop
    //   462: aload_1
    //   463: athrow
    //   464: astore_1
    //   465: aload 13
    //   467: astore 10
    //   469: aload_2
    //   470: astore 11
    //   472: goto -39 -> 433
    //   475: astore_1
    //   476: aload_2
    //   477: astore 11
    //   479: goto -46 -> 433
    //   482: astore_2
    //   483: aload 14
    //   485: astore_1
    //   486: goto -218 -> 268
    //   489: astore 10
    //   491: aload_2
    //   492: astore_1
    //   493: aload 10
    //   495: astore_2
    //   496: goto -228 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	this	RFWDownloader
    //   0	499	1	paramRFWDownloadInfo	RFWDownloadInfo
    //   0	499	2	paramResponse	okhttp3.Response
    //   201	18	3	i	int
    //   50	203	4	l1	long
    //   221	30	6	l2	long
    //   133	113	8	l3	long
    //   54	414	10	localObject1	Object
    //   489	5	10	localIOException1	java.io.IOException
    //   58	152	11	localObject2	Object
    //   257	9	11	localIOException2	java.io.IOException
    //   273	205	11	localObject3	Object
    //   13	312	12	localObject4	Object
    //   10	456	13	localObject5	Object
    //   4	480	14	localObject6	Object
    //   1	158	15	localObject7	Object
    //   7	148	16	localObject8	Object
    //   19	436	17	str	String
    //   43	348	18	localFile	File
    // Exception table:
    //   from	to	target	type
    //   188	195	257	java/io/IOException
    //   195	202	257	java/io/IOException
    //   207	216	257	java/io/IOException
    //   223	229	257	java/io/IOException
    //   240	250	257	java/io/IOException
    //   343	390	257	java/io/IOException
    //   390	403	257	java/io/IOException
    //   60	71	432	finally
    //   79	88	432	finally
    //   96	104	432	finally
    //   112	118	432	finally
    //   126	135	432	finally
    //   143	154	432	finally
    //   162	170	432	finally
    //   275	298	432	finally
    //   305	314	432	finally
    //   170	188	464	finally
    //   188	195	475	finally
    //   195	202	475	finally
    //   207	216	475	finally
    //   223	229	475	finally
    //   240	250	475	finally
    //   343	390	475	finally
    //   390	403	475	finally
    //   60	71	482	java/io/IOException
    //   79	88	482	java/io/IOException
    //   96	104	482	java/io/IOException
    //   112	118	482	java/io/IOException
    //   126	135	482	java/io/IOException
    //   143	154	482	java/io/IOException
    //   162	170	482	java/io/IOException
    //   170	188	489	java/io/IOException
  }
  
  public void download(String paramString)
  {
    download(paramString, null);
  }
  
  public void download(String paramString, RFWDownloader.RFWDownloadListener paramRFWDownloadListener)
  {
    if ((getDownLoadHandler() == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    getDownLoadHandler().post(new RFWDownloader.2(this, paramString, paramRFWDownloadListener));
  }
  
  public void downloadOrUpdateFile(String paramString, RFWDownloader.RFWDownloadListener paramRFWDownloadListener)
  {
    if ((getDownLoadHandler() == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    getDownLoadHandler().post(new RFWDownloader.3(this, paramRFWDownloadListener, paramString));
  }
  
  public String getContentFilePath(String paramString)
  {
    if (isZipFile(paramString)) {
      return this.mDownloadStrategy.getDownloadRootPath() + getFileNameForKey(paramString) + File.separator;
    }
    return getDefaultSavePath(paramString);
  }
  
  public String getDefaultSavePath(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    for (;;)
    {
      return str;
      try
      {
        str = URLEncoder.encode(paramString, "UTF-8");
        str = this.mDownloadStrategy.getDownloadRootPath() + str;
        int i = str.length();
        int j = MAX_FILE_NAME_LENGTH;
        if (i <= j) {}
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    return this.mDownloadStrategy.getDownloadRootPath() + getFileNameForKey(paramString) + File.separator + RFWDownloadUtil.getFileNameFromUrl(paramString);
  }
  
  public boolean isFileDownLoaded(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(getContentFilePath(paramString));
    } while ((SdCardUtil.getSdCardDirectory() == null) || (!paramString.exists()) || ((!paramString.isFile()) && ((!paramString.isDirectory()) || (paramString.listFiles() == null) || (paramString.listFiles().length <= 0))));
    return true;
  }
  
  public boolean isFileDownLoading(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return this.mDownloadingUrlSet.contains(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader
 * JD-Core Version:    0.7.0.1
 */