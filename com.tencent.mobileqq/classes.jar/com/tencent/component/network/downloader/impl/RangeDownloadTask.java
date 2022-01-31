package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.component.network.downloader.RangeDownloadManager;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import okhttp3.OkHttpClient;

public class RangeDownloadTask
  extends DownloadTask
{
  int connect_retry = 0;
  long connect_time = 0L;
  int exe_retry = 0;
  long exe_time = 0L;
  private RangeDownloadManager mRangeDownloaderManager;
  private String mRealUrl;
  private String mRefer;
  private final long mTimeStamp = SystemClock.uptimeMillis();
  long send_req_time = 0L;
  
  public RangeDownloadTask(Context paramContext, OkHttpClient paramOkHttpClient, QZoneHttpClient paramQZoneHttpClient, String paramString1, String paramString2, boolean paramBoolean, int paramInt, long paramLong)
  {
    super(paramContext, paramOkHttpClient, paramQZoneHttpClient, paramString1, paramString2, paramBoolean, true);
    this.mRangeDownloaderManager = new RangeDownloadManager(this.pokHttpClient, null, null, paramInt);
    this.mRangeDownloaderManager.setFileSize(paramLong);
  }
  
  /* Error */
  public void execute(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 64	java/lang/Object
    //   4: dup
    //   5: iconst_0
    //   6: aload_0
    //   7: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   10: aastore
    //   11: dup
    //   12: iconst_1
    //   13: aload_2
    //   14: aastore
    //   15: invokestatic 74	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:generateRandomId	([Ljava/lang/Object;)I
    //   18: istore 7
    //   20: invokestatic 80	com/tencent/component/network/utils/SDCardUtil:isSdCardHasEnoughCapability	()Z
    //   23: istore 9
    //   25: iconst_0
    //   26: istore 4
    //   28: aload_1
    //   29: invokeinterface 85 1 0
    //   34: ifeq +11 -> 45
    //   37: aload_0
    //   38: aload_1
    //   39: aload_2
    //   40: aconst_null
    //   41: invokevirtual 89	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   44: return
    //   45: aload_0
    //   46: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   49: invokestatic 99	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   52: ifne +30 -> 82
    //   55: iload 4
    //   57: aload_0
    //   58: getfield 102	com/tencent/component/network/downloader/impl/RangeDownloadTask:mAttemptTotalCount	I
    //   61: iconst_1
    //   62: isub
    //   63: if_icmpne +13 -> 76
    //   66: aload_2
    //   67: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   70: bipush 6
    //   72: invokevirtual 114	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   75: return
    //   76: ldc2_w 115
    //   79: invokestatic 121	java/lang/Thread:sleep	(J)V
    //   82: iload 9
    //   84: ifne +24 -> 108
    //   87: aload_2
    //   88: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   91: iconst_2
    //   92: invokevirtual 114	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   95: return
    //   96: astore 14
    //   98: ldc 123
    //   100: ldc 125
    //   102: invokestatic 131	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: goto -23 -> 82
    //   108: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   111: lstore 10
    //   113: new 133	com/tencent/component/network/downloader/DownloadReport
    //   116: dup
    //   117: invokespecial 136	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   120: astore 19
    //   122: aload 19
    //   124: iload 7
    //   126: putfield 139	com/tencent/component/network/downloader/DownloadReport:id	I
    //   129: aload 19
    //   131: aload_0
    //   132: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   135: putfield 142	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   138: aload 19
    //   140: aload_0
    //   141: invokevirtual 145	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   144: putfield 148	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   147: aload 19
    //   149: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   152: putfield 156	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 160	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   160: aconst_null
    //   161: astore 16
    //   163: iconst_0
    //   164: istore 6
    //   166: iconst_0
    //   167: istore_3
    //   168: getstatic 164	com/tencent/component/network/downloader/impl/RangeDownloadTask:sRequestOptions	Ljava/lang/ThreadLocal;
    //   171: invokevirtual 170	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   174: checkcast 172	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   177: astore 15
    //   179: aload_0
    //   180: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   183: ifnull +1632 -> 1815
    //   186: aload_0
    //   187: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   190: invokeinterface 182 1 0
    //   195: astore 14
    //   197: aload 15
    //   199: aload 14
    //   201: putfield 186	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   204: aload 19
    //   206: iload 4
    //   208: putfield 189	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   211: aload 19
    //   213: aload_0
    //   214: getfield 191	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRefer	Ljava/lang/String;
    //   217: putfield 194	com/tencent/component/network/downloader/DownloadReport:refer	Ljava/lang/String;
    //   220: aload_0
    //   221: aload_0
    //   222: aload_0
    //   223: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   226: invokevirtual 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:prepareUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   229: putfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   232: aload_0
    //   233: aload_0
    //   234: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   237: aload_0
    //   238: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   241: aload_0
    //   242: invokevirtual 145	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   245: aload_0
    //   246: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   249: aload_0
    //   250: getfield 191	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRefer	Ljava/lang/String;
    //   253: invokestatic 206	com/tencent/component/network/utils/http/HttpUtil:createOkHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   256: putfield 160	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   259: aload_0
    //   260: getfield 210	com/tencent/component/network/downloader/impl/RangeDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   263: ifnull +25 -> 288
    //   266: aload_0
    //   267: getfield 210	com/tencent/component/network/downloader/impl/RangeDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   270: aconst_null
    //   271: aload_0
    //   272: getfield 160	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   275: aload_0
    //   276: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   279: aload_0
    //   280: invokevirtual 145	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   283: invokeinterface 216 5 0
    //   288: aload_0
    //   289: aload_0
    //   290: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   293: aload_0
    //   294: invokevirtual 145	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   297: aconst_null
    //   298: aload_0
    //   299: getfield 160	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   302: invokevirtual 219	com/tencent/component/network/downloader/impl/RangeDownloadTask:prepareRequest	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;)V
    //   305: aload_0
    //   306: aload_0
    //   307: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   310: aload_0
    //   311: invokevirtual 145	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   314: aconst_null
    //   315: aload_0
    //   316: getfield 160	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   319: aload 15
    //   321: invokevirtual 223	com/tencent/component/network/downloader/impl/RangeDownloadTask:applyKeepAliveStrategy	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   324: aload_0
    //   325: lconst_0
    //   326: putfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   329: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   332: lstore 12
    //   334: aload_0
    //   335: getfield 160	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   338: ifnull +1523 -> 1861
    //   341: aload_0
    //   342: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   345: invokestatic 229	com/tencent/component/network/Global:getContext	()Landroid/content/Context;
    //   348: aload_0
    //   349: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   352: aload_0
    //   353: invokevirtual 145	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   356: aload_0
    //   357: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   360: aload_0
    //   361: getfield 191	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRefer	Ljava/lang/String;
    //   364: aload_0
    //   365: getfield 160	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   368: invokevirtual 233	com/tencent/component/network/downloader/RangeDownloadManager:tryBuildAllRangeRequests	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokhttp3/Request$Builder;)Z
    //   371: ifeq +1450 -> 1821
    //   374: aload_0
    //   375: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   378: lload 12
    //   380: lsub
    //   381: putfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   384: ldc 235
    //   386: new 237	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   393: ldc 240
    //   395: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_0
    //   399: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   402: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: ldc 246
    //   407: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_0
    //   411: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   414: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 252	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: aload_0
    //   424: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   427: invokevirtual 255	com/tencent/component/network/downloader/RangeDownloadManager:execute	()Lokhttp3/Response;
    //   430: astore 14
    //   432: aload 14
    //   434: ifnull +3406 -> 3840
    //   437: aload 14
    //   439: invokevirtual 261	okhttp3/Response:code	()I
    //   442: istore 5
    //   444: iload 5
    //   446: istore_3
    //   447: aload_2
    //   448: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   451: iload_3
    //   452: putfield 264	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   455: sipush 200
    //   458: iload_3
    //   459: if_icmpne +2006 -> 2465
    //   462: iload_3
    //   463: istore 5
    //   465: aload_0
    //   466: aconst_null
    //   467: aload 14
    //   469: aload_2
    //   470: aload_1
    //   471: iload_3
    //   472: invokevirtual 268	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleResponse	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   475: ifeq +2017 -> 2492
    //   478: aload_2
    //   479: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   482: invokevirtual 271	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   485: aload_2
    //   486: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   489: lload 10
    //   491: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   494: invokevirtual 281	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   497: aload_2
    //   498: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   501: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   504: aload_0
    //   505: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   508: lsub
    //   509: putfield 284	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   512: aload_2
    //   513: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   516: aload_0
    //   517: getfield 287	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   520: putfield 290	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   523: aload_0
    //   524: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   527: invokestatic 296	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   530: invokevirtual 300	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   533: astore 17
    //   535: aload_0
    //   536: aconst_null
    //   537: aconst_null
    //   538: aload 14
    //   540: invokevirtual 304	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   543: astore 18
    //   545: aload 14
    //   547: ifnull +1320 -> 1867
    //   550: aload 14
    //   552: invokevirtual 307	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   555: ifnull +1312 -> 1867
    //   558: aload 14
    //   560: invokevirtual 307	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   563: ldc_w 309
    //   566: invokevirtual 312	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   569: astore 15
    //   571: aload_2
    //   572: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   575: aload 15
    //   577: putfield 321	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   580: aload_0
    //   581: lconst_0
    //   582: putfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   585: aload_0
    //   586: iconst_0
    //   587: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   590: aload_0
    //   591: lconst_0
    //   592: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   595: aload_0
    //   596: iconst_0
    //   597: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   600: aload_1
    //   601: invokeinterface 85 1 0
    //   606: ifne +1203 -> 1809
    //   609: aload_0
    //   610: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   613: invokestatic 99	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   616: istore 8
    //   618: aload_2
    //   619: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   622: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   625: ifne +1271 -> 1896
    //   628: new 237	java/lang/StringBuilder
    //   631: dup
    //   632: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   635: ldc_w 326
    //   638: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload_0
    //   642: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   645: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: ldc_w 328
    //   651: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: aload_0
    //   655: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   658: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   661: ldc_w 337
    //   664: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: astore 20
    //   669: aload_0
    //   670: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   673: ifeq +1200 -> 1873
    //   676: aload 14
    //   678: ifnull +1195 -> 1873
    //   681: aload 14
    //   683: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   686: ifnull +1187 -> 1873
    //   689: aload 14
    //   691: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   694: invokevirtual 344	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   697: astore 16
    //   699: aload 20
    //   701: aload 16
    //   703: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: ldc_w 346
    //   709: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: aload 17
    //   714: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   717: ldc_w 351
    //   720: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: aconst_null
    //   724: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: ldc_w 353
    //   730: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aconst_null
    //   734: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: ldc_w 355
    //   740: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: invokestatic 359	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   746: invokevirtual 362	java/lang/Thread:getId	()J
    //   749: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   752: ldc_w 367
    //   755: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: invokestatic 372	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   761: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: ldc_w 374
    //   767: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: iload 8
    //   772: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   775: ldc_w 376
    //   778: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: invokestatic 381	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   784: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   787: ldc_w 386
    //   790: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload_2
    //   794: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   797: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   800: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: ldc_w 391
    //   806: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload_2
    //   810: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   813: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   816: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   819: ldc_w 396
    //   822: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   828: aload_0
    //   829: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   832: lsub
    //   833: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   836: ldc_w 398
    //   839: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: aload_2
    //   843: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   846: getfield 401	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   849: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   852: ldc_w 403
    //   855: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: aload_2
    //   859: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   862: getfield 406	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   865: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   868: ldc_w 408
    //   871: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: aload_2
    //   875: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   878: getfield 411	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   881: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   884: ldc_w 413
    //   887: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: aload_0
    //   891: invokevirtual 416	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   894: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   897: ldc_w 418
    //   900: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: aload_0
    //   904: invokevirtual 421	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   907: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   910: ldc_w 423
    //   913: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: aload_2
    //   917: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   920: invokevirtual 426	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   923: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   926: ldc_w 428
    //   929: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: iload_3
    //   933: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   936: ldc_w 430
    //   939: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: aload 18
    //   944: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: ldc_w 432
    //   950: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: aload 15
    //   955: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: ldc_w 434
    //   961: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: astore 20
    //   966: aload_0
    //   967: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   970: ifnull +911 -> 1881
    //   973: aload_0
    //   974: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   977: iconst_0
    //   978: bipush 30
    //   980: invokevirtual 440	java/lang/String:substring	(II)Ljava/lang/String;
    //   983: astore 16
    //   985: aload 20
    //   987: aload 16
    //   989: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: ldc_w 442
    //   995: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: aload_2
    //   999: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1002: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1005: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: ldc_w 447
    //   1011: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: lconst_0
    //   1015: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1018: ldc_w 449
    //   1021: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: aload_0
    //   1025: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   1028: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1031: ldc_w 418
    //   1034: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: aload_0
    //   1038: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   1041: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1044: ldc_w 451
    //   1047: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: aload_0
    //   1051: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   1054: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1057: ldc_w 418
    //   1060: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: aload_0
    //   1064: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   1067: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1070: ldc_w 453
    //   1073: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: aload_0
    //   1077: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   1080: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1083: ldc_w 455
    //   1086: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: aload_0
    //   1090: getfield 458	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   1093: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1096: ldc_w 460
    //   1099: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: aload_0
    //   1103: invokevirtual 463	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   1106: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1109: ldc_w 465
    //   1112: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: astore 20
    //   1117: aload_0
    //   1118: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1121: ifnull +769 -> 1890
    //   1124: aload_0
    //   1125: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1128: invokeinterface 182 1 0
    //   1133: astore 16
    //   1135: aload 19
    //   1137: aload 20
    //   1139: aload 16
    //   1141: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1144: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1147: putfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1150: ldc_w 470
    //   1153: aload 19
    //   1155: getfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1158: aconst_null
    //   1159: invokestatic 474	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1162: iload 8
    //   1164: ifne +8 -> 1172
    //   1167: aload_0
    //   1168: iconst_0
    //   1169: putfield 477	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   1172: aload_2
    //   1173: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1176: astore 16
    //   1178: new 237	java/lang/StringBuilder
    //   1181: dup
    //   1182: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   1185: aload_0
    //   1186: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   1189: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: ldc_w 479
    //   1195: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: aconst_null
    //   1199: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: ldc_w 481
    //   1205: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: aload_2
    //   1209: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1212: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1215: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: ldc_w 483
    //   1221: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: astore 20
    //   1226: aload_0
    //   1227: getfield 487	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1230: ifnull +1199 -> 2429
    //   1233: aload_0
    //   1234: getfield 487	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1237: getfield 490	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1240: istore 4
    //   1242: aload 20
    //   1244: iload 4
    //   1246: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1249: ldc_w 428
    //   1252: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: iload_3
    //   1256: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1259: ldc_w 386
    //   1262: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: aload_2
    //   1266: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1269: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1272: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: ldc_w 398
    //   1278: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: aload_2
    //   1282: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1285: getfield 401	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   1288: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1291: ldc_w 403
    //   1294: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: aload_2
    //   1298: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1301: getfield 406	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1304: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1307: ldc_w 391
    //   1310: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: aload_2
    //   1314: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1317: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1320: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1323: ldc_w 396
    //   1326: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1329: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   1332: aload_0
    //   1333: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   1336: lsub
    //   1337: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1340: astore 20
    //   1342: aload 15
    //   1344: invokestatic 496	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1347: ifne +1088 -> 2435
    //   1350: new 237	java/lang/StringBuilder
    //   1353: dup
    //   1354: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   1357: ldc_w 432
    //   1360: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: aload 15
    //   1365: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1371: astore 15
    //   1373: aload 16
    //   1375: aload 20
    //   1377: aload 15
    //   1379: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1382: ldc_w 430
    //   1385: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: aload 18
    //   1390: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1396: putfield 499	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   1399: iload 8
    //   1401: ifeq +64 -> 1465
    //   1404: aload_0
    //   1405: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   1408: invokestatic 504	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   1411: astore 15
    //   1413: aload_0
    //   1414: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1417: astore 16
    //   1419: aload_0
    //   1420: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   1423: ifeq +1020 -> 2443
    //   1426: aload_0
    //   1427: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1430: ifnull +1013 -> 2443
    //   1433: aload_0
    //   1434: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1437: ldc_w 506
    //   1440: invokevirtual 510	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1443: ifeq +1000 -> 2443
    //   1446: iconst_1
    //   1447: istore 8
    //   1449: aload 15
    //   1451: aload 16
    //   1453: iload 8
    //   1455: aload_2
    //   1456: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1459: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1462: invokevirtual 514	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   1465: aload 19
    //   1467: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   1470: putfield 517	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   1473: aload 19
    //   1475: aload_0
    //   1476: invokevirtual 520	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   1479: putfield 523	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   1482: aload 19
    //   1484: aload 14
    //   1486: putfield 527	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   1489: aload 19
    //   1491: iload_3
    //   1492: putfield 528	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   1495: aload 19
    //   1497: aconst_null
    //   1498: putfield 532	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   1501: aload 17
    //   1503: ifnonnull +946 -> 2449
    //   1506: aconst_null
    //   1507: astore 15
    //   1509: aload 19
    //   1511: aload 15
    //   1513: putfield 535	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1516: aload 19
    //   1518: aconst_null
    //   1519: putfield 538	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1522: aload 19
    //   1524: aload_2
    //   1525: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1528: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1531: putfield 539	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1534: aload 19
    //   1536: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   1539: aload_0
    //   1540: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   1543: lsub
    //   1544: putfield 542	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1547: aload 19
    //   1549: aload_2
    //   1550: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1553: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1556: putfield 545	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   1559: aload 19
    //   1561: aload 19
    //   1563: getfield 542	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1566: aload_2
    //   1567: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1570: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1573: lsub
    //   1574: putfield 548	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   1577: aload 19
    //   1579: lconst_0
    //   1580: putfield 551	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   1583: aload 19
    //   1585: aload_0
    //   1586: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   1589: putfield 554	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   1592: aload 19
    //   1594: aload_0
    //   1595: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   1598: putfield 557	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   1601: aload 19
    //   1603: aload_0
    //   1604: getfield 458	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   1607: putfield 560	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   1610: aload 19
    //   1612: lconst_0
    //   1613: putfield 563	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   1616: aload 19
    //   1618: aload_0
    //   1619: invokevirtual 463	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   1622: putfield 566	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   1625: aload 19
    //   1627: aload_2
    //   1628: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1631: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1634: putfield 569	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1637: aload 19
    //   1639: aload_0
    //   1640: invokevirtual 145	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   1643: invokestatic 572	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   1646: putfield 574	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   1649: aload 19
    //   1651: aload_0
    //   1652: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   1655: putfield 577	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   1658: aload_0
    //   1659: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1662: ifnull +797 -> 2459
    //   1665: aload_0
    //   1666: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1669: ldc_w 506
    //   1672: invokevirtual 510	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1675: ifeq +784 -> 2459
    //   1678: iconst_1
    //   1679: istore 8
    //   1681: aload 19
    //   1683: iload 8
    //   1685: putfield 580	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   1688: aload 19
    //   1690: aload_2
    //   1691: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1694: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1697: putfield 582	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   1700: aload 19
    //   1702: getstatic 588	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   1705: invokevirtual 591	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   1708: putfield 594	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   1711: aload 19
    //   1713: aload_0
    //   1714: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   1717: invokevirtual 597	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   1720: putfield 600	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   1723: aload 19
    //   1725: aload_0
    //   1726: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   1729: invokevirtual 603	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeMergePhase	()J
    //   1732: putfield 606	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeMergePhase	J
    //   1735: aload 14
    //   1737: ifnull +24 -> 1761
    //   1740: aload 14
    //   1742: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1745: ifnull +16 -> 1761
    //   1748: aload 19
    //   1750: aload 14
    //   1752: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1755: invokevirtual 344	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   1758: putfield 608	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   1761: aload 19
    //   1763: aload_0
    //   1764: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   1767: invokevirtual 612	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   1770: putfield 616	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   1773: aload 19
    //   1775: aload_0
    //   1776: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   1779: invokevirtual 619	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   1782: putfield 622	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   1785: aload_2
    //   1786: aload 19
    //   1788: invokevirtual 626	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1791: aload_2
    //   1792: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1795: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1798: ifeq +11 -> 1809
    //   1801: aload_0
    //   1802: aload_1
    //   1803: aload_2
    //   1804: aload 19
    //   1806: invokevirtual 89	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1809: aload_0
    //   1810: aconst_null
    //   1811: putfield 160	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1814: return
    //   1815: aconst_null
    //   1816: astore 14
    //   1818: goto -1621 -> 197
    //   1821: ldc 235
    //   1823: new 237	java/lang/StringBuilder
    //   1826: dup
    //   1827: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   1830: ldc_w 628
    //   1833: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: aload_0
    //   1837: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   1840: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: ldc 246
    //   1845: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: aload_0
    //   1849: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1852: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1858: invokestatic 252	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1861: aconst_null
    //   1862: astore 14
    //   1864: goto -1432 -> 432
    //   1867: aconst_null
    //   1868: astore 15
    //   1870: goto -1299 -> 571
    //   1873: ldc_w 630
    //   1876: astore 16
    //   1878: goto -1179 -> 699
    //   1881: aload_0
    //   1882: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1885: astore 16
    //   1887: goto -902 -> 985
    //   1890: aconst_null
    //   1891: astore 16
    //   1893: goto -758 -> 1135
    //   1896: new 237	java/lang/StringBuilder
    //   1899: dup
    //   1900: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   1903: ldc_w 632
    //   1906: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1909: aload_0
    //   1910: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   1913: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: ldc_w 328
    //   1919: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1922: aload_0
    //   1923: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   1926: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1929: ldc_w 337
    //   1932: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1935: astore 20
    //   1937: aload_0
    //   1938: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   1941: ifeq +465 -> 2406
    //   1944: aload 14
    //   1946: ifnull +460 -> 2406
    //   1949: aload 14
    //   1951: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1954: ifnull +452 -> 2406
    //   1957: aload 14
    //   1959: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1962: invokevirtual 344	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   1965: astore 16
    //   1967: aload 20
    //   1969: aload 16
    //   1971: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1974: ldc_w 346
    //   1977: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1980: aload 17
    //   1982: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1985: ldc_w 351
    //   1988: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1991: aconst_null
    //   1992: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1995: ldc_w 353
    //   1998: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2001: aconst_null
    //   2002: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2005: ldc_w 355
    //   2008: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: invokestatic 359	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2014: invokevirtual 362	java/lang/Thread:getId	()J
    //   2017: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2020: ldc_w 367
    //   2023: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2026: invokestatic 372	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   2029: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2032: ldc_w 376
    //   2035: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2038: invokestatic 381	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2041: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2044: ldc_w 391
    //   2047: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2050: aload_2
    //   2051: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2054: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2057: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2060: ldc_w 396
    //   2063: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2066: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   2069: aload_0
    //   2070: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   2073: lsub
    //   2074: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2077: ldc_w 398
    //   2080: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2083: aload_2
    //   2084: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2087: getfield 401	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2090: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2093: ldc_w 403
    //   2096: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2099: aload_2
    //   2100: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2103: getfield 406	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2106: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2109: ldc_w 408
    //   2112: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2115: aload_2
    //   2116: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2119: getfield 411	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   2122: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2125: ldc_w 413
    //   2128: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2131: aload_0
    //   2132: invokevirtual 416	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   2135: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2138: ldc_w 418
    //   2141: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2144: aload_0
    //   2145: invokevirtual 421	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   2148: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2151: ldc_w 634
    //   2154: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2157: iload_3
    //   2158: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2161: ldc_w 430
    //   2164: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2167: aload 18
    //   2169: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2172: ldc_w 386
    //   2175: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2178: aload_2
    //   2179: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2182: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2185: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2188: ldc_w 432
    //   2191: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2194: aload 15
    //   2196: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2199: ldc_w 434
    //   2202: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2205: astore 20
    //   2207: aload_0
    //   2208: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   2211: ifnull +203 -> 2414
    //   2214: aload_0
    //   2215: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   2218: iconst_0
    //   2219: bipush 30
    //   2221: invokevirtual 440	java/lang/String:substring	(II)Ljava/lang/String;
    //   2224: astore 16
    //   2226: aload 20
    //   2228: aload 16
    //   2230: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2233: ldc_w 442
    //   2236: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2239: aload_2
    //   2240: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2243: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2246: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: ldc_w 447
    //   2252: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: lconst_0
    //   2256: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2259: ldc_w 449
    //   2262: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2265: aload_0
    //   2266: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   2269: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2272: ldc_w 418
    //   2275: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2278: aload_0
    //   2279: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   2282: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2285: ldc_w 451
    //   2288: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2291: aload_0
    //   2292: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   2295: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2298: ldc_w 418
    //   2301: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2304: aload_0
    //   2305: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   2308: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2311: ldc_w 453
    //   2314: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2317: aload_0
    //   2318: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   2321: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2324: ldc_w 455
    //   2327: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2330: aload_0
    //   2331: getfield 458	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   2334: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2337: ldc_w 460
    //   2340: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2343: aload_0
    //   2344: invokevirtual 463	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   2347: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2350: ldc_w 465
    //   2353: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2356: astore 20
    //   2358: aload_0
    //   2359: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2362: ifnull +61 -> 2423
    //   2365: aload_0
    //   2366: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2369: invokeinterface 182 1 0
    //   2374: astore 16
    //   2376: aload 19
    //   2378: aload 20
    //   2380: aload 16
    //   2382: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2385: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2388: putfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   2391: ldc_w 470
    //   2394: aload 19
    //   2396: getfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   2399: aconst_null
    //   2400: invokestatic 637	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2403: goto -1241 -> 1162
    //   2406: ldc_w 630
    //   2409: astore 16
    //   2411: goto -444 -> 1967
    //   2414: aload_0
    //   2415: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   2418: astore 16
    //   2420: goto -194 -> 2226
    //   2423: aconst_null
    //   2424: astore 16
    //   2426: goto -50 -> 2376
    //   2429: iconst_0
    //   2430: istore 4
    //   2432: goto -1190 -> 1242
    //   2435: ldc_w 639
    //   2438: astore 15
    //   2440: goto -1067 -> 1373
    //   2443: iconst_0
    //   2444: istore 8
    //   2446: goto -997 -> 1449
    //   2449: aload 17
    //   2451: invokevirtual 642	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   2454: astore 15
    //   2456: goto -947 -> 1509
    //   2459: iconst_0
    //   2460: istore 8
    //   2462: goto -781 -> 1681
    //   2465: iload_3
    //   2466: istore 5
    //   2468: aload_0
    //   2469: getfield 210	com/tencent/component/network/downloader/impl/RangeDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2472: ifnull +20 -> 2492
    //   2475: aload_0
    //   2476: getfield 210	com/tencent/component/network/downloader/impl/RangeDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2479: aload_0
    //   2480: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   2483: iconst_1
    //   2484: invokeinterface 646 3 0
    //   2489: iload_3
    //   2490: istore 5
    //   2492: aload_2
    //   2493: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2496: lload 10
    //   2498: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   2501: invokevirtual 281	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   2504: aload_2
    //   2505: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2508: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   2511: aload_0
    //   2512: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   2515: lsub
    //   2516: putfield 284	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   2519: aload_2
    //   2520: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2523: aload_0
    //   2524: getfield 287	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   2527: putfield 290	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   2530: aload_0
    //   2531: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   2534: invokestatic 296	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   2537: invokevirtual 300	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   2540: astore 17
    //   2542: aload_0
    //   2543: aconst_null
    //   2544: aconst_null
    //   2545: aload 14
    //   2547: invokevirtual 304	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   2550: astore 18
    //   2552: aload 14
    //   2554: ifnull +1300 -> 3854
    //   2557: aload 14
    //   2559: invokevirtual 307	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   2562: ifnull +1292 -> 3854
    //   2565: aload 14
    //   2567: invokevirtual 307	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   2570: ldc_w 309
    //   2573: invokevirtual 312	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   2576: astore 15
    //   2578: aload_2
    //   2579: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2582: aload 15
    //   2584: putfield 321	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   2587: aload_0
    //   2588: lconst_0
    //   2589: putfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   2592: aload_0
    //   2593: iconst_0
    //   2594: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   2597: aload_0
    //   2598: lconst_0
    //   2599: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   2602: aload_0
    //   2603: iconst_0
    //   2604: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   2607: aload_1
    //   2608: invokeinterface 85 1 0
    //   2613: ifne +1204 -> 3817
    //   2616: aload_0
    //   2617: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   2620: invokestatic 99	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2623: istore 8
    //   2625: aload_2
    //   2626: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2629: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2632: ifne +1251 -> 3883
    //   2635: new 237	java/lang/StringBuilder
    //   2638: dup
    //   2639: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   2642: ldc_w 326
    //   2645: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2648: aload_0
    //   2649: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   2652: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2655: ldc_w 328
    //   2658: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2661: aload_0
    //   2662: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   2665: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2668: ldc_w 337
    //   2671: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2674: astore 20
    //   2676: aload_0
    //   2677: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   2680: ifeq +1180 -> 3860
    //   2683: aload 14
    //   2685: ifnull +1175 -> 3860
    //   2688: aload 14
    //   2690: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   2693: ifnull +1167 -> 3860
    //   2696: aload 14
    //   2698: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   2701: invokevirtual 344	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   2704: astore 16
    //   2706: aload 20
    //   2708: aload 16
    //   2710: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2713: ldc_w 346
    //   2716: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2719: aload 17
    //   2721: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2724: ldc_w 351
    //   2727: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2730: aconst_null
    //   2731: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2734: ldc_w 353
    //   2737: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2740: aconst_null
    //   2741: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2744: ldc_w 355
    //   2747: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2750: invokestatic 359	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2753: invokevirtual 362	java/lang/Thread:getId	()J
    //   2756: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2759: ldc_w 367
    //   2762: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2765: invokestatic 372	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   2768: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2771: ldc_w 374
    //   2774: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2777: iload 8
    //   2779: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2782: ldc_w 376
    //   2785: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2788: invokestatic 381	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2791: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2794: ldc_w 386
    //   2797: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2800: aload_2
    //   2801: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2804: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2807: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2810: ldc_w 391
    //   2813: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2816: aload_2
    //   2817: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2820: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2823: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2826: ldc_w 396
    //   2829: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2832: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   2835: aload_0
    //   2836: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   2839: lsub
    //   2840: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2843: ldc_w 398
    //   2846: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2849: aload_2
    //   2850: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2853: getfield 401	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2856: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2859: ldc_w 403
    //   2862: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2865: aload_2
    //   2866: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2869: getfield 406	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2872: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2875: ldc_w 408
    //   2878: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2881: aload_2
    //   2882: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2885: getfield 411	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   2888: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2891: ldc_w 413
    //   2894: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2897: aload_0
    //   2898: invokevirtual 416	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   2901: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2904: ldc_w 418
    //   2907: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2910: aload_0
    //   2911: invokevirtual 421	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   2914: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2917: ldc_w 423
    //   2920: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2923: aload_2
    //   2924: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2927: invokevirtual 426	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   2930: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2933: ldc_w 428
    //   2936: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2939: iload 5
    //   2941: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2944: ldc_w 430
    //   2947: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2950: aload 18
    //   2952: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2955: ldc_w 432
    //   2958: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2961: aload 15
    //   2963: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2966: ldc_w 434
    //   2969: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2972: astore 20
    //   2974: aload_0
    //   2975: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   2978: ifnull +890 -> 3868
    //   2981: aload_0
    //   2982: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   2985: iconst_0
    //   2986: bipush 30
    //   2988: invokevirtual 440	java/lang/String:substring	(II)Ljava/lang/String;
    //   2991: astore 16
    //   2993: aload 20
    //   2995: aload 16
    //   2997: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3000: ldc_w 442
    //   3003: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3006: aload_2
    //   3007: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3010: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3013: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3016: ldc_w 447
    //   3019: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3022: lconst_0
    //   3023: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3026: ldc_w 449
    //   3029: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3032: aload_0
    //   3033: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   3036: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3039: ldc_w 418
    //   3042: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3045: aload_0
    //   3046: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   3049: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3052: ldc_w 451
    //   3055: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3058: aload_0
    //   3059: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   3062: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3065: ldc_w 418
    //   3068: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3071: aload_0
    //   3072: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   3075: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3078: ldc_w 453
    //   3081: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3084: aload_0
    //   3085: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   3088: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3091: ldc_w 455
    //   3094: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3097: aload_0
    //   3098: getfield 458	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   3101: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3104: ldc_w 460
    //   3107: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3110: aload_0
    //   3111: invokevirtual 463	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   3114: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3117: ldc_w 465
    //   3120: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3123: astore 20
    //   3125: aload_0
    //   3126: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3129: ifnull +748 -> 3877
    //   3132: aload_0
    //   3133: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3136: invokeinterface 182 1 0
    //   3141: astore 16
    //   3143: aload 19
    //   3145: aload 20
    //   3147: aload 16
    //   3149: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3152: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3155: putfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3158: ldc_w 470
    //   3161: aload 19
    //   3163: getfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3166: aconst_null
    //   3167: invokestatic 474	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3170: iload 8
    //   3172: ifne +8 -> 3180
    //   3175: aload_0
    //   3176: iconst_0
    //   3177: putfield 477	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   3180: aload_2
    //   3181: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3184: astore 16
    //   3186: new 237	java/lang/StringBuilder
    //   3189: dup
    //   3190: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   3193: aload_0
    //   3194: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   3197: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3200: ldc_w 479
    //   3203: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3206: aconst_null
    //   3207: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3210: ldc_w 481
    //   3213: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3216: aload_2
    //   3217: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3220: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3223: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3226: ldc_w 483
    //   3229: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3232: astore 20
    //   3234: aload_0
    //   3235: getfield 487	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3238: ifnull +1179 -> 4417
    //   3241: aload_0
    //   3242: getfield 487	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3245: getfield 490	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3248: istore_3
    //   3249: aload 20
    //   3251: iload_3
    //   3252: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3255: ldc_w 428
    //   3258: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3261: iload 5
    //   3263: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3266: ldc_w 386
    //   3269: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3272: aload_2
    //   3273: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3276: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3279: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3282: ldc_w 398
    //   3285: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3288: aload_2
    //   3289: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3292: getfield 401	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3295: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3298: ldc_w 403
    //   3301: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3304: aload_2
    //   3305: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3308: getfield 406	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3311: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3314: ldc_w 391
    //   3317: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3320: aload_2
    //   3321: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3324: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3327: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3330: ldc_w 396
    //   3333: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3336: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   3339: aload_0
    //   3340: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   3343: lsub
    //   3344: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3347: astore 20
    //   3349: aload 15
    //   3351: invokestatic 496	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3354: ifne +1068 -> 4422
    //   3357: new 237	java/lang/StringBuilder
    //   3360: dup
    //   3361: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   3364: ldc_w 432
    //   3367: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3370: aload 15
    //   3372: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3375: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3378: astore 15
    //   3380: aload 16
    //   3382: aload 20
    //   3384: aload 15
    //   3386: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3389: ldc_w 430
    //   3392: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3395: aload 18
    //   3397: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3400: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3403: putfield 499	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   3406: iload 8
    //   3408: ifeq +64 -> 3472
    //   3411: aload_0
    //   3412: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   3415: invokestatic 504	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   3418: astore 15
    //   3420: aload_0
    //   3421: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   3424: astore 16
    //   3426: aload_0
    //   3427: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   3430: ifeq +1000 -> 4430
    //   3433: aload_0
    //   3434: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   3437: ifnull +993 -> 4430
    //   3440: aload_0
    //   3441: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   3444: ldc_w 506
    //   3447: invokevirtual 510	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3450: ifeq +980 -> 4430
    //   3453: iconst_1
    //   3454: istore 8
    //   3456: aload 15
    //   3458: aload 16
    //   3460: iload 8
    //   3462: aload_2
    //   3463: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3466: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3469: invokevirtual 514	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   3472: aload 19
    //   3474: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   3477: putfield 517	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   3480: aload 19
    //   3482: aload_0
    //   3483: invokevirtual 520	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   3486: putfield 523	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   3489: aload 19
    //   3491: aload 14
    //   3493: putfield 527	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   3496: aload 19
    //   3498: iload 5
    //   3500: putfield 528	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   3503: aload 19
    //   3505: aconst_null
    //   3506: putfield 532	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   3509: aload 17
    //   3511: ifnonnull +925 -> 4436
    //   3514: aconst_null
    //   3515: astore 15
    //   3517: aload 19
    //   3519: aload 15
    //   3521: putfield 535	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   3524: aload 19
    //   3526: aconst_null
    //   3527: putfield 538	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   3530: aload 19
    //   3532: aload_2
    //   3533: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3536: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3539: putfield 539	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   3542: aload 19
    //   3544: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   3547: aload_0
    //   3548: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   3551: lsub
    //   3552: putfield 542	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   3555: aload 19
    //   3557: aload_2
    //   3558: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3561: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3564: putfield 545	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   3567: aload 19
    //   3569: aload 19
    //   3571: getfield 542	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   3574: aload_2
    //   3575: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3578: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3581: lsub
    //   3582: putfield 548	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   3585: aload 19
    //   3587: lconst_0
    //   3588: putfield 551	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   3591: aload 19
    //   3593: aload_0
    //   3594: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   3597: putfield 554	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   3600: aload 19
    //   3602: aload_0
    //   3603: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   3606: putfield 557	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   3609: aload 19
    //   3611: aload_0
    //   3612: getfield 458	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   3615: putfield 560	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   3618: aload 19
    //   3620: lconst_0
    //   3621: putfield 563	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   3624: aload 19
    //   3626: aload_0
    //   3627: invokevirtual 463	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   3630: putfield 566	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   3633: aload 19
    //   3635: aload_2
    //   3636: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3639: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3642: putfield 569	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   3645: aload 19
    //   3647: aload_0
    //   3648: invokevirtual 145	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   3651: invokestatic 572	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   3654: putfield 574	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   3657: aload 19
    //   3659: aload_0
    //   3660: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   3663: putfield 577	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   3666: aload_0
    //   3667: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   3670: ifnull +776 -> 4446
    //   3673: aload_0
    //   3674: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   3677: ldc_w 506
    //   3680: invokevirtual 510	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3683: ifeq +763 -> 4446
    //   3686: iconst_1
    //   3687: istore 8
    //   3689: aload 19
    //   3691: iload 8
    //   3693: putfield 580	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   3696: aload 19
    //   3698: aload_2
    //   3699: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3702: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3705: putfield 582	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   3708: aload 19
    //   3710: getstatic 588	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   3713: invokevirtual 591	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   3716: putfield 594	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   3719: aload 19
    //   3721: aload_0
    //   3722: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   3725: invokevirtual 597	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   3728: putfield 600	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   3731: aload 19
    //   3733: aload_0
    //   3734: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   3737: invokevirtual 603	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeMergePhase	()J
    //   3740: putfield 606	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeMergePhase	J
    //   3743: aload 14
    //   3745: ifnull +24 -> 3769
    //   3748: aload 14
    //   3750: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3753: ifnull +16 -> 3769
    //   3756: aload 19
    //   3758: aload 14
    //   3760: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3763: invokevirtual 344	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3766: putfield 608	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   3769: aload 19
    //   3771: aload_0
    //   3772: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   3775: invokevirtual 612	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   3778: putfield 616	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   3781: aload 19
    //   3783: aload_0
    //   3784: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   3787: invokevirtual 619	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   3790: putfield 622	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   3793: aload_2
    //   3794: aload 19
    //   3796: invokevirtual 626	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   3799: aload_2
    //   3800: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3803: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3806: ifeq +11 -> 3817
    //   3809: aload_0
    //   3810: aload_1
    //   3811: aload_2
    //   3812: aload 19
    //   3814: invokevirtual 89	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   3817: aload_0
    //   3818: aconst_null
    //   3819: putfield 160	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   3822: iload 4
    //   3824: iconst_1
    //   3825: iadd
    //   3826: istore_3
    //   3827: aload_0
    //   3828: invokevirtual 649	com/tencent/component/network/downloader/impl/RangeDownloadTask:canAttempt	()Z
    //   3831: ifeq -3787 -> 44
    //   3834: iload_3
    //   3835: istore 4
    //   3837: goto -3809 -> 28
    //   3840: aload_2
    //   3841: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3844: iconst_3
    //   3845: invokevirtual 114	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   3848: iconst_0
    //   3849: istore 5
    //   3851: goto -1359 -> 2492
    //   3854: aconst_null
    //   3855: astore 15
    //   3857: goto -1279 -> 2578
    //   3860: ldc_w 630
    //   3863: astore 16
    //   3865: goto -1159 -> 2706
    //   3868: aload_0
    //   3869: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   3872: astore 16
    //   3874: goto -881 -> 2993
    //   3877: aconst_null
    //   3878: astore 16
    //   3880: goto -737 -> 3143
    //   3883: new 237	java/lang/StringBuilder
    //   3886: dup
    //   3887: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   3890: ldc_w 632
    //   3893: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3896: aload_0
    //   3897: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   3900: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3903: ldc_w 328
    //   3906: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3909: aload_0
    //   3910: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   3913: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3916: ldc_w 337
    //   3919: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3922: astore 20
    //   3924: aload_0
    //   3925: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   3928: ifeq +466 -> 4394
    //   3931: aload 14
    //   3933: ifnull +461 -> 4394
    //   3936: aload 14
    //   3938: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3941: ifnull +453 -> 4394
    //   3944: aload 14
    //   3946: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3949: invokevirtual 344	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3952: astore 16
    //   3954: aload 20
    //   3956: aload 16
    //   3958: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3961: ldc_w 346
    //   3964: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3967: aload 17
    //   3969: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3972: ldc_w 351
    //   3975: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3978: aconst_null
    //   3979: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3982: ldc_w 353
    //   3985: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3988: aconst_null
    //   3989: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3992: ldc_w 355
    //   3995: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3998: invokestatic 359	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4001: invokevirtual 362	java/lang/Thread:getId	()J
    //   4004: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4007: ldc_w 367
    //   4010: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4013: invokestatic 372	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4016: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4019: ldc_w 376
    //   4022: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4025: invokestatic 381	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   4028: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4031: ldc_w 391
    //   4034: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4037: aload_2
    //   4038: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4041: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4044: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4047: ldc_w 396
    //   4050: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4053: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   4056: aload_0
    //   4057: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   4060: lsub
    //   4061: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4064: ldc_w 398
    //   4067: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4070: aload_2
    //   4071: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4074: getfield 401	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4077: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4080: ldc_w 403
    //   4083: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4086: aload_2
    //   4087: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4090: getfield 406	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4093: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4096: ldc_w 408
    //   4099: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4102: aload_2
    //   4103: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4106: getfield 411	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4109: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4112: ldc_w 413
    //   4115: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4118: aload_0
    //   4119: invokevirtual 416	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   4122: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4125: ldc_w 418
    //   4128: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4131: aload_0
    //   4132: invokevirtual 421	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   4135: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4138: ldc_w 634
    //   4141: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4144: iload 5
    //   4146: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4149: ldc_w 430
    //   4152: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4155: aload 18
    //   4157: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4160: ldc_w 386
    //   4163: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4166: aload_2
    //   4167: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4170: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4173: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4176: ldc_w 432
    //   4179: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4182: aload 15
    //   4184: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4187: ldc_w 434
    //   4190: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4193: astore 20
    //   4195: aload_0
    //   4196: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4199: ifnull +203 -> 4402
    //   4202: aload_0
    //   4203: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4206: iconst_0
    //   4207: bipush 30
    //   4209: invokevirtual 440	java/lang/String:substring	(II)Ljava/lang/String;
    //   4212: astore 16
    //   4214: aload 20
    //   4216: aload 16
    //   4218: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4221: ldc_w 442
    //   4224: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4227: aload_2
    //   4228: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4231: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4234: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4237: ldc_w 447
    //   4240: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4243: lconst_0
    //   4244: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4247: ldc_w 449
    //   4250: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4253: aload_0
    //   4254: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   4257: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4260: ldc_w 418
    //   4263: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4266: aload_0
    //   4267: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   4270: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4273: ldc_w 451
    //   4276: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4279: aload_0
    //   4280: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   4283: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4286: ldc_w 418
    //   4289: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4292: aload_0
    //   4293: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   4296: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4299: ldc_w 453
    //   4302: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4305: aload_0
    //   4306: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   4309: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4312: ldc_w 455
    //   4315: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4318: aload_0
    //   4319: getfield 458	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   4322: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4325: ldc_w 460
    //   4328: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4331: aload_0
    //   4332: invokevirtual 463	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   4335: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4338: ldc_w 465
    //   4341: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4344: astore 20
    //   4346: aload_0
    //   4347: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4350: ifnull +61 -> 4411
    //   4353: aload_0
    //   4354: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4357: invokeinterface 182 1 0
    //   4362: astore 16
    //   4364: aload 19
    //   4366: aload 20
    //   4368: aload 16
    //   4370: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4373: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4376: putfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4379: ldc_w 470
    //   4382: aload 19
    //   4384: getfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4387: aconst_null
    //   4388: invokestatic 637	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4391: goto -1221 -> 3170
    //   4394: ldc_w 630
    //   4397: astore 16
    //   4399: goto -445 -> 3954
    //   4402: aload_0
    //   4403: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4406: astore 16
    //   4408: goto -194 -> 4214
    //   4411: aconst_null
    //   4412: astore 16
    //   4414: goto -50 -> 4364
    //   4417: iconst_0
    //   4418: istore_3
    //   4419: goto -1170 -> 3249
    //   4422: ldc_w 639
    //   4425: astore 15
    //   4427: goto -1047 -> 3380
    //   4430: iconst_0
    //   4431: istore 8
    //   4433: goto -977 -> 3456
    //   4436: aload 17
    //   4438: invokevirtual 642	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   4441: astore 15
    //   4443: goto -926 -> 3517
    //   4446: iconst_0
    //   4447: istore 8
    //   4449: goto -760 -> 3689
    //   4452: astore 15
    //   4454: aconst_null
    //   4455: astore 14
    //   4457: ldc 235
    //   4459: new 237	java/lang/StringBuilder
    //   4462: dup
    //   4463: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   4466: ldc_w 651
    //   4469: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4472: aload_0
    //   4473: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   4476: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4479: ldc_w 653
    //   4482: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4485: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4488: aload 15
    //   4490: invokestatic 474	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4493: aload_2
    //   4494: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4497: aload 15
    //   4499: invokevirtual 656	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   4502: aload_2
    //   4503: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4506: lload 10
    //   4508: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   4511: invokevirtual 281	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4514: aload_2
    //   4515: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4518: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   4521: aload_0
    //   4522: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   4525: lsub
    //   4526: putfield 284	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   4529: aload_2
    //   4530: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4533: aload_0
    //   4534: getfield 287	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   4537: putfield 290	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   4540: aload_0
    //   4541: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   4544: invokestatic 296	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   4547: invokevirtual 300	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4550: astore 18
    //   4552: aload_0
    //   4553: aconst_null
    //   4554: aconst_null
    //   4555: aload 14
    //   4557: invokevirtual 304	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   4560: astore 20
    //   4562: aload 14
    //   4564: ifnull +1277 -> 5841
    //   4567: aload 14
    //   4569: invokevirtual 307	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   4572: ifnull +1269 -> 5841
    //   4575: aload 14
    //   4577: invokevirtual 307	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   4580: ldc_w 309
    //   4583: invokevirtual 312	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   4586: astore 16
    //   4588: aload_2
    //   4589: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4592: aload 16
    //   4594: putfield 321	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   4597: aload_0
    //   4598: lconst_0
    //   4599: putfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   4602: aload_0
    //   4603: iconst_0
    //   4604: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   4607: aload_0
    //   4608: lconst_0
    //   4609: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   4612: aload_0
    //   4613: iconst_0
    //   4614: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   4617: aload_1
    //   4618: invokeinterface 85 1 0
    //   4623: ifne +1205 -> 5828
    //   4626: aload_0
    //   4627: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   4630: invokestatic 99	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   4633: istore 8
    //   4635: aload_2
    //   4636: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4639: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4642: ifne +1228 -> 5870
    //   4645: new 237	java/lang/StringBuilder
    //   4648: dup
    //   4649: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   4652: ldc_w 326
    //   4655: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4658: aload_0
    //   4659: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   4662: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4665: ldc_w 328
    //   4668: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4671: aload_0
    //   4672: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   4675: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4678: ldc_w 337
    //   4681: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4684: astore 21
    //   4686: aload_0
    //   4687: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   4690: ifeq +1157 -> 5847
    //   4693: aload 14
    //   4695: ifnull +1152 -> 5847
    //   4698: aload 14
    //   4700: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4703: ifnull +1144 -> 5847
    //   4706: aload 14
    //   4708: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4711: invokevirtual 344	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   4714: astore 17
    //   4716: aload 21
    //   4718: aload 17
    //   4720: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4723: ldc_w 346
    //   4726: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4729: aload 18
    //   4731: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4734: ldc_w 351
    //   4737: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4740: aconst_null
    //   4741: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4744: ldc_w 353
    //   4747: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4750: aconst_null
    //   4751: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4754: ldc_w 355
    //   4757: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4760: invokestatic 359	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4763: invokevirtual 362	java/lang/Thread:getId	()J
    //   4766: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4769: ldc_w 367
    //   4772: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4775: invokestatic 372	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4778: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4781: ldc_w 374
    //   4784: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4787: iload 8
    //   4789: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4792: ldc_w 376
    //   4795: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4798: invokestatic 381	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   4801: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4804: ldc_w 386
    //   4807: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4810: aload_2
    //   4811: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4814: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4817: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4820: ldc_w 391
    //   4823: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4826: aload_2
    //   4827: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4830: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4833: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4836: ldc_w 396
    //   4839: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4842: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   4845: aload_0
    //   4846: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   4849: lsub
    //   4850: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4853: ldc_w 398
    //   4856: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4859: aload_2
    //   4860: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4863: getfield 401	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4866: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4869: ldc_w 403
    //   4872: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4875: aload_2
    //   4876: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4879: getfield 406	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4882: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4885: ldc_w 408
    //   4888: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4891: aload_2
    //   4892: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4895: getfield 411	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4898: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4901: ldc_w 413
    //   4904: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4907: aload_0
    //   4908: invokevirtual 416	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   4911: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4914: ldc_w 418
    //   4917: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4920: aload_0
    //   4921: invokevirtual 421	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   4924: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4927: ldc_w 423
    //   4930: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4933: aload_2
    //   4934: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4937: invokevirtual 426	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   4940: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4943: ldc_w 428
    //   4946: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4949: iload_3
    //   4950: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4953: ldc_w 430
    //   4956: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4959: aload 20
    //   4961: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4964: ldc_w 432
    //   4967: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4970: aload 16
    //   4972: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4975: ldc_w 434
    //   4978: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4981: astore 21
    //   4983: aload_0
    //   4984: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4987: ifnull +868 -> 5855
    //   4990: aload_0
    //   4991: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4994: iconst_0
    //   4995: bipush 30
    //   4997: invokevirtual 440	java/lang/String:substring	(II)Ljava/lang/String;
    //   5000: astore 17
    //   5002: aload 21
    //   5004: aload 17
    //   5006: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5009: ldc_w 442
    //   5012: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5015: aload_2
    //   5016: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5019: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5022: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5025: ldc_w 447
    //   5028: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5031: lconst_0
    //   5032: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5035: ldc_w 449
    //   5038: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5041: aload_0
    //   5042: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   5045: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5048: ldc_w 418
    //   5051: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5054: aload_0
    //   5055: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   5058: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5061: ldc_w 451
    //   5064: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5067: aload_0
    //   5068: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   5071: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5074: ldc_w 418
    //   5077: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5080: aload_0
    //   5081: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   5084: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5087: ldc_w 453
    //   5090: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5093: aload_0
    //   5094: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   5097: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5100: ldc_w 455
    //   5103: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5106: aload_0
    //   5107: getfield 458	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   5110: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5113: ldc_w 460
    //   5116: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5119: aload_0
    //   5120: invokevirtual 463	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   5123: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5126: ldc_w 465
    //   5129: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5132: astore 21
    //   5134: aload_0
    //   5135: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5138: ifnull +726 -> 5864
    //   5141: aload_0
    //   5142: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5145: invokeinterface 182 1 0
    //   5150: astore 17
    //   5152: aload 19
    //   5154: aload 21
    //   5156: aload 17
    //   5158: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5161: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5164: putfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5167: ldc_w 470
    //   5170: aload 19
    //   5172: getfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5175: aload 15
    //   5177: invokestatic 474	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5180: iload 8
    //   5182: ifne +8 -> 5190
    //   5185: aload_0
    //   5186: iconst_0
    //   5187: putfield 477	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   5190: aload_2
    //   5191: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5194: astore 17
    //   5196: new 237	java/lang/StringBuilder
    //   5199: dup
    //   5200: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   5203: aload_0
    //   5204: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   5207: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5210: ldc_w 479
    //   5213: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5216: aconst_null
    //   5217: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5220: ldc_w 481
    //   5223: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5226: aload_2
    //   5227: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5230: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5233: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5236: ldc_w 483
    //   5239: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5242: astore 21
    //   5244: aload_0
    //   5245: getfield 487	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5248: ifnull +1155 -> 6403
    //   5251: aload_0
    //   5252: getfield 487	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5255: getfield 490	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5258: istore 5
    //   5260: aload 21
    //   5262: iload 5
    //   5264: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5267: ldc_w 428
    //   5270: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5273: iload_3
    //   5274: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5277: ldc_w 386
    //   5280: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5283: aload_2
    //   5284: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5287: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5290: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5293: ldc_w 398
    //   5296: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5299: aload_2
    //   5300: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5303: getfield 401	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5306: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5309: ldc_w 403
    //   5312: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5315: aload_2
    //   5316: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5319: getfield 406	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5322: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5325: ldc_w 391
    //   5328: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5331: aload_2
    //   5332: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5335: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5338: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5341: ldc_w 396
    //   5344: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5347: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   5350: aload_0
    //   5351: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   5354: lsub
    //   5355: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5358: astore 21
    //   5360: aload 16
    //   5362: invokestatic 496	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5365: ifne +1044 -> 6409
    //   5368: new 237	java/lang/StringBuilder
    //   5371: dup
    //   5372: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   5375: ldc_w 432
    //   5378: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5381: aload 16
    //   5383: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5386: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5389: astore 16
    //   5391: aload 17
    //   5393: aload 21
    //   5395: aload 16
    //   5397: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5400: ldc_w 430
    //   5403: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5406: aload 20
    //   5408: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5411: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5414: putfield 499	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   5417: iload 8
    //   5419: ifeq +64 -> 5483
    //   5422: aload_0
    //   5423: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   5426: invokestatic 504	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   5429: astore 16
    //   5431: aload_0
    //   5432: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5435: astore 17
    //   5437: aload_0
    //   5438: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   5441: ifeq +976 -> 6417
    //   5444: aload_0
    //   5445: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5448: ifnull +969 -> 6417
    //   5451: aload_0
    //   5452: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5455: ldc_w 506
    //   5458: invokevirtual 510	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5461: ifeq +956 -> 6417
    //   5464: iconst_1
    //   5465: istore 8
    //   5467: aload 16
    //   5469: aload 17
    //   5471: iload 8
    //   5473: aload_2
    //   5474: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5477: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5480: invokevirtual 514	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   5483: aload 19
    //   5485: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   5488: putfield 517	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   5491: aload 19
    //   5493: aload_0
    //   5494: invokevirtual 520	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   5497: putfield 523	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   5500: aload 19
    //   5502: aload 14
    //   5504: putfield 527	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   5507: aload 19
    //   5509: iload_3
    //   5510: putfield 528	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   5513: aload 19
    //   5515: aload 15
    //   5517: putfield 532	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   5520: aload 18
    //   5522: ifnonnull +901 -> 6423
    //   5525: aconst_null
    //   5526: astore 15
    //   5528: aload 19
    //   5530: aload 15
    //   5532: putfield 535	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   5535: aload 19
    //   5537: aconst_null
    //   5538: putfield 538	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   5541: aload 19
    //   5543: aload_2
    //   5544: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5547: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5550: putfield 539	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   5553: aload 19
    //   5555: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   5558: aload_0
    //   5559: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   5562: lsub
    //   5563: putfield 542	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5566: aload 19
    //   5568: aload_2
    //   5569: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5572: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5575: putfield 545	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   5578: aload 19
    //   5580: aload 19
    //   5582: getfield 542	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5585: aload_2
    //   5586: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5589: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5592: lsub
    //   5593: putfield 548	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   5596: aload 19
    //   5598: lconst_0
    //   5599: putfield 551	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   5602: aload 19
    //   5604: aload_0
    //   5605: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   5608: putfield 554	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   5611: aload 19
    //   5613: aload_0
    //   5614: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   5617: putfield 557	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   5620: aload 19
    //   5622: aload_0
    //   5623: getfield 458	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   5626: putfield 560	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   5629: aload 19
    //   5631: lconst_0
    //   5632: putfield 563	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   5635: aload 19
    //   5637: aload_0
    //   5638: invokevirtual 463	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   5641: putfield 566	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   5644: aload 19
    //   5646: aload_2
    //   5647: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5650: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5653: putfield 569	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   5656: aload 19
    //   5658: aload_0
    //   5659: invokevirtual 145	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   5662: invokestatic 572	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   5665: putfield 574	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   5668: aload 19
    //   5670: aload_0
    //   5671: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   5674: putfield 577	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   5677: aload_0
    //   5678: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5681: ifnull +752 -> 6433
    //   5684: aload_0
    //   5685: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5688: ldc_w 506
    //   5691: invokevirtual 510	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5694: ifeq +739 -> 6433
    //   5697: iconst_1
    //   5698: istore 8
    //   5700: aload 19
    //   5702: iload 8
    //   5704: putfield 580	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   5707: aload 19
    //   5709: aload_2
    //   5710: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5713: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5716: putfield 582	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   5719: aload 19
    //   5721: getstatic 588	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   5724: invokevirtual 591	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   5727: putfield 594	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   5730: aload 19
    //   5732: aload_0
    //   5733: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   5736: invokevirtual 597	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   5739: putfield 600	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   5742: aload 19
    //   5744: aload_0
    //   5745: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   5748: invokevirtual 603	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeMergePhase	()J
    //   5751: putfield 606	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeMergePhase	J
    //   5754: aload 14
    //   5756: ifnull +24 -> 5780
    //   5759: aload 14
    //   5761: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5764: ifnull +16 -> 5780
    //   5767: aload 19
    //   5769: aload 14
    //   5771: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5774: invokevirtual 344	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5777: putfield 608	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   5780: aload 19
    //   5782: aload_0
    //   5783: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   5786: invokevirtual 612	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   5789: putfield 616	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   5792: aload 19
    //   5794: aload_0
    //   5795: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   5798: invokevirtual 619	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   5801: putfield 622	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   5804: aload_2
    //   5805: aload 19
    //   5807: invokevirtual 626	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5810: aload_2
    //   5811: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5814: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5817: ifeq +11 -> 5828
    //   5820: aload_0
    //   5821: aload_1
    //   5822: aload_2
    //   5823: aload 19
    //   5825: invokevirtual 89	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5828: aload_0
    //   5829: aconst_null
    //   5830: putfield 160	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   5833: iload 4
    //   5835: iconst_1
    //   5836: iadd
    //   5837: istore_3
    //   5838: goto -2011 -> 3827
    //   5841: aconst_null
    //   5842: astore 16
    //   5844: goto -1256 -> 4588
    //   5847: ldc_w 630
    //   5850: astore 17
    //   5852: goto -1136 -> 4716
    //   5855: aload_0
    //   5856: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5859: astore 17
    //   5861: goto -859 -> 5002
    //   5864: aconst_null
    //   5865: astore 17
    //   5867: goto -715 -> 5152
    //   5870: new 237	java/lang/StringBuilder
    //   5873: dup
    //   5874: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   5877: ldc_w 632
    //   5880: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5883: aload_0
    //   5884: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   5887: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5890: ldc_w 328
    //   5893: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5896: aload_0
    //   5897: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   5900: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5903: ldc_w 337
    //   5906: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5909: astore 21
    //   5911: aload_0
    //   5912: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   5915: ifeq +465 -> 6380
    //   5918: aload 14
    //   5920: ifnull +460 -> 6380
    //   5923: aload 14
    //   5925: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5928: ifnull +452 -> 6380
    //   5931: aload 14
    //   5933: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5936: invokevirtual 344	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5939: astore 17
    //   5941: aload 21
    //   5943: aload 17
    //   5945: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5948: ldc_w 346
    //   5951: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5954: aload 18
    //   5956: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5959: ldc_w 351
    //   5962: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5965: aconst_null
    //   5966: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5969: ldc_w 353
    //   5972: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5975: aconst_null
    //   5976: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5979: ldc_w 355
    //   5982: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5985: invokestatic 359	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5988: invokevirtual 362	java/lang/Thread:getId	()J
    //   5991: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5994: ldc_w 367
    //   5997: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6000: invokestatic 372	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   6003: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6006: ldc_w 376
    //   6009: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6012: invokestatic 381	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6015: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6018: ldc_w 391
    //   6021: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6024: aload_2
    //   6025: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6028: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6031: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6034: ldc_w 396
    //   6037: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6040: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   6043: aload_0
    //   6044: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   6047: lsub
    //   6048: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6051: ldc_w 398
    //   6054: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6057: aload_2
    //   6058: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6061: getfield 401	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6064: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6067: ldc_w 403
    //   6070: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6073: aload_2
    //   6074: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6077: getfield 406	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6080: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6083: ldc_w 408
    //   6086: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6089: aload_2
    //   6090: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6093: getfield 411	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   6096: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6099: ldc_w 413
    //   6102: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6105: aload_0
    //   6106: invokevirtual 416	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   6109: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6112: ldc_w 418
    //   6115: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6118: aload_0
    //   6119: invokevirtual 421	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   6122: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6125: ldc_w 634
    //   6128: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6131: iload_3
    //   6132: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6135: ldc_w 430
    //   6138: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6141: aload 20
    //   6143: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6146: ldc_w 386
    //   6149: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6152: aload_2
    //   6153: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6156: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6159: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6162: ldc_w 432
    //   6165: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6168: aload 16
    //   6170: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6173: ldc_w 434
    //   6176: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6179: astore 21
    //   6181: aload_0
    //   6182: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   6185: ifnull +203 -> 6388
    //   6188: aload_0
    //   6189: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   6192: iconst_0
    //   6193: bipush 30
    //   6195: invokevirtual 440	java/lang/String:substring	(II)Ljava/lang/String;
    //   6198: astore 17
    //   6200: aload 21
    //   6202: aload 17
    //   6204: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6207: ldc_w 442
    //   6210: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6213: aload_2
    //   6214: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6217: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6220: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6223: ldc_w 447
    //   6226: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6229: lconst_0
    //   6230: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6233: ldc_w 449
    //   6236: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6239: aload_0
    //   6240: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   6243: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6246: ldc_w 418
    //   6249: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6252: aload_0
    //   6253: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   6256: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6259: ldc_w 451
    //   6262: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6265: aload_0
    //   6266: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   6269: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6272: ldc_w 418
    //   6275: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6278: aload_0
    //   6279: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   6282: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6285: ldc_w 453
    //   6288: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6291: aload_0
    //   6292: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   6295: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6298: ldc_w 455
    //   6301: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6304: aload_0
    //   6305: getfield 458	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   6308: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6311: ldc_w 460
    //   6314: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6317: aload_0
    //   6318: invokevirtual 463	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   6321: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6324: ldc_w 465
    //   6327: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6330: astore 21
    //   6332: aload_0
    //   6333: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6336: ifnull +61 -> 6397
    //   6339: aload_0
    //   6340: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6343: invokeinterface 182 1 0
    //   6348: astore 17
    //   6350: aload 19
    //   6352: aload 21
    //   6354: aload 17
    //   6356: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6359: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6362: putfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   6365: ldc_w 470
    //   6368: aload 19
    //   6370: getfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   6373: aconst_null
    //   6374: invokestatic 637	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6377: goto -1197 -> 5180
    //   6380: ldc_w 630
    //   6383: astore 17
    //   6385: goto -444 -> 5941
    //   6388: aload_0
    //   6389: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   6392: astore 17
    //   6394: goto -194 -> 6200
    //   6397: aconst_null
    //   6398: astore 17
    //   6400: goto -50 -> 6350
    //   6403: iconst_0
    //   6404: istore 5
    //   6406: goto -1146 -> 5260
    //   6409: ldc_w 639
    //   6412: astore 16
    //   6414: goto -1023 -> 5391
    //   6417: iconst_0
    //   6418: istore 8
    //   6420: goto -953 -> 5467
    //   6423: aload 18
    //   6425: invokevirtual 642	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   6428: astore 15
    //   6430: goto -902 -> 5528
    //   6433: iconst_0
    //   6434: istore 8
    //   6436: goto -736 -> 5700
    //   6439: astore 14
    //   6441: aconst_null
    //   6442: astore 15
    //   6444: iload 6
    //   6446: istore_3
    //   6447: aload_2
    //   6448: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6451: lload 10
    //   6453: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   6456: invokevirtual 281	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   6459: aload_2
    //   6460: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6463: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   6466: aload_0
    //   6467: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   6470: lsub
    //   6471: putfield 284	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   6474: aload_2
    //   6475: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6478: aload_0
    //   6479: getfield 287	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   6482: putfield 290	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   6485: aload_0
    //   6486: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   6489: invokestatic 296	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   6492: invokevirtual 300	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   6495: astore 20
    //   6497: aload_0
    //   6498: aconst_null
    //   6499: aconst_null
    //   6500: aload 16
    //   6502: invokevirtual 304	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   6505: astore 21
    //   6507: aload 16
    //   6509: ifnull +1272 -> 7781
    //   6512: aload 16
    //   6514: invokevirtual 307	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   6517: ifnull +1264 -> 7781
    //   6520: aload 16
    //   6522: invokevirtual 307	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   6525: ldc_w 309
    //   6528: invokevirtual 312	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   6531: astore 17
    //   6533: aload_2
    //   6534: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6537: aload 17
    //   6539: putfield 321	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   6542: aload_0
    //   6543: lconst_0
    //   6544: putfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   6547: aload_0
    //   6548: iconst_0
    //   6549: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   6552: aload_0
    //   6553: lconst_0
    //   6554: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   6557: aload_0
    //   6558: iconst_0
    //   6559: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   6562: aload_1
    //   6563: invokeinterface 85 1 0
    //   6568: ifne +1205 -> 7773
    //   6571: aload_0
    //   6572: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   6575: invokestatic 99	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   6578: istore 8
    //   6580: aload_2
    //   6581: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6584: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6587: ifne +1223 -> 7810
    //   6590: new 237	java/lang/StringBuilder
    //   6593: dup
    //   6594: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   6597: ldc_w 326
    //   6600: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6603: aload_0
    //   6604: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   6607: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6610: ldc_w 328
    //   6613: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6616: aload_0
    //   6617: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   6620: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6623: ldc_w 337
    //   6626: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6629: astore 22
    //   6631: aload_0
    //   6632: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   6635: ifeq +1152 -> 7787
    //   6638: aload 16
    //   6640: ifnull +1147 -> 7787
    //   6643: aload 16
    //   6645: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6648: ifnull +1139 -> 7787
    //   6651: aload 16
    //   6653: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6656: invokevirtual 344	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   6659: astore 18
    //   6661: aload 22
    //   6663: aload 18
    //   6665: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6668: ldc_w 346
    //   6671: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6674: aload 20
    //   6676: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6679: ldc_w 351
    //   6682: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6685: aconst_null
    //   6686: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6689: ldc_w 353
    //   6692: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6695: aconst_null
    //   6696: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6699: ldc_w 355
    //   6702: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6705: invokestatic 359	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6708: invokevirtual 362	java/lang/Thread:getId	()J
    //   6711: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6714: ldc_w 367
    //   6717: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6720: invokestatic 372	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   6723: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6726: ldc_w 374
    //   6729: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6732: iload 8
    //   6734: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6737: ldc_w 376
    //   6740: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6743: invokestatic 381	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6746: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6749: ldc_w 386
    //   6752: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6755: aload_2
    //   6756: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6759: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6762: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6765: ldc_w 391
    //   6768: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6771: aload_2
    //   6772: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6775: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6778: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6781: ldc_w 396
    //   6784: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6787: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   6790: aload_0
    //   6791: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   6794: lsub
    //   6795: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6798: ldc_w 398
    //   6801: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6804: aload_2
    //   6805: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6808: getfield 401	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6811: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6814: ldc_w 403
    //   6817: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6820: aload_2
    //   6821: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6824: getfield 406	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6827: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6830: ldc_w 408
    //   6833: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6836: aload_2
    //   6837: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6840: getfield 411	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   6843: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6846: ldc_w 413
    //   6849: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6852: aload_0
    //   6853: invokevirtual 416	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   6856: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6859: ldc_w 418
    //   6862: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6865: aload_0
    //   6866: invokevirtual 421	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   6869: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6872: ldc_w 423
    //   6875: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6878: aload_2
    //   6879: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6882: invokevirtual 426	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   6885: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6888: ldc_w 428
    //   6891: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6894: iload_3
    //   6895: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6898: ldc_w 430
    //   6901: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6904: aload 21
    //   6906: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6909: ldc_w 432
    //   6912: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6915: aload 17
    //   6917: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6920: ldc_w 434
    //   6923: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6926: astore 22
    //   6928: aload_0
    //   6929: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   6932: ifnull +863 -> 7795
    //   6935: aload_0
    //   6936: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   6939: iconst_0
    //   6940: bipush 30
    //   6942: invokevirtual 440	java/lang/String:substring	(II)Ljava/lang/String;
    //   6945: astore 18
    //   6947: aload 22
    //   6949: aload 18
    //   6951: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6954: ldc_w 442
    //   6957: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6960: aload_2
    //   6961: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6964: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6967: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6970: ldc_w 447
    //   6973: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6976: lconst_0
    //   6977: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6980: ldc_w 449
    //   6983: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6986: aload_0
    //   6987: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   6990: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6993: ldc_w 418
    //   6996: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6999: aload_0
    //   7000: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   7003: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7006: ldc_w 451
    //   7009: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7012: aload_0
    //   7013: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   7016: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7019: ldc_w 418
    //   7022: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7025: aload_0
    //   7026: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   7029: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7032: ldc_w 453
    //   7035: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7038: aload_0
    //   7039: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   7042: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7045: ldc_w 455
    //   7048: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7051: aload_0
    //   7052: getfield 458	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   7055: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7058: ldc_w 460
    //   7061: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7064: aload_0
    //   7065: invokevirtual 463	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   7068: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7071: ldc_w 465
    //   7074: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7077: astore 22
    //   7079: aload_0
    //   7080: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7083: ifnull +721 -> 7804
    //   7086: aload_0
    //   7087: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7090: invokeinterface 182 1 0
    //   7095: astore 18
    //   7097: aload 19
    //   7099: aload 22
    //   7101: aload 18
    //   7103: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7106: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7109: putfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7112: ldc_w 470
    //   7115: aload 19
    //   7117: getfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7120: aload 15
    //   7122: invokestatic 474	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7125: iload 8
    //   7127: ifne +8 -> 7135
    //   7130: aload_0
    //   7131: iconst_0
    //   7132: putfield 477	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   7135: aload_2
    //   7136: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7139: astore 18
    //   7141: new 237	java/lang/StringBuilder
    //   7144: dup
    //   7145: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   7148: aload_0
    //   7149: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   7152: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7155: ldc_w 479
    //   7158: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7161: aconst_null
    //   7162: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7165: ldc_w 481
    //   7168: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7171: aload_2
    //   7172: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7175: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7178: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7181: ldc_w 483
    //   7184: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7187: astore 22
    //   7189: aload_0
    //   7190: getfield 487	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7193: ifnull +1150 -> 8343
    //   7196: aload_0
    //   7197: getfield 487	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7200: getfield 490	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7203: istore 4
    //   7205: aload 22
    //   7207: iload 4
    //   7209: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7212: ldc_w 428
    //   7215: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7218: iload_3
    //   7219: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7222: ldc_w 386
    //   7225: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7228: aload_2
    //   7229: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7232: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7235: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7238: ldc_w 398
    //   7241: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7244: aload_2
    //   7245: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7248: getfield 401	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7251: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7254: ldc_w 403
    //   7257: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7260: aload_2
    //   7261: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7264: getfield 406	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7267: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7270: ldc_w 391
    //   7273: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7276: aload_2
    //   7277: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7280: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7283: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7286: ldc_w 396
    //   7289: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7292: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   7295: aload_0
    //   7296: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   7299: lsub
    //   7300: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7303: astore 22
    //   7305: aload 17
    //   7307: invokestatic 496	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7310: ifne +1039 -> 8349
    //   7313: new 237	java/lang/StringBuilder
    //   7316: dup
    //   7317: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   7320: ldc_w 432
    //   7323: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7326: aload 17
    //   7328: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7331: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7334: astore 17
    //   7336: aload 18
    //   7338: aload 22
    //   7340: aload 17
    //   7342: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7345: ldc_w 430
    //   7348: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7351: aload 21
    //   7353: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7356: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7359: putfield 499	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   7362: iload 8
    //   7364: ifeq +64 -> 7428
    //   7367: aload_0
    //   7368: getfield 93	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   7371: invokestatic 504	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   7374: astore 17
    //   7376: aload_0
    //   7377: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7380: astore 18
    //   7382: aload_0
    //   7383: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   7386: ifeq +971 -> 8357
    //   7389: aload_0
    //   7390: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7393: ifnull +964 -> 8357
    //   7396: aload_0
    //   7397: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7400: ldc_w 506
    //   7403: invokevirtual 510	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7406: ifeq +951 -> 8357
    //   7409: iconst_1
    //   7410: istore 8
    //   7412: aload 17
    //   7414: aload 18
    //   7416: iload 8
    //   7418: aload_2
    //   7419: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7422: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7425: invokevirtual 514	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   7428: aload 19
    //   7430: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   7433: putfield 517	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   7436: aload 19
    //   7438: aload_0
    //   7439: invokevirtual 520	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   7442: putfield 523	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   7445: aload 19
    //   7447: aload 16
    //   7449: putfield 527	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   7452: aload 19
    //   7454: iload_3
    //   7455: putfield 528	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   7458: aload 19
    //   7460: aload 15
    //   7462: putfield 532	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   7465: aload 20
    //   7467: ifnonnull +896 -> 8363
    //   7470: aconst_null
    //   7471: astore 15
    //   7473: aload 19
    //   7475: aload 15
    //   7477: putfield 535	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   7480: aload 19
    //   7482: aconst_null
    //   7483: putfield 538	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   7486: aload 19
    //   7488: aload_2
    //   7489: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7492: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7495: putfield 539	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   7498: aload 19
    //   7500: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   7503: aload_0
    //   7504: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   7507: lsub
    //   7508: putfield 542	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   7511: aload 19
    //   7513: aload_2
    //   7514: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7517: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7520: putfield 545	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   7523: aload 19
    //   7525: aload 19
    //   7527: getfield 542	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   7530: aload_2
    //   7531: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7534: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7537: lsub
    //   7538: putfield 548	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   7541: aload 19
    //   7543: lconst_0
    //   7544: putfield 551	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   7547: aload 19
    //   7549: aload_0
    //   7550: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   7553: putfield 554	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   7556: aload 19
    //   7558: aload_0
    //   7559: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   7562: putfield 557	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   7565: aload 19
    //   7567: aload_0
    //   7568: getfield 458	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   7571: putfield 560	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   7574: aload 19
    //   7576: lconst_0
    //   7577: putfield 563	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   7580: aload 19
    //   7582: aload_0
    //   7583: invokevirtual 463	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   7586: putfield 566	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   7589: aload 19
    //   7591: aload_2
    //   7592: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7595: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7598: putfield 569	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   7601: aload 19
    //   7603: aload_0
    //   7604: invokevirtual 145	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   7607: invokestatic 572	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   7610: putfield 574	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   7613: aload 19
    //   7615: aload_0
    //   7616: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   7619: putfield 577	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   7622: aload_0
    //   7623: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7626: ifnull +747 -> 8373
    //   7629: aload_0
    //   7630: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7633: ldc_w 506
    //   7636: invokevirtual 510	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7639: ifeq +734 -> 8373
    //   7642: iconst_1
    //   7643: istore 8
    //   7645: aload 19
    //   7647: iload 8
    //   7649: putfield 580	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   7652: aload 19
    //   7654: aload_2
    //   7655: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7658: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7661: putfield 582	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   7664: aload 19
    //   7666: getstatic 588	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   7669: invokevirtual 591	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   7672: putfield 594	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   7675: aload 19
    //   7677: aload_0
    //   7678: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   7681: invokevirtual 597	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   7684: putfield 600	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   7687: aload 19
    //   7689: aload_0
    //   7690: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   7693: invokevirtual 603	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeMergePhase	()J
    //   7696: putfield 606	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeMergePhase	J
    //   7699: aload 16
    //   7701: ifnull +24 -> 7725
    //   7704: aload 16
    //   7706: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7709: ifnull +16 -> 7725
    //   7712: aload 19
    //   7714: aload 16
    //   7716: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7719: invokevirtual 344	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   7722: putfield 608	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   7725: aload 19
    //   7727: aload_0
    //   7728: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   7731: invokevirtual 612	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   7734: putfield 616	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   7737: aload 19
    //   7739: aload_0
    //   7740: getfield 51	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   7743: invokevirtual 619	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   7746: putfield 622	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   7749: aload_2
    //   7750: aload 19
    //   7752: invokevirtual 626	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   7755: aload_2
    //   7756: invokevirtual 108	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7759: invokevirtual 324	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7762: ifeq +11 -> 7773
    //   7765: aload_0
    //   7766: aload_1
    //   7767: aload_2
    //   7768: aload 19
    //   7770: invokevirtual 89	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   7773: aload_0
    //   7774: aconst_null
    //   7775: putfield 160	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   7778: aload 14
    //   7780: athrow
    //   7781: aconst_null
    //   7782: astore 17
    //   7784: goto -1251 -> 6533
    //   7787: ldc_w 630
    //   7790: astore 18
    //   7792: goto -1131 -> 6661
    //   7795: aload_0
    //   7796: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7799: astore 18
    //   7801: goto -854 -> 6947
    //   7804: aconst_null
    //   7805: astore 18
    //   7807: goto -710 -> 7097
    //   7810: new 237	java/lang/StringBuilder
    //   7813: dup
    //   7814: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   7817: ldc_w 632
    //   7820: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7823: aload_0
    //   7824: invokevirtual 68	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   7827: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7830: ldc_w 328
    //   7833: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7836: aload_0
    //   7837: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   7840: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7843: ldc_w 337
    //   7846: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7849: astore 22
    //   7851: aload_0
    //   7852: getfield 332	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   7855: ifeq +465 -> 8320
    //   7858: aload 16
    //   7860: ifnull +460 -> 8320
    //   7863: aload 16
    //   7865: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7868: ifnull +452 -> 8320
    //   7871: aload 16
    //   7873: invokevirtual 341	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7876: invokevirtual 344	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   7879: astore 18
    //   7881: aload 22
    //   7883: aload 18
    //   7885: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7888: ldc_w 346
    //   7891: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7894: aload 20
    //   7896: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7899: ldc_w 351
    //   7902: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7905: aconst_null
    //   7906: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7909: ldc_w 353
    //   7912: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7915: aconst_null
    //   7916: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7919: ldc_w 355
    //   7922: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7925: invokestatic 359	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7928: invokevirtual 362	java/lang/Thread:getId	()J
    //   7931: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7934: ldc_w 367
    //   7937: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7940: invokestatic 372	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7943: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7946: ldc_w 376
    //   7949: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7952: invokestatic 381	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7955: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7958: ldc_w 391
    //   7961: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7964: aload_2
    //   7965: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7968: getfield 394	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7971: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7974: ldc_w 396
    //   7977: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7980: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   7983: aload_0
    //   7984: getfield 30	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   7987: lsub
    //   7988: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7991: ldc_w 398
    //   7994: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7997: aload_2
    //   7998: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8001: getfield 401	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8004: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8007: ldc_w 403
    //   8010: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8013: aload_2
    //   8014: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8017: getfield 406	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8020: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8023: ldc_w 408
    //   8026: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8029: aload_2
    //   8030: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8033: getfield 411	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8036: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8039: ldc_w 413
    //   8042: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8045: aload_0
    //   8046: invokevirtual 416	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   8049: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8052: ldc_w 418
    //   8055: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8058: aload_0
    //   8059: invokevirtual 421	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   8062: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8065: ldc_w 634
    //   8068: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8071: iload_3
    //   8072: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8075: ldc_w 430
    //   8078: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8081: aload 21
    //   8083: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8086: ldc_w 386
    //   8089: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8092: aload_2
    //   8093: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8096: getfield 389	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8099: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8102: ldc_w 432
    //   8105: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8108: aload 17
    //   8110: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8113: ldc_w 434
    //   8116: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8119: astore 22
    //   8121: aload_0
    //   8122: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   8125: ifnull +203 -> 8328
    //   8128: aload_0
    //   8129: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   8132: iconst_0
    //   8133: bipush 30
    //   8135: invokevirtual 440	java/lang/String:substring	(II)Ljava/lang/String;
    //   8138: astore 18
    //   8140: aload 22
    //   8142: aload 18
    //   8144: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8147: ldc_w 442
    //   8150: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8153: aload_2
    //   8154: invokevirtual 316	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8157: getfield 445	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8160: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8163: ldc_w 447
    //   8166: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8169: lconst_0
    //   8170: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8173: ldc_w 449
    //   8176: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8179: aload_0
    //   8180: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   8183: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8186: ldc_w 418
    //   8189: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8192: aload_0
    //   8193: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   8196: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8199: ldc_w 451
    //   8202: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8205: aload_0
    //   8206: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   8209: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8212: ldc_w 418
    //   8215: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8218: aload_0
    //   8219: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   8222: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8225: ldc_w 453
    //   8228: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8231: aload_0
    //   8232: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   8235: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8238: ldc_w 455
    //   8241: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8244: aload_0
    //   8245: getfield 458	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   8248: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8251: ldc_w 460
    //   8254: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8257: aload_0
    //   8258: invokevirtual 463	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   8261: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8264: ldc_w 465
    //   8267: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8270: astore 22
    //   8272: aload_0
    //   8273: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8276: ifnull +61 -> 8337
    //   8279: aload_0
    //   8280: getfield 176	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8283: invokeinterface 182 1 0
    //   8288: astore 18
    //   8290: aload 19
    //   8292: aload 22
    //   8294: aload 18
    //   8296: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8299: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8302: putfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8305: ldc_w 470
    //   8308: aload 19
    //   8310: getfield 468	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8313: aconst_null
    //   8314: invokestatic 637	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8317: goto -1192 -> 7125
    //   8320: ldc_w 630
    //   8323: astore 18
    //   8325: goto -444 -> 7881
    //   8328: aload_0
    //   8329: getfield 200	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   8332: astore 18
    //   8334: goto -194 -> 8140
    //   8337: aconst_null
    //   8338: astore 18
    //   8340: goto -50 -> 8290
    //   8343: iconst_0
    //   8344: istore 4
    //   8346: goto -1141 -> 7205
    //   8349: ldc_w 639
    //   8352: astore 17
    //   8354: goto -1018 -> 7336
    //   8357: iconst_0
    //   8358: istore 8
    //   8360: goto -948 -> 7412
    //   8363: aload 20
    //   8365: invokevirtual 642	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   8368: astore 15
    //   8370: goto -897 -> 7473
    //   8373: iconst_0
    //   8374: istore 8
    //   8376: goto -731 -> 7645
    //   8379: astore 17
    //   8381: aconst_null
    //   8382: astore 15
    //   8384: aload 14
    //   8386: astore 16
    //   8388: aload 17
    //   8390: astore 14
    //   8392: iload 6
    //   8394: istore_3
    //   8395: goto -1948 -> 6447
    //   8398: astore 17
    //   8400: aconst_null
    //   8401: astore 15
    //   8403: aload 14
    //   8405: astore 16
    //   8407: aload 17
    //   8409: astore 14
    //   8411: goto -1964 -> 6447
    //   8414: astore 15
    //   8416: aconst_null
    //   8417: astore 17
    //   8419: aload 14
    //   8421: astore 16
    //   8423: aload 15
    //   8425: astore 14
    //   8427: aload 17
    //   8429: astore 15
    //   8431: goto -1984 -> 6447
    //   8434: astore 17
    //   8436: aload 14
    //   8438: astore 16
    //   8440: aload 17
    //   8442: astore 14
    //   8444: goto -1997 -> 6447
    //   8447: astore 15
    //   8449: goto -3992 -> 4457
    //   8452: astore 15
    //   8454: goto -3997 -> 4457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8457	0	this	RangeDownloadTask
    //   0	8457	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	8457	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   167	8228	3	i	int
    //   26	8319	4	j	int
    //   442	5963	5	k	int
    //   164	8229	6	m	int
    //   18	107	7	n	int
    //   616	7759	8	bool1	boolean
    //   23	60	9	bool2	boolean
    //   111	6341	10	l1	long
    //   332	47	12	l2	long
    //   96	1	14	localException	java.lang.Exception
    //   195	5737	14	localObject1	java.lang.Object
    //   6439	1946	14	localObject2	java.lang.Object
    //   8390	53	14	localObject3	java.lang.Object
    //   177	4265	15	localObject4	java.lang.Object
    //   4452	1064	15	localThrowable1	java.lang.Throwable
    //   5526	2876	15	str	String
    //   8414	10	15	localObject5	java.lang.Object
    //   8429	1	15	localObject6	java.lang.Object
    //   8447	1	15	localThrowable2	java.lang.Throwable
    //   8452	1	15	localThrowable3	java.lang.Throwable
    //   161	8278	16	localObject7	java.lang.Object
    //   533	7820	17	localObject8	java.lang.Object
    //   8379	10	17	localObject9	java.lang.Object
    //   8398	10	17	localObject10	java.lang.Object
    //   8417	11	17	localObject11	java.lang.Object
    //   8434	7	17	localObject12	java.lang.Object
    //   543	7796	18	localObject13	java.lang.Object
    //   120	8189	19	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   667	7697	20	localObject14	java.lang.Object
    //   4684	3398	21	localObject15	java.lang.Object
    //   6629	1664	22	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   76	82	96	java/lang/Exception
    //   168	197	4452	java/lang/Throwable
    //   197	288	4452	java/lang/Throwable
    //   288	432	4452	java/lang/Throwable
    //   1821	1861	4452	java/lang/Throwable
    //   168	197	6439	finally
    //   197	288	6439	finally
    //   288	432	6439	finally
    //   1821	1861	6439	finally
    //   437	444	8379	finally
    //   3840	3848	8379	finally
    //   447	455	8398	finally
    //   465	485	8398	finally
    //   2468	2489	8398	finally
    //   4457	4493	8414	finally
    //   4493	4502	8434	finally
    //   437	444	8447	java/lang/Throwable
    //   3840	3848	8447	java/lang/Throwable
    //   447	455	8452	java/lang/Throwable
    //   465	485	8452	java/lang/Throwable
    //   2468	2489	8452	java/lang/Throwable
  }
  
  protected void initTask()
  {
    super.initTask();
    this.mRefer = HttpUtil.prepareRefer(getUrl());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.RangeDownloadTask
 * JD-Core Version:    0.7.0.1
 */