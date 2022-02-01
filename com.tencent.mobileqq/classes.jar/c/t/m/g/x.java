package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class x
{
  private static volatile boolean a = true;
  private static String b = "";
  private static String c = "unknown";
  private static volatile int d = 0;
  private static volatile boolean e = false;
  private static volatile int f = -1;
  private static Map<String, x.a> g = new ConcurrentHashMap();
  private static BroadcastReceiver h = new y();
  private static String i = "";
  private static String j = "cmwap";
  private static String k = "3gwap";
  private static String l = "uniwap";
  private static String m = "ctwap";
  
  public static void a()
  {
    try
    {
      e();
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      m.a().registerReceiver(h, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(String paramString, x.a parama)
  {
    synchronized (g)
    {
      g.put(paramString, parama);
      return;
    }
  }
  
  public static String b()
  {
    return c;
  }
  
  public static String c()
  {
    int n = d;
    if (n != 1)
    {
      if (n != 2)
      {
        if (n != 3)
        {
          if (n != 4) {
            return "";
          }
          return "4g";
        }
        return "3g";
      }
      return "2g";
    }
    return "wifi";
  }
  
  public static String d()
  {
    int n = d;
    if (n != 1)
    {
      if ((n != 2) && (n != 3) && (n != 4)) {
        return "null";
      }
      return b;
    }
    return "wifi";
  }
  
  /* Error */
  public static void e()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 97	c/t/m/g/x:d	I
    //   6: istore_0
    //   7: invokestatic 79	c/t/m/g/m:a	()Landroid/content/Context;
    //   10: ldc 111
    //   12: invokevirtual 115	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 117	android/net/ConnectivityManager
    //   18: invokevirtual 121	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull +345 -> 368
    //   26: aload_3
    //   27: invokevirtual 127	android/net/NetworkInfo:isAvailable	()Z
    //   30: ifeq +338 -> 368
    //   33: aload_3
    //   34: invokevirtual 130	android/net/NetworkInfo:isConnected	()Z
    //   37: ifeq +331 -> 368
    //   40: iconst_1
    //   41: putstatic 132	c/t/m/g/x:a	Z
    //   44: aload_3
    //   45: invokevirtual 136	android/net/NetworkInfo:getType	()I
    //   48: istore_1
    //   49: iload_1
    //   50: iconst_1
    //   51: if_icmpne +75 -> 126
    //   54: iconst_1
    //   55: putstatic 97	c/t/m/g/x:d	I
    //   58: iconst_0
    //   59: putstatic 138	c/t/m/g/x:f	I
    //   62: iconst_0
    //   63: putstatic 140	c/t/m/g/x:e	Z
    //   66: invokestatic 79	c/t/m/g/m:a	()Landroid/content/Context;
    //   69: invokevirtual 143	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   72: ldc 105
    //   74: invokevirtual 115	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   77: checkcast 145	android/net/wifi/WifiManager
    //   80: invokestatic 151	com/tencent/mobileqq/qmethodmonitor/monitor/NetworkMonitor:getConnectionInfo	(Landroid/net/wifi/WifiManager;)Landroid/net/wifi/WifiInfo;
    //   83: astore_3
    //   84: new 153	java/lang/StringBuilder
    //   87: dup
    //   88: ldc 155
    //   90: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: astore 4
    //   95: aload 4
    //   97: aload_3
    //   98: invokevirtual 161	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   101: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 4
    //   107: aload_3
    //   108: invokevirtual 168	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   111: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: putstatic 95	c/t/m/g/x:c	Ljava/lang/String;
    //   123: goto +271 -> 394
    //   126: aload_3
    //   127: invokevirtual 174	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   130: astore 4
    //   132: aload 4
    //   134: ifnull +209 -> 343
    //   137: aload 4
    //   139: invokevirtual 179	java/lang/String:trim	()Ljava/lang/String;
    //   142: invokevirtual 182	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   145: putstatic 109	c/t/m/g/x:b	Ljava/lang/String;
    //   148: iload_1
    //   149: ifne +169 -> 318
    //   152: new 153	java/lang/StringBuilder
    //   155: dup
    //   156: ldc 184
    //   158: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: astore 4
    //   163: aload 4
    //   165: getstatic 109	c/t/m/g/x:b	Ljava/lang/String;
    //   168: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 4
    //   174: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: putstatic 95	c/t/m/g/x:c	Ljava/lang/String;
    //   180: aload_3
    //   181: invokevirtual 187	android/net/NetworkInfo:getSubtype	()I
    //   184: istore_1
    //   185: iload_1
    //   186: putstatic 138	c/t/m/g/x:f	I
    //   189: iload_1
    //   190: iconst_1
    //   191: if_icmpeq +30 -> 221
    //   194: iload_1
    //   195: iconst_2
    //   196: if_icmpeq +25 -> 221
    //   199: iload_1
    //   200: iconst_4
    //   201: if_icmpne +449 -> 650
    //   204: goto +17 -> 221
    //   207: iconst_3
    //   208: putstatic 97	c/t/m/g/x:d	I
    //   211: goto +14 -> 225
    //   214: iconst_4
    //   215: putstatic 97	c/t/m/g/x:d	I
    //   218: goto +7 -> 225
    //   221: iconst_2
    //   222: putstatic 97	c/t/m/g/x:d	I
    //   225: getstatic 109	c/t/m/g/x:b	Ljava/lang/String;
    //   228: ldc 189
    //   230: invokevirtual 193	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   233: istore_2
    //   234: iload_2
    //   235: putstatic 140	c/t/m/g/x:e	Z
    //   238: iload_2
    //   239: ifeq +155 -> 394
    //   242: getstatic 109	c/t/m/g/x:b	Ljava/lang/String;
    //   245: getstatic 54	c/t/m/g/x:k	Ljava/lang/String;
    //   248: invokevirtual 193	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   251: ifeq +13 -> 264
    //   254: ldc 195
    //   256: astore_3
    //   257: aload_3
    //   258: putstatic 46	c/t/m/g/x:i	Ljava/lang/String;
    //   261: goto +133 -> 394
    //   264: getstatic 109	c/t/m/g/x:b	Ljava/lang/String;
    //   267: getstatic 50	c/t/m/g/x:j	Ljava/lang/String;
    //   270: invokevirtual 193	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   273: ifeq +9 -> 282
    //   276: ldc 195
    //   278: astore_3
    //   279: goto -22 -> 257
    //   282: getstatic 109	c/t/m/g/x:b	Ljava/lang/String;
    //   285: getstatic 58	c/t/m/g/x:l	Ljava/lang/String;
    //   288: invokevirtual 193	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   291: ifeq +9 -> 300
    //   294: ldc 195
    //   296: astore_3
    //   297: goto -40 -> 257
    //   300: getstatic 109	c/t/m/g/x:b	Ljava/lang/String;
    //   303: getstatic 62	c/t/m/g/x:m	Ljava/lang/String;
    //   306: invokevirtual 193	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   309: ifeq +356 -> 665
    //   312: ldc 197
    //   314: astore_3
    //   315: goto -58 -> 257
    //   318: ldc 14
    //   320: putstatic 109	c/t/m/g/x:b	Ljava/lang/String;
    //   323: iconst_0
    //   324: putstatic 97	c/t/m/g/x:d	I
    //   327: iconst_m1
    //   328: putstatic 138	c/t/m/g/x:f	I
    //   331: ldc 14
    //   333: putstatic 95	c/t/m/g/x:c	Ljava/lang/String;
    //   336: iconst_0
    //   337: putstatic 140	c/t/m/g/x:e	Z
    //   340: goto +54 -> 394
    //   343: ldc 14
    //   345: putstatic 109	c/t/m/g/x:b	Ljava/lang/String;
    //   348: iconst_0
    //   349: putstatic 97	c/t/m/g/x:d	I
    //   352: iconst_m1
    //   353: putstatic 138	c/t/m/g/x:f	I
    //   356: ldc 14
    //   358: putstatic 95	c/t/m/g/x:c	Ljava/lang/String;
    //   361: iconst_0
    //   362: putstatic 140	c/t/m/g/x:e	Z
    //   365: goto +29 -> 394
    //   368: ldc 14
    //   370: putstatic 109	c/t/m/g/x:b	Ljava/lang/String;
    //   373: iconst_0
    //   374: putstatic 97	c/t/m/g/x:d	I
    //   377: iconst_m1
    //   378: putstatic 138	c/t/m/g/x:f	I
    //   381: ldc 14
    //   383: putstatic 95	c/t/m/g/x:c	Ljava/lang/String;
    //   386: iconst_0
    //   387: putstatic 140	c/t/m/g/x:e	Z
    //   390: iconst_0
    //   391: putstatic 132	c/t/m/g/x:a	Z
    //   394: iload_0
    //   395: getstatic 97	c/t/m/g/x:d	I
    //   398: if_icmpeq +158 -> 556
    //   401: getstatic 39	c/t/m/g/x:g	Ljava/util/Map;
    //   404: astore_3
    //   405: aload_3
    //   406: monitorenter
    //   407: getstatic 39	c/t/m/g/x:g	Ljava/util/Map;
    //   410: invokeinterface 201 1 0
    //   415: invokeinterface 207 1 0
    //   420: astore 4
    //   422: aload 4
    //   424: invokeinterface 212 1 0
    //   429: ifeq +28 -> 457
    //   432: aload 4
    //   434: invokeinterface 216 1 0
    //   439: checkcast 218	c/t/m/g/x$a
    //   442: ifnull -20 -> 422
    //   445: getstatic 97	c/t/m/g/x:d	I
    //   448: getstatic 95	c/t/m/g/x:c	Ljava/lang/String;
    //   451: invokestatic 221	c/t/m/g/x$a:a	(ILjava/lang/String;)V
    //   454: goto -32 -> 422
    //   457: aload_3
    //   458: monitorexit
    //   459: ldc 2
    //   461: monitorexit
    //   462: return
    //   463: astore 4
    //   465: aload_3
    //   466: monitorexit
    //   467: aload 4
    //   469: athrow
    //   470: astore 4
    //   472: goto +88 -> 560
    //   475: astore_3
    //   476: aload_3
    //   477: invokevirtual 224	java/lang/Throwable:printStackTrace	()V
    //   480: iload_0
    //   481: getstatic 97	c/t/m/g/x:d	I
    //   484: if_icmpeq +72 -> 556
    //   487: getstatic 39	c/t/m/g/x:g	Ljava/util/Map;
    //   490: astore_3
    //   491: aload_3
    //   492: monitorenter
    //   493: getstatic 39	c/t/m/g/x:g	Ljava/util/Map;
    //   496: invokeinterface 201 1 0
    //   501: invokeinterface 207 1 0
    //   506: astore 4
    //   508: aload 4
    //   510: invokeinterface 212 1 0
    //   515: ifeq +28 -> 543
    //   518: aload 4
    //   520: invokeinterface 216 1 0
    //   525: checkcast 218	c/t/m/g/x$a
    //   528: ifnull -20 -> 508
    //   531: getstatic 97	c/t/m/g/x:d	I
    //   534: getstatic 95	c/t/m/g/x:c	Ljava/lang/String;
    //   537: invokestatic 221	c/t/m/g/x$a:a	(ILjava/lang/String;)V
    //   540: goto -32 -> 508
    //   543: aload_3
    //   544: monitorexit
    //   545: ldc 2
    //   547: monitorexit
    //   548: return
    //   549: astore 4
    //   551: aload_3
    //   552: monitorexit
    //   553: aload 4
    //   555: athrow
    //   556: ldc 2
    //   558: monitorexit
    //   559: return
    //   560: iload_0
    //   561: getstatic 97	c/t/m/g/x:d	I
    //   564: if_icmpeq +71 -> 635
    //   567: getstatic 39	c/t/m/g/x:g	Ljava/util/Map;
    //   570: astore_3
    //   571: aload_3
    //   572: monitorenter
    //   573: getstatic 39	c/t/m/g/x:g	Ljava/util/Map;
    //   576: invokeinterface 201 1 0
    //   581: invokeinterface 207 1 0
    //   586: astore 5
    //   588: aload 5
    //   590: invokeinterface 212 1 0
    //   595: ifeq +28 -> 623
    //   598: aload 5
    //   600: invokeinterface 216 1 0
    //   605: checkcast 218	c/t/m/g/x$a
    //   608: ifnull -20 -> 588
    //   611: getstatic 97	c/t/m/g/x:d	I
    //   614: getstatic 95	c/t/m/g/x:c	Ljava/lang/String;
    //   617: invokestatic 221	c/t/m/g/x$a:a	(ILjava/lang/String;)V
    //   620: goto -32 -> 588
    //   623: aload_3
    //   624: monitorexit
    //   625: goto +10 -> 635
    //   628: astore 4
    //   630: aload_3
    //   631: monitorexit
    //   632: aload 4
    //   634: athrow
    //   635: aload 4
    //   637: athrow
    //   638: astore_3
    //   639: ldc 2
    //   641: monitorexit
    //   642: goto +5 -> 647
    //   645: aload_3
    //   646: athrow
    //   647: goto -2 -> 645
    //   650: iload_1
    //   651: bipush 13
    //   653: if_icmpeq -439 -> 214
    //   656: iload_1
    //   657: bipush 19
    //   659: if_icmpne -452 -> 207
    //   662: goto -448 -> 214
    //   665: ldc 11
    //   667: astore_3
    //   668: goto -411 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	559	0	n	int
    //   48	612	1	i1	int
    //   233	6	2	bool	boolean
    //   475	2	3	localThrowable	Throwable
    //   638	8	3	localObject2	Object
    //   667	1	3	str	String
    //   93	340	4	localObject3	Object
    //   463	5	4	localObject4	Object
    //   470	1	4	localObject5	Object
    //   506	13	4	localIterator1	java.util.Iterator
    //   549	5	4	localObject6	Object
    //   628	8	4	localObject7	Object
    //   586	13	5	localIterator2	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   407	422	463	finally
    //   422	454	463	finally
    //   457	459	463	finally
    //   465	467	463	finally
    //   7	22	470	finally
    //   26	49	470	finally
    //   54	123	470	finally
    //   126	132	470	finally
    //   137	148	470	finally
    //   152	189	470	finally
    //   207	211	470	finally
    //   214	218	470	finally
    //   221	225	470	finally
    //   225	238	470	finally
    //   242	254	470	finally
    //   257	261	470	finally
    //   264	276	470	finally
    //   282	294	470	finally
    //   300	312	470	finally
    //   318	340	470	finally
    //   343	365	470	finally
    //   368	394	470	finally
    //   476	480	470	finally
    //   7	22	475	java/lang/Throwable
    //   26	49	475	java/lang/Throwable
    //   54	123	475	java/lang/Throwable
    //   126	132	475	java/lang/Throwable
    //   137	148	475	java/lang/Throwable
    //   152	189	475	java/lang/Throwable
    //   207	211	475	java/lang/Throwable
    //   214	218	475	java/lang/Throwable
    //   221	225	475	java/lang/Throwable
    //   225	238	475	java/lang/Throwable
    //   242	254	475	java/lang/Throwable
    //   257	261	475	java/lang/Throwable
    //   264	276	475	java/lang/Throwable
    //   282	294	475	java/lang/Throwable
    //   300	312	475	java/lang/Throwable
    //   318	340	475	java/lang/Throwable
    //   343	365	475	java/lang/Throwable
    //   368	394	475	java/lang/Throwable
    //   493	508	549	finally
    //   508	540	549	finally
    //   543	545	549	finally
    //   551	553	549	finally
    //   573	588	628	finally
    //   588	620	628	finally
    //   623	625	628	finally
    //   630	632	628	finally
    //   3	7	638	finally
    //   394	407	638	finally
    //   467	470	638	finally
    //   480	493	638	finally
    //   553	556	638	finally
    //   560	573	638	finally
    //   632	635	638	finally
    //   635	638	638	finally
  }
  
  public static String f()
  {
    if (f == -1) {
      return "unknown";
    }
    switch (f)
    {
    default: 
      return "unknown";
    case 15: 
      return "HSPAP";
    case 14: 
      return "EHRPD";
    case 13: 
      return "LTE";
    case 12: 
      return "EVDO_B";
    case 11: 
      return "iDen";
    case 10: 
      return "HSPA";
    case 9: 
      return "HSUPA";
    case 8: 
      return "HSDPA";
    case 7: 
      return "1xRTT";
    case 6: 
      return "EVDO_A";
    case 5: 
      return "EVDO_0";
    case 4: 
      return "CDMA";
    case 3: 
      return "UMTS";
    case 2: 
      return "EDGE";
    case 1: 
      return "GPRS";
    }
    return "wifi";
  }
  
  public static int g()
  {
    return d;
  }
  
  public static boolean h()
  {
    return a;
  }
  
  public static boolean i()
  {
    return e;
  }
  
  public static Integer j()
  {
    e();
    int i3 = d;
    Integer localInteger = Integer.valueOf(3);
    int i2 = 1;
    int i1 = 0;
    int n = i2;
    if (i3 != 2)
    {
      n = i2;
      if (d != 3) {
        if (d == 4) {
          n = i2;
        } else {
          n = 0;
        }
      }
    }
    if (n != 0)
    {
      Object localObject2 = m.a();
      Object localObject1 = b;
      localObject2 = (TelephonyManager)((Context)localObject2).getSystemService("phone");
      if ((localObject2 != null) && (((TelephonyManager)localObject2).getSimState() == 5))
      {
        localObject2 = ((TelephonyManager)localObject2).getSimOperator();
        if (((String)localObject2).length() > 0)
        {
          if ((((String)localObject2).equals("46000")) || (((String)localObject2).equals("46002"))) {
            break label282;
          }
          if (((String)localObject2).equals("46001")) {
            break label273;
          }
          if (((String)localObject2).equals("46003"))
          {
            localObject1 = localInteger;
            break label297;
          }
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((String)localObject1).toLowerCase();
        if ((!((String)localObject2).contains("cmnet")) && (!((String)localObject2).contains("cmwap")))
        {
          if ((!((String)localObject2).contains("uninet")) && (!((String)localObject2).contains("uniwap")) && (!((String)localObject2).contains("3gnet")) && (!((String)localObject2).contains("3gwap")))
          {
            localObject1 = localInteger;
            if (((String)localObject2).contains("ctnet")) {
              break label297;
            }
            if (((String)localObject2).contains("ctwap"))
            {
              localObject1 = localInteger;
              break label297;
            }
          }
          else
          {
            label273:
            localObject1 = Integer.valueOf(2);
            break label297;
          }
        }
        else
        {
          label282:
          localObject1 = Integer.valueOf(1);
          break label297;
        }
      }
      localObject1 = Integer.valueOf(0);
      label297:
      i1 = ((Integer)localObject1).intValue();
    }
    return Integer.valueOf(i1);
  }
  
  public static Proxy k()
  {
    if ((e) && (!TextUtils.isEmpty(i))) {
      return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(i, 80));
    }
    return null;
  }
  
  public static boolean l()
  {
    boolean bool2 = false;
    try
    {
      PowerManager localPowerManager = (PowerManager)m.a().getSystemService("power");
      boolean bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool1 = bool2;
        if (localPowerManager != null) {
          bool1 = ((Boolean)PowerManager.class.getDeclaredMethod("isDeviceIdleMode", new Class[0]).invoke(localPowerManager, new Object[0])).booleanValue();
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.x
 * JD-Core Version:    0.7.0.1
 */