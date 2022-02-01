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
  private static final HashMap<String, Proxy> sAPNProxies = new HashMap();
  
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
    //   0: aload_0
    //   1: invokestatic 77	com/tencent/component/network/utils/NetworkUtils:getActiveNetworkInfo	(Landroid/content/Context;)Landroid/net/NetworkInfo;
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore_1
    //   15: aconst_null
    //   16: astore 5
    //   18: aload 6
    //   20: ifnonnull +5 -> 25
    //   23: aconst_null
    //   24: areturn
    //   25: aload 6
    //   27: invokevirtual 83	android/net/NetworkInfo:getType	()I
    //   30: iconst_1
    //   31: if_icmpne +9 -> 40
    //   34: ldc 8
    //   36: astore_1
    //   37: goto +161 -> 198
    //   40: aload 6
    //   42: invokevirtual 83	android/net/NetworkInfo:getType	()I
    //   45: ifne +153 -> 198
    //   48: invokestatic 88	com/tencent/component/network/utils/PlatformUtil:version	()I
    //   51: bipush 17
    //   53: if_icmpge +130 -> 183
    //   56: aload_3
    //   57: astore_1
    //   58: aload_0
    //   59: invokevirtual 94	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   62: getstatic 28	com/tencent/component/network/utils/NetworkUtils:PREFERRED_APN_URI	Landroid/net/Uri;
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: aconst_null
    //   69: invokevirtual 100	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore_3
    //   73: aload 5
    //   75: astore_0
    //   76: aload_3
    //   77: ifnull +48 -> 125
    //   80: aload_3
    //   81: invokeinterface 106 1 0
    //   86: ifeq +39 -> 125
    //   89: aload_3
    //   90: aload_3
    //   91: ldc 108
    //   93: invokeinterface 112 2 0
    //   98: invokeinterface 116 2 0
    //   103: astore_1
    //   104: aload_1
    //   105: astore_0
    //   106: goto -30 -> 76
    //   109: astore_0
    //   110: aload_3
    //   111: astore_1
    //   112: goto +59 -> 171
    //   115: astore_1
    //   116: aload_0
    //   117: astore_2
    //   118: aload_3
    //   119: astore_0
    //   120: aload_1
    //   121: astore_3
    //   122: goto +30 -> 152
    //   125: aload_0
    //   126: astore_2
    //   127: aload_3
    //   128: ifnull +55 -> 183
    //   131: aload_3
    //   132: invokeinterface 119 1 0
    //   137: aload_0
    //   138: astore_2
    //   139: goto +44 -> 183
    //   142: astore_0
    //   143: goto +28 -> 171
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_2
    //   149: aload 4
    //   151: astore_0
    //   152: aload_0
    //   153: astore_1
    //   154: aload_3
    //   155: invokevirtual 122	java/lang/Throwable:printStackTrace	()V
    //   158: aload_0
    //   159: ifnull +9 -> 168
    //   162: aload_0
    //   163: invokeinterface 119 1 0
    //   168: goto +15 -> 183
    //   171: aload_1
    //   172: ifnull +9 -> 181
    //   175: aload_1
    //   176: invokeinterface 119 1 0
    //   181: aload_0
    //   182: athrow
    //   183: aload_2
    //   184: astore_1
    //   185: aload_2
    //   186: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifeq +9 -> 198
    //   192: aload 6
    //   194: invokevirtual 132	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   197: astore_1
    //   198: aload_1
    //   199: astore_0
    //   200: aload_1
    //   201: ifnull +8 -> 209
    //   204: aload_1
    //   205: invokevirtual 137	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   208: astore_0
    //   209: aload_0
    //   210: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramContext	Context
    //   14	98	1	localObject1	Object
    //   115	6	1	localThrowable1	Throwable
    //   153	52	1	localObject2	Object
    //   12	174	2	localContext	Context
    //   7	125	3	localObject3	Object
    //   146	9	3	localThrowable2	Throwable
    //   9	141	4	localObject4	Object
    //   16	58	5	localObject5	Object
    //   4	189	6	localNetworkInfo	NetworkInfo
    // Exception table:
    //   from	to	target	type
    //   80	104	109	finally
    //   80	104	115	java/lang/Throwable
    //   58	73	142	finally
    //   154	158	142	finally
    //   58	73	146	java/lang/Throwable
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
      QDLog.e("NetworkUtil", "fail to get active network info", paramContext);
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
        localDNS.primary = int32ToIPStr(paramContext.dns1);
        localDNS.secondary = int32ToIPStr(paramContext.dns2);
      }
    }
    if ((localDNS.primary == null) && (localDNS.secondary == null))
    {
      localDNS.primary = PropertyUtil.get("net.dns1", null);
      localDNS.secondary = PropertyUtil.get("net.dns2", null);
    }
    return localDNS;
  }
  
  public static Proxy getProxy(Context paramContext)
  {
    if (!isMobileConnected(paramContext)) {
      return null;
    }
    String str = getProxyHost(paramContext);
    int i = getProxyPort(paramContext);
    if ((!isEmpty(str)) && (i >= 0))
    {
      paramContext = new InetSocketAddress(str, i);
      return new Proxy(Proxy.Type.HTTP, paramContext);
    }
    return null;
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
    int i;
    if (!isEmpty(paramContext)) {
      try
      {
        i = Integer.parseInt(paramContext);
      }
      catch (NumberFormatException paramContext)
      {
        paramContext.printStackTrace();
      }
    } else {
      i = -1;
    }
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
  
  private static String int32ToIPStr(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF);
    localStringBuffer.append(".");
    localStringBuffer.append(paramInt >> 8 & 0xFF);
    localStringBuffer.append(".");
    localStringBuffer.append(paramInt >> 16 & 0xFF);
    localStringBuffer.append(".");
    localStringBuffer.append(paramInt >> 24 & 0xFF);
    return localStringBuffer.toString();
  }
  
  private static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isMobileConnected(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = getActiveNetworkInfo(paramContext);
    boolean bool1 = bool2;
    if (paramContext != null) {
      if (paramContext.getType() != 0)
      {
        bool1 = bool2;
        if (paramContext.getType() + 50 != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      if (URLUtil.isFileUrl(paramString)) {
        return false;
      }
      return URLUtil.isNetworkUrl(paramString);
    }
    return true;
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = getActiveNetworkInfo(paramContext);
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.getType() == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */