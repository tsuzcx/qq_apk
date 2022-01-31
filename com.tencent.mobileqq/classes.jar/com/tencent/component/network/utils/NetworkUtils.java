package com.tencent.component.network.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.component.network.module.base.QDLog;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.HashMap;

public class NetworkUtils
{
  public static final String APN_NAME_WIFI = "wifi";
  private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
  private static final String TAG = "NetworkUtil";
  private static final HashMap sAPNProxies = new HashMap();
  
  static
  {
    sAPNProxies.put("cmwap", new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
    sAPNProxies.put("3gwap", new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
    sAPNProxies.put("uniwap", new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
    sAPNProxies.put("ctwap", new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
  }
  
  /* Error */
  public static String getAPN(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 76	com/tencent/component/network/utils/NetworkUtils:getActiveNetworkInfo	(Landroid/content/Context;)Landroid/net/NetworkInfo;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload 4
    //   17: invokevirtual 82	android/net/NetworkInfo:getType	()I
    //   20: iconst_1
    //   21: if_icmpne +19 -> 40
    //   24: ldc 8
    //   26: astore_0
    //   27: aload_0
    //   28: astore_1
    //   29: aload_0
    //   30: ifnull +8 -> 38
    //   33: aload_0
    //   34: invokevirtual 88	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   37: astore_1
    //   38: aload_1
    //   39: areturn
    //   40: aload 4
    //   42: invokevirtual 82	android/net/NetworkInfo:getType	()I
    //   45: ifne +165 -> 210
    //   48: invokestatic 93	com/tencent/component/network/utils/PlatformUtil:a	()I
    //   51: bipush 17
    //   53: if_icmpge +152 -> 205
    //   56: aload_0
    //   57: invokevirtual 99	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   60: getstatic 27	com/tencent/component/network/utils/NetworkUtils:PREFERRED_APN_URI	Landroid/net/Uri;
    //   63: aconst_null
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: invokevirtual 105	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore_0
    //   71: aload_0
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_2
    //   76: ifnull +90 -> 166
    //   79: aload_2
    //   80: invokeinterface 111 1 0
    //   85: ifeq +81 -> 166
    //   88: aload_2
    //   89: aload_2
    //   90: ldc 113
    //   92: invokeinterface 117 2 0
    //   97: invokeinterface 121 2 0
    //   102: astore_1
    //   103: aload_1
    //   104: astore_0
    //   105: goto -30 -> 75
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_3
    //   111: aload_2
    //   112: astore_0
    //   113: aload_3
    //   114: astore_2
    //   115: aload_1
    //   116: invokevirtual 124	java/lang/Throwable:printStackTrace	()V
    //   119: aload_2
    //   120: astore_1
    //   121: aload_0
    //   122: ifnull +11 -> 133
    //   125: aload_0
    //   126: invokeinterface 127 1 0
    //   131: aload_2
    //   132: astore_1
    //   133: aload_1
    //   134: astore_0
    //   135: aload_1
    //   136: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifeq -112 -> 27
    //   142: aload 4
    //   144: invokevirtual 136	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   147: astore_0
    //   148: goto -121 -> 27
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_2
    //   154: aload_2
    //   155: ifnull +9 -> 164
    //   158: aload_2
    //   159: invokeinterface 127 1 0
    //   164: aload_0
    //   165: athrow
    //   166: aload_0
    //   167: astore_1
    //   168: aload_2
    //   169: ifnull -36 -> 133
    //   172: aload_2
    //   173: invokeinterface 127 1 0
    //   178: aload_0
    //   179: astore_1
    //   180: goto -47 -> 133
    //   183: astore_0
    //   184: goto -30 -> 154
    //   187: astore_1
    //   188: aload_0
    //   189: astore_2
    //   190: aload_1
    //   191: astore_0
    //   192: goto -38 -> 154
    //   195: astore_1
    //   196: aload_2
    //   197: astore_3
    //   198: aload_0
    //   199: astore_2
    //   200: aload_3
    //   201: astore_0
    //   202: goto -87 -> 115
    //   205: aconst_null
    //   206: astore_1
    //   207: goto -74 -> 133
    //   210: aconst_null
    //   211: astore_0
    //   212: goto -185 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramContext	Context
    //   28	76	1	localObject1	Object
    //   108	8	1	localThrowable1	Throwable
    //   120	60	1	localObject2	Object
    //   187	4	1	localObject3	Object
    //   195	1	1	localThrowable2	Throwable
    //   206	1	1	localObject4	Object
    //   1	199	2	localObject5	Object
    //   110	91	3	localObject6	Object
    //   6	137	4	localNetworkInfo	NetworkInfo
    // Exception table:
    //   from	to	target	type
    //   56	71	108	java/lang/Throwable
    //   56	71	151	finally
    //   79	103	183	finally
    //   115	119	187	finally
    //   79	103	195	java/lang/Throwable
  }
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QDLog.d("NetworkUtil", "fail to get active network info", paramContext);
    }
    return null;
  }
  
  public static NetworkUtils.DNS getDNS(Context paramContext)
  {
    NetworkUtils.DNS localDNS = new NetworkUtils.DNS();
    if ((paramContext != null) && (isWifiConnected(paramContext)))
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getDhcpInfo();
      if (paramContext != null)
      {
        localDNS.a = int32ToIPStr(paramContext.dns1);
        localDNS.b = int32ToIPStr(paramContext.dns2);
      }
    }
    if ((localDNS.a == null) && (localDNS.b == null))
    {
      localDNS.a = PropertyUtil.a("net.dns1", null);
      localDNS.b = PropertyUtil.a("net.dns2", null);
    }
    return localDNS;
  }
  
  public static Proxy getProxy(Context paramContext)
  {
    if (!isMobileConnected(paramContext)) {}
    String str;
    int i;
    do
    {
      return null;
      str = getProxyHost(paramContext);
      i = getProxyPort(paramContext);
    } while ((isEmpty(str)) || (i < 0));
    paramContext = new InetSocketAddress(str, i);
    return new Proxy(Proxy.Type.HTTP, paramContext);
  }
  
  public static Proxy getProxy(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return getProxy(paramContext);
    }
    return getProxyByAPN(paramContext);
  }
  
