package com.tencent.av.HttpHelper;

import android.util.Log;
import java.util.Map;

public class HttpHelper
{
  private static final String TAG = "HttpHelper";
  
  public static boolean httpGetRequest(String paramString, final Object paramObject, final int paramInt, final HttpRequestListener paramHttpRequestListener)
  {
    Log.e("HttpHelper", "httpGetRequest|url = " + paramString + "|| http request timeout =" + paramInt);
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 9
        //   3: aconst_null
        //   4: astore 6
        //   6: aconst_null
        //   7: astore 10
        //   9: aconst_null
        //   10: astore 11
        //   12: aconst_null
        //   13: astore 12
        //   15: aconst_null
        //   16: astore 14
        //   18: aconst_null
        //   19: astore 8
        //   21: sipush 200
        //   24: istore_1
        //   25: aconst_null
        //   26: astore 13
        //   28: iload_1
        //   29: istore_3
        //   30: iload_1
        //   31: istore 4
        //   33: iload_1
        //   34: istore_2
        //   35: aload 14
        //   37: astore 7
        //   39: new 40	java/net/URL
        //   42: dup
        //   43: aload_0
        //   44: getfield 23	com/tencent/av/HttpHelper/HttpHelper$1:val$url	Ljava/lang/String;
        //   47: invokespecial 43	java/net/URL:<init>	(Ljava/lang/String;)V
        //   50: invokevirtual 47	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   53: checkcast 49	java/net/HttpURLConnection
        //   56: checkcast 49	java/net/HttpURLConnection
        //   59: astore 5
        //   61: aload 5
        //   63: astore 10
        //   65: iload_1
        //   66: istore_3
        //   67: aload 5
        //   69: astore 9
        //   71: iload_1
        //   72: istore 4
        //   74: aload 5
        //   76: astore 6
        //   78: iload_1
        //   79: istore_2
        //   80: aload 14
        //   82: astore 7
        //   84: aload 5
        //   86: ldc 51
        //   88: invokevirtual 54	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   91: aload 5
        //   93: astore 10
        //   95: iload_1
        //   96: istore_3
        //   97: aload 5
        //   99: astore 9
        //   101: iload_1
        //   102: istore 4
        //   104: aload 5
        //   106: astore 6
        //   108: iload_1
        //   109: istore_2
        //   110: aload 14
        //   112: astore 7
        //   114: aload 5
        //   116: aload_0
        //   117: getfield 25	com/tencent/av/HttpHelper/HttpHelper$1:val$timeout	I
        //   120: invokevirtual 58	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   123: aload 5
        //   125: astore 10
        //   127: iload_1
        //   128: istore_3
        //   129: aload 5
        //   131: astore 9
        //   133: iload_1
        //   134: istore 4
        //   136: aload 5
        //   138: astore 6
        //   140: iload_1
        //   141: istore_2
        //   142: aload 14
        //   144: astore 7
        //   146: aload 5
        //   148: aload_0
        //   149: getfield 25	com/tencent/av/HttpHelper/HttpHelper$1:val$timeout	I
        //   152: invokevirtual 61	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   155: aload 5
        //   157: astore 10
        //   159: iload_1
        //   160: istore_3
        //   161: aload 5
        //   163: astore 9
        //   165: iload_1
        //   166: istore 4
        //   168: aload 5
        //   170: astore 6
        //   172: iload_1
        //   173: istore_2
        //   174: aload 14
        //   176: astore 7
        //   178: aload 5
        //   180: invokevirtual 64	java/net/HttpURLConnection:connect	()V
        //   183: aload 5
        //   185: astore 10
        //   187: iload_1
        //   188: istore_3
        //   189: aload 5
        //   191: astore 9
        //   193: iload_1
        //   194: istore 4
        //   196: aload 5
        //   198: astore 6
        //   200: iload_1
        //   201: istore_2
        //   202: aload 14
        //   204: astore 7
        //   206: aload 5
        //   208: invokevirtual 68	java/net/HttpURLConnection:getResponseCode	()I
        //   211: istore_1
        //   212: iload_1
        //   213: sipush 200
        //   216: if_icmpne +209 -> 425
        //   219: aload 5
        //   221: astore 10
        //   223: iload_1
        //   224: istore_3
        //   225: aload 5
        //   227: astore 9
        //   229: iload_1
        //   230: istore 4
        //   232: aload 5
        //   234: astore 6
        //   236: iload_1
        //   237: istore_2
        //   238: aload 14
        //   240: astore 7
        //   242: new 70	java/io/BufferedInputStream
        //   245: dup
        //   246: aload 5
        //   248: invokevirtual 74	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   251: invokespecial 77	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   254: astore 8
        //   256: new 79	java/io/ByteArrayOutputStream
        //   259: dup
        //   260: sipush 10240
        //   263: invokespecial 81	java/io/ByteArrayOutputStream:<init>	(I)V
        //   266: astore 6
        //   268: sipush 1024
        //   271: newarray byte
        //   273: astore 7
        //   275: aload 8
        //   277: aload 7
        //   279: invokevirtual 87	java/io/InputStream:read	([B)I
        //   282: istore_2
        //   283: iload_2
        //   284: ifge +58 -> 342
        //   287: aload 6
        //   289: invokevirtual 91	java/io/ByteArrayOutputStream:toByteArray	()[B
        //   292: astore 6
        //   294: aload 8
        //   296: ifnull +8 -> 304
        //   299: aload 8
        //   301: invokevirtual 94	java/io/InputStream:close	()V
        //   304: aload 5
        //   306: ifnull +8 -> 314
        //   309: aload 5
        //   311: invokevirtual 97	java/net/HttpURLConnection:disconnect	()V
        //   314: aload_0
        //   315: getfield 27	com/tencent/av/HttpHelper/HttpHelper$1:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   318: ifnull +23 -> 341
        //   321: aload_0
        //   322: getfield 27	com/tencent/av/HttpHelper/HttpHelper$1:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   325: aload_0
        //   326: getfield 23	com/tencent/av/HttpHelper/HttpHelper$1:val$url	Ljava/lang/String;
        //   329: iload_1
        //   330: aload 6
        //   332: aload_0
        //   333: getfield 29	com/tencent/av/HttpHelper/HttpHelper$1:val$param	Ljava/lang/Object;
        //   336: invokeinterface 103 5 0
        //   341: return
        //   342: aload 6
        //   344: aload 7
        //   346: iconst_0
        //   347: iload_2
        //   348: invokevirtual 107	java/io/ByteArrayOutputStream:write	([BII)V
        //   351: goto -76 -> 275
        //   354: astore 9
        //   356: aload 5
        //   358: astore 6
        //   360: iload_1
        //   361: istore_2
        //   362: aload 8
        //   364: astore 7
        //   366: ldc 109
        //   368: ldc 111
        //   370: aload 9
        //   372: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   375: pop
        //   376: aload 8
        //   378: ifnull +8 -> 386
        //   381: aload 8
        //   383: invokevirtual 94	java/io/InputStream:close	()V
        //   386: aload 5
        //   388: ifnull +8 -> 396
        //   391: aload 5
        //   393: invokevirtual 97	java/net/HttpURLConnection:disconnect	()V
        //   396: aload_0
        //   397: getfield 27	com/tencent/av/HttpHelper/HttpHelper$1:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   400: ifnull -59 -> 341
        //   403: aload_0
        //   404: getfield 27	com/tencent/av/HttpHelper/HttpHelper$1:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   407: aload_0
        //   408: getfield 23	com/tencent/av/HttpHelper/HttpHelper$1:val$url	Ljava/lang/String;
        //   411: sipush 404
        //   414: aconst_null
        //   415: aload_0
        //   416: getfield 29	com/tencent/av/HttpHelper/HttpHelper$1:val$param	Ljava/lang/Object;
        //   419: invokeinterface 103 5 0
        //   424: return
        //   425: aload 5
        //   427: astore 10
        //   429: iload_1
        //   430: istore_3
        //   431: aload 5
        //   433: astore 9
        //   435: iload_1
        //   436: istore 4
        //   438: aload 5
        //   440: astore 6
        //   442: iload_1
        //   443: istore_2
        //   444: aload 14
        //   446: astore 7
        //   448: ldc 109
        //   450: new 119	java/lang/StringBuilder
        //   453: dup
        //   454: invokespecial 120	java/lang/StringBuilder:<init>	()V
        //   457: ldc 122
        //   459: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   462: iload_1
        //   463: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   466: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   469: invokestatic 136	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   472: pop
        //   473: aload 13
        //   475: astore 6
        //   477: goto -183 -> 294
        //   480: astore 9
        //   482: aload 10
        //   484: astore 5
        //   486: iload_3
        //   487: istore_1
        //   488: aload 11
        //   490: astore 8
        //   492: goto -136 -> 356
        //   495: astore 7
        //   497: aload 7
        //   499: invokevirtual 139	java/io/IOException:printStackTrace	()V
        //   502: goto -198 -> 304
        //   505: astore 6
        //   507: aload 6
        //   509: invokevirtual 139	java/io/IOException:printStackTrace	()V
        //   512: goto -126 -> 386
        //   515: astore 10
        //   517: aload 12
        //   519: astore 8
        //   521: iload 4
        //   523: istore_1
        //   524: aload 9
        //   526: astore 5
        //   528: aload 5
        //   530: astore 6
        //   532: iload_1
        //   533: istore_2
        //   534: aload 8
        //   536: astore 7
        //   538: ldc 109
        //   540: ldc 111
        //   542: aload 10
        //   544: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   547: pop
        //   548: aload 8
        //   550: ifnull +8 -> 558
        //   553: aload 8
        //   555: invokevirtual 94	java/io/InputStream:close	()V
        //   558: aload 5
        //   560: ifnull +8 -> 568
        //   563: aload 5
        //   565: invokevirtual 97	java/net/HttpURLConnection:disconnect	()V
        //   568: aload_0
        //   569: getfield 27	com/tencent/av/HttpHelper/HttpHelper$1:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   572: ifnull -231 -> 341
        //   575: aload_0
        //   576: getfield 27	com/tencent/av/HttpHelper/HttpHelper$1:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   579: aload_0
        //   580: getfield 23	com/tencent/av/HttpHelper/HttpHelper$1:val$url	Ljava/lang/String;
        //   583: iconst_m1
        //   584: aconst_null
        //   585: aload_0
        //   586: getfield 29	com/tencent/av/HttpHelper/HttpHelper$1:val$param	Ljava/lang/Object;
        //   589: invokeinterface 103 5 0
        //   594: return
        //   595: astore 6
        //   597: aload 6
        //   599: invokevirtual 139	java/io/IOException:printStackTrace	()V
        //   602: goto -44 -> 558
        //   605: astore 8
        //   607: iload_2
        //   608: istore_1
        //   609: aload 6
        //   611: astore 5
        //   613: aload 7
        //   615: ifnull +8 -> 623
        //   618: aload 7
        //   620: invokevirtual 94	java/io/InputStream:close	()V
        //   623: aload 5
        //   625: ifnull +8 -> 633
        //   628: aload 5
        //   630: invokevirtual 97	java/net/HttpURLConnection:disconnect	()V
        //   633: aload_0
        //   634: getfield 27	com/tencent/av/HttpHelper/HttpHelper$1:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   637: ifnull +22 -> 659
        //   640: aload_0
        //   641: getfield 27	com/tencent/av/HttpHelper/HttpHelper$1:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   644: aload_0
        //   645: getfield 23	com/tencent/av/HttpHelper/HttpHelper$1:val$url	Ljava/lang/String;
        //   648: iload_1
        //   649: aconst_null
        //   650: aload_0
        //   651: getfield 29	com/tencent/av/HttpHelper/HttpHelper$1:val$param	Ljava/lang/Object;
        //   654: invokeinterface 103 5 0
        //   659: aload 8
        //   661: athrow
        //   662: astore 6
        //   664: aload 6
        //   666: invokevirtual 139	java/io/IOException:printStackTrace	()V
        //   669: goto -46 -> 623
        //   672: astore 6
        //   674: aload 8
        //   676: astore 7
        //   678: aload 6
        //   680: astore 8
        //   682: goto -69 -> 613
        //   685: astore 10
        //   687: goto -159 -> 528
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	690	0	this	1
        //   24	625	1	i	int
        //   34	574	2	j	int
        //   29	458	3	k	int
        //   31	491	4	m	int
        //   59	570	5	localObject1	Object
        //   4	472	6	localObject2	Object
        //   505	3	6	localIOException1	java.io.IOException
        //   530	1	6	localObject3	Object
        //   595	15	6	localIOException2	java.io.IOException
        //   662	3	6	localIOException3	java.io.IOException
        //   672	7	6	localObject4	Object
        //   37	410	7	localObject5	Object
        //   495	3	7	localIOException4	java.io.IOException
        //   536	141	7	localObject6	Object
        //   19	535	8	localObject7	Object
        //   605	70	8	localObject8	Object
        //   680	1	8	localObject9	Object
        //   1	227	9	localObject10	Object
        //   354	17	9	localUnknownHostException1	java.net.UnknownHostException
        //   433	1	9	localObject11	Object
        //   480	45	9	localUnknownHostException2	java.net.UnknownHostException
        //   7	476	10	localObject12	Object
        //   515	28	10	localIOException5	java.io.IOException
        //   685	1	10	localIOException6	java.io.IOException
        //   10	479	11	localObject13	Object
        //   13	505	12	localObject14	Object
        //   26	448	13	localObject15	Object
        //   16	429	14	localObject16	Object
        // Exception table:
        //   from	to	target	type
        //   256	275	354	java/net/UnknownHostException
        //   275	283	354	java/net/UnknownHostException
        //   287	294	354	java/net/UnknownHostException
        //   342	351	354	java/net/UnknownHostException
        //   39	61	480	java/net/UnknownHostException
        //   84	91	480	java/net/UnknownHostException
        //   114	123	480	java/net/UnknownHostException
        //   146	155	480	java/net/UnknownHostException
        //   178	183	480	java/net/UnknownHostException
        //   206	212	480	java/net/UnknownHostException
        //   242	256	480	java/net/UnknownHostException
        //   448	473	480	java/net/UnknownHostException
        //   299	304	495	java/io/IOException
        //   381	386	505	java/io/IOException
        //   39	61	515	java/io/IOException
        //   84	91	515	java/io/IOException
        //   114	123	515	java/io/IOException
        //   146	155	515	java/io/IOException
        //   178	183	515	java/io/IOException
        //   206	212	515	java/io/IOException
        //   242	256	515	java/io/IOException
        //   448	473	515	java/io/IOException
        //   553	558	595	java/io/IOException
        //   39	61	605	finally
        //   84	91	605	finally
        //   114	123	605	finally
        //   146	155	605	finally
        //   178	183	605	finally
        //   206	212	605	finally
        //   242	256	605	finally
        //   366	376	605	finally
        //   448	473	605	finally
        //   538	548	605	finally
        //   618	623	662	java/io/IOException
        //   256	275	672	finally
        //   275	283	672	finally
        //   287	294	672	finally
        //   342	351	672	finally
        //   256	275	685	java/io/IOException
        //   275	283	685	java/io/IOException
        //   287	294	685	java/io/IOException
        //   342	351	685	java/io/IOException
      }
    }).start();
    return true;
  }
  
  public static boolean httpGetRequest(String paramString, Object paramObject, HttpRequestListener paramHttpRequestListener)
  {
    return httpGetRequest(paramString, paramObject, 5000, paramHttpRequestListener);
  }
  
  public static boolean httpPostRequest(String paramString, final byte[] paramArrayOfByte, final Map<String, String> paramMap, final Object paramObject, final int paramInt, final HttpRequestListener paramHttpRequestListener)
  {
    Log.e("HttpHelper", "httpPostRequest|url = " + paramString + "|| http request timeout =" + paramInt);
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 12
        //   3: aconst_null
        //   4: astore 7
        //   6: aconst_null
        //   7: astore 11
        //   9: aconst_null
        //   10: astore 10
        //   12: aconst_null
        //   13: astore 17
        //   15: aconst_null
        //   16: astore 21
        //   18: aconst_null
        //   19: astore 16
        //   21: sipush 200
        //   24: istore_1
        //   25: aconst_null
        //   26: astore 20
        //   28: aconst_null
        //   29: astore 13
        //   31: aconst_null
        //   32: astore 19
        //   34: aconst_null
        //   35: astore 22
        //   37: aconst_null
        //   38: astore 14
        //   40: aconst_null
        //   41: astore 15
        //   43: aconst_null
        //   44: astore 18
        //   46: iload_1
        //   47: istore_3
        //   48: iload_1
        //   49: istore 4
        //   51: iload_1
        //   52: istore_2
        //   53: aload 21
        //   55: astore 8
        //   57: aload 22
        //   59: astore 9
        //   61: new 48	java/net/URL
        //   64: dup
        //   65: aload_0
        //   66: getfield 27	com/tencent/av/HttpHelper/HttpHelper$2:val$url	Ljava/lang/String;
        //   69: invokespecial 51	java/net/URL:<init>	(Ljava/lang/String;)V
        //   72: invokevirtual 55	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   75: checkcast 57	java/net/HttpURLConnection
        //   78: checkcast 57	java/net/HttpURLConnection
        //   81: astore 6
        //   83: aload 6
        //   85: astore 11
        //   87: iload_1
        //   88: istore_3
        //   89: aload 6
        //   91: astore 12
        //   93: iload_1
        //   94: istore 4
        //   96: aload 6
        //   98: astore 7
        //   100: iload_1
        //   101: istore_2
        //   102: aload 21
        //   104: astore 8
        //   106: aload 22
        //   108: astore 9
        //   110: aload 6
        //   112: ldc 59
        //   114: invokevirtual 62	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   117: aload 6
        //   119: astore 11
        //   121: iload_1
        //   122: istore_3
        //   123: aload 6
        //   125: astore 12
        //   127: iload_1
        //   128: istore 4
        //   130: aload 6
        //   132: astore 7
        //   134: iload_1
        //   135: istore_2
        //   136: aload 21
        //   138: astore 8
        //   140: aload 22
        //   142: astore 9
        //   144: aload 6
        //   146: aload_0
        //   147: getfield 29	com/tencent/av/HttpHelper/HttpHelper$2:val$timeout	I
        //   150: invokevirtual 66	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   153: aload 6
        //   155: astore 11
        //   157: iload_1
        //   158: istore_3
        //   159: aload 6
        //   161: astore 12
        //   163: iload_1
        //   164: istore 4
        //   166: aload 6
        //   168: astore 7
        //   170: iload_1
        //   171: istore_2
        //   172: aload 21
        //   174: astore 8
        //   176: aload 22
        //   178: astore 9
        //   180: aload 6
        //   182: aload_0
        //   183: getfield 29	com/tencent/av/HttpHelper/HttpHelper$2:val$timeout	I
        //   186: invokevirtual 69	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   189: aload 6
        //   191: astore 11
        //   193: iload_1
        //   194: istore_3
        //   195: aload 6
        //   197: astore 12
        //   199: iload_1
        //   200: istore 4
        //   202: aload 6
        //   204: astore 7
        //   206: iload_1
        //   207: istore_2
        //   208: aload 21
        //   210: astore 8
        //   212: aload 22
        //   214: astore 9
        //   216: aload 6
        //   218: iconst_1
        //   219: invokevirtual 73	java/net/HttpURLConnection:setDoInput	(Z)V
        //   222: aload 6
        //   224: astore 11
        //   226: iload_1
        //   227: istore_3
        //   228: aload 6
        //   230: astore 12
        //   232: iload_1
        //   233: istore 4
        //   235: aload 6
        //   237: astore 7
        //   239: iload_1
        //   240: istore_2
        //   241: aload 21
        //   243: astore 8
        //   245: aload 22
        //   247: astore 9
        //   249: aload 6
        //   251: iconst_1
        //   252: invokevirtual 76	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   255: aload 6
        //   257: astore 11
        //   259: iload_1
        //   260: istore_3
        //   261: aload 6
        //   263: astore 12
        //   265: iload_1
        //   266: istore 4
        //   268: aload 6
        //   270: astore 7
        //   272: iload_1
        //   273: istore_2
        //   274: aload 21
        //   276: astore 8
        //   278: aload 22
        //   280: astore 9
        //   282: aload 6
        //   284: ldc 78
        //   286: ldc 80
        //   288: invokevirtual 84	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   291: aload 6
        //   293: astore 11
        //   295: iload_1
        //   296: istore_3
        //   297: aload 6
        //   299: astore 12
        //   301: iload_1
        //   302: istore 4
        //   304: aload 6
        //   306: astore 7
        //   308: iload_1
        //   309: istore_2
        //   310: aload 21
        //   312: astore 8
        //   314: aload 22
        //   316: astore 9
        //   318: aload 6
        //   320: ldc 86
        //   322: aload_0
        //   323: getfield 31	com/tencent/av/HttpHelper/HttpHelper$2:val$req	[B
        //   326: arraylength
        //   327: invokestatic 92	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   330: invokevirtual 84	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   333: aload 6
        //   335: astore 11
        //   337: iload_1
        //   338: istore_3
        //   339: aload 6
        //   341: astore 12
        //   343: iload_1
        //   344: istore 4
        //   346: aload 6
        //   348: astore 7
        //   350: iload_1
        //   351: istore_2
        //   352: aload 21
        //   354: astore 8
        //   356: aload 22
        //   358: astore 9
        //   360: aload_0
        //   361: getfield 33	com/tencent/av/HttpHelper/HttpHelper$2:val$mapPropertys	Ljava/util/Map;
        //   364: ifnull +306 -> 670
        //   367: aload 6
        //   369: astore 11
        //   371: iload_1
        //   372: istore_3
        //   373: aload 6
        //   375: astore 12
        //   377: iload_1
        //   378: istore 4
        //   380: aload 6
        //   382: astore 7
        //   384: iload_1
        //   385: istore_2
        //   386: aload 21
        //   388: astore 8
        //   390: aload 22
        //   392: astore 9
        //   394: aload_0
        //   395: getfield 33	com/tencent/av/HttpHelper/HttpHelper$2:val$mapPropertys	Ljava/util/Map;
        //   398: invokeinterface 98 1 0
        //   403: ifne +267 -> 670
        //   406: aload 6
        //   408: astore 11
        //   410: iload_1
        //   411: istore_3
        //   412: aload 6
        //   414: astore 12
        //   416: iload_1
        //   417: istore 4
        //   419: aload 6
        //   421: astore 7
        //   423: iload_1
        //   424: istore_2
        //   425: aload 21
        //   427: astore 8
        //   429: aload 22
        //   431: astore 9
        //   433: aload_0
        //   434: getfield 33	com/tencent/av/HttpHelper/HttpHelper$2:val$mapPropertys	Ljava/util/Map;
        //   437: invokeinterface 102 1 0
        //   442: invokeinterface 108 1 0
        //   447: astore 23
        //   449: aload 6
        //   451: astore 11
        //   453: iload_1
        //   454: istore_3
        //   455: aload 6
        //   457: astore 12
        //   459: iload_1
        //   460: istore 4
        //   462: aload 6
        //   464: astore 7
        //   466: iload_1
        //   467: istore_2
        //   468: aload 21
        //   470: astore 8
        //   472: aload 22
        //   474: astore 9
        //   476: aload 23
        //   478: invokeinterface 113 1 0
        //   483: ifeq +187 -> 670
        //   486: aload 6
        //   488: astore 11
        //   490: iload_1
        //   491: istore_3
        //   492: aload 6
        //   494: astore 12
        //   496: iload_1
        //   497: istore 4
        //   499: aload 6
        //   501: astore 7
        //   503: iload_1
        //   504: istore_2
        //   505: aload 21
        //   507: astore 8
        //   509: aload 22
        //   511: astore 9
        //   513: aload 23
        //   515: invokeinterface 117 1 0
        //   520: checkcast 119	java/util/Map$Entry
        //   523: astore 24
        //   525: aload 6
        //   527: astore 11
        //   529: iload_1
        //   530: istore_3
        //   531: aload 6
        //   533: astore 12
        //   535: iload_1
        //   536: istore 4
        //   538: aload 6
        //   540: astore 7
        //   542: iload_1
        //   543: istore_2
        //   544: aload 21
        //   546: astore 8
        //   548: aload 22
        //   550: astore 9
        //   552: aload 6
        //   554: aload 24
        //   556: invokeinterface 122 1 0
        //   561: checkcast 88	java/lang/String
        //   564: aload 24
        //   566: invokeinterface 125 1 0
        //   571: checkcast 88	java/lang/String
        //   574: invokevirtual 84	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   577: goto -128 -> 449
        //   580: astore 13
        //   582: aload 18
        //   584: astore 10
        //   586: aload 16
        //   588: astore 12
        //   590: iload_3
        //   591: istore_1
        //   592: aload 11
        //   594: astore 6
        //   596: aload 6
        //   598: astore 7
        //   600: iload_1
        //   601: istore_2
        //   602: aload 12
        //   604: astore 8
        //   606: aload 10
        //   608: astore 9
        //   610: ldc 127
        //   612: ldc 129
        //   614: aload 13
        //   616: invokestatic 135	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   619: pop
        //   620: aload 12
        //   622: ifnull +8 -> 630
        //   625: aload 12
        //   627: invokevirtual 139	java/io/InputStream:close	()V
        //   630: aload 6
        //   632: ifnull +8 -> 640
        //   635: aload 6
        //   637: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
        //   640: aload_0
        //   641: getfield 35	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   644: ifnull +25 -> 669
        //   647: aload_0
        //   648: getfield 35	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   651: aload_0
        //   652: getfield 27	com/tencent/av/HttpHelper/HttpHelper$2:val$url	Ljava/lang/String;
        //   655: sipush 404
        //   658: aload 10
        //   660: aload_0
        //   661: getfield 37	com/tencent/av/HttpHelper/HttpHelper$2:val$param	Ljava/lang/Object;
        //   664: invokeinterface 148 5 0
        //   669: return
        //   670: aload 6
        //   672: astore 11
        //   674: iload_1
        //   675: istore_3
        //   676: aload 6
        //   678: astore 12
        //   680: iload_1
        //   681: istore 4
        //   683: aload 6
        //   685: astore 7
        //   687: iload_1
        //   688: istore_2
        //   689: aload 21
        //   691: astore 8
        //   693: aload 22
        //   695: astore 9
        //   697: aload 6
        //   699: invokevirtual 152	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   702: aload_0
        //   703: getfield 31	com/tencent/av/HttpHelper/HttpHelper$2:val$req	[B
        //   706: invokevirtual 158	java/io/OutputStream:write	([B)V
        //   709: aload 6
        //   711: astore 11
        //   713: iload_1
        //   714: istore_3
        //   715: aload 6
        //   717: astore 12
        //   719: iload_1
        //   720: istore 4
        //   722: aload 6
        //   724: astore 7
        //   726: iload_1
        //   727: istore_2
        //   728: aload 21
        //   730: astore 8
        //   732: aload 22
        //   734: astore 9
        //   736: aload 6
        //   738: invokevirtual 162	java/net/HttpURLConnection:getResponseCode	()I
        //   741: istore_1
        //   742: iload_1
        //   743: sipush 200
        //   746: if_icmpne +322 -> 1068
        //   749: aload 6
        //   751: astore 11
        //   753: iload_1
        //   754: istore_3
        //   755: aload 6
        //   757: astore 12
        //   759: iload_1
        //   760: istore 4
        //   762: aload 6
        //   764: astore 7
        //   766: iload_1
        //   767: istore_2
        //   768: aload 21
        //   770: astore 8
        //   772: aload 22
        //   774: astore 9
        //   776: new 164	java/io/BufferedInputStream
        //   779: dup
        //   780: aload 6
        //   782: invokevirtual 168	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   785: invokespecial 171	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   788: astore 10
        //   790: aload 13
        //   792: astore 8
        //   794: aload 14
        //   796: astore 11
        //   798: aload 15
        //   800: astore 9
        //   802: new 173	java/io/ByteArrayOutputStream
        //   805: dup
        //   806: sipush 10240
        //   809: invokespecial 175	java/io/ByteArrayOutputStream:<init>	(I)V
        //   812: astore 7
        //   814: aload 13
        //   816: astore 8
        //   818: aload 14
        //   820: astore 11
        //   822: aload 15
        //   824: astore 9
        //   826: sipush 1024
        //   829: newarray byte
        //   831: astore 12
        //   833: aload 13
        //   835: astore 8
        //   837: aload 14
        //   839: astore 11
        //   841: aload 15
        //   843: astore 9
        //   845: aload 10
        //   847: aload 12
        //   849: invokevirtual 179	java/io/InputStream:read	([B)I
        //   852: istore_2
        //   853: iload_2
        //   854: ifge +177 -> 1031
        //   857: aload 13
        //   859: astore 8
        //   861: aload 14
        //   863: astore 11
        //   865: aload 15
        //   867: astore 9
        //   869: aload 7
        //   871: invokevirtual 183	java/io/ByteArrayOutputStream:toByteArray	()[B
        //   874: astore 7
        //   876: aload 7
        //   878: iconst_4
        //   879: baload
        //   880: istore_2
        //   881: aload 7
        //   883: iconst_5
        //   884: baload
        //   885: istore_3
        //   886: aload 7
        //   888: bipush 6
        //   890: baload
        //   891: istore 4
        //   893: aload 7
        //   895: bipush 7
        //   897: baload
        //   898: istore 5
        //   900: aload 7
        //   902: astore 8
        //   904: aload 7
        //   906: astore 11
        //   908: aload 7
        //   910: astore 9
        //   912: ldc 127
        //   914: new 185	java/lang/StringBuilder
        //   917: dup
        //   918: invokespecial 186	java/lang/StringBuilder:<init>	()V
        //   921: ldc 188
        //   923: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   926: iload_2
        //   927: sipush 255
        //   930: iand
        //   931: bipush 24
        //   933: ishl
        //   934: iload_3
        //   935: sipush 255
        //   938: iand
        //   939: bipush 16
        //   941: ishl
        //   942: ior
        //   943: iload 4
        //   945: sipush 255
        //   948: iand
        //   949: bipush 8
        //   951: ishl
        //   952: ior
        //   953: iload 5
        //   955: sipush 255
        //   958: iand
        //   959: ior
        //   960: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   963: ldc 197
        //   965: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   968: aload 7
        //   970: bipush 8
        //   972: baload
        //   973: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   976: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   979: invokestatic 204	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   982: pop
        //   983: aload 10
        //   985: ifnull +8 -> 993
        //   988: aload 10
        //   990: invokevirtual 139	java/io/InputStream:close	()V
        //   993: aload 6
        //   995: ifnull +8 -> 1003
        //   998: aload 6
        //   1000: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
        //   1003: aload_0
        //   1004: getfield 35	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   1007: ifnull -338 -> 669
        //   1010: aload_0
        //   1011: getfield 35	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   1014: aload_0
        //   1015: getfield 27	com/tencent/av/HttpHelper/HttpHelper$2:val$url	Ljava/lang/String;
        //   1018: iload_1
        //   1019: aload 7
        //   1021: aload_0
        //   1022: getfield 37	com/tencent/av/HttpHelper/HttpHelper$2:val$param	Ljava/lang/Object;
        //   1025: invokeinterface 148 5 0
        //   1030: return
        //   1031: aload 13
        //   1033: astore 8
        //   1035: aload 14
        //   1037: astore 11
        //   1039: aload 15
        //   1041: astore 9
        //   1043: aload 7
        //   1045: aload 12
        //   1047: iconst_0
        //   1048: iload_2
        //   1049: invokevirtual 207	java/io/ByteArrayOutputStream:write	([BII)V
        //   1052: goto -219 -> 833
        //   1055: astore 13
        //   1057: aload 10
        //   1059: astore 12
        //   1061: aload 8
        //   1063: astore 10
        //   1065: goto -469 -> 596
        //   1068: aload 6
        //   1070: astore 11
        //   1072: iload_1
        //   1073: istore_3
        //   1074: aload 6
        //   1076: astore 12
        //   1078: iload_1
        //   1079: istore 4
        //   1081: aload 6
        //   1083: astore 7
        //   1085: iload_1
        //   1086: istore_2
        //   1087: aload 21
        //   1089: astore 8
        //   1091: aload 22
        //   1093: astore 9
        //   1095: ldc 127
        //   1097: new 185	java/lang/StringBuilder
        //   1100: dup
        //   1101: invokespecial 186	java/lang/StringBuilder:<init>	()V
        //   1104: ldc 209
        //   1106: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1109: iload_1
        //   1110: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   1113: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1116: invokestatic 204	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   1119: pop
        //   1120: aload 20
        //   1122: astore 7
        //   1124: goto -141 -> 983
        //   1127: astore 13
        //   1129: aload 19
        //   1131: astore 10
        //   1133: aload 17
        //   1135: astore 11
        //   1137: iload 4
        //   1139: istore_1
        //   1140: aload 12
        //   1142: astore 6
        //   1144: aload 6
        //   1146: astore 7
        //   1148: iload_1
        //   1149: istore_2
        //   1150: aload 11
        //   1152: astore 8
        //   1154: aload 10
        //   1156: astore 9
        //   1158: ldc 127
        //   1160: ldc 129
        //   1162: aload 13
        //   1164: invokestatic 135	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   1167: pop
        //   1168: aload 11
        //   1170: ifnull +8 -> 1178
        //   1173: aload 11
        //   1175: invokevirtual 139	java/io/InputStream:close	()V
        //   1178: aload 6
        //   1180: ifnull +8 -> 1188
        //   1183: aload 6
        //   1185: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
        //   1188: aload_0
        //   1189: getfield 35	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   1192: ifnull -523 -> 669
        //   1195: aload_0
        //   1196: getfield 35	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   1199: aload_0
        //   1200: getfield 27	com/tencent/av/HttpHelper/HttpHelper$2:val$url	Ljava/lang/String;
        //   1203: iconst_m1
        //   1204: aload 10
        //   1206: aload_0
        //   1207: getfield 37	com/tencent/av/HttpHelper/HttpHelper$2:val$param	Ljava/lang/Object;
        //   1210: invokeinterface 148 5 0
        //   1215: return
        //   1216: astore 8
        //   1218: aload 8
        //   1220: invokevirtual 212	java/io/IOException:printStackTrace	()V
        //   1223: goto -230 -> 993
        //   1226: astore 7
        //   1228: aload 7
        //   1230: invokevirtual 212	java/io/IOException:printStackTrace	()V
        //   1233: goto -603 -> 630
        //   1236: astore 7
        //   1238: aload 7
        //   1240: invokevirtual 212	java/io/IOException:printStackTrace	()V
        //   1243: goto -65 -> 1178
        //   1246: astore 10
        //   1248: iload_2
        //   1249: istore_1
        //   1250: aload 7
        //   1252: astore 6
        //   1254: aload 8
        //   1256: ifnull +8 -> 1264
        //   1259: aload 8
        //   1261: invokevirtual 139	java/io/InputStream:close	()V
        //   1264: aload 6
        //   1266: ifnull +8 -> 1274
        //   1269: aload 6
        //   1271: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
        //   1274: aload_0
        //   1275: getfield 35	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   1278: ifnull +23 -> 1301
        //   1281: aload_0
        //   1282: getfield 35	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
        //   1285: aload_0
        //   1286: getfield 27	com/tencent/av/HttpHelper/HttpHelper$2:val$url	Ljava/lang/String;
        //   1289: iload_1
        //   1290: aload 9
        //   1292: aload_0
        //   1293: getfield 37	com/tencent/av/HttpHelper/HttpHelper$2:val$param	Ljava/lang/Object;
        //   1296: invokeinterface 148 5 0
        //   1301: aload 10
        //   1303: athrow
        //   1304: astore 7
        //   1306: aload 7
        //   1308: invokevirtual 212	java/io/IOException:printStackTrace	()V
        //   1311: goto -47 -> 1264
        //   1314: astore 7
        //   1316: aload 10
        //   1318: astore 8
        //   1320: aload 11
        //   1322: astore 9
        //   1324: aload 7
        //   1326: astore 10
        //   1328: goto -74 -> 1254
        //   1331: astore 13
        //   1333: aload 10
        //   1335: astore 11
        //   1337: aload 9
        //   1339: astore 10
        //   1341: goto -197 -> 1144
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1344	0	this	2
        //   24	1266	1	i	int
        //   52	1197	2	j	int
        //   47	1027	3	k	int
        //   49	1089	4	m	int
        //   898	61	5	n	int
        //   81	1189	6	localObject1	Object
        //   4	1143	7	localObject2	Object
        //   1226	3	7	localIOException1	java.io.IOException
        //   1236	15	7	localIOException2	java.io.IOException
        //   1304	3	7	localIOException3	java.io.IOException
        //   1314	11	7	localObject3	Object
        //   55	1098	8	localObject4	Object
        //   1216	44	8	localIOException4	java.io.IOException
        //   1318	1	8	localObject5	Object
        //   59	1279	9	localObject6	Object
        //   10	1195	10	localObject7	Object
        //   1246	71	10	localObject8	Object
        //   1326	14	10	localObject9	Object
        //   7	1329	11	localObject10	Object
        //   1	1140	12	localObject11	Object
        //   29	1	13	localObject12	Object
        //   580	452	13	localUnknownHostException1	java.net.UnknownHostException
        //   1055	1	13	localUnknownHostException2	java.net.UnknownHostException
        //   1127	36	13	localIOException5	java.io.IOException
        //   1331	1	13	localIOException6	java.io.IOException
        //   38	998	14	localObject13	Object
        //   41	999	15	localObject14	Object
        //   19	568	16	localObject15	Object
        //   13	1121	17	localObject16	Object
        //   44	539	18	localObject17	Object
        //   32	1098	19	localObject18	Object
        //   26	1095	20	localObject19	Object
        //   16	1072	21	localObject20	Object
        //   35	1057	22	localObject21	Object
        //   447	67	23	localIterator	java.util.Iterator
        //   523	42	24	localEntry	java.util.Map.Entry
        // Exception table:
        //   from	to	target	type
        //   61	83	580	java/net/UnknownHostException
        //   110	117	580	java/net/UnknownHostException
        //   144	153	580	java/net/UnknownHostException
        //   180	189	580	java/net/UnknownHostException
        //   216	222	580	java/net/UnknownHostException
        //   249	255	580	java/net/UnknownHostException
        //   282	291	580	java/net/UnknownHostException
        //   318	333	580	java/net/UnknownHostException
        //   360	367	580	java/net/UnknownHostException
        //   394	406	580	java/net/UnknownHostException
        //   433	449	580	java/net/UnknownHostException
        //   476	486	580	java/net/UnknownHostException
        //   513	525	580	java/net/UnknownHostException
        //   552	577	580	java/net/UnknownHostException
        //   697	709	580	java/net/UnknownHostException
        //   736	742	580	java/net/UnknownHostException
        //   776	790	580	java/net/UnknownHostException
        //   1095	1120	580	java/net/UnknownHostException
        //   802	814	1055	java/net/UnknownHostException
        //   826	833	1055	java/net/UnknownHostException
        //   845	853	1055	java/net/UnknownHostException
        //   869	876	1055	java/net/UnknownHostException
        //   912	983	1055	java/net/UnknownHostException
        //   1043	1052	1055	java/net/UnknownHostException
        //   61	83	1127	java/io/IOException
        //   110	117	1127	java/io/IOException
        //   144	153	1127	java/io/IOException
        //   180	189	1127	java/io/IOException
        //   216	222	1127	java/io/IOException
        //   249	255	1127	java/io/IOException
        //   282	291	1127	java/io/IOException
        //   318	333	1127	java/io/IOException
        //   360	367	1127	java/io/IOException
        //   394	406	1127	java/io/IOException
        //   433	449	1127	java/io/IOException
        //   476	486	1127	java/io/IOException
        //   513	525	1127	java/io/IOException
        //   552	577	1127	java/io/IOException
        //   697	709	1127	java/io/IOException
        //   736	742	1127	java/io/IOException
        //   776	790	1127	java/io/IOException
        //   1095	1120	1127	java/io/IOException
        //   988	993	1216	java/io/IOException
        //   625	630	1226	java/io/IOException
        //   1173	1178	1236	java/io/IOException
        //   61	83	1246	finally
        //   110	117	1246	finally
        //   144	153	1246	finally
        //   180	189	1246	finally
        //   216	222	1246	finally
        //   249	255	1246	finally
        //   282	291	1246	finally
        //   318	333	1246	finally
        //   360	367	1246	finally
        //   394	406	1246	finally
        //   433	449	1246	finally
        //   476	486	1246	finally
        //   513	525	1246	finally
        //   552	577	1246	finally
        //   610	620	1246	finally
        //   697	709	1246	finally
        //   736	742	1246	finally
        //   776	790	1246	finally
        //   1095	1120	1246	finally
        //   1158	1168	1246	finally
        //   1259	1264	1304	java/io/IOException
        //   802	814	1314	finally
        //   826	833	1314	finally
        //   845	853	1314	finally
        //   869	876	1314	finally
        //   912	983	1314	finally
        //   1043	1052	1314	finally
        //   802	814	1331	java/io/IOException
        //   826	833	1331	java/io/IOException
        //   845	853	1331	java/io/IOException
        //   869	876	1331	java/io/IOException
        //   912	983	1331	java/io/IOException
        //   1043	1052	1331	java/io/IOException
      }
    }).start();
    return true;
  }
  
  public static boolean httpPostRequest(String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap, Object paramObject, HttpRequestListener paramHttpRequestListener)
  {
    return httpPostRequest(paramString, paramArrayOfByte, paramMap, paramObject, 5000, paramHttpRequestListener);
  }
  
  public static abstract interface HttpRequestListener
  {
    public abstract void onCompleted(String paramString, int paramInt, byte[] paramArrayOfByte, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.HttpHelper.HttpHelper
 * JD-Core Version:    0.7.0.1
 */