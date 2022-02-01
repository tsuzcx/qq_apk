package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.component.network.downloader.RangeDownloadManager;
import com.tencent.component.network.downloader.RangeDownloadManager.ProgressListener;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import okhttp3.OkHttpClient;

public class RangeDownloadTask
  extends DownloadTask
  implements RangeDownloadManager.ProgressListener
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
    this.mRangeDownloaderManager = new RangeDownloadManager(paramOkHttpClient, paramInt);
    this.mRangeDownloaderManager.setContentLength(paramLong);
  }
  
  /* Error */
  public void execute(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 62	java/lang/Object
    //   4: dup
    //   5: iconst_0
    //   6: aload_0
    //   7: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   10: aastore
    //   11: dup
    //   12: iconst_1
    //   13: aload_2
    //   14: aastore
    //   15: invokestatic 72	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:generateRandomId	([Ljava/lang/Object;)I
    //   18: istore 7
    //   20: invokestatic 78	com/tencent/component/network/utils/SDCardUtil:isSdCardHasEnoughCapability	()Z
    //   23: istore 9
    //   25: iconst_0
    //   26: istore 5
    //   28: aload_1
    //   29: invokeinterface 83 1 0
    //   34: ifeq +11 -> 45
    //   37: aload_0
    //   38: aload_1
    //   39: aload_2
    //   40: aconst_null
    //   41: invokevirtual 87	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   44: return
    //   45: aload_0
    //   46: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   49: invokestatic 97	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   52: ifne +30 -> 82
    //   55: iload 5
    //   57: aload_0
    //   58: getfield 100	com/tencent/component/network/downloader/impl/RangeDownloadTask:mAttemptTotalCount	I
    //   61: iconst_1
    //   62: isub
    //   63: if_icmpne +13 -> 76
    //   66: aload_2
    //   67: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   70: bipush 6
    //   72: invokevirtual 112	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   75: return
    //   76: ldc2_w 113
    //   79: invokestatic 119	java/lang/Thread:sleep	(J)V
    //   82: iload 9
    //   84: ifne +24 -> 108
    //   87: aload_2
    //   88: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   91: iconst_2
    //   92: invokevirtual 112	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   95: return
    //   96: astore 14
    //   98: ldc 121
    //   100: ldc 123
    //   102: invokestatic 129	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: goto -23 -> 82
    //   108: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   111: lstore 12
    //   113: new 131	com/tencent/component/network/downloader/DownloadReport
    //   116: dup
    //   117: invokespecial 134	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   120: astore 19
    //   122: aload 19
    //   124: iload 7
    //   126: putfield 137	com/tencent/component/network/downloader/DownloadReport:id	I
    //   129: aload 19
    //   131: aload_0
    //   132: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   135: putfield 140	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   138: aload 19
    //   140: aload_0
    //   141: invokevirtual 143	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   144: putfield 146	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   147: aload 19
    //   149: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   152: putfield 154	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 158	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   160: aconst_null
    //   161: astore 16
    //   163: iconst_0
    //   164: istore_3
    //   165: iconst_0
    //   166: istore 4
    //   168: iconst_0
    //   169: istore 6
    //   171: getstatic 162	com/tencent/component/network/downloader/impl/RangeDownloadTask:sRequestOptions	Ljava/lang/ThreadLocal;
    //   174: invokevirtual 168	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   177: checkcast 170	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   180: astore 15
    //   182: aload_0
    //   183: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   186: ifnull +1695 -> 1881
    //   189: aload_0
    //   190: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   193: invokeinterface 180 1 0
    //   198: astore 14
    //   200: aload 15
    //   202: aload 14
    //   204: putfield 184	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   207: aload 19
    //   209: iload 5
    //   211: putfield 187	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   214: aload 19
    //   216: aload_0
    //   217: getfield 189	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRefer	Ljava/lang/String;
    //   220: putfield 192	com/tencent/component/network/downloader/DownloadReport:refer	Ljava/lang/String;
    //   223: aload_0
    //   224: aload_0
    //   225: aload_0
    //   226: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   229: invokevirtual 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:prepareUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   232: putfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   235: aload_0
    //   236: aload_0
    //   237: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   240: aload_0
    //   241: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   244: aload_0
    //   245: invokevirtual 143	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   248: aload_0
    //   249: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   252: aload_0
    //   253: getfield 189	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRefer	Ljava/lang/String;
    //   256: invokestatic 204	com/tencent/component/network/utils/http/HttpUtil:createOkHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   259: putfield 158	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   262: aload_0
    //   263: getfield 208	com/tencent/component/network/downloader/impl/RangeDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   266: ifnull +25 -> 291
    //   269: aload_0
    //   270: getfield 208	com/tencent/component/network/downloader/impl/RangeDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   273: aconst_null
    //   274: aload_0
    //   275: getfield 158	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   278: aload_0
    //   279: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   282: aload_0
    //   283: invokevirtual 143	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   286: invokeinterface 214 5 0
    //   291: aload_0
    //   292: aload_0
    //   293: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   296: aload_0
    //   297: invokevirtual 143	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   300: aconst_null
    //   301: aload_0
    //   302: getfield 158	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   305: invokevirtual 217	com/tencent/component/network/downloader/impl/RangeDownloadTask:prepareRequest	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;)V
    //   308: aload_0
    //   309: aload_0
    //   310: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   313: aload_0
    //   314: invokevirtual 143	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   317: aconst_null
    //   318: aload_0
    //   319: getfield 158	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   322: aload 15
    //   324: invokevirtual 221	com/tencent/component/network/downloader/impl/RangeDownloadTask:applyKeepAliveStrategy	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   327: aload_0
    //   328: lconst_0
    //   329: putfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   332: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   335: lstore 10
    //   337: aload_0
    //   338: getfield 158	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   341: ifnull +4910 -> 5251
    //   344: aload_0
    //   345: invokevirtual 224	com/tencent/component/network/downloader/impl/RangeDownloadTask:generateStorageName	()Ljava/lang/String;
    //   348: astore 15
    //   350: aload_0
    //   351: aload 15
    //   353: invokevirtual 227	com/tencent/component/network/downloader/impl/RangeDownloadTask:generateStoragePath	(Ljava/lang/String;)Ljava/lang/String;
    //   356: astore 14
    //   358: aload_0
    //   359: aload 15
    //   361: iconst_0
    //   362: invokevirtual 230	com/tencent/component/network/downloader/impl/RangeDownloadTask:generateStoragePath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   365: astore 15
    //   367: aload_0
    //   368: aload 14
    //   370: aload_0
    //   371: getfield 233	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContentLength	J
    //   374: invokevirtual 237	com/tencent/component/network/downloader/impl/RangeDownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   377: ifeq +1510 -> 1887
    //   380: aload_2
    //   381: aload 14
    //   383: invokevirtual 241	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   386: aload_0
    //   387: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   390: aload_0
    //   391: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   394: aload_0
    //   395: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   398: aload_0
    //   399: getfield 158	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   402: aload_2
    //   403: invokevirtual 244	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   406: aload_0
    //   407: invokevirtual 248	com/tencent/component/network/downloader/RangeDownloadManager:tryBuildAllRangeRequests	(Ljava/lang/String;Ljava/lang/String;Lokhttp3/Request$Builder;Ljava/lang/String;Lcom/tencent/component/network/downloader/RangeDownloadManager$ProgressListener;)Z
    //   410: ifeq +4800 -> 5210
    //   413: aload_0
    //   414: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   417: aload_2
    //   418: invokevirtual 244	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   421: invokevirtual 252	com/tencent/component/network/downloader/RangeDownloadManager:createEmptyFile	(Ljava/lang/String;)Z
    //   424: ifeq +4786 -> 5210
    //   427: aload_0
    //   428: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   431: lload 10
    //   433: lsub
    //   434: putfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   437: ldc 254
    //   439: new 256	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 259
    //   449: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_0
    //   453: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   456: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: ldc_w 265
    //   462: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_0
    //   466: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   469: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 271	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   478: aload_2
    //   479: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   482: aload_0
    //   483: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   486: invokevirtual 278	com/tencent/component/network/downloader/RangeDownloadManager:getContentLength	()J
    //   489: putfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   492: aload_0
    //   493: aload_0
    //   494: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   497: invokevirtual 278	com/tencent/component/network/downloader/RangeDownloadManager:getContentLength	()J
    //   500: putfield 233	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContentLength	J
    //   503: aload_0
    //   504: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   507: invokevirtual 286	com/tencent/component/network/downloader/RangeDownloadManager:execute	()Lokhttp3/Response;
    //   510: astore 14
    //   512: aload_2
    //   513: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   516: aload_0
    //   517: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   520: invokevirtual 289	com/tencent/component/network/downloader/RangeDownloadManager:getTotalFileSize	()J
    //   523: putfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   526: aload 14
    //   528: ifnull +6673 -> 7201
    //   531: aload 14
    //   533: astore 16
    //   535: aload 14
    //   537: invokevirtual 298	okhttp3/Response:code	()I
    //   540: istore_3
    //   541: aload_2
    //   542: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   545: iload_3
    //   546: putfield 301	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   549: sipush 200
    //   552: iload_3
    //   553: if_icmpne +5302 -> 5855
    //   556: aload_2
    //   557: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   560: invokevirtual 304	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   563: aload_2
    //   564: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   567: lload 12
    //   569: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   572: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   575: aload_2
    //   576: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   579: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   582: aload_0
    //   583: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   586: lsub
    //   587: putfield 317	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   590: aload_2
    //   591: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   594: aload_0
    //   595: getfield 320	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   598: putfield 323	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   601: aload_0
    //   602: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   605: invokestatic 329	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   608: invokevirtual 333	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   611: astore 17
    //   613: aload_0
    //   614: aconst_null
    //   615: aconst_null
    //   616: aload 14
    //   618: invokevirtual 337	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   621: astore 18
    //   623: aload 14
    //   625: ifnull +4632 -> 5257
    //   628: aload 14
    //   630: invokevirtual 340	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   633: ifnull +4624 -> 5257
    //   636: aload 14
    //   638: invokevirtual 340	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   641: ldc_w 342
    //   644: invokevirtual 345	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   647: astore 15
    //   649: aload_2
    //   650: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   653: aload 15
    //   655: putfield 348	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   658: aload_0
    //   659: lconst_0
    //   660: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   663: aload_0
    //   664: iconst_0
    //   665: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   668: aload_0
    //   669: lconst_0
    //   670: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   673: aload_0
    //   674: iconst_0
    //   675: putfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   678: aload_1
    //   679: invokeinterface 83 1 0
    //   684: ifne +1191 -> 1875
    //   687: aload_0
    //   688: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   691: invokestatic 97	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   694: istore 8
    //   696: aload_2
    //   697: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   700: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   703: ifne +4583 -> 5286
    //   706: new 256	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   713: ldc_w 353
    //   716: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload_0
    //   720: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   723: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: ldc_w 355
    //   729: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: aload_0
    //   733: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   736: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   739: ldc_w 364
    //   742: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: astore 20
    //   747: aload_0
    //   748: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   751: ifeq +4512 -> 5263
    //   754: aload 14
    //   756: ifnull +4507 -> 5263
    //   759: aload 14
    //   761: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   764: ifnull +4499 -> 5263
    //   767: aload 14
    //   769: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   772: invokevirtual 371	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   775: astore 16
    //   777: aload 20
    //   779: aload 16
    //   781: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: ldc_w 373
    //   787: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: aload 17
    //   792: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   795: ldc_w 378
    //   798: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aconst_null
    //   802: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: ldc_w 380
    //   808: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: aconst_null
    //   812: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: ldc_w 382
    //   818: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: invokestatic 386	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   824: invokevirtual 389	java/lang/Thread:getId	()J
    //   827: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   830: ldc_w 394
    //   833: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: invokestatic 399	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   839: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: ldc_w 401
    //   845: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: iload 8
    //   850: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   853: ldc_w 403
    //   856: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokestatic 408	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   862: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   865: ldc_w 413
    //   868: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: aload_2
    //   872: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   875: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   878: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: ldc_w 418
    //   884: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: aload_2
    //   888: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   891: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   894: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   897: ldc_w 423
    //   900: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   906: aload_0
    //   907: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   910: lsub
    //   911: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   914: ldc_w 425
    //   917: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: aload_2
    //   921: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   924: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   927: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   930: ldc_w 427
    //   933: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: aload_2
    //   937: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   940: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   943: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   946: ldc_w 429
    //   949: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: aload_2
    //   953: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   956: getfield 432	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   959: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   962: ldc_w 434
    //   965: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: aload_0
    //   969: invokevirtual 437	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   972: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   975: ldc_w 439
    //   978: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: aload_0
    //   982: invokevirtual 442	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   985: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   988: ldc_w 444
    //   991: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: aload_2
    //   995: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   998: invokevirtual 447	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   1001: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1004: ldc_w 449
    //   1007: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: iload_3
    //   1011: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1014: ldc_w 451
    //   1017: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: aload 18
    //   1022: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: ldc_w 453
    //   1028: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: aload 15
    //   1033: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: ldc_w 455
    //   1039: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: astore 20
    //   1044: aload_0
    //   1045: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1048: ifnull +4223 -> 5271
    //   1051: aload_0
    //   1052: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1055: iconst_0
    //   1056: bipush 30
    //   1058: invokevirtual 461	java/lang/String:substring	(II)Ljava/lang/String;
    //   1061: astore 16
    //   1063: aload 20
    //   1065: aload 16
    //   1067: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: ldc_w 463
    //   1073: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: aload_2
    //   1077: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1080: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1083: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: ldc_w 468
    //   1089: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: lconst_0
    //   1093: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1096: ldc_w 470
    //   1099: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: aload_0
    //   1103: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   1106: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1109: ldc_w 439
    //   1112: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: aload_0
    //   1116: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   1119: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1122: ldc_w 472
    //   1125: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1128: aload_0
    //   1129: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   1132: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1135: ldc_w 439
    //   1138: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: aload_0
    //   1142: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   1145: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1148: ldc_w 474
    //   1151: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload_0
    //   1155: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   1158: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1161: ldc_w 476
    //   1164: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: aload_0
    //   1168: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   1171: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1174: ldc_w 481
    //   1177: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: aload_0
    //   1181: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   1184: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1187: ldc_w 486
    //   1190: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: astore 20
    //   1195: aload_0
    //   1196: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1199: ifnull +4081 -> 5280
    //   1202: aload_0
    //   1203: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1206: invokeinterface 180 1 0
    //   1211: astore 16
    //   1213: aload 19
    //   1215: aload 20
    //   1217: aload 16
    //   1219: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1222: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1225: putfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1228: ldc_w 491
    //   1231: aload 19
    //   1233: getfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1236: aconst_null
    //   1237: invokestatic 495	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1240: iload 8
    //   1242: ifne +8 -> 1250
    //   1245: aload_0
    //   1246: iconst_0
    //   1247: putfield 498	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   1250: aload_2
    //   1251: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1254: astore 16
    //   1256: new 256	java/lang/StringBuilder
    //   1259: dup
    //   1260: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   1263: aload_0
    //   1264: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   1267: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: ldc_w 500
    //   1273: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: aconst_null
    //   1277: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: ldc_w 502
    //   1283: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: aload_2
    //   1287: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1290: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1293: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: ldc_w 504
    //   1299: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: astore 20
    //   1304: aload_0
    //   1305: getfield 508	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1308: ifnull +4511 -> 5819
    //   1311: aload_0
    //   1312: getfield 508	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1315: getfield 511	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1318: istore 4
    //   1320: aload 20
    //   1322: iload 4
    //   1324: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1327: ldc_w 449
    //   1330: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: iload_3
    //   1334: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1337: ldc_w 413
    //   1340: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: aload_2
    //   1344: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1347: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1350: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: ldc_w 425
    //   1356: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: aload_2
    //   1360: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1363: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   1366: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1369: ldc_w 427
    //   1372: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: aload_2
    //   1376: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1379: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1382: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1385: ldc_w 418
    //   1388: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: aload_2
    //   1392: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1395: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1398: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1401: ldc_w 423
    //   1404: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1407: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   1410: aload_0
    //   1411: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   1414: lsub
    //   1415: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1418: astore 20
    //   1420: aload 15
    //   1422: invokestatic 517	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1425: ifne +4400 -> 5825
    //   1428: new 256	java/lang/StringBuilder
    //   1431: dup
    //   1432: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   1435: ldc_w 453
    //   1438: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: aload 15
    //   1443: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1449: astore 15
    //   1451: aload 16
    //   1453: aload 20
    //   1455: aload 15
    //   1457: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1460: ldc_w 451
    //   1463: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: aload 18
    //   1468: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1474: putfield 520	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   1477: iload 8
    //   1479: ifeq +64 -> 1543
    //   1482: aload_0
    //   1483: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   1486: invokestatic 525	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   1489: astore 16
    //   1491: aload_0
    //   1492: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1495: astore 15
    //   1497: aload_0
    //   1498: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   1501: ifeq +4332 -> 5833
    //   1504: aload_0
    //   1505: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1508: ifnull +4325 -> 5833
    //   1511: aload_0
    //   1512: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1515: ldc_w 527
    //   1518: invokevirtual 530	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1521: ifeq +4312 -> 5833
    //   1524: iconst_1
    //   1525: istore 8
    //   1527: aload 16
    //   1529: aload 15
    //   1531: iload 8
    //   1533: aload_2
    //   1534: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1537: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1540: invokevirtual 534	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   1543: aload 19
    //   1545: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   1548: putfield 537	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   1551: aload 19
    //   1553: aload_0
    //   1554: invokevirtual 538	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   1557: putfield 541	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   1560: aload 19
    //   1562: aload 14
    //   1564: putfield 545	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   1567: aload 19
    //   1569: iload_3
    //   1570: putfield 546	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   1573: aload 19
    //   1575: aconst_null
    //   1576: putfield 550	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   1579: aload 17
    //   1581: ifnonnull +4258 -> 5839
    //   1584: aconst_null
    //   1585: astore 15
    //   1587: aload 19
    //   1589: aload 15
    //   1591: putfield 553	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1594: aload 19
    //   1596: aconst_null
    //   1597: putfield 556	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1600: aload 19
    //   1602: aload_2
    //   1603: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1606: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1609: putfield 557	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1612: aload 19
    //   1614: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   1617: aload_0
    //   1618: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   1621: lsub
    //   1622: putfield 560	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1625: aload 19
    //   1627: aload_2
    //   1628: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1631: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1634: putfield 563	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   1637: aload 19
    //   1639: aload 19
    //   1641: getfield 560	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1644: aload_2
    //   1645: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1648: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1651: lsub
    //   1652: putfield 566	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   1655: aload 19
    //   1657: lconst_0
    //   1658: putfield 569	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   1661: aload 19
    //   1663: aload_0
    //   1664: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   1667: putfield 572	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   1670: aload 19
    //   1672: aload_0
    //   1673: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   1676: putfield 575	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   1679: aload 19
    //   1681: aload_0
    //   1682: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   1685: putfield 578	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   1688: aload 19
    //   1690: lconst_0
    //   1691: putfield 581	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   1694: aload 19
    //   1696: aload_0
    //   1697: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   1700: putfield 584	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   1703: aload 19
    //   1705: aload_2
    //   1706: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1709: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1712: putfield 587	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1715: aload 19
    //   1717: aload_0
    //   1718: invokevirtual 143	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   1721: invokestatic 590	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   1724: putfield 592	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   1727: aload 19
    //   1729: aload_0
    //   1730: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   1733: putfield 595	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   1736: aload_0
    //   1737: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1740: ifnull +4109 -> 5849
    //   1743: aload_0
    //   1744: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1747: ldc_w 527
    //   1750: invokevirtual 530	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1753: ifeq +4096 -> 5849
    //   1756: iconst_1
    //   1757: istore 8
    //   1759: aload 19
    //   1761: iload 8
    //   1763: putfield 598	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   1766: aload 19
    //   1768: aload_2
    //   1769: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1772: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1775: putfield 600	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   1778: aload 19
    //   1780: getstatic 606	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   1783: invokevirtual 609	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   1786: putfield 612	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   1789: aload 19
    //   1791: aload_0
    //   1792: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   1795: invokevirtual 615	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   1798: putfield 618	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   1801: aload 14
    //   1803: ifnull +24 -> 1827
    //   1806: aload 14
    //   1808: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1811: ifnull +16 -> 1827
    //   1814: aload 19
    //   1816: aload 14
    //   1818: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1821: invokevirtual 371	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   1824: putfield 620	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   1827: aload 19
    //   1829: aload_0
    //   1830: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   1833: invokevirtual 624	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   1836: putfield 628	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   1839: aload 19
    //   1841: aload_0
    //   1842: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   1845: invokevirtual 631	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   1848: putfield 634	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   1851: aload_2
    //   1852: aload 19
    //   1854: invokevirtual 638	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1857: aload_2
    //   1858: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1861: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1864: ifeq +11 -> 1875
    //   1867: aload_0
    //   1868: aload_1
    //   1869: aload_2
    //   1870: aload 19
    //   1872: invokevirtual 87	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1875: aload_0
    //   1876: aconst_null
    //   1877: putfield 158	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1880: return
    //   1881: aconst_null
    //   1882: astore 14
    //   1884: goto -1684 -> 200
    //   1887: aload 14
    //   1889: aload 15
    //   1891: invokestatic 642	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1894: ifne +1422 -> 3316
    //   1897: aload_0
    //   1898: aload 15
    //   1900: aload_0
    //   1901: getfield 233	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContentLength	J
    //   1904: invokevirtual 237	com/tencent/component/network/downloader/impl/RangeDownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   1907: ifeq +1409 -> 3316
    //   1910: aload_2
    //   1911: aload 15
    //   1913: invokevirtual 241	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   1916: goto -1530 -> 386
    //   1919: astore 15
    //   1921: aconst_null
    //   1922: astore 14
    //   1924: iload 6
    //   1926: istore_3
    //   1927: aload 14
    //   1929: astore 16
    //   1931: iload_3
    //   1932: istore 4
    //   1934: ldc 254
    //   1936: new 256	java/lang/StringBuilder
    //   1939: dup
    //   1940: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   1943: ldc_w 644
    //   1946: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1949: aload_0
    //   1950: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   1953: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1956: ldc_w 646
    //   1959: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1962: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1965: aload 15
    //   1967: invokestatic 495	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1970: aload_2
    //   1971: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1974: aload 15
    //   1976: invokevirtual 649	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   1979: aload_2
    //   1980: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1983: lload 12
    //   1985: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   1988: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   1991: aload_2
    //   1992: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1995: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   1998: aload_0
    //   1999: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   2002: lsub
    //   2003: putfield 317	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   2006: aload_2
    //   2007: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2010: aload_0
    //   2011: getfield 320	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   2014: putfield 323	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   2017: aload_0
    //   2018: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   2021: invokestatic 329	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   2024: invokevirtual 333	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   2027: astore 18
    //   2029: aload_0
    //   2030: aconst_null
    //   2031: aconst_null
    //   2032: aload 14
    //   2034: invokevirtual 337	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   2037: astore 20
    //   2039: aload 14
    //   2041: ifnull +5775 -> 7816
    //   2044: aload 14
    //   2046: invokevirtual 340	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   2049: ifnull +5767 -> 7816
    //   2052: aload 14
    //   2054: invokevirtual 340	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   2057: ldc_w 342
    //   2060: invokevirtual 345	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   2063: astore 16
    //   2065: aload_2
    //   2066: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2069: aload 16
    //   2071: putfield 348	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   2074: aload_0
    //   2075: lconst_0
    //   2076: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   2079: aload_0
    //   2080: iconst_0
    //   2081: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   2084: aload_0
    //   2085: lconst_0
    //   2086: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   2089: aload_0
    //   2090: iconst_0
    //   2091: putfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   2094: aload_1
    //   2095: invokeinterface 83 1 0
    //   2100: ifne +1193 -> 3293
    //   2103: aload_0
    //   2104: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   2107: invokestatic 97	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2110: istore 8
    //   2112: aload_2
    //   2113: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2116: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2119: ifne +5726 -> 7845
    //   2122: new 256	java/lang/StringBuilder
    //   2125: dup
    //   2126: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   2129: ldc_w 353
    //   2132: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2135: aload_0
    //   2136: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   2139: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2142: ldc_w 355
    //   2145: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2148: aload_0
    //   2149: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   2152: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2155: ldc_w 364
    //   2158: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2161: astore 21
    //   2163: aload_0
    //   2164: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   2167: ifeq +5655 -> 7822
    //   2170: aload 14
    //   2172: ifnull +5650 -> 7822
    //   2175: aload 14
    //   2177: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   2180: ifnull +5642 -> 7822
    //   2183: aload 14
    //   2185: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   2188: invokevirtual 371	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   2191: astore 17
    //   2193: aload 21
    //   2195: aload 17
    //   2197: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2200: ldc_w 373
    //   2203: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2206: aload 18
    //   2208: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2211: ldc_w 378
    //   2214: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: aconst_null
    //   2218: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2221: ldc_w 380
    //   2224: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2227: aconst_null
    //   2228: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2231: ldc_w 382
    //   2234: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2237: invokestatic 386	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2240: invokevirtual 389	java/lang/Thread:getId	()J
    //   2243: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2246: ldc_w 394
    //   2249: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2252: invokestatic 399	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   2255: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2258: ldc_w 401
    //   2261: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2264: iload 8
    //   2266: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2269: ldc_w 403
    //   2272: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2275: invokestatic 408	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2278: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2281: ldc_w 413
    //   2284: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2287: aload_2
    //   2288: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2291: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2294: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2297: ldc_w 418
    //   2300: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2303: aload_2
    //   2304: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2307: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2310: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2313: ldc_w 423
    //   2316: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2319: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   2322: aload_0
    //   2323: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   2326: lsub
    //   2327: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2330: ldc_w 425
    //   2333: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2336: aload_2
    //   2337: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2340: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2343: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2346: ldc_w 427
    //   2349: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2352: aload_2
    //   2353: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2356: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2359: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2362: ldc_w 429
    //   2365: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2368: aload_2
    //   2369: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2372: getfield 432	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   2375: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2378: ldc_w 434
    //   2381: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2384: aload_0
    //   2385: invokevirtual 437	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   2388: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2391: ldc_w 439
    //   2394: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2397: aload_0
    //   2398: invokevirtual 442	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   2401: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2404: ldc_w 444
    //   2407: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2410: aload_2
    //   2411: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2414: invokevirtual 447	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   2417: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2420: ldc_w 449
    //   2423: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2426: iload_3
    //   2427: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2430: ldc_w 451
    //   2433: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2436: aload 20
    //   2438: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2441: ldc_w 453
    //   2444: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2447: aload 16
    //   2449: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2452: ldc_w 455
    //   2455: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2458: astore 21
    //   2460: aload_0
    //   2461: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   2464: ifnull +5366 -> 7830
    //   2467: aload_0
    //   2468: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   2471: iconst_0
    //   2472: bipush 30
    //   2474: invokevirtual 461	java/lang/String:substring	(II)Ljava/lang/String;
    //   2477: astore 17
    //   2479: aload 21
    //   2481: aload 17
    //   2483: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2486: ldc_w 463
    //   2489: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2492: aload_2
    //   2493: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2496: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2499: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2502: ldc_w 468
    //   2505: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2508: lconst_0
    //   2509: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2512: ldc_w 470
    //   2515: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2518: aload_0
    //   2519: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   2522: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2525: ldc_w 439
    //   2528: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2531: aload_0
    //   2532: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   2535: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2538: ldc_w 472
    //   2541: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: aload_0
    //   2545: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   2548: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2551: ldc_w 439
    //   2554: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2557: aload_0
    //   2558: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   2561: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2564: ldc_w 474
    //   2567: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2570: aload_0
    //   2571: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   2574: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2577: ldc_w 476
    //   2580: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2583: aload_0
    //   2584: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   2587: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2590: ldc_w 481
    //   2593: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2596: aload_0
    //   2597: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   2600: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2603: ldc_w 486
    //   2606: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2609: astore 21
    //   2611: aload_0
    //   2612: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2615: ifnull +5224 -> 7839
    //   2618: aload_0
    //   2619: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2622: invokeinterface 180 1 0
    //   2627: astore 17
    //   2629: aload 19
    //   2631: aload 21
    //   2633: aload 17
    //   2635: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2638: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2641: putfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   2644: ldc_w 491
    //   2647: aload 19
    //   2649: getfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   2652: aload 15
    //   2654: invokestatic 495	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2657: iload 8
    //   2659: ifne +8 -> 2667
    //   2662: aload_0
    //   2663: iconst_0
    //   2664: putfield 498	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   2667: aload_2
    //   2668: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2671: astore 17
    //   2673: new 256	java/lang/StringBuilder
    //   2676: dup
    //   2677: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   2680: aload_0
    //   2681: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   2684: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2687: ldc_w 500
    //   2690: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2693: aconst_null
    //   2694: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2697: ldc_w 502
    //   2700: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2703: aload_2
    //   2704: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2707: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2710: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2713: ldc_w 504
    //   2716: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2719: astore 21
    //   2721: aload_0
    //   2722: getfield 508	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2725: ifnull +5653 -> 8378
    //   2728: aload_0
    //   2729: getfield 508	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2732: getfield 511	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2735: istore 4
    //   2737: aload 21
    //   2739: iload 4
    //   2741: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2744: ldc_w 449
    //   2747: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2750: iload_3
    //   2751: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2754: ldc_w 413
    //   2757: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2760: aload_2
    //   2761: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2764: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2767: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2770: ldc_w 425
    //   2773: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2776: aload_2
    //   2777: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2780: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2783: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2786: ldc_w 427
    //   2789: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2792: aload_2
    //   2793: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2796: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2799: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2802: ldc_w 418
    //   2805: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2808: aload_2
    //   2809: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2812: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2815: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2818: ldc_w 423
    //   2821: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2824: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   2827: aload_0
    //   2828: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   2831: lsub
    //   2832: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2835: astore 21
    //   2837: aload 16
    //   2839: invokestatic 517	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2842: ifne +5542 -> 8384
    //   2845: new 256	java/lang/StringBuilder
    //   2848: dup
    //   2849: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   2852: ldc_w 453
    //   2855: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2858: aload 16
    //   2860: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2863: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2866: astore 16
    //   2868: aload 17
    //   2870: aload 21
    //   2872: aload 16
    //   2874: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2877: ldc_w 451
    //   2880: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2883: aload 20
    //   2885: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2888: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2891: putfield 520	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   2894: iload 8
    //   2896: ifeq +64 -> 2960
    //   2899: aload_0
    //   2900: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   2903: invokestatic 525	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   2906: astore 16
    //   2908: aload_0
    //   2909: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   2912: astore 17
    //   2914: aload_0
    //   2915: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   2918: ifeq +5474 -> 8392
    //   2921: aload_0
    //   2922: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   2925: ifnull +5467 -> 8392
    //   2928: aload_0
    //   2929: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   2932: ldc_w 527
    //   2935: invokevirtual 530	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2938: ifeq +5454 -> 8392
    //   2941: iconst_1
    //   2942: istore 8
    //   2944: aload 16
    //   2946: aload 17
    //   2948: iload 8
    //   2950: aload_2
    //   2951: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2954: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2957: invokevirtual 534	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   2960: aload 19
    //   2962: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   2965: putfield 537	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   2968: aload 19
    //   2970: aload_0
    //   2971: invokevirtual 538	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   2974: putfield 541	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   2977: aload 19
    //   2979: aload 14
    //   2981: putfield 545	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   2984: aload 19
    //   2986: iload_3
    //   2987: putfield 546	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   2990: aload 19
    //   2992: aload 15
    //   2994: putfield 550	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   2997: aload 18
    //   2999: ifnonnull +5399 -> 8398
    //   3002: aconst_null
    //   3003: astore 15
    //   3005: aload 19
    //   3007: aload 15
    //   3009: putfield 553	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   3012: aload 19
    //   3014: aconst_null
    //   3015: putfield 556	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   3018: aload 19
    //   3020: aload_2
    //   3021: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3024: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3027: putfield 557	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   3030: aload 19
    //   3032: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   3035: aload_0
    //   3036: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   3039: lsub
    //   3040: putfield 560	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   3043: aload 19
    //   3045: aload_2
    //   3046: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3049: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3052: putfield 563	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   3055: aload 19
    //   3057: aload 19
    //   3059: getfield 560	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   3062: aload_2
    //   3063: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3066: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3069: lsub
    //   3070: putfield 566	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   3073: aload 19
    //   3075: lconst_0
    //   3076: putfield 569	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   3079: aload 19
    //   3081: aload_0
    //   3082: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   3085: putfield 572	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   3088: aload 19
    //   3090: aload_0
    //   3091: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   3094: putfield 575	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   3097: aload 19
    //   3099: aload_0
    //   3100: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   3103: putfield 578	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   3106: aload 19
    //   3108: lconst_0
    //   3109: putfield 581	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   3112: aload 19
    //   3114: aload_0
    //   3115: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   3118: putfield 584	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   3121: aload 19
    //   3123: aload_2
    //   3124: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3127: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3130: putfield 587	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   3133: aload 19
    //   3135: aload_0
    //   3136: invokevirtual 143	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   3139: invokestatic 590	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   3142: putfield 592	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   3145: aload 19
    //   3147: aload_0
    //   3148: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   3151: putfield 595	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   3154: aload_0
    //   3155: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   3158: ifnull +5250 -> 8408
    //   3161: aload_0
    //   3162: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   3165: ldc_w 527
    //   3168: invokevirtual 530	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3171: ifeq +5237 -> 8408
    //   3174: iconst_1
    //   3175: istore 8
    //   3177: aload 19
    //   3179: iload 8
    //   3181: putfield 598	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   3184: aload 19
    //   3186: aload_2
    //   3187: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3190: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3193: putfield 600	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   3196: aload 19
    //   3198: getstatic 606	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   3201: invokevirtual 609	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   3204: putfield 612	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   3207: aload 19
    //   3209: aload_0
    //   3210: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   3213: invokevirtual 615	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   3216: putfield 618	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   3219: aload 14
    //   3221: ifnull +24 -> 3245
    //   3224: aload 14
    //   3226: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3229: ifnull +16 -> 3245
    //   3232: aload 19
    //   3234: aload 14
    //   3236: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3239: invokevirtual 371	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3242: putfield 620	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   3245: aload 19
    //   3247: aload_0
    //   3248: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   3251: invokevirtual 624	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   3254: putfield 628	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   3257: aload 19
    //   3259: aload_0
    //   3260: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   3263: invokevirtual 631	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   3266: putfield 634	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   3269: aload_2
    //   3270: aload 19
    //   3272: invokevirtual 638	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   3275: aload_2
    //   3276: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3279: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3282: ifeq +11 -> 3293
    //   3285: aload_0
    //   3286: aload_1
    //   3287: aload_2
    //   3288: aload 19
    //   3290: invokevirtual 87	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   3293: aload_0
    //   3294: aconst_null
    //   3295: putfield 158	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   3298: iload 5
    //   3300: iconst_1
    //   3301: iadd
    //   3302: istore_3
    //   3303: aload_0
    //   3304: invokevirtual 652	com/tencent/component/network/downloader/impl/RangeDownloadTask:canAttempt	()Z
    //   3307: ifeq -3263 -> 44
    //   3310: iload_3
    //   3311: istore 5
    //   3313: goto -3285 -> 28
    //   3316: aload_2
    //   3317: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3320: iconst_2
    //   3321: invokevirtual 112	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   3324: ldc 254
    //   3326: new 256	java/lang/StringBuilder
    //   3329: dup
    //   3330: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   3333: ldc_w 654
    //   3336: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3339: aload_0
    //   3340: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   3343: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3346: ldc_w 265
    //   3349: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3352: aload_0
    //   3353: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   3356: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3359: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3362: invokestatic 656	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3365: aload_2
    //   3366: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3369: lload 12
    //   3371: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   3374: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   3377: aload_2
    //   3378: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3381: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   3384: aload_0
    //   3385: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   3388: lsub
    //   3389: putfield 317	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   3392: aload_2
    //   3393: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3396: aload_0
    //   3397: getfield 320	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   3400: putfield 323	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   3403: aload_0
    //   3404: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   3407: invokestatic 329	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   3410: invokevirtual 333	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3413: astore 15
    //   3415: aload_0
    //   3416: aconst_null
    //   3417: aconst_null
    //   3418: aconst_null
    //   3419: invokevirtual 337	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   3422: astore 16
    //   3424: iconst_0
    //   3425: ifeq +1212 -> 4637
    //   3428: new 658	java/lang/NullPointerException
    //   3431: dup
    //   3432: invokespecial 659	java/lang/NullPointerException:<init>	()V
    //   3435: athrow
    //   3436: aload_2
    //   3437: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3440: aconst_null
    //   3441: putfield 348	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   3444: aload_0
    //   3445: lconst_0
    //   3446: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   3449: aload_0
    //   3450: iconst_0
    //   3451: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   3454: aload_0
    //   3455: lconst_0
    //   3456: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   3459: aload_0
    //   3460: iconst_0
    //   3461: putfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   3464: aload_1
    //   3465: invokeinterface 83 1 0
    //   3470: ifne +1161 -> 4631
    //   3473: aload_0
    //   3474: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   3477: invokestatic 97	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3480: istore 8
    //   3482: aload_2
    //   3483: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3486: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3489: ifne +1169 -> 4658
    //   3492: new 256	java/lang/StringBuilder
    //   3495: dup
    //   3496: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   3499: ldc_w 353
    //   3502: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3505: aload_0
    //   3506: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   3509: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3512: ldc_w 355
    //   3515: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3518: aload_0
    //   3519: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   3522: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3525: ldc_w 364
    //   3528: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3531: astore 14
    //   3533: aload_0
    //   3534: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   3537: ifeq +1103 -> 4640
    //   3540: iconst_0
    //   3541: ifeq +1099 -> 4640
    //   3544: new 658	java/lang/NullPointerException
    //   3547: dup
    //   3548: invokespecial 659	java/lang/NullPointerException:<init>	()V
    //   3551: athrow
    //   3552: aload 14
    //   3554: ldc_w 661
    //   3557: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3560: ldc_w 373
    //   3563: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3566: aload 15
    //   3568: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3571: ldc_w 378
    //   3574: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3577: aconst_null
    //   3578: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3581: ldc_w 380
    //   3584: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3587: aconst_null
    //   3588: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3591: ldc_w 382
    //   3594: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3597: invokestatic 386	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3600: invokevirtual 389	java/lang/Thread:getId	()J
    //   3603: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3606: ldc_w 394
    //   3609: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3612: invokestatic 399	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3615: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3618: ldc_w 401
    //   3621: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3624: iload 8
    //   3626: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3629: ldc_w 403
    //   3632: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3635: invokestatic 408	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3638: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3641: ldc_w 413
    //   3644: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3647: aload_2
    //   3648: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3651: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3654: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3657: ldc_w 418
    //   3660: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3663: aload_2
    //   3664: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3667: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3670: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3673: ldc_w 423
    //   3676: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3679: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   3682: aload_0
    //   3683: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   3686: lsub
    //   3687: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3690: ldc_w 425
    //   3693: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3696: aload_2
    //   3697: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3700: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3703: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3706: ldc_w 427
    //   3709: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3712: aload_2
    //   3713: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3716: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3719: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3722: ldc_w 429
    //   3725: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3728: aload_2
    //   3729: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3732: getfield 432	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3735: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3738: ldc_w 434
    //   3741: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3744: aload_0
    //   3745: invokevirtual 437	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   3748: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3751: ldc_w 439
    //   3754: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3757: aload_0
    //   3758: invokevirtual 442	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   3761: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3764: ldc_w 444
    //   3767: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3770: aload_2
    //   3771: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3774: invokevirtual 447	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3777: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3780: ldc_w 449
    //   3783: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3786: iconst_0
    //   3787: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3790: ldc_w 451
    //   3793: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3796: aload 16
    //   3798: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3801: ldc_w 453
    //   3804: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3807: aconst_null
    //   3808: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3811: ldc_w 455
    //   3814: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3817: astore 17
    //   3819: aload_0
    //   3820: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   3823: ifnull +820 -> 4643
    //   3826: aload_0
    //   3827: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   3830: iconst_0
    //   3831: bipush 30
    //   3833: invokevirtual 461	java/lang/String:substring	(II)Ljava/lang/String;
    //   3836: astore 14
    //   3838: aload 17
    //   3840: aload 14
    //   3842: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3845: ldc_w 463
    //   3848: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3851: aload_2
    //   3852: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3855: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3858: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3861: ldc_w 468
    //   3864: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3867: lconst_0
    //   3868: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3871: ldc_w 470
    //   3874: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3877: aload_0
    //   3878: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   3881: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3884: ldc_w 439
    //   3887: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3890: aload_0
    //   3891: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   3894: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3897: ldc_w 472
    //   3900: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3903: aload_0
    //   3904: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   3907: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3910: ldc_w 439
    //   3913: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3916: aload_0
    //   3917: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   3920: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3923: ldc_w 474
    //   3926: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3929: aload_0
    //   3930: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   3933: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3936: ldc_w 476
    //   3939: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3942: aload_0
    //   3943: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   3946: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3949: ldc_w 481
    //   3952: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3955: aload_0
    //   3956: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   3959: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3962: ldc_w 486
    //   3965: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3968: astore 17
    //   3970: aload_0
    //   3971: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3974: ifnull +678 -> 4652
    //   3977: aload_0
    //   3978: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3981: invokeinterface 180 1 0
    //   3986: astore 14
    //   3988: aload 19
    //   3990: aload 17
    //   3992: aload 14
    //   3994: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3997: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4000: putfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4003: ldc_w 491
    //   4006: aload 19
    //   4008: getfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4011: aconst_null
    //   4012: invokestatic 495	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4015: iload 8
    //   4017: ifne +8 -> 4025
    //   4020: aload_0
    //   4021: iconst_0
    //   4022: putfield 498	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   4025: aload_2
    //   4026: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4029: astore 17
    //   4031: new 256	java/lang/StringBuilder
    //   4034: dup
    //   4035: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   4038: aload_0
    //   4039: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   4042: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4045: ldc_w 500
    //   4048: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4051: aconst_null
    //   4052: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4055: ldc_w 502
    //   4058: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4061: aload_2
    //   4062: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4065: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4068: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4071: ldc_w 504
    //   4074: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4077: astore 14
    //   4079: aload_0
    //   4080: getfield 508	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4083: ifnull +1092 -> 5175
    //   4086: aload_0
    //   4087: getfield 508	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4090: getfield 511	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4093: istore_3
    //   4094: aload 14
    //   4096: iload_3
    //   4097: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4100: ldc_w 449
    //   4103: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4106: iconst_0
    //   4107: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4110: ldc_w 413
    //   4113: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4116: aload_2
    //   4117: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4120: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4123: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4126: ldc_w 425
    //   4129: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4132: aload_2
    //   4133: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4136: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4139: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4142: ldc_w 427
    //   4145: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4148: aload_2
    //   4149: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4152: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4155: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4158: ldc_w 418
    //   4161: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4164: aload_2
    //   4165: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4168: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4171: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4174: ldc_w 423
    //   4177: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4180: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   4183: aload_0
    //   4184: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   4187: lsub
    //   4188: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4191: astore 18
    //   4193: aconst_null
    //   4194: invokestatic 517	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4197: ifne +983 -> 5180
    //   4200: new 256	java/lang/StringBuilder
    //   4203: dup
    //   4204: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   4207: ldc_w 453
    //   4210: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4213: aconst_null
    //   4214: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4217: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4220: astore 14
    //   4222: aload 17
    //   4224: aload 18
    //   4226: aload 14
    //   4228: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4231: ldc_w 451
    //   4234: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4237: aload 16
    //   4239: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4242: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4245: putfield 520	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   4248: iload 8
    //   4250: ifeq +64 -> 4314
    //   4253: aload_0
    //   4254: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   4257: invokestatic 525	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   4260: astore 14
    //   4262: aload_0
    //   4263: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4266: astore 16
    //   4268: aload_0
    //   4269: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   4272: ifeq +916 -> 5188
    //   4275: aload_0
    //   4276: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4279: ifnull +909 -> 5188
    //   4282: aload_0
    //   4283: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4286: ldc_w 527
    //   4289: invokevirtual 530	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4292: ifeq +896 -> 5188
    //   4295: iconst_1
    //   4296: istore 8
    //   4298: aload 14
    //   4300: aload 16
    //   4302: iload 8
    //   4304: aload_2
    //   4305: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4308: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4311: invokevirtual 534	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   4314: aload 19
    //   4316: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   4319: putfield 537	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4322: aload 19
    //   4324: aload_0
    //   4325: invokevirtual 538	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   4328: putfield 541	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4331: aload 19
    //   4333: aconst_null
    //   4334: putfield 545	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   4337: aload 19
    //   4339: iconst_0
    //   4340: putfield 546	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4343: aload 19
    //   4345: aconst_null
    //   4346: putfield 550	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4349: aload 15
    //   4351: ifnonnull +843 -> 5194
    //   4354: aconst_null
    //   4355: astore 14
    //   4357: aload 19
    //   4359: aload 14
    //   4361: putfield 553	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4364: aload 19
    //   4366: aconst_null
    //   4367: putfield 556	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4370: aload 19
    //   4372: aload_2
    //   4373: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4376: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4379: putfield 557	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4382: aload 19
    //   4384: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   4387: aload_0
    //   4388: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   4391: lsub
    //   4392: putfield 560	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4395: aload 19
    //   4397: aload_2
    //   4398: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4401: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4404: putfield 563	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   4407: aload 19
    //   4409: aload 19
    //   4411: getfield 560	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4414: aload_2
    //   4415: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4418: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4421: lsub
    //   4422: putfield 566	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   4425: aload 19
    //   4427: lconst_0
    //   4428: putfield 569	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   4431: aload 19
    //   4433: aload_0
    //   4434: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   4437: putfield 572	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   4440: aload 19
    //   4442: aload_0
    //   4443: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   4446: putfield 575	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   4449: aload 19
    //   4451: aload_0
    //   4452: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   4455: putfield 578	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   4458: aload 19
    //   4460: lconst_0
    //   4461: putfield 581	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   4464: aload 19
    //   4466: aload_0
    //   4467: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   4470: putfield 584	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   4473: aload 19
    //   4475: aload_2
    //   4476: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4479: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4482: putfield 587	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4485: aload 19
    //   4487: aload_0
    //   4488: invokevirtual 143	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   4491: invokestatic 590	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   4494: putfield 592	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   4497: aload 19
    //   4499: aload_0
    //   4500: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   4503: putfield 595	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   4506: aload_0
    //   4507: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4510: ifnull +694 -> 5204
    //   4513: aload_0
    //   4514: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4517: ldc_w 527
    //   4520: invokevirtual 530	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4523: ifeq +681 -> 5204
    //   4526: iconst_1
    //   4527: istore 8
    //   4529: aload 19
    //   4531: iload 8
    //   4533: putfield 598	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   4536: aload 19
    //   4538: aload_2
    //   4539: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4542: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4545: putfield 600	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   4548: aload 19
    //   4550: getstatic 606	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   4553: invokevirtual 609	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   4556: putfield 612	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   4559: aload 19
    //   4561: aload_0
    //   4562: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   4565: invokevirtual 615	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   4568: putfield 618	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   4571: iconst_0
    //   4572: ifeq +11 -> 4583
    //   4575: new 658	java/lang/NullPointerException
    //   4578: dup
    //   4579: invokespecial 659	java/lang/NullPointerException:<init>	()V
    //   4582: athrow
    //   4583: aload 19
    //   4585: aload_0
    //   4586: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   4589: invokevirtual 624	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   4592: putfield 628	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   4595: aload 19
    //   4597: aload_0
    //   4598: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   4601: invokevirtual 631	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   4604: putfield 634	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   4607: aload_2
    //   4608: aload 19
    //   4610: invokevirtual 638	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4613: aload_2
    //   4614: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4617: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4620: ifeq +11 -> 4631
    //   4623: aload_0
    //   4624: aload_1
    //   4625: aload_2
    //   4626: aload 19
    //   4628: invokevirtual 87	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4631: aload_0
    //   4632: aconst_null
    //   4633: putfield 158	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   4636: return
    //   4637: goto -1201 -> 3436
    //   4640: goto -1088 -> 3552
    //   4643: aload_0
    //   4644: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4647: astore 14
    //   4649: goto -811 -> 3838
    //   4652: aconst_null
    //   4653: astore 14
    //   4655: goto -667 -> 3988
    //   4658: new 256	java/lang/StringBuilder
    //   4661: dup
    //   4662: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   4665: ldc_w 663
    //   4668: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4671: aload_0
    //   4672: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   4675: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4678: ldc_w 355
    //   4681: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4684: aload_0
    //   4685: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   4688: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4691: ldc_w 364
    //   4694: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4697: astore 14
    //   4699: aload_0
    //   4700: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   4703: ifeq +454 -> 5157
    //   4706: iconst_0
    //   4707: ifeq +450 -> 5157
    //   4710: new 658	java/lang/NullPointerException
    //   4713: dup
    //   4714: invokespecial 659	java/lang/NullPointerException:<init>	()V
    //   4717: athrow
    //   4718: aload 14
    //   4720: ldc_w 661
    //   4723: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4726: ldc_w 373
    //   4729: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4732: aload 15
    //   4734: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4737: ldc_w 378
    //   4740: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4743: aconst_null
    //   4744: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4747: ldc_w 380
    //   4750: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4753: aconst_null
    //   4754: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4757: ldc_w 382
    //   4760: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4763: invokestatic 386	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4766: invokevirtual 389	java/lang/Thread:getId	()J
    //   4769: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4772: ldc_w 394
    //   4775: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4778: invokestatic 399	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4781: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4784: ldc_w 403
    //   4787: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4790: invokestatic 408	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   4793: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4796: ldc_w 418
    //   4799: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4802: aload_2
    //   4803: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4806: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4809: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4812: ldc_w 423
    //   4815: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4818: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   4821: aload_0
    //   4822: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   4825: lsub
    //   4826: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4829: ldc_w 425
    //   4832: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4835: aload_2
    //   4836: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4839: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4842: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4845: ldc_w 427
    //   4848: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4851: aload_2
    //   4852: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4855: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4858: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4861: ldc_w 429
    //   4864: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4867: aload_2
    //   4868: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4871: getfield 432	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4874: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4877: ldc_w 434
    //   4880: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4883: aload_0
    //   4884: invokevirtual 437	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   4887: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4890: ldc_w 439
    //   4893: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4896: aload_0
    //   4897: invokevirtual 442	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   4900: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4903: ldc_w 665
    //   4906: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4909: iconst_0
    //   4910: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4913: ldc_w 451
    //   4916: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4919: aload 16
    //   4921: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4924: ldc_w 413
    //   4927: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4930: aload_2
    //   4931: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4934: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4937: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4940: ldc_w 453
    //   4943: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4946: aconst_null
    //   4947: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4950: ldc_w 455
    //   4953: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4956: astore 17
    //   4958: aload_0
    //   4959: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4962: ifnull +198 -> 5160
    //   4965: aload_0
    //   4966: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4969: iconst_0
    //   4970: bipush 30
    //   4972: invokevirtual 461	java/lang/String:substring	(II)Ljava/lang/String;
    //   4975: astore 14
    //   4977: aload 17
    //   4979: aload 14
    //   4981: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4984: ldc_w 463
    //   4987: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4990: aload_2
    //   4991: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4994: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4997: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5000: ldc_w 468
    //   5003: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5006: lconst_0
    //   5007: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5010: ldc_w 470
    //   5013: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5016: aload_0
    //   5017: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   5020: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5023: ldc_w 439
    //   5026: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5029: aload_0
    //   5030: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   5033: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5036: ldc_w 472
    //   5039: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5042: aload_0
    //   5043: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   5046: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5049: ldc_w 439
    //   5052: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5055: aload_0
    //   5056: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   5059: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5062: ldc_w 474
    //   5065: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5068: aload_0
    //   5069: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   5072: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5075: ldc_w 476
    //   5078: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5081: aload_0
    //   5082: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   5085: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5088: ldc_w 481
    //   5091: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5094: aload_0
    //   5095: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   5098: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5101: ldc_w 486
    //   5104: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5107: astore 17
    //   5109: aload_0
    //   5110: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5113: ifnull +56 -> 5169
    //   5116: aload_0
    //   5117: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5120: invokeinterface 180 1 0
    //   5125: astore 14
    //   5127: aload 19
    //   5129: aload 17
    //   5131: aload 14
    //   5133: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5136: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5139: putfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5142: ldc_w 491
    //   5145: aload 19
    //   5147: getfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5150: aconst_null
    //   5151: invokestatic 668	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5154: goto -1139 -> 4015
    //   5157: goto -439 -> 4718
    //   5160: aload_0
    //   5161: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5164: astore 14
    //   5166: goto -189 -> 4977
    //   5169: aconst_null
    //   5170: astore 14
    //   5172: goto -45 -> 5127
    //   5175: iconst_0
    //   5176: istore_3
    //   5177: goto -1083 -> 4094
    //   5180: ldc_w 670
    //   5183: astore 14
    //   5185: goto -963 -> 4222
    //   5188: iconst_0
    //   5189: istore 8
    //   5191: goto -893 -> 4298
    //   5194: aload 15
    //   5196: invokevirtual 673	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   5199: astore 14
    //   5201: goto -844 -> 4357
    //   5204: iconst_0
    //   5205: istore 8
    //   5207: goto -678 -> 4529
    //   5210: ldc 254
    //   5212: new 256	java/lang/StringBuilder
    //   5215: dup
    //   5216: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   5219: ldc_w 654
    //   5222: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5225: aload_0
    //   5226: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   5229: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5232: ldc_w 265
    //   5235: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5238: aload_0
    //   5239: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5242: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5245: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5248: invokestatic 656	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5251: aconst_null
    //   5252: astore 14
    //   5254: goto -4728 -> 526
    //   5257: aconst_null
    //   5258: astore 15
    //   5260: goto -4611 -> 649
    //   5263: ldc_w 661
    //   5266: astore 16
    //   5268: goto -4491 -> 777
    //   5271: aload_0
    //   5272: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5275: astore 16
    //   5277: goto -4214 -> 1063
    //   5280: aconst_null
    //   5281: astore 16
    //   5283: goto -4070 -> 1213
    //   5286: new 256	java/lang/StringBuilder
    //   5289: dup
    //   5290: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   5293: ldc_w 663
    //   5296: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5299: aload_0
    //   5300: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   5303: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5306: ldc_w 355
    //   5309: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5312: aload_0
    //   5313: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   5316: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5319: ldc_w 364
    //   5322: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5325: astore 20
    //   5327: aload_0
    //   5328: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   5331: ifeq +465 -> 5796
    //   5334: aload 14
    //   5336: ifnull +460 -> 5796
    //   5339: aload 14
    //   5341: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5344: ifnull +452 -> 5796
    //   5347: aload 14
    //   5349: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5352: invokevirtual 371	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5355: astore 16
    //   5357: aload 20
    //   5359: aload 16
    //   5361: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5364: ldc_w 373
    //   5367: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5370: aload 17
    //   5372: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5375: ldc_w 378
    //   5378: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5381: aconst_null
    //   5382: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5385: ldc_w 380
    //   5388: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5391: aconst_null
    //   5392: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5395: ldc_w 382
    //   5398: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5401: invokestatic 386	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5404: invokevirtual 389	java/lang/Thread:getId	()J
    //   5407: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5410: ldc_w 394
    //   5413: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5416: invokestatic 399	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5419: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5422: ldc_w 403
    //   5425: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5428: invokestatic 408	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   5431: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5434: ldc_w 418
    //   5437: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5440: aload_2
    //   5441: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5444: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5447: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5450: ldc_w 423
    //   5453: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5456: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   5459: aload_0
    //   5460: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   5463: lsub
    //   5464: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5467: ldc_w 425
    //   5470: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5473: aload_2
    //   5474: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5477: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5480: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5483: ldc_w 427
    //   5486: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5489: aload_2
    //   5490: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5493: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5496: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5499: ldc_w 429
    //   5502: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5505: aload_2
    //   5506: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5509: getfield 432	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5512: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5515: ldc_w 434
    //   5518: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5521: aload_0
    //   5522: invokevirtual 437	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   5525: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5528: ldc_w 439
    //   5531: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5534: aload_0
    //   5535: invokevirtual 442	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   5538: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5541: ldc_w 665
    //   5544: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5547: iload_3
    //   5548: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5551: ldc_w 451
    //   5554: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5557: aload 18
    //   5559: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5562: ldc_w 413
    //   5565: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5568: aload_2
    //   5569: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5572: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5575: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5578: ldc_w 453
    //   5581: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5584: aload 15
    //   5586: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5589: ldc_w 455
    //   5592: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5595: astore 20
    //   5597: aload_0
    //   5598: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5601: ifnull +203 -> 5804
    //   5604: aload_0
    //   5605: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5608: iconst_0
    //   5609: bipush 30
    //   5611: invokevirtual 461	java/lang/String:substring	(II)Ljava/lang/String;
    //   5614: astore 16
    //   5616: aload 20
    //   5618: aload 16
    //   5620: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5623: ldc_w 463
    //   5626: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5629: aload_2
    //   5630: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5633: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5636: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5639: ldc_w 468
    //   5642: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5645: lconst_0
    //   5646: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5649: ldc_w 470
    //   5652: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5655: aload_0
    //   5656: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   5659: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5662: ldc_w 439
    //   5665: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5668: aload_0
    //   5669: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   5672: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5675: ldc_w 472
    //   5678: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5681: aload_0
    //   5682: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   5685: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5688: ldc_w 439
    //   5691: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5694: aload_0
    //   5695: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   5698: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5701: ldc_w 474
    //   5704: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5707: aload_0
    //   5708: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   5711: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5714: ldc_w 476
    //   5717: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5720: aload_0
    //   5721: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   5724: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5727: ldc_w 481
    //   5730: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5733: aload_0
    //   5734: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   5737: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5740: ldc_w 486
    //   5743: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5746: astore 20
    //   5748: aload_0
    //   5749: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5752: ifnull +61 -> 5813
    //   5755: aload_0
    //   5756: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5759: invokeinterface 180 1 0
    //   5764: astore 16
    //   5766: aload 19
    //   5768: aload 20
    //   5770: aload 16
    //   5772: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5775: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5778: putfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5781: ldc_w 491
    //   5784: aload 19
    //   5786: getfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5789: aconst_null
    //   5790: invokestatic 668	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5793: goto -4553 -> 1240
    //   5796: ldc_w 661
    //   5799: astore 16
    //   5801: goto -444 -> 5357
    //   5804: aload_0
    //   5805: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5808: astore 16
    //   5810: goto -194 -> 5616
    //   5813: aconst_null
    //   5814: astore 16
    //   5816: goto -50 -> 5766
    //   5819: iconst_0
    //   5820: istore 4
    //   5822: goto -4502 -> 1320
    //   5825: ldc_w 670
    //   5828: astore 15
    //   5830: goto -4379 -> 1451
    //   5833: iconst_0
    //   5834: istore 8
    //   5836: goto -4309 -> 1527
    //   5839: aload 17
    //   5841: invokevirtual 673	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   5844: astore 15
    //   5846: goto -4259 -> 1587
    //   5849: iconst_0
    //   5850: istore 8
    //   5852: goto -4093 -> 1759
    //   5855: aload_0
    //   5856: getfield 208	com/tencent/component/network/downloader/impl/RangeDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5859: ifnull +4561 -> 10420
    //   5862: aload_0
    //   5863: getfield 208	com/tencent/component/network/downloader/impl/RangeDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5866: aload_0
    //   5867: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   5870: iconst_1
    //   5871: invokeinterface 677 3 0
    //   5876: aload_2
    //   5877: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5880: lload 12
    //   5882: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   5885: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   5888: aload_2
    //   5889: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5892: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   5895: aload_0
    //   5896: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   5899: lsub
    //   5900: putfield 317	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   5903: aload_2
    //   5904: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5907: aload_0
    //   5908: getfield 320	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   5911: putfield 323	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   5914: aload_0
    //   5915: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   5918: invokestatic 329	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   5921: invokevirtual 333	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   5924: astore 17
    //   5926: aload_0
    //   5927: aconst_null
    //   5928: aconst_null
    //   5929: aload 14
    //   5931: invokevirtual 337	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   5934: astore 18
    //   5936: aload 14
    //   5938: ifnull +1280 -> 7218
    //   5941: aload 14
    //   5943: invokevirtual 340	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   5946: ifnull +1272 -> 7218
    //   5949: aload 14
    //   5951: invokevirtual 340	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   5954: ldc_w 342
    //   5957: invokevirtual 345	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   5960: astore 15
    //   5962: aload_2
    //   5963: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5966: aload 15
    //   5968: putfield 348	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   5971: aload_0
    //   5972: lconst_0
    //   5973: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   5976: aload_0
    //   5977: iconst_0
    //   5978: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   5981: aload_0
    //   5982: lconst_0
    //   5983: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   5986: aload_0
    //   5987: iconst_0
    //   5988: putfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   5991: aload_1
    //   5992: invokeinterface 83 1 0
    //   5997: ifne +1191 -> 7188
    //   6000: aload_0
    //   6001: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   6004: invokestatic 97	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   6007: istore 8
    //   6009: aload_2
    //   6010: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6013: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6016: ifne +1231 -> 7247
    //   6019: new 256	java/lang/StringBuilder
    //   6022: dup
    //   6023: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   6026: ldc_w 353
    //   6029: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6032: aload_0
    //   6033: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   6036: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6039: ldc_w 355
    //   6042: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6045: aload_0
    //   6046: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   6049: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6052: ldc_w 364
    //   6055: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6058: astore 20
    //   6060: aload_0
    //   6061: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   6064: ifeq +1160 -> 7224
    //   6067: aload 14
    //   6069: ifnull +1155 -> 7224
    //   6072: aload 14
    //   6074: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6077: ifnull +1147 -> 7224
    //   6080: aload 14
    //   6082: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6085: invokevirtual 371	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   6088: astore 16
    //   6090: aload 20
    //   6092: aload 16
    //   6094: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6097: ldc_w 373
    //   6100: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6103: aload 17
    //   6105: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6108: ldc_w 378
    //   6111: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6114: aconst_null
    //   6115: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6118: ldc_w 380
    //   6121: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6124: aconst_null
    //   6125: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6128: ldc_w 382
    //   6131: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6134: invokestatic 386	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6137: invokevirtual 389	java/lang/Thread:getId	()J
    //   6140: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6143: ldc_w 394
    //   6146: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6149: invokestatic 399	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   6152: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6155: ldc_w 401
    //   6158: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6161: iload 8
    //   6163: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6166: ldc_w 403
    //   6169: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6172: invokestatic 408	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6175: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6178: ldc_w 413
    //   6181: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6184: aload_2
    //   6185: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6188: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6191: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6194: ldc_w 418
    //   6197: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6200: aload_2
    //   6201: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6204: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6207: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6210: ldc_w 423
    //   6213: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6216: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   6219: aload_0
    //   6220: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   6223: lsub
    //   6224: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6227: ldc_w 425
    //   6230: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6233: aload_2
    //   6234: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6237: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6240: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6243: ldc_w 427
    //   6246: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6249: aload_2
    //   6250: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6253: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6256: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6259: ldc_w 429
    //   6262: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6265: aload_2
    //   6266: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6269: getfield 432	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   6272: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6275: ldc_w 434
    //   6278: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6281: aload_0
    //   6282: invokevirtual 437	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   6285: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6288: ldc_w 439
    //   6291: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6294: aload_0
    //   6295: invokevirtual 442	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   6298: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6301: ldc_w 444
    //   6304: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6307: aload_2
    //   6308: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6311: invokevirtual 447	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   6314: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6317: ldc_w 449
    //   6320: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6323: iload_3
    //   6324: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6327: ldc_w 451
    //   6330: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6333: aload 18
    //   6335: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6338: ldc_w 453
    //   6341: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6344: aload 15
    //   6346: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6349: ldc_w 455
    //   6352: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6355: astore 20
    //   6357: aload_0
    //   6358: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   6361: ifnull +871 -> 7232
    //   6364: aload_0
    //   6365: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   6368: iconst_0
    //   6369: bipush 30
    //   6371: invokevirtual 461	java/lang/String:substring	(II)Ljava/lang/String;
    //   6374: astore 16
    //   6376: aload 20
    //   6378: aload 16
    //   6380: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6383: ldc_w 463
    //   6386: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6389: aload_2
    //   6390: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6393: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6396: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6399: ldc_w 468
    //   6402: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6405: lconst_0
    //   6406: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6409: ldc_w 470
    //   6412: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6415: aload_0
    //   6416: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   6419: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6422: ldc_w 439
    //   6425: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6428: aload_0
    //   6429: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   6432: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6435: ldc_w 472
    //   6438: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6441: aload_0
    //   6442: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   6445: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6448: ldc_w 439
    //   6451: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6454: aload_0
    //   6455: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   6458: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6461: ldc_w 474
    //   6464: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6467: aload_0
    //   6468: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   6471: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6474: ldc_w 476
    //   6477: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6480: aload_0
    //   6481: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   6484: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6487: ldc_w 481
    //   6490: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6493: aload_0
    //   6494: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   6497: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6500: ldc_w 486
    //   6503: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6506: astore 20
    //   6508: aload_0
    //   6509: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6512: ifnull +729 -> 7241
    //   6515: aload_0
    //   6516: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6519: invokeinterface 180 1 0
    //   6524: astore 16
    //   6526: aload 19
    //   6528: aload 20
    //   6530: aload 16
    //   6532: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6535: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6538: putfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   6541: ldc_w 491
    //   6544: aload 19
    //   6546: getfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   6549: aconst_null
    //   6550: invokestatic 495	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6553: iload 8
    //   6555: ifne +8 -> 6563
    //   6558: aload_0
    //   6559: iconst_0
    //   6560: putfield 498	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   6563: aload_2
    //   6564: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6567: astore 16
    //   6569: new 256	java/lang/StringBuilder
    //   6572: dup
    //   6573: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   6576: aload_0
    //   6577: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   6580: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6583: ldc_w 500
    //   6586: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6589: aconst_null
    //   6590: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6593: ldc_w 502
    //   6596: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6599: aload_2
    //   6600: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6603: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6606: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6609: ldc_w 504
    //   6612: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6615: astore 20
    //   6617: aload_0
    //   6618: getfield 508	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6621: ifnull +1159 -> 7780
    //   6624: aload_0
    //   6625: getfield 508	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6628: getfield 511	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6631: istore 4
    //   6633: aload 20
    //   6635: iload 4
    //   6637: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6640: ldc_w 449
    //   6643: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6646: iload_3
    //   6647: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6650: ldc_w 413
    //   6653: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6656: aload_2
    //   6657: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6660: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6663: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6666: ldc_w 425
    //   6669: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6672: aload_2
    //   6673: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6676: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6679: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6682: ldc_w 427
    //   6685: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6688: aload_2
    //   6689: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6692: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6695: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6698: ldc_w 418
    //   6701: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6704: aload_2
    //   6705: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6708: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6711: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6714: ldc_w 423
    //   6717: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6720: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   6723: aload_0
    //   6724: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   6727: lsub
    //   6728: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6731: astore 20
    //   6733: aload 15
    //   6735: invokestatic 517	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6738: ifne +1048 -> 7786
    //   6741: new 256	java/lang/StringBuilder
    //   6744: dup
    //   6745: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   6748: ldc_w 453
    //   6751: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6754: aload 15
    //   6756: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6759: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6762: astore 15
    //   6764: aload 16
    //   6766: aload 20
    //   6768: aload 15
    //   6770: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6773: ldc_w 451
    //   6776: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6779: aload 18
    //   6781: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6784: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6787: putfield 520	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   6790: iload 8
    //   6792: ifeq +64 -> 6856
    //   6795: aload_0
    //   6796: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   6799: invokestatic 525	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   6802: astore 15
    //   6804: aload_0
    //   6805: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   6808: astore 16
    //   6810: aload_0
    //   6811: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   6814: ifeq +980 -> 7794
    //   6817: aload_0
    //   6818: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   6821: ifnull +973 -> 7794
    //   6824: aload_0
    //   6825: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   6828: ldc_w 527
    //   6831: invokevirtual 530	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6834: ifeq +960 -> 7794
    //   6837: iconst_1
    //   6838: istore 8
    //   6840: aload 15
    //   6842: aload 16
    //   6844: iload 8
    //   6846: aload_2
    //   6847: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6850: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6853: invokevirtual 534	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   6856: aload 19
    //   6858: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   6861: putfield 537	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   6864: aload 19
    //   6866: aload_0
    //   6867: invokevirtual 538	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   6870: putfield 541	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   6873: aload 19
    //   6875: aload 14
    //   6877: putfield 545	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   6880: aload 19
    //   6882: iload_3
    //   6883: putfield 546	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   6886: aload 19
    //   6888: aconst_null
    //   6889: putfield 550	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   6892: aload 17
    //   6894: ifnonnull +906 -> 7800
    //   6897: aconst_null
    //   6898: astore 15
    //   6900: aload 19
    //   6902: aload 15
    //   6904: putfield 553	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   6907: aload 19
    //   6909: aconst_null
    //   6910: putfield 556	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   6913: aload 19
    //   6915: aload_2
    //   6916: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6919: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6922: putfield 557	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   6925: aload 19
    //   6927: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   6930: aload_0
    //   6931: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   6934: lsub
    //   6935: putfield 560	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6938: aload 19
    //   6940: aload_2
    //   6941: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6944: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6947: putfield 563	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   6950: aload 19
    //   6952: aload 19
    //   6954: getfield 560	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6957: aload_2
    //   6958: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6961: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6964: lsub
    //   6965: putfield 566	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   6968: aload 19
    //   6970: lconst_0
    //   6971: putfield 569	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   6974: aload 19
    //   6976: aload_0
    //   6977: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   6980: putfield 572	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   6983: aload 19
    //   6985: aload_0
    //   6986: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   6989: putfield 575	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   6992: aload 19
    //   6994: aload_0
    //   6995: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   6998: putfield 578	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   7001: aload 19
    //   7003: lconst_0
    //   7004: putfield 581	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   7007: aload 19
    //   7009: aload_0
    //   7010: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   7013: putfield 584	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   7016: aload 19
    //   7018: aload_2
    //   7019: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7022: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7025: putfield 587	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   7028: aload 19
    //   7030: aload_0
    //   7031: invokevirtual 143	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   7034: invokestatic 590	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   7037: putfield 592	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   7040: aload 19
    //   7042: aload_0
    //   7043: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   7046: putfield 595	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   7049: aload_0
    //   7050: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7053: ifnull +757 -> 7810
    //   7056: aload_0
    //   7057: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7060: ldc_w 527
    //   7063: invokevirtual 530	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7066: ifeq +744 -> 7810
    //   7069: iconst_1
    //   7070: istore 8
    //   7072: aload 19
    //   7074: iload 8
    //   7076: putfield 598	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   7079: aload 19
    //   7081: aload_2
    //   7082: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7085: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7088: putfield 600	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   7091: aload 19
    //   7093: getstatic 606	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   7096: invokevirtual 609	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   7099: putfield 612	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   7102: aload 19
    //   7104: aload_0
    //   7105: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   7108: invokevirtual 615	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   7111: putfield 618	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   7114: aload 14
    //   7116: ifnull +24 -> 7140
    //   7119: aload 14
    //   7121: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7124: ifnull +16 -> 7140
    //   7127: aload 19
    //   7129: aload 14
    //   7131: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7134: invokevirtual 371	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   7137: putfield 620	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   7140: aload 19
    //   7142: aload_0
    //   7143: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   7146: invokevirtual 624	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   7149: putfield 628	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   7152: aload 19
    //   7154: aload_0
    //   7155: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   7158: invokevirtual 631	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   7161: putfield 634	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   7164: aload_2
    //   7165: aload 19
    //   7167: invokevirtual 638	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   7170: aload_2
    //   7171: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7174: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7177: ifeq +11 -> 7188
    //   7180: aload_0
    //   7181: aload_1
    //   7182: aload_2
    //   7183: aload 19
    //   7185: invokevirtual 87	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   7188: aload_0
    //   7189: aconst_null
    //   7190: putfield 158	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   7193: iload 5
    //   7195: iconst_1
    //   7196: iadd
    //   7197: istore_3
    //   7198: goto -3895 -> 3303
    //   7201: aload 14
    //   7203: astore 16
    //   7205: aload_2
    //   7206: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7209: iconst_3
    //   7210: invokevirtual 112	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   7213: iconst_0
    //   7214: istore_3
    //   7215: goto -1339 -> 5876
    //   7218: aconst_null
    //   7219: astore 15
    //   7221: goto -1259 -> 5962
    //   7224: ldc_w 661
    //   7227: astore 16
    //   7229: goto -1139 -> 6090
    //   7232: aload_0
    //   7233: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7236: astore 16
    //   7238: goto -862 -> 6376
    //   7241: aconst_null
    //   7242: astore 16
    //   7244: goto -718 -> 6526
    //   7247: new 256	java/lang/StringBuilder
    //   7250: dup
    //   7251: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   7254: ldc_w 663
    //   7257: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7260: aload_0
    //   7261: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   7264: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7267: ldc_w 355
    //   7270: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7273: aload_0
    //   7274: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   7277: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7280: ldc_w 364
    //   7283: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7286: astore 20
    //   7288: aload_0
    //   7289: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   7292: ifeq +465 -> 7757
    //   7295: aload 14
    //   7297: ifnull +460 -> 7757
    //   7300: aload 14
    //   7302: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7305: ifnull +452 -> 7757
    //   7308: aload 14
    //   7310: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7313: invokevirtual 371	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   7316: astore 16
    //   7318: aload 20
    //   7320: aload 16
    //   7322: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7325: ldc_w 373
    //   7328: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7331: aload 17
    //   7333: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7336: ldc_w 378
    //   7339: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7342: aconst_null
    //   7343: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7346: ldc_w 380
    //   7349: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7352: aconst_null
    //   7353: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7356: ldc_w 382
    //   7359: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7362: invokestatic 386	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7365: invokevirtual 389	java/lang/Thread:getId	()J
    //   7368: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7371: ldc_w 394
    //   7374: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7377: invokestatic 399	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7380: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7383: ldc_w 403
    //   7386: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7389: invokestatic 408	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7392: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7395: ldc_w 418
    //   7398: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7401: aload_2
    //   7402: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7405: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7408: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7411: ldc_w 423
    //   7414: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7417: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   7420: aload_0
    //   7421: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   7424: lsub
    //   7425: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7428: ldc_w 425
    //   7431: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7434: aload_2
    //   7435: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7438: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7441: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7444: ldc_w 427
    //   7447: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7450: aload_2
    //   7451: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7454: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7457: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7460: ldc_w 429
    //   7463: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7466: aload_2
    //   7467: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7470: getfield 432	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7473: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7476: ldc_w 434
    //   7479: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7482: aload_0
    //   7483: invokevirtual 437	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   7486: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7489: ldc_w 439
    //   7492: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7495: aload_0
    //   7496: invokevirtual 442	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   7499: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7502: ldc_w 665
    //   7505: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7508: iload_3
    //   7509: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7512: ldc_w 451
    //   7515: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7518: aload 18
    //   7520: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7523: ldc_w 413
    //   7526: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7529: aload_2
    //   7530: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7533: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7536: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7539: ldc_w 453
    //   7542: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7545: aload 15
    //   7547: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7550: ldc_w 455
    //   7553: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7556: astore 20
    //   7558: aload_0
    //   7559: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7562: ifnull +203 -> 7765
    //   7565: aload_0
    //   7566: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7569: iconst_0
    //   7570: bipush 30
    //   7572: invokevirtual 461	java/lang/String:substring	(II)Ljava/lang/String;
    //   7575: astore 16
    //   7577: aload 20
    //   7579: aload 16
    //   7581: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7584: ldc_w 463
    //   7587: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7590: aload_2
    //   7591: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7594: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7597: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7600: ldc_w 468
    //   7603: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7606: lconst_0
    //   7607: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7610: ldc_w 470
    //   7613: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7616: aload_0
    //   7617: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   7620: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7623: ldc_w 439
    //   7626: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7629: aload_0
    //   7630: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   7633: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7636: ldc_w 472
    //   7639: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7642: aload_0
    //   7643: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   7646: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7649: ldc_w 439
    //   7652: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7655: aload_0
    //   7656: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   7659: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7662: ldc_w 474
    //   7665: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7668: aload_0
    //   7669: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   7672: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7675: ldc_w 476
    //   7678: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7681: aload_0
    //   7682: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   7685: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7688: ldc_w 481
    //   7691: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7694: aload_0
    //   7695: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   7698: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7701: ldc_w 486
    //   7704: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7707: astore 20
    //   7709: aload_0
    //   7710: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7713: ifnull +61 -> 7774
    //   7716: aload_0
    //   7717: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7720: invokeinterface 180 1 0
    //   7725: astore 16
    //   7727: aload 19
    //   7729: aload 20
    //   7731: aload 16
    //   7733: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7736: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7739: putfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7742: ldc_w 491
    //   7745: aload 19
    //   7747: getfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7750: aconst_null
    //   7751: invokestatic 668	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7754: goto -1201 -> 6553
    //   7757: ldc_w 661
    //   7760: astore 16
    //   7762: goto -444 -> 7318
    //   7765: aload_0
    //   7766: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7769: astore 16
    //   7771: goto -194 -> 7577
    //   7774: aconst_null
    //   7775: astore 16
    //   7777: goto -50 -> 7727
    //   7780: iconst_0
    //   7781: istore 4
    //   7783: goto -1150 -> 6633
    //   7786: ldc_w 670
    //   7789: astore 15
    //   7791: goto -1027 -> 6764
    //   7794: iconst_0
    //   7795: istore 8
    //   7797: goto -957 -> 6840
    //   7800: aload 17
    //   7802: invokevirtual 673	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   7805: astore 15
    //   7807: goto -907 -> 6900
    //   7810: iconst_0
    //   7811: istore 8
    //   7813: goto -741 -> 7072
    //   7816: aconst_null
    //   7817: astore 16
    //   7819: goto -5754 -> 2065
    //   7822: ldc_w 661
    //   7825: astore 17
    //   7827: goto -5634 -> 2193
    //   7830: aload_0
    //   7831: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7834: astore 17
    //   7836: goto -5357 -> 2479
    //   7839: aconst_null
    //   7840: astore 17
    //   7842: goto -5213 -> 2629
    //   7845: new 256	java/lang/StringBuilder
    //   7848: dup
    //   7849: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   7852: ldc_w 663
    //   7855: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7858: aload_0
    //   7859: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   7862: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7865: ldc_w 355
    //   7868: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7871: aload_0
    //   7872: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   7875: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7878: ldc_w 364
    //   7881: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7884: astore 21
    //   7886: aload_0
    //   7887: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   7890: ifeq +465 -> 8355
    //   7893: aload 14
    //   7895: ifnull +460 -> 8355
    //   7898: aload 14
    //   7900: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7903: ifnull +452 -> 8355
    //   7906: aload 14
    //   7908: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7911: invokevirtual 371	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   7914: astore 17
    //   7916: aload 21
    //   7918: aload 17
    //   7920: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7923: ldc_w 373
    //   7926: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7929: aload 18
    //   7931: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7934: ldc_w 378
    //   7937: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7940: aconst_null
    //   7941: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7944: ldc_w 380
    //   7947: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7950: aconst_null
    //   7951: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7954: ldc_w 382
    //   7957: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7960: invokestatic 386	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7963: invokevirtual 389	java/lang/Thread:getId	()J
    //   7966: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7969: ldc_w 394
    //   7972: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7975: invokestatic 399	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7978: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7981: ldc_w 403
    //   7984: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7987: invokestatic 408	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7990: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7993: ldc_w 418
    //   7996: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7999: aload_2
    //   8000: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8003: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8006: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8009: ldc_w 423
    //   8012: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8015: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   8018: aload_0
    //   8019: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   8022: lsub
    //   8023: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8026: ldc_w 425
    //   8029: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8032: aload_2
    //   8033: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8036: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8039: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8042: ldc_w 427
    //   8045: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8048: aload_2
    //   8049: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8052: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8055: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8058: ldc_w 429
    //   8061: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8064: aload_2
    //   8065: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8068: getfield 432	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8071: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8074: ldc_w 434
    //   8077: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8080: aload_0
    //   8081: invokevirtual 437	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   8084: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8087: ldc_w 439
    //   8090: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8093: aload_0
    //   8094: invokevirtual 442	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   8097: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8100: ldc_w 665
    //   8103: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8106: iload_3
    //   8107: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8110: ldc_w 451
    //   8113: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8116: aload 20
    //   8118: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8121: ldc_w 413
    //   8124: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8127: aload_2
    //   8128: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8131: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8134: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8137: ldc_w 453
    //   8140: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8143: aload 16
    //   8145: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8148: ldc_w 455
    //   8151: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8154: astore 21
    //   8156: aload_0
    //   8157: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   8160: ifnull +203 -> 8363
    //   8163: aload_0
    //   8164: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   8167: iconst_0
    //   8168: bipush 30
    //   8170: invokevirtual 461	java/lang/String:substring	(II)Ljava/lang/String;
    //   8173: astore 17
    //   8175: aload 21
    //   8177: aload 17
    //   8179: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8182: ldc_w 463
    //   8185: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8188: aload_2
    //   8189: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8192: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8195: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8198: ldc_w 468
    //   8201: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8204: lconst_0
    //   8205: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8208: ldc_w 470
    //   8211: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8214: aload_0
    //   8215: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   8218: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8221: ldc_w 439
    //   8224: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8227: aload_0
    //   8228: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   8231: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8234: ldc_w 472
    //   8237: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8240: aload_0
    //   8241: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   8244: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8247: ldc_w 439
    //   8250: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8253: aload_0
    //   8254: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   8257: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8260: ldc_w 474
    //   8263: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8266: aload_0
    //   8267: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   8270: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8273: ldc_w 476
    //   8276: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8279: aload_0
    //   8280: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   8283: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8286: ldc_w 481
    //   8289: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8292: aload_0
    //   8293: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   8296: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8299: ldc_w 486
    //   8302: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8305: astore 21
    //   8307: aload_0
    //   8308: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8311: ifnull +61 -> 8372
    //   8314: aload_0
    //   8315: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8318: invokeinterface 180 1 0
    //   8323: astore 17
    //   8325: aload 19
    //   8327: aload 21
    //   8329: aload 17
    //   8331: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8334: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8337: putfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8340: ldc_w 491
    //   8343: aload 19
    //   8345: getfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8348: aconst_null
    //   8349: invokestatic 668	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8352: goto -5695 -> 2657
    //   8355: ldc_w 661
    //   8358: astore 17
    //   8360: goto -444 -> 7916
    //   8363: aload_0
    //   8364: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   8367: astore 17
    //   8369: goto -194 -> 8175
    //   8372: aconst_null
    //   8373: astore 17
    //   8375: goto -50 -> 8325
    //   8378: iconst_0
    //   8379: istore 4
    //   8381: goto -5644 -> 2737
    //   8384: ldc_w 670
    //   8387: astore 16
    //   8389: goto -5521 -> 2868
    //   8392: iconst_0
    //   8393: istore 8
    //   8395: goto -5451 -> 2944
    //   8398: aload 18
    //   8400: invokevirtual 673	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   8403: astore 15
    //   8405: goto -5400 -> 3005
    //   8408: iconst_0
    //   8409: istore 8
    //   8411: goto -5234 -> 3177
    //   8414: astore 14
    //   8416: aconst_null
    //   8417: astore 15
    //   8419: aload_2
    //   8420: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8423: lload 12
    //   8425: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   8428: invokevirtual 314	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   8431: aload_2
    //   8432: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8435: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   8438: aload_0
    //   8439: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   8442: lsub
    //   8443: putfield 317	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   8446: aload_2
    //   8447: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8450: aload_0
    //   8451: getfield 320	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   8454: putfield 323	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   8457: aload_0
    //   8458: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   8461: invokestatic 329	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   8464: invokevirtual 333	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   8467: astore 20
    //   8469: aload_0
    //   8470: aconst_null
    //   8471: aconst_null
    //   8472: aload 16
    //   8474: invokevirtual 337	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   8477: astore 21
    //   8479: aload 16
    //   8481: ifnull +1260 -> 9741
    //   8484: aload 16
    //   8486: invokevirtual 340	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   8489: ifnull +1252 -> 9741
    //   8492: aload 16
    //   8494: invokevirtual 340	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   8497: ldc_w 342
    //   8500: invokevirtual 345	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   8503: astore 17
    //   8505: aload_2
    //   8506: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8509: aload 17
    //   8511: putfield 348	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   8514: aload_0
    //   8515: lconst_0
    //   8516: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   8519: aload_0
    //   8520: iconst_0
    //   8521: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   8524: aload_0
    //   8525: lconst_0
    //   8526: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   8529: aload_0
    //   8530: iconst_0
    //   8531: putfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   8534: aload_1
    //   8535: invokeinterface 83 1 0
    //   8540: ifne +1193 -> 9733
    //   8543: aload_0
    //   8544: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   8547: invokestatic 97	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8550: istore 8
    //   8552: aload_2
    //   8553: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8556: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8559: ifne +1211 -> 9770
    //   8562: new 256	java/lang/StringBuilder
    //   8565: dup
    //   8566: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   8569: ldc_w 353
    //   8572: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8575: aload_0
    //   8576: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   8579: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8582: ldc_w 355
    //   8585: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8588: aload_0
    //   8589: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   8592: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8595: ldc_w 364
    //   8598: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8601: astore 22
    //   8603: aload_0
    //   8604: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   8607: ifeq +1140 -> 9747
    //   8610: aload 16
    //   8612: ifnull +1135 -> 9747
    //   8615: aload 16
    //   8617: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8620: ifnull +1127 -> 9747
    //   8623: aload 16
    //   8625: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8628: invokevirtual 371	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   8631: astore 18
    //   8633: aload 22
    //   8635: aload 18
    //   8637: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8640: ldc_w 373
    //   8643: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8646: aload 20
    //   8648: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8651: ldc_w 378
    //   8654: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8657: aconst_null
    //   8658: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8661: ldc_w 380
    //   8664: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8667: aconst_null
    //   8668: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8671: ldc_w 382
    //   8674: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8677: invokestatic 386	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8680: invokevirtual 389	java/lang/Thread:getId	()J
    //   8683: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8686: ldc_w 394
    //   8689: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8692: invokestatic 399	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   8695: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8698: ldc_w 401
    //   8701: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8704: iload 8
    //   8706: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8709: ldc_w 403
    //   8712: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8715: invokestatic 408	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   8718: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8721: ldc_w 413
    //   8724: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8727: aload_2
    //   8728: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8731: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8734: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8737: ldc_w 418
    //   8740: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8743: aload_2
    //   8744: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8747: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8750: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8753: ldc_w 423
    //   8756: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8759: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   8762: aload_0
    //   8763: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   8766: lsub
    //   8767: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8770: ldc_w 425
    //   8773: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8776: aload_2
    //   8777: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8780: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8783: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8786: ldc_w 427
    //   8789: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8792: aload_2
    //   8793: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8796: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8799: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8802: ldc_w 429
    //   8805: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8808: aload_2
    //   8809: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8812: getfield 432	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8815: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8818: ldc_w 434
    //   8821: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8824: aload_0
    //   8825: invokevirtual 437	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   8828: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8831: ldc_w 439
    //   8834: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8837: aload_0
    //   8838: invokevirtual 442	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   8841: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8844: ldc_w 444
    //   8847: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8850: aload_2
    //   8851: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8854: invokevirtual 447	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   8857: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8860: ldc_w 449
    //   8863: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8866: iload_3
    //   8867: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8870: ldc_w 451
    //   8873: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8876: aload 21
    //   8878: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8881: ldc_w 453
    //   8884: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8887: aload 17
    //   8889: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8892: ldc_w 455
    //   8895: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8898: astore 22
    //   8900: aload_0
    //   8901: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   8904: ifnull +851 -> 9755
    //   8907: aload_0
    //   8908: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   8911: iconst_0
    //   8912: bipush 30
    //   8914: invokevirtual 461	java/lang/String:substring	(II)Ljava/lang/String;
    //   8917: astore 18
    //   8919: aload 22
    //   8921: aload 18
    //   8923: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8926: ldc_w 463
    //   8929: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8932: aload_2
    //   8933: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8936: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8939: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8942: ldc_w 468
    //   8945: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8948: lconst_0
    //   8949: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8952: ldc_w 470
    //   8955: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8958: aload_0
    //   8959: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   8962: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8965: ldc_w 439
    //   8968: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8971: aload_0
    //   8972: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   8975: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8978: ldc_w 472
    //   8981: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8984: aload_0
    //   8985: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   8988: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8991: ldc_w 439
    //   8994: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8997: aload_0
    //   8998: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   9001: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9004: ldc_w 474
    //   9007: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9010: aload_0
    //   9011: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   9014: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9017: ldc_w 476
    //   9020: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9023: aload_0
    //   9024: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   9027: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9030: ldc_w 481
    //   9033: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9036: aload_0
    //   9037: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   9040: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9043: ldc_w 486
    //   9046: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9049: astore 22
    //   9051: aload_0
    //   9052: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9055: ifnull +709 -> 9764
    //   9058: aload_0
    //   9059: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9062: invokeinterface 180 1 0
    //   9067: astore 18
    //   9069: aload 19
    //   9071: aload 22
    //   9073: aload 18
    //   9075: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9078: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9081: putfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9084: ldc_w 491
    //   9087: aload 19
    //   9089: getfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9092: aload 15
    //   9094: invokestatic 495	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9097: iload 8
    //   9099: ifne +8 -> 9107
    //   9102: aload_0
    //   9103: iconst_0
    //   9104: putfield 498	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   9107: aload_2
    //   9108: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9111: astore 18
    //   9113: new 256	java/lang/StringBuilder
    //   9116: dup
    //   9117: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   9120: aload_0
    //   9121: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   9124: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9127: ldc_w 500
    //   9130: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9133: aconst_null
    //   9134: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9137: ldc_w 502
    //   9140: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9143: aload_2
    //   9144: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9147: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9150: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9153: ldc_w 504
    //   9156: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9159: astore 22
    //   9161: aload_0
    //   9162: getfield 508	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9165: ifnull +1138 -> 10303
    //   9168: aload_0
    //   9169: getfield 508	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9172: getfield 511	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9175: istore 4
    //   9177: aload 22
    //   9179: iload 4
    //   9181: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9184: ldc_w 449
    //   9187: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9190: iload_3
    //   9191: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9194: ldc_w 413
    //   9197: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9200: aload_2
    //   9201: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9204: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9207: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9210: ldc_w 425
    //   9213: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9216: aload_2
    //   9217: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9220: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9223: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9226: ldc_w 427
    //   9229: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9232: aload_2
    //   9233: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9236: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9239: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9242: ldc_w 418
    //   9245: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9248: aload_2
    //   9249: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9252: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9255: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9258: ldc_w 423
    //   9261: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9264: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   9267: aload_0
    //   9268: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   9271: lsub
    //   9272: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9275: astore 22
    //   9277: aload 17
    //   9279: invokestatic 517	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9282: ifne +1027 -> 10309
    //   9285: new 256	java/lang/StringBuilder
    //   9288: dup
    //   9289: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   9292: ldc_w 453
    //   9295: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9298: aload 17
    //   9300: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9303: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9306: astore 17
    //   9308: aload 18
    //   9310: aload 22
    //   9312: aload 17
    //   9314: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9317: ldc_w 451
    //   9320: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9323: aload 21
    //   9325: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9328: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9331: putfield 520	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   9334: iload 8
    //   9336: ifeq +64 -> 9400
    //   9339: aload_0
    //   9340: getfield 91	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   9343: invokestatic 525	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   9346: astore 17
    //   9348: aload_0
    //   9349: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   9352: astore 18
    //   9354: aload_0
    //   9355: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   9358: ifeq +959 -> 10317
    //   9361: aload_0
    //   9362: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   9365: ifnull +952 -> 10317
    //   9368: aload_0
    //   9369: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   9372: ldc_w 527
    //   9375: invokevirtual 530	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9378: ifeq +939 -> 10317
    //   9381: iconst_1
    //   9382: istore 8
    //   9384: aload 17
    //   9386: aload 18
    //   9388: iload 8
    //   9390: aload_2
    //   9391: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9394: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9397: invokevirtual 534	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   9400: aload 19
    //   9402: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   9405: putfield 537	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   9408: aload 19
    //   9410: aload_0
    //   9411: invokevirtual 538	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   9414: putfield 541	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   9417: aload 19
    //   9419: aload 16
    //   9421: putfield 545	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   9424: aload 19
    //   9426: iload_3
    //   9427: putfield 546	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   9430: aload 19
    //   9432: aload 15
    //   9434: putfield 550	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   9437: aload 20
    //   9439: ifnonnull +884 -> 10323
    //   9442: aconst_null
    //   9443: astore 15
    //   9445: aload 19
    //   9447: aload 15
    //   9449: putfield 553	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   9452: aload 19
    //   9454: aconst_null
    //   9455: putfield 556	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   9458: aload 19
    //   9460: aload_2
    //   9461: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9464: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9467: putfield 557	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   9470: aload 19
    //   9472: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   9475: aload_0
    //   9476: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   9479: lsub
    //   9480: putfield 560	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9483: aload 19
    //   9485: aload_2
    //   9486: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9489: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9492: putfield 563	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   9495: aload 19
    //   9497: aload 19
    //   9499: getfield 560	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9502: aload_2
    //   9503: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9506: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9509: lsub
    //   9510: putfield 566	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   9513: aload 19
    //   9515: lconst_0
    //   9516: putfield 569	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   9519: aload 19
    //   9521: aload_0
    //   9522: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   9525: putfield 572	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   9528: aload 19
    //   9530: aload_0
    //   9531: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   9534: putfield 575	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   9537: aload 19
    //   9539: aload_0
    //   9540: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   9543: putfield 578	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   9546: aload 19
    //   9548: lconst_0
    //   9549: putfield 581	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   9552: aload 19
    //   9554: aload_0
    //   9555: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   9558: putfield 584	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   9561: aload 19
    //   9563: aload_2
    //   9564: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9567: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9570: putfield 587	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   9573: aload 19
    //   9575: aload_0
    //   9576: invokevirtual 143	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   9579: invokestatic 590	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   9582: putfield 592	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   9585: aload 19
    //   9587: aload_0
    //   9588: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   9591: putfield 595	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   9594: aload_0
    //   9595: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   9598: ifnull +735 -> 10333
    //   9601: aload_0
    //   9602: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   9605: ldc_w 527
    //   9608: invokevirtual 530	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9611: ifeq +722 -> 10333
    //   9614: iconst_1
    //   9615: istore 8
    //   9617: aload 19
    //   9619: iload 8
    //   9621: putfield 598	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   9624: aload 19
    //   9626: aload_2
    //   9627: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9630: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9633: putfield 600	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   9636: aload 19
    //   9638: getstatic 606	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   9641: invokevirtual 609	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   9644: putfield 612	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   9647: aload 19
    //   9649: aload_0
    //   9650: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   9653: invokevirtual 615	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   9656: putfield 618	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   9659: aload 16
    //   9661: ifnull +24 -> 9685
    //   9664: aload 16
    //   9666: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9669: ifnull +16 -> 9685
    //   9672: aload 19
    //   9674: aload 16
    //   9676: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9679: invokevirtual 371	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9682: putfield 620	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   9685: aload 19
    //   9687: aload_0
    //   9688: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   9691: invokevirtual 624	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   9694: putfield 628	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   9697: aload 19
    //   9699: aload_0
    //   9700: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   9703: invokevirtual 631	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   9706: putfield 634	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   9709: aload_2
    //   9710: aload 19
    //   9712: invokevirtual 638	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9715: aload_2
    //   9716: invokevirtual 106	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9719: invokevirtual 351	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9722: ifeq +11 -> 9733
    //   9725: aload_0
    //   9726: aload_1
    //   9727: aload_2
    //   9728: aload 19
    //   9730: invokevirtual 87	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9733: aload_0
    //   9734: aconst_null
    //   9735: putfield 158	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   9738: aload 14
    //   9740: athrow
    //   9741: aconst_null
    //   9742: astore 17
    //   9744: goto -1239 -> 8505
    //   9747: ldc_w 661
    //   9750: astore 18
    //   9752: goto -1119 -> 8633
    //   9755: aload_0
    //   9756: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   9759: astore 18
    //   9761: goto -842 -> 8919
    //   9764: aconst_null
    //   9765: astore 18
    //   9767: goto -698 -> 9069
    //   9770: new 256	java/lang/StringBuilder
    //   9773: dup
    //   9774: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   9777: ldc_w 663
    //   9780: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9783: aload_0
    //   9784: invokevirtual 66	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   9787: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9790: ldc_w 355
    //   9793: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9796: aload_0
    //   9797: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   9800: invokevirtual 362	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9803: ldc_w 364
    //   9806: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9809: astore 22
    //   9811: aload_0
    //   9812: getfield 359	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   9815: ifeq +465 -> 10280
    //   9818: aload 16
    //   9820: ifnull +460 -> 10280
    //   9823: aload 16
    //   9825: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9828: ifnull +452 -> 10280
    //   9831: aload 16
    //   9833: invokevirtual 368	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9836: invokevirtual 371	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9839: astore 18
    //   9841: aload 22
    //   9843: aload 18
    //   9845: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9848: ldc_w 373
    //   9851: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9854: aload 20
    //   9856: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9859: ldc_w 378
    //   9862: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9865: aconst_null
    //   9866: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9869: ldc_w 380
    //   9872: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9875: aconst_null
    //   9876: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9879: ldc_w 382
    //   9882: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9885: invokestatic 386	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9888: invokevirtual 389	java/lang/Thread:getId	()J
    //   9891: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9894: ldc_w 394
    //   9897: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9900: invokestatic 399	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9903: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9906: ldc_w 403
    //   9909: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9912: invokestatic 408	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9915: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9918: ldc_w 418
    //   9921: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9924: aload_2
    //   9925: invokevirtual 308	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9928: getfield 421	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9931: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9934: ldc_w 423
    //   9937: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9940: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   9943: aload_0
    //   9944: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   9947: lsub
    //   9948: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9951: ldc_w 425
    //   9954: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9957: aload_2
    //   9958: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9961: getfield 283	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9964: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9967: ldc_w 427
    //   9970: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9973: aload_2
    //   9974: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9977: getfield 292	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9980: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9983: ldc_w 429
    //   9986: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9989: aload_2
    //   9990: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9993: getfield 432	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9996: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9999: ldc_w 434
    //   10002: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10005: aload_0
    //   10006: invokevirtual 437	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   10009: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10012: ldc_w 439
    //   10015: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10018: aload_0
    //   10019: invokevirtual 442	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   10022: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10025: ldc_w 665
    //   10028: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10031: iload_3
    //   10032: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10035: ldc_w 451
    //   10038: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10041: aload 21
    //   10043: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10046: ldc_w 413
    //   10049: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10052: aload_2
    //   10053: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10056: getfield 416	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10059: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10062: ldc_w 453
    //   10065: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10068: aload 17
    //   10070: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10073: ldc_w 455
    //   10076: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10079: astore 22
    //   10081: aload_0
    //   10082: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   10085: ifnull +203 -> 10288
    //   10088: aload_0
    //   10089: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   10092: iconst_0
    //   10093: bipush 30
    //   10095: invokevirtual 461	java/lang/String:substring	(II)Ljava/lang/String;
    //   10098: astore 18
    //   10100: aload 22
    //   10102: aload 18
    //   10104: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10107: ldc_w 463
    //   10110: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10113: aload_2
    //   10114: invokevirtual 275	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10117: getfield 466	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10120: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10123: ldc_w 468
    //   10126: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10129: lconst_0
    //   10130: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10133: ldc_w 470
    //   10136: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10139: aload_0
    //   10140: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   10143: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10146: ldc_w 439
    //   10149: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10152: aload_0
    //   10153: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   10156: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10159: ldc_w 472
    //   10162: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10165: aload_0
    //   10166: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   10169: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10172: ldc_w 439
    //   10175: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10178: aload_0
    //   10179: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   10182: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10185: ldc_w 474
    //   10188: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10191: aload_0
    //   10192: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   10195: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10198: ldc_w 476
    //   10201: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10204: aload_0
    //   10205: getfield 479	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   10208: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10211: ldc_w 481
    //   10214: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10217: aload_0
    //   10218: invokevirtual 484	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   10221: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10224: ldc_w 486
    //   10227: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10230: astore 22
    //   10232: aload_0
    //   10233: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10236: ifnull +61 -> 10297
    //   10239: aload_0
    //   10240: getfield 174	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10243: invokeinterface 180 1 0
    //   10248: astore 18
    //   10250: aload 19
    //   10252: aload 22
    //   10254: aload 18
    //   10256: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10259: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10262: putfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10265: ldc_w 491
    //   10268: aload 19
    //   10270: getfield 489	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10273: aconst_null
    //   10274: invokestatic 668	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10277: goto -1180 -> 9097
    //   10280: ldc_w 661
    //   10283: astore 18
    //   10285: goto -444 -> 9841
    //   10288: aload_0
    //   10289: getfield 198	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   10292: astore 18
    //   10294: goto -194 -> 10100
    //   10297: aconst_null
    //   10298: astore 18
    //   10300: goto -50 -> 10250
    //   10303: iconst_0
    //   10304: istore 4
    //   10306: goto -1129 -> 9177
    //   10309: ldc_w 670
    //   10312: astore 17
    //   10314: goto -1006 -> 9308
    //   10317: iconst_0
    //   10318: istore 8
    //   10320: goto -936 -> 9384
    //   10323: aload 20
    //   10325: invokevirtual 673	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   10328: astore 15
    //   10330: goto -885 -> 9445
    //   10333: iconst_0
    //   10334: istore 8
    //   10336: goto -719 -> 9617
    //   10339: astore 15
    //   10341: aconst_null
    //   10342: astore 17
    //   10344: aload 14
    //   10346: astore 16
    //   10348: aload 15
    //   10350: astore 14
    //   10352: aload 17
    //   10354: astore 15
    //   10356: goto -1937 -> 8419
    //   10359: astore 14
    //   10361: aconst_null
    //   10362: astore 15
    //   10364: iload 4
    //   10366: istore_3
    //   10367: goto -1948 -> 8419
    //   10370: astore 17
    //   10372: aconst_null
    //   10373: astore 15
    //   10375: aload 14
    //   10377: astore 16
    //   10379: aload 17
    //   10381: astore 14
    //   10383: goto -1964 -> 8419
    //   10386: astore 17
    //   10388: aload 14
    //   10390: astore 16
    //   10392: aload 17
    //   10394: astore 14
    //   10396: goto -1977 -> 8419
    //   10399: astore 15
    //   10401: iload 6
    //   10403: istore_3
    //   10404: goto -8477 -> 1927
    //   10407: astore 15
    //   10409: iload 6
    //   10411: istore_3
    //   10412: goto -8485 -> 1927
    //   10415: astore 15
    //   10417: goto -8490 -> 1927
    //   10420: goto -4544 -> 5876
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10423	0	this	RangeDownloadTask
    //   0	10423	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	10423	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   164	10248	3	i	int
    //   166	10199	4	j	int
    //   26	7171	5	k	int
    //   169	10241	6	m	int
    //   18	107	7	n	int
    //   694	9641	8	bool1	boolean
    //   23	60	9	bool2	boolean
    //   335	97	10	l1	long
    //   111	8313	12	l2	long
    //   96	1	14	localException	java.lang.Exception
    //   198	7709	14	localObject1	java.lang.Object
    //   8414	1931	14	localObject2	java.lang.Object
    //   10350	1	14	localObject3	java.lang.Object
    //   10359	17	14	localObject4	java.lang.Object
    //   10381	14	14	localObject5	java.lang.Object
    //   180	1732	15	localObject6	java.lang.Object
    //   1919	1074	15	localThrowable1	java.lang.Throwable
    //   3003	7326	15	localObject7	java.lang.Object
    //   10339	10	15	localObject8	java.lang.Object
    //   10354	20	15	localObject9	java.lang.Object
    //   10399	1	15	localThrowable2	java.lang.Throwable
    //   10407	1	15	localThrowable3	java.lang.Throwable
    //   10415	1	15	localThrowable4	java.lang.Throwable
    //   161	10230	16	localObject10	java.lang.Object
    //   611	9742	17	localObject11	java.lang.Object
    //   10370	10	17	localObject12	java.lang.Object
    //   10386	7	17	localObject13	java.lang.Object
    //   621	9678	18	localObject14	java.lang.Object
    //   120	10149	19	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   745	9579	20	localObject15	java.lang.Object
    //   2161	7881	21	localObject16	java.lang.Object
    //   8601	1652	22	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   76	82	96	java/lang/Exception
    //   171	200	1919	java/lang/Throwable
    //   200	291	1919	java/lang/Throwable
    //   291	386	1919	java/lang/Throwable
    //   386	512	1919	java/lang/Throwable
    //   1887	1916	1919	java/lang/Throwable
    //   3316	3365	1919	java/lang/Throwable
    //   5210	5251	1919	java/lang/Throwable
    //   171	200	8414	finally
    //   200	291	8414	finally
    //   291	386	8414	finally
    //   386	512	8414	finally
    //   1887	1916	8414	finally
    //   3316	3365	8414	finally
    //   5210	5251	8414	finally
    //   512	526	10339	finally
    //   535	541	10359	finally
    //   1934	1970	10359	finally
    //   7205	7213	10359	finally
    //   541	549	10370	finally
    //   556	563	10370	finally
    //   5855	5876	10370	finally
    //   1970	1979	10386	finally
    //   512	526	10399	java/lang/Throwable
    //   535	541	10407	java/lang/Throwable
    //   7205	7213	10407	java/lang/Throwable
    //   541	549	10415	java/lang/Throwable
    //   556	563	10415	java/lang/Throwable
    //   5855	5876	10415	java/lang/Throwable
  }
  
  protected void initTask()
  {
    super.initTask();
    this.mRefer = HttpUtil.prepareRefer(getUrl());
  }
  
  public void onReceive(float paramFloat)
  {
    notifyDownloadProgress(getUrlKey(), this.mContentLength, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.RangeDownloadTask
 * JD-Core Version:    0.7.0.1
 */