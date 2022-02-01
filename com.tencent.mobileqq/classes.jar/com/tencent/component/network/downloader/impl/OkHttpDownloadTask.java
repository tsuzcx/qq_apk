package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpDownloadTask
  extends DownloadTask
{
  private long mDnsEnd;
  private long mDnsStart;
  private float mLastCallbackProgress;
  private final float mProgressCallbackStep = 0.1F;
  private String mRemoteAddress;
  private final long mTimeStamp = SystemClock.uptimeMillis();
  
  public OkHttpDownloadTask(Context paramContext, OkHttpClient paramOkHttpClient, QZoneHttpClient paramQZoneHttpClient, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramOkHttpClient, paramQZoneHttpClient, paramString1, paramString2, paramBoolean1, true);
    this.pokHttpClient = this.pokHttpClient.newBuilder().addNetworkInterceptor(new OkHttpDownloadTask.ProgressInterceptor(this, new OkHttpDownloadTask.2(this))).eventListener(new OkHttpDownloadTask.1(this)).build();
  }
  
  private long parseContentLength(Response paramResponse)
  {
    long l2;
    long l1;
    if ((paramResponse != null) && (paramResponse.body() != null))
    {
      l2 = paramResponse.body().contentLength();
      l1 = l2;
      if (l2 <= 0L)
      {
        l1 = l2;
        if (paramResponse.networkResponse() != null)
        {
          paramResponse = paramResponse.networkResponse().header("content-length");
          l1 = l2;
          if (TextUtils.isEmpty(paramResponse)) {}
        }
      }
    }
    try
    {
      l1 = Long.parseLong(paramResponse);
      return l1;
    }
    catch (Throwable paramResponse) {}
    return -1L;
    return l2;
  }
  
  private void reset()
  {
    this.mLastCallbackProgress = 0.0F;
  }
  
  private long saveToFile(InputStream paramInputStream, String paramString)
  {
    if (paramInputStream != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0L;
      }
      paramString = new FileOutputStream(new File(paramString));
      byte[] arrayOfByte = new byte[8192];
      int i;
      for (long l1 = 0L;; l1 += i)
      {
        i = 0;
        do
        {
          int j = paramInputStream.read(arrayOfByte, i, 8192 - i);
          if (j == -1) {
            break;
          }
          i += j;
        } while (i < 8192);
        paramString.write(arrayOfByte, 0, i);
      }
      long l2 = l1;
      if (i > 0)
      {
        paramString.write(arrayOfByte, 0, i);
        l2 = l1 + i;
      }
      paramString.close();
      return l2;
    }
    return 0L;
  }
  
  /* Error */
  public void execute(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: ldc 155
    //   2: astore 36
    //   4: ldc 157
    //   6: astore 35
    //   8: ldc 159
    //   10: astore 26
    //   12: ldc 161
    //   14: astore 25
    //   16: ldc 163
    //   18: astore 24
    //   20: ldc 165
    //   22: astore 31
    //   24: ldc 167
    //   26: astore 29
    //   28: ldc 169
    //   30: astore 27
    //   32: ldc 171
    //   34: astore 28
    //   36: iconst_2
    //   37: anewarray 173	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_2
    //   50: aastore
    //   51: invokestatic 183	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:generateRandomId	([Ljava/lang/Object;)I
    //   54: istore_3
    //   55: invokestatic 189	com/tencent/component/network/utils/SDCardUtil:isSdCardHasEnoughCapability	()Z
    //   58: istore 7
    //   60: lconst_0
    //   61: lstore 8
    //   63: aload_1
    //   64: invokeinterface 194 1 0
    //   69: ifeq +4 -> 73
    //   72: return
    //   73: aload_0
    //   74: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   77: invokestatic 204	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   80: ifne +42 -> 122
    //   83: aload_0
    //   84: invokevirtual 208	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   87: aload_0
    //   88: invokevirtual 211	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   91: iconst_1
    //   92: isub
    //   93: if_icmpne +13 -> 106
    //   96: aload_2
    //   97: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   100: bipush 6
    //   102: invokevirtual 223	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   105: return
    //   106: ldc2_w 224
    //   109: invokestatic 231	java/lang/Thread:sleep	(J)V
    //   112: goto +10 -> 122
    //   115: ldc 233
    //   117: ldc 235
    //   119: invokestatic 241	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: iload 7
    //   124: ifne +12 -> 136
    //   127: aload_2
    //   128: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   131: iconst_2
    //   132: invokevirtual 223	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   135: return
    //   136: aload_0
    //   137: invokespecial 243	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:reset	()V
    //   140: aload_2
    //   141: invokevirtual 244	com/tencent/component/network/downloader/DownloadResult:reset	()V
    //   144: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   147: lstore 18
    //   149: new 246	com/tencent/component/network/downloader/DownloadReport
    //   152: dup
    //   153: invokespecial 248	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   156: astore 30
    //   158: aload 30
    //   160: iload_3
    //   161: putfield 252	com/tencent/component/network/downloader/DownloadReport:id	I
    //   164: aload 30
    //   166: aload_0
    //   167: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   170: putfield 255	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   173: aload 30
    //   175: aload_0
    //   176: invokevirtual 258	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   179: putfield 261	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   182: aload 31
    //   184: astore 33
    //   186: aload 30
    //   188: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   191: putfield 269	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   194: aload 30
    //   196: aload_0
    //   197: invokevirtual 208	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   200: putfield 272	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   203: new 274	okhttp3/Request$Builder
    //   206: dup
    //   207: invokespecial 275	okhttp3/Request$Builder:<init>	()V
    //   210: aload_0
    //   211: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   214: invokevirtual 278	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   217: astore 32
    //   219: aload_0
    //   220: getfield 282	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mHttpParams	Ljava/util/Map;
    //   223: astore 34
    //   225: iload_3
    //   226: istore 5
    //   228: aload 34
    //   230: ifnull +256 -> 486
    //   233: iload_3
    //   234: istore 4
    //   236: aload_0
    //   237: getfield 282	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mHttpParams	Ljava/util/Map;
    //   240: invokeinterface 288 1 0
    //   245: invokeinterface 294 1 0
    //   250: astore 34
    //   252: iload_3
    //   253: istore 4
    //   255: iload_3
    //   256: istore 5
    //   258: aload 34
    //   260: invokeinterface 299 1 0
    //   265: ifeq +221 -> 486
    //   268: iload_3
    //   269: istore 4
    //   271: aload 34
    //   273: invokeinterface 303 1 0
    //   278: checkcast 305	java/util/Map$Entry
    //   281: astore 38
    //   283: iload_3
    //   284: istore 4
    //   286: aload 38
    //   288: invokeinterface 308 1 0
    //   293: checkcast 310	java/lang/String
    //   296: astore 37
    //   298: iload_3
    //   299: istore 4
    //   301: aload 38
    //   303: invokeinterface 313 1 0
    //   308: astore 38
    //   310: aload 38
    //   312: checkcast 310	java/lang/String
    //   315: astore 38
    //   317: aload 37
    //   319: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   322: ifne +21 -> 343
    //   325: aload 38
    //   327: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   330: ifne +13 -> 343
    //   333: aload 32
    //   335: aload 37
    //   337: aload 38
    //   339: invokevirtual 316	okhttp3/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   342: pop
    //   343: goto -91 -> 252
    //   346: astore 34
    //   348: iload_3
    //   349: istore 4
    //   351: goto +81 -> 432
    //   354: astore 31
    //   356: aload 26
    //   358: astore 38
    //   360: aload 25
    //   362: astore 37
    //   364: aload 27
    //   366: astore 39
    //   368: lconst_0
    //   369: lstore 14
    //   371: lconst_0
    //   372: lstore 10
    //   374: aconst_null
    //   375: astore 26
    //   377: aload 29
    //   379: astore 25
    //   381: lload 8
    //   383: lstore 12
    //   385: aload 33
    //   387: astore 32
    //   389: aload 28
    //   391: astore 34
    //   393: aload 31
    //   395: astore 27
    //   397: aload 26
    //   399: astore 31
    //   401: aload 24
    //   403: astore 26
    //   405: aload 38
    //   407: astore 29
    //   409: lload 14
    //   411: lstore 8
    //   413: aload 39
    //   415: astore 28
    //   417: aload 30
    //   419: astore 24
    //   421: iconst_0
    //   422: istore_3
    //   423: aload 37
    //   425: astore 30
    //   427: goto +11422 -> 11849
    //   430: astore 34
    //   432: aload 26
    //   434: astore 31
    //   436: lconst_0
    //   437: lstore 10
    //   439: iconst_0
    //   440: istore_3
    //   441: aconst_null
    //   442: astore 37
    //   444: lconst_0
    //   445: lstore 12
    //   447: aload 28
    //   449: astore 32
    //   451: aload 27
    //   453: astore 28
    //   455: aload 29
    //   457: astore 27
    //   459: aload 25
    //   461: astore 26
    //   463: aload 31
    //   465: astore 29
    //   467: aload 24
    //   469: astore 25
    //   471: aload 37
    //   473: astore 31
    //   475: aload 32
    //   477: astore 24
    //   479: aload 33
    //   481: astore 32
    //   483: goto +8793 -> 9276
    //   486: iload 5
    //   488: istore 4
    //   490: aload 32
    //   492: ldc_w 318
    //   495: invokevirtual 321	okhttp3/Request$Builder:removeHeader	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   498: pop
    //   499: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   502: lstore 12
    //   504: lload 12
    //   506: lload 18
    //   508: lsub
    //   509: lstore 10
    //   511: aload_0
    //   512: getfield 32	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pokHttpClient	Lokhttp3/OkHttpClient;
    //   515: aload 32
    //   517: invokevirtual 324	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   520: invokevirtual 328	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   523: invokeinterface 332 1 0
    //   528: astore 32
    //   530: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   533: lstore 8
    //   535: lload 8
    //   537: lload 12
    //   539: lsub
    //   540: lstore 12
    //   542: aload_0
    //   543: aload 32
    //   545: invokevirtual 336	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:headerCallback	(Lokhttp3/Response;)V
    //   548: aload 32
    //   550: ifnull +2836 -> 3386
    //   553: aload 32
    //   555: invokevirtual 339	okhttp3/Response:isSuccessful	()Z
    //   558: ifeq +2828 -> 3386
    //   561: aload 32
    //   563: invokevirtual 93	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   566: astore 34
    //   568: aload 34
    //   570: ifnull +2816 -> 3386
    //   573: aload_0
    //   574: aload_0
    //   575: aload 32
    //   577: invokespecial 341	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:parseContentLength	(Lokhttp3/Response;)J
    //   580: putfield 344	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContentLength	J
    //   583: aload_2
    //   584: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   587: aload_0
    //   588: getfield 344	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContentLength	J
    //   591: putfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   594: aload_0
    //   595: aload_0
    //   596: getfield 344	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContentLength	J
    //   599: invokevirtual 357	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getSavePath	(J)Ljava/lang/String;
    //   602: astore 39
    //   604: aload 39
    //   606: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   609: istore 6
    //   611: iload 6
    //   613: ifeq +2356 -> 2969
    //   616: aload_2
    //   617: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   620: iconst_2
    //   621: invokevirtual 223	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   624: new 359	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   631: astore 34
    //   633: aload 34
    //   635: ldc_w 362
    //   638: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: pop
    //   642: aload 34
    //   644: aload_0
    //   645: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   648: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: ldc 233
    //   654: aload 34
    //   656: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 372	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: aload_2
    //   663: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   666: lload 18
    //   668: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   671: invokevirtual 382	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   674: aload_2
    //   675: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   678: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   681: aload_0
    //   682: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   685: lsub
    //   686: putfield 385	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   689: aload_2
    //   690: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   693: aload_0
    //   694: getfield 388	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTaskStartTimeStamp	J
    //   697: putfield 391	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   700: aload_0
    //   701: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   704: invokestatic 397	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   707: invokevirtual 401	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   710: astore 38
    //   712: aload_0
    //   713: getfield 83	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mRemoteAddress	Ljava/lang/String;
    //   716: astore 40
    //   718: aload_0
    //   719: aconst_null
    //   720: aconst_null
    //   721: aload 32
    //   723: invokevirtual 405	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   726: astore 39
    //   728: aload_0
    //   729: getfield 73	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsEnd	J
    //   732: aload_0
    //   733: getfield 70	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsStart	J
    //   736: lsub
    //   737: lstore 8
    //   739: aload 32
    //   741: ifnull +27 -> 768
    //   744: aload 32
    //   746: invokevirtual 408	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   749: ifnull +19 -> 768
    //   752: aload 32
    //   754: invokevirtual 408	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   757: ldc_w 410
    //   760: invokevirtual 108	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   763: astore 34
    //   765: goto +6 -> 771
    //   768: aconst_null
    //   769: astore 34
    //   771: aload_2
    //   772: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   775: aload 34
    //   777: putfield 413	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   780: aload_0
    //   781: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   784: astore 37
    //   786: aload_1
    //   787: invokeinterface 194 1 0
    //   792: ifne +10968 -> 11760
    //   795: aload_0
    //   796: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   799: invokestatic 204	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   802: istore 6
    //   804: aload_2
    //   805: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   808: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   811: ifne +754 -> 1565
    //   814: new 359	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   821: astore 41
    //   823: aload 41
    //   825: ldc_w 418
    //   828: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload 41
    //   834: aload_0
    //   835: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   838: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload 41
    //   844: aload 35
    //   846: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: pop
    //   850: aload 41
    //   852: aload_0
    //   853: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   856: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: aload 41
    //   862: aload 36
    //   864: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: pop
    //   868: aload_0
    //   869: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   872: ifeq +29 -> 901
    //   875: aload 32
    //   877: ifnull +24 -> 901
    //   880: aload 32
    //   882: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   885: ifnull +16 -> 901
    //   888: aload 32
    //   890: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   893: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   896: astore 35
    //   898: goto +8 -> 906
    //   901: ldc_w 434
    //   904: astore 35
    //   906: aload 41
    //   908: aload 35
    //   910: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: pop
    //   914: aload 41
    //   916: ldc_w 436
    //   919: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload 41
    //   925: aload 38
    //   927: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: aload 41
    //   933: ldc_w 441
    //   936: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: pop
    //   940: aload 41
    //   942: aload 40
    //   944: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: pop
    //   948: aload 41
    //   950: ldc_w 443
    //   953: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: pop
    //   957: aload 41
    //   959: aconst_null
    //   960: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: pop
    //   964: aload 41
    //   966: ldc_w 445
    //   969: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: pop
    //   973: aload 41
    //   975: invokestatic 449	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   978: invokevirtual 452	java/lang/Thread:getId	()J
    //   981: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: aload 41
    //   987: ldc_w 457
    //   990: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: pop
    //   994: aload 41
    //   996: invokestatic 462	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   999: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: aload 41
    //   1005: ldc_w 464
    //   1008: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: pop
    //   1012: aload 41
    //   1014: iload 6
    //   1016: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1019: pop
    //   1020: aload 41
    //   1022: ldc_w 466
    //   1025: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: pop
    //   1029: aload 41
    //   1031: invokestatic 471	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   1034: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1037: pop
    //   1038: aload 41
    //   1040: aload 25
    //   1042: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: pop
    //   1046: aload 41
    //   1048: aload_2
    //   1049: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1052: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1055: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: pop
    //   1059: aload 41
    //   1061: aload 27
    //   1063: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: aload 41
    //   1069: aload_2
    //   1070: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1073: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1076: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1079: pop
    //   1080: aload 41
    //   1082: aload 29
    //   1084: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: pop
    //   1088: aload 41
    //   1090: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   1093: aload_0
    //   1094: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   1097: lsub
    //   1098: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload 41
    //   1104: ldc_w 482
    //   1107: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: pop
    //   1111: aload 41
    //   1113: aload_2
    //   1114: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1117: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   1120: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1123: pop
    //   1124: aload 41
    //   1126: aload 33
    //   1128: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: pop
    //   1132: aload 41
    //   1134: aload_2
    //   1135: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1138: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1141: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1144: pop
    //   1145: aload 41
    //   1147: ldc_w 487
    //   1150: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: pop
    //   1154: aload 41
    //   1156: aload_2
    //   1157: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1160: getfield 490	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   1163: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1166: pop
    //   1167: aload 41
    //   1169: ldc_w 492
    //   1172: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: pop
    //   1176: aload 41
    //   1178: aload_0
    //   1179: invokevirtual 208	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   1182: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: aload 41
    //   1188: aload 28
    //   1190: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: pop
    //   1194: aload 41
    //   1196: aload_0
    //   1197: invokevirtual 211	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   1200: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1203: pop
    //   1204: aload 41
    //   1206: ldc_w 494
    //   1209: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: pop
    //   1213: aload 41
    //   1215: aload_2
    //   1216: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1219: invokevirtual 497	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   1222: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1225: pop
    //   1226: aload 41
    //   1228: ldc_w 499
    //   1231: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: pop
    //   1235: aload 41
    //   1237: iconst_0
    //   1238: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1241: pop
    //   1242: aload 41
    //   1244: aload 24
    //   1246: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: pop
    //   1250: aload 41
    //   1252: aload 39
    //   1254: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: pop
    //   1258: aload 41
    //   1260: aload 26
    //   1262: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: pop
    //   1266: aload 41
    //   1268: aload 34
    //   1270: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: pop
    //   1274: aload 41
    //   1276: ldc_w 501
    //   1279: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: pop
    //   1283: aload 41
    //   1285: aload_0
    //   1286: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   1289: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: pop
    //   1293: aload 41
    //   1295: ldc_w 503
    //   1298: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: pop
    //   1302: aload 41
    //   1304: aload_2
    //   1305: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1308: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1311: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: pop
    //   1315: aload 41
    //   1317: ldc_w 508
    //   1320: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: pop
    //   1324: aload 41
    //   1326: lload 8
    //   1328: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1331: pop
    //   1332: aload 41
    //   1334: ldc_w 510
    //   1337: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: pop
    //   1341: aload 41
    //   1343: lload 12
    //   1345: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: aload 41
    //   1351: aload 28
    //   1353: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: pop
    //   1357: aload 41
    //   1359: iconst_0
    //   1360: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1363: pop
    //   1364: aload 41
    //   1366: ldc_w 512
    //   1369: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: pop
    //   1373: aload 41
    //   1375: lconst_0
    //   1376: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1379: pop
    //   1380: aload 41
    //   1382: aload 28
    //   1384: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: pop
    //   1388: aload 41
    //   1390: iconst_0
    //   1391: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1394: pop
    //   1395: aload 41
    //   1397: ldc_w 514
    //   1400: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: pop
    //   1404: aload 41
    //   1406: lload 12
    //   1408: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1411: pop
    //   1412: aload 41
    //   1414: ldc_w 516
    //   1417: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: pop
    //   1421: aload 41
    //   1423: aload_0
    //   1424: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   1427: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1430: pop
    //   1431: aload 41
    //   1433: ldc_w 521
    //   1436: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: aload 41
    //   1442: aload_0
    //   1443: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   1446: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1449: pop
    //   1450: aload 41
    //   1452: ldc_w 526
    //   1455: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: pop
    //   1459: aload_0
    //   1460: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1463: ifnull +17 -> 1480
    //   1466: aload_0
    //   1467: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1470: invokeinterface 536 1 0
    //   1475: astore 28
    //   1477: goto +6 -> 1483
    //   1480: aconst_null
    //   1481: astore 28
    //   1483: aload 41
    //   1485: aload 28
    //   1487: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1490: pop
    //   1491: aload 41
    //   1493: ldc_w 538
    //   1496: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: pop
    //   1500: aload 41
    //   1502: aload_2
    //   1503: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1506: getfield 541	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   1509: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1512: pop
    //   1513: aload 30
    //   1515: aload 41
    //   1517: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1520: putfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1523: ldc_w 546
    //   1526: aload 30
    //   1528: getfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1531: aconst_null
    //   1532: invokestatic 549	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1535: aload 37
    //   1537: ifnull +25 -> 1562
    //   1540: aload 37
    //   1542: ldc_w 551
    //   1545: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1548: ifeq +11 -> 1559
    //   1551: aload_0
    //   1552: invokevirtual 258	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   1555: iconst_0
    //   1556: invokestatic 561	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   1559: goto +3 -> 1562
    //   1562: goto +697 -> 2259
    //   1565: new 359	java/lang/StringBuilder
    //   1568: dup
    //   1569: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   1572: astore 41
    //   1574: aload 41
    //   1576: ldc_w 563
    //   1579: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: pop
    //   1583: aload 41
    //   1585: aload_0
    //   1586: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   1589: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1592: pop
    //   1593: aload 41
    //   1595: aload 35
    //   1597: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: pop
    //   1601: aload 41
    //   1603: aload_0
    //   1604: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   1607: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1610: pop
    //   1611: aload 41
    //   1613: aload 36
    //   1615: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1618: pop
    //   1619: aload_0
    //   1620: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   1623: ifeq +29 -> 1652
    //   1626: aload 32
    //   1628: ifnull +24 -> 1652
    //   1631: aload 32
    //   1633: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1636: ifnull +16 -> 1652
    //   1639: aload 32
    //   1641: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1644: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   1647: astore 35
    //   1649: goto +8 -> 1657
    //   1652: ldc_w 434
    //   1655: astore 35
    //   1657: aload 41
    //   1659: aload 35
    //   1661: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: pop
    //   1665: aload 41
    //   1667: ldc_w 436
    //   1670: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1673: pop
    //   1674: aload 41
    //   1676: aload 38
    //   1678: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1681: pop
    //   1682: aload 41
    //   1684: ldc_w 441
    //   1687: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1690: pop
    //   1691: aload 41
    //   1693: aload 40
    //   1695: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: pop
    //   1699: aload 41
    //   1701: ldc_w 443
    //   1704: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: pop
    //   1708: aload 41
    //   1710: aconst_null
    //   1711: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1714: pop
    //   1715: aload 41
    //   1717: ldc_w 445
    //   1720: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1723: pop
    //   1724: aload 41
    //   1726: invokestatic 449	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1729: invokevirtual 452	java/lang/Thread:getId	()J
    //   1732: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1735: pop
    //   1736: aload 41
    //   1738: ldc_w 457
    //   1741: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: pop
    //   1745: aload 41
    //   1747: invokestatic 462	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1750: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1753: pop
    //   1754: aload 41
    //   1756: ldc_w 466
    //   1759: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1762: pop
    //   1763: aload 41
    //   1765: invokestatic 471	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   1768: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1771: pop
    //   1772: aload 41
    //   1774: aload 27
    //   1776: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1779: pop
    //   1780: aload 41
    //   1782: aload_2
    //   1783: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1786: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1789: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1792: pop
    //   1793: aload 41
    //   1795: aload 29
    //   1797: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1800: pop
    //   1801: aload 41
    //   1803: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   1806: aload_0
    //   1807: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   1810: lsub
    //   1811: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1814: pop
    //   1815: aload 41
    //   1817: ldc_w 482
    //   1820: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1823: pop
    //   1824: aload 41
    //   1826: aload_2
    //   1827: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1830: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   1833: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1836: pop
    //   1837: aload 41
    //   1839: aload 33
    //   1841: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: pop
    //   1845: aload 41
    //   1847: aload_2
    //   1848: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1851: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1854: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1857: pop
    //   1858: aload 41
    //   1860: ldc_w 487
    //   1863: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: pop
    //   1867: aload 41
    //   1869: aload_2
    //   1870: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1873: getfield 490	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   1876: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1879: pop
    //   1880: aload 41
    //   1882: ldc_w 492
    //   1885: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1888: pop
    //   1889: aload 41
    //   1891: aload_0
    //   1892: invokevirtual 208	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   1895: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1898: pop
    //   1899: aload 41
    //   1901: aload 28
    //   1903: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1906: pop
    //   1907: aload 41
    //   1909: aload_0
    //   1910: invokevirtual 211	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   1913: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1916: pop
    //   1917: aload 41
    //   1919: ldc_w 565
    //   1922: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1925: pop
    //   1926: aload 41
    //   1928: iconst_0
    //   1929: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1932: pop
    //   1933: aload 41
    //   1935: aload 24
    //   1937: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1940: pop
    //   1941: aload 41
    //   1943: aload 39
    //   1945: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: pop
    //   1949: aload 41
    //   1951: aload 25
    //   1953: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1956: pop
    //   1957: aload 41
    //   1959: aload_2
    //   1960: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1963: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1966: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1969: pop
    //   1970: aload 41
    //   1972: aload 26
    //   1974: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1977: pop
    //   1978: aload 41
    //   1980: aload 34
    //   1982: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1985: pop
    //   1986: aload 41
    //   1988: ldc_w 501
    //   1991: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1994: pop
    //   1995: aload 41
    //   1997: aload_0
    //   1998: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   2001: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2004: pop
    //   2005: aload 41
    //   2007: ldc_w 503
    //   2010: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2013: pop
    //   2014: aload 41
    //   2016: aload_2
    //   2017: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2020: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2023: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2026: pop
    //   2027: aload 41
    //   2029: ldc_w 508
    //   2032: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2035: pop
    //   2036: aload 41
    //   2038: lload 8
    //   2040: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2043: pop
    //   2044: aload 41
    //   2046: ldc_w 510
    //   2049: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2052: pop
    //   2053: lload 12
    //   2055: lstore 8
    //   2057: aload 41
    //   2059: lload 8
    //   2061: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2064: pop
    //   2065: aload 41
    //   2067: aload 28
    //   2069: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2072: pop
    //   2073: aload 41
    //   2075: iconst_0
    //   2076: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2079: pop
    //   2080: aload 41
    //   2082: ldc_w 512
    //   2085: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2088: pop
    //   2089: aload 41
    //   2091: lconst_0
    //   2092: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2095: pop
    //   2096: aload 41
    //   2098: aload 28
    //   2100: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2103: pop
    //   2104: aload 41
    //   2106: iconst_0
    //   2107: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2110: pop
    //   2111: aload 41
    //   2113: ldc_w 514
    //   2116: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2119: pop
    //   2120: aload 41
    //   2122: lload 8
    //   2124: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2127: pop
    //   2128: aload 41
    //   2130: ldc_w 516
    //   2133: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2136: pop
    //   2137: aload 41
    //   2139: aload_0
    //   2140: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   2143: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2146: pop
    //   2147: aload 41
    //   2149: ldc_w 521
    //   2152: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2155: pop
    //   2156: aload 41
    //   2158: aload_0
    //   2159: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   2162: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2165: pop
    //   2166: aload 41
    //   2168: ldc_w 526
    //   2171: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2174: pop
    //   2175: aload_0
    //   2176: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2179: ifnull +17 -> 2196
    //   2182: aload_0
    //   2183: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2186: invokeinterface 536 1 0
    //   2191: astore 28
    //   2193: goto +6 -> 2199
    //   2196: aconst_null
    //   2197: astore 28
    //   2199: aload 41
    //   2201: aload 28
    //   2203: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2206: pop
    //   2207: aload 41
    //   2209: ldc_w 538
    //   2212: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2215: pop
    //   2216: aload 41
    //   2218: aload_2
    //   2219: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2222: getfield 541	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   2225: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2228: pop
    //   2229: aload 41
    //   2231: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2234: astore 33
    //   2236: aload 30
    //   2238: astore 28
    //   2240: aload 28
    //   2242: aload 33
    //   2244: putfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   2247: ldc_w 546
    //   2250: aload 28
    //   2252: getfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   2255: aconst_null
    //   2256: invokestatic 568	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2259: aload 37
    //   2261: astore 28
    //   2263: iload 6
    //   2265: ifne +8 -> 2273
    //   2268: aload_0
    //   2269: iconst_0
    //   2270: putfield 571	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mShouldReport	Z
    //   2273: aload_2
    //   2274: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2277: astore 33
    //   2279: new 359	java/lang/StringBuilder
    //   2282: dup
    //   2283: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   2286: astore 35
    //   2288: aload 35
    //   2290: aload_0
    //   2291: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   2294: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2297: pop
    //   2298: aload 35
    //   2300: ldc_w 573
    //   2303: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2306: pop
    //   2307: aload 35
    //   2309: aload 40
    //   2311: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2314: pop
    //   2315: aload 35
    //   2317: ldc_w 575
    //   2320: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2323: pop
    //   2324: aload 35
    //   2326: aload_2
    //   2327: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2330: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2333: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2336: pop
    //   2337: aload 35
    //   2339: ldc_w 577
    //   2342: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2345: pop
    //   2346: aload_0
    //   2347: getfield 581	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2350: ifnull +14 -> 2364
    //   2353: aload_0
    //   2354: getfield 581	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2357: getfield 584	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2360: istore_3
    //   2361: goto +5 -> 2366
    //   2364: iconst_0
    //   2365: istore_3
    //   2366: aload 35
    //   2368: iload_3
    //   2369: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2372: pop
    //   2373: aload 35
    //   2375: ldc_w 499
    //   2378: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2381: pop
    //   2382: aload 35
    //   2384: iconst_0
    //   2385: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2388: pop
    //   2389: aload 35
    //   2391: aload 25
    //   2393: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2396: pop
    //   2397: aload 35
    //   2399: aload_2
    //   2400: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2403: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2406: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2409: pop
    //   2410: aload 35
    //   2412: ldc_w 482
    //   2415: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2418: pop
    //   2419: aload 35
    //   2421: aload_2
    //   2422: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2425: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2428: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2431: pop
    //   2432: aload 35
    //   2434: aload 31
    //   2436: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2439: pop
    //   2440: aload 35
    //   2442: aload_2
    //   2443: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2446: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2449: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2452: pop
    //   2453: aload 35
    //   2455: aload 27
    //   2457: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2460: pop
    //   2461: aload 35
    //   2463: aload_2
    //   2464: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2467: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2470: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2473: pop
    //   2474: aload 35
    //   2476: aload 29
    //   2478: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2481: pop
    //   2482: aload 35
    //   2484: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   2487: aload_0
    //   2488: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   2491: lsub
    //   2492: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2495: pop
    //   2496: aload 34
    //   2498: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2501: ifne +38 -> 2539
    //   2504: new 359	java/lang/StringBuilder
    //   2507: dup
    //   2508: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   2511: astore 25
    //   2513: aload 25
    //   2515: aload 26
    //   2517: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2520: pop
    //   2521: aload 25
    //   2523: aload 34
    //   2525: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2528: pop
    //   2529: aload 25
    //   2531: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2534: astore 25
    //   2536: goto +8 -> 2544
    //   2539: ldc_w 586
    //   2542: astore 25
    //   2544: aload 35
    //   2546: aload 25
    //   2548: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2551: pop
    //   2552: aload 35
    //   2554: aload 24
    //   2556: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2559: pop
    //   2560: aload 35
    //   2562: aload 39
    //   2564: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2567: pop
    //   2568: aload 33
    //   2570: aload 35
    //   2572: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2575: putfield 589	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   2578: iload 6
    //   2580: ifeq +73 -> 2653
    //   2583: aload_0
    //   2584: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   2587: invokestatic 594	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   2590: astore 25
    //   2592: aload_0
    //   2593: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   2596: astore 26
    //   2598: aload_0
    //   2599: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   2602: ifeq +29 -> 2631
    //   2605: aload 28
    //   2607: astore 24
    //   2609: aload 24
    //   2611: ifnull +20 -> 2631
    //   2614: aload 24
    //   2616: ldc_w 596
    //   2619: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2622: ifeq +9 -> 2631
    //   2625: iconst_1
    //   2626: istore 6
    //   2628: goto +6 -> 2634
    //   2631: iconst_0
    //   2632: istore 6
    //   2634: aload 25
    //   2636: aload 26
    //   2638: iload 6
    //   2640: aload_2
    //   2641: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2644: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2647: invokevirtual 600	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   2650: goto +3 -> 2653
    //   2653: aload 30
    //   2655: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   2658: putfield 603	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   2661: aload 30
    //   2663: aload_0
    //   2664: invokevirtual 606	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getContentLength	()J
    //   2667: putfield 609	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   2670: aload 30
    //   2672: aload 32
    //   2674: putfield 613	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   2677: aload 30
    //   2679: iconst_0
    //   2680: putfield 616	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   2683: aload 30
    //   2685: aconst_null
    //   2686: putfield 620	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   2689: aload 38
    //   2691: ifnonnull +9 -> 2700
    //   2694: aconst_null
    //   2695: astore 24
    //   2697: goto +10 -> 2707
    //   2700: aload 38
    //   2702: invokevirtual 623	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   2705: astore 24
    //   2707: aload 30
    //   2709: aload 24
    //   2711: putfield 626	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   2714: aload 30
    //   2716: aconst_null
    //   2717: putfield 629	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   2720: aload 30
    //   2722: aload_2
    //   2723: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2726: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2729: putfield 630	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   2732: aload 30
    //   2734: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   2737: aload_0
    //   2738: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   2741: lsub
    //   2742: putfield 633	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   2745: aload 30
    //   2747: aload_2
    //   2748: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2751: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2754: putfield 636	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   2757: aload 30
    //   2759: aload 30
    //   2761: getfield 633	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   2764: aload_2
    //   2765: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2768: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2771: lsub
    //   2772: putfield 639	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   2775: aload 30
    //   2777: lload 10
    //   2779: putfield 642	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   2782: aload 30
    //   2784: lload 12
    //   2786: putfield 645	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   2789: aload 30
    //   2791: lload 12
    //   2793: putfield 648	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   2796: aload 30
    //   2798: aload_0
    //   2799: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   2802: putfield 651	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   2805: aload 30
    //   2807: lconst_0
    //   2808: putfield 654	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   2811: aload 30
    //   2813: aload_0
    //   2814: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   2817: putfield 657	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   2820: aload 30
    //   2822: aload_2
    //   2823: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2826: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2829: putfield 660	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   2832: aload 30
    //   2834: aload_0
    //   2835: invokevirtual 258	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   2838: invokestatic 663	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   2841: putfield 665	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   2844: aload 30
    //   2846: aload_0
    //   2847: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   2850: putfield 668	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   2853: aload 28
    //   2855: ifnull +20 -> 2875
    //   2858: aload 28
    //   2860: ldc_w 596
    //   2863: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2866: ifeq +9 -> 2875
    //   2869: iconst_1
    //   2870: istore 6
    //   2872: goto +6 -> 2878
    //   2875: iconst_0
    //   2876: istore 6
    //   2878: aload 30
    //   2880: iload 6
    //   2882: putfield 671	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   2885: aload 30
    //   2887: aload_2
    //   2888: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2891: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2894: putfield 673	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   2897: aload 30
    //   2899: getstatic 679	com/tencent/component/network/downloader/Downloader$DownloadMode:OkHttpMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   2902: invokevirtual 682	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   2905: putfield 685	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   2908: aload 32
    //   2910: ifnull +24 -> 2934
    //   2913: aload 32
    //   2915: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   2918: ifnull +16 -> 2934
    //   2921: aload 30
    //   2923: aload 32
    //   2925: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   2928: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   2931: putfield 687	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   2934: aload_2
    //   2935: aload 30
    //   2937: invokevirtual 691	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   2940: aload_2
    //   2941: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2944: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2947: ifeq +8813 -> 11760
    //   2950: aload_0
    //   2951: aload_1
    //   2952: aload_2
    //   2953: aload 30
    //   2955: invokevirtual 695	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   2958: return
    //   2959: astore 37
    //   2961: goto +121 -> 3082
    //   2964: astore 34
    //   2966: goto +159 -> 3125
    //   2969: aload 27
    //   2971: astore 34
    //   2973: lload 10
    //   2975: lstore 8
    //   2977: aload 24
    //   2979: astore 37
    //   2981: lload 12
    //   2983: lstore 14
    //   2985: aload 26
    //   2987: astore 37
    //   2989: aload 32
    //   2991: astore 37
    //   2993: aload 25
    //   2995: astore 38
    //   2997: aload_2
    //   2998: aload 39
    //   3000: invokevirtual 698	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   3003: aload 37
    //   3005: invokevirtual 93	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   3008: invokevirtual 702	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   3011: astore 37
    //   3013: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   3016: lstore 20
    //   3018: aload_0
    //   3019: aload 37
    //   3021: aload 39
    //   3023: invokespecial 704	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:saveToFile	(Ljava/io/InputStream;Ljava/lang/String;)J
    //   3026: lstore 16
    //   3028: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   3031: lstore 22
    //   3033: aload 28
    //   3035: astore 33
    //   3037: aload_0
    //   3038: lload 22
    //   3040: lload 20
    //   3042: lsub
    //   3043: putfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   3046: aload 37
    //   3048: invokevirtual 705	java/io/InputStream:close	()V
    //   3051: lload 16
    //   3053: lstore 14
    //   3055: goto +334 -> 3389
    //   3058: astore 28
    //   3060: aload 34
    //   3062: astore 27
    //   3064: goto +154 -> 3218
    //   3067: astore 27
    //   3069: aload 34
    //   3071: astore 28
    //   3073: lload 14
    //   3075: lstore 12
    //   3077: goto +252 -> 3329
    //   3080: astore 37
    //   3082: aload 25
    //   3084: astore 33
    //   3086: aload 31
    //   3088: astore 38
    //   3090: iconst_0
    //   3091: istore_3
    //   3092: aload 32
    //   3094: astore 31
    //   3096: aload 29
    //   3098: astore 25
    //   3100: aload 26
    //   3102: astore 29
    //   3104: aload 24
    //   3106: astore 26
    //   3108: aload 28
    //   3110: astore 34
    //   3112: aload 38
    //   3114: astore 32
    //   3116: lload 10
    //   3118: lstore 14
    //   3120: goto +160 -> 3280
    //   3123: astore 34
    //   3125: lload 10
    //   3127: lstore 8
    //   3129: lload 12
    //   3131: lstore 14
    //   3133: aload 31
    //   3135: astore 33
    //   3137: aload 28
    //   3139: astore 37
    //   3141: aload 32
    //   3143: astore 31
    //   3145: iconst_0
    //   3146: istore_3
    //   3147: aload 26
    //   3149: astore 32
    //   3151: lload 12
    //   3153: lstore 10
    //   3155: aload 27
    //   3157: astore 28
    //   3159: aload 29
    //   3161: astore 27
    //   3163: aload 25
    //   3165: astore 26
    //   3167: aload 32
    //   3169: astore 29
    //   3171: aload 24
    //   3173: astore 25
    //   3175: aload 37
    //   3177: astore 24
    //   3179: aload 33
    //   3181: astore 32
    //   3183: lload 14
    //   3185: lstore 12
    //   3187: goto +6089 -> 9276
    //   3190: astore 33
    //   3192: goto +10 -> 3202
    //   3195: astore 34
    //   3197: goto +116 -> 3313
    //   3200: astore 33
    //   3202: aload 33
    //   3204: astore 34
    //   3206: lload 10
    //   3208: lstore 8
    //   3210: aload 28
    //   3212: astore 33
    //   3214: aload 34
    //   3216: astore 28
    //   3218: aload 25
    //   3220: astore 34
    //   3222: aload 24
    //   3224: astore 25
    //   3226: iconst_0
    //   3227: istore_3
    //   3228: aload 26
    //   3230: astore 24
    //   3232: aload 32
    //   3234: astore 26
    //   3236: aload 29
    //   3238: astore 37
    //   3240: aload 34
    //   3242: astore 29
    //   3244: aload 31
    //   3246: astore 32
    //   3248: aload 33
    //   3250: astore 34
    //   3252: aload 26
    //   3254: astore 31
    //   3256: aload 25
    //   3258: astore 26
    //   3260: aload 37
    //   3262: astore 25
    //   3264: lload 8
    //   3266: lstore 14
    //   3268: aload 29
    //   3270: astore 33
    //   3272: aload 28
    //   3274: astore 37
    //   3276: aload 24
    //   3278: astore 29
    //   3280: aload 30
    //   3282: astore 24
    //   3284: lload 12
    //   3286: lstore 8
    //   3288: lload 8
    //   3290: lstore 10
    //   3292: aload 27
    //   3294: astore 28
    //   3296: aload 37
    //   3298: astore 27
    //   3300: aload 33
    //   3302: astore 30
    //   3304: lload 14
    //   3306: lstore 12
    //   3308: goto +8541 -> 11849
    //   3311: astore 34
    //   3313: lload 10
    //   3315: lstore 8
    //   3317: aload 28
    //   3319: astore 33
    //   3321: aload 27
    //   3323: astore 28
    //   3325: aload 34
    //   3327: astore 27
    //   3329: aload 24
    //   3331: astore 37
    //   3333: iconst_0
    //   3334: istore_3
    //   3335: aload 26
    //   3337: astore 34
    //   3339: aload 25
    //   3341: astore 26
    //   3343: aload 32
    //   3345: astore 25
    //   3347: aload 31
    //   3349: astore 32
    //   3351: aload 33
    //   3353: astore 24
    //   3355: aload 25
    //   3357: astore 31
    //   3359: aload 37
    //   3361: astore 25
    //   3363: aload 34
    //   3365: astore 33
    //   3367: lload 12
    //   3369: lstore 10
    //   3371: aload 27
    //   3373: astore 34
    //   3375: aload 29
    //   3377: astore 27
    //   3379: aload 33
    //   3381: astore 29
    //   3383: goto +5893 -> 9276
    //   3386: lconst_0
    //   3387: lstore 14
    //   3389: lload 12
    //   3391: lstore 8
    //   3393: aload 27
    //   3395: astore 34
    //   3397: aload 26
    //   3399: astore 33
    //   3401: aload 25
    //   3403: astore 26
    //   3405: aload 29
    //   3407: astore 27
    //   3409: aload 32
    //   3411: astore 25
    //   3413: aload_2
    //   3414: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3417: lload 14
    //   3419: putfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3422: aload_2
    //   3423: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3426: lload 14
    //   3428: putfield 490	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3431: aload 25
    //   3433: ifnull +2715 -> 6148
    //   3436: aload 25
    //   3438: invokevirtual 708	okhttp3/Response:code	()I
    //   3441: istore_3
    //   3442: aload_2
    //   3443: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3446: aload 25
    //   3448: ldc_w 710
    //   3451: invokevirtual 108	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   3454: putfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3457: aload_2
    //   3458: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3461: aload 25
    //   3463: ldc_w 712
    //   3466: invokevirtual 108	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   3469: putfield 715	com/tencent/component/network/downloader/DownloadResult$Content:encoding	Ljava/lang/String;
    //   3472: aload_2
    //   3473: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3476: iload_3
    //   3477: putfield 718	com/tencent/component/network/downloader/DownloadResult$Content:retCode	I
    //   3480: aload_2
    //   3481: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3484: iload_3
    //   3485: putfield 719	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   3488: aload 25
    //   3490: invokevirtual 102	okhttp3/Response:networkResponse	()Lokhttp3/Response;
    //   3493: astore 32
    //   3495: aload 32
    //   3497: ifnull +10790 -> 14287
    //   3500: aload 25
    //   3502: invokevirtual 102	okhttp3/Response:networkResponse	()Lokhttp3/Response;
    //   3505: ldc_w 712
    //   3508: invokevirtual 108	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   3511: astore 32
    //   3513: ldc_w 721
    //   3516: aload 32
    //   3518: invokevirtual 725	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3521: ifeq +10766 -> 14287
    //   3524: aload_2
    //   3525: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3528: aload 32
    //   3530: putfield 715	com/tencent/component/network/downloader/DownloadResult$Content:encoding	Ljava/lang/String;
    //   3533: aload_2
    //   3534: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3537: iconst_1
    //   3538: putfield 541	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   3541: goto +10746 -> 14287
    //   3544: aload_0
    //   3545: getfield 729	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3548: ifnull +10756 -> 14304
    //   3551: aload_0
    //   3552: getfield 729	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3555: aload_0
    //   3556: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   3559: iconst_1
    //   3560: invokeinterface 734 3 0
    //   3565: goto +3 -> 3568
    //   3568: aload_2
    //   3569: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3572: iload_3
    //   3573: invokevirtual 223	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   3576: goto +2626 -> 6202
    //   3579: aload_2
    //   3580: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3583: invokevirtual 737	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   3586: aload_2
    //   3587: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3590: lload 18
    //   3592: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   3595: invokevirtual 382	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   3598: aload_2
    //   3599: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3602: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   3605: aload_0
    //   3606: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   3609: lsub
    //   3610: putfield 385	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   3613: aload_2
    //   3614: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3617: aload_0
    //   3618: getfield 388	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTaskStartTimeStamp	J
    //   3621: putfield 391	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   3624: aload_0
    //   3625: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   3628: invokestatic 397	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   3631: invokevirtual 401	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3634: astore 38
    //   3636: aload_0
    //   3637: getfield 83	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mRemoteAddress	Ljava/lang/String;
    //   3640: astore 40
    //   3642: aload_0
    //   3643: aconst_null
    //   3644: aconst_null
    //   3645: aload 25
    //   3647: invokevirtual 405	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   3650: astore 39
    //   3652: aload_0
    //   3653: getfield 73	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsEnd	J
    //   3656: aload_0
    //   3657: getfield 70	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsStart	J
    //   3660: lsub
    //   3661: lstore 12
    //   3663: aload 25
    //   3665: ifnull +27 -> 3692
    //   3668: aload 25
    //   3670: invokevirtual 408	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   3673: ifnull +19 -> 3692
    //   3676: aload 25
    //   3678: invokevirtual 408	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   3681: ldc_w 410
    //   3684: invokevirtual 108	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   3687: astore 29
    //   3689: goto +6 -> 3695
    //   3692: aconst_null
    //   3693: astore 29
    //   3695: aload_2
    //   3696: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3699: aload 29
    //   3701: putfield 413	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   3704: aload_0
    //   3705: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   3708: astore 32
    //   3710: aload_1
    //   3711: invokeinterface 194 1 0
    //   3716: ifne +8044 -> 11760
    //   3719: aload 32
    //   3721: astore 37
    //   3723: aload_0
    //   3724: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   3727: invokestatic 204	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3730: istore 6
    //   3732: aload_2
    //   3733: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3736: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3739: ifne +758 -> 4497
    //   3742: new 359	java/lang/StringBuilder
    //   3745: dup
    //   3746: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   3749: astore 41
    //   3751: aload 41
    //   3753: ldc_w 418
    //   3756: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3759: pop
    //   3760: aload 41
    //   3762: aload_0
    //   3763: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   3766: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3769: pop
    //   3770: aload 41
    //   3772: aload 35
    //   3774: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3777: pop
    //   3778: aload 41
    //   3780: aload_0
    //   3781: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   3784: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3787: pop
    //   3788: aload 41
    //   3790: aload 36
    //   3792: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3795: pop
    //   3796: aload_0
    //   3797: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   3800: ifeq +29 -> 3829
    //   3803: aload 25
    //   3805: ifnull +24 -> 3829
    //   3808: aload 25
    //   3810: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3813: ifnull +16 -> 3829
    //   3816: aload 25
    //   3818: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3821: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3824: astore 35
    //   3826: goto +8 -> 3834
    //   3829: ldc_w 434
    //   3832: astore 35
    //   3834: aload 41
    //   3836: aload 35
    //   3838: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3841: pop
    //   3842: aload 41
    //   3844: ldc_w 436
    //   3847: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3850: pop
    //   3851: aload 41
    //   3853: aload 38
    //   3855: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3858: pop
    //   3859: aload 41
    //   3861: ldc_w 441
    //   3864: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3867: pop
    //   3868: aload 41
    //   3870: aload 40
    //   3872: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3875: pop
    //   3876: aload 41
    //   3878: ldc_w 443
    //   3881: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3884: pop
    //   3885: aload 41
    //   3887: aconst_null
    //   3888: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3891: pop
    //   3892: aload 41
    //   3894: ldc_w 445
    //   3897: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3900: pop
    //   3901: aload 41
    //   3903: invokestatic 449	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3906: invokevirtual 452	java/lang/Thread:getId	()J
    //   3909: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3912: pop
    //   3913: aload 41
    //   3915: ldc_w 457
    //   3918: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3921: pop
    //   3922: aload 41
    //   3924: invokestatic 462	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3927: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3930: pop
    //   3931: aload 41
    //   3933: ldc_w 464
    //   3936: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3939: pop
    //   3940: aload 41
    //   3942: iload 6
    //   3944: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3947: pop
    //   3948: aload 41
    //   3950: ldc_w 466
    //   3953: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3956: pop
    //   3957: aload 41
    //   3959: invokestatic 471	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3962: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3965: pop
    //   3966: aload 41
    //   3968: aload 26
    //   3970: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3973: pop
    //   3974: aload 41
    //   3976: aload_2
    //   3977: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3980: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3983: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3986: pop
    //   3987: aload 41
    //   3989: aload 34
    //   3991: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3994: pop
    //   3995: aload 41
    //   3997: aload_2
    //   3998: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4001: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4004: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4007: pop
    //   4008: aload 41
    //   4010: aload 27
    //   4012: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4015: pop
    //   4016: aload 41
    //   4018: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   4021: aload_0
    //   4022: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   4025: lsub
    //   4026: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4029: pop
    //   4030: aload 41
    //   4032: ldc_w 482
    //   4035: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4038: pop
    //   4039: aload 41
    //   4041: aload_2
    //   4042: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4045: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4048: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4051: pop
    //   4052: aload 41
    //   4054: aload 31
    //   4056: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4059: pop
    //   4060: aload 41
    //   4062: aload_2
    //   4063: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4066: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4069: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4072: pop
    //   4073: aload 41
    //   4075: ldc_w 487
    //   4078: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4081: pop
    //   4082: aload 41
    //   4084: aload_2
    //   4085: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4088: getfield 490	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4091: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4094: pop
    //   4095: aload 41
    //   4097: ldc_w 492
    //   4100: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4103: pop
    //   4104: aload 41
    //   4106: aload_0
    //   4107: invokevirtual 208	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   4110: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4113: pop
    //   4114: aload 41
    //   4116: aload 28
    //   4118: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4121: pop
    //   4122: aload 41
    //   4124: aload_0
    //   4125: invokevirtual 211	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   4128: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4131: pop
    //   4132: aload 41
    //   4134: ldc_w 494
    //   4137: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4140: pop
    //   4141: aload 41
    //   4143: aload_2
    //   4144: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4147: invokevirtual 497	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   4150: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4153: pop
    //   4154: aload 41
    //   4156: ldc_w 499
    //   4159: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4162: pop
    //   4163: aload 41
    //   4165: iload_3
    //   4166: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4169: pop
    //   4170: aload 41
    //   4172: aload 24
    //   4174: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4177: pop
    //   4178: aload 41
    //   4180: aload 39
    //   4182: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4185: pop
    //   4186: aload 41
    //   4188: aload 33
    //   4190: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4193: pop
    //   4194: aload 41
    //   4196: aload 29
    //   4198: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4201: pop
    //   4202: aload 41
    //   4204: ldc_w 501
    //   4207: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4210: pop
    //   4211: aload 41
    //   4213: aload_0
    //   4214: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   4217: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4220: pop
    //   4221: aload 41
    //   4223: ldc_w 503
    //   4226: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4229: pop
    //   4230: aload 41
    //   4232: aload_2
    //   4233: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4236: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4239: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4242: pop
    //   4243: aload 41
    //   4245: ldc_w 508
    //   4248: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4251: pop
    //   4252: aload 41
    //   4254: lload 12
    //   4256: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4259: pop
    //   4260: aload 41
    //   4262: ldc_w 510
    //   4265: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4268: pop
    //   4269: lload 8
    //   4271: lstore 12
    //   4273: aload 41
    //   4275: lload 12
    //   4277: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4280: pop
    //   4281: aload 41
    //   4283: aload 28
    //   4285: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4288: pop
    //   4289: aload 41
    //   4291: iconst_0
    //   4292: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4295: pop
    //   4296: aload 41
    //   4298: ldc_w 512
    //   4301: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4304: pop
    //   4305: aload 41
    //   4307: lconst_0
    //   4308: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4311: pop
    //   4312: aload 41
    //   4314: aload 28
    //   4316: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4319: pop
    //   4320: aload 41
    //   4322: iconst_0
    //   4323: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4326: pop
    //   4327: aload 41
    //   4329: ldc_w 514
    //   4332: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4335: pop
    //   4336: aload 41
    //   4338: lload 12
    //   4340: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4343: pop
    //   4344: aload 41
    //   4346: ldc_w 516
    //   4349: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4352: pop
    //   4353: aload 41
    //   4355: aload_0
    //   4356: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   4359: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4362: pop
    //   4363: aload 41
    //   4365: ldc_w 521
    //   4368: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4371: pop
    //   4372: aload 41
    //   4374: aload_0
    //   4375: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   4378: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4381: pop
    //   4382: aload 41
    //   4384: ldc_w 526
    //   4387: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4390: pop
    //   4391: aload_0
    //   4392: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4395: ifnull +17 -> 4412
    //   4398: aload_0
    //   4399: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4402: invokeinterface 536 1 0
    //   4407: astore 28
    //   4409: goto +6 -> 4415
    //   4412: aconst_null
    //   4413: astore 28
    //   4415: aload 41
    //   4417: aload 28
    //   4419: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4422: pop
    //   4423: aload 41
    //   4425: ldc_w 538
    //   4428: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4431: pop
    //   4432: aload 41
    //   4434: aload_2
    //   4435: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4438: getfield 541	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   4441: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4444: pop
    //   4445: aload 30
    //   4447: aload 41
    //   4449: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4452: putfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4455: ldc_w 546
    //   4458: aload 30
    //   4460: getfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4463: aconst_null
    //   4464: invokestatic 549	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4467: aload 37
    //   4469: ifnull +25 -> 4494
    //   4472: aload 37
    //   4474: ldc_w 551
    //   4477: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4480: ifeq +11 -> 4491
    //   4483: aload_0
    //   4484: invokevirtual 258	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   4487: iconst_0
    //   4488: invokestatic 561	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   4491: goto +704 -> 5195
    //   4494: goto +701 -> 5195
    //   4497: aload 25
    //   4499: astore 37
    //   4501: new 359	java/lang/StringBuilder
    //   4504: dup
    //   4505: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   4508: astore 41
    //   4510: aload 41
    //   4512: ldc_w 563
    //   4515: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4518: pop
    //   4519: aload 41
    //   4521: aload_0
    //   4522: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   4525: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4528: pop
    //   4529: aload 41
    //   4531: aload 35
    //   4533: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4536: pop
    //   4537: aload 41
    //   4539: aload_0
    //   4540: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   4543: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4546: pop
    //   4547: aload 41
    //   4549: aload 36
    //   4551: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4554: pop
    //   4555: aload_0
    //   4556: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   4559: ifeq +29 -> 4588
    //   4562: aload 37
    //   4564: ifnull +24 -> 4588
    //   4567: aload 37
    //   4569: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4572: ifnull +16 -> 4588
    //   4575: aload 37
    //   4577: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4580: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   4583: astore 35
    //   4585: goto +8 -> 4593
    //   4588: ldc_w 434
    //   4591: astore 35
    //   4593: aload 41
    //   4595: aload 35
    //   4597: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4600: pop
    //   4601: aload 41
    //   4603: ldc_w 436
    //   4606: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4609: pop
    //   4610: aload 41
    //   4612: aload 38
    //   4614: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4617: pop
    //   4618: aload 41
    //   4620: ldc_w 441
    //   4623: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4626: pop
    //   4627: aload 41
    //   4629: aload 40
    //   4631: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4634: pop
    //   4635: aload 41
    //   4637: ldc_w 443
    //   4640: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4643: pop
    //   4644: aload 41
    //   4646: aconst_null
    //   4647: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4650: pop
    //   4651: aload 41
    //   4653: ldc_w 445
    //   4656: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4659: pop
    //   4660: aload 41
    //   4662: invokestatic 449	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4665: invokevirtual 452	java/lang/Thread:getId	()J
    //   4668: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4671: pop
    //   4672: aload 41
    //   4674: ldc_w 457
    //   4677: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4680: pop
    //   4681: aload 41
    //   4683: invokestatic 462	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4686: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4689: pop
    //   4690: aload 41
    //   4692: ldc_w 466
    //   4695: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4698: pop
    //   4699: aload 41
    //   4701: invokestatic 471	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   4704: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4707: pop
    //   4708: aload 41
    //   4710: aload 34
    //   4712: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4715: pop
    //   4716: aload 41
    //   4718: aload_2
    //   4719: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4722: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4725: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4728: pop
    //   4729: aload 41
    //   4731: aload 27
    //   4733: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4736: pop
    //   4737: aload 41
    //   4739: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   4742: aload_0
    //   4743: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   4746: lsub
    //   4747: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4750: pop
    //   4751: aload 41
    //   4753: ldc_w 482
    //   4756: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4759: pop
    //   4760: aload 41
    //   4762: aload_2
    //   4763: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4766: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4769: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4772: pop
    //   4773: aload 41
    //   4775: aload 31
    //   4777: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4780: pop
    //   4781: aload 41
    //   4783: aload_2
    //   4784: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4787: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4790: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4793: pop
    //   4794: aload 41
    //   4796: ldc_w 487
    //   4799: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4802: pop
    //   4803: aload 41
    //   4805: aload_2
    //   4806: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4809: getfield 490	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4812: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4815: pop
    //   4816: aload 41
    //   4818: ldc_w 492
    //   4821: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4824: pop
    //   4825: aload 41
    //   4827: aload_0
    //   4828: invokevirtual 208	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   4831: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4834: pop
    //   4835: aload 41
    //   4837: aload 28
    //   4839: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4842: pop
    //   4843: aload 41
    //   4845: aload_0
    //   4846: invokevirtual 211	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   4849: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4852: pop
    //   4853: aload 41
    //   4855: ldc_w 565
    //   4858: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4861: pop
    //   4862: aload 41
    //   4864: iload_3
    //   4865: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4868: pop
    //   4869: aload 41
    //   4871: aload 24
    //   4873: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4876: pop
    //   4877: aload 41
    //   4879: aload 39
    //   4881: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4884: pop
    //   4885: aload 41
    //   4887: aload 26
    //   4889: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4892: pop
    //   4893: aload 41
    //   4895: aload_2
    //   4896: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4899: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4902: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4905: pop
    //   4906: aload 41
    //   4908: aload 33
    //   4910: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4913: pop
    //   4914: aload 41
    //   4916: aload 29
    //   4918: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4921: pop
    //   4922: aload 41
    //   4924: ldc_w 501
    //   4927: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4930: pop
    //   4931: aload 41
    //   4933: aload_0
    //   4934: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   4937: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4940: pop
    //   4941: aload 41
    //   4943: ldc_w 503
    //   4946: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4949: pop
    //   4950: aload 41
    //   4952: aload_2
    //   4953: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4956: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4959: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4962: pop
    //   4963: aload 41
    //   4965: ldc_w 508
    //   4968: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4971: pop
    //   4972: aload 41
    //   4974: lload 12
    //   4976: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4979: pop
    //   4980: aload 41
    //   4982: ldc_w 510
    //   4985: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4988: pop
    //   4989: lload 8
    //   4991: lstore 12
    //   4993: aload 41
    //   4995: lload 12
    //   4997: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5000: pop
    //   5001: aload 41
    //   5003: aload 28
    //   5005: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5008: pop
    //   5009: aload 41
    //   5011: iconst_0
    //   5012: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5015: pop
    //   5016: aload 41
    //   5018: ldc_w 512
    //   5021: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5024: pop
    //   5025: aload 41
    //   5027: lconst_0
    //   5028: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5031: pop
    //   5032: aload 41
    //   5034: aload 28
    //   5036: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5039: pop
    //   5040: aload 41
    //   5042: iconst_0
    //   5043: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5046: pop
    //   5047: aload 41
    //   5049: ldc_w 514
    //   5052: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5055: pop
    //   5056: aload 41
    //   5058: lload 12
    //   5060: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5063: pop
    //   5064: aload 41
    //   5066: ldc_w 516
    //   5069: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5072: pop
    //   5073: aload 41
    //   5075: aload_0
    //   5076: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   5079: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5082: pop
    //   5083: aload 41
    //   5085: ldc_w 521
    //   5088: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5091: pop
    //   5092: aload 41
    //   5094: aload_0
    //   5095: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   5098: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5101: pop
    //   5102: aload 41
    //   5104: ldc_w 526
    //   5107: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5110: pop
    //   5111: aload_0
    //   5112: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5115: ifnull +17 -> 5132
    //   5118: aload_0
    //   5119: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5122: invokeinterface 536 1 0
    //   5127: astore 28
    //   5129: goto +6 -> 5135
    //   5132: aconst_null
    //   5133: astore 28
    //   5135: aload 41
    //   5137: aload 28
    //   5139: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5142: pop
    //   5143: aload 41
    //   5145: ldc_w 538
    //   5148: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5151: pop
    //   5152: aload 41
    //   5154: aload_2
    //   5155: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5158: getfield 541	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   5161: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5164: pop
    //   5165: aload 41
    //   5167: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5170: astore 35
    //   5172: aload 30
    //   5174: astore 28
    //   5176: aload 28
    //   5178: aload 35
    //   5180: putfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5183: ldc_w 546
    //   5186: aload 28
    //   5188: getfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5191: aconst_null
    //   5192: invokestatic 568	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5195: aload 25
    //   5197: astore 28
    //   5199: iload 6
    //   5201: ifne +8 -> 5209
    //   5204: aload_0
    //   5205: iconst_0
    //   5206: putfield 571	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mShouldReport	Z
    //   5209: aload_2
    //   5210: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5213: astore 35
    //   5215: new 359	java/lang/StringBuilder
    //   5218: dup
    //   5219: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   5222: astore 36
    //   5224: aload 36
    //   5226: aload_0
    //   5227: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   5230: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5233: pop
    //   5234: aload 36
    //   5236: ldc_w 573
    //   5239: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5242: pop
    //   5243: aload 36
    //   5245: aload 40
    //   5247: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5250: pop
    //   5251: aload 36
    //   5253: ldc_w 575
    //   5256: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5259: pop
    //   5260: aload 36
    //   5262: aload_2
    //   5263: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5266: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5269: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5272: pop
    //   5273: aload 36
    //   5275: ldc_w 577
    //   5278: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5281: pop
    //   5282: aload_0
    //   5283: getfield 581	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5286: ifnull +15 -> 5301
    //   5289: aload_0
    //   5290: getfield 581	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5293: getfield 584	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5296: istore 4
    //   5298: goto +6 -> 5304
    //   5301: iconst_0
    //   5302: istore 4
    //   5304: aload 36
    //   5306: iload 4
    //   5308: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5311: pop
    //   5312: aload 36
    //   5314: ldc_w 499
    //   5317: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5320: pop
    //   5321: aload 36
    //   5323: iload_3
    //   5324: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5327: pop
    //   5328: aload 36
    //   5330: aload 26
    //   5332: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5335: pop
    //   5336: aload 36
    //   5338: aload_2
    //   5339: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5342: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5345: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5348: pop
    //   5349: aload 36
    //   5351: ldc_w 482
    //   5354: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5357: pop
    //   5358: aload 36
    //   5360: aload_2
    //   5361: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5364: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5367: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5370: pop
    //   5371: aload 36
    //   5373: aload 31
    //   5375: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5378: pop
    //   5379: aload 36
    //   5381: aload_2
    //   5382: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5385: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5388: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5391: pop
    //   5392: aload 36
    //   5394: aload 34
    //   5396: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5399: pop
    //   5400: aload 36
    //   5402: aload_2
    //   5403: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5406: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5409: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5412: pop
    //   5413: aload 36
    //   5415: aload 27
    //   5417: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5420: pop
    //   5421: aload 36
    //   5423: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   5426: aload_0
    //   5427: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   5430: lsub
    //   5431: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5434: pop
    //   5435: aload 29
    //   5437: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5440: ifne +38 -> 5478
    //   5443: new 359	java/lang/StringBuilder
    //   5446: dup
    //   5447: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   5450: astore 25
    //   5452: aload 25
    //   5454: aload 33
    //   5456: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5459: pop
    //   5460: aload 25
    //   5462: aload 29
    //   5464: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5467: pop
    //   5468: aload 25
    //   5470: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5473: astore 25
    //   5475: goto +8 -> 5483
    //   5478: ldc_w 586
    //   5481: astore 25
    //   5483: aload 36
    //   5485: aload 25
    //   5487: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5490: pop
    //   5491: aload 36
    //   5493: aload 24
    //   5495: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5498: pop
    //   5499: aload 36
    //   5501: aload 39
    //   5503: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5506: pop
    //   5507: aload 35
    //   5509: aload 36
    //   5511: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5514: putfield 589	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   5517: iload 6
    //   5519: ifeq +69 -> 5588
    //   5522: aload_0
    //   5523: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   5526: invokestatic 594	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   5529: astore 24
    //   5531: aload_0
    //   5532: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   5535: astore 25
    //   5537: aload_0
    //   5538: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   5541: ifeq +25 -> 5566
    //   5544: aload 32
    //   5546: ifnull +20 -> 5566
    //   5549: aload 32
    //   5551: ldc_w 596
    //   5554: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5557: ifeq +9 -> 5566
    //   5560: iconst_1
    //   5561: istore 6
    //   5563: goto +6 -> 5569
    //   5566: iconst_0
    //   5567: istore 6
    //   5569: aload 24
    //   5571: aload 25
    //   5573: iload 6
    //   5575: aload_2
    //   5576: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5579: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5582: invokevirtual 600	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   5585: goto +3 -> 5588
    //   5588: aload 30
    //   5590: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   5593: putfield 603	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   5596: aload 30
    //   5598: aload_0
    //   5599: invokevirtual 606	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getContentLength	()J
    //   5602: putfield 609	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   5605: aload 30
    //   5607: aload 28
    //   5609: putfield 613	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   5612: aload 30
    //   5614: iload_3
    //   5615: putfield 616	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   5618: aload 30
    //   5620: aconst_null
    //   5621: putfield 620	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   5624: aload 38
    //   5626: ifnonnull +9 -> 5635
    //   5629: aconst_null
    //   5630: astore 24
    //   5632: goto +10 -> 5642
    //   5635: aload 38
    //   5637: invokevirtual 623	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   5640: astore 24
    //   5642: aload 30
    //   5644: aload 24
    //   5646: putfield 626	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   5649: aload 30
    //   5651: aconst_null
    //   5652: putfield 629	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   5655: aload 30
    //   5657: aload_2
    //   5658: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5661: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5664: putfield 630	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   5667: aload 30
    //   5669: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   5672: aload_0
    //   5673: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   5676: lsub
    //   5677: putfield 633	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5680: aload 30
    //   5682: aload_2
    //   5683: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5686: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5689: putfield 636	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   5692: aload 30
    //   5694: aload 30
    //   5696: getfield 633	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5699: aload_2
    //   5700: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5703: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5706: lsub
    //   5707: putfield 639	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   5710: aload 30
    //   5712: lload 10
    //   5714: putfield 642	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   5717: aload 30
    //   5719: lload 8
    //   5721: putfield 645	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   5724: aload 30
    //   5726: lload 8
    //   5728: putfield 648	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   5731: aload 30
    //   5733: aload_0
    //   5734: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   5737: putfield 651	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   5740: aload 30
    //   5742: lconst_0
    //   5743: putfield 654	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   5746: aload 30
    //   5748: aload_0
    //   5749: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   5752: putfield 657	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   5755: aload 30
    //   5757: aload_2
    //   5758: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5761: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5764: putfield 660	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   5767: aload 30
    //   5769: aload_0
    //   5770: invokevirtual 258	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   5773: invokestatic 663	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   5776: putfield 665	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   5779: aload 30
    //   5781: aload_0
    //   5782: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   5785: putfield 668	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   5788: aload 32
    //   5790: ifnull +20 -> 5810
    //   5793: aload 32
    //   5795: ldc_w 596
    //   5798: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5801: ifeq +9 -> 5810
    //   5804: iconst_1
    //   5805: istore 6
    //   5807: goto +6 -> 5813
    //   5810: iconst_0
    //   5811: istore 6
    //   5813: aload 30
    //   5815: iload 6
    //   5817: putfield 671	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   5820: aload 30
    //   5822: aload_2
    //   5823: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5826: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5829: putfield 673	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   5832: aload 30
    //   5834: getstatic 679	com/tencent/component/network/downloader/Downloader$DownloadMode:OkHttpMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   5837: invokevirtual 682	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   5840: putfield 685	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   5843: aload 28
    //   5845: ifnull +24 -> 5869
    //   5848: aload 28
    //   5850: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5853: ifnull +16 -> 5869
    //   5856: aload 30
    //   5858: aload 28
    //   5860: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5863: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5866: putfield 687	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   5869: aload_2
    //   5870: aload 30
    //   5872: invokevirtual 691	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5875: aload_2
    //   5876: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5879: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5882: ifeq +5878 -> 11760
    //   5885: aload_0
    //   5886: aload_1
    //   5887: aload_2
    //   5888: aload 30
    //   5890: invokevirtual 695	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5893: return
    //   5894: astore 32
    //   5896: aload 34
    //   5898: astore 29
    //   5900: aload 25
    //   5902: astore 34
    //   5904: aload 33
    //   5906: astore 25
    //   5908: aload 26
    //   5910: astore 33
    //   5912: aload 31
    //   5914: astore 37
    //   5916: lload 10
    //   5918: lstore 12
    //   5920: aload 24
    //   5922: astore 26
    //   5924: aload 28
    //   5926: astore 38
    //   5928: lload 8
    //   5930: lstore 10
    //   5932: aload 30
    //   5934: astore 24
    //   5936: aload 29
    //   5938: astore 28
    //   5940: aload 25
    //   5942: astore 29
    //   5944: aload 27
    //   5946: astore 25
    //   5948: aload 34
    //   5950: astore 31
    //   5952: aload 32
    //   5954: astore 27
    //   5956: aload 38
    //   5958: astore 34
    //   5960: aload 37
    //   5962: astore 32
    //   5964: aload 33
    //   5966: astore 30
    //   5968: goto +5881 -> 11849
    //   5971: astore 27
    //   5973: aload 34
    //   5975: astore 38
    //   5977: aload 25
    //   5979: astore 32
    //   5981: aload 28
    //   5983: astore 34
    //   5985: aload 31
    //   5987: astore 37
    //   5989: aload 38
    //   5991: astore 28
    //   5993: aload 24
    //   5995: astore 25
    //   5997: aload 32
    //   5999: astore 31
    //   6001: aload 34
    //   6003: astore 24
    //   6005: aload 37
    //   6007: astore 32
    //   6009: lload 8
    //   6011: lstore 12
    //   6013: lload 10
    //   6015: lstore 8
    //   6017: goto -2650 -> 3367
    //   6020: astore 32
    //   6022: aload 34
    //   6024: astore 29
    //   6026: aload 26
    //   6028: astore 37
    //   6030: aload 28
    //   6032: astore 34
    //   6034: aload 31
    //   6036: astore 38
    //   6038: lload 10
    //   6040: lstore 12
    //   6042: lload 8
    //   6044: lstore 10
    //   6046: aload 24
    //   6048: astore 26
    //   6050: aload 30
    //   6052: astore 24
    //   6054: lload 10
    //   6056: lstore 8
    //   6058: iconst_0
    //   6059: istore_3
    //   6060: aload 25
    //   6062: astore 31
    //   6064: aload 29
    //   6066: astore 28
    //   6068: aload 33
    //   6070: astore 29
    //   6072: aload 27
    //   6074: astore 25
    //   6076: aload 32
    //   6078: astore 27
    //   6080: aload 38
    //   6082: astore 32
    //   6084: aload 37
    //   6086: astore 30
    //   6088: goto +5761 -> 11849
    //   6091: astore 39
    //   6093: aload 25
    //   6095: astore 29
    //   6097: aload 33
    //   6099: astore 38
    //   6101: aload 26
    //   6103: astore 25
    //   6105: aload 28
    //   6107: astore 32
    //   6109: aload 31
    //   6111: astore 33
    //   6113: lload 10
    //   6115: lstore 14
    //   6117: aload 24
    //   6119: astore 37
    //   6121: lload 8
    //   6123: lstore 10
    //   6125: aload 39
    //   6127: astore 24
    //   6129: aload 34
    //   6131: astore 28
    //   6133: aload 29
    //   6135: astore 31
    //   6137: lload 8
    //   6139: lstore 12
    //   6141: lload 14
    //   6143: lstore 8
    //   6145: goto +2879 -> 9024
    //   6148: aload 25
    //   6150: astore 37
    //   6152: aload 27
    //   6154: astore 41
    //   6156: aload 26
    //   6158: astore 39
    //   6160: aload 28
    //   6162: astore 40
    //   6164: aload 31
    //   6166: astore 42
    //   6168: lload 10
    //   6170: lstore 12
    //   6172: lload 8
    //   6174: lstore 14
    //   6176: aload 24
    //   6178: astore 38
    //   6180: aload 34
    //   6182: astore 29
    //   6184: aload 33
    //   6186: astore 32
    //   6188: aload_2
    //   6189: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6192: astore 43
    //   6194: aload 43
    //   6196: iconst_3
    //   6197: invokevirtual 223	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   6200: iconst_0
    //   6201: istore_3
    //   6202: aload 26
    //   6204: astore 29
    //   6206: aload 25
    //   6208: astore 26
    //   6210: aload_2
    //   6211: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6214: astore 25
    //   6216: aload 31
    //   6218: astore 37
    //   6220: aload 25
    //   6222: lload 18
    //   6224: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   6227: invokevirtual 382	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   6230: aload_2
    //   6231: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6234: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   6237: aload_0
    //   6238: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   6241: lsub
    //   6242: putfield 385	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   6245: aload_2
    //   6246: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6249: aload_0
    //   6250: getfield 388	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTaskStartTimeStamp	J
    //   6253: putfield 391	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   6256: aload_0
    //   6257: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   6260: invokestatic 397	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   6263: invokevirtual 401	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   6266: astore 39
    //   6268: aload_0
    //   6269: getfield 83	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mRemoteAddress	Ljava/lang/String;
    //   6272: astore 42
    //   6274: aload_0
    //   6275: aconst_null
    //   6276: aconst_null
    //   6277: aload 26
    //   6279: invokevirtual 405	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   6282: astore 41
    //   6284: aload_0
    //   6285: getfield 73	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsEnd	J
    //   6288: aload_0
    //   6289: getfield 70	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsStart	J
    //   6292: lsub
    //   6293: lstore 14
    //   6295: aload 26
    //   6297: ifnull +27 -> 6324
    //   6300: aload 26
    //   6302: invokevirtual 408	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   6305: ifnull +19 -> 6324
    //   6308: aload 26
    //   6310: invokevirtual 408	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   6313: ldc_w 410
    //   6316: invokevirtual 108	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   6319: astore 25
    //   6321: goto +6 -> 6327
    //   6324: aconst_null
    //   6325: astore 25
    //   6327: aload_2
    //   6328: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6331: aload 25
    //   6333: putfield 413	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   6336: aload_0
    //   6337: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   6340: astore 32
    //   6342: aload_1
    //   6343: invokeinterface 194 1 0
    //   6348: ifne +2208 -> 8556
    //   6351: aload 32
    //   6353: astore 40
    //   6355: aload_0
    //   6356: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   6359: invokestatic 204	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   6362: istore 6
    //   6364: aload_2
    //   6365: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6368: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6371: ifne +755 -> 7126
    //   6374: new 359	java/lang/StringBuilder
    //   6377: dup
    //   6378: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   6381: astore 43
    //   6383: aload 43
    //   6385: ldc_w 418
    //   6388: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6391: pop
    //   6392: aload 43
    //   6394: aload_0
    //   6395: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   6398: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6401: pop
    //   6402: aload 43
    //   6404: aload 35
    //   6406: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6409: pop
    //   6410: aload 43
    //   6412: aload_0
    //   6413: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   6416: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6419: pop
    //   6420: aload 43
    //   6422: aload 36
    //   6424: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6427: pop
    //   6428: aload_0
    //   6429: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   6432: ifeq +29 -> 6461
    //   6435: aload 26
    //   6437: ifnull +24 -> 6461
    //   6440: aload 26
    //   6442: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6445: ifnull +16 -> 6461
    //   6448: aload 26
    //   6450: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6453: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   6456: astore 38
    //   6458: goto +8 -> 6466
    //   6461: ldc_w 434
    //   6464: astore 38
    //   6466: aload 43
    //   6468: aload 38
    //   6470: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6473: pop
    //   6474: aload 43
    //   6476: ldc_w 436
    //   6479: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6482: pop
    //   6483: aload 43
    //   6485: aload 39
    //   6487: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6490: pop
    //   6491: aload 43
    //   6493: ldc_w 441
    //   6496: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6499: pop
    //   6500: aload 43
    //   6502: aload 42
    //   6504: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6507: pop
    //   6508: aload 43
    //   6510: ldc_w 443
    //   6513: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6516: pop
    //   6517: aload 43
    //   6519: aconst_null
    //   6520: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6523: pop
    //   6524: aload 43
    //   6526: ldc_w 445
    //   6529: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6532: pop
    //   6533: aload 43
    //   6535: invokestatic 449	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6538: invokevirtual 452	java/lang/Thread:getId	()J
    //   6541: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6544: pop
    //   6545: aload 43
    //   6547: ldc_w 457
    //   6550: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6553: pop
    //   6554: aload 43
    //   6556: invokestatic 462	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   6559: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6562: pop
    //   6563: aload 43
    //   6565: ldc_w 464
    //   6568: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6571: pop
    //   6572: aload 43
    //   6574: iload 6
    //   6576: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6579: pop
    //   6580: aload 43
    //   6582: ldc_w 466
    //   6585: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6588: pop
    //   6589: aload 43
    //   6591: invokestatic 471	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6594: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6597: pop
    //   6598: aload 43
    //   6600: aload 29
    //   6602: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6605: pop
    //   6606: aload 43
    //   6608: aload_2
    //   6609: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6612: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6615: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6618: pop
    //   6619: aload 43
    //   6621: aload 34
    //   6623: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6626: pop
    //   6627: aload 43
    //   6629: aload_2
    //   6630: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6633: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6636: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6639: pop
    //   6640: aload 43
    //   6642: aload 27
    //   6644: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6647: pop
    //   6648: aload 43
    //   6650: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   6653: aload_0
    //   6654: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   6657: lsub
    //   6658: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6661: pop
    //   6662: aload 43
    //   6664: ldc_w 482
    //   6667: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6670: pop
    //   6671: aload 43
    //   6673: aload_2
    //   6674: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6677: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6680: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6683: pop
    //   6684: aload 43
    //   6686: aload 37
    //   6688: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6691: pop
    //   6692: aload 43
    //   6694: aload_2
    //   6695: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6698: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6701: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6704: pop
    //   6705: aload 43
    //   6707: ldc_w 487
    //   6710: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6713: pop
    //   6714: aload 43
    //   6716: aload_2
    //   6717: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6720: getfield 490	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   6723: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6726: pop
    //   6727: aload 43
    //   6729: ldc_w 492
    //   6732: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6735: pop
    //   6736: aload 43
    //   6738: aload_0
    //   6739: invokevirtual 208	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   6742: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6745: pop
    //   6746: aload 28
    //   6748: astore 37
    //   6750: aload 43
    //   6752: aload 37
    //   6754: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6757: pop
    //   6758: aload 43
    //   6760: aload_0
    //   6761: invokevirtual 211	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   6764: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6767: pop
    //   6768: aload 43
    //   6770: ldc_w 494
    //   6773: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6776: pop
    //   6777: aload 43
    //   6779: aload_2
    //   6780: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6783: invokevirtual 497	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   6786: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6789: pop
    //   6790: aload 43
    //   6792: ldc_w 499
    //   6795: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6798: pop
    //   6799: aload 43
    //   6801: iload_3
    //   6802: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6805: pop
    //   6806: aload 43
    //   6808: aload 24
    //   6810: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6813: pop
    //   6814: aload 43
    //   6816: aload 41
    //   6818: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6821: pop
    //   6822: aload 43
    //   6824: aload 33
    //   6826: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6829: pop
    //   6830: aload 43
    //   6832: aload 25
    //   6834: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6837: pop
    //   6838: aload 43
    //   6840: ldc_w 501
    //   6843: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6846: pop
    //   6847: aload 43
    //   6849: aload_0
    //   6850: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   6853: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6856: pop
    //   6857: aload 43
    //   6859: ldc_w 503
    //   6862: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6865: pop
    //   6866: aload 43
    //   6868: aload_2
    //   6869: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6872: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6875: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6878: pop
    //   6879: aload 43
    //   6881: ldc_w 508
    //   6884: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6887: pop
    //   6888: aload 43
    //   6890: lload 14
    //   6892: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6895: pop
    //   6896: aload 43
    //   6898: ldc_w 510
    //   6901: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6904: pop
    //   6905: aload 43
    //   6907: lload 8
    //   6909: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6912: pop
    //   6913: aload 43
    //   6915: aload 37
    //   6917: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6920: pop
    //   6921: aload 43
    //   6923: iconst_0
    //   6924: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6927: pop
    //   6928: aload 43
    //   6930: ldc_w 512
    //   6933: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6936: pop
    //   6937: aload 43
    //   6939: lconst_0
    //   6940: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6943: pop
    //   6944: aload 43
    //   6946: aload 37
    //   6948: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6951: pop
    //   6952: aload 43
    //   6954: iconst_0
    //   6955: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6958: pop
    //   6959: aload 43
    //   6961: ldc_w 514
    //   6964: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6967: pop
    //   6968: aload 43
    //   6970: lload 8
    //   6972: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6975: pop
    //   6976: aload 43
    //   6978: ldc_w 516
    //   6981: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6984: pop
    //   6985: aload 43
    //   6987: aload_0
    //   6988: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   6991: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6994: pop
    //   6995: aload 43
    //   6997: ldc_w 521
    //   7000: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7003: pop
    //   7004: aload 43
    //   7006: aload_0
    //   7007: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   7010: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7013: pop
    //   7014: aload 43
    //   7016: ldc_w 526
    //   7019: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7022: pop
    //   7023: aload_0
    //   7024: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7027: ifnull +17 -> 7044
    //   7030: aload_0
    //   7031: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7034: invokeinterface 536 1 0
    //   7039: astore 37
    //   7041: goto +6 -> 7047
    //   7044: aconst_null
    //   7045: astore 37
    //   7047: aload 43
    //   7049: aload 37
    //   7051: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7054: pop
    //   7055: aload 43
    //   7057: ldc_w 538
    //   7060: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7063: pop
    //   7064: aload 43
    //   7066: aload_2
    //   7067: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7070: getfield 541	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   7073: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7076: pop
    //   7077: aload 30
    //   7079: aload 43
    //   7081: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7084: putfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7087: ldc_w 546
    //   7090: aload 30
    //   7092: getfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7095: aconst_null
    //   7096: invokestatic 549	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7099: aload 40
    //   7101: ifnull +22 -> 7123
    //   7104: aload 40
    //   7106: ldc_w 551
    //   7109: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7112: ifeq +11 -> 7123
    //   7115: aload_0
    //   7116: invokevirtual 258	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   7119: iconst_0
    //   7120: invokestatic 561	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   7123: goto +701 -> 7824
    //   7126: aload 28
    //   7128: astore 40
    //   7130: lload 8
    //   7132: lstore 12
    //   7134: new 359	java/lang/StringBuilder
    //   7137: dup
    //   7138: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   7141: astore 43
    //   7143: aload 43
    //   7145: ldc_w 563
    //   7148: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7151: pop
    //   7152: aload 43
    //   7154: aload_0
    //   7155: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   7158: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7161: pop
    //   7162: aload 43
    //   7164: aload 35
    //   7166: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7169: pop
    //   7170: aload 43
    //   7172: aload_0
    //   7173: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   7176: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7179: pop
    //   7180: aload 43
    //   7182: aload 36
    //   7184: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7187: pop
    //   7188: aload_0
    //   7189: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   7192: ifeq +29 -> 7221
    //   7195: aload 26
    //   7197: ifnull +24 -> 7221
    //   7200: aload 26
    //   7202: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7205: ifnull +16 -> 7221
    //   7208: aload 26
    //   7210: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7213: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   7216: astore 38
    //   7218: goto +8 -> 7226
    //   7221: ldc_w 434
    //   7224: astore 38
    //   7226: aload 43
    //   7228: aload 38
    //   7230: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7233: pop
    //   7234: aload 43
    //   7236: ldc_w 436
    //   7239: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7242: pop
    //   7243: aload 43
    //   7245: aload 39
    //   7247: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7250: pop
    //   7251: aload 43
    //   7253: ldc_w 441
    //   7256: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7259: pop
    //   7260: aload 43
    //   7262: aload 42
    //   7264: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7267: pop
    //   7268: aload 43
    //   7270: ldc_w 443
    //   7273: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7276: pop
    //   7277: aload 43
    //   7279: aconst_null
    //   7280: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7283: pop
    //   7284: aload 43
    //   7286: ldc_w 445
    //   7289: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7292: pop
    //   7293: aload 43
    //   7295: invokestatic 449	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7298: invokevirtual 452	java/lang/Thread:getId	()J
    //   7301: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7304: pop
    //   7305: aload 43
    //   7307: ldc_w 457
    //   7310: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7313: pop
    //   7314: aload 43
    //   7316: invokestatic 462	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7319: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7322: pop
    //   7323: aload 43
    //   7325: ldc_w 466
    //   7328: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7331: pop
    //   7332: aload 43
    //   7334: invokestatic 471	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7337: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7340: pop
    //   7341: aload 43
    //   7343: aload 34
    //   7345: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7348: pop
    //   7349: aload 43
    //   7351: aload_2
    //   7352: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7355: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7358: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7361: pop
    //   7362: aload 43
    //   7364: aload 27
    //   7366: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7369: pop
    //   7370: aload 43
    //   7372: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   7375: aload_0
    //   7376: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   7379: lsub
    //   7380: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7383: pop
    //   7384: aload 43
    //   7386: ldc_w 482
    //   7389: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7392: pop
    //   7393: aload 43
    //   7395: aload_2
    //   7396: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7399: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7402: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7405: pop
    //   7406: aload 43
    //   7408: aload 37
    //   7410: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7413: pop
    //   7414: aload 43
    //   7416: aload_2
    //   7417: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7420: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7423: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7426: pop
    //   7427: aload 43
    //   7429: ldc_w 487
    //   7432: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7435: pop
    //   7436: aload 43
    //   7438: aload_2
    //   7439: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7442: getfield 490	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7445: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7448: pop
    //   7449: aload 43
    //   7451: ldc_w 492
    //   7454: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7457: pop
    //   7458: aload 43
    //   7460: aload_0
    //   7461: invokevirtual 208	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   7464: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7467: pop
    //   7468: aload 43
    //   7470: aload 40
    //   7472: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7475: pop
    //   7476: aload 43
    //   7478: aload_0
    //   7479: invokevirtual 211	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   7482: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7485: pop
    //   7486: aload 43
    //   7488: ldc_w 565
    //   7491: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7494: pop
    //   7495: aload 43
    //   7497: iload_3
    //   7498: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7501: pop
    //   7502: aload 43
    //   7504: aload 24
    //   7506: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7509: pop
    //   7510: aload 43
    //   7512: aload 41
    //   7514: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7517: pop
    //   7518: aload 43
    //   7520: aload 29
    //   7522: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7525: pop
    //   7526: aload 43
    //   7528: aload_2
    //   7529: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7532: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7535: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7538: pop
    //   7539: aload 43
    //   7541: aload 33
    //   7543: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7546: pop
    //   7547: aload 43
    //   7549: aload 25
    //   7551: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7554: pop
    //   7555: aload 43
    //   7557: ldc_w 501
    //   7560: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7563: pop
    //   7564: aload 43
    //   7566: aload_0
    //   7567: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   7570: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7573: pop
    //   7574: aload 43
    //   7576: ldc_w 503
    //   7579: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7582: pop
    //   7583: aload 43
    //   7585: aload_2
    //   7586: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7589: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7592: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7595: pop
    //   7596: aload 43
    //   7598: ldc_w 508
    //   7601: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7604: pop
    //   7605: aload 43
    //   7607: lload 14
    //   7609: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7612: pop
    //   7613: aload 43
    //   7615: ldc_w 510
    //   7618: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7621: pop
    //   7622: aload 43
    //   7624: lload 12
    //   7626: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7629: pop
    //   7630: aload 43
    //   7632: aload 40
    //   7634: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7637: pop
    //   7638: aload 43
    //   7640: iconst_0
    //   7641: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7644: pop
    //   7645: aload 43
    //   7647: ldc_w 512
    //   7650: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7653: pop
    //   7654: aload 43
    //   7656: lconst_0
    //   7657: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7660: pop
    //   7661: aload 43
    //   7663: aload 40
    //   7665: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7668: pop
    //   7669: aload 43
    //   7671: iconst_0
    //   7672: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7675: pop
    //   7676: aload 43
    //   7678: ldc_w 514
    //   7681: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7684: pop
    //   7685: aload 43
    //   7687: lload 12
    //   7689: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7692: pop
    //   7693: aload 43
    //   7695: ldc_w 516
    //   7698: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7701: pop
    //   7702: aload 43
    //   7704: aload_0
    //   7705: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   7708: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7711: pop
    //   7712: aload 43
    //   7714: ldc_w 521
    //   7717: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7720: pop
    //   7721: aload 43
    //   7723: aload_0
    //   7724: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   7727: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7730: pop
    //   7731: aload 43
    //   7733: ldc_w 526
    //   7736: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7739: pop
    //   7740: aload_0
    //   7741: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7744: ifnull +17 -> 7761
    //   7747: aload_0
    //   7748: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7751: invokeinterface 536 1 0
    //   7756: astore 37
    //   7758: goto +6 -> 7764
    //   7761: aconst_null
    //   7762: astore 37
    //   7764: aload 43
    //   7766: aload 37
    //   7768: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7771: pop
    //   7772: aload 43
    //   7774: ldc_w 538
    //   7777: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7780: pop
    //   7781: aload 43
    //   7783: aload_2
    //   7784: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7787: getfield 541	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   7790: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7793: pop
    //   7794: aload 43
    //   7796: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7799: astore 38
    //   7801: aload 30
    //   7803: astore 37
    //   7805: aload 37
    //   7807: aload 38
    //   7809: putfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7812: ldc_w 546
    //   7815: aload 37
    //   7817: getfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7820: aconst_null
    //   7821: invokestatic 568	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7824: aload 26
    //   7826: astore 37
    //   7828: iload 6
    //   7830: ifne +8 -> 7838
    //   7833: aload_0
    //   7834: iconst_0
    //   7835: putfield 571	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mShouldReport	Z
    //   7838: aload_2
    //   7839: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7842: astore 38
    //   7844: new 359	java/lang/StringBuilder
    //   7847: dup
    //   7848: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   7851: astore 40
    //   7853: aload 40
    //   7855: aload_0
    //   7856: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   7859: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7862: pop
    //   7863: aload 40
    //   7865: ldc_w 573
    //   7868: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7871: pop
    //   7872: aload 40
    //   7874: aload 42
    //   7876: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7879: pop
    //   7880: aload 40
    //   7882: ldc_w 575
    //   7885: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7888: pop
    //   7889: aload 40
    //   7891: aload_2
    //   7892: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7895: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7898: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7901: pop
    //   7902: aload 40
    //   7904: ldc_w 577
    //   7907: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7910: pop
    //   7911: aload_0
    //   7912: getfield 581	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7915: ifnull +15 -> 7930
    //   7918: aload_0
    //   7919: getfield 581	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7922: getfield 584	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7925: istore 5
    //   7927: goto +6 -> 7933
    //   7930: iconst_0
    //   7931: istore 5
    //   7933: aload 40
    //   7935: iload 5
    //   7937: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7940: pop
    //   7941: aload 40
    //   7943: ldc_w 499
    //   7946: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7949: pop
    //   7950: aload 40
    //   7952: iload_3
    //   7953: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7956: pop
    //   7957: aload 40
    //   7959: aload 29
    //   7961: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7964: pop
    //   7965: aload 40
    //   7967: aload_2
    //   7968: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7971: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7974: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7977: pop
    //   7978: aload 40
    //   7980: ldc_w 482
    //   7983: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7986: pop
    //   7987: aload_2
    //   7988: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7991: astore 42
    //   7993: aload 28
    //   7995: astore 26
    //   7997: aload 40
    //   7999: aload 42
    //   8001: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8004: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8007: pop
    //   8008: aload 40
    //   8010: aload 31
    //   8012: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8015: pop
    //   8016: aload 40
    //   8018: aload_2
    //   8019: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8022: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8025: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8028: pop
    //   8029: aload 40
    //   8031: aload 34
    //   8033: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8036: pop
    //   8037: aload 40
    //   8039: aload_2
    //   8040: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8043: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8046: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8049: pop
    //   8050: aload 40
    //   8052: aload 27
    //   8054: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8057: pop
    //   8058: aload 40
    //   8060: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   8063: aload_0
    //   8064: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   8067: lsub
    //   8068: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8071: pop
    //   8072: aload 25
    //   8074: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8077: ifne +38 -> 8115
    //   8080: new 359	java/lang/StringBuilder
    //   8083: dup
    //   8084: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   8087: astore 28
    //   8089: aload 28
    //   8091: aload 33
    //   8093: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8096: pop
    //   8097: aload 28
    //   8099: aload 25
    //   8101: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8104: pop
    //   8105: aload 28
    //   8107: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8110: astore 25
    //   8112: goto +8 -> 8120
    //   8115: ldc_w 586
    //   8118: astore 25
    //   8120: aload 40
    //   8122: aload 25
    //   8124: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8127: pop
    //   8128: aload 40
    //   8130: aload 24
    //   8132: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8135: pop
    //   8136: aload 40
    //   8138: aload 41
    //   8140: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8143: pop
    //   8144: aload 38
    //   8146: aload 40
    //   8148: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8151: putfield 589	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   8154: iload 6
    //   8156: ifeq +69 -> 8225
    //   8159: aload_0
    //   8160: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   8163: invokestatic 594	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   8166: astore 25
    //   8168: aload_0
    //   8169: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   8172: astore 28
    //   8174: aload_0
    //   8175: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   8178: ifeq +25 -> 8203
    //   8181: aload 32
    //   8183: ifnull +20 -> 8203
    //   8186: aload 32
    //   8188: ldc_w 596
    //   8191: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8194: ifeq +9 -> 8203
    //   8197: iconst_1
    //   8198: istore 6
    //   8200: goto +6 -> 8206
    //   8203: iconst_0
    //   8204: istore 6
    //   8206: aload 25
    //   8208: aload 28
    //   8210: iload 6
    //   8212: aload_2
    //   8213: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8216: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8219: invokevirtual 600	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   8222: goto +3 -> 8225
    //   8225: aload 30
    //   8227: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   8230: putfield 603	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   8233: aload 30
    //   8235: aload_0
    //   8236: invokevirtual 606	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getContentLength	()J
    //   8239: putfield 609	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   8242: aload 30
    //   8244: aload 37
    //   8246: putfield 613	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   8249: aload 30
    //   8251: iload_3
    //   8252: putfield 616	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   8255: aload 30
    //   8257: aconst_null
    //   8258: putfield 620	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   8261: aload 39
    //   8263: ifnonnull +9 -> 8272
    //   8266: aconst_null
    //   8267: astore 25
    //   8269: goto +10 -> 8279
    //   8272: aload 39
    //   8274: invokevirtual 623	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   8277: astore 25
    //   8279: aload 30
    //   8281: aload 25
    //   8283: putfield 626	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   8286: aload 30
    //   8288: aconst_null
    //   8289: putfield 629	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   8292: aload 30
    //   8294: aload_2
    //   8295: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8298: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8301: putfield 630	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   8304: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   8307: lstore 12
    //   8309: aload 24
    //   8311: astore 25
    //   8313: aload 30
    //   8315: lload 12
    //   8317: aload_0
    //   8318: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   8321: lsub
    //   8322: putfield 633	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   8325: aload 30
    //   8327: aload_2
    //   8328: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8331: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8334: putfield 636	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   8337: aload 30
    //   8339: aload 30
    //   8341: getfield 633	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   8344: aload_2
    //   8345: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8348: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8351: lsub
    //   8352: putfield 639	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   8355: aload 30
    //   8357: lload 10
    //   8359: putfield 642	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   8362: aload 30
    //   8364: lload 8
    //   8366: putfield 645	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   8369: aload 30
    //   8371: lload 8
    //   8373: putfield 648	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   8376: aload 30
    //   8378: aload_0
    //   8379: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   8382: putfield 651	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   8385: aload 30
    //   8387: lconst_0
    //   8388: putfield 654	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   8391: aload 30
    //   8393: aload_0
    //   8394: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   8397: putfield 657	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   8400: aload 30
    //   8402: aload_2
    //   8403: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8406: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8409: putfield 660	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   8412: aload 30
    //   8414: aload_0
    //   8415: invokevirtual 258	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   8418: invokestatic 663	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   8421: putfield 665	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   8424: aload 30
    //   8426: aload_0
    //   8427: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   8430: putfield 668	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   8433: aload 32
    //   8435: ifnull +20 -> 8455
    //   8438: aload 32
    //   8440: ldc_w 596
    //   8443: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8446: ifeq +9 -> 8455
    //   8449: iconst_1
    //   8450: istore 6
    //   8452: goto +6 -> 8458
    //   8455: iconst_0
    //   8456: istore 6
    //   8458: aload 30
    //   8460: iload 6
    //   8462: putfield 671	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   8465: aload 30
    //   8467: aload_2
    //   8468: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8471: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8474: putfield 673	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   8477: aload 30
    //   8479: getstatic 679	com/tencent/component/network/downloader/Downloader$DownloadMode:OkHttpMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   8482: invokevirtual 682	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   8485: putfield 685	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   8488: aload 37
    //   8490: ifnull +24 -> 8514
    //   8493: aload 37
    //   8495: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8498: ifnull +16 -> 8514
    //   8501: aload 30
    //   8503: aload 37
    //   8505: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8508: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   8511: putfield 687	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   8514: aload 27
    //   8516: astore 24
    //   8518: aload_2
    //   8519: aload 30
    //   8521: invokevirtual 691	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   8524: aload_2
    //   8525: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8528: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8531: ifeq +18 -> 8549
    //   8534: aload_0
    //   8535: aload_1
    //   8536: aload_2
    //   8537: aload 30
    //   8539: invokevirtual 695	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   8542: aload 31
    //   8544: astore 32
    //   8546: goto +26 -> 8572
    //   8549: aload 31
    //   8551: astore 32
    //   8553: goto +19 -> 8572
    //   8556: aload 28
    //   8558: astore 26
    //   8560: aload 37
    //   8562: astore 32
    //   8564: aload 24
    //   8566: astore 25
    //   8568: aload 27
    //   8570: astore 24
    //   8572: aload 35
    //   8574: astore 30
    //   8576: aload 29
    //   8578: astore 31
    //   8580: aload 26
    //   8582: astore 27
    //   8584: lload 10
    //   8586: lstore 8
    //   8588: aload 34
    //   8590: astore 28
    //   8592: aload 33
    //   8594: astore 29
    //   8596: aload 24
    //   8598: astore 26
    //   8600: aload 25
    //   8602: astore 24
    //   8604: aload 31
    //   8606: astore 25
    //   8608: goto +3145 -> 11753
    //   8611: astore 28
    //   8613: aload 42
    //   8615: astore 33
    //   8617: aload 41
    //   8619: astore 27
    //   8621: aload 39
    //   8623: astore 31
    //   8625: lload 12
    //   8627: lstore 10
    //   8629: lload 14
    //   8631: lstore 8
    //   8633: aload 38
    //   8635: astore 25
    //   8637: aload 37
    //   8639: astore 26
    //   8641: aload 32
    //   8643: astore 24
    //   8645: aload 40
    //   8647: astore 32
    //   8649: goto +266 -> 8915
    //   8652: astore 24
    //   8654: goto +46 -> 8700
    //   8657: astore 27
    //   8659: lload 14
    //   8661: lstore 8
    //   8663: aload 38
    //   8665: astore 26
    //   8667: aload 37
    //   8669: astore 31
    //   8671: aload 32
    //   8673: astore 24
    //   8675: aload 41
    //   8677: astore 25
    //   8679: aload 39
    //   8681: astore 37
    //   8683: aload 40
    //   8685: astore 34
    //   8687: aload 29
    //   8689: astore 28
    //   8691: aload 42
    //   8693: astore 32
    //   8695: goto +264 -> 8959
    //   8698: astore 24
    //   8700: lload 8
    //   8702: lstore 12
    //   8704: aload 31
    //   8706: astore 33
    //   8708: aload 28
    //   8710: astore 34
    //   8712: aload 26
    //   8714: astore 25
    //   8716: lload 10
    //   8718: lstore 8
    //   8720: aload 38
    //   8722: astore 28
    //   8724: aload 37
    //   8726: astore 31
    //   8728: aload 32
    //   8730: astore 26
    //   8732: aload 34
    //   8734: astore 32
    //   8736: lload 12
    //   8738: lstore 10
    //   8740: goto +268 -> 9008
    //   8743: astore 38
    //   8745: aload 24
    //   8747: astore 32
    //   8749: aload 33
    //   8751: astore 24
    //   8753: aload 34
    //   8755: astore 29
    //   8757: aload 28
    //   8759: astore 33
    //   8761: aload 31
    //   8763: astore 34
    //   8765: aload 25
    //   8767: astore 37
    //   8769: aload 38
    //   8771: astore 28
    //   8773: aload 26
    //   8775: astore 31
    //   8777: aload 32
    //   8779: astore 25
    //   8781: aload 37
    //   8783: astore 26
    //   8785: aload 33
    //   8787: astore 32
    //   8789: aload 34
    //   8791: astore 33
    //   8793: goto +122 -> 8915
    //   8796: astore 38
    //   8798: aload 24
    //   8800: astore 32
    //   8802: aload 33
    //   8804: astore 37
    //   8806: aload 34
    //   8808: astore 29
    //   8810: aload 28
    //   8812: astore 33
    //   8814: aload 31
    //   8816: astore 34
    //   8818: lload 8
    //   8820: lstore 12
    //   8822: aload 25
    //   8824: astore 31
    //   8826: lload 10
    //   8828: lstore 8
    //   8830: aload 38
    //   8832: astore 24
    //   8834: aload 26
    //   8836: astore 25
    //   8838: aload 37
    //   8840: astore 26
    //   8842: aload 32
    //   8844: astore 28
    //   8846: aload 33
    //   8848: astore 32
    //   8850: aload 34
    //   8852: astore 33
    //   8854: lload 12
    //   8856: lstore 10
    //   8858: goto +150 -> 9008
    //   8861: astore 38
    //   8863: lload 12
    //   8865: lstore 8
    //   8867: aload 32
    //   8869: astore 31
    //   8871: aload 28
    //   8873: astore 32
    //   8875: aload 26
    //   8877: astore 28
    //   8879: aload 25
    //   8881: astore 34
    //   8883: aload 27
    //   8885: astore 37
    //   8887: aload 31
    //   8889: astore 26
    //   8891: aload 24
    //   8893: astore 25
    //   8895: aload 28
    //   8897: astore 24
    //   8899: aload 34
    //   8901: astore 31
    //   8903: aload 29
    //   8905: astore 27
    //   8907: aload 37
    //   8909: astore 29
    //   8911: aload 38
    //   8913: astore 28
    //   8915: aload 28
    //   8917: astore 38
    //   8919: aload 27
    //   8921: astore 28
    //   8923: aload 32
    //   8925: astore 34
    //   8927: lload 10
    //   8929: lstore 12
    //   8931: aload 31
    //   8933: astore 37
    //   8935: aload 33
    //   8937: astore 32
    //   8939: aload 38
    //   8941: astore 27
    //   8943: aload 26
    //   8945: astore 31
    //   8947: aload 25
    //   8949: astore 26
    //   8951: aload 28
    //   8953: astore 25
    //   8955: aload 29
    //   8957: astore 28
    //   8959: lload 8
    //   8961: lstore 10
    //   8963: aload 24
    //   8965: astore 29
    //   8967: goto -8550 -> 417
    //   8970: astore 37
    //   8972: aload 32
    //   8974: astore 31
    //   8976: lload 10
    //   8978: lstore 8
    //   8980: aload 27
    //   8982: astore 34
    //   8984: lload 12
    //   8986: lstore 10
    //   8988: aload 28
    //   8990: astore 32
    //   8992: aload 24
    //   8994: astore 28
    //   8996: aload 29
    //   8998: astore 27
    //   9000: aload 34
    //   9002: astore 29
    //   9004: aload 37
    //   9006: astore 24
    //   9008: lload 10
    //   9010: lstore 12
    //   9012: aload 28
    //   9014: astore 37
    //   9016: aload 26
    //   9018: astore 38
    //   9020: aload 29
    //   9022: astore 28
    //   9024: iconst_0
    //   9025: istore_3
    //   9026: aload 24
    //   9028: astore 34
    //   9030: aload 25
    //   9032: astore 26
    //   9034: aload 38
    //   9036: astore 29
    //   9038: aload 37
    //   9040: astore 25
    //   9042: aload 32
    //   9044: astore 24
    //   9046: aload 33
    //   9048: astore 32
    //   9050: goto +226 -> 9276
    //   9053: astore 34
    //   9055: aload 32
    //   9057: astore 31
    //   9059: aload 27
    //   9061: astore 32
    //   9063: aload 34
    //   9065: astore 27
    //   9067: lload 10
    //   9069: lstore 12
    //   9071: aload 29
    //   9073: astore 38
    //   9075: aload 25
    //   9077: astore 37
    //   9079: aload 28
    //   9081: astore 34
    //   9083: lconst_0
    //   9084: lstore 8
    //   9086: lconst_0
    //   9087: lstore 10
    //   9089: aload 32
    //   9091: astore 28
    //   9093: aload 26
    //   9095: astore 29
    //   9097: aload 38
    //   9099: astore 25
    //   9101: aload 24
    //   9103: astore 26
    //   9105: aload 33
    //   9107: astore 32
    //   9109: goto -8692 -> 417
    //   9112: astore 34
    //   9114: aload 32
    //   9116: astore 31
    //   9118: lload 10
    //   9120: lstore 8
    //   9122: goto +102 -> 9224
    //   9125: astore 32
    //   9127: lload 10
    //   9129: lstore 12
    //   9131: goto +23 -> 9154
    //   9134: astore 34
    //   9136: lload 10
    //   9138: lstore 8
    //   9140: goto +81 -> 9221
    //   9143: astore 34
    //   9145: goto +76 -> 9221
    //   9148: astore 32
    //   9150: lload 8
    //   9152: lstore 12
    //   9154: aload 25
    //   9156: astore 37
    //   9158: aload 28
    //   9160: astore 34
    //   9162: aload 24
    //   9164: astore 31
    //   9166: aload 29
    //   9168: astore 25
    //   9170: aload 30
    //   9172: astore 24
    //   9174: lconst_0
    //   9175: lstore 8
    //   9177: lconst_0
    //   9178: lstore 10
    //   9180: iconst_0
    //   9181: istore_3
    //   9182: aconst_null
    //   9183: astore 30
    //   9185: aload 27
    //   9187: astore 28
    //   9189: aload 26
    //   9191: astore 29
    //   9193: aload 31
    //   9195: astore 26
    //   9197: aload 30
    //   9199: astore 31
    //   9201: aload 32
    //   9203: astore 27
    //   9205: aload 33
    //   9207: astore 32
    //   9209: aload 37
    //   9211: astore 30
    //   9213: goto +2636 -> 11849
    //   9216: astore 34
    //   9218: iload_3
    //   9219: istore 4
    //   9221: aconst_null
    //   9222: astore 31
    //   9224: aload 28
    //   9226: astore 40
    //   9228: aload 24
    //   9230: astore 39
    //   9232: iconst_0
    //   9233: istore_3
    //   9234: aload 26
    //   9236: astore 38
    //   9238: aload 25
    //   9240: astore 26
    //   9242: aload 29
    //   9244: astore 37
    //   9246: lconst_0
    //   9247: lstore 10
    //   9249: aload 27
    //   9251: astore 28
    //   9253: lconst_0
    //   9254: lstore 12
    //   9256: aload 33
    //   9258: astore 32
    //   9260: aload 40
    //   9262: astore 24
    //   9264: aload 39
    //   9266: astore 25
    //   9268: aload 38
    //   9270: astore 29
    //   9272: aload 37
    //   9274: astore 27
    //   9276: aload 35
    //   9278: astore 33
    //   9280: aload 36
    //   9282: astore 38
    //   9284: new 359	java/lang/StringBuilder
    //   9287: dup
    //   9288: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   9291: astore 37
    //   9293: aload 37
    //   9295: ldc_w 739
    //   9298: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9301: pop
    //   9302: aload 37
    //   9304: aload_0
    //   9305: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   9308: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9311: pop
    //   9312: aload 37
    //   9314: ldc_w 741
    //   9317: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9320: pop
    //   9321: ldc 233
    //   9323: aload 37
    //   9325: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9328: aload 34
    //   9330: invokestatic 549	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9333: aload_2
    //   9334: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9337: aload 34
    //   9339: invokevirtual 744	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   9342: aload_2
    //   9343: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9346: lload 18
    //   9348: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   9351: invokevirtual 382	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   9354: aload_2
    //   9355: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9358: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   9361: aload_0
    //   9362: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   9365: lsub
    //   9366: putfield 385	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   9369: aload_2
    //   9370: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9373: aload_0
    //   9374: getfield 388	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTaskStartTimeStamp	J
    //   9377: putfield 391	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   9380: aload_0
    //   9381: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   9384: invokestatic 397	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   9387: invokevirtual 401	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   9390: astore 39
    //   9392: aload_0
    //   9393: getfield 83	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mRemoteAddress	Ljava/lang/String;
    //   9396: astore 42
    //   9398: aload_0
    //   9399: aconst_null
    //   9400: aconst_null
    //   9401: aload 31
    //   9403: invokevirtual 405	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   9406: astore 41
    //   9408: aload_0
    //   9409: getfield 73	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsEnd	J
    //   9412: aload_0
    //   9413: getfield 70	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsStart	J
    //   9416: lsub
    //   9417: lstore 14
    //   9419: aload 31
    //   9421: ifnull +27 -> 9448
    //   9424: aload 31
    //   9426: invokevirtual 408	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   9429: ifnull +19 -> 9448
    //   9432: aload 31
    //   9434: invokevirtual 408	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   9437: ldc_w 410
    //   9440: invokevirtual 108	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   9443: astore 35
    //   9445: goto +6 -> 9451
    //   9448: aconst_null
    //   9449: astore 35
    //   9451: aload_2
    //   9452: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9455: aload 35
    //   9457: putfield 413	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   9460: aload_0
    //   9461: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   9464: astore 37
    //   9466: aload_1
    //   9467: invokeinterface 194 1 0
    //   9472: ifne +2257 -> 11729
    //   9475: aload 37
    //   9477: astore 40
    //   9479: aload_0
    //   9480: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   9483: invokestatic 204	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   9486: istore 6
    //   9488: aload_2
    //   9489: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9492: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9495: ifne +767 -> 10262
    //   9498: new 359	java/lang/StringBuilder
    //   9501: dup
    //   9502: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   9505: astore 43
    //   9507: aload 43
    //   9509: ldc_w 418
    //   9512: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9515: pop
    //   9516: aload 43
    //   9518: aload_0
    //   9519: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   9522: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9525: pop
    //   9526: aload 43
    //   9528: aload 33
    //   9530: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9533: pop
    //   9534: aload 43
    //   9536: aload_0
    //   9537: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   9540: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9543: pop
    //   9544: aload 43
    //   9546: aload 38
    //   9548: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9551: pop
    //   9552: aload_0
    //   9553: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   9556: ifeq +29 -> 9585
    //   9559: aload 31
    //   9561: ifnull +24 -> 9585
    //   9564: aload 31
    //   9566: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9569: ifnull +16 -> 9585
    //   9572: aload 31
    //   9574: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9577: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9580: astore 38
    //   9582: goto +8 -> 9590
    //   9585: ldc_w 434
    //   9588: astore 38
    //   9590: aload 43
    //   9592: aload 38
    //   9594: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9597: pop
    //   9598: aload 43
    //   9600: ldc_w 436
    //   9603: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9606: pop
    //   9607: aload 43
    //   9609: aload 39
    //   9611: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9614: pop
    //   9615: aload 43
    //   9617: ldc_w 441
    //   9620: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9623: pop
    //   9624: aload 43
    //   9626: aload 42
    //   9628: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9631: pop
    //   9632: aload 43
    //   9634: ldc_w 443
    //   9637: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9640: pop
    //   9641: aload 43
    //   9643: aconst_null
    //   9644: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9647: pop
    //   9648: aload 43
    //   9650: ldc_w 445
    //   9653: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9656: pop
    //   9657: aload 43
    //   9659: invokestatic 449	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9662: invokevirtual 452	java/lang/Thread:getId	()J
    //   9665: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9668: pop
    //   9669: aload 43
    //   9671: ldc_w 457
    //   9674: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9677: pop
    //   9678: aload 43
    //   9680: invokestatic 462	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9683: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9686: pop
    //   9687: aload 43
    //   9689: ldc_w 464
    //   9692: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9695: pop
    //   9696: aload 43
    //   9698: iload 6
    //   9700: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9703: pop
    //   9704: aload 43
    //   9706: ldc_w 466
    //   9709: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9712: pop
    //   9713: aload 43
    //   9715: invokestatic 471	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9718: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9721: pop
    //   9722: aload 43
    //   9724: aload 26
    //   9726: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9729: pop
    //   9730: aload 43
    //   9732: aload_2
    //   9733: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9736: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9739: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9742: pop
    //   9743: aload 43
    //   9745: aload 28
    //   9747: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9750: pop
    //   9751: aload 43
    //   9753: aload_2
    //   9754: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9757: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9760: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9763: pop
    //   9764: aload 43
    //   9766: aload 27
    //   9768: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9771: pop
    //   9772: aload 43
    //   9774: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   9777: aload_0
    //   9778: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   9781: lsub
    //   9782: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9785: pop
    //   9786: aload 43
    //   9788: ldc_w 482
    //   9791: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9794: pop
    //   9795: aload 43
    //   9797: aload_2
    //   9798: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9801: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9804: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9807: pop
    //   9808: aload 43
    //   9810: aload 32
    //   9812: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9815: pop
    //   9816: aload 43
    //   9818: aload_2
    //   9819: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9822: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9825: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9828: pop
    //   9829: aload 43
    //   9831: ldc_w 487
    //   9834: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9837: pop
    //   9838: aload 43
    //   9840: aload_2
    //   9841: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9844: getfield 490	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9847: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9850: pop
    //   9851: aload 43
    //   9853: ldc_w 492
    //   9856: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9859: pop
    //   9860: aload 43
    //   9862: aload_0
    //   9863: invokevirtual 208	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   9866: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9869: pop
    //   9870: aload 24
    //   9872: astore 38
    //   9874: aload 43
    //   9876: aload 38
    //   9878: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9881: pop
    //   9882: aload 43
    //   9884: aload_0
    //   9885: invokevirtual 211	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   9888: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9891: pop
    //   9892: aload 43
    //   9894: ldc_w 494
    //   9897: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9900: pop
    //   9901: aload 43
    //   9903: aload_2
    //   9904: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9907: invokevirtual 497	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   9910: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9913: pop
    //   9914: aload 43
    //   9916: ldc_w 499
    //   9919: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9922: pop
    //   9923: aload 43
    //   9925: iload_3
    //   9926: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9929: pop
    //   9930: aload 43
    //   9932: aload 25
    //   9934: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9937: pop
    //   9938: aload 43
    //   9940: aload 41
    //   9942: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9945: pop
    //   9946: aload 43
    //   9948: aload 29
    //   9950: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9953: pop
    //   9954: aload 43
    //   9956: aload 35
    //   9958: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9961: pop
    //   9962: aload 43
    //   9964: ldc_w 501
    //   9967: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9970: pop
    //   9971: aload 43
    //   9973: aload_0
    //   9974: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   9977: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9980: pop
    //   9981: aload 43
    //   9983: ldc_w 503
    //   9986: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9989: pop
    //   9990: aload 43
    //   9992: aload_2
    //   9993: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9996: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9999: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10002: pop
    //   10003: aload 43
    //   10005: ldc_w 508
    //   10008: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10011: pop
    //   10012: aload 43
    //   10014: lload 14
    //   10016: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10019: pop
    //   10020: aload 43
    //   10022: ldc_w 510
    //   10025: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10028: pop
    //   10029: aload 43
    //   10031: lload 10
    //   10033: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10036: pop
    //   10037: aload 43
    //   10039: aload 38
    //   10041: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10044: pop
    //   10045: aload 43
    //   10047: iconst_0
    //   10048: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10051: pop
    //   10052: aload 43
    //   10054: ldc_w 512
    //   10057: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10060: pop
    //   10061: aload 43
    //   10063: lconst_0
    //   10064: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10067: pop
    //   10068: aload 43
    //   10070: aload 38
    //   10072: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10075: pop
    //   10076: aload 43
    //   10078: iconst_0
    //   10079: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10082: pop
    //   10083: aload 43
    //   10085: ldc_w 514
    //   10088: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10091: pop
    //   10092: aload 43
    //   10094: lload 12
    //   10096: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10099: pop
    //   10100: aload 43
    //   10102: ldc_w 516
    //   10105: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10108: pop
    //   10109: aload 43
    //   10111: aload_0
    //   10112: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   10115: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10118: pop
    //   10119: aload 43
    //   10121: ldc_w 521
    //   10124: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10127: pop
    //   10128: aload 43
    //   10130: aload_0
    //   10131: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   10134: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10137: pop
    //   10138: aload 43
    //   10140: ldc_w 526
    //   10143: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10146: pop
    //   10147: aload_0
    //   10148: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10151: ifnull +17 -> 10168
    //   10154: aload_0
    //   10155: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10158: invokeinterface 536 1 0
    //   10163: astore 38
    //   10165: goto +6 -> 10171
    //   10168: aconst_null
    //   10169: astore 38
    //   10171: aload 43
    //   10173: aload 38
    //   10175: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10178: pop
    //   10179: aload 43
    //   10181: ldc_w 538
    //   10184: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10187: pop
    //   10188: aload 43
    //   10190: aload_2
    //   10191: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10194: getfield 541	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   10197: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10200: pop
    //   10201: aload 43
    //   10203: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10206: astore 43
    //   10208: aload 30
    //   10210: astore 38
    //   10212: aload 38
    //   10214: aload 43
    //   10216: putfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10219: ldc_w 546
    //   10222: aload 38
    //   10224: getfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10227: aload 34
    //   10229: invokestatic 549	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10232: aload 40
    //   10234: ifnull +25 -> 10259
    //   10237: aload 40
    //   10239: ldc_w 551
    //   10242: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   10245: ifeq +14 -> 10259
    //   10248: aload_0
    //   10249: invokevirtual 258	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   10252: iconst_0
    //   10253: invokestatic 561	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   10256: goto +3 -> 10259
    //   10259: goto +697 -> 10956
    //   10262: aload 24
    //   10264: astore 40
    //   10266: new 359	java/lang/StringBuilder
    //   10269: dup
    //   10270: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   10273: astore 43
    //   10275: aload 43
    //   10277: ldc_w 563
    //   10280: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10283: pop
    //   10284: aload 43
    //   10286: aload_0
    //   10287: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   10290: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10293: pop
    //   10294: aload 43
    //   10296: aload 33
    //   10298: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10301: pop
    //   10302: aload 43
    //   10304: aload_0
    //   10305: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   10308: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10311: pop
    //   10312: aload 43
    //   10314: aload 38
    //   10316: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10319: pop
    //   10320: aload_0
    //   10321: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   10324: ifeq +29 -> 10353
    //   10327: aload 31
    //   10329: ifnull +24 -> 10353
    //   10332: aload 31
    //   10334: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   10337: ifnull +16 -> 10353
    //   10340: aload 31
    //   10342: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   10345: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   10348: astore 38
    //   10350: goto +8 -> 10358
    //   10353: ldc_w 434
    //   10356: astore 38
    //   10358: aload 43
    //   10360: aload 38
    //   10362: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10365: pop
    //   10366: aload 43
    //   10368: ldc_w 436
    //   10371: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10374: pop
    //   10375: aload 43
    //   10377: aload 39
    //   10379: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10382: pop
    //   10383: aload 43
    //   10385: ldc_w 441
    //   10388: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10391: pop
    //   10392: aload 43
    //   10394: aload 42
    //   10396: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10399: pop
    //   10400: aload 43
    //   10402: ldc_w 443
    //   10405: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10408: pop
    //   10409: aload 43
    //   10411: aconst_null
    //   10412: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10415: pop
    //   10416: aload 43
    //   10418: ldc_w 445
    //   10421: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10424: pop
    //   10425: aload 43
    //   10427: invokestatic 449	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   10430: invokevirtual 452	java/lang/Thread:getId	()J
    //   10433: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10436: pop
    //   10437: aload 43
    //   10439: ldc_w 457
    //   10442: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10445: pop
    //   10446: aload 43
    //   10448: invokestatic 462	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   10451: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10454: pop
    //   10455: aload 43
    //   10457: ldc_w 466
    //   10460: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10463: pop
    //   10464: aload 43
    //   10466: invokestatic 471	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   10469: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10472: pop
    //   10473: aload 43
    //   10475: aload 28
    //   10477: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10480: pop
    //   10481: aload 43
    //   10483: aload_2
    //   10484: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10487: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10490: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10493: pop
    //   10494: aload 43
    //   10496: aload 27
    //   10498: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10501: pop
    //   10502: aload 43
    //   10504: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   10507: aload_0
    //   10508: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   10511: lsub
    //   10512: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10515: pop
    //   10516: aload 43
    //   10518: ldc_w 482
    //   10521: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10524: pop
    //   10525: aload 43
    //   10527: aload_2
    //   10528: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10531: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10534: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10537: pop
    //   10538: aload 43
    //   10540: aload 32
    //   10542: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10545: pop
    //   10546: aload 43
    //   10548: aload_2
    //   10549: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10552: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10555: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10558: pop
    //   10559: aload 43
    //   10561: ldc_w 487
    //   10564: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10567: pop
    //   10568: aload 43
    //   10570: aload_2
    //   10571: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10574: getfield 490	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10577: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10580: pop
    //   10581: aload 43
    //   10583: ldc_w 492
    //   10586: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10589: pop
    //   10590: aload 43
    //   10592: aload_0
    //   10593: invokevirtual 208	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   10596: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10599: pop
    //   10600: aload 43
    //   10602: aload 40
    //   10604: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10607: pop
    //   10608: aload 43
    //   10610: aload_0
    //   10611: invokevirtual 211	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   10614: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10617: pop
    //   10618: aload 43
    //   10620: ldc_w 565
    //   10623: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10626: pop
    //   10627: aload 43
    //   10629: iload_3
    //   10630: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10633: pop
    //   10634: aload 43
    //   10636: aload 25
    //   10638: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10641: pop
    //   10642: aload 43
    //   10644: aload 41
    //   10646: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10649: pop
    //   10650: aload 43
    //   10652: aload 26
    //   10654: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10657: pop
    //   10658: aload 43
    //   10660: aload_2
    //   10661: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10664: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10667: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10670: pop
    //   10671: aload 43
    //   10673: aload 29
    //   10675: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10678: pop
    //   10679: aload 43
    //   10681: aload 35
    //   10683: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10686: pop
    //   10687: aload 43
    //   10689: ldc_w 501
    //   10692: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10695: pop
    //   10696: aload 43
    //   10698: aload_0
    //   10699: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   10702: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10705: pop
    //   10706: aload 43
    //   10708: ldc_w 503
    //   10711: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10714: pop
    //   10715: aload 43
    //   10717: aload_2
    //   10718: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10721: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10724: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10727: pop
    //   10728: aload 43
    //   10730: ldc_w 508
    //   10733: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10736: pop
    //   10737: aload 43
    //   10739: lload 14
    //   10741: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10744: pop
    //   10745: aload 43
    //   10747: ldc_w 510
    //   10750: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10753: pop
    //   10754: aload 43
    //   10756: lload 10
    //   10758: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10761: pop
    //   10762: aload 43
    //   10764: aload 40
    //   10766: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10769: pop
    //   10770: aload 43
    //   10772: iconst_0
    //   10773: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10776: pop
    //   10777: aload 43
    //   10779: ldc_w 512
    //   10782: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10785: pop
    //   10786: aload 43
    //   10788: lconst_0
    //   10789: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10792: pop
    //   10793: aload 43
    //   10795: aload 40
    //   10797: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10800: pop
    //   10801: aload 43
    //   10803: iconst_0
    //   10804: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10807: pop
    //   10808: aload 43
    //   10810: ldc_w 514
    //   10813: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10816: pop
    //   10817: aload 43
    //   10819: lload 12
    //   10821: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10824: pop
    //   10825: aload 43
    //   10827: ldc_w 516
    //   10830: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10833: pop
    //   10834: aload 43
    //   10836: aload_0
    //   10837: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   10840: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10843: pop
    //   10844: aload 43
    //   10846: ldc_w 521
    //   10849: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10852: pop
    //   10853: aload 43
    //   10855: aload_0
    //   10856: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   10859: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10862: pop
    //   10863: aload 43
    //   10865: ldc_w 526
    //   10868: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10871: pop
    //   10872: aload_0
    //   10873: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10876: ifnull +17 -> 10893
    //   10879: aload_0
    //   10880: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10883: invokeinterface 536 1 0
    //   10888: astore 38
    //   10890: goto +6 -> 10896
    //   10893: aconst_null
    //   10894: astore 38
    //   10896: aload 43
    //   10898: aload 38
    //   10900: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10903: pop
    //   10904: aload 43
    //   10906: ldc_w 538
    //   10909: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10912: pop
    //   10913: aload 43
    //   10915: aload_2
    //   10916: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10919: getfield 541	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   10922: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10925: pop
    //   10926: aload 43
    //   10928: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10931: astore 40
    //   10933: aload 30
    //   10935: astore 38
    //   10937: aload 38
    //   10939: aload 40
    //   10941: putfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10944: ldc_w 546
    //   10947: aload 38
    //   10949: getfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10952: aconst_null
    //   10953: invokestatic 568	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10956: aload 31
    //   10958: astore 38
    //   10960: aload 39
    //   10962: astore 40
    //   10964: aload 26
    //   10966: astore 31
    //   10968: aload 30
    //   10970: astore 39
    //   10972: aload 25
    //   10974: astore 26
    //   10976: iload 6
    //   10978: ifne +8 -> 10986
    //   10981: aload_0
    //   10982: iconst_0
    //   10983: putfield 571	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mShouldReport	Z
    //   10986: aload_2
    //   10987: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10990: astore 43
    //   10992: new 359	java/lang/StringBuilder
    //   10995: dup
    //   10996: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   10999: astore 44
    //   11001: aload 44
    //   11003: aload_0
    //   11004: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   11007: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11010: pop
    //   11011: aload 44
    //   11013: ldc_w 573
    //   11016: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11019: pop
    //   11020: aload 44
    //   11022: aload 42
    //   11024: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11027: pop
    //   11028: aload 44
    //   11030: ldc_w 575
    //   11033: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11036: pop
    //   11037: aload 44
    //   11039: aload_2
    //   11040: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11043: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11046: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11049: pop
    //   11050: aload 44
    //   11052: ldc_w 577
    //   11055: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11058: pop
    //   11059: aload_0
    //   11060: getfield 581	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11063: ifnull +15 -> 11078
    //   11066: aload_0
    //   11067: getfield 581	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11070: getfield 584	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11073: istore 5
    //   11075: goto +6 -> 11081
    //   11078: iconst_0
    //   11079: istore 5
    //   11081: aload 44
    //   11083: iload 5
    //   11085: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11088: pop
    //   11089: aload 44
    //   11091: ldc_w 499
    //   11094: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11097: pop
    //   11098: aload 44
    //   11100: iload_3
    //   11101: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11104: pop
    //   11105: aload 44
    //   11107: aload 31
    //   11109: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11112: pop
    //   11113: aload 44
    //   11115: aload_2
    //   11116: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11119: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11122: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11125: pop
    //   11126: aload 44
    //   11128: ldc_w 482
    //   11131: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11134: pop
    //   11135: aload_2
    //   11136: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11139: astore 30
    //   11141: aload 31
    //   11143: astore 25
    //   11145: aload 44
    //   11147: aload 30
    //   11149: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   11152: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11155: pop
    //   11156: aload 44
    //   11158: aload 32
    //   11160: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11163: pop
    //   11164: aload 44
    //   11166: aload_2
    //   11167: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11170: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   11173: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11176: pop
    //   11177: aload 44
    //   11179: aload 28
    //   11181: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11184: pop
    //   11185: aload 44
    //   11187: aload_2
    //   11188: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11191: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11194: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11197: pop
    //   11198: aload 44
    //   11200: aload 27
    //   11202: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11205: pop
    //   11206: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   11209: lstore 14
    //   11211: aload 44
    //   11213: lload 14
    //   11215: aload_0
    //   11216: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   11219: lsub
    //   11220: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11223: pop
    //   11224: aload 35
    //   11226: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11229: ifne +38 -> 11267
    //   11232: new 359	java/lang/StringBuilder
    //   11235: dup
    //   11236: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   11239: astore 30
    //   11241: aload 30
    //   11243: aload 29
    //   11245: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11248: pop
    //   11249: aload 30
    //   11251: aload 35
    //   11253: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11256: pop
    //   11257: aload 30
    //   11259: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11262: astore 30
    //   11264: goto +8 -> 11272
    //   11267: ldc_w 586
    //   11270: astore 30
    //   11272: aload 44
    //   11274: aload 30
    //   11276: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11279: pop
    //   11280: aload 44
    //   11282: aload 26
    //   11284: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11287: pop
    //   11288: aload 44
    //   11290: aload 41
    //   11292: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11295: pop
    //   11296: aload 43
    //   11298: aload 44
    //   11300: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11303: putfield 589	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   11306: iload 6
    //   11308: ifeq +69 -> 11377
    //   11311: aload_0
    //   11312: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   11315: invokestatic 594	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   11318: astore 30
    //   11320: aload_0
    //   11321: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   11324: astore 31
    //   11326: aload_0
    //   11327: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   11330: ifeq +25 -> 11355
    //   11333: aload 37
    //   11335: ifnull +20 -> 11355
    //   11338: aload 37
    //   11340: ldc_w 596
    //   11343: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11346: ifeq +9 -> 11355
    //   11349: iconst_1
    //   11350: istore 6
    //   11352: goto +6 -> 11358
    //   11355: iconst_0
    //   11356: istore 6
    //   11358: aload 30
    //   11360: aload 31
    //   11362: iload 6
    //   11364: aload_2
    //   11365: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11368: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11371: invokevirtual 600	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   11374: goto +3 -> 11377
    //   11377: aload 39
    //   11379: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   11382: putfield 603	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   11385: aload 39
    //   11387: aload_0
    //   11388: invokevirtual 606	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getContentLength	()J
    //   11391: putfield 609	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   11394: aload 39
    //   11396: aload 38
    //   11398: putfield 613	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   11401: aload 39
    //   11403: iload_3
    //   11404: putfield 616	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   11407: aload 39
    //   11409: aload 34
    //   11411: putfield 620	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   11414: aload 40
    //   11416: ifnonnull +9 -> 11425
    //   11419: aconst_null
    //   11420: astore 30
    //   11422: goto +10 -> 11432
    //   11425: aload 40
    //   11427: invokevirtual 623	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   11430: astore 30
    //   11432: aload 39
    //   11434: aload 30
    //   11436: putfield 626	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   11439: aload 39
    //   11441: aconst_null
    //   11442: putfield 629	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   11445: aload 39
    //   11447: aload_2
    //   11448: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11451: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11454: putfield 630	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   11457: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   11460: lstore 14
    //   11462: aload 26
    //   11464: astore 30
    //   11466: aload 39
    //   11468: lload 14
    //   11470: aload_0
    //   11471: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   11474: lsub
    //   11475: putfield 633	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11478: aload 39
    //   11480: aload_2
    //   11481: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11484: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11487: putfield 636	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   11490: aload 39
    //   11492: aload 39
    //   11494: getfield 633	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11497: aload_2
    //   11498: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11501: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11504: lsub
    //   11505: putfield 639	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   11508: aload 39
    //   11510: lload 8
    //   11512: putfield 642	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   11515: aload 39
    //   11517: lload 10
    //   11519: putfield 645	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   11522: aload 39
    //   11524: lload 12
    //   11526: putfield 648	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   11529: aload 39
    //   11531: aload_0
    //   11532: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   11535: putfield 651	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   11538: aload 39
    //   11540: lconst_0
    //   11541: putfield 654	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   11544: aload 39
    //   11546: aload_0
    //   11547: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   11550: putfield 657	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   11553: aload 39
    //   11555: aload_2
    //   11556: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11559: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11562: putfield 660	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   11565: aload 39
    //   11567: aload_0
    //   11568: invokevirtual 258	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   11571: invokestatic 663	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   11574: putfield 665	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   11577: aload 39
    //   11579: aload_0
    //   11580: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   11583: putfield 668	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   11586: aload 37
    //   11588: ifnull +20 -> 11608
    //   11591: aload 37
    //   11593: ldc_w 596
    //   11596: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11599: ifeq +9 -> 11608
    //   11602: iconst_1
    //   11603: istore 6
    //   11605: goto +6 -> 11611
    //   11608: iconst_0
    //   11609: istore 6
    //   11611: aload 39
    //   11613: iload 6
    //   11615: putfield 671	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   11618: aload 39
    //   11620: aload_2
    //   11621: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11624: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11627: putfield 673	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   11630: aload 39
    //   11632: getstatic 679	com/tencent/component/network/downloader/Downloader$DownloadMode:OkHttpMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   11635: invokevirtual 682	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   11638: putfield 685	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   11641: aload 38
    //   11643: ifnull +24 -> 11667
    //   11646: aload 38
    //   11648: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11651: ifnull +16 -> 11667
    //   11654: aload 39
    //   11656: aload 38
    //   11658: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   11661: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   11664: putfield 687	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   11667: aload_2
    //   11668: aload 39
    //   11670: invokevirtual 691	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11673: aload_2
    //   11674: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11677: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11680: ifeq +30 -> 11710
    //   11683: aload_0
    //   11684: aload_1
    //   11685: aload_2
    //   11686: aload 39
    //   11688: invokevirtual 695	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11691: aload 27
    //   11693: astore 26
    //   11695: aload 24
    //   11697: astore 27
    //   11699: aload 30
    //   11701: astore 24
    //   11703: aload 33
    //   11705: astore 30
    //   11707: goto +46 -> 11753
    //   11710: aload 27
    //   11712: astore 26
    //   11714: aload 24
    //   11716: astore 27
    //   11718: aload 30
    //   11720: astore 24
    //   11722: aload 33
    //   11724: astore 30
    //   11726: goto +27 -> 11753
    //   11729: aload 27
    //   11731: astore 31
    //   11733: aload 24
    //   11735: astore 27
    //   11737: aload 25
    //   11739: astore 24
    //   11741: aload 26
    //   11743: astore 25
    //   11745: aload 33
    //   11747: astore 30
    //   11749: aload 31
    //   11751: astore 26
    //   11753: aload_0
    //   11754: invokevirtual 747	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:canAttempt	()Z
    //   11757: ifne +4 -> 11761
    //   11760: return
    //   11761: aload 29
    //   11763: astore 31
    //   11765: aload 26
    //   11767: astore 29
    //   11769: aload 27
    //   11771: astore 33
    //   11773: aload 28
    //   11775: astore 27
    //   11777: iload 4
    //   11779: istore_3
    //   11780: aload 30
    //   11782: astore 35
    //   11784: aload 31
    //   11786: astore 26
    //   11788: aload 32
    //   11790: astore 31
    //   11792: aload 33
    //   11794: astore 28
    //   11796: goto -11733 -> 63
    //   11799: astore 33
    //   11801: goto +8 -> 11809
    //   11804: astore 33
    //   11806: goto +3 -> 11809
    //   11809: aload 24
    //   11811: astore 34
    //   11813: aload 27
    //   11815: astore 37
    //   11817: aload 30
    //   11819: astore 24
    //   11821: aload 33
    //   11823: astore 27
    //   11825: lload 12
    //   11827: lstore 14
    //   11829: lload 8
    //   11831: lstore 12
    //   11833: aload 26
    //   11835: astore 30
    //   11837: aload 25
    //   11839: astore 26
    //   11841: aload 37
    //   11843: astore 25
    //   11845: lload 14
    //   11847: lstore 8
    //   11849: aload 36
    //   11851: astore 37
    //   11853: aload_2
    //   11854: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11857: lload 18
    //   11859: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   11862: invokevirtual 382	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   11865: aload_2
    //   11866: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11869: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   11872: aload_0
    //   11873: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   11876: lsub
    //   11877: putfield 385	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   11880: aload_2
    //   11881: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11884: aload_0
    //   11885: getfield 388	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTaskStartTimeStamp	J
    //   11888: putfield 391	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   11891: aload_0
    //   11892: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   11895: invokestatic 397	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   11898: invokevirtual 401	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   11901: astore 38
    //   11903: aload_0
    //   11904: getfield 83	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mRemoteAddress	Ljava/lang/String;
    //   11907: astore 40
    //   11909: aload_0
    //   11910: aconst_null
    //   11911: aconst_null
    //   11912: aload 31
    //   11914: invokevirtual 405	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   11917: astore 39
    //   11919: aload_0
    //   11920: getfield 73	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsEnd	J
    //   11923: aload_0
    //   11924: getfield 70	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsStart	J
    //   11927: lsub
    //   11928: lstore 14
    //   11930: aload 31
    //   11932: ifnull +27 -> 11959
    //   11935: aload 31
    //   11937: invokevirtual 408	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   11940: ifnull +19 -> 11959
    //   11943: aload 31
    //   11945: invokevirtual 408	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   11948: ldc_w 410
    //   11951: invokevirtual 108	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   11954: astore 33
    //   11956: goto +6 -> 11962
    //   11959: aconst_null
    //   11960: astore 33
    //   11962: aload_2
    //   11963: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11966: aload 33
    //   11968: putfield 413	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   11971: aload_0
    //   11972: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   11975: astore 36
    //   11977: aload_1
    //   11978: invokeinterface 194 1 0
    //   11983: ifne +2172 -> 14155
    //   11986: aload_0
    //   11987: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   11990: invokestatic 204	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   11993: istore 6
    //   11995: aload_2
    //   11996: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11999: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12002: ifne +754 -> 12756
    //   12005: new 359	java/lang/StringBuilder
    //   12008: dup
    //   12009: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   12012: astore 41
    //   12014: aload 41
    //   12016: ldc_w 418
    //   12019: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12022: pop
    //   12023: aload 41
    //   12025: aload_0
    //   12026: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   12029: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12032: pop
    //   12033: aload 41
    //   12035: aload 35
    //   12037: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12040: pop
    //   12041: aload 41
    //   12043: aload_0
    //   12044: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   12047: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12050: pop
    //   12051: aload 41
    //   12053: aload 37
    //   12055: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12058: pop
    //   12059: aload_0
    //   12060: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   12063: ifeq +29 -> 12092
    //   12066: aload 31
    //   12068: ifnull +24 -> 12092
    //   12071: aload 31
    //   12073: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12076: ifnull +16 -> 12092
    //   12079: aload 31
    //   12081: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12084: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   12087: astore 35
    //   12089: goto +8 -> 12097
    //   12092: ldc_w 434
    //   12095: astore 35
    //   12097: aload 41
    //   12099: aload 35
    //   12101: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12104: pop
    //   12105: aload 41
    //   12107: ldc_w 436
    //   12110: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12113: pop
    //   12114: aload 41
    //   12116: aload 38
    //   12118: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12121: pop
    //   12122: aload 41
    //   12124: ldc_w 441
    //   12127: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12130: pop
    //   12131: aload 41
    //   12133: aload 40
    //   12135: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12138: pop
    //   12139: aload 41
    //   12141: ldc_w 443
    //   12144: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12147: pop
    //   12148: aload 41
    //   12150: aconst_null
    //   12151: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12154: pop
    //   12155: aload 41
    //   12157: ldc_w 445
    //   12160: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12163: pop
    //   12164: aload 41
    //   12166: invokestatic 449	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12169: invokevirtual 452	java/lang/Thread:getId	()J
    //   12172: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12175: pop
    //   12176: aload 41
    //   12178: ldc_w 457
    //   12181: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12184: pop
    //   12185: aload 41
    //   12187: invokestatic 462	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   12190: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12193: pop
    //   12194: aload 41
    //   12196: ldc_w 464
    //   12199: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12202: pop
    //   12203: aload 41
    //   12205: iload 6
    //   12207: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12210: pop
    //   12211: aload 41
    //   12213: ldc_w 466
    //   12216: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12219: pop
    //   12220: aload 41
    //   12222: invokestatic 471	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   12225: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12228: pop
    //   12229: aload 41
    //   12231: aload 30
    //   12233: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12236: pop
    //   12237: aload 41
    //   12239: aload_2
    //   12240: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12243: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   12246: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12249: pop
    //   12250: aload 41
    //   12252: aload 28
    //   12254: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12257: pop
    //   12258: aload 41
    //   12260: aload_2
    //   12261: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12264: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   12267: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12270: pop
    //   12271: aload 41
    //   12273: aload 25
    //   12275: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12278: pop
    //   12279: aload 41
    //   12281: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   12284: aload_0
    //   12285: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   12288: lsub
    //   12289: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12292: pop
    //   12293: aload 41
    //   12295: ldc_w 482
    //   12298: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12301: pop
    //   12302: aload 41
    //   12304: aload_2
    //   12305: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12308: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   12311: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12314: pop
    //   12315: aload 41
    //   12317: aload 32
    //   12319: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12322: pop
    //   12323: aload 41
    //   12325: aload_2
    //   12326: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12329: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   12332: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12335: pop
    //   12336: aload 41
    //   12338: ldc_w 487
    //   12341: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12344: pop
    //   12345: aload 41
    //   12347: aload_2
    //   12348: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12351: getfield 490	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   12354: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12357: pop
    //   12358: aload 41
    //   12360: ldc_w 492
    //   12363: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12366: pop
    //   12367: aload 41
    //   12369: aload_0
    //   12370: invokevirtual 208	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   12373: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12376: pop
    //   12377: aload 41
    //   12379: aload 34
    //   12381: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12384: pop
    //   12385: aload 41
    //   12387: aload_0
    //   12388: invokevirtual 211	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   12391: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12394: pop
    //   12395: aload 41
    //   12397: ldc_w 494
    //   12400: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12403: pop
    //   12404: aload 41
    //   12406: aload_2
    //   12407: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12410: invokevirtual 497	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   12413: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12416: pop
    //   12417: aload 41
    //   12419: ldc_w 499
    //   12422: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12425: pop
    //   12426: aload 41
    //   12428: iload_3
    //   12429: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12432: pop
    //   12433: aload 41
    //   12435: aload 26
    //   12437: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12440: pop
    //   12441: aload 41
    //   12443: aload 39
    //   12445: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12448: pop
    //   12449: aload 41
    //   12451: aload 29
    //   12453: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12456: pop
    //   12457: aload 41
    //   12459: aload 33
    //   12461: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12464: pop
    //   12465: aload 41
    //   12467: ldc_w 501
    //   12470: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12473: pop
    //   12474: aload 41
    //   12476: aload_0
    //   12477: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   12480: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12483: pop
    //   12484: aload 41
    //   12486: ldc_w 503
    //   12489: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12492: pop
    //   12493: aload 41
    //   12495: aload_2
    //   12496: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12499: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   12502: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12505: pop
    //   12506: aload 41
    //   12508: ldc_w 508
    //   12511: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12514: pop
    //   12515: aload 41
    //   12517: lload 14
    //   12519: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12522: pop
    //   12523: aload 41
    //   12525: ldc_w 510
    //   12528: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12531: pop
    //   12532: aload 41
    //   12534: lload 10
    //   12536: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12539: pop
    //   12540: aload 41
    //   12542: aload 34
    //   12544: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12547: pop
    //   12548: aload 41
    //   12550: iconst_0
    //   12551: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12554: pop
    //   12555: aload 41
    //   12557: ldc_w 512
    //   12560: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12563: pop
    //   12564: aload 41
    //   12566: lconst_0
    //   12567: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12570: pop
    //   12571: aload 41
    //   12573: aload 34
    //   12575: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12578: pop
    //   12579: aload 41
    //   12581: iconst_0
    //   12582: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12585: pop
    //   12586: aload 41
    //   12588: ldc_w 514
    //   12591: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12594: pop
    //   12595: aload 41
    //   12597: lload 8
    //   12599: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12602: pop
    //   12603: aload 41
    //   12605: ldc_w 516
    //   12608: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12611: pop
    //   12612: aload 41
    //   12614: aload_0
    //   12615: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   12618: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12621: pop
    //   12622: aload 41
    //   12624: ldc_w 521
    //   12627: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12630: pop
    //   12631: aload 41
    //   12633: aload_0
    //   12634: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   12637: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12640: pop
    //   12641: aload 41
    //   12643: ldc_w 526
    //   12646: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12649: pop
    //   12650: aload_0
    //   12651: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12654: ifnull +17 -> 12671
    //   12657: aload_0
    //   12658: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12661: invokeinterface 536 1 0
    //   12666: astore 34
    //   12668: goto +6 -> 12674
    //   12671: aconst_null
    //   12672: astore 34
    //   12674: aload 41
    //   12676: aload 34
    //   12678: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12681: pop
    //   12682: aload 41
    //   12684: ldc_w 538
    //   12687: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12690: pop
    //   12691: aload 41
    //   12693: aload_2
    //   12694: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12697: getfield 541	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   12700: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12703: pop
    //   12704: aload 24
    //   12706: aload 41
    //   12708: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12711: putfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12714: ldc_w 546
    //   12717: aload 24
    //   12719: getfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12722: aconst_null
    //   12723: invokestatic 549	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12726: aload 36
    //   12728: ifnull +25 -> 12753
    //   12731: aload 36
    //   12733: ldc_w 551
    //   12736: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12739: ifeq +11 -> 12750
    //   12742: aload_0
    //   12743: invokevirtual 258	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   12746: iconst_0
    //   12747: invokestatic 561	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   12750: goto +3 -> 12753
    //   12753: goto +693 -> 13446
    //   12756: new 359	java/lang/StringBuilder
    //   12759: dup
    //   12760: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   12763: astore 41
    //   12765: aload 41
    //   12767: ldc_w 563
    //   12770: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12773: pop
    //   12774: aload 41
    //   12776: aload_0
    //   12777: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   12780: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12783: pop
    //   12784: aload 41
    //   12786: aload 35
    //   12788: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12791: pop
    //   12792: aload 41
    //   12794: aload_0
    //   12795: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   12798: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12801: pop
    //   12802: aload 41
    //   12804: aload 37
    //   12806: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12809: pop
    //   12810: aload_0
    //   12811: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   12814: ifeq +29 -> 12843
    //   12817: aload 31
    //   12819: ifnull +24 -> 12843
    //   12822: aload 31
    //   12824: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12827: ifnull +16 -> 12843
    //   12830: aload 31
    //   12832: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12835: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   12838: astore 35
    //   12840: goto +8 -> 12848
    //   12843: ldc_w 434
    //   12846: astore 35
    //   12848: aload 41
    //   12850: aload 35
    //   12852: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12855: pop
    //   12856: aload 41
    //   12858: ldc_w 436
    //   12861: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12864: pop
    //   12865: aload 41
    //   12867: aload 38
    //   12869: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12872: pop
    //   12873: aload 41
    //   12875: ldc_w 441
    //   12878: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12881: pop
    //   12882: aload 41
    //   12884: aload 40
    //   12886: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12889: pop
    //   12890: aload 41
    //   12892: ldc_w 443
    //   12895: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12898: pop
    //   12899: aload 41
    //   12901: aconst_null
    //   12902: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12905: pop
    //   12906: aload 41
    //   12908: ldc_w 445
    //   12911: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12914: pop
    //   12915: aload 41
    //   12917: invokestatic 449	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12920: invokevirtual 452	java/lang/Thread:getId	()J
    //   12923: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12926: pop
    //   12927: aload 41
    //   12929: ldc_w 457
    //   12932: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12935: pop
    //   12936: aload 41
    //   12938: invokestatic 462	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   12941: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12944: pop
    //   12945: aload 41
    //   12947: ldc_w 466
    //   12950: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12953: pop
    //   12954: aload 41
    //   12956: invokestatic 471	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   12959: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12962: pop
    //   12963: aload 41
    //   12965: aload 28
    //   12967: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12970: pop
    //   12971: aload 41
    //   12973: aload_2
    //   12974: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12977: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   12980: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12983: pop
    //   12984: aload 41
    //   12986: aload 25
    //   12988: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12991: pop
    //   12992: aload 41
    //   12994: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   12997: aload_0
    //   12998: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   13001: lsub
    //   13002: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13005: pop
    //   13006: aload 41
    //   13008: ldc_w 482
    //   13011: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13014: pop
    //   13015: aload 41
    //   13017: aload_2
    //   13018: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13021: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13024: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13027: pop
    //   13028: aload 41
    //   13030: aload 32
    //   13032: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13035: pop
    //   13036: aload 41
    //   13038: aload_2
    //   13039: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13042: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13045: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13048: pop
    //   13049: aload 41
    //   13051: ldc_w 487
    //   13054: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13057: pop
    //   13058: aload 41
    //   13060: aload_2
    //   13061: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13064: getfield 490	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   13067: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13070: pop
    //   13071: aload 41
    //   13073: ldc_w 492
    //   13076: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13079: pop
    //   13080: aload 41
    //   13082: aload_0
    //   13083: invokevirtual 208	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   13086: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13089: pop
    //   13090: aload 41
    //   13092: aload 34
    //   13094: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13097: pop
    //   13098: aload 41
    //   13100: aload_0
    //   13101: invokevirtual 211	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   13104: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13107: pop
    //   13108: aload 41
    //   13110: ldc_w 565
    //   13113: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13116: pop
    //   13117: aload 41
    //   13119: iload_3
    //   13120: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13123: pop
    //   13124: aload 41
    //   13126: aload 26
    //   13128: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13131: pop
    //   13132: aload 41
    //   13134: aload 39
    //   13136: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13139: pop
    //   13140: aload 41
    //   13142: aload 30
    //   13144: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13147: pop
    //   13148: aload 41
    //   13150: aload_2
    //   13151: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13154: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13157: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13160: pop
    //   13161: aload 41
    //   13163: aload 29
    //   13165: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13168: pop
    //   13169: aload 41
    //   13171: aload 33
    //   13173: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13176: pop
    //   13177: aload 41
    //   13179: ldc_w 501
    //   13182: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13185: pop
    //   13186: aload 41
    //   13188: aload_0
    //   13189: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   13192: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13195: pop
    //   13196: aload 41
    //   13198: ldc_w 503
    //   13201: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13204: pop
    //   13205: aload 41
    //   13207: aload_2
    //   13208: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13211: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13214: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13217: pop
    //   13218: aload 41
    //   13220: ldc_w 508
    //   13223: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13226: pop
    //   13227: aload 41
    //   13229: lload 14
    //   13231: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13234: pop
    //   13235: aload 41
    //   13237: ldc_w 510
    //   13240: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13243: pop
    //   13244: aload 41
    //   13246: lload 10
    //   13248: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13251: pop
    //   13252: aload 41
    //   13254: aload 34
    //   13256: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13259: pop
    //   13260: aload 41
    //   13262: iconst_0
    //   13263: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13266: pop
    //   13267: aload 41
    //   13269: ldc_w 512
    //   13272: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13275: pop
    //   13276: aload 41
    //   13278: lconst_0
    //   13279: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13282: pop
    //   13283: aload 41
    //   13285: aload 34
    //   13287: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13290: pop
    //   13291: aload 41
    //   13293: iconst_0
    //   13294: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13297: pop
    //   13298: aload 41
    //   13300: ldc_w 514
    //   13303: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13306: pop
    //   13307: aload 41
    //   13309: lload 8
    //   13311: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13314: pop
    //   13315: aload 41
    //   13317: ldc_w 516
    //   13320: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13323: pop
    //   13324: aload 41
    //   13326: aload_0
    //   13327: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   13330: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13333: pop
    //   13334: aload 41
    //   13336: ldc_w 521
    //   13339: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13342: pop
    //   13343: aload 41
    //   13345: aload_0
    //   13346: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   13349: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13352: pop
    //   13353: aload 41
    //   13355: ldc_w 526
    //   13358: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13361: pop
    //   13362: aload_0
    //   13363: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13366: ifnull +17 -> 13383
    //   13369: aload_0
    //   13370: getfield 530	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13373: invokeinterface 536 1 0
    //   13378: astore 34
    //   13380: goto +6 -> 13386
    //   13383: aconst_null
    //   13384: astore 34
    //   13386: aload 41
    //   13388: aload 34
    //   13390: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13393: pop
    //   13394: aload 41
    //   13396: ldc_w 538
    //   13399: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13402: pop
    //   13403: aload 41
    //   13405: aload_2
    //   13406: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13409: getfield 541	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   13412: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13415: pop
    //   13416: aload 41
    //   13418: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13421: astore 35
    //   13423: aload 24
    //   13425: astore 34
    //   13427: aload 34
    //   13429: aload 35
    //   13431: putfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13434: ldc_w 546
    //   13437: aload 34
    //   13439: getfield 544	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13442: aconst_null
    //   13443: invokestatic 568	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   13446: aload 36
    //   13448: astore 34
    //   13450: aload 24
    //   13452: astore 35
    //   13454: iload 6
    //   13456: ifne +11 -> 13467
    //   13459: aload_0
    //   13460: iconst_0
    //   13461: putfield 571	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mShouldReport	Z
    //   13464: goto +3 -> 13467
    //   13467: aload_2
    //   13468: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13471: astore 36
    //   13473: new 359	java/lang/StringBuilder
    //   13476: dup
    //   13477: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   13480: astore 37
    //   13482: aload 37
    //   13484: aload_0
    //   13485: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   13488: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13491: pop
    //   13492: aload 37
    //   13494: ldc_w 573
    //   13497: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13500: pop
    //   13501: aload 37
    //   13503: aload 40
    //   13505: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13508: pop
    //   13509: aload 37
    //   13511: ldc_w 575
    //   13514: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13517: pop
    //   13518: aload 37
    //   13520: aload_2
    //   13521: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13524: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13527: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13530: pop
    //   13531: aload 37
    //   13533: ldc_w 577
    //   13536: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13539: pop
    //   13540: aload_0
    //   13541: getfield 581	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13544: ifnull +15 -> 13559
    //   13547: aload_0
    //   13548: getfield 581	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13551: getfield 584	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13554: istore 4
    //   13556: goto +6 -> 13562
    //   13559: iconst_0
    //   13560: istore 4
    //   13562: aload 37
    //   13564: iload 4
    //   13566: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13569: pop
    //   13570: aload 37
    //   13572: ldc_w 499
    //   13575: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13578: pop
    //   13579: aload 37
    //   13581: iload_3
    //   13582: invokevirtual 474	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13585: pop
    //   13586: aload 37
    //   13588: aload 30
    //   13590: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13593: pop
    //   13594: aload 37
    //   13596: aload_2
    //   13597: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13600: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13603: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13606: pop
    //   13607: aload 37
    //   13609: ldc_w 482
    //   13612: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13615: pop
    //   13616: aload 37
    //   13618: aload_2
    //   13619: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13622: getfield 353	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13625: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13628: pop
    //   13629: aload 37
    //   13631: aload 32
    //   13633: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13636: pop
    //   13637: aload 37
    //   13639: aload_2
    //   13640: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13643: getfield 485	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13646: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13649: pop
    //   13650: aload 37
    //   13652: aload 28
    //   13654: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13657: pop
    //   13658: aload 37
    //   13660: aload_2
    //   13661: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13664: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13667: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13670: pop
    //   13671: aload 37
    //   13673: aload 25
    //   13675: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13678: pop
    //   13679: aload 37
    //   13681: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   13684: aload_0
    //   13685: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   13688: lsub
    //   13689: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13692: pop
    //   13693: aload 33
    //   13695: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13698: ifne +38 -> 13736
    //   13701: new 359	java/lang/StringBuilder
    //   13704: dup
    //   13705: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   13708: astore 24
    //   13710: aload 24
    //   13712: aload 29
    //   13714: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13717: pop
    //   13718: aload 24
    //   13720: aload 33
    //   13722: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13725: pop
    //   13726: aload 24
    //   13728: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13731: astore 24
    //   13733: goto +8 -> 13741
    //   13736: ldc_w 586
    //   13739: astore 24
    //   13741: aload 37
    //   13743: aload 24
    //   13745: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13748: pop
    //   13749: aload 37
    //   13751: aload 26
    //   13753: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13756: pop
    //   13757: aload 37
    //   13759: aload 39
    //   13761: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13764: pop
    //   13765: aload 36
    //   13767: aload 37
    //   13769: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13772: putfield 589	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   13775: iload 6
    //   13777: ifeq +73 -> 13850
    //   13780: aload_0
    //   13781: getfield 198	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   13784: invokestatic 594	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   13787: astore 25
    //   13789: aload_0
    //   13790: invokevirtual 177	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   13793: astore 26
    //   13795: aload_0
    //   13796: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   13799: ifeq +29 -> 13828
    //   13802: aload 34
    //   13804: astore 24
    //   13806: aload 24
    //   13808: ifnull +20 -> 13828
    //   13811: aload 24
    //   13813: ldc_w 596
    //   13816: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13819: ifeq +9 -> 13828
    //   13822: iconst_1
    //   13823: istore 6
    //   13825: goto +6 -> 13831
    //   13828: iconst_0
    //   13829: istore 6
    //   13831: aload 25
    //   13833: aload 26
    //   13835: iload 6
    //   13837: aload_2
    //   13838: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13841: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13844: invokevirtual 600	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   13847: goto +3 -> 13850
    //   13850: aload 35
    //   13852: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   13855: putfield 603	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   13858: aload 35
    //   13860: aload_0
    //   13861: invokevirtual 606	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getContentLength	()J
    //   13864: putfield 609	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   13867: aload 35
    //   13869: aload 31
    //   13871: putfield 613	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   13874: aload 35
    //   13876: iload_3
    //   13877: putfield 616	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   13880: aload 35
    //   13882: aconst_null
    //   13883: putfield 620	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   13886: aload 38
    //   13888: ifnonnull +9 -> 13897
    //   13891: aconst_null
    //   13892: astore 24
    //   13894: goto +10 -> 13904
    //   13897: aload 38
    //   13899: invokevirtual 623	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   13902: astore 24
    //   13904: aload 35
    //   13906: aload 24
    //   13908: putfield 626	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   13911: aload 35
    //   13913: aconst_null
    //   13914: putfield 629	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   13917: aload 35
    //   13919: aload_2
    //   13920: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13923: getfield 506	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13926: putfield 630	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   13929: aload 35
    //   13931: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   13934: aload_0
    //   13935: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   13938: lsub
    //   13939: putfield 633	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   13942: aload 35
    //   13944: aload_2
    //   13945: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13948: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13951: putfield 636	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   13954: aload 35
    //   13956: aload 35
    //   13958: getfield 633	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   13961: aload_2
    //   13962: invokevirtual 376	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13965: getfield 480	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13968: lsub
    //   13969: putfield 639	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   13972: aload 35
    //   13974: lload 12
    //   13976: putfield 642	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   13979: aload 35
    //   13981: lload 10
    //   13983: putfield 645	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   13986: aload 35
    //   13988: lload 8
    //   13990: putfield 648	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   13993: aload 35
    //   13995: aload_0
    //   13996: getfield 519	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   13999: putfield 651	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   14002: aload 35
    //   14004: lconst_0
    //   14005: putfield 654	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   14008: aload 35
    //   14010: aload_0
    //   14011: invokevirtual 524	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   14014: putfield 657	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   14017: aload 35
    //   14019: aload_2
    //   14020: invokevirtual 348	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14023: getfield 477	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   14026: putfield 660	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   14029: aload 35
    //   14031: aload_0
    //   14032: invokevirtual 258	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   14035: invokestatic 663	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   14038: putfield 665	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   14041: aload 35
    //   14043: aload_0
    //   14044: getfield 422	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   14047: putfield 668	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   14050: aload 34
    //   14052: ifnull +20 -> 14072
    //   14055: aload 34
    //   14057: ldc_w 596
    //   14060: invokevirtual 555	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14063: ifeq +9 -> 14072
    //   14066: iconst_1
    //   14067: istore 6
    //   14069: goto +6 -> 14075
    //   14072: iconst_0
    //   14073: istore 6
    //   14075: aload 35
    //   14077: iload 6
    //   14079: putfield 671	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   14082: aload 35
    //   14084: aload_2
    //   14085: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14088: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14091: putfield 673	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   14094: aload 35
    //   14096: getstatic 679	com/tencent/component/network/downloader/Downloader$DownloadMode:OkHttpMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   14099: invokevirtual 682	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   14102: putfield 685	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   14105: aload 31
    //   14107: ifnull +24 -> 14131
    //   14110: aload 31
    //   14112: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14115: ifnull +16 -> 14131
    //   14118: aload 35
    //   14120: aload 31
    //   14122: invokevirtual 429	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14125: invokevirtual 432	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   14128: putfield 687	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   14131: aload_2
    //   14132: aload 35
    //   14134: invokevirtual 691	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   14137: aload_2
    //   14138: invokevirtual 217	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14141: invokevirtual 416	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14144: ifeq +11 -> 14155
    //   14147: aload_0
    //   14148: aload_1
    //   14149: aload_2
    //   14150: aload 35
    //   14152: invokevirtual 695	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   14155: goto +6 -> 14161
    //   14158: aload 27
    //   14160: athrow
    //   14161: goto -3 -> 14158
    //   14164: astore 30
    //   14166: goto -14051 -> 115
    //   14169: astore 32
    //   14171: aload 24
    //   14173: astore 37
    //   14175: aload 26
    //   14177: astore 29
    //   14179: aload 33
    //   14181: astore 24
    //   14183: aload 34
    //   14185: astore 26
    //   14187: aload 28
    //   14189: astore 34
    //   14191: aload 31
    //   14193: astore 33
    //   14195: lload 10
    //   14197: lstore 8
    //   14199: aload 25
    //   14201: astore 31
    //   14203: aload 27
    //   14205: astore 25
    //   14207: aload 26
    //   14209: astore 27
    //   14211: aload 37
    //   14213: astore 26
    //   14215: aload 32
    //   14217: astore 28
    //   14219: aload 33
    //   14221: astore 32
    //   14223: goto -10959 -> 3264
    //   14226: astore 38
    //   14228: aload 33
    //   14230: astore 29
    //   14232: aload 34
    //   14234: astore 37
    //   14236: aload 28
    //   14238: astore 32
    //   14240: aload 31
    //   14242: astore 33
    //   14244: lload 10
    //   14246: lstore 14
    //   14248: aload 25
    //   14250: astore 31
    //   14252: lload 8
    //   14254: lstore 10
    //   14256: aload 38
    //   14258: astore 34
    //   14260: aload 37
    //   14262: astore 28
    //   14264: aload 24
    //   14266: astore 25
    //   14268: aload 32
    //   14270: astore 24
    //   14272: aload 33
    //   14274: astore 32
    //   14276: lload 8
    //   14278: lstore 12
    //   14280: lload 14
    //   14282: lstore 8
    //   14284: goto -5008 -> 9276
    //   14287: sipush 200
    //   14290: iload_3
    //   14291: if_icmpeq -10712 -> 3579
    //   14294: sipush 206
    //   14297: iload_3
    //   14298: if_icmpne -10754 -> 3544
    //   14301: goto -10722 -> 3579
    //   14304: goto -10736 -> 3568
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	14307	0	this	OkHttpDownloadTask
    //   0	14307	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	14307	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   54	14245	3	i	int
    //   234	13331	4	j	int
    //   226	10858	5	k	int
    //   609	13469	6	bool1	boolean
    //   58	65	7	bool2	boolean
    //   61	14222	8	l1	long
    //   372	13883	10	l2	long
    //   383	13896	12	l3	long
    //   369	13912	14	l4	long
    //   3026	26	16	l5	long
    //   147	11711	18	l6	long
    //   3016	25	20	l7	long
    //   3031	8	22	l8	long
    //   18	8626	24	localObject1	java.lang.Object
    //   8652	1	24	localThrowable1	Throwable
    //   8673	1	24	localObject2	java.lang.Object
    //   8698	48	24	localThrowable2	Throwable
    //   8751	5520	24	localObject3	java.lang.Object
    //   14	14253	25	localObject4	java.lang.Object
    //   10	14204	26	localObject5	java.lang.Object
    //   30	3033	27	localObject6	java.lang.Object
    //   3067	89	27	localThrowable3	Throwable
    //   3161	2794	27	localObject7	java.lang.Object
    //   5971	102	27	localThrowable4	Throwable
    //   6078	2542	27	localObject8	java.lang.Object
    //   8657	227	27	localObject9	java.lang.Object
    //   8905	5305	27	localObject10	java.lang.Object
    //   34	3000	28	localObject11	java.lang.Object
    //   3058	1	28	localObject12	java.lang.Object
    //   3071	5520	28	localObject13	java.lang.Object
    //   8611	1	28	localObject14	java.lang.Object
    //   8689	5574	28	localObject15	java.lang.Object
    //   26	14205	29	localObject16	java.lang.Object
    //   156	13433	30	localObject17	java.lang.Object
    //   14164	1	30	localException	java.lang.Exception
    //   22	161	31	str	String
    //   354	40	31	localObject18	java.lang.Object
    //   399	13852	31	localObject19	java.lang.Object
    //   217	5577	32	localObject20	java.lang.Object
    //   5894	59	32	localObject21	java.lang.Object
    //   5962	46	32	localObject22	java.lang.Object
    //   6020	57	32	localObject23	java.lang.Object
    //   6082	3033	32	localObject24	java.lang.Object
    //   9125	1	32	localObject25	java.lang.Object
    //   9148	54	32	localObject26	java.lang.Object
    //   9207	4425	32	localObject27	java.lang.Object
    //   14169	47	32	localObject28	java.lang.Object
    //   14221	54	32	localObject29	java.lang.Object
    //   184	2996	33	localObject30	java.lang.Object
    //   3190	1	33	localObject31	java.lang.Object
    //   3200	3	33	localObject32	java.lang.Object
    //   3212	8581	33	localObject33	java.lang.Object
    //   11799	1	33	localObject34	java.lang.Object
    //   11804	18	33	localObject35	java.lang.Object
    //   11954	2319	33	localObject36	java.lang.Object
    //   223	49	34	localObject37	java.lang.Object
    //   346	1	34	localThrowable5	Throwable
    //   391	1	34	localObject38	java.lang.Object
    //   430	1	34	localThrowable6	Throwable
    //   566	1958	34	localObject39	java.lang.Object
    //   2964	1	34	localThrowable7	Throwable
    //   2971	140	34	localObject40	java.lang.Object
    //   3123	1	34	localThrowable8	Throwable
    //   3195	1	34	localThrowable9	Throwable
    //   3204	47	34	localObject41	java.lang.Object
    //   3311	15	34	localThrowable10	Throwable
    //   3337	5692	34	localObject42	java.lang.Object
    //   9053	11	34	localObject43	java.lang.Object
    //   9081	1	34	localObject44	java.lang.Object
    //   9112	1	34	localThrowable11	Throwable
    //   9134	1	34	localThrowable12	Throwable
    //   9143	1	34	localThrowable13	Throwable
    //   9160	1	34	localObject45	java.lang.Object
    //   9216	2194	34	localThrowable14	Throwable
    //   11811	2448	34	localObject46	java.lang.Object
    //   6	14145	35	localObject47	java.lang.Object
    //   2	13764	36	localObject48	java.lang.Object
    //   296	1964	37	localObject49	java.lang.Object
    //   2959	1	37	localObject50	java.lang.Object
    //   2979	68	37	localObject51	java.lang.Object
    //   3080	1	37	localObject52	java.lang.Object
    //   3139	5795	37	localObject53	java.lang.Object
    //   8970	35	37	localThrowable15	Throwable
    //   9014	5247	37	localObject54	java.lang.Object
    //   281	8440	38	localObject55	java.lang.Object
    //   8743	27	38	localObject56	java.lang.Object
    //   8796	35	38	localThrowable16	Throwable
    //   8861	51	38	localObject57	java.lang.Object
    //   8917	4981	38	localObject58	java.lang.Object
    //   14226	31	38	localThrowable17	Throwable
    //   366	5136	39	localObject59	java.lang.Object
    //   6091	35	39	localThrowable18	Throwable
    //   6158	7602	39	localObject60	java.lang.Object
    //   716	12788	40	localObject61	java.lang.Object
    //   821	12596	41	localObject62	java.lang.Object
    //   6166	4857	42	localObject63	java.lang.Object
    //   6192	5105	43	localObject64	java.lang.Object
    //   10999	300	44	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   310	343	346	java/lang/Throwable
    //   236	252	354	finally
    //   258	268	354	finally
    //   271	283	354	finally
    //   286	298	354	finally
    //   301	310	354	finally
    //   310	343	354	finally
    //   236	252	430	java/lang/Throwable
    //   258	268	430	java/lang/Throwable
    //   271	283	430	java/lang/Throwable
    //   286	298	430	java/lang/Throwable
    //   301	310	430	java/lang/Throwable
    //   616	662	2959	finally
    //   616	662	2964	java/lang/Throwable
    //   3037	3051	3058	finally
    //   3037	3051	3067	java/lang/Throwable
    //   2997	3033	3080	finally
    //   2997	3033	3123	java/lang/Throwable
    //   573	611	3190	finally
    //   573	611	3195	java/lang/Throwable
    //   553	568	3200	finally
    //   553	568	3311	java/lang/Throwable
    //   3442	3495	5894	finally
    //   3579	3586	5894	finally
    //   3442	3495	5971	java/lang/Throwable
    //   3579	3586	5971	java/lang/Throwable
    //   3436	3442	6020	finally
    //   3436	3442	6091	java/lang/Throwable
    //   6194	6200	8611	finally
    //   6194	6200	8652	java/lang/Throwable
    //   6188	6194	8657	finally
    //   6188	6194	8698	java/lang/Throwable
    //   3413	3431	8743	finally
    //   3413	3431	8796	java/lang/Throwable
    //   542	548	8861	finally
    //   542	548	8970	java/lang/Throwable
    //   530	535	9053	finally
    //   530	535	9112	java/lang/Throwable
    //   511	530	9125	finally
    //   511	530	9134	java/lang/Throwable
    //   490	504	9143	java/lang/Throwable
    //   203	225	9148	finally
    //   490	504	9148	finally
    //   203	225	9216	java/lang/Throwable
    //   9293	9342	11799	finally
    //   9284	9293	11804	finally
    //   106	112	14164	java/lang/Exception
    //   3500	3541	14169	finally
    //   3544	3565	14169	finally
    //   3568	3576	14169	finally
    //   3500	3541	14226	java/lang/Throwable
    //   3544	3565	14226	java/lang/Throwable
    //   3568	3576	14226	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.OkHttpDownloadTask
 * JD-Core Version:    0.7.0.1
 */