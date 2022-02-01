package com.tencent.featuretoggle.hltxkg.common.a;

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
import com.tencent.featuretoggle.hltxkg.common.a;
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

public final class e
{
  private static volatile byte a = 0;
  private static volatile boolean b = true;
  private static String c = "";
  private static String d = "unknown";
  private static volatile int e = 0;
  private static volatile boolean f = false;
  private static volatile int g = -1;
  private static Map<String, j> h = new ConcurrentHashMap();
  private static BroadcastReceiver i = new f();
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
          if (i.b(paramString))
          {
            i2 = 1;
          }
          else if ((i1 == 0) && (i.c(paramString)))
          {
            boolean bool = i.a(paramString);
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
      m();
      d();
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      a.a().registerReceiver(i, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(String paramString, j paramj)
  {
    synchronized (h)
    {
      h.put(paramString, paramj);
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
  
  /* Error */
  public static void d()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   6: istore_0
    //   7: invokestatic 151	com/tencent/featuretoggle/hltxkg/common/a:a	()Landroid/content/Context;
    //   10: ldc 178
    //   12: invokevirtual 182	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 184	android/net/ConnectivityManager
    //   18: invokevirtual 188	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull +345 -> 368
    //   26: aload_3
    //   27: invokevirtual 193	android/net/NetworkInfo:isAvailable	()Z
    //   30: ifeq +338 -> 368
    //   33: aload_3
    //   34: invokevirtual 196	android/net/NetworkInfo:isConnected	()Z
    //   37: ifeq +331 -> 368
    //   40: iconst_1
    //   41: putstatic 198	com/tencent/featuretoggle/hltxkg/common/a/e:b	Z
    //   44: aload_3
    //   45: invokevirtual 202	android/net/NetworkInfo:getType	()I
    //   48: istore_1
    //   49: iload_1
    //   50: iconst_1
    //   51: if_icmpne +75 -> 126
    //   54: iconst_1
    //   55: putstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   58: iconst_0
    //   59: putstatic 204	com/tencent/featuretoggle/hltxkg/common/a/e:g	I
    //   62: iconst_0
    //   63: putstatic 206	com/tencent/featuretoggle/hltxkg/common/a/e:f	Z
    //   66: invokestatic 151	com/tencent/featuretoggle/hltxkg/common/a:a	()Landroid/content/Context;
    //   69: invokevirtual 209	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   72: ldc 176
    //   74: invokevirtual 182	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   77: checkcast 211	android/net/wifi/WifiManager
    //   80: invokestatic 217	com/tencent/mobileqq/qmethodmonitor/monitor/NetworkMonitor:getConnectionInfo	(Landroid/net/wifi/WifiManager;)Landroid/net/wifi/WifiInfo;
    //   83: astore_3
    //   84: new 219	java/lang/StringBuilder
    //   87: dup
    //   88: ldc 221
    //   90: invokespecial 222	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: astore 4
    //   95: aload 4
    //   97: aload_3
    //   98: invokevirtual 227	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   101: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 4
    //   107: aload_3
    //   108: invokevirtual 234	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   111: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: putstatic 166	com/tencent/featuretoggle/hltxkg/common/a/e:d	Ljava/lang/String;
    //   123: goto +275 -> 398
    //   126: aload_3
    //   127: invokevirtual 240	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   130: astore 4
    //   132: aload 4
    //   134: ifnull +213 -> 347
    //   137: aload 4
    //   139: invokevirtual 243	java/lang/String:trim	()Ljava/lang/String;
    //   142: invokevirtual 246	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   145: putstatic 248	com/tencent/featuretoggle/hltxkg/common/a/e:c	Ljava/lang/String;
    //   148: iload_1
    //   149: ifne +173 -> 322
    //   152: new 219	java/lang/StringBuilder
    //   155: dup
    //   156: ldc 250
    //   158: invokespecial 222	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: astore 4
    //   163: aload 4
    //   165: getstatic 248	com/tencent/featuretoggle/hltxkg/common/a/e:c	Ljava/lang/String;
    //   168: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 4
    //   174: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: putstatic 166	com/tencent/featuretoggle/hltxkg/common/a/e:d	Ljava/lang/String;
    //   180: aload_3
    //   181: invokevirtual 253	android/net/NetworkInfo:getSubtype	()I
    //   184: istore_1
    //   185: iload_1
    //   186: putstatic 204	com/tencent/featuretoggle/hltxkg/common/a/e:g	I
    //   189: iload_1
    //   190: iconst_1
    //   191: if_icmpeq +30 -> 221
    //   194: iload_1
    //   195: iconst_2
    //   196: if_icmpeq +25 -> 221
    //   199: iload_1
    //   200: iconst_4
    //   201: if_icmpne +469 -> 670
    //   204: goto +17 -> 221
    //   207: iconst_3
    //   208: putstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   211: goto +14 -> 225
    //   214: iconst_4
    //   215: putstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   218: goto +7 -> 225
    //   221: iconst_2
    //   222: putstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   225: getstatic 248	com/tencent/featuretoggle/hltxkg/common/a/e:c	Ljava/lang/String;
    //   228: ldc 255
    //   230: invokevirtual 120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   233: istore_2
    //   234: iload_2
    //   235: putstatic 206	com/tencent/featuretoggle/hltxkg/common/a/e:f	Z
    //   238: iload_2
    //   239: ifeq +159 -> 398
    //   242: getstatic 248	com/tencent/featuretoggle/hltxkg/common/a/e:c	Ljava/lang/String;
    //   245: getstatic 56	com/tencent/featuretoggle/hltxkg/common/a/e:l	Ljava/lang/String;
    //   248: invokevirtual 120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   251: ifeq +14 -> 265
    //   254: ldc_w 257
    //   257: astore_3
    //   258: aload_3
    //   259: putstatic 48	com/tencent/featuretoggle/hltxkg/common/a/e:j	Ljava/lang/String;
    //   262: goto +136 -> 398
    //   265: getstatic 248	com/tencent/featuretoggle/hltxkg/common/a/e:c	Ljava/lang/String;
    //   268: getstatic 52	com/tencent/featuretoggle/hltxkg/common/a/e:k	Ljava/lang/String;
    //   271: invokevirtual 120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   274: ifeq +10 -> 284
    //   277: ldc_w 257
    //   280: astore_3
    //   281: goto -23 -> 258
    //   284: getstatic 248	com/tencent/featuretoggle/hltxkg/common/a/e:c	Ljava/lang/String;
    //   287: getstatic 60	com/tencent/featuretoggle/hltxkg/common/a/e:m	Ljava/lang/String;
    //   290: invokevirtual 120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   293: ifeq +10 -> 303
    //   296: ldc_w 257
    //   299: astore_3
    //   300: goto -42 -> 258
    //   303: getstatic 248	com/tencent/featuretoggle/hltxkg/common/a/e:c	Ljava/lang/String;
    //   306: getstatic 64	com/tencent/featuretoggle/hltxkg/common/a/e:n	Ljava/lang/String;
    //   309: invokevirtual 120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   312: ifeq +373 -> 685
    //   315: ldc_w 259
    //   318: astore_3
    //   319: goto -61 -> 258
    //   322: ldc 17
    //   324: putstatic 248	com/tencent/featuretoggle/hltxkg/common/a/e:c	Ljava/lang/String;
    //   327: iconst_0
    //   328: putstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   331: iconst_m1
    //   332: putstatic 204	com/tencent/featuretoggle/hltxkg/common/a/e:g	I
    //   335: ldc 17
    //   337: putstatic 166	com/tencent/featuretoggle/hltxkg/common/a/e:d	Ljava/lang/String;
    //   340: iconst_0
    //   341: putstatic 206	com/tencent/featuretoggle/hltxkg/common/a/e:f	Z
    //   344: goto +54 -> 398
    //   347: ldc 17
    //   349: putstatic 248	com/tencent/featuretoggle/hltxkg/common/a/e:c	Ljava/lang/String;
    //   352: iconst_0
    //   353: putstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   356: iconst_m1
    //   357: putstatic 204	com/tencent/featuretoggle/hltxkg/common/a/e:g	I
    //   360: ldc 17
    //   362: putstatic 166	com/tencent/featuretoggle/hltxkg/common/a/e:d	Ljava/lang/String;
    //   365: goto -25 -> 340
    //   368: ldc 17
    //   370: putstatic 248	com/tencent/featuretoggle/hltxkg/common/a/e:c	Ljava/lang/String;
    //   373: iconst_0
    //   374: putstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   377: iconst_m1
    //   378: putstatic 204	com/tencent/featuretoggle/hltxkg/common/a/e:g	I
    //   381: ldc 17
    //   383: putstatic 166	com/tencent/featuretoggle/hltxkg/common/a/e:d	Ljava/lang/String;
    //   386: iconst_0
    //   387: putstatic 206	com/tencent/featuretoggle/hltxkg/common/a/e:f	Z
    //   390: iconst_0
    //   391: putstatic 198	com/tencent/featuretoggle/hltxkg/common/a/e:b	Z
    //   394: iconst_0
    //   395: putstatic 261	com/tencent/featuretoggle/hltxkg/common/a/e:a	B
    //   398: iload_0
    //   399: getstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   402: if_icmpeq +168 -> 570
    //   405: getstatic 41	com/tencent/featuretoggle/hltxkg/common/a/e:h	Ljava/util/Map;
    //   408: astore_3
    //   409: aload_3
    //   410: monitorenter
    //   411: getstatic 41	com/tencent/featuretoggle/hltxkg/common/a/e:h	Ljava/util/Map;
    //   414: invokeinterface 265 1 0
    //   419: invokeinterface 268 1 0
    //   424: astore 4
    //   426: aload 4
    //   428: invokeinterface 93 1 0
    //   433: ifeq +34 -> 467
    //   436: aload 4
    //   438: invokeinterface 97 1 0
    //   443: checkcast 270	com/tencent/featuretoggle/hltxkg/common/a/j
    //   446: astore 5
    //   448: aload 5
    //   450: ifnull -24 -> 426
    //   453: aload 5
    //   455: getstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   458: getstatic 166	com/tencent/featuretoggle/hltxkg/common/a/e:d	Ljava/lang/String;
    //   461: invokevirtual 273	com/tencent/featuretoggle/hltxkg/common/a/j:a	(ILjava/lang/String;)V
    //   464: goto -38 -> 426
    //   467: aload_3
    //   468: monitorexit
    //   469: goto +101 -> 570
    //   472: astore 4
    //   474: aload_3
    //   475: monitorexit
    //   476: aload 4
    //   478: athrow
    //   479: astore 4
    //   481: goto +93 -> 574
    //   484: astore_3
    //   485: aload_3
    //   486: invokevirtual 276	java/lang/Throwable:printStackTrace	()V
    //   489: iload_0
    //   490: getstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   493: if_icmpeq +77 -> 570
    //   496: getstatic 41	com/tencent/featuretoggle/hltxkg/common/a/e:h	Ljava/util/Map;
    //   499: astore_3
    //   500: aload_3
    //   501: monitorenter
    //   502: getstatic 41	com/tencent/featuretoggle/hltxkg/common/a/e:h	Ljava/util/Map;
    //   505: invokeinterface 265 1 0
    //   510: invokeinterface 268 1 0
    //   515: astore 4
    //   517: aload 4
    //   519: invokeinterface 93 1 0
    //   524: ifeq +34 -> 558
    //   527: aload 4
    //   529: invokeinterface 97 1 0
    //   534: checkcast 270	com/tencent/featuretoggle/hltxkg/common/a/j
    //   537: astore 5
    //   539: aload 5
    //   541: ifnull -24 -> 517
    //   544: aload 5
    //   546: getstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   549: getstatic 166	com/tencent/featuretoggle/hltxkg/common/a/e:d	Ljava/lang/String;
    //   552: invokevirtual 273	com/tencent/featuretoggle/hltxkg/common/a/j:a	(ILjava/lang/String;)V
    //   555: goto -38 -> 517
    //   558: aload_3
    //   559: monitorexit
    //   560: goto +10 -> 570
    //   563: astore 4
    //   565: aload_3
    //   566: monitorexit
    //   567: aload 4
    //   569: athrow
    //   570: ldc 2
    //   572: monitorexit
    //   573: return
    //   574: iload_0
    //   575: getstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   578: if_icmpeq +77 -> 655
    //   581: getstatic 41	com/tencent/featuretoggle/hltxkg/common/a/e:h	Ljava/util/Map;
    //   584: astore_3
    //   585: aload_3
    //   586: monitorenter
    //   587: getstatic 41	com/tencent/featuretoggle/hltxkg/common/a/e:h	Ljava/util/Map;
    //   590: invokeinterface 265 1 0
    //   595: invokeinterface 268 1 0
    //   600: astore 5
    //   602: aload 5
    //   604: invokeinterface 93 1 0
    //   609: ifeq +34 -> 643
    //   612: aload 5
    //   614: invokeinterface 97 1 0
    //   619: checkcast 270	com/tencent/featuretoggle/hltxkg/common/a/j
    //   622: astore 6
    //   624: aload 6
    //   626: ifnull -24 -> 602
    //   629: aload 6
    //   631: getstatic 168	com/tencent/featuretoggle/hltxkg/common/a/e:e	I
    //   634: getstatic 166	com/tencent/featuretoggle/hltxkg/common/a/e:d	Ljava/lang/String;
    //   637: invokevirtual 273	com/tencent/featuretoggle/hltxkg/common/a/j:a	(ILjava/lang/String;)V
    //   640: goto -38 -> 602
    //   643: aload_3
    //   644: monitorexit
    //   645: goto +10 -> 655
    //   648: astore 4
    //   650: aload_3
    //   651: monitorexit
    //   652: aload 4
    //   654: athrow
    //   655: aload 4
    //   657: athrow
    //   658: astore_3
    //   659: ldc 2
    //   661: monitorexit
    //   662: goto +5 -> 667
    //   665: aload_3
    //   666: athrow
    //   667: goto -2 -> 665
    //   670: iload_1
    //   671: bipush 13
    //   673: if_icmpeq -459 -> 214
    //   676: iload_1
    //   677: bipush 19
    //   679: if_icmpne -472 -> 207
    //   682: goto -468 -> 214
    //   685: ldc 14
    //   687: astore_3
    //   688: goto -430 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	573	0	i1	int
    //   48	632	1	i2	int
    //   233	6	2	bool	boolean
    //   484	2	3	localThrowable	Throwable
    //   658	8	3	localObject2	Object
    //   687	1	3	str	String
    //   93	344	4	localObject3	Object
    //   472	5	4	localObject4	Object
    //   479	1	4	localObject5	Object
    //   515	13	4	localIterator	Iterator
    //   563	5	4	localObject6	Object
    //   648	8	4	localObject7	Object
    //   446	167	5	localObject8	Object
    //   622	8	6	localj	j
    // Exception table:
    //   from	to	target	type
    //   411	426	472	finally
    //   426	448	472	finally
    //   453	464	472	finally
    //   467	469	472	finally
    //   7	22	479	finally
    //   26	49	479	finally
    //   54	123	479	finally
    //   126	132	479	finally
    //   137	148	479	finally
    //   152	189	479	finally
    //   207	211	479	finally
    //   214	218	479	finally
    //   221	225	479	finally
    //   225	238	479	finally
    //   242	254	479	finally
    //   258	262	479	finally
    //   265	277	479	finally
    //   284	296	479	finally
    //   303	315	479	finally
    //   322	340	479	finally
    //   340	344	479	finally
    //   347	365	479	finally
    //   368	398	479	finally
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
    //   225	238	484	java/lang/Throwable
    //   242	254	484	java/lang/Throwable
    //   258	262	484	java/lang/Throwable
    //   265	277	484	java/lang/Throwable
    //   284	296	484	java/lang/Throwable
    //   303	315	484	java/lang/Throwable
    //   322	340	484	java/lang/Throwable
    //   340	344	484	java/lang/Throwable
    //   347	365	484	java/lang/Throwable
    //   368	398	484	java/lang/Throwable
    //   502	517	563	finally
    //   517	539	563	finally
    //   544	555	563	finally
    //   558	560	563	finally
    //   587	602	648	finally
    //   602	624	648	finally
    //   629	640	648	finally
    //   643	645	648	finally
    //   3	7	658	finally
    //   398	411	658	finally
    //   474	479	658	finally
    //   489	502	658	finally
    //   565	570	658	finally
    //   574	587	658	finally
    //   650	655	658	finally
    //   655	658	658	finally
  }
  
  public static int e()
  {
    return e;
  }
  
  public static byte f()
  {
    return a;
  }
  
  public static boolean g()
  {
    return b;
  }
  
  public static boolean h()
  {
    return f;
  }
  
  public static Integer i()
  {
    d();
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
      Object localObject2 = a.a();
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
  
  public static Proxy j()
  {
    if ((f) && (!TextUtils.isEmpty(j))) {
      return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(j, 80));
    }
    return null;
  }
  
  public static boolean k()
  {
    boolean bool2 = false;
    try
    {
      PowerManager localPowerManager = (PowerManager)a.a().getSystemService("power");
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
  
  private static boolean m()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      a = 1;
      return false;
    }
    Object localObject = (ConnectivityManager)a.a().getSystemService("connectivity");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.e
 * JD-Core Version:    0.7.0.1
 */