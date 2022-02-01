package com.tencent.luggage.wxa.nz;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.IpPrefix;
import android.net.LinkProperties;
import android.net.Network;
import android.net.RouteInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.luggage.wxa.gl.g;
import com.tencent.luggage.wxa.ix.b;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mars.cdn.CronetLogic.WebPageProfile;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.util.InetAddressUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum j
{
  @RequiresApi(api=21)
  private static int a()
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)r.a().getSystemService("connectivity");
      Network[] arrayOfNetwork = localConnectivityManager.getAllNetworks();
      int j = arrayOfNetwork.length;
      int i = 0;
      while (i < j)
      {
        Iterator localIterator = localConnectivityManager.getLinkProperties(arrayOfNetwork[i]).getRoutes().iterator();
        while (localIterator.hasNext())
        {
          RouteInfo localRouteInfo = (RouteInfo)localIterator.next();
          String str = localRouteInfo.getDestination().getAddress().getHostAddress().toUpperCase();
          if (InetAddressUtils.isIPv4Address(str))
          {
            i = localRouteInfo.getDestination().getPrefixLength();
            j = a(i);
            o.d("MicroMsg.AppBrandNetworkUtil", "findNetworkMask sAddr:%s,getPrefixLength:%d,netmask:%d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
            return j;
          }
        }
        i += 1;
      }
      return 0;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.AppBrandNetworkUtil", localException, "Exception: findNetworkMask error ", new Object[0]);
    }
    return 0;
  }
  
  public static int a(int paramInt)
  {
    int[] arrayOfInt = new int[4];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[(arrayOfInt.length - 1 - i)] = (-1 << 32 - paramInt >> i * 8 & 0xFF);
      i += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(arrayOfInt[0]);
    localObject = ((StringBuilder)localObject).toString();
    paramInt = 1;
    while (paramInt < arrayOfInt.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(".");
      localStringBuilder.append(arrayOfInt[paramInt]);
      localObject = localStringBuilder.toString();
      paramInt += 1;
    }
    o.d("MicroMsg.AppBrandNetworkUtil", "calcMaskByPrefixLength result:%s", new Object[] { localObject });
    localObject = ((String)localObject).split("\\.");
    return g.a(new byte[] { (byte)(af.a(localObject[0], 0) & 0xFF), (byte)(af.a(localObject[1], 0) & 0xFF), (byte)(af.a(localObject[2], 0) & 0xFF), (byte)(af.a(localObject[3], 0) & 0xFF) });
  }
  
  public static int a(long paramLong)
  {
    return a(paramLong, -1);
  }
  
  public static int a(long paramLong, int paramInt)
  {
    if (paramLong <= 0L) {
      return 8192;
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = 3;
    }
    paramInt = (int)(paramLong / i);
    if ((paramInt <= 524288) && (paramInt >= 1024)) {
      return paramInt;
    }
    if (paramInt < 1024) {
      return 1024;
    }
    return 524288;
  }
  
  private static int a(long paramLong, int paramInt1, int paramInt2)
  {
    int m = g.a(new byte[] { -1, -1, -1, 0 });
    long[] arrayOfLong = b(paramLong);
    int j = 0;
    int i = 0;
    for (;;)
    {
      k = i;
      if (j >= arrayOfLong.length) {
        break label101;
      }
      i = (int)(i + arrayOfLong[j]);
      if ((arrayOfLong[j] < 0L) || (arrayOfLong[j] > 255L)) {
        break;
      }
      j += 1;
    }
    int k = -1;
    label101:
    if (k <= 0) {
      paramLong = m;
    }
    o.d("MicroMsg.AppBrandNetworkUtil", "matchNetMask oldIpInt:%d, localIpInt:%d, netmask:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    if ((paramInt1 & paramLong) == (paramLong & paramInt2))
    {
      if (paramInt1 == paramInt2) {
        return 1;
      }
      return 2;
    }
    return 0;
  }
  
  public static int a(a parama, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return 0;
          }
          return parama.f;
        }
        return parama.e;
      }
      return parama.d;
    }
    return parama.c;
  }
  
  public static String a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection == null) {
      return "";
    }
    URL localURL = paramHttpURLConnection.getURL();
    if (localURL == null) {
      return "";
    }
    String str2 = paramHttpURLConnection.getHeaderField("Location");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramHttpURLConnection.getHeaderField("location");
    }
    if (str1 == null) {
      return null;
    }
    try
    {
      paramHttpURLConnection = localURL.toURI().resolve(str1).toString();
      return paramHttpURLConnection;
    }
    catch (URISyntaxException paramHttpURLConnection)
    {
      o.a("MicroMsg.AppBrandNetworkUtil", paramHttpURLConnection, "URISyntaxException: resolve url error", new Object[0]);
    }
    return str1;
  }
  
  public static String a(URI paramURI)
  {
    if (paramURI == null) {
      return null;
    }
    Object localObject2 = paramURI.getScheme();
    if (af.c((String)localObject2)) {
      return null;
    }
    Object localObject1;
    if (((String)localObject2).equalsIgnoreCase("wss"))
    {
      localObject1 = "https";
    }
    else
    {
      localObject1 = localObject2;
      if (((String)localObject2).equalsIgnoreCase("ws")) {
        localObject1 = "http";
      }
    }
    localObject2 = new StringBuilder((String)localObject1);
    ((StringBuilder)localObject2).append("://");
    ((StringBuilder)localObject2).append(paramURI.getHost());
    int i = paramURI.getPort();
    if ((i != -1) && ((!((String)localObject1).equalsIgnoreCase("http")) || (i != 80)) && ((!((String)localObject1).equalsIgnoreCase("https")) || (i != 443))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(paramURI.getPort());
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  /* Error */
  public static HashMap<String, String> a(String paramString)
  {
    // Byte code:
    //   0: ldc 129
    //   2: astore_3
    //   3: aload_0
    //   4: invokestatic 264	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 265	android/net/Uri:getHost	()Ljava/lang/String;
    //   12: astore_1
    //   13: aload_2
    //   14: invokevirtual 266	android/net/Uri:getScheme	()Ljava/lang/String;
    //   17: astore_0
    //   18: aload_2
    //   19: invokevirtual 267	android/net/Uri:getPort	()I
    //   22: invokestatic 270	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   25: astore_2
    //   26: goto +35 -> 61
    //   29: astore_2
    //   30: goto +16 -> 46
    //   33: astore_2
    //   34: ldc 129
    //   36: astore_0
    //   37: goto +9 -> 46
    //   40: astore_2
    //   41: ldc 129
    //   43: astore_1
    //   44: aload_1
    //   45: astore_0
    //   46: ldc 100
    //   48: aload_2
    //   49: ldc_w 272
    //   52: iconst_0
    //   53: anewarray 104	java/lang/Object
    //   56: invokestatic 121	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_3
    //   60: astore_2
    //   61: new 274	java/util/HashMap
    //   64: dup
    //   65: invokespecial 275	java/util/HashMap:<init>	()V
    //   68: astore_3
    //   69: aload_3
    //   70: ldc_w 277
    //   73: aload_1
    //   74: invokevirtual 281	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: aload_3
    //   79: ldc_w 283
    //   82: aload_0
    //   83: invokevirtual 281	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: aload_3
    //   88: ldc_w 285
    //   91: aload_2
    //   92: invokevirtual 281	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: aload_3
    //   97: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramString	String
    //   12	62	1	str	String
    //   7	19	2	localObject1	Object
    //   29	1	2	localException1	Exception
    //   33	1	2	localException2	Exception
    //   40	9	2	localException3	Exception
    //   60	32	2	localObject2	Object
    //   2	95	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	26	29	java/lang/Exception
    //   13	18	33	java/lang/Exception
    //   3	13	40	java/lang/Exception
  }
  
  public static Map<String, Object> a(CronetLogic.WebPageProfile paramWebPageProfile)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      if (paramWebPageProfile != null)
      {
        localHashMap.put("redirectStart", Long.valueOf(paramWebPageProfile.redirectStart));
        localHashMap.put("redirectEnd", Long.valueOf(paramWebPageProfile.redirectEnd));
        localHashMap.put("fetchStart", Long.valueOf(paramWebPageProfile.fetchStart));
        localHashMap.put("domainLookUpStart", Long.valueOf(paramWebPageProfile.domainLookUpStart));
        localHashMap.put("domainLookUpEnd", Long.valueOf(paramWebPageProfile.domainLookUpEnd));
        localHashMap.put("connectStart", Long.valueOf(paramWebPageProfile.connectStart));
        localHashMap.put("connectEnd", Long.valueOf(paramWebPageProfile.connectEnd));
        localHashMap.put("SSLconnectionStart", Long.valueOf(paramWebPageProfile.SSLconnectionStart));
        localHashMap.put("SSLconnectionEnd", Long.valueOf(paramWebPageProfile.SSLconnectionEnd));
        localHashMap.put("requestStart", Long.valueOf(paramWebPageProfile.requestStart));
        localHashMap.put("requestEnd", Long.valueOf(paramWebPageProfile.requestEnd));
        localHashMap.put("responseStart", Long.valueOf(paramWebPageProfile.responseStart));
        localHashMap.put("responseEnd", Long.valueOf(paramWebPageProfile.responseEnd));
        localHashMap.put("rtt", Integer.valueOf(paramWebPageProfile.rtt));
        localHashMap.put("estimate_nettype", Integer.valueOf(paramWebPageProfile.networkTypeEstimate));
        localHashMap.put("httpRttEstimate", Integer.valueOf(paramWebPageProfile.httpRttEstimate));
        localHashMap.put("transportRttEstimate", Integer.valueOf(paramWebPageProfile.transportRttEstimate));
        localHashMap.put("downstreamThroughputKbpsEstimate", Integer.valueOf(paramWebPageProfile.downstreamThroughputKbpsEstimate));
        localHashMap.put("throughputKbps", Integer.valueOf(paramWebPageProfile.throughputKbps));
        localHashMap.put("peerIP", paramWebPageProfile.peerIP);
        localHashMap.put("port", Integer.valueOf(paramWebPageProfile.port));
        localHashMap.put("protocol", paramWebPageProfile.protocol);
        localHashMap.put("socketReused", Boolean.valueOf(paramWebPageProfile.socketReused));
        localHashMap.put("sendBytesCount", Long.valueOf(paramWebPageProfile.sendBytesCount));
        localHashMap.put("receivedBytedCount", Long.valueOf(paramWebPageProfile.receivedBytedCount));
      }
      return localHashMap;
    }
    finally {}
  }
  
  public static Map<String, List<String>> a(Map<String, String> paramMap)
  {
    localHashMap = new HashMap();
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        String str1 = (String)paramMap.getKey();
        if ((str1 != null) && (!str1.isEmpty()))
        {
          String str2 = (String)paramMap.getValue();
          List localList = (List)localHashMap.get(str1);
          paramMap = localList;
          if (localList == null) {
            paramMap = new ArrayList();
          }
          paramMap.add(str2);
          localHashMap.put(str1, paramMap);
        }
      }
      return localHashMap;
    }
    catch (Exception paramMap)
    {
      o.a("MicroMsg.AppBrandNetworkUtil", paramMap, "JSONException: put header error", new Object[0]);
    }
  }
  
  private static Map<String, String> a(Map<String, String> paramMap, a parama)
  {
    if (parama == null)
    {
      o.b("MicroMsg.AppBrandNetworkUtil", "hy: no network config!");
      return paramMap;
    }
    Object localObject;
    if (parama.x == 1)
    {
      localObject = paramMap;
      if (parama.p != null) {
        localObject = a(paramMap, parama.p);
      }
    }
    else
    {
      localObject = paramMap;
      if (parama.x == 2)
      {
        localObject = paramMap;
        if (parama.q != null) {
          localObject = b(paramMap, parama.q);
        }
      }
    }
    if (localObject != null)
    {
      b((Map)localObject);
      if (!TextUtils.isEmpty(parama.w)) {
        ((Map)localObject).put("referer", parama.w);
      }
    }
    return localObject;
  }
  
  private static Map<String, String> a(Map<String, String> paramMap, ArrayList<String> paramArrayList)
  {
    if ((paramMap != null) && (paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str1 = (String)paramArrayList.next();
        if (str1 != null)
        {
          str1 = str1.toLowerCase();
          String str2 = (String)paramMap.remove(str1);
          if (str2 != null) {
            o.f("MicroMsg.AppBrandNetworkUtil", "remove key %s value %s", new Object[] { str1, str2 });
          }
        }
      }
      return paramMap;
    }
    o.b("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderBlackList fail, headerMap is null or blacklist is null or nil.");
    return paramMap;
  }
  
  public static Map<String, String> a(JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("header");
      if (paramJSONObject != null)
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str != null) {
            localHashMap.put(str.toLowerCase(), paramJSONObject.getString(str));
          }
        }
      }
      return localHashMap;
    }
    catch (Exception paramJSONObject)
    {
      o.a("MicroMsg.AppBrandNetworkUtil", paramJSONObject, "Exception: get header error", new Object[0]);
    }
  }
  
  public static Map<String, String> a(JSONObject paramJSONObject, a parama)
  {
    return a(a(paramJSONObject), parama);
  }
  
  @Nullable
  public static SSLContext a(a parama)
  {
    parama = b(parama);
    if (parama == null) {
      return null;
    }
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, new TrustManager[] { parama }, null);
      return localSSLContext;
    }
    catch (Exception parama)
    {
      o.a("MicroMsg.AppBrandNetworkUtil", parama, "Exception: SSLContext init error", new Object[0]);
    }
    return null;
  }
  
  public static JSONObject a(Map<String, List<String>> paramMap, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramInt == 1) {
      try
      {
        localJSONObject.put("__AppBrandRemoteDebugRequestHeader__", true);
      }
      catch (JSONException localJSONException1)
      {
        o.a("MicroMsg.AppBrandNetworkUtil", localJSONException1, "JSONException: getHeaderJsonObject put REQUEST_HEADER header error", new Object[0]);
      }
    }
    if (paramMap == null) {
      return localJSONObject;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      if ((!af.c(str)) && (localObject != null) && (!((List)localObject).isEmpty()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)((List)localObject).get(0));
        paramInt = 1;
        while (paramInt < ((List)localObject).size())
        {
          localStringBuilder.append(",");
          localStringBuilder.append((String)((List)localObject).get(paramInt));
          paramInt += 1;
        }
        try
        {
          localJSONObject.put(str, localStringBuilder.toString());
        }
        catch (JSONException localJSONException2)
        {
          o.a("MicroMsg.AppBrandNetworkUtil", localJSONException2, "JSONException: getHeaderJsonObject put header error", new Object[0]);
        }
      }
    }
    return localJSONObject;
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection, ArrayList<String> paramArrayList)
  {
    if (paramHttpURLConnection == null) {
      return;
    }
    HostnameVerifier localHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
    ((HttpsURLConnection)paramHttpURLConnection).setHostnameVerifier(new j.1(localHostnameVerifier, paramArrayList));
  }
  
  public static boolean a(b paramb)
  {
    int i = j.2.a[paramb.ordinal()];
    return (i == 1) || (i == 2);
  }
  
  public static boolean a(c paramc)
  {
    int i = j.2.a[paramc.getAppState().ordinal()];
    return (i == 1) || (i == 2);
  }
  
  public static boolean a(ArrayList<String> paramArrayList, String paramString)
  {
    return a(paramArrayList, paramString, false);
  }
  
  public static boolean a(ArrayList<String> paramArrayList, String paramString, boolean paramBoolean)
  {
    if (b(paramArrayList, paramString, paramBoolean)) {
      return true;
    }
    if (b((String)a(paramString).get("host")) == 2)
    {
      o.b("MicroMsg.AppBrandNetworkUtil", "matchUrl, url in the same net %s", new Object[] { paramString });
      return true;
    }
    return false;
  }
  
  public static int b(String paramString)
  {
    if (!d(paramString))
    {
      o.b("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
      return 0;
    }
    Object localObject = paramString.split("\\.");
    int m = g.a(new byte[] { (byte)(af.a(localObject[0], 0) & 0xFF), (byte)(af.a(localObject[1], 0) & 0xFF), (byte)(af.a(localObject[2], 0) & 0xFF), (byte)(af.a(localObject[3], 0) & 0xFF) });
    WifiManager localWifiManager = (WifiManager)r.a().getApplicationContext().getSystemService("wifi");
    int k;
    int j;
    if (localWifiManager.getWifiState() == 3)
    {
      k = NetworkMonitor.getConnectionInfo(localWifiManager).getIpAddress();
      localObject = d(k);
      try
      {
        i = localWifiManager.getDhcpInfo().netmask;
      }
      catch (NullPointerException localNullPointerException)
      {
        o.a("MicroMsg.AppBrandNetworkUtil", localNullPointerException, "NullPointerException: getDhcpInfo error", new Object[0]);
        i = 0;
      }
      j = i;
      if (i <= 0) {
        if (Build.VERSION.SDK_INT >= 21)
        {
          j = a();
        }
        else
        {
          o.b("MicroMsg.AppBrandNetworkUtil", "invalid netmask");
          j = i;
        }
      }
      o.d("MicroMsg.AppBrandNetworkUtil", "matchIp oldIpStr:%s, localIp:%s,oldIpInt:%d, localIpInt:%d, netmask:%d", new Object[] { paramString, localObject, Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) });
      return a(j, m, k);
    }
    int i = 13;
    try
    {
      j = ((Integer)localNullPointerException.getClass().getField("WIFI_AP_STATE_ENABLED").get(localNullPointerException)).intValue();
      i = j;
      k = ((Integer)localNullPointerException.getClass().getMethod("getWifiApState", new Class[0]).invoke(localNullPointerException, new Object[0])).intValue();
      i = k;
    }
    catch (Exception paramString)
    {
      o.a("MicroMsg.AppBrandNetworkUtil", paramString, "Exception: getWifiApState error", new Object[0]);
      k = 0;
      j = i;
      i = k;
    }
    if (i == j)
    {
      o.d("MicroMsg.AppBrandNetworkUtil", "matchip in apmode");
      return c(m);
    }
    o.d("MicroMsg.AppBrandNetworkUtil", "apState:%d", new Object[] { Integer.valueOf(i) });
    return 0;
  }
  
  @Nullable
  public static m b(a parama)
  {
    Object localObject = new LinkedList();
    Iterator localIterator = parama.r.iterator();
    while (localIterator.hasNext())
    {
      byte[] arrayOfByte = (byte[])localIterator.next();
      if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
        ((LinkedList)localObject).add(new ByteArrayInputStream(arrayOfByte));
      }
    }
    if (((LinkedList)localObject).isEmpty())
    {
      if (parama.A)
      {
        o.d("MicroMsg.AppBrandNetworkUtil", "getTrustManagerWithSelfSignedCertificates debug type");
        parama = new m(true);
        parama.a();
        return parama;
      }
      return null;
    }
    parama = new m(parama.A);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      parama.a((InputStream)((Iterator)localObject).next());
    }
    parama.a();
    return parama;
  }
  
  private static Map<String, String> b(Map<String, String> paramMap, ArrayList<String> paramArrayList)
  {
    if ((paramMap != null) && (paramArrayList != null))
    {
      HashMap localHashMap = new HashMap();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str1 = (String)paramArrayList.next();
        if (str1 != null)
        {
          str1 = str1.toLowerCase();
          String str2 = (String)paramMap.get(str1);
          if (str2 != null)
          {
            o.f("MicroMsg.AppBrandNetworkUtil", "add item, key(%s), value(%s)", new Object[] { str1, str2 });
            localHashMap.put(str1, str2);
          }
        }
      }
      return localHashMap;
    }
    o.b("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderWhiteList fail");
    return paramMap;
  }
  
  public static Map<String, String> b(JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("formData");
      if (paramJSONObject != null)
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, paramJSONObject.getString(str));
        }
      }
      return localHashMap;
    }
    catch (Exception paramJSONObject)
    {
      o.a("MicroMsg.AppBrandNetworkUtil", paramJSONObject, "Exception: get form error", new Object[0]);
    }
  }
  
  public static JSONObject b(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection == null) {
      return a(null, 2);
    }
    return a(paramHttpURLConnection.getHeaderFields(), 2);
  }
  
  private static void b(Map<String, String> paramMap)
  {
    if (paramMap != null) {
      paramMap.remove("referer");
    }
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 301) || (paramInt == 302) || (paramInt == 307);
  }
  
  public static boolean b(ArrayList<String> paramArrayList, String paramString, boolean paramBoolean)
  {
    if (af.c(paramString))
    {
      o.b("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
      return false;
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("url ");
      ((StringBuilder)localObject1).append(paramString);
      o.d("MicroMsg.AppBrandNetworkUtil", ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("configUrl size ");
      ((StringBuilder)localObject1).append(paramArrayList.size());
      o.d("MicroMsg.AppBrandNetworkUtil", ((StringBuilder)localObject1).toString());
      Object localObject2 = a(paramString);
      paramString = (String)((HashMap)localObject2).get("host");
      localObject1 = (String)((HashMap)localObject2).get("scheme");
      localObject2 = (String)((HashMap)localObject2).get("port");
      if (!af.c(paramString))
      {
        if (af.c((String)localObject1)) {
          return false;
        }
        o.d("MicroMsg.AppBrandNetworkUtil", "host %s  scheme %s port %s skipPortCheck %s", new Object[] { paramString, localObject1, localObject2, Boolean.valueOf(paramBoolean) });
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("configUrl ");
          ((StringBuilder)localObject3).append(str);
          o.d("MicroMsg.AppBrandNetworkUtil", ((StringBuilder)localObject3).toString());
          Object localObject4 = a(str);
          str = (String)((HashMap)localObject4).get("host");
          localObject3 = (String)((HashMap)localObject4).get("scheme");
          localObject4 = (String)((HashMap)localObject4).get("port");
          o.d("MicroMsg.AppBrandNetworkUtil", "confighost %s  configscheme %s configport %s", new Object[] { str, localObject3, localObject4 });
          if ((paramString.equalsIgnoreCase(str)) && (((String)localObject1).equalsIgnoreCase((String)localObject3)) && ((paramBoolean) || (((String)localObject2).equalsIgnoreCase((String)localObject4))))
          {
            o.d("MicroMsg.AppBrandNetworkUtil", "match!!");
            return true;
          }
        }
      }
      return false;
    }
    o.b("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, configUrls is empty");
    return false;
  }
  
  private static long[] b(long paramLong)
  {
    long[] arrayOfLong = new long[4];
    if (paramLong > 0L)
    {
      arrayOfLong[0] = (paramLong >>> 24);
      arrayOfLong[1] = ((0xFFFFFF & paramLong) >>> 16);
      arrayOfLong[2] = ((0xFFFF & paramLong) >>> 8);
      arrayOfLong[3] = (paramLong & 0xFF);
    }
    return arrayOfLong;
  }
  
  private static int c(int paramInt)
  {
    try
    {
      Iterator localIterator1 = Collections.list(NetworkMonitor.getNetworkInterfaces()).iterator();
      InterfaceAddress localInterfaceAddress;
      String str;
      boolean bool;
      do
      {
        do
        {
          Iterator localIterator2;
          while (!localIterator2.hasNext())
          {
            if (!localIterator1.hasNext()) {
              break;
            }
            localIterator2 = ((NetworkInterface)localIterator1.next()).getInterfaceAddresses().iterator();
          }
          localInterfaceAddress = (InterfaceAddress)localIterator2.next();
        } while (localInterfaceAddress.getAddress().isLoopbackAddress());
        str = localInterfaceAddress.getAddress().getHostAddress().toUpperCase();
        bool = InetAddressUtils.isIPv4Address(str);
        o.d("MicroMsg.AppBrandNetworkUtil", "check ip:%s, isIPv4:%b", new Object[] { str, Boolean.valueOf(bool) });
      } while (!bool);
      int i = e(str);
      long l = a(localInterfaceAddress.getNetworkPrefixLength());
      o.d("MicroMsg.AppBrandNetworkUtil", "matchAddress oldIpInt:%d, localIpInt:%d, netmask:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(l) });
      paramInt = a(l, paramInt, i);
      return paramInt;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.AppBrandNetworkUtil", localException, "Exception: matchAddress error", new Object[0]);
    }
    return 0;
  }
  
  public static String c(String paramString)
  {
    return paramString;
  }
  
  public static String c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    paramJSONObject = paramJSONObject.optJSONArray("protocols");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localLinkedList.add(paramJSONObject.optString(i));
        i += 1;
      }
    }
    if (!af.a(localLinkedList)) {
      return TextUtils.join(", ", localLinkedList);
    }
    return null;
  }
  
  public static JSONObject c(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection == null) {
      return a(null, 1);
    }
    return a(paramHttpURLConnection.getRequestProperties(), 1);
  }
  
  private static boolean c(ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList != null)
    {
      if (paramString == null) {
        return true;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (((String)paramArrayList.next()).contains(paramString)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  private static String d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  private static boolean d(String paramString)
  {
    if (af.c(paramString))
    {
      o.b("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
      return false;
    }
    paramString = paramString.split("\\.");
    if (paramString.length != 4)
    {
      o.b("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
      return false;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      int k = af.a(paramString[i], -1);
      if ((k >= 0) && (k <= 255))
      {
        i += 1;
      }
      else
      {
        o.b("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
        return false;
      }
    }
    return true;
  }
  
  private static int e(String paramString)
  {
    if (!d(paramString)) {
      return 0;
    }
    paramString = paramString.split("\\.");
    return g.a(new byte[] { (byte)(af.a(paramString[0], 0) & 0xFF), (byte)(af.a(paramString[1], 0) & 0xFF), (byte)(af.a(paramString[2], 0) & 0xFF), (byte)(af.a(paramString[3], 0) & 0xFF) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.j
 * JD-Core Version:    0.7.0.1
 */