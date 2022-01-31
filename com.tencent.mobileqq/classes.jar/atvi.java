import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.loginwelcome.GateWayVerifyMobileHelper.1;
import com.tencent.mobileqq.loginwelcome.GateWayVerifyMobileHelper.2;
import com.tencent.mobileqq.loginwelcome.GateWayVerifyMobileHelper.4;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.math.BigInteger;
import mqq.os.MqqHandler;

public class atvi
{
  public static void a(String paramString, atvk paramatvk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GateWayVerifyMobileHelper", 2, new Object[] { "gateway url is : ", paramString });
    }
    QLog.d("GateWayVerifyMobileHelper", 1, "start verifyMobile");
    if (bdin.b(BaseApplicationImpl.getContext()))
    {
      QLog.d("GateWayVerifyMobileHelper", 1, "current network is mobile");
      ThreadManagerV2.excute(new GateWayVerifyMobileHelper.1(paramString, paramatvk), 128, null, true);
      return;
    }
    QLog.d("GateWayVerifyMobileHelper", 1, "current network is not mobile");
    if ((!b(BaseApplicationImpl.getContext())) || (!a(BaseApplicationImpl.getContext())))
    {
      paramatvk.a(new Exception("mobile network is not enable"));
      return;
    }
    QLog.d("GateWayVerifyMobileHelper", 1, new Object[] { "current version is ", Integer.valueOf(Build.VERSION.SDK_INT) });
    if (Build.VERSION.SDK_INT <= 20)
    {
      d(paramString, paramatvk);
      return;
    }
    e(paramString, paramatvk);
  }
  
  /* Error */
  private static void a(java.net.HttpURLConnection paramHttpURLConnection, java.net.URL paramURL, atvk paramatvk)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_0
    //   13: ldc 101
    //   15: invokevirtual 106	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: ldc 108
    //   21: ldc 110
    //   23: invokevirtual 114	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: ldc 116
    //   29: ldc 118
    //   31: invokevirtual 114	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_0
    //   35: sipush 4000
    //   38: invokevirtual 122	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   41: aload_0
    //   42: sipush 4000
    //   45: invokevirtual 125	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   48: aload_0
    //   49: invokevirtual 129	java/net/HttpURLConnection:connect	()V
    //   52: aload_0
    //   53: invokevirtual 133	java/net/HttpURLConnection:getResponseCode	()I
    //   56: istore_3
    //   57: ldc 25
    //   59: iconst_1
    //   60: iconst_2
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: ldc 135
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: iload_3
    //   72: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: aastore
    //   76: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   79: iload_3
    //   80: sipush 200
    //   83: if_icmpne +184 -> 267
    //   86: aload_0
    //   87: invokevirtual 139	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   90: astore_0
    //   91: new 141	java/io/ByteArrayOutputStream
    //   94: dup
    //   95: invokespecial 143	java/io/ByteArrayOutputStream:<init>	()V
    //   98: astore 4
    //   100: sipush 1024
    //   103: newarray byte
    //   105: astore 5
    //   107: aload_0
    //   108: aload 5
    //   110: invokevirtual 149	java/io/InputStream:read	([B)I
    //   113: istore_3
    //   114: iload_3
    //   115: iconst_m1
    //   116: if_icmpeq +75 -> 191
    //   119: aload 4
    //   121: aload 5
    //   123: iconst_0
    //   124: iload_3
    //   125: invokevirtual 153	java/io/ByteArrayOutputStream:write	([BII)V
    //   128: goto -21 -> 107
    //   131: astore 5
    //   133: aload_0
    //   134: astore_1
    //   135: aload 4
    //   137: astore_0
    //   138: aload 5
    //   140: astore 4
    //   142: ldc 25
    //   144: iconst_1
    //   145: iconst_2
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: ldc 155
    //   153: aastore
    //   154: dup
    //   155: iconst_1
    //   156: aload 4
    //   158: invokevirtual 159	java/io/IOException:getMessage	()Ljava/lang/String;
    //   161: aastore
    //   162: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   165: aload_2
    //   166: iconst_m1
    //   167: aload 4
    //   169: invokeinterface 164 3 0
    //   174: aload_1
    //   175: ifnull +7 -> 182
    //   178: aload_1
    //   179: invokevirtual 167	java/io/InputStream:close	()V
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   190: return
    //   191: aload 4
    //   193: invokevirtual 171	java/io/ByteArrayOutputStream:flush	()V
    //   196: aload 4
    //   198: invokevirtual 174	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   201: astore 5
    //   203: aload_2
    //   204: aload_1
    //   205: invokevirtual 177	java/net/URL:toString	()Ljava/lang/String;
    //   208: aload 5
    //   210: invokeinterface 179 3 0
    //   215: ldc 25
    //   217: iconst_1
    //   218: iconst_2
    //   219: anewarray 4	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: ldc 181
    //   226: aastore
    //   227: dup
    //   228: iconst_1
    //   229: aload 5
    //   231: aastore
    //   232: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   235: aload_0
    //   236: astore_1
    //   237: aload 4
    //   239: astore_0
    //   240: aload_1
    //   241: ifnull +7 -> 248
    //   244: aload_1
    //   245: invokevirtual 167	java/io/InputStream:close	()V
    //   248: aload_0
    //   249: ifnull -59 -> 190
    //   252: aload_0
    //   253: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   256: return
    //   257: astore_0
    //   258: ldc 25
    //   260: iconst_1
    //   261: ldc 183
    //   263: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: return
    //   267: iload_3
    //   268: sipush 302
    //   271: if_icmpne +24 -> 295
    //   274: aload_2
    //   275: aload_0
    //   276: ldc 187
    //   278: invokevirtual 191	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   281: invokeinterface 193 2 0
    //   286: aload 7
    //   288: astore_1
    //   289: aload 6
    //   291: astore_0
    //   292: goto -52 -> 240
    //   295: aload_2
    //   296: iload_3
    //   297: new 67	java/lang/Exception
    //   300: dup
    //   301: new 195	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   308: ldc 198
    //   310: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload_3
    //   314: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokespecial 72	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   323: invokeinterface 164 3 0
    //   328: aload 7
    //   330: astore_1
    //   331: aload 6
    //   333: astore_0
    //   334: goto -94 -> 240
    //   337: astore_0
    //   338: aload 5
    //   340: astore_2
    //   341: aload 4
    //   343: astore_1
    //   344: aload_1
    //   345: ifnull +7 -> 352
    //   348: aload_1
    //   349: invokevirtual 167	java/io/InputStream:close	()V
    //   352: aload_2
    //   353: ifnull +7 -> 360
    //   356: aload_2
    //   357: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   360: aload_0
    //   361: athrow
    //   362: astore_1
    //   363: ldc 25
    //   365: iconst_1
    //   366: ldc 208
    //   368: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: goto -123 -> 248
    //   374: astore_1
    //   375: ldc 25
    //   377: iconst_1
    //   378: ldc 208
    //   380: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: goto -201 -> 182
    //   386: astore_0
    //   387: ldc 25
    //   389: iconst_1
    //   390: ldc 183
    //   392: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: return
    //   396: astore_1
    //   397: ldc 25
    //   399: iconst_1
    //   400: ldc 208
    //   402: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: goto -53 -> 352
    //   408: astore_1
    //   409: ldc 25
    //   411: iconst_1
    //   412: ldc 183
    //   414: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: goto -57 -> 360
    //   420: astore_2
    //   421: aload_0
    //   422: astore_1
    //   423: aload_2
    //   424: astore_0
    //   425: aload 5
    //   427: astore_2
    //   428: goto -84 -> 344
    //   431: astore 5
    //   433: aload 4
    //   435: astore_2
    //   436: aload_0
    //   437: astore_1
    //   438: aload 5
    //   440: astore_0
    //   441: goto -97 -> 344
    //   444: astore 4
    //   446: aload_0
    //   447: astore_2
    //   448: aload 4
    //   450: astore_0
    //   451: goto -107 -> 344
    //   454: astore 4
    //   456: aconst_null
    //   457: astore 5
    //   459: aload_0
    //   460: astore_1
    //   461: aload 5
    //   463: astore_0
    //   464: goto -322 -> 142
    //   467: astore 4
    //   469: aconst_null
    //   470: astore_1
    //   471: aconst_null
    //   472: astore_0
    //   473: goto -331 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	476	1	paramURL	java.net.URL
    //   0	476	2	paramatvk	atvk
    //   56	258	3	i	int
    //   1	433	4	localObject1	Object
    //   444	5	4	localObject2	Object
    //   454	1	4	localIOException1	java.io.IOException
    //   467	1	4	localIOException2	java.io.IOException
    //   7	115	5	arrayOfByte	byte[]
    //   131	8	5	localIOException3	java.io.IOException
    //   201	225	5	str	String
    //   431	8	5	localObject3	Object
    //   457	5	5	localObject4	Object
    //   10	322	6	localObject5	Object
    //   4	325	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   100	107	131	java/io/IOException
    //   107	114	131	java/io/IOException
    //   119	128	131	java/io/IOException
    //   191	235	131	java/io/IOException
    //   252	256	257	java/io/IOException
    //   12	79	337	finally
    //   86	91	337	finally
    //   274	286	337	finally
    //   295	328	337	finally
    //   244	248	362	java/io/IOException
    //   178	182	374	java/io/IOException
    //   186	190	386	java/io/IOException
    //   348	352	396	java/io/IOException
    //   356	360	408	java/io/IOException
    //   91	100	420	finally
    //   100	107	431	finally
    //   107	114	431	finally
    //   119	128	431	finally
    //   191	235	431	finally
    //   142	174	444	finally
    //   91	100	454	java/io/IOException
    //   12	79	467	java/io/IOException
    //   86	91	467	java/io/IOException
    //   274	286	467	java/io/IOException
    //   295	328	467	java/io/IOException
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool;
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getSimState())
    {
    default: 
      bool = true;
    }
    for (;;)
    {
      QLog.d("GateWayVerifyMobileHelper", 1, new Object[] { "hasSimCard result : ", Boolean.valueOf(bool) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private static int b(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    try
    {
      long[] arrayOfLong = new long[4];
      int i = paramString.indexOf(".");
      int j = paramString.indexOf(".", i + 1);
      int k = paramString.indexOf(".", j + 1);
      arrayOfLong[0] = Long.parseLong(paramString.substring(0, i));
      arrayOfLong[1] = Long.parseLong(paramString.substring(i + 1, j));
      arrayOfLong[2] = Long.parseLong(paramString.substring(j + 1, k));
      arrayOfLong[3] = Long.parseLong(paramString.substring(k + 1));
      long l1 = arrayOfLong[3];
      long l2 = arrayOfLong[2];
      long l3 = arrayOfLong[1];
      long l4 = arrayOfLong[0];
      return (int)(l4 + ((l1 << 24) + (l2 << 16) + (l3 << 8)));
    }
    catch (Exception paramString)
    {
      QLog.e("GateWayVerifyMobileHelper", 1, new Object[] { "ipv4toInt error : ", paramString.getMessage() });
    }
    return 0;
  }
  
  private static BigInteger b(String paramString)
  {
    BigInteger localBigInteger = BigInteger.ZERO;
    int i;
    int j;
    try
    {
      i = paramString.indexOf("::");
      Object localObject1;
      Object localObject2;
      int m;
      if (i != -1)
      {
        localObject1 = paramString.substring(0, i);
        localObject2 = paramString.substring(i + 1);
        paramString = b((String)localObject1);
        localObject2 = b((String)localObject2);
        localObject1 = ((String)localObject1).toCharArray();
        m = localObject1.length;
        j = 0;
      }
      label171:
      for (i = 0; j >= m; i = 0)
      {
        return paramString.shiftLeft((7 - i) * 16).add((BigInteger)localObject2);
        localObject1 = paramString.split(":");
        paramString = localBigInteger;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        while (i < localObject1.length)
        {
          if (localObject1[i].isEmpty()) {
            localObject1[i] = "0";
          }
          localBigInteger = paramString.add(BigInteger.valueOf(Long.valueOf(localObject1[i], 16).longValue()).shiftLeft((localObject1.length - i - 1) * 16));
          i += 1;
          paramString = localBigInteger;
        }
        localException1 = localException1;
        paramString = localBigInteger;
      }
      catch (Exception localException2)
      {
        break label171;
      }
      QLog.e("GateWayVerifyMobileHelper", 1, new Object[] { "ipv6toInt error : ", localException1.getMessage() });
      return paramString;
    }
    for (;;)
    {
      int k = i;
      if (localException2[j] == ':') {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
    return paramString;
  }
  
  /* Error */
  @RequiresApi(api=21)
  private static void b(String paramString, android.net.Network paramNetwork, atvk paramatvk)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 5
    //   8: astore_3
    //   9: new 176	java/net/URL
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 301	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: astore 6
    //   19: aload 5
    //   21: astore_3
    //   22: aload_1
    //   23: aload 6
    //   25: invokevirtual 307	android/net/Network:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   28: checkcast 103	java/net/HttpURLConnection
    //   31: astore_0
    //   32: aload_0
    //   33: aload 6
    //   35: aload_2
    //   36: invokestatic 309	atvi:a	(Ljava/net/HttpURLConnection;Ljava/net/URL;Latvk;)V
    //   39: aload_0
    //   40: ifnull +7 -> 47
    //   43: aload_0
    //   44: invokevirtual 312	java/net/HttpURLConnection:disconnect	()V
    //   47: return
    //   48: astore_1
    //   49: aload 4
    //   51: astore_0
    //   52: aload_0
    //   53: astore_3
    //   54: ldc 25
    //   56: iconst_1
    //   57: iconst_2
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: ldc_w 314
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_1
    //   70: invokevirtual 159	java/io/IOException:getMessage	()Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   77: aload_0
    //   78: astore_3
    //   79: aload_2
    //   80: iconst_m1
    //   81: aload_1
    //   82: invokeinterface 164 3 0
    //   87: aload_0
    //   88: ifnull -41 -> 47
    //   91: aload_0
    //   92: invokevirtual 312	java/net/HttpURLConnection:disconnect	()V
    //   95: return
    //   96: astore_1
    //   97: aload_3
    //   98: astore_0
    //   99: aload_0
    //   100: ifnull +7 -> 107
    //   103: aload_0
    //   104: invokevirtual 312	java/net/HttpURLConnection:disconnect	()V
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: goto -11 -> 99
    //   113: astore_1
    //   114: goto -62 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString	String
    //   0	117	1	paramNetwork	android.net.Network
    //   0	117	2	paramatvk	atvk
    //   8	90	3	localObject1	Object
    //   4	46	4	localObject2	Object
    //   1	19	5	localObject3	Object
    //   17	17	6	localURL	java.net.URL
    // Exception table:
    //   from	to	target	type
    //   9	19	48	java/io/IOException
    //   22	32	48	java/io/IOException
    //   9	19	96	finally
    //   22	32	96	finally
    //   54	77	96	finally
    //   79	87	96	finally
    //   32	39	109	finally
    //   32	39	113	java/io/IOException
  }
  
  private static boolean b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    try
    {
      Method localMethod = paramContext.getClass().getMethod("getMobileDataEnabled", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception paramContext)
    {
      QLog.e("GateWayVerifyMobileHelper", 1, new Object[] { "getMobileDataEnabled error : ", paramContext.getMessage() });
    }
    return true;
  }
  
  /* Error */
  private static void c(String paramString, atvk paramatvk)
  {
    // Byte code:
    //   0: ldc 25
    //   2: iconst_1
    //   3: ldc_w 351
    //   6: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: aload 4
    //   16: astore_2
    //   17: new 176	java/net/URL
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 301	java/net/URL:<init>	(Ljava/lang/String;)V
    //   25: astore 5
    //   27: aload 4
    //   29: astore_2
    //   30: aload 5
    //   32: invokevirtual 354	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   35: checkcast 103	java/net/HttpURLConnection
    //   38: astore_0
    //   39: aload_0
    //   40: aload 5
    //   42: aload_1
    //   43: invokestatic 309	atvi:a	(Ljava/net/HttpURLConnection;Ljava/net/URL;Latvk;)V
    //   46: aload_0
    //   47: ifnull +7 -> 54
    //   50: aload_0
    //   51: invokevirtual 312	java/net/HttpURLConnection:disconnect	()V
    //   54: return
    //   55: astore_2
    //   56: aload_3
    //   57: astore_0
    //   58: aload_2
    //   59: astore_3
    //   60: aload_0
    //   61: astore_2
    //   62: ldc 25
    //   64: iconst_1
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc_w 356
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload_3
    //   78: invokevirtual 159	java/io/IOException:getMessage	()Ljava/lang/String;
    //   81: aastore
    //   82: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   85: aload_0
    //   86: astore_2
    //   87: aload_1
    //   88: iconst_m1
    //   89: aload_3
    //   90: invokeinterface 164 3 0
    //   95: aload_0
    //   96: ifnull -42 -> 54
    //   99: aload_0
    //   100: invokevirtual 312	java/net/HttpURLConnection:disconnect	()V
    //   103: return
    //   104: astore_1
    //   105: aload_2
    //   106: astore_0
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 312	java/net/HttpURLConnection:disconnect	()V
    //   115: aload_1
    //   116: athrow
    //   117: astore_1
    //   118: goto -11 -> 107
    //   121: astore_3
    //   122: goto -62 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramString	String
    //   0	125	1	paramatvk	atvk
    //   16	14	2	localObject1	Object
    //   55	4	2	localIOException1	java.io.IOException
    //   61	45	2	str	String
    //   13	77	3	localObject2	Object
    //   121	1	3	localIOException2	java.io.IOException
    //   10	18	4	localObject3	Object
    //   25	16	5	localURL	java.net.URL
    // Exception table:
    //   from	to	target	type
    //   17	27	55	java/io/IOException
    //   30	39	55	java/io/IOException
    //   17	27	104	finally
    //   30	39	104	finally
    //   62	85	104	finally
    //   87	95	104	finally
    //   39	46	117	finally
    //   39	46	121	java/io/IOException
  }
  
  private static void d(String paramString, atvk paramatvk)
  {
    QLog.d("GateWayVerifyMobileHelper", 1, "start changeNetTypeToMobileV19");
    ThreadManagerV2.excute(new GateWayVerifyMobileHelper.2(paramString, paramatvk), 128, null, true);
  }
  
  @RequiresApi(api=21)
  private static void e(String paramString, atvk paramatvk)
  {
    QLog.d("GateWayVerifyMobileHelper", 1, "start changeNetTypeToMobileV20");
    Object localObject = new NetworkRequest.Builder();
    ((NetworkRequest.Builder)localObject).addCapability(12);
    ((NetworkRequest.Builder)localObject).addTransportType(0);
    localObject = ((NetworkRequest.Builder)localObject).build();
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    ConnectivityManager localConnectivityManager = (ConnectivityManager)BaseApplicationImpl.getContext().getSystemService("connectivity");
    paramString = new atvj(localMqqHandler, localConnectivityManager, paramatvk, paramString);
    localConnectivityManager.requestNetwork((NetworkRequest)localObject, paramString);
    localMqqHandler.postDelayed(new GateWayVerifyMobileHelper.4(paramatvk, localConnectivityManager, paramString), 4000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atvi
 * JD-Core Version:    0.7.0.1
 */