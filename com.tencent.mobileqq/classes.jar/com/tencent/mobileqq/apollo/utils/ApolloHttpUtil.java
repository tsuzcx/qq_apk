package com.tencent.mobileqq.apollo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ApolloHttpProgressCallback;
import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ApolloHttpResponseCallback;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
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
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString, com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ApolloHttpCallBack paramApolloHttpCallBack)
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
    //   123: goto +514 -> 637
    //   126: aload_0
    //   127: aload_2
    //   128: aload 4
    //   130: iload 6
    //   132: aaload
    //   133: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto +501 -> 637
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
    //   267: invokeinterface 157 3 0
    //   272: aload_0
    //   273: ifnull +7 -> 280
    //   276: aload_0
    //   277: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   280: aload_2
    //   281: ifnull +22 -> 303
    //   284: aload_2
    //   285: invokevirtual 163	java/io/OutputStream:close	()V
    //   288: goto +15 -> 303
    //   291: astore_0
    //   292: ldc 48
    //   294: iconst_1
    //   295: aload_0
    //   296: iconst_0
    //   297: anewarray 4	java/lang/Object
    //   300: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   303: aload_1
    //   304: ifnull +22 -> 326
    //   307: aload_1
    //   308: invokevirtual 168	java/io/InputStream:close	()V
    //   311: goto +15 -> 326
    //   314: astore_0
    //   315: ldc 48
    //   317: iconst_1
    //   318: aload_0
    //   319: iconst_0
    //   320: anewarray 4	java/lang/Object
    //   323: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   326: aload 11
    //   328: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   331: return
    //   332: astore 4
    //   334: aconst_null
    //   335: astore 5
    //   337: aload_0
    //   338: astore_3
    //   339: aload 4
    //   341: astore_0
    //   342: aload_2
    //   343: astore 4
    //   345: aload 5
    //   347: astore_2
    //   348: goto +183 -> 531
    //   351: aconst_null
    //   352: astore_3
    //   353: aload_0
    //   354: astore 10
    //   356: aload_3
    //   357: astore_0
    //   358: goto +74 -> 432
    //   361: astore 4
    //   363: aconst_null
    //   364: astore_1
    //   365: aload_1
    //   366: astore 5
    //   368: aload_0
    //   369: astore_3
    //   370: aload 4
    //   372: astore_0
    //   373: aload_2
    //   374: astore 4
    //   376: aload 5
    //   378: astore_2
    //   379: goto +152 -> 531
    //   382: aconst_null
    //   383: astore_1
    //   384: aload_0
    //   385: astore 10
    //   387: goto +43 -> 430
    //   390: astore_2
    //   391: aload_0
    //   392: astore_1
    //   393: aload_2
    //   394: astore_0
    //   395: goto +9 -> 404
    //   398: goto +25 -> 423
    //   401: astore_0
    //   402: aconst_null
    //   403: astore_1
    //   404: aconst_null
    //   405: astore 5
    //   407: aconst_null
    //   408: astore_2
    //   409: aload 8
    //   411: astore 4
    //   413: aload_1
    //   414: astore_3
    //   415: aload 5
    //   417: astore_1
    //   418: goto +113 -> 531
    //   421: aconst_null
    //   422: astore_0
    //   423: aconst_null
    //   424: astore_2
    //   425: aconst_null
    //   426: astore_1
    //   427: aload_0
    //   428: astore 10
    //   430: aload_1
    //   431: astore_0
    //   432: aload 10
    //   434: astore_3
    //   435: aload_2
    //   436: astore 4
    //   438: aload_1
    //   439: astore 8
    //   441: aload_0
    //   442: astore 9
    //   444: aload 5
    //   446: iconst_m1
    //   447: aconst_null
    //   448: invokeinterface 157 3 0
    //   453: aload 10
    //   455: ifnull +8 -> 463
    //   458: aload 10
    //   460: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   463: aload_2
    //   464: ifnull +22 -> 486
    //   467: aload_2
    //   468: invokevirtual 163	java/io/OutputStream:close	()V
    //   471: goto +15 -> 486
    //   474: astore_2
    //   475: ldc 48
    //   477: iconst_1
    //   478: aload_2
    //   479: iconst_0
    //   480: anewarray 4	java/lang/Object
    //   483: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   486: aload_1
    //   487: ifnull +22 -> 509
    //   490: aload_1
    //   491: invokevirtual 168	java/io/InputStream:close	()V
    //   494: goto +15 -> 509
    //   497: astore_1
    //   498: ldc 48
    //   500: iconst_1
    //   501: aload_1
    //   502: iconst_0
    //   503: anewarray 4	java/lang/Object
    //   506: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   509: aload_0
    //   510: ifnull +13 -> 523
    //   513: aload_0
    //   514: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   517: return
    //   518: astore_0
    //   519: aload_0
    //   520: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   523: return
    //   524: astore_0
    //   525: aload 9
    //   527: astore_2
    //   528: aload 8
    //   530: astore_1
    //   531: aload_3
    //   532: ifnull +7 -> 539
    //   535: aload_3
    //   536: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   539: aload 4
    //   541: ifnull +23 -> 564
    //   544: aload 4
    //   546: invokevirtual 163	java/io/OutputStream:close	()V
    //   549: goto +15 -> 564
    //   552: astore_3
    //   553: ldc 48
    //   555: iconst_1
    //   556: aload_3
    //   557: iconst_0
    //   558: anewarray 4	java/lang/Object
    //   561: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   564: aload_1
    //   565: ifnull +22 -> 587
    //   568: aload_1
    //   569: invokevirtual 168	java/io/InputStream:close	()V
    //   572: goto +15 -> 587
    //   575: astore_1
    //   576: ldc 48
    //   578: iconst_1
    //   579: aload_1
    //   580: iconst_0
    //   581: anewarray 4	java/lang/Object
    //   584: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   587: aload_2
    //   588: ifnull +15 -> 603
    //   591: aload_2
    //   592: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   595: goto +8 -> 603
    //   598: astore_1
    //   599: aload_1
    //   600: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   603: goto +5 -> 608
    //   606: aload_0
    //   607: athrow
    //   608: goto -2 -> 606
    //   611: astore_0
    //   612: goto -191 -> 421
    //   615: astore_1
    //   616: goto -218 -> 398
    //   619: astore_1
    //   620: goto -238 -> 382
    //   623: astore_3
    //   624: goto -273 -> 351
    //   627: astore_3
    //   628: aload_0
    //   629: astore 10
    //   631: aload 11
    //   633: astore_0
    //   634: goto -202 -> 432
    //   637: iload 6
    //   639: iconst_1
    //   640: iadd
    //   641: istore 6
    //   643: goto -541 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	646	0	paramString1	String
    //   0	646	1	paramString2	String
    //   0	646	2	paramString3	String
    //   0	646	3	paramString4	String
    //   0	646	4	paramArrayOfString	String[]
    //   0	646	5	paramApolloHttpCallBack	com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ApolloHttpCallBack
    //   100	542	6	i	int
    //   213	26	7	j	int
    //   1	528	8	str	String
    //   34	492	9	localObject1	Object
    //   193	437	10	localObject2	Object
    //   174	458	11	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   284	288	291	java/io/IOException
    //   307	311	314	java/io/IOException
    //   167	176	332	finally
    //   144	167	361	finally
    //   18	36	390	finally
    //   41	57	390	finally
    //   57	97	390	finally
    //   102	110	390	finally
    //   126	136	390	finally
    //   139	144	390	finally
    //   3	18	401	finally
    //   467	471	474	java/io/IOException
    //   490	494	497	java/io/IOException
    //   326	331	518	java/io/IOException
    //   513	517	518	java/io/IOException
    //   188	195	524	finally
    //   207	215	524	finally
    //   233	243	524	finally
    //   258	272	524	finally
    //   444	453	524	finally
    //   544	549	552	java/io/IOException
    //   568	572	575	java/io/IOException
    //   591	595	598	java/io/IOException
    //   3	18	611	java/lang/Throwable
    //   18	36	615	java/lang/Throwable
    //   41	57	615	java/lang/Throwable
    //   57	97	615	java/lang/Throwable
    //   102	110	615	java/lang/Throwable
    //   126	136	615	java/lang/Throwable
    //   139	144	615	java/lang/Throwable
    //   144	167	619	java/lang/Throwable
    //   167	176	623	java/lang/Throwable
    //   188	195	627	java/lang/Throwable
    //   207	215	627	java/lang/Throwable
    //   233	243	627	java/lang/Throwable
    //   258	272	627	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, byte[] paramArrayOfByte, String[] paramArrayOfString, com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ApolloHttpCallBack paramApolloHttpCallBack)
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
    //   94: goto +506 -> 600
    //   97: aload_1
    //   98: aload_0
    //   99: aload_3
    //   100: iload 5
    //   102: aaload
    //   103: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: goto +494 -> 600
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
    //   231: invokeinterface 157 3 0
    //   236: aload_1
    //   237: ifnull +7 -> 244
    //   240: aload_1
    //   241: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   244: aload_0
    //   245: ifnull +22 -> 267
    //   248: aload_0
    //   249: invokevirtual 163	java/io/OutputStream:close	()V
    //   252: goto +15 -> 267
    //   255: astore_0
    //   256: ldc 48
    //   258: iconst_1
    //   259: aload_0
    //   260: iconst_0
    //   261: anewarray 4	java/lang/Object
    //   264: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   267: aload_3
    //   268: ifnull +22 -> 290
    //   271: aload_3
    //   272: invokevirtual 168	java/io/InputStream:close	()V
    //   275: goto +15 -> 290
    //   278: astore_0
    //   279: ldc 48
    //   281: iconst_1
    //   282: aload_0
    //   283: iconst_0
    //   284: anewarray 4	java/lang/Object
    //   287: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   290: aload_2
    //   291: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   294: return
    //   295: astore_0
    //   296: ldc 48
    //   298: iconst_1
    //   299: aload_0
    //   300: iconst_0
    //   301: anewarray 4	java/lang/Object
    //   304: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   307: return
    //   308: astore 4
    //   310: aconst_null
    //   311: astore_2
    //   312: aload_0
    //   313: astore 8
    //   315: aload_1
    //   316: astore 9
    //   318: aload 4
    //   320: astore_0
    //   321: aload_3
    //   322: astore_1
    //   323: goto +167 -> 490
    //   326: aconst_null
    //   327: astore_2
    //   328: goto +58 -> 386
    //   331: astore 4
    //   333: aconst_null
    //   334: astore_3
    //   335: aload_3
    //   336: astore_2
    //   337: aload_0
    //   338: astore 8
    //   340: aload_1
    //   341: astore 9
    //   343: aload 4
    //   345: astore_0
    //   346: aload_3
    //   347: astore_1
    //   348: goto +142 -> 490
    //   351: goto +31 -> 382
    //   354: astore_0
    //   355: goto +11 -> 366
    //   358: aconst_null
    //   359: astore_0
    //   360: goto +22 -> 382
    //   363: astore_0
    //   364: aconst_null
    //   365: astore_1
    //   366: aconst_null
    //   367: astore_3
    //   368: aconst_null
    //   369: astore_2
    //   370: aload_1
    //   371: astore 9
    //   373: aload_3
    //   374: astore_1
    //   375: goto +115 -> 490
    //   378: aconst_null
    //   379: astore_0
    //   380: aload_0
    //   381: astore_1
    //   382: aconst_null
    //   383: astore_3
    //   384: aconst_null
    //   385: astore_2
    //   386: aload_2
    //   387: astore 7
    //   389: aload_0
    //   390: astore 8
    //   392: aload_1
    //   393: astore 9
    //   395: aload_3
    //   396: astore 10
    //   398: aload 4
    //   400: iconst_m1
    //   401: aconst_null
    //   402: invokeinterface 157 3 0
    //   407: aload_1
    //   408: ifnull +7 -> 415
    //   411: aload_1
    //   412: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   415: aload_0
    //   416: ifnull +22 -> 438
    //   419: aload_0
    //   420: invokevirtual 163	java/io/OutputStream:close	()V
    //   423: goto +15 -> 438
    //   426: astore_0
    //   427: ldc 48
    //   429: iconst_1
    //   430: aload_0
    //   431: iconst_0
    //   432: anewarray 4	java/lang/Object
    //   435: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   438: aload_3
    //   439: ifnull +22 -> 461
    //   442: aload_3
    //   443: invokevirtual 168	java/io/InputStream:close	()V
    //   446: goto +15 -> 461
    //   449: astore_0
    //   450: ldc 48
    //   452: iconst_1
    //   453: aload_0
    //   454: iconst_0
    //   455: anewarray 4	java/lang/Object
    //   458: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   461: aload_2
    //   462: ifnull +20 -> 482
    //   465: aload_2
    //   466: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   469: return
    //   470: astore_0
    //   471: ldc 48
    //   473: iconst_1
    //   474: aload_0
    //   475: iconst_0
    //   476: anewarray 4	java/lang/Object
    //   479: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   482: return
    //   483: astore_0
    //   484: aload 10
    //   486: astore_1
    //   487: aload 7
    //   489: astore_2
    //   490: aload 9
    //   492: ifnull +8 -> 500
    //   495: aload 9
    //   497: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   500: aload 8
    //   502: ifnull +23 -> 525
    //   505: aload 8
    //   507: invokevirtual 163	java/io/OutputStream:close	()V
    //   510: goto +15 -> 525
    //   513: astore_3
    //   514: ldc 48
    //   516: iconst_1
    //   517: aload_3
    //   518: iconst_0
    //   519: anewarray 4	java/lang/Object
    //   522: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   525: aload_1
    //   526: ifnull +22 -> 548
    //   529: aload_1
    //   530: invokevirtual 168	java/io/InputStream:close	()V
    //   533: goto +15 -> 548
    //   536: astore_1
    //   537: ldc 48
    //   539: iconst_1
    //   540: aload_1
    //   541: iconst_0
    //   542: anewarray 4	java/lang/Object
    //   545: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   548: aload_2
    //   549: ifnull +22 -> 571
    //   552: aload_2
    //   553: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   556: goto +15 -> 571
    //   559: astore_1
    //   560: ldc 48
    //   562: iconst_1
    //   563: aload_1
    //   564: iconst_0
    //   565: anewarray 4	java/lang/Object
    //   568: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   571: goto +5 -> 576
    //   574: aload_0
    //   575: athrow
    //   576: goto -2 -> 574
    //   579: astore_0
    //   580: goto -202 -> 378
    //   583: astore_0
    //   584: goto -226 -> 358
    //   587: astore_2
    //   588: goto -237 -> 351
    //   591: astore_2
    //   592: goto -266 -> 326
    //   595: astore 7
    //   597: goto -211 -> 386
    //   600: iload 5
    //   602: iconst_1
    //   603: iadd
    //   604: istore 5
    //   606: goto -531 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	609	0	paramString1	String
    //   0	609	1	paramString2	String
    //   0	609	2	paramArrayOfByte	byte[]
    //   0	609	3	paramArrayOfString	String[]
    //   0	609	4	paramApolloHttpCallBack	com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ApolloHttpCallBack
    //   73	532	5	i	int
    //   179	25	6	j	int
    //   143	345	7	arrayOfByte1	byte[]
    //   595	1	7	localThrowable	Throwable
    //   1	505	8	str1	String
    //   149	347	9	str2	String
    //   152	333	10	arrayOfString	String[]
    //   159	42	11	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   248	252	255	java/io/IOException
    //   271	275	278	java/io/IOException
    //   290	294	295	java/io/IOException
    //   134	142	308	finally
    //   114	134	331	finally
    //   18	34	354	finally
    //   38	51	354	finally
    //   51	70	354	finally
    //   75	82	354	finally
    //   97	106	354	finally
    //   109	114	354	finally
    //   3	18	363	finally
    //   419	423	426	java/io/IOException
    //   442	446	449	java/io/IOException
    //   465	469	470	java/io/IOException
    //   154	161	483	finally
    //   173	181	483	finally
    //   199	208	483	finally
    //   223	236	483	finally
    //   398	407	483	finally
    //   505	510	513	java/io/IOException
    //   529	533	536	java/io/IOException
    //   552	556	559	java/io/IOException
    //   3	18	579	java/lang/Throwable
    //   18	34	583	java/lang/Throwable
    //   38	51	583	java/lang/Throwable
    //   51	70	583	java/lang/Throwable
    //   75	82	583	java/lang/Throwable
    //   97	106	583	java/lang/Throwable
    //   109	114	583	java/lang/Throwable
    //   114	134	587	java/lang/Throwable
    //   134	142	591	java/lang/Throwable
    //   154	161	595	java/lang/Throwable
    //   173	181	595	java/lang/Throwable
    //   199	208	595	java/lang/Throwable
    //   223	236	595	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String[] paramArrayOfString, com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ApolloHttpCallBack paramApolloHttpCallBack)
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
    //   102: goto +544 -> 646
    //   105: aload_0
    //   106: aload 6
    //   108: aload_2
    //   109: iload 4
    //   111: aaload
    //   112: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: goto +531 -> 646
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
    //   249: invokeinterface 157 3 0
    //   254: aload_0
    //   255: ifnull +7 -> 262
    //   258: aload_0
    //   259: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   262: aload_2
    //   263: ifnull +22 -> 285
    //   266: aload_2
    //   267: invokevirtual 163	java/io/OutputStream:close	()V
    //   270: goto +15 -> 285
    //   273: astore_0
    //   274: ldc 48
    //   276: iconst_1
    //   277: aload_0
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   285: aload_1
    //   286: ifnull +22 -> 308
    //   289: aload_1
    //   290: invokevirtual 168	java/io/InputStream:close	()V
    //   293: goto +15 -> 308
    //   296: astore_0
    //   297: ldc 48
    //   299: iconst_1
    //   300: aload_0
    //   301: iconst_0
    //   302: anewarray 4	java/lang/Object
    //   305: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   308: aload 11
    //   310: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   313: return
    //   314: astore_0
    //   315: ldc 48
    //   317: iconst_1
    //   318: aload_0
    //   319: iconst_0
    //   320: anewarray 4	java/lang/Object
    //   323: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   326: return
    //   327: astore 6
    //   329: aconst_null
    //   330: astore_3
    //   331: aload_0
    //   332: astore 8
    //   334: aload 6
    //   336: astore_0
    //   337: goto +187 -> 524
    //   340: aconst_null
    //   341: astore 6
    //   343: aload_1
    //   344: astore 10
    //   346: aload 6
    //   348: astore_1
    //   349: goto +66 -> 415
    //   352: astore 6
    //   354: aconst_null
    //   355: astore_1
    //   356: aload_1
    //   357: astore_3
    //   358: aload_0
    //   359: astore 8
    //   361: aload 6
    //   363: astore_0
    //   364: goto +160 -> 524
    //   367: aconst_null
    //   368: astore 6
    //   370: goto +38 -> 408
    //   373: astore_2
    //   374: aload_0
    //   375: astore_1
    //   376: aload_2
    //   377: astore_0
    //   378: goto +9 -> 387
    //   381: goto +22 -> 403
    //   384: astore_0
    //   385: aconst_null
    //   386: astore_1
    //   387: aconst_null
    //   388: astore_2
    //   389: aconst_null
    //   390: astore_3
    //   391: aload 7
    //   393: astore 6
    //   395: aload_1
    //   396: astore 8
    //   398: goto +131 -> 529
    //   401: aconst_null
    //   402: astore_0
    //   403: aconst_null
    //   404: astore_2
    //   405: aconst_null
    //   406: astore 6
    //   408: aload 6
    //   410: astore_1
    //   411: aload 6
    //   413: astore 10
    //   415: aload 10
    //   417: astore 6
    //   419: aload_1
    //   420: astore 7
    //   422: aload_0
    //   423: astore 8
    //   425: aload_2
    //   426: astore 9
    //   428: aload_3
    //   429: iconst_m1
    //   430: aconst_null
    //   431: invokeinterface 157 3 0
    //   436: aload_0
    //   437: ifnull +7 -> 444
    //   440: aload_0
    //   441: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   444: aload_2
    //   445: ifnull +22 -> 467
    //   448: aload_2
    //   449: invokevirtual 163	java/io/OutputStream:close	()V
    //   452: goto +15 -> 467
    //   455: astore_0
    //   456: ldc 48
    //   458: iconst_1
    //   459: aload_0
    //   460: iconst_0
    //   461: anewarray 4	java/lang/Object
    //   464: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   467: aload 10
    //   469: ifnull +23 -> 492
    //   472: aload 10
    //   474: invokevirtual 168	java/io/InputStream:close	()V
    //   477: goto +15 -> 492
    //   480: astore_0
    //   481: ldc 48
    //   483: iconst_1
    //   484: aload_0
    //   485: iconst_0
    //   486: anewarray 4	java/lang/Object
    //   489: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   492: aload_1
    //   493: ifnull +20 -> 513
    //   496: aload_1
    //   497: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   500: return
    //   501: astore_0
    //   502: ldc 48
    //   504: iconst_1
    //   505: aload_0
    //   506: iconst_0
    //   507: anewarray 4	java/lang/Object
    //   510: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   513: return
    //   514: astore_0
    //   515: aload 9
    //   517: astore_2
    //   518: aload 7
    //   520: astore_3
    //   521: aload 6
    //   523: astore_1
    //   524: aload_2
    //   525: astore 6
    //   527: aload_1
    //   528: astore_2
    //   529: aload 8
    //   531: ifnull +8 -> 539
    //   534: aload 8
    //   536: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   539: aload 6
    //   541: ifnull +23 -> 564
    //   544: aload 6
    //   546: invokevirtual 163	java/io/OutputStream:close	()V
    //   549: goto +15 -> 564
    //   552: astore_1
    //   553: ldc 48
    //   555: iconst_1
    //   556: aload_1
    //   557: iconst_0
    //   558: anewarray 4	java/lang/Object
    //   561: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   564: aload_2
    //   565: ifnull +22 -> 587
    //   568: aload_2
    //   569: invokevirtual 168	java/io/InputStream:close	()V
    //   572: goto +15 -> 587
    //   575: astore_1
    //   576: ldc 48
    //   578: iconst_1
    //   579: aload_1
    //   580: iconst_0
    //   581: anewarray 4	java/lang/Object
    //   584: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   587: aload_3
    //   588: ifnull +22 -> 610
    //   591: aload_3
    //   592: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   595: goto +15 -> 610
    //   598: astore_1
    //   599: ldc 48
    //   601: iconst_1
    //   602: aload_1
    //   603: iconst_0
    //   604: anewarray 4	java/lang/Object
    //   607: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   610: goto +5 -> 615
    //   613: aload_0
    //   614: athrow
    //   615: goto -2 -> 613
    //   618: astore_0
    //   619: goto -218 -> 401
    //   622: astore_1
    //   623: goto -242 -> 381
    //   626: astore_1
    //   627: goto -260 -> 367
    //   630: astore 6
    //   632: goto -292 -> 340
    //   635: astore 6
    //   637: aload_1
    //   638: astore 10
    //   640: aload 11
    //   642: astore_1
    //   643: goto -228 -> 415
    //   646: iload 4
    //   648: iconst_1
    //   649: iadd
    //   650: istore 4
    //   652: goto -570 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	655	0	paramString1	String
    //   0	655	1	paramString2	String
    //   0	655	2	paramArrayOfString	String[]
    //   0	655	3	paramApolloHttpCallBack	com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ApolloHttpCallBack
    //   80	571	4	i	int
    //   194	27	5	j	int
    //   34	196	6	localObject1	Object
    //   327	8	6	localObject2	Object
    //   341	6	6	localObject3	Object
    //   352	10	6	localObject4	Object
    //   368	177	6	localObject5	Object
    //   630	1	6	localThrowable1	Throwable
    //   635	1	6	localThrowable2	Throwable
    //   1	518	7	localObject6	Object
    //   163	372	8	str	String
    //   166	350	9	arrayOfString	String[]
    //   173	466	10	localObject7	Object
    //   153	488	11	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   266	270	273	java/io/IOException
    //   289	293	296	java/io/IOException
    //   308	313	314	java/io/IOException
    //   146	155	327	finally
    //   123	146	352	finally
    //   18	36	373	finally
    //   41	57	373	finally
    //   57	76	373	finally
    //   82	89	373	finally
    //   105	115	373	finally
    //   118	123	373	finally
    //   3	18	384	finally
    //   448	452	455	java/io/IOException
    //   472	477	480	java/io/IOException
    //   496	500	501	java/io/IOException
    //   168	175	514	finally
    //   188	196	514	finally
    //   215	225	514	finally
    //   241	254	514	finally
    //   428	436	514	finally
    //   544	549	552	java/io/IOException
    //   568	572	575	java/io/IOException
    //   591	595	598	java/io/IOException
    //   3	18	618	java/lang/Throwable
    //   18	36	622	java/lang/Throwable
    //   41	57	622	java/lang/Throwable
    //   57	76	622	java/lang/Throwable
    //   82	89	622	java/lang/Throwable
    //   105	115	622	java/lang/Throwable
    //   118	123	622	java/lang/Throwable
    //   123	146	626	java/lang/Throwable
    //   146	155	630	java/lang/Throwable
    //   168	175	635	java/lang/Throwable
    //   188	196	635	java/lang/Throwable
    //   215	225	635	java/lang/Throwable
    //   241	254	635	java/lang/Throwable
  }
  
  /* Error */
  public static void a(@NonNull String paramString1, @NonNull String paramString2, @Nullable String[] paramArrayOfString, @Nullable byte[] paramArrayOfByte, @NonNull ApolloHttpResponseCallback paramApolloHttpResponseCallback, @Nullable ApolloHttpProgressCallback paramApolloHttpProgressCallback1, @Nullable ApolloHttpProgressCallback paramApolloHttpProgressCallback2)
  {
    // Byte code:
    //   0: new 179	java/util/HashMap
    //   3: dup
    //   4: invokespecial 180	java/util/HashMap:<init>	()V
    //   7: astore 22
    //   9: new 182	java/lang/StringBuffer
    //   12: dup
    //   13: ldc 184
    //   15: invokespecial 185	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   18: astore 21
    //   20: aload 21
    //   22: aload_0
    //   23: invokevirtual 188	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   26: pop
    //   27: aconst_null
    //   28: astore 17
    //   30: aconst_null
    //   31: astore 18
    //   33: aconst_null
    //   34: astore 15
    //   36: aconst_null
    //   37: astore 16
    //   39: aconst_null
    //   40: astore 19
    //   42: aconst_null
    //   43: astore 14
    //   45: aconst_null
    //   46: astore 20
    //   48: iconst_m1
    //   49: istore 7
    //   51: new 63	java/net/URL
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 66	java/net/URL:<init>	(Ljava/lang/String;)V
    //   59: invokevirtual 70	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   62: checkcast 72	java/net/HttpURLConnection
    //   65: astore 13
    //   67: aload 17
    //   69: astore 15
    //   71: iload 7
    //   73: istore 8
    //   75: aload 18
    //   77: astore 16
    //   79: iload 7
    //   81: istore 9
    //   83: aload 19
    //   85: astore_0
    //   86: aload 13
    //   88: astore 14
    //   90: aload 13
    //   92: instanceof 79
    //   95: ifeq +195 -> 290
    //   98: aload 17
    //   100: astore 15
    //   102: iload 7
    //   104: istore 8
    //   106: aload 18
    //   108: astore 16
    //   110: iload 7
    //   112: istore 9
    //   114: aload 19
    //   116: astore_0
    //   117: aload 13
    //   119: astore 14
    //   121: invokestatic 81	com/tencent/mobileqq/apollo/utils/ApolloHttpUtil:a	()Ljavax/net/ssl/SSLContext;
    //   124: astore 23
    //   126: aload 23
    //   128: ifnull +100 -> 228
    //   131: aload 17
    //   133: astore 15
    //   135: iload 7
    //   137: istore 8
    //   139: aload 18
    //   141: astore 16
    //   143: iload 7
    //   145: istore 9
    //   147: aload 19
    //   149: astore_0
    //   150: aload 13
    //   152: astore 14
    //   154: aload 23
    //   156: invokevirtual 85	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   159: astore 23
    //   161: aload 17
    //   163: astore 15
    //   165: iload 7
    //   167: istore 8
    //   169: aload 18
    //   171: astore 16
    //   173: iload 7
    //   175: istore 9
    //   177: aload 19
    //   179: astore_0
    //   180: aload 13
    //   182: astore 14
    //   184: aload 13
    //   186: checkcast 79	javax/net/ssl/HttpsURLConnection
    //   189: aload 23
    //   191: invokevirtual 89	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   194: aload 17
    //   196: astore 15
    //   198: iload 7
    //   200: istore 8
    //   202: aload 18
    //   204: astore 16
    //   206: iload 7
    //   208: istore 9
    //   210: aload 19
    //   212: astore_0
    //   213: aload 13
    //   215: astore 14
    //   217: aload 21
    //   219: ldc 190
    //   221: invokevirtual 188	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   224: pop
    //   225: goto +65 -> 290
    //   228: aload 17
    //   230: astore 15
    //   232: iload 7
    //   234: istore 8
    //   236: aload 18
    //   238: astore 16
    //   240: iload 7
    //   242: istore 9
    //   244: aload 19
    //   246: astore_0
    //   247: aload 13
    //   249: astore 14
    //   251: aload 21
    //   253: ldc 192
    //   255: invokevirtual 188	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   258: pop
    //   259: aload 17
    //   261: astore 15
    //   263: iload 7
    //   265: istore 8
    //   267: aload 18
    //   269: astore 16
    //   271: iload 7
    //   273: istore 9
    //   275: aload 19
    //   277: astore_0
    //   278: aload 13
    //   280: astore 14
    //   282: ldc 48
    //   284: iconst_1
    //   285: ldc 194
    //   287: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload 17
    //   292: astore 15
    //   294: iload 7
    //   296: istore 8
    //   298: aload 18
    //   300: astore 16
    //   302: iload 7
    //   304: istore 9
    //   306: aload 19
    //   308: astore_0
    //   309: aload 13
    //   311: astore 14
    //   313: aload 13
    //   315: aload_1
    //   316: invokevirtual 77	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   319: aload 17
    //   321: astore 15
    //   323: iload 7
    //   325: istore 8
    //   327: aload 18
    //   329: astore 16
    //   331: iload 7
    //   333: istore 9
    //   335: aload 19
    //   337: astore_0
    //   338: aload 13
    //   340: astore 14
    //   342: aload 13
    //   344: sipush 10000
    //   347: invokevirtual 93	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   350: aload 17
    //   352: astore 15
    //   354: iload 7
    //   356: istore 8
    //   358: aload 18
    //   360: astore 16
    //   362: iload 7
    //   364: istore 9
    //   366: aload 19
    //   368: astore_0
    //   369: aload 13
    //   371: astore 14
    //   373: aload 13
    //   375: sipush 10000
    //   378: invokevirtual 96	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   381: aload 17
    //   383: astore 15
    //   385: iload 7
    //   387: istore 8
    //   389: aload 18
    //   391: astore 16
    //   393: iload 7
    //   395: istore 9
    //   397: aload 19
    //   399: astore_0
    //   400: aload 13
    //   402: astore 14
    //   404: aload 13
    //   406: iconst_1
    //   407: invokevirtual 199	java/net/HttpURLConnection:setDoInput	(Z)V
    //   410: iconst_0
    //   411: istore 11
    //   413: aload 17
    //   415: astore 15
    //   417: iload 7
    //   419: istore 8
    //   421: aload 18
    //   423: astore 16
    //   425: iload 7
    //   427: istore 9
    //   429: aload 19
    //   431: astore_0
    //   432: aload 13
    //   434: astore 14
    //   436: aload 13
    //   438: iconst_0
    //   439: invokevirtual 100	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   442: aload_2
    //   443: ifnull +89 -> 532
    //   446: aconst_null
    //   447: astore_1
    //   448: iconst_0
    //   449: istore 10
    //   451: aload 17
    //   453: astore 15
    //   455: iload 7
    //   457: istore 8
    //   459: aload 18
    //   461: astore 16
    //   463: iload 7
    //   465: istore 9
    //   467: aload 19
    //   469: astore_0
    //   470: aload 13
    //   472: astore 14
    //   474: iload 10
    //   476: aload_2
    //   477: arraylength
    //   478: if_icmpge +54 -> 532
    //   481: iload 10
    //   483: iconst_1
    //   484: iand
    //   485: ifne +11 -> 496
    //   488: aload_2
    //   489: iload 10
    //   491: aaload
    //   492: astore_1
    //   493: goto +1222 -> 1715
    //   496: aload 17
    //   498: astore 15
    //   500: iload 7
    //   502: istore 8
    //   504: aload 18
    //   506: astore 16
    //   508: iload 7
    //   510: istore 9
    //   512: aload 19
    //   514: astore_0
    //   515: aload 13
    //   517: astore 14
    //   519: aload 13
    //   521: aload_1
    //   522: aload_2
    //   523: iload 10
    //   525: aaload
    //   526: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   529: goto +1186 -> 1715
    //   532: aload 20
    //   534: astore_1
    //   535: aload_3
    //   536: ifnull +328 -> 864
    //   539: aload 17
    //   541: astore 15
    //   543: iload 7
    //   545: istore 8
    //   547: aload 18
    //   549: astore 16
    //   551: iload 7
    //   553: istore 9
    //   555: aload 19
    //   557: astore_0
    //   558: aload 13
    //   560: astore 14
    //   562: aload 21
    //   564: ldc 201
    //   566: invokevirtual 188	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   569: pop
    //   570: aload 17
    //   572: astore 15
    //   574: iload 7
    //   576: istore 8
    //   578: aload 18
    //   580: astore 16
    //   582: iload 7
    //   584: istore 9
    //   586: aload 19
    //   588: astore_0
    //   589: aload 13
    //   591: astore 14
    //   593: aload 21
    //   595: aload_3
    //   596: arraylength
    //   597: invokevirtual 204	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   600: pop
    //   601: aload 17
    //   603: astore 15
    //   605: iload 7
    //   607: istore 8
    //   609: aload 18
    //   611: astore 16
    //   613: iload 7
    //   615: istore 9
    //   617: aload 19
    //   619: astore_0
    //   620: aload 13
    //   622: astore 14
    //   624: aload 13
    //   626: iconst_1
    //   627: invokevirtual 207	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   630: aload 17
    //   632: astore 15
    //   634: iload 7
    //   636: istore 8
    //   638: aload 18
    //   640: astore 16
    //   642: iload 7
    //   644: istore 9
    //   646: aload 19
    //   648: astore_0
    //   649: aload 13
    //   651: astore 14
    //   653: aload 13
    //   655: aload_3
    //   656: arraylength
    //   657: invokevirtual 210	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   660: aload 17
    //   662: astore 15
    //   664: iload 7
    //   666: istore 8
    //   668: aload 18
    //   670: astore 16
    //   672: iload 7
    //   674: istore 9
    //   676: aload 19
    //   678: astore_0
    //   679: aload 13
    //   681: astore 14
    //   683: aload 13
    //   685: invokevirtual 114	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   688: astore_1
    //   689: aload_1
    //   690: astore 15
    //   692: iload 7
    //   694: istore 8
    //   696: aload_1
    //   697: astore 16
    //   699: iload 7
    //   701: istore 9
    //   703: aload_1
    //   704: astore_0
    //   705: aload 13
    //   707: astore 14
    //   709: aload_3
    //   710: arraylength
    //   711: istore 12
    //   713: iload 11
    //   715: istore 10
    //   717: iload 10
    //   719: iload 12
    //   721: if_icmpge +119 -> 840
    //   724: aload_1
    //   725: astore 15
    //   727: iload 7
    //   729: istore 8
    //   731: aload_1
    //   732: astore 16
    //   734: iload 7
    //   736: istore 9
    //   738: aload_1
    //   739: astore_0
    //   740: aload 13
    //   742: astore 14
    //   744: sipush 4096
    //   747: iload 12
    //   749: iload 10
    //   751: isub
    //   752: invokestatic 216	java/lang/Math:min	(II)I
    //   755: istore 11
    //   757: aload_1
    //   758: astore 15
    //   760: iload 7
    //   762: istore 8
    //   764: aload_1
    //   765: astore 16
    //   767: iload 7
    //   769: istore 9
    //   771: aload_1
    //   772: astore_0
    //   773: aload 13
    //   775: astore 14
    //   777: aload_1
    //   778: aload_3
    //   779: iload 10
    //   781: iload 11
    //   783: invokevirtual 217	java/io/OutputStream:write	([BII)V
    //   786: iload 10
    //   788: iload 11
    //   790: iadd
    //   791: istore 11
    //   793: iload 11
    //   795: istore 10
    //   797: aload 5
    //   799: ifnull -82 -> 717
    //   802: aload_1
    //   803: astore 15
    //   805: iload 7
    //   807: istore 8
    //   809: aload_1
    //   810: astore 16
    //   812: iload 7
    //   814: istore 9
    //   816: aload_1
    //   817: astore_0
    //   818: aload 13
    //   820: astore 14
    //   822: aload 5
    //   824: iload 11
    //   826: iload 12
    //   828: invokeinterface 222 3 0
    //   833: iload 11
    //   835: istore 10
    //   837: goto -120 -> 717
    //   840: aload_1
    //   841: astore 15
    //   843: iload 7
    //   845: istore 8
    //   847: aload_1
    //   848: astore 16
    //   850: iload 7
    //   852: istore 9
    //   854: aload_1
    //   855: astore_0
    //   856: aload 13
    //   858: astore 14
    //   860: aload_1
    //   861: invokevirtual 129	java/io/OutputStream:flush	()V
    //   864: aload_1
    //   865: astore 15
    //   867: iload 7
    //   869: istore 8
    //   871: aload_1
    //   872: astore 16
    //   874: iload 7
    //   876: istore 9
    //   878: aload_1
    //   879: astore_0
    //   880: aload 13
    //   882: astore 14
    //   884: aload 13
    //   886: invokevirtual 133	java/net/HttpURLConnection:getResponseCode	()I
    //   889: istore 7
    //   891: aload_1
    //   892: astore 15
    //   894: iload 7
    //   896: istore 8
    //   898: aload_1
    //   899: astore 16
    //   901: iload 7
    //   903: istore 9
    //   905: aload_1
    //   906: astore_0
    //   907: aload 13
    //   909: astore 14
    //   911: aload 13
    //   913: invokevirtual 226	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   916: astore_2
    //   917: aload_1
    //   918: astore 15
    //   920: iload 7
    //   922: istore 8
    //   924: aload_1
    //   925: astore 16
    //   927: iload 7
    //   929: istore 9
    //   931: aload_1
    //   932: astore_0
    //   933: aload 13
    //   935: astore 14
    //   937: aload 21
    //   939: ldc 228
    //   941: invokevirtual 188	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   944: pop
    //   945: aload_1
    //   946: astore 15
    //   948: iload 7
    //   950: istore 8
    //   952: aload_1
    //   953: astore 16
    //   955: iload 7
    //   957: istore 9
    //   959: aload_1
    //   960: astore_0
    //   961: aload 13
    //   963: astore 14
    //   965: aload 21
    //   967: iload 7
    //   969: invokevirtual 204	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   972: pop
    //   973: aload_1
    //   974: astore 15
    //   976: iload 7
    //   978: istore 8
    //   980: aload_1
    //   981: astore 16
    //   983: iload 7
    //   985: istore 9
    //   987: aload_1
    //   988: astore_0
    //   989: aload 13
    //   991: astore 14
    //   993: aload 21
    //   995: ldc 230
    //   997: invokevirtual 188	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1000: pop
    //   1001: aload_1
    //   1002: astore 15
    //   1004: iload 7
    //   1006: istore 8
    //   1008: aload_1
    //   1009: astore 16
    //   1011: iload 7
    //   1013: istore 9
    //   1015: aload_1
    //   1016: astore_0
    //   1017: aload 13
    //   1019: astore 14
    //   1021: aload 21
    //   1023: aload_2
    //   1024: invokevirtual 233	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   1027: pop
    //   1028: aload_1
    //   1029: astore 15
    //   1031: iload 7
    //   1033: istore 8
    //   1035: aload_1
    //   1036: astore 16
    //   1038: iload 7
    //   1040: istore 9
    //   1042: aload_1
    //   1043: astore_0
    //   1044: aload 13
    //   1046: astore 14
    //   1048: aload_2
    //   1049: invokeinterface 239 1 0
    //   1054: invokeinterface 245 1 0
    //   1059: astore_2
    //   1060: aload_1
    //   1061: astore 15
    //   1063: iload 7
    //   1065: istore 8
    //   1067: aload_1
    //   1068: astore 16
    //   1070: iload 7
    //   1072: istore 9
    //   1074: aload_1
    //   1075: astore_0
    //   1076: aload 13
    //   1078: astore 14
    //   1080: aload_2
    //   1081: invokeinterface 251 1 0
    //   1086: ifeq +144 -> 1230
    //   1089: aload_1
    //   1090: astore 15
    //   1092: iload 7
    //   1094: istore 8
    //   1096: aload_1
    //   1097: astore 16
    //   1099: iload 7
    //   1101: istore 9
    //   1103: aload_1
    //   1104: astore_0
    //   1105: aload 13
    //   1107: astore 14
    //   1109: aload_2
    //   1110: invokeinterface 255 1 0
    //   1115: checkcast 257	java/util/Map$Entry
    //   1118: astore 5
    //   1120: aload_1
    //   1121: astore 15
    //   1123: iload 7
    //   1125: istore 8
    //   1127: aload_1
    //   1128: astore 16
    //   1130: iload 7
    //   1132: istore 9
    //   1134: aload_1
    //   1135: astore_0
    //   1136: aload 13
    //   1138: astore 14
    //   1140: aload 5
    //   1142: invokeinterface 260 1 0
    //   1147: checkcast 116	java/lang/String
    //   1150: astore_3
    //   1151: aload_1
    //   1152: astore 15
    //   1154: iload 7
    //   1156: istore 8
    //   1158: aload_1
    //   1159: astore 16
    //   1161: iload 7
    //   1163: istore 9
    //   1165: aload_1
    //   1166: astore_0
    //   1167: aload 13
    //   1169: astore 14
    //   1171: aload 5
    //   1173: invokeinterface 263 1 0
    //   1178: checkcast 265	java/util/List
    //   1181: astore 5
    //   1183: aload_3
    //   1184: ifnull -124 -> 1060
    //   1187: aload 5
    //   1189: ifnull -129 -> 1060
    //   1192: aload_1
    //   1193: astore 15
    //   1195: iload 7
    //   1197: istore 8
    //   1199: aload_1
    //   1200: astore 16
    //   1202: iload 7
    //   1204: istore 9
    //   1206: aload_1
    //   1207: astore_0
    //   1208: aload 13
    //   1210: astore 14
    //   1212: aload 22
    //   1214: aload_3
    //   1215: ldc_w 267
    //   1218: aload 5
    //   1220: invokestatic 273	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   1223: invokevirtual 277	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1226: pop
    //   1227: goto -167 -> 1060
    //   1230: aload_1
    //   1231: astore 15
    //   1233: iload 7
    //   1235: istore 8
    //   1237: aload_1
    //   1238: astore 16
    //   1240: iload 7
    //   1242: istore 9
    //   1244: aload_1
    //   1245: astore_0
    //   1246: aload 13
    //   1248: astore 14
    //   1250: aload 13
    //   1252: aload 6
    //   1254: invokestatic 280	com/tencent/mobileqq/apollo/utils/ApolloHttpUtil:a	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/cmshow/brickengine/apollo/utils/ApolloHttpProgressCallback;)[B
    //   1257: astore_2
    //   1258: aload_1
    //   1259: astore 15
    //   1261: iload 7
    //   1263: istore 8
    //   1265: aload_1
    //   1266: astore 16
    //   1268: iload 7
    //   1270: istore 9
    //   1272: aload_1
    //   1273: astore_0
    //   1274: aload 13
    //   1276: astore 14
    //   1278: aload 21
    //   1280: ldc_w 282
    //   1283: invokevirtual 188	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1286: pop
    //   1287: aload_1
    //   1288: astore 15
    //   1290: iload 7
    //   1292: istore 8
    //   1294: aload_1
    //   1295: astore 16
    //   1297: iload 7
    //   1299: istore 9
    //   1301: aload_1
    //   1302: astore_0
    //   1303: aload 13
    //   1305: astore 14
    //   1307: aload 21
    //   1309: aload_2
    //   1310: arraylength
    //   1311: invokevirtual 204	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   1314: pop
    //   1315: aload_1
    //   1316: astore 15
    //   1318: iload 7
    //   1320: istore 8
    //   1322: aload_1
    //   1323: astore 16
    //   1325: iload 7
    //   1327: istore 9
    //   1329: aload_1
    //   1330: astore_0
    //   1331: aload 13
    //   1333: astore 14
    //   1335: aload 4
    //   1337: iload 7
    //   1339: aload 22
    //   1341: aload_2
    //   1342: invokeinterface 287 4 0
    //   1347: ldc 48
    //   1349: iconst_1
    //   1350: aload 21
    //   1352: invokevirtual 288	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1355: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1358: aload_1
    //   1359: ifnull +15 -> 1374
    //   1362: aload_1
    //   1363: invokevirtual 163	java/io/OutputStream:close	()V
    //   1366: goto +8 -> 1374
    //   1369: astore_0
    //   1370: aload_0
    //   1371: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   1374: aload 13
    //   1376: ifnull +292 -> 1668
    //   1379: goto +154 -> 1533
    //   1382: astore_1
    //   1383: iload 8
    //   1385: istore 7
    //   1387: goto +27 -> 1414
    //   1390: astore_1
    //   1391: iload 9
    //   1393: istore 7
    //   1395: goto +148 -> 1543
    //   1398: astore_1
    //   1399: aconst_null
    //   1400: astore_2
    //   1401: aload 14
    //   1403: astore_0
    //   1404: aload_2
    //   1405: astore 14
    //   1407: goto +263 -> 1670
    //   1410: astore_1
    //   1411: aconst_null
    //   1412: astore 13
    //   1414: aload 15
    //   1416: astore_0
    //   1417: aload 13
    //   1419: astore 14
    //   1421: new 36	java/lang/StringBuilder
    //   1424: dup
    //   1425: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1428: astore_2
    //   1429: aload 15
    //   1431: astore_0
    //   1432: aload 13
    //   1434: astore 14
    //   1436: aload_2
    //   1437: ldc_w 290
    //   1440: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1443: pop
    //   1444: aload 15
    //   1446: astore_0
    //   1447: aload 13
    //   1449: astore 14
    //   1451: aload_2
    //   1452: aload_1
    //   1453: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1456: pop
    //   1457: aload 15
    //   1459: astore_0
    //   1460: aload 13
    //   1462: astore 14
    //   1464: ldc 48
    //   1466: iconst_1
    //   1467: aload_2
    //   1468: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1471: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1474: aload 15
    //   1476: astore_0
    //   1477: aload 13
    //   1479: astore 14
    //   1481: aload 4
    //   1483: iload 7
    //   1485: aload 22
    //   1487: aload_1
    //   1488: invokevirtual 291	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1491: invokevirtual 120	java/lang/String:getBytes	()[B
    //   1494: invokeinterface 287 4 0
    //   1499: ldc 48
    //   1501: iconst_1
    //   1502: aload 21
    //   1504: invokevirtual 288	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1507: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1510: aload 15
    //   1512: ifnull +16 -> 1528
    //   1515: aload 15
    //   1517: invokevirtual 163	java/io/OutputStream:close	()V
    //   1520: goto +8 -> 1528
    //   1523: astore_0
    //   1524: aload_0
    //   1525: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   1528: aload 13
    //   1530: ifnull +138 -> 1668
    //   1533: aload 13
    //   1535: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   1538: return
    //   1539: astore_1
    //   1540: aconst_null
    //   1541: astore 13
    //   1543: aload 16
    //   1545: astore_0
    //   1546: aload 13
    //   1548: astore 14
    //   1550: new 36	java/lang/StringBuilder
    //   1553: dup
    //   1554: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1557: astore_2
    //   1558: aload 16
    //   1560: astore_0
    //   1561: aload 13
    //   1563: astore 14
    //   1565: aload_2
    //   1566: ldc_w 293
    //   1569: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: pop
    //   1573: aload 16
    //   1575: astore_0
    //   1576: aload 13
    //   1578: astore 14
    //   1580: aload_2
    //   1581: aload_1
    //   1582: invokevirtual 296	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1585: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1588: pop
    //   1589: aload 16
    //   1591: astore_0
    //   1592: aload 13
    //   1594: astore 14
    //   1596: ldc 48
    //   1598: iconst_1
    //   1599: aload_2
    //   1600: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1603: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1606: aload 16
    //   1608: astore_0
    //   1609: aload 13
    //   1611: astore 14
    //   1613: aload 4
    //   1615: iload 7
    //   1617: aload 22
    //   1619: aload_1
    //   1620: invokevirtual 297	java/io/IOException:toString	()Ljava/lang/String;
    //   1623: invokevirtual 120	java/lang/String:getBytes	()[B
    //   1626: invokeinterface 287 4 0
    //   1631: ldc 48
    //   1633: iconst_1
    //   1634: aload 21
    //   1636: invokevirtual 288	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1639: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1642: aload 16
    //   1644: ifnull +16 -> 1660
    //   1647: aload 16
    //   1649: invokevirtual 163	java/io/OutputStream:close	()V
    //   1652: goto +8 -> 1660
    //   1655: astore_0
    //   1656: aload_0
    //   1657: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   1660: aload 13
    //   1662: ifnull +6 -> 1668
    //   1665: goto -132 -> 1533
    //   1668: return
    //   1669: astore_1
    //   1670: ldc 48
    //   1672: iconst_1
    //   1673: aload 21
    //   1675: invokevirtual 288	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1678: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1681: aload_0
    //   1682: ifnull +15 -> 1697
    //   1685: aload_0
    //   1686: invokevirtual 163	java/io/OutputStream:close	()V
    //   1689: goto +8 -> 1697
    //   1692: astore_0
    //   1693: aload_0
    //   1694: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   1697: aload 14
    //   1699: ifnull +8 -> 1707
    //   1702: aload 14
    //   1704: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   1707: goto +5 -> 1712
    //   1710: aload_1
    //   1711: athrow
    //   1712: goto -2 -> 1710
    //   1715: iload 10
    //   1717: iconst_1
    //   1718: iadd
    //   1719: istore 10
    //   1721: goto -1270 -> 451
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1724	0	paramString1	String
    //   0	1724	1	paramString2	String
    //   0	1724	2	paramArrayOfString	String[]
    //   0	1724	3	paramArrayOfByte	byte[]
    //   0	1724	4	paramApolloHttpResponseCallback	ApolloHttpResponseCallback
    //   0	1724	5	paramApolloHttpProgressCallback1	ApolloHttpProgressCallback
    //   0	1724	6	paramApolloHttpProgressCallback2	ApolloHttpProgressCallback
    //   49	1567	7	i	int
    //   73	1311	8	j	int
    //   81	1311	9	k	int
    //   449	1271	10	m	int
    //   411	423	11	n	int
    //   711	116	12	i1	int
    //   65	1596	13	localHttpURLConnection	HttpURLConnection
    //   43	1660	14	localObject1	Object
    //   34	1482	15	localObject2	Object
    //   37	1611	16	localObject3	Object
    //   28	633	17	localObject4	Object
    //   31	638	18	localObject5	Object
    //   40	637	19	localObject6	Object
    //   46	487	20	localObject7	Object
    //   18	1656	21	localStringBuffer	java.lang.StringBuffer
    //   7	1611	22	localHashMap	HashMap
    //   124	66	23	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   1362	1366	1369	java/io/IOException
    //   90	98	1382	java/lang/Throwable
    //   121	126	1382	java/lang/Throwable
    //   154	161	1382	java/lang/Throwable
    //   184	194	1382	java/lang/Throwable
    //   217	225	1382	java/lang/Throwable
    //   251	259	1382	java/lang/Throwable
    //   282	290	1382	java/lang/Throwable
    //   313	319	1382	java/lang/Throwable
    //   342	350	1382	java/lang/Throwable
    //   373	381	1382	java/lang/Throwable
    //   404	410	1382	java/lang/Throwable
    //   436	442	1382	java/lang/Throwable
    //   474	481	1382	java/lang/Throwable
    //   519	529	1382	java/lang/Throwable
    //   562	570	1382	java/lang/Throwable
    //   593	601	1382	java/lang/Throwable
    //   624	630	1382	java/lang/Throwable
    //   653	660	1382	java/lang/Throwable
    //   683	689	1382	java/lang/Throwable
    //   709	713	1382	java/lang/Throwable
    //   744	757	1382	java/lang/Throwable
    //   777	786	1382	java/lang/Throwable
    //   822	833	1382	java/lang/Throwable
    //   860	864	1382	java/lang/Throwable
    //   884	891	1382	java/lang/Throwable
    //   911	917	1382	java/lang/Throwable
    //   937	945	1382	java/lang/Throwable
    //   965	973	1382	java/lang/Throwable
    //   993	1001	1382	java/lang/Throwable
    //   1021	1028	1382	java/lang/Throwable
    //   1048	1060	1382	java/lang/Throwable
    //   1080	1089	1382	java/lang/Throwable
    //   1109	1120	1382	java/lang/Throwable
    //   1140	1151	1382	java/lang/Throwable
    //   1171	1183	1382	java/lang/Throwable
    //   1212	1227	1382	java/lang/Throwable
    //   1250	1258	1382	java/lang/Throwable
    //   1278	1287	1382	java/lang/Throwable
    //   1307	1315	1382	java/lang/Throwable
    //   1335	1347	1382	java/lang/Throwable
    //   90	98	1390	java/io/IOException
    //   121	126	1390	java/io/IOException
    //   154	161	1390	java/io/IOException
    //   184	194	1390	java/io/IOException
    //   217	225	1390	java/io/IOException
    //   251	259	1390	java/io/IOException
    //   282	290	1390	java/io/IOException
    //   313	319	1390	java/io/IOException
    //   342	350	1390	java/io/IOException
    //   373	381	1390	java/io/IOException
    //   404	410	1390	java/io/IOException
    //   436	442	1390	java/io/IOException
    //   474	481	1390	java/io/IOException
    //   519	529	1390	java/io/IOException
    //   562	570	1390	java/io/IOException
    //   593	601	1390	java/io/IOException
    //   624	630	1390	java/io/IOException
    //   653	660	1390	java/io/IOException
    //   683	689	1390	java/io/IOException
    //   709	713	1390	java/io/IOException
    //   744	757	1390	java/io/IOException
    //   777	786	1390	java/io/IOException
    //   822	833	1390	java/io/IOException
    //   860	864	1390	java/io/IOException
    //   884	891	1390	java/io/IOException
    //   911	917	1390	java/io/IOException
    //   937	945	1390	java/io/IOException
    //   965	973	1390	java/io/IOException
    //   993	1001	1390	java/io/IOException
    //   1021	1028	1390	java/io/IOException
    //   1048	1060	1390	java/io/IOException
    //   1080	1089	1390	java/io/IOException
    //   1109	1120	1390	java/io/IOException
    //   1140	1151	1390	java/io/IOException
    //   1171	1183	1390	java/io/IOException
    //   1212	1227	1390	java/io/IOException
    //   1250	1258	1390	java/io/IOException
    //   1278	1287	1390	java/io/IOException
    //   1307	1315	1390	java/io/IOException
    //   1335	1347	1390	java/io/IOException
    //   51	67	1398	finally
    //   51	67	1410	java/lang/Throwable
    //   1515	1520	1523	java/io/IOException
    //   51	67	1539	java/io/IOException
    //   1647	1652	1655	java/io/IOException
    //   90	98	1669	finally
    //   121	126	1669	finally
    //   154	161	1669	finally
    //   184	194	1669	finally
    //   217	225	1669	finally
    //   251	259	1669	finally
    //   282	290	1669	finally
    //   313	319	1669	finally
    //   342	350	1669	finally
    //   373	381	1669	finally
    //   404	410	1669	finally
    //   436	442	1669	finally
    //   474	481	1669	finally
    //   519	529	1669	finally
    //   562	570	1669	finally
    //   593	601	1669	finally
    //   624	630	1669	finally
    //   653	660	1669	finally
    //   683	689	1669	finally
    //   709	713	1669	finally
    //   744	757	1669	finally
    //   777	786	1669	finally
    //   822	833	1669	finally
    //   860	864	1669	finally
    //   884	891	1669	finally
    //   911	917	1669	finally
    //   937	945	1669	finally
    //   965	973	1669	finally
    //   993	1001	1669	finally
    //   1021	1028	1669	finally
    //   1048	1060	1669	finally
    //   1080	1089	1669	finally
    //   1109	1120	1669	finally
    //   1140	1151	1669	finally
    //   1171	1183	1669	finally
    //   1212	1227	1669	finally
    //   1250	1258	1669	finally
    //   1278	1287	1669	finally
    //   1307	1315	1669	finally
    //   1335	1347	1669	finally
    //   1421	1429	1669	finally
    //   1436	1444	1669	finally
    //   1451	1457	1669	finally
    //   1464	1474	1669	finally
    //   1481	1499	1669	finally
    //   1550	1558	1669	finally
    //   1565	1573	1669	finally
    //   1580	1589	1669	finally
    //   1596	1606	1669	finally
    //   1613	1631	1669	finally
    //   1685	1689	1692	java/io/IOException
  }
  
  /* Error */
  public static void a(String paramString, String[] paramArrayOfString, com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ApolloHttpCallBack paramApolloHttpCallBack)
  {
    // Byte code:
    //   0: new 36	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 303
    //   7: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
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
    //   40: invokestatic 309	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   43: aload_0
    //   44: ldc_w 311
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
    //   85: ldc_w 313
    //   88: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: goto +12 -> 104
    //   95: aload 10
    //   97: ldc_w 315
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
    //   144: goto +510 -> 654
    //   147: aload_0
    //   148: aload 5
    //   150: aload_1
    //   151: iload_3
    //   152: aaload
    //   153: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto +498 -> 654
    //   159: aload_0
    //   160: invokevirtual 133	java/net/HttpURLConnection:getResponseCode	()I
    //   163: istore_3
    //   164: aload 10
    //   166: ldc_w 317
    //   169: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 10
    //   175: iload_3
    //   176: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 10
    //   182: ldc 230
    //   184: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 10
    //   190: aload_0
    //   191: invokevirtual 226	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   194: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_0
    //   199: invokevirtual 137	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   202: astore_1
    //   203: new 139	java/io/ByteArrayOutputStream
    //   206: dup
    //   207: invokespecial 140	java/io/ByteArrayOutputStream:<init>	()V
    //   210: astore 9
    //   212: aload_1
    //   213: astore 5
    //   215: aload 9
    //   217: astore 6
    //   219: aload_0
    //   220: astore 7
    //   222: sipush 1024
    //   225: newarray byte
    //   227: astore 8
    //   229: aload_1
    //   230: astore 5
    //   232: aload 9
    //   234: astore 6
    //   236: aload_0
    //   237: astore 7
    //   239: aload_1
    //   240: aload 8
    //   242: invokevirtual 146	java/io/InputStream:read	([B)I
    //   245: istore 4
    //   247: iload 4
    //   249: iconst_m1
    //   250: if_icmpeq +26 -> 276
    //   253: aload_1
    //   254: astore 5
    //   256: aload 9
    //   258: astore 6
    //   260: aload_0
    //   261: astore 7
    //   263: aload 9
    //   265: aload 8
    //   267: iconst_0
    //   268: iload 4
    //   270: invokevirtual 149	java/io/ByteArrayOutputStream:write	([BII)V
    //   273: goto -44 -> 229
    //   276: aload_1
    //   277: astore 5
    //   279: aload 9
    //   281: astore 6
    //   283: aload_0
    //   284: astore 7
    //   286: aload 10
    //   288: ldc_w 322
    //   291: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_1
    //   296: astore 5
    //   298: aload 9
    //   300: astore 6
    //   302: aload_0
    //   303: astore 7
    //   305: aload 10
    //   307: aload 9
    //   309: invokevirtual 325	java/io/ByteArrayOutputStream:size	()I
    //   312: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_2
    //   317: ifnull +25 -> 342
    //   320: aload_1
    //   321: astore 5
    //   323: aload 9
    //   325: astore 6
    //   327: aload_0
    //   328: astore 7
    //   330: aload_2
    //   331: iload_3
    //   332: aload 9
    //   334: invokevirtual 152	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   337: invokeinterface 157 3 0
    //   342: aload_0
    //   343: ifnull +7 -> 350
    //   346: aload_0
    //   347: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   350: aload_1
    //   351: ifnull +22 -> 373
    //   354: aload_1
    //   355: invokevirtual 168	java/io/InputStream:close	()V
    //   358: goto +15 -> 373
    //   361: astore_0
    //   362: ldc 48
    //   364: iconst_1
    //   365: aload_0
    //   366: iconst_0
    //   367: anewarray 4	java/lang/Object
    //   370: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   373: aload 9
    //   375: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   378: goto +243 -> 621
    //   381: astore_0
    //   382: ldc 48
    //   384: iconst_1
    //   385: aload_0
    //   386: iconst_0
    //   387: anewarray 4	java/lang/Object
    //   390: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   393: goto +228 -> 621
    //   396: aload_1
    //   397: astore 8
    //   399: aload 9
    //   401: astore_1
    //   402: goto +59 -> 461
    //   405: astore_2
    //   406: aconst_null
    //   407: astore 6
    //   409: aload_1
    //   410: astore 5
    //   412: aload_2
    //   413: astore_1
    //   414: goto +76 -> 490
    //   417: aconst_null
    //   418: astore 5
    //   420: aload_1
    //   421: astore 8
    //   423: aload 5
    //   425: astore_1
    //   426: goto +35 -> 461
    //   429: astore_1
    //   430: aconst_null
    //   431: astore 6
    //   433: aload 7
    //   435: astore_2
    //   436: goto +57 -> 493
    //   439: goto +17 -> 456
    //   442: astore_1
    //   443: aconst_null
    //   444: astore_0
    //   445: aload_0
    //   446: astore 6
    //   448: aload 7
    //   450: astore_2
    //   451: goto +42 -> 493
    //   454: aconst_null
    //   455: astore_0
    //   456: aconst_null
    //   457: astore 8
    //   459: aconst_null
    //   460: astore_1
    //   461: aload_2
    //   462: ifnull +103 -> 565
    //   465: aload 8
    //   467: astore 5
    //   469: aload_1
    //   470: astore 6
    //   472: aload_0
    //   473: astore 7
    //   475: aload_2
    //   476: iconst_m1
    //   477: aconst_null
    //   478: invokeinterface 157 3 0
    //   483: goto +82 -> 565
    //   486: astore_1
    //   487: aload 7
    //   489: astore_0
    //   490: aload 5
    //   492: astore_2
    //   493: aload_0
    //   494: ifnull +7 -> 501
    //   497: aload_0
    //   498: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   501: aload_2
    //   502: ifnull +22 -> 524
    //   505: aload_2
    //   506: invokevirtual 168	java/io/InputStream:close	()V
    //   509: goto +15 -> 524
    //   512: astore_0
    //   513: ldc 48
    //   515: iconst_1
    //   516: aload_0
    //   517: iconst_0
    //   518: anewarray 4	java/lang/Object
    //   521: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   524: aload 6
    //   526: ifnull +23 -> 549
    //   529: aload 6
    //   531: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   534: goto +15 -> 549
    //   537: astore_0
    //   538: ldc 48
    //   540: iconst_1
    //   541: aload_0
    //   542: iconst_0
    //   543: anewarray 4	java/lang/Object
    //   546: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   549: invokestatic 328	android/net/TrafficStats:clearThreadStatsTag	()V
    //   552: ldc 48
    //   554: iconst_1
    //   555: aload 10
    //   557: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: aload_1
    //   564: athrow
    //   565: aload_0
    //   566: ifnull +7 -> 573
    //   569: aload_0
    //   570: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   573: aload 8
    //   575: ifnull +23 -> 598
    //   578: aload 8
    //   580: invokevirtual 168	java/io/InputStream:close	()V
    //   583: goto +15 -> 598
    //   586: astore_0
    //   587: ldc 48
    //   589: iconst_1
    //   590: aload_0
    //   591: iconst_0
    //   592: anewarray 4	java/lang/Object
    //   595: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   598: aload_1
    //   599: ifnull +22 -> 621
    //   602: aload_1
    //   603: invokevirtual 169	java/io/ByteArrayOutputStream:close	()V
    //   606: goto +15 -> 621
    //   609: astore_0
    //   610: ldc 48
    //   612: iconst_1
    //   613: aload_0
    //   614: iconst_0
    //   615: anewarray 4	java/lang/Object
    //   618: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   621: invokestatic 328	android/net/TrafficStats:clearThreadStatsTag	()V
    //   624: ldc 48
    //   626: iconst_1
    //   627: aload 10
    //   629: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: return
    //   636: astore_0
    //   637: goto -183 -> 454
    //   640: astore_1
    //   641: goto -202 -> 439
    //   644: astore 5
    //   646: goto -229 -> 417
    //   649: astore 5
    //   651: goto -255 -> 396
    //   654: iload_3
    //   655: iconst_1
    //   656: iadd
    //   657: istore_3
    //   658: goto -531 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	paramString	String
    //   0	661	1	paramArrayOfString	String[]
    //   0	661	2	paramApolloHttpCallBack	com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ApolloHttpCallBack
    //   126	532	3	i	int
    //   245	24	4	j	int
    //   60	431	5	localObject1	Object
    //   644	1	5	localException1	Exception
    //   649	1	5	localException2	Exception
    //   217	313	6	localObject2	Object
    //   20	468	7	str	String
    //   227	352	8	localObject3	Object
    //   210	190	9	localByteArrayOutputStream	ByteArrayOutputStream
    //   10	618	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   354	358	361	java/io/IOException
    //   373	378	381	java/io/IOException
    //   203	212	405	finally
    //   37	62	429	finally
    //   67	92	429	finally
    //   95	104	429	finally
    //   104	118	429	finally
    //   127	133	429	finally
    //   147	156	429	finally
    //   159	203	429	finally
    //   22	37	442	finally
    //   222	229	486	finally
    //   239	247	486	finally
    //   263	273	486	finally
    //   286	295	486	finally
    //   305	316	486	finally
    //   330	342	486	finally
    //   475	483	486	finally
    //   505	509	512	java/io/IOException
    //   529	534	537	java/io/IOException
    //   578	583	586	java/io/IOException
    //   602	606	609	java/io/IOException
    //   22	37	636	java/lang/Exception
    //   37	62	640	java/lang/Exception
    //   67	92	640	java/lang/Exception
    //   95	104	640	java/lang/Exception
    //   104	118	640	java/lang/Exception
    //   127	133	640	java/lang/Exception
    //   147	156	640	java/lang/Exception
    //   159	203	640	java/lang/Exception
    //   203	212	644	java/lang/Exception
    //   222	229	649	java/lang/Exception
    //   239	247	649	java/lang/Exception
    //   263	273	649	java/lang/Exception
    //   286	295	649	java/lang/Exception
    //   305	316	649	java/lang/Exception
    //   330	342	649	java/lang/Exception
  }
  
  private static void a(@NonNull String paramString, @Nullable String[] paramArrayOfString, @NonNull ApolloHttpResponseCallback paramApolloHttpResponseCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ApolloConstant.a);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    localObject = new File(paramString);
    if (((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest file exists:", ((File)localObject).getAbsolutePath() });
      }
      paramArrayOfString = b(paramArrayOfString);
      if (a(paramString)) {
        paramApolloHttpResponseCallback.a(0, paramArrayOfString, b((File)localObject, paramArrayOfString));
      } else {
        paramApolloHttpResponseCallback.a(0, paramArrayOfString, b(new FileInputStream((File)localObject)));
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retHeader:", paramArrayOfString });
      }
    }
    else
    {
      QLog.d("[cmshow]ApolloHttpUtil", 1, new Object[] { "fakeResource3DUrlRequest file no exists", ((File)localObject).getAbsolutePath() });
    }
  }
  
  public static void a(@NonNull String paramString, @Nullable String[] paramArrayOfString, @NonNull ApolloHttpResponseCallback paramApolloHttpResponseCallback, @NonNull IApolloResManager paramIApolloResManager)
  {
    if (paramApolloHttpResponseCallback == null)
    {
      QLog.e("[cmshow]ApolloHttpUtil", 1, "fakeResource3DUrlRequest return, callback is null!");
      return;
    }
    paramString = b(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      paramApolloHttpResponseCallback.a(-1, null, null);
      return;
    }
    try
    {
      if (paramString.startsWith("Role:"))
      {
        b(paramString, paramArrayOfString, paramApolloHttpResponseCallback, paramIApolloResManager);
        return;
      }
      if (paramString.startsWith("Dress:"))
      {
        c(paramString, paramArrayOfString, paramApolloHttpResponseCallback, paramIApolloResManager);
        return;
      }
      if (paramString.startsWith("def/role/0/3D/"))
      {
        a(paramString, paramArrayOfString, paramApolloHttpResponseCallback);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow]ApolloHttpUtil", 1, paramString, new Object[0]);
    }
  }
  
  private static void a(@Nullable String[] paramArrayOfString, @NonNull ApolloHttpResponseCallback paramApolloHttpResponseCallback, @NonNull IApolloResManager paramIApolloResManager, String paramString, int paramInt)
  {
    paramIApolloResManager.a().b(CmGameUtil.b(), null, new ApolloHttpUtil.1(paramString, paramArrayOfString, paramApolloHttpResponseCallback), paramInt, null, -1, -1, false);
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
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest urlString:", paramString });
    }
    int i = paramString.indexOf("http://stubcmshow.qq.com/cm3d/");
    String str;
    if (i >= 0) {
      str = paramString.substring(i + 30);
    } else {
      str = paramString;
    }
    i = paramString.indexOf("https://stubcmshow.qq.com/cm3d/");
    if (i >= 0) {
      str = paramString.substring(i + 31);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest urlString: ", paramString, ", localUrl: ", str });
    }
    return str;
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
  
  private static void b(@NonNull String paramString, @Nullable String[] paramArrayOfString, @NonNull ApolloHttpResponseCallback paramApolloHttpResponseCallback, @NonNull IApolloResManager paramIApolloResManager)
  {
    paramString = paramString.substring(7);
    int i = paramString.indexOf("/");
    if (i > 0)
    {
      int j = ApolloUtilImpl.parseToInt(paramString.substring(0, i));
      paramString = paramString.substring(i + 1);
      if (TextUtils.isEmpty(paramString))
      {
        paramApolloHttpResponseCallback.a(-1, null, null);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest file exists:", ((File)localObject).getAbsolutePath() });
        }
        paramArrayOfString = b(paramArrayOfString);
        if (a(paramString))
        {
          paramString = b((File)localObject, paramArrayOfString);
          paramApolloHttpResponseCallback.a(0, paramArrayOfString, paramString);
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retByteArray:", Integer.valueOf(paramString.length) });
          }
        }
        else
        {
          paramApolloHttpResponseCallback.a(0, paramArrayOfString, b(new FileInputStream((File)localObject)));
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retHeader:", paramArrayOfString });
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fakeResource3DUrlRequest start download id:");
        ((StringBuilder)localObject).append(j);
        QLog.d("[cmshow]ApolloHttpUtil", 1, ((StringBuilder)localObject).toString());
        a(paramArrayOfString, paramApolloHttpResponseCallback, paramIApolloResManager, paramString, j);
      }
    }
  }
  
  private static void b(@Nullable String[] paramArrayOfString, @NonNull ApolloHttpResponseCallback paramApolloHttpResponseCallback, @NonNull IApolloResManager paramIApolloResManager, String paramString, int paramInt)
  {
    paramIApolloResManager.a().b(CmGameUtil.b(), null, new ApolloHttpUtil.2(paramString, paramArrayOfString, paramApolloHttpResponseCallback, paramInt), -1, new int[] { paramInt }, -1, -1, true);
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
  
  private static void c(@NonNull String paramString, @Nullable String[] paramArrayOfString, @NonNull ApolloHttpResponseCallback paramApolloHttpResponseCallback, @NonNull IApolloResManager paramIApolloResManager)
  {
    paramString = paramString.substring(8);
    int i = paramString.indexOf("/");
    if (i > 0)
    {
      int j = ApolloUtilImpl.parseToInt(paramString.substring(0, i));
      paramString = paramString.substring(i + 1);
      if (TextUtils.isEmpty(paramString))
      {
        paramApolloHttpResponseCallback.a(-1, null, null);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest file exists:", ((File)localObject).getAbsolutePath() });
        }
        paramArrayOfString = b(paramArrayOfString);
        if (a(paramString)) {
          paramApolloHttpResponseCallback.a(0, paramArrayOfString, b((File)localObject, paramArrayOfString));
        } else {
          paramApolloHttpResponseCallback.a(0, paramArrayOfString, b(new FileInputStream((File)localObject)));
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retHeader:", paramArrayOfString });
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fakeResource3DUrlRequest start download id:");
        ((StringBuilder)localObject).append(j);
        QLog.d("[cmshow]ApolloHttpUtil", 1, ((StringBuilder)localObject).toString());
        b(paramArrayOfString, paramApolloHttpResponseCallback, paramIApolloResManager, paramString, j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloHttpUtil
 * JD-Core Version:    0.7.0.1
 */