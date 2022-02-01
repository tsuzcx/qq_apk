import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.2;
import com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.3;
import com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.4;
import com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.6;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.math.BigInteger;
import mqq.os.MqqHandler;

public class awvg
{
  private static volatile awvg jdField_a_of_type_Awvg;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConnectivityManager.NetworkCallback jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback;
  private ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplicationImpl.getContext().getSystemService("connectivity");
  private Network jdField_a_of_type_AndroidNetNetwork;
  private awvl jdField_a_of_type_Awvl;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private awvg()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback = new awvh(this);
    }
    try
    {
      b();
      return;
    }
    catch (Exception localException)
    {
      QLog.d("GateWayVerifyManager", 1, new Object[] { "requestMobileNetwork error : ", localException.getMessage() });
      this.b = true;
    }
  }
  
  private int a(String paramString)
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
      QLog.e("GateWayVerifyManager", 1, new Object[] { "ipv4toInt error : ", paramString.getMessage() });
    }
    return 0;
  }
  
  private Network a()
  {
    try
    {
      Network localNetwork = this.jdField_a_of_type_AndroidNetNetwork;
      return localNetwork;
    }
    finally {}
  }
  
  public static awvg a()
  {
    if (jdField_a_of_type_Awvg == null) {}
    try
    {
      if (jdField_a_of_type_Awvg == null) {
        jdField_a_of_type_Awvg = new awvg();
      }
      return jdField_a_of_type_Awvg;
    }
    finally {}
  }
  
  private BigInteger a(String paramString)
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
        paramString = a((String)localObject1);
        localObject2 = a((String)localObject2);
        localObject1 = ((String)localObject1).toCharArray();
        m = localObject1.length;
        j = 0;
      }
      label170:
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
        break label170;
      }
      QLog.e("GateWayVerifyManager", 1, new Object[] { "ipv6toInt error : ", localException1.getMessage() });
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
  
  private void a(Network paramNetwork)
  {
    try
    {
      this.jdField_a_of_type_AndroidNetNetwork = paramNetwork;
      return;
    }
    finally {}
  }
  
  private void a(awvl paramawvl)
  {
    this.jdField_a_of_type_Awvl = paramawvl;
  }
  
  @RequiresApi(api=21)
  private void a(String paramString, Network paramNetwork, awvj paramawvj)
  {
    ThreadManagerV2.excute(new GateWayVerifyManager.2(this, paramString, paramNetwork, paramawvj), 128, null, true);
  }
  
  /* Error */
  private void a(java.net.HttpURLConnection paramHttpURLConnection, java.net.URL paramURL, awvj paramawvj)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 7
    //   12: aload_1
    //   13: ldc 212
    //   15: invokevirtual 218	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   18: aload_1
    //   19: ldc 220
    //   21: ldc 222
    //   23: invokevirtual 226	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_1
    //   27: ldc 228
    //   29: ldc 230
    //   31: invokevirtual 226	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_1
    //   35: sipush 4000
    //   38: invokevirtual 234	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   41: aload_1
    //   42: sipush 4000
    //   45: invokevirtual 237	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   48: aload_1
    //   49: invokevirtual 240	java/net/HttpURLConnection:connect	()V
    //   52: aload_1
    //   53: invokevirtual 244	java/net/HttpURLConnection:getResponseCode	()I
    //   56: istore 4
    //   58: ldc 67
    //   60: iconst_1
    //   61: iconst_2
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: ldc 246
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: iload 4
    //   74: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   81: iload 4
    //   83: sipush 200
    //   86: if_icmpne +190 -> 276
    //   89: aload_1
    //   90: invokevirtual 255	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   93: astore_1
    //   94: new 257	java/io/ByteArrayOutputStream
    //   97: dup
    //   98: invokespecial 258	java/io/ByteArrayOutputStream:<init>	()V
    //   101: astore 5
    //   103: sipush 1024
    //   106: newarray byte
    //   108: astore 6
    //   110: aload_1
    //   111: aload 6
    //   113: invokevirtual 264	java/io/InputStream:read	([B)I
    //   116: istore 4
    //   118: iload 4
    //   120: iconst_m1
    //   121: if_icmpeq +77 -> 198
    //   124: aload 5
    //   126: aload 6
    //   128: iconst_0
    //   129: iload 4
    //   131: invokevirtual 268	java/io/ByteArrayOutputStream:write	([BII)V
    //   134: goto -24 -> 110
    //   137: astore 6
    //   139: aload_1
    //   140: astore_2
    //   141: aload 5
    //   143: astore_1
    //   144: aload 6
    //   146: astore 5
    //   148: ldc 67
    //   150: iconst_1
    //   151: iconst_2
    //   152: anewarray 4	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: ldc_w 270
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: aload 5
    //   165: invokevirtual 271	java/io/IOException:getMessage	()Ljava/lang/String;
    //   168: aastore
    //   169: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   172: aload_3
    //   173: iconst_m1
    //   174: aload 5
    //   176: invokeinterface 276 3 0
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 279	java/io/InputStream:close	()V
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 280	java/io/ByteArrayOutputStream:close	()V
    //   197: return
    //   198: aload 5
    //   200: invokevirtual 283	java/io/ByteArrayOutputStream:flush	()V
    //   203: aload 5
    //   205: invokevirtual 286	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   208: astore 6
    //   210: aload_3
    //   211: aload_2
    //   212: invokevirtual 289	java/net/URL:toString	()Ljava/lang/String;
    //   215: aload 6
    //   217: invokeinterface 291 3 0
    //   222: ldc 67
    //   224: iconst_1
    //   225: iconst_2
    //   226: anewarray 4	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: ldc_w 293
    //   234: aastore
    //   235: dup
    //   236: iconst_1
    //   237: aload 6
    //   239: aastore
    //   240: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   243: aload_1
    //   244: astore_2
    //   245: aload 5
    //   247: astore_1
    //   248: aload_2
    //   249: ifnull +7 -> 256
    //   252: aload_2
    //   253: invokevirtual 279	java/io/InputStream:close	()V
    //   256: aload_1
    //   257: ifnull -60 -> 197
    //   260: aload_1
    //   261: invokevirtual 280	java/io/ByteArrayOutputStream:close	()V
    //   264: return
    //   265: astore_1
    //   266: ldc 67
    //   268: iconst_1
    //   269: ldc_w 295
    //   272: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: return
    //   276: iload 4
    //   278: sipush 302
    //   281: if_icmpne +25 -> 306
    //   284: aload_3
    //   285: aload_1
    //   286: ldc_w 300
    //   289: invokevirtual 304	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   292: invokeinterface 306 2 0
    //   297: aload 8
    //   299: astore_2
    //   300: aload 7
    //   302: astore_1
    //   303: goto -55 -> 248
    //   306: aload_3
    //   307: iload 4
    //   309: new 24	java/lang/Exception
    //   312: dup
    //   313: new 308	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 309	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 311
    //   323: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: iload 4
    //   328: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokespecial 321	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   337: invokeinterface 276 3 0
    //   342: aload 8
    //   344: astore_2
    //   345: aload 7
    //   347: astore_1
    //   348: goto -100 -> 248
    //   351: astore_1
    //   352: aload 6
    //   354: astore_3
    //   355: aload 5
    //   357: astore_2
    //   358: aload_2
    //   359: ifnull +7 -> 366
    //   362: aload_2
    //   363: invokevirtual 279	java/io/InputStream:close	()V
    //   366: aload_3
    //   367: ifnull +7 -> 374
    //   370: aload_3
    //   371: invokevirtual 280	java/io/ByteArrayOutputStream:close	()V
    //   374: aload_1
    //   375: athrow
    //   376: astore_2
    //   377: ldc 67
    //   379: iconst_1
    //   380: ldc_w 323
    //   383: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: goto -130 -> 256
    //   389: astore_2
    //   390: ldc 67
    //   392: iconst_1
    //   393: ldc_w 323
    //   396: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: goto -210 -> 189
    //   402: astore_1
    //   403: ldc 67
    //   405: iconst_1
    //   406: ldc_w 295
    //   409: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: return
    //   413: astore_2
    //   414: ldc 67
    //   416: iconst_1
    //   417: ldc_w 323
    //   420: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: goto -57 -> 366
    //   426: astore_2
    //   427: ldc 67
    //   429: iconst_1
    //   430: ldc_w 295
    //   433: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: goto -62 -> 374
    //   439: astore_3
    //   440: aload_1
    //   441: astore_2
    //   442: aload_3
    //   443: astore_1
    //   444: aload 6
    //   446: astore_3
    //   447: goto -89 -> 358
    //   450: astore 6
    //   452: aload 5
    //   454: astore_3
    //   455: aload_1
    //   456: astore_2
    //   457: aload 6
    //   459: astore_1
    //   460: goto -102 -> 358
    //   463: astore 5
    //   465: aload_1
    //   466: astore_3
    //   467: aload 5
    //   469: astore_1
    //   470: goto -112 -> 358
    //   473: astore 5
    //   475: aconst_null
    //   476: astore 6
    //   478: aload_1
    //   479: astore_2
    //   480: aload 6
    //   482: astore_1
    //   483: goto -335 -> 148
    //   486: astore 5
    //   488: aconst_null
    //   489: astore_2
    //   490: aconst_null
    //   491: astore_1
    //   492: goto -344 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	495	0	this	awvg
    //   0	495	1	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	495	2	paramURL	java.net.URL
    //   0	495	3	paramawvj	awvj
    //   56	271	4	i	int
    //   1	452	5	localObject1	Object
    //   463	5	5	localObject2	Object
    //   473	1	5	localIOException1	java.io.IOException
    //   486	1	5	localIOException2	java.io.IOException
    //   7	120	6	arrayOfByte	byte[]
    //   137	8	6	localIOException3	java.io.IOException
    //   208	237	6	str	String
    //   450	8	6	localObject3	Object
    //   476	5	6	localObject4	Object
    //   10	336	7	localObject5	Object
    //   4	339	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   103	110	137	java/io/IOException
    //   110	118	137	java/io/IOException
    //   124	134	137	java/io/IOException
    //   198	243	137	java/io/IOException
    //   260	264	265	java/io/IOException
    //   12	81	351	finally
    //   89	94	351	finally
    //   284	297	351	finally
    //   306	342	351	finally
    //   252	256	376	java/io/IOException
    //   185	189	389	java/io/IOException
    //   193	197	402	java/io/IOException
    //   362	366	413	java/io/IOException
    //   370	374	426	java/io/IOException
    //   94	103	439	finally
    //   103	110	450	finally
    //   110	118	450	finally
    //   124	134	450	finally
    //   198	243	450	finally
    //   148	181	463	finally
    //   94	103	473	java/io/IOException
    //   12	81	486	java/io/IOException
    //   89	94	486	java/io/IOException
    //   284	297	486	java/io/IOException
    //   306	342	486	java/io/IOException
  }
  
  @RequiresApi(api=21)
  private void b()
  {
    Object localObject = new NetworkRequest.Builder();
    ((NetworkRequest.Builder)localObject).addCapability(12);
    ((NetworkRequest.Builder)localObject).addTransportType(0);
    localObject = ((NetworkRequest.Builder)localObject).build();
    this.jdField_a_of_type_AndroidNetConnectivityManager.requestNetwork((NetworkRequest)localObject, this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback);
  }
  
  private void b(String paramString, awvj paramawvj)
  {
    ThreadManagerV2.excute(new GateWayVerifyManager.3(this, paramString, paramawvj), 128, null, true);
  }
  
  private boolean b()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)BaseApplicationImpl.getContext().getSystemService("connectivity");
    try
    {
      Method localMethod = localConnectivityManager.getClass().getMethod("getMobileDataEnabled", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(localConnectivityManager, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("GateWayVerifyManager", 1, new Object[] { "getMobileDataEnabled error : ", localException.getMessage() });
    }
    return true;
  }
  
  private void c(String paramString, awvj paramawvj)
  {
    QLog.d("GateWayVerifyManager", 1, "start changeNetTypeToMobileV19");
    ThreadManagerV2.excute(new GateWayVerifyManager.4(this, paramString, paramawvj), 128, null, true);
  }
  
  @RequiresApi(api=21)
  private void d(String paramString, awvj paramawvj)
  {
    boolean bool = false;
    Network localNetwork = a();
    if (localNetwork == null) {
      bool = true;
    }
    QLog.d("GateWayVerifyManager", 1, new Object[] { "start changeNetTypeToMobileV20, mNetwork is null [", Boolean.valueOf(bool), "]" });
    a(new awvi(this, paramString, paramawvj));
    if (localNetwork == null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new GateWayVerifyManager.6(this, paramawvj), 4000L);
      return;
    }
    a(paramString, localNetwork, new awvk(paramawvj, localNetwork));
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 414	awvg:jdField_a_of_type_Boolean	Z
    //   7: ifeq +16 -> 23
    //   10: ldc 67
    //   12: iconst_1
    //   13: ldc_w 416
    //   16: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: aconst_null
    //   24: putstatic 120	awvg:jdField_a_of_type_Awvg	Lawvg;
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield 414	awvg:jdField_a_of_type_Boolean	Z
    //   32: ldc 2
    //   34: monitorexit
    //   35: getstatic 56	android/os/Build$VERSION:SDK_INT	I
    //   38: bipush 21
    //   40: if_icmplt +19 -> 59
    //   43: aload_0
    //   44: getfield 42	awvg:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   47: aload_0
    //   48: getfield 63	awvg:jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback	Landroid/net/ConnectivityManager$NetworkCallback;
    //   51: invokevirtual 420	android/net/ConnectivityManager:unregisterNetworkCallback	(Landroid/net/ConnectivityManager$NetworkCallback;)V
    //   54: aload_0
    //   55: aconst_null
    //   56: invokespecial 178	awvg:a	(Landroid/net/Network;)V
    //   59: aload_0
    //   60: getfield 50	awvg:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   63: aconst_null
    //   64: invokevirtual 424	mqq/os/MqqHandler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   67: return
    //   68: astore_1
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: ldc 67
    //   77: iconst_1
    //   78: iconst_2
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: ldc_w 426
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: aload_1
    //   91: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   94: aastore
    //   95: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   98: goto -44 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	awvg
    //   68	5	1	localObject	Object
    //   74	17	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   3	22	68	finally
    //   23	35	68	finally
    //   69	72	68	finally
    //   43	54	74	java/lang/Exception
  }
  
  public void a(String paramString, awvj paramawvj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GateWayVerifyManager", 2, new Object[] { "gateway url is : ", paramString });
    }
    if (this.b)
    {
      paramawvj.a(new Exception("request network error"));
      return;
    }
    QLog.d("GateWayVerifyManager", 1, "start verifyMobile");
    if (bhnv.b(BaseApplicationImpl.getContext()))
    {
      QLog.d("GateWayVerifyManager", 1, "current network is mobile");
      b(paramString, paramawvj);
      return;
    }
    QLog.d("GateWayVerifyManager", 1, "current network is not mobile");
    if (!b())
    {
      paramawvj.a(new Exception("mobile network is unable"));
      return;
    }
    if (!a())
    {
      paramawvj.a(new Exception("no sim card"));
      return;
    }
    QLog.d("GateWayVerifyManager", 1, new Object[] { "current version is ", Integer.valueOf(Build.VERSION.SDK_INT) });
    if (Build.VERSION.SDK_INT <= 20)
    {
      c(paramString, paramawvj);
      return;
    }
    d(paramString, paramawvj);
  }
  
  public boolean a()
  {
    boolean bool;
    switch (((TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone")).getSimState())
    {
    default: 
      bool = true;
    }
    for (;;)
    {
      QLog.d("GateWayVerifyManager", 1, new Object[] { "hasSimCard result : ", Boolean.valueOf(bool) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvg
 * JD-Core Version:    0.7.0.1
 */