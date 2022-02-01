package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public abstract class e
{
  /* Error */
  public static String a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +17 -> 18
    //   4: aload_1
    //   5: invokestatic 18	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifne +10 -> 18
    //   11: aload_2
    //   12: invokestatic 18	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: iconst_m1
    //   21: istore 4
    //   23: aload_0
    //   24: aload_1
    //   25: aload_3
    //   26: getstatic 24	com/huawei/hms/opendevice/e$a:b	Lcom/huawei/hms/opendevice/e$a;
    //   29: invokevirtual 27	com/huawei/hms/opendevice/e$a:a	()Ljava/lang/String;
    //   32: invokestatic 30	com/huawei/hms/opendevice/e:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   35: astore_1
    //   36: aload_1
    //   37: ifnonnull +28 -> 65
    //   40: aconst_null
    //   41: invokestatic 36	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   44: aconst_null
    //   45: invokestatic 39	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   48: aconst_null
    //   49: invokestatic 39	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   52: aload_1
    //   53: invokestatic 44	com/huawei/hms/opendevice/s:a	(Ljava/net/HttpURLConnection;)V
    //   56: ldc 46
    //   58: ldc 48
    //   60: invokestatic 54	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aconst_null
    //   64: areturn
    //   65: new 56	java/io/BufferedOutputStream
    //   68: dup
    //   69: aload_1
    //   70: invokevirtual 62	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   73: invokespecial 65	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   76: astore_3
    //   77: iload 4
    //   79: istore 5
    //   81: iload 4
    //   83: istore 6
    //   85: iload 4
    //   87: istore 7
    //   89: aload_3
    //   90: aload_2
    //   91: ldc 67
    //   93: invokevirtual 73	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   96: invokevirtual 79	java/io/OutputStream:write	([B)V
    //   99: iload 4
    //   101: istore 5
    //   103: iload 4
    //   105: istore 6
    //   107: iload 4
    //   109: istore 7
    //   111: aload_3
    //   112: invokevirtual 83	java/io/OutputStream:flush	()V
    //   115: iload 4
    //   117: istore 5
    //   119: iload 4
    //   121: istore 6
    //   123: iload 4
    //   125: istore 7
    //   127: aload_1
    //   128: invokevirtual 87	java/net/HttpURLConnection:getResponseCode	()I
    //   131: istore 4
    //   133: iload 4
    //   135: istore 5
    //   137: iload 4
    //   139: istore 6
    //   141: iload 4
    //   143: istore 7
    //   145: ldc 46
    //   147: new 89	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   154: ldc 93
    //   156: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload 4
    //   161: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 106	com/huawei/hms/support/log/HMSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: iload 4
    //   172: sipush 400
    //   175: if_icmplt +76 -> 251
    //   178: iload 4
    //   180: istore 5
    //   182: iload 4
    //   184: istore 6
    //   186: iload 4
    //   188: istore 7
    //   190: aload_1
    //   191: invokevirtual 110	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   194: astore_0
    //   195: new 112	java/io/BufferedInputStream
    //   198: dup
    //   199: aload_0
    //   200: invokespecial 114	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   203: astore 11
    //   205: aload_1
    //   206: astore 10
    //   208: aload 11
    //   210: astore 9
    //   212: aload_0
    //   213: astore 8
    //   215: aload_3
    //   216: astore_2
    //   217: aload 11
    //   219: invokestatic 117	com/huawei/hms/opendevice/s:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   222: astore 12
    //   224: aload_3
    //   225: invokestatic 36	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   228: aload_0
    //   229: invokestatic 39	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   232: aload 11
    //   234: invokestatic 39	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   237: aload_1
    //   238: invokestatic 44	com/huawei/hms/opendevice/s:a	(Ljava/net/HttpURLConnection;)V
    //   241: ldc 46
    //   243: ldc 48
    //   245: invokestatic 54	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload 12
    //   250: areturn
    //   251: iload 4
    //   253: istore 5
    //   255: iload 4
    //   257: istore 6
    //   259: iload 4
    //   261: istore 7
    //   263: aload_1
    //   264: invokevirtual 120	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   267: astore_0
    //   268: goto -73 -> 195
    //   271: astore_0
    //   272: aconst_null
    //   273: astore 12
    //   275: aconst_null
    //   276: astore_1
    //   277: aconst_null
    //   278: astore_0
    //   279: aconst_null
    //   280: astore_3
    //   281: aload 12
    //   283: astore 10
    //   285: aload_1
    //   286: astore 9
    //   288: aload_0
    //   289: astore 8
    //   291: aload_3
    //   292: astore_2
    //   293: ldc 46
    //   295: new 89	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   302: ldc 122
    //   304: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: iload 4
    //   309: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   312: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 125	com/huawei/hms/support/log/HMSLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: aload_3
    //   319: invokestatic 36	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   322: aload_0
    //   323: invokestatic 39	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   326: aload_1
    //   327: invokestatic 39	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   330: aload 12
    //   332: invokestatic 44	com/huawei/hms/opendevice/s:a	(Ljava/net/HttpURLConnection;)V
    //   335: ldc 46
    //   337: ldc 48
    //   339: invokestatic 54	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: aconst_null
    //   343: areturn
    //   344: astore_0
    //   345: aconst_null
    //   346: astore 12
    //   348: aconst_null
    //   349: astore_1
    //   350: aconst_null
    //   351: astore_0
    //   352: aconst_null
    //   353: astore_3
    //   354: aload 12
    //   356: astore 10
    //   358: aload_1
    //   359: astore 9
    //   361: aload_0
    //   362: astore 8
    //   364: aload_3
    //   365: astore_2
    //   366: ldc 46
    //   368: new 89	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   375: ldc 127
    //   377: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: iload 4
    //   382: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 125	com/huawei/hms/support/log/HMSLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload_3
    //   392: invokestatic 36	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   395: aload_0
    //   396: invokestatic 39	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   399: aload_1
    //   400: invokestatic 39	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   403: aload 12
    //   405: invokestatic 44	com/huawei/hms/opendevice/s:a	(Ljava/net/HttpURLConnection;)V
    //   408: ldc 46
    //   410: ldc 48
    //   412: invokestatic 54	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   415: aconst_null
    //   416: areturn
    //   417: astore_0
    //   418: aconst_null
    //   419: astore 12
    //   421: aconst_null
    //   422: astore_1
    //   423: aconst_null
    //   424: astore_0
    //   425: aconst_null
    //   426: astore_3
    //   427: aload 12
    //   429: astore 10
    //   431: aload_1
    //   432: astore 9
    //   434: aload_0
    //   435: astore 8
    //   437: aload_3
    //   438: astore_2
    //   439: ldc 46
    //   441: new 89	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   448: ldc 129
    //   450: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: iload 4
    //   455: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 125	com/huawei/hms/support/log/HMSLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: aload_3
    //   465: invokestatic 36	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   468: aload_0
    //   469: invokestatic 39	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   472: aload_1
    //   473: invokestatic 39	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   476: aload 12
    //   478: invokestatic 44	com/huawei/hms/opendevice/s:a	(Ljava/net/HttpURLConnection;)V
    //   481: ldc 46
    //   483: ldc 48
    //   485: invokestatic 54	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: aconst_null
    //   489: areturn
    //   490: astore 11
    //   492: aconst_null
    //   493: astore_1
    //   494: aconst_null
    //   495: astore 9
    //   497: aconst_null
    //   498: astore_0
    //   499: aconst_null
    //   500: astore_2
    //   501: aload_2
    //   502: invokestatic 36	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   505: aload_0
    //   506: invokestatic 39	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   509: aload 9
    //   511: invokestatic 39	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   514: aload_1
    //   515: invokestatic 44	com/huawei/hms/opendevice/s:a	(Ljava/net/HttpURLConnection;)V
    //   518: ldc 46
    //   520: ldc 48
    //   522: invokestatic 54	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload 11
    //   527: athrow
    //   528: astore 11
    //   530: aconst_null
    //   531: astore 9
    //   533: aconst_null
    //   534: astore_0
    //   535: aconst_null
    //   536: astore_2
    //   537: goto -36 -> 501
    //   540: astore 11
    //   542: aconst_null
    //   543: astore 9
    //   545: aconst_null
    //   546: astore_0
    //   547: aload_3
    //   548: astore_2
    //   549: goto -48 -> 501
    //   552: astore 11
    //   554: aconst_null
    //   555: astore 9
    //   557: aload_3
    //   558: astore_2
    //   559: goto -58 -> 501
    //   562: astore 11
    //   564: aload 10
    //   566: astore_1
    //   567: aload 8
    //   569: astore_0
    //   570: goto -69 -> 501
    //   573: astore_0
    //   574: aconst_null
    //   575: astore_2
    //   576: aconst_null
    //   577: astore_0
    //   578: aconst_null
    //   579: astore_3
    //   580: aload_1
    //   581: astore 12
    //   583: aload_2
    //   584: astore_1
    //   585: goto -158 -> 427
    //   588: astore_0
    //   589: aconst_null
    //   590: astore_2
    //   591: aconst_null
    //   592: astore_0
    //   593: iload 5
    //   595: istore 4
    //   597: aload_1
    //   598: astore 12
    //   600: aload_2
    //   601: astore_1
    //   602: goto -175 -> 427
    //   605: astore_2
    //   606: aconst_null
    //   607: astore_2
    //   608: aload_1
    //   609: astore 12
    //   611: aload_2
    //   612: astore_1
    //   613: goto -186 -> 427
    //   616: astore_2
    //   617: aload_1
    //   618: astore 12
    //   620: aload 11
    //   622: astore_1
    //   623: goto -196 -> 427
    //   626: astore_0
    //   627: aconst_null
    //   628: astore_2
    //   629: aconst_null
    //   630: astore_0
    //   631: aconst_null
    //   632: astore_3
    //   633: aload_1
    //   634: astore 12
    //   636: aload_2
    //   637: astore_1
    //   638: goto -284 -> 354
    //   641: astore_0
    //   642: aconst_null
    //   643: astore_2
    //   644: aconst_null
    //   645: astore_0
    //   646: iload 6
    //   648: istore 4
    //   650: aload_1
    //   651: astore 12
    //   653: aload_2
    //   654: astore_1
    //   655: goto -301 -> 354
    //   658: astore_2
    //   659: aconst_null
    //   660: astore_2
    //   661: aload_1
    //   662: astore 12
    //   664: aload_2
    //   665: astore_1
    //   666: goto -312 -> 354
    //   669: astore_2
    //   670: aload_1
    //   671: astore 12
    //   673: aload 11
    //   675: astore_1
    //   676: goto -322 -> 354
    //   679: astore_0
    //   680: aconst_null
    //   681: astore_2
    //   682: aconst_null
    //   683: astore_0
    //   684: aconst_null
    //   685: astore_3
    //   686: aload_1
    //   687: astore 12
    //   689: aload_2
    //   690: astore_1
    //   691: goto -410 -> 281
    //   694: astore_0
    //   695: aconst_null
    //   696: astore_2
    //   697: aconst_null
    //   698: astore_0
    //   699: iload 7
    //   701: istore 4
    //   703: aload_1
    //   704: astore 12
    //   706: aload_2
    //   707: astore_1
    //   708: goto -427 -> 281
    //   711: astore_2
    //   712: aconst_null
    //   713: astore_2
    //   714: aload_1
    //   715: astore 12
    //   717: aload_2
    //   718: astore_1
    //   719: goto -438 -> 281
    //   722: astore_2
    //   723: aload_1
    //   724: astore 12
    //   726: aload 11
    //   728: astore_1
    //   729: goto -448 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	732	0	paramContext	Context
    //   0	732	1	paramString1	String
    //   0	732	2	paramString2	String
    //   0	732	3	paramMap	Map<String, String>
    //   21	681	4	i	int
    //   79	515	5	j	int
    //   83	564	6	k	int
    //   87	613	7	m	int
    //   213	355	8	localContext	Context
    //   210	346	9	localObject1	Object
    //   206	359	10	localObject2	Object
    //   203	30	11	localBufferedInputStream	java.io.BufferedInputStream
    //   490	36	11	localObject3	Object
    //   528	1	11	localObject4	Object
    //   540	1	11	localObject5	Object
    //   552	1	11	localObject6	Object
    //   562	165	11	localObject7	Object
    //   222	503	12	str	String
    // Exception table:
    //   from	to	target	type
    //   23	36	271	java/io/IOException
    //   23	36	344	java/lang/RuntimeException
    //   23	36	417	java/lang/Exception
    //   23	36	490	finally
    //   65	77	528	finally
    //   89	99	540	finally
    //   111	115	540	finally
    //   127	133	540	finally
    //   145	170	540	finally
    //   190	195	540	finally
    //   263	268	540	finally
    //   195	205	552	finally
    //   217	224	562	finally
    //   293	318	562	finally
    //   366	391	562	finally
    //   439	464	562	finally
    //   65	77	573	java/lang/Exception
    //   89	99	588	java/lang/Exception
    //   111	115	588	java/lang/Exception
    //   127	133	588	java/lang/Exception
    //   145	170	588	java/lang/Exception
    //   190	195	588	java/lang/Exception
    //   263	268	588	java/lang/Exception
    //   195	205	605	java/lang/Exception
    //   217	224	616	java/lang/Exception
    //   65	77	626	java/lang/RuntimeException
    //   89	99	641	java/lang/RuntimeException
    //   111	115	641	java/lang/RuntimeException
    //   127	133	641	java/lang/RuntimeException
    //   145	170	641	java/lang/RuntimeException
    //   190	195	641	java/lang/RuntimeException
    //   263	268	641	java/lang/RuntimeException
    //   195	205	658	java/lang/RuntimeException
    //   217	224	669	java/lang/RuntimeException
    //   65	77	679	java/io/IOException
    //   89	99	694	java/io/IOException
    //   111	115	694	java/io/IOException
    //   127	133	694	java/io/IOException
    //   145	170	694	java/io/IOException
    //   190	195	694	java/io/IOException
    //   263	268	694	java/io/IOException
    //   195	205	711	java/io/IOException
    //   217	224	722	java/io/IOException
  }
  
  private static HttpURLConnection a(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2)
  {
    paramString1 = (HttpURLConnection)new URL(paramString1).openConnection();
    a(paramContext, paramString1);
    paramString1.setRequestMethod(paramString2);
    paramString1.setConnectTimeout(15000);
    paramString1.setReadTimeout(15000);
    paramString1.setDoOutput(true);
    paramString1.setDoInput(true);
    paramString1.setRequestProperty("Content-type", "application/json; charset=UTF-8");
    paramString1.setRequestProperty("Connection", "close");
    if ((paramMap == null) || (paramMap.size() < 1)) {
      return paramString1;
    }
    paramMap = paramMap.entrySet().iterator();
    label93:
    while (paramMap.hasNext())
    {
      paramContext = (Map.Entry)paramMap.next();
      paramString2 = (String)paramContext.getKey();
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2))) {
        if (paramContext.getValue() != null) {
          break label159;
        }
      }
    }
    label159:
    for (paramContext = "";; paramContext = (String)paramContext.getValue())
    {
      paramString1.setRequestProperty(paramString2, URLEncoder.encode(paramContext, "UTF-8"));
      break label93;
      break;
    }
  }
  
  private static void a(Context paramContext, HttpURLConnection paramHttpURLConnection)
  {
    HttpsURLConnection localHttpsURLConnection;
    if ((paramHttpURLConnection instanceof HttpsURLConnection))
    {
      localHttpsURLConnection = (HttpsURLConnection)paramHttpURLConnection;
      paramHttpURLConnection = null;
    }
    try
    {
      paramContext = SecureSSLSocketFactory.getInstance(paramContext);
      if (paramContext != null)
      {
        localHttpsURLConnection.setSSLSocketFactory(paramContext);
        localHttpsURLConnection.setHostnameVerifier(SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        return;
      }
    }
    catch (NoSuchAlgorithmException paramContext)
    {
      for (;;)
      {
        HMSLog.w("PushHttpClient", "Get SocketFactory Algorithm Exception.");
        paramContext = paramHttpURLConnection;
      }
    }
    catch (KeyStoreException paramContext)
    {
      for (;;)
      {
        HMSLog.w("PushHttpClient", "Get SocketFactory Key Store exception.");
        paramContext = paramHttpURLConnection;
      }
    }
    catch (GeneralSecurityException paramContext)
    {
      for (;;)
      {
        HMSLog.w("PushHttpClient", "Get SocketFactory General Security Exception.");
        paramContext = paramHttpURLConnection;
      }
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        HMSLog.w("PushHttpClient", "Get SocketFactory IO Exception.");
        paramContext = paramHttpURLConnection;
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Access Exception.");
        paramContext = paramHttpURLConnection;
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Argument Exception.");
        paramContext = paramHttpURLConnection;
      }
      throw new Exception("No ssl socket factory set.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.e
 * JD-Core Version:    0.7.0.1
 */