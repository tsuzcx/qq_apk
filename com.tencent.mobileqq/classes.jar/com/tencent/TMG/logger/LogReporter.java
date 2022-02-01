package com.tencent.TMG.logger;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.TMG.ptt.PttManager;
import com.tencent.TMG.utils.CosFileTransfer;
import com.tencent.TMG.utils.CosFileTransfer.UploadCosFileListener;
import com.tencent.TMG.utils.HttpHelper;
import com.tencent.TMG.utils.HttpHelper.HttpRequestListener;
import com.tencent.TMG.wrapper.OpensdkGameWrapper;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class LogReporter
{
  public static final String TAG = "LogReporter";
  private static final int TIME_INTERVAL = 10800000;
  public static final String URL_LOG_POLLER = "https://console.tim.qq.com:443/v4/opensdk_log_poller/poll?identifier=%s&usersig=%s&sdkappid=%s";
  public static final String URL_REPORT_REQ_RECEIVED = "https://avc.qcloud.com/log/opensdklogApi.php?act=reportReqReceived";
  public static final String URL_REPORT_UPLOAD_FINISHED = "https://avc.qcloud.com/log/opensdklogApi.php?act=reportUploadFinished";
  private static final int appId = 10002868;
  private static final String bucketId = "sdklog";
  private static final String dir = "imsdk";
  private static LogReporter sInstance;
  private static final String secretId = "AKIDIsvZoS8DRMqxDPh0wQ5B3sF6SlCINL0G";
  private static final String secretKey = "8whnoADaf5USGpmmio7JATVQWrj5BaSz";
  private static final String uploadRoot = "http://web.file.myqcloud.com/files/v1";
  Handler handler = new Handler(Looper.getMainLooper());
  private String mAppid = null;
  private String mIdentifier = null;
  private HttpHelper.HttpRequestListener mLogPollerListener = new LogReporter.1(this);
  private HttpHelper.HttpRequestListener mReportLogFinishedListener = new LogReporter.4(this);
  private HttpHelper.HttpRequestListener mReportLogInfoListener = new LogReporter.2(this);
  private String mToken = null;
  private CosFileTransfer.UploadCosFileListener mUploadCosFileListener = new LogReporter.3(this);
  Runnable runnable = new LogReporter.5(this);
  
  private void fetchLogReportInfo()
  {
    HttpHelper.httpPostRequest(String.format("https://console.tim.qq.com:443/v4/opensdk_log_poller/poll?identifier=%s&usersig=%s&sdkappid=%s", new Object[] { this.mIdentifier, this.mToken, this.mAppid }), "{}".getBytes(), null, null, this.mLogPollerListener);
  }
  
  public static LogReporter getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new LogReporter();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void reportLogFinished(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("seq", paramString2);
      localJSONObject.put("url", paramString1);
      HttpHelper.httpPostRequest("https://avc.qcloud.com/log/opensdklogApi.php?act=reportUploadFinished", localJSONObject.toString().getBytes(), null, localJSONObject.toString(), this.mReportLogFinishedListener);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void reprotLogInfo(LogUploadMessage.LogParam paramLogParam)
  {
    long l1 = paramLogParam.begin_at.get();
    long l2 = paramLogParam.end_at.get();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramLogParam.seq.get());
    ((StringBuilder)localObject1).append("");
    localObject1 = zipLogFile(l1, l2, ((StringBuilder)localObject1).toString());
    int j = 0;
    int i;
    if (localObject1 != null) {
      i = PttManager.getFileSize((String)localObject1);
    } else {
      i = 0;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramLogParam.seq.get());
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    paramLogParam = new JSONObject();
    for (;;)
    {
      try
      {
        paramLogParam.put("seq", localObject2);
        if (i == 0)
        {
          paramLogParam.put("exist", j);
          paramLogParam.put("size", i);
          paramLogParam.put("platform", "Android");
          paramLogParam.put("sdkversion", OpensdkGameWrapper.nativeGetSdkVersion());
          paramLogParam.put("appversion", OpensdkGameWrapper.nativeGetAppVersion());
          localObject1 = new LogReporter.LogReprotInfo(this, (String)localObject1, (String)localObject2);
          HttpHelper.httpPostRequest("https://avc.qcloud.com/log/opensdklogApi.php?act=reportReqReceived", paramLogParam.toString().getBytes(), null, localObject1, this.mReportLogInfoListener);
          return;
        }
      }
      catch (JSONException paramLogParam)
      {
        paramLogParam.printStackTrace();
        return;
      }
      j = 1;
    }
  }
  
  private void uploadLogFile(LogReporter.LogReprotInfo paramLogReprotInfo)
  {
    String str = UUID.randomUUID().toString();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/10002868/sdklog/imsdk/");
    ((StringBuilder)localObject).append(str);
    str = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("http://web.file.myqcloud.com/files/v1");
    ((StringBuilder)localObject).append(str);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      str = IMFunc.appSignature(10002868, "AKIDIsvZoS8DRMqxDPh0wQ5B3sF6SlCINL0G", "8whnoADaf5USGpmmio7JATVQWrj5BaSz", 60L, str, "sdklog");
      CosFileTransfer.uploadFile(paramLogReprotInfo.logPath, (String)localObject, str, 20971520, paramLogReprotInfo, this.mUploadCosFileListener);
      return;
    }
    catch (Exception paramLogReprotInfo)
    {
      Log.e("LogReporter", "get cos signature failed.");
      paramLogReprotInfo.printStackTrace();
    }
  }
  
  /* Error */
  private String zipLogFile(long paramLong1, long paramLong2, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: lload_3
    //   4: lload_1
    //   5: lsub
    //   6: lconst_0
    //   7: lcmp
    //   8: ifge +35 -> 43
    //   11: ldc 8
    //   13: ldc_w 275
    //   16: iconst_2
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: lload_1
    //   23: invokestatic 281	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: lload_3
    //   30: invokestatic 281	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   33: aastore
    //   34: invokestatic 129	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   37: invokestatic 270	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aconst_null
    //   42: areturn
    //   43: invokestatic 286	com/tencent/TMG/sdk/AVLoggerClient:getLogDir	()Ljava/lang/String;
    //   46: astore 11
    //   48: aload 11
    //   50: invokestatic 292	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +14 -> 67
    //   56: ldc 8
    //   58: ldc_w 294
    //   61: invokestatic 270	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   64: pop
    //   65: aconst_null
    //   66: areturn
    //   67: aload 11
    //   69: astore 13
    //   71: aload 11
    //   73: bipush 47
    //   75: invokevirtual 298	java/lang/String:lastIndexOf	(I)I
    //   78: aload 11
    //   80: invokevirtual 301	java/lang/String:length	()I
    //   83: iconst_1
    //   84: isub
    //   85: if_icmpne +18 -> 103
    //   88: aload 11
    //   90: iconst_0
    //   91: aload 11
    //   93: invokevirtual 301	java/lang/String:length	()I
    //   96: iconst_1
    //   97: isub
    //   98: invokevirtual 305	java/lang/String:substring	(II)Ljava/lang/String;
    //   101: astore 13
    //   103: bipush 7
    //   105: anewarray 125	java/lang/String
    //   108: astore 16
    //   110: new 307	java/text/SimpleDateFormat
    //   113: dup
    //   114: ldc_w 309
    //   117: invokespecial 312	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   120: astore 11
    //   122: lload_1
    //   123: lstore 9
    //   125: iconst_0
    //   126: istore 6
    //   128: lload 9
    //   130: lload_3
    //   131: lcmp
    //   132: ifgt +131 -> 263
    //   135: lload 9
    //   137: lload_1
    //   138: ldc2_w 313
    //   141: ladd
    //   142: lcmp
    //   143: ifge +120 -> 263
    //   146: ldc_w 316
    //   149: iconst_1
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload 11
    //   157: new 318	java/util/Date
    //   160: dup
    //   161: ldc2_w 319
    //   164: lload 9
    //   166: lmul
    //   167: invokespecial 323	java/util/Date:<init>	(J)V
    //   170: invokevirtual 326	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   173: aastore
    //   174: invokestatic 129	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   177: astore 12
    //   179: new 183	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   186: astore 15
    //   188: aload 15
    //   190: aload 13
    //   192: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 15
    //   198: ldc_w 328
    //   201: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 15
    //   207: aload 12
    //   209: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: iload 6
    //   215: istore 7
    //   217: new 330	java/io/File
    //   220: dup
    //   221: aload 15
    //   223: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokespecial 331	java/io/File:<init>	(Ljava/lang/String;)V
    //   229: invokevirtual 335	java/io/File:exists	()Z
    //   232: ifeq +16 -> 248
    //   235: aload 16
    //   237: iload 6
    //   239: aload 12
    //   241: aastore
    //   242: iload 6
    //   244: iconst_1
    //   245: iadd
    //   246: istore 7
    //   248: lload 9
    //   250: ldc2_w 336
    //   253: ladd
    //   254: lstore 9
    //   256: iload 7
    //   258: istore 6
    //   260: goto -132 -> 128
    //   263: new 318	java/util/Date
    //   266: dup
    //   267: lload_1
    //   268: ldc2_w 319
    //   271: lmul
    //   272: invokespecial 323	java/util/Date:<init>	(J)V
    //   275: astore 12
    //   277: new 318	java/util/Date
    //   280: dup
    //   281: ldc2_w 319
    //   284: lload_3
    //   285: lmul
    //   286: invokespecial 323	java/util/Date:<init>	(J)V
    //   289: astore 15
    //   291: iload 6
    //   293: ifne +46 -> 339
    //   296: ldc 8
    //   298: ldc_w 339
    //   301: iconst_3
    //   302: anewarray 4	java/lang/Object
    //   305: dup
    //   306: iconst_0
    //   307: aload 13
    //   309: aastore
    //   310: dup
    //   311: iconst_1
    //   312: aload 11
    //   314: aload 12
    //   316: invokevirtual 326	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   319: aastore
    //   320: dup
    //   321: iconst_2
    //   322: aload 11
    //   324: aload 15
    //   326: invokevirtual 326	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   329: aastore
    //   330: invokestatic 129	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   333: invokestatic 270	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   336: pop
    //   337: aconst_null
    //   338: areturn
    //   339: ldc_w 341
    //   342: iconst_4
    //   343: anewarray 4	java/lang/Object
    //   346: dup
    //   347: iconst_0
    //   348: aload 13
    //   350: aastore
    //   351: dup
    //   352: iconst_1
    //   353: aload_0
    //   354: getfield 62	com/tencent/TMG/logger/LogReporter:mIdentifier	Ljava/lang/String;
    //   357: aastore
    //   358: dup
    //   359: iconst_2
    //   360: aload 11
    //   362: aload 12
    //   364: invokevirtual 326	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   367: aastore
    //   368: dup
    //   369: iconst_3
    //   370: aload 5
    //   372: aastore
    //   373: invokestatic 129	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   376: astore 17
    //   378: new 343	java/util/zip/ZipOutputStream
    //   381: dup
    //   382: new 345	java/io/FileOutputStream
    //   385: dup
    //   386: new 330	java/io/File
    //   389: dup
    //   390: aload 17
    //   392: invokespecial 331	java/io/File:<init>	(Ljava/lang/String;)V
    //   395: invokespecial 348	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   398: invokespecial 351	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   401: astore 5
    //   403: sipush 4096
    //   406: newarray byte
    //   408: astore 18
    //   410: iconst_0
    //   411: istore 7
    //   413: iload 7
    //   415: iload 6
    //   417: if_icmpge +178 -> 595
    //   420: new 183	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   427: astore 11
    //   429: aload 11
    //   431: aload 13
    //   433: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 11
    //   439: ldc_w 328
    //   442: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 11
    //   448: aload 16
    //   450: iload 7
    //   452: aaload
    //   453: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: new 353	java/io/FileInputStream
    //   460: dup
    //   461: new 330	java/io/File
    //   464: dup
    //   465: aload 11
    //   467: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokespecial 331	java/io/File:<init>	(Ljava/lang/String;)V
    //   473: invokespecial 354	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   476: astore 15
    //   478: aload 5
    //   480: astore 11
    //   482: aload 15
    //   484: astore 12
    //   486: aload 5
    //   488: new 356	java/util/zip/ZipEntry
    //   491: dup
    //   492: aload 16
    //   494: iload 7
    //   496: aaload
    //   497: invokespecial 357	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   500: invokevirtual 361	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   503: aload 5
    //   505: astore 11
    //   507: aload 15
    //   509: astore 12
    //   511: aload 15
    //   513: aload 18
    //   515: invokevirtual 365	java/io/FileInputStream:read	([B)I
    //   518: istore 8
    //   520: iload 8
    //   522: iconst_m1
    //   523: if_icmpeq +24 -> 547
    //   526: aload 5
    //   528: astore 11
    //   530: aload 15
    //   532: astore 12
    //   534: aload 5
    //   536: aload 18
    //   538: iconst_0
    //   539: iload 8
    //   541: invokevirtual 369	java/util/zip/ZipOutputStream:write	([BII)V
    //   544: goto -41 -> 503
    //   547: aload 5
    //   549: astore 11
    //   551: aload 15
    //   553: astore 12
    //   555: aload 5
    //   557: invokevirtual 372	java/util/zip/ZipOutputStream:closeEntry	()V
    //   560: aload 5
    //   562: astore 11
    //   564: aload 15
    //   566: astore 12
    //   568: aload 15
    //   570: invokevirtual 375	java/io/FileInputStream:close	()V
    //   573: iload 7
    //   575: iconst_1
    //   576: iadd
    //   577: istore 7
    //   579: goto -166 -> 413
    //   582: astore 13
    //   584: aload 5
    //   586: astore 14
    //   588: aload 15
    //   590: astore 5
    //   592: goto +85 -> 677
    //   595: aload 5
    //   597: invokevirtual 376	java/util/zip/ZipOutputStream:close	()V
    //   600: aload 17
    //   602: areturn
    //   603: astore 5
    //   605: aload 5
    //   607: invokevirtual 377	java/io/IOException:printStackTrace	()V
    //   610: aload 17
    //   612: areturn
    //   613: astore 11
    //   615: aload 14
    //   617: astore 12
    //   619: goto +140 -> 759
    //   622: astore 13
    //   624: aconst_null
    //   625: astore 11
    //   627: aload 5
    //   629: astore 14
    //   631: aload 11
    //   633: astore 5
    //   635: goto +42 -> 677
    //   638: astore 5
    //   640: goto +10 -> 650
    //   643: astore 13
    //   645: goto +25 -> 670
    //   648: astore 11
    //   650: aconst_null
    //   651: astore 13
    //   653: aload 5
    //   655: astore 11
    //   657: aload 14
    //   659: astore 12
    //   661: aload 13
    //   663: astore 5
    //   665: goto +94 -> 759
    //   668: astore 5
    //   670: aconst_null
    //   671: astore 14
    //   673: aload 14
    //   675: astore 5
    //   677: aload 14
    //   679: astore 11
    //   681: aload 5
    //   683: astore 12
    //   685: aload 13
    //   687: invokevirtual 377	java/io/IOException:printStackTrace	()V
    //   690: aload 14
    //   692: astore 11
    //   694: aload 5
    //   696: astore 12
    //   698: ldc 8
    //   700: ldc_w 379
    //   703: invokestatic 270	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   706: pop
    //   707: aload 14
    //   709: ifnull +18 -> 727
    //   712: aload 14
    //   714: invokevirtual 376	java/util/zip/ZipOutputStream:close	()V
    //   717: goto +10 -> 727
    //   720: astore 11
    //   722: aload 11
    //   724: invokevirtual 377	java/io/IOException:printStackTrace	()V
    //   727: aload 5
    //   729: ifnull +18 -> 747
    //   732: aload 5
    //   734: invokevirtual 375	java/io/FileInputStream:close	()V
    //   737: goto +10 -> 747
    //   740: astore 5
    //   742: aload 5
    //   744: invokevirtual 377	java/io/IOException:printStackTrace	()V
    //   747: aconst_null
    //   748: areturn
    //   749: astore 13
    //   751: aload 11
    //   753: astore 5
    //   755: aload 13
    //   757: astore 11
    //   759: aload 5
    //   761: ifnull +18 -> 779
    //   764: aload 5
    //   766: invokevirtual 376	java/util/zip/ZipOutputStream:close	()V
    //   769: goto +10 -> 779
    //   772: astore 5
    //   774: aload 5
    //   776: invokevirtual 377	java/io/IOException:printStackTrace	()V
    //   779: aload 12
    //   781: ifnull +18 -> 799
    //   784: aload 12
    //   786: invokevirtual 375	java/io/FileInputStream:close	()V
    //   789: goto +10 -> 799
    //   792: astore 5
    //   794: aload 5
    //   796: invokevirtual 377	java/io/IOException:printStackTrace	()V
    //   799: goto +6 -> 805
    //   802: aload 11
    //   804: athrow
    //   805: goto -3 -> 802
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	808	0	this	LogReporter
    //   0	808	1	paramLong1	long
    //   0	808	3	paramLong2	long
    //   0	808	5	paramString	String
    //   126	292	6	i	int
    //   215	363	7	j	int
    //   518	22	8	k	int
    //   123	132	9	l	long
    //   46	517	11	localObject1	Object
    //   613	1	11	localObject2	Object
    //   625	7	11	localObject3	Object
    //   177	441	12	localObject4	Object
    //   69	363	13	localObject5	Object
    //   582	1	13	localIOException1	java.io.IOException
    //   622	1	13	localIOException2	java.io.IOException
    //   643	1	13	localIOException3	java.io.IOException
    //   1	629	14	str1	String
    //   186	403	15	localObject6	Object
    //   108	385	16	arrayOfString	String[]
    //   376	235	17	str2	String
    //   408	129	18	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   486	503	582	java/io/IOException
    //   511	520	582	java/io/IOException
    //   534	544	582	java/io/IOException
    //   555	560	582	java/io/IOException
    //   568	573	582	java/io/IOException
    //   595	600	603	java/io/IOException
    //   403	410	613	finally
    //   420	478	613	finally
    //   403	410	622	java/io/IOException
    //   420	478	622	java/io/IOException
    //   339	403	638	finally
    //   339	403	643	java/io/IOException
    //   712	717	720	java/io/IOException
    //   732	737	740	java/io/IOException
    //   486	503	749	finally
    //   511	520	749	finally
    //   534	544	749	finally
    //   555	560	749	finally
    //   568	573	749	finally
    //   685	690	749	finally
    //   698	707	749	finally
    //   764	769	772	java/io/IOException
    //   784	789	792	java/io/IOException
  }
  
  public int reportLog()
  {
    this.handler.removeCallbacks(this.runnable);
    this.handler.postDelayed(this.runnable, 10800000L);
    Log.d("LogReporter", String.format("reportLog|mAppid=%s,mIdentifier=%s,mToken=%s", new Object[] { this.mAppid, this.mIdentifier, this.mToken }));
    if ((this.mAppid != null) && (this.mIdentifier != null))
    {
      fetchLogReportInfo();
      return 0;
    }
    return 1004;
  }
  
  public void setAccessToken(String paramString)
  {
    this.mToken = paramString;
  }
  
  public void setAppInfo(String paramString1, String paramString2)
  {
    this.mAppid = paramString1;
    this.mIdentifier = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.logger.LogReporter
 * JD-Core Version:    0.7.0.1
 */