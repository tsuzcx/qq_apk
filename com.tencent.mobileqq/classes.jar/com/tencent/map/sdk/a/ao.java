package com.tencent.map.sdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ao
{
  private static volatile byte a = 0;
  private static volatile boolean b = true;
  private static String c = "";
  private static String d = "unknown";
  private static volatile int e = 0;
  private static volatile boolean f = false;
  private static volatile int g = -1;
  private static Map<String, at> h = new ConcurrentHashMap();
  private static BroadcastReceiver i = new ap();
  private static String j = "";
  private static String k = "cmwap";
  private static String l = "3gwap";
  private static String m = "uniwap";
  private static String n = "ctwap";
  
  private static byte a(String paramString)
  {
    try
    {
      paramString = NetworkInterface.getByName(paramString);
      if (!paramString.isUp()) {
        return 1;
      }
      Iterator localIterator = paramString.getInterfaceAddresses().iterator();
      int i2 = 0;
      int i1 = 0;
      while (localIterator.hasNext())
      {
        paramString = ((InterfaceAddress)localIterator.next()).getAddress();
        if (!paramString.isLoopbackAddress())
        {
          String str = paramString.getHostAddress();
          paramString = str;
          if (str.contains("%")) {
            paramString = str.split("%")[0];
          }
          if (as.b(paramString))
          {
            i2 = 1;
          }
          else if ((i1 == 0) && (as.c(paramString)))
          {
            boolean bool = as.a(paramString);
            if (bool) {
              i1 = 1;
            }
          }
        }
      }
      if ((i2 != 0) && (i1 != 0)) {
        return 2;
      }
      if (i1 != 0) {
        return 3;
      }
      if (i2 != 0) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static void a()
  {
    try
    {
      o();
      e();
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      ac.a().registerReceiver(i, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(String paramString, at paramat)
  {
    synchronized (h)
    {
      h.put(paramString, paramat);
      return;
    }
  }
  
  public static String b()
  {
    return d;
  }
  
  public static String c()
  {
    int i1 = e;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
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
    int i1 = e;
    if (i1 != 1)
    {
      if ((i1 != 2) && (i1 != 3) && (i1 != 4)) {
        return "null";
      }
      return c;
    }
    return "wifi";
  }
  
  /* Error */
  public static void e()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   6: istore_0
    //   7: invokestatic 152	com/tencent/map/sdk/a/ac:a	()Landroid/content/Context;
    //   10: ldc 183
    //   12: invokevirtual 187	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 189	android/net/ConnectivityManager
    //   18: invokevirtual 193	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull +350 -> 373
    //   26: aload_3
    //   27: invokevirtual 198	android/net/NetworkInfo:isAvailable	()Z
    //   30: ifeq +343 -> 373
    //   33: aload_3
    //   34: invokevirtual 201	android/net/NetworkInfo:isConnected	()Z
    //   37: ifeq +336 -> 373
    //   40: iconst_1
    //   41: putstatic 203	com/tencent/map/sdk/a/ao:b	Z
    //   44: aload_3
    //   45: invokevirtual 207	android/net/NetworkInfo:getType	()I
    //   48: istore_1
    //   49: iload_1
    //   50: iconst_1
    //   51: if_icmpne +75 -> 126
    //   54: iconst_1
    //   55: putstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   58: iconst_0
    //   59: putstatic 209	com/tencent/map/sdk/a/ao:g	I
    //   62: iconst_0
    //   63: putstatic 211	com/tencent/map/sdk/a/ao:f	Z
    //   66: invokestatic 152	com/tencent/map/sdk/a/ac:a	()Landroid/content/Context;
    //   69: invokevirtual 214	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   72: ldc 177
    //   74: invokevirtual 187	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   77: checkcast 216	android/net/wifi/WifiManager
    //   80: invokestatic 222	com/tencent/mobileqq/qmethodmonitor/monitor/NetworkMonitor:getConnectionInfo	(Landroid/net/wifi/WifiManager;)Landroid/net/wifi/WifiInfo;
    //   83: astore_3
    //   84: new 224	java/lang/StringBuilder
    //   87: dup
    //   88: ldc 226
    //   90: invokespecial 227	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: astore 4
    //   95: aload 4
    //   97: aload_3
    //   98: invokevirtual 232	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   101: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 4
    //   107: aload_3
    //   108: invokevirtual 239	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   111: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: putstatic 167	com/tencent/map/sdk/a/ao:d	Ljava/lang/String;
    //   123: goto +280 -> 403
    //   126: aload_3
    //   127: invokevirtual 245	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   130: astore 4
    //   132: aload 4
    //   134: ifnull +214 -> 348
    //   137: aload 4
    //   139: invokevirtual 248	java/lang/String:trim	()Ljava/lang/String;
    //   142: invokevirtual 251	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   145: putstatic 181	com/tencent/map/sdk/a/ao:c	Ljava/lang/String;
    //   148: iload_1
    //   149: ifne +174 -> 323
    //   152: new 224	java/lang/StringBuilder
    //   155: dup
    //   156: ldc 253
    //   158: invokespecial 227	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: astore 4
    //   163: aload 4
    //   165: getstatic 181	com/tencent/map/sdk/a/ao:c	Ljava/lang/String;
    //   168: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 4
    //   174: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: putstatic 167	com/tencent/map/sdk/a/ao:d	Ljava/lang/String;
    //   180: aload_3
    //   181: invokevirtual 256	android/net/NetworkInfo:getSubtype	()I
    //   184: istore_1
    //   185: iload_1
    //   186: putstatic 209	com/tencent/map/sdk/a/ao:g	I
    //   189: iload_1
    //   190: iconst_1
    //   191: if_icmpeq +30 -> 221
    //   194: iload_1
    //   195: iconst_2
    //   196: if_icmpeq +25 -> 221
    //   199: iload_1
    //   200: iconst_4
    //   201: if_icmpne +458 -> 659
    //   204: goto +17 -> 221
    //   207: iconst_3
    //   208: putstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   211: goto +14 -> 225
    //   214: iconst_4
    //   215: putstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   218: goto +7 -> 225
    //   221: iconst_2
    //   222: putstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   225: getstatic 181	com/tencent/map/sdk/a/ao:c	Ljava/lang/String;
    //   228: ldc_w 258
    //   231: invokevirtual 120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   234: istore_2
    //   235: iload_2
    //   236: putstatic 211	com/tencent/map/sdk/a/ao:f	Z
    //   239: iload_2
    //   240: ifeq +163 -> 403
    //   243: getstatic 181	com/tencent/map/sdk/a/ao:c	Ljava/lang/String;
    //   246: getstatic 56	com/tencent/map/sdk/a/ao:l	Ljava/lang/String;
    //   249: invokevirtual 120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   252: ifeq +14 -> 266
    //   255: ldc_w 260
    //   258: astore_3
    //   259: aload_3
    //   260: putstatic 48	com/tencent/map/sdk/a/ao:j	Ljava/lang/String;
    //   263: goto +140 -> 403
    //   266: getstatic 181	com/tencent/map/sdk/a/ao:c	Ljava/lang/String;
    //   269: getstatic 52	com/tencent/map/sdk/a/ao:k	Ljava/lang/String;
    //   272: invokevirtual 120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   275: ifeq +10 -> 285
    //   278: ldc_w 260
    //   281: astore_3
    //   282: goto -23 -> 259
    //   285: getstatic 181	com/tencent/map/sdk/a/ao:c	Ljava/lang/String;
    //   288: getstatic 60	com/tencent/map/sdk/a/ao:m	Ljava/lang/String;
    //   291: invokevirtual 120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   294: ifeq +10 -> 304
    //   297: ldc_w 260
    //   300: astore_3
    //   301: goto -42 -> 259
    //   304: getstatic 181	com/tencent/map/sdk/a/ao:c	Ljava/lang/String;
    //   307: getstatic 64	com/tencent/map/sdk/a/ao:n	Ljava/lang/String;
    //   310: invokevirtual 120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   313: ifeq +361 -> 674
    //   316: ldc_w 262
    //   319: astore_3
    //   320: goto -61 -> 259
    //   323: ldc 17
    //   325: putstatic 181	com/tencent/map/sdk/a/ao:c	Ljava/lang/String;
    //   328: iconst_0
    //   329: putstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   332: iconst_m1
    //   333: putstatic 209	com/tencent/map/sdk/a/ao:g	I
    //   336: ldc 17
    //   338: putstatic 167	com/tencent/map/sdk/a/ao:d	Ljava/lang/String;
    //   341: iconst_0
    //   342: putstatic 211	com/tencent/map/sdk/a/ao:f	Z
    //   345: goto +58 -> 403
    //   348: ldc 17
    //   350: putstatic 181	com/tencent/map/sdk/a/ao:c	Ljava/lang/String;
    //   353: iconst_0
    //   354: putstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   357: iconst_m1
    //   358: putstatic 209	com/tencent/map/sdk/a/ao:g	I
    //   361: ldc 17
    //   363: putstatic 167	com/tencent/map/sdk/a/ao:d	Ljava/lang/String;
    //   366: iconst_0
    //   367: putstatic 211	com/tencent/map/sdk/a/ao:f	Z
    //   370: goto +33 -> 403
    //   373: ldc 17
    //   375: putstatic 181	com/tencent/map/sdk/a/ao:c	Ljava/lang/String;
    //   378: iconst_0
    //   379: putstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   382: iconst_m1
    //   383: putstatic 209	com/tencent/map/sdk/a/ao:g	I
    //   386: ldc 17
    //   388: putstatic 167	com/tencent/map/sdk/a/ao:d	Ljava/lang/String;
    //   391: iconst_0
    //   392: putstatic 211	com/tencent/map/sdk/a/ao:f	Z
    //   395: iconst_0
    //   396: putstatic 203	com/tencent/map/sdk/a/ao:b	Z
    //   399: iconst_0
    //   400: putstatic 264	com/tencent/map/sdk/a/ao:a	B
    //   403: iload_0
    //   404: getstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   407: if_icmpeq +158 -> 565
    //   410: getstatic 41	com/tencent/map/sdk/a/ao:h	Ljava/util/Map;
    //   413: astore_3
    //   414: aload_3
    //   415: monitorenter
    //   416: getstatic 41	com/tencent/map/sdk/a/ao:h	Ljava/util/Map;
    //   419: invokeinterface 268 1 0
    //   424: invokeinterface 271 1 0
    //   429: astore 4
    //   431: aload 4
    //   433: invokeinterface 93 1 0
    //   438: ifeq +28 -> 466
    //   441: aload 4
    //   443: invokeinterface 97 1 0
    //   448: checkcast 273	com/tencent/map/sdk/a/at
    //   451: ifnull -20 -> 431
    //   454: getstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   457: getstatic 167	com/tencent/map/sdk/a/ao:d	Ljava/lang/String;
    //   460: invokestatic 276	com/tencent/map/sdk/a/at:a	(ILjava/lang/String;)V
    //   463: goto -32 -> 431
    //   466: aload_3
    //   467: monitorexit
    //   468: ldc 2
    //   470: monitorexit
    //   471: return
    //   472: astore 4
    //   474: aload_3
    //   475: monitorexit
    //   476: aload 4
    //   478: athrow
    //   479: astore 4
    //   481: goto +88 -> 569
    //   484: astore_3
    //   485: aload_3
    //   486: invokevirtual 279	java/lang/Throwable:printStackTrace	()V
    //   489: iload_0
    //   490: getstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   493: if_icmpeq +72 -> 565
    //   496: getstatic 41	com/tencent/map/sdk/a/ao:h	Ljava/util/Map;
    //   499: astore_3
    //   500: aload_3
    //   501: monitorenter
    //   502: getstatic 41	com/tencent/map/sdk/a/ao:h	Ljava/util/Map;
    //   505: invokeinterface 268 1 0
    //   510: invokeinterface 271 1 0
    //   515: astore 4
    //   517: aload 4
    //   519: invokeinterface 93 1 0
    //   524: ifeq +28 -> 552
    //   527: aload 4
    //   529: invokeinterface 97 1 0
    //   534: checkcast 273	com/tencent/map/sdk/a/at
    //   537: ifnull -20 -> 517
    //   540: getstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   543: getstatic 167	com/tencent/map/sdk/a/ao:d	Ljava/lang/String;
    //   546: invokestatic 276	com/tencent/map/sdk/a/at:a	(ILjava/lang/String;)V
    //   549: goto -32 -> 517
    //   552: aload_3
    //   553: monitorexit
    //   554: ldc 2
    //   556: monitorexit
    //   557: return
    //   558: astore 4
    //   560: aload_3
    //   561: monitorexit
    //   562: aload 4
    //   564: athrow
    //   565: ldc 2
    //   567: monitorexit
    //   568: return
    //   569: iload_0
    //   570: getstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   573: if_icmpeq +71 -> 644
    //   576: getstatic 41	com/tencent/map/sdk/a/ao:h	Ljava/util/Map;
    //   579: astore_3
    //   580: aload_3
    //   581: monitorenter
    //   582: getstatic 41	com/tencent/map/sdk/a/ao:h	Ljava/util/Map;
    //   585: invokeinterface 268 1 0
    //   590: invokeinterface 271 1 0
    //   595: astore 5
    //   597: aload 5
    //   599: invokeinterface 93 1 0
    //   604: ifeq +28 -> 632
    //   607: aload 5
    //   609: invokeinterface 97 1 0
    //   614: checkcast 273	com/tencent/map/sdk/a/at
    //   617: ifnull -20 -> 597
    //   620: getstatic 169	com/tencent/map/sdk/a/ao:e	I
    //   623: getstatic 167	com/tencent/map/sdk/a/ao:d	Ljava/lang/String;
    //   626: invokestatic 276	com/tencent/map/sdk/a/at:a	(ILjava/lang/String;)V
    //   629: goto -32 -> 597
    //   632: aload_3
    //   633: monitorexit
    //   634: goto +10 -> 644
    //   637: astore 4
    //   639: aload_3
    //   640: monitorexit
    //   641: aload 4
    //   643: athrow
    //   644: aload 4
    //   646: athrow
    //   647: astore_3
    //   648: ldc 2
    //   650: monitorexit
    //   651: goto +5 -> 656
    //   654: aload_3
    //   655: athrow
    //   656: goto -2 -> 654
    //   659: iload_1
    //   660: bipush 13
    //   662: if_icmpeq -448 -> 214
    //   665: iload_1
    //   666: bipush 19
    //   668: if_icmpne -461 -> 207
    //   671: goto -457 -> 214
    //   674: ldc 14
    //   676: astore_3
    //   677: goto -418 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	568	0	i1	int
    //   48	621	1	i2	int
    //   234	6	2	bool	boolean
    //   484	2	3	localThrowable	Throwable
    //   647	8	3	localObject2	Object
    //   676	1	3	str	String
    //   93	349	4	localObject3	Object
    //   472	5	4	localObject4	Object
    //   479	1	4	localObject5	Object
    //   515	13	4	localIterator1	Iterator
    //   558	5	4	localObject6	Object
    //   637	8	4	localObject7	Object
    //   595	13	5	localIterator2	Iterator
    // Exception table:
    //   from	to	target	type
    //   416	431	472	finally
    //   431	463	472	finally
    //   466	468	472	finally
    //   474	476	472	finally
    //   7	22	479	finally
    //   26	49	479	finally
    //   54	123	479	finally
    //   126	132	479	finally
    //   137	148	479	finally
    //   152	189	479	finally
    //   207	211	479	finally
    //   214	218	479	finally
    //   221	225	479	finally
    //   225	239	479	finally
    //   243	255	479	finally
    //   259	263	479	finally
    //   266	278	479	finally
    //   285	297	479	finally
    //   304	316	479	finally
    //   323	345	479	finally
    //   348	370	479	finally
    //   373	403	479	finally
    //   485	489	479	finally
    //   7	22	484	java/lang/Throwable
    //   26	49	484	java/lang/Throwable
    //   54	123	484	java/lang/Throwable
    //   126	132	484	java/lang/Throwable
    //   137	148	484	java/lang/Throwable
    //   152	189	484	java/lang/Throwable
    //   207	211	484	java/lang/Throwable
    //   214	218	484	java/lang/Throwable
    //   221	225	484	java/lang/Throwable
    //   225	239	484	java/lang/Throwable
    //   243	255	484	java/lang/Throwable
    //   259	263	484	java/lang/Throwable
    //   266	278	484	java/lang/Throwable
    //   285	297	484	java/lang/Throwable
    //   304	316	484	java/lang/Throwable
    //   323	345	484	java/lang/Throwable
    //   348	370	484	java/lang/Throwable
    //   373	403	484	java/lang/Throwable
    //   502	517	558	finally
    //   517	549	558	finally
    //   552	554	558	finally
    //   560	562	558	finally
    //   582	597	637	finally
    //   597	629	637	finally
    //   632	634	637	finally
    //   639	641	637	finally
    //   3	7	647	finally
    //   403	416	647	finally
    //   476	479	647	finally
    //   489	502	647	finally
    //   562	565	647	finally
    //   569	582	647	finally
    //   641	644	647	finally
    //   644	647	647	finally
  }
  
  public static String f()
  {
    if (g == -1) {
      return "unknown";
    }
    switch (g)
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
    return e;
  }
  
  public static byte h()
  {
    return a;
  }
  
  public static boolean i()
  {
    return b;
  }
  
  public static boolean j()
  {
    return f;
  }
  
  public static Integer k()
  {
    e();
    int i4 = e;
    Integer localInteger = Integer.valueOf(3);
    int i3 = 1;
    int i2 = 0;
    int i1 = i3;
    if (i4 != 2)
    {
      i1 = i3;
      if (e != 3) {
        if (e == 4) {
          i1 = i3;
        } else {
          i1 = 0;
        }
      }
    }
    if (i1 != 0)
    {
      Object localObject2 = ac.a();
      Object localObject1 = c;
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
      i2 = ((Integer)localObject1).intValue();
    }
    return Integer.valueOf(i2);
  }
  
  public static Proxy l()
  {
    if ((f) && (!TextUtils.isEmpty(j))) {
      return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(j, 80));
    }
    return null;
  }
  
  public static boolean m()
  {
    boolean bool2 = false;
    try
    {
      PowerManager localPowerManager = (PowerManager)ac.a().getSystemService("power");
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
  
  private static boolean o()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      a = 1;
      return false;
    }
    Object localObject = (ConnectivityManager)ac.a().getSystemService("connectivity");
    NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()) && (localNetworkInfo.isConnected())) {}
    try
    {
      localObject = (LinkProperties)ConnectivityManager.class.getDeclaredMethod("getActiveLinkProperties", new Class[0]).invoke(localObject, new Object[0]);
      if (localObject == null)
      {
        a = 0;
        return true;
      }
      a = a(((LinkProperties)localObject).getInterfaceName());
      return true;
    }
    catch (Exception localException)
    {
      label98:
      break label98;
    }
    a = 0;
    return true;
    a = 0;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ao
 * JD-Core Version:    0.7.0.1
 */