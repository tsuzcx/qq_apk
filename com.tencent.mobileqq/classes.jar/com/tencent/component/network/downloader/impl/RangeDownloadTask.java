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
    //   0: aload_1
    //   1: astore 15
    //   3: aload_2
    //   4: astore 14
    //   6: ldc 62
    //   8: astore 26
    //   10: ldc 64
    //   12: astore 21
    //   14: ldc 66
    //   16: astore 16
    //   18: ldc 68
    //   20: astore 23
    //   22: ldc 70
    //   24: astore 18
    //   26: ldc 72
    //   28: astore 13
    //   30: ldc 74
    //   32: astore 25
    //   34: ldc 76
    //   36: astore 20
    //   38: ldc 78
    //   40: astore 27
    //   42: ldc 80
    //   44: astore 19
    //   46: aload_0
    //   47: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   50: astore 22
    //   52: ldc 86
    //   54: astore 17
    //   56: iconst_2
    //   57: anewarray 88	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload 22
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: aload 14
    //   69: aastore
    //   70: invokestatic 94	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:generateRandomId	([Ljava/lang/Object;)I
    //   73: istore 5
    //   75: invokestatic 100	com/tencent/component/network/utils/SDCardUtil:isSdCardHasEnoughCapability	()Z
    //   78: istore 8
    //   80: iconst_0
    //   81: istore_3
    //   82: aload_1
    //   83: invokeinterface 105 1 0
    //   88: ifeq +13 -> 101
    //   91: aload_0
    //   92: aload 15
    //   94: aload 14
    //   96: aconst_null
    //   97: invokevirtual 109	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   100: return
    //   101: aload_0
    //   102: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   105: invokestatic 119	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   108: ifne +42 -> 150
    //   111: iload_3
    //   112: aload_0
    //   113: getfield 122	com/tencent/component/network/downloader/impl/RangeDownloadTask:mAttemptTotalCount	I
    //   116: iconst_1
    //   117: isub
    //   118: if_icmpne +13 -> 131
    //   121: aload_2
    //   122: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   125: bipush 6
    //   127: invokevirtual 134	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   130: return
    //   131: ldc2_w 135
    //   134: invokestatic 141	java/lang/Thread:sleep	(J)V
    //   137: goto +13 -> 150
    //   140: ldc 143
    //   142: ldc 145
    //   144: invokestatic 151	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: goto +3 -> 150
    //   150: iload_3
    //   151: istore 6
    //   153: iload 8
    //   155: ifne +12 -> 167
    //   158: aload_2
    //   159: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   162: iconst_2
    //   163: invokevirtual 134	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   166: return
    //   167: aload 23
    //   169: astore 24
    //   171: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   174: lstore 9
    //   176: new 153	com/tencent/component/network/downloader/DownloadReport
    //   179: dup
    //   180: invokespecial 156	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   183: astore 15
    //   185: aload 15
    //   187: iload 5
    //   189: putfield 159	com/tencent/component/network/downloader/DownloadReport:id	I
    //   192: aload 15
    //   194: aload_0
    //   195: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   198: putfield 162	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   201: aload 15
    //   203: aload_0
    //   204: invokevirtual 165	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   207: putfield 168	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   210: aload 15
    //   212: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   215: putfield 176	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   218: aload_0
    //   219: aconst_null
    //   220: putfield 180	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   223: getstatic 184	com/tencent/component/network/downloader/impl/RangeDownloadTask:sRequestOptions	Ljava/lang/ThreadLocal;
    //   226: invokevirtual 190	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   229: checkcast 192	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   232: astore 29
    //   234: aload_0
    //   235: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   238: astore 22
    //   240: aload 22
    //   242: ifnull +87 -> 329
    //   245: aload_0
    //   246: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   249: invokeinterface 202 1 0
    //   254: astore 22
    //   256: goto +76 -> 332
    //   259: astore 22
    //   261: aload 13
    //   263: astore 28
    //   265: aconst_null
    //   266: astore 31
    //   268: aload 18
    //   270: astore 29
    //   272: aload 15
    //   274: astore 13
    //   276: aload 17
    //   278: astore 30
    //   280: aconst_null
    //   281: astore 14
    //   283: aload 20
    //   285: astore 15
    //   287: aload 19
    //   289: astore 17
    //   291: iconst_0
    //   292: istore_3
    //   293: aload 16
    //   295: astore 18
    //   297: aload 21
    //   299: astore 23
    //   301: aload 30
    //   303: astore 16
    //   305: aload 29
    //   307: astore 20
    //   309: aload 31
    //   311: astore 19
    //   313: aload 22
    //   315: astore 21
    //   317: aload 28
    //   319: astore 22
    //   321: goto +11150 -> 11471
    //   324: astore 24
    //   326: goto +8413 -> 8739
    //   329: aconst_null
    //   330: astore 22
    //   332: aload 29
    //   334: aload 22
    //   336: putfield 206	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   339: aload 15
    //   341: iload 6
    //   343: putfield 209	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   346: aload 15
    //   348: aload_0
    //   349: getfield 211	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRefer	Ljava/lang/String;
    //   352: putfield 214	com/tencent/component/network/downloader/DownloadReport:refer	Ljava/lang/String;
    //   355: aload_0
    //   356: aload_0
    //   357: aload_0
    //   358: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   361: invokevirtual 218	com/tencent/component/network/downloader/impl/RangeDownloadTask:prepareUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   364: putfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   367: aload_0
    //   368: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   371: astore 22
    //   373: aload_0
    //   374: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   377: astore 28
    //   379: aload_0
    //   380: invokevirtual 165	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   383: astore 30
    //   385: aload_0
    //   386: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   389: astore 31
    //   391: aload_0
    //   392: aload 22
    //   394: aload 28
    //   396: aload 30
    //   398: aload 31
    //   400: aload_0
    //   401: getfield 211	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRefer	Ljava/lang/String;
    //   404: invokestatic 226	com/tencent/component/network/utils/http/HttpUtil:createOkHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   407: putfield 180	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   410: aload_0
    //   411: getfield 230	com/tencent/component/network/downloader/impl/RangeDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   414: astore 22
    //   416: aload 22
    //   418: ifnull +38 -> 456
    //   421: aload_0
    //   422: getfield 230	com/tencent/component/network/downloader/impl/RangeDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   425: aconst_null
    //   426: aload_0
    //   427: getfield 180	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   430: aload_0
    //   431: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   434: aload_0
    //   435: invokevirtual 165	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   438: invokeinterface 236 5 0
    //   443: goto +13 -> 456
    //   446: astore 22
    //   448: goto -187 -> 261
    //   451: astore 24
    //   453: goto -127 -> 326
    //   456: aload_0
    //   457: aload_0
    //   458: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   461: aload_0
    //   462: invokevirtual 165	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   465: aconst_null
    //   466: aload_0
    //   467: getfield 180	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   470: invokevirtual 239	com/tencent/component/network/downloader/impl/RangeDownloadTask:prepareRequest	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;)V
    //   473: aload_0
    //   474: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   477: astore 30
    //   479: aload_0
    //   480: invokevirtual 165	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   483: astore 31
    //   485: aload_0
    //   486: getfield 180	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   489: astore 32
    //   491: aload 27
    //   493: astore 33
    //   495: aload 21
    //   497: astore 28
    //   499: aload 20
    //   501: astore 22
    //   503: aload_0
    //   504: aload 30
    //   506: aload 31
    //   508: aconst_null
    //   509: aload 32
    //   511: aload 29
    //   513: invokevirtual 243	com/tencent/component/network/downloader/impl/RangeDownloadTask:applyKeepAliveStrategy	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   516: aload_0
    //   517: lconst_0
    //   518: putfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   521: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   524: lstore 11
    //   526: aload_0
    //   527: getfield 180	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   530: astore 29
    //   532: aload 29
    //   534: ifnull +2750 -> 3284
    //   537: aload_0
    //   538: invokevirtual 246	com/tencent/component/network/downloader/impl/RangeDownloadTask:generateStorageName	()Ljava/lang/String;
    //   541: astore 30
    //   543: aload_0
    //   544: aload 30
    //   546: invokevirtual 249	com/tencent/component/network/downloader/impl/RangeDownloadTask:generateStoragePath	(Ljava/lang/String;)Ljava/lang/String;
    //   549: astore 29
    //   551: aload_0
    //   552: aload 30
    //   554: iconst_0
    //   555: invokevirtual 252	com/tencent/component/network/downloader/impl/RangeDownloadTask:generateStoragePath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   558: astore 30
    //   560: aload_0
    //   561: aload 29
    //   563: aload_0
    //   564: getfield 255	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContentLength	J
    //   567: invokevirtual 259	com/tencent/component/network/downloader/impl/RangeDownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   570: istore 7
    //   572: iload 7
    //   574: ifeq +23 -> 597
    //   577: aload 14
    //   579: aload 29
    //   581: invokevirtual 263	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   584: goto +47 -> 631
    //   587: astore 22
    //   589: goto +7994 -> 8583
    //   592: astore 20
    //   594: goto +2642 -> 3236
    //   597: aload 29
    //   599: aload 30
    //   601: invokestatic 269	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   604: istore 7
    //   606: iload 7
    //   608: ifne +349 -> 957
    //   611: aload_0
    //   612: aload 30
    //   614: aload_0
    //   615: getfield 255	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContentLength	J
    //   618: invokevirtual 259	com/tencent/component/network/downloader/impl/RangeDownloadTask:ensureStorageSpace	(Ljava/lang/String;J)Z
    //   621: ifeq +336 -> 957
    //   624: aload 14
    //   626: aload 30
    //   628: invokevirtual 263	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   631: aload_0
    //   632: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   635: aload_0
    //   636: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   639: aload_0
    //   640: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   643: aload_0
    //   644: getfield 180	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   647: aload_2
    //   648: invokevirtual 272	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   651: aload_0
    //   652: invokevirtual 276	com/tencent/component/network/downloader/RangeDownloadManager:tryBuildAllRangeRequests	(Ljava/lang/String;Ljava/lang/String;Lokhttp3/Request$Builder;Ljava/lang/String;Lcom/tencent/component/network/downloader/RangeDownloadManager$ProgressListener;)Z
    //   655: ifeq +241 -> 896
    //   658: aload_0
    //   659: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   662: aload_2
    //   663: invokevirtual 272	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   666: invokevirtual 280	com/tencent/component/network/downloader/RangeDownloadManager:createEmptyFile	(Ljava/lang/String;)Z
    //   669: ifeq +227 -> 896
    //   672: aload_0
    //   673: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   676: lload 11
    //   678: lsub
    //   679: putfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   682: new 282	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   689: astore 29
    //   691: aload 29
    //   693: ldc_w 285
    //   696: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: aload 29
    //   702: aload_0
    //   703: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   706: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload 29
    //   712: ldc_w 291
    //   715: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload 29
    //   721: aload_0
    //   722: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   725: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: ldc_w 293
    //   732: aload 29
    //   734: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokestatic 299	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   740: aload_2
    //   741: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   744: aload_0
    //   745: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   748: invokevirtual 306	com/tencent/component/network/downloader/RangeDownloadManager:getContentLength	()J
    //   751: putfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   754: aload_0
    //   755: aload_0
    //   756: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   759: invokevirtual 306	com/tencent/component/network/downloader/RangeDownloadManager:getContentLength	()J
    //   762: putfield 255	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContentLength	J
    //   765: aload_0
    //   766: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   769: invokevirtual 314	com/tencent/component/network/downloader/RangeDownloadManager:execute	()Lokhttp3/Response;
    //   772: astore 29
    //   774: aload_2
    //   775: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   778: aload_0
    //   779: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   782: invokevirtual 317	com/tencent/component/network/downloader/RangeDownloadManager:getTotalFileSize	()J
    //   785: putfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   788: aload 29
    //   790: astore 14
    //   792: goto +2495 -> 3287
    //   795: astore 21
    //   797: aload 13
    //   799: astore 30
    //   801: aload 18
    //   803: astore 20
    //   805: aload 28
    //   807: astore 23
    //   809: aload 15
    //   811: astore 13
    //   813: aload 17
    //   815: astore 28
    //   817: aload 22
    //   819: astore 15
    //   821: iconst_0
    //   822: istore_3
    //   823: aconst_null
    //   824: astore 14
    //   826: aload 19
    //   828: astore 17
    //   830: aload 16
    //   832: astore 18
    //   834: aload 28
    //   836: astore 16
    //   838: aload 29
    //   840: astore 19
    //   842: aload 30
    //   844: astore 22
    //   846: goto +10625 -> 11471
    //   849: astore 23
    //   851: aload 24
    //   853: astore 20
    //   855: aload 18
    //   857: astore 30
    //   859: aload 17
    //   861: astore 18
    //   863: iconst_0
    //   864: istore_3
    //   865: aload 19
    //   867: astore 17
    //   869: aload 14
    //   871: astore 24
    //   873: aload 15
    //   875: astore 14
    //   877: aload 20
    //   879: astore 15
    //   881: aload 29
    //   883: astore 20
    //   885: aload 28
    //   887: astore 21
    //   889: aload 30
    //   891: astore 19
    //   893: goto +7903 -> 8796
    //   896: new 282	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   903: astore 29
    //   905: aload 29
    //   907: ldc_w 322
    //   910: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: pop
    //   914: aload 29
    //   916: aload_0
    //   917: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   920: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: pop
    //   924: aload 29
    //   926: ldc_w 291
    //   929: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: pop
    //   933: aload 29
    //   935: aload_0
    //   936: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   939: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: pop
    //   943: ldc_w 293
    //   946: aload 29
    //   948: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: invokestatic 325	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   954: goto +2330 -> 3284
    //   957: aload_2
    //   958: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   961: iconst_2
    //   962: invokevirtual 134	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   965: new 282	java/lang/StringBuilder
    //   968: dup
    //   969: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   972: astore 29
    //   974: aload 29
    //   976: ldc_w 322
    //   979: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: pop
    //   983: aload 29
    //   985: aload_0
    //   986: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   989: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: pop
    //   993: aload 29
    //   995: ldc_w 291
    //   998: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: pop
    //   1002: aload 29
    //   1004: aload_0
    //   1005: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1008: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: pop
    //   1012: ldc_w 293
    //   1015: aload 29
    //   1017: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1020: invokestatic 325	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1023: aload_2
    //   1024: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1027: lload 9
    //   1029: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   1032: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   1035: aload_2
    //   1036: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1039: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   1042: aload_0
    //   1043: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   1046: lsub
    //   1047: putfield 338	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   1050: aload_2
    //   1051: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1054: aload_0
    //   1055: getfield 341	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   1058: putfield 344	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   1061: aload_0
    //   1062: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   1065: invokestatic 350	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   1068: invokevirtual 354	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   1071: astore 21
    //   1073: aload_0
    //   1074: aconst_null
    //   1075: aconst_null
    //   1076: aconst_null
    //   1077: invokevirtual 358	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   1080: astore 27
    //   1082: aload_2
    //   1083: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1086: aconst_null
    //   1087: putfield 361	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   1090: aload_0
    //   1091: lconst_0
    //   1092: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   1095: aload_0
    //   1096: iconst_0
    //   1097: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   1100: aload_0
    //   1101: lconst_0
    //   1102: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   1105: aload_0
    //   1106: iconst_0
    //   1107: putfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   1110: aload_1
    //   1111: invokeinterface 105 1 0
    //   1116: ifne +2107 -> 3223
    //   1119: aload_0
    //   1120: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   1123: invokestatic 119	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   1126: istore 7
    //   1128: aload_2
    //   1129: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1132: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1135: ifne +712 -> 1847
    //   1138: new 282	java/lang/StringBuilder
    //   1141: dup
    //   1142: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   1145: astore 29
    //   1147: aload 29
    //   1149: ldc_w 366
    //   1152: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: pop
    //   1156: aload 29
    //   1158: aload_0
    //   1159: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   1162: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: pop
    //   1166: aload 29
    //   1168: aload 16
    //   1170: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: pop
    //   1174: aload 29
    //   1176: aload_0
    //   1177: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   1180: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1183: pop
    //   1184: aload 29
    //   1186: aload 28
    //   1188: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: pop
    //   1192: aload_0
    //   1193: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   1196: istore 8
    //   1198: aload 29
    //   1200: aload 26
    //   1202: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: pop
    //   1206: aload 29
    //   1208: ldc_w 375
    //   1211: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: pop
    //   1215: aload 29
    //   1217: aload 21
    //   1219: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1222: pop
    //   1223: aload 29
    //   1225: ldc_w 380
    //   1228: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload 29
    //   1234: aconst_null
    //   1235: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: pop
    //   1239: aload 29
    //   1241: ldc_w 382
    //   1244: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: pop
    //   1248: aload 29
    //   1250: aconst_null
    //   1251: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: pop
    //   1255: aload 29
    //   1257: ldc_w 384
    //   1260: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: pop
    //   1264: aload 29
    //   1266: invokestatic 388	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1269: invokevirtual 391	java/lang/Thread:getId	()J
    //   1272: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1275: pop
    //   1276: aload 29
    //   1278: ldc_w 396
    //   1281: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: pop
    //   1285: aload 29
    //   1287: invokestatic 401	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1290: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: pop
    //   1294: aload 29
    //   1296: ldc_w 403
    //   1299: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: pop
    //   1303: aload 29
    //   1305: iload 7
    //   1307: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1310: pop
    //   1311: aload 29
    //   1313: ldc_w 405
    //   1316: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1319: pop
    //   1320: aload 29
    //   1322: invokestatic 411	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   1325: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1328: pop
    //   1329: aload 29
    //   1331: aload 18
    //   1333: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: pop
    //   1337: aload 29
    //   1339: aload_2
    //   1340: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1343: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1346: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: pop
    //   1350: aload 29
    //   1352: aload 33
    //   1354: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: pop
    //   1358: aload 29
    //   1360: aload_2
    //   1361: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1364: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1367: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1370: pop
    //   1371: aload 29
    //   1373: aload 17
    //   1375: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: aload 29
    //   1381: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   1384: aload_0
    //   1385: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   1388: lsub
    //   1389: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1392: pop
    //   1393: aload 29
    //   1395: aload 22
    //   1397: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: pop
    //   1401: aload 29
    //   1403: aload_2
    //   1404: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1407: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   1410: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1413: pop
    //   1414: aload 29
    //   1416: aload 25
    //   1418: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: pop
    //   1422: aload 29
    //   1424: aload_2
    //   1425: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1428: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1431: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1434: pop
    //   1435: aload 29
    //   1437: ldc_w 422
    //   1440: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1443: pop
    //   1444: aload 29
    //   1446: aload_2
    //   1447: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1450: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   1453: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1456: pop
    //   1457: aload 29
    //   1459: ldc_w 427
    //   1462: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1465: pop
    //   1466: aload 29
    //   1468: aload_0
    //   1469: invokevirtual 430	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   1472: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1475: pop
    //   1476: aload 29
    //   1478: aload 19
    //   1480: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: pop
    //   1484: aload 29
    //   1486: aload_0
    //   1487: invokevirtual 433	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   1490: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1493: pop
    //   1494: aload 29
    //   1496: ldc_w 435
    //   1499: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: pop
    //   1503: aload 29
    //   1505: aload_2
    //   1506: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1509: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   1512: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1515: pop
    //   1516: aload 29
    //   1518: ldc_w 440
    //   1521: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: pop
    //   1525: aload 29
    //   1527: iconst_0
    //   1528: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1531: pop
    //   1532: aload 29
    //   1534: aload 13
    //   1536: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: pop
    //   1540: aload 29
    //   1542: aload 27
    //   1544: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: pop
    //   1548: aload 29
    //   1550: aload 24
    //   1552: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: pop
    //   1556: aload 29
    //   1558: aconst_null
    //   1559: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: pop
    //   1563: aload 29
    //   1565: ldc_w 442
    //   1568: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1571: pop
    //   1572: aload_0
    //   1573: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   1576: astore 14
    //   1578: aload 14
    //   1580: ifnull +16 -> 1596
    //   1583: aload 14
    //   1585: iconst_0
    //   1586: bipush 30
    //   1588: invokevirtual 448	java/lang/String:substring	(II)Ljava/lang/String;
    //   1591: astore 14
    //   1593: goto +3 -> 1596
    //   1596: aload 29
    //   1598: aload 14
    //   1600: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1603: pop
    //   1604: aload 29
    //   1606: ldc_w 450
    //   1609: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: pop
    //   1613: aload 29
    //   1615: aload_2
    //   1616: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1619: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1622: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: pop
    //   1626: aload 29
    //   1628: ldc_w 455
    //   1631: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1634: pop
    //   1635: aload 29
    //   1637: lconst_0
    //   1638: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1641: pop
    //   1642: aload 29
    //   1644: ldc_w 457
    //   1647: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1650: pop
    //   1651: aload 29
    //   1653: aload_0
    //   1654: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   1657: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1660: pop
    //   1661: aload 29
    //   1663: aload 19
    //   1665: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1668: pop
    //   1669: aload 29
    //   1671: aload_0
    //   1672: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   1675: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1678: pop
    //   1679: aload 29
    //   1681: ldc_w 459
    //   1684: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: pop
    //   1688: aload 29
    //   1690: aload_0
    //   1691: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   1694: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1697: pop
    //   1698: aload 29
    //   1700: aload 19
    //   1702: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: pop
    //   1706: aload 29
    //   1708: aload_0
    //   1709: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   1712: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1715: pop
    //   1716: aload 29
    //   1718: ldc_w 461
    //   1721: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1724: pop
    //   1725: aload 29
    //   1727: aload_0
    //   1728: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   1731: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1734: pop
    //   1735: aload 29
    //   1737: ldc_w 463
    //   1740: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1743: pop
    //   1744: aload 29
    //   1746: aload_0
    //   1747: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   1750: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1753: pop
    //   1754: aload 29
    //   1756: ldc_w 468
    //   1759: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1762: pop
    //   1763: aload 29
    //   1765: aload_0
    //   1766: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   1769: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1772: pop
    //   1773: aload 29
    //   1775: ldc_w 473
    //   1778: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: pop
    //   1782: aload_0
    //   1783: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1786: ifnull +17 -> 1803
    //   1789: aload_0
    //   1790: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1793: invokeinterface 202 1 0
    //   1798: astore 14
    //   1800: goto +6 -> 1806
    //   1803: aconst_null
    //   1804: astore 14
    //   1806: aload 29
    //   1808: aload 14
    //   1810: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1813: pop
    //   1814: aload 29
    //   1816: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1819: astore 16
    //   1821: aload 15
    //   1823: astore 14
    //   1825: aload 14
    //   1827: aload 16
    //   1829: putfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1832: ldc_w 478
    //   1835: aload 14
    //   1837: getfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1840: aconst_null
    //   1841: invokestatic 481	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1844: goto +671 -> 2515
    //   1847: new 282	java/lang/StringBuilder
    //   1850: dup
    //   1851: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   1854: astore 29
    //   1856: aload 29
    //   1858: ldc_w 483
    //   1861: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1864: pop
    //   1865: aload 29
    //   1867: aload_0
    //   1868: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   1871: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: pop
    //   1875: aload 29
    //   1877: aload 16
    //   1879: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1882: pop
    //   1883: aload 29
    //   1885: aload_0
    //   1886: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   1889: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1892: pop
    //   1893: aload 29
    //   1895: aload 28
    //   1897: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1900: pop
    //   1901: aload_0
    //   1902: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   1905: istore 8
    //   1907: aload 29
    //   1909: aload 26
    //   1911: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1914: pop
    //   1915: aload 29
    //   1917: ldc_w 375
    //   1920: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: pop
    //   1924: aload 29
    //   1926: aload 21
    //   1928: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1931: pop
    //   1932: aload 29
    //   1934: ldc_w 380
    //   1937: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1940: pop
    //   1941: aload 29
    //   1943: aconst_null
    //   1944: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1947: pop
    //   1948: aload 29
    //   1950: ldc_w 382
    //   1953: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1956: pop
    //   1957: aload 29
    //   1959: aconst_null
    //   1960: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1963: pop
    //   1964: aload 29
    //   1966: ldc_w 384
    //   1969: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1972: pop
    //   1973: aload 29
    //   1975: invokestatic 388	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1978: invokevirtual 391	java/lang/Thread:getId	()J
    //   1981: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1984: pop
    //   1985: aload 29
    //   1987: ldc_w 396
    //   1990: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1993: pop
    //   1994: aload 29
    //   1996: invokestatic 401	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1999: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2002: pop
    //   2003: aload 29
    //   2005: ldc_w 405
    //   2008: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: pop
    //   2012: aload 29
    //   2014: invokestatic 411	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2017: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2020: pop
    //   2021: aload 29
    //   2023: aload 33
    //   2025: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2028: pop
    //   2029: aload 29
    //   2031: aload_2
    //   2032: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2035: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2038: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2041: pop
    //   2042: aload 29
    //   2044: aload 17
    //   2046: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2049: pop
    //   2050: aload 29
    //   2052: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   2055: aload_0
    //   2056: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   2059: lsub
    //   2060: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2063: pop
    //   2064: aload 29
    //   2066: aload 22
    //   2068: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2071: pop
    //   2072: aload 29
    //   2074: aload_2
    //   2075: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2078: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2081: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2084: pop
    //   2085: aload 29
    //   2087: aload 25
    //   2089: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2092: pop
    //   2093: aload 29
    //   2095: aload_2
    //   2096: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2099: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2102: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2105: pop
    //   2106: aload 29
    //   2108: ldc_w 422
    //   2111: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2114: pop
    //   2115: aload 29
    //   2117: aload_2
    //   2118: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2121: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   2124: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2127: pop
    //   2128: aload 29
    //   2130: ldc_w 427
    //   2133: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2136: pop
    //   2137: aload 29
    //   2139: aload_0
    //   2140: invokevirtual 430	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   2143: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2146: pop
    //   2147: aload 29
    //   2149: aload 19
    //   2151: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2154: pop
    //   2155: aload 29
    //   2157: aload_0
    //   2158: invokevirtual 433	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   2161: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2164: pop
    //   2165: aload 29
    //   2167: ldc_w 485
    //   2170: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2173: pop
    //   2174: aload 29
    //   2176: iconst_0
    //   2177: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2180: pop
    //   2181: aload 29
    //   2183: aload 13
    //   2185: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2188: pop
    //   2189: aload 29
    //   2191: aload 27
    //   2193: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2196: pop
    //   2197: aload 29
    //   2199: aload 18
    //   2201: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2204: pop
    //   2205: aload 29
    //   2207: aload_2
    //   2208: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2211: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2214: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: pop
    //   2218: aload 29
    //   2220: aload 24
    //   2222: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2225: pop
    //   2226: aload 29
    //   2228: aconst_null
    //   2229: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2232: pop
    //   2233: aload 29
    //   2235: ldc_w 442
    //   2238: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: pop
    //   2242: aload_0
    //   2243: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   2246: astore 16
    //   2248: aload 16
    //   2250: astore 14
    //   2252: aload 16
    //   2254: ifnull +13 -> 2267
    //   2257: aload 16
    //   2259: iconst_0
    //   2260: bipush 30
    //   2262: invokevirtual 448	java/lang/String:substring	(II)Ljava/lang/String;
    //   2265: astore 14
    //   2267: aload 29
    //   2269: aload 14
    //   2271: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2274: pop
    //   2275: aload 29
    //   2277: ldc_w 450
    //   2280: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2283: pop
    //   2284: aload 29
    //   2286: aload_2
    //   2287: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2290: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2293: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2296: pop
    //   2297: aload 29
    //   2299: ldc_w 455
    //   2302: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2305: pop
    //   2306: aload 29
    //   2308: lconst_0
    //   2309: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2312: pop
    //   2313: aload 29
    //   2315: ldc_w 457
    //   2318: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2321: pop
    //   2322: aload 29
    //   2324: aload_0
    //   2325: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   2328: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2331: pop
    //   2332: aload 29
    //   2334: aload 19
    //   2336: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2339: pop
    //   2340: aload 29
    //   2342: aload_0
    //   2343: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   2346: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2349: pop
    //   2350: aload 29
    //   2352: ldc_w 459
    //   2355: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2358: pop
    //   2359: aload 29
    //   2361: aload_0
    //   2362: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   2365: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2368: pop
    //   2369: aload 29
    //   2371: aload 19
    //   2373: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2376: pop
    //   2377: aload 29
    //   2379: aload_0
    //   2380: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   2383: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2386: pop
    //   2387: aload 29
    //   2389: ldc_w 461
    //   2392: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2395: pop
    //   2396: aload 29
    //   2398: aload_0
    //   2399: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   2402: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2405: pop
    //   2406: aload 29
    //   2408: ldc_w 463
    //   2411: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2414: pop
    //   2415: aload 29
    //   2417: aload_0
    //   2418: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   2421: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2424: pop
    //   2425: aload 29
    //   2427: ldc_w 468
    //   2430: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2433: pop
    //   2434: aload 29
    //   2436: aload_0
    //   2437: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   2440: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2443: pop
    //   2444: aload 29
    //   2446: ldc_w 473
    //   2449: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2452: pop
    //   2453: aload_0
    //   2454: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2457: ifnull +17 -> 2474
    //   2460: aload_0
    //   2461: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2464: invokeinterface 202 1 0
    //   2469: astore 14
    //   2471: goto +6 -> 2477
    //   2474: aconst_null
    //   2475: astore 14
    //   2477: aload 29
    //   2479: aload 14
    //   2481: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2484: pop
    //   2485: aload 29
    //   2487: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2490: astore 16
    //   2492: aload 15
    //   2494: astore 14
    //   2496: aload 14
    //   2498: aload 16
    //   2500: putfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   2503: ldc_w 478
    //   2506: aload 14
    //   2508: getfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   2511: aconst_null
    //   2512: invokestatic 488	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2515: iload 7
    //   2517: ifne +8 -> 2525
    //   2520: aload_0
    //   2521: iconst_0
    //   2522: putfield 491	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   2525: aload_2
    //   2526: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2529: astore 16
    //   2531: new 282	java/lang/StringBuilder
    //   2534: dup
    //   2535: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   2538: astore 19
    //   2540: aload 19
    //   2542: aload_0
    //   2543: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   2546: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2549: pop
    //   2550: aload 19
    //   2552: ldc_w 493
    //   2555: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2558: pop
    //   2559: aload 19
    //   2561: aconst_null
    //   2562: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2565: pop
    //   2566: aload 19
    //   2568: ldc_w 495
    //   2571: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2574: pop
    //   2575: aload 19
    //   2577: aload_2
    //   2578: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2581: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2584: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2587: pop
    //   2588: aload 19
    //   2590: ldc_w 497
    //   2593: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2596: pop
    //   2597: aload_0
    //   2598: getfield 501	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2601: ifnull +14 -> 2615
    //   2604: aload_0
    //   2605: getfield 501	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2608: getfield 504	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2611: istore_3
    //   2612: goto +5 -> 2617
    //   2615: iconst_0
    //   2616: istore_3
    //   2617: aload 19
    //   2619: iload_3
    //   2620: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2623: pop
    //   2624: aload 19
    //   2626: ldc_w 440
    //   2629: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2632: pop
    //   2633: aload 19
    //   2635: iconst_0
    //   2636: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2639: pop
    //   2640: aload 19
    //   2642: aload 18
    //   2644: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2647: pop
    //   2648: aload 19
    //   2650: aload_2
    //   2651: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2654: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2657: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2660: pop
    //   2661: aload 19
    //   2663: aload 20
    //   2665: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2668: pop
    //   2669: aload 19
    //   2671: aload_2
    //   2672: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2675: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2678: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2681: pop
    //   2682: aload 19
    //   2684: aload 25
    //   2686: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2689: pop
    //   2690: aload 19
    //   2692: aload_2
    //   2693: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2696: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2699: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2702: pop
    //   2703: aload 19
    //   2705: aload 33
    //   2707: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2710: pop
    //   2711: aload 19
    //   2713: aload_2
    //   2714: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2717: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2720: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2723: pop
    //   2724: aload 19
    //   2726: aload 17
    //   2728: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2731: pop
    //   2732: aload 19
    //   2734: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   2737: aload_0
    //   2738: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   2741: lsub
    //   2742: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2745: pop
    //   2746: aconst_null
    //   2747: invokestatic 508	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2750: ifne +37 -> 2787
    //   2753: new 282	java/lang/StringBuilder
    //   2756: dup
    //   2757: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   2760: astore 14
    //   2762: aload 14
    //   2764: aload 23
    //   2766: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2769: pop
    //   2770: aload 14
    //   2772: aconst_null
    //   2773: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2776: pop
    //   2777: aload 14
    //   2779: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2782: astore 14
    //   2784: goto +8 -> 2792
    //   2787: ldc_w 510
    //   2790: astore 14
    //   2792: aload 19
    //   2794: aload 14
    //   2796: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2799: pop
    //   2800: aload 19
    //   2802: aload 13
    //   2804: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2807: pop
    //   2808: aload 19
    //   2810: aload 27
    //   2812: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2815: pop
    //   2816: aload 16
    //   2818: aload 19
    //   2820: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2823: putfield 513	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   2826: iload 7
    //   2828: ifeq +72 -> 2900
    //   2831: aload_0
    //   2832: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   2835: invokestatic 518	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   2838: astore 13
    //   2840: aload_0
    //   2841: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   2844: astore 14
    //   2846: aload_0
    //   2847: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   2850: ifeq +31 -> 2881
    //   2853: aload_0
    //   2854: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   2857: astore 16
    //   2859: aload 16
    //   2861: ifnull +20 -> 2881
    //   2864: aload 16
    //   2866: ldc_w 520
    //   2869: invokevirtual 523	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2872: ifeq +9 -> 2881
    //   2875: iconst_1
    //   2876: istore 7
    //   2878: goto +6 -> 2884
    //   2881: iconst_0
    //   2882: istore 7
    //   2884: aload 13
    //   2886: aload 14
    //   2888: iload 7
    //   2890: aload_2
    //   2891: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2894: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2897: invokevirtual 527	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   2900: aload 15
    //   2902: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   2905: putfield 530	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   2908: aload 15
    //   2910: aload_0
    //   2911: invokevirtual 531	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   2914: putfield 534	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   2917: aload 15
    //   2919: aconst_null
    //   2920: putfield 538	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   2923: aload 15
    //   2925: iconst_0
    //   2926: putfield 541	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   2929: aload 15
    //   2931: aconst_null
    //   2932: putfield 545	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   2935: aload 21
    //   2937: ifnonnull +9 -> 2946
    //   2940: aconst_null
    //   2941: astore 13
    //   2943: goto +10 -> 2953
    //   2946: aload 21
    //   2948: invokevirtual 548	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   2951: astore 13
    //   2953: aload 15
    //   2955: aload 13
    //   2957: putfield 551	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   2960: aload 15
    //   2962: aconst_null
    //   2963: putfield 554	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   2966: aload 15
    //   2968: aload_2
    //   2969: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2972: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2975: putfield 555	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   2978: aload 15
    //   2980: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   2983: aload_0
    //   2984: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   2987: lsub
    //   2988: putfield 558	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   2991: aload 15
    //   2993: aload_2
    //   2994: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2997: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3000: putfield 561	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   3003: aload 15
    //   3005: aload 15
    //   3007: getfield 558	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   3010: aload_2
    //   3011: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3014: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3017: lsub
    //   3018: putfield 564	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   3021: aload 15
    //   3023: lconst_0
    //   3024: putfield 567	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   3027: aload 15
    //   3029: aload_0
    //   3030: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   3033: putfield 570	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   3036: aload 15
    //   3038: aload_0
    //   3039: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   3042: putfield 573	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   3045: aload 15
    //   3047: aload_0
    //   3048: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   3051: putfield 576	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   3054: aload 15
    //   3056: lconst_0
    //   3057: putfield 579	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   3060: aload 15
    //   3062: aload_0
    //   3063: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   3066: putfield 582	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   3069: aload 15
    //   3071: aload_2
    //   3072: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3075: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3078: putfield 585	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   3081: aload 15
    //   3083: aload_0
    //   3084: invokevirtual 165	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   3087: invokestatic 588	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   3090: putfield 590	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   3093: aload 15
    //   3095: aload_0
    //   3096: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   3099: putfield 593	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   3102: aload_0
    //   3103: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   3106: astore 13
    //   3108: aload 13
    //   3110: ifnull +20 -> 3130
    //   3113: aload 13
    //   3115: ldc_w 520
    //   3118: invokevirtual 523	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3121: ifeq +9 -> 3130
    //   3124: iconst_1
    //   3125: istore 7
    //   3127: goto +6 -> 3133
    //   3130: iconst_0
    //   3131: istore 7
    //   3133: aload 15
    //   3135: iload 7
    //   3137: putfield 596	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   3140: aload 15
    //   3142: aload_2
    //   3143: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3146: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3149: putfield 598	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   3152: aload 15
    //   3154: getstatic 604	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   3157: invokevirtual 607	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   3160: putfield 610	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   3163: aload 15
    //   3165: aload_0
    //   3166: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   3169: invokevirtual 613	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   3172: putfield 616	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   3175: aload 15
    //   3177: aload_0
    //   3178: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   3181: invokevirtual 620	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   3184: putfield 624	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   3187: aload 15
    //   3189: aload_0
    //   3190: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   3193: invokevirtual 627	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   3196: putfield 630	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   3199: aload_2
    //   3200: aload 15
    //   3202: invokevirtual 634	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   3205: aload_2
    //   3206: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3209: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3212: ifeq +11 -> 3223
    //   3215: aload_0
    //   3216: aload_1
    //   3217: aload_2
    //   3218: aload 15
    //   3220: invokevirtual 109	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   3223: aload_0
    //   3224: aconst_null
    //   3225: putfield 180	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   3228: return
    //   3229: astore 22
    //   3231: goto +5352 -> 8583
    //   3234: astore 20
    //   3236: aload 18
    //   3238: astore 29
    //   3240: iconst_0
    //   3241: istore_3
    //   3242: aload 17
    //   3244: astore 18
    //   3246: aload 19
    //   3248: astore 17
    //   3250: aconst_null
    //   3251: astore 19
    //   3253: aload 14
    //   3255: astore 24
    //   3257: aload 15
    //   3259: astore 14
    //   3261: aload 23
    //   3263: astore 15
    //   3265: aload 20
    //   3267: astore 23
    //   3269: aload 19
    //   3271: astore 20
    //   3273: aload 28
    //   3275: astore 21
    //   3277: aload 29
    //   3279: astore 19
    //   3281: goto +5515 -> 8796
    //   3284: aconst_null
    //   3285: astore 14
    //   3287: aload 26
    //   3289: astore 24
    //   3291: aload 25
    //   3293: astore 34
    //   3295: aload 15
    //   3297: astore 22
    //   3299: aload 23
    //   3301: astore 15
    //   3303: aload 14
    //   3305: ifnull +2704 -> 6009
    //   3308: aload 22
    //   3310: astore 23
    //   3312: aload 14
    //   3314: invokevirtual 639	okhttp3/Response:code	()I
    //   3317: istore_3
    //   3318: aload_2
    //   3319: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3322: iload_3
    //   3323: putfield 640	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   3326: sipush 200
    //   3329: iload_3
    //   3330: if_icmpne +2398 -> 5728
    //   3333: aload_2
    //   3334: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3337: invokevirtual 643	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   3340: aload_2
    //   3341: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3344: lload 9
    //   3346: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   3349: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   3352: aload_2
    //   3353: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3356: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   3359: aload_0
    //   3360: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   3363: lsub
    //   3364: putfield 338	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   3367: aload_2
    //   3368: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3371: aload_0
    //   3372: getfield 341	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   3375: putfield 344	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   3378: aload_0
    //   3379: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   3382: invokestatic 350	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   3385: invokevirtual 354	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3388: astore 26
    //   3390: aload_0
    //   3391: aconst_null
    //   3392: aconst_null
    //   3393: aload 14
    //   3395: invokevirtual 358	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   3398: astore 28
    //   3400: aload 14
    //   3402: ifnull +27 -> 3429
    //   3405: aload 14
    //   3407: invokevirtual 646	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   3410: ifnull +19 -> 3429
    //   3413: aload 14
    //   3415: invokevirtual 646	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   3418: ldc_w 648
    //   3421: invokevirtual 651	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   3424: astore 25
    //   3426: goto +6 -> 3432
    //   3429: aconst_null
    //   3430: astore 25
    //   3432: aload_2
    //   3433: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3436: aload 25
    //   3438: putfield 361	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   3441: aload_0
    //   3442: lconst_0
    //   3443: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   3446: aload_0
    //   3447: iconst_0
    //   3448: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   3451: aload_0
    //   3452: lconst_0
    //   3453: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   3456: aload_0
    //   3457: iconst_0
    //   3458: putfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   3461: aload_1
    //   3462: invokeinterface 105 1 0
    //   3467: ifne +2190 -> 5657
    //   3470: aload_0
    //   3471: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   3474: invokestatic 119	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3477: istore 7
    //   3479: aload_2
    //   3480: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3483: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3486: ifne +732 -> 4218
    //   3489: new 282	java/lang/StringBuilder
    //   3492: dup
    //   3493: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   3496: astore 27
    //   3498: aload 27
    //   3500: ldc_w 366
    //   3503: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3506: pop
    //   3507: aload 27
    //   3509: aload_0
    //   3510: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   3513: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3516: pop
    //   3517: aload 27
    //   3519: aload 16
    //   3521: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3524: pop
    //   3525: aload 27
    //   3527: aload_0
    //   3528: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   3531: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3534: pop
    //   3535: aload 27
    //   3537: aload 21
    //   3539: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3542: pop
    //   3543: aload_0
    //   3544: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   3547: ifeq +29 -> 3576
    //   3550: aload 14
    //   3552: ifnull +24 -> 3576
    //   3555: aload 14
    //   3557: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3560: ifnull +16 -> 3576
    //   3563: aload 14
    //   3565: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3568: invokevirtual 658	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3571: astore 24
    //   3573: goto +3 -> 3576
    //   3576: aload 27
    //   3578: aload 24
    //   3580: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3583: pop
    //   3584: aload 27
    //   3586: ldc_w 375
    //   3589: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3592: pop
    //   3593: aload 27
    //   3595: aload 26
    //   3597: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3600: pop
    //   3601: aload 27
    //   3603: ldc_w 380
    //   3606: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3609: pop
    //   3610: aload 27
    //   3612: aconst_null
    //   3613: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3616: pop
    //   3617: aload 27
    //   3619: ldc_w 382
    //   3622: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3625: pop
    //   3626: aload 27
    //   3628: aconst_null
    //   3629: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3632: pop
    //   3633: aload 27
    //   3635: ldc_w 384
    //   3638: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3641: pop
    //   3642: aload 27
    //   3644: invokestatic 388	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3647: invokevirtual 391	java/lang/Thread:getId	()J
    //   3650: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3653: pop
    //   3654: aload 27
    //   3656: ldc_w 396
    //   3659: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3662: pop
    //   3663: aload 27
    //   3665: invokestatic 401	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3668: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3671: pop
    //   3672: aload 27
    //   3674: ldc_w 403
    //   3677: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3680: pop
    //   3681: aload 27
    //   3683: iload 7
    //   3685: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3688: pop
    //   3689: aload 27
    //   3691: ldc_w 405
    //   3694: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3697: pop
    //   3698: aload 27
    //   3700: invokestatic 411	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3703: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3706: pop
    //   3707: aload 27
    //   3709: aload 18
    //   3711: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3714: pop
    //   3715: aload 27
    //   3717: aload_2
    //   3718: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3721: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3724: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3727: pop
    //   3728: aload 27
    //   3730: aload 33
    //   3732: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3735: pop
    //   3736: aload 27
    //   3738: aload_2
    //   3739: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3742: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3745: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3748: pop
    //   3749: aload 27
    //   3751: aload 17
    //   3753: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3756: pop
    //   3757: aload 27
    //   3759: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   3762: aload_0
    //   3763: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   3766: lsub
    //   3767: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3770: pop
    //   3771: aload 27
    //   3773: aload 20
    //   3775: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3778: pop
    //   3779: aload 27
    //   3781: aload_2
    //   3782: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3785: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3788: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3791: pop
    //   3792: aload 27
    //   3794: aload 34
    //   3796: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3799: pop
    //   3800: aload 27
    //   3802: aload_2
    //   3803: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3806: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3809: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3812: pop
    //   3813: aload 27
    //   3815: ldc_w 422
    //   3818: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3821: pop
    //   3822: aload 27
    //   3824: aload_2
    //   3825: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3828: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3831: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3834: pop
    //   3835: aload 27
    //   3837: ldc_w 427
    //   3840: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3843: pop
    //   3844: aload 27
    //   3846: aload_0
    //   3847: invokevirtual 430	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   3850: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3853: pop
    //   3854: aload 27
    //   3856: aload 19
    //   3858: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3861: pop
    //   3862: aload 27
    //   3864: aload_0
    //   3865: invokevirtual 433	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   3868: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3871: pop
    //   3872: aload 27
    //   3874: ldc_w 435
    //   3877: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3880: pop
    //   3881: aload 27
    //   3883: aload_2
    //   3884: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3887: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3890: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3893: pop
    //   3894: aload 27
    //   3896: ldc_w 440
    //   3899: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3902: pop
    //   3903: aload 27
    //   3905: iload_3
    //   3906: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3909: pop
    //   3910: aload 27
    //   3912: aload 13
    //   3914: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3917: pop
    //   3918: aload 27
    //   3920: aload 28
    //   3922: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3925: pop
    //   3926: aload 27
    //   3928: aload 15
    //   3930: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3933: pop
    //   3934: aload 27
    //   3936: aload 25
    //   3938: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3941: pop
    //   3942: aload 27
    //   3944: ldc_w 442
    //   3947: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3950: pop
    //   3951: aload_0
    //   3952: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   3955: astore 16
    //   3957: aload 16
    //   3959: ifnull +16 -> 3975
    //   3962: aload 16
    //   3964: iconst_0
    //   3965: bipush 30
    //   3967: invokevirtual 448	java/lang/String:substring	(II)Ljava/lang/String;
    //   3970: astore 16
    //   3972: goto +3 -> 3975
    //   3975: aload 27
    //   3977: aload 16
    //   3979: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3982: pop
    //   3983: aload 27
    //   3985: ldc_w 450
    //   3988: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3991: pop
    //   3992: aload 27
    //   3994: aload_2
    //   3995: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3998: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4001: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4004: pop
    //   4005: aload 27
    //   4007: ldc_w 455
    //   4010: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4013: pop
    //   4014: aload 27
    //   4016: lconst_0
    //   4017: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4020: pop
    //   4021: aload 27
    //   4023: ldc_w 457
    //   4026: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4029: pop
    //   4030: aload 27
    //   4032: aload_0
    //   4033: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   4036: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4039: pop
    //   4040: aload 27
    //   4042: aload 19
    //   4044: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4047: pop
    //   4048: aload 27
    //   4050: aload_0
    //   4051: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   4054: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4057: pop
    //   4058: aload 27
    //   4060: ldc_w 459
    //   4063: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4066: pop
    //   4067: aload 27
    //   4069: aload_0
    //   4070: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   4073: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4076: pop
    //   4077: aload 27
    //   4079: aload 19
    //   4081: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4084: pop
    //   4085: aload 27
    //   4087: aload_0
    //   4088: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   4091: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4094: pop
    //   4095: aload 27
    //   4097: ldc_w 461
    //   4100: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4103: pop
    //   4104: aload 27
    //   4106: aload_0
    //   4107: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   4110: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4113: pop
    //   4114: aload 27
    //   4116: ldc_w 463
    //   4119: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4122: pop
    //   4123: aload 27
    //   4125: aload_0
    //   4126: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   4129: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4132: pop
    //   4133: aload 27
    //   4135: ldc_w 468
    //   4138: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4141: pop
    //   4142: aload 27
    //   4144: aload_0
    //   4145: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   4148: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4151: pop
    //   4152: aload 27
    //   4154: ldc_w 473
    //   4157: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4160: pop
    //   4161: aload_0
    //   4162: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4165: ifnull +17 -> 4182
    //   4168: aload_0
    //   4169: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4172: invokeinterface 202 1 0
    //   4177: astore 16
    //   4179: goto +6 -> 4185
    //   4182: aconst_null
    //   4183: astore 16
    //   4185: aload 27
    //   4187: aload 16
    //   4189: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4192: pop
    //   4193: aload 23
    //   4195: aload 27
    //   4197: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4200: putfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4203: ldc_w 478
    //   4206: aload 23
    //   4208: getfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4211: aconst_null
    //   4212: invokestatic 481	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4215: goto +698 -> 4913
    //   4218: aload 14
    //   4220: astore 27
    //   4222: new 282	java/lang/StringBuilder
    //   4225: dup
    //   4226: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   4229: astore 29
    //   4231: aload 29
    //   4233: ldc_w 483
    //   4236: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4239: pop
    //   4240: aload 29
    //   4242: aload_0
    //   4243: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   4246: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4249: pop
    //   4250: aload 29
    //   4252: aload 16
    //   4254: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4257: pop
    //   4258: aload 29
    //   4260: aload_0
    //   4261: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   4264: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4267: pop
    //   4268: aload 29
    //   4270: aload 21
    //   4272: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4275: pop
    //   4276: aload_0
    //   4277: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   4280: ifeq +29 -> 4309
    //   4283: aload 27
    //   4285: ifnull +24 -> 4309
    //   4288: aload 27
    //   4290: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4293: ifnull +16 -> 4309
    //   4296: aload 27
    //   4298: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4301: invokevirtual 658	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   4304: astore 24
    //   4306: goto +3 -> 4309
    //   4309: aload 29
    //   4311: aload 24
    //   4313: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4316: pop
    //   4317: aload 29
    //   4319: ldc_w 375
    //   4322: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4325: pop
    //   4326: aload 29
    //   4328: aload 26
    //   4330: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4333: pop
    //   4334: aload 29
    //   4336: ldc_w 380
    //   4339: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4342: pop
    //   4343: aload 29
    //   4345: aconst_null
    //   4346: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4349: pop
    //   4350: aload 29
    //   4352: ldc_w 382
    //   4355: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4358: pop
    //   4359: aload 29
    //   4361: aconst_null
    //   4362: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4365: pop
    //   4366: aload 29
    //   4368: ldc_w 384
    //   4371: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4374: pop
    //   4375: aload 29
    //   4377: invokestatic 388	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4380: invokevirtual 391	java/lang/Thread:getId	()J
    //   4383: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4386: pop
    //   4387: aload 29
    //   4389: ldc_w 396
    //   4392: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4395: pop
    //   4396: aload 29
    //   4398: invokestatic 401	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4401: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4404: pop
    //   4405: aload 29
    //   4407: ldc_w 405
    //   4410: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4413: pop
    //   4414: aload 29
    //   4416: invokestatic 411	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   4419: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4422: pop
    //   4423: aload 29
    //   4425: aload 33
    //   4427: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4430: pop
    //   4431: aload 29
    //   4433: aload_2
    //   4434: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4437: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4440: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4443: pop
    //   4444: aload 29
    //   4446: aload 17
    //   4448: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4451: pop
    //   4452: aload 29
    //   4454: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   4457: aload_0
    //   4458: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   4461: lsub
    //   4462: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4465: pop
    //   4466: aload 29
    //   4468: aload 20
    //   4470: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4473: pop
    //   4474: aload 29
    //   4476: aload_2
    //   4477: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4480: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4483: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4486: pop
    //   4487: aload 29
    //   4489: aload 34
    //   4491: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4494: pop
    //   4495: aload 29
    //   4497: aload_2
    //   4498: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4501: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4504: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4507: pop
    //   4508: aload 29
    //   4510: ldc_w 422
    //   4513: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4516: pop
    //   4517: aload 29
    //   4519: aload_2
    //   4520: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4523: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4526: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4529: pop
    //   4530: aload 29
    //   4532: ldc_w 427
    //   4535: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4538: pop
    //   4539: aload 29
    //   4541: aload_0
    //   4542: invokevirtual 430	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   4545: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4548: pop
    //   4549: aload 29
    //   4551: aload 19
    //   4553: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4556: pop
    //   4557: aload 29
    //   4559: aload_0
    //   4560: invokevirtual 433	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   4563: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4566: pop
    //   4567: aload 29
    //   4569: ldc_w 485
    //   4572: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4575: pop
    //   4576: aload 29
    //   4578: iload_3
    //   4579: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4582: pop
    //   4583: aload 29
    //   4585: aload 13
    //   4587: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4590: pop
    //   4591: aload 29
    //   4593: aload 28
    //   4595: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4598: pop
    //   4599: aload 29
    //   4601: aload 18
    //   4603: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4606: pop
    //   4607: aload 29
    //   4609: aload_2
    //   4610: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4613: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4616: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4619: pop
    //   4620: aload 29
    //   4622: aload 15
    //   4624: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4627: pop
    //   4628: aload 29
    //   4630: aload 25
    //   4632: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4635: pop
    //   4636: aload 29
    //   4638: ldc_w 442
    //   4641: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4644: pop
    //   4645: aload_0
    //   4646: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   4649: astore 16
    //   4651: aload 16
    //   4653: ifnull +16 -> 4669
    //   4656: aload 16
    //   4658: iconst_0
    //   4659: bipush 30
    //   4661: invokevirtual 448	java/lang/String:substring	(II)Ljava/lang/String;
    //   4664: astore 16
    //   4666: goto +3 -> 4669
    //   4669: aload 29
    //   4671: aload 16
    //   4673: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4676: pop
    //   4677: aload 29
    //   4679: ldc_w 450
    //   4682: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4685: pop
    //   4686: aload 29
    //   4688: aload_2
    //   4689: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4692: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4695: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4698: pop
    //   4699: aload 29
    //   4701: ldc_w 455
    //   4704: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4707: pop
    //   4708: aload 29
    //   4710: lconst_0
    //   4711: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4714: pop
    //   4715: aload 29
    //   4717: ldc_w 457
    //   4720: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4723: pop
    //   4724: aload 29
    //   4726: aload_0
    //   4727: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   4730: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4733: pop
    //   4734: aload 29
    //   4736: aload 19
    //   4738: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4741: pop
    //   4742: aload 29
    //   4744: aload_0
    //   4745: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   4748: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4751: pop
    //   4752: aload 29
    //   4754: ldc_w 459
    //   4757: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4760: pop
    //   4761: aload 29
    //   4763: aload_0
    //   4764: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   4767: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4770: pop
    //   4771: aload 29
    //   4773: aload 19
    //   4775: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4778: pop
    //   4779: aload 29
    //   4781: aload_0
    //   4782: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   4785: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4788: pop
    //   4789: aload 29
    //   4791: ldc_w 461
    //   4794: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4797: pop
    //   4798: aload 29
    //   4800: aload_0
    //   4801: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   4804: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4807: pop
    //   4808: aload 29
    //   4810: ldc_w 463
    //   4813: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4816: pop
    //   4817: aload 29
    //   4819: aload_0
    //   4820: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   4823: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4826: pop
    //   4827: aload 29
    //   4829: ldc_w 468
    //   4832: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4835: pop
    //   4836: aload 29
    //   4838: aload_0
    //   4839: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   4842: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4845: pop
    //   4846: aload 29
    //   4848: ldc_w 473
    //   4851: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4854: pop
    //   4855: aload_0
    //   4856: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4859: ifnull +17 -> 4876
    //   4862: aload_0
    //   4863: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4866: invokeinterface 202 1 0
    //   4871: astore 16
    //   4873: goto +6 -> 4879
    //   4876: aconst_null
    //   4877: astore 16
    //   4879: aload 29
    //   4881: aload 16
    //   4883: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4886: pop
    //   4887: aload 29
    //   4889: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4892: astore 16
    //   4894: aload 23
    //   4896: aload 16
    //   4898: putfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4901: ldc_w 478
    //   4904: aload 23
    //   4906: getfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4909: aconst_null
    //   4910: invokestatic 488	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4913: aload 14
    //   4915: astore 16
    //   4917: iload 7
    //   4919: ifne +8 -> 4927
    //   4922: aload_0
    //   4923: iconst_0
    //   4924: putfield 491	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   4927: aload_2
    //   4928: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4931: astore 19
    //   4933: new 282	java/lang/StringBuilder
    //   4936: dup
    //   4937: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   4940: astore 21
    //   4942: aload 21
    //   4944: aload_0
    //   4945: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   4948: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4951: pop
    //   4952: aload 21
    //   4954: ldc_w 493
    //   4957: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4960: pop
    //   4961: aload 21
    //   4963: aconst_null
    //   4964: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4967: pop
    //   4968: aload 21
    //   4970: ldc_w 495
    //   4973: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4976: pop
    //   4977: aload 21
    //   4979: aload_2
    //   4980: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4983: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4986: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4989: pop
    //   4990: aload 21
    //   4992: ldc_w 497
    //   4995: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4998: pop
    //   4999: aload_0
    //   5000: getfield 501	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5003: ifnull +15 -> 5018
    //   5006: aload_0
    //   5007: getfield 501	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5010: getfield 504	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5013: istore 4
    //   5015: goto +6 -> 5021
    //   5018: iconst_0
    //   5019: istore 4
    //   5021: aload 21
    //   5023: iload 4
    //   5025: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5028: pop
    //   5029: aload 21
    //   5031: ldc_w 440
    //   5034: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5037: pop
    //   5038: aload 21
    //   5040: iload_3
    //   5041: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5044: pop
    //   5045: aload 21
    //   5047: aload 18
    //   5049: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5052: pop
    //   5053: aload 21
    //   5055: aload_2
    //   5056: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5059: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5062: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5065: pop
    //   5066: aload 21
    //   5068: aload 20
    //   5070: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5073: pop
    //   5074: aload 21
    //   5076: aload_2
    //   5077: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5080: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5083: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5086: pop
    //   5087: aload 21
    //   5089: aload 34
    //   5091: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5094: pop
    //   5095: aload 21
    //   5097: aload_2
    //   5098: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5101: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5104: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5107: pop
    //   5108: aload 21
    //   5110: aload 33
    //   5112: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5115: pop
    //   5116: aload 21
    //   5118: aload_2
    //   5119: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5122: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5125: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5128: pop
    //   5129: aload 21
    //   5131: aload 17
    //   5133: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5136: pop
    //   5137: aload 21
    //   5139: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   5142: aload_0
    //   5143: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   5146: lsub
    //   5147: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5150: pop
    //   5151: aload 25
    //   5153: invokestatic 508	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5156: ifne +38 -> 5194
    //   5159: new 282	java/lang/StringBuilder
    //   5162: dup
    //   5163: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   5166: astore 14
    //   5168: aload 14
    //   5170: aload 15
    //   5172: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5175: pop
    //   5176: aload 14
    //   5178: aload 25
    //   5180: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5183: pop
    //   5184: aload 14
    //   5186: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5189: astore 14
    //   5191: goto +8 -> 5199
    //   5194: ldc_w 510
    //   5197: astore 14
    //   5199: aload 21
    //   5201: aload 14
    //   5203: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5206: pop
    //   5207: aload 21
    //   5209: aload 13
    //   5211: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5214: pop
    //   5215: aload 21
    //   5217: aload 28
    //   5219: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5222: pop
    //   5223: aload 19
    //   5225: aload 21
    //   5227: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5230: putfield 513	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   5233: iload 7
    //   5235: ifeq +72 -> 5307
    //   5238: aload_0
    //   5239: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   5242: invokestatic 518	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   5245: astore 13
    //   5247: aload_0
    //   5248: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5251: astore 14
    //   5253: aload_0
    //   5254: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   5257: ifeq +31 -> 5288
    //   5260: aload_0
    //   5261: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5264: astore 15
    //   5266: aload 15
    //   5268: ifnull +20 -> 5288
    //   5271: aload 15
    //   5273: ldc_w 520
    //   5276: invokevirtual 523	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5279: ifeq +9 -> 5288
    //   5282: iconst_1
    //   5283: istore 7
    //   5285: goto +6 -> 5291
    //   5288: iconst_0
    //   5289: istore 7
    //   5291: aload 13
    //   5293: aload 14
    //   5295: iload 7
    //   5297: aload_2
    //   5298: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5301: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5304: invokevirtual 527	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   5307: aload 22
    //   5309: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   5312: putfield 530	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   5315: aload 22
    //   5317: aload_0
    //   5318: invokevirtual 531	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   5321: putfield 534	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   5324: aload 22
    //   5326: aload 16
    //   5328: putfield 538	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   5331: aload 22
    //   5333: iload_3
    //   5334: putfield 541	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   5337: aload 22
    //   5339: aconst_null
    //   5340: putfield 545	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   5343: aload 26
    //   5345: ifnonnull +9 -> 5354
    //   5348: aconst_null
    //   5349: astore 13
    //   5351: goto +10 -> 5361
    //   5354: aload 26
    //   5356: invokevirtual 548	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   5359: astore 13
    //   5361: aload 22
    //   5363: aload 13
    //   5365: putfield 551	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   5368: aload 22
    //   5370: aconst_null
    //   5371: putfield 554	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   5374: aload 22
    //   5376: aload_2
    //   5377: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5380: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5383: putfield 555	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   5386: aload 22
    //   5388: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   5391: aload_0
    //   5392: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   5395: lsub
    //   5396: putfield 558	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5399: aload 22
    //   5401: aload_2
    //   5402: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5405: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5408: putfield 561	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   5411: aload 22
    //   5413: aload 22
    //   5415: getfield 558	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5418: aload_2
    //   5419: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5422: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5425: lsub
    //   5426: putfield 564	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   5429: aload 22
    //   5431: lconst_0
    //   5432: putfield 567	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   5435: aload 22
    //   5437: aload_0
    //   5438: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   5441: putfield 570	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   5444: aload 22
    //   5446: aload_0
    //   5447: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   5450: putfield 573	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   5453: aload 22
    //   5455: aload_0
    //   5456: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   5459: putfield 576	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   5462: aload 22
    //   5464: lconst_0
    //   5465: putfield 579	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   5468: aload 22
    //   5470: aload_0
    //   5471: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   5474: putfield 582	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   5477: aload 22
    //   5479: aload_2
    //   5480: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5483: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5486: putfield 585	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   5489: aload 22
    //   5491: aload_0
    //   5492: invokevirtual 165	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   5495: invokestatic 588	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   5498: putfield 590	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   5501: aload 22
    //   5503: aload_0
    //   5504: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   5507: putfield 593	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   5510: aload_0
    //   5511: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   5514: astore 13
    //   5516: aload 13
    //   5518: ifnull +20 -> 5538
    //   5521: aload 13
    //   5523: ldc_w 520
    //   5526: invokevirtual 523	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5529: ifeq +9 -> 5538
    //   5532: iconst_1
    //   5533: istore 7
    //   5535: goto +6 -> 5541
    //   5538: iconst_0
    //   5539: istore 7
    //   5541: aload 22
    //   5543: iload 7
    //   5545: putfield 596	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   5548: aload 22
    //   5550: aload_2
    //   5551: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5554: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5557: putfield 598	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   5560: aload 22
    //   5562: getstatic 604	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   5565: invokevirtual 607	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   5568: putfield 610	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   5571: aload 22
    //   5573: aload_0
    //   5574: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   5577: invokevirtual 613	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   5580: putfield 616	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   5583: aload 16
    //   5585: ifnull +24 -> 5609
    //   5588: aload 16
    //   5590: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5593: ifnull +16 -> 5609
    //   5596: aload 22
    //   5598: aload 16
    //   5600: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5603: invokevirtual 658	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5606: putfield 660	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   5609: aload 22
    //   5611: aload_0
    //   5612: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   5615: invokevirtual 620	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   5618: putfield 624	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   5621: aload 22
    //   5623: aload_0
    //   5624: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   5627: invokevirtual 627	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   5630: putfield 630	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   5633: aload_2
    //   5634: aload 22
    //   5636: invokevirtual 634	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5639: aload_2
    //   5640: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5643: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5646: ifeq +11 -> 5657
    //   5649: aload_0
    //   5650: aload_1
    //   5651: aload_2
    //   5652: aload 22
    //   5654: invokevirtual 109	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5657: aload_0
    //   5658: aconst_null
    //   5659: putfield 180	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   5662: return
    //   5663: astore 24
    //   5665: aload 14
    //   5667: astore 28
    //   5669: aload 13
    //   5671: astore 14
    //   5673: aload 22
    //   5675: astore 13
    //   5677: aload 14
    //   5679: astore 22
    //   5681: goto +232 -> 5913
    //   5684: astore 28
    //   5686: aload 19
    //   5688: astore 24
    //   5690: aload 18
    //   5692: astore 19
    //   5694: aload 20
    //   5696: astore 22
    //   5698: aload 17
    //   5700: astore 18
    //   5702: aload 14
    //   5704: astore 20
    //   5706: aload 23
    //   5708: astore 14
    //   5710: aload 28
    //   5712: astore 23
    //   5714: aload_2
    //   5715: astore 28
    //   5717: aload 24
    //   5719: astore 17
    //   5721: aload 28
    //   5723: astore 24
    //   5725: goto +3071 -> 8796
    //   5728: iload_3
    //   5729: istore 4
    //   5731: aload 14
    //   5733: astore 30
    //   5735: aload 19
    //   5737: astore 28
    //   5739: aload 17
    //   5741: astore 31
    //   5743: aload 13
    //   5745: astore 29
    //   5747: aload_0
    //   5748: getfield 230	com/tencent/component/network/downloader/impl/RangeDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5751: ifnull +55 -> 5806
    //   5754: aload_0
    //   5755: getfield 230	com/tencent/component/network/downloader/impl/RangeDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5758: astore 32
    //   5760: aload_0
    //   5761: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   5764: astore 23
    //   5766: aload 32
    //   5768: aload 23
    //   5770: iconst_1
    //   5771: invokeinterface 664 3 0
    //   5776: goto +30 -> 5806
    //   5779: astore 23
    //   5781: goto +10 -> 5791
    //   5784: astore 23
    //   5786: goto +14 -> 5800
    //   5789: astore 23
    //   5791: aload 23
    //   5793: astore 24
    //   5795: goto -130 -> 5665
    //   5798: astore 23
    //   5800: iload 4
    //   5802: istore_3
    //   5803: goto +2740 -> 8543
    //   5806: iload 4
    //   5808: istore_3
    //   5809: goto +234 -> 6043
    //   5812: astore 22
    //   5814: aload 15
    //   5816: astore 24
    //   5818: aload 16
    //   5820: astore 13
    //   5822: iload 4
    //   5824: istore_3
    //   5825: aconst_null
    //   5826: astore 14
    //   5828: aload 18
    //   5830: astore 19
    //   5832: aload 31
    //   5834: astore 16
    //   5836: aload 20
    //   5838: astore 15
    //   5840: aload 23
    //   5842: astore 20
    //   5844: aload 28
    //   5846: astore 17
    //   5848: aload 13
    //   5850: astore 18
    //   5852: aload 21
    //   5854: astore 23
    //   5856: aload 20
    //   5858: astore 13
    //   5860: aload 19
    //   5862: astore 20
    //   5864: aload 30
    //   5866: astore 19
    //   5868: aload 22
    //   5870: astore 21
    //   5872: aload 29
    //   5874: astore 22
    //   5876: goto +5595 -> 11471
    //   5879: astore 23
    //   5881: iload 4
    //   5883: istore_3
    //   5884: goto +2659 -> 8543
    //   5887: astore 24
    //   5889: goto +12 -> 5901
    //   5892: astore 22
    //   5894: goto +73 -> 5967
    //   5897: astore 24
    //   5899: iconst_0
    //   5900: istore_3
    //   5901: aload 13
    //   5903: astore 22
    //   5905: aload 23
    //   5907: astore 13
    //   5909: aload 14
    //   5911: astore 28
    //   5913: aload 15
    //   5915: astore 29
    //   5917: aload 18
    //   5919: astore 30
    //   5921: aconst_null
    //   5922: astore 14
    //   5924: aload 20
    //   5926: astore 15
    //   5928: aload 16
    //   5930: astore 18
    //   5932: aload 17
    //   5934: astore 16
    //   5936: aload 19
    //   5938: astore 17
    //   5940: aload 21
    //   5942: astore 23
    //   5944: aload 30
    //   5946: astore 20
    //   5948: aload 28
    //   5950: astore 19
    //   5952: aload 24
    //   5954: astore 21
    //   5956: aload 29
    //   5958: astore 24
    //   5960: goto +5511 -> 11471
    //   5963: astore 22
    //   5965: iconst_0
    //   5966: istore_3
    //   5967: aload 20
    //   5969: astore 28
    //   5971: aload 18
    //   5973: astore 29
    //   5975: aload_2
    //   5976: astore 24
    //   5978: aload 17
    //   5980: astore 18
    //   5982: aload 14
    //   5984: astore 20
    //   5986: aload 23
    //   5988: astore 14
    //   5990: aload 19
    //   5992: astore 17
    //   5994: aload 22
    //   5996: astore 23
    //   5998: aload 29
    //   6000: astore 19
    //   6002: aload 28
    //   6004: astore 22
    //   6006: goto +2790 -> 8796
    //   6009: aload 15
    //   6011: astore 23
    //   6013: aload 22
    //   6015: astore 29
    //   6017: aload 14
    //   6019: astore 32
    //   6021: aload 19
    //   6023: astore 28
    //   6025: aload 17
    //   6027: astore 30
    //   6029: aload 13
    //   6031: astore 31
    //   6033: aload_2
    //   6034: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6037: iconst_3
    //   6038: invokevirtual 134	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   6041: iconst_0
    //   6042: istore_3
    //   6043: aload 13
    //   6045: astore 23
    //   6047: iload 6
    //   6049: iconst_1
    //   6050: iadd
    //   6051: istore 4
    //   6053: aload_2
    //   6054: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6057: lload 9
    //   6059: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   6062: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   6065: aload_2
    //   6066: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6069: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   6072: aload_0
    //   6073: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   6076: lsub
    //   6077: putfield 338	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   6080: aload_2
    //   6081: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6084: aload_0
    //   6085: getfield 341	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   6088: putfield 344	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   6091: aload_0
    //   6092: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   6095: invokestatic 350	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   6098: invokevirtual 354	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   6101: astore 28
    //   6103: aload_0
    //   6104: aconst_null
    //   6105: aconst_null
    //   6106: aload 14
    //   6108: invokevirtual 358	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   6111: astore 31
    //   6113: aload 14
    //   6115: ifnull +27 -> 6142
    //   6118: aload 14
    //   6120: invokevirtual 646	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   6123: ifnull +19 -> 6142
    //   6126: aload 14
    //   6128: invokevirtual 646	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   6131: ldc_w 648
    //   6134: invokevirtual 651	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   6137: astore 13
    //   6139: goto +6 -> 6145
    //   6142: aconst_null
    //   6143: astore 13
    //   6145: aload_2
    //   6146: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6149: aload 13
    //   6151: putfield 361	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   6154: aload_0
    //   6155: lconst_0
    //   6156: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   6159: aload_0
    //   6160: iconst_0
    //   6161: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   6164: aload_0
    //   6165: lconst_0
    //   6166: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   6169: aload_0
    //   6170: iconst_0
    //   6171: putfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   6174: aload_1
    //   6175: invokeinterface 105 1 0
    //   6180: ifne +2247 -> 8427
    //   6183: aload_0
    //   6184: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   6187: invokestatic 119	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   6190: istore 7
    //   6192: aload_2
    //   6193: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6196: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6199: ifne +752 -> 6951
    //   6202: new 282	java/lang/StringBuilder
    //   6205: dup
    //   6206: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   6209: astore 30
    //   6211: aload 30
    //   6213: ldc_w 366
    //   6216: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6219: pop
    //   6220: aload 30
    //   6222: aload_0
    //   6223: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   6226: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6229: pop
    //   6230: aload 30
    //   6232: aload 16
    //   6234: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6237: pop
    //   6238: aload 30
    //   6240: aload_0
    //   6241: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   6244: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6247: pop
    //   6248: aload 30
    //   6250: aload 21
    //   6252: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6255: pop
    //   6256: aload_0
    //   6257: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   6260: ifeq +29 -> 6289
    //   6263: aload 14
    //   6265: ifnull +24 -> 6289
    //   6268: aload 14
    //   6270: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6273: ifnull +16 -> 6289
    //   6276: aload 14
    //   6278: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6281: invokevirtual 658	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   6284: astore 24
    //   6286: goto +3 -> 6289
    //   6289: aload 30
    //   6291: aload 24
    //   6293: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6296: pop
    //   6297: aload 30
    //   6299: ldc_w 375
    //   6302: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6305: pop
    //   6306: aload 30
    //   6308: aload 28
    //   6310: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6313: pop
    //   6314: aload 30
    //   6316: ldc_w 380
    //   6319: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6322: pop
    //   6323: aload 30
    //   6325: aconst_null
    //   6326: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6329: pop
    //   6330: aload 30
    //   6332: ldc_w 382
    //   6335: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6338: pop
    //   6339: aload 30
    //   6341: aconst_null
    //   6342: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6345: pop
    //   6346: aload 30
    //   6348: ldc_w 384
    //   6351: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6354: pop
    //   6355: aload 30
    //   6357: invokestatic 388	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6360: invokevirtual 391	java/lang/Thread:getId	()J
    //   6363: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6366: pop
    //   6367: aload 30
    //   6369: ldc_w 396
    //   6372: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6375: pop
    //   6376: aload 30
    //   6378: invokestatic 401	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   6381: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6384: pop
    //   6385: aload 30
    //   6387: ldc_w 403
    //   6390: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6393: pop
    //   6394: aload 30
    //   6396: iload 7
    //   6398: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6401: pop
    //   6402: aload 30
    //   6404: ldc_w 405
    //   6407: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6410: pop
    //   6411: aload 30
    //   6413: invokestatic 411	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6416: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6419: pop
    //   6420: aload 30
    //   6422: aload 18
    //   6424: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6427: pop
    //   6428: aload 30
    //   6430: aload_2
    //   6431: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6434: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6437: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6440: pop
    //   6441: aload 30
    //   6443: aload 33
    //   6445: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6448: pop
    //   6449: aload 30
    //   6451: aload_2
    //   6452: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6455: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6458: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6461: pop
    //   6462: aload 30
    //   6464: aload 17
    //   6466: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6469: pop
    //   6470: aload 30
    //   6472: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   6475: aload_0
    //   6476: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   6479: lsub
    //   6480: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6483: pop
    //   6484: aload 30
    //   6486: aload 20
    //   6488: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6491: pop
    //   6492: aload 30
    //   6494: aload_2
    //   6495: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6498: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6501: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6504: pop
    //   6505: aload 30
    //   6507: aload 34
    //   6509: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6512: pop
    //   6513: aload 30
    //   6515: aload_2
    //   6516: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6519: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6522: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6525: pop
    //   6526: aload 30
    //   6528: ldc_w 422
    //   6531: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6534: pop
    //   6535: aload 30
    //   6537: aload_2
    //   6538: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6541: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   6544: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6547: pop
    //   6548: aload 30
    //   6550: ldc_w 427
    //   6553: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6556: pop
    //   6557: aload 30
    //   6559: aload_0
    //   6560: invokevirtual 430	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   6563: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6566: pop
    //   6567: aload 19
    //   6569: astore 29
    //   6571: aload 30
    //   6573: aload 29
    //   6575: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6578: pop
    //   6579: aload 30
    //   6581: aload_0
    //   6582: invokevirtual 433	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   6585: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6588: pop
    //   6589: aload 30
    //   6591: ldc_w 435
    //   6594: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6597: pop
    //   6598: aload 30
    //   6600: aload_2
    //   6601: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6604: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   6607: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6610: pop
    //   6611: aload 30
    //   6613: ldc_w 440
    //   6616: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6619: pop
    //   6620: aload 30
    //   6622: iload_3
    //   6623: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6626: pop
    //   6627: aload 30
    //   6629: aload 23
    //   6631: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6634: pop
    //   6635: aload 30
    //   6637: aload 31
    //   6639: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6642: pop
    //   6643: aload 30
    //   6645: aload 15
    //   6647: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6650: pop
    //   6651: aload 30
    //   6653: aload 13
    //   6655: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6658: pop
    //   6659: aload 30
    //   6661: ldc_w 442
    //   6664: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6667: pop
    //   6668: aload_0
    //   6669: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   6672: astore 24
    //   6674: aload 24
    //   6676: ifnull +16 -> 6692
    //   6679: aload 24
    //   6681: iconst_0
    //   6682: bipush 30
    //   6684: invokevirtual 448	java/lang/String:substring	(II)Ljava/lang/String;
    //   6687: astore 24
    //   6689: goto +3 -> 6692
    //   6692: aload 30
    //   6694: aload 24
    //   6696: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6699: pop
    //   6700: aload 30
    //   6702: ldc_w 450
    //   6705: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6708: pop
    //   6709: aload 30
    //   6711: aload_2
    //   6712: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6715: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6718: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6721: pop
    //   6722: aload 30
    //   6724: ldc_w 455
    //   6727: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6730: pop
    //   6731: aload 30
    //   6733: lconst_0
    //   6734: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6737: pop
    //   6738: aload 30
    //   6740: ldc_w 457
    //   6743: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6746: pop
    //   6747: aload 30
    //   6749: aload_0
    //   6750: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   6753: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6756: pop
    //   6757: aload 30
    //   6759: aload 29
    //   6761: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6764: pop
    //   6765: aload 30
    //   6767: aload_0
    //   6768: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   6771: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6774: pop
    //   6775: aload 30
    //   6777: ldc_w 459
    //   6780: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6783: pop
    //   6784: aload 30
    //   6786: aload_0
    //   6787: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   6790: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6793: pop
    //   6794: aload 30
    //   6796: aload 29
    //   6798: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6801: pop
    //   6802: aload 30
    //   6804: aload_0
    //   6805: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   6808: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6811: pop
    //   6812: aload 30
    //   6814: ldc_w 461
    //   6817: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6820: pop
    //   6821: aload 30
    //   6823: aload_0
    //   6824: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   6827: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6830: pop
    //   6831: aload 30
    //   6833: ldc_w 463
    //   6836: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6839: pop
    //   6840: aload 30
    //   6842: aload_0
    //   6843: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   6846: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6849: pop
    //   6850: aload 30
    //   6852: ldc_w 468
    //   6855: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6858: pop
    //   6859: aload 30
    //   6861: aload_0
    //   6862: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   6865: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6868: pop
    //   6869: aload 30
    //   6871: ldc_w 473
    //   6874: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6877: pop
    //   6878: aload_0
    //   6879: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6882: ifnull +17 -> 6899
    //   6885: aload_0
    //   6886: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6889: invokeinterface 202 1 0
    //   6894: astore 24
    //   6896: goto +6 -> 6902
    //   6899: aconst_null
    //   6900: astore 24
    //   6902: aload 30
    //   6904: aload 24
    //   6906: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6909: pop
    //   6910: aload 30
    //   6912: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6915: astore 29
    //   6917: aload 22
    //   6919: astore 24
    //   6921: aload 24
    //   6923: aload 29
    //   6925: putfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   6928: ldc_w 478
    //   6931: aload 24
    //   6933: getfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   6936: aconst_null
    //   6937: invokestatic 481	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6940: aload 13
    //   6942: astore 24
    //   6944: aload 15
    //   6946: astore 13
    //   6948: goto +706 -> 7654
    //   6951: aload 22
    //   6953: astore 29
    //   6955: aload 19
    //   6957: astore 30
    //   6959: new 282	java/lang/StringBuilder
    //   6962: dup
    //   6963: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   6966: astore 32
    //   6968: aload 32
    //   6970: ldc_w 483
    //   6973: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6976: pop
    //   6977: aload 32
    //   6979: aload_0
    //   6980: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   6983: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6986: pop
    //   6987: aload 32
    //   6989: aload 16
    //   6991: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6994: pop
    //   6995: aload 32
    //   6997: aload_0
    //   6998: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   7001: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7004: pop
    //   7005: aload 32
    //   7007: aload 21
    //   7009: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7012: pop
    //   7013: aload_0
    //   7014: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   7017: ifeq +29 -> 7046
    //   7020: aload 14
    //   7022: ifnull +24 -> 7046
    //   7025: aload 14
    //   7027: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7030: ifnull +16 -> 7046
    //   7033: aload 14
    //   7035: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7038: invokevirtual 658	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   7041: astore 24
    //   7043: goto +3 -> 7046
    //   7046: aload 32
    //   7048: aload 24
    //   7050: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7053: pop
    //   7054: aload 32
    //   7056: ldc_w 375
    //   7059: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7062: pop
    //   7063: aload 32
    //   7065: aload 28
    //   7067: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7070: pop
    //   7071: aload 32
    //   7073: ldc_w 380
    //   7076: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7079: pop
    //   7080: aload 32
    //   7082: aconst_null
    //   7083: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7086: pop
    //   7087: aload 32
    //   7089: ldc_w 382
    //   7092: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7095: pop
    //   7096: aload 32
    //   7098: aconst_null
    //   7099: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7102: pop
    //   7103: aload 32
    //   7105: ldc_w 384
    //   7108: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7111: pop
    //   7112: aload 32
    //   7114: invokestatic 388	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7117: invokevirtual 391	java/lang/Thread:getId	()J
    //   7120: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7123: pop
    //   7124: aload 32
    //   7126: ldc_w 396
    //   7129: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7132: pop
    //   7133: aload 32
    //   7135: invokestatic 401	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7138: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7141: pop
    //   7142: aload 32
    //   7144: ldc_w 405
    //   7147: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7150: pop
    //   7151: aload 32
    //   7153: invokestatic 411	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7156: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7159: pop
    //   7160: aload 32
    //   7162: aload 33
    //   7164: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7167: pop
    //   7168: aload 32
    //   7170: aload_2
    //   7171: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7174: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7177: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7180: pop
    //   7181: aload 32
    //   7183: aload 17
    //   7185: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7188: pop
    //   7189: aload 32
    //   7191: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   7194: aload_0
    //   7195: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   7198: lsub
    //   7199: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7202: pop
    //   7203: aload 32
    //   7205: aload 20
    //   7207: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7210: pop
    //   7211: aload 32
    //   7213: aload_2
    //   7214: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7217: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7220: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7223: pop
    //   7224: aload 32
    //   7226: aload 34
    //   7228: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7231: pop
    //   7232: aload 32
    //   7234: aload_2
    //   7235: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7238: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7241: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7244: pop
    //   7245: aload 32
    //   7247: ldc_w 422
    //   7250: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7253: pop
    //   7254: aload 32
    //   7256: aload_2
    //   7257: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7260: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7263: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7266: pop
    //   7267: aload 32
    //   7269: ldc_w 427
    //   7272: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7275: pop
    //   7276: aload 32
    //   7278: aload_0
    //   7279: invokevirtual 430	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   7282: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7285: pop
    //   7286: aload 32
    //   7288: aload 30
    //   7290: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7293: pop
    //   7294: aload 32
    //   7296: aload_0
    //   7297: invokevirtual 433	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   7300: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7303: pop
    //   7304: aload 32
    //   7306: ldc_w 485
    //   7309: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7312: pop
    //   7313: aload 32
    //   7315: iload_3
    //   7316: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7319: pop
    //   7320: aload 32
    //   7322: aload 23
    //   7324: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7327: pop
    //   7328: aload 32
    //   7330: aload 31
    //   7332: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7335: pop
    //   7336: aload 32
    //   7338: aload 18
    //   7340: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7343: pop
    //   7344: aload 32
    //   7346: aload_2
    //   7347: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7350: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7353: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7356: pop
    //   7357: aload 32
    //   7359: aload 15
    //   7361: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7364: pop
    //   7365: aload 32
    //   7367: aload 13
    //   7369: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7372: pop
    //   7373: aload 32
    //   7375: ldc_w 442
    //   7378: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7381: pop
    //   7382: aload_0
    //   7383: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7386: astore 24
    //   7388: aload 24
    //   7390: ifnull +16 -> 7406
    //   7393: aload 24
    //   7395: iconst_0
    //   7396: bipush 30
    //   7398: invokevirtual 448	java/lang/String:substring	(II)Ljava/lang/String;
    //   7401: astore 24
    //   7403: goto +3 -> 7406
    //   7406: aload 32
    //   7408: aload 24
    //   7410: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7413: pop
    //   7414: aload 32
    //   7416: ldc_w 450
    //   7419: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7422: pop
    //   7423: aload 32
    //   7425: aload_2
    //   7426: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7429: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7432: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7435: pop
    //   7436: aload 32
    //   7438: ldc_w 455
    //   7441: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7444: pop
    //   7445: aload 32
    //   7447: lconst_0
    //   7448: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7451: pop
    //   7452: aload 32
    //   7454: ldc_w 457
    //   7457: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7460: pop
    //   7461: aload 32
    //   7463: aload_0
    //   7464: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   7467: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7470: pop
    //   7471: aload 32
    //   7473: aload 30
    //   7475: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7478: pop
    //   7479: aload 32
    //   7481: aload_0
    //   7482: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   7485: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7488: pop
    //   7489: aload 32
    //   7491: ldc_w 459
    //   7494: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7497: pop
    //   7498: aload 32
    //   7500: aload_0
    //   7501: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   7504: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7507: pop
    //   7508: aload 32
    //   7510: aload 30
    //   7512: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7515: pop
    //   7516: aload 32
    //   7518: aload_0
    //   7519: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   7522: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7525: pop
    //   7526: aload 32
    //   7528: ldc_w 461
    //   7531: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7534: pop
    //   7535: aload 32
    //   7537: aload_0
    //   7538: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   7541: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7544: pop
    //   7545: aload 32
    //   7547: ldc_w 463
    //   7550: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7553: pop
    //   7554: aload 32
    //   7556: aload_0
    //   7557: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   7560: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7563: pop
    //   7564: aload 32
    //   7566: ldc_w 468
    //   7569: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7572: pop
    //   7573: aload 32
    //   7575: aload_0
    //   7576: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   7579: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7582: pop
    //   7583: aload 32
    //   7585: ldc_w 473
    //   7588: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7591: pop
    //   7592: aload_0
    //   7593: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7596: ifnull +17 -> 7613
    //   7599: aload_0
    //   7600: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7603: invokeinterface 202 1 0
    //   7608: astore 24
    //   7610: goto +6 -> 7616
    //   7613: aconst_null
    //   7614: astore 24
    //   7616: aload 32
    //   7618: aload 24
    //   7620: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7623: pop
    //   7624: aload 29
    //   7626: aload 32
    //   7628: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7631: putfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7634: ldc_w 478
    //   7637: aload 29
    //   7639: getfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7642: aconst_null
    //   7643: invokestatic 488	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7646: aload 13
    //   7648: astore 24
    //   7650: aload 15
    //   7652: astore 13
    //   7654: aload 14
    //   7656: astore 15
    //   7658: iload_3
    //   7659: istore 6
    //   7661: iload 7
    //   7663: ifne +8 -> 7671
    //   7666: aload_0
    //   7667: iconst_0
    //   7668: putfield 491	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   7671: aload_2
    //   7672: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7675: astore 29
    //   7677: new 282	java/lang/StringBuilder
    //   7680: dup
    //   7681: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   7684: astore 30
    //   7686: aload 30
    //   7688: aload_0
    //   7689: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   7692: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7695: pop
    //   7696: aload 30
    //   7698: ldc_w 493
    //   7701: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7704: pop
    //   7705: aload 30
    //   7707: aconst_null
    //   7708: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7711: pop
    //   7712: aload 30
    //   7714: ldc_w 495
    //   7717: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7720: pop
    //   7721: aload 30
    //   7723: aload_2
    //   7724: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7727: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7730: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7733: pop
    //   7734: aload 30
    //   7736: ldc_w 497
    //   7739: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7742: pop
    //   7743: aload_0
    //   7744: getfield 501	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7747: ifnull +14 -> 7761
    //   7750: aload_0
    //   7751: getfield 501	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7754: getfield 504	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7757: istore_3
    //   7758: goto +5 -> 7763
    //   7761: iconst_0
    //   7762: istore_3
    //   7763: aload 30
    //   7765: iload_3
    //   7766: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7769: pop
    //   7770: aload 30
    //   7772: ldc_w 440
    //   7775: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7778: pop
    //   7779: aload 30
    //   7781: iload 6
    //   7783: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7786: pop
    //   7787: aload 30
    //   7789: aload 18
    //   7791: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7794: pop
    //   7795: aload 30
    //   7797: aload_2
    //   7798: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7801: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7804: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7807: pop
    //   7808: aload 30
    //   7810: aload 20
    //   7812: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7815: pop
    //   7816: aload 30
    //   7818: aload_2
    //   7819: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7822: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7825: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7828: pop
    //   7829: aload 30
    //   7831: aload 34
    //   7833: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7836: pop
    //   7837: aload 30
    //   7839: aload_2
    //   7840: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7843: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7846: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7849: pop
    //   7850: aload 30
    //   7852: aload 33
    //   7854: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7857: pop
    //   7858: aload 30
    //   7860: aload_2
    //   7861: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7864: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7867: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7870: pop
    //   7871: aload 30
    //   7873: aload 17
    //   7875: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7878: pop
    //   7879: aload 30
    //   7881: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   7884: aload_0
    //   7885: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   7888: lsub
    //   7889: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7892: pop
    //   7893: aload 24
    //   7895: invokestatic 508	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7898: ifne +38 -> 7936
    //   7901: new 282	java/lang/StringBuilder
    //   7904: dup
    //   7905: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   7908: astore 14
    //   7910: aload 14
    //   7912: aload 13
    //   7914: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7917: pop
    //   7918: aload 14
    //   7920: aload 24
    //   7922: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7925: pop
    //   7926: aload 14
    //   7928: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7931: astore 14
    //   7933: goto +8 -> 7941
    //   7936: ldc_w 510
    //   7939: astore 14
    //   7941: aload 30
    //   7943: aload 14
    //   7945: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7948: pop
    //   7949: aload 30
    //   7951: aload 23
    //   7953: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7956: pop
    //   7957: aload 30
    //   7959: aload 31
    //   7961: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7964: pop
    //   7965: aload 29
    //   7967: aload 30
    //   7969: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7972: putfield 513	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   7975: iload 7
    //   7977: ifeq +72 -> 8049
    //   7980: aload_0
    //   7981: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   7984: invokestatic 518	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   7987: astore 14
    //   7989: aload_0
    //   7990: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   7993: astore 24
    //   7995: aload_0
    //   7996: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   7999: ifeq +31 -> 8030
    //   8002: aload_0
    //   8003: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   8006: astore 29
    //   8008: aload 29
    //   8010: ifnull +20 -> 8030
    //   8013: aload 29
    //   8015: ldc_w 520
    //   8018: invokevirtual 523	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8021: ifeq +9 -> 8030
    //   8024: iconst_1
    //   8025: istore 7
    //   8027: goto +6 -> 8033
    //   8030: iconst_0
    //   8031: istore 7
    //   8033: aload 14
    //   8035: aload 24
    //   8037: iload 7
    //   8039: aload_2
    //   8040: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8043: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8046: invokevirtual 527	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   8049: aload 22
    //   8051: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   8054: putfield 530	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   8057: aload 22
    //   8059: aload_0
    //   8060: invokevirtual 531	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   8063: putfield 534	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   8066: aload 22
    //   8068: aload 15
    //   8070: putfield 538	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   8073: aload 22
    //   8075: iload 6
    //   8077: putfield 541	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   8080: aload 22
    //   8082: aconst_null
    //   8083: putfield 545	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   8086: aload 28
    //   8088: ifnonnull +9 -> 8097
    //   8091: aconst_null
    //   8092: astore 14
    //   8094: goto +10 -> 8104
    //   8097: aload 28
    //   8099: invokevirtual 548	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   8102: astore 14
    //   8104: aload 22
    //   8106: aload 14
    //   8108: putfield 551	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   8111: aload 22
    //   8113: aconst_null
    //   8114: putfield 554	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   8117: aload 22
    //   8119: aload_2
    //   8120: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8123: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8126: putfield 555	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   8129: aload 22
    //   8131: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   8134: aload_0
    //   8135: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   8138: lsub
    //   8139: putfield 558	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   8142: aload 22
    //   8144: aload_2
    //   8145: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8148: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8151: putfield 561	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   8154: aload 22
    //   8156: aload 22
    //   8158: getfield 558	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   8161: aload_2
    //   8162: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8165: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8168: lsub
    //   8169: putfield 564	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   8172: aload 22
    //   8174: lconst_0
    //   8175: putfield 567	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   8178: aload 22
    //   8180: aload_0
    //   8181: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   8184: putfield 570	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   8187: aload 22
    //   8189: aload_0
    //   8190: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   8193: putfield 573	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   8196: aload 22
    //   8198: aload_0
    //   8199: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   8202: putfield 576	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   8205: aload 22
    //   8207: lconst_0
    //   8208: putfield 579	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   8211: aload 22
    //   8213: aload_0
    //   8214: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   8217: putfield 582	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   8220: aload 22
    //   8222: aload_2
    //   8223: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8226: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8229: putfield 585	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   8232: aload 22
    //   8234: aload_0
    //   8235: invokevirtual 165	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   8238: invokestatic 588	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   8241: putfield 590	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   8244: aload 22
    //   8246: aload_0
    //   8247: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   8250: putfield 593	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   8253: aload_0
    //   8254: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   8257: astore 14
    //   8259: aload 14
    //   8261: ifnull +20 -> 8281
    //   8264: aload 14
    //   8266: ldc_w 520
    //   8269: invokevirtual 523	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8272: ifeq +9 -> 8281
    //   8275: iconst_1
    //   8276: istore 7
    //   8278: goto +6 -> 8284
    //   8281: iconst_0
    //   8282: istore 7
    //   8284: aload 22
    //   8286: iload 7
    //   8288: putfield 596	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   8291: aload 22
    //   8293: aload_2
    //   8294: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8297: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8300: putfield 598	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   8303: aload 22
    //   8305: getstatic 604	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   8308: invokevirtual 607	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   8311: putfield 610	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   8314: aload 22
    //   8316: aload_0
    //   8317: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   8320: invokevirtual 613	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   8323: putfield 616	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   8326: aload 15
    //   8328: ifnull +24 -> 8352
    //   8331: aload 15
    //   8333: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8336: ifnull +16 -> 8352
    //   8339: aload 22
    //   8341: aload 15
    //   8343: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8346: invokevirtual 658	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   8349: putfield 660	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   8352: aload 22
    //   8354: aload_0
    //   8355: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   8358: invokevirtual 620	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   8361: putfield 624	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   8364: aload 22
    //   8366: aload_0
    //   8367: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   8370: invokevirtual 627	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   8373: putfield 630	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   8376: aload_2
    //   8377: astore 14
    //   8379: aload 14
    //   8381: aload 22
    //   8383: invokevirtual 634	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   8386: aload_2
    //   8387: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8390: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8393: ifeq +23 -> 8416
    //   8396: aload_0
    //   8397: aload_1
    //   8398: aload 14
    //   8400: aload 22
    //   8402: invokevirtual 109	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   8405: aload 13
    //   8407: astore 14
    //   8409: aload 17
    //   8411: astore 13
    //   8413: goto +22 -> 8435
    //   8416: aload 13
    //   8418: astore 14
    //   8420: aload 17
    //   8422: astore 13
    //   8424: goto +11 -> 8435
    //   8427: aload 15
    //   8429: astore 14
    //   8431: aload 17
    //   8433: astore 13
    //   8435: aload 19
    //   8437: astore 17
    //   8439: aload_0
    //   8440: aconst_null
    //   8441: putfield 180	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   8444: aload_2
    //   8445: astore 22
    //   8447: aload 14
    //   8449: astore 24
    //   8451: aload 23
    //   8453: astore 19
    //   8455: aload_1
    //   8456: astore 15
    //   8458: aload 20
    //   8460: astore 14
    //   8462: aload 18
    //   8464: astore 20
    //   8466: iload 4
    //   8468: istore_3
    //   8469: aload 24
    //   8471: astore 18
    //   8473: goto +2793 -> 11266
    //   8476: astore 22
    //   8478: aload 32
    //   8480: astore 19
    //   8482: aload 31
    //   8484: astore 24
    //   8486: aload 21
    //   8488: astore 14
    //   8490: aload 18
    //   8492: astore 21
    //   8494: aload 29
    //   8496: astore 13
    //   8498: aload 20
    //   8500: astore 15
    //   8502: iconst_0
    //   8503: istore_3
    //   8504: aload 28
    //   8506: astore 17
    //   8508: aload 16
    //   8510: astore 18
    //   8512: aload 30
    //   8514: astore 16
    //   8516: aload 21
    //   8518: astore 20
    //   8520: aload 22
    //   8522: astore 21
    //   8524: aload 24
    //   8526: astore 22
    //   8528: goto +2928 -> 11456
    //   8531: astore 24
    //   8533: aload 23
    //   8535: astore 15
    //   8537: iconst_0
    //   8538: istore_3
    //   8539: aload 24
    //   8541: astore 23
    //   8543: aload 20
    //   8545: astore 28
    //   8547: aload 18
    //   8549: astore 29
    //   8551: aload 14
    //   8553: astore 20
    //   8555: aload 17
    //   8557: astore 18
    //   8559: aload 22
    //   8561: astore 14
    //   8563: aload_2
    //   8564: astore 24
    //   8566: aload 19
    //   8568: astore 17
    //   8570: aload 29
    //   8572: astore 19
    //   8574: aload 28
    //   8576: astore 22
    //   8578: goto +218 -> 8796
    //   8581: astore 22
    //   8583: aload 13
    //   8585: astore 28
    //   8587: aload 18
    //   8589: astore 29
    //   8591: aload 15
    //   8593: astore 13
    //   8595: aload 17
    //   8597: astore 30
    //   8599: aload 20
    //   8601: astore 15
    //   8603: aload 19
    //   8605: astore 17
    //   8607: iconst_0
    //   8608: istore_3
    //   8609: aconst_null
    //   8610: astore 14
    //   8612: aconst_null
    //   8613: astore 19
    //   8615: aload 16
    //   8617: astore 18
    //   8619: aload 21
    //   8621: astore 23
    //   8623: aload 30
    //   8625: astore 16
    //   8627: aload 29
    //   8629: astore 20
    //   8631: aload 22
    //   8633: astore 21
    //   8635: aload 28
    //   8637: astore 22
    //   8639: goto +2832 -> 11471
    //   8642: astore 22
    //   8644: goto +91 -> 8735
    //   8647: astore 14
    //   8649: goto +25 -> 8674
    //   8652: astore 22
    //   8654: goto +81 -> 8735
    //   8657: astore 14
    //   8659: goto +15 -> 8674
    //   8662: astore 22
    //   8664: goto +71 -> 8735
    //   8667: astore 22
    //   8669: goto +66 -> 8735
    //   8672: astore 14
    //   8674: aload 13
    //   8676: astore 22
    //   8678: aload 18
    //   8680: astore 28
    //   8682: aload 15
    //   8684: astore 13
    //   8686: aload 17
    //   8688: astore 29
    //   8690: aload 21
    //   8692: astore 23
    //   8694: aload 20
    //   8696: astore 15
    //   8698: aload 19
    //   8700: astore 17
    //   8702: aconst_null
    //   8703: astore 20
    //   8705: aconst_null
    //   8706: astore 19
    //   8708: aload 14
    //   8710: astore 21
    //   8712: iconst_0
    //   8713: istore_3
    //   8714: aload 16
    //   8716: astore 18
    //   8718: aload 20
    //   8720: astore 14
    //   8722: aload 29
    //   8724: astore 16
    //   8726: aload 28
    //   8728: astore 20
    //   8730: goto +2741 -> 11471
    //   8733: astore 22
    //   8735: aload 22
    //   8737: astore 24
    //   8739: aload 20
    //   8741: astore 22
    //   8743: aload 18
    //   8745: astore 20
    //   8747: aconst_null
    //   8748: astore 31
    //   8750: aload 17
    //   8752: astore 18
    //   8754: aload 23
    //   8756: astore 30
    //   8758: aload 15
    //   8760: astore 29
    //   8762: aload 14
    //   8764: astore 28
    //   8766: aload 19
    //   8768: astore 17
    //   8770: iconst_0
    //   8771: istore_3
    //   8772: aload 20
    //   8774: astore 19
    //   8776: aload 31
    //   8778: astore 20
    //   8780: aload 24
    //   8782: astore 23
    //   8784: aload 30
    //   8786: astore 15
    //   8788: aload 29
    //   8790: astore 14
    //   8792: aload 28
    //   8794: astore 24
    //   8796: aload 16
    //   8798: astore 24
    //   8800: aload 26
    //   8802: astore 28
    //   8804: aload 25
    //   8806: astore 31
    //   8808: aload 27
    //   8810: astore 30
    //   8812: new 282	java/lang/StringBuilder
    //   8815: dup
    //   8816: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   8819: astore 29
    //   8821: aload 29
    //   8823: ldc_w 666
    //   8826: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8829: pop
    //   8830: aload 29
    //   8832: aload_0
    //   8833: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   8836: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8839: pop
    //   8840: aload 29
    //   8842: ldc_w 668
    //   8845: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8848: pop
    //   8849: ldc_w 293
    //   8852: aload 29
    //   8854: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8857: aload 23
    //   8859: invokestatic 481	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8862: aload_2
    //   8863: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8866: aload 23
    //   8868: invokevirtual 671	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   8871: iload 6
    //   8873: iconst_1
    //   8874: iadd
    //   8875: istore 6
    //   8877: aload_2
    //   8878: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8881: lload 9
    //   8883: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   8886: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   8889: aload_2
    //   8890: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8893: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   8896: aload_0
    //   8897: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   8900: lsub
    //   8901: putfield 338	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   8904: aload_2
    //   8905: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8908: aload_0
    //   8909: getfield 341	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   8912: putfield 344	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   8915: aload_0
    //   8916: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   8919: invokestatic 350	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   8922: invokevirtual 354	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   8925: astore 32
    //   8927: aload_0
    //   8928: aconst_null
    //   8929: aconst_null
    //   8930: aload 20
    //   8932: invokevirtual 358	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   8935: astore 34
    //   8937: aload 20
    //   8939: ifnull +27 -> 8966
    //   8942: aload 20
    //   8944: invokevirtual 646	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   8947: ifnull +19 -> 8966
    //   8950: aload 20
    //   8952: invokevirtual 646	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   8955: ldc_w 648
    //   8958: invokevirtual 651	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   8961: astore 29
    //   8963: goto +6 -> 8969
    //   8966: aconst_null
    //   8967: astore 29
    //   8969: aload_2
    //   8970: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8973: aload 29
    //   8975: putfield 361	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   8978: aload_0
    //   8979: lconst_0
    //   8980: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   8983: aload_0
    //   8984: iconst_0
    //   8985: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   8988: aload_0
    //   8989: lconst_0
    //   8990: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   8993: aload_0
    //   8994: iconst_0
    //   8995: putfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   8998: aload_1
    //   8999: invokeinterface 105 1 0
    //   9004: ifne +2216 -> 11220
    //   9007: aload_0
    //   9008: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   9011: invokestatic 119	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   9014: istore 7
    //   9016: aload_2
    //   9017: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9020: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9023: ifne +742 -> 9765
    //   9026: new 282	java/lang/StringBuilder
    //   9029: dup
    //   9030: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   9033: astore 33
    //   9035: aload 33
    //   9037: ldc_w 366
    //   9040: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9043: pop
    //   9044: aload 33
    //   9046: aload_0
    //   9047: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   9050: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9053: pop
    //   9054: aload 33
    //   9056: aload 24
    //   9058: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9061: pop
    //   9062: aload 33
    //   9064: aload_0
    //   9065: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   9068: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9071: pop
    //   9072: aload 33
    //   9074: aload 21
    //   9076: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9079: pop
    //   9080: aload_0
    //   9081: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   9084: ifeq +29 -> 9113
    //   9087: aload 20
    //   9089: ifnull +24 -> 9113
    //   9092: aload 20
    //   9094: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9097: ifnull +16 -> 9113
    //   9100: aload 20
    //   9102: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9105: invokevirtual 658	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9108: astore 28
    //   9110: goto +3 -> 9113
    //   9113: aload 33
    //   9115: aload 28
    //   9117: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9120: pop
    //   9121: aload 33
    //   9123: ldc_w 375
    //   9126: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9129: pop
    //   9130: aload 33
    //   9132: aload 32
    //   9134: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9137: pop
    //   9138: aload 33
    //   9140: ldc_w 380
    //   9143: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9146: pop
    //   9147: aload 33
    //   9149: aconst_null
    //   9150: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9153: pop
    //   9154: aload 33
    //   9156: ldc_w 382
    //   9159: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9162: pop
    //   9163: aload 33
    //   9165: aconst_null
    //   9166: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9169: pop
    //   9170: aload 33
    //   9172: ldc_w 384
    //   9175: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9178: pop
    //   9179: aload 33
    //   9181: invokestatic 388	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9184: invokevirtual 391	java/lang/Thread:getId	()J
    //   9187: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9190: pop
    //   9191: aload 33
    //   9193: ldc_w 396
    //   9196: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9199: pop
    //   9200: aload 33
    //   9202: invokestatic 401	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9205: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9208: pop
    //   9209: aload 33
    //   9211: ldc_w 403
    //   9214: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9217: pop
    //   9218: aload 33
    //   9220: iload 7
    //   9222: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9225: pop
    //   9226: aload 33
    //   9228: ldc_w 405
    //   9231: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9234: pop
    //   9235: aload 33
    //   9237: invokestatic 411	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9240: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9243: pop
    //   9244: aload 33
    //   9246: aload 19
    //   9248: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9251: pop
    //   9252: aload 33
    //   9254: aload_2
    //   9255: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9258: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9261: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9264: pop
    //   9265: aload 33
    //   9267: aload 30
    //   9269: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9272: pop
    //   9273: aload 33
    //   9275: aload_2
    //   9276: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9279: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9282: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9285: pop
    //   9286: aload 33
    //   9288: aload 18
    //   9290: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9293: pop
    //   9294: aload 33
    //   9296: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   9299: aload_0
    //   9300: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   9303: lsub
    //   9304: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9307: pop
    //   9308: aload 33
    //   9310: aload 22
    //   9312: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9315: pop
    //   9316: aload 33
    //   9318: aload_2
    //   9319: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9322: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9325: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9328: pop
    //   9329: aload 33
    //   9331: aload 31
    //   9333: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9336: pop
    //   9337: aload 33
    //   9339: aload_2
    //   9340: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9343: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9346: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9349: pop
    //   9350: aload 33
    //   9352: ldc_w 422
    //   9355: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9358: pop
    //   9359: aload 33
    //   9361: aload_2
    //   9362: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9365: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9368: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9371: pop
    //   9372: aload 33
    //   9374: ldc_w 427
    //   9377: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9380: pop
    //   9381: aload 33
    //   9383: aload_0
    //   9384: invokevirtual 430	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   9387: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9390: pop
    //   9391: aload 33
    //   9393: aload 17
    //   9395: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9398: pop
    //   9399: aload 33
    //   9401: aload_0
    //   9402: invokevirtual 433	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   9405: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9408: pop
    //   9409: aload 33
    //   9411: ldc_w 435
    //   9414: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9417: pop
    //   9418: aload 33
    //   9420: aload_2
    //   9421: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9424: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   9427: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9430: pop
    //   9431: aload 33
    //   9433: ldc_w 440
    //   9436: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9439: pop
    //   9440: aload 33
    //   9442: iload_3
    //   9443: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9446: pop
    //   9447: aload 33
    //   9449: aload 13
    //   9451: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9454: pop
    //   9455: aload 33
    //   9457: aload 34
    //   9459: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9462: pop
    //   9463: aload 33
    //   9465: aload 15
    //   9467: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9470: pop
    //   9471: aload 33
    //   9473: aload 29
    //   9475: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9478: pop
    //   9479: aload 33
    //   9481: ldc_w 442
    //   9484: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9487: pop
    //   9488: aload_0
    //   9489: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   9492: astore 28
    //   9494: aload 28
    //   9496: astore 24
    //   9498: aload 28
    //   9500: ifnull +13 -> 9513
    //   9503: aload 28
    //   9505: iconst_0
    //   9506: bipush 30
    //   9508: invokevirtual 448	java/lang/String:substring	(II)Ljava/lang/String;
    //   9511: astore 24
    //   9513: aload 33
    //   9515: aload 24
    //   9517: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9520: pop
    //   9521: aload 33
    //   9523: ldc_w 450
    //   9526: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9529: pop
    //   9530: aload 33
    //   9532: aload_2
    //   9533: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9536: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9539: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9542: pop
    //   9543: aload 33
    //   9545: ldc_w 455
    //   9548: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9551: pop
    //   9552: aload 33
    //   9554: lconst_0
    //   9555: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9558: pop
    //   9559: aload 33
    //   9561: ldc_w 457
    //   9564: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9567: pop
    //   9568: aload 33
    //   9570: aload_0
    //   9571: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   9574: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9577: pop
    //   9578: aload 33
    //   9580: aload 17
    //   9582: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9585: pop
    //   9586: aload 33
    //   9588: aload_0
    //   9589: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   9592: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9595: pop
    //   9596: aload 33
    //   9598: ldc_w 459
    //   9601: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9604: pop
    //   9605: aload 33
    //   9607: aload_0
    //   9608: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   9611: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9614: pop
    //   9615: aload 33
    //   9617: aload 17
    //   9619: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9622: pop
    //   9623: aload 33
    //   9625: aload_0
    //   9626: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   9629: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9632: pop
    //   9633: aload 33
    //   9635: ldc_w 461
    //   9638: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9641: pop
    //   9642: aload 33
    //   9644: aload_0
    //   9645: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   9648: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9651: pop
    //   9652: aload 33
    //   9654: ldc_w 463
    //   9657: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9660: pop
    //   9661: aload 33
    //   9663: aload_0
    //   9664: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   9667: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9670: pop
    //   9671: aload 33
    //   9673: ldc_w 468
    //   9676: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9679: pop
    //   9680: aload 33
    //   9682: aload_0
    //   9683: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   9686: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9689: pop
    //   9690: aload 33
    //   9692: ldc_w 473
    //   9695: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9698: pop
    //   9699: aload_0
    //   9700: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9703: ifnull +17 -> 9720
    //   9706: aload_0
    //   9707: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9710: invokeinterface 202 1 0
    //   9715: astore 24
    //   9717: goto +6 -> 9723
    //   9720: aconst_null
    //   9721: astore 24
    //   9723: aload 33
    //   9725: aload 24
    //   9727: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9730: pop
    //   9731: aload 33
    //   9733: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9736: astore 28
    //   9738: aload 14
    //   9740: astore 24
    //   9742: aload 24
    //   9744: aload 28
    //   9746: putfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9749: ldc_w 478
    //   9752: aload 24
    //   9754: getfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9757: aload 23
    //   9759: invokestatic 481	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9762: goto +694 -> 10456
    //   9765: aload 14
    //   9767: astore 33
    //   9769: new 282	java/lang/StringBuilder
    //   9772: dup
    //   9773: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   9776: astore 35
    //   9778: aload 35
    //   9780: ldc_w 483
    //   9783: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9786: pop
    //   9787: aload 35
    //   9789: aload_0
    //   9790: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   9793: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9796: pop
    //   9797: aload 35
    //   9799: aload 24
    //   9801: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9804: pop
    //   9805: aload 35
    //   9807: aload_0
    //   9808: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   9811: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9814: pop
    //   9815: aload 35
    //   9817: aload 21
    //   9819: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9822: pop
    //   9823: aload_0
    //   9824: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   9827: ifeq +29 -> 9856
    //   9830: aload 20
    //   9832: ifnull +24 -> 9856
    //   9835: aload 20
    //   9837: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9840: ifnull +16 -> 9856
    //   9843: aload 20
    //   9845: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9848: invokevirtual 658	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9851: astore 28
    //   9853: goto +3 -> 9856
    //   9856: aload 35
    //   9858: aload 28
    //   9860: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9863: pop
    //   9864: aload 35
    //   9866: ldc_w 375
    //   9869: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9872: pop
    //   9873: aload 35
    //   9875: aload 32
    //   9877: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9880: pop
    //   9881: aload 35
    //   9883: ldc_w 380
    //   9886: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9889: pop
    //   9890: aload 35
    //   9892: aconst_null
    //   9893: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9896: pop
    //   9897: aload 35
    //   9899: ldc_w 382
    //   9902: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9905: pop
    //   9906: aload 35
    //   9908: aconst_null
    //   9909: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9912: pop
    //   9913: aload 35
    //   9915: ldc_w 384
    //   9918: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9921: pop
    //   9922: aload 35
    //   9924: invokestatic 388	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9927: invokevirtual 391	java/lang/Thread:getId	()J
    //   9930: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9933: pop
    //   9934: aload 35
    //   9936: ldc_w 396
    //   9939: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9942: pop
    //   9943: aload 35
    //   9945: invokestatic 401	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9948: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9951: pop
    //   9952: aload 35
    //   9954: ldc_w 405
    //   9957: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9960: pop
    //   9961: aload 35
    //   9963: invokestatic 411	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9966: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9969: pop
    //   9970: aload 35
    //   9972: aload 30
    //   9974: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9977: pop
    //   9978: aload 35
    //   9980: aload_2
    //   9981: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9984: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9987: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9990: pop
    //   9991: aload 35
    //   9993: aload 18
    //   9995: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9998: pop
    //   9999: aload 35
    //   10001: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   10004: aload_0
    //   10005: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   10008: lsub
    //   10009: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10012: pop
    //   10013: aload 35
    //   10015: aload 22
    //   10017: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10020: pop
    //   10021: aload 35
    //   10023: aload_2
    //   10024: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10027: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10030: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10033: pop
    //   10034: aload 35
    //   10036: aload 31
    //   10038: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10041: pop
    //   10042: aload 35
    //   10044: aload_2
    //   10045: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10048: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10051: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10054: pop
    //   10055: aload 35
    //   10057: ldc_w 422
    //   10060: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10063: pop
    //   10064: aload 35
    //   10066: aload_2
    //   10067: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10070: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10073: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10076: pop
    //   10077: aload 35
    //   10079: ldc_w 427
    //   10082: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10085: pop
    //   10086: aload 35
    //   10088: aload_0
    //   10089: invokevirtual 430	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   10092: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10095: pop
    //   10096: aload 35
    //   10098: aload 17
    //   10100: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10103: pop
    //   10104: aload 35
    //   10106: aload_0
    //   10107: invokevirtual 433	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   10110: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10113: pop
    //   10114: aload 35
    //   10116: ldc_w 485
    //   10119: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10122: pop
    //   10123: aload 35
    //   10125: iload_3
    //   10126: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10129: pop
    //   10130: aload 35
    //   10132: aload 13
    //   10134: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10137: pop
    //   10138: aload 35
    //   10140: aload 34
    //   10142: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10145: pop
    //   10146: aload 35
    //   10148: aload 19
    //   10150: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10153: pop
    //   10154: aload 35
    //   10156: aload_2
    //   10157: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10160: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10163: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10166: pop
    //   10167: aload 35
    //   10169: aload 15
    //   10171: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10174: pop
    //   10175: aload 35
    //   10177: aload 29
    //   10179: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10182: pop
    //   10183: aload 35
    //   10185: ldc_w 442
    //   10188: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10191: pop
    //   10192: aload_0
    //   10193: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   10196: astore 24
    //   10198: aload 24
    //   10200: ifnull +16 -> 10216
    //   10203: aload 24
    //   10205: iconst_0
    //   10206: bipush 30
    //   10208: invokevirtual 448	java/lang/String:substring	(II)Ljava/lang/String;
    //   10211: astore 24
    //   10213: goto +3 -> 10216
    //   10216: aload 35
    //   10218: aload 24
    //   10220: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10223: pop
    //   10224: aload 35
    //   10226: ldc_w 450
    //   10229: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10232: pop
    //   10233: aload 35
    //   10235: aload_2
    //   10236: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10239: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10242: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10245: pop
    //   10246: aload 35
    //   10248: ldc_w 455
    //   10251: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10254: pop
    //   10255: aload 35
    //   10257: lconst_0
    //   10258: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10261: pop
    //   10262: aload 35
    //   10264: ldc_w 457
    //   10267: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10270: pop
    //   10271: aload 35
    //   10273: aload_0
    //   10274: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   10277: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10280: pop
    //   10281: aload 35
    //   10283: aload 17
    //   10285: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10288: pop
    //   10289: aload 35
    //   10291: aload_0
    //   10292: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   10295: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10298: pop
    //   10299: aload 35
    //   10301: ldc_w 459
    //   10304: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10307: pop
    //   10308: aload 35
    //   10310: aload_0
    //   10311: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   10314: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10317: pop
    //   10318: aload 35
    //   10320: aload 17
    //   10322: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10325: pop
    //   10326: aload 35
    //   10328: aload_0
    //   10329: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   10332: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10335: pop
    //   10336: aload 35
    //   10338: ldc_w 461
    //   10341: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10344: pop
    //   10345: aload 35
    //   10347: aload_0
    //   10348: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   10351: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10354: pop
    //   10355: aload 35
    //   10357: ldc_w 463
    //   10360: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10363: pop
    //   10364: aload 35
    //   10366: aload_0
    //   10367: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   10370: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10373: pop
    //   10374: aload 35
    //   10376: ldc_w 468
    //   10379: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10382: pop
    //   10383: aload 35
    //   10385: aload_0
    //   10386: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   10389: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10392: pop
    //   10393: aload 35
    //   10395: ldc_w 473
    //   10398: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10401: pop
    //   10402: aload_0
    //   10403: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10406: ifnull +17 -> 10423
    //   10409: aload_0
    //   10410: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10413: invokeinterface 202 1 0
    //   10418: astore 24
    //   10420: goto +6 -> 10426
    //   10423: aconst_null
    //   10424: astore 24
    //   10426: aload 35
    //   10428: aload 24
    //   10430: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10433: pop
    //   10434: aload 33
    //   10436: aload 35
    //   10438: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10441: putfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10444: ldc_w 478
    //   10447: aload 33
    //   10449: getfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10452: aconst_null
    //   10453: invokestatic 488	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10456: aload 14
    //   10458: astore 24
    //   10460: iload 7
    //   10462: ifne +8 -> 10470
    //   10465: aload_0
    //   10466: iconst_0
    //   10467: putfield 491	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   10470: aload_2
    //   10471: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10474: astore 28
    //   10476: new 282	java/lang/StringBuilder
    //   10479: dup
    //   10480: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   10483: astore 33
    //   10485: aload 33
    //   10487: aload_0
    //   10488: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   10491: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10494: pop
    //   10495: aload 33
    //   10497: ldc_w 493
    //   10500: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10503: pop
    //   10504: aload 33
    //   10506: aconst_null
    //   10507: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10510: pop
    //   10511: aload 33
    //   10513: ldc_w 495
    //   10516: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10519: pop
    //   10520: aload 33
    //   10522: aload_2
    //   10523: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10526: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10529: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10532: pop
    //   10533: aload 33
    //   10535: ldc_w 497
    //   10538: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10541: pop
    //   10542: aload_0
    //   10543: getfield 501	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10546: ifnull +15 -> 10561
    //   10549: aload_0
    //   10550: getfield 501	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10553: getfield 504	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10556: istore 4
    //   10558: goto +6 -> 10564
    //   10561: iconst_0
    //   10562: istore 4
    //   10564: aload 33
    //   10566: iload 4
    //   10568: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10571: pop
    //   10572: aload 33
    //   10574: ldc_w 440
    //   10577: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10580: pop
    //   10581: aload 33
    //   10583: iload_3
    //   10584: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10587: pop
    //   10588: aload 33
    //   10590: aload 19
    //   10592: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10595: pop
    //   10596: aload 33
    //   10598: aload_2
    //   10599: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10602: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10605: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10608: pop
    //   10609: aload 33
    //   10611: aload 22
    //   10613: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10616: pop
    //   10617: aload 33
    //   10619: aload_2
    //   10620: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10623: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10626: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10629: pop
    //   10630: aload 33
    //   10632: aload 31
    //   10634: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10637: pop
    //   10638: aload 33
    //   10640: aload_2
    //   10641: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10644: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10647: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10650: pop
    //   10651: aload 33
    //   10653: aload 30
    //   10655: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10658: pop
    //   10659: aload 33
    //   10661: aload_2
    //   10662: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10665: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10668: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10671: pop
    //   10672: aload 33
    //   10674: aload 18
    //   10676: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10679: pop
    //   10680: aload 33
    //   10682: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   10685: aload_0
    //   10686: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   10689: lsub
    //   10690: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10693: pop
    //   10694: aload 29
    //   10696: invokestatic 508	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10699: ifne +38 -> 10737
    //   10702: new 282	java/lang/StringBuilder
    //   10705: dup
    //   10706: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   10709: astore 14
    //   10711: aload 14
    //   10713: aload 15
    //   10715: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10718: pop
    //   10719: aload 14
    //   10721: aload 29
    //   10723: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10726: pop
    //   10727: aload 14
    //   10729: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10732: astore 14
    //   10734: goto +8 -> 10742
    //   10737: ldc_w 510
    //   10740: astore 14
    //   10742: aload 33
    //   10744: aload 14
    //   10746: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10749: pop
    //   10750: aload 33
    //   10752: aload 13
    //   10754: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10757: pop
    //   10758: aload 33
    //   10760: aload 34
    //   10762: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10765: pop
    //   10766: aload 28
    //   10768: aload 33
    //   10770: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10773: putfield 513	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   10776: iload 7
    //   10778: ifeq +72 -> 10850
    //   10781: aload_0
    //   10782: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   10785: invokestatic 518	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   10788: astore 14
    //   10790: aload_0
    //   10791: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   10794: astore 28
    //   10796: aload_0
    //   10797: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   10800: ifeq +31 -> 10831
    //   10803: aload_0
    //   10804: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   10807: astore 29
    //   10809: aload 29
    //   10811: ifnull +20 -> 10831
    //   10814: aload 29
    //   10816: ldc_w 520
    //   10819: invokevirtual 523	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   10822: ifeq +9 -> 10831
    //   10825: iconst_1
    //   10826: istore 7
    //   10828: goto +6 -> 10834
    //   10831: iconst_0
    //   10832: istore 7
    //   10834: aload 14
    //   10836: aload 28
    //   10838: iload 7
    //   10840: aload_2
    //   10841: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10844: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10847: invokevirtual 527	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   10850: aload 24
    //   10852: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   10855: putfield 530	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   10858: aload 24
    //   10860: aload_0
    //   10861: invokevirtual 531	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   10864: putfield 534	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   10867: aload 24
    //   10869: aload 20
    //   10871: putfield 538	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   10874: aload 24
    //   10876: iload_3
    //   10877: putfield 541	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   10880: aload 24
    //   10882: aload 23
    //   10884: putfield 545	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   10887: aload 32
    //   10889: ifnonnull +9 -> 10898
    //   10892: aconst_null
    //   10893: astore 14
    //   10895: goto +10 -> 10905
    //   10898: aload 32
    //   10900: invokevirtual 548	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   10903: astore 14
    //   10905: aload 24
    //   10907: aload 14
    //   10909: putfield 551	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   10912: aload 24
    //   10914: aconst_null
    //   10915: putfield 554	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   10918: aload 24
    //   10920: aload_2
    //   10921: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10924: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10927: putfield 555	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   10930: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   10933: lstore 9
    //   10935: aload 15
    //   10937: astore 14
    //   10939: aload 24
    //   10941: lload 9
    //   10943: aload_0
    //   10944: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   10947: lsub
    //   10948: putfield 558	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   10951: aload 24
    //   10953: aload_2
    //   10954: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10957: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10960: putfield 561	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   10963: aload 24
    //   10965: aload 24
    //   10967: getfield 558	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   10970: aload_2
    //   10971: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10974: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10977: lsub
    //   10978: putfield 564	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   10981: aload 24
    //   10983: lconst_0
    //   10984: putfield 567	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   10987: aload 24
    //   10989: aload_0
    //   10990: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   10993: putfield 570	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   10996: aload 24
    //   10998: aload_0
    //   10999: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   11002: putfield 573	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   11005: aload 24
    //   11007: aload_0
    //   11008: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   11011: putfield 576	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   11014: aload 24
    //   11016: lconst_0
    //   11017: putfield 579	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   11020: aload 24
    //   11022: aload_0
    //   11023: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   11026: putfield 582	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   11029: aload 24
    //   11031: aload_2
    //   11032: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11035: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11038: putfield 585	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   11041: aload 24
    //   11043: aload_0
    //   11044: invokevirtual 165	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   11047: invokestatic 588	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   11050: putfield 590	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   11053: aload 24
    //   11055: aload_0
    //   11056: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   11059: putfield 593	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   11062: aload_0
    //   11063: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   11066: astore 15
    //   11068: aload 15
    //   11070: ifnull +20 -> 11090
    //   11073: aload 15
    //   11075: ldc_w 520
    //   11078: invokevirtual 523	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11081: ifeq +9 -> 11090
    //   11084: iconst_1
    //   11085: istore 7
    //   11087: goto +6 -> 11093
    //   11090: iconst_0
    //   11091: istore 7
    //   11093: aload 24
    //   11095: iload 7
    //   11097: putfield 596	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   11100: aload 24
    //   11102: aload_2
    //   11103: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11106: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11109: putfield 598	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   11112: aload 24
    //   11114: getstatic 604	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   11117: invokevirtual 607	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   11120: putfield 610	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   11123: aload 24
    //   11125: aload_0
    //   11126: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   11129: invokevirtual 613	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   11132: putfield 616	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   11135: aload 20
    //   11137: ifnull +24 -> 11161
    //   11140: aload 20
    //   11142: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11145: ifnull +16 -> 11161
    //   11148: aload 24
    //   11150: aload 20
    //   11152: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11155: invokevirtual 658	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   11158: putfield 660	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   11161: aload 24
    //   11163: aload_0
    //   11164: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   11167: invokevirtual 620	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   11170: putfield 624	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   11173: aload 24
    //   11175: aload_0
    //   11176: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   11179: invokevirtual 627	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   11182: putfield 630	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   11185: aload_2
    //   11186: astore 15
    //   11188: aload 15
    //   11190: aload 24
    //   11192: invokevirtual 634	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11195: aload_2
    //   11196: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11199: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11202: ifeq +15 -> 11217
    //   11205: aload_0
    //   11206: aload_1
    //   11207: aload 15
    //   11209: aload 24
    //   11211: invokevirtual 109	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11214: goto +10 -> 11224
    //   11217: goto +7 -> 11224
    //   11220: aload 15
    //   11222: astore 14
    //   11224: aload 13
    //   11226: astore 24
    //   11228: aload 19
    //   11230: astore 20
    //   11232: aload_1
    //   11233: astore 15
    //   11235: aload 22
    //   11237: astore 23
    //   11239: aload_2
    //   11240: astore 22
    //   11242: aload_0
    //   11243: aconst_null
    //   11244: putfield 180	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   11247: aload 18
    //   11249: astore 13
    //   11251: aload 14
    //   11253: astore 18
    //   11255: aload 24
    //   11257: astore 19
    //   11259: iload 6
    //   11261: istore_3
    //   11262: aload 23
    //   11264: astore 14
    //   11266: aload_0
    //   11267: invokevirtual 674	com/tencent/component/network/downloader/impl/RangeDownloadTask:canAttempt	()Z
    //   11270: ifne +4 -> 11274
    //   11273: return
    //   11274: aload 17
    //   11276: astore 24
    //   11278: aload 22
    //   11280: astore 23
    //   11282: aload 20
    //   11284: astore 17
    //   11286: aload 19
    //   11288: astore 22
    //   11290: aload 13
    //   11292: astore 28
    //   11294: aload 24
    //   11296: astore 19
    //   11298: aload 14
    //   11300: astore 20
    //   11302: aload 23
    //   11304: astore 14
    //   11306: aload 18
    //   11308: astore 23
    //   11310: aload 17
    //   11312: astore 18
    //   11314: aload 22
    //   11316: astore 13
    //   11318: aload 28
    //   11320: astore 17
    //   11322: goto -11240 -> 82
    //   11325: astore 30
    //   11327: aload 15
    //   11329: astore 28
    //   11331: aload 13
    //   11333: astore 29
    //   11335: aload 18
    //   11337: astore 16
    //   11339: aload 24
    //   11341: astore 18
    //   11343: aload 21
    //   11345: astore 13
    //   11347: aload 22
    //   11349: astore 15
    //   11351: aload 14
    //   11353: astore 22
    //   11355: aload 30
    //   11357: astore 21
    //   11359: aload 20
    //   11361: astore 24
    //   11363: aload 23
    //   11365: astore 14
    //   11367: aload 13
    //   11369: astore 23
    //   11371: aload 22
    //   11373: astore 13
    //   11375: aload 19
    //   11377: astore 20
    //   11379: aload 24
    //   11381: astore 19
    //   11383: aload 29
    //   11385: astore 22
    //   11387: aload 28
    //   11389: astore 24
    //   11391: goto +80 -> 11471
    //   11394: astore 16
    //   11396: goto +8 -> 11404
    //   11399: astore 16
    //   11401: goto +3 -> 11404
    //   11404: aload 15
    //   11406: astore 23
    //   11408: aload 13
    //   11410: astore 30
    //   11412: aload 19
    //   11414: astore 29
    //   11416: aload 14
    //   11418: astore 13
    //   11420: aload 18
    //   11422: astore 28
    //   11424: aload 21
    //   11426: astore 14
    //   11428: aload 22
    //   11430: astore 15
    //   11432: aload 24
    //   11434: astore 18
    //   11436: aload 20
    //   11438: astore 19
    //   11440: aload 30
    //   11442: astore 22
    //   11444: aload 16
    //   11446: astore 21
    //   11448: aload 29
    //   11450: astore 20
    //   11452: aload 28
    //   11454: astore 16
    //   11456: aconst_null
    //   11457: astore 28
    //   11459: aload 23
    //   11461: astore 24
    //   11463: aload 14
    //   11465: astore 23
    //   11467: aload 28
    //   11469: astore 14
    //   11471: aload 25
    //   11473: astore 28
    //   11475: aload_2
    //   11476: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11479: lload 9
    //   11481: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   11484: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   11487: aload_2
    //   11488: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11491: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   11494: aload_0
    //   11495: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   11498: lsub
    //   11499: putfield 338	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   11502: aload_2
    //   11503: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11506: aload_0
    //   11507: getfield 341	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTaskStartTimeStamp	J
    //   11510: putfield 344	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   11513: aload_0
    //   11514: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   11517: invokestatic 350	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   11520: invokevirtual 354	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   11523: astore 29
    //   11525: aload_0
    //   11526: aconst_null
    //   11527: aconst_null
    //   11528: aload 19
    //   11530: invokevirtual 358	com/tencent/component/network/downloader/impl/RangeDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   11533: astore 30
    //   11535: aload 19
    //   11537: ifnull +27 -> 11564
    //   11540: aload 19
    //   11542: invokevirtual 646	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   11545: ifnull +19 -> 11564
    //   11548: aload 19
    //   11550: invokevirtual 646	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   11553: ldc_w 648
    //   11556: invokevirtual 651	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   11559: astore 25
    //   11561: goto +6 -> 11567
    //   11564: aconst_null
    //   11565: astore 25
    //   11567: aload_2
    //   11568: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11571: aload 25
    //   11573: putfield 361	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   11576: aload_0
    //   11577: lconst_0
    //   11578: putfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   11581: aload_0
    //   11582: iconst_0
    //   11583: putfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   11586: aload_0
    //   11587: lconst_0
    //   11588: putfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   11591: aload_0
    //   11592: iconst_0
    //   11593: putfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   11596: aload_1
    //   11597: invokeinterface 105 1 0
    //   11602: ifne +2202 -> 13804
    //   11605: aload_0
    //   11606: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   11609: invokestatic 119	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   11612: istore 7
    //   11614: aload_2
    //   11615: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11618: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11621: ifne +733 -> 12354
    //   11624: new 282	java/lang/StringBuilder
    //   11627: dup
    //   11628: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   11631: astore 31
    //   11633: aload 31
    //   11635: ldc_w 366
    //   11638: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11641: pop
    //   11642: aload 31
    //   11644: aload_0
    //   11645: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   11648: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11651: pop
    //   11652: aload 31
    //   11654: aload 18
    //   11656: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11659: pop
    //   11660: aload 31
    //   11662: aload_0
    //   11663: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   11666: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11669: pop
    //   11670: aload 31
    //   11672: aload 23
    //   11674: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11677: pop
    //   11678: aload_0
    //   11679: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   11682: ifeq +29 -> 11711
    //   11685: aload 19
    //   11687: ifnull +24 -> 11711
    //   11690: aload 19
    //   11692: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11695: ifnull +16 -> 11711
    //   11698: aload 19
    //   11700: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11703: invokevirtual 658	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   11706: astore 26
    //   11708: goto +3 -> 11711
    //   11711: aload 31
    //   11713: aload 26
    //   11715: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11718: pop
    //   11719: aload 31
    //   11721: ldc_w 375
    //   11724: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11727: pop
    //   11728: aload 31
    //   11730: aload 29
    //   11732: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11735: pop
    //   11736: aload 31
    //   11738: ldc_w 380
    //   11741: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11744: pop
    //   11745: aload 31
    //   11747: aconst_null
    //   11748: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11751: pop
    //   11752: aload 31
    //   11754: ldc_w 382
    //   11757: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11760: pop
    //   11761: aload 31
    //   11763: aconst_null
    //   11764: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11767: pop
    //   11768: aload 31
    //   11770: ldc_w 384
    //   11773: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11776: pop
    //   11777: aload 31
    //   11779: invokestatic 388	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11782: invokevirtual 391	java/lang/Thread:getId	()J
    //   11785: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11788: pop
    //   11789: aload 31
    //   11791: ldc_w 396
    //   11794: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11797: pop
    //   11798: aload 31
    //   11800: invokestatic 401	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   11803: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11806: pop
    //   11807: aload 31
    //   11809: ldc_w 403
    //   11812: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11815: pop
    //   11816: aload 31
    //   11818: iload 7
    //   11820: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11823: pop
    //   11824: aload 31
    //   11826: ldc_w 405
    //   11829: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11832: pop
    //   11833: aload 31
    //   11835: invokestatic 411	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   11838: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11841: pop
    //   11842: aload 31
    //   11844: aload 20
    //   11846: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11849: pop
    //   11850: aload 31
    //   11852: aload_2
    //   11853: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11856: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11859: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11862: pop
    //   11863: aload 31
    //   11865: aload 27
    //   11867: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11870: pop
    //   11871: aload 31
    //   11873: aload_2
    //   11874: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11877: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11880: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11883: pop
    //   11884: aload 31
    //   11886: aload 16
    //   11888: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11891: pop
    //   11892: aload 31
    //   11894: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   11897: aload_0
    //   11898: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   11901: lsub
    //   11902: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11905: pop
    //   11906: aload 31
    //   11908: aload 15
    //   11910: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11913: pop
    //   11914: aload 31
    //   11916: aload_2
    //   11917: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11920: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   11923: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11926: pop
    //   11927: aload 31
    //   11929: aload 28
    //   11931: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11934: pop
    //   11935: aload 31
    //   11937: aload_2
    //   11938: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11941: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   11944: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11947: pop
    //   11948: aload 31
    //   11950: ldc_w 422
    //   11953: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11956: pop
    //   11957: aload 31
    //   11959: aload_2
    //   11960: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11963: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   11966: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11969: pop
    //   11970: aload 31
    //   11972: ldc_w 427
    //   11975: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11978: pop
    //   11979: aload 31
    //   11981: aload_0
    //   11982: invokevirtual 430	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   11985: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11988: pop
    //   11989: aload 31
    //   11991: aload 17
    //   11993: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11996: pop
    //   11997: aload 31
    //   11999: aload_0
    //   12000: invokevirtual 433	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   12003: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12006: pop
    //   12007: aload 31
    //   12009: ldc_w 435
    //   12012: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12015: pop
    //   12016: aload 31
    //   12018: aload_2
    //   12019: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12022: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   12025: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12028: pop
    //   12029: aload 31
    //   12031: ldc_w 440
    //   12034: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12037: pop
    //   12038: aload 31
    //   12040: iload_3
    //   12041: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12044: pop
    //   12045: aload 31
    //   12047: aload 22
    //   12049: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12052: pop
    //   12053: aload 31
    //   12055: aload 30
    //   12057: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12060: pop
    //   12061: aload 31
    //   12063: aload 24
    //   12065: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12068: pop
    //   12069: aload 31
    //   12071: aload 25
    //   12073: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12076: pop
    //   12077: aload 31
    //   12079: ldc_w 442
    //   12082: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12085: pop
    //   12086: aload_0
    //   12087: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   12090: astore 18
    //   12092: aload 18
    //   12094: ifnull +16 -> 12110
    //   12097: aload 18
    //   12099: iconst_0
    //   12100: bipush 30
    //   12102: invokevirtual 448	java/lang/String:substring	(II)Ljava/lang/String;
    //   12105: astore 18
    //   12107: goto +3 -> 12110
    //   12110: aload 31
    //   12112: aload 18
    //   12114: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12117: pop
    //   12118: aload 31
    //   12120: ldc_w 450
    //   12123: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12126: pop
    //   12127: aload 31
    //   12129: aload_2
    //   12130: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12133: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   12136: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12139: pop
    //   12140: aload 31
    //   12142: ldc_w 455
    //   12145: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12148: pop
    //   12149: aload 31
    //   12151: lconst_0
    //   12152: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12155: pop
    //   12156: aload 31
    //   12158: ldc_w 457
    //   12161: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12164: pop
    //   12165: aload 31
    //   12167: aload_0
    //   12168: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   12171: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12174: pop
    //   12175: aload 31
    //   12177: aload 17
    //   12179: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12182: pop
    //   12183: aload 31
    //   12185: aload_0
    //   12186: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   12189: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12192: pop
    //   12193: aload 31
    //   12195: ldc_w 459
    //   12198: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12201: pop
    //   12202: aload 31
    //   12204: aload_0
    //   12205: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   12208: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12211: pop
    //   12212: aload 31
    //   12214: aload 17
    //   12216: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12219: pop
    //   12220: aload 31
    //   12222: aload_0
    //   12223: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   12226: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12229: pop
    //   12230: aload 31
    //   12232: ldc_w 461
    //   12235: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12238: pop
    //   12239: aload 31
    //   12241: aload_0
    //   12242: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   12245: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12248: pop
    //   12249: aload 31
    //   12251: ldc_w 463
    //   12254: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12257: pop
    //   12258: aload 31
    //   12260: aload_0
    //   12261: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   12264: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12267: pop
    //   12268: aload 31
    //   12270: ldc_w 468
    //   12273: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12276: pop
    //   12277: aload 31
    //   12279: aload_0
    //   12280: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   12283: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12286: pop
    //   12287: aload 31
    //   12289: ldc_w 473
    //   12292: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12295: pop
    //   12296: aload_0
    //   12297: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12300: ifnull +17 -> 12317
    //   12303: aload_0
    //   12304: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12307: invokeinterface 202 1 0
    //   12312: astore 17
    //   12314: goto +6 -> 12320
    //   12317: aconst_null
    //   12318: astore 17
    //   12320: aload 31
    //   12322: aload 17
    //   12324: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12327: pop
    //   12328: aload 13
    //   12330: aload 31
    //   12332: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12335: putfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12338: ldc_w 478
    //   12341: aload 13
    //   12343: getfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12346: aload 14
    //   12348: invokestatic 481	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12351: goto +698 -> 13049
    //   12354: new 282	java/lang/StringBuilder
    //   12357: dup
    //   12358: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   12361: astore 31
    //   12363: aload 31
    //   12365: ldc_w 483
    //   12368: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12371: pop
    //   12372: aload 31
    //   12374: aload_0
    //   12375: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   12378: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12381: pop
    //   12382: aload 31
    //   12384: aload 18
    //   12386: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12389: pop
    //   12390: aload 31
    //   12392: aload_0
    //   12393: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   12396: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12399: pop
    //   12400: aload 31
    //   12402: aload 23
    //   12404: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12407: pop
    //   12408: aload_0
    //   12409: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   12412: ifeq +29 -> 12441
    //   12415: aload 19
    //   12417: ifnull +24 -> 12441
    //   12420: aload 19
    //   12422: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12425: ifnull +16 -> 12441
    //   12428: aload 19
    //   12430: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12433: invokevirtual 658	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   12436: astore 26
    //   12438: goto +3 -> 12441
    //   12441: aload 31
    //   12443: aload 26
    //   12445: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12448: pop
    //   12449: aload 31
    //   12451: ldc_w 375
    //   12454: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12457: pop
    //   12458: aload 31
    //   12460: aload 29
    //   12462: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12465: pop
    //   12466: aload 31
    //   12468: ldc_w 380
    //   12471: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12474: pop
    //   12475: aload 31
    //   12477: aconst_null
    //   12478: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12481: pop
    //   12482: aload 31
    //   12484: ldc_w 382
    //   12487: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12490: pop
    //   12491: aload 31
    //   12493: aconst_null
    //   12494: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12497: pop
    //   12498: aload 31
    //   12500: ldc_w 384
    //   12503: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12506: pop
    //   12507: aload 31
    //   12509: invokestatic 388	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12512: invokevirtual 391	java/lang/Thread:getId	()J
    //   12515: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12518: pop
    //   12519: aload 31
    //   12521: ldc_w 396
    //   12524: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12527: pop
    //   12528: aload 31
    //   12530: invokestatic 401	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   12533: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12536: pop
    //   12537: aload 31
    //   12539: ldc_w 405
    //   12542: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12545: pop
    //   12546: aload 31
    //   12548: invokestatic 411	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   12551: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12554: pop
    //   12555: aload 31
    //   12557: aload 27
    //   12559: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12562: pop
    //   12563: aload 31
    //   12565: aload_2
    //   12566: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12569: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   12572: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12575: pop
    //   12576: aload 31
    //   12578: aload 16
    //   12580: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12583: pop
    //   12584: aload 31
    //   12586: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   12589: aload_0
    //   12590: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   12593: lsub
    //   12594: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12597: pop
    //   12598: aload 31
    //   12600: aload 15
    //   12602: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12605: pop
    //   12606: aload 31
    //   12608: aload_2
    //   12609: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12612: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   12615: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12618: pop
    //   12619: aload 31
    //   12621: aload 28
    //   12623: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12626: pop
    //   12627: aload 31
    //   12629: aload_2
    //   12630: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12633: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   12636: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12639: pop
    //   12640: aload 31
    //   12642: ldc_w 422
    //   12645: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12648: pop
    //   12649: aload 31
    //   12651: aload_2
    //   12652: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12655: getfield 425	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   12658: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12661: pop
    //   12662: aload 31
    //   12664: ldc_w 427
    //   12667: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12670: pop
    //   12671: aload 31
    //   12673: aload_0
    //   12674: invokevirtual 430	com/tencent/component/network/downloader/impl/RangeDownloadTask:getCurrAttemptCount	()I
    //   12677: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12680: pop
    //   12681: aload 31
    //   12683: aload 17
    //   12685: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12688: pop
    //   12689: aload 31
    //   12691: aload_0
    //   12692: invokevirtual 433	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTotalAttemptCount	()I
    //   12695: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12698: pop
    //   12699: aload 31
    //   12701: ldc_w 485
    //   12704: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12707: pop
    //   12708: aload 31
    //   12710: iload_3
    //   12711: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12714: pop
    //   12715: aload 31
    //   12717: aload 22
    //   12719: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12722: pop
    //   12723: aload 31
    //   12725: aload 30
    //   12727: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12730: pop
    //   12731: aload 31
    //   12733: aload 20
    //   12735: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12738: pop
    //   12739: aload 31
    //   12741: aload_2
    //   12742: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12745: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   12748: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12751: pop
    //   12752: aload 31
    //   12754: aload 24
    //   12756: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12759: pop
    //   12760: aload 31
    //   12762: aload 25
    //   12764: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12767: pop
    //   12768: aload 31
    //   12770: ldc_w 442
    //   12773: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12776: pop
    //   12777: aload_0
    //   12778: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   12781: astore 18
    //   12783: aload 18
    //   12785: ifnull +16 -> 12801
    //   12788: aload 18
    //   12790: iconst_0
    //   12791: bipush 30
    //   12793: invokevirtual 448	java/lang/String:substring	(II)Ljava/lang/String;
    //   12796: astore 18
    //   12798: goto +3 -> 12801
    //   12801: aload 31
    //   12803: aload 18
    //   12805: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12808: pop
    //   12809: aload 31
    //   12811: ldc_w 450
    //   12814: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12817: pop
    //   12818: aload 31
    //   12820: aload_2
    //   12821: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12824: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   12827: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12830: pop
    //   12831: aload 31
    //   12833: ldc_w 455
    //   12836: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12839: pop
    //   12840: aload 31
    //   12842: lconst_0
    //   12843: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12846: pop
    //   12847: aload 31
    //   12849: ldc_w 457
    //   12852: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12855: pop
    //   12856: aload 31
    //   12858: aload_0
    //   12859: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   12862: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12865: pop
    //   12866: aload 31
    //   12868: aload 17
    //   12870: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12873: pop
    //   12874: aload 31
    //   12876: aload_0
    //   12877: getfield 36	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_retry	I
    //   12880: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12883: pop
    //   12884: aload 31
    //   12886: ldc_w 459
    //   12889: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12892: pop
    //   12893: aload 31
    //   12895: aload_0
    //   12896: getfield 38	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_time	J
    //   12899: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12902: pop
    //   12903: aload 31
    //   12905: aload 17
    //   12907: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12910: pop
    //   12911: aload 31
    //   12913: aload_0
    //   12914: getfield 40	com/tencent/component/network/downloader/impl/RangeDownloadTask:exe_retry	I
    //   12917: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12920: pop
    //   12921: aload 31
    //   12923: ldc_w 461
    //   12926: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12929: pop
    //   12930: aload 31
    //   12932: aload_0
    //   12933: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   12936: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12939: pop
    //   12940: aload 31
    //   12942: ldc_w 463
    //   12945: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12948: pop
    //   12949: aload 31
    //   12951: aload_0
    //   12952: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   12955: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12958: pop
    //   12959: aload 31
    //   12961: ldc_w 468
    //   12964: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12967: pop
    //   12968: aload 31
    //   12970: aload_0
    //   12971: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   12974: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12977: pop
    //   12978: aload 31
    //   12980: ldc_w 473
    //   12983: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12986: pop
    //   12987: aload_0
    //   12988: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12991: ifnull +17 -> 13008
    //   12994: aload_0
    //   12995: getfield 196	com/tencent/component/network/downloader/impl/RangeDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12998: invokeinterface 202 1 0
    //   13003: astore 17
    //   13005: goto +6 -> 13011
    //   13008: aconst_null
    //   13009: astore 17
    //   13011: aload 31
    //   13013: aload 17
    //   13015: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13018: pop
    //   13019: aload 31
    //   13021: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13024: astore 18
    //   13026: aload 13
    //   13028: astore 17
    //   13030: aload 17
    //   13032: aload 18
    //   13034: putfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13037: ldc_w 478
    //   13040: aload 17
    //   13042: getfield 476	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13045: aconst_null
    //   13046: invokestatic 488	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   13049: iload_3
    //   13050: istore 4
    //   13052: aload 13
    //   13054: astore 17
    //   13056: iload 7
    //   13058: ifne +11 -> 13069
    //   13061: aload_0
    //   13062: iconst_0
    //   13063: putfield 491	com/tencent/component/network/downloader/impl/RangeDownloadTask:mShouldReport	Z
    //   13066: goto +3 -> 13069
    //   13069: iconst_0
    //   13070: istore 8
    //   13072: aload_2
    //   13073: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13076: astore 18
    //   13078: new 282	java/lang/StringBuilder
    //   13081: dup
    //   13082: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   13085: astore 23
    //   13087: aload 23
    //   13089: aload_0
    //   13090: invokevirtual 84	com/tencent/component/network/downloader/impl/RangeDownloadTask:getUrl	()Ljava/lang/String;
    //   13093: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13096: pop
    //   13097: aload 23
    //   13099: ldc_w 493
    //   13102: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13105: pop
    //   13106: aload 23
    //   13108: aconst_null
    //   13109: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13112: pop
    //   13113: aload 23
    //   13115: ldc_w 495
    //   13118: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13121: pop
    //   13122: aload 23
    //   13124: aload_2
    //   13125: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13128: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13131: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13134: pop
    //   13135: aload 23
    //   13137: ldc_w 497
    //   13140: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13143: pop
    //   13144: aload_0
    //   13145: getfield 501	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13148: ifnull +14 -> 13162
    //   13151: aload_0
    //   13152: getfield 501	com/tencent/component/network/downloader/impl/RangeDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13155: getfield 504	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13158: istore_3
    //   13159: goto +5 -> 13164
    //   13162: iconst_0
    //   13163: istore_3
    //   13164: aload 23
    //   13166: iload_3
    //   13167: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13170: pop
    //   13171: aload 23
    //   13173: ldc_w 440
    //   13176: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13179: pop
    //   13180: aload 23
    //   13182: iload 4
    //   13184: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13187: pop
    //   13188: aload 23
    //   13190: aload 20
    //   13192: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13195: pop
    //   13196: aload 23
    //   13198: aload_2
    //   13199: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13202: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13205: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13208: pop
    //   13209: aload 23
    //   13211: aload 15
    //   13213: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13216: pop
    //   13217: aload 23
    //   13219: aload_2
    //   13220: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13223: getfield 311	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13226: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13229: pop
    //   13230: aload 23
    //   13232: aload 28
    //   13234: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13237: pop
    //   13238: aload 23
    //   13240: aload_2
    //   13241: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13244: getfield 320	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13247: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13250: pop
    //   13251: aload 23
    //   13253: aload 27
    //   13255: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13258: pop
    //   13259: aload 23
    //   13261: aload_2
    //   13262: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13265: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13268: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13271: pop
    //   13272: aload 23
    //   13274: aload 16
    //   13276: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13279: pop
    //   13280: aload 23
    //   13282: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   13285: aload_0
    //   13286: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   13289: lsub
    //   13290: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13293: pop
    //   13294: aload 25
    //   13296: invokestatic 508	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13299: ifne +38 -> 13337
    //   13302: new 282	java/lang/StringBuilder
    //   13305: dup
    //   13306: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   13309: astore 13
    //   13311: aload 13
    //   13313: aload 24
    //   13315: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13318: pop
    //   13319: aload 13
    //   13321: aload 25
    //   13323: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13326: pop
    //   13327: aload 13
    //   13329: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13332: astore 13
    //   13334: goto +8 -> 13342
    //   13337: ldc_w 510
    //   13340: astore 13
    //   13342: aload 23
    //   13344: aload 13
    //   13346: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13349: pop
    //   13350: aload 23
    //   13352: aload 22
    //   13354: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13357: pop
    //   13358: aload 23
    //   13360: aload 30
    //   13362: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13365: pop
    //   13366: aload 18
    //   13368: aload 23
    //   13370: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13373: putfield 513	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   13376: iload 7
    //   13378: ifeq +72 -> 13450
    //   13381: aload_0
    //   13382: getfield 113	com/tencent/component/network/downloader/impl/RangeDownloadTask:mContext	Landroid/content/Context;
    //   13385: invokestatic 518	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   13388: astore 13
    //   13390: aload_0
    //   13391: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   13394: astore 15
    //   13396: aload_0
    //   13397: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   13400: ifeq +31 -> 13431
    //   13403: aload_0
    //   13404: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   13407: astore 16
    //   13409: aload 16
    //   13411: ifnull +20 -> 13431
    //   13414: aload 16
    //   13416: ldc_w 520
    //   13419: invokevirtual 523	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13422: ifeq +9 -> 13431
    //   13425: iconst_1
    //   13426: istore 7
    //   13428: goto +6 -> 13434
    //   13431: iconst_0
    //   13432: istore 7
    //   13434: aload 13
    //   13436: aload 15
    //   13438: iload 7
    //   13440: aload_2
    //   13441: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13444: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13447: invokevirtual 527	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   13450: aload 17
    //   13452: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   13455: putfield 530	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   13458: aload 17
    //   13460: aload_0
    //   13461: invokevirtual 531	com/tencent/component/network/downloader/impl/RangeDownloadTask:getContentLength	()J
    //   13464: putfield 534	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   13467: aload 17
    //   13469: aload 19
    //   13471: putfield 538	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   13474: aload 17
    //   13476: iload 4
    //   13478: putfield 541	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   13481: aload 17
    //   13483: aload 14
    //   13485: putfield 545	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   13488: aload 29
    //   13490: ifnonnull +9 -> 13499
    //   13493: aconst_null
    //   13494: astore 13
    //   13496: goto +10 -> 13506
    //   13499: aload 29
    //   13501: invokevirtual 548	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   13504: astore 13
    //   13506: aload 17
    //   13508: aload 13
    //   13510: putfield 551	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   13513: aload 17
    //   13515: aconst_null
    //   13516: putfield 554	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   13519: aload 17
    //   13521: aload_2
    //   13522: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13525: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13528: putfield 555	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   13531: aload 17
    //   13533: invokestatic 30	android/os/SystemClock:uptimeMillis	()J
    //   13536: aload_0
    //   13537: getfield 32	com/tencent/component/network/downloader/impl/RangeDownloadTask:mTimeStamp	J
    //   13540: lsub
    //   13541: putfield 558	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   13544: aload 17
    //   13546: aload_2
    //   13547: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13550: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13553: putfield 561	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   13556: aload 17
    //   13558: aload 17
    //   13560: getfield 558	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   13563: aload_2
    //   13564: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13567: getfield 420	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13570: lsub
    //   13571: putfield 564	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   13574: aload 17
    //   13576: lconst_0
    //   13577: putfield 567	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   13580: aload 17
    //   13582: aload_0
    //   13583: getfield 34	com/tencent/component/network/downloader/impl/RangeDownloadTask:connect_time	J
    //   13586: putfield 570	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   13589: aload 17
    //   13591: aload_0
    //   13592: getfield 42	com/tencent/component/network/downloader/impl/RangeDownloadTask:send_req_time	J
    //   13595: putfield 573	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   13598: aload 17
    //   13600: aload_0
    //   13601: getfield 466	com/tencent/component/network/downloader/impl/RangeDownloadTask:t_recv_data	J
    //   13604: putfield 576	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   13607: aload 17
    //   13609: lconst_0
    //   13610: putfield 579	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   13613: aload 17
    //   13615: aload_0
    //   13616: invokevirtual 471	com/tencent/component/network/downloader/impl/RangeDownloadTask:getTaskConcurrentCount	()I
    //   13619: putfield 582	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   13622: aload 17
    //   13624: aload_2
    //   13625: invokevirtual 303	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13628: getfield 417	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13631: putfield 585	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   13634: aload 17
    //   13636: aload_0
    //   13637: invokevirtual 165	com/tencent/component/network/downloader/impl/RangeDownloadTask:getDomain	()Ljava/lang/String;
    //   13640: invokestatic 588	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   13643: putfield 590	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   13646: aload 17
    //   13648: aload_0
    //   13649: getfield 370	com/tencent/component/network/downloader/impl/RangeDownloadTask:mIsHttp2	Z
    //   13652: putfield 593	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   13655: aload_0
    //   13656: getfield 220	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRealUrl	Ljava/lang/String;
    //   13659: astore 13
    //   13661: iload 8
    //   13663: istore 7
    //   13665: aload 13
    //   13667: ifnull +21 -> 13688
    //   13670: iload 8
    //   13672: istore 7
    //   13674: aload 13
    //   13676: ldc_w 520
    //   13679: invokevirtual 523	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13682: ifeq +6 -> 13688
    //   13685: iconst_1
    //   13686: istore 7
    //   13688: aload 17
    //   13690: iload 7
    //   13692: putfield 596	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   13695: aload 17
    //   13697: aload_2
    //   13698: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13701: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13704: putfield 598	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   13707: aload 17
    //   13709: getstatic 604	com/tencent/component/network/downloader/Downloader$DownloadMode:RangeMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   13712: invokevirtual 607	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   13715: putfield 610	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   13718: aload 17
    //   13720: aload_0
    //   13721: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   13724: invokevirtual 613	com/tencent/component/network/downloader/RangeDownloadManager:getDurationMillisForRangeReceivePhase	()J
    //   13727: putfield 616	com/tencent/component/network/downloader/DownloadReport:timeCostForRangeReceivePhase	J
    //   13730: aload 19
    //   13732: ifnull +24 -> 13756
    //   13735: aload 19
    //   13737: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   13740: ifnull +16 -> 13756
    //   13743: aload 17
    //   13745: aload 19
    //   13747: invokevirtual 655	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   13750: invokevirtual 658	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   13753: putfield 660	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   13756: aload 17
    //   13758: aload_0
    //   13759: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   13762: invokevirtual 620	com/tencent/component/network/downloader/RangeDownloadManager:getRangeDownloadReports	()Ljava/util/List;
    //   13765: putfield 624	com/tencent/component/network/downloader/DownloadReport:rangeDownloadReports	Ljava/util/List;
    //   13768: aload 17
    //   13770: aload_0
    //   13771: getfield 49	com/tencent/component/network/downloader/impl/RangeDownloadTask:mRangeDownloaderManager	Lcom/tencent/component/network/downloader/RangeDownloadManager;
    //   13774: invokevirtual 627	com/tencent/component/network/downloader/RangeDownloadManager:getNumberOfRangeTasks	()I
    //   13777: putfield 630	com/tencent/component/network/downloader/DownloadReport:rangeNumber	I
    //   13780: aload_2
    //   13781: aload 17
    //   13783: invokevirtual 634	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   13786: aload_2
    //   13787: invokevirtual 128	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13790: invokevirtual 364	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13793: ifeq +11 -> 13804
    //   13796: aload_0
    //   13797: aload_1
    //   13798: aload_2
    //   13799: aload 17
    //   13801: invokevirtual 109	com/tencent/component/network/downloader/impl/RangeDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   13804: aload_0
    //   13805: aconst_null
    //   13806: putfield 180	com/tencent/component/network/downloader/impl/RangeDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   13809: goto +6 -> 13815
    //   13812: aload 21
    //   13814: athrow
    //   13815: goto -3 -> 13812
    //   13818: astore 15
    //   13820: goto -13680 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	13823	0	this	RangeDownloadTask
    //   0	13823	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	13823	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   81	13086	3	i	int
    //   5013	8464	4	j	int
    //   73	115	5	k	int
    //   151	11109	6	m	int
    //   570	13121	7	bool1	boolean
    //   78	13593	8	bool2	boolean
    //   174	11306	9	l1	long
    //   524	153	11	l2	long
    //   28	13647	13	localObject1	java.lang.Object
    //   4	8607	14	localObject2	java.lang.Object
    //   8647	1	14	localObject3	java.lang.Object
    //   8657	1	14	localObject4	java.lang.Object
    //   8672	37	14	localObject5	java.lang.Object
    //   8720	4764	14	localObject6	java.lang.Object
    //   1	13436	15	localObject7	java.lang.Object
    //   13818	1	15	localException	java.lang.Exception
    //   16	11322	16	localObject8	java.lang.Object
    //   11394	1	16	localObject9	java.lang.Object
    //   11399	46	16	localObject10	java.lang.Object
    //   11454	1961	16	localObject11	java.lang.Object
    //   54	13746	17	localObject12	java.lang.Object
    //   24	13343	18	localObject13	java.lang.Object
    //   44	13702	19	localObject14	java.lang.Object
    //   36	464	20	localObject15	java.lang.Object
    //   592	1	20	localThrowable1	java.lang.Throwable
    //   803	1861	20	localObject16	java.lang.Object
    //   3234	32	20	localThrowable2	java.lang.Throwable
    //   3271	9920	20	localObject17	java.lang.Object
    //   12	484	21	localObject18	java.lang.Object
    //   795	1	21	localObject19	java.lang.Object
    //   887	12926	21	localObject20	java.lang.Object
    //   50	205	22	localObject21	java.lang.Object
    //   259	55	22	localObject22	java.lang.Object
    //   319	98	22	localObject23	java.lang.Object
    //   446	1	22	localObject24	java.lang.Object
    //   501	1	22	localObject25	java.lang.Object
    //   587	231	22	localObject26	java.lang.Object
    //   844	1223	22	localObject27	java.lang.Object
    //   3229	1	22	localObject28	java.lang.Object
    //   3297	2400	22	localObject29	java.lang.Object
    //   5812	57	22	localObject30	java.lang.Object
    //   5874	1	22	localObject31	java.lang.Object
    //   5892	1	22	localThrowable3	java.lang.Throwable
    //   5903	1	22	localObject32	java.lang.Object
    //   5963	32	22	localThrowable4	java.lang.Throwable
    //   6004	2442	22	localObject33	java.lang.Object
    //   8476	45	22	localObject34	java.lang.Object
    //   8526	51	22	localObject35	java.lang.Object
    //   8581	51	22	localObject36	java.lang.Object
    //   8637	1	22	localObject37	java.lang.Object
    //   8642	1	22	localThrowable5	java.lang.Throwable
    //   8652	1	22	localThrowable6	java.lang.Throwable
    //   8662	1	22	localThrowable7	java.lang.Throwable
    //   8667	1	22	localThrowable8	java.lang.Throwable
    //   8676	1	22	localObject38	java.lang.Object
    //   8733	3	22	localThrowable9	java.lang.Throwable
    //   8741	4612	22	localObject39	java.lang.Object
    //   20	788	23	localObject40	java.lang.Object
    //   849	2413	23	localThrowable10	java.lang.Throwable
    //   3267	2502	23	localObject41	java.lang.Object
    //   5779	1	23	localObject42	java.lang.Object
    //   5784	1	23	localThrowable11	java.lang.Throwable
    //   5789	3	23	localObject43	java.lang.Object
    //   5798	43	23	localThrowable12	java.lang.Throwable
    //   5854	1	23	localObject44	java.lang.Object
    //   5879	27	23	localThrowable13	java.lang.Throwable
    //   5942	7427	23	localObject45	java.lang.Object
    //   169	1	24	localObject46	java.lang.Object
    //   324	1	24	localThrowable14	java.lang.Throwable
    //   451	401	24	localThrowable15	java.lang.Throwable
    //   871	3441	24	localObject47	java.lang.Object
    //   5663	1	24	localObject48	java.lang.Object
    //   5688	129	24	localObject49	java.lang.Object
    //   5887	1	24	localObject50	java.lang.Object
    //   5897	56	24	localObject51	java.lang.Object
    //   5958	2567	24	localObject52	java.lang.Object
    //   8531	9	24	localThrowable16	java.lang.Throwable
    //   8564	4750	24	localObject53	java.lang.Object
    //   32	13290	25	str1	String
    //   8	12436	26	localObject54	java.lang.Object
    //   40	13214	27	localObject55	java.lang.Object
    //   263	5405	28	localObject56	java.lang.Object
    //   5684	27	28	localThrowable17	java.lang.Throwable
    //   5715	7518	28	localObject57	java.lang.Object
    //   232	13268	29	localObject58	java.lang.Object
    //   278	10376	30	localObject59	java.lang.Object
    //   11325	31	30	localObject60	java.lang.Object
    //   11410	1951	30	localObject61	java.lang.Object
    //   266	12754	31	localObject62	java.lang.Object
    //   489	10410	32	localObject63	java.lang.Object
    //   493	10276	33	localObject64	java.lang.Object
    //   3293	7468	34	str2	String
    //   9776	661	35	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   245	256	259	finally
    //   245	256	324	java/lang/Throwable
    //   421	443	446	finally
    //   421	443	451	java/lang/Throwable
    //   577	584	587	finally
    //   611	631	587	finally
    //   631	774	587	finally
    //   896	954	587	finally
    //   577	584	592	java/lang/Throwable
    //   611	631	592	java/lang/Throwable
    //   631	774	592	java/lang/Throwable
    //   896	954	592	java/lang/Throwable
    //   774	788	795	finally
    //   774	788	849	java/lang/Throwable
    //   537	572	3229	finally
    //   597	606	3229	finally
    //   957	1023	3229	finally
    //   537	572	3234	java/lang/Throwable
    //   597	606	3234	java/lang/Throwable
    //   957	1023	3234	java/lang/Throwable
    //   3333	3340	5663	finally
    //   3333	3340	5684	java/lang/Throwable
    //   5766	5776	5779	finally
    //   5766	5776	5784	java/lang/Throwable
    //   5760	5766	5789	finally
    //   5760	5766	5798	java/lang/Throwable
    //   5747	5760	5812	finally
    //   5747	5760	5879	java/lang/Throwable
    //   3318	3326	5887	finally
    //   3318	3326	5892	java/lang/Throwable
    //   3312	3318	5897	finally
    //   3312	3318	5963	java/lang/Throwable
    //   6033	6041	8476	finally
    //   6033	6041	8531	java/lang/Throwable
    //   503	532	8581	finally
    //   503	532	8642	java/lang/Throwable
    //   391	416	8647	finally
    //   456	491	8647	finally
    //   391	416	8652	java/lang/Throwable
    //   456	491	8652	java/lang/Throwable
    //   385	391	8657	finally
    //   385	391	8662	java/lang/Throwable
    //   379	385	8667	java/lang/Throwable
    //   223	240	8672	finally
    //   332	379	8672	finally
    //   379	385	8672	finally
    //   223	240	8733	java/lang/Throwable
    //   332	379	8733	java/lang/Throwable
    //   8862	8871	11325	finally
    //   8821	8862	11394	finally
    //   8812	8821	11399	finally
    //   131	137	13818	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.RangeDownloadTask
 * JD-Core Version:    0.7.0.1
 */