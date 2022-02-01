package com.tencent.map.sdk.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public final class qc
  extends qa
{
  private HttpURLConnection b;
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private static void a(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      if (paramOutputStream == null) {
        return;
      }
      try
      {
        paramOutputStream.write(paramArrayOfByte);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  /* Error */
  private static byte[] a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 38	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 39	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: astore_2
    //   16: sipush 4096
    //   19: newarray byte
    //   21: astore 4
    //   23: aload_3
    //   24: astore_2
    //   25: aload_0
    //   26: aload 4
    //   28: iconst_0
    //   29: sipush 4096
    //   32: invokevirtual 45	java/io/InputStream:read	([BII)I
    //   35: istore_1
    //   36: iload_1
    //   37: iconst_m1
    //   38: if_icmpeq +16 -> 54
    //   41: aload_3
    //   42: astore_2
    //   43: aload_3
    //   44: aload 4
    //   46: iconst_0
    //   47: iload_1
    //   48: invokevirtual 48	java/io/ByteArrayOutputStream:write	([BII)V
    //   51: goto -28 -> 23
    //   54: aload_3
    //   55: astore_2
    //   56: aload_3
    //   57: invokevirtual 51	java/io/ByteArrayOutputStream:flush	()V
    //   60: aload_3
    //   61: astore_2
    //   62: aload_3
    //   63: invokevirtual 55	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   66: astore_0
    //   67: aload_3
    //   68: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   71: aload_0
    //   72: areturn
    //   73: astore_2
    //   74: aload_3
    //   75: astore_0
    //   76: aload_2
    //   77: astore_3
    //   78: goto +12 -> 90
    //   81: astore_0
    //   82: aconst_null
    //   83: astore_2
    //   84: goto +19 -> 103
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_0
    //   91: astore_2
    //   92: aload_3
    //   93: invokevirtual 58	java/lang/Throwable:printStackTrace	()V
    //   96: aload_0
    //   97: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: aload_2
    //   104: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   107: goto +5 -> 112
    //   110: aload_0
    //   111: athrow
    //   112: goto -2 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramInputStream	java.io.InputStream
    //   35	13	1	i	int
    //   15	47	2	localObject1	java.lang.Object
    //   73	4	2	localThrowable1	java.lang.Throwable
    //   83	21	2	localInputStream	java.io.InputStream
    //   13	65	3	localObject2	java.lang.Object
    //   87	6	3	localThrowable2	java.lang.Throwable
    //   21	24	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	23	73	java/lang/Throwable
    //   25	36	73	java/lang/Throwable
    //   43	51	73	java/lang/Throwable
    //   56	60	73	java/lang/Throwable
    //   62	67	73	java/lang/Throwable
    //   6	14	81	finally
    //   6	14	87	java/lang/Throwable
    //   16	23	102	finally
    //   25	36	102	finally
    //   43	51	102	finally
    //   56	60	102	finally
    //   62	67	102	finally
    //   92	96	102	finally
  }
  
  /* Error */
  protected final com.tencent.map.tools.net.NetResponse a(java.lang.String paramString1, java.lang.String paramString2, int paramInt1, int paramInt2, java.util.HashMap<java.lang.String, java.lang.String> paramHashMap, com.tencent.map.tools.net.http.HttpCanceler paramHttpCanceler)
  {
    // Byte code:
    //   0: new 65	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 68	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore 11
    //   10: aconst_null
    //   11: astore_1
    //   12: goto +16 -> 28
    //   15: astore_1
    //   16: new 70	com/tencent/map/tools/net/NetResponse
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 73	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   24: astore_1
    //   25: aconst_null
    //   26: astore 11
    //   28: new 75	com/tencent/map/sdk/a/qc$a
    //   31: dup
    //   32: aload_0
    //   33: iload_3
    //   34: invokespecial 78	com/tencent/map/sdk/a/qc$a:<init>	(Lcom/tencent/map/sdk/a/qc;I)V
    //   37: astore 12
    //   39: aload 12
    //   41: invokevirtual 81	com/tencent/map/sdk/a/qc$a:a	()Z
    //   44: ifeq +518 -> 562
    //   47: aload 11
    //   49: ifnull +488 -> 537
    //   52: iconst_0
    //   53: istore_3
    //   54: aload 11
    //   56: invokevirtual 85	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   59: checkcast 87	java/net/HttpURLConnection
    //   62: astore 8
    //   64: aload 8
    //   66: astore 9
    //   68: aload 8
    //   70: ldc 89
    //   72: invokevirtual 92	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   75: iload 4
    //   77: ifle +14 -> 91
    //   80: aload 8
    //   82: astore 9
    //   84: aload 8
    //   86: iload 4
    //   88: invokevirtual 96	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   91: aload 5
    //   93: ifnull +133 -> 226
    //   96: aload 8
    //   98: astore 9
    //   100: aload 5
    //   102: invokevirtual 101	java/util/HashMap:isEmpty	()Z
    //   105: ifne +121 -> 226
    //   108: aload 8
    //   110: astore 9
    //   112: aload 5
    //   114: invokevirtual 105	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   117: invokeinterface 111 1 0
    //   122: astore 10
    //   124: aload 8
    //   126: astore 9
    //   128: aload 10
    //   130: invokeinterface 116 1 0
    //   135: ifeq +91 -> 226
    //   138: aload 8
    //   140: astore 9
    //   142: aload 10
    //   144: invokeinterface 120 1 0
    //   149: checkcast 122	java/util/Map$Entry
    //   152: astore 14
    //   154: aload 8
    //   156: astore 9
    //   158: aload 14
    //   160: invokeinterface 125 1 0
    //   165: checkcast 127	java/lang/String
    //   168: astore 13
    //   170: aload 8
    //   172: astore 9
    //   174: aload 14
    //   176: invokeinterface 130 1 0
    //   181: checkcast 127	java/lang/String
    //   184: astore 14
    //   186: aload 8
    //   188: astore 9
    //   190: aload 13
    //   192: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   195: ifne -71 -> 124
    //   198: aload 8
    //   200: astore 9
    //   202: aload 14
    //   204: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifne -83 -> 124
    //   210: aload 8
    //   212: astore 9
    //   214: aload 8
    //   216: aload 13
    //   218: aload 14
    //   220: invokevirtual 139	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: goto -99 -> 124
    //   226: aload 8
    //   228: astore 9
    //   230: aload_2
    //   231: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   234: ifne +15 -> 249
    //   237: aload 8
    //   239: astore 9
    //   241: aload 8
    //   243: ldc 141
    //   245: aload_2
    //   246: invokevirtual 139	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload 6
    //   251: ifnull +33 -> 284
    //   254: aload 8
    //   256: astore 9
    //   258: aload 6
    //   260: aload_0
    //   261: new 143	com/tencent/map/sdk/a/qc$1
    //   264: dup
    //   265: aload_0
    //   266: aload 12
    //   268: invokespecial 146	com/tencent/map/sdk/a/qc$1:<init>	(Lcom/tencent/map/sdk/a/qc;Lcom/tencent/map/sdk/a/qc$a;)V
    //   271: invokevirtual 152	com/tencent/map/tools/net/http/HttpCanceler:setHttpAccessRequest	(Lcom/tencent/map/tools/net/NetAdapter;Lcom/tencent/map/sdk/a/ft;)V
    //   274: aload 8
    //   276: astore 9
    //   278: aload_0
    //   279: aload 8
    //   281: putfield 15	com/tencent/map/sdk/a/qc:b	Ljava/net/HttpURLConnection;
    //   284: aload 8
    //   286: astore 9
    //   288: aload 8
    //   290: invokevirtual 155	java/net/HttpURLConnection:connect	()V
    //   293: aload 8
    //   295: astore 9
    //   297: aload 8
    //   299: invokevirtual 159	java/net/HttpURLConnection:getResponseCode	()I
    //   302: istore 7
    //   304: aload 8
    //   306: astore 9
    //   308: new 70	com/tencent/map/tools/net/NetResponse
    //   311: dup
    //   312: invokespecial 160	com/tencent/map/tools/net/NetResponse:<init>	()V
    //   315: astore 10
    //   317: aload 8
    //   319: astore 9
    //   321: aload 10
    //   323: iload 7
    //   325: putfield 164	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   328: aload 8
    //   330: astore 9
    //   332: aload 10
    //   334: aload 8
    //   336: invokevirtual 168	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   339: invokestatic 171	com/tencent/map/sdk/a/qc:a	(Ljava/lang/String;)Ljava/lang/String;
    //   342: putfield 175	com/tencent/map/tools/net/NetResponse:charset	Ljava/lang/String;
    //   345: iload 7
    //   347: sipush 200
    //   350: if_icmpne +43 -> 393
    //   353: aload 8
    //   355: astore 9
    //   357: aload 10
    //   359: iconst_0
    //   360: putfield 178	com/tencent/map/tools/net/NetResponse:errorCode	I
    //   363: aload 8
    //   365: astore 9
    //   367: aload 10
    //   369: aload 8
    //   371: invokevirtual 182	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   374: invokestatic 184	com/tencent/map/sdk/a/qc:a	(Ljava/io/InputStream;)[B
    //   377: putfield 188	com/tencent/map/tools/net/NetResponse:data	[B
    //   380: aload 8
    //   382: astore 9
    //   384: aload 12
    //   386: iconst_0
    //   387: putfield 191	com/tencent/map/sdk/a/qc$a:a	Z
    //   390: goto +29 -> 419
    //   393: aload 8
    //   395: astore 9
    //   397: aload 10
    //   399: aload 8
    //   401: invokevirtual 194	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   404: invokestatic 184	com/tencent/map/sdk/a/qc:a	(Ljava/io/InputStream;)[B
    //   407: putfield 197	com/tencent/map/tools/net/NetResponse:errorData	[B
    //   410: aload 8
    //   412: astore 9
    //   414: aload 12
    //   416: invokevirtual 199	com/tencent/map/sdk/a/qc$a:b	()V
    //   419: aload 10
    //   421: astore 9
    //   423: goto +120 -> 543
    //   426: goto +75 -> 501
    //   429: astore_1
    //   430: iload 7
    //   432: istore_3
    //   433: goto +18 -> 451
    //   436: astore_1
    //   437: goto +14 -> 451
    //   440: astore_1
    //   441: aconst_null
    //   442: astore 9
    //   444: goto +81 -> 525
    //   447: astore_1
    //   448: aconst_null
    //   449: astore 8
    //   451: aload 8
    //   453: astore 9
    //   455: new 70	com/tencent/map/tools/net/NetResponse
    //   458: dup
    //   459: aload_1
    //   460: invokespecial 73	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   463: astore_1
    //   464: aload 8
    //   466: astore 9
    //   468: aload_1
    //   469: iload_3
    //   470: putfield 164	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   473: aload 8
    //   475: astore 9
    //   477: aload 12
    //   479: invokevirtual 199	com/tencent/map/sdk/a/qc$a:b	()V
    //   482: aload 8
    //   484: ifnull +8 -> 492
    //   487: aload 8
    //   489: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   492: goto -453 -> 39
    //   495: aconst_null
    //   496: astore 8
    //   498: aload_1
    //   499: astore 10
    //   501: aload 8
    //   503: astore 9
    //   505: aload 12
    //   507: invokevirtual 199	com/tencent/map/sdk/a/qc$a:b	()V
    //   510: aload 10
    //   512: astore_1
    //   513: aload 8
    //   515: ifnull -476 -> 39
    //   518: aload 10
    //   520: astore_1
    //   521: goto +33 -> 554
    //   524: astore_1
    //   525: aload 9
    //   527: ifnull +8 -> 535
    //   530: aload 9
    //   532: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   535: aload_1
    //   536: athrow
    //   537: aconst_null
    //   538: astore 8
    //   540: aload_1
    //   541: astore 9
    //   543: aload 9
    //   545: astore_1
    //   546: aload 8
    //   548: ifnull -509 -> 39
    //   551: aload 9
    //   553: astore_1
    //   554: aload 8
    //   556: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   559: goto -520 -> 39
    //   562: aload_1
    //   563: areturn
    //   564: astore 8
    //   566: goto -71 -> 495
    //   569: astore 9
    //   571: aload_1
    //   572: astore 10
    //   574: goto -73 -> 501
    //   577: astore_1
    //   578: goto -152 -> 426
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	this	qc
    //   0	581	1	paramString1	java.lang.String
    //   0	581	2	paramString2	java.lang.String
    //   0	581	3	paramInt1	int
    //   0	581	4	paramInt2	int
    //   0	581	5	paramHashMap	java.util.HashMap<java.lang.String, java.lang.String>
    //   0	581	6	paramHttpCanceler	com.tencent.map.tools.net.http.HttpCanceler
    //   302	129	7	i	int
    //   62	493	8	localHttpURLConnection	HttpURLConnection
    //   564	1	8	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   66	486	9	localObject1	java.lang.Object
    //   569	1	9	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   122	451	10	localObject2	java.lang.Object
    //   8	47	11	localURL	java.net.URL
    //   37	469	12	locala	qc.a
    //   168	49	13	str	java.lang.String
    //   152	67	14	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   0	10	15	java/net/MalformedURLException
    //   308	317	429	java/io/IOException
    //   321	328	429	java/io/IOException
    //   332	345	429	java/io/IOException
    //   357	363	429	java/io/IOException
    //   367	380	429	java/io/IOException
    //   384	390	429	java/io/IOException
    //   397	410	429	java/io/IOException
    //   414	419	429	java/io/IOException
    //   68	75	436	java/io/IOException
    //   84	91	436	java/io/IOException
    //   100	108	436	java/io/IOException
    //   112	124	436	java/io/IOException
    //   128	138	436	java/io/IOException
    //   142	154	436	java/io/IOException
    //   158	170	436	java/io/IOException
    //   174	186	436	java/io/IOException
    //   190	198	436	java/io/IOException
    //   202	210	436	java/io/IOException
    //   214	223	436	java/io/IOException
    //   230	237	436	java/io/IOException
    //   241	249	436	java/io/IOException
    //   258	274	436	java/io/IOException
    //   278	284	436	java/io/IOException
    //   288	293	436	java/io/IOException
    //   297	304	436	java/io/IOException
    //   54	64	440	finally
    //   54	64	447	java/io/IOException
    //   68	75	524	finally
    //   84	91	524	finally
    //   100	108	524	finally
    //   112	124	524	finally
    //   128	138	524	finally
    //   142	154	524	finally
    //   158	170	524	finally
    //   174	186	524	finally
    //   190	198	524	finally
    //   202	210	524	finally
    //   214	223	524	finally
    //   230	237	524	finally
    //   241	249	524	finally
    //   258	274	524	finally
    //   278	284	524	finally
    //   288	293	524	finally
    //   297	304	524	finally
    //   308	317	524	finally
    //   321	328	524	finally
    //   332	345	524	finally
    //   357	363	524	finally
    //   367	380	524	finally
    //   384	390	524	finally
    //   397	410	524	finally
    //   414	419	524	finally
    //   455	464	524	finally
    //   468	473	524	finally
    //   477	482	524	finally
    //   505	510	524	finally
    //   54	64	564	java/net/SocketTimeoutException
    //   68	75	569	java/net/SocketTimeoutException
    //   84	91	569	java/net/SocketTimeoutException
    //   100	108	569	java/net/SocketTimeoutException
    //   112	124	569	java/net/SocketTimeoutException
    //   128	138	569	java/net/SocketTimeoutException
    //   142	154	569	java/net/SocketTimeoutException
    //   158	170	569	java/net/SocketTimeoutException
    //   174	186	569	java/net/SocketTimeoutException
    //   190	198	569	java/net/SocketTimeoutException
    //   202	210	569	java/net/SocketTimeoutException
    //   214	223	569	java/net/SocketTimeoutException
    //   230	237	569	java/net/SocketTimeoutException
    //   241	249	569	java/net/SocketTimeoutException
    //   258	274	569	java/net/SocketTimeoutException
    //   278	284	569	java/net/SocketTimeoutException
    //   288	293	569	java/net/SocketTimeoutException
    //   297	304	569	java/net/SocketTimeoutException
    //   308	317	569	java/net/SocketTimeoutException
    //   321	328	577	java/net/SocketTimeoutException
    //   332	345	577	java/net/SocketTimeoutException
    //   357	363	577	java/net/SocketTimeoutException
    //   367	380	577	java/net/SocketTimeoutException
    //   384	390	577	java/net/SocketTimeoutException
    //   397	410	577	java/net/SocketTimeoutException
    //   414	419	577	java/net/SocketTimeoutException
  }
  
  /* Error */
  protected final com.tencent.map.tools.net.NetResponse a(java.lang.String paramString1, java.lang.String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 5
    //   15: aconst_null
    //   16: astore 12
    //   18: aconst_null
    //   19: astore 10
    //   21: new 65	java/net/URL
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 68	java/net/URL:<init>	(Ljava/lang/String;)V
    //   29: astore_1
    //   30: aconst_null
    //   31: astore 6
    //   33: goto +16 -> 49
    //   36: astore_1
    //   37: new 70	com/tencent/map/tools/net/NetResponse
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 73	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   45: astore 6
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +378 -> 428
    //   53: aload_1
    //   54: invokevirtual 85	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   57: checkcast 87	java/net/HttpURLConnection
    //   60: astore 5
    //   62: aload 10
    //   64: astore 7
    //   66: aload 11
    //   68: astore 9
    //   70: aload 12
    //   72: astore 8
    //   74: aload 5
    //   76: ldc 207
    //   78: invokevirtual 92	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   81: aload 10
    //   83: astore 7
    //   85: aload 11
    //   87: astore 9
    //   89: aload 12
    //   91: astore 8
    //   93: aload 5
    //   95: iconst_1
    //   96: invokevirtual 211	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   99: aload 10
    //   101: astore 7
    //   103: aload 11
    //   105: astore 9
    //   107: aload 12
    //   109: astore 8
    //   111: aload_2
    //   112: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifne +23 -> 138
    //   118: aload 10
    //   120: astore 7
    //   122: aload 11
    //   124: astore 9
    //   126: aload 12
    //   128: astore 8
    //   130: aload 5
    //   132: ldc 141
    //   134: aload_2
    //   135: invokevirtual 139	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 10
    //   140: astore 7
    //   142: aload 11
    //   144: astore 9
    //   146: aload 12
    //   148: astore 8
    //   150: aload 5
    //   152: invokevirtual 215	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   155: astore_1
    //   156: aload_1
    //   157: astore 7
    //   159: aload_1
    //   160: astore 9
    //   162: aload_1
    //   163: astore 8
    //   165: aload_3
    //   166: aload_1
    //   167: invokestatic 217	com/tencent/map/sdk/a/qc:a	([BLjava/io/OutputStream;)V
    //   170: aload_1
    //   171: astore 7
    //   173: aload_1
    //   174: astore 9
    //   176: aload_1
    //   177: astore 8
    //   179: aload 5
    //   181: invokevirtual 155	java/net/HttpURLConnection:connect	()V
    //   184: aload_1
    //   185: astore 7
    //   187: aload_1
    //   188: astore 9
    //   190: aload_1
    //   191: astore 8
    //   193: aload 5
    //   195: invokevirtual 159	java/net/HttpURLConnection:getResponseCode	()I
    //   198: istore 4
    //   200: aload_1
    //   201: astore 7
    //   203: aload_1
    //   204: astore 8
    //   206: new 70	com/tencent/map/tools/net/NetResponse
    //   209: dup
    //   210: invokespecial 160	com/tencent/map/tools/net/NetResponse:<init>	()V
    //   213: astore_2
    //   214: aload_1
    //   215: astore 7
    //   217: aload_2
    //   218: iload 4
    //   220: putfield 164	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   223: aload_1
    //   224: astore 7
    //   226: aload_2
    //   227: aload 5
    //   229: invokevirtual 168	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   232: invokestatic 171	com/tencent/map/sdk/a/qc:a	(Ljava/lang/String;)Ljava/lang/String;
    //   235: putfield 175	com/tencent/map/tools/net/NetResponse:charset	Ljava/lang/String;
    //   238: iload 4
    //   240: sipush 200
    //   243: if_icmpne +29 -> 272
    //   246: aload_1
    //   247: astore 7
    //   249: aload_2
    //   250: iconst_0
    //   251: putfield 178	com/tencent/map/tools/net/NetResponse:errorCode	I
    //   254: aload_1
    //   255: astore 7
    //   257: aload_2
    //   258: aload 5
    //   260: invokevirtual 182	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   263: invokestatic 184	com/tencent/map/sdk/a/qc:a	(Ljava/io/InputStream;)[B
    //   266: putfield 188	com/tencent/map/tools/net/NetResponse:data	[B
    //   269: goto +18 -> 287
    //   272: aload_1
    //   273: astore 7
    //   275: aload_2
    //   276: aload 5
    //   278: invokevirtual 194	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   281: invokestatic 184	com/tencent/map/sdk/a/qc:a	(Ljava/io/InputStream;)[B
    //   284: putfield 197	com/tencent/map/tools/net/NetResponse:errorData	[B
    //   287: aload_2
    //   288: astore_3
    //   289: aload 5
    //   291: astore_2
    //   292: goto +144 -> 436
    //   295: goto +117 -> 412
    //   298: astore_3
    //   299: aload 5
    //   301: astore_2
    //   302: goto +46 -> 348
    //   305: aload 8
    //   307: astore_1
    //   308: aload 6
    //   310: astore_2
    //   311: goto +101 -> 412
    //   314: astore_1
    //   315: goto +71 -> 386
    //   318: astore_3
    //   319: aload 9
    //   321: astore_1
    //   322: aload 5
    //   324: astore_2
    //   325: goto +20 -> 345
    //   328: astore_1
    //   329: aconst_null
    //   330: astore 5
    //   332: aload 9
    //   334: astore 7
    //   336: goto +50 -> 386
    //   339: astore_3
    //   340: aconst_null
    //   341: astore_1
    //   342: aload 7
    //   344: astore_2
    //   345: iconst_0
    //   346: istore 4
    //   348: new 70	com/tencent/map/tools/net/NetResponse
    //   351: dup
    //   352: aload_3
    //   353: invokespecial 73	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   356: astore_3
    //   357: aload_3
    //   358: iload 4
    //   360: putfield 164	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   363: aload_2
    //   364: ifnull +7 -> 371
    //   367: aload_2
    //   368: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   371: aload_1
    //   372: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   375: aload_3
    //   376: areturn
    //   377: astore_3
    //   378: aload_1
    //   379: astore 7
    //   381: aload_3
    //   382: astore_1
    //   383: aload_2
    //   384: astore 5
    //   386: aload 5
    //   388: ifnull +8 -> 396
    //   391: aload 5
    //   393: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   396: aload 7
    //   398: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   401: aload_1
    //   402: athrow
    //   403: aconst_null
    //   404: astore 5
    //   406: aload 6
    //   408: astore_2
    //   409: aload 8
    //   411: astore_1
    //   412: aload 5
    //   414: ifnull +8 -> 422
    //   417: aload 5
    //   419: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   422: aload_1
    //   423: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   426: aload_2
    //   427: areturn
    //   428: aload 6
    //   430: astore_3
    //   431: aconst_null
    //   432: astore_1
    //   433: aload 5
    //   435: astore_2
    //   436: aload_2
    //   437: ifnull +7 -> 444
    //   440: aload_2
    //   441: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   444: aload_1
    //   445: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   448: aload_3
    //   449: areturn
    //   450: astore_1
    //   451: goto -48 -> 403
    //   454: astore_1
    //   455: goto -150 -> 305
    //   458: astore_3
    //   459: goto -164 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	qc
    //   0	462	1	paramString1	java.lang.String
    //   0	462	2	paramString2	java.lang.String
    //   0	462	3	paramArrayOfByte	byte[]
    //   198	161	4	i	int
    //   13	421	5	localObject1	java.lang.Object
    //   31	398	6	localNetResponse	com.tencent.map.tools.net.NetResponse
    //   4	393	7	localObject2	java.lang.Object
    //   10	400	8	localObject3	java.lang.Object
    //   7	326	9	localObject4	java.lang.Object
    //   19	120	10	localObject5	java.lang.Object
    //   1	142	11	localObject6	java.lang.Object
    //   16	131	12	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   21	30	36	java/net/MalformedURLException
    //   206	214	298	java/io/IOException
    //   217	223	298	java/io/IOException
    //   226	238	298	java/io/IOException
    //   249	254	298	java/io/IOException
    //   257	269	298	java/io/IOException
    //   275	287	298	java/io/IOException
    //   74	81	314	finally
    //   93	99	314	finally
    //   111	118	314	finally
    //   130	138	314	finally
    //   150	156	314	finally
    //   165	170	314	finally
    //   179	184	314	finally
    //   193	200	314	finally
    //   206	214	314	finally
    //   217	223	314	finally
    //   226	238	314	finally
    //   249	254	314	finally
    //   257	269	314	finally
    //   275	287	314	finally
    //   74	81	318	java/io/IOException
    //   93	99	318	java/io/IOException
    //   111	118	318	java/io/IOException
    //   130	138	318	java/io/IOException
    //   150	156	318	java/io/IOException
    //   165	170	318	java/io/IOException
    //   179	184	318	java/io/IOException
    //   193	200	318	java/io/IOException
    //   53	62	328	finally
    //   53	62	339	java/io/IOException
    //   348	363	377	finally
    //   53	62	450	java/net/SocketTimeoutException
    //   74	81	454	java/net/SocketTimeoutException
    //   93	99	454	java/net/SocketTimeoutException
    //   111	118	454	java/net/SocketTimeoutException
    //   130	138	454	java/net/SocketTimeoutException
    //   150	156	454	java/net/SocketTimeoutException
    //   165	170	454	java/net/SocketTimeoutException
    //   179	184	454	java/net/SocketTimeoutException
    //   193	200	454	java/net/SocketTimeoutException
    //   206	214	454	java/net/SocketTimeoutException
    //   217	223	458	java/net/SocketTimeoutException
    //   226	238	458	java/net/SocketTimeoutException
    //   249	254	458	java/net/SocketTimeoutException
    //   257	269	458	java/net/SocketTimeoutException
    //   275	287	458	java/net/SocketTimeoutException
  }
  
  /* Error */
  protected final com.tencent.map.tools.net.NetResponse a(java.lang.String paramString1, java.lang.String paramString2, byte[] paramArrayOfByte, int paramInt1, java.util.HashMap<java.lang.String, java.lang.String> paramHashMap, com.tencent.map.tools.net.http.HttpCanceler paramHttpCanceler, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 15
    //   3: new 65	java/net/URL
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 68	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: astore 14
    //   13: aconst_null
    //   14: astore 9
    //   16: goto +17 -> 33
    //   19: astore_1
    //   20: new 70	com/tencent/map/tools/net/NetResponse
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 73	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   28: astore 9
    //   30: aconst_null
    //   31: astore 14
    //   33: new 75	com/tencent/map/sdk/a/qc$a
    //   36: dup
    //   37: aload_0
    //   38: iload 4
    //   40: invokespecial 78	com/tencent/map/sdk/a/qc$a:<init>	(Lcom/tencent/map/sdk/a/qc;I)V
    //   43: astore 16
    //   45: aload 16
    //   47: invokevirtual 81	com/tencent/map/sdk/a/qc$a:a	()Z
    //   50: ifeq +602 -> 652
    //   53: aload 14
    //   55: ifnull +555 -> 610
    //   58: iconst_0
    //   59: istore 4
    //   61: aload 14
    //   63: invokevirtual 85	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   66: checkcast 87	java/net/HttpURLConnection
    //   69: astore_1
    //   70: aload_1
    //   71: ldc 207
    //   73: invokevirtual 92	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: iconst_1
    //   78: invokevirtual 211	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   81: iload 7
    //   83: ifle +9 -> 92
    //   86: aload_1
    //   87: iload 7
    //   89: invokevirtual 96	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   92: aload 5
    //   94: ifnull +96 -> 190
    //   97: aload 5
    //   99: invokevirtual 101	java/util/HashMap:isEmpty	()Z
    //   102: ifne +88 -> 190
    //   105: aload 5
    //   107: invokevirtual 105	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   110: invokeinterface 111 1 0
    //   115: astore 10
    //   117: aload 10
    //   119: invokeinterface 116 1 0
    //   124: ifeq +66 -> 190
    //   127: aload 10
    //   129: invokeinterface 120 1 0
    //   134: checkcast 122	java/util/Map$Entry
    //   137: astore 12
    //   139: aload 12
    //   141: invokeinterface 125 1 0
    //   146: checkcast 127	java/lang/String
    //   149: astore 11
    //   151: aload 12
    //   153: invokeinterface 130 1 0
    //   158: checkcast 127	java/lang/String
    //   161: astore 12
    //   163: aload 11
    //   165: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   168: ifne -51 -> 117
    //   171: aload 12
    //   173: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne -59 -> 117
    //   179: aload_1
    //   180: aload 11
    //   182: aload 12
    //   184: invokevirtual 139	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: goto -70 -> 117
    //   190: aload_2
    //   191: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: ifne +10 -> 204
    //   197: aload_1
    //   198: ldc 141
    //   200: aload_2
    //   201: invokevirtual 139	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload 6
    //   206: ifnull +24 -> 230
    //   209: aload 6
    //   211: aload_0
    //   212: new 220	com/tencent/map/sdk/a/qc$2
    //   215: dup
    //   216: aload_0
    //   217: aload 16
    //   219: invokespecial 221	com/tencent/map/sdk/a/qc$2:<init>	(Lcom/tencent/map/sdk/a/qc;Lcom/tencent/map/sdk/a/qc$a;)V
    //   222: invokevirtual 152	com/tencent/map/tools/net/http/HttpCanceler:setHttpAccessRequest	(Lcom/tencent/map/tools/net/NetAdapter;Lcom/tencent/map/sdk/a/ft;)V
    //   225: aload_0
    //   226: aload_1
    //   227: putfield 15	com/tencent/map/sdk/a/qc:b	Ljava/net/HttpURLConnection;
    //   230: aload_1
    //   231: invokevirtual 215	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   234: astore 10
    //   236: aload_1
    //   237: astore 11
    //   239: aload 10
    //   241: astore 12
    //   243: aload_3
    //   244: aload 10
    //   246: invokestatic 217	com/tencent/map/sdk/a/qc:a	([BLjava/io/OutputStream;)V
    //   249: aload_1
    //   250: astore 11
    //   252: aload 10
    //   254: astore 12
    //   256: aload_1
    //   257: invokevirtual 155	java/net/HttpURLConnection:connect	()V
    //   260: aload_1
    //   261: astore 11
    //   263: aload 10
    //   265: astore 12
    //   267: aload_1
    //   268: invokevirtual 159	java/net/HttpURLConnection:getResponseCode	()I
    //   271: istore 8
    //   273: aload_1
    //   274: astore 11
    //   276: aload 10
    //   278: astore 12
    //   280: new 70	com/tencent/map/tools/net/NetResponse
    //   283: dup
    //   284: invokespecial 160	com/tencent/map/tools/net/NetResponse:<init>	()V
    //   287: astore 13
    //   289: aload_1
    //   290: astore 11
    //   292: aload 10
    //   294: astore 12
    //   296: aload 13
    //   298: iload 8
    //   300: putfield 164	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   303: aload_1
    //   304: astore 11
    //   306: aload 10
    //   308: astore 12
    //   310: aload 13
    //   312: aload_1
    //   313: invokevirtual 168	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   316: invokestatic 171	com/tencent/map/sdk/a/qc:a	(Ljava/lang/String;)Ljava/lang/String;
    //   319: putfield 175	com/tencent/map/tools/net/NetResponse:charset	Ljava/lang/String;
    //   322: iload 8
    //   324: sipush 200
    //   327: if_icmpne +51 -> 378
    //   330: aload_1
    //   331: astore 11
    //   333: aload 10
    //   335: astore 12
    //   337: aload 13
    //   339: iconst_0
    //   340: putfield 178	com/tencent/map/tools/net/NetResponse:errorCode	I
    //   343: aload_1
    //   344: astore 11
    //   346: aload 10
    //   348: astore 12
    //   350: aload 13
    //   352: aload_1
    //   353: invokevirtual 182	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   356: invokestatic 184	com/tencent/map/sdk/a/qc:a	(Ljava/io/InputStream;)[B
    //   359: putfield 188	com/tencent/map/tools/net/NetResponse:data	[B
    //   362: aload_1
    //   363: astore 11
    //   365: aload 10
    //   367: astore 12
    //   369: aload 16
    //   371: iconst_0
    //   372: putfield 191	com/tencent/map/sdk/a/qc$a:a	Z
    //   375: goto +34 -> 409
    //   378: aload_1
    //   379: astore 11
    //   381: aload 10
    //   383: astore 12
    //   385: aload 13
    //   387: aload_1
    //   388: invokevirtual 194	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   391: invokestatic 184	com/tencent/map/sdk/a/qc:a	(Ljava/io/InputStream;)[B
    //   394: putfield 197	com/tencent/map/tools/net/NetResponse:errorData	[B
    //   397: aload_1
    //   398: astore 11
    //   400: aload 10
    //   402: astore 12
    //   404: aload 16
    //   406: invokevirtual 199	com/tencent/map/sdk/a/qc$a:b	()V
    //   409: aload 13
    //   411: astore 9
    //   413: aload_1
    //   414: astore 12
    //   416: aload 10
    //   418: astore_1
    //   419: goto +197 -> 616
    //   422: aload 13
    //   424: astore 9
    //   426: aload_1
    //   427: astore 13
    //   429: aload 10
    //   431: astore_1
    //   432: goto +126 -> 558
    //   435: astore 9
    //   437: iload 8
    //   439: istore 4
    //   441: goto +51 -> 492
    //   444: astore 9
    //   446: goto +46 -> 492
    //   449: astore_2
    //   450: aload 15
    //   452: astore_3
    //   453: goto +143 -> 596
    //   456: astore 9
    //   458: aconst_null
    //   459: astore 10
    //   461: goto +31 -> 492
    //   464: aconst_null
    //   465: astore 10
    //   467: aload_1
    //   468: astore 13
    //   470: aload 10
    //   472: astore_1
    //   473: goto +85 -> 558
    //   476: astore_2
    //   477: aconst_null
    //   478: astore_1
    //   479: aload 15
    //   481: astore_3
    //   482: goto +114 -> 596
    //   485: astore 9
    //   487: aconst_null
    //   488: astore_1
    //   489: aload_1
    //   490: astore 10
    //   492: aload_1
    //   493: astore 11
    //   495: aload 10
    //   497: astore 12
    //   499: new 70	com/tencent/map/tools/net/NetResponse
    //   502: dup
    //   503: aload 9
    //   505: invokespecial 73	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   508: astore 9
    //   510: aload_1
    //   511: astore 11
    //   513: aload 10
    //   515: astore 12
    //   517: aload 9
    //   519: iload 4
    //   521: putfield 164	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   524: aload_1
    //   525: astore 11
    //   527: aload 10
    //   529: astore 12
    //   531: aload 16
    //   533: invokevirtual 199	com/tencent/map/sdk/a/qc$a:b	()V
    //   536: aload_1
    //   537: ifnull +7 -> 544
    //   540: aload_1
    //   541: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   544: aload 10
    //   546: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   549: goto -504 -> 45
    //   552: aconst_null
    //   553: astore 13
    //   555: aload 13
    //   557: astore_1
    //   558: aload 13
    //   560: astore 11
    //   562: aload_1
    //   563: astore 12
    //   565: aload 16
    //   567: invokevirtual 199	com/tencent/map/sdk/a/qc$a:b	()V
    //   570: aload 9
    //   572: astore 10
    //   574: aload_1
    //   575: astore 11
    //   577: aload 13
    //   579: ifnull +61 -> 640
    //   582: aload 13
    //   584: astore 12
    //   586: goto +42 -> 628
    //   589: astore_2
    //   590: aload 12
    //   592: astore_3
    //   593: aload 11
    //   595: astore_1
    //   596: aload_1
    //   597: ifnull +7 -> 604
    //   600: aload_1
    //   601: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   604: aload_3
    //   605: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   608: aload_2
    //   609: athrow
    //   610: aconst_null
    //   611: astore 12
    //   613: aload 12
    //   615: astore_1
    //   616: aload 9
    //   618: astore 10
    //   620: aload_1
    //   621: astore 11
    //   623: aload 12
    //   625: ifnull +15 -> 640
    //   628: aload 12
    //   630: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   633: aload_1
    //   634: astore 11
    //   636: aload 9
    //   638: astore 10
    //   640: aload 11
    //   642: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   645: aload 10
    //   647: astore 9
    //   649: goto -604 -> 45
    //   652: aload 9
    //   654: areturn
    //   655: astore_1
    //   656: goto -104 -> 552
    //   659: astore 10
    //   661: goto -197 -> 464
    //   664: astore 11
    //   666: aload_1
    //   667: astore 13
    //   669: aload 10
    //   671: astore_1
    //   672: goto -114 -> 558
    //   675: astore 9
    //   677: goto -255 -> 422
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	680	0	this	qc
    //   0	680	1	paramString1	java.lang.String
    //   0	680	2	paramString2	java.lang.String
    //   0	680	3	paramArrayOfByte	byte[]
    //   0	680	4	paramInt1	int
    //   0	680	5	paramHashMap	java.util.HashMap<java.lang.String, java.lang.String>
    //   0	680	6	paramHttpCanceler	com.tencent.map.tools.net.http.HttpCanceler
    //   0	680	7	paramInt2	int
    //   271	167	8	i	int
    //   14	411	9	localObject1	java.lang.Object
    //   435	1	9	localIOException1	IOException
    //   444	1	9	localIOException2	IOException
    //   456	1	9	localIOException3	IOException
    //   485	19	9	localIOException4	IOException
    //   508	145	9	localObject2	java.lang.Object
    //   675	1	9	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   115	531	10	localObject3	java.lang.Object
    //   659	11	10	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   149	492	11	localObject4	java.lang.Object
    //   664	1	11	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   137	492	12	localObject5	java.lang.Object
    //   287	381	13	localObject6	java.lang.Object
    //   11	51	14	localURL	java.net.URL
    //   1	479	15	localObject7	java.lang.Object
    //   43	523	16	locala	qc.a
    // Exception table:
    //   from	to	target	type
    //   3	13	19	java/net/MalformedURLException
    //   280	289	435	java/io/IOException
    //   296	303	435	java/io/IOException
    //   310	322	435	java/io/IOException
    //   337	343	435	java/io/IOException
    //   350	362	435	java/io/IOException
    //   369	375	435	java/io/IOException
    //   385	397	435	java/io/IOException
    //   404	409	435	java/io/IOException
    //   243	249	444	java/io/IOException
    //   256	260	444	java/io/IOException
    //   267	273	444	java/io/IOException
    //   70	81	449	finally
    //   86	92	449	finally
    //   97	117	449	finally
    //   117	187	449	finally
    //   190	204	449	finally
    //   209	230	449	finally
    //   230	236	449	finally
    //   70	81	456	java/io/IOException
    //   86	92	456	java/io/IOException
    //   97	117	456	java/io/IOException
    //   117	187	456	java/io/IOException
    //   190	204	456	java/io/IOException
    //   209	230	456	java/io/IOException
    //   230	236	456	java/io/IOException
    //   61	70	476	finally
    //   61	70	485	java/io/IOException
    //   243	249	589	finally
    //   256	260	589	finally
    //   267	273	589	finally
    //   280	289	589	finally
    //   296	303	589	finally
    //   310	322	589	finally
    //   337	343	589	finally
    //   350	362	589	finally
    //   369	375	589	finally
    //   385	397	589	finally
    //   404	409	589	finally
    //   499	510	589	finally
    //   517	524	589	finally
    //   531	536	589	finally
    //   565	570	589	finally
    //   61	70	655	java/net/SocketTimeoutException
    //   70	81	659	java/net/SocketTimeoutException
    //   86	92	659	java/net/SocketTimeoutException
    //   97	117	659	java/net/SocketTimeoutException
    //   117	187	659	java/net/SocketTimeoutException
    //   190	204	659	java/net/SocketTimeoutException
    //   209	230	659	java/net/SocketTimeoutException
    //   230	236	659	java/net/SocketTimeoutException
    //   243	249	664	java/net/SocketTimeoutException
    //   256	260	664	java/net/SocketTimeoutException
    //   267	273	664	java/net/SocketTimeoutException
    //   280	289	664	java/net/SocketTimeoutException
    //   296	303	675	java/net/SocketTimeoutException
    //   310	322	675	java/net/SocketTimeoutException
    //   337	343	675	java/net/SocketTimeoutException
    //   350	362	675	java/net/SocketTimeoutException
    //   369	375	675	java/net/SocketTimeoutException
    //   385	397	675	java/net/SocketTimeoutException
    //   404	409	675	java/net/SocketTimeoutException
  }
  
  protected final void a(Context paramContext, Bundle paramBundle)
  {
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
      System.setProperty("http.keepAlive", "false");
    }
  }
  
  /* Error */
  protected final void a(java.lang.String paramString1, byte[] paramArrayOfByte, java.lang.String paramString2, java.lang.String paramString3, java.lang.String paramString4, java.lang.String paramString5, com.tencent.map.tools.net.http.HttpCanceler paramHttpCanceler)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 15
    //   12: aconst_null
    //   13: astore 13
    //   15: aconst_null
    //   16: astore 14
    //   18: aconst_null
    //   19: astore 12
    //   21: new 65	java/net/URL
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 68	java/net/URL:<init>	(Ljava/lang/String;)V
    //   29: astore_1
    //   30: goto +5 -> 35
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +503 -> 539
    //   39: aload_1
    //   40: invokevirtual 85	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   43: checkcast 87	java/net/HttpURLConnection
    //   46: astore_1
    //   47: aload 12
    //   49: astore 9
    //   51: aload 13
    //   53: astore 10
    //   55: aload 14
    //   57: astore 11
    //   59: aload_1
    //   60: ldc 207
    //   62: invokevirtual 92	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   65: aload 12
    //   67: astore 9
    //   69: aload 13
    //   71: astore 10
    //   73: aload 14
    //   75: astore 11
    //   77: aload_1
    //   78: iconst_1
    //   79: invokevirtual 211	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   82: aload 12
    //   84: astore 9
    //   86: aload 13
    //   88: astore 10
    //   90: aload 14
    //   92: astore 11
    //   94: aload_1
    //   95: ldc 141
    //   97: ldc 247
    //   99: invokevirtual 139	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload 12
    //   104: astore 9
    //   106: aload 13
    //   108: astore 10
    //   110: aload 14
    //   112: astore 11
    //   114: aload_1
    //   115: ldc 249
    //   117: aload_3
    //   118: invokevirtual 139	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload 12
    //   123: astore 9
    //   125: aload 13
    //   127: astore 10
    //   129: aload 14
    //   131: astore 11
    //   133: aload_1
    //   134: ldc 251
    //   136: aload 4
    //   138: invokevirtual 139	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 12
    //   143: astore 9
    //   145: aload 13
    //   147: astore 10
    //   149: aload 14
    //   151: astore 11
    //   153: aload_1
    //   154: ldc 253
    //   156: aload 5
    //   158: invokevirtual 139	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 12
    //   163: astore 9
    //   165: aload 13
    //   167: astore 10
    //   169: aload 14
    //   171: astore 11
    //   173: new 255	java/lang/StringBuilder
    //   176: dup
    //   177: ldc_w 257
    //   180: invokespecial 258	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: astore_3
    //   184: aload 12
    //   186: astore 9
    //   188: aload 13
    //   190: astore 10
    //   192: aload 14
    //   194: astore 11
    //   196: aload_3
    //   197: aload 6
    //   199: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 12
    //   205: astore 9
    //   207: aload 13
    //   209: astore 10
    //   211: aload 14
    //   213: astore 11
    //   215: aload_3
    //   216: ldc_w 264
    //   219: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 12
    //   225: astore 9
    //   227: aload 13
    //   229: astore 10
    //   231: aload 14
    //   233: astore 11
    //   235: aload_1
    //   236: ldc_w 266
    //   239: aload_3
    //   240: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokevirtual 139	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: aload 7
    //   248: ifnull +46 -> 294
    //   251: aload 12
    //   253: astore 9
    //   255: aload 13
    //   257: astore 10
    //   259: aload 14
    //   261: astore 11
    //   263: aload 7
    //   265: aload_0
    //   266: new 271	com/tencent/map/sdk/a/qc$3
    //   269: dup
    //   270: aload_0
    //   271: invokespecial 274	com/tencent/map/sdk/a/qc$3:<init>	(Lcom/tencent/map/sdk/a/qc;)V
    //   274: invokevirtual 152	com/tencent/map/tools/net/http/HttpCanceler:setHttpAccessRequest	(Lcom/tencent/map/tools/net/NetAdapter;Lcom/tencent/map/sdk/a/ft;)V
    //   277: aload 12
    //   279: astore 9
    //   281: aload 13
    //   283: astore 10
    //   285: aload 14
    //   287: astore 11
    //   289: aload_0
    //   290: aload_1
    //   291: putfield 15	com/tencent/map/sdk/a/qc:b	Ljava/net/HttpURLConnection;
    //   294: aload 12
    //   296: astore 9
    //   298: aload 13
    //   300: astore 10
    //   302: aload 14
    //   304: astore 11
    //   306: aload_1
    //   307: invokevirtual 215	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   310: astore_3
    //   311: aload_3
    //   312: astore 9
    //   314: aload_3
    //   315: astore 10
    //   317: aload_3
    //   318: astore 11
    //   320: aload_2
    //   321: aload_3
    //   322: invokestatic 217	com/tencent/map/sdk/a/qc:a	([BLjava/io/OutputStream;)V
    //   325: aload_3
    //   326: astore 9
    //   328: aload_3
    //   329: astore 10
    //   331: aload_3
    //   332: astore 11
    //   334: aload_1
    //   335: invokevirtual 155	java/net/HttpURLConnection:connect	()V
    //   338: aload_3
    //   339: astore 9
    //   341: aload_3
    //   342: astore 10
    //   344: aload_3
    //   345: astore 11
    //   347: aload_1
    //   348: invokevirtual 159	java/net/HttpURLConnection:getResponseCode	()I
    //   351: istore 8
    //   353: aload_3
    //   354: astore 9
    //   356: aload_3
    //   357: astore 10
    //   359: aload_3
    //   360: astore 11
    //   362: aload_1
    //   363: invokevirtual 168	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   366: invokestatic 171	com/tencent/map/sdk/a/qc:a	(Ljava/lang/String;)Ljava/lang/String;
    //   369: pop
    //   370: aload_3
    //   371: astore 4
    //   373: aload_1
    //   374: astore_2
    //   375: iload 8
    //   377: sipush 200
    //   380: if_icmpne +165 -> 545
    //   383: aload_3
    //   384: astore 9
    //   386: aload_3
    //   387: astore 10
    //   389: aload_3
    //   390: astore 11
    //   392: aload_1
    //   393: ldc_w 276
    //   396: invokevirtual 279	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   399: astore 5
    //   401: aload_3
    //   402: astore 9
    //   404: aload_3
    //   405: astore 10
    //   407: aload_3
    //   408: astore 11
    //   410: aload 5
    //   412: invokestatic 234	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   415: istore 8
    //   417: aload_3
    //   418: astore 4
    //   420: aload_1
    //   421: astore_2
    //   422: iload 8
    //   424: ifeq +121 -> 545
    //   427: iload 8
    //   429: bipush 254
    //   431: if_icmpne +20 -> 451
    //   434: aload_3
    //   435: astore 9
    //   437: aload_3
    //   438: astore 10
    //   440: aload_3
    //   441: astore 11
    //   443: new 281	com/tencent/map/sdk/a/qj
    //   446: dup
    //   447: invokespecial 282	com/tencent/map/sdk/a/qj:<init>	()V
    //   450: athrow
    //   451: aload_3
    //   452: astore 9
    //   454: aload_3
    //   455: astore 10
    //   457: aload_3
    //   458: astore 11
    //   460: new 284	java/lang/Exception
    //   463: dup
    //   464: ldc_w 286
    //   467: aload 5
    //   469: invokestatic 290	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   472: invokevirtual 293	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   475: invokespecial 294	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   478: athrow
    //   479: goto +30 -> 509
    //   482: goto +43 -> 525
    //   485: astore_2
    //   486: goto +6 -> 492
    //   489: astore_2
    //   490: aconst_null
    //   491: astore_1
    //   492: aload_1
    //   493: ifnull +7 -> 500
    //   496: aload_1
    //   497: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   500: aload 9
    //   502: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   505: aload_2
    //   506: athrow
    //   507: aconst_null
    //   508: astore_1
    //   509: aload_1
    //   510: ifnull +7 -> 517
    //   513: aload_1
    //   514: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   517: aload 11
    //   519: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   522: return
    //   523: aconst_null
    //   524: astore_1
    //   525: aload_1
    //   526: ifnull +7 -> 533
    //   529: aload_1
    //   530: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   533: aload 10
    //   535: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   538: return
    //   539: aconst_null
    //   540: astore_2
    //   541: aload 15
    //   543: astore 4
    //   545: aload_2
    //   546: ifnull +7 -> 553
    //   549: aload_2
    //   550: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   553: aload 4
    //   555: invokestatic 57	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   558: return
    //   559: astore_1
    //   560: goto -527 -> 33
    //   563: astore_1
    //   564: goto -41 -> 523
    //   567: astore_1
    //   568: goto -61 -> 507
    //   571: astore_2
    //   572: goto -90 -> 482
    //   575: astore_2
    //   576: goto -97 -> 479
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	qc
    //   0	579	1	paramString1	java.lang.String
    //   0	579	2	paramArrayOfByte	byte[]
    //   0	579	3	paramString2	java.lang.String
    //   0	579	4	paramString3	java.lang.String
    //   0	579	5	paramString4	java.lang.String
    //   0	579	6	paramString5	java.lang.String
    //   0	579	7	paramHttpCanceler	com.tencent.map.tools.net.http.HttpCanceler
    //   351	81	8	i	int
    //   1	500	9	localObject1	java.lang.Object
    //   7	527	10	localObject2	java.lang.Object
    //   4	514	11	localObject3	java.lang.Object
    //   19	276	12	localObject4	java.lang.Object
    //   13	286	13	localObject5	java.lang.Object
    //   16	287	14	localObject6	java.lang.Object
    //   10	532	15	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   59	65	485	finally
    //   77	82	485	finally
    //   94	102	485	finally
    //   114	121	485	finally
    //   133	141	485	finally
    //   153	161	485	finally
    //   173	184	485	finally
    //   196	203	485	finally
    //   215	223	485	finally
    //   235	246	485	finally
    //   263	277	485	finally
    //   289	294	485	finally
    //   306	311	485	finally
    //   320	325	485	finally
    //   334	338	485	finally
    //   347	353	485	finally
    //   362	370	485	finally
    //   392	401	485	finally
    //   410	417	485	finally
    //   443	451	485	finally
    //   460	479	485	finally
    //   39	47	489	finally
    //   21	30	559	java/net/MalformedURLException
    //   39	47	563	java/net/SocketTimeoutException
    //   39	47	567	java/io/IOException
    //   59	65	571	java/net/SocketTimeoutException
    //   77	82	571	java/net/SocketTimeoutException
    //   94	102	571	java/net/SocketTimeoutException
    //   114	121	571	java/net/SocketTimeoutException
    //   133	141	571	java/net/SocketTimeoutException
    //   153	161	571	java/net/SocketTimeoutException
    //   173	184	571	java/net/SocketTimeoutException
    //   196	203	571	java/net/SocketTimeoutException
    //   215	223	571	java/net/SocketTimeoutException
    //   235	246	571	java/net/SocketTimeoutException
    //   263	277	571	java/net/SocketTimeoutException
    //   289	294	571	java/net/SocketTimeoutException
    //   306	311	571	java/net/SocketTimeoutException
    //   320	325	571	java/net/SocketTimeoutException
    //   334	338	571	java/net/SocketTimeoutException
    //   347	353	571	java/net/SocketTimeoutException
    //   362	370	571	java/net/SocketTimeoutException
    //   392	401	571	java/net/SocketTimeoutException
    //   410	417	571	java/net/SocketTimeoutException
    //   443	451	571	java/net/SocketTimeoutException
    //   460	479	571	java/net/SocketTimeoutException
    //   59	65	575	java/io/IOException
    //   77	82	575	java/io/IOException
    //   94	102	575	java/io/IOException
    //   114	121	575	java/io/IOException
    //   133	141	575	java/io/IOException
    //   153	161	575	java/io/IOException
    //   173	184	575	java/io/IOException
    //   196	203	575	java/io/IOException
    //   215	223	575	java/io/IOException
    //   235	246	575	java/io/IOException
    //   263	277	575	java/io/IOException
    //   289	294	575	java/io/IOException
    //   306	311	575	java/io/IOException
    //   320	325	575	java/io/IOException
    //   334	338	575	java/io/IOException
    //   347	353	575	java/io/IOException
    //   362	370	575	java/io/IOException
    //   392	401	575	java/io/IOException
    //   410	417	575	java/io/IOException
    //   443	451	575	java/io/IOException
    //   460	479	575	java/io/IOException
  }
  
  public final boolean cancel()
  {
    HttpURLConnection localHttpURLConnection = this.b;
    if (localHttpURLConnection != null)
    {
      localHttpURLConnection.disconnect();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.qc
 * JD-Core Version:    0.7.0.1
 */