  public static Proxy getProxyByAPN(Context paramContext)
  {
    if (!isMobileConnected(paramContext)) {
      return null;
    }
    paramContext = getAPN(paramContext);
    Proxy localProxy = (Proxy)sAPNProxies.get(paramContext);
    paramContext = localProxy;
    if (localProxy == null) {
      paramContext = null;
    }
    return paramContext;
  }
  
  private static String getProxyHost(Context paramContext)
  {
    return System.getProperty("http.proxyHost");
  }
  
  private static int getProxyPort(Context paramContext)
  {
    paramContext = System.getProperty("http.proxyPort");
    if (!isEmpty(paramContext)) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramContext);
        int j;
        if (i >= 0)
        {
          j = i;
          if (i <= 65535) {}
        }
        else
        {
          j = -1;
        }
        return j;
      }
      catch (NumberFormatException paramContext)
      {
        paramContext.printStackTrace();
      }
      int i = -1;
    }
  }
  
  private static String int32ToIPStr(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF).append(".");
    localStringBuffer.append(paramInt >> 8 & 0xFF).append(".");
    localStringBuffer.append(paramInt >> 16 & 0xFF).append(".");
    localStringBuffer.append(paramInt >> 24 & 0xFF);
    return localStringBuffer.toString();
  }
  
  private static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isMobileConnected(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = getActiveNetworkInfo(paramContext);
    } while ((paramContext == null) || ((paramContext.getType() != 0) && (paramContext.getType() + 50 != 0)));
    return true;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
        return true;
      }
    } while (URLUtil.isFileUrl(paramString));
    return URLUtil.isNetworkUrl(paramString);
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    paramContext = getActiveNetworkInfo(paramContext);
    if ((paramContext != null) && (paramContext.getType() == 1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */