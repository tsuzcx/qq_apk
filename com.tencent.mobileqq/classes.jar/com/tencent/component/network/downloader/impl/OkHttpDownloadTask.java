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
    long l2 = -1L;
    long l1 = l2;
    if (paramResponse != null)
    {
      if (paramResponse.body() != null) {
        break label24;
      }
      l1 = l2;
    }
    label24:
    do
    {
      do
      {
        do
        {
          return l1;
          l2 = paramResponse.body().contentLength();
          l1 = l2;
        } while (l2 > 0L);
        l1 = l2;
      } while (paramResponse.networkResponse() == null);
      paramResponse = paramResponse.networkResponse().header("content-length");
      l1 = l2;
    } while (TextUtils.isEmpty(paramResponse));
    try
    {
      l1 = Long.parseLong(paramResponse);
      return l1;
    }
    catch (Throwable paramResponse) {}
    return l2;
  }
  
  private void reset()
  {
    this.mLastCallbackProgress = 0.0F;
  }
  
  private long saveToFile(InputStream paramInputStream, String paramString)
  {
    if ((paramInputStream == null) || (TextUtils.isEmpty(paramString))) {
      return 0L;
    }
    paramString = new FileOutputStream(new File(paramString));
    byte[] arrayOfByte = new byte[8192];
    int i = 0;
    long l1 = 0L;
    int j = 0;
    for (;;)
    {
      int k = paramInputStream.read(arrayOfByte, i, 8192 - i);
      if (k == -1) {
        break;
      }
      int m = k + i;
      if (m < 8192)
      {
        i += k;
      }
      else
      {
        paramString.write(arrayOfByte, 0, m);
        l1 += m;
        j += 1;
        i = 0;
      }
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
  
  /* Error */
  public void execute(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 155	java/lang/Object
    //   4: dup
    //   5: iconst_0
    //   6: aload_0
    //   7: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   10: aastore
    //   11: dup
    //   12: iconst_1
    //   13: aload_2
    //   14: aastore
    //   15: invokestatic 165	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:generateRandomId	([Ljava/lang/Object;)I
    //   18: istore 5
    //   20: invokestatic 171	com/tencent/component/network/utils/SDCardUtil:isSdCardHasEnoughCapability	()Z
    //   23: istore 7
    //   25: lconst_0
    //   26: lstore 8
    //   28: aload_1
    //   29: invokeinterface 176 1 0
    //   34: ifeq +4 -> 38
    //   37: return
    //   38: aload_0
    //   39: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   42: invokestatic 186	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   45: ifne +32 -> 77
    //   48: aload_0
    //   49: invokevirtual 190	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   52: aload_0
    //   53: invokevirtual 193	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   56: iconst_1
    //   57: isub
    //   58: if_icmpne +13 -> 71
    //   61: aload_2
    //   62: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   65: bipush 6
    //   67: invokevirtual 205	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   70: return
    //   71: ldc2_w 206
    //   74: invokestatic 213	java/lang/Thread:sleep	(J)V
    //   77: iload 7
    //   79: ifne +24 -> 103
    //   82: aload_2
    //   83: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   86: iconst_2
    //   87: invokevirtual 205	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   90: return
    //   91: astore 20
    //   93: ldc 215
    //   95: ldc 217
    //   97: invokestatic 223	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: goto -23 -> 77
    //   103: aload_0
    //   104: invokespecial 225	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:reset	()V
    //   107: aload_2
    //   108: invokevirtual 226	com/tencent/component/network/downloader/DownloadResult:reset	()V
    //   111: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   114: lstore 16
    //   116: new 228	com/tencent/component/network/downloader/DownloadReport
    //   119: dup
    //   120: invokespecial 230	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   123: astore 24
    //   125: aload 24
    //   127: iload 5
    //   129: putfield 234	com/tencent/component/network/downloader/DownloadReport:id	I
    //   132: aload 24
    //   134: aload_0
    //   135: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   138: putfield 237	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   141: aload 24
    //   143: aload_0
    //   144: invokevirtual 240	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   147: putfield 243	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   150: aload 24
    //   152: invokestatic 248	java/lang/System:currentTimeMillis	()J
    //   155: putfield 251	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   158: aload 24
    //   160: aload_0
    //   161: invokevirtual 190	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   164: putfield 254	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   167: iconst_0
    //   168: istore 4
    //   170: aconst_null
    //   171: astore 20
    //   173: lconst_0
    //   174: lstore 14
    //   176: lconst_0
    //   177: lstore 10
    //   179: new 256	okhttp3/Request$Builder
    //   182: dup
    //   183: invokespecial 257	okhttp3/Request$Builder:<init>	()V
    //   186: aload_0
    //   187: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   190: invokevirtual 260	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   193: astore 21
    //   195: aload_0
    //   196: getfield 264	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mHttpParams	Ljava/util/Map;
    //   199: ifnull +1414 -> 1613
    //   202: aload_0
    //   203: getfield 264	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mHttpParams	Ljava/util/Map;
    //   206: invokeinterface 270 1 0
    //   211: invokeinterface 276 1 0
    //   216: astore 22
    //   218: aload 22
    //   220: invokeinterface 281 1 0
    //   225: ifeq +1388 -> 1613
    //   228: aload 22
    //   230: invokeinterface 285 1 0
    //   235: checkcast 287	java/util/Map$Entry
    //   238: astore 25
    //   240: aload 25
    //   242: invokeinterface 290 1 0
    //   247: checkcast 292	java/lang/String
    //   250: astore 23
    //   252: aload 25
    //   254: invokeinterface 295 1 0
    //   259: checkcast 292	java/lang/String
    //   262: astore 25
    //   264: aload 23
    //   266: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   269: ifne -51 -> 218
    //   272: aload 25
    //   274: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   277: ifne -59 -> 218
    //   280: aload 21
    //   282: aload 23
    //   284: aload 25
    //   286: invokevirtual 298	okhttp3/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   289: pop
    //   290: goto -72 -> 218
    //   293: astore 21
    //   295: lconst_0
    //   296: lstore 12
    //   298: lconst_0
    //   299: lstore 10
    //   301: iconst_0
    //   302: istore_3
    //   303: ldc 215
    //   305: new 300	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 303
    //   315: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_0
    //   319: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   322: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 309
    //   328: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: aload 21
    //   336: invokestatic 316	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   339: aload_2
    //   340: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   343: aload 21
    //   345: invokevirtual 319	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   348: aload_2
    //   349: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   352: lload 16
    //   354: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   357: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   360: aload_2
    //   361: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   364: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   367: aload_0
    //   368: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   371: lsub
    //   372: putfield 332	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   375: aload_2
    //   376: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   379: aload_0
    //   380: getfield 335	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTaskStartTimeStamp	J
    //   383: putfield 338	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   386: aload_0
    //   387: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   390: invokestatic 344	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   393: invokevirtual 348	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   396: astore 26
    //   398: aload_0
    //   399: getfield 83	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mRemoteAddress	Ljava/lang/String;
    //   402: astore 28
    //   404: aload_0
    //   405: aconst_null
    //   406: aconst_null
    //   407: aload 20
    //   409: invokevirtual 352	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   412: astore 27
    //   414: aload_0
    //   415: getfield 73	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsEnd	J
    //   418: aload_0
    //   419: getfield 70	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsStart	J
    //   422: lsub
    //   423: lstore 14
    //   425: aload 20
    //   427: ifnull +7030 -> 7457
    //   430: aload 20
    //   432: invokevirtual 355	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   435: ifnull +7022 -> 7457
    //   438: aload 20
    //   440: invokevirtual 355	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   443: ldc_w 357
    //   446: invokevirtual 110	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   449: astore 22
    //   451: aload_2
    //   452: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   455: aload 22
    //   457: putfield 366	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   460: aload_0
    //   461: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   464: astore 25
    //   466: aload_1
    //   467: invokeinterface 176 1 0
    //   472: ifne +1131 -> 1603
    //   475: aload_0
    //   476: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   479: invokestatic 186	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   482: istore 6
    //   484: aload_2
    //   485: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   488: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   491: ifne +6986 -> 7477
    //   494: new 300	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   501: ldc_w 371
    //   504: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload_0
    //   508: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   511: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: ldc_w 373
    //   517: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_0
    //   521: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   524: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: ldc_w 382
    //   530: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: astore 29
    //   535: aload_0
    //   536: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   539: ifeq +6924 -> 7463
    //   542: aload 20
    //   544: ifnull +6919 -> 7463
    //   547: aload 20
    //   549: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   552: ifnull +6911 -> 7463
    //   555: aload 20
    //   557: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   560: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   563: astore 23
    //   565: aload 29
    //   567: aload 23
    //   569: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: ldc_w 391
    //   575: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload 26
    //   580: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   583: ldc_w 396
    //   586: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload 28
    //   591: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: ldc_w 398
    //   597: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aconst_null
    //   601: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: ldc_w 400
    //   607: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokestatic 404	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   613: invokevirtual 407	java/lang/Thread:getId	()J
    //   616: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   619: ldc_w 412
    //   622: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: invokestatic 417	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   628: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: ldc_w 419
    //   634: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: iload 6
    //   639: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   642: ldc_w 421
    //   645: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokestatic 426	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   651: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   654: ldc_w 431
    //   657: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload_2
    //   661: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   664: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   667: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: ldc_w 436
    //   673: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: aload_2
    //   677: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   680: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   683: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   686: ldc_w 441
    //   689: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   695: aload_0
    //   696: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   699: lsub
    //   700: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   703: ldc_w 443
    //   706: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: aload_2
    //   710: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   713: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   716: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   719: ldc_w 448
    //   722: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload_2
    //   726: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   729: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   732: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   735: ldc_w 453
    //   738: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: aload_2
    //   742: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   745: getfield 456	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   748: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   751: ldc_w 458
    //   754: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload_0
    //   758: invokevirtual 190	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   761: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   764: ldc_w 460
    //   767: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: aload_0
    //   771: invokevirtual 193	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   774: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   777: ldc_w 462
    //   780: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload_2
    //   784: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   787: invokevirtual 465	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   790: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   793: ldc_w 467
    //   796: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: iload_3
    //   800: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   803: ldc_w 469
    //   806: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload 27
    //   811: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: ldc_w 471
    //   817: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload 22
    //   822: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: ldc_w 473
    //   828: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: aload_0
    //   832: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   835: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: ldc_w 475
    //   841: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: aload_2
    //   845: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   848: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   851: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: ldc_w 480
    //   857: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: lload 14
    //   862: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   865: ldc_w 482
    //   868: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: lload 10
    //   873: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   876: ldc_w 460
    //   879: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: iconst_0
    //   883: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   886: ldc_w 484
    //   889: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: lconst_0
    //   893: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   896: ldc_w 460
    //   899: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: iconst_0
    //   903: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   906: ldc_w 486
    //   909: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: lload 12
    //   914: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   917: ldc_w 488
    //   920: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: aload_0
    //   924: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   927: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   930: ldc_w 493
    //   933: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: aload_0
    //   937: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   940: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   943: ldc_w 498
    //   946: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: astore 29
    //   951: aload_0
    //   952: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   955: ifnull +6516 -> 7471
    //   958: aload_0
    //   959: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   962: invokeinterface 508 1 0
    //   967: astore 23
    //   969: aload 24
    //   971: aload 29
    //   973: aload 23
    //   975: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   978: ldc_w 510
    //   981: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: aload_2
    //   985: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   988: getfield 513	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   991: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   994: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: putfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1000: ldc_w 518
    //   1003: aload 24
    //   1005: getfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1008: aload 21
    //   1010: invokestatic 316	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1013: iload 6
    //   1015: ifne +8 -> 1023
    //   1018: aload_0
    //   1019: iconst_0
    //   1020: putfield 521	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mShouldReport	Z
    //   1023: aload_2
    //   1024: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1027: astore 23
    //   1029: new 300	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   1036: aload_0
    //   1037: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   1040: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: ldc_w 523
    //   1046: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: aload 28
    //   1051: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: ldc_w 525
    //   1057: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: aload_2
    //   1061: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1064: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1067: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: ldc_w 527
    //   1073: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: astore 28
    //   1078: aload_0
    //   1079: getfield 531	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1082: ifnull +6903 -> 7985
    //   1085: aload_0
    //   1086: getfield 531	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1089: getfield 534	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1092: istore 4
    //   1094: aload 28
    //   1096: iload 4
    //   1098: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1101: ldc_w 467
    //   1104: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: iload_3
    //   1108: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1111: ldc_w 431
    //   1114: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: aload_2
    //   1118: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1121: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1124: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: ldc_w 443
    //   1130: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: aload_2
    //   1134: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1137: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   1140: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1143: ldc_w 448
    //   1146: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: aload_2
    //   1150: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1153: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1156: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1159: ldc_w 436
    //   1162: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: aload_2
    //   1166: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1169: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1172: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1175: ldc_w 441
    //   1178: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   1184: aload_0
    //   1185: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   1188: lsub
    //   1189: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1192: astore 28
    //   1194: aload 22
    //   1196: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1199: ifne +6792 -> 7991
    //   1202: new 300	java/lang/StringBuilder
    //   1205: dup
    //   1206: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   1209: ldc_w 471
    //   1212: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: aload 22
    //   1217: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1223: astore 22
    //   1225: aload 23
    //   1227: aload 28
    //   1229: aload 22
    //   1231: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: ldc_w 469
    //   1237: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload 27
    //   1242: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1248: putfield 537	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   1251: iload 6
    //   1253: ifeq +60 -> 1313
    //   1256: aload_0
    //   1257: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   1260: invokestatic 542	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   1263: astore 22
    //   1265: aload_0
    //   1266: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   1269: astore 23
    //   1271: aload_0
    //   1272: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   1275: ifeq +6724 -> 7999
    //   1278: aload 25
    //   1280: ifnull +6719 -> 7999
    //   1283: aload 25
    //   1285: ldc_w 544
    //   1288: invokevirtual 548	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1291: ifeq +6708 -> 7999
    //   1294: iconst_1
    //   1295: istore 6
    //   1297: aload 22
    //   1299: aload 23
    //   1301: iload 6
    //   1303: aload_2
    //   1304: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1307: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1310: invokevirtual 552	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   1313: aload 24
    //   1315: invokestatic 248	java/lang/System:currentTimeMillis	()J
    //   1318: putfield 555	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   1321: aload 24
    //   1323: aload_0
    //   1324: invokevirtual 558	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getContentLength	()J
    //   1327: putfield 561	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   1330: aload 24
    //   1332: aload 20
    //   1334: putfield 565	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   1337: aload 24
    //   1339: iload_3
    //   1340: putfield 568	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   1343: aload 24
    //   1345: aload 21
    //   1347: putfield 572	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   1350: aload 26
    //   1352: ifnonnull +6653 -> 8005
    //   1355: aconst_null
    //   1356: astore 21
    //   1358: aload 24
    //   1360: aload 21
    //   1362: putfield 575	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1365: aload 24
    //   1367: aconst_null
    //   1368: putfield 578	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1371: aload 24
    //   1373: aload_2
    //   1374: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1377: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1380: putfield 579	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1383: aload 24
    //   1385: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   1388: aload_0
    //   1389: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   1392: lsub
    //   1393: putfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1396: aload 24
    //   1398: aload_2
    //   1399: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1402: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1405: putfield 585	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   1408: aload 24
    //   1410: aload 24
    //   1412: getfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1415: aload_2
    //   1416: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1419: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1422: lsub
    //   1423: putfield 588	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   1426: aload 24
    //   1428: lload 8
    //   1430: putfield 591	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   1433: aload 24
    //   1435: lload 10
    //   1437: putfield 594	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   1440: aload 24
    //   1442: lload 12
    //   1444: putfield 597	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   1447: aload 24
    //   1449: aload_0
    //   1450: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   1453: putfield 600	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   1456: aload 24
    //   1458: lconst_0
    //   1459: putfield 603	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   1462: aload 24
    //   1464: aload_0
    //   1465: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   1468: putfield 606	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   1471: aload 24
    //   1473: aload_2
    //   1474: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1477: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1480: putfield 609	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1483: aload 24
    //   1485: aload_0
    //   1486: invokevirtual 240	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   1489: invokestatic 612	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   1492: putfield 614	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   1495: aload 24
    //   1497: aload_0
    //   1498: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   1501: putfield 617	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   1504: aload 25
    //   1506: ifnull +6509 -> 8015
    //   1509: aload 25
    //   1511: ldc_w 544
    //   1514: invokevirtual 548	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1517: ifeq +6498 -> 8015
    //   1520: iconst_1
    //   1521: istore 6
    //   1523: aload 24
    //   1525: iload 6
    //   1527: putfield 620	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   1530: aload 24
    //   1532: aload_2
    //   1533: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1536: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1539: putfield 622	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   1542: aload 24
    //   1544: getstatic 628	com/tencent/component/network/downloader/Downloader$DownloadMode:OkHttpMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   1547: invokevirtual 631	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   1550: putfield 634	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   1553: aload 20
    //   1555: ifnull +24 -> 1579
    //   1558: aload 20
    //   1560: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1563: ifnull +16 -> 1579
    //   1566: aload 24
    //   1568: aload 20
    //   1570: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1573: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   1576: putfield 636	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   1579: aload_2
    //   1580: aload 24
    //   1582: invokevirtual 640	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1585: aload_2
    //   1586: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1589: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1592: ifeq +11 -> 1603
    //   1595: aload_0
    //   1596: aload_1
    //   1597: aload_2
    //   1598: aload 24
    //   1600: invokevirtual 644	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1603: aload_0
    //   1604: invokevirtual 647	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:canAttempt	()Z
    //   1607: ifeq -1570 -> 37
    //   1610: goto -1582 -> 28
    //   1613: aload 21
    //   1615: ldc_w 649
    //   1618: invokevirtual 652	okhttp3/Request$Builder:removeHeader	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   1621: pop
    //   1622: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   1625: lstore 12
    //   1627: lload 12
    //   1629: lload 16
    //   1631: lsub
    //   1632: lstore 8
    //   1634: aload_0
    //   1635: getfield 32	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pokHttpClient	Lokhttp3/OkHttpClient;
    //   1638: aload 21
    //   1640: invokevirtual 655	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   1643: invokevirtual 659	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   1646: invokeinterface 663 1 0
    //   1651: astore 21
    //   1653: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   1656: lstore 18
    //   1658: lload 18
    //   1660: lload 12
    //   1662: lsub
    //   1663: lstore 10
    //   1665: aload_0
    //   1666: aload 21
    //   1668: invokevirtual 667	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:headerCallback	(Lokhttp3/Response;)V
    //   1671: lconst_0
    //   1672: lstore 14
    //   1674: lload 14
    //   1676: lstore 12
    //   1678: aload 21
    //   1680: ifnull +1963 -> 3643
    //   1683: lload 14
    //   1685: lstore 12
    //   1687: aload 21
    //   1689: invokevirtual 670	okhttp3/Response:isSuccessful	()Z
    //   1692: ifeq +1951 -> 3643
    //   1695: lload 14
    //   1697: lstore 12
    //   1699: aload 21
    //   1701: invokevirtual 95	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   1704: ifnull +1939 -> 3643
    //   1707: aload_0
    //   1708: aload_0
    //   1709: aload 21
    //   1711: invokespecial 672	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:parseContentLength	(Lokhttp3/Response;)J
    //   1714: putfield 675	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContentLength	J
    //   1717: aload_2
    //   1718: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1721: aload_0
    //   1722: getfield 675	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContentLength	J
    //   1725: putfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   1728: aload_0
    //   1729: aload_0
    //   1730: getfield 675	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContentLength	J
    //   1733: invokevirtual 679	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getSavePath	(J)Ljava/lang/String;
    //   1736: astore 20
    //   1738: aload 20
    //   1740: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1743: ifeq +1854 -> 3597
    //   1746: aload_2
    //   1747: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1750: iconst_2
    //   1751: invokevirtual 205	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   1754: ldc 215
    //   1756: new 300	java/lang/StringBuilder
    //   1759: dup
    //   1760: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   1763: ldc_w 681
    //   1766: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1769: aload_0
    //   1770: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   1773: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1776: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1779: invokestatic 683	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1782: aload_2
    //   1783: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1786: lload 16
    //   1788: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   1791: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   1794: aload_2
    //   1795: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1798: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   1801: aload_0
    //   1802: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   1805: lsub
    //   1806: putfield 332	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   1809: aload_2
    //   1810: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1813: aload_0
    //   1814: getfield 335	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTaskStartTimeStamp	J
    //   1817: putfield 338	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   1820: aload_0
    //   1821: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   1824: invokestatic 344	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   1827: invokevirtual 348	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   1830: astore 25
    //   1832: aload_0
    //   1833: getfield 83	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mRemoteAddress	Ljava/lang/String;
    //   1836: astore 27
    //   1838: aload_0
    //   1839: aconst_null
    //   1840: aconst_null
    //   1841: aload 21
    //   1843: invokevirtual 352	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   1846: astore 26
    //   1848: aload_0
    //   1849: getfield 73	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsEnd	J
    //   1852: aload_0
    //   1853: getfield 70	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsStart	J
    //   1856: lsub
    //   1857: lstore 12
    //   1859: aload 21
    //   1861: ifnull +1173 -> 3034
    //   1864: aload 21
    //   1866: invokevirtual 355	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   1869: ifnull +1165 -> 3034
    //   1872: aload 21
    //   1874: invokevirtual 355	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   1877: ldc_w 357
    //   1880: invokevirtual 110	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   1883: astore 20
    //   1885: aload_2
    //   1886: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1889: aload 20
    //   1891: putfield 366	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   1894: aload_0
    //   1895: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   1898: astore 23
    //   1900: aload_1
    //   1901: invokeinterface 176 1 0
    //   1906: ifne -1869 -> 37
    //   1909: aload_0
    //   1910: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   1913: invokestatic 186	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   1916: istore 6
    //   1918: aload_2
    //   1919: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1922: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1925: ifne +1129 -> 3054
    //   1928: new 300	java/lang/StringBuilder
    //   1931: dup
    //   1932: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   1935: ldc_w 371
    //   1938: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: aload_0
    //   1942: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   1945: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: ldc_w 373
    //   1951: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1954: aload_0
    //   1955: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   1958: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1961: ldc_w 382
    //   1964: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1967: astore 28
    //   1969: aload_0
    //   1970: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   1973: ifeq +1067 -> 3040
    //   1976: aload 21
    //   1978: ifnull +1062 -> 3040
    //   1981: aload 21
    //   1983: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1986: ifnull +1054 -> 3040
    //   1989: aload 21
    //   1991: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1994: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   1997: astore 22
    //   1999: aload 28
    //   2001: aload 22
    //   2003: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2006: ldc_w 391
    //   2009: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2012: aload 25
    //   2014: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2017: ldc_w 396
    //   2020: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2023: aload 27
    //   2025: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2028: ldc_w 398
    //   2031: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2034: aconst_null
    //   2035: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2038: ldc_w 400
    //   2041: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2044: invokestatic 404	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2047: invokevirtual 407	java/lang/Thread:getId	()J
    //   2050: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2053: ldc_w 412
    //   2056: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2059: invokestatic 417	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   2062: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: ldc_w 419
    //   2068: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2071: iload 6
    //   2073: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2076: ldc_w 421
    //   2079: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: invokestatic 426	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2085: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2088: ldc_w 431
    //   2091: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2094: aload_2
    //   2095: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2098: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2101: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2104: ldc_w 436
    //   2107: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2110: aload_2
    //   2111: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2114: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2117: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2120: ldc_w 441
    //   2123: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2126: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   2129: aload_0
    //   2130: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   2133: lsub
    //   2134: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2137: ldc_w 443
    //   2140: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: aload_2
    //   2144: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2147: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2150: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2153: ldc_w 448
    //   2156: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2159: aload_2
    //   2160: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2163: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2166: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2169: ldc_w 453
    //   2172: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2175: aload_2
    //   2176: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2179: getfield 456	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   2182: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2185: ldc_w 458
    //   2188: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2191: aload_0
    //   2192: invokevirtual 190	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   2195: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2198: ldc_w 460
    //   2201: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2204: aload_0
    //   2205: invokevirtual 193	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   2208: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2211: ldc_w 462
    //   2214: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: aload_2
    //   2218: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2221: invokevirtual 465	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   2224: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2227: ldc_w 467
    //   2230: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2233: iconst_0
    //   2234: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2237: ldc_w 469
    //   2240: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: aload 26
    //   2245: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2248: ldc_w 471
    //   2251: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2254: aload 20
    //   2256: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2259: ldc_w 473
    //   2262: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2265: aload_0
    //   2266: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   2269: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2272: ldc_w 475
    //   2275: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2278: aload_2
    //   2279: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2282: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2285: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2288: ldc_w 480
    //   2291: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2294: lload 12
    //   2296: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2299: ldc_w 482
    //   2302: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2305: lload 10
    //   2307: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2310: ldc_w 460
    //   2313: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2316: iconst_0
    //   2317: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2320: ldc_w 484
    //   2323: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2326: lconst_0
    //   2327: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2330: ldc_w 460
    //   2333: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2336: iconst_0
    //   2337: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2340: ldc_w 486
    //   2343: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2346: lload 10
    //   2348: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2351: ldc_w 488
    //   2354: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2357: aload_0
    //   2358: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   2361: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2364: ldc_w 493
    //   2367: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2370: aload_0
    //   2371: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   2374: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2377: ldc_w 498
    //   2380: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2383: astore 28
    //   2385: aload_0
    //   2386: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2389: ifnull +659 -> 3048
    //   2392: aload_0
    //   2393: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2396: invokeinterface 508 1 0
    //   2401: astore 22
    //   2403: aload 24
    //   2405: aload 28
    //   2407: aload 22
    //   2409: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2412: ldc_w 510
    //   2415: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2418: aload_2
    //   2419: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2422: getfield 513	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   2425: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2428: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2431: putfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   2434: ldc_w 518
    //   2437: aload 24
    //   2439: getfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   2442: aconst_null
    //   2443: invokestatic 316	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2446: iload 6
    //   2448: ifne +8 -> 2456
    //   2451: aload_0
    //   2452: iconst_0
    //   2453: putfield 521	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mShouldReport	Z
    //   2456: aload_2
    //   2457: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2460: astore 22
    //   2462: new 300	java/lang/StringBuilder
    //   2465: dup
    //   2466: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   2469: aload_0
    //   2470: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   2473: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2476: ldc_w 523
    //   2479: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2482: aload 27
    //   2484: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2487: ldc_w 525
    //   2490: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2493: aload_2
    //   2494: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2497: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2500: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2503: ldc_w 527
    //   2506: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2509: astore 27
    //   2511: aload_0
    //   2512: getfield 531	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2515: ifnull +1047 -> 3562
    //   2518: aload_0
    //   2519: getfield 531	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2522: getfield 534	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2525: istore_3
    //   2526: aload 27
    //   2528: iload_3
    //   2529: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2532: ldc_w 467
    //   2535: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2538: iconst_0
    //   2539: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2542: ldc_w 431
    //   2545: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2548: aload_2
    //   2549: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2552: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2555: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2558: ldc_w 443
    //   2561: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2564: aload_2
    //   2565: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2568: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2571: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2574: ldc_w 448
    //   2577: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2580: aload_2
    //   2581: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2584: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2587: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2590: ldc_w 436
    //   2593: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2596: aload_2
    //   2597: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2600: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2603: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2606: ldc_w 441
    //   2609: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2612: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   2615: aload_0
    //   2616: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   2619: lsub
    //   2620: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2623: astore 27
    //   2625: aload 20
    //   2627: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2630: ifne +937 -> 3567
    //   2633: new 300	java/lang/StringBuilder
    //   2636: dup
    //   2637: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   2640: ldc_w 471
    //   2643: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2646: aload 20
    //   2648: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2651: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2654: astore 20
    //   2656: aload 22
    //   2658: aload 27
    //   2660: aload 20
    //   2662: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2665: ldc_w 469
    //   2668: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2671: aload 26
    //   2673: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2676: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2679: putfield 537	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   2682: iload 6
    //   2684: ifeq +60 -> 2744
    //   2687: aload_0
    //   2688: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   2691: invokestatic 542	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   2694: astore 20
    //   2696: aload_0
    //   2697: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   2700: astore 22
    //   2702: aload_0
    //   2703: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   2706: ifeq +869 -> 3575
    //   2709: aload 23
    //   2711: ifnull +864 -> 3575
    //   2714: aload 23
    //   2716: ldc_w 544
    //   2719: invokevirtual 548	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2722: ifeq +853 -> 3575
    //   2725: iconst_1
    //   2726: istore 6
    //   2728: aload 20
    //   2730: aload 22
    //   2732: iload 6
    //   2734: aload_2
    //   2735: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2738: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2741: invokevirtual 552	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   2744: aload 24
    //   2746: invokestatic 248	java/lang/System:currentTimeMillis	()J
    //   2749: putfield 555	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   2752: aload 24
    //   2754: aload_0
    //   2755: invokevirtual 558	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getContentLength	()J
    //   2758: putfield 561	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   2761: aload 24
    //   2763: aload 21
    //   2765: putfield 565	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   2768: aload 24
    //   2770: iconst_0
    //   2771: putfield 568	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   2774: aload 24
    //   2776: aconst_null
    //   2777: putfield 572	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   2780: aload 25
    //   2782: ifnonnull +799 -> 3581
    //   2785: aconst_null
    //   2786: astore 20
    //   2788: aload 24
    //   2790: aload 20
    //   2792: putfield 575	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   2795: aload 24
    //   2797: aconst_null
    //   2798: putfield 578	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   2801: aload 24
    //   2803: aload_2
    //   2804: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2807: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2810: putfield 579	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   2813: aload 24
    //   2815: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   2818: aload_0
    //   2819: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   2822: lsub
    //   2823: putfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   2826: aload 24
    //   2828: aload_2
    //   2829: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2832: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2835: putfield 585	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   2838: aload 24
    //   2840: aload 24
    //   2842: getfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   2845: aload_2
    //   2846: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2849: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2852: lsub
    //   2853: putfield 588	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   2856: aload 24
    //   2858: lload 8
    //   2860: putfield 591	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   2863: aload 24
    //   2865: lload 10
    //   2867: putfield 594	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   2870: aload 24
    //   2872: lload 10
    //   2874: putfield 597	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   2877: aload 24
    //   2879: aload_0
    //   2880: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   2883: putfield 600	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   2886: aload 24
    //   2888: lconst_0
    //   2889: putfield 603	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   2892: aload 24
    //   2894: aload_0
    //   2895: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   2898: putfield 606	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   2901: aload 24
    //   2903: aload_2
    //   2904: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2907: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2910: putfield 609	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   2913: aload 24
    //   2915: aload_0
    //   2916: invokevirtual 240	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   2919: invokestatic 612	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   2922: putfield 614	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   2925: aload 24
    //   2927: aload_0
    //   2928: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   2931: putfield 617	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   2934: aload 23
    //   2936: ifnull +655 -> 3591
    //   2939: aload 23
    //   2941: ldc_w 544
    //   2944: invokevirtual 548	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2947: ifeq +644 -> 3591
    //   2950: iconst_1
    //   2951: istore 6
    //   2953: aload 24
    //   2955: iload 6
    //   2957: putfield 620	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   2960: aload 24
    //   2962: aload_2
    //   2963: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2966: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2969: putfield 622	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   2972: aload 24
    //   2974: getstatic 628	com/tencent/component/network/downloader/Downloader$DownloadMode:OkHttpMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   2977: invokevirtual 631	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   2980: putfield 634	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   2983: aload 21
    //   2985: ifnull +24 -> 3009
    //   2988: aload 21
    //   2990: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   2993: ifnull +16 -> 3009
    //   2996: aload 24
    //   2998: aload 21
    //   3000: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3003: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3006: putfield 636	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   3009: aload_2
    //   3010: aload 24
    //   3012: invokevirtual 640	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   3015: aload_2
    //   3016: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3019: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3022: ifeq -2985 -> 37
    //   3025: aload_0
    //   3026: aload_1
    //   3027: aload_2
    //   3028: aload 24
    //   3030: invokevirtual 644	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   3033: return
    //   3034: aconst_null
    //   3035: astore 20
    //   3037: goto -1152 -> 1885
    //   3040: ldc_w 685
    //   3043: astore 22
    //   3045: goto -1046 -> 1999
    //   3048: aconst_null
    //   3049: astore 22
    //   3051: goto -648 -> 2403
    //   3054: new 300	java/lang/StringBuilder
    //   3057: dup
    //   3058: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   3061: ldc_w 687
    //   3064: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3067: aload_0
    //   3068: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   3071: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3074: ldc_w 373
    //   3077: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3080: aload_0
    //   3081: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   3084: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3087: ldc_w 382
    //   3090: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3093: astore 28
    //   3095: aload_0
    //   3096: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   3099: ifeq +449 -> 3548
    //   3102: aload 21
    //   3104: ifnull +444 -> 3548
    //   3107: aload 21
    //   3109: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3112: ifnull +436 -> 3548
    //   3115: aload 21
    //   3117: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3120: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3123: astore 22
    //   3125: aload 28
    //   3127: aload 22
    //   3129: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3132: ldc_w 391
    //   3135: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3138: aload 25
    //   3140: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3143: ldc_w 396
    //   3146: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3149: aload 27
    //   3151: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3154: ldc_w 398
    //   3157: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3160: aconst_null
    //   3161: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3164: ldc_w 400
    //   3167: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3170: invokestatic 404	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3173: invokevirtual 407	java/lang/Thread:getId	()J
    //   3176: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3179: ldc_w 412
    //   3182: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3185: invokestatic 417	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3188: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3191: ldc_w 421
    //   3194: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3197: invokestatic 426	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3200: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3203: ldc_w 436
    //   3206: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3209: aload_2
    //   3210: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3213: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3216: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3219: ldc_w 441
    //   3222: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3225: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   3228: aload_0
    //   3229: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   3232: lsub
    //   3233: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3236: ldc_w 443
    //   3239: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3242: aload_2
    //   3243: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3246: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3249: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3252: ldc_w 448
    //   3255: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3258: aload_2
    //   3259: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3262: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3265: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3268: ldc_w 453
    //   3271: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3274: aload_2
    //   3275: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3278: getfield 456	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3281: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3284: ldc_w 458
    //   3287: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3290: aload_0
    //   3291: invokevirtual 190	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   3294: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3297: ldc_w 460
    //   3300: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3303: aload_0
    //   3304: invokevirtual 193	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   3307: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3310: ldc_w 689
    //   3313: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3316: iconst_0
    //   3317: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3320: ldc_w 469
    //   3323: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3326: aload 26
    //   3328: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3331: ldc_w 431
    //   3334: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3337: aload_2
    //   3338: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3341: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3344: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3347: ldc_w 471
    //   3350: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3353: aload 20
    //   3355: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3358: ldc_w 473
    //   3361: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3364: aload_0
    //   3365: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   3368: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3371: ldc_w 475
    //   3374: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3377: aload_2
    //   3378: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3381: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3384: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3387: ldc_w 480
    //   3390: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3393: lload 12
    //   3395: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3398: ldc_w 482
    //   3401: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3404: lload 10
    //   3406: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3409: ldc_w 460
    //   3412: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3415: iconst_0
    //   3416: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3419: ldc_w 484
    //   3422: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3425: lconst_0
    //   3426: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3429: ldc_w 460
    //   3432: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3435: iconst_0
    //   3436: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3439: ldc_w 486
    //   3442: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3445: lload 10
    //   3447: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3450: ldc_w 488
    //   3453: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3456: aload_0
    //   3457: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   3460: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3463: ldc_w 493
    //   3466: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3469: aload_0
    //   3470: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   3473: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3476: ldc_w 498
    //   3479: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3482: astore 28
    //   3484: aload_0
    //   3485: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3488: ifnull +68 -> 3556
    //   3491: aload_0
    //   3492: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3495: invokeinterface 508 1 0
    //   3500: astore 22
    //   3502: aload 24
    //   3504: aload 28
    //   3506: aload 22
    //   3508: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3511: ldc_w 510
    //   3514: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3517: aload_2
    //   3518: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3521: getfield 513	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   3524: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3527: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3530: putfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3533: ldc_w 518
    //   3536: aload 24
    //   3538: getfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3541: aconst_null
    //   3542: invokestatic 692	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3545: goto -1099 -> 2446
    //   3548: ldc_w 685
    //   3551: astore 22
    //   3553: goto -428 -> 3125
    //   3556: aconst_null
    //   3557: astore 22
    //   3559: goto -57 -> 3502
    //   3562: iconst_0
    //   3563: istore_3
    //   3564: goto -1038 -> 2526
    //   3567: ldc_w 694
    //   3570: astore 20
    //   3572: goto -916 -> 2656
    //   3575: iconst_0
    //   3576: istore 6
    //   3578: goto -850 -> 2728
    //   3581: aload 25
    //   3583: invokevirtual 697	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   3586: astore 20
    //   3588: goto -800 -> 2788
    //   3591: iconst_0
    //   3592: istore 6
    //   3594: goto -641 -> 2953
    //   3597: aload_2
    //   3598: aload 20
    //   3600: invokevirtual 700	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   3603: aload 21
    //   3605: invokevirtual 95	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   3608: invokevirtual 704	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   3611: astore 22
    //   3613: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   3616: lstore 14
    //   3618: aload_0
    //   3619: aload 22
    //   3621: aload 20
    //   3623: invokespecial 706	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:saveToFile	(Ljava/io/InputStream;Ljava/lang/String;)J
    //   3626: lstore 12
    //   3628: aload_0
    //   3629: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   3632: lload 14
    //   3634: lsub
    //   3635: putfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   3638: aload 22
    //   3640: invokevirtual 707	java/io/InputStream:close	()V
    //   3643: aload_2
    //   3644: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3647: lload 12
    //   3649: putfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3652: aload_2
    //   3653: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3656: lload 12
    //   3658: putfield 456	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3661: aload 21
    //   3663: ifnull +3217 -> 6880
    //   3666: aload 21
    //   3668: invokevirtual 710	okhttp3/Response:code	()I
    //   3671: istore_3
    //   3672: aload_2
    //   3673: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3676: aload 21
    //   3678: ldc_w 712
    //   3681: invokevirtual 110	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   3684: putfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3687: aload_2
    //   3688: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3691: aload 21
    //   3693: ldc_w 714
    //   3696: invokevirtual 110	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   3699: putfield 717	com/tencent/component/network/downloader/DownloadResult$Content:encoding	Ljava/lang/String;
    //   3702: aload_2
    //   3703: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3706: iload_3
    //   3707: putfield 720	com/tencent/component/network/downloader/DownloadResult$Content:retCode	I
    //   3710: aload_2
    //   3711: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3714: iload_3
    //   3715: putfield 721	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   3718: aload 21
    //   3720: invokevirtual 104	okhttp3/Response:networkResponse	()Lokhttp3/Response;
    //   3723: ifnull +6313 -> 10036
    //   3726: aload 21
    //   3728: invokevirtual 104	okhttp3/Response:networkResponse	()Lokhttp3/Response;
    //   3731: ldc_w 714
    //   3734: invokevirtual 110	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   3737: astore 20
    //   3739: ldc_w 723
    //   3742: aload 20
    //   3744: invokevirtual 727	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3747: ifeq +6289 -> 10036
    //   3750: aload_2
    //   3751: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3754: aload 20
    //   3756: putfield 717	com/tencent/component/network/downloader/DownloadResult$Content:encoding	Ljava/lang/String;
    //   3759: aload_2
    //   3760: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3763: iconst_1
    //   3764: putfield 513	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   3767: goto +6269 -> 10036
    //   3770: aload_2
    //   3771: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3774: invokevirtual 730	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   3777: aload_2
    //   3778: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3781: lload 16
    //   3783: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   3786: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   3789: aload_2
    //   3790: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3793: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   3796: aload_0
    //   3797: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   3800: lsub
    //   3801: putfield 332	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   3804: aload_2
    //   3805: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3808: aload_0
    //   3809: getfield 335	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTaskStartTimeStamp	J
    //   3812: putfield 338	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   3815: aload_0
    //   3816: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   3819: invokestatic 344	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   3822: invokevirtual 348	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3825: astore 25
    //   3827: aload_0
    //   3828: getfield 83	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mRemoteAddress	Ljava/lang/String;
    //   3831: astore 27
    //   3833: aload_0
    //   3834: aconst_null
    //   3835: aconst_null
    //   3836: aload 21
    //   3838: invokevirtual 352	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   3841: astore 26
    //   3843: aload_0
    //   3844: getfield 73	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsEnd	J
    //   3847: aload_0
    //   3848: getfield 70	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsStart	J
    //   3851: lsub
    //   3852: lstore 12
    //   3854: aload 21
    //   3856: ifnull +1175 -> 5031
    //   3859: aload 21
    //   3861: invokevirtual 355	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   3864: ifnull +1167 -> 5031
    //   3867: aload 21
    //   3869: invokevirtual 355	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   3872: ldc_w 357
    //   3875: invokevirtual 110	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   3878: astore 20
    //   3880: aload_2
    //   3881: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3884: aload 20
    //   3886: putfield 366	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   3889: aload_0
    //   3890: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   3893: astore 23
    //   3895: aload_1
    //   3896: invokeinterface 176 1 0
    //   3901: ifne -3864 -> 37
    //   3904: aload_0
    //   3905: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   3908: invokestatic 186	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3911: istore 6
    //   3913: aload_2
    //   3914: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3917: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3920: ifne +1131 -> 5051
    //   3923: new 300	java/lang/StringBuilder
    //   3926: dup
    //   3927: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   3930: ldc_w 371
    //   3933: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3936: aload_0
    //   3937: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   3940: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3943: ldc_w 373
    //   3946: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3949: aload_0
    //   3950: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   3953: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3956: ldc_w 382
    //   3959: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3962: astore 28
    //   3964: aload_0
    //   3965: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   3968: ifeq +1069 -> 5037
    //   3971: aload 21
    //   3973: ifnull +1064 -> 5037
    //   3976: aload 21
    //   3978: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3981: ifnull +1056 -> 5037
    //   3984: aload 21
    //   3986: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3989: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3992: astore 22
    //   3994: aload 28
    //   3996: aload 22
    //   3998: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4001: ldc_w 391
    //   4004: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4007: aload 25
    //   4009: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4012: ldc_w 396
    //   4015: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4018: aload 27
    //   4020: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4023: ldc_w 398
    //   4026: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4029: aconst_null
    //   4030: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4033: ldc_w 400
    //   4036: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4039: invokestatic 404	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4042: invokevirtual 407	java/lang/Thread:getId	()J
    //   4045: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4048: ldc_w 412
    //   4051: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4054: invokestatic 417	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4057: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4060: ldc_w 419
    //   4063: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4066: iload 6
    //   4068: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4071: ldc_w 421
    //   4074: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4077: invokestatic 426	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   4080: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4083: ldc_w 431
    //   4086: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4089: aload_2
    //   4090: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4093: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4096: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4099: ldc_w 436
    //   4102: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4105: aload_2
    //   4106: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4109: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4112: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4115: ldc_w 441
    //   4118: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4121: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   4124: aload_0
    //   4125: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   4128: lsub
    //   4129: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4132: ldc_w 443
    //   4135: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4138: aload_2
    //   4139: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4142: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4145: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4148: ldc_w 448
    //   4151: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4154: aload_2
    //   4155: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4158: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4161: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4164: ldc_w 453
    //   4167: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4170: aload_2
    //   4171: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4174: getfield 456	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4177: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4180: ldc_w 458
    //   4183: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4186: aload_0
    //   4187: invokevirtual 190	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   4190: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4193: ldc_w 460
    //   4196: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4199: aload_0
    //   4200: invokevirtual 193	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   4203: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4206: ldc_w 462
    //   4209: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4212: aload_2
    //   4213: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4216: invokevirtual 465	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   4219: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4222: ldc_w 467
    //   4225: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4228: iload_3
    //   4229: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4232: ldc_w 469
    //   4235: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4238: aload 26
    //   4240: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4243: ldc_w 471
    //   4246: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4249: aload 20
    //   4251: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4254: ldc_w 473
    //   4257: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4260: aload_0
    //   4261: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   4264: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4267: ldc_w 475
    //   4270: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4273: aload_2
    //   4274: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4277: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4280: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4283: ldc_w 480
    //   4286: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4289: lload 12
    //   4291: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4294: ldc_w 482
    //   4297: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4300: lload 10
    //   4302: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4305: ldc_w 460
    //   4308: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4311: iconst_0
    //   4312: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4315: ldc_w 484
    //   4318: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4321: lconst_0
    //   4322: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4325: ldc_w 460
    //   4328: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4331: iconst_0
    //   4332: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4335: ldc_w 486
    //   4338: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4341: lload 10
    //   4343: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4346: ldc_w 488
    //   4349: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4352: aload_0
    //   4353: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   4356: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4359: ldc_w 493
    //   4362: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4365: aload_0
    //   4366: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   4369: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4372: ldc_w 498
    //   4375: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4378: astore 28
    //   4380: aload_0
    //   4381: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4384: ifnull +661 -> 5045
    //   4387: aload_0
    //   4388: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4391: invokeinterface 508 1 0
    //   4396: astore 22
    //   4398: aload 24
    //   4400: aload 28
    //   4402: aload 22
    //   4404: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4407: ldc_w 510
    //   4410: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4413: aload_2
    //   4414: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4417: getfield 513	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   4420: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4423: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4426: putfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4429: ldc_w 518
    //   4432: aload 24
    //   4434: getfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   4437: aconst_null
    //   4438: invokestatic 316	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4441: iload 6
    //   4443: ifne +8 -> 4451
    //   4446: aload_0
    //   4447: iconst_0
    //   4448: putfield 521	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mShouldReport	Z
    //   4451: aload_2
    //   4452: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4455: astore 22
    //   4457: new 300	java/lang/StringBuilder
    //   4460: dup
    //   4461: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   4464: aload_0
    //   4465: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   4468: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4471: ldc_w 523
    //   4474: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4477: aload 27
    //   4479: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4482: ldc_w 525
    //   4485: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4488: aload_2
    //   4489: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4492: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4495: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4498: ldc_w 527
    //   4501: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4504: astore 27
    //   4506: aload_0
    //   4507: getfield 531	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4510: ifnull +1049 -> 5559
    //   4513: aload_0
    //   4514: getfield 531	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4517: getfield 534	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4520: istore 4
    //   4522: aload 27
    //   4524: iload 4
    //   4526: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4529: ldc_w 467
    //   4532: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4535: iload_3
    //   4536: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4539: ldc_w 431
    //   4542: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4545: aload_2
    //   4546: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4549: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4552: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4555: ldc_w 443
    //   4558: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4561: aload_2
    //   4562: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4565: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4568: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4571: ldc_w 448
    //   4574: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4577: aload_2
    //   4578: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4581: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4584: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4587: ldc_w 436
    //   4590: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4593: aload_2
    //   4594: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4597: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4600: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4603: ldc_w 441
    //   4606: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4609: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   4612: aload_0
    //   4613: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   4616: lsub
    //   4617: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4620: astore 27
    //   4622: aload 20
    //   4624: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4627: ifne +938 -> 5565
    //   4630: new 300	java/lang/StringBuilder
    //   4633: dup
    //   4634: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   4637: ldc_w 471
    //   4640: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4643: aload 20
    //   4645: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4648: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4651: astore 20
    //   4653: aload 22
    //   4655: aload 27
    //   4657: aload 20
    //   4659: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4662: ldc_w 469
    //   4665: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4668: aload 26
    //   4670: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4673: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4676: putfield 537	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   4679: iload 6
    //   4681: ifeq +60 -> 4741
    //   4684: aload_0
    //   4685: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   4688: invokestatic 542	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   4691: astore 20
    //   4693: aload_0
    //   4694: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   4697: astore 22
    //   4699: aload_0
    //   4700: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   4703: ifeq +870 -> 5573
    //   4706: aload 23
    //   4708: ifnull +865 -> 5573
    //   4711: aload 23
    //   4713: ldc_w 544
    //   4716: invokevirtual 548	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4719: ifeq +854 -> 5573
    //   4722: iconst_1
    //   4723: istore 6
    //   4725: aload 20
    //   4727: aload 22
    //   4729: iload 6
    //   4731: aload_2
    //   4732: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4735: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4738: invokevirtual 552	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   4741: aload 24
    //   4743: invokestatic 248	java/lang/System:currentTimeMillis	()J
    //   4746: putfield 555	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4749: aload 24
    //   4751: aload_0
    //   4752: invokevirtual 558	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getContentLength	()J
    //   4755: putfield 561	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4758: aload 24
    //   4760: aload 21
    //   4762: putfield 565	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   4765: aload 24
    //   4767: iload_3
    //   4768: putfield 568	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4771: aload 24
    //   4773: aconst_null
    //   4774: putfield 572	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4777: aload 25
    //   4779: ifnonnull +800 -> 5579
    //   4782: aconst_null
    //   4783: astore 20
    //   4785: aload 24
    //   4787: aload 20
    //   4789: putfield 575	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4792: aload 24
    //   4794: aconst_null
    //   4795: putfield 578	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4798: aload 24
    //   4800: aload_2
    //   4801: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4804: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4807: putfield 579	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4810: aload 24
    //   4812: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   4815: aload_0
    //   4816: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   4819: lsub
    //   4820: putfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4823: aload 24
    //   4825: aload_2
    //   4826: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4829: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4832: putfield 585	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   4835: aload 24
    //   4837: aload 24
    //   4839: getfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4842: aload_2
    //   4843: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4846: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4849: lsub
    //   4850: putfield 588	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   4853: aload 24
    //   4855: lload 8
    //   4857: putfield 591	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   4860: aload 24
    //   4862: lload 10
    //   4864: putfield 594	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   4867: aload 24
    //   4869: lload 10
    //   4871: putfield 597	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   4874: aload 24
    //   4876: aload_0
    //   4877: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   4880: putfield 600	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   4883: aload 24
    //   4885: lconst_0
    //   4886: putfield 603	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   4889: aload 24
    //   4891: aload_0
    //   4892: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   4895: putfield 606	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   4898: aload 24
    //   4900: aload_2
    //   4901: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4904: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4907: putfield 609	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4910: aload 24
    //   4912: aload_0
    //   4913: invokevirtual 240	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   4916: invokestatic 612	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   4919: putfield 614	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   4922: aload 24
    //   4924: aload_0
    //   4925: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   4928: putfield 617	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   4931: aload 23
    //   4933: ifnull +656 -> 5589
    //   4936: aload 23
    //   4938: ldc_w 544
    //   4941: invokevirtual 548	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4944: ifeq +645 -> 5589
    //   4947: iconst_1
    //   4948: istore 6
    //   4950: aload 24
    //   4952: iload 6
    //   4954: putfield 620	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   4957: aload 24
    //   4959: aload_2
    //   4960: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4963: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4966: putfield 622	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   4969: aload 24
    //   4971: getstatic 628	com/tencent/component/network/downloader/Downloader$DownloadMode:OkHttpMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   4974: invokevirtual 631	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   4977: putfield 634	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   4980: aload 21
    //   4982: ifnull +24 -> 5006
    //   4985: aload 21
    //   4987: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4990: ifnull +16 -> 5006
    //   4993: aload 24
    //   4995: aload 21
    //   4997: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5000: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5003: putfield 636	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   5006: aload_2
    //   5007: aload 24
    //   5009: invokevirtual 640	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5012: aload_2
    //   5013: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5016: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5019: ifeq -4982 -> 37
    //   5022: aload_0
    //   5023: aload_1
    //   5024: aload_2
    //   5025: aload 24
    //   5027: invokevirtual 644	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5030: return
    //   5031: aconst_null
    //   5032: astore 20
    //   5034: goto -1154 -> 3880
    //   5037: ldc_w 685
    //   5040: astore 22
    //   5042: goto -1048 -> 3994
    //   5045: aconst_null
    //   5046: astore 22
    //   5048: goto -650 -> 4398
    //   5051: new 300	java/lang/StringBuilder
    //   5054: dup
    //   5055: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   5058: ldc_w 687
    //   5061: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5064: aload_0
    //   5065: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   5068: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5071: ldc_w 373
    //   5074: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5077: aload_0
    //   5078: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   5081: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5084: ldc_w 382
    //   5087: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5090: astore 28
    //   5092: aload_0
    //   5093: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   5096: ifeq +449 -> 5545
    //   5099: aload 21
    //   5101: ifnull +444 -> 5545
    //   5104: aload 21
    //   5106: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5109: ifnull +436 -> 5545
    //   5112: aload 21
    //   5114: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5117: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5120: astore 22
    //   5122: aload 28
    //   5124: aload 22
    //   5126: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5129: ldc_w 391
    //   5132: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5135: aload 25
    //   5137: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5140: ldc_w 396
    //   5143: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5146: aload 27
    //   5148: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5151: ldc_w 398
    //   5154: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5157: aconst_null
    //   5158: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5161: ldc_w 400
    //   5164: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5167: invokestatic 404	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5170: invokevirtual 407	java/lang/Thread:getId	()J
    //   5173: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5176: ldc_w 412
    //   5179: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5182: invokestatic 417	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5185: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5188: ldc_w 421
    //   5191: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5194: invokestatic 426	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   5197: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5200: ldc_w 436
    //   5203: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5206: aload_2
    //   5207: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5210: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5213: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5216: ldc_w 441
    //   5219: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5222: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   5225: aload_0
    //   5226: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   5229: lsub
    //   5230: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5233: ldc_w 443
    //   5236: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5239: aload_2
    //   5240: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5243: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5246: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5249: ldc_w 448
    //   5252: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5255: aload_2
    //   5256: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5259: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5262: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5265: ldc_w 453
    //   5268: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5271: aload_2
    //   5272: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5275: getfield 456	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5278: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5281: ldc_w 458
    //   5284: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5287: aload_0
    //   5288: invokevirtual 190	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   5291: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5294: ldc_w 460
    //   5297: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5300: aload_0
    //   5301: invokevirtual 193	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   5304: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5307: ldc_w 689
    //   5310: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5313: iload_3
    //   5314: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5317: ldc_w 469
    //   5320: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5323: aload 26
    //   5325: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5328: ldc_w 431
    //   5331: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5334: aload_2
    //   5335: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5338: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5341: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5344: ldc_w 471
    //   5347: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5350: aload 20
    //   5352: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5355: ldc_w 473
    //   5358: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5361: aload_0
    //   5362: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   5365: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5368: ldc_w 475
    //   5371: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5374: aload_2
    //   5375: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5378: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5381: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5384: ldc_w 480
    //   5387: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5390: lload 12
    //   5392: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5395: ldc_w 482
    //   5398: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5401: lload 10
    //   5403: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5406: ldc_w 460
    //   5409: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5412: iconst_0
    //   5413: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5416: ldc_w 484
    //   5419: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5422: lconst_0
    //   5423: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5426: ldc_w 460
    //   5429: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5432: iconst_0
    //   5433: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5436: ldc_w 486
    //   5439: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5442: lload 10
    //   5444: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5447: ldc_w 488
    //   5450: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5453: aload_0
    //   5454: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   5457: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5460: ldc_w 493
    //   5463: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5466: aload_0
    //   5467: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   5470: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5473: ldc_w 498
    //   5476: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5479: astore 28
    //   5481: aload_0
    //   5482: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5485: ifnull +68 -> 5553
    //   5488: aload_0
    //   5489: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5492: invokeinterface 508 1 0
    //   5497: astore 22
    //   5499: aload 24
    //   5501: aload 28
    //   5503: aload 22
    //   5505: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5508: ldc_w 510
    //   5511: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5514: aload_2
    //   5515: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5518: getfield 513	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   5521: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5524: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5527: putfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5530: ldc_w 518
    //   5533: aload 24
    //   5535: getfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5538: aconst_null
    //   5539: invokestatic 692	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5542: goto -1101 -> 4441
    //   5545: ldc_w 685
    //   5548: astore 22
    //   5550: goto -428 -> 5122
    //   5553: aconst_null
    //   5554: astore 22
    //   5556: goto -57 -> 5499
    //   5559: iconst_0
    //   5560: istore 4
    //   5562: goto -1040 -> 4522
    //   5565: ldc_w 694
    //   5568: astore 20
    //   5570: goto -917 -> 4653
    //   5573: iconst_0
    //   5574: istore 6
    //   5576: goto -851 -> 4725
    //   5579: aload 25
    //   5581: invokevirtual 697	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   5584: astore 20
    //   5586: goto -801 -> 4785
    //   5589: iconst_0
    //   5590: istore 6
    //   5592: goto -642 -> 4950
    //   5595: aload_0
    //   5596: getfield 734	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5599: ifnull +17 -> 5616
    //   5602: aload_0
    //   5603: getfield 734	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5606: aload_0
    //   5607: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   5610: iconst_1
    //   5611: invokeinterface 740 3 0
    //   5616: aload_2
    //   5617: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5620: iload_3
    //   5621: invokevirtual 205	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   5624: aload_2
    //   5625: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5628: lload 16
    //   5630: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   5633: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   5636: aload_2
    //   5637: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5640: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   5643: aload_0
    //   5644: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   5647: lsub
    //   5648: putfield 332	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   5651: aload_2
    //   5652: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5655: aload_0
    //   5656: getfield 335	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTaskStartTimeStamp	J
    //   5659: putfield 338	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   5662: aload_0
    //   5663: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   5666: invokestatic 344	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   5669: invokevirtual 348	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   5672: astore 25
    //   5674: aload_0
    //   5675: getfield 83	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mRemoteAddress	Ljava/lang/String;
    //   5678: astore 27
    //   5680: aload_0
    //   5681: aconst_null
    //   5682: aconst_null
    //   5683: aload 21
    //   5685: invokevirtual 352	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   5688: astore 26
    //   5690: aload_0
    //   5691: getfield 73	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsEnd	J
    //   5694: aload_0
    //   5695: getfield 70	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsStart	J
    //   5698: lsub
    //   5699: lstore 12
    //   5701: aload 21
    //   5703: ifnull +1190 -> 6893
    //   5706: aload 21
    //   5708: invokevirtual 355	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   5711: ifnull +1182 -> 6893
    //   5714: aload 21
    //   5716: invokevirtual 355	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   5719: ldc_w 357
    //   5722: invokevirtual 110	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   5725: astore 20
    //   5727: aload_2
    //   5728: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5731: aload 20
    //   5733: putfield 366	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   5736: aload_0
    //   5737: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   5740: astore 23
    //   5742: aload_1
    //   5743: invokeinterface 176 1 0
    //   5748: ifne +1129 -> 6877
    //   5751: aload_0
    //   5752: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   5755: invokestatic 186	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5758: istore 6
    //   5760: aload_2
    //   5761: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5764: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5767: ifne +1146 -> 6913
    //   5770: new 300	java/lang/StringBuilder
    //   5773: dup
    //   5774: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   5777: ldc_w 371
    //   5780: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5783: aload_0
    //   5784: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   5787: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5790: ldc_w 373
    //   5793: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5796: aload_0
    //   5797: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   5800: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5803: ldc_w 382
    //   5806: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5809: astore 28
    //   5811: aload_0
    //   5812: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   5815: ifeq +1084 -> 6899
    //   5818: aload 21
    //   5820: ifnull +1079 -> 6899
    //   5823: aload 21
    //   5825: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5828: ifnull +1071 -> 6899
    //   5831: aload 21
    //   5833: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5836: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5839: astore 22
    //   5841: aload 28
    //   5843: aload 22
    //   5845: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5848: ldc_w 391
    //   5851: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5854: aload 25
    //   5856: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5859: ldc_w 396
    //   5862: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5865: aload 27
    //   5867: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5870: ldc_w 398
    //   5873: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5876: aconst_null
    //   5877: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5880: ldc_w 400
    //   5883: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5886: invokestatic 404	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5889: invokevirtual 407	java/lang/Thread:getId	()J
    //   5892: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5895: ldc_w 412
    //   5898: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5901: invokestatic 417	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5904: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5907: ldc_w 419
    //   5910: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5913: iload 6
    //   5915: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5918: ldc_w 421
    //   5921: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5924: invokestatic 426	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   5927: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5930: ldc_w 431
    //   5933: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5936: aload_2
    //   5937: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5940: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5943: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5946: ldc_w 436
    //   5949: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5952: aload_2
    //   5953: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5956: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5959: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5962: ldc_w 441
    //   5965: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5968: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   5971: aload_0
    //   5972: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   5975: lsub
    //   5976: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5979: ldc_w 443
    //   5982: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5985: aload_2
    //   5986: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5989: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5992: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5995: ldc_w 448
    //   5998: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6001: aload_2
    //   6002: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6005: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6008: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6011: ldc_w 453
    //   6014: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6017: aload_2
    //   6018: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6021: getfield 456	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   6024: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6027: ldc_w 458
    //   6030: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6033: aload_0
    //   6034: invokevirtual 190	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   6037: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6040: ldc_w 460
    //   6043: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6046: aload_0
    //   6047: invokevirtual 193	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   6050: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6053: ldc_w 462
    //   6056: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6059: aload_2
    //   6060: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6063: invokevirtual 465	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   6066: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6069: ldc_w 467
    //   6072: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6075: iload_3
    //   6076: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6079: ldc_w 469
    //   6082: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6085: aload 26
    //   6087: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6090: ldc_w 471
    //   6093: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6096: aload 20
    //   6098: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6101: ldc_w 473
    //   6104: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6107: aload_0
    //   6108: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   6111: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6114: ldc_w 475
    //   6117: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6120: aload_2
    //   6121: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6124: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6127: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6130: ldc_w 480
    //   6133: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6136: lload 12
    //   6138: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6141: ldc_w 482
    //   6144: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6147: lload 10
    //   6149: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6152: ldc_w 460
    //   6155: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6158: iconst_0
    //   6159: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6162: ldc_w 484
    //   6165: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6168: lconst_0
    //   6169: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6172: ldc_w 460
    //   6175: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6178: iconst_0
    //   6179: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6182: ldc_w 486
    //   6185: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6188: lload 10
    //   6190: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6193: ldc_w 488
    //   6196: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6199: aload_0
    //   6200: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   6203: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6206: ldc_w 493
    //   6209: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6212: aload_0
    //   6213: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   6216: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6219: ldc_w 498
    //   6222: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6225: astore 28
    //   6227: aload_0
    //   6228: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6231: ifnull +676 -> 6907
    //   6234: aload_0
    //   6235: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6238: invokeinterface 508 1 0
    //   6243: astore 22
    //   6245: aload 24
    //   6247: aload 28
    //   6249: aload 22
    //   6251: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6254: ldc_w 510
    //   6257: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6260: aload_2
    //   6261: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6264: getfield 513	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   6267: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6270: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6273: putfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   6276: ldc_w 518
    //   6279: aload 24
    //   6281: getfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   6284: aconst_null
    //   6285: invokestatic 316	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6288: iload 6
    //   6290: ifne +8 -> 6298
    //   6293: aload_0
    //   6294: iconst_0
    //   6295: putfield 521	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mShouldReport	Z
    //   6298: aload_2
    //   6299: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6302: astore 22
    //   6304: new 300	java/lang/StringBuilder
    //   6307: dup
    //   6308: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   6311: aload_0
    //   6312: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   6315: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6318: ldc_w 523
    //   6321: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6324: aload 27
    //   6326: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6329: ldc_w 525
    //   6332: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6335: aload_2
    //   6336: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6339: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6342: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6345: ldc_w 527
    //   6348: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6351: astore 27
    //   6353: aload_0
    //   6354: getfield 531	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6357: ifnull +1064 -> 7421
    //   6360: aload_0
    //   6361: getfield 531	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6364: getfield 534	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6367: istore 4
    //   6369: aload 27
    //   6371: iload 4
    //   6373: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6376: ldc_w 467
    //   6379: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6382: iload_3
    //   6383: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6386: ldc_w 431
    //   6389: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6392: aload_2
    //   6393: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6396: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6399: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6402: ldc_w 443
    //   6405: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6408: aload_2
    //   6409: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6412: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6415: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6418: ldc_w 448
    //   6421: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6424: aload_2
    //   6425: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6428: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6431: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6434: ldc_w 436
    //   6437: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6440: aload_2
    //   6441: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6444: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6447: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6450: ldc_w 441
    //   6453: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6456: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   6459: aload_0
    //   6460: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   6463: lsub
    //   6464: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6467: astore 27
    //   6469: aload 20
    //   6471: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6474: ifne +953 -> 7427
    //   6477: new 300	java/lang/StringBuilder
    //   6480: dup
    //   6481: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   6484: ldc_w 471
    //   6487: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6490: aload 20
    //   6492: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6495: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6498: astore 20
    //   6500: aload 22
    //   6502: aload 27
    //   6504: aload 20
    //   6506: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6509: ldc_w 469
    //   6512: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6515: aload 26
    //   6517: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6520: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6523: putfield 537	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   6526: iload 6
    //   6528: ifeq +60 -> 6588
    //   6531: aload_0
    //   6532: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   6535: invokestatic 542	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   6538: astore 20
    //   6540: aload_0
    //   6541: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   6544: astore 22
    //   6546: aload_0
    //   6547: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   6550: ifeq +885 -> 7435
    //   6553: aload 23
    //   6555: ifnull +880 -> 7435
    //   6558: aload 23
    //   6560: ldc_w 544
    //   6563: invokevirtual 548	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6566: ifeq +869 -> 7435
    //   6569: iconst_1
    //   6570: istore 6
    //   6572: aload 20
    //   6574: aload 22
    //   6576: iload 6
    //   6578: aload_2
    //   6579: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6582: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6585: invokevirtual 552	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   6588: aload 24
    //   6590: invokestatic 248	java/lang/System:currentTimeMillis	()J
    //   6593: putfield 555	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   6596: aload 24
    //   6598: aload_0
    //   6599: invokevirtual 558	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getContentLength	()J
    //   6602: putfield 561	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   6605: aload 24
    //   6607: aload 21
    //   6609: putfield 565	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   6612: aload 24
    //   6614: iload_3
    //   6615: putfield 568	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   6618: aload 24
    //   6620: aconst_null
    //   6621: putfield 572	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   6624: aload 25
    //   6626: ifnonnull +815 -> 7441
    //   6629: aconst_null
    //   6630: astore 20
    //   6632: aload 24
    //   6634: aload 20
    //   6636: putfield 575	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   6639: aload 24
    //   6641: aconst_null
    //   6642: putfield 578	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   6645: aload 24
    //   6647: aload_2
    //   6648: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6651: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6654: putfield 579	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   6657: aload 24
    //   6659: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   6662: aload_0
    //   6663: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   6666: lsub
    //   6667: putfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6670: aload 24
    //   6672: aload_2
    //   6673: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6676: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6679: putfield 585	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   6682: aload 24
    //   6684: aload 24
    //   6686: getfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6689: aload_2
    //   6690: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6693: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6696: lsub
    //   6697: putfield 588	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   6700: aload 24
    //   6702: lload 8
    //   6704: putfield 591	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   6707: aload 24
    //   6709: lload 10
    //   6711: putfield 594	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   6714: aload 24
    //   6716: lload 10
    //   6718: putfield 597	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   6721: aload 24
    //   6723: aload_0
    //   6724: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   6727: putfield 600	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   6730: aload 24
    //   6732: lconst_0
    //   6733: putfield 603	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   6736: aload 24
    //   6738: aload_0
    //   6739: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   6742: putfield 606	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   6745: aload 24
    //   6747: aload_2
    //   6748: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6751: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6754: putfield 609	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   6757: aload 24
    //   6759: aload_0
    //   6760: invokevirtual 240	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   6763: invokestatic 612	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   6766: putfield 614	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   6769: aload 24
    //   6771: aload_0
    //   6772: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   6775: putfield 617	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   6778: aload 23
    //   6780: ifnull +671 -> 7451
    //   6783: aload 23
    //   6785: ldc_w 544
    //   6788: invokevirtual 548	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6791: ifeq +660 -> 7451
    //   6794: iconst_1
    //   6795: istore 6
    //   6797: aload 24
    //   6799: iload 6
    //   6801: putfield 620	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   6804: aload 24
    //   6806: aload_2
    //   6807: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6810: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6813: putfield 622	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   6816: aload 24
    //   6818: getstatic 628	com/tencent/component/network/downloader/Downloader$DownloadMode:OkHttpMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   6821: invokevirtual 631	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   6824: putfield 634	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   6827: aload 21
    //   6829: ifnull +24 -> 6853
    //   6832: aload 21
    //   6834: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6837: ifnull +16 -> 6853
    //   6840: aload 24
    //   6842: aload 21
    //   6844: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6847: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   6850: putfield 636	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   6853: aload_2
    //   6854: aload 24
    //   6856: invokevirtual 640	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6859: aload_2
    //   6860: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6863: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6866: ifeq +11 -> 6877
    //   6869: aload_0
    //   6870: aload_1
    //   6871: aload_2
    //   6872: aload 24
    //   6874: invokevirtual 644	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6877: goto -5274 -> 1603
    //   6880: aload_2
    //   6881: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6884: iconst_3
    //   6885: invokevirtual 205	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   6888: iconst_0
    //   6889: istore_3
    //   6890: goto -1266 -> 5624
    //   6893: aconst_null
    //   6894: astore 20
    //   6896: goto -1169 -> 5727
    //   6899: ldc_w 685
    //   6902: astore 22
    //   6904: goto -1063 -> 5841
    //   6907: aconst_null
    //   6908: astore 22
    //   6910: goto -665 -> 6245
    //   6913: new 300	java/lang/StringBuilder
    //   6916: dup
    //   6917: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   6920: ldc_w 687
    //   6923: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6926: aload_0
    //   6927: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   6930: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6933: ldc_w 373
    //   6936: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6939: aload_0
    //   6940: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   6943: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6946: ldc_w 382
    //   6949: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6952: astore 28
    //   6954: aload_0
    //   6955: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   6958: ifeq +449 -> 7407
    //   6961: aload 21
    //   6963: ifnull +444 -> 7407
    //   6966: aload 21
    //   6968: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6971: ifnull +436 -> 7407
    //   6974: aload 21
    //   6976: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6979: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   6982: astore 22
    //   6984: aload 28
    //   6986: aload 22
    //   6988: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6991: ldc_w 391
    //   6994: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6997: aload 25
    //   6999: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7002: ldc_w 396
    //   7005: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7008: aload 27
    //   7010: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7013: ldc_w 398
    //   7016: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7019: aconst_null
    //   7020: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7023: ldc_w 400
    //   7026: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7029: invokestatic 404	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7032: invokevirtual 407	java/lang/Thread:getId	()J
    //   7035: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7038: ldc_w 412
    //   7041: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7044: invokestatic 417	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7047: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7050: ldc_w 421
    //   7053: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7056: invokestatic 426	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7059: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7062: ldc_w 436
    //   7065: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7068: aload_2
    //   7069: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7072: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7075: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7078: ldc_w 441
    //   7081: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7084: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   7087: aload_0
    //   7088: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   7091: lsub
    //   7092: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7095: ldc_w 443
    //   7098: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7101: aload_2
    //   7102: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7105: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7108: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7111: ldc_w 448
    //   7114: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7117: aload_2
    //   7118: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7121: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7124: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7127: ldc_w 453
    //   7130: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7133: aload_2
    //   7134: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7137: getfield 456	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7140: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7143: ldc_w 458
    //   7146: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7149: aload_0
    //   7150: invokevirtual 190	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   7153: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7156: ldc_w 460
    //   7159: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7162: aload_0
    //   7163: invokevirtual 193	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   7166: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7169: ldc_w 689
    //   7172: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7175: iload_3
    //   7176: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7179: ldc_w 469
    //   7182: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7185: aload 26
    //   7187: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7190: ldc_w 431
    //   7193: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7196: aload_2
    //   7197: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7200: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7203: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7206: ldc_w 471
    //   7209: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7212: aload 20
    //   7214: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7217: ldc_w 473
    //   7220: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7223: aload_0
    //   7224: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   7227: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7230: ldc_w 475
    //   7233: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7236: aload_2
    //   7237: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7240: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7243: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7246: ldc_w 480
    //   7249: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7252: lload 12
    //   7254: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7257: ldc_w 482
    //   7260: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7263: lload 10
    //   7265: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7268: ldc_w 460
    //   7271: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7274: iconst_0
    //   7275: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7278: ldc_w 484
    //   7281: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7284: lconst_0
    //   7285: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7288: ldc_w 460
    //   7291: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7294: iconst_0
    //   7295: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7298: ldc_w 486
    //   7301: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7304: lload 10
    //   7306: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7309: ldc_w 488
    //   7312: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7315: aload_0
    //   7316: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   7319: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7322: ldc_w 493
    //   7325: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7328: aload_0
    //   7329: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   7332: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7335: ldc_w 498
    //   7338: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7341: astore 28
    //   7343: aload_0
    //   7344: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7347: ifnull +68 -> 7415
    //   7350: aload_0
    //   7351: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7354: invokeinterface 508 1 0
    //   7359: astore 22
    //   7361: aload 24
    //   7363: aload 28
    //   7365: aload 22
    //   7367: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7370: ldc_w 510
    //   7373: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7376: aload_2
    //   7377: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7380: getfield 513	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   7383: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7386: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7389: putfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7392: ldc_w 518
    //   7395: aload 24
    //   7397: getfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7400: aconst_null
    //   7401: invokestatic 692	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7404: goto -1116 -> 6288
    //   7407: ldc_w 685
    //   7410: astore 22
    //   7412: goto -428 -> 6984
    //   7415: aconst_null
    //   7416: astore 22
    //   7418: goto -57 -> 7361
    //   7421: iconst_0
    //   7422: istore 4
    //   7424: goto -1055 -> 6369
    //   7427: ldc_w 694
    //   7430: astore 20
    //   7432: goto -932 -> 6500
    //   7435: iconst_0
    //   7436: istore 6
    //   7438: goto -866 -> 6572
    //   7441: aload 25
    //   7443: invokevirtual 697	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   7446: astore 20
    //   7448: goto -816 -> 6632
    //   7451: iconst_0
    //   7452: istore 6
    //   7454: goto -657 -> 6797
    //   7457: aconst_null
    //   7458: astore 22
    //   7460: goto -7009 -> 451
    //   7463: ldc_w 685
    //   7466: astore 23
    //   7468: goto -6903 -> 565
    //   7471: aconst_null
    //   7472: astore 23
    //   7474: goto -6505 -> 969
    //   7477: new 300	java/lang/StringBuilder
    //   7480: dup
    //   7481: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   7484: ldc_w 687
    //   7487: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7490: aload_0
    //   7491: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   7494: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7497: ldc_w 373
    //   7500: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7503: aload_0
    //   7504: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   7507: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7510: ldc_w 382
    //   7513: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7516: astore 29
    //   7518: aload_0
    //   7519: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   7522: ifeq +449 -> 7971
    //   7525: aload 20
    //   7527: ifnull +444 -> 7971
    //   7530: aload 20
    //   7532: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7535: ifnull +436 -> 7971
    //   7538: aload 20
    //   7540: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7543: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   7546: astore 23
    //   7548: aload 29
    //   7550: aload 23
    //   7552: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7555: ldc_w 391
    //   7558: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7561: aload 26
    //   7563: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7566: ldc_w 396
    //   7569: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7572: aload 28
    //   7574: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7577: ldc_w 398
    //   7580: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7583: aconst_null
    //   7584: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7587: ldc_w 400
    //   7590: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7593: invokestatic 404	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7596: invokevirtual 407	java/lang/Thread:getId	()J
    //   7599: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7602: ldc_w 412
    //   7605: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7608: invokestatic 417	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7611: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7614: ldc_w 421
    //   7617: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7620: invokestatic 426	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7623: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7626: ldc_w 436
    //   7629: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7632: aload_2
    //   7633: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7636: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7639: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7642: ldc_w 441
    //   7645: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7648: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   7651: aload_0
    //   7652: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   7655: lsub
    //   7656: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7659: ldc_w 443
    //   7662: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7665: aload_2
    //   7666: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7669: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7672: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7675: ldc_w 448
    //   7678: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7681: aload_2
    //   7682: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7685: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7688: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7691: ldc_w 453
    //   7694: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7697: aload_2
    //   7698: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7701: getfield 456	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7704: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7707: ldc_w 458
    //   7710: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7713: aload_0
    //   7714: invokevirtual 190	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   7717: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7720: ldc_w 460
    //   7723: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7726: aload_0
    //   7727: invokevirtual 193	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   7730: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7733: ldc_w 689
    //   7736: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7739: iload_3
    //   7740: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7743: ldc_w 469
    //   7746: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7749: aload 27
    //   7751: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7754: ldc_w 431
    //   7757: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7760: aload_2
    //   7761: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7764: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7767: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7770: ldc_w 471
    //   7773: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7776: aload 22
    //   7778: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7781: ldc_w 473
    //   7784: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7787: aload_0
    //   7788: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   7791: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7794: ldc_w 475
    //   7797: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7800: aload_2
    //   7801: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7804: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7807: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7810: ldc_w 480
    //   7813: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7816: lload 14
    //   7818: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7821: ldc_w 482
    //   7824: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7827: lload 10
    //   7829: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7832: ldc_w 460
    //   7835: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7838: iconst_0
    //   7839: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7842: ldc_w 484
    //   7845: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7848: lconst_0
    //   7849: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7852: ldc_w 460
    //   7855: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7858: iconst_0
    //   7859: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7862: ldc_w 486
    //   7865: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7868: lload 12
    //   7870: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7873: ldc_w 488
    //   7876: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7879: aload_0
    //   7880: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   7883: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7886: ldc_w 493
    //   7889: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7892: aload_0
    //   7893: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   7896: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7899: ldc_w 498
    //   7902: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7905: astore 29
    //   7907: aload_0
    //   7908: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7911: ifnull +68 -> 7979
    //   7914: aload_0
    //   7915: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7918: invokeinterface 508 1 0
    //   7923: astore 23
    //   7925: aload 24
    //   7927: aload 29
    //   7929: aload 23
    //   7931: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7934: ldc_w 510
    //   7937: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7940: aload_2
    //   7941: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7944: getfield 513	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   7947: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7950: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7953: putfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7956: ldc_w 518
    //   7959: aload 24
    //   7961: getfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7964: aconst_null
    //   7965: invokestatic 692	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7968: goto -6955 -> 1013
    //   7971: ldc_w 685
    //   7974: astore 23
    //   7976: goto -428 -> 7548
    //   7979: aconst_null
    //   7980: astore 23
    //   7982: goto -57 -> 7925
    //   7985: iconst_0
    //   7986: istore 4
    //   7988: goto -6894 -> 1094
    //   7991: ldc_w 694
    //   7994: astore 22
    //   7996: goto -6771 -> 1225
    //   7999: iconst_0
    //   8000: istore 6
    //   8002: goto -6705 -> 1297
    //   8005: aload 26
    //   8007: invokevirtual 697	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   8010: astore 21
    //   8012: goto -6654 -> 1358
    //   8015: iconst_0
    //   8016: istore 6
    //   8018: goto -6495 -> 1523
    //   8021: astore 20
    //   8023: lload 8
    //   8025: lstore 12
    //   8027: aconst_null
    //   8028: astore 21
    //   8030: lload 14
    //   8032: lstore 8
    //   8034: iload 4
    //   8036: istore_3
    //   8037: aload_2
    //   8038: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8041: lload 16
    //   8043: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   8046: invokevirtual 329	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   8049: aload_2
    //   8050: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8053: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   8056: aload_0
    //   8057: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   8060: lsub
    //   8061: putfield 332	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   8064: aload_2
    //   8065: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8068: aload_0
    //   8069: getfield 335	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTaskStartTimeStamp	J
    //   8072: putfield 338	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   8075: aload_0
    //   8076: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   8079: invokestatic 344	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   8082: invokevirtual 348	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   8085: astore 26
    //   8087: aload_0
    //   8088: getfield 83	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mRemoteAddress	Ljava/lang/String;
    //   8091: astore 28
    //   8093: aload_0
    //   8094: aconst_null
    //   8095: aconst_null
    //   8096: aload 21
    //   8098: invokevirtual 352	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   8101: astore 27
    //   8103: aload_0
    //   8104: getfield 73	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsEnd	J
    //   8107: aload_0
    //   8108: getfield 70	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDnsStart	J
    //   8111: lsub
    //   8112: lstore 14
    //   8114: aload 21
    //   8116: ifnull +1177 -> 9293
    //   8119: aload 21
    //   8121: invokevirtual 355	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   8124: ifnull +1169 -> 9293
    //   8127: aload 21
    //   8129: invokevirtual 355	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   8132: ldc_w 357
    //   8135: invokevirtual 110	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   8138: astore 22
    //   8140: aload_2
    //   8141: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8144: aload 22
    //   8146: putfield 366	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   8149: aload_0
    //   8150: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   8153: astore 25
    //   8155: aload_1
    //   8156: invokeinterface 176 1 0
    //   8161: ifne +1129 -> 9290
    //   8164: aload_0
    //   8165: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   8168: invokestatic 186	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8171: istore 6
    //   8173: aload_2
    //   8174: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8177: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8180: ifne +1133 -> 9313
    //   8183: new 300	java/lang/StringBuilder
    //   8186: dup
    //   8187: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   8190: ldc_w 371
    //   8193: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8196: aload_0
    //   8197: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   8200: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8203: ldc_w 373
    //   8206: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8209: aload_0
    //   8210: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   8213: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8216: ldc_w 382
    //   8219: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8222: astore 29
    //   8224: aload_0
    //   8225: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   8228: ifeq +1071 -> 9299
    //   8231: aload 21
    //   8233: ifnull +1066 -> 9299
    //   8236: aload 21
    //   8238: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8241: ifnull +1058 -> 9299
    //   8244: aload 21
    //   8246: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8249: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   8252: astore 23
    //   8254: aload 29
    //   8256: aload 23
    //   8258: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8261: ldc_w 391
    //   8264: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8267: aload 26
    //   8269: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8272: ldc_w 396
    //   8275: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8278: aload 28
    //   8280: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8283: ldc_w 398
    //   8286: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8289: aconst_null
    //   8290: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8293: ldc_w 400
    //   8296: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8299: invokestatic 404	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8302: invokevirtual 407	java/lang/Thread:getId	()J
    //   8305: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8308: ldc_w 412
    //   8311: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8314: invokestatic 417	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   8317: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8320: ldc_w 419
    //   8323: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8326: iload 6
    //   8328: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8331: ldc_w 421
    //   8334: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8337: invokestatic 426	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   8340: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8343: ldc_w 431
    //   8346: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8349: aload_2
    //   8350: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8353: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8356: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8359: ldc_w 436
    //   8362: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8365: aload_2
    //   8366: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8369: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8372: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8375: ldc_w 441
    //   8378: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8381: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   8384: aload_0
    //   8385: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   8388: lsub
    //   8389: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8392: ldc_w 443
    //   8395: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8398: aload_2
    //   8399: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8402: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8405: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8408: ldc_w 448
    //   8411: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8414: aload_2
    //   8415: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8418: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8421: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8424: ldc_w 453
    //   8427: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8430: aload_2
    //   8431: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8434: getfield 456	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8437: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8440: ldc_w 458
    //   8443: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8446: aload_0
    //   8447: invokevirtual 190	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   8450: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8453: ldc_w 460
    //   8456: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8459: aload_0
    //   8460: invokevirtual 193	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   8463: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8466: ldc_w 462
    //   8469: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8472: aload_2
    //   8473: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8476: invokevirtual 465	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   8479: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8482: ldc_w 467
    //   8485: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8488: iload_3
    //   8489: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8492: ldc_w 469
    //   8495: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8498: aload 27
    //   8500: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8503: ldc_w 471
    //   8506: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8509: aload 22
    //   8511: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8514: ldc_w 473
    //   8517: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8520: aload_0
    //   8521: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   8524: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8527: ldc_w 475
    //   8530: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8533: aload_2
    //   8534: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8537: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8540: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8543: ldc_w 480
    //   8546: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8549: lload 14
    //   8551: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8554: ldc_w 482
    //   8557: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8560: lload 8
    //   8562: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8565: ldc_w 460
    //   8568: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8571: iconst_0
    //   8572: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8575: ldc_w 484
    //   8578: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8581: lconst_0
    //   8582: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8585: ldc_w 460
    //   8588: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8591: iconst_0
    //   8592: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8595: ldc_w 486
    //   8598: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8601: lload 10
    //   8603: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8606: ldc_w 488
    //   8609: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8612: aload_0
    //   8613: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   8616: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8619: ldc_w 493
    //   8622: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8625: aload_0
    //   8626: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   8629: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8632: ldc_w 498
    //   8635: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8638: astore 29
    //   8640: aload_0
    //   8641: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8644: ifnull +663 -> 9307
    //   8647: aload_0
    //   8648: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8651: invokeinterface 508 1 0
    //   8656: astore 23
    //   8658: aload 24
    //   8660: aload 29
    //   8662: aload 23
    //   8664: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8667: ldc_w 510
    //   8670: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8673: aload_2
    //   8674: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8677: getfield 513	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   8680: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8683: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8686: putfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8689: ldc_w 518
    //   8692: aload 24
    //   8694: getfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8697: aconst_null
    //   8698: invokestatic 316	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8701: iload 6
    //   8703: ifne +8 -> 8711
    //   8706: aload_0
    //   8707: iconst_0
    //   8708: putfield 521	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mShouldReport	Z
    //   8711: aload_2
    //   8712: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8715: astore 23
    //   8717: new 300	java/lang/StringBuilder
    //   8720: dup
    //   8721: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   8724: aload_0
    //   8725: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   8728: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8731: ldc_w 523
    //   8734: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8737: aload 28
    //   8739: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8742: ldc_w 525
    //   8745: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8748: aload_2
    //   8749: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8752: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8755: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8758: ldc_w 527
    //   8761: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8764: astore 28
    //   8766: aload_0
    //   8767: getfield 531	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8770: ifnull +1051 -> 9821
    //   8773: aload_0
    //   8774: getfield 531	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8777: getfield 534	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8780: istore 4
    //   8782: aload 28
    //   8784: iload 4
    //   8786: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8789: ldc_w 467
    //   8792: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8795: iload_3
    //   8796: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8799: ldc_w 431
    //   8802: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8805: aload_2
    //   8806: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8809: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8812: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8815: ldc_w 443
    //   8818: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8821: aload_2
    //   8822: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8825: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8828: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8831: ldc_w 448
    //   8834: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8837: aload_2
    //   8838: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8841: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8844: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8847: ldc_w 436
    //   8850: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8853: aload_2
    //   8854: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8857: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8860: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8863: ldc_w 441
    //   8866: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8869: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   8872: aload_0
    //   8873: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   8876: lsub
    //   8877: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8880: astore 28
    //   8882: aload 22
    //   8884: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8887: ifne +940 -> 9827
    //   8890: new 300	java/lang/StringBuilder
    //   8893: dup
    //   8894: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   8897: ldc_w 471
    //   8900: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8903: aload 22
    //   8905: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8908: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8911: astore 22
    //   8913: aload 23
    //   8915: aload 28
    //   8917: aload 22
    //   8919: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8922: ldc_w 469
    //   8925: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8928: aload 27
    //   8930: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8933: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8936: putfield 537	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   8939: iload 6
    //   8941: ifeq +60 -> 9001
    //   8944: aload_0
    //   8945: getfield 180	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mContext	Landroid/content/Context;
    //   8948: invokestatic 542	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   8951: astore 22
    //   8953: aload_0
    //   8954: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   8957: astore 23
    //   8959: aload_0
    //   8960: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   8963: ifeq +872 -> 9835
    //   8966: aload 25
    //   8968: ifnull +867 -> 9835
    //   8971: aload 25
    //   8973: ldc_w 544
    //   8976: invokevirtual 548	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8979: ifeq +856 -> 9835
    //   8982: iconst_1
    //   8983: istore 6
    //   8985: aload 22
    //   8987: aload 23
    //   8989: iload 6
    //   8991: aload_2
    //   8992: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8995: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8998: invokevirtual 552	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   9001: aload 24
    //   9003: invokestatic 248	java/lang/System:currentTimeMillis	()J
    //   9006: putfield 555	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   9009: aload 24
    //   9011: aload_0
    //   9012: invokevirtual 558	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getContentLength	()J
    //   9015: putfield 561	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   9018: aload 24
    //   9020: aload 21
    //   9022: putfield 565	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   9025: aload 24
    //   9027: iload_3
    //   9028: putfield 568	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   9031: aload 24
    //   9033: aconst_null
    //   9034: putfield 572	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   9037: aload 26
    //   9039: ifnonnull +802 -> 9841
    //   9042: aconst_null
    //   9043: astore 22
    //   9045: aload 24
    //   9047: aload 22
    //   9049: putfield 575	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   9052: aload 24
    //   9054: aconst_null
    //   9055: putfield 578	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   9058: aload 24
    //   9060: aload_2
    //   9061: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9064: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9067: putfield 579	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   9070: aload 24
    //   9072: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   9075: aload_0
    //   9076: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   9079: lsub
    //   9080: putfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9083: aload 24
    //   9085: aload_2
    //   9086: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9089: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9092: putfield 585	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   9095: aload 24
    //   9097: aload 24
    //   9099: getfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9102: aload_2
    //   9103: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9106: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9109: lsub
    //   9110: putfield 588	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   9113: aload 24
    //   9115: lload 12
    //   9117: putfield 591	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   9120: aload 24
    //   9122: lload 8
    //   9124: putfield 594	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   9127: aload 24
    //   9129: lload 10
    //   9131: putfield 597	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   9134: aload 24
    //   9136: aload_0
    //   9137: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   9140: putfield 600	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   9143: aload 24
    //   9145: lconst_0
    //   9146: putfield 603	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   9149: aload 24
    //   9151: aload_0
    //   9152: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   9155: putfield 606	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   9158: aload 24
    //   9160: aload_2
    //   9161: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9164: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9167: putfield 609	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   9170: aload 24
    //   9172: aload_0
    //   9173: invokevirtual 240	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getDomain	()Ljava/lang/String;
    //   9176: invokestatic 612	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   9179: putfield 614	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   9182: aload 24
    //   9184: aload_0
    //   9185: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   9188: putfield 617	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   9191: aload 25
    //   9193: ifnull +658 -> 9851
    //   9196: aload 25
    //   9198: ldc_w 544
    //   9201: invokevirtual 548	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9204: ifeq +647 -> 9851
    //   9207: iconst_1
    //   9208: istore 6
    //   9210: aload 24
    //   9212: iload 6
    //   9214: putfield 620	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   9217: aload 24
    //   9219: aload_2
    //   9220: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9223: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9226: putfield 622	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   9229: aload 24
    //   9231: getstatic 628	com/tencent/component/network/downloader/Downloader$DownloadMode:OkHttpMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   9234: invokevirtual 631	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   9237: putfield 634	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   9240: aload 21
    //   9242: ifnull +24 -> 9266
    //   9245: aload 21
    //   9247: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9250: ifnull +16 -> 9266
    //   9253: aload 24
    //   9255: aload 21
    //   9257: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9260: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9263: putfield 636	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   9266: aload_2
    //   9267: aload 24
    //   9269: invokevirtual 640	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9272: aload_2
    //   9273: invokevirtual 199	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9276: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9279: ifeq +11 -> 9290
    //   9282: aload_0
    //   9283: aload_1
    //   9284: aload_2
    //   9285: aload 24
    //   9287: invokevirtual 644	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9290: aload 20
    //   9292: athrow
    //   9293: aconst_null
    //   9294: astore 22
    //   9296: goto -1156 -> 8140
    //   9299: ldc_w 685
    //   9302: astore 23
    //   9304: goto -1050 -> 8254
    //   9307: aconst_null
    //   9308: astore 23
    //   9310: goto -652 -> 8658
    //   9313: new 300	java/lang/StringBuilder
    //   9316: dup
    //   9317: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   9320: ldc_w 687
    //   9323: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9326: aload_0
    //   9327: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   9330: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9333: ldc_w 373
    //   9336: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9339: aload_0
    //   9340: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   9343: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9346: ldc_w 382
    //   9349: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9352: astore 29
    //   9354: aload_0
    //   9355: getfield 377	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mIsHttp2	Z
    //   9358: ifeq +449 -> 9807
    //   9361: aload 21
    //   9363: ifnull +444 -> 9807
    //   9366: aload 21
    //   9368: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9371: ifnull +436 -> 9807
    //   9374: aload 21
    //   9376: invokevirtual 386	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9379: invokevirtual 389	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9382: astore 23
    //   9384: aload 29
    //   9386: aload 23
    //   9388: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9391: ldc_w 391
    //   9394: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9397: aload 26
    //   9399: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9402: ldc_w 396
    //   9405: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9408: aload 28
    //   9410: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9413: ldc_w 398
    //   9416: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9419: aconst_null
    //   9420: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9423: ldc_w 400
    //   9426: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9429: invokestatic 404	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9432: invokevirtual 407	java/lang/Thread:getId	()J
    //   9435: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9438: ldc_w 412
    //   9441: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9444: invokestatic 417	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9447: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9450: ldc_w 421
    //   9453: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9456: invokestatic 426	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9459: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9462: ldc_w 436
    //   9465: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9468: aload_2
    //   9469: invokevirtual 323	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9472: getfield 439	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9475: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9478: ldc_w 441
    //   9481: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9484: invokestatic 23	android/os/SystemClock:uptimeMillis	()J
    //   9487: aload_0
    //   9488: getfield 25	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mTimeStamp	J
    //   9491: lsub
    //   9492: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9495: ldc_w 443
    //   9498: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9501: aload_2
    //   9502: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9505: getfield 446	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9508: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9511: ldc_w 448
    //   9514: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9517: aload_2
    //   9518: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9521: getfield 451	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9524: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9527: ldc_w 453
    //   9530: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9533: aload_2
    //   9534: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9537: getfield 456	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9540: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9543: ldc_w 458
    //   9546: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9549: aload_0
    //   9550: invokevirtual 190	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getCurrAttemptCount	()I
    //   9553: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9556: ldc_w 460
    //   9559: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9562: aload_0
    //   9563: invokevirtual 193	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTotalAttemptCount	()I
    //   9566: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9569: ldc_w 689
    //   9572: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9575: iload_3
    //   9576: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9579: ldc_w 469
    //   9582: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9585: aload 27
    //   9587: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9590: ldc_w 431
    //   9593: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9596: aload_2
    //   9597: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9600: getfield 434	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9603: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9606: ldc_w 471
    //   9609: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9612: aload 22
    //   9614: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9617: ldc_w 473
    //   9620: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9623: aload_0
    //   9624: invokevirtual 159	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getUrl	()Ljava/lang/String;
    //   9627: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9630: ldc_w 475
    //   9633: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9636: aload_2
    //   9637: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9640: getfield 478	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9643: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9646: ldc_w 480
    //   9649: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9652: lload 14
    //   9654: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9657: ldc_w 482
    //   9660: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9663: lload 8
    //   9665: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9668: ldc_w 460
    //   9671: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9674: iconst_0
    //   9675: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9678: ldc_w 484
    //   9681: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9684: lconst_0
    //   9685: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9688: ldc_w 460
    //   9691: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9694: iconst_0
    //   9695: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9698: ldc_w 486
    //   9701: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9704: lload 10
    //   9706: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9709: ldc_w 488
    //   9712: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9715: aload_0
    //   9716: getfield 491	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:t_recv_data	J
    //   9719: invokevirtual 410	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9722: ldc_w 493
    //   9725: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9728: aload_0
    //   9729: invokevirtual 496	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:getTaskConcurrentCount	()I
    //   9732: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9735: ldc_w 498
    //   9738: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9741: astore 29
    //   9743: aload_0
    //   9744: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9747: ifnull +68 -> 9815
    //   9750: aload_0
    //   9751: getfield 502	com/tencent/component/network/downloader/impl/OkHttpDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9754: invokeinterface 508 1 0
    //   9759: astore 23
    //   9761: aload 24
    //   9763: aload 29
    //   9765: aload 23
    //   9767: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9770: ldc_w 510
    //   9773: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9776: aload_2
    //   9777: invokevirtual 361	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9780: getfield 513	com/tencent/component/network/downloader/DownloadResult$Content:isGzip	Z
    //   9783: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9786: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9789: putfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9792: ldc_w 518
    //   9795: aload 24
    //   9797: getfield 516	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9800: aconst_null
    //   9801: invokestatic 692	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9804: goto -1103 -> 8701
    //   9807: ldc_w 685
    //   9810: astore 23
    //   9812: goto -428 -> 9384
    //   9815: aconst_null
    //   9816: astore 23
    //   9818: goto -57 -> 9761
    //   9821: iconst_0
    //   9822: istore 4
    //   9824: goto -1042 -> 8782
    //   9827: ldc_w 694
    //   9830: astore 22
    //   9832: goto -919 -> 8913
    //   9835: iconst_0
    //   9836: istore 6
    //   9838: goto -853 -> 8985
    //   9841: aload 26
    //   9843: invokevirtual 697	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   9846: astore 22
    //   9848: goto -803 -> 9045
    //   9851: iconst_0
    //   9852: istore 6
    //   9854: goto -644 -> 9210
    //   9857: astore 20
    //   9859: aconst_null
    //   9860: astore 21
    //   9862: iload 4
    //   9864: istore_3
    //   9865: lload 8
    //   9867: lstore 12
    //   9869: lload 14
    //   9871: lstore 8
    //   9873: goto -1836 -> 8037
    //   9876: astore 20
    //   9878: iload 4
    //   9880: istore_3
    //   9881: lload 8
    //   9883: lstore 12
    //   9885: lload 14
    //   9887: lstore 8
    //   9889: goto -1852 -> 8037
    //   9892: astore 20
    //   9894: lload 10
    //   9896: lstore 14
    //   9898: iload 4
    //   9900: istore_3
    //   9901: lload 8
    //   9903: lstore 12
    //   9905: lload 14
    //   9907: lstore 8
    //   9909: goto -1872 -> 8037
    //   9912: astore 20
    //   9914: lload 10
    //   9916: lstore 14
    //   9918: lload 8
    //   9920: lstore 12
    //   9922: lload 14
    //   9924: lstore 8
    //   9926: goto -1889 -> 8037
    //   9929: astore 21
    //   9931: lload 10
    //   9933: lstore 14
    //   9935: lload 12
    //   9937: lstore 10
    //   9939: aload 20
    //   9941: astore 22
    //   9943: aload 21
    //   9945: astore 20
    //   9947: aload 22
    //   9949: astore 21
    //   9951: lload 8
    //   9953: lstore 12
    //   9955: lload 14
    //   9957: lstore 8
    //   9959: goto -1922 -> 8037
    //   9962: astore 21
    //   9964: lconst_0
    //   9965: lstore 12
    //   9967: lconst_0
    //   9968: lstore 10
    //   9970: iconst_0
    //   9971: istore_3
    //   9972: goto -9669 -> 303
    //   9975: astore 22
    //   9977: aload 21
    //   9979: astore 20
    //   9981: lconst_0
    //   9982: lstore 12
    //   9984: lconst_0
    //   9985: lstore 10
    //   9987: iconst_0
    //   9988: istore_3
    //   9989: aload 22
    //   9991: astore 21
    //   9993: goto -9690 -> 303
    //   9996: astore 22
    //   9998: aload 21
    //   10000: astore 20
    //   10002: iconst_0
    //   10003: istore_3
    //   10004: aload 22
    //   10006: astore 21
    //   10008: lload 10
    //   10010: lstore 12
    //   10012: goto -9709 -> 303
    //   10015: astore 20
    //   10017: aload 21
    //   10019: astore 22
    //   10021: lload 10
    //   10023: lstore 12
    //   10025: aload 20
    //   10027: astore 21
    //   10029: aload 22
    //   10031: astore 20
    //   10033: goto -9730 -> 303
    //   10036: sipush 200
    //   10039: iload_3
    //   10040: if_icmpeq -6270 -> 3770
    //   10043: sipush 206
    //   10046: iload_3
    //   10047: if_icmpne -4452 -> 5595
    //   10050: goto -6280 -> 3770
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10053	0	this	OkHttpDownloadTask
    //   0	10053	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	10053	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   302	9746	3	i	int
    //   168	9731	4	j	int
    //   18	110	5	k	int
    //   482	9371	6	bool1	boolean
    //   23	55	7	bool2	boolean
    //   26	9932	8	l1	long
    //   177	9845	10	l2	long
    //   296	9728	12	l3	long
    //   174	9782	14	l4	long
    //   114	7928	16	l5	long
    //   1656	3	18	l6	long
    //   91	1	20	localException	java.lang.Exception
    //   171	7368	20	localObject1	java.lang.Object
    //   8021	1270	20	localObject2	java.lang.Object
    //   9857	1	20	localObject3	java.lang.Object
    //   9876	1	20	localObject4	java.lang.Object
    //   9892	1	20	localObject5	java.lang.Object
    //   9912	28	20	localObject6	java.lang.Object
    //   9945	56	20	localObject7	java.lang.Object
    //   10015	11	20	localThrowable1	Throwable
    //   10031	1	20	localObject8	java.lang.Object
    //   193	88	21	localBuilder	okhttp3.Request.Builder
    //   293	1053	21	localThrowable2	Throwable
    //   1356	8505	21	localObject9	java.lang.Object
    //   9929	15	21	localObject10	java.lang.Object
    //   9949	1	21	localObject11	java.lang.Object
    //   9962	16	21	localThrowable3	Throwable
    //   9991	37	21	localObject12	java.lang.Object
    //   216	9732	22	localObject13	java.lang.Object
    //   9975	15	22	localThrowable4	Throwable
    //   9996	9	22	localThrowable5	Throwable
    //   10019	11	22	localObject14	java.lang.Object
    //   250	9567	23	localObject15	java.lang.Object
    //   123	9673	24	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   238	8959	25	localObject16	java.lang.Object
    //   396	9446	26	localObject17	java.lang.Object
    //   412	9174	27	localObject18	java.lang.Object
    //   402	9007	28	localObject19	java.lang.Object
    //   533	9231	29	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   71	77	91	java/lang/Exception
    //   179	218	293	java/lang/Throwable
    //   218	290	293	java/lang/Throwable
    //   1613	1627	293	java/lang/Throwable
    //   179	218	8021	finally
    //   218	290	8021	finally
    //   1613	1627	8021	finally
    //   1634	1653	9857	finally
    //   1653	1658	9876	finally
    //   1665	1671	9892	finally
    //   1687	1695	9892	finally
    //   1699	1782	9892	finally
    //   3597	3643	9892	finally
    //   3643	3661	9892	finally
    //   3666	3672	9892	finally
    //   6880	6888	9892	finally
    //   3672	3767	9912	finally
    //   3770	3777	9912	finally
    //   5595	5616	9912	finally
    //   5616	5624	9912	finally
    //   303	348	9929	finally
    //   1634	1653	9962	java/lang/Throwable
    //   1653	1658	9975	java/lang/Throwable
    //   1665	1671	9996	java/lang/Throwable
    //   1687	1695	9996	java/lang/Throwable
    //   1699	1782	9996	java/lang/Throwable
    //   3597	3643	9996	java/lang/Throwable
    //   3643	3661	9996	java/lang/Throwable
    //   3666	3672	9996	java/lang/Throwable
    //   6880	6888	9996	java/lang/Throwable
    //   3672	3767	10015	java/lang/Throwable
    //   3770	3777	10015	java/lang/Throwable
    //   5595	5616	10015	java/lang/Throwable
    //   5616	5624	10015	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.OkHttpDownloadTask
 * JD-Core Version:    0.7.0.1
 */