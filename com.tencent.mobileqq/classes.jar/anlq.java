import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class anlq
{
  public static SSLContext a()
  {
    try
    {
      localSSLContext = SSLContext.getInstance("TLS");
      QLog.d("ApolloHttpUtil", 1, "getSLLContext exception: " + localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localSSLContext.init(null, new TrustManager[] { new anlt() }, null);
        return localSSLContext;
      }
      catch (Throwable localThrowable2)
      {
        SSLContext localSSLContext;
        break label31;
      }
      localThrowable1 = localThrowable1;
      localSSLContext = null;
    }
    label31:
    return localSSLContext;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString, anln paramanln)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 10
    //   15: new 62	java/net/URL
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 65	java/net/URL:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 69	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   26: checkcast 71	java/net/HttpURLConnection
    //   29: astore_0
    //   30: aload_0
    //   31: ldc 73
    //   33: invokevirtual 76	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: instanceof 78
    //   40: ifeq +29 -> 69
    //   43: invokestatic 80	anlq:a	()Ljavax/net/ssl/SSLContext;
    //   46: astore 12
    //   48: aload 12
    //   50: ifnull +19 -> 69
    //   53: aload 12
    //   55: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   58: astore 12
    //   60: aload_0
    //   61: checkcast 78	javax/net/ssl/HttpsURLConnection
    //   64: aload 12
    //   66: invokevirtual 88	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   69: aload_0
    //   70: sipush 8000
    //   73: invokevirtual 92	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   76: aload_0
    //   77: sipush 8000
    //   80: invokevirtual 95	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   83: aload_0
    //   84: iconst_0
    //   85: invokevirtual 99	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   88: aload_0
    //   89: ldc 101
    //   91: aload_1
    //   92: invokevirtual 105	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: ldc 107
    //   98: aload_2
    //   99: invokevirtual 105	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_0
    //   103: ldc 109
    //   105: aload_3
    //   106: invokevirtual 105	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aconst_null
    //   110: astore_2
    //   111: iconst_0
    //   112: istore 6
    //   114: iload 6
    //   116: aload 4
    //   118: arraylength
    //   119: if_icmpge +87 -> 206
    //   122: iload 6
    //   124: iconst_2
    //   125: irem
    //   126: ifne +12 -> 138
    //   129: aload 4
    //   131: iload 6
    //   133: aaload
    //   134: astore_2
    //   135: goto +470 -> 605
    //   138: aload_0
    //   139: aload_2
    //   140: aload 4
    //   142: iload 6
    //   144: aaload
    //   145: invokevirtual 105	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto +457 -> 605
    //   151: astore_1
    //   152: aconst_null
    //   153: astore_1
    //   154: aconst_null
    //   155: astore 4
    //   157: aconst_null
    //   158: astore_2
    //   159: aload_0
    //   160: astore_3
    //   161: aload_1
    //   162: astore_0
    //   163: aload 4
    //   165: astore_1
    //   166: aload 5
    //   168: iconst_m1
    //   169: aconst_null
    //   170: invokevirtual 114	anln:a	(I[B)V
    //   173: aload_3
    //   174: ifnull +7 -> 181
    //   177: aload_3
    //   178: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   181: aload_1
    //   182: ifnull +7 -> 189
    //   185: aload_1
    //   186: invokevirtual 122	java/io/OutputStream:close	()V
    //   189: aload_2
    //   190: ifnull +7 -> 197
    //   193: aload_2
    //   194: invokevirtual 125	java/io/InputStream:close	()V
    //   197: aload_0
    //   198: ifnull +7 -> 205
    //   201: aload_0
    //   202: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   205: return
    //   206: aload_0
    //   207: invokevirtual 132	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   210: astore_2
    //   211: aload 11
    //   213: astore 4
    //   215: aload_2
    //   216: aload_1
    //   217: invokevirtual 138	java/lang/String:getBytes	()[B
    //   220: invokevirtual 142	java/io/OutputStream:write	([B)V
    //   223: aload 11
    //   225: astore 4
    //   227: aload_2
    //   228: invokevirtual 145	java/io/OutputStream:flush	()V
    //   231: aload 11
    //   233: astore 4
    //   235: aload_0
    //   236: invokevirtual 149	java/net/HttpURLConnection:getResponseCode	()I
    //   239: istore 6
    //   241: aload 11
    //   243: astore 4
    //   245: aload_0
    //   246: invokevirtual 153	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   249: astore_1
    //   250: aload_1
    //   251: astore 4
    //   253: new 127	java/io/ByteArrayOutputStream
    //   256: dup
    //   257: invokespecial 154	java/io/ByteArrayOutputStream:<init>	()V
    //   260: astore_3
    //   261: sipush 1024
    //   264: newarray byte
    //   266: astore 4
    //   268: aload_1
    //   269: aload 4
    //   271: invokevirtual 158	java/io/InputStream:read	([B)I
    //   274: istore 7
    //   276: iload 7
    //   278: iconst_m1
    //   279: if_icmpeq +15 -> 294
    //   282: aload_3
    //   283: aload 4
    //   285: iconst_0
    //   286: iload 7
    //   288: invokevirtual 161	java/io/ByteArrayOutputStream:write	([BII)V
    //   291: goto -23 -> 268
    //   294: aload 5
    //   296: iload 6
    //   298: aload_3
    //   299: invokevirtual 164	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   302: invokevirtual 114	anln:a	(I[B)V
    //   305: aload_0
    //   306: ifnull +7 -> 313
    //   309: aload_0
    //   310: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   313: aload_2
    //   314: ifnull +7 -> 321
    //   317: aload_2
    //   318: invokevirtual 122	java/io/OutputStream:close	()V
    //   321: aload_1
    //   322: ifnull +7 -> 329
    //   325: aload_1
    //   326: invokevirtual 125	java/io/InputStream:close	()V
    //   329: aload_3
    //   330: ifnull -125 -> 205
    //   333: aload_3
    //   334: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   337: return
    //   338: astore_0
    //   339: return
    //   340: astore_0
    //   341: ldc 35
    //   343: iconst_1
    //   344: aload_0
    //   345: iconst_0
    //   346: anewarray 4	java/lang/Object
    //   349: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   352: goto -31 -> 321
    //   355: astore_0
    //   356: ldc 35
    //   358: iconst_1
    //   359: aload_0
    //   360: iconst_0
    //   361: anewarray 4	java/lang/Object
    //   364: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   367: goto -38 -> 329
    //   370: astore_1
    //   371: ldc 35
    //   373: iconst_1
    //   374: aload_1
    //   375: iconst_0
    //   376: anewarray 4	java/lang/Object
    //   379: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   382: goto -193 -> 189
    //   385: astore_1
    //   386: ldc 35
    //   388: iconst_1
    //   389: aload_1
    //   390: iconst_0
    //   391: anewarray 4	java/lang/Object
    //   394: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   397: goto -200 -> 197
    //   400: astore_0
    //   401: aload 9
    //   403: astore_1
    //   404: aload 8
    //   406: astore 5
    //   408: aload 10
    //   410: astore_3
    //   411: aload 12
    //   413: astore_2
    //   414: aload_2
    //   415: ifnull +7 -> 422
    //   418: aload_2
    //   419: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   422: aload_3
    //   423: ifnull +7 -> 430
    //   426: aload_3
    //   427: invokevirtual 122	java/io/OutputStream:close	()V
    //   430: aload_1
    //   431: ifnull +7 -> 438
    //   434: aload_1
    //   435: invokevirtual 125	java/io/InputStream:close	()V
    //   438: aload 5
    //   440: ifnull +8 -> 448
    //   443: aload 5
    //   445: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   448: aload_0
    //   449: athrow
    //   450: astore_2
    //   451: ldc 35
    //   453: iconst_1
    //   454: aload_2
    //   455: iconst_0
    //   456: anewarray 4	java/lang/Object
    //   459: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   462: goto -32 -> 430
    //   465: astore_1
    //   466: ldc 35
    //   468: iconst_1
    //   469: aload_1
    //   470: iconst_0
    //   471: anewarray 4	java/lang/Object
    //   474: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   477: goto -39 -> 438
    //   480: astore_0
    //   481: return
    //   482: astore_1
    //   483: goto -35 -> 448
    //   486: astore_1
    //   487: aload_0
    //   488: astore_2
    //   489: aload_1
    //   490: astore_0
    //   491: aload 10
    //   493: astore_3
    //   494: aload 8
    //   496: astore 5
    //   498: aload 9
    //   500: astore_1
    //   501: goto -87 -> 414
    //   504: astore_1
    //   505: aload_2
    //   506: astore_3
    //   507: aload_0
    //   508: astore_2
    //   509: aload_1
    //   510: astore_0
    //   511: aload 8
    //   513: astore 5
    //   515: aload 4
    //   517: astore_1
    //   518: goto -104 -> 414
    //   521: astore 4
    //   523: aload_3
    //   524: astore 5
    //   526: aload_2
    //   527: astore_3
    //   528: aload_0
    //   529: astore_2
    //   530: aload 4
    //   532: astore_0
    //   533: goto -119 -> 414
    //   536: astore 5
    //   538: aload_2
    //   539: astore 4
    //   541: aload 5
    //   543: astore_2
    //   544: aload_0
    //   545: astore 5
    //   547: aload_2
    //   548: astore_0
    //   549: aload_3
    //   550: astore_2
    //   551: aload_1
    //   552: astore_3
    //   553: aload 4
    //   555: astore_1
    //   556: goto -142 -> 414
    //   559: astore_0
    //   560: aconst_null
    //   561: astore_1
    //   562: aconst_null
    //   563: astore_2
    //   564: aconst_null
    //   565: astore_3
    //   566: aconst_null
    //   567: astore_0
    //   568: goto -402 -> 166
    //   571: astore_1
    //   572: aconst_null
    //   573: astore 4
    //   575: aload_0
    //   576: astore_3
    //   577: aload_2
    //   578: astore_1
    //   579: aconst_null
    //   580: astore_0
    //   581: aload 4
    //   583: astore_2
    //   584: goto -418 -> 166
    //   587: astore_3
    //   588: aload_1
    //   589: astore_3
    //   590: aload_0
    //   591: astore 4
    //   593: aload_2
    //   594: astore_1
    //   595: aconst_null
    //   596: astore_0
    //   597: aload_3
    //   598: astore_2
    //   599: aload 4
    //   601: astore_3
    //   602: goto -436 -> 166
    //   605: iload 6
    //   607: iconst_1
    //   608: iadd
    //   609: istore 6
    //   611: goto -497 -> 114
    //   614: astore 4
    //   616: aload_0
    //   617: astore 4
    //   619: aload_3
    //   620: astore_0
    //   621: aload_1
    //   622: astore_3
    //   623: aload_2
    //   624: astore_1
    //   625: aload_3
    //   626: astore_2
    //   627: aload 4
    //   629: astore_3
    //   630: goto -464 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	633	0	paramString1	String
    //   0	633	1	paramString2	String
    //   0	633	2	paramString3	String
    //   0	633	3	paramString4	String
    //   0	633	4	paramArrayOfString	String[]
    //   0	633	5	paramanln	anln
    //   112	498	6	i	int
    //   274	13	7	j	int
    //   10	502	8	localObject1	Object
    //   7	492	9	localObject2	Object
    //   13	479	10	localObject3	Object
    //   4	238	11	localObject4	Object
    //   1	411	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   30	48	151	java/lang/Throwable
    //   53	69	151	java/lang/Throwable
    //   69	109	151	java/lang/Throwable
    //   114	122	151	java/lang/Throwable
    //   138	148	151	java/lang/Throwable
    //   206	211	151	java/lang/Throwable
    //   333	337	338	java/io/IOException
    //   317	321	340	java/io/IOException
    //   325	329	355	java/io/IOException
    //   185	189	370	java/io/IOException
    //   193	197	385	java/io/IOException
    //   15	30	400	finally
    //   426	430	450	java/io/IOException
    //   434	438	465	java/io/IOException
    //   201	205	480	java/io/IOException
    //   443	448	482	java/io/IOException
    //   30	48	486	finally
    //   53	69	486	finally
    //   69	109	486	finally
    //   114	122	486	finally
    //   138	148	486	finally
    //   206	211	486	finally
    //   215	223	504	finally
    //   227	231	504	finally
    //   235	241	504	finally
    //   245	250	504	finally
    //   253	261	504	finally
    //   261	268	521	finally
    //   268	276	521	finally
    //   282	291	521	finally
    //   294	305	521	finally
    //   166	173	536	finally
    //   15	30	559	java/lang/Throwable
    //   215	223	571	java/lang/Throwable
    //   227	231	571	java/lang/Throwable
    //   235	241	571	java/lang/Throwable
    //   245	250	571	java/lang/Throwable
    //   253	261	587	java/lang/Throwable
    //   261	268	614	java/lang/Throwable
    //   268	276	614	java/lang/Throwable
    //   282	291	614	java/lang/Throwable
    //   294	305	614	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, byte[] paramArrayOfByte, String[] paramArrayOfString, anln paramanln)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 9
    //   15: new 62	java/net/URL
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 65	java/net/URL:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 69	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   26: checkcast 71	java/net/HttpURLConnection
    //   29: astore_1
    //   30: aload_1
    //   31: aload_0
    //   32: invokevirtual 76	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   35: aload_1
    //   36: instanceof 78
    //   39: ifeq +24 -> 63
    //   42: invokestatic 80	anlq:a	()Ljavax/net/ssl/SSLContext;
    //   45: astore_0
    //   46: aload_0
    //   47: ifnull +16 -> 63
    //   50: aload_0
    //   51: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   54: astore_0
    //   55: aload_1
    //   56: checkcast 78	javax/net/ssl/HttpsURLConnection
    //   59: aload_0
    //   60: invokevirtual 88	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   63: aload_1
    //   64: sipush 8000
    //   67: invokevirtual 92	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   70: aload_1
    //   71: sipush 8000
    //   74: invokevirtual 95	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   77: aload_1
    //   78: iconst_0
    //   79: invokevirtual 99	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   82: aconst_null
    //   83: astore_0
    //   84: iconst_0
    //   85: istore 5
    //   87: iload 5
    //   89: aload_3
    //   90: arraylength
    //   91: if_icmpge +83 -> 174
    //   94: iload 5
    //   96: iconst_2
    //   97: irem
    //   98: ifne +11 -> 109
    //   101: aload_3
    //   102: iload 5
    //   104: aaload
    //   105: astore_0
    //   106: goto +487 -> 593
    //   109: aload_1
    //   110: aload_0
    //   111: aload_3
    //   112: iload 5
    //   114: aaload
    //   115: invokevirtual 105	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: goto +475 -> 593
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_0
    //   124: aconst_null
    //   125: astore 7
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_1
    //   130: astore_3
    //   131: aload 7
    //   133: astore_1
    //   134: aload 4
    //   136: iconst_m1
    //   137: aconst_null
    //   138: invokevirtual 114	anln:a	(I[B)V
    //   141: aload_3
    //   142: ifnull +7 -> 149
    //   145: aload_3
    //   146: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 122	java/io/OutputStream:close	()V
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 125	java/io/InputStream:close	()V
    //   165: aload_0
    //   166: ifnull +7 -> 173
    //   169: aload_0
    //   170: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   173: return
    //   174: aload_1
    //   175: invokevirtual 132	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   178: astore_0
    //   179: aload 10
    //   181: astore 7
    //   183: aload_0
    //   184: aload_2
    //   185: invokevirtual 142	java/io/OutputStream:write	([B)V
    //   188: aload 10
    //   190: astore 7
    //   192: aload_0
    //   193: invokevirtual 145	java/io/OutputStream:flush	()V
    //   196: aload 10
    //   198: astore 7
    //   200: aload_1
    //   201: invokevirtual 149	java/net/HttpURLConnection:getResponseCode	()I
    //   204: istore 5
    //   206: aload 10
    //   208: astore 7
    //   210: aload_1
    //   211: invokevirtual 153	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   214: astore_2
    //   215: aload_2
    //   216: astore 7
    //   218: new 127	java/io/ByteArrayOutputStream
    //   221: dup
    //   222: invokespecial 154	java/io/ByteArrayOutputStream:<init>	()V
    //   225: astore_3
    //   226: sipush 1024
    //   229: newarray byte
    //   231: astore 7
    //   233: aload_2
    //   234: aload 7
    //   236: invokevirtual 158	java/io/InputStream:read	([B)I
    //   239: istore 6
    //   241: iload 6
    //   243: iconst_m1
    //   244: if_icmpeq +15 -> 259
    //   247: aload_3
    //   248: aload 7
    //   250: iconst_0
    //   251: iload 6
    //   253: invokevirtual 161	java/io/ByteArrayOutputStream:write	([BII)V
    //   256: goto -23 -> 233
    //   259: aload 4
    //   261: iload 5
    //   263: aload_3
    //   264: invokevirtual 164	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   267: invokevirtual 114	anln:a	(I[B)V
    //   270: aload_1
    //   271: ifnull +7 -> 278
    //   274: aload_1
    //   275: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   278: aload_0
    //   279: ifnull +7 -> 286
    //   282: aload_0
    //   283: invokevirtual 122	java/io/OutputStream:close	()V
    //   286: aload_2
    //   287: ifnull +7 -> 294
    //   290: aload_2
    //   291: invokevirtual 125	java/io/InputStream:close	()V
    //   294: aload_3
    //   295: ifnull -122 -> 173
    //   298: aload_3
    //   299: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   302: return
    //   303: astore_0
    //   304: ldc 35
    //   306: iconst_1
    //   307: aload_0
    //   308: iconst_0
    //   309: anewarray 4	java/lang/Object
    //   312: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   315: return
    //   316: astore_0
    //   317: ldc 35
    //   319: iconst_1
    //   320: aload_0
    //   321: iconst_0
    //   322: anewarray 4	java/lang/Object
    //   325: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   328: goto -42 -> 286
    //   331: astore_0
    //   332: ldc 35
    //   334: iconst_1
    //   335: aload_0
    //   336: iconst_0
    //   337: anewarray 4	java/lang/Object
    //   340: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   343: goto -49 -> 294
    //   346: astore_1
    //   347: ldc 35
    //   349: iconst_1
    //   350: aload_1
    //   351: iconst_0
    //   352: anewarray 4	java/lang/Object
    //   355: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   358: goto -201 -> 157
    //   361: astore_1
    //   362: ldc 35
    //   364: iconst_1
    //   365: aload_1
    //   366: iconst_0
    //   367: anewarray 4	java/lang/Object
    //   370: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   373: goto -208 -> 165
    //   376: astore_0
    //   377: ldc 35
    //   379: iconst_1
    //   380: aload_0
    //   381: iconst_0
    //   382: anewarray 4	java/lang/Object
    //   385: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   388: return
    //   389: astore_0
    //   390: aload 7
    //   392: astore_2
    //   393: aload 8
    //   395: astore 4
    //   397: aload 9
    //   399: astore_3
    //   400: aload 11
    //   402: astore_1
    //   403: aload_1
    //   404: ifnull +7 -> 411
    //   407: aload_1
    //   408: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   411: aload_3
    //   412: ifnull +7 -> 419
    //   415: aload_3
    //   416: invokevirtual 122	java/io/OutputStream:close	()V
    //   419: aload_2
    //   420: ifnull +7 -> 427
    //   423: aload_2
    //   424: invokevirtual 125	java/io/InputStream:close	()V
    //   427: aload 4
    //   429: ifnull +8 -> 437
    //   432: aload 4
    //   434: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   437: aload_0
    //   438: athrow
    //   439: astore_1
    //   440: ldc 35
    //   442: iconst_1
    //   443: aload_1
    //   444: iconst_0
    //   445: anewarray 4	java/lang/Object
    //   448: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   451: goto -32 -> 419
    //   454: astore_1
    //   455: ldc 35
    //   457: iconst_1
    //   458: aload_1
    //   459: iconst_0
    //   460: anewarray 4	java/lang/Object
    //   463: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   466: goto -39 -> 427
    //   469: astore_1
    //   470: ldc 35
    //   472: iconst_1
    //   473: aload_1
    //   474: iconst_0
    //   475: anewarray 4	java/lang/Object
    //   478: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   481: goto -44 -> 437
    //   484: astore_0
    //   485: aload 9
    //   487: astore_3
    //   488: aload 8
    //   490: astore 4
    //   492: aload 7
    //   494: astore_2
    //   495: goto -92 -> 403
    //   498: astore_2
    //   499: aload_0
    //   500: astore_3
    //   501: aload_2
    //   502: astore_0
    //   503: aload 8
    //   505: astore 4
    //   507: aload 7
    //   509: astore_2
    //   510: goto -107 -> 403
    //   513: astore 7
    //   515: aload_3
    //   516: astore 4
    //   518: aload_0
    //   519: astore_3
    //   520: aload 7
    //   522: astore_0
    //   523: goto -120 -> 403
    //   526: astore 7
    //   528: aload_1
    //   529: astore 4
    //   531: aload 7
    //   533: astore_1
    //   534: aload_0
    //   535: astore 7
    //   537: aload_1
    //   538: astore_0
    //   539: aload_3
    //   540: astore_1
    //   541: aload 4
    //   543: astore_3
    //   544: aload 7
    //   546: astore 4
    //   548: goto -145 -> 403
    //   551: astore_0
    //   552: aconst_null
    //   553: astore_1
    //   554: aconst_null
    //   555: astore_2
    //   556: aconst_null
    //   557: astore_3
    //   558: aconst_null
    //   559: astore_0
    //   560: goto -426 -> 134
    //   563: astore_2
    //   564: aconst_null
    //   565: astore_2
    //   566: aload_1
    //   567: astore_3
    //   568: aconst_null
    //   569: astore 7
    //   571: aload_0
    //   572: astore_1
    //   573: aload 7
    //   575: astore_0
    //   576: goto -442 -> 134
    //   579: astore_3
    //   580: aload_1
    //   581: astore_3
    //   582: aconst_null
    //   583: astore 7
    //   585: aload_0
    //   586: astore_1
    //   587: aload 7
    //   589: astore_0
    //   590: goto -456 -> 134
    //   593: iload 5
    //   595: iconst_1
    //   596: iadd
    //   597: istore 5
    //   599: goto -512 -> 87
    //   602: astore 7
    //   604: aload_1
    //   605: astore 7
    //   607: aload_0
    //   608: astore_1
    //   609: aload_3
    //   610: astore_0
    //   611: aload 7
    //   613: astore_3
    //   614: goto -480 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	paramString1	String
    //   0	617	1	paramString2	String
    //   0	617	2	paramArrayOfByte	byte[]
    //   0	617	3	paramArrayOfString	String[]
    //   0	617	4	paramanln	anln
    //   85	513	5	i	int
    //   239	13	6	j	int
    //   7	501	7	localObject1	Object
    //   513	8	7	localObject2	Object
    //   526	6	7	localObject3	Object
    //   535	53	7	str1	String
    //   602	1	7	localThrowable	Throwable
    //   605	7	7	str2	String
    //   10	494	8	localObject4	Object
    //   13	473	9	localObject5	Object
    //   4	203	10	localObject6	Object
    //   1	400	11	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   30	46	121	java/lang/Throwable
    //   50	63	121	java/lang/Throwable
    //   63	82	121	java/lang/Throwable
    //   87	94	121	java/lang/Throwable
    //   109	118	121	java/lang/Throwable
    //   174	179	121	java/lang/Throwable
    //   298	302	303	java/io/IOException
    //   282	286	316	java/io/IOException
    //   290	294	331	java/io/IOException
    //   153	157	346	java/io/IOException
    //   161	165	361	java/io/IOException
    //   169	173	376	java/io/IOException
    //   15	30	389	finally
    //   415	419	439	java/io/IOException
    //   423	427	454	java/io/IOException
    //   432	437	469	java/io/IOException
    //   30	46	484	finally
    //   50	63	484	finally
    //   63	82	484	finally
    //   87	94	484	finally
    //   109	118	484	finally
    //   174	179	484	finally
    //   183	188	498	finally
    //   192	196	498	finally
    //   200	206	498	finally
    //   210	215	498	finally
    //   218	226	498	finally
    //   226	233	513	finally
    //   233	241	513	finally
    //   247	256	513	finally
    //   259	270	513	finally
    //   134	141	526	finally
    //   15	30	551	java/lang/Throwable
    //   183	188	563	java/lang/Throwable
    //   192	196	563	java/lang/Throwable
    //   200	206	563	java/lang/Throwable
    //   210	215	563	java/lang/Throwable
    //   218	226	579	java/lang/Throwable
    //   226	233	602	java/lang/Throwable
    //   233	241	602	java/lang/Throwable
    //   247	256	602	java/lang/Throwable
    //   259	270	602	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String[] paramArrayOfString, anln paramanln)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: new 62	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 65	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 69	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 71	java/net/HttpURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: ldc 73
    //   24: invokevirtual 76	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   27: aload_0
    //   28: instanceof 78
    //   31: ifeq +29 -> 60
    //   34: invokestatic 80	anlq:a	()Ljavax/net/ssl/SSLContext;
    //   37: astore 6
    //   39: aload 6
    //   41: ifnull +19 -> 60
    //   44: aload 6
    //   46: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   49: astore 6
    //   51: aload_0
    //   52: checkcast 78	javax/net/ssl/HttpsURLConnection
    //   55: aload 6
    //   57: invokevirtual 88	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   60: aload_0
    //   61: sipush 8000
    //   64: invokevirtual 92	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   67: aload_0
    //   68: sipush 8000
    //   71: invokevirtual 95	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   74: aload_0
    //   75: iconst_0
    //   76: invokevirtual 99	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   79: iconst_0
    //   80: istore 4
    //   82: aconst_null
    //   83: astore 6
    //   85: iload 4
    //   87: aload_2
    //   88: arraylength
    //   89: if_icmpge +88 -> 177
    //   92: iload 4
    //   94: iconst_2
    //   95: irem
    //   96: ifne +12 -> 108
    //   99: aload_2
    //   100: iload 4
    //   102: aaload
    //   103: astore 6
    //   105: goto +505 -> 610
    //   108: aload_0
    //   109: aload 6
    //   111: aload_2
    //   112: iload 4
    //   114: aaload
    //   115: invokevirtual 105	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: goto +492 -> 610
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_1
    //   124: aconst_null
    //   125: astore 7
    //   127: aload_0
    //   128: astore_2
    //   129: aload 8
    //   131: astore 6
    //   133: aload 7
    //   135: astore_0
    //   136: aload_3
    //   137: iconst_m1
    //   138: aconst_null
    //   139: invokevirtual 114	anln:a	(I[B)V
    //   142: aload_2
    //   143: ifnull +7 -> 150
    //   146: aload_2
    //   147: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   150: aload_0
    //   151: ifnull +7 -> 158
    //   154: aload_0
    //   155: invokevirtual 122	java/io/OutputStream:close	()V
    //   158: aload_1
    //   159: ifnull +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 125	java/io/InputStream:close	()V
    //   166: aload 6
    //   168: ifnull +8 -> 176
    //   171: aload 6
    //   173: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   176: return
    //   177: aload_0
    //   178: invokevirtual 132	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   181: astore_2
    //   182: aload_2
    //   183: aload_1
    //   184: invokevirtual 138	java/lang/String:getBytes	()[B
    //   187: invokevirtual 142	java/io/OutputStream:write	([B)V
    //   190: aload_2
    //   191: invokevirtual 145	java/io/OutputStream:flush	()V
    //   194: aload_0
    //   195: invokevirtual 149	java/net/HttpURLConnection:getResponseCode	()I
    //   198: istore 4
    //   200: aload_0
    //   201: invokevirtual 153	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   204: astore 6
    //   206: new 127	java/io/ByteArrayOutputStream
    //   209: dup
    //   210: invokespecial 154	java/io/ByteArrayOutputStream:<init>	()V
    //   213: astore 7
    //   215: sipush 1024
    //   218: newarray byte
    //   220: astore_1
    //   221: aload 6
    //   223: aload_1
    //   224: invokevirtual 158	java/io/InputStream:read	([B)I
    //   227: istore 5
    //   229: iload 5
    //   231: iconst_m1
    //   232: if_icmpeq +15 -> 247
    //   235: aload 7
    //   237: aload_1
    //   238: iconst_0
    //   239: iload 5
    //   241: invokevirtual 161	java/io/ByteArrayOutputStream:write	([BII)V
    //   244: goto -23 -> 221
    //   247: aload_3
    //   248: iload 4
    //   250: aload 7
    //   252: invokevirtual 164	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   255: invokevirtual 114	anln:a	(I[B)V
    //   258: aload_0
    //   259: ifnull +7 -> 266
    //   262: aload_0
    //   263: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   266: aload_2
    //   267: ifnull +7 -> 274
    //   270: aload_2
    //   271: invokevirtual 122	java/io/OutputStream:close	()V
    //   274: aload 6
    //   276: ifnull +8 -> 284
    //   279: aload 6
    //   281: invokevirtual 125	java/io/InputStream:close	()V
    //   284: aload 7
    //   286: ifnull -110 -> 176
    //   289: aload 7
    //   291: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   294: return
    //   295: astore_0
    //   296: ldc 35
    //   298: iconst_1
    //   299: aload_0
    //   300: iconst_0
    //   301: anewarray 4	java/lang/Object
    //   304: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   307: return
    //   308: astore_0
    //   309: ldc 35
    //   311: iconst_1
    //   312: aload_0
    //   313: iconst_0
    //   314: anewarray 4	java/lang/Object
    //   317: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   320: goto -46 -> 274
    //   323: astore_0
    //   324: ldc 35
    //   326: iconst_1
    //   327: aload_0
    //   328: iconst_0
    //   329: anewarray 4	java/lang/Object
    //   332: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   335: goto -51 -> 284
    //   338: astore_0
    //   339: ldc 35
    //   341: iconst_1
    //   342: aload_0
    //   343: iconst_0
    //   344: anewarray 4	java/lang/Object
    //   347: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   350: goto -192 -> 158
    //   353: astore_0
    //   354: ldc 35
    //   356: iconst_1
    //   357: aload_0
    //   358: iconst_0
    //   359: anewarray 4	java/lang/Object
    //   362: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   365: goto -199 -> 166
    //   368: astore_0
    //   369: ldc 35
    //   371: iconst_1
    //   372: aload_0
    //   373: iconst_0
    //   374: anewarray 4	java/lang/Object
    //   377: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   380: return
    //   381: astore_0
    //   382: aconst_null
    //   383: astore_2
    //   384: aconst_null
    //   385: astore 6
    //   387: aconst_null
    //   388: astore_1
    //   389: aload 7
    //   391: astore_3
    //   392: aload_1
    //   393: ifnull +7 -> 400
    //   396: aload_1
    //   397: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   400: aload_3
    //   401: ifnull +7 -> 408
    //   404: aload_3
    //   405: invokevirtual 122	java/io/OutputStream:close	()V
    //   408: aload 6
    //   410: ifnull +8 -> 418
    //   413: aload 6
    //   415: invokevirtual 125	java/io/InputStream:close	()V
    //   418: aload_2
    //   419: ifnull +7 -> 426
    //   422: aload_2
    //   423: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   426: aload_0
    //   427: athrow
    //   428: astore_1
    //   429: ldc 35
    //   431: iconst_1
    //   432: aload_1
    //   433: iconst_0
    //   434: anewarray 4	java/lang/Object
    //   437: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   440: goto -32 -> 408
    //   443: astore_1
    //   444: ldc 35
    //   446: iconst_1
    //   447: aload_1
    //   448: iconst_0
    //   449: anewarray 4	java/lang/Object
    //   452: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   455: goto -37 -> 418
    //   458: astore_1
    //   459: ldc 35
    //   461: iconst_1
    //   462: aload_1
    //   463: iconst_0
    //   464: anewarray 4	java/lang/Object
    //   467: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   470: goto -44 -> 426
    //   473: astore_3
    //   474: aconst_null
    //   475: astore_2
    //   476: aconst_null
    //   477: astore 6
    //   479: aload_0
    //   480: astore_1
    //   481: aload_3
    //   482: astore_0
    //   483: aload 7
    //   485: astore_3
    //   486: goto -94 -> 392
    //   489: astore_3
    //   490: aconst_null
    //   491: astore 6
    //   493: aload_0
    //   494: astore_1
    //   495: aload_3
    //   496: astore_0
    //   497: aconst_null
    //   498: astore 7
    //   500: aload_2
    //   501: astore_3
    //   502: aload 7
    //   504: astore_2
    //   505: goto -113 -> 392
    //   508: astore_3
    //   509: aconst_null
    //   510: astore 7
    //   512: aload_0
    //   513: astore_1
    //   514: aload_3
    //   515: astore_0
    //   516: aload_2
    //   517: astore_3
    //   518: aload 7
    //   520: astore_2
    //   521: goto -129 -> 392
    //   524: astore_3
    //   525: aload_0
    //   526: astore_1
    //   527: aload_3
    //   528: astore_0
    //   529: aload_2
    //   530: astore_3
    //   531: aload 7
    //   533: astore_2
    //   534: goto -142 -> 392
    //   537: astore 8
    //   539: aload_1
    //   540: astore 7
    //   542: aload_2
    //   543: astore_1
    //   544: aload 6
    //   546: astore_2
    //   547: aload_0
    //   548: astore_3
    //   549: aload 8
    //   551: astore_0
    //   552: aload 7
    //   554: astore 6
    //   556: goto -164 -> 392
    //   559: astore_0
    //   560: aconst_null
    //   561: astore_0
    //   562: aconst_null
    //   563: astore_1
    //   564: aconst_null
    //   565: astore_2
    //   566: aload 8
    //   568: astore 6
    //   570: goto -434 -> 136
    //   573: astore_1
    //   574: aload_0
    //   575: astore 7
    //   577: aload_2
    //   578: astore_0
    //   579: aconst_null
    //   580: astore_1
    //   581: aload 8
    //   583: astore 6
    //   585: aload 7
    //   587: astore_2
    //   588: goto -452 -> 136
    //   591: astore_1
    //   592: aload_0
    //   593: astore 7
    //   595: aload_2
    //   596: astore_0
    //   597: aload 6
    //   599: astore_1
    //   600: aload 8
    //   602: astore 6
    //   604: aload 7
    //   606: astore_2
    //   607: goto -471 -> 136
    //   610: iload 4
    //   612: iconst_1
    //   613: iadd
    //   614: istore 4
    //   616: goto -531 -> 85
    //   619: astore_1
    //   620: aload_0
    //   621: astore 8
    //   623: aload_2
    //   624: astore_0
    //   625: aload 6
    //   627: astore_1
    //   628: aload 7
    //   630: astore 6
    //   632: aload 8
    //   634: astore_2
    //   635: goto -499 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	paramString1	String
    //   0	638	1	paramString2	String
    //   0	638	2	paramArrayOfString	String[]
    //   0	638	3	paramanln	anln
    //   80	535	4	i	int
    //   227	13	5	j	int
    //   37	594	6	localObject1	Object
    //   1	628	7	localObject2	Object
    //   4	126	8	localObject3	Object
    //   537	64	8	localObject4	Object
    //   621	12	8	str	String
    // Exception table:
    //   from	to	target	type
    //   21	39	121	java/lang/Throwable
    //   44	60	121	java/lang/Throwable
    //   60	79	121	java/lang/Throwable
    //   85	92	121	java/lang/Throwable
    //   108	118	121	java/lang/Throwable
    //   177	182	121	java/lang/Throwable
    //   289	294	295	java/io/IOException
    //   270	274	308	java/io/IOException
    //   279	284	323	java/io/IOException
    //   154	158	338	java/io/IOException
    //   162	166	353	java/io/IOException
    //   171	176	368	java/io/IOException
    //   6	21	381	finally
    //   404	408	428	java/io/IOException
    //   413	418	443	java/io/IOException
    //   422	426	458	java/io/IOException
    //   21	39	473	finally
    //   44	60	473	finally
    //   60	79	473	finally
    //   85	92	473	finally
    //   108	118	473	finally
    //   177	182	473	finally
    //   182	206	489	finally
    //   206	215	508	finally
    //   215	221	524	finally
    //   221	229	524	finally
    //   235	244	524	finally
    //   247	258	524	finally
    //   136	142	537	finally
    //   6	21	559	java/lang/Throwable
    //   182	206	573	java/lang/Throwable
    //   206	215	591	java/lang/Throwable
    //   215	221	619	java/lang/Throwable
    //   221	229	619	java/lang/Throwable
    //   235	244	619	java/lang/Throwable
    //   247	258	619	java/lang/Throwable
  }
  
  public static void a(@NonNull String paramString1, @NonNull String paramString2, @Nullable String[] paramArrayOfString, @Nullable byte[] paramArrayOfByte, @NonNull anlp paramanlp, @Nullable anlo paramanlo1, @Nullable anlo paramanlo2)
  {
    if (paramanlp == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramanlp.a(-1, null, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest urlString:", paramString1 });
    }
    int i = paramString1.indexOf("http://stubcmshow.qq.com/cm3d/");
    if (i >= 0) {}
    for (paramString2 = paramString1.substring(i + "http://stubcmshow.qq.com/cm3d/".length());; paramString2 = paramString1)
    {
      int j;
      for (;;)
      {
        i = paramString1.indexOf("https://stubcmshow.qq.com/cm3d/");
        if (i >= 0) {
          paramString2 = paramString1.substring("https://stubcmshow.qq.com/cm3d/".length() + i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest localUrl:", paramString2 });
        }
        if (TextUtils.isEmpty(paramString2))
        {
          paramanlp.a(-1, null, null);
          return;
        }
        try
        {
          if (!paramString2.startsWith("Role:")) {
            break label473;
          }
          paramString1 = paramString2.substring("Role:".length() + "//".length());
          i = paramString1.indexOf("/");
          if (i <= 0) {
            break;
          }
          j = ApolloUtil.b(paramString1.substring(0, i));
          paramString1 = paramString1.substring("/".length() + i);
          if (TextUtils.isEmpty(paramString1))
          {
            paramanlp.a(-1, null, null);
            return;
          }
        }
        catch (Exception paramString1)
        {
          QLog.e("ApolloHttpUtil", 1, paramString1, new Object[0]);
          return;
        }
      }
      paramString1 = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + j + File.separator + paramString1;
      paramString2 = new File(paramString1);
      if (paramString2.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest file exists:", paramString2.getAbsolutePath() });
        }
        paramArrayOfString = b(paramArrayOfString);
        if (a(paramString1))
        {
          paramString1 = b(paramString2, paramArrayOfString);
          paramanlp.a(0, paramArrayOfString, paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retByteArray:", Integer.valueOf(paramString1.length) });
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retHeader:", paramArrayOfString });
          return;
          paramanlp.a(0, paramArrayOfString, ApolloRender.readStream(new FileInputStream(paramString2)));
        }
        break;
      }
      QLog.d("ApolloHttpUtil", 1, "fakeResource3DUrlRequest start download id:" + j);
      anex.b(amwn.a(), null, new anlr(paramString1, paramArrayOfString, paramanlp), j, null, -1, -1, false);
      return;
      label473:
      if (paramString2.startsWith("Dress:"))
      {
        paramString1 = paramString2.substring("Dress:".length() + "//".length());
        i = paramString1.indexOf("/");
        if (i <= 0) {
          break;
        }
        j = ApolloUtil.b(paramString1.substring(0, i));
        paramString1 = paramString1.substring("/".length() + i);
        if (TextUtils.isEmpty(paramString1))
        {
          paramanlp.a(-1, null, null);
          return;
        }
        paramString1 = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + j + File.separator + paramString1;
        paramString2 = new File(paramString1);
        if (paramString2.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest file exists:", paramString2.getAbsolutePath() });
          }
          paramArrayOfString = b(paramArrayOfString);
          if (a(paramString1)) {
            paramanlp.a(0, paramArrayOfString, b(paramString2, paramArrayOfString));
          }
          while (QLog.isColorLevel())
          {
            QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retHeader:", paramArrayOfString });
            return;
            paramanlp.a(0, paramArrayOfString, ApolloRender.readStream(new FileInputStream(paramString2)));
          }
          break;
        }
        QLog.d("ApolloHttpUtil", 1, "fakeResource3DUrlRequest start download id:" + j);
        anex.b(amwn.a(), null, new anls(paramString1, paramArrayOfString, paramanlp, j), -1, new int[] { j }, -1, -1, true);
        return;
      }
      if (!paramString2.startsWith("def/role/0/3D/")) {
        break;
      }
      paramString1 = anka.a + File.separator + paramString2;
      paramString2 = new File(paramString1);
      if (paramString2.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest file exists:", paramString2.getAbsolutePath() });
        }
        paramArrayOfString = b(paramArrayOfString);
        if (a(paramString1)) {
          paramanlp.a(0, paramArrayOfString, b(paramString2, paramArrayOfString));
        }
        while (QLog.isColorLevel())
        {
          QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retHeader:", paramArrayOfString });
          return;
          paramanlp.a(0, paramArrayOfString, ApolloRender.readStream(new FileInputStream(paramString2)));
        }
        break;
      }
      QLog.d("ApolloHttpUtil", 1, new Object[] { "fakeResource3DUrlRequest file no exists", paramString2.getAbsolutePath() });
      return;
    }
  }
  
  /* Error */
  public static void a(String paramString, String[] paramArrayOfString, anln paramanln)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: new 37	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 313
    //   13: invokespecial 314	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: astore 8
    //   22: new 62	java/net/URL
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 65	java/net/URL:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 69	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   33: checkcast 71	java/net/HttpURLConnection
    //   36: astore_0
    //   37: sipush -255
    //   40: invokestatic 319	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   43: aload_0
    //   44: ldc_w 321
    //   47: invokevirtual 76	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: instanceof 78
    //   54: ifeq +38 -> 92
    //   57: invokestatic 80	anlq:a	()Ljavax/net/ssl/SSLContext;
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +71 -> 135
    //   67: aload 5
    //   69: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   72: astore 5
    //   74: aload_0
    //   75: checkcast 78	javax/net/ssl/HttpsURLConnection
    //   78: aload 5
    //   80: invokevirtual 88	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   83: aload 8
    //   85: ldc_w 323
    //   88: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_0
    //   93: sipush 8000
    //   96: invokevirtual 92	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   99: aload_0
    //   100: sipush 8000
    //   103: invokevirtual 95	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   106: aload_1
    //   107: ifnull +171 -> 278
    //   110: iconst_0
    //   111: istore_3
    //   112: aconst_null
    //   113: astore 5
    //   115: iload_3
    //   116: aload_1
    //   117: arraylength
    //   118: if_icmpge +160 -> 278
    //   121: iload_3
    //   122: iconst_2
    //   123: irem
    //   124: ifne +87 -> 211
    //   127: aload_1
    //   128: iload_3
    //   129: aaload
    //   130: astore 5
    //   132: goto +450 -> 582
    //   135: aload 8
    //   137: ldc_w 325
    //   140: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: goto -52 -> 92
    //   147: astore_1
    //   148: aconst_null
    //   149: astore 7
    //   151: aload 6
    //   153: astore 5
    //   155: aload_0
    //   156: astore_1
    //   157: aload 7
    //   159: astore_0
    //   160: aload_2
    //   161: ifnull +9 -> 170
    //   164: aload_2
    //   165: iconst_m1
    //   166: aconst_null
    //   167: invokevirtual 114	anln:a	(I[B)V
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   178: aload 5
    //   180: ifnull +8 -> 188
    //   183: aload 5
    //   185: invokevirtual 125	java/io/InputStream:close	()V
    //   188: aload_0
    //   189: ifnull +7 -> 196
    //   192: aload_0
    //   193: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   196: invokestatic 328	android/net/TrafficStats:clearThreadStatsTag	()V
    //   199: ldc 35
    //   201: iconst_1
    //   202: aload 8
    //   204: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: return
    //   211: aload_0
    //   212: aload 5
    //   214: aload_1
    //   215: iload_3
    //   216: aaload
    //   217: invokevirtual 105	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: goto +362 -> 582
    //   223: astore 6
    //   225: aconst_null
    //   226: astore 5
    //   228: aload 7
    //   230: astore_2
    //   231: aload_0
    //   232: astore_1
    //   233: aload 6
    //   235: astore_0
    //   236: aload_1
    //   237: ifnull +7 -> 244
    //   240: aload_1
    //   241: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   244: aload 5
    //   246: ifnull +8 -> 254
    //   249: aload 5
    //   251: invokevirtual 125	java/io/InputStream:close	()V
    //   254: aload_2
    //   255: ifnull +7 -> 262
    //   258: aload_2
    //   259: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   262: invokestatic 328	android/net/TrafficStats:clearThreadStatsTag	()V
    //   265: ldc 35
    //   267: iconst_1
    //   268: aload 8
    //   270: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_0
    //   277: athrow
    //   278: aload_0
    //   279: invokevirtual 149	java/net/HttpURLConnection:getResponseCode	()I
    //   282: istore_3
    //   283: aload 8
    //   285: ldc_w 333
    //   288: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: iload_3
    //   292: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: ldc_w 335
    //   298: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_0
    //   302: invokevirtual 339	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   305: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload_0
    //   310: invokevirtual 153	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   313: astore 5
    //   315: new 127	java/io/ByteArrayOutputStream
    //   318: dup
    //   319: invokespecial 154	java/io/ByteArrayOutputStream:<init>	()V
    //   322: astore_1
    //   323: sipush 1024
    //   326: newarray byte
    //   328: astore 6
    //   330: aload 5
    //   332: aload 6
    //   334: invokevirtual 158	java/io/InputStream:read	([B)I
    //   337: istore 4
    //   339: iload 4
    //   341: iconst_m1
    //   342: if_icmpeq +15 -> 357
    //   345: aload_1
    //   346: aload 6
    //   348: iconst_0
    //   349: iload 4
    //   351: invokevirtual 161	java/io/ByteArrayOutputStream:write	([BII)V
    //   354: goto -24 -> 330
    //   357: aload 8
    //   359: ldc_w 341
    //   362: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_1
    //   366: invokevirtual 344	java/io/ByteArrayOutputStream:size	()I
    //   369: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload_2
    //   374: ifnull +12 -> 386
    //   377: aload_2
    //   378: iload_3
    //   379: aload_1
    //   380: invokevirtual 164	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   383: invokevirtual 114	anln:a	(I[B)V
    //   386: aload_0
    //   387: ifnull +7 -> 394
    //   390: aload_0
    //   391: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   394: aload 5
    //   396: ifnull +8 -> 404
    //   399: aload 5
    //   401: invokevirtual 125	java/io/InputStream:close	()V
    //   404: aload_1
    //   405: ifnull +7 -> 412
    //   408: aload_1
    //   409: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   412: invokestatic 328	android/net/TrafficStats:clearThreadStatsTag	()V
    //   415: ldc 35
    //   417: iconst_1
    //   418: aload 8
    //   420: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: return
    //   427: astore_0
    //   428: ldc 35
    //   430: iconst_1
    //   431: aload_0
    //   432: iconst_0
    //   433: anewarray 4	java/lang/Object
    //   436: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   439: goto -35 -> 404
    //   442: astore_0
    //   443: ldc 35
    //   445: iconst_1
    //   446: aload_0
    //   447: iconst_0
    //   448: anewarray 4	java/lang/Object
    //   451: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   454: goto -42 -> 412
    //   457: astore_1
    //   458: ldc 35
    //   460: iconst_1
    //   461: aload_1
    //   462: iconst_0
    //   463: anewarray 4	java/lang/Object
    //   466: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   469: goto -281 -> 188
    //   472: astore_0
    //   473: ldc 35
    //   475: iconst_1
    //   476: aload_0
    //   477: iconst_0
    //   478: anewarray 4	java/lang/Object
    //   481: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   484: goto -288 -> 196
    //   487: astore_1
    //   488: ldc 35
    //   490: iconst_1
    //   491: aload_1
    //   492: iconst_0
    //   493: anewarray 4	java/lang/Object
    //   496: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   499: goto -245 -> 254
    //   502: astore_1
    //   503: ldc 35
    //   505: iconst_1
    //   506: aload_1
    //   507: iconst_0
    //   508: anewarray 4	java/lang/Object
    //   511: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   514: goto -252 -> 262
    //   517: astore_0
    //   518: aconst_null
    //   519: astore 5
    //   521: aconst_null
    //   522: astore_1
    //   523: aload 7
    //   525: astore_2
    //   526: goto -290 -> 236
    //   529: astore_2
    //   530: aload_0
    //   531: astore_1
    //   532: aload_2
    //   533: astore_0
    //   534: aload 7
    //   536: astore_2
    //   537: goto -301 -> 236
    //   540: astore 6
    //   542: aload_1
    //   543: astore_2
    //   544: aload_0
    //   545: astore_1
    //   546: aload 6
    //   548: astore_0
    //   549: goto -313 -> 236
    //   552: astore 6
    //   554: aload_0
    //   555: astore_2
    //   556: aload 6
    //   558: astore_0
    //   559: goto -323 -> 236
    //   562: astore_0
    //   563: aconst_null
    //   564: astore_0
    //   565: aconst_null
    //   566: astore_1
    //   567: aload 6
    //   569: astore 5
    //   571: goto -411 -> 160
    //   574: astore_1
    //   575: aload_0
    //   576: astore_1
    //   577: aconst_null
    //   578: astore_0
    //   579: goto -419 -> 160
    //   582: iload_3
    //   583: iconst_1
    //   584: iadd
    //   585: istore_3
    //   586: goto -471 -> 115
    //   589: astore 6
    //   591: aload_0
    //   592: astore 6
    //   594: aload_1
    //   595: astore_0
    //   596: aload 6
    //   598: astore_1
    //   599: goto -439 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	602	0	paramString	String
    //   0	602	1	paramArrayOfString	String[]
    //   0	602	2	paramanln	anln
    //   111	475	3	i	int
    //   337	13	4	j	int
    //   60	510	5	localObject1	Object
    //   4	148	6	localObject2	Object
    //   223	11	6	localObject3	Object
    //   328	19	6	arrayOfByte	byte[]
    //   540	7	6	localObject4	Object
    //   552	16	6	localObject5	Object
    //   589	1	6	localException	Exception
    //   592	5	6	str	String
    //   1	534	7	localObject6	Object
    //   20	399	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	62	147	java/lang/Exception
    //   67	92	147	java/lang/Exception
    //   92	106	147	java/lang/Exception
    //   115	121	147	java/lang/Exception
    //   135	144	147	java/lang/Exception
    //   211	220	147	java/lang/Exception
    //   278	315	147	java/lang/Exception
    //   37	62	223	finally
    //   67	92	223	finally
    //   92	106	223	finally
    //   115	121	223	finally
    //   135	144	223	finally
    //   211	220	223	finally
    //   278	315	223	finally
    //   399	404	427	java/io/IOException
    //   408	412	442	java/io/IOException
    //   183	188	457	java/io/IOException
    //   192	196	472	java/io/IOException
    //   249	254	487	java/io/IOException
    //   258	262	502	java/io/IOException
    //   22	37	517	finally
    //   315	323	529	finally
    //   323	330	540	finally
    //   330	339	540	finally
    //   345	354	540	finally
    //   357	373	540	finally
    //   377	386	540	finally
    //   164	170	552	finally
    //   22	37	562	java/lang/Exception
    //   315	323	574	java/lang/Exception
    //   323	330	589	java/lang/Exception
    //   330	339	589	java/lang/Exception
    //   345	354	589	java/lang/Exception
    //   357	373	589	java/lang/Exception
    //   377	386	589	java/lang/Exception
  }
  
  static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.endsWith(".jpg")) && (!paramString.endsWith(".png"))) {
      return false;
    }
    return true;
  }
  
  private static byte[] a(@NonNull HttpURLConnection paramHttpURLConnection, @Nullable anlo paramanlo)
  {
    localObject3 = null;
    Object localObject1 = localObject3;
    try
    {
      int i = paramHttpURLConnection.getContentLength();
      localObject1 = localObject3;
      Object localObject4;
      try
      {
        localObject4 = paramHttpURLConnection.getInputStream();
        paramHttpURLConnection = (HttpURLConnection)localObject4;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          try
          {
            paramHttpURLConnection.close();
            paramanlo = (anlo)localObject3;
            return paramanlo;
          }
          catch (IOException paramHttpURLConnection)
          {
            paramHttpURLConnection.printStackTrace();
            return localObject3;
          }
          localIOException = localIOException;
          localObject2 = localObject3;
          paramHttpURLConnection = paramHttpURLConnection.getErrorStream();
        }
      }
      if (paramHttpURLConnection == null)
      {
        localObject1 = paramHttpURLConnection;
        localObject3 = new byte[0];
        paramanlo = (anlo)localObject3;
        if (paramHttpURLConnection == null) {}
      }
      for (;;)
      {
        Object localObject2 = paramHttpURLConnection;
        localObject3 = new ByteArrayOutputStream();
        localObject2 = paramHttpURLConnection;
        localObject4 = new byte[1024];
        for (;;)
        {
          localObject2 = paramHttpURLConnection;
          int j = paramHttpURLConnection.read((byte[])localObject4);
          if (j == -1) {
            break;
          }
          localObject2 = paramHttpURLConnection;
          ((ByteArrayOutputStream)localObject3).write((byte[])localObject4, 0, j);
          if (paramanlo != null)
          {
            localObject2 = paramHttpURLConnection;
            paramanlo.a(((ByteArrayOutputStream)localObject3).size(), i);
          }
        }
        try
        {
          ((InputStream)localObject2).close();
          throw paramHttpURLConnection;
          localObject2 = paramHttpURLConnection;
          paramanlo = ((ByteArrayOutputStream)localObject3).toByteArray();
          localObject2 = paramanlo;
          paramanlo = (anlo)localObject2;
          if (paramHttpURLConnection == null) {
            continue;
          }
          try
          {
            paramHttpURLConnection.close();
            return localObject2;
          }
          catch (IOException paramHttpURLConnection)
          {
            paramHttpURLConnection.printStackTrace();
            return localObject2;
          }
        }
        catch (IOException paramanlo)
        {
          for (;;)
          {
            paramanlo.printStackTrace();
          }
        }
      }
    }
    finally
    {
      if (localObject2 == null) {}
    }
  }
  
  private static HashMap<String, String> b(String[] paramArrayOfString)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayOfString != null)
    {
      String str = null;
      int i = 0;
      if (i < paramArrayOfString.length)
      {
        if ((i & 0x1) == 0) {
          str = paramArrayOfString[i];
        }
        for (;;)
        {
          i += 1;
          break;
          localHashMap.put(str, paramArrayOfString[i]);
        }
      }
    }
    return localHashMap;
  }
  
  /* Error */
  public static void b(@NonNull String paramString1, @NonNull String paramString2, @Nullable String[] paramArrayOfString, @Nullable byte[] paramArrayOfByte, @NonNull anlp paramanlp, @Nullable anlo paramanlo1, @Nullable anlo paramanlo2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 16
    //   6: aconst_null
    //   7: astore 15
    //   9: aconst_null
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 14
    //   15: aconst_null
    //   16: astore 13
    //   18: iconst_m1
    //   19: istore 8
    //   21: new 368	java/util/HashMap
    //   24: dup
    //   25: invokespecial 369	java/util/HashMap:<init>	()V
    //   28: astore 18
    //   30: new 377	java/lang/StringBuffer
    //   33: dup
    //   34: ldc_w 379
    //   37: invokespecial 380	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: invokevirtual 383	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   44: astore 17
    //   46: new 62	java/net/URL
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 65	java/net/URL:<init>	(Ljava/lang/String;)V
    //   54: invokevirtual 69	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   57: checkcast 71	java/net/HttpURLConnection
    //   60: astore_0
    //   61: aload 13
    //   63: astore 12
    //   65: aload 14
    //   67: astore 11
    //   69: aload_0
    //   70: instanceof 78
    //   73: ifeq +70 -> 143
    //   76: aload 13
    //   78: astore 12
    //   80: aload 14
    //   82: astore 11
    //   84: invokestatic 80	anlq:a	()Ljavax/net/ssl/SSLContext;
    //   87: astore 15
    //   89: aload 15
    //   91: ifnull +160 -> 251
    //   94: aload 13
    //   96: astore 12
    //   98: aload 14
    //   100: astore 11
    //   102: aload 15
    //   104: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   107: astore 15
    //   109: aload 13
    //   111: astore 12
    //   113: aload 14
    //   115: astore 11
    //   117: aload_0
    //   118: checkcast 78	javax/net/ssl/HttpsURLConnection
    //   121: aload 15
    //   123: invokevirtual 88	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   126: aload 13
    //   128: astore 12
    //   130: aload 14
    //   132: astore 11
    //   134: aload 17
    //   136: ldc_w 385
    //   139: invokevirtual 383	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: aload 13
    //   145: astore 12
    //   147: aload 14
    //   149: astore 11
    //   151: aload_0
    //   152: aload_1
    //   153: invokevirtual 76	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   156: aload 13
    //   158: astore 12
    //   160: aload 14
    //   162: astore 11
    //   164: aload_0
    //   165: sipush 10000
    //   168: invokevirtual 92	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   171: aload 13
    //   173: astore 12
    //   175: aload 14
    //   177: astore 11
    //   179: aload_0
    //   180: sipush 10000
    //   183: invokevirtual 95	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   186: aload 13
    //   188: astore 12
    //   190: aload 14
    //   192: astore 11
    //   194: aload_0
    //   195: iconst_1
    //   196: invokevirtual 388	java/net/HttpURLConnection:setDoInput	(Z)V
    //   199: aload 13
    //   201: astore 12
    //   203: aload 14
    //   205: astore 11
    //   207: aload_0
    //   208: iconst_0
    //   209: invokevirtual 99	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   212: aload_2
    //   213: ifnull +272 -> 485
    //   216: aconst_null
    //   217: astore_1
    //   218: iconst_0
    //   219: istore 7
    //   221: aload 13
    //   223: astore 12
    //   225: aload 14
    //   227: astore 11
    //   229: iload 7
    //   231: aload_2
    //   232: arraylength
    //   233: if_icmpge +252 -> 485
    //   236: iload 7
    //   238: iconst_1
    //   239: iand
    //   240: ifne +133 -> 373
    //   243: aload_2
    //   244: iload 7
    //   246: aaload
    //   247: astore_1
    //   248: goto +737 -> 985
    //   251: aload 13
    //   253: astore 12
    //   255: aload 14
    //   257: astore 11
    //   259: aload 17
    //   261: ldc_w 390
    //   264: invokevirtual 383	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   267: pop
    //   268: aload 13
    //   270: astore 12
    //   272: aload 14
    //   274: astore 11
    //   276: ldc 35
    //   278: iconst_1
    //   279: ldc_w 392
    //   282: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: goto -142 -> 143
    //   288: astore_2
    //   289: iconst_m1
    //   290: istore 7
    //   292: aconst_null
    //   293: astore_3
    //   294: aload_0
    //   295: astore_1
    //   296: aload_3
    //   297: astore_0
    //   298: ldc 35
    //   300: iconst_1
    //   301: new 37	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   308: ldc_w 396
    //   311: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_2
    //   315: invokevirtual 399	java/io/IOException:getMessage	()Ljava/lang/String;
    //   318: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: aload 4
    //   329: iload 7
    //   331: aload 18
    //   333: aload_2
    //   334: invokevirtual 400	java/io/IOException:toString	()Ljava/lang/String;
    //   337: invokevirtual 138	java/lang/String:getBytes	()[B
    //   340: invokeinterface 186 4 0
    //   345: ldc 35
    //   347: iconst_1
    //   348: aload 17
    //   350: invokevirtual 401	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   353: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: aload_0
    //   357: ifnull +7 -> 364
    //   360: aload_0
    //   361: invokevirtual 122	java/io/OutputStream:close	()V
    //   364: aload_1
    //   365: ifnull +7 -> 372
    //   368: aload_1
    //   369: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   372: return
    //   373: aload 13
    //   375: astore 12
    //   377: aload 14
    //   379: astore 11
    //   381: aload_0
    //   382: aload_1
    //   383: aload_2
    //   384: iload 7
    //   386: aaload
    //   387: invokevirtual 105	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: goto +595 -> 985
    //   393: astore_2
    //   394: aload 12
    //   396: astore_1
    //   397: iload 8
    //   399: istore 7
    //   401: aload_0
    //   402: astore 11
    //   404: aload_1
    //   405: astore 12
    //   407: ldc 35
    //   409: iconst_1
    //   410: new 37	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 403
    //   420: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_2
    //   424: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_0
    //   434: astore 11
    //   436: aload_1
    //   437: astore 12
    //   439: aload 4
    //   441: iload 7
    //   443: aload 18
    //   445: aload_2
    //   446: invokevirtual 404	java/lang/Throwable:toString	()Ljava/lang/String;
    //   449: invokevirtual 138	java/lang/String:getBytes	()[B
    //   452: invokeinterface 186 4 0
    //   457: ldc 35
    //   459: iconst_1
    //   460: aload 17
    //   462: invokevirtual 401	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   465: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aload_1
    //   469: ifnull +7 -> 476
    //   472: aload_1
    //   473: invokevirtual 122	java/io/OutputStream:close	()V
    //   476: aload_0
    //   477: ifnull -105 -> 372
    //   480: aload_0
    //   481: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   484: return
    //   485: aload_3
    //   486: ifnull +494 -> 980
    //   489: aload 13
    //   491: astore 12
    //   493: aload 14
    //   495: astore 11
    //   497: aload 17
    //   499: ldc_w 406
    //   502: invokevirtual 383	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   505: aload_3
    //   506: arraylength
    //   507: invokevirtual 409	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   510: pop
    //   511: aload 13
    //   513: astore 12
    //   515: aload 14
    //   517: astore 11
    //   519: aload_0
    //   520: iconst_1
    //   521: invokevirtual 412	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   524: aload 13
    //   526: astore 12
    //   528: aload 14
    //   530: astore 11
    //   532: aload_0
    //   533: aload_3
    //   534: arraylength
    //   535: invokevirtual 415	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   538: aload 13
    //   540: astore 12
    //   542: aload 14
    //   544: astore 11
    //   546: aload_0
    //   547: invokevirtual 132	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   550: astore_1
    //   551: aload_1
    //   552: astore 12
    //   554: aload_1
    //   555: astore 11
    //   557: aload_3
    //   558: arraylength
    //   559: istore 10
    //   561: iconst_0
    //   562: istore 7
    //   564: iload 7
    //   566: iload 10
    //   568: if_icmpge +77 -> 645
    //   571: aload_1
    //   572: astore 12
    //   574: aload_1
    //   575: astore 11
    //   577: sipush 4096
    //   580: iload 10
    //   582: iload 7
    //   584: isub
    //   585: invokestatic 421	java/lang/Math:min	(II)I
    //   588: istore 9
    //   590: aload_1
    //   591: astore 12
    //   593: aload_1
    //   594: astore 11
    //   596: aload_1
    //   597: aload_3
    //   598: iload 7
    //   600: iload 9
    //   602: invokevirtual 422	java/io/OutputStream:write	([BII)V
    //   605: iload 7
    //   607: iload 9
    //   609: iadd
    //   610: istore 9
    //   612: iload 9
    //   614: istore 7
    //   616: aload 5
    //   618: ifnull -54 -> 564
    //   621: aload_1
    //   622: astore 12
    //   624: aload_1
    //   625: astore 11
    //   627: aload 5
    //   629: iload 9
    //   631: iload 10
    //   633: invokeinterface 366 3 0
    //   638: iload 9
    //   640: istore 7
    //   642: goto -78 -> 564
    //   645: aload_1
    //   646: astore 12
    //   648: aload_1
    //   649: astore 11
    //   651: aload_1
    //   652: invokevirtual 145	java/io/OutputStream:flush	()V
    //   655: aload_0
    //   656: invokevirtual 149	java/net/HttpURLConnection:getResponseCode	()I
    //   659: istore 7
    //   661: aload_0
    //   662: invokevirtual 339	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   665: astore_2
    //   666: aload 17
    //   668: ldc_w 424
    //   671: invokevirtual 383	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   674: iload 7
    //   676: invokevirtual 409	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   679: ldc_w 335
    //   682: invokevirtual 383	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   685: aload_2
    //   686: invokevirtual 427	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   689: pop
    //   690: aload_2
    //   691: invokeinterface 433 1 0
    //   696: invokeinterface 439 1 0
    //   701: astore_2
    //   702: aload_2
    //   703: invokeinterface 444 1 0
    //   708: ifeq +64 -> 772
    //   711: aload_2
    //   712: invokeinterface 448 1 0
    //   717: checkcast 450	java/util/Map$Entry
    //   720: astore 5
    //   722: aload 5
    //   724: invokeinterface 453 1 0
    //   729: checkcast 134	java/lang/String
    //   732: astore_3
    //   733: aload 5
    //   735: invokeinterface 456 1 0
    //   740: checkcast 458	java/util/List
    //   743: astore 5
    //   745: aload_3
    //   746: ifnull -44 -> 702
    //   749: aload 5
    //   751: ifnull -49 -> 702
    //   754: aload 18
    //   756: aload_3
    //   757: ldc_w 460
    //   760: aload 5
    //   762: invokestatic 464	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   765: invokevirtual 373	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   768: pop
    //   769: goto -67 -> 702
    //   772: aload_0
    //   773: aload 6
    //   775: invokestatic 466	anlq:a	(Ljava/net/HttpURLConnection;Lanlo;)[B
    //   778: astore_2
    //   779: aload 17
    //   781: ldc_w 468
    //   784: invokevirtual 383	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   787: aload_2
    //   788: arraylength
    //   789: invokevirtual 409	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   792: pop
    //   793: aload 4
    //   795: iload 7
    //   797: aload 18
    //   799: aload_2
    //   800: invokeinterface 186 4 0
    //   805: ldc 35
    //   807: iconst_1
    //   808: aload 17
    //   810: invokevirtual 401	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   813: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: aload_1
    //   817: ifnull +7 -> 824
    //   820: aload_1
    //   821: invokevirtual 122	java/io/OutputStream:close	()V
    //   824: aload_0
    //   825: ifnull -453 -> 372
    //   828: aload_0
    //   829: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   832: return
    //   833: astore_1
    //   834: aload_1
    //   835: invokevirtual 361	java/io/IOException:printStackTrace	()V
    //   838: goto -14 -> 824
    //   841: astore_0
    //   842: aload_0
    //   843: invokevirtual 361	java/io/IOException:printStackTrace	()V
    //   846: goto -482 -> 364
    //   849: astore_1
    //   850: aload_1
    //   851: invokevirtual 361	java/io/IOException:printStackTrace	()V
    //   854: goto -378 -> 476
    //   857: astore_0
    //   858: aload 12
    //   860: astore_2
    //   861: aload 11
    //   863: astore_1
    //   864: ldc 35
    //   866: iconst_1
    //   867: aload 17
    //   869: invokevirtual 401	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   872: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   875: aload_2
    //   876: ifnull +7 -> 883
    //   879: aload_2
    //   880: invokevirtual 122	java/io/OutputStream:close	()V
    //   883: aload_1
    //   884: ifnull +7 -> 891
    //   887: aload_1
    //   888: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   891: aload_0
    //   892: athrow
    //   893: astore_2
    //   894: aload_2
    //   895: invokevirtual 361	java/io/IOException:printStackTrace	()V
    //   898: goto -15 -> 883
    //   901: astore_2
    //   902: aload_0
    //   903: astore_1
    //   904: aload_2
    //   905: astore_0
    //   906: aload 11
    //   908: astore_2
    //   909: goto -45 -> 864
    //   912: astore_3
    //   913: aload_1
    //   914: astore_2
    //   915: aload_0
    //   916: astore_1
    //   917: aload_3
    //   918: astore_0
    //   919: goto -55 -> 864
    //   922: astore_3
    //   923: aload_0
    //   924: astore_2
    //   925: aload_3
    //   926: astore_0
    //   927: goto -63 -> 864
    //   930: astore_2
    //   931: aload 16
    //   933: astore_0
    //   934: iload 8
    //   936: istore 7
    //   938: aload 15
    //   940: astore_1
    //   941: goto -540 -> 401
    //   944: astore_2
    //   945: iload 8
    //   947: istore 7
    //   949: goto -548 -> 401
    //   952: astore_2
    //   953: goto -552 -> 401
    //   956: astore_2
    //   957: aconst_null
    //   958: astore_0
    //   959: aconst_null
    //   960: astore_1
    //   961: iconst_m1
    //   962: istore 7
    //   964: goto -666 -> 298
    //   967: astore_2
    //   968: aload_0
    //   969: astore_3
    //   970: iconst_m1
    //   971: istore 7
    //   973: aload_1
    //   974: astore_0
    //   975: aload_3
    //   976: astore_1
    //   977: goto -679 -> 298
    //   980: aconst_null
    //   981: astore_1
    //   982: goto -327 -> 655
    //   985: iload 7
    //   987: iconst_1
    //   988: iadd
    //   989: istore 7
    //   991: goto -770 -> 221
    //   994: astore_2
    //   995: iconst_m1
    //   996: istore 7
    //   998: aload_0
    //   999: astore_3
    //   1000: aload_1
    //   1001: astore_0
    //   1002: aload_3
    //   1003: astore_1
    //   1004: goto -706 -> 298
    //   1007: astore_2
    //   1008: aload_0
    //   1009: astore_3
    //   1010: aload_1
    //   1011: astore_0
    //   1012: aload_3
    //   1013: astore_1
    //   1014: goto -716 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1017	0	paramString1	String
    //   0	1017	1	paramString2	String
    //   0	1017	2	paramArrayOfString	String[]
    //   0	1017	3	paramArrayOfByte	byte[]
    //   0	1017	4	paramanlp	anlp
    //   0	1017	5	paramanlo1	anlo
    //   0	1017	6	paramanlo2	anlo
    //   219	778	7	i	int
    //   19	927	8	j	int
    //   588	51	9	k	int
    //   559	73	10	m	int
    //   1	906	11	localObject1	Object
    //   10	849	12	localObject2	Object
    //   16	523	13	localObject3	Object
    //   13	530	14	localObject4	Object
    //   7	932	15	localObject5	Object
    //   4	928	16	localObject6	Object
    //   44	824	17	localStringBuffer	java.lang.StringBuffer
    //   28	770	18	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   69	76	288	java/io/IOException
    //   84	89	288	java/io/IOException
    //   102	109	288	java/io/IOException
    //   117	126	288	java/io/IOException
    //   134	143	288	java/io/IOException
    //   151	156	288	java/io/IOException
    //   164	171	288	java/io/IOException
    //   179	186	288	java/io/IOException
    //   194	199	288	java/io/IOException
    //   207	212	288	java/io/IOException
    //   229	236	288	java/io/IOException
    //   259	268	288	java/io/IOException
    //   276	285	288	java/io/IOException
    //   381	390	288	java/io/IOException
    //   497	511	288	java/io/IOException
    //   519	524	288	java/io/IOException
    //   532	538	288	java/io/IOException
    //   546	551	288	java/io/IOException
    //   69	76	393	java/lang/Throwable
    //   84	89	393	java/lang/Throwable
    //   102	109	393	java/lang/Throwable
    //   117	126	393	java/lang/Throwable
    //   134	143	393	java/lang/Throwable
    //   151	156	393	java/lang/Throwable
    //   164	171	393	java/lang/Throwable
    //   179	186	393	java/lang/Throwable
    //   194	199	393	java/lang/Throwable
    //   207	212	393	java/lang/Throwable
    //   229	236	393	java/lang/Throwable
    //   259	268	393	java/lang/Throwable
    //   276	285	393	java/lang/Throwable
    //   381	390	393	java/lang/Throwable
    //   497	511	393	java/lang/Throwable
    //   519	524	393	java/lang/Throwable
    //   532	538	393	java/lang/Throwable
    //   546	551	393	java/lang/Throwable
    //   557	561	393	java/lang/Throwable
    //   577	590	393	java/lang/Throwable
    //   596	605	393	java/lang/Throwable
    //   627	638	393	java/lang/Throwable
    //   651	655	393	java/lang/Throwable
    //   820	824	833	java/io/IOException
    //   360	364	841	java/io/IOException
    //   472	476	849	java/io/IOException
    //   46	61	857	finally
    //   407	433	857	finally
    //   439	457	857	finally
    //   879	883	893	java/io/IOException
    //   69	76	901	finally
    //   84	89	901	finally
    //   102	109	901	finally
    //   117	126	901	finally
    //   134	143	901	finally
    //   151	156	901	finally
    //   164	171	901	finally
    //   179	186	901	finally
    //   194	199	901	finally
    //   207	212	901	finally
    //   229	236	901	finally
    //   259	268	901	finally
    //   276	285	901	finally
    //   381	390	901	finally
    //   497	511	901	finally
    //   519	524	901	finally
    //   532	538	901	finally
    //   546	551	901	finally
    //   557	561	901	finally
    //   577	590	901	finally
    //   596	605	901	finally
    //   627	638	901	finally
    //   651	655	901	finally
    //   655	661	912	finally
    //   661	702	912	finally
    //   702	745	912	finally
    //   754	769	912	finally
    //   772	805	912	finally
    //   298	345	922	finally
    //   46	61	930	java/lang/Throwable
    //   655	661	944	java/lang/Throwable
    //   661	702	952	java/lang/Throwable
    //   702	745	952	java/lang/Throwable
    //   754	769	952	java/lang/Throwable
    //   772	805	952	java/lang/Throwable
    //   46	61	956	java/io/IOException
    //   655	661	967	java/io/IOException
    //   557	561	994	java/io/IOException
    //   577	590	994	java/io/IOException
    //   596	605	994	java/io/IOException
    //   627	638	994	java/io/IOException
    //   651	655	994	java/io/IOException
    //   661	702	1007	java/io/IOException
    //   702	745	1007	java/io/IOException
    //   754	769	1007	java/io/IOException
    //   772	805	1007	java/io/IOException
  }
  
  private static byte[] b(File paramFile, HashMap<String, String> paramHashMap)
  {
    if ((paramFile != null) && (paramFile.exists())) {
      try
      {
        paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
        if (paramHashMap != null)
        {
          paramHashMap.put("width", String.valueOf(paramFile.getWidth()));
          paramHashMap.put("height", String.valueOf(paramFile.getHeight()));
        }
        paramHashMap = ByteBuffer.allocateDirect(paramFile.getByteCount());
        paramHashMap.order(ByteOrder.nativeOrder());
        paramFile.copyPixelsToBuffer(paramHashMap);
        paramFile = paramHashMap.array();
        return paramFile;
      }
      catch (OutOfMemoryError paramFile)
      {
        QLog.d("ApolloHttpUtil", 2, "wrapBitmapBuffer" + paramFile);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlq
 * JD-Core Version:    0.7.0.1
 */