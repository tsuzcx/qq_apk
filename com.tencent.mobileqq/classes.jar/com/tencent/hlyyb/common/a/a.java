package com.tencent.hlyyb.common.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.PowerManager;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static volatile boolean a = true;
  private static String b = "";
  private static String c = "";
  private static String d = "";
  private static volatile int e = 0;
  private static volatile boolean f = false;
  private static Map<String, b> g = new ConcurrentHashMap();
  private static BroadcastReceiver h = new c();
  
  public static void a()
  {
    com.tencent.hlyyb.common.a.h().post(new d());
  }
  
  public static void a(String paramString, b paramb)
  {
    synchronized (g)
    {
      g.put(paramString, paramb);
      return;
    }
  }
  
  public static String b()
  {
    try
    {
      int i = e;
      Object localObject1;
      if (i != 1)
      {
        if ((i != 2) && (i != 3) && (i != 4))
        {
          localObject1 = "unknown";
        }
        else
        {
          localObject1 = new StringBuilder("apn_");
          ((StringBuilder)localObject1).append(b);
        }
      }
      else {
        for (;;)
        {
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
          localObject1 = new StringBuilder("ssid_");
          ((StringBuilder)localObject1).append(c);
          ((StringBuilder)localObject1).append(d);
        }
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static String c()
  {
    int i = e;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
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
  
  /* Error */
  public static void d()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   6: istore_0
    //   7: invokestatic 98	com/tencent/hlyyb/common/a:a	()Landroid/content/Context;
    //   10: ldc 100
    //   12: invokevirtual 106	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 108	android/net/ConnectivityManager
    //   18: invokevirtual 112	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +187 -> 210
    //   26: aload_2
    //   27: invokevirtual 118	android/net/NetworkInfo:isAvailable	()Z
    //   30: ifeq +180 -> 210
    //   33: aload_2
    //   34: invokevirtual 121	android/net/NetworkInfo:isConnected	()Z
    //   37: ifeq +173 -> 210
    //   40: iconst_1
    //   41: putstatic 123	com/tencent/hlyyb/common/a/a:a	Z
    //   44: aload_2
    //   45: invokevirtual 127	android/net/NetworkInfo:getType	()I
    //   48: istore_1
    //   49: iload_1
    //   50: iconst_1
    //   51: if_icmpne +43 -> 94
    //   54: iconst_1
    //   55: putstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   58: iconst_0
    //   59: putstatic 129	com/tencent/hlyyb/common/a/a:f	Z
    //   62: invokestatic 98	com/tencent/hlyyb/common/a:a	()Landroid/content/Context;
    //   65: ldc 93
    //   67: invokevirtual 106	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   70: checkcast 131	android/net/wifi/WifiManager
    //   73: invokevirtual 135	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   76: astore_2
    //   77: aload_2
    //   78: invokevirtual 140	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   81: putstatic 83	com/tencent/hlyyb/common/a/a:c	Ljava/lang/String;
    //   84: aload_2
    //   85: invokevirtual 143	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   88: putstatic 85	com/tencent/hlyyb/common/a/a:d	Ljava/lang/String;
    //   91: goto +136 -> 227
    //   94: aload_2
    //   95: invokevirtual 146	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   98: astore_3
    //   99: aload_3
    //   100: ifnull +94 -> 194
    //   103: aload_3
    //   104: invokevirtual 151	java/lang/String:trim	()Ljava/lang/String;
    //   107: invokevirtual 154	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   110: putstatic 72	com/tencent/hlyyb/common/a/a:b	Ljava/lang/String;
    //   113: iload_1
    //   114: ifne +64 -> 178
    //   117: aload_2
    //   118: invokevirtual 157	android/net/NetworkInfo:getSubtype	()I
    //   121: istore_1
    //   122: iload_1
    //   123: iconst_1
    //   124: if_icmpeq +36 -> 160
    //   127: iload_1
    //   128: iconst_2
    //   129: if_icmpeq +31 -> 160
    //   132: iload_1
    //   133: iconst_4
    //   134: if_icmpne +6 -> 140
    //   137: goto +23 -> 160
    //   140: iload_1
    //   141: bipush 13
    //   143: if_icmpne +10 -> 153
    //   146: iconst_4
    //   147: putstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   150: goto +14 -> 164
    //   153: iconst_3
    //   154: putstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   157: goto +7 -> 164
    //   160: iconst_2
    //   161: putstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   164: getstatic 72	com/tencent/hlyyb/common/a/a:b	Ljava/lang/String;
    //   167: ldc 159
    //   169: invokevirtual 163	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   172: putstatic 129	com/tencent/hlyyb/common/a/a:f	Z
    //   175: goto +52 -> 227
    //   178: ldc 63
    //   180: putstatic 72	com/tencent/hlyyb/common/a/a:b	Ljava/lang/String;
    //   183: iconst_0
    //   184: putstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   187: iconst_0
    //   188: putstatic 129	com/tencent/hlyyb/common/a/a:f	Z
    //   191: goto +36 -> 227
    //   194: ldc 63
    //   196: putstatic 72	com/tencent/hlyyb/common/a/a:b	Ljava/lang/String;
    //   199: iconst_0
    //   200: putstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   203: iconst_0
    //   204: putstatic 129	com/tencent/hlyyb/common/a/a:f	Z
    //   207: goto +20 -> 227
    //   210: ldc 63
    //   212: putstatic 72	com/tencent/hlyyb/common/a/a:b	Ljava/lang/String;
    //   215: iconst_0
    //   216: putstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   219: iconst_0
    //   220: putstatic 129	com/tencent/hlyyb/common/a/a:f	Z
    //   223: iconst_0
    //   224: putstatic 123	com/tencent/hlyyb/common/a/a:a	Z
    //   227: iload_0
    //   228: getstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   231: if_icmpeq +161 -> 392
    //   234: getstatic 31	com/tencent/hlyyb/common/a/a:g	Ljava/util/Map;
    //   237: astore_2
    //   238: aload_2
    //   239: monitorenter
    //   240: getstatic 31	com/tencent/hlyyb/common/a/a:g	Ljava/util/Map;
    //   243: invokeinterface 167 1 0
    //   248: invokeinterface 173 1 0
    //   253: astore_3
    //   254: aload_3
    //   255: invokeinterface 178 1 0
    //   260: ifeq +35 -> 295
    //   263: aload_3
    //   264: invokeinterface 182 1 0
    //   269: checkcast 184	com/tencent/hlyyb/common/a/b
    //   272: astore 4
    //   274: aload 4
    //   276: ifnull -22 -> 254
    //   279: aload 4
    //   281: getstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   284: invokestatic 186	com/tencent/hlyyb/common/a/a:b	()Ljava/lang/String;
    //   287: invokeinterface 189 3 0
    //   292: goto -38 -> 254
    //   295: aload_2
    //   296: monitorexit
    //   297: goto +95 -> 392
    //   300: astore_3
    //   301: aload_2
    //   302: monitorexit
    //   303: aload_3
    //   304: athrow
    //   305: astore_3
    //   306: goto +90 -> 396
    //   309: astore_2
    //   310: aload_2
    //   311: invokevirtual 192	java/lang/Throwable:printStackTrace	()V
    //   314: iload_0
    //   315: getstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   318: if_icmpeq +74 -> 392
    //   321: getstatic 31	com/tencent/hlyyb/common/a/a:g	Ljava/util/Map;
    //   324: astore_2
    //   325: aload_2
    //   326: monitorenter
    //   327: getstatic 31	com/tencent/hlyyb/common/a/a:g	Ljava/util/Map;
    //   330: invokeinterface 167 1 0
    //   335: invokeinterface 173 1 0
    //   340: astore_3
    //   341: aload_3
    //   342: invokeinterface 178 1 0
    //   347: ifeq +35 -> 382
    //   350: aload_3
    //   351: invokeinterface 182 1 0
    //   356: checkcast 184	com/tencent/hlyyb/common/a/b
    //   359: astore 4
    //   361: aload 4
    //   363: ifnull -22 -> 341
    //   366: aload 4
    //   368: getstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   371: invokestatic 186	com/tencent/hlyyb/common/a/a:b	()Ljava/lang/String;
    //   374: invokeinterface 189 3 0
    //   379: goto -38 -> 341
    //   382: aload_2
    //   383: monitorexit
    //   384: goto +8 -> 392
    //   387: astore_3
    //   388: aload_2
    //   389: monitorexit
    //   390: aload_3
    //   391: athrow
    //   392: ldc 2
    //   394: monitorexit
    //   395: return
    //   396: iload_0
    //   397: getstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   400: if_icmpeq +77 -> 477
    //   403: getstatic 31	com/tencent/hlyyb/common/a/a:g	Ljava/util/Map;
    //   406: astore_2
    //   407: aload_2
    //   408: monitorenter
    //   409: getstatic 31	com/tencent/hlyyb/common/a/a:g	Ljava/util/Map;
    //   412: invokeinterface 167 1 0
    //   417: invokeinterface 173 1 0
    //   422: astore 4
    //   424: aload 4
    //   426: invokeinterface 178 1 0
    //   431: ifeq +36 -> 467
    //   434: aload 4
    //   436: invokeinterface 182 1 0
    //   441: checkcast 184	com/tencent/hlyyb/common/a/b
    //   444: astore 5
    //   446: aload 5
    //   448: ifnull -24 -> 424
    //   451: aload 5
    //   453: getstatic 61	com/tencent/hlyyb/common/a/a:e	I
    //   456: invokestatic 186	com/tencent/hlyyb/common/a/a:b	()Ljava/lang/String;
    //   459: invokeinterface 189 3 0
    //   464: goto -40 -> 424
    //   467: aload_2
    //   468: monitorexit
    //   469: goto +8 -> 477
    //   472: astore_3
    //   473: aload_2
    //   474: monitorexit
    //   475: aload_3
    //   476: athrow
    //   477: aload_3
    //   478: athrow
    //   479: astore_2
    //   480: ldc 2
    //   482: monitorexit
    //   483: goto +5 -> 488
    //   486: aload_2
    //   487: athrow
    //   488: goto -2 -> 486
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	395	0	i	int
    //   48	96	1	j	int
    //   309	2	2	localThrowable	Throwable
    //   479	8	2	localObject2	Object
    //   98	166	3	localObject3	Object
    //   300	4	3	localObject4	Object
    //   305	1	3	localObject5	Object
    //   340	11	3	localIterator	java.util.Iterator
    //   387	4	3	localObject6	Object
    //   472	6	3	localObject7	Object
    //   272	163	4	localObject8	Object
    //   444	8	5	localb	b
    // Exception table:
    //   from	to	target	type
    //   240	254	300	finally
    //   254	274	300	finally
    //   279	292	300	finally
    //   295	297	300	finally
    //   301	303	300	finally
    //   7	22	305	finally
    //   26	49	305	finally
    //   54	91	305	finally
    //   94	99	305	finally
    //   103	113	305	finally
    //   117	122	305	finally
    //   146	150	305	finally
    //   153	157	305	finally
    //   160	164	305	finally
    //   164	175	305	finally
    //   178	191	305	finally
    //   194	207	305	finally
    //   210	227	305	finally
    //   310	314	305	finally
    //   7	22	309	java/lang/Throwable
    //   26	49	309	java/lang/Throwable
    //   54	91	309	java/lang/Throwable
    //   94	99	309	java/lang/Throwable
    //   103	113	309	java/lang/Throwable
    //   117	122	309	java/lang/Throwable
    //   146	150	309	java/lang/Throwable
    //   153	157	309	java/lang/Throwable
    //   160	164	309	java/lang/Throwable
    //   164	175	309	java/lang/Throwable
    //   178	191	309	java/lang/Throwable
    //   194	207	309	java/lang/Throwable
    //   210	227	309	java/lang/Throwable
    //   327	341	387	finally
    //   341	361	387	finally
    //   366	379	387	finally
    //   382	384	387	finally
    //   388	390	387	finally
    //   409	424	472	finally
    //   424	446	472	finally
    //   451	464	472	finally
    //   467	469	472	finally
    //   473	475	472	finally
    //   3	7	479	finally
    //   227	240	479	finally
    //   303	305	479	finally
    //   314	327	479	finally
    //   390	392	479	finally
    //   396	409	479	finally
    //   475	477	479	finally
    //   477	479	479	finally
  }
  
  public static boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        PowerManager localPowerManager = (PowerManager)com.tencent.hlyyb.common.a.a().getSystemService("power");
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
  
  public static boolean f()
  {
    return (e == 2) || (e == 3) || (e == 4);
  }
  
  public static int g()
  {
    return e;
  }
  
  public static boolean h()
  {
    return a;
  }
  
  public static boolean i()
  {
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.common.a.a
 * JD-Core Version:    0.7.0.1
 */