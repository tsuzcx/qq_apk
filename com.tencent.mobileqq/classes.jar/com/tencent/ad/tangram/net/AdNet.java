package com.tencent.ad.tangram.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.e;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;

@Keep
public final class AdNet
{
  public static final int IP_FAMILY_UNKNOWN = 0;
  public static final int IP_FAMILY_V4 = 1;
  public static final int IP_FAMILY_V6 = 2;
  private static final String TAG = "AdNet";
  private static String ipV4Address;
  private static long ipV4AddressTimeStamp = -2147483648L;
  private static String userAgent;
  
  public static String getBSSID(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (e.checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE")) {}
    }
    label87:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return null;
            if (Build.VERSION.SDK_INT > 26) {
              break label87;
            }
            if (paramContext != null)
            {
              paramContext = paramContext.getApplicationContext();
              if (paramContext != null)
              {
                paramContext = paramContext.getSystemService("wifi");
                if ((paramContext instanceof WifiManager))
                {
                  paramContext = (WifiManager)WifiManager.class.cast(paramContext);
                  if (paramContext == null) {}
                }
              }
            }
            try
            {
              paramContext = paramContext.getConnectionInfo();
              if (paramContext != null) {
                paramContext = paramContext.getBSSID();
              }
            }
            catch (Throwable paramContext)
            {
              for (;;)
              {
                AdLog.e("AdNet", "getBSSID", paramContext);
                paramContext = null;
              }
            }
          }
        } while (!isValidBSSID(paramContext));
        return paramContext;
        if ((Build.VERSION.SDK_INT != 27) && (Build.VERSION.SDK_INT != 28)) {
          break;
        }
      } while ((e.checkPermission(paramContext, "android.permission.ACCESS_COARSE_LOCATION")) || (e.checkPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION")));
      return null;
    } while (e.checkPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION"));
    return null;
  }
  
  public static int getIpFamily(Context paramContext)
  {
    int i = getIpFamilyImpl(paramContext);
    AdLog.i("AdNet", String.format("getIpFamily %d", new Object[] { Integer.valueOf(i) }));
    return i;
  }
  
  private static int getIpFamilyImpl(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    paramContext = paramContext.getApplicationContext();
    if (paramContext == null) {
      return 0;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return 0;
      }
      if (Build.VERSION.SDK_INT < 23) {
        return 0;
      }
      paramContext = paramContext.getLinkProperties(paramContext.getActiveNetwork());
      if (paramContext == null) {
        return 0;
      }
      paramContext = paramContext.getLinkAddresses().iterator();
      int i = 0;
      while (paramContext.hasNext())
      {
        LinkAddress localLinkAddress = (LinkAddress)paramContext.next();
        if (localLinkAddress != null)
        {
          int j = getNetIpFamily(localLinkAddress.getAddress());
          i |= j;
        }
      }
      return i;
    }
    catch (Throwable paramContext)
    {
      AdLog.i("AdNet", "getIpFamily", paramContext);
    }
    return 0;
  }
  
  private static String getIpV4Address()
  {
    Object localObject = new AdHttp.Params();
    ((AdHttp.Params)localObject).setUrl("https://ipv4.gdt.qq.com/get_client_ip");
    ((AdHttp.Params)localObject).method = "GET";
    AdHttp.send((AdHttp.Params)localObject);
    AdLog.i("AdNet", String.format("getIpV4Address responseCode:%d", new Object[] { Integer.valueOf(((AdHttp.Params)localObject).responseCode) }));
    if ((!((AdHttp.Params)localObject).canSend()) || (((AdHttp.Params)localObject).responseCode != 200)) {
      return null;
    }
    try
    {
      localObject = new String(((AdHttp.Params)localObject).responseData, "UTF-8");
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdNet", "getIpV4Address", localThrowable);
    }
    return null;
  }
  
  public static String getIpV4AddressCache()
  {
    AdLog.i("AdNet", String.format("getIpV4AddressCache address:%s timeStamp:%d", new Object[] { ipV4Address, Long.valueOf(ipV4AddressTimeStamp) }));
    return ipV4Address;
  }
  
  private static int getNetIpFamily(InetAddress paramInetAddress)
  {
    if (paramInetAddress == null) {}
    do
    {
      do
      {
        return 0;
      } while ((paramInetAddress.isLoopbackAddress()) || (paramInetAddress.isLinkLocalAddress()) || (paramInetAddress.isAnyLocalAddress()));
      if ((paramInetAddress instanceof Inet6Address)) {
        return 2;
      }
    } while (!(paramInetAddress instanceof Inet4Address));
    return 1;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      AdLog.e("AdNet", "getNetworkType error");
      return -2147483648;
      paramContext = paramContext.getApplicationContext();
      if (paramContext != null) {
        try
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            int i = paramContext.getNetworkType();
            return i;
          }
        }
        catch (Throwable paramContext)
        {
          AdLog.e("AdNet", "getNetworkType", paramContext);
        }
      }
    }
  }
  
  /* Error */
  public static int getType(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: invokevirtual 72	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   10: astore 7
    //   12: aload 7
    //   14: ifnonnull +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: new 118	java/lang/Integer
    //   22: dup
    //   23: iconst_1
    //   24: invokespecial 258	java/lang/Integer:<init>	(I)V
    //   27: astore_2
    //   28: new 118	java/lang/Integer
    //   31: dup
    //   32: iconst_2
    //   33: invokespecial 258	java/lang/Integer:<init>	(I)V
    //   36: astore 4
    //   38: new 118	java/lang/Integer
    //   41: dup
    //   42: iconst_3
    //   43: invokespecial 258	java/lang/Integer:<init>	(I)V
    //   46: astore 5
    //   48: aload 4
    //   50: astore_0
    //   51: ldc 250
    //   53: ldc_w 260
    //   56: invokevirtual 264	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   59: ldc 250
    //   61: invokevirtual 269	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: astore_3
    //   65: aload 4
    //   67: astore_0
    //   68: aload_3
    //   69: astore_2
    //   70: ldc 250
    //   72: ldc_w 271
    //   75: invokevirtual 264	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   78: ldc 250
    //   80: invokevirtual 269	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: astore 4
    //   85: aload 4
    //   87: astore_0
    //   88: aload_3
    //   89: astore_2
    //   90: ldc 250
    //   92: ldc_w 273
    //   95: invokevirtual 264	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   98: ldc 250
    //   100: invokevirtual 269	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: astore 6
    //   105: aload 4
    //   107: astore_2
    //   108: aload 6
    //   110: astore_0
    //   111: aload 7
    //   113: ldc 134
    //   115: invokevirtual 78	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   118: checkcast 136	android/net/ConnectivityManager
    //   121: astore 4
    //   123: aload 4
    //   125: ifnonnull +25 -> 150
    //   128: iconst_0
    //   129: ireturn
    //   130: astore_3
    //   131: ldc 16
    //   133: ldc_w 274
    //   136: aload_3
    //   137: invokestatic 179	com/tencent/ad/tangram/log/AdLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_2
    //   141: astore_3
    //   142: aload_0
    //   143: astore_2
    //   144: aload 5
    //   146: astore_0
    //   147: goto -36 -> 111
    //   150: aload 4
    //   152: invokevirtual 278	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   155: astore 4
    //   157: aload 4
    //   159: ifnonnull +5 -> 164
    //   162: iconst_0
    //   163: ireturn
    //   164: aload 4
    //   166: invokevirtual 282	android/net/NetworkInfo:getType	()I
    //   169: tableswitch	default:+132 -> 301, 0:+43->212, 1:+134->303, 2:+43->212, 3:+43->212, 4:+43->212, 5:+43->212, 6:+134->303
    //   213: <illegal opcode>
    //   214: ldc_w 284
    //   217: iconst_1
    //   218: anewarray 82	java/lang/Class
    //   221: dup
    //   222: iconst_0
    //   223: getstatic 288	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   226: aastore
    //   227: invokevirtual 292	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   230: ldc 250
    //   232: iconst_1
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: aload 4
    //   240: invokevirtual 295	android/net/NetworkInfo:getSubtype	()I
    //   243: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: aastore
    //   247: invokevirtual 301	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   250: astore 4
    //   252: aload 4
    //   254: aload_3
    //   255: invokevirtual 305	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   258: ifeq +5 -> 263
    //   261: iconst_2
    //   262: ireturn
    //   263: aload 4
    //   265: aload_2
    //   266: invokevirtual 305	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   269: ifeq +5 -> 274
    //   272: iconst_3
    //   273: ireturn
    //   274: aload 4
    //   276: aload_0
    //   277: invokevirtual 305	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   280: istore_1
    //   281: iload_1
    //   282: ifeq +5 -> 287
    //   285: iconst_4
    //   286: ireturn
    //   287: iconst_0
    //   288: ireturn
    //   289: astore_0
    //   290: ldc 16
    //   292: ldc_w 274
    //   295: aload_0
    //   296: invokestatic 109	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   299: iconst_0
    //   300: ireturn
    //   301: iconst_0
    //   302: ireturn
    //   303: iconst_1
    //   304: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	paramContext	Context
    //   280	2	1	bool	boolean
    //   27	239	2	localObject1	Object
    //   64	25	3	localObject2	Object
    //   130	7	3	localThrowable	Throwable
    //   141	114	3	localObject3	Object
    //   36	239	4	localObject4	Object
    //   46	99	5	localInteger	Integer
    //   103	6	6	localObject5	Object
    //   10	102	7	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   51	65	130	java/lang/Throwable
    //   70	85	130	java/lang/Throwable
    //   90	105	130	java/lang/Throwable
    //   111	123	289	java/lang/Throwable
    //   150	157	289	java/lang/Throwable
    //   164	212	289	java/lang/Throwable
    //   212	261	289	java/lang/Throwable
    //   263	272	289	java/lang/Throwable
    //   274	281	289	java/lang/Throwable
  }
  
  public static int getTypeWith5G(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {
      return 0;
    }
    Object localObject2 = new Integer(1);
    Object localObject3 = new Integer(2);
    Object localObject6 = new Integer(3);
    Integer localInteger = new Integer(4);
    Object localObject1 = localObject6;
    paramContext = (Context)localObject3;
    for (;;)
    {
      try
      {
        localObject5 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_2_G").get(TelephonyManager.class);
        localObject1 = localObject6;
        paramContext = (Context)localObject3;
        localObject2 = localObject5;
        localObject3 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_3_G").get(TelephonyManager.class);
        localObject1 = localObject6;
        paramContext = (Context)localObject3;
        localObject2 = localObject5;
        localObject6 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_4_G").get(TelephonyManager.class);
        localObject1 = localObject6;
        paramContext = (Context)localObject3;
        localObject2 = localObject5;
        Object localObject7 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_5_G").get(TelephonyManager.class);
        localObject1 = localObject6;
        paramContext = localObject7;
        localObject2 = localObject3;
        localObject3 = localObject5;
      }
      catch (Throwable localThrowable)
      {
        Object localObject4 = localObject2;
        Object localObject5 = localInteger;
        localObject2 = paramContext;
        paramContext = (Context)localObject5;
        continue;
        return 0;
      }
      try
      {
        localObject5 = (ConnectivityManager)localContext.getSystemService("connectivity");
        if (localObject5 == null) {
          return 0;
        }
        localObject5 = ((ConnectivityManager)localObject5).getActiveNetworkInfo();
        if (localObject5 == null) {
          return 0;
        }
        switch (((NetworkInfo)localObject5).getType())
        {
        case 0: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
          localObject5 = TelephonyManager.class.getDeclaredMethod("getNetworkClass", new Class[] { Integer.TYPE }).invoke(TelephonyManager.class, new Object[] { Integer.valueOf(((NetworkInfo)localObject5).getSubtype()) });
          if (localObject5.equals(localObject3)) {
            return 2;
          }
          if (localObject5.equals(localObject2)) {
            return 3;
          }
          if (localObject5.equals(localObject1)) {
            return 4;
          }
          boolean bool = localObject5.equals(paramContext);
          if (bool) {
            return 7;
          }
          return 0;
        }
      }
      catch (Throwable paramContext)
      {
        AdLog.e("AdNet", "getType", paramContext);
        return 0;
      }
    }
    return 1;
  }
  
  public static String getUserAgent()
  {
    if (!TextUtils.isEmpty(userAgent)) {
      return userAgent;
    }
    userAgent = System.getProperty("http.agent");
    return userAgent;
  }
  
  public static String getUserAgentCache()
  {
    return userAgent;
  }
  
  public static boolean isNetValid(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable());
  }
  
  private static boolean isValidBSSID(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramString, "00:00:00:00:00:00")) && (!TextUtils.equals(paramString, "02:00:00:00:00:00"));
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    return getType(paramContext) == 1;
  }
  
  private static void updateIpV4Address(long paramLong)
  {
    AdLog.i("AdNet", String.format("updateIpV4Address delayMillis:%d", new Object[] { Long.valueOf(paramLong) }));
    AdThreadManager.INSTANCE.postDelayed(new AdNet.1(), 4, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdNet
 * JD-Core Version:    0.7.0.1
 */