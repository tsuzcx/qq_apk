package com.tencent.mobileqq.apollo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
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

public class ApolloHttpUtil
{
  public static SSLContext a()
  {
    SSLContext localSSLContext;
    try
    {
      localSSLContext = SSLContext.getInstance("TLS");
      try
      {
        localSSLContext.init(null, new TrustManager[] { new ApolloHttpUtil.CustomX509TrustManager() }, null);
        return localSSLContext;
      }
      catch (Throwable localThrowable1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Throwable localThrowable2)
    {
      localSSLContext = null;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("getSLLContext exception: ");
    localStringBuilder.append(localThrowable2);
    QLog.d("[cmshow]ApolloHttpUtil", 1, localStringBuilder.toString());
    return localSSLContext;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString, ApolloHttpCallBack paramApolloHttpCallBack)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 63	java/net/URL
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 66	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 70	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   14: checkcast 72	java/net/HttpURLConnection
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 74
    //   21: invokevirtual 77	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: instanceof 79
    //   28: ifeq +29 -> 57
    //   31: invokestatic 81	com/tencent/mobileqq/apollo/utils/ApolloHttpUtil:a	()Ljavax/net/ssl/SSLContext;
    //   34: astore 9
    //   36: aload 9
    //   38: ifnull +19 -> 57
    //   41: aload 9
    //   43: invokevirtual 85	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   46: astore 9
    //   48: aload_0
    //   49: checkcast 79	javax/net/ssl/HttpsURLConnection
    //   52: aload 9
    //   54: invokevirtual 89	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   57: aload_0
    //   58: sipush 8000
    //   61: invokevirtual 93	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   64: aload_0
    //   65: sipush 8000
    //   68: invokevirtual 96	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   71: aload_0
    //   72: iconst_0
    //   73: invokevirtual 100	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   76: aload_0
    //   77: ldc 102
    //   79: aload_1
    //   80: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: ldc 108
    //   86: aload_2
    //   87: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: ldc 110
    //   93: aload_3
    //   94: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aconst_null
    //   98: astore_2
    //   99: iconst_0
    //   100: istore 6
    //   102: iload 6
    //   104: aload 4
    //   106: arraylength
    //   107: if_icmpge +32 -> 139
    //   110: iload 6
    //   112: iconst_2
    //   113: irem
    //   114: ifne +12 -> 126
    //   117: aload 4
    //   119: iload 6
    //   121: aaload
    //   122: astore_2
    //   123: goto +510 -> 633
    //   126: aload_0
    //   127: aload_2
    //   128: aload 4
    //   130: iload 6
    //   132: aaload
    //   133: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto +497 -> 633
    //   139: aload_0
    //   140: invokevirtual 114	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   143: astore_2
    //   144: aload_2
    //   145: aload_1
    //   146: invokevirtual 120	java/lang/String:getBytes	()[B
    //   149: invokevirtual 126	java/io/OutputStream:write	([B)V
    //   152: aload_2
    //   153: invokevirtual 129	java/io/OutputStream:flush	()V
    //   156: aload_0
    //   157: invokevirtual 133	java/net/HttpURLConnection:getResponseCode	()I
    //   160: istore 6
    //   162: aload_0
    //   163: invokevirtual 137	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   166: astore_1
    //   167: new 139	java/io/ByteArrayOutputStream
    //   170: dup
    //   171: invokespecial 140	java/io/ByteArrayOutputStream:<init>	()V
    //   174: astore 11
    //   176: aload_0
    //   177: astore_3
    //   178: aload_2
    //   179: astore 4
    //   181: aload_1
    //   182: astore 8
    //   184: aload 11
    //   186: astore 9
    //   188: sipush 1024
    //   191: newarray byte
    //   193: astore 10
    //   195: aload_0
    //   196: astore_3
    //   197: aload_2
    //   198: astore 4
    //   200: aload_1
    //   201: astore 8
    //   203: aload 11
    //   205: astore 9
    //   207: aload_1
    //   208: aload 10
    //   210: invokevirtual 146	java/io/InputStream:read	([B)I
    //   213: istore 7
    //   215: iload 7
    //   217: iconst_m1
    //   218: if_icmpeq +28 -> 246
    //   221: aload_0
    //   222: astore_3
    //   223: aload_2
    //   224: astore 4
    //   226: aload_1
    //   227: astore 8
    //   229: aload 11
    //   231: astore 9
    //   233: aload 11
    //   235: aload 10
    //   237: iconst_0
    //   238: iload 7
    //   240: invokevirtual 149	java/io/ByteArrayOutputStream:write	([BII)V
    //   243: goto -48 -> 195
    //   246: aload_0
    //   247: astore_3
    //   248: aload_2
    //   249: astore 4
    //   251: aload_1
    //   252: astore 8
    //   254: aload 11
    //   256: astore 9
    //   258: aload 5
    //   260: iload 6
    //   262: aload 11
    //   264: invokevirtual 152	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   267: invokevirtual 157	com/tencent/mobileqq/apollo/utils/ApolloHttpCallBack:a	(I[B)V
    //   270: aload_0
    //   271: ifnull +7 -> 278
    //   274: aload_0
    //   275: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   278: aload_2
    //   279: ifnull +22 -> 301
    //   282: aload_2
    //   283: invokevirtual 163	java/io/OutputStream:close	()V
    //   286: goto +15 -> 301
    //   289: astore_0
    //   290: ldc 48
    //   292: iconst_1
    //   293: aload_0
    //   294: iconst_0
    //   295: anewarray 4	java/lang/Object
    //   298: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   301: aload_1
    //   302: ifnull +22 -> 324
    //   305: aload_1
    //   306: invokevirtual 168	java/io/InputStream:close	()V
    //   309: goto +15 -> 324
    //   312: astore_0
    //   313: ldc 48
    //   315: iconst_1
    //   316: aload_0
    //   317: iconst_0
    //   318: anewarray 4	java/lang/Object
    //   321: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   324: aload 11
    //   326: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   329: return
    //   330: astore 4
    //   332: aconst_null
    //   333: astore 5
    //   335: aload_0
    //   336: astore_3
    //   337: aload 4
    //   339: astore_0
    //   340: aload_2
    //   341: astore 4
    //   343: aload 5
    //   345: astore_2
    //   346: goto +181 -> 527
    //   349: aconst_null
    //   350: astore_3
    //   351: aload_0
    //   352: astore 10
    //   354: aload_3
    //   355: astore_0
    //   356: goto +74 -> 430
    //   359: astore 4
    //   361: aconst_null
    //   362: astore_1
    //   363: aload_1
    //   364: astore 5
    //   366: aload_0
    //   367: astore_3
    //   368: aload 4
    //   370: astore_0
    //   371: aload_2
    //   372: astore 4
    //   374: aload 5
    //   376: astore_2
    //   377: goto +150 -> 527
    //   380: aconst_null
    //   381: astore_1
    //   382: aload_0
    //   383: astore 10
    //   385: goto +43 -> 428
    //   388: astore_2
    //   389: aload_0
    //   390: astore_1
    //   391: aload_2
    //   392: astore_0
    //   393: goto +9 -> 402
    //   396: goto +25 -> 421
    //   399: astore_0
    //   400: aconst_null
    //   401: astore_1
    //   402: aconst_null
    //   403: astore 5
    //   405: aconst_null
    //   406: astore_2
    //   407: aload 8
    //   409: astore 4
    //   411: aload_1
    //   412: astore_3
    //   413: aload 5
    //   415: astore_1
    //   416: goto +111 -> 527
    //   419: aconst_null
    //   420: astore_0
    //   421: aconst_null
    //   422: astore_2
    //   423: aconst_null
    //   424: astore_1
    //   425: aload_0
    //   426: astore 10
    //   428: aload_1
    //   429: astore_0
    //   430: aload 10
    //   432: astore_3
    //   433: aload_2
    //   434: astore 4
    //   436: aload_1
    //   437: astore 8
    //   439: aload_0
    //   440: astore 9
    //   442: aload 5
    //   444: iconst_m1
    //   445: aconst_null
    //   446: invokevirtual 157	com/tencent/mobileqq/apollo/utils/ApolloHttpCallBack:a	(I[B)V
    //   449: aload 10
    //   451: ifnull +8 -> 459
    //   454: aload 10
    //   456: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   459: aload_2
    //   460: ifnull +22 -> 482
    //   463: aload_2
    //   464: invokevirtual 163	java/io/OutputStream:close	()V
    //   467: goto +15 -> 482
    //   470: astore_2
    //   471: ldc 48
    //   473: iconst_1
    //   474: aload_2
    //   475: iconst_0
    //   476: anewarray 4	java/lang/Object
    //   479: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   482: aload_1
    //   483: ifnull +22 -> 505
    //   486: aload_1
    //   487: invokevirtual 168	java/io/InputStream:close	()V
    //   490: goto +15 -> 505
    //   493: astore_1
    //   494: ldc 48
    //   496: iconst_1
    //   497: aload_1
    //   498: iconst_0
    //   499: anewarray 4	java/lang/Object
    //   502: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   505: aload_0
    //   506: ifnull +13 -> 519
    //   509: aload_0
    //   510: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   513: return
    //   514: astore_0
    //   515: aload_0
    //   516: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   519: return
    //   520: astore_0
    //   521: aload 9
    //   523: astore_2
    //   524: aload 8
    //   526: astore_1
    //   527: aload_3
    //   528: ifnull +7 -> 535
    //   531: aload_3
    //   532: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   535: aload 4
    //   537: ifnull +23 -> 560
    //   540: aload 4
    //   542: invokevirtual 163	java/io/OutputStream:close	()V
    //   545: goto +15 -> 560
    //   548: astore_3
    //   549: ldc 48
    //   551: iconst_1
    //   552: aload_3
    //   553: iconst_0
    //   554: anewarray 4	java/lang/Object
    //   557: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   560: aload_1
    //   561: ifnull +22 -> 583
    //   564: aload_1
    //   565: invokevirtual 168	java/io/InputStream:close	()V
    //   568: goto +15 -> 583
    //   571: astore_1
    //   572: ldc 48
    //   574: iconst_1
    //   575: aload_1
    //   576: iconst_0
    //   577: anewarray 4	java/lang/Object
    //   580: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   583: aload_2
    //   584: ifnull +15 -> 599
    //   587: aload_2
    //   588: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   591: goto +8 -> 599
    //   594: astore_1
    //   595: aload_1
    //   596: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   599: goto +5 -> 604
    //   602: aload_0
    //   603: athrow
    //   604: goto -2 -> 602
    //   607: astore_0
    //   608: goto -189 -> 419
    //   611: astore_1
    //   612: goto -216 -> 396
    //   615: astore_1
    //   616: goto -236 -> 380
    //   619: astore_3
    //   620: goto -271 -> 349
    //   623: astore_3
    //   624: aload_0
    //   625: astore 10
    //   627: aload 11
    //   629: astore_0
    //   630: goto -200 -> 430
    //   633: iload 6
    //   635: iconst_1
    //   636: iadd
    //   637: istore 6
    //   639: goto -537 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	paramString1	String
    //   0	642	1	paramString2	String
    //   0	642	2	paramString3	String
    //   0	642	3	paramString4	String
    //   0	642	4	paramArrayOfString	String[]
    //   0	642	5	paramApolloHttpCallBack	ApolloHttpCallBack
    //   100	538	6	i	int
    //   213	26	7	j	int
    //   1	524	8	str	String
    //   34	488	9	localObject1	Object
    //   193	433	10	localObject2	Object
    //   174	454	11	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   282	286	289	java/io/IOException
    //   305	309	312	java/io/IOException
    //   167	176	330	finally
    //   144	167	359	finally
    //   18	36	388	finally
    //   41	57	388	finally
    //   57	97	388	finally
    //   102	110	388	finally
    //   126	136	388	finally
    //   139	144	388	finally
    //   3	18	399	finally
    //   463	467	470	java/io/IOException
    //   486	490	493	java/io/IOException
    //   324	329	514	java/io/IOException
    //   509	513	514	java/io/IOException
    //   188	195	520	finally
    //   207	215	520	finally
    //   233	243	520	finally
    //   258	270	520	finally
    //   442	449	520	finally
    //   540	545	548	java/io/IOException
    //   564	568	571	java/io/IOException
    //   587	591	594	java/io/IOException
    //   3	18	607	java/lang/Throwable
    //   18	36	611	java/lang/Throwable
    //   41	57	611	java/lang/Throwable
    //   57	97	611	java/lang/Throwable
    //   102	110	611	java/lang/Throwable
    //   126	136	611	java/lang/Throwable
    //   139	144	611	java/lang/Throwable
    //   144	167	615	java/lang/Throwable
    //   167	176	619	java/lang/Throwable
    //   188	195	623	java/lang/Throwable
    //   207	215	623	java/lang/Throwable
    //   233	243	623	java/lang/Throwable
    //   258	270	623	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, byte[] paramArrayOfByte, String[] paramArrayOfString, ApolloHttpCallBack paramApolloHttpCallBack)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 63	java/net/URL
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 66	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 70	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   14: checkcast 72	java/net/HttpURLConnection
    //   17: astore_1
    //   18: aload_1
    //   19: aload_0
    //   20: invokevirtual 77	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: instanceof 79
    //   27: ifeq +24 -> 51
    //   30: invokestatic 81	com/tencent/mobileqq/apollo/utils/ApolloHttpUtil:a	()Ljavax/net/ssl/SSLContext;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +16 -> 51
    //   38: aload_0
    //   39: invokevirtual 85	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   42: astore_0
    //   43: aload_1
    //   44: checkcast 79	javax/net/ssl/HttpsURLConnection
    //   47: aload_0
    //   48: invokevirtual 89	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   51: aload_1
    //   52: sipush 8000
    //   55: invokevirtual 93	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   58: aload_1
    //   59: sipush 8000
    //   62: invokevirtual 96	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   65: aload_1
    //   66: iconst_0
    //   67: invokevirtual 100	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   70: aconst_null
    //   71: astore_0
    //   72: iconst_0
    //   73: istore 5
    //   75: iload 5
    //   77: aload_3
    //   78: arraylength
    //   79: if_icmpge +30 -> 109
    //   82: iload 5
    //   84: iconst_2
    //   85: irem
    //   86: ifne +11 -> 97
    //   89: aload_3
    //   90: iload 5
    //   92: aaload
    //   93: astore_0
    //   94: goto +502 -> 596
    //   97: aload_1
    //   98: aload_0
    //   99: aload_3
    //   100: iload 5
    //   102: aaload
    //   103: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: goto +490 -> 596
    //   109: aload_1
    //   110: invokevirtual 114	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   113: astore_0
    //   114: aload_0
    //   115: aload_2
    //   116: invokevirtual 126	java/io/OutputStream:write	([B)V
    //   119: aload_0
    //   120: invokevirtual 129	java/io/OutputStream:flush	()V
    //   123: aload_1
    //   124: invokevirtual 133	java/net/HttpURLConnection:getResponseCode	()I
    //   127: istore 5
    //   129: aload_1
    //   130: invokevirtual 137	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   133: astore_3
    //   134: new 139	java/io/ByteArrayOutputStream
    //   137: dup
    //   138: invokespecial 140	java/io/ByteArrayOutputStream:<init>	()V
    //   141: astore_2
    //   142: aload_2
    //   143: astore 7
    //   145: aload_0
    //   146: astore 8
    //   148: aload_1
    //   149: astore 9
    //   151: aload_3
    //   152: astore 10
    //   154: sipush 1024
    //   157: newarray byte
    //   159: astore 11
    //   161: aload_2
    //   162: astore 7
    //   164: aload_0
    //   165: astore 8
    //   167: aload_1
    //   168: astore 9
    //   170: aload_3
    //   171: astore 10
    //   173: aload_3
    //   174: aload 11
    //   176: invokevirtual 146	java/io/InputStream:read	([B)I
    //   179: istore 6
    //   181: iload 6
    //   183: iconst_m1
    //   184: if_icmpeq +27 -> 211
    //   187: aload_2
    //   188: astore 7
    //   190: aload_0
    //   191: astore 8
    //   193: aload_1
    //   194: astore 9
    //   196: aload_3
    //   197: astore 10
    //   199: aload_2
    //   200: aload 11
    //   202: iconst_0
    //   203: iload 6
    //   205: invokevirtual 149	java/io/ByteArrayOutputStream:write	([BII)V
    //   208: goto -47 -> 161
    //   211: aload_2
    //   212: astore 7
    //   214: aload_0
    //   215: astore 8
    //   217: aload_1
    //   218: astore 9
    //   220: aload_3
    //   221: astore 10
    //   223: aload 4
    //   225: iload 5
    //   227: aload_2
    //   228: invokevirtual 152	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   231: invokevirtual 157	com/tencent/mobileqq/apollo/utils/ApolloHttpCallBack:a	(I[B)V
    //   234: aload_1
    //   235: ifnull +7 -> 242
    //   238: aload_1
    //   239: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   242: aload_0
    //   243: ifnull +22 -> 265
    //   246: aload_0
    //   247: invokevirtual 163	java/io/OutputStream:close	()V
    //   250: goto +15 -> 265
    //   253: astore_0
    //   254: ldc 48
    //   256: iconst_1
    //   257: aload_0
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   265: aload_3
    //   266: ifnull +22 -> 288
    //   269: aload_3
    //   270: invokevirtual 168	java/io/InputStream:close	()V
    //   273: goto +15 -> 288
    //   276: astore_0
    //   277: ldc 48
    //   279: iconst_1
    //   280: aload_0
    //   281: iconst_0
    //   282: anewarray 4	java/lang/Object
    //   285: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   288: aload_2
    //   289: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   292: return
    //   293: astore_0
    //   294: ldc 48
    //   296: iconst_1
    //   297: aload_0
    //   298: iconst_0
    //   299: anewarray 4	java/lang/Object
    //   302: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   305: return
    //   306: astore 4
    //   308: aconst_null
    //   309: astore_2
    //   310: aload_0
    //   311: astore 8
    //   313: aload_1
    //   314: astore 9
    //   316: aload 4
    //   318: astore_0
    //   319: aload_3
    //   320: astore_1
    //   321: goto +165 -> 486
    //   324: aconst_null
    //   325: astore_2
    //   326: goto +58 -> 384
    //   329: astore 4
    //   331: aconst_null
    //   332: astore_3
    //   333: aload_3
    //   334: astore_2
    //   335: aload_0
    //   336: astore 8
    //   338: aload_1
    //   339: astore 9
    //   341: aload 4
    //   343: astore_0
    //   344: aload_3
    //   345: astore_1
    //   346: goto +140 -> 486
    //   349: goto +31 -> 380
    //   352: astore_0
    //   353: goto +11 -> 364
    //   356: aconst_null
    //   357: astore_0
    //   358: goto +22 -> 380
    //   361: astore_0
    //   362: aconst_null
    //   363: astore_1
    //   364: aconst_null
    //   365: astore_3
    //   366: aconst_null
    //   367: astore_2
    //   368: aload_1
    //   369: astore 9
    //   371: aload_3
    //   372: astore_1
    //   373: goto +113 -> 486
    //   376: aconst_null
    //   377: astore_0
    //   378: aload_0
    //   379: astore_1
    //   380: aconst_null
    //   381: astore_3
    //   382: aconst_null
    //   383: astore_2
    //   384: aload_2
    //   385: astore 7
    //   387: aload_0
    //   388: astore 8
    //   390: aload_1
    //   391: astore 9
    //   393: aload_3
    //   394: astore 10
    //   396: aload 4
    //   398: iconst_m1
    //   399: aconst_null
    //   400: invokevirtual 157	com/tencent/mobileqq/apollo/utils/ApolloHttpCallBack:a	(I[B)V
    //   403: aload_1
    //   404: ifnull +7 -> 411
    //   407: aload_1
    //   408: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   411: aload_0
    //   412: ifnull +22 -> 434
    //   415: aload_0
    //   416: invokevirtual 163	java/io/OutputStream:close	()V
    //   419: goto +15 -> 434
    //   422: astore_0
    //   423: ldc 48
    //   425: iconst_1
    //   426: aload_0
    //   427: iconst_0
    //   428: anewarray 4	java/lang/Object
    //   431: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   434: aload_3
    //   435: ifnull +22 -> 457
    //   438: aload_3
    //   439: invokevirtual 168	java/io/InputStream:close	()V
    //   442: goto +15 -> 457
    //   445: astore_0
    //   446: ldc 48
    //   448: iconst_1
    //   449: aload_0
    //   450: iconst_0
    //   451: anewarray 4	java/lang/Object
    //   454: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   457: aload_2
    //   458: ifnull +20 -> 478
    //   461: aload_2
    //   462: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   465: return
    //   466: astore_0
    //   467: ldc 48
    //   469: iconst_1
    //   470: aload_0
    //   471: iconst_0
    //   472: anewarray 4	java/lang/Object
    //   475: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   478: return
    //   479: astore_0
    //   480: aload 10
    //   482: astore_1
    //   483: aload 7
    //   485: astore_2
    //   486: aload 9
    //   488: ifnull +8 -> 496
    //   491: aload 9
    //   493: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   496: aload 8
    //   498: ifnull +23 -> 521
    //   501: aload 8
    //   503: invokevirtual 163	java/io/OutputStream:close	()V
    //   506: goto +15 -> 521
    //   509: astore_3
    //   510: ldc 48
    //   512: iconst_1
    //   513: aload_3
    //   514: iconst_0
    //   515: anewarray 4	java/lang/Object
    //   518: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   521: aload_1
    //   522: ifnull +22 -> 544
    //   525: aload_1
    //   526: invokevirtual 168	java/io/InputStream:close	()V
    //   529: goto +15 -> 544
    //   532: astore_1
    //   533: ldc 48
    //   535: iconst_1
    //   536: aload_1
    //   537: iconst_0
    //   538: anewarray 4	java/lang/Object
    //   541: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   544: aload_2
    //   545: ifnull +22 -> 567
    //   548: aload_2
    //   549: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   552: goto +15 -> 567
    //   555: astore_1
    //   556: ldc 48
    //   558: iconst_1
    //   559: aload_1
    //   560: iconst_0
    //   561: anewarray 4	java/lang/Object
    //   564: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   567: goto +5 -> 572
    //   570: aload_0
    //   571: athrow
    //   572: goto -2 -> 570
    //   575: astore_0
    //   576: goto -200 -> 376
    //   579: astore_0
    //   580: goto -224 -> 356
    //   583: astore_2
    //   584: goto -235 -> 349
    //   587: astore_2
    //   588: goto -264 -> 324
    //   591: astore 7
    //   593: goto -209 -> 384
    //   596: iload 5
    //   598: iconst_1
    //   599: iadd
    //   600: istore 5
    //   602: goto -527 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	605	0	paramString1	String
    //   0	605	1	paramString2	String
    //   0	605	2	paramArrayOfByte	byte[]
    //   0	605	3	paramArrayOfString	String[]
    //   0	605	4	paramApolloHttpCallBack	ApolloHttpCallBack
    //   73	528	5	i	int
    //   179	25	6	j	int
    //   143	341	7	arrayOfByte1	byte[]
    //   591	1	7	localThrowable	Throwable
    //   1	501	8	str1	String
    //   149	343	9	str2	String
    //   152	329	10	arrayOfString	String[]
    //   159	42	11	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   246	250	253	java/io/IOException
    //   269	273	276	java/io/IOException
    //   288	292	293	java/io/IOException
    //   134	142	306	finally
    //   114	134	329	finally
    //   18	34	352	finally
    //   38	51	352	finally
    //   51	70	352	finally
    //   75	82	352	finally
    //   97	106	352	finally
    //   109	114	352	finally
    //   3	18	361	finally
    //   415	419	422	java/io/IOException
    //   438	442	445	java/io/IOException
    //   461	465	466	java/io/IOException
    //   154	161	479	finally
    //   173	181	479	finally
    //   199	208	479	finally
    //   223	234	479	finally
    //   396	403	479	finally
    //   501	506	509	java/io/IOException
    //   525	529	532	java/io/IOException
    //   548	552	555	java/io/IOException
    //   3	18	575	java/lang/Throwable
    //   18	34	579	java/lang/Throwable
    //   38	51	579	java/lang/Throwable
    //   51	70	579	java/lang/Throwable
    //   75	82	579	java/lang/Throwable
    //   97	106	579	java/lang/Throwable
    //   109	114	579	java/lang/Throwable
    //   114	134	583	java/lang/Throwable
    //   134	142	587	java/lang/Throwable
    //   154	161	591	java/lang/Throwable
    //   173	181	591	java/lang/Throwable
    //   199	208	591	java/lang/Throwable
    //   223	234	591	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String[] paramArrayOfString, ApolloHttpCallBack paramApolloHttpCallBack)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 63	java/net/URL
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 66	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 70	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   14: checkcast 72	java/net/HttpURLConnection
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 74
    //   21: invokevirtual 77	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: instanceof 79
    //   28: ifeq +29 -> 57
    //   31: invokestatic 81	com/tencent/mobileqq/apollo/utils/ApolloHttpUtil:a	()Ljavax/net/ssl/SSLContext;
    //   34: astore 6
    //   36: aload 6
    //   38: ifnull +19 -> 57
    //   41: aload 6
    //   43: invokevirtual 85	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   46: astore 6
    //   48: aload_0
    //   49: checkcast 79	javax/net/ssl/HttpsURLConnection
    //   52: aload 6
    //   54: invokevirtual 89	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   57: aload_0
    //   58: sipush 8000
    //   61: invokevirtual 93	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   64: aload_0
    //   65: sipush 8000
    //   68: invokevirtual 96	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   71: aload_0
    //   72: iconst_0
    //   73: invokevirtual 100	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   76: aconst_null
    //   77: astore 6
    //   79: iconst_0
    //   80: istore 4
    //   82: iload 4
    //   84: aload_2
    //   85: arraylength
    //   86: if_icmpge +32 -> 118
    //   89: iload 4
    //   91: iconst_2
    //   92: irem
    //   93: ifne +12 -> 105
    //   96: aload_2
    //   97: iload 4
    //   99: aaload
    //   100: astore 6
    //   102: goto +540 -> 642
    //   105: aload_0
    //   106: aload 6
    //   108: aload_2
    //   109: iload 4
    //   111: aaload
    //   112: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: goto +527 -> 642
    //   118: aload_0
    //   119: invokevirtual 114	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   122: astore_2
    //   123: aload_2
    //   124: aload_1
    //   125: invokevirtual 120	java/lang/String:getBytes	()[B
    //   128: invokevirtual 126	java/io/OutputStream:write	([B)V
    //   131: aload_2
    //   132: invokevirtual 129	java/io/OutputStream:flush	()V
    //   135: aload_0
    //   136: invokevirtual 133	java/net/HttpURLConnection:getResponseCode	()I
    //   139: istore 4
    //   141: aload_0
    //   142: invokevirtual 137	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   145: astore_1
    //   146: new 139	java/io/ByteArrayOutputStream
    //   149: dup
    //   150: invokespecial 140	java/io/ByteArrayOutputStream:<init>	()V
    //   153: astore 11
    //   155: aload_1
    //   156: astore 6
    //   158: aload 11
    //   160: astore 7
    //   162: aload_0
    //   163: astore 8
    //   165: aload_2
    //   166: astore 9
    //   168: sipush 1024
    //   171: newarray byte
    //   173: astore 10
    //   175: aload_1
    //   176: astore 6
    //   178: aload 11
    //   180: astore 7
    //   182: aload_0
    //   183: astore 8
    //   185: aload_2
    //   186: astore 9
    //   188: aload_1
    //   189: aload 10
    //   191: invokevirtual 146	java/io/InputStream:read	([B)I
    //   194: istore 5
    //   196: iload 5
    //   198: iconst_m1
    //   199: if_icmpeq +29 -> 228
    //   202: aload_1
    //   203: astore 6
    //   205: aload 11
    //   207: astore 7
    //   209: aload_0
    //   210: astore 8
    //   212: aload_2
    //   213: astore 9
    //   215: aload 11
    //   217: aload 10
    //   219: iconst_0
    //   220: iload 5
    //   222: invokevirtual 149	java/io/ByteArrayOutputStream:write	([BII)V
    //   225: goto -50 -> 175
    //   228: aload_1
    //   229: astore 6
    //   231: aload 11
    //   233: astore 7
    //   235: aload_0
    //   236: astore 8
    //   238: aload_2
    //   239: astore 9
    //   241: aload_3
    //   242: iload 4
    //   244: aload 11
    //   246: invokevirtual 152	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   249: invokevirtual 157	com/tencent/mobileqq/apollo/utils/ApolloHttpCallBack:a	(I[B)V
    //   252: aload_0
    //   253: ifnull +7 -> 260
    //   256: aload_0
    //   257: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   260: aload_2
    //   261: ifnull +22 -> 283
    //   264: aload_2
    //   265: invokevirtual 163	java/io/OutputStream:close	()V
    //   268: goto +15 -> 283
    //   271: astore_0
    //   272: ldc 48
    //   274: iconst_1
    //   275: aload_0
    //   276: iconst_0
    //   277: anewarray 4	java/lang/Object
    //   280: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   283: aload_1
    //   284: ifnull +22 -> 306
    //   287: aload_1
    //   288: invokevirtual 168	java/io/InputStream:close	()V
    //   291: goto +15 -> 306
    //   294: astore_0
    //   295: ldc 48
    //   297: iconst_1
    //   298: aload_0
    //   299: iconst_0
    //   300: anewarray 4	java/lang/Object
    //   303: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   306: aload 11
    //   308: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   311: return
    //   312: astore_0
    //   313: ldc 48
    //   315: iconst_1
    //   316: aload_0
    //   317: iconst_0
    //   318: anewarray 4	java/lang/Object
    //   321: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   324: return
    //   325: astore 6
    //   327: aconst_null
    //   328: astore_3
    //   329: aload_0
    //   330: astore 8
    //   332: aload 6
    //   334: astore_0
    //   335: goto +185 -> 520
    //   338: aconst_null
    //   339: astore 6
    //   341: aload_1
    //   342: astore 10
    //   344: aload 6
    //   346: astore_1
    //   347: goto +66 -> 413
    //   350: astore 6
    //   352: aconst_null
    //   353: astore_1
    //   354: aload_1
    //   355: astore_3
    //   356: aload_0
    //   357: astore 8
    //   359: aload 6
    //   361: astore_0
    //   362: goto +158 -> 520
    //   365: aconst_null
    //   366: astore 6
    //   368: goto +38 -> 406
    //   371: astore_2
    //   372: aload_0
    //   373: astore_1
    //   374: aload_2
    //   375: astore_0
    //   376: goto +9 -> 385
    //   379: goto +22 -> 401
    //   382: astore_0
    //   383: aconst_null
    //   384: astore_1
    //   385: aconst_null
    //   386: astore_2
    //   387: aconst_null
    //   388: astore_3
    //   389: aload 7
    //   391: astore 6
    //   393: aload_1
    //   394: astore 8
    //   396: goto +129 -> 525
    //   399: aconst_null
    //   400: astore_0
    //   401: aconst_null
    //   402: astore_2
    //   403: aconst_null
    //   404: astore 6
    //   406: aload 6
    //   408: astore_1
    //   409: aload 6
    //   411: astore 10
    //   413: aload 10
    //   415: astore 6
    //   417: aload_1
    //   418: astore 7
    //   420: aload_0
    //   421: astore 8
    //   423: aload_2
    //   424: astore 9
    //   426: aload_3
    //   427: iconst_m1
    //   428: aconst_null
    //   429: invokevirtual 157	com/tencent/mobileqq/apollo/utils/ApolloHttpCallBack:a	(I[B)V
    //   432: aload_0
    //   433: ifnull +7 -> 440
    //   436: aload_0
    //   437: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   440: aload_2
    //   441: ifnull +22 -> 463
    //   444: aload_2
    //   445: invokevirtual 163	java/io/OutputStream:close	()V
    //   448: goto +15 -> 463
    //   451: astore_0
    //   452: ldc 48
    //   454: iconst_1
    //   455: aload_0
    //   456: iconst_0
    //   457: anewarray 4	java/lang/Object
    //   460: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   463: aload 10
    //   465: ifnull +23 -> 488
    //   468: aload 10
    //   470: invokevirtual 168	java/io/InputStream:close	()V
    //   473: goto +15 -> 488
    //   476: astore_0
    //   477: ldc 48
    //   479: iconst_1
    //   480: aload_0
    //   481: iconst_0
    //   482: anewarray 4	java/lang/Object
    //   485: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   488: aload_1
    //   489: ifnull +20 -> 509
    //   492: aload_1
    //   493: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   496: return
    //   497: astore_0
    //   498: ldc 48
    //   500: iconst_1
    //   501: aload_0
    //   502: iconst_0
    //   503: anewarray 4	java/lang/Object
    //   506: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   509: return
    //   510: astore_0
    //   511: aload 9
    //   513: astore_2
    //   514: aload 7
    //   516: astore_3
    //   517: aload 6
    //   519: astore_1
    //   520: aload_2
    //   521: astore 6
    //   523: aload_1
    //   524: astore_2
    //   525: aload 8
    //   527: ifnull +8 -> 535
    //   530: aload 8
    //   532: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   535: aload 6
    //   537: ifnull +23 -> 560
    //   540: aload 6
    //   542: invokevirtual 163	java/io/OutputStream:close	()V
    //   545: goto +15 -> 560
    //   548: astore_1
    //   549: ldc 48
    //   551: iconst_1
    //   552: aload_1
    //   553: iconst_0
    //   554: anewarray 4	java/lang/Object
    //   557: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   560: aload_2
    //   561: ifnull +22 -> 583
    //   564: aload_2
    //   565: invokevirtual 168	java/io/InputStream:close	()V
    //   568: goto +15 -> 583
    //   571: astore_1
    //   572: ldc 48
    //   574: iconst_1
    //   575: aload_1
    //   576: iconst_0
    //   577: anewarray 4	java/lang/Object
    //   580: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   583: aload_3
    //   584: ifnull +22 -> 606
    //   587: aload_3
    //   588: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   591: goto +15 -> 606
    //   594: astore_1
    //   595: ldc 48
    //   597: iconst_1
    //   598: aload_1
    //   599: iconst_0
    //   600: anewarray 4	java/lang/Object
    //   603: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   606: goto +5 -> 611
    //   609: aload_0
    //   610: athrow
    //   611: goto -2 -> 609
    //   614: astore_0
    //   615: goto -216 -> 399
    //   618: astore_1
    //   619: goto -240 -> 379
    //   622: astore_1
    //   623: goto -258 -> 365
    //   626: astore 6
    //   628: goto -290 -> 338
    //   631: astore 6
    //   633: aload_1
    //   634: astore 10
    //   636: aload 11
    //   638: astore_1
    //   639: goto -226 -> 413
    //   642: iload 4
    //   644: iconst_1
    //   645: iadd
    //   646: istore 4
    //   648: goto -566 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	paramString1	String
    //   0	651	1	paramString2	String
    //   0	651	2	paramArrayOfString	String[]
    //   0	651	3	paramApolloHttpCallBack	ApolloHttpCallBack
    //   80	567	4	i	int
    //   194	27	5	j	int
    //   34	196	6	localObject1	Object
    //   325	8	6	localObject2	Object
    //   339	6	6	localObject3	Object
    //   350	10	6	localObject4	Object
    //   366	175	6	localObject5	Object
    //   626	1	6	localThrowable1	Throwable
    //   631	1	6	localThrowable2	Throwable
    //   1	514	7	localObject6	Object
    //   163	368	8	str	String
    //   166	346	9	arrayOfString	String[]
    //   173	462	10	localObject7	Object
    //   153	484	11	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   264	268	271	java/io/IOException
    //   287	291	294	java/io/IOException
    //   306	311	312	java/io/IOException
    //   146	155	325	finally
    //   123	146	350	finally
    //   18	36	371	finally
    //   41	57	371	finally
    //   57	76	371	finally
    //   82	89	371	finally
    //   105	115	371	finally
    //   118	123	371	finally
    //   3	18	382	finally
    //   444	448	451	java/io/IOException
    //   468	473	476	java/io/IOException
    //   492	496	497	java/io/IOException
    //   168	175	510	finally
    //   188	196	510	finally
    //   215	225	510	finally
    //   241	252	510	finally
    //   426	432	510	finally
    //   540	545	548	java/io/IOException
    //   564	568	571	java/io/IOException
    //   587	591	594	java/io/IOException
    //   3	18	614	java/lang/Throwable
    //   18	36	618	java/lang/Throwable
    //   41	57	618	java/lang/Throwable
    //   57	76	618	java/lang/Throwable
    //   82	89	618	java/lang/Throwable
    //   105	115	618	java/lang/Throwable
    //   118	123	618	java/lang/Throwable
    //   123	146	622	java/lang/Throwable
    //   146	155	626	java/lang/Throwable
    //   168	175	631	java/lang/Throwable
    //   188	196	631	java/lang/Throwable
    //   215	225	631	java/lang/Throwable
    //   241	252	631	java/lang/Throwable
  }
  
  public static void a(@NonNull String paramString1, @NonNull String paramString2, @Nullable String[] paramArrayOfString, @Nullable byte[] paramArrayOfByte, @NonNull ApolloHttpResponseCallback paramApolloHttpResponseCallback, @Nullable ApolloHttpProgressCallback paramApolloHttpProgressCallback1, @Nullable ApolloHttpProgressCallback paramApolloHttpProgressCallback2)
  {
    if (paramApolloHttpResponseCallback == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramApolloHttpResponseCallback.a(-1, null, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest urlString:", paramString1 });
    }
    int i = paramString1.indexOf("http://stubcmshow.qq.com/cm3d/");
    if (i >= 0) {
      paramString2 = paramString1.substring(i + 30);
    } else {
      paramString2 = paramString1;
    }
    i = paramString1.indexOf("https://stubcmshow.qq.com/cm3d/");
    if (i >= 0) {
      paramString2 = paramString1.substring(i + 31);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest localUrl:", paramString2 });
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramApolloHttpResponseCallback.a(-1, null, null);
      return;
    }
    try
    {
      boolean bool = paramString2.startsWith("Role:");
      int j;
      if (bool)
      {
        paramString1 = paramString2.substring(7);
        i = paramString1.indexOf("/");
        if (i > 0)
        {
          j = ApolloUtilImpl.parseToInt(paramString1.substring(0, i));
          paramString1 = paramString1.substring(i + 1);
          if (TextUtils.isEmpty(paramString1))
          {
            paramApolloHttpResponseCallback.a(-1, null, null);
            return;
          }
          paramString2 = new StringBuilder();
          paramString2.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
          paramString2.append(j);
          paramString2.append(File.separator);
          paramString2.append(paramString1);
          paramString1 = paramString2.toString();
          paramString2 = new File(paramString1);
          if (paramString2.exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest file exists:", paramString2.getAbsolutePath() });
            }
            paramArrayOfString = b(paramArrayOfString);
            if (a(paramString1))
            {
              paramString1 = b(paramString2, paramArrayOfString);
              paramApolloHttpResponseCallback.a(0, paramArrayOfString, paramString1);
              if (QLog.isColorLevel()) {
                QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retByteArray:", Integer.valueOf(paramString1.length) });
              }
            }
            else
            {
              paramApolloHttpResponseCallback.a(0, paramArrayOfString, b(new FileInputStream(paramString2)));
            }
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retHeader:", paramArrayOfString });
            }
          }
          else
          {
            paramString2 = new StringBuilder();
            paramString2.append("fakeResource3DUrlRequest start download id:");
            paramString2.append(j);
            QLog.d("[cmshow]ApolloHttpUtil", 1, paramString2.toString());
            ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(CmGameUtil.a(), null, new ApolloHttpUtil.1(paramString1, paramArrayOfString, paramApolloHttpResponseCallback), j, null, -1, -1, false);
          }
        }
      }
      else if (paramString2.startsWith("Dress:"))
      {
        paramString1 = paramString2.substring(8);
        i = paramString1.indexOf("/");
        if (i > 0)
        {
          j = ApolloUtilImpl.parseToInt(paramString1.substring(0, i));
          paramString1 = paramString1.substring(i + 1);
          if (TextUtils.isEmpty(paramString1))
          {
            paramApolloHttpResponseCallback.a(-1, null, null);
            return;
          }
          paramString2 = new StringBuilder();
          paramString2.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
          paramString2.append(j);
          paramString2.append(File.separator);
          paramString2.append(paramString1);
          paramString1 = paramString2.toString();
          paramString2 = new File(paramString1);
          if (paramString2.exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest file exists:", paramString2.getAbsolutePath() });
            }
            paramArrayOfString = b(paramArrayOfString);
            if (a(paramString1)) {
              paramApolloHttpResponseCallback.a(0, paramArrayOfString, b(paramString2, paramArrayOfString));
            } else {
              paramApolloHttpResponseCallback.a(0, paramArrayOfString, b(new FileInputStream(paramString2)));
            }
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retHeader:", paramArrayOfString });
            }
          }
          else
          {
            paramString2 = new StringBuilder();
            paramString2.append("fakeResource3DUrlRequest start download id:");
            paramString2.append(j);
            QLog.d("[cmshow]ApolloHttpUtil", 1, paramString2.toString());
            ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(CmGameUtil.a(), null, new ApolloHttpUtil.2(paramString1, paramArrayOfString, paramApolloHttpResponseCallback, j), -1, new int[] { j }, -1, -1, true);
          }
        }
      }
      else if (paramString2.startsWith("def/role/0/3D/"))
      {
        paramString1 = new StringBuilder();
        paramString1.append(ApolloConstant.a);
        paramString1.append(File.separator);
        paramString1.append(paramString2);
        paramString1 = paramString1.toString();
        paramString2 = new File(paramString1);
        if (paramString2.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest file exists:", paramString2.getAbsolutePath() });
          }
          paramArrayOfString = b(paramArrayOfString);
          if (a(paramString1)) {
            paramApolloHttpResponseCallback.a(0, paramArrayOfString, b(paramString2, paramArrayOfString));
          } else {
            paramApolloHttpResponseCallback.a(0, paramArrayOfString, b(new FileInputStream(paramString2)));
          }
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retHeader:", paramArrayOfString });
          }
        }
        else
        {
          QLog.d("[cmshow]ApolloHttpUtil", 1, new Object[] { "fakeResource3DUrlRequest file no exists", paramString2.getAbsolutePath() });
          return;
        }
      }
    }
    catch (Exception paramString1)
    {
      QLog.e("[cmshow]ApolloHttpUtil", 1, paramString1, new Object[0]);
    }
  }
  
  /* Error */
  public static void a(String paramString, String[] paramArrayOfString, ApolloHttpCallBack paramApolloHttpCallBack)
  {
    // Byte code:
    //   0: new 36	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 317
    //   7: invokespecial 318	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: astore 10
    //   12: aload 10
    //   14: aload_0
    //   15: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aconst_null
    //   20: astore 7
    //   22: new 63	java/net/URL
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 66	java/net/URL:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 70	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   33: checkcast 72	java/net/HttpURLConnection
    //   36: astore_0
    //   37: sipush -255
    //   40: invokestatic 323	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   43: aload_0
    //   44: ldc_w 325
    //   47: invokevirtual 77	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: instanceof 79
    //   54: ifeq +50 -> 104
    //   57: invokestatic 81	com/tencent/mobileqq/apollo/utils/ApolloHttpUtil:a	()Ljavax/net/ssl/SSLContext;
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +31 -> 95
    //   67: aload 5
    //   69: invokevirtual 85	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   72: astore 5
    //   74: aload_0
    //   75: checkcast 79	javax/net/ssl/HttpsURLConnection
    //   78: aload 5
    //   80: invokevirtual 89	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   83: aload 10
    //   85: ldc_w 327
    //   88: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: goto +12 -> 104
    //   95: aload 10
    //   97: ldc_w 329
    //   100: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_0
    //   105: sipush 8000
    //   108: invokevirtual 93	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   111: aload_0
    //   112: sipush 8000
    //   115: invokevirtual 96	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   118: aload_1
    //   119: ifnull +40 -> 159
    //   122: aconst_null
    //   123: astore 5
    //   125: iconst_0
    //   126: istore_3
    //   127: iload_3
    //   128: aload_1
    //   129: arraylength
    //   130: if_icmpge +29 -> 159
    //   133: iload_3
    //   134: iconst_2
    //   135: irem
    //   136: ifne +11 -> 147
    //   139: aload_1
    //   140: iload_3
    //   141: aaload
    //   142: astore 5
    //   144: goto +507 -> 651
    //   147: aload_0
    //   148: aload 5
    //   150: aload_1
    //   151: iload_3
    //   152: aaload
    //   153: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto +495 -> 651
    //   159: aload_0
    //   160: invokevirtual 133	java/net/HttpURLConnection:getResponseCode	()I
    //   163: istore_3
    //   164: aload 10
    //   166: ldc_w 331
    //   169: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 10
    //   175: iload_3
    //   176: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 10
    //   182: ldc_w 333
    //   185: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 10
    //   191: aload_0
    //   192: invokevirtual 337	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   195: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_0
    //   200: invokevirtual 137	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   203: astore_1
    //   204: new 139	java/io/ByteArrayOutputStream
    //   207: dup
    //   208: invokespecial 140	java/io/ByteArrayOutputStream:<init>	()V
    //   211: astore 9
    //   213: aload_1
    //   214: astore 5
    //   216: aload 9
    //   218: astore 6
    //   220: aload_0
    //   221: astore 7
    //   223: sipush 1024
    //   226: newarray byte
    //   228: astore 8
    //   230: aload_1
    //   231: astore 5
    //   233: aload 9
    //   235: astore 6
    //   237: aload_0
    //   238: astore 7
    //   240: aload_1
    //   241: aload 8
    //   243: invokevirtual 146	java/io/InputStream:read	([B)I
    //   246: istore 4
    //   248: iload 4
    //   250: iconst_m1
    //   251: if_icmpeq +26 -> 277
    //   254: aload_1
    //   255: astore 5
    //   257: aload 9
    //   259: astore 6
    //   261: aload_0
    //   262: astore 7
    //   264: aload 9
    //   266: aload 8
    //   268: iconst_0
    //   269: iload 4
    //   271: invokevirtual 149	java/io/ByteArrayOutputStream:write	([BII)V
    //   274: goto -44 -> 230
    //   277: aload_1
    //   278: astore 5
    //   280: aload 9
    //   282: astore 6
    //   284: aload_0
    //   285: astore 7
    //   287: aload 10
    //   289: ldc_w 339
    //   292: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_1
    //   297: astore 5
    //   299: aload 9
    //   301: astore 6
    //   303: aload_0
    //   304: astore 7
    //   306: aload 10
    //   308: aload 9
    //   310: invokevirtual 342	java/io/ByteArrayOutputStream:size	()I
    //   313: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_2
    //   318: ifnull +23 -> 341
    //   321: aload_1
    //   322: astore 5
    //   324: aload 9
    //   326: astore 6
    //   328: aload_0
    //   329: astore 7
    //   331: aload_2
    //   332: iload_3
    //   333: aload 9
    //   335: invokevirtual 152	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   338: invokevirtual 157	com/tencent/mobileqq/apollo/utils/ApolloHttpCallBack:a	(I[B)V
    //   341: aload_0
    //   342: ifnull +7 -> 349
    //   345: aload_0
    //   346: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   349: aload_1
    //   350: ifnull +22 -> 372
    //   353: aload_1
    //   354: invokevirtual 168	java/io/InputStream:close	()V
    //   357: goto +15 -> 372
    //   360: astore_0
    //   361: ldc 48
    //   363: iconst_1
    //   364: aload_0
    //   365: iconst_0
    //   366: anewarray 4	java/lang/Object
    //   369: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   372: aload 9
    //   374: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   377: goto +241 -> 618
    //   380: astore_0
    //   381: ldc 48
    //   383: iconst_1
    //   384: aload_0
    //   385: iconst_0
    //   386: anewarray 4	java/lang/Object
    //   389: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   392: goto +226 -> 618
    //   395: aload_1
    //   396: astore 8
    //   398: aload 9
    //   400: astore_1
    //   401: goto +59 -> 460
    //   404: astore_2
    //   405: aconst_null
    //   406: astore 6
    //   408: aload_1
    //   409: astore 5
    //   411: aload_2
    //   412: astore_1
    //   413: goto +74 -> 487
    //   416: aconst_null
    //   417: astore 5
    //   419: aload_1
    //   420: astore 8
    //   422: aload 5
    //   424: astore_1
    //   425: goto +35 -> 460
    //   428: astore_1
    //   429: aconst_null
    //   430: astore 6
    //   432: aload 7
    //   434: astore_2
    //   435: goto +55 -> 490
    //   438: goto +17 -> 455
    //   441: astore_1
    //   442: aconst_null
    //   443: astore_0
    //   444: aload_0
    //   445: astore 6
    //   447: aload 7
    //   449: astore_2
    //   450: goto +40 -> 490
    //   453: aconst_null
    //   454: astore_0
    //   455: aconst_null
    //   456: astore 8
    //   458: aconst_null
    //   459: astore_1
    //   460: aload_2
    //   461: ifnull +101 -> 562
    //   464: aload 8
    //   466: astore 5
    //   468: aload_1
    //   469: astore 6
    //   471: aload_0
    //   472: astore 7
    //   474: aload_2
    //   475: iconst_m1
    //   476: aconst_null
    //   477: invokevirtual 157	com/tencent/mobileqq/apollo/utils/ApolloHttpCallBack:a	(I[B)V
    //   480: goto +82 -> 562
    //   483: astore_1
    //   484: aload 7
    //   486: astore_0
    //   487: aload 5
    //   489: astore_2
    //   490: aload_0
    //   491: ifnull +7 -> 498
    //   494: aload_0
    //   495: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   498: aload_2
    //   499: ifnull +22 -> 521
    //   502: aload_2
    //   503: invokevirtual 168	java/io/InputStream:close	()V
    //   506: goto +15 -> 521
    //   509: astore_0
    //   510: ldc 48
    //   512: iconst_1
    //   513: aload_0
    //   514: iconst_0
    //   515: anewarray 4	java/lang/Object
    //   518: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   521: aload 6
    //   523: ifnull +23 -> 546
    //   526: aload 6
    //   528: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   531: goto +15 -> 546
    //   534: astore_0
    //   535: ldc 48
    //   537: iconst_1
    //   538: aload_0
    //   539: iconst_0
    //   540: anewarray 4	java/lang/Object
    //   543: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   546: invokestatic 345	android/net/TrafficStats:clearThreadStatsTag	()V
    //   549: ldc 48
    //   551: iconst_1
    //   552: aload 10
    //   554: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 348	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: aload_1
    //   561: athrow
    //   562: aload_0
    //   563: ifnull +7 -> 570
    //   566: aload_0
    //   567: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   570: aload 8
    //   572: ifnull +23 -> 595
    //   575: aload 8
    //   577: invokevirtual 168	java/io/InputStream:close	()V
    //   580: goto +15 -> 595
    //   583: astore_0
    //   584: ldc 48
    //   586: iconst_1
    //   587: aload_0
    //   588: iconst_0
    //   589: anewarray 4	java/lang/Object
    //   592: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   595: aload_1
    //   596: ifnull +22 -> 618
    //   599: aload_1
    //   600: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   603: goto +15 -> 618
    //   606: astore_0
    //   607: ldc 48
    //   609: iconst_1
    //   610: aload_0
    //   611: iconst_0
    //   612: anewarray 4	java/lang/Object
    //   615: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   618: invokestatic 345	android/net/TrafficStats:clearThreadStatsTag	()V
    //   621: ldc 48
    //   623: iconst_1
    //   624: aload 10
    //   626: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 348	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: return
    //   633: astore_0
    //   634: goto -181 -> 453
    //   637: astore_1
    //   638: goto -200 -> 438
    //   641: astore 5
    //   643: goto -227 -> 416
    //   646: astore 5
    //   648: goto -253 -> 395
    //   651: iload_3
    //   652: iconst_1
    //   653: iadd
    //   654: istore_3
    //   655: goto -528 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	658	0	paramString	String
    //   0	658	1	paramArrayOfString	String[]
    //   0	658	2	paramApolloHttpCallBack	ApolloHttpCallBack
    //   126	529	3	i	int
    //   246	24	4	j	int
    //   60	428	5	localObject1	Object
    //   641	1	5	localException1	Exception
    //   646	1	5	localException2	Exception
    //   218	309	6	localObject2	Object
    //   20	465	7	str	String
    //   228	348	8	localObject3	Object
    //   211	188	9	localByteArrayOutputStream	ByteArrayOutputStream
    //   10	615	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   353	357	360	java/io/IOException
    //   372	377	380	java/io/IOException
    //   204	213	404	finally
    //   37	62	428	finally
    //   67	92	428	finally
    //   95	104	428	finally
    //   104	118	428	finally
    //   127	133	428	finally
    //   147	156	428	finally
    //   159	204	428	finally
    //   22	37	441	finally
    //   223	230	483	finally
    //   240	248	483	finally
    //   264	274	483	finally
    //   287	296	483	finally
    //   306	317	483	finally
    //   331	341	483	finally
    //   474	480	483	finally
    //   502	506	509	java/io/IOException
    //   526	531	534	java/io/IOException
    //   575	580	583	java/io/IOException
    //   599	603	606	java/io/IOException
    //   22	37	633	java/lang/Exception
    //   37	62	637	java/lang/Exception
    //   67	92	637	java/lang/Exception
    //   95	104	637	java/lang/Exception
    //   104	118	637	java/lang/Exception
    //   127	133	637	java/lang/Exception
    //   147	156	637	java/lang/Exception
    //   159	204	637	java/lang/Exception
    //   204	213	641	java/lang/Exception
    //   223	230	646	java/lang/Exception
    //   240	248	646	java/lang/Exception
    //   264	274	646	java/lang/Exception
    //   287	296	646	java/lang/Exception
    //   306	317	646	java/lang/Exception
    //   331	341	646	java/lang/Exception
  }
  
  static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return (paramString.endsWith(".jpg")) || (paramString.endsWith(".png"));
  }
  
  private static byte[] a(@NonNull HttpURLConnection paramHttpURLConnection, @Nullable ApolloHttpProgressCallback paramApolloHttpProgressCallback)
  {
    ByteArrayOutputStream localByteArrayOutputStream = null;
    localObject1 = localByteArrayOutputStream;
    for (;;)
    {
      try
      {
        i = paramHttpURLConnection.getContentLength();
        localObject1 = localByteArrayOutputStream;
      }
      finally
      {
        int i;
        Object localObject2;
        if (localObject1 != null) {
          try
          {
            ((InputStream)localObject1).close();
          }
          catch (IOException paramApolloHttpProgressCallback)
          {
            paramApolloHttpProgressCallback.printStackTrace();
          }
        }
        continue;
        throw paramHttpURLConnection;
        continue;
      }
      try
      {
        localObject2 = paramHttpURLConnection.getInputStream();
        paramHttpURLConnection = (HttpURLConnection)localObject2;
      }
      catch (IOException localIOException)
      {
        continue;
      }
      localObject1 = localByteArrayOutputStream;
      paramHttpURLConnection = paramHttpURLConnection.getErrorStream();
    }
    if (paramHttpURLConnection == null)
    {
      localObject1 = paramHttpURLConnection;
      paramApolloHttpProgressCallback = new byte[0];
      if (paramHttpURLConnection != null) {
        try
        {
          paramHttpURLConnection.close();
          return paramApolloHttpProgressCallback;
        }
        catch (IOException paramHttpURLConnection)
        {
          paramHttpURLConnection.printStackTrace();
        }
      }
      return paramApolloHttpProgressCallback;
    }
    localObject1 = paramHttpURLConnection;
    localByteArrayOutputStream = new ByteArrayOutputStream();
    localObject1 = paramHttpURLConnection;
    localObject2 = new byte[1024];
    for (;;)
    {
      localObject1 = paramHttpURLConnection;
      int j = paramHttpURLConnection.read((byte[])localObject2);
      if (j == -1) {
        break;
      }
      localObject1 = paramHttpURLConnection;
      localByteArrayOutputStream.write((byte[])localObject2, 0, j);
      if (paramApolloHttpProgressCallback != null)
      {
        localObject1 = paramHttpURLConnection;
        paramApolloHttpProgressCallback.a(localByteArrayOutputStream.size(), i);
      }
    }
    localObject1 = paramHttpURLConnection;
    paramApolloHttpProgressCallback = localByteArrayOutputStream.toByteArray();
    if (paramHttpURLConnection != null) {
      try
      {
        paramHttpURLConnection.close();
        return paramApolloHttpProgressCallback;
      }
      catch (IOException paramHttpURLConnection)
      {
        paramHttpURLConnection.printStackTrace();
      }
    }
    return paramApolloHttpProgressCallback;
  }
  
  private static HashMap<String, String> b(String[] paramArrayOfString)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayOfString != null)
    {
      String str = null;
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if ((i & 0x1) == 0) {
          str = paramArrayOfString[i];
        } else {
          localHashMap.put(str, paramArrayOfString[i]);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  /* Error */
  public static void b(@NonNull String paramString1, @NonNull String paramString2, @Nullable String[] paramArrayOfString, @Nullable byte[] paramArrayOfByte, @NonNull ApolloHttpResponseCallback paramApolloHttpResponseCallback, @Nullable ApolloHttpProgressCallback paramApolloHttpProgressCallback1, @Nullable ApolloHttpProgressCallback paramApolloHttpProgressCallback2)
  {
    // Byte code:
    //   0: new 369	java/util/HashMap
    //   3: dup
    //   4: invokespecial 370	java/util/HashMap:<init>	()V
    //   7: astore 22
    //   9: new 378	java/lang/StringBuffer
    //   12: dup
    //   13: ldc_w 380
    //   16: invokespecial 381	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   19: astore 21
    //   21: aload 21
    //   23: aload_0
    //   24: invokevirtual 384	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   27: pop
    //   28: aconst_null
    //   29: astore 17
    //   31: aconst_null
    //   32: astore 18
    //   34: aconst_null
    //   35: astore 15
    //   37: aconst_null
    //   38: astore 16
    //   40: aconst_null
    //   41: astore 19
    //   43: aconst_null
    //   44: astore 14
    //   46: aconst_null
    //   47: astore 20
    //   49: iconst_m1
    //   50: istore 7
    //   52: new 63	java/net/URL
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 66	java/net/URL:<init>	(Ljava/lang/String;)V
    //   60: invokevirtual 70	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   63: checkcast 72	java/net/HttpURLConnection
    //   66: astore 13
    //   68: aload 17
    //   70: astore 15
    //   72: iload 7
    //   74: istore 8
    //   76: aload 18
    //   78: astore 16
    //   80: iload 7
    //   82: istore 9
    //   84: aload 19
    //   86: astore_0
    //   87: aload 13
    //   89: astore 14
    //   91: aload 13
    //   93: instanceof 79
    //   96: ifeq +198 -> 294
    //   99: aload 17
    //   101: astore 15
    //   103: iload 7
    //   105: istore 8
    //   107: aload 18
    //   109: astore 16
    //   111: iload 7
    //   113: istore 9
    //   115: aload 19
    //   117: astore_0
    //   118: aload 13
    //   120: astore 14
    //   122: invokestatic 81	com/tencent/mobileqq/apollo/utils/ApolloHttpUtil:a	()Ljavax/net/ssl/SSLContext;
    //   125: astore 23
    //   127: aload 23
    //   129: ifnull +101 -> 230
    //   132: aload 17
    //   134: astore 15
    //   136: iload 7
    //   138: istore 8
    //   140: aload 18
    //   142: astore 16
    //   144: iload 7
    //   146: istore 9
    //   148: aload 19
    //   150: astore_0
    //   151: aload 13
    //   153: astore 14
    //   155: aload 23
    //   157: invokevirtual 85	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   160: astore 23
    //   162: aload 17
    //   164: astore 15
    //   166: iload 7
    //   168: istore 8
    //   170: aload 18
    //   172: astore 16
    //   174: iload 7
    //   176: istore 9
    //   178: aload 19
    //   180: astore_0
    //   181: aload 13
    //   183: astore 14
    //   185: aload 13
    //   187: checkcast 79	javax/net/ssl/HttpsURLConnection
    //   190: aload 23
    //   192: invokevirtual 89	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   195: aload 17
    //   197: astore 15
    //   199: iload 7
    //   201: istore 8
    //   203: aload 18
    //   205: astore 16
    //   207: iload 7
    //   209: istore 9
    //   211: aload 19
    //   213: astore_0
    //   214: aload 13
    //   216: astore 14
    //   218: aload 21
    //   220: ldc_w 386
    //   223: invokevirtual 384	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   226: pop
    //   227: goto +67 -> 294
    //   230: aload 17
    //   232: astore 15
    //   234: iload 7
    //   236: istore 8
    //   238: aload 18
    //   240: astore 16
    //   242: iload 7
    //   244: istore 9
    //   246: aload 19
    //   248: astore_0
    //   249: aload 13
    //   251: astore 14
    //   253: aload 21
    //   255: ldc_w 388
    //   258: invokevirtual 384	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   261: pop
    //   262: aload 17
    //   264: astore 15
    //   266: iload 7
    //   268: istore 8
    //   270: aload 18
    //   272: astore 16
    //   274: iload 7
    //   276: istore 9
    //   278: aload 19
    //   280: astore_0
    //   281: aload 13
    //   283: astore 14
    //   285: ldc 48
    //   287: iconst_1
    //   288: ldc_w 390
    //   291: invokestatic 392	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: aload 17
    //   296: astore 15
    //   298: iload 7
    //   300: istore 8
    //   302: aload 18
    //   304: astore 16
    //   306: iload 7
    //   308: istore 9
    //   310: aload 19
    //   312: astore_0
    //   313: aload 13
    //   315: astore 14
    //   317: aload 13
    //   319: aload_1
    //   320: invokevirtual 77	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   323: aload 17
    //   325: astore 15
    //   327: iload 7
    //   329: istore 8
    //   331: aload 18
    //   333: astore 16
    //   335: iload 7
    //   337: istore 9
    //   339: aload 19
    //   341: astore_0
    //   342: aload 13
    //   344: astore 14
    //   346: aload 13
    //   348: sipush 10000
    //   351: invokevirtual 93	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   354: aload 17
    //   356: astore 15
    //   358: iload 7
    //   360: istore 8
    //   362: aload 18
    //   364: astore 16
    //   366: iload 7
    //   368: istore 9
    //   370: aload 19
    //   372: astore_0
    //   373: aload 13
    //   375: astore 14
    //   377: aload 13
    //   379: sipush 10000
    //   382: invokevirtual 96	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   385: aload 17
    //   387: astore 15
    //   389: iload 7
    //   391: istore 8
    //   393: aload 18
    //   395: astore 16
    //   397: iload 7
    //   399: istore 9
    //   401: aload 19
    //   403: astore_0
    //   404: aload 13
    //   406: astore 14
    //   408: aload 13
    //   410: iconst_1
    //   411: invokevirtual 395	java/net/HttpURLConnection:setDoInput	(Z)V
    //   414: iconst_0
    //   415: istore 11
    //   417: aload 17
    //   419: astore 15
    //   421: iload 7
    //   423: istore 8
    //   425: aload 18
    //   427: astore 16
    //   429: iload 7
    //   431: istore 9
    //   433: aload 19
    //   435: astore_0
    //   436: aload 13
    //   438: astore 14
    //   440: aload 13
    //   442: iconst_0
    //   443: invokevirtual 100	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   446: aload_2
    //   447: ifnull +89 -> 536
    //   450: aconst_null
    //   451: astore_1
    //   452: iconst_0
    //   453: istore 10
    //   455: aload 17
    //   457: astore 15
    //   459: iload 7
    //   461: istore 8
    //   463: aload 18
    //   465: astore 16
    //   467: iload 7
    //   469: istore 9
    //   471: aload 19
    //   473: astore_0
    //   474: aload 13
    //   476: astore 14
    //   478: iload 10
    //   480: aload_2
    //   481: arraylength
    //   482: if_icmpge +54 -> 536
    //   485: iload 10
    //   487: iconst_1
    //   488: iand
    //   489: ifne +11 -> 500
    //   492: aload_2
    //   493: iload 10
    //   495: aaload
    //   496: astore_1
    //   497: goto +1225 -> 1722
    //   500: aload 17
    //   502: astore 15
    //   504: iload 7
    //   506: istore 8
    //   508: aload 18
    //   510: astore 16
    //   512: iload 7
    //   514: istore 9
    //   516: aload 19
    //   518: astore_0
    //   519: aload 13
    //   521: astore 14
    //   523: aload 13
    //   525: aload_1
    //   526: aload_2
    //   527: iload 10
    //   529: aaload
    //   530: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: goto +1189 -> 1722
    //   536: aload 20
    //   538: astore_1
    //   539: aload_3
    //   540: ifnull +329 -> 869
    //   543: aload 17
    //   545: astore 15
    //   547: iload 7
    //   549: istore 8
    //   551: aload 18
    //   553: astore 16
    //   555: iload 7
    //   557: istore 9
    //   559: aload 19
    //   561: astore_0
    //   562: aload 13
    //   564: astore 14
    //   566: aload 21
    //   568: ldc_w 397
    //   571: invokevirtual 384	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   574: pop
    //   575: aload 17
    //   577: astore 15
    //   579: iload 7
    //   581: istore 8
    //   583: aload 18
    //   585: astore 16
    //   587: iload 7
    //   589: istore 9
    //   591: aload 19
    //   593: astore_0
    //   594: aload 13
    //   596: astore 14
    //   598: aload 21
    //   600: aload_3
    //   601: arraylength
    //   602: invokevirtual 400	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   605: pop
    //   606: aload 17
    //   608: astore 15
    //   610: iload 7
    //   612: istore 8
    //   614: aload 18
    //   616: astore 16
    //   618: iload 7
    //   620: istore 9
    //   622: aload 19
    //   624: astore_0
    //   625: aload 13
    //   627: astore 14
    //   629: aload 13
    //   631: iconst_1
    //   632: invokevirtual 403	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   635: aload 17
    //   637: astore 15
    //   639: iload 7
    //   641: istore 8
    //   643: aload 18
    //   645: astore 16
    //   647: iload 7
    //   649: istore 9
    //   651: aload 19
    //   653: astore_0
    //   654: aload 13
    //   656: astore 14
    //   658: aload 13
    //   660: aload_3
    //   661: arraylength
    //   662: invokevirtual 406	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   665: aload 17
    //   667: astore 15
    //   669: iload 7
    //   671: istore 8
    //   673: aload 18
    //   675: astore 16
    //   677: iload 7
    //   679: istore 9
    //   681: aload 19
    //   683: astore_0
    //   684: aload 13
    //   686: astore 14
    //   688: aload 13
    //   690: invokevirtual 114	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   693: astore_1
    //   694: aload_1
    //   695: astore 15
    //   697: iload 7
    //   699: istore 8
    //   701: aload_1
    //   702: astore 16
    //   704: iload 7
    //   706: istore 9
    //   708: aload_1
    //   709: astore_0
    //   710: aload 13
    //   712: astore 14
    //   714: aload_3
    //   715: arraylength
    //   716: istore 12
    //   718: iload 11
    //   720: istore 10
    //   722: iload 10
    //   724: iload 12
    //   726: if_icmpge +119 -> 845
    //   729: aload_1
    //   730: astore 15
    //   732: iload 7
    //   734: istore 8
    //   736: aload_1
    //   737: astore 16
    //   739: iload 7
    //   741: istore 9
    //   743: aload_1
    //   744: astore_0
    //   745: aload 13
    //   747: astore 14
    //   749: sipush 4096
    //   752: iload 12
    //   754: iload 10
    //   756: isub
    //   757: invokestatic 412	java/lang/Math:min	(II)I
    //   760: istore 11
    //   762: aload_1
    //   763: astore 15
    //   765: iload 7
    //   767: istore 8
    //   769: aload_1
    //   770: astore 16
    //   772: iload 7
    //   774: istore 9
    //   776: aload_1
    //   777: astore_0
    //   778: aload 13
    //   780: astore 14
    //   782: aload_1
    //   783: aload_3
    //   784: iload 10
    //   786: iload 11
    //   788: invokevirtual 413	java/io/OutputStream:write	([BII)V
    //   791: iload 10
    //   793: iload 11
    //   795: iadd
    //   796: istore 11
    //   798: iload 11
    //   800: istore 10
    //   802: aload 5
    //   804: ifnull -82 -> 722
    //   807: aload_1
    //   808: astore 15
    //   810: iload 7
    //   812: istore 8
    //   814: aload_1
    //   815: astore 16
    //   817: iload 7
    //   819: istore 9
    //   821: aload_1
    //   822: astore_0
    //   823: aload 13
    //   825: astore 14
    //   827: aload 5
    //   829: iload 11
    //   831: iload 12
    //   833: invokeinterface 367 3 0
    //   838: iload 11
    //   840: istore 10
    //   842: goto -120 -> 722
    //   845: aload_1
    //   846: astore 15
    //   848: iload 7
    //   850: istore 8
    //   852: aload_1
    //   853: astore 16
    //   855: iload 7
    //   857: istore 9
    //   859: aload_1
    //   860: astore_0
    //   861: aload 13
    //   863: astore 14
    //   865: aload_1
    //   866: invokevirtual 129	java/io/OutputStream:flush	()V
    //   869: aload_1
    //   870: astore 15
    //   872: iload 7
    //   874: istore 8
    //   876: aload_1
    //   877: astore 16
    //   879: iload 7
    //   881: istore 9
    //   883: aload_1
    //   884: astore_0
    //   885: aload 13
    //   887: astore 14
    //   889: aload 13
    //   891: invokevirtual 133	java/net/HttpURLConnection:getResponseCode	()I
    //   894: istore 7
    //   896: aload_1
    //   897: astore 15
    //   899: iload 7
    //   901: istore 8
    //   903: aload_1
    //   904: astore 16
    //   906: iload 7
    //   908: istore 9
    //   910: aload_1
    //   911: astore_0
    //   912: aload 13
    //   914: astore 14
    //   916: aload 13
    //   918: invokevirtual 337	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   921: astore_2
    //   922: aload_1
    //   923: astore 15
    //   925: iload 7
    //   927: istore 8
    //   929: aload_1
    //   930: astore 16
    //   932: iload 7
    //   934: istore 9
    //   936: aload_1
    //   937: astore_0
    //   938: aload 13
    //   940: astore 14
    //   942: aload 21
    //   944: ldc_w 415
    //   947: invokevirtual 384	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   950: pop
    //   951: aload_1
    //   952: astore 15
    //   954: iload 7
    //   956: istore 8
    //   958: aload_1
    //   959: astore 16
    //   961: iload 7
    //   963: istore 9
    //   965: aload_1
    //   966: astore_0
    //   967: aload 13
    //   969: astore 14
    //   971: aload 21
    //   973: iload 7
    //   975: invokevirtual 400	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   978: pop
    //   979: aload_1
    //   980: astore 15
    //   982: iload 7
    //   984: istore 8
    //   986: aload_1
    //   987: astore 16
    //   989: iload 7
    //   991: istore 9
    //   993: aload_1
    //   994: astore_0
    //   995: aload 13
    //   997: astore 14
    //   999: aload 21
    //   1001: ldc_w 333
    //   1004: invokevirtual 384	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1007: pop
    //   1008: aload_1
    //   1009: astore 15
    //   1011: iload 7
    //   1013: istore 8
    //   1015: aload_1
    //   1016: astore 16
    //   1018: iload 7
    //   1020: istore 9
    //   1022: aload_1
    //   1023: astore_0
    //   1024: aload 13
    //   1026: astore 14
    //   1028: aload 21
    //   1030: aload_2
    //   1031: invokevirtual 418	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   1034: pop
    //   1035: aload_1
    //   1036: astore 15
    //   1038: iload 7
    //   1040: istore 8
    //   1042: aload_1
    //   1043: astore 16
    //   1045: iload 7
    //   1047: istore 9
    //   1049: aload_1
    //   1050: astore_0
    //   1051: aload 13
    //   1053: astore 14
    //   1055: aload_2
    //   1056: invokeinterface 424 1 0
    //   1061: invokeinterface 430 1 0
    //   1066: astore_2
    //   1067: aload_1
    //   1068: astore 15
    //   1070: iload 7
    //   1072: istore 8
    //   1074: aload_1
    //   1075: astore 16
    //   1077: iload 7
    //   1079: istore 9
    //   1081: aload_1
    //   1082: astore_0
    //   1083: aload 13
    //   1085: astore 14
    //   1087: aload_2
    //   1088: invokeinterface 435 1 0
    //   1093: ifeq +144 -> 1237
    //   1096: aload_1
    //   1097: astore 15
    //   1099: iload 7
    //   1101: istore 8
    //   1103: aload_1
    //   1104: astore 16
    //   1106: iload 7
    //   1108: istore 9
    //   1110: aload_1
    //   1111: astore_0
    //   1112: aload 13
    //   1114: astore 14
    //   1116: aload_2
    //   1117: invokeinterface 439 1 0
    //   1122: checkcast 441	java/util/Map$Entry
    //   1125: astore 5
    //   1127: aload_1
    //   1128: astore 15
    //   1130: iload 7
    //   1132: istore 8
    //   1134: aload_1
    //   1135: astore 16
    //   1137: iload 7
    //   1139: istore 9
    //   1141: aload_1
    //   1142: astore_0
    //   1143: aload 13
    //   1145: astore 14
    //   1147: aload 5
    //   1149: invokeinterface 444 1 0
    //   1154: checkcast 116	java/lang/String
    //   1157: astore_3
    //   1158: aload_1
    //   1159: astore 15
    //   1161: iload 7
    //   1163: istore 8
    //   1165: aload_1
    //   1166: astore 16
    //   1168: iload 7
    //   1170: istore 9
    //   1172: aload_1
    //   1173: astore_0
    //   1174: aload 13
    //   1176: astore 14
    //   1178: aload 5
    //   1180: invokeinterface 447 1 0
    //   1185: checkcast 449	java/util/List
    //   1188: astore 5
    //   1190: aload_3
    //   1191: ifnull -124 -> 1067
    //   1194: aload 5
    //   1196: ifnull -129 -> 1067
    //   1199: aload_1
    //   1200: astore 15
    //   1202: iload 7
    //   1204: istore 8
    //   1206: aload_1
    //   1207: astore 16
    //   1209: iload 7
    //   1211: istore 9
    //   1213: aload_1
    //   1214: astore_0
    //   1215: aload 13
    //   1217: astore 14
    //   1219: aload 22
    //   1221: aload_3
    //   1222: ldc_w 451
    //   1225: aload 5
    //   1227: invokestatic 455	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   1230: invokevirtual 374	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1233: pop
    //   1234: goto -167 -> 1067
    //   1237: aload_1
    //   1238: astore 15
    //   1240: iload 7
    //   1242: istore 8
    //   1244: aload_1
    //   1245: astore 16
    //   1247: iload 7
    //   1249: istore 9
    //   1251: aload_1
    //   1252: astore_0
    //   1253: aload 13
    //   1255: astore 14
    //   1257: aload 13
    //   1259: aload 6
    //   1261: invokestatic 457	com/tencent/mobileqq/apollo/utils/ApolloHttpUtil:a	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/apollo/utils/ApolloHttpProgressCallback;)[B
    //   1264: astore_2
    //   1265: aload_1
    //   1266: astore 15
    //   1268: iload 7
    //   1270: istore 8
    //   1272: aload_1
    //   1273: astore 16
    //   1275: iload 7
    //   1277: istore 9
    //   1279: aload_1
    //   1280: astore_0
    //   1281: aload 13
    //   1283: astore 14
    //   1285: aload 21
    //   1287: ldc_w 459
    //   1290: invokevirtual 384	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1293: pop
    //   1294: aload_1
    //   1295: astore 15
    //   1297: iload 7
    //   1299: istore 8
    //   1301: aload_1
    //   1302: astore 16
    //   1304: iload 7
    //   1306: istore 9
    //   1308: aload_1
    //   1309: astore_0
    //   1310: aload 13
    //   1312: astore 14
    //   1314: aload 21
    //   1316: aload_2
    //   1317: arraylength
    //   1318: invokevirtual 400	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   1321: pop
    //   1322: aload_1
    //   1323: astore 15
    //   1325: iload 7
    //   1327: istore 8
    //   1329: aload_1
    //   1330: astore 16
    //   1332: iload 7
    //   1334: istore 9
    //   1336: aload_1
    //   1337: astore_0
    //   1338: aload 13
    //   1340: astore 14
    //   1342: aload 4
    //   1344: iload 7
    //   1346: aload 22
    //   1348: aload_2
    //   1349: invokeinterface 190 4 0
    //   1354: ldc 48
    //   1356: iconst_1
    //   1357: aload 21
    //   1359: invokevirtual 460	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1362: invokestatic 392	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1365: aload_1
    //   1366: ifnull +15 -> 1381
    //   1369: aload_1
    //   1370: invokevirtual 163	java/io/OutputStream:close	()V
    //   1373: goto +8 -> 1381
    //   1376: astore_0
    //   1377: aload_0
    //   1378: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   1381: aload 13
    //   1383: ifnull +292 -> 1675
    //   1386: goto +154 -> 1540
    //   1389: astore_1
    //   1390: iload 8
    //   1392: istore 7
    //   1394: goto +27 -> 1421
    //   1397: astore_1
    //   1398: iload 9
    //   1400: istore 7
    //   1402: goto +148 -> 1550
    //   1405: astore_1
    //   1406: aconst_null
    //   1407: astore_2
    //   1408: aload 14
    //   1410: astore_0
    //   1411: aload_2
    //   1412: astore 14
    //   1414: goto +263 -> 1677
    //   1417: astore_1
    //   1418: aconst_null
    //   1419: astore 13
    //   1421: aload 15
    //   1423: astore_0
    //   1424: aload 13
    //   1426: astore 14
    //   1428: new 36	java/lang/StringBuilder
    //   1431: dup
    //   1432: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1435: astore_2
    //   1436: aload 15
    //   1438: astore_0
    //   1439: aload 13
    //   1441: astore 14
    //   1443: aload_2
    //   1444: ldc_w 462
    //   1447: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: pop
    //   1451: aload 15
    //   1453: astore_0
    //   1454: aload 13
    //   1456: astore 14
    //   1458: aload_2
    //   1459: aload_1
    //   1460: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1463: pop
    //   1464: aload 15
    //   1466: astore_0
    //   1467: aload 13
    //   1469: astore 14
    //   1471: ldc 48
    //   1473: iconst_1
    //   1474: aload_2
    //   1475: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1478: invokestatic 392	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1481: aload 15
    //   1483: astore_0
    //   1484: aload 13
    //   1486: astore 14
    //   1488: aload 4
    //   1490: iload 7
    //   1492: aload 22
    //   1494: aload_1
    //   1495: invokevirtual 463	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1498: invokevirtual 120	java/lang/String:getBytes	()[B
    //   1501: invokeinterface 190 4 0
    //   1506: ldc 48
    //   1508: iconst_1
    //   1509: aload 21
    //   1511: invokevirtual 460	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1514: invokestatic 392	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1517: aload 15
    //   1519: ifnull +16 -> 1535
    //   1522: aload 15
    //   1524: invokevirtual 163	java/io/OutputStream:close	()V
    //   1527: goto +8 -> 1535
    //   1530: astore_0
    //   1531: aload_0
    //   1532: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   1535: aload 13
    //   1537: ifnull +138 -> 1675
    //   1540: aload 13
    //   1542: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   1545: return
    //   1546: astore_1
    //   1547: aconst_null
    //   1548: astore 13
    //   1550: aload 16
    //   1552: astore_0
    //   1553: aload 13
    //   1555: astore 14
    //   1557: new 36	java/lang/StringBuilder
    //   1560: dup
    //   1561: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1564: astore_2
    //   1565: aload 16
    //   1567: astore_0
    //   1568: aload 13
    //   1570: astore 14
    //   1572: aload_2
    //   1573: ldc_w 465
    //   1576: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1579: pop
    //   1580: aload 16
    //   1582: astore_0
    //   1583: aload 13
    //   1585: astore 14
    //   1587: aload_2
    //   1588: aload_1
    //   1589: invokevirtual 468	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1592: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: pop
    //   1596: aload 16
    //   1598: astore_0
    //   1599: aload 13
    //   1601: astore 14
    //   1603: ldc 48
    //   1605: iconst_1
    //   1606: aload_2
    //   1607: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1610: invokestatic 392	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1613: aload 16
    //   1615: astore_0
    //   1616: aload 13
    //   1618: astore 14
    //   1620: aload 4
    //   1622: iload 7
    //   1624: aload 22
    //   1626: aload_1
    //   1627: invokevirtual 469	java/io/IOException:toString	()Ljava/lang/String;
    //   1630: invokevirtual 120	java/lang/String:getBytes	()[B
    //   1633: invokeinterface 190 4 0
    //   1638: ldc 48
    //   1640: iconst_1
    //   1641: aload 21
    //   1643: invokevirtual 460	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1646: invokestatic 392	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1649: aload 16
    //   1651: ifnull +16 -> 1667
    //   1654: aload 16
    //   1656: invokevirtual 163	java/io/OutputStream:close	()V
    //   1659: goto +8 -> 1667
    //   1662: astore_0
    //   1663: aload_0
    //   1664: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   1667: aload 13
    //   1669: ifnull +6 -> 1675
    //   1672: goto -132 -> 1540
    //   1675: return
    //   1676: astore_1
    //   1677: ldc 48
    //   1679: iconst_1
    //   1680: aload 21
    //   1682: invokevirtual 460	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1685: invokestatic 392	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1688: aload_0
    //   1689: ifnull +15 -> 1704
    //   1692: aload_0
    //   1693: invokevirtual 163	java/io/OutputStream:close	()V
    //   1696: goto +8 -> 1704
    //   1699: astore_0
    //   1700: aload_0
    //   1701: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   1704: aload 14
    //   1706: ifnull +8 -> 1714
    //   1709: aload 14
    //   1711: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   1714: goto +5 -> 1719
    //   1717: aload_1
    //   1718: athrow
    //   1719: goto -2 -> 1717
    //   1722: iload 10
    //   1724: iconst_1
    //   1725: iadd
    //   1726: istore 10
    //   1728: goto -1273 -> 455
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1731	0	paramString1	String
    //   0	1731	1	paramString2	String
    //   0	1731	2	paramArrayOfString	String[]
    //   0	1731	3	paramArrayOfByte	byte[]
    //   0	1731	4	paramApolloHttpResponseCallback	ApolloHttpResponseCallback
    //   0	1731	5	paramApolloHttpProgressCallback1	ApolloHttpProgressCallback
    //   0	1731	6	paramApolloHttpProgressCallback2	ApolloHttpProgressCallback
    //   50	1573	7	i	int
    //   74	1317	8	j	int
    //   82	1317	9	k	int
    //   453	1274	10	m	int
    //   415	424	11	n	int
    //   716	116	12	i1	int
    //   66	1602	13	localHttpURLConnection	HttpURLConnection
    //   44	1666	14	localObject1	Object
    //   35	1488	15	localObject2	Object
    //   38	1617	16	localObject3	Object
    //   29	637	17	localObject4	Object
    //   32	642	18	localObject5	Object
    //   41	641	19	localObject6	Object
    //   47	490	20	localObject7	Object
    //   19	1662	21	localStringBuffer	java.lang.StringBuffer
    //   7	1618	22	localHashMap	HashMap
    //   125	66	23	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   1369	1373	1376	java/io/IOException
    //   91	99	1389	java/lang/Throwable
    //   122	127	1389	java/lang/Throwable
    //   155	162	1389	java/lang/Throwable
    //   185	195	1389	java/lang/Throwable
    //   218	227	1389	java/lang/Throwable
    //   253	262	1389	java/lang/Throwable
    //   285	294	1389	java/lang/Throwable
    //   317	323	1389	java/lang/Throwable
    //   346	354	1389	java/lang/Throwable
    //   377	385	1389	java/lang/Throwable
    //   408	414	1389	java/lang/Throwable
    //   440	446	1389	java/lang/Throwable
    //   478	485	1389	java/lang/Throwable
    //   523	533	1389	java/lang/Throwable
    //   566	575	1389	java/lang/Throwable
    //   598	606	1389	java/lang/Throwable
    //   629	635	1389	java/lang/Throwable
    //   658	665	1389	java/lang/Throwable
    //   688	694	1389	java/lang/Throwable
    //   714	718	1389	java/lang/Throwable
    //   749	762	1389	java/lang/Throwable
    //   782	791	1389	java/lang/Throwable
    //   827	838	1389	java/lang/Throwable
    //   865	869	1389	java/lang/Throwable
    //   889	896	1389	java/lang/Throwable
    //   916	922	1389	java/lang/Throwable
    //   942	951	1389	java/lang/Throwable
    //   971	979	1389	java/lang/Throwable
    //   999	1008	1389	java/lang/Throwable
    //   1028	1035	1389	java/lang/Throwable
    //   1055	1067	1389	java/lang/Throwable
    //   1087	1096	1389	java/lang/Throwable
    //   1116	1127	1389	java/lang/Throwable
    //   1147	1158	1389	java/lang/Throwable
    //   1178	1190	1389	java/lang/Throwable
    //   1219	1234	1389	java/lang/Throwable
    //   1257	1265	1389	java/lang/Throwable
    //   1285	1294	1389	java/lang/Throwable
    //   1314	1322	1389	java/lang/Throwable
    //   1342	1354	1389	java/lang/Throwable
    //   91	99	1397	java/io/IOException
    //   122	127	1397	java/io/IOException
    //   155	162	1397	java/io/IOException
    //   185	195	1397	java/io/IOException
    //   218	227	1397	java/io/IOException
    //   253	262	1397	java/io/IOException
    //   285	294	1397	java/io/IOException
    //   317	323	1397	java/io/IOException
    //   346	354	1397	java/io/IOException
    //   377	385	1397	java/io/IOException
    //   408	414	1397	java/io/IOException
    //   440	446	1397	java/io/IOException
    //   478	485	1397	java/io/IOException
    //   523	533	1397	java/io/IOException
    //   566	575	1397	java/io/IOException
    //   598	606	1397	java/io/IOException
    //   629	635	1397	java/io/IOException
    //   658	665	1397	java/io/IOException
    //   688	694	1397	java/io/IOException
    //   714	718	1397	java/io/IOException
    //   749	762	1397	java/io/IOException
    //   782	791	1397	java/io/IOException
    //   827	838	1397	java/io/IOException
    //   865	869	1397	java/io/IOException
    //   889	896	1397	java/io/IOException
    //   916	922	1397	java/io/IOException
    //   942	951	1397	java/io/IOException
    //   971	979	1397	java/io/IOException
    //   999	1008	1397	java/io/IOException
    //   1028	1035	1397	java/io/IOException
    //   1055	1067	1397	java/io/IOException
    //   1087	1096	1397	java/io/IOException
    //   1116	1127	1397	java/io/IOException
    //   1147	1158	1397	java/io/IOException
    //   1178	1190	1397	java/io/IOException
    //   1219	1234	1397	java/io/IOException
    //   1257	1265	1397	java/io/IOException
    //   1285	1294	1397	java/io/IOException
    //   1314	1322	1397	java/io/IOException
    //   1342	1354	1397	java/io/IOException
    //   52	68	1405	finally
    //   52	68	1417	java/lang/Throwable
    //   1522	1527	1530	java/io/IOException
    //   52	68	1546	java/io/IOException
    //   1654	1659	1662	java/io/IOException
    //   91	99	1676	finally
    //   122	127	1676	finally
    //   155	162	1676	finally
    //   185	195	1676	finally
    //   218	227	1676	finally
    //   253	262	1676	finally
    //   285	294	1676	finally
    //   317	323	1676	finally
    //   346	354	1676	finally
    //   377	385	1676	finally
    //   408	414	1676	finally
    //   440	446	1676	finally
    //   478	485	1676	finally
    //   523	533	1676	finally
    //   566	575	1676	finally
    //   598	606	1676	finally
    //   629	635	1676	finally
    //   658	665	1676	finally
    //   688	694	1676	finally
    //   714	718	1676	finally
    //   749	762	1676	finally
    //   782	791	1676	finally
    //   827	838	1676	finally
    //   865	869	1676	finally
    //   889	896	1676	finally
    //   916	922	1676	finally
    //   942	951	1676	finally
    //   971	979	1676	finally
    //   999	1008	1676	finally
    //   1028	1035	1676	finally
    //   1055	1067	1676	finally
    //   1087	1096	1676	finally
    //   1116	1127	1676	finally
    //   1147	1158	1676	finally
    //   1178	1190	1676	finally
    //   1219	1234	1676	finally
    //   1257	1265	1676	finally
    //   1285	1294	1676	finally
    //   1314	1322	1676	finally
    //   1342	1354	1676	finally
    //   1428	1436	1676	finally
    //   1443	1451	1676	finally
    //   1458	1464	1676	finally
    //   1471	1481	1676	finally
    //   1488	1506	1676	finally
    //   1557	1565	1676	finally
    //   1572	1580	1676	finally
    //   1587	1596	1676	finally
    //   1603	1613	1676	finally
    //   1620	1638	1676	finally
    //   1692	1696	1699	java/io/IOException
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
        paramHashMap = new StringBuilder();
        paramHashMap.append("wrapBitmapBuffer");
        paramHashMap.append(paramFile);
        QLog.d("[cmshow]ApolloHttpUtil", 2, paramHashMap.toString());
      }
    }
    return null;
  }
  
  /* Error */
  private static byte[] b(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 139	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 140	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: astore_2
    //   16: sipush 1024
    //   19: newarray byte
    //   21: astore 4
    //   23: aload_3
    //   24: astore_2
    //   25: aload_0
    //   26: aload 4
    //   28: invokevirtual 146	java/io/InputStream:read	([B)I
    //   31: istore_1
    //   32: iload_1
    //   33: iconst_m1
    //   34: if_icmpeq +16 -> 50
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: aload 4
    //   42: iconst_0
    //   43: iload_1
    //   44: invokevirtual 149	java/io/ByteArrayOutputStream:write	([BII)V
    //   47: goto -24 -> 23
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: invokevirtual 152	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   56: astore 4
    //   58: aload_0
    //   59: ifnull +22 -> 81
    //   62: aload_0
    //   63: invokevirtual 168	java/io/InputStream:close	()V
    //   66: goto +15 -> 81
    //   69: astore_0
    //   70: ldc 48
    //   72: iconst_1
    //   73: aload_0
    //   74: iconst_0
    //   75: anewarray 4	java/lang/Object
    //   78: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   81: aload_3
    //   82: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   85: aload 4
    //   87: areturn
    //   88: astore_0
    //   89: ldc 48
    //   91: iconst_1
    //   92: aload_0
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   100: aload 4
    //   102: areturn
    //   103: astore_3
    //   104: goto +79 -> 183
    //   107: astore 4
    //   109: goto +13 -> 122
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_2
    //   115: goto +68 -> 183
    //   118: astore 4
    //   120: aconst_null
    //   121: astore_3
    //   122: aload_3
    //   123: astore_2
    //   124: ldc 48
    //   126: iconst_1
    //   127: aload 4
    //   129: iconst_0
    //   130: anewarray 4	java/lang/Object
    //   133: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   136: aload_0
    //   137: ifnull +22 -> 159
    //   140: aload_0
    //   141: invokevirtual 168	java/io/InputStream:close	()V
    //   144: goto +15 -> 159
    //   147: astore_0
    //   148: ldc 48
    //   150: iconst_1
    //   151: aload_0
    //   152: iconst_0
    //   153: anewarray 4	java/lang/Object
    //   156: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   159: aload_3
    //   160: ifnull +21 -> 181
    //   163: aload_3
    //   164: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   167: aconst_null
    //   168: areturn
    //   169: astore_0
    //   170: ldc 48
    //   172: iconst_1
    //   173: aload_0
    //   174: iconst_0
    //   175: anewarray 4	java/lang/Object
    //   178: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   181: aconst_null
    //   182: areturn
    //   183: aload_0
    //   184: ifnull +22 -> 206
    //   187: aload_0
    //   188: invokevirtual 168	java/io/InputStream:close	()V
    //   191: goto +15 -> 206
    //   194: astore_0
    //   195: ldc 48
    //   197: iconst_1
    //   198: aload_0
    //   199: iconst_0
    //   200: anewarray 4	java/lang/Object
    //   203: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   206: aload_2
    //   207: ifnull +22 -> 229
    //   210: aload_2
    //   211: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   214: goto +15 -> 229
    //   217: astore_0
    //   218: ldc 48
    //   220: iconst_1
    //   221: aload_0
    //   222: iconst_0
    //   223: anewarray 4	java/lang/Object
    //   226: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   229: goto +5 -> 234
    //   232: aload_3
    //   233: athrow
    //   234: goto -2 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramInputStream	InputStream
    //   31	13	1	i	int
    //   15	196	2	localObject1	Object
    //   13	69	3	localByteArrayOutputStream	ByteArrayOutputStream
    //   103	1	3	localObject2	Object
    //   112	1	3	localObject3	Object
    //   121	112	3	localObject4	Object
    //   21	80	4	arrayOfByte	byte[]
    //   107	1	4	localException1	Exception
    //   118	10	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   62	66	69	java/io/IOException
    //   81	85	88	java/io/IOException
    //   16	23	103	finally
    //   25	32	103	finally
    //   39	47	103	finally
    //   52	58	103	finally
    //   124	136	103	finally
    //   16	23	107	java/lang/Exception
    //   25	32	107	java/lang/Exception
    //   39	47	107	java/lang/Exception
    //   52	58	107	java/lang/Exception
    //   6	14	112	finally
    //   6	14	118	java/lang/Exception
    //   140	144	147	java/io/IOException
    //   163	167	169	java/io/IOException
    //   187	191	194	java/io/IOException
    //   210	214	217	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloHttpUtil
 * JD-Core Version:    0.7.0.1
 */