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
import com.tencent.ad.tangram.system.a;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.e;
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
  
  /* Error */
  private static int getDataTypeOnAndroidQ(int paramInt)
  {
    // Byte code:
    //   0: new 113	java/lang/Integer
    //   3: dup
    //   4: iconst_1
    //   5: invokespecial 116	java/lang/Integer:<init>	(I)V
    //   8: astore_3
    //   9: new 113	java/lang/Integer
    //   12: dup
    //   13: iconst_2
    //   14: invokespecial 116	java/lang/Integer:<init>	(I)V
    //   17: astore 6
    //   19: new 113	java/lang/Integer
    //   22: dup
    //   23: iconst_3
    //   24: invokespecial 116	java/lang/Integer:<init>	(I)V
    //   27: astore 7
    //   29: new 113	java/lang/Integer
    //   32: dup
    //   33: iconst_4
    //   34: invokespecial 116	java/lang/Integer:<init>	(I)V
    //   37: astore 8
    //   39: aload 7
    //   41: astore 4
    //   43: aload 6
    //   45: astore_2
    //   46: ldc 118
    //   48: ldc 120
    //   50: invokevirtual 124	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   53: ldc 118
    //   55: invokevirtual 129	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: astore 5
    //   60: aload 7
    //   62: astore 4
    //   64: aload 6
    //   66: astore_2
    //   67: aload 5
    //   69: astore_3
    //   70: ldc 118
    //   72: ldc 131
    //   74: invokevirtual 124	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   77: ldc 118
    //   79: invokevirtual 129	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: astore 6
    //   84: aload 7
    //   86: astore 4
    //   88: aload 6
    //   90: astore_2
    //   91: aload 5
    //   93: astore_3
    //   94: ldc 118
    //   96: ldc 133
    //   98: invokevirtual 124	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   101: ldc 118
    //   103: invokevirtual 129	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: astore 7
    //   108: aload 7
    //   110: astore 4
    //   112: aload 6
    //   114: astore_2
    //   115: aload 5
    //   117: astore_3
    //   118: ldc 118
    //   120: ldc 135
    //   122: invokevirtual 124	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   125: ldc 118
    //   127: invokevirtual 129	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   130: astore 9
    //   132: aload 9
    //   134: astore 8
    //   136: aload 5
    //   138: astore_3
    //   139: aload 6
    //   141: astore_2
    //   142: aload 7
    //   144: astore 4
    //   146: aload 8
    //   148: astore 5
    //   150: ldc 118
    //   152: ldc 137
    //   154: iconst_1
    //   155: anewarray 82	java/lang/Class
    //   158: dup
    //   159: iconst_0
    //   160: getstatic 141	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   163: aastore
    //   164: invokevirtual 145	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   167: ldc 118
    //   169: iconst_1
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: iload_0
    //   176: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: aastore
    //   180: invokevirtual 155	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   183: astore 6
    //   185: aload 6
    //   187: aload_3
    //   188: invokevirtual 159	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   191: istore_1
    //   192: iload_1
    //   193: ifeq +23 -> 216
    //   196: iconst_2
    //   197: ireturn
    //   198: astore 5
    //   200: ldc 16
    //   202: ldc 160
    //   204: aload 5
    //   206: invokestatic 163	com/tencent/ad/tangram/log/AdLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload 8
    //   211: astore 5
    //   213: goto -63 -> 150
    //   216: aload 6
    //   218: aload_2
    //   219: invokevirtual 159	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   222: ifeq +5 -> 227
    //   225: iconst_3
    //   226: ireturn
    //   227: aload 6
    //   229: aload 4
    //   231: invokevirtual 159	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +5 -> 239
    //   237: iconst_4
    //   238: ireturn
    //   239: aload 6
    //   241: aload 5
    //   243: invokevirtual 159	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   246: istore_1
    //   247: iload_1
    //   248: ifeq +6 -> 254
    //   251: bipush 7
    //   253: ireturn
    //   254: iconst_0
    //   255: ireturn
    //   256: astore_2
    //   257: ldc 16
    //   259: ldc 160
    //   261: aload_2
    //   262: invokestatic 163	com/tencent/ad/tangram/log/AdLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   265: iconst_0
    //   266: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramInt	int
    //   191	57	1	bool	boolean
    //   45	174	2	localObject1	Object
    //   256	6	2	localThrowable1	Throwable
    //   8	180	3	localObject2	Object
    //   41	189	4	localObject3	Object
    //   58	91	5	localObject4	Object
    //   198	7	5	localThrowable2	Throwable
    //   211	31	5	localObject5	Object
    //   17	223	6	localObject6	Object
    //   27	116	7	localObject7	Object
    //   37	173	8	localObject8	Object
    //   130	3	9	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   46	60	198	java/lang/Throwable
    //   70	84	198	java/lang/Throwable
    //   94	108	198	java/lang/Throwable
    //   118	132	198	java/lang/Throwable
    //   150	192	256	java/lang/Throwable
    //   216	225	256	java/lang/Throwable
    //   227	237	256	java/lang/Throwable
    //   239	247	256	java/lang/Throwable
  }
  
  private static int getDataTypeOnAndroidR(int paramInt)
  {
    long l = a.getBitMaskForNetworkType(paramInt);
    if ((0x804B & l) != 0L) {
      return 2;
    }
    if ((0x16BB4 & l) != 0L) {
      return 3;
    }
    if ((0x61000 & l) != 0L) {
      return 4;
    }
    if ((l & 0x80000) != 0L) {
      return 7;
    }
    return 0;
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
  
  public static int getType(Context paramContext)
  {
    int j = getTypeInternal(paramContext);
    int i = j;
    if (j == 7) {
      i = 0;
    }
    return i;
  }
  
  private static int getTypeInternal(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {
      return 0;
    }
    try
    {
      Object localObject = (ConnectivityManager)ConnectivityManager.class.cast(localContext.getSystemService("connectivity"));
      if (localObject == null) {
        return 0;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        return 0;
      }
      switch (((NetworkInfo)localObject).getType())
      {
      case 0: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
        if (Build.VERSION.SDK_INT <= 29) {
          return getDataTypeOnAndroidQ(((NetworkInfo)localObject).getSubtype());
        }
        if (!e.checkPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
          return 0;
        }
        paramContext = (TelephonyManager)TelephonyManager.class.cast(localContext.getSystemService("phone"));
        if (paramContext == null) {
          return 0;
        }
        int i = getDataTypeOnAndroidR(paramContext.getNetworkType());
        return i;
      }
    }
    catch (Throwable paramContext)
    {
      AdLog.e("AdNet", "getTypeInternal", paramContext);
      return 0;
    }
    return 0;
    return 1;
  }
  
  public static int getTypeWith5G(Context paramContext)
  {
    return getType(paramContext);
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