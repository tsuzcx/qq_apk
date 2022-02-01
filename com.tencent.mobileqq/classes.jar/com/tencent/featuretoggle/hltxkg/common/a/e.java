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
  private static volatile byte jdField_a_of_type_Byte = 0;
  private static volatile int jdField_a_of_type_Int = 0;
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new f();
  private static String jdField_a_of_type_JavaLangString = "";
  private static Map<String, j> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private static volatile boolean jdField_a_of_type_Boolean = true;
  private static volatile int jdField_b_of_type_Int = -1;
  private static String jdField_b_of_type_JavaLangString = "unknown";
  private static volatile boolean jdField_b_of_type_Boolean = false;
  private static String c = "";
  private static String d = "cmwap";
  private static String e = "3gwap";
  private static String f = "uniwap";
  private static String g = "ctwap";
  
  private static byte a(String paramString)
  {
    try
    {
      paramString = NetworkInterface.getByName(paramString);
      if (!paramString.isUp()) {
        return 1;
      }
      Iterator localIterator = paramString.getInterfaceAddresses().iterator();
      int j = 0;
      int i = 0;
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
            j = 1;
          }
          else if ((i == 0) && (i.c(paramString)))
          {
            boolean bool = i.a(paramString);
            if (bool) {
              i = 1;
            }
          }
        }
      }
      if ((j != 0) && (i != 0)) {
        return 2;
      }
      if (i != 0) {
        return 3;
      }
      if (j != 0) {
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
      b();
      d();
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      a.a().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(String paramString, j paramj)
  {
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      jdField_a_of_type_JavaUtilMap.put(paramString, paramj);
      return;
    }
  }
  
  public static String b()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  private static boolean b()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      jdField_a_of_type_Byte = 1;
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
        jdField_a_of_type_Byte = 0;
        return true;
      }
      jdField_a_of_type_Byte = a(((LinkProperties)localObject).getInterfaceName());
      return true;
    }
    catch (Exception localException)
    {
      label97:
      break label97;
    }
    jdField_a_of_type_Byte = 0;
    return true;
    jdField_a_of_type_Byte = 0;
    return false;
  }
  
  public static String c()
  {
    int i = jdField_a_of_type_Int;
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
    //   3: getstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   6: istore_0
    //   7: invokestatic 144	com/tencent/featuretoggle/hltxkg/common/a:a	()Landroid/content/Context;
    //   10: ldc 168
    //   12: invokevirtual 172	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 174	android/net/ConnectivityManager
    //   18: invokevirtual 178	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull +347 -> 370
    //   26: aload_3
    //   27: invokevirtual 183	android/net/NetworkInfo:isAvailable	()Z
    //   30: ifeq +340 -> 370
    //   33: aload_3
    //   34: invokevirtual 186	android/net/NetworkInfo:isConnected	()Z
    //   37: ifeq +333 -> 370
    //   40: iconst_1
    //   41: putstatic 219	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Boolean	Z
    //   44: aload_3
    //   45: invokevirtual 223	android/net/NetworkInfo:getType	()I
    //   48: istore_1
    //   49: iload_1
    //   50: iconst_1
    //   51: if_icmpne +75 -> 126
    //   54: iconst_1
    //   55: putstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   58: iconst_0
    //   59: putstatic 225	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_Int	I
    //   62: iconst_0
    //   63: putstatic 227	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_Boolean	Z
    //   66: invokestatic 144	com/tencent/featuretoggle/hltxkg/common/a:a	()Landroid/content/Context;
    //   69: invokevirtual 230	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   72: ldc 217
    //   74: invokevirtual 172	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   77: checkcast 232	android/net/wifi/WifiManager
    //   80: invokevirtual 236	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   83: astore_3
    //   84: new 238	java/lang/StringBuilder
    //   87: dup
    //   88: ldc 240
    //   90: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: astore 4
    //   95: aload 4
    //   97: aload_3
    //   98: invokevirtual 246	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   101: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 4
    //   107: aload_3
    //   108: invokevirtual 253	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   111: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: putstatic 159	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   123: goto +277 -> 400
    //   126: aload_3
    //   127: invokevirtual 259	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   130: astore 4
    //   132: aload 4
    //   134: ifnull +215 -> 349
    //   137: aload 4
    //   139: invokevirtual 262	java/lang/String:trim	()Ljava/lang/String;
    //   142: invokevirtual 265	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   145: putstatic 267	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   148: iload_1
    //   149: ifne +175 -> 324
    //   152: new 238	java/lang/StringBuilder
    //   155: dup
    //   156: ldc_w 269
    //   159: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   162: astore 4
    //   164: aload 4
    //   166: getstatic 267	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   169: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 4
    //   175: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: putstatic 159	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   181: aload_3
    //   182: invokevirtual 272	android/net/NetworkInfo:getSubtype	()I
    //   185: istore_1
    //   186: iload_1
    //   187: putstatic 225	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_Int	I
    //   190: iload_1
    //   191: iconst_1
    //   192: if_icmpeq +30 -> 222
    //   195: iload_1
    //   196: iconst_2
    //   197: if_icmpeq +25 -> 222
    //   200: iload_1
    //   201: iconst_4
    //   202: if_icmpne +470 -> 672
    //   205: goto +17 -> 222
    //   208: iconst_3
    //   209: putstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   212: goto +14 -> 226
    //   215: iconst_4
    //   216: putstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   219: goto +7 -> 226
    //   222: iconst_2
    //   223: putstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   226: getstatic 267	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   229: ldc_w 274
    //   232: invokevirtual 113	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   235: istore_2
    //   236: iload_2
    //   237: putstatic 227	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_Boolean	Z
    //   240: iload_2
    //   241: ifeq +159 -> 400
    //   244: getstatic 267	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   247: getstatic 49	com/tencent/featuretoggle/hltxkg/common/a/e:e	Ljava/lang/String;
    //   250: invokevirtual 113	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   253: ifeq +14 -> 267
    //   256: ldc_w 276
    //   259: astore_3
    //   260: aload_3
    //   261: putstatic 41	com/tencent/featuretoggle/hltxkg/common/a/e:c	Ljava/lang/String;
    //   264: goto +136 -> 400
    //   267: getstatic 267	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   270: getstatic 45	com/tencent/featuretoggle/hltxkg/common/a/e:d	Ljava/lang/String;
    //   273: invokevirtual 113	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   276: ifeq +10 -> 286
    //   279: ldc_w 276
    //   282: astore_3
    //   283: goto -23 -> 260
    //   286: getstatic 267	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   289: getstatic 53	com/tencent/featuretoggle/hltxkg/common/a/e:f	Ljava/lang/String;
    //   292: invokevirtual 113	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   295: ifeq +10 -> 305
    //   298: ldc_w 276
    //   301: astore_3
    //   302: goto -42 -> 260
    //   305: getstatic 267	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   308: getstatic 57	com/tencent/featuretoggle/hltxkg/common/a/e:g	Ljava/lang/String;
    //   311: invokevirtual 113	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   314: ifeq +373 -> 687
    //   317: ldc_w 278
    //   320: astore_3
    //   321: goto -61 -> 260
    //   324: ldc 20
    //   326: putstatic 267	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   329: iconst_0
    //   330: putstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   333: iconst_m1
    //   334: putstatic 225	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_Int	I
    //   337: ldc 20
    //   339: putstatic 159	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   342: iconst_0
    //   343: putstatic 227	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_Boolean	Z
    //   346: goto +54 -> 400
    //   349: ldc 20
    //   351: putstatic 267	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   354: iconst_0
    //   355: putstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   358: iconst_m1
    //   359: putstatic 225	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_Int	I
    //   362: ldc 20
    //   364: putstatic 159	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   367: goto -25 -> 342
    //   370: ldc 20
    //   372: putstatic 267	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   375: iconst_0
    //   376: putstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   379: iconst_m1
    //   380: putstatic 225	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_Int	I
    //   383: ldc 20
    //   385: putstatic 159	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   388: iconst_0
    //   389: putstatic 227	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_Boolean	Z
    //   392: iconst_0
    //   393: putstatic 219	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Boolean	Z
    //   396: iconst_0
    //   397: putstatic 166	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Byte	B
    //   400: iload_0
    //   401: getstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   404: if_icmpeq +168 -> 572
    //   407: getstatic 34	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   410: astore_3
    //   411: aload_3
    //   412: monitorenter
    //   413: getstatic 34	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   416: invokeinterface 282 1 0
    //   421: invokeinterface 285 1 0
    //   426: astore 4
    //   428: aload 4
    //   430: invokeinterface 86 1 0
    //   435: ifeq +34 -> 469
    //   438: aload 4
    //   440: invokeinterface 90 1 0
    //   445: checkcast 287	com/tencent/featuretoggle/hltxkg/common/a/j
    //   448: astore 5
    //   450: aload 5
    //   452: ifnull -24 -> 428
    //   455: aload 5
    //   457: getstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   460: getstatic 159	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   463: invokevirtual 290	com/tencent/featuretoggle/hltxkg/common/a/j:a	(ILjava/lang/String;)V
    //   466: goto -38 -> 428
    //   469: aload_3
    //   470: monitorexit
    //   471: goto +101 -> 572
    //   474: astore 4
    //   476: aload_3
    //   477: monitorexit
    //   478: aload 4
    //   480: athrow
    //   481: astore 4
    //   483: goto +93 -> 576
    //   486: astore_3
    //   487: aload_3
    //   488: invokevirtual 293	java/lang/Throwable:printStackTrace	()V
    //   491: iload_0
    //   492: getstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   495: if_icmpeq +77 -> 572
    //   498: getstatic 34	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   501: astore_3
    //   502: aload_3
    //   503: monitorenter
    //   504: getstatic 34	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   507: invokeinterface 282 1 0
    //   512: invokeinterface 285 1 0
    //   517: astore 4
    //   519: aload 4
    //   521: invokeinterface 86 1 0
    //   526: ifeq +34 -> 560
    //   529: aload 4
    //   531: invokeinterface 90 1 0
    //   536: checkcast 287	com/tencent/featuretoggle/hltxkg/common/a/j
    //   539: astore 5
    //   541: aload 5
    //   543: ifnull -24 -> 519
    //   546: aload 5
    //   548: getstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   551: getstatic 159	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   554: invokevirtual 290	com/tencent/featuretoggle/hltxkg/common/a/j:a	(ILjava/lang/String;)V
    //   557: goto -38 -> 519
    //   560: aload_3
    //   561: monitorexit
    //   562: goto +10 -> 572
    //   565: astore 4
    //   567: aload_3
    //   568: monitorexit
    //   569: aload 4
    //   571: athrow
    //   572: ldc 2
    //   574: monitorexit
    //   575: return
    //   576: iload_0
    //   577: getstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   580: if_icmpeq +77 -> 657
    //   583: getstatic 34	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   586: astore_3
    //   587: aload_3
    //   588: monitorenter
    //   589: getstatic 34	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   592: invokeinterface 282 1 0
    //   597: invokeinterface 285 1 0
    //   602: astore 5
    //   604: aload 5
    //   606: invokeinterface 86 1 0
    //   611: ifeq +34 -> 645
    //   614: aload 5
    //   616: invokeinterface 90 1 0
    //   621: checkcast 287	com/tencent/featuretoggle/hltxkg/common/a/j
    //   624: astore 6
    //   626: aload 6
    //   628: ifnull -24 -> 604
    //   631: aload 6
    //   633: getstatic 209	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_a_of_type_Int	I
    //   636: getstatic 159	com/tencent/featuretoggle/hltxkg/common/a/e:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   639: invokevirtual 290	com/tencent/featuretoggle/hltxkg/common/a/j:a	(ILjava/lang/String;)V
    //   642: goto -38 -> 604
    //   645: aload_3
    //   646: monitorexit
    //   647: goto +10 -> 657
    //   650: astore 4
    //   652: aload_3
    //   653: monitorexit
    //   654: aload 4
    //   656: athrow
    //   657: aload 4
    //   659: athrow
    //   660: astore_3
    //   661: ldc 2
    //   663: monitorexit
    //   664: goto +5 -> 669
    //   667: aload_3
    //   668: athrow
    //   669: goto -2 -> 667
    //   672: iload_1
    //   673: bipush 13
    //   675: if_icmpeq -460 -> 215
    //   678: iload_1
    //   679: bipush 19
    //   681: if_icmpne -473 -> 208
    //   684: goto -469 -> 215
    //   687: ldc 12
    //   689: astore_3
    //   690: goto -430 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	575	0	i	int
    //   48	634	1	j	int
    //   235	6	2	bool	boolean
    //   486	2	3	localThrowable	Throwable
    //   660	8	3	localObject2	Object
    //   689	1	3	str	String
    //   93	346	4	localObject3	Object
    //   474	5	4	localObject4	Object
    //   481	1	4	localObject5	Object
    //   517	13	4	localIterator	Iterator
    //   565	5	4	localObject6	Object
    //   650	8	4	localObject7	Object
    //   448	167	5	localObject8	Object
    //   624	8	6	localj	j
    // Exception table:
    //   from	to	target	type
    //   413	428	474	finally
    //   428	450	474	finally
    //   455	466	474	finally
    //   469	471	474	finally
    //   7	22	481	finally
    //   26	49	481	finally
    //   54	123	481	finally
    //   126	132	481	finally
    //   137	148	481	finally
    //   152	190	481	finally
    //   208	212	481	finally
    //   215	219	481	finally
    //   222	226	481	finally
    //   226	240	481	finally
    //   244	256	481	finally
    //   260	264	481	finally
    //   267	279	481	finally
    //   286	298	481	finally
    //   305	317	481	finally
    //   324	342	481	finally
    //   342	346	481	finally
    //   349	367	481	finally
    //   370	400	481	finally
    //   487	491	481	finally
    //   7	22	486	java/lang/Throwable
    //   26	49	486	java/lang/Throwable
    //   54	123	486	java/lang/Throwable
    //   126	132	486	java/lang/Throwable
    //   137	148	486	java/lang/Throwable
    //   152	190	486	java/lang/Throwable
    //   208	212	486	java/lang/Throwable
    //   215	219	486	java/lang/Throwable
    //   222	226	486	java/lang/Throwable
    //   226	240	486	java/lang/Throwable
    //   244	256	486	java/lang/Throwable
    //   260	264	486	java/lang/Throwable
    //   267	279	486	java/lang/Throwable
    //   286	298	486	java/lang/Throwable
    //   305	317	486	java/lang/Throwable
    //   324	342	486	java/lang/Throwable
    //   342	346	486	java/lang/Throwable
    //   349	367	486	java/lang/Throwable
    //   370	400	486	java/lang/Throwable
    //   504	519	565	finally
    //   519	541	565	finally
    //   546	557	565	finally
    //   560	562	565	finally
    //   589	604	650	finally
    //   604	626	650	finally
    //   631	642	650	finally
    //   645	647	650	finally
    //   3	7	660	finally
    //   400	413	660	finally
    //   476	481	660	finally
    //   491	504	660	finally
    //   567	572	660	finally
    //   576	589	660	finally
    //   652	657	660	finally
    //   657	660	660	finally
  }
  
  public static int e()
  {
    return jdField_a_of_type_Int;
  }
  
  public static byte f()
  {
    return jdField_a_of_type_Byte;
  }
  
  public static boolean g()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean h()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public static Integer i()
  {
    d();
    int m = jdField_a_of_type_Int;
    Integer localInteger = Integer.valueOf(3);
    int k = 1;
    int j = 0;
    int i = k;
    if (m != 2)
    {
      i = k;
      if (jdField_a_of_type_Int != 3) {
        if (jdField_a_of_type_Int == 4) {
          i = k;
        } else {
          i = 0;
        }
      }
    }
    if (i != 0)
    {
      Object localObject2 = a.a();
      Object localObject1 = jdField_a_of_type_JavaLangString;
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
      j = ((Integer)localObject1).intValue();
    }
    return Integer.valueOf(j);
  }
  
  public static Proxy j()
  {
    if ((jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(c))) {
      return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c, 80));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.e
 * JD-Core Version:    0.7.0.1
 */