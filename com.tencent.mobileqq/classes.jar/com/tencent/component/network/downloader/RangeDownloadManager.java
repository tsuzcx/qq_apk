package com.tencent.component.network.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class RangeDownloadManager
{
  private static final int DEFAULT_RANGE_NUMBER = 4;
  private List<Request> allRangeRequests = new ArrayList();
  private final DownloadResult downloadResult;
  private long durationMillisForHeadPhase;
  private long durationMillisForRangeMergePhase;
  private long durationMillisForRangeReceivePhase;
  private long fileSize;
  private final int numberOfRangeTasks;
  private final OkHttpClient okHttpClient;
  private List<RangeDownloadReport> rangeDownloadReports = new ArrayList();
  private final HttpUtil.RequestOptions requestOptions;
  
  public RangeDownloadManager(OkHttpClient paramOkHttpClient, HttpUtil.RequestOptions paramRequestOptions, DownloadResult paramDownloadResult, int paramInt)
  {
    this.okHttpClient = paramOkHttpClient;
    this.requestOptions = paramRequestOptions;
    this.downloadResult = paramDownloadResult;
    if (paramInt > 0) {}
    for (;;)
    {
      this.numberOfRangeTasks = paramInt;
      return;
      paramInt = 4;
    }
  }
  
  /* Error */
  private okio.BufferedSource provideResponseBodyFromBufferedSourceInCaseOfOOM(RangeDownloadManager.RangeDownloadResult[] paramArrayOfRangeDownloadResult)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 55	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   13: aload_0
    //   14: getfield 42	com/tencent/component/network/downloader/RangeDownloadManager:downloadResult	Lcom/tencent/component/network/downloader/DownloadResult;
    //   17: invokevirtual 62	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   20: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 68
    //   25: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: astore 7
    //   33: new 73	java/io/FileOutputStream
    //   36: dup
    //   37: aload 7
    //   39: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   42: astore 5
    //   44: aload 5
    //   46: astore 4
    //   48: aload_1
    //   49: arraylength
    //   50: istore_3
    //   51: iconst_0
    //   52: istore_2
    //   53: iload_2
    //   54: iload_3
    //   55: if_icmpge +69 -> 124
    //   58: aload_1
    //   59: iload_2
    //   60: aaload
    //   61: astore 6
    //   63: aload 5
    //   65: astore 4
    //   67: aload 6
    //   69: invokevirtual 82	com/tencent/component/network/downloader/RangeDownloadManager$RangeDownloadResult:getResponse	()Lokhttp3/Response;
    //   72: astore 8
    //   74: aload 8
    //   76: ifnull +41 -> 117
    //   79: aload 5
    //   81: astore 4
    //   83: aload 8
    //   85: invokevirtual 88	okhttp3/Response:isSuccessful	()Z
    //   88: ifeq +29 -> 117
    //   91: aload 5
    //   93: astore 4
    //   95: aload 8
    //   97: invokevirtual 92	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   100: ifnull +17 -> 117
    //   103: aload 5
    //   105: astore 4
    //   107: aload 5
    //   109: aload 6
    //   111: invokevirtual 96	com/tencent/component/network/downloader/RangeDownloadManager$RangeDownloadResult:getContentBytes	()[B
    //   114: invokevirtual 100	java/io/FileOutputStream:write	([B)V
    //   117: iload_2
    //   118: iconst_1
    //   119: iadd
    //   120: istore_2
    //   121: goto -68 -> 53
    //   124: aload 5
    //   126: ifnull +8 -> 134
    //   129: aload 5
    //   131: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   134: new 105	java/io/File
    //   137: dup
    //   138: aload 7
    //   140: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: invokestatic 112	okio/Okio:source	(Ljava/io/File;)Lokio/Source;
    //   146: invokestatic 116	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   149: astore_1
    //   150: aload_1
    //   151: areturn
    //   152: astore_1
    //   153: ldc 118
    //   155: aload_1
    //   156: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
    //   159: aload_1
    //   160: invokestatic 127	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: goto -29 -> 134
    //   166: astore 6
    //   168: aconst_null
    //   169: astore_1
    //   170: aload_1
    //   171: astore 4
    //   173: ldc 118
    //   175: aload 6
    //   177: invokevirtual 128	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   180: aload 6
    //   182: invokestatic 127	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   185: aload_1
    //   186: ifnull -52 -> 134
    //   189: aload_1
    //   190: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   193: goto -59 -> 134
    //   196: astore_1
    //   197: ldc 118
    //   199: aload_1
    //   200: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
    //   203: aload_1
    //   204: invokestatic 127	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   207: goto -73 -> 134
    //   210: astore_1
    //   211: aconst_null
    //   212: astore 4
    //   214: aload 4
    //   216: ifnull +8 -> 224
    //   219: aload 4
    //   221: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   224: aload_1
    //   225: athrow
    //   226: astore 4
    //   228: ldc 118
    //   230: aload 4
    //   232: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
    //   235: aload 4
    //   237: invokestatic 127	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   240: goto -16 -> 224
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 131	java/io/FileNotFoundException:printStackTrace	()V
    //   248: aconst_null
    //   249: areturn
    //   250: astore_1
    //   251: goto -37 -> 214
    //   254: astore 6
    //   256: aload 5
    //   258: astore_1
    //   259: goto -89 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	RangeDownloadManager
    //   0	262	1	paramArrayOfRangeDownloadResult	RangeDownloadManager.RangeDownloadResult[]
    //   52	69	2	i	int
    //   50	6	3	j	int
    //   46	174	4	localObject	Object
    //   226	10	4	localIOException	IOException
    //   42	215	5	localFileOutputStream	java.io.FileOutputStream
    //   61	49	6	localRangeDownloadResult	RangeDownloadManager.RangeDownloadResult
    //   166	15	6	localException1	java.lang.Exception
    //   254	1	6	localException2	java.lang.Exception
    //   31	108	7	str	String
    //   72	24	8	localResponse	Response
    // Exception table:
    //   from	to	target	type
    //   129	134	152	java/io/IOException
    //   33	44	166	java/lang/Exception
    //   189	193	196	java/io/IOException
    //   33	44	210	finally
    //   219	224	226	java/io/IOException
    //   134	150	243	java/io/FileNotFoundException
    //   48	51	250	finally
    //   67	74	250	finally
    //   83	91	250	finally
    //   95	103	250	finally
    //   107	117	250	finally
    //   173	185	250	finally
    //   48	51	254	java/lang/Exception
    //   67	74	254	java/lang/Exception
    //   83	91	254	java/lang/Exception
    //   95	103	254	java/lang/Exception
    //   107	117	254	java/lang/Exception
  }
  
  /* Error */
  private Response simulateHttpResponseFromOkHttpResponses(RangeDownloadManager.RangeDownloadResult[] paramArrayOfRangeDownloadResult)
  {
    // Byte code:
    //   0: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   3: lstore 8
    //   5: aconst_null
    //   6: astore 10
    //   8: new 145	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 146	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore 16
    //   17: aload_1
    //   18: arraylength
    //   19: istore_3
    //   20: aconst_null
    //   21: astore 17
    //   23: aconst_null
    //   24: astore 10
    //   26: aconst_null
    //   27: astore 11
    //   29: aconst_null
    //   30: astore 12
    //   32: aconst_null
    //   33: astore 13
    //   35: aconst_null
    //   36: astore 14
    //   38: iconst_0
    //   39: istore_2
    //   40: iload_2
    //   41: iload_3
    //   42: if_icmpge +534 -> 576
    //   45: aload_1
    //   46: iload_2
    //   47: aaload
    //   48: astore 15
    //   50: aload 15
    //   52: invokevirtual 82	com/tencent/component/network/downloader/RangeDownloadManager$RangeDownloadResult:getResponse	()Lokhttp3/Response;
    //   55: astore 24
    //   57: aload 17
    //   59: astore 18
    //   61: aload 10
    //   63: astore 19
    //   65: aload 11
    //   67: astore 20
    //   69: aload 12
    //   71: astore 21
    //   73: aload 13
    //   75: astore 22
    //   77: aload 14
    //   79: astore 23
    //   81: aload 24
    //   83: ifnull +499 -> 582
    //   86: aload 17
    //   88: astore 18
    //   90: aload 10
    //   92: astore 19
    //   94: aload 11
    //   96: astore 20
    //   98: aload 12
    //   100: astore 21
    //   102: aload 13
    //   104: astore 22
    //   106: aload 14
    //   108: astore 23
    //   110: aload 24
    //   112: invokevirtual 88	okhttp3/Response:isSuccessful	()Z
    //   115: ifeq +467 -> 582
    //   118: aload 15
    //   120: invokevirtual 96	com/tencent/component/network/downloader/RangeDownloadManager$RangeDownloadResult:getContentBytes	()[B
    //   123: astore 18
    //   125: aload_0
    //   126: getfield 36	com/tencent/component/network/downloader/RangeDownloadManager:rangeDownloadReports	Ljava/util/List;
    //   129: aload 15
    //   131: invokevirtual 150	com/tencent/component/network/downloader/RangeDownloadManager$RangeDownloadResult:getRangeDownloadReport	()Lcom/tencent/component/network/downloader/RangeDownloadReport;
    //   134: invokeinterface 156 2 0
    //   139: pop
    //   140: aload 18
    //   142: ifnull +10 -> 152
    //   145: aload 16
    //   147: aload 18
    //   149: invokevirtual 157	java/io/ByteArrayOutputStream:write	([B)V
    //   152: aload 14
    //   154: astore 15
    //   156: aload 14
    //   158: ifnonnull +12 -> 170
    //   161: aload 24
    //   163: ldc 159
    //   165: invokevirtual 163	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 15
    //   170: aload 13
    //   172: astore 14
    //   174: aload 13
    //   176: ifnonnull +12 -> 188
    //   179: aload 24
    //   181: ldc 165
    //   183: invokevirtual 163	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 14
    //   188: aload 12
    //   190: astore 13
    //   192: aload 12
    //   194: ifnonnull +10 -> 204
    //   197: aload 24
    //   199: invokevirtual 169	okhttp3/Response:request	()Lokhttp3/Request;
    //   202: astore 13
    //   204: aload 11
    //   206: astore 12
    //   208: aload 11
    //   210: ifnonnull +10 -> 220
    //   213: aload 24
    //   215: invokevirtual 172	okhttp3/Response:message	()Ljava/lang/String;
    //   218: astore 12
    //   220: aload 10
    //   222: astore 11
    //   224: aload 10
    //   226: ifnonnull +10 -> 236
    //   229: aload 24
    //   231: invokevirtual 176	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   234: astore 11
    //   236: aload 17
    //   238: astore 18
    //   240: aload 11
    //   242: astore 19
    //   244: aload 12
    //   246: astore 20
    //   248: aload 13
    //   250: astore 21
    //   252: aload 14
    //   254: astore 22
    //   256: aload 15
    //   258: astore 23
    //   260: aload 17
    //   262: ifnonnull +320 -> 582
    //   265: aload 24
    //   267: invokevirtual 179	okhttp3/Response:priorResponse	()Lokhttp3/Response;
    //   270: astore 18
    //   272: aload 11
    //   274: astore 19
    //   276: aload 12
    //   278: astore 20
    //   280: aload 13
    //   282: astore 21
    //   284: aload 14
    //   286: astore 22
    //   288: aload 15
    //   290: astore 23
    //   292: goto +290 -> 582
    //   295: astore 15
    //   297: aload_0
    //   298: aload_1
    //   299: invokespecial 181	com/tencent/component/network/downloader/RangeDownloadManager:provideResponseBodyFromBufferedSourceInCaseOfOOM	([Lcom/tencent/component/network/downloader/RangeDownloadManager$RangeDownloadResult;)Lokio/BufferedSource;
    //   302: astore 15
    //   304: aload 15
    //   306: ifnull +156 -> 462
    //   309: aload_1
    //   310: arraylength
    //   311: istore_3
    //   312: iconst_0
    //   313: istore_2
    //   314: lconst_0
    //   315: lstore 4
    //   317: iload_2
    //   318: iload_3
    //   319: if_icmpge +35 -> 354
    //   322: aload_1
    //   323: iload_2
    //   324: aaload
    //   325: astore 18
    //   327: lload 4
    //   329: lstore 6
    //   331: aload 18
    //   333: invokevirtual 96	com/tencent/component/network/downloader/RangeDownloadManager$RangeDownloadResult:getContentBytes	()[B
    //   336: ifnull +277 -> 613
    //   339: lload 4
    //   341: aload 18
    //   343: invokevirtual 96	com/tencent/component/network/downloader/RangeDownloadManager$RangeDownloadResult:getContentBytes	()[B
    //   346: arraylength
    //   347: i2l
    //   348: ladd
    //   349: lstore 6
    //   351: goto +262 -> 613
    //   354: aconst_null
    //   355: lload 4
    //   357: aload 15
    //   359: invokestatic 187	okhttp3/ResponseBody:create	(Lokhttp3/MediaType;JLokio/BufferedSource;)Lokhttp3/ResponseBody;
    //   362: astore_1
    //   363: new 189	okhttp3/Response$Builder
    //   366: dup
    //   367: invokespecial 190	okhttp3/Response$Builder:<init>	()V
    //   370: aload 12
    //   372: invokevirtual 193	okhttp3/Response$Builder:request	(Lokhttp3/Request;)Lokhttp3/Response$Builder;
    //   375: aload_1
    //   376: invokevirtual 196	okhttp3/Response$Builder:body	(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;
    //   379: aload 10
    //   381: invokevirtual 199	okhttp3/Response$Builder:protocol	(Lokhttp3/Protocol;)Lokhttp3/Response$Builder;
    //   384: sipush 200
    //   387: invokevirtual 203	okhttp3/Response$Builder:code	(I)Lokhttp3/Response$Builder;
    //   390: aload 11
    //   392: invokevirtual 206	okhttp3/Response$Builder:message	(Ljava/lang/String;)Lokhttp3/Response$Builder;
    //   395: aload 17
    //   397: invokevirtual 209	okhttp3/Response$Builder:priorResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   400: astore_1
    //   401: aload 14
    //   403: invokestatic 215	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   406: ifne +12 -> 418
    //   409: aload_1
    //   410: ldc 159
    //   412: aload 14
    //   414: invokevirtual 218	okhttp3/Response$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Response$Builder;
    //   417: pop
    //   418: aload 13
    //   420: invokestatic 215	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   423: ifne +12 -> 435
    //   426: aload_1
    //   427: ldc 165
    //   429: aload 13
    //   431: invokevirtual 218	okhttp3/Response$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Response$Builder;
    //   434: pop
    //   435: aload_0
    //   436: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   439: lload 8
    //   441: lsub
    //   442: putfield 220	com/tencent/component/network/downloader/RangeDownloadManager:durationMillisForRangeMergePhase	J
    //   445: aload_1
    //   446: invokevirtual 223	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   449: astore_1
    //   450: aload 16
    //   452: ifnull +8 -> 460
    //   455: aload 16
    //   457: invokevirtual 224	java/io/ByteArrayOutputStream:close	()V
    //   460: aload_1
    //   461: areturn
    //   462: aconst_null
    //   463: aload 16
    //   465: invokevirtual 227	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   468: invokestatic 230	okhttp3/ResponseBody:create	(Lokhttp3/MediaType;[B)Lokhttp3/ResponseBody;
    //   471: astore_1
    //   472: goto -109 -> 363
    //   475: astore 10
    //   477: aload 10
    //   479: invokevirtual 231	java/io/IOException:printStackTrace	()V
    //   482: aload_1
    //   483: areturn
    //   484: astore 11
    //   486: aload 10
    //   488: astore_1
    //   489: aload 11
    //   491: astore 10
    //   493: ldc 233
    //   495: aload 10
    //   497: invokevirtual 234	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   500: aload 10
    //   502: invokestatic 127	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   505: aload_1
    //   506: ifnull +7 -> 513
    //   509: aload_1
    //   510: invokevirtual 224	java/io/ByteArrayOutputStream:close	()V
    //   513: aconst_null
    //   514: areturn
    //   515: astore_1
    //   516: aload_1
    //   517: invokevirtual 231	java/io/IOException:printStackTrace	()V
    //   520: goto -7 -> 513
    //   523: astore_1
    //   524: aconst_null
    //   525: astore 10
    //   527: aload 10
    //   529: ifnull +8 -> 537
    //   532: aload 10
    //   534: invokevirtual 224	java/io/ByteArrayOutputStream:close	()V
    //   537: aload_1
    //   538: athrow
    //   539: astore 10
    //   541: aload 10
    //   543: invokevirtual 231	java/io/IOException:printStackTrace	()V
    //   546: goto -9 -> 537
    //   549: astore_1
    //   550: aload 16
    //   552: astore 10
    //   554: goto -27 -> 527
    //   557: astore 11
    //   559: aload_1
    //   560: astore 10
    //   562: aload 11
    //   564: astore_1
    //   565: goto -38 -> 527
    //   568: astore 10
    //   570: aload 16
    //   572: astore_1
    //   573: goto -80 -> 493
    //   576: aconst_null
    //   577: astore 15
    //   579: goto -275 -> 304
    //   582: iload_2
    //   583: iconst_1
    //   584: iadd
    //   585: istore_2
    //   586: aload 18
    //   588: astore 17
    //   590: aload 19
    //   592: astore 10
    //   594: aload 20
    //   596: astore 11
    //   598: aload 21
    //   600: astore 12
    //   602: aload 22
    //   604: astore 13
    //   606: aload 23
    //   608: astore 14
    //   610: goto -570 -> 40
    //   613: iload_2
    //   614: iconst_1
    //   615: iadd
    //   616: istore_2
    //   617: lload 6
    //   619: lstore 4
    //   621: goto -304 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	624	0	this	RangeDownloadManager
    //   0	624	1	paramArrayOfRangeDownloadResult	RangeDownloadManager.RangeDownloadResult[]
    //   39	578	2	i	int
    //   19	301	3	j	int
    //   315	305	4	l1	long
    //   329	289	6	l2	long
    //   3	437	8	l3	long
    //   6	374	10	localProtocol1	okhttp3.Protocol
    //   475	12	10	localIOException1	IOException
    //   491	42	10	localObject1	Object
    //   539	3	10	localIOException2	IOException
    //   552	9	10	localObject2	Object
    //   568	1	10	localThrowable1	java.lang.Throwable
    //   592	1	10	localObject3	Object
    //   27	364	11	localProtocol2	okhttp3.Protocol
    //   484	6	11	localThrowable2	java.lang.Throwable
    //   557	6	11	localObject4	Object
    //   596	1	11	localObject5	Object
    //   30	571	12	localObject6	Object
    //   33	572	13	localObject7	Object
    //   36	573	14	localObject8	Object
    //   48	241	15	localObject9	Object
    //   295	1	15	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   302	276	15	localBufferedSource	okio.BufferedSource
    //   15	556	16	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   21	568	17	localObject10	Object
    //   59	528	18	localObject11	Object
    //   63	528	19	localProtocol3	okhttp3.Protocol
    //   67	528	20	localObject12	Object
    //   71	528	21	localObject13	Object
    //   75	528	22	localObject14	Object
    //   79	528	23	localObject15	Object
    //   55	211	24	localResponse	Response
    // Exception table:
    //   from	to	target	type
    //   145	152	295	java/lang/OutOfMemoryError
    //   455	460	475	java/io/IOException
    //   8	17	484	java/lang/Throwable
    //   509	513	515	java/io/IOException
    //   8	17	523	finally
    //   532	537	539	java/io/IOException
    //   17	20	549	finally
    //   50	57	549	finally
    //   110	140	549	finally
    //   145	152	549	finally
    //   161	170	549	finally
    //   179	188	549	finally
    //   197	204	549	finally
    //   213	220	549	finally
    //   229	236	549	finally
    //   265	272	549	finally
    //   297	304	549	finally
    //   309	312	549	finally
    //   331	351	549	finally
    //   354	363	549	finally
    //   363	418	549	finally
    //   418	435	549	finally
    //   435	450	549	finally
    //   462	472	549	finally
    //   493	505	557	finally
    //   17	20	568	java/lang/Throwable
    //   50	57	568	java/lang/Throwable
    //   110	140	568	java/lang/Throwable
    //   145	152	568	java/lang/Throwable
    //   161	170	568	java/lang/Throwable
    //   179	188	568	java/lang/Throwable
    //   197	204	568	java/lang/Throwable
    //   213	220	568	java/lang/Throwable
    //   229	236	568	java/lang/Throwable
    //   265	272	568	java/lang/Throwable
    //   297	304	568	java/lang/Throwable
    //   309	312	568	java/lang/Throwable
    //   331	351	568	java/lang/Throwable
    //   354	363	568	java/lang/Throwable
    //   363	418	568	java/lang/Throwable
    //   418	435	568	java/lang/Throwable
    //   435	450	568	java/lang/Throwable
    //   462	472	568	java/lang/Throwable
  }
  
  /* Error */
  private boolean writeResponseToFile(Response[] paramArrayOfResponse)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 5
    //   3: new 73	java/io/FileOutputStream
    //   6: dup
    //   7: aload_0
    //   8: getfield 42	com/tencent/component/network/downloader/RangeDownloadManager:downloadResult	Lcom/tencent/component/network/downloader/DownloadResult;
    //   11: invokevirtual 62	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   14: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: astore 9
    //   19: aload_1
    //   20: arraylength
    //   21: istore_3
    //   22: iconst_0
    //   23: istore_2
    //   24: lconst_0
    //   25: lstore 5
    //   27: iload_2
    //   28: iload_3
    //   29: if_icmpge +131 -> 160
    //   32: aload_1
    //   33: iload_2
    //   34: aaload
    //   35: astore 10
    //   37: aload 10
    //   39: invokevirtual 88	okhttp3/Response:isSuccessful	()Z
    //   42: ifeq +70 -> 112
    //   45: aload 10
    //   47: invokevirtual 92	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   50: ifnull +62 -> 112
    //   53: aload 10
    //   55: invokevirtual 92	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   58: invokevirtual 239	okhttp3/ResponseBody:bytes	()[B
    //   61: astore 11
    //   63: aload 11
    //   65: ifnull +259 -> 324
    //   68: aload 11
    //   70: arraylength
    //   71: istore 4
    //   73: iload 4
    //   75: i2l
    //   76: lload 5
    //   78: ladd
    //   79: lstore 7
    //   81: lload 7
    //   83: lstore 5
    //   85: aload 9
    //   87: aload 11
    //   89: invokevirtual 100	java/io/FileOutputStream:write	([B)V
    //   92: lload 7
    //   94: lstore 5
    //   96: aload 10
    //   98: invokevirtual 240	okhttp3/Response:close	()V
    //   101: iload_2
    //   102: iconst_1
    //   103: iadd
    //   104: istore_2
    //   105: lload 7
    //   107: lstore 5
    //   109: goto -82 -> 27
    //   112: aload_0
    //   113: getfield 42	com/tencent/component/network/downloader/RangeDownloadManager:downloadResult	Lcom/tencent/component/network/downloader/DownloadResult;
    //   116: invokevirtual 244	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   119: aload 10
    //   121: invokevirtual 247	okhttp3/Response:code	()I
    //   124: putfield 252	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   127: aload_0
    //   128: getfield 42	com/tencent/component/network/downloader/RangeDownloadManager:downloadResult	Lcom/tencent/component/network/downloader/DownloadResult;
    //   131: invokevirtual 244	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   134: iconst_1
    //   135: invokevirtual 256	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   138: aload 10
    //   140: invokevirtual 240	okhttp3/Response:close	()V
    //   143: aload 9
    //   145: ifnull +13 -> 158
    //   148: aload 9
    //   150: invokevirtual 259	java/io/FileOutputStream:flush	()V
    //   153: aload 9
    //   155: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   158: iconst_0
    //   159: ireturn
    //   160: lload 5
    //   162: lstore 7
    //   164: aload 9
    //   166: ifnull +17 -> 183
    //   169: aload 9
    //   171: invokevirtual 259	java/io/FileOutputStream:flush	()V
    //   174: aload 9
    //   176: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   179: lload 5
    //   181: lstore 7
    //   183: aload_0
    //   184: getfield 42	com/tencent/component/network/downloader/RangeDownloadManager:downloadResult	Lcom/tencent/component/network/downloader/DownloadResult;
    //   187: invokevirtual 244	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   190: sipush 200
    //   193: putfield 252	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   196: aload_0
    //   197: getfield 42	com/tencent/component/network/downloader/RangeDownloadManager:downloadResult	Lcom/tencent/component/network/downloader/DownloadResult;
    //   200: invokevirtual 244	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   203: invokevirtual 262	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   206: aload_0
    //   207: getfield 42	com/tencent/component/network/downloader/RangeDownloadManager:downloadResult	Lcom/tencent/component/network/downloader/DownloadResult;
    //   210: invokevirtual 266	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   213: lload 7
    //   215: putfield 271	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   218: iconst_1
    //   219: ireturn
    //   220: astore 9
    //   222: aconst_null
    //   223: astore_1
    //   224: lconst_0
    //   225: lstore 5
    //   227: ldc 233
    //   229: aload 9
    //   231: invokevirtual 234	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   234: aload 9
    //   236: invokestatic 127	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   239: lload 5
    //   241: lstore 7
    //   243: aload_1
    //   244: ifnull -61 -> 183
    //   247: aload_1
    //   248: invokevirtual 259	java/io/FileOutputStream:flush	()V
    //   251: aload_1
    //   252: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   255: lload 5
    //   257: lstore 7
    //   259: goto -76 -> 183
    //   262: astore_1
    //   263: aconst_null
    //   264: astore 9
    //   266: aload 9
    //   268: ifnull +13 -> 281
    //   271: aload 9
    //   273: invokevirtual 259	java/io/FileOutputStream:flush	()V
    //   276: aload 9
    //   278: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   281: aload_1
    //   282: athrow
    //   283: astore_1
    //   284: goto -18 -> 266
    //   287: astore 10
    //   289: aload_1
    //   290: astore 9
    //   292: aload 10
    //   294: astore_1
    //   295: goto -29 -> 266
    //   298: astore_1
    //   299: aload 9
    //   301: astore 10
    //   303: aload_1
    //   304: astore 9
    //   306: aload 10
    //   308: astore_1
    //   309: goto -82 -> 227
    //   312: astore 10
    //   314: aload 9
    //   316: astore_1
    //   317: aload 10
    //   319: astore 9
    //   321: goto -94 -> 227
    //   324: lload 5
    //   326: lstore 7
    //   328: goto -236 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	RangeDownloadManager
    //   0	331	1	paramArrayOfResponse	Response[]
    //   23	82	2	i	int
    //   21	9	3	j	int
    //   71	3	4	k	int
    //   1	324	5	l1	long
    //   79	248	7	l2	long
    //   17	158	9	localFileOutputStream	java.io.FileOutputStream
    //   220	15	9	localThrowable1	java.lang.Throwable
    //   264	56	9	localObject1	Object
    //   35	104	10	localResponse	Response
    //   287	6	10	localObject2	Object
    //   301	6	10	localObject3	Object
    //   312	6	10	localThrowable2	java.lang.Throwable
    //   61	27	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   3	19	220	java/lang/Throwable
    //   3	19	262	finally
    //   19	22	283	finally
    //   37	63	283	finally
    //   68	73	283	finally
    //   85	92	283	finally
    //   96	101	283	finally
    //   112	143	283	finally
    //   227	239	287	finally
    //   19	22	298	java/lang/Throwable
    //   85	92	298	java/lang/Throwable
    //   96	101	298	java/lang/Throwable
    //   37	63	312	java/lang/Throwable
    //   68	73	312	java/lang/Throwable
    //   112	143	312	java/lang/Throwable
  }
  
  public void cancel() {}
  
  public Response execute()
  {
    long l = System.currentTimeMillis();
    RangeDownloadManager.RangeDownloadResult[] arrayOfRangeDownloadResult = new RangeDownloadManager.RangeDownloadResult[this.numberOfRangeTasks];
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.allRangeRequests.size())
    {
      ((List)localObject1).add(new RangeDownloadManager.RangeDownloadCallable(this.okHttpClient, (Request)this.allRangeRequests.get(i), this.requestOptions, i));
      i += 1;
    }
    ExecutorService localExecutorService = Executors.newFixedThreadPool(this.numberOfRangeTasks);
    localObject1 = localExecutorService.invokeAll((Collection)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Future)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = (RangeDownloadManager.RangeDownloadResult)((Future)localObject2).get();
        arrayOfRangeDownloadResult[localObject2.getIndex()] = localObject2;
      }
    }
    localExecutorService.shutdown();
    localExecutorService.awaitTermination(1L, TimeUnit.SECONDS);
    this.durationMillisForRangeReceivePhase = (System.currentTimeMillis() - l);
    return simulateHttpResponseFromOkHttpResponses(arrayOfRangeDownloadResult);
  }
  
  public long getDurationMillisForHeadPhase()
  {
    return this.durationMillisForHeadPhase;
  }
  
  public long getDurationMillisForRangeMergePhase()
  {
    return this.durationMillisForRangeMergePhase;
  }
  
  public long getDurationMillisForRangeReceivePhase()
  {
    return this.durationMillisForRangeReceivePhase;
  }
  
  public long getFileSize()
  {
    return this.fileSize;
  }
  
  public int getNumberOfRangeTasks()
  {
    return this.numberOfRangeTasks;
  }
  
  public List<RangeDownloadReport> getRangeDownloadReports()
  {
    return this.rangeDownloadReports;
  }
  
  public void setFileSize(long paramLong)
  {
    this.fileSize = paramLong;
  }
  
  public boolean tryBuildAllRangeRequests(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Request.Builder paramBuilder)
  {
    Object localObject1 = paramBuilder;
    if (paramBuilder == null) {
      localObject1 = new Request.Builder();
    }
    long l3 = System.currentTimeMillis();
    Object localObject2 = null;
    for (;;)
    {
      long l2;
      try
      {
        l2 = getFileSize();
        if (l2 > 0L) {
          break label481;
        }
        l1 = System.currentTimeMillis();
        localObject1 = ((Request.Builder)localObject1).url(paramString3).head().build();
        localObject3 = this.okHttpClient.newCall((Request)localObject1).execute();
        QDLog.e("downloader_RANGE", "tryBuildAllRangeRequests header costTime:" + (System.currentTimeMillis() - l1) + ", rangeTaskNum:" + this.numberOfRangeTasks);
        l1 = l2;
        paramBuilder = (Request.Builder)localObject2;
        if (localObject3 == null) {
          break label466;
        }
        l1 = l2;
        paramBuilder = (Request.Builder)localObject2;
        if (!((Response)localObject3).isSuccessful()) {
          break label466;
        }
        paramBuilder = ((Response)localObject3).header("Accept-Ranges", null);
        l1 = Long.parseLong(((Response)localObject3).header("Content-Length", "0"));
      }
      catch (IOException paramContext)
      {
        Object localObject3;
        long l4;
        int i;
        long l5;
        QDLog.e("downloader_RANGE", "tryBuildAllRangeRequests exception:" + paramContext.getMessage(), paramContext);
        QDLog.w("downloader_RANGE", "tryBuildAllRangeRequests fail, url:" + paramString1 + ", requestUrl:" + paramString3);
        return false;
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equalsIgnoreCase("none")) && (l1 > 0L))
      {
        l4 = l1 / this.numberOfRangeTasks + 1L;
        i = 0;
        if (i < this.numberOfRangeTasks)
        {
          l5 = i * l4;
          l2 = l4 - 1L + l5;
          if (l2 < l1) {
            break label463;
          }
          l2 = -1L;
          if (paramBuilder != null)
          {
            localObject1 = paramBuilder.newBuilder().get().url(paramString1);
            localObject3 = new StringBuilder().append("bytes=").append(l5).append('-');
            if (l2 == -1L)
            {
              localObject2 = "";
              ((Request.Builder)localObject1).header("Range", localObject2);
              this.allRangeRequests.add(((Request.Builder)localObject1).build());
              i += 1;
            }
          }
          else
          {
            localObject1 = HttpUtil.createOkHttpGet(paramContext, paramString1, paramString2, paramString3, paramString4);
            continue;
          }
          localObject2 = Long.valueOf(l2);
          continue;
        }
        this.durationMillisForHeadPhase = (System.currentTimeMillis() - l3);
        return true;
      }
      label463:
      continue;
      label466:
      localObject2 = localObject1;
      localObject1 = paramBuilder;
      paramBuilder = (Request.Builder)localObject2;
      continue;
      label481:
      localObject1 = "bytes";
      paramBuilder = null;
      long l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.RangeDownloadManager
 * JD-Core Version:    0.7.0.1
 */