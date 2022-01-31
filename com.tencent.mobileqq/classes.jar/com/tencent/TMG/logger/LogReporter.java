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
  private static LogReporter sInstance = null;
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
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new LogReporter();
      }
      return sInstance;
    }
    finally {}
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
    int j = 0;
    Object localObject = zipLogFile(paramLogParam.begin_at.get(), paramLogParam.end_at.get(), paramLogParam.seq.get() + "");
    int i;
    if (localObject != null) {
      i = PttManager.getFileSize((String)localObject);
    }
    for (;;)
    {
      String str = paramLogParam.seq.get() + "";
      paramLogParam = new JSONObject();
      try
      {
        paramLogParam.put("seq", str);
        if (i == 0) {}
        for (;;)
        {
          paramLogParam.put("exist", j);
          paramLogParam.put("size", i);
          paramLogParam.put("platform", "Android");
          paramLogParam.put("sdkversion", OpensdkGameWrapper.nativeGetSdkVersion());
          paramLogParam.put("appversion", OpensdkGameWrapper.nativeGetAppVersion());
          localObject = new LogReporter.LogReprotInfo(this, (String)localObject, str);
          HttpHelper.httpPostRequest("https://avc.qcloud.com/log/opensdklogApi.php?act=reportReqReceived", paramLogParam.toString().getBytes(), null, localObject, this.mReportLogInfoListener);
          return;
          j = 1;
        }
        i = 0;
      }
      catch (JSONException paramLogParam)
      {
        paramLogParam.printStackTrace();
        return;
      }
    }
  }
  
  private void uploadLogFile(LogReporter.LogReprotInfo paramLogReprotInfo)
  {
    String str1 = UUID.randomUUID().toString();
    String str2 = "/10002868/sdklog/imsdk/" + str1;
    str1 = "http://web.file.myqcloud.com/files/v1" + str2;
    try
    {
      str2 = IMFunc.appSignature(10002868, "AKIDIsvZoS8DRMqxDPh0wQ5B3sF6SlCINL0G", "8whnoADaf5USGpmmio7JATVQWrj5BaSz", 60L, str2, "sdklog");
      CosFileTransfer.uploadFile(paramLogReprotInfo.logPath, str1, str2, 20971520, paramLogReprotInfo, this.mUploadCosFileListener);
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
    //   0: lload_3
    //   1: lload_1
    //   2: lsub
    //   3: lconst_0
    //   4: lcmp
    //   5: ifge +35 -> 40
    //   8: ldc 8
    //   10: ldc_w 275
    //   13: iconst_2
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: lload_1
    //   20: invokestatic 281	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: lload_3
    //   27: invokestatic 281	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   30: aastore
    //   31: invokestatic 131	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokestatic 270	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   37: pop
    //   38: aconst_null
    //   39: areturn
    //   40: invokestatic 286	com/tencent/TMG/sdk/AVLoggerClient:getLogDir	()Ljava/lang/String;
    //   43: astore 12
    //   45: aload 12
    //   47: invokestatic 292	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifeq +14 -> 64
    //   53: ldc 8
    //   55: ldc_w 294
    //   58: invokestatic 270	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   61: pop
    //   62: aconst_null
    //   63: areturn
    //   64: aload 12
    //   66: astore 11
    //   68: aload 12
    //   70: bipush 47
    //   72: invokevirtual 298	java/lang/String:lastIndexOf	(I)I
    //   75: aload 12
    //   77: invokevirtual 301	java/lang/String:length	()I
    //   80: iconst_1
    //   81: isub
    //   82: if_icmpne +18 -> 100
    //   85: aload 12
    //   87: iconst_0
    //   88: aload 12
    //   90: invokevirtual 301	java/lang/String:length	()I
    //   93: iconst_1
    //   94: isub
    //   95: invokevirtual 305	java/lang/String:substring	(II)Ljava/lang/String;
    //   98: astore 11
    //   100: bipush 7
    //   102: anewarray 127	java/lang/String
    //   105: astore 14
    //   107: iconst_0
    //   108: istore 6
    //   110: new 307	java/text/SimpleDateFormat
    //   113: dup
    //   114: ldc_w 309
    //   117: invokespecial 312	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   120: astore 15
    //   122: lload_1
    //   123: lstore 9
    //   125: lload 9
    //   127: lload_3
    //   128: lcmp
    //   129: ifgt +118 -> 247
    //   132: lload 9
    //   134: ldc2_w 313
    //   137: lload_1
    //   138: ladd
    //   139: lcmp
    //   140: ifge +107 -> 247
    //   143: ldc_w 316
    //   146: iconst_1
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload 15
    //   154: new 318	java/util/Date
    //   157: dup
    //   158: ldc2_w 319
    //   161: lload 9
    //   163: lmul
    //   164: invokespecial 323	java/util/Date:<init>	(J)V
    //   167: invokevirtual 326	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   170: aastore
    //   171: invokestatic 131	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   174: astore 12
    //   176: iload 6
    //   178: istore 7
    //   180: new 328	java/io/File
    //   183: dup
    //   184: new 183	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   191: aload 11
    //   193: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 330
    //   199: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 12
    //   204: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokespecial 331	java/io/File:<init>	(Ljava/lang/String;)V
    //   213: invokevirtual 335	java/io/File:exists	()Z
    //   216: ifeq +16 -> 232
    //   219: aload 14
    //   221: iload 6
    //   223: aload 12
    //   225: aastore
    //   226: iload 6
    //   228: iconst_1
    //   229: iadd
    //   230: istore 7
    //   232: lload 9
    //   234: ldc2_w 336
    //   237: ladd
    //   238: lstore 9
    //   240: iload 7
    //   242: istore 6
    //   244: goto -119 -> 125
    //   247: new 318	java/util/Date
    //   250: dup
    //   251: ldc2_w 319
    //   254: lload_1
    //   255: lmul
    //   256: invokespecial 323	java/util/Date:<init>	(J)V
    //   259: astore 16
    //   261: new 318	java/util/Date
    //   264: dup
    //   265: ldc2_w 319
    //   268: lload_3
    //   269: lmul
    //   270: invokespecial 323	java/util/Date:<init>	(J)V
    //   273: astore 12
    //   275: iload 6
    //   277: ifne +46 -> 323
    //   280: ldc 8
    //   282: ldc_w 339
    //   285: iconst_3
    //   286: anewarray 4	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: aload 11
    //   293: aastore
    //   294: dup
    //   295: iconst_1
    //   296: aload 15
    //   298: aload 16
    //   300: invokevirtual 326	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   303: aastore
    //   304: dup
    //   305: iconst_2
    //   306: aload 15
    //   308: aload 12
    //   310: invokevirtual 326	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   313: aastore
    //   314: invokestatic 131	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   317: invokestatic 270	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   320: pop
    //   321: aconst_null
    //   322: areturn
    //   323: aconst_null
    //   324: astore 13
    //   326: aconst_null
    //   327: astore 12
    //   329: ldc_w 341
    //   332: iconst_4
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: aload 11
    //   340: aastore
    //   341: dup
    //   342: iconst_1
    //   343: aload_0
    //   344: getfield 64	com/tencent/TMG/logger/LogReporter:mIdentifier	Ljava/lang/String;
    //   347: aastore
    //   348: dup
    //   349: iconst_2
    //   350: aload 15
    //   352: aload 16
    //   354: invokevirtual 326	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   357: aastore
    //   358: dup
    //   359: iconst_3
    //   360: aload 5
    //   362: aastore
    //   363: invokestatic 131	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   366: astore 15
    //   368: new 343	java/util/zip/ZipOutputStream
    //   371: dup
    //   372: new 345	java/io/FileOutputStream
    //   375: dup
    //   376: new 328	java/io/File
    //   379: dup
    //   380: aload 15
    //   382: invokespecial 331	java/io/File:<init>	(Ljava/lang/String;)V
    //   385: invokespecial 348	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   388: invokespecial 351	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   391: astore 5
    //   393: aload 13
    //   395: astore 12
    //   397: sipush 4096
    //   400: newarray byte
    //   402: astore 16
    //   404: iconst_0
    //   405: istore 7
    //   407: iload 7
    //   409: iload 6
    //   411: if_icmpge +178 -> 589
    //   414: new 353	java/io/FileInputStream
    //   417: dup
    //   418: new 328	java/io/File
    //   421: dup
    //   422: new 183	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   429: aload 11
    //   431: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 330
    //   437: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload 14
    //   442: iload 7
    //   444: aaload
    //   445: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokespecial 331	java/io/File:<init>	(Ljava/lang/String;)V
    //   454: invokespecial 354	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   457: astore 13
    //   459: aload 13
    //   461: astore 12
    //   463: aload 5
    //   465: new 356	java/util/zip/ZipEntry
    //   468: dup
    //   469: aload 14
    //   471: iload 7
    //   473: aaload
    //   474: invokespecial 357	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   477: invokevirtual 361	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   480: aload 13
    //   482: astore 12
    //   484: aload 13
    //   486: aload 16
    //   488: invokevirtual 365	java/io/FileInputStream:read	([B)I
    //   491: istore 8
    //   493: iload 8
    //   495: iconst_m1
    //   496: if_icmpeq +66 -> 562
    //   499: aload 13
    //   501: astore 12
    //   503: aload 5
    //   505: aload 16
    //   507: iconst_0
    //   508: iload 8
    //   510: invokevirtual 369	java/util/zip/ZipOutputStream:write	([BII)V
    //   513: goto -33 -> 480
    //   516: astore 12
    //   518: aload 5
    //   520: astore 11
    //   522: aload 13
    //   524: astore 5
    //   526: aload 12
    //   528: invokevirtual 370	java/io/IOException:printStackTrace	()V
    //   531: ldc 8
    //   533: ldc_w 372
    //   536: invokestatic 270	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   539: pop
    //   540: aload 11
    //   542: ifnull +8 -> 550
    //   545: aload 11
    //   547: invokevirtual 375	java/util/zip/ZipOutputStream:close	()V
    //   550: aload 5
    //   552: ifnull +223 -> 775
    //   555: aload 5
    //   557: invokevirtual 376	java/io/FileInputStream:close	()V
    //   560: aconst_null
    //   561: areturn
    //   562: aload 13
    //   564: astore 12
    //   566: aload 5
    //   568: invokevirtual 379	java/util/zip/ZipOutputStream:closeEntry	()V
    //   571: aload 13
    //   573: astore 12
    //   575: aload 13
    //   577: invokevirtual 376	java/io/FileInputStream:close	()V
    //   580: iload 7
    //   582: iconst_1
    //   583: iadd
    //   584: istore 7
    //   586: goto -179 -> 407
    //   589: aload 5
    //   591: ifnull +8 -> 599
    //   594: aload 5
    //   596: invokevirtual 375	java/util/zip/ZipOutputStream:close	()V
    //   599: iconst_0
    //   600: ifeq +177 -> 777
    //   603: new 381	java/lang/NullPointerException
    //   606: dup
    //   607: invokespecial 382	java/lang/NullPointerException:<init>	()V
    //   610: athrow
    //   611: astore 5
    //   613: aload 5
    //   615: invokevirtual 370	java/io/IOException:printStackTrace	()V
    //   618: goto -19 -> 599
    //   621: astore 5
    //   623: aload 5
    //   625: invokevirtual 370	java/io/IOException:printStackTrace	()V
    //   628: aload 15
    //   630: areturn
    //   631: astore 11
    //   633: aload 11
    //   635: invokevirtual 370	java/io/IOException:printStackTrace	()V
    //   638: goto -88 -> 550
    //   641: astore 5
    //   643: aload 5
    //   645: invokevirtual 370	java/io/IOException:printStackTrace	()V
    //   648: aconst_null
    //   649: areturn
    //   650: astore 11
    //   652: aconst_null
    //   653: astore 5
    //   655: aload 5
    //   657: ifnull +8 -> 665
    //   660: aload 5
    //   662: invokevirtual 375	java/util/zip/ZipOutputStream:close	()V
    //   665: aload 12
    //   667: ifnull +8 -> 675
    //   670: aload 12
    //   672: invokevirtual 376	java/io/FileInputStream:close	()V
    //   675: aload 11
    //   677: athrow
    //   678: astore 5
    //   680: aload 5
    //   682: invokevirtual 370	java/io/IOException:printStackTrace	()V
    //   685: goto -20 -> 665
    //   688: astore 5
    //   690: aload 5
    //   692: invokevirtual 370	java/io/IOException:printStackTrace	()V
    //   695: goto -20 -> 675
    //   698: astore 11
    //   700: goto -45 -> 655
    //   703: astore 11
    //   705: aconst_null
    //   706: astore 12
    //   708: goto -53 -> 655
    //   711: astore 12
    //   713: aload 11
    //   715: astore 13
    //   717: aload 12
    //   719: astore 11
    //   721: aload 5
    //   723: astore 12
    //   725: aload 13
    //   727: astore 5
    //   729: goto -74 -> 655
    //   732: astore 12
    //   734: aconst_null
    //   735: astore 5
    //   737: aconst_null
    //   738: astore 11
    //   740: goto -214 -> 526
    //   743: astore 12
    //   745: aconst_null
    //   746: astore 13
    //   748: aload 5
    //   750: astore 11
    //   752: aload 13
    //   754: astore 5
    //   756: goto -230 -> 526
    //   759: astore 12
    //   761: aconst_null
    //   762: astore 13
    //   764: aload 5
    //   766: astore 11
    //   768: aload 13
    //   770: astore 5
    //   772: goto -246 -> 526
    //   775: aconst_null
    //   776: areturn
    //   777: aload 15
    //   779: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	780	0	this	LogReporter
    //   0	780	1	paramLong1	long
    //   0	780	3	paramLong2	long
    //   0	780	5	paramString	String
    //   108	304	6	i	int
    //   178	407	7	j	int
    //   491	18	8	k	int
    //   123	116	9	l	long
    //   66	480	11	localObject1	Object
    //   631	3	11	localIOException1	java.io.IOException
    //   650	26	11	localObject2	Object
    //   698	1	11	localObject3	Object
    //   703	11	11	localObject4	Object
    //   719	48	11	localObject5	Object
    //   43	459	12	localObject6	Object
    //   516	11	12	localIOException2	java.io.IOException
    //   564	143	12	localObject7	Object
    //   711	7	12	localObject8	Object
    //   723	1	12	str	String
    //   732	1	12	localIOException3	java.io.IOException
    //   743	1	12	localIOException4	java.io.IOException
    //   759	1	12	localIOException5	java.io.IOException
    //   324	445	13	localObject9	Object
    //   105	365	14	arrayOfString	String[]
    //   120	658	15	localObject10	Object
    //   259	247	16	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   463	480	516	java/io/IOException
    //   484	493	516	java/io/IOException
    //   503	513	516	java/io/IOException
    //   566	571	516	java/io/IOException
    //   575	580	516	java/io/IOException
    //   594	599	611	java/io/IOException
    //   603	611	621	java/io/IOException
    //   545	550	631	java/io/IOException
    //   555	560	641	java/io/IOException
    //   329	393	650	finally
    //   660	665	678	java/io/IOException
    //   670	675	688	java/io/IOException
    //   397	404	698	finally
    //   463	480	698	finally
    //   484	493	698	finally
    //   503	513	698	finally
    //   566	571	698	finally
    //   575	580	698	finally
    //   414	459	703	finally
    //   526	540	711	finally
    //   329	393	732	java/io/IOException
    //   397	404	743	java/io/IOException
    //   414	459	759	java/io/IOException
  }
  
  public int reportLog()
  {
    this.handler.removeCallbacks(this.runnable);
    this.handler.postDelayed(this.runnable, 10800000L);
    Log.d("LogReporter", String.format("reportLog|mAppid=%s,mIdentifier=%s,mToken=%s", new Object[] { this.mAppid, this.mIdentifier, this.mToken }));
    if ((this.mAppid == null) || (this.mIdentifier == null)) {
      return 1004;
    }
    fetchLogReportInfo();
    return 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.logger.LogReporter
 * JD-Core Version:    0.7.0.1
 */