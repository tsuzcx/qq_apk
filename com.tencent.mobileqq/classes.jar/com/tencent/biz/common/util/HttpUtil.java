package com.tencent.biz.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.rookery.asyncHttpClient.CustomSSLSocketFactory;
import com.tencent.component.network.utils.http.base.SNIVerifier;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BaseQRUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpUtil
{
  public static final String GET = "GET";
  public static final String LOCAL_IMAGE_QUERY_URL = "https://cgi.connect.qq.com/qqconnectopen/query_share_image?key=%s&size=%d&short_url=0";
  public static final String LOCAL_IMAGE_UPLOAD_HOST = "cgi.connect.qq.com";
  public static final String LOCAL_IMAGE_UPLOAD_NO_SCALE = "1";
  public static final String LOCAL_IMAGE_UPLOAD_URL = "https://cgi.connect.qq.com/qqconnectopen/upload_share_image";
  public static final String POST = "POST";
  public static final int SET_CONNECTION_TIMEOUT = 15000;
  public static final int SET_SOCKET_TIMEOUT = 30000;
  public static final String TAG = "HttpUtil";
  private static final String URL_EXCHANGE_URL = "https://openmobile.qq.com/api/url_change";
  private static final String URL_SHORTEN_URL = "https://openmobile.qq.com/api/shortUrl";
  private static final int VIVO_3G = 17;
  private static boolean hasLookupQrDNS = false;
  private static final SNIVerifier httpVerifier = new SNIVerifier();
  
  public static void addCookie(Bundle paramBundle)
  {
    String str1 = getRunTime().getAccount();
    String str2 = ((TicketManager)getRunTime().getManager(2)).getSkey(str1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append(str1);
    localStringBuilder.append(";skey=");
    localStringBuilder.append(str2);
    paramBundle.putString("cookie", localStringBuilder.toString());
  }
  
  public static final HashMap<String, String> batchUrlExchange(Context paramContext, String paramString1, String paramString2, int paramInt, HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    if (paramHashMap == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap(paramHashMap);
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramHashMap.get(str1);
      if (!TextUtils.isEmpty(str2))
      {
        localJSONArray.put(str2);
        localArrayList.add(str1);
      }
    }
    paramContext = exchaneUrl(paramContext, paramString1, paramString2, paramInt, localJSONArray);
    if (paramContext != null) {
      try
      {
        paramContext = new JSONObject(paramContext);
        paramInt = paramContext.getInt("retcode");
        if (paramBundle != null) {
          paramBundle.putInt("retcode", paramInt);
        }
        if (paramInt == 0)
        {
          paramContext = paramContext.getJSONObject("result");
          if (paramContext == null) {
            return localHashMap;
          }
          paramString1 = paramContext.getJSONArray("list");
          if (paramString1 == null) {
            return localHashMap;
          }
          if (paramString1.length() == localArrayList.size())
          {
            paramContext = new HashMap();
            paramInt = 0;
            while (paramInt < paramString1.length())
            {
              paramContext.put(localArrayList.get(paramInt), paramString1.getString(paramInt));
              paramInt += 1;
            }
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append("batchUrlExchange results: ");
              paramString1.append(paramContext.toString());
              paramString1.append(", input: ");
              paramString1.append(paramHashMap);
              QLog.d("HttpUtil", 2, paramString1.toString());
            }
            if (paramBundle == null) {
              return paramContext;
            }
            paramBundle.putBoolean("isSuccess", true);
            return paramContext;
          }
          QLog.e("Q.share.sdk", 4, "!!!!urlArray.length() != srcKeyArray.size()");
          return localHashMap;
        }
      }
      catch (JSONException paramContext)
      {
        QLog.d("Q.share.sdk", 4, paramContext.getMessage());
      }
    } else {
      return localHashMap;
    }
    return paramContext;
  }
  
  public static String decodeHtmlText(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&nbsp;", " ").replace("<br>", " ").replace("<br/>", " ").replace("<br />", " ").replace("&amp;", "&").replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "\"").replace("&#92;", "\\").replace("&#39;", "'");
  }
  
  public static HashMap<String, String> decodeURL(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString == null) {
      return localHashMap;
    }
    paramString = truncateUrlPage(paramString);
    if (paramString == null) {
      return localHashMap;
    }
    paramString = paramString.split("[&]");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i].split("[=]");
      if (arrayOfString.length > 1) {
        localHashMap.put(URLDecoder.decode(arrayOfString[0]), URLDecoder.decode(arrayOfString[1]));
      } else if (!TextUtils.isEmpty(arrayOfString[0])) {
        localHashMap.put(arrayOfString[0], "");
      }
      i += 1;
    }
    return localHashMap;
  }
  
  public static String encodeUrl(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramBundle.get((String)localObject1);
      if (((localObject2 instanceof String)) || ((localObject2 instanceof String[])))
      {
        boolean bool = localObject2 instanceof String[];
        int k = 0;
        if (bool)
        {
          int j;
          if (i != 0)
          {
            j = 0;
          }
          else
          {
            localStringBuilder.append("&");
            j = i;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(URLEncoder.encode((String)localObject1));
          ((StringBuilder)localObject2).append("=");
          localStringBuilder.append(((StringBuilder)localObject2).toString());
          localObject1 = (String[])paramBundle.getStringArray((String)localObject1);
          for (;;)
          {
            i = j;
            if (k >= localObject1.length) {
              break;
            }
            if (k == 0)
            {
              localStringBuilder.append(URLEncoder.encode(localObject1[k]));
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(",");
              ((StringBuilder)localObject2).append(localObject1[k]);
              localStringBuilder.append(URLEncoder.encode(((StringBuilder)localObject2).toString()));
            }
            k += 1;
          }
        }
        if (i != 0) {
          i = 0;
        } else {
          localStringBuilder.append("&");
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(URLEncoder.encode((String)localObject1));
        ((StringBuilder)localObject2).append("=");
        ((StringBuilder)localObject2).append(URLEncoder.encode(paramBundle.getString((String)localObject1)));
        localStringBuilder.append(((StringBuilder)localObject2).toString());
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String escape(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&", "&amp;").replace("'", "&apos;").replace("\"", "&quot;").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;");
  }
  
  protected static final String exchaneUrl(Context paramContext, String paramString1, String paramString2, int paramInt, JSONArray paramJSONArray)
  {
    Bundle localBundle = new Bundle();
    Object localObject = ((TicketManager)getRunTime().getManager(2)).getPskey(paramString1, "openmobile.qq.com");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString2 = new StringBuilder();
      paramString2.append("p_uin=");
      paramString2.append(paramString1);
      paramString2.append(";p_skey=");
      paramString2.append((String)localObject);
      localBundle.putString("cookie", paramString2.toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(";skey=");
      ((StringBuilder)localObject).append(paramString2);
      localBundle.putString("cookie", ((StringBuilder)localObject).toString());
    }
    localBundle.putString("Referer", "http://openmobile.qq.com/");
    paramString1 = new Bundle();
    paramString1.putString("type", String.valueOf(paramInt));
    paramString1.putString("value", paramJSONArray.toString());
    paramString1.putString("mType", "qb_share");
    try
    {
      paramContext = openUrl(paramContext, "https://openmobile.qq.com/api/url_change", "POST", paramString1, localBundle);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      QLog.d("zivonchen", 4, paramContext.getMessage());
    }
    return null;
  }
  
  private static String getAccount()
  {
    Object localObject = getRunTime();
    if (localObject == null) {
      return "0";
    }
    String str = ((AppRuntime)localObject).getAccount();
    localObject = str;
    if (str == null) {
      localObject = "0";
    }
    return localObject;
  }
  
  private static HttpClient getHttpClient(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 16) {}
    try
    {
      localObject1 = KeyStore.getInstance(KeyStore.getDefaultType());
      ((KeyStore)localObject1).load(null, null);
      localObject1 = new CustomSSLSocketFactory((KeyStore)localObject1);
      ((SSLSocketFactory)localObject1).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }
    catch (Exception localException)
    {
      Object localObject1;
      label51:
      Object localObject2;
      break label51;
    }
    localObject1 = SSLSocketFactory.getSocketFactory();
    ((SSLSocketFactory)localObject1).setHostnameVerifier(httpVerifier);
    break label72;
    localObject1 = SSLSocketFactory.getSocketFactory();
    label72:
    if (!TextUtils.isEmpty(paramString)) {
      ((SSLSocketFactory)localObject1).setHostnameVerifier(new HttpUtil.1(paramString));
    }
    paramString = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(paramString, paramInt1);
    HttpConnectionParams.setSoTimeout(paramString, paramInt2);
    HttpProtocolParams.setVersion(paramString, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(paramString, "UTF-8");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("AndroidSDK_");
    ((StringBuilder)localObject2).append(Build.VERSION.SDK);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(Build.DEVICE);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(Build.VERSION.RELEASE);
    HttpProtocolParams.setUserAgent(paramString, ((StringBuilder)localObject2).toString());
    localObject2 = new SchemeRegistry();
    ((SchemeRegistry)localObject2).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    ((SchemeRegistry)localObject2).register(new Scheme("https", (SocketFactory)localObject1, 443));
    paramString = new DefaultHttpClient(new ThreadSafeClientConnManager(paramString, (SchemeRegistry)localObject2), paramString);
    paramContext = getProxy(paramContext);
    if (paramContext != null)
    {
      paramContext = new HttpHost(paramContext.host, paramContext.port);
      paramString.getParams().setParameter("http.route.default-proxy", paramContext);
    }
    return paramString;
  }
  
  public static int getNetWorkType()
  {
    boolean bool = AppNetConnInfo.isNetSupport();
    int j = 0;
    if (!bool) {
      return 0;
    }
    if (AppNetConnInfo.isWifiConn()) {
      return 1;
    }
    int i = j;
    if (AppNetConnInfo.isMobileConn())
    {
      int k = AppNetConnInfo.getMobileInfo();
      i = j;
      if (k != -1)
      {
        j = 2;
        i = j;
        if (k != 0)
        {
          i = j;
          if (k != 1)
          {
            if (k != 2)
            {
              if ((k != 3) && (k != 4)) {
                return -1;
              }
              return 4;
            }
            return 3;
          }
        }
      }
    }
    return i;
  }
  
  public static String getNetWorkTypeByStr()
  {
    switch ()
    {
    default: 
      return null;
    case 6: 
      return "5G";
    case 5: 
      return "CABLE";
    case 4: 
      return "4G";
    case 3: 
      return "3G";
    case 2: 
      return "2G";
    case 1: 
      return "WIFI";
    case 0: 
      return "NONE";
    }
    return "UNKNOWN";
  }
  
  public static int getNetWorkTypeContain5G()
  {
    boolean bool = AppNetConnInfo.isNetSupport();
    int j = 0;
    if (!bool) {
      return 0;
    }
    if (AppNetConnInfo.isWifiConn()) {
      return 1;
    }
    int i = j;
    if (AppNetConnInfo.isMobileConn())
    {
      int k = AppNetConnInfo.getMobileInfo();
      i = j;
      if (k != -1)
      {
        j = 2;
        i = j;
        if (k != 0)
        {
          i = j;
          if (k != 1)
          {
            if (k != 2)
            {
              if (k != 3)
              {
                if (k != 4) {
                  return -1;
                }
                return 6;
              }
              return 4;
            }
            return 3;
          }
        }
      }
    }
    return i;
  }
  
  public static HttpUtil.NetworkProxy getProxy(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return null;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return null;
    }
    if (NetworkUtil.isMobileNetworkInfo((NetworkInfo)localObject))
    {
      localObject = getProxyHost(paramContext);
      int i = getProxyPort(paramContext);
      if ((!isEmpty((String)localObject)) && (i >= 0)) {
        return new HttpUtil.NetworkProxy((String)localObject, i, null);
      }
    }
    return null;
  }
  
  public static String getProxyHost(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (paramContext != null)
      {
        String str = Proxy.getHost(paramContext);
        paramContext = str;
        if (isEmpty(str)) {
          return Proxy.getDefaultHost();
        }
      }
      else
      {
        return Proxy.getDefaultHost();
      }
    }
    else {
      paramContext = System.getProperty("http.proxyHost");
    }
    return paramContext;
  }
  
  public static int getProxyPort(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (paramContext != null)
      {
        int j = Proxy.getPort(paramContext);
        i = j;
        if (j < 0) {
          return Proxy.getDefaultPort();
        }
      }
      else
      {
        return Proxy.getDefaultPort();
      }
    }
    else
    {
      paramContext = System.getProperty("http.proxyPort");
      if (isEmpty(paramContext)) {}
    }
    try
    {
      i = Integer.parseInt(paramContext);
      return i;
    }
    catch (NumberFormatException paramContext)
    {
      label52:
      break label52;
    }
    int i = -1;
    return i;
  }
  
  private static AppRuntime getRunTime()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static boolean isConnect(Context paramContext)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HttpUtil", 2, "isConnect(), context == null");
      }
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()))
        {
          paramContext = paramContext.getState();
          NetworkInfo.State localState = NetworkInfo.State.CONNECTED;
          if (paramContext == localState) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.d("HttpUtil", 2, paramContext.toString());
    }
    return false;
  }
  
  private static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static final boolean isValidUrl(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static String mapToParams(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = (String)paramMap.get(str);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (i != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("=");
        ((StringBuilder)localObject2).append(URLEncoder.encode((String)localObject1, "utf-8"));
        localStringBuilder.append(((StringBuilder)localObject2).toString());
        i = 0;
      }
      else if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("&");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("=");
        ((StringBuilder)localObject2).append(URLEncoder.encode((String)localObject1, "utf-8"));
        localStringBuilder.append(((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("&");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("=");
        localStringBuilder.append(((StringBuilder)localObject1).toString());
      }
    }
    return localStringBuilder.toString();
  }
  
  public static HttpResponse openRequest(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2)
  {
    return openRequest(paramContext, paramString1, paramString2, paramString3, paramBundle1, paramBundle2, 15000, 30000);
  }
  
  public static HttpResponse openRequest(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt1, int paramInt2)
  {
    return openRequest(paramContext, paramString1, paramString2, paramString3, paramBundle1, paramBundle2, paramInt1, paramInt2, null);
  }
  
  /* Error */
  public static HttpResponse openRequest(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt1, int paramInt2, String paramString4)
  {
    // Byte code:
    //   0: getstatic 672	com/tencent/biz/common/util/HttpUtil:hasLookupQrDNS	Z
    //   3: ifne +14 -> 17
    //   6: iconst_1
    //   7: putstatic 672	com/tencent/biz/common/util/HttpUtil:hasLookupQrDNS	Z
    //   10: aload_0
    //   11: getstatic 677	com/tencent/util/BaseQRUtil:f	Ljava/lang/String;
    //   14: invokestatic 681	com/tencent/util/BaseQRUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   17: aload_0
    //   18: ifnonnull +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: aload_0
    //   24: iload 6
    //   26: iload 7
    //   28: aload 8
    //   30: invokestatic 683	com/tencent/biz/common/util/HttpUtil:getHttpClient	(Landroid/content/Context;IILjava/lang/String;)Lorg/apache/http/client/HttpClient;
    //   33: astore 8
    //   35: aload 8
    //   37: ifnonnull +5 -> 42
    //   40: aconst_null
    //   41: areturn
    //   42: ldc_w 685
    //   45: iconst_2
    //   46: aload_1
    //   47: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_1
    //   51: astore_0
    //   52: aload_1
    //   53: ldc_w 687
    //   56: invokevirtual 690	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   59: ifeq +15 -> 74
    //   62: aload_1
    //   63: iconst_0
    //   64: aload_1
    //   65: bipush 35
    //   67: invokevirtual 694	java/lang/String:indexOf	(I)I
    //   70: invokevirtual 698	java/lang/String:substring	(II)Ljava/lang/String;
    //   73: astore_0
    //   74: aload_0
    //   75: ldc 243
    //   77: ldc_w 700
    //   80: invokevirtual 247	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   83: astore_1
    //   84: ldc 7
    //   86: aload_3
    //   87: invokevirtual 703	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifeq +181 -> 271
    //   93: aload 4
    //   95: invokestatic 705	com/tencent/biz/common/util/HttpUtil:encodeUrl	(Landroid/os/Bundle;)Ljava/lang/String;
    //   98: astore_3
    //   99: aload_1
    //   100: astore_0
    //   101: aload_3
    //   102: ifnull +66 -> 168
    //   105: aload_1
    //   106: astore_0
    //   107: aload_3
    //   108: invokevirtual 641	java/lang/String:length	()I
    //   111: ifle +57 -> 168
    //   114: new 77	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   121: astore 4
    //   123: aload 4
    //   125: aload_1
    //   126: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: ldc_w 707
    //   133: astore_0
    //   134: aload_1
    //   135: ldc_w 707
    //   138: invokevirtual 690	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   141: ifeq +7 -> 148
    //   144: ldc_w 257
    //   147: astore_0
    //   148: aload 4
    //   150: aload_0
    //   151: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 4
    //   157: aload_3
    //   158: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 4
    //   164: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: astore_0
    //   168: new 709	org/apache/http/client/methods/HttpGet
    //   171: dup
    //   172: aload_0
    //   173: invokespecial 710	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   176: astore_1
    //   177: aload_1
    //   178: ldc_w 712
    //   181: ldc_w 714
    //   184: invokeinterface 719 3 0
    //   189: aload_1
    //   190: ldc_w 721
    //   193: ldc_w 723
    //   196: invokeinterface 719 3 0
    //   201: aload_1
    //   202: astore_0
    //   203: aload 5
    //   205: ifnull +434 -> 639
    //   208: aload 5
    //   210: invokevirtual 299	android/os/Bundle:keySet	()Ljava/util/Set;
    //   213: invokeinterface 123 1 0
    //   218: astore_3
    //   219: aload_1
    //   220: astore_0
    //   221: aload_3
    //   222: invokeinterface 129 1 0
    //   227: ifeq +412 -> 639
    //   230: aload_3
    //   231: invokeinterface 133 1 0
    //   236: checkcast 135	java/lang/String
    //   239: astore_0
    //   240: aload 5
    //   242: aload_0
    //   243: invokevirtual 302	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   246: astore 4
    //   248: aload 4
    //   250: instanceof 135
    //   253: ifeq -34 -> 219
    //   256: aload_1
    //   257: aload_0
    //   258: aload 4
    //   260: checkcast 135	java/lang/String
    //   263: invokeinterface 719 3 0
    //   268: goto -49 -> 219
    //   271: new 725	org/apache/http/client/methods/HttpPost
    //   274: dup
    //   275: aload_1
    //   276: invokespecial 726	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   279: astore_1
    //   280: aload_1
    //   281: ldc_w 712
    //   284: ldc_w 714
    //   287: invokevirtual 727	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload_1
    //   291: ldc_w 721
    //   294: ldc_w 723
    //   297: invokevirtual 727	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload 4
    //   302: ldc_w 729
    //   305: invokevirtual 730	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   308: istore 6
    //   310: iload 6
    //   312: ifne +22 -> 334
    //   315: aload 4
    //   317: invokestatic 705	com/tencent/biz/common/util/HttpUtil:encodeUrl	(Landroid/os/Bundle;)Ljava/lang/String;
    //   320: astore_0
    //   321: aload_1
    //   322: ldc_w 732
    //   325: ldc_w 734
    //   328: invokevirtual 737	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: goto +222 -> 553
    //   334: iload 6
    //   336: iconst_1
    //   337: if_icmpne +213 -> 550
    //   340: aload_1
    //   341: ldc_w 732
    //   344: ldc_w 739
    //   347: invokevirtual 737	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: aload 4
    //   352: ldc_w 729
    //   355: invokevirtual 742	android/os/Bundle:remove	(Ljava/lang/String;)V
    //   358: new 159	org/json/JSONObject
    //   361: dup
    //   362: invokespecial 743	org/json/JSONObject:<init>	()V
    //   365: astore_0
    //   366: aload 4
    //   368: invokevirtual 299	android/os/Bundle:keySet	()Ljava/util/Set;
    //   371: invokeinterface 123 1 0
    //   376: astore_3
    //   377: aload_3
    //   378: invokeinterface 129 1 0
    //   383: ifeq +159 -> 542
    //   386: aload_3
    //   387: invokeinterface 133 1 0
    //   392: checkcast 135	java/lang/String
    //   395: astore 9
    //   397: aload 4
    //   399: aload 9
    //   401: invokevirtual 302	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   404: astore 10
    //   406: aload 10
    //   408: instanceof 135
    //   411: ifeq +23 -> 434
    //   414: aload_0
    //   415: aload 9
    //   417: invokestatic 309	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   420: aload 4
    //   422: aload 9
    //   424: invokevirtual 318	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   427: invokevirtual 746	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   430: pop
    //   431: goto -54 -> 377
    //   434: aload 10
    //   436: instanceof 748
    //   439: ifne +69 -> 508
    //   442: aload 10
    //   444: instanceof 607
    //   447: ifne +61 -> 508
    //   450: aload 10
    //   452: instanceof 750
    //   455: ifne +53 -> 508
    //   458: aload 10
    //   460: instanceof 752
    //   463: ifne +45 -> 508
    //   466: aload 10
    //   468: instanceof 754
    //   471: ifeq +6 -> 477
    //   474: goto +34 -> 508
    //   477: aload 10
    //   479: instanceof 159
    //   482: ifne +11 -> 493
    //   485: aload 10
    //   487: instanceof 109
    //   490: ifeq -113 -> 377
    //   493: aload_0
    //   494: aload 9
    //   496: invokestatic 309	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   499: aload 10
    //   501: invokevirtual 746	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   504: pop
    //   505: goto -128 -> 377
    //   508: aload_0
    //   509: aload 9
    //   511: invokestatic 309	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   514: aload 10
    //   516: invokevirtual 746	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   519: pop
    //   520: goto -143 -> 377
    //   523: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq -149 -> 377
    //   529: ldc_w 685
    //   532: iconst_2
    //   533: ldc_w 756
    //   536: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: goto -162 -> 377
    //   542: aload_0
    //   543: invokevirtual 757	org/json/JSONObject:toString	()Ljava/lang/String;
    //   546: astore_0
    //   547: goto +6 -> 553
    //   550: ldc 239
    //   552: astore_0
    //   553: aload_0
    //   554: invokevirtual 761	java/lang/String:getBytes	()[B
    //   557: astore_0
    //   558: aload 5
    //   560: ifnull +65 -> 625
    //   563: aload 5
    //   565: invokevirtual 299	android/os/Bundle:keySet	()Ljava/util/Set;
    //   568: invokeinterface 123 1 0
    //   573: astore_3
    //   574: aload_3
    //   575: invokeinterface 129 1 0
    //   580: ifeq +45 -> 625
    //   583: aload_3
    //   584: invokeinterface 133 1 0
    //   589: checkcast 135	java/lang/String
    //   592: astore 4
    //   594: aload 5
    //   596: aload 4
    //   598: invokevirtual 302	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   601: astore 9
    //   603: aload 9
    //   605: instanceof 135
    //   608: ifeq -34 -> 574
    //   611: aload_1
    //   612: aload 4
    //   614: aload 9
    //   616: checkcast 135	java/lang/String
    //   619: invokevirtual 727	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   622: goto -48 -> 574
    //   625: aload_1
    //   626: new 763	org/apache/http/entity/ByteArrayEntity
    //   629: dup
    //   630: aload_0
    //   631: invokespecial 766	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   634: invokevirtual 770	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   637: aload_1
    //   638: astore_0
    //   639: aload_2
    //   640: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   643: ifne +26 -> 669
    //   646: aload_0
    //   647: invokeinterface 771 1 0
    //   652: ldc_w 773
    //   655: new 488	org/apache/http/HttpHost
    //   658: dup
    //   659: aload_2
    //   660: invokespecial 774	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   663: invokeinterface 512 3 0
    //   668: pop
    //   669: aload 8
    //   671: aload_0
    //   672: invokeinterface 778 2 0
    //   677: astore_0
    //   678: aload_0
    //   679: areturn
    //   680: astore_0
    //   681: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   684: ifeq +52 -> 736
    //   687: ldc_w 685
    //   690: iconst_2
    //   691: ldc_w 780
    //   694: aload_0
    //   695: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   698: aconst_null
    //   699: areturn
    //   700: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   703: ifeq +33 -> 736
    //   706: ldc_w 685
    //   709: iconst_2
    //   710: ldc_w 785
    //   713: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   716: aconst_null
    //   717: areturn
    //   718: astore_0
    //   719: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   722: ifeq +14 -> 736
    //   725: ldc_w 685
    //   728: iconst_2
    //   729: ldc_w 787
    //   732: aload_0
    //   733: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   736: aconst_null
    //   737: areturn
    //   738: astore_0
    //   739: aconst_null
    //   740: areturn
    //   741: astore 9
    //   743: goto -220 -> 523
    //   746: astore_0
    //   747: goto -47 -> 700
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	750	0	paramContext	Context
    //   0	750	1	paramString1	String
    //   0	750	2	paramString2	String
    //   0	750	3	paramString3	String
    //   0	750	4	paramBundle1	Bundle
    //   0	750	5	paramBundle2	Bundle
    //   0	750	6	paramInt1	int
    //   0	750	7	paramInt2	int
    //   0	750	8	paramString4	String
    //   395	220	9	localObject1	Object
    //   741	1	9	localJSONException	JSONException
    //   404	111	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   669	678	680	java/lang/Exception
    //   669	678	718	java/io/IOException
    //   168	177	738	java/lang/Exception
    //   406	431	741	org/json/JSONException
    //   434	474	741	org/json/JSONException
    //   477	493	741	org/json/JSONException
    //   493	505	741	org/json/JSONException
    //   508	520	741	org/json/JSONException
    //   669	678	746	java/lang/OutOfMemoryError
  }
  
  public static String openUrl(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
  {
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    String str1 = Uri.parse(paramString1).getHost();
    try
    {
      paramBundle1 = openRequest(paramContext, paramString1, null, paramString2, localBundle, paramBundle2);
      paramContext = paramBundle1;
    }
    catch (IOException paramBundle1)
    {
      if (!str1.equals(BaseQRUtil.f)) {
        break label200;
      }
    }
    String str2 = BaseQRUtil.a(paramContext, str1);
    paramBundle1 = paramString1;
    if (str2 != null) {
      paramBundle1 = paramString1.replace(str1, str2);
    }
    paramString1 = new StringBuilder();
    paramString1.append("ClientProtocolException reopen: ");
    paramString1.append(paramBundle1);
    QLog.d("QRHttpUtil", 2, paramString1.toString());
    paramContext = openRequest(paramContext, paramBundle1, str1, paramString2, localBundle, paramBundle2);
    if (paramContext != null)
    {
      int i = paramContext.getStatusLine().getStatusCode();
      if (i == 200) {
        return readHttpResponse(paramContext);
      }
      paramContext = new StringBuilder();
      paramContext.append("Http statusCode:");
      paramContext.append(i);
      throw new IOException(paramContext.toString());
    }
    throw new IOException("Http no response.");
    label200:
    throw paramBundle1;
  }
  
  public static byte[] openUrlForByte(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    String str1 = Uri.parse(paramString1).getHost();
    try
    {
      paramBundle1 = openRequest(paramContext, paramString1, null, paramString2, localBundle, paramBundle2);
      paramContext = paramBundle1;
    }
    catch (IOException paramBundle1)
    {
      if (!str1.equals(BaseQRUtil.f)) {
        break label212;
      }
    }
    String str2 = BaseQRUtil.a(paramContext, str1);
    paramBundle1 = paramString1;
    if (str2 != null) {
      paramBundle1 = paramString1.replace(str1, str2);
    }
    paramString1 = new StringBuilder();
    paramString1.append("ClientProtocolException reopen: ");
    paramString1.append(paramBundle1);
    QLog.d("QRHttpUtil", 2, paramString1.toString());
    paramContext = openRequest(paramContext, paramBundle1, str1, paramString2, localBundle, paramBundle2);
    if (paramContext != null)
    {
      int i = paramContext.getStatusLine().getStatusCode();
      if (i == 200) {
        return readHttpResponseSteam(paramContext).toByteArray();
      }
      paramContext = new StringBuilder();
      paramContext.append("Http statusCode:");
      paramContext.append(i);
      throw new IOException(paramContext.toString());
    }
    throw new IOException("Http no response.");
    label212:
    throw paramBundle1;
  }
  
  public static byte[] openUrlForByteForPubAccount(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    String str = Uri.parse(paramString1).getHost();
    try
    {
      if (TextUtils.isEmpty(paramString3))
      {
        paramString3 = openRequest(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
        paramContext = paramString3;
      }
      else
      {
        paramString3 = openRequest(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2, 15000, 30000, paramString3);
        paramContext = paramString3;
      }
    }
    catch (IOException paramString3)
    {
      label87:
      int i;
      break label87;
    }
    if (str.equals(BaseQRUtil.f))
    {
      paramString3 = BaseQRUtil.a(paramContext, str);
      if (paramString3 != null) {
        paramString1 = paramString1.replace(str, paramString3);
      }
      paramString3 = new StringBuilder();
      paramString3.append("ClientProtocolException reopen: ");
      paramString3.append(paramString1);
      QLog.d("QRHttpUtil", 2, paramString3.toString());
      paramContext = openRequest(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
      if (paramContext != null)
      {
        i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return readHttpResponseSteam(paramContext).toByteArray();
        }
        paramContext = new StringBuilder();
        paramContext.append("");
        paramContext.append(i);
        throw new IOException(paramContext.toString());
      }
      throw new IOException("0");
    }
    throw new IOException("0");
  }
  
  public static String openUrlForPubAccount(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2, String paramString3)
  {
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    String str = Uri.parse(paramString1).getHost();
    Object localObject = null;
    try
    {
      if (TextUtils.isEmpty(paramString3))
      {
        paramString3 = openRequest(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
        paramContext = paramString3;
      }
      else
      {
        paramString3 = openRequest(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2, 15000, 30000, paramString3);
        paramContext = paramString3;
      }
    }
    catch (IOException paramString3)
    {
      label190:
      int i;
      break label105;
    }
    catch (OutOfMemoryError paramContext)
    {
      label81:
      label105:
      break label81;
    }
    paramContext = localObject;
    if (QLog.isColorLevel())
    {
      QLog.d("HttpUtil", 2, "openRequest fail OutOfMemoryError");
      paramContext = localObject;
      break label190;
      if (!str.equals(BaseQRUtil.f)) {
        break label278;
      }
      paramString3 = BaseQRUtil.a(paramContext, str);
      if (paramString3 != null) {
        paramString1 = paramString1.replace(str, paramString3);
      }
      paramString3 = new StringBuilder();
      paramString3.append("ClientProtocolException reopen: ");
      paramString3.append(paramString1);
      QLog.d("QRHttpUtil", 2, paramString3.toString());
      paramContext = openRequest(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
    }
    if (paramContext != null)
    {
      i = paramContext.getStatusLine().getStatusCode();
      if (i != 200) {}
    }
    label278:
    try
    {
      paramContext = readHttpResponse(paramContext);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext)
    {
      label222:
      break label222;
    }
    throw new IOException("-1");
    paramContext = new StringBuilder();
    paramContext.append("");
    paramContext.append(i);
    throw new IOException(paramContext.toString());
    throw new IOException("0");
    throw new IOException("0");
  }
  
  public static HttpResponse postRequestWithJson(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject, Bundle paramBundle, int paramInt1, int paramInt2, String paramString3)
  {
    if (!hasLookupQrDNS)
    {
      hasLookupQrDNS = true;
      BaseQRUtil.a(paramContext, BaseQRUtil.f);
    }
    if (paramContext != null)
    {
      if (paramJSONObject == null) {
        return null;
      }
      paramString3 = getHttpClient(paramContext, paramInt1, paramInt2, paramString3);
      if (paramString3 == null) {
        return null;
      }
      QLog.d("QRHttpUtil", 2, paramString1);
      paramContext = paramString1;
      if (paramString1.contains("#")) {
        paramContext = paramString1.substring(0, paramString1.indexOf('#'));
      }
      paramContext = new HttpPost(paramContext.replace(" ", "%20"));
      paramContext.addHeader("Accept-Encoding", "gzip");
      paramContext.addHeader("Connection", "close");
      paramContext.setHeader("Content-Type", "application/json; charset=UTF-8");
      paramString1 = paramJSONObject.toString().getBytes();
      if (paramBundle != null)
      {
        paramJSONObject = paramBundle.keySet().iterator();
        while (paramJSONObject.hasNext())
        {
          String str = (String)paramJSONObject.next();
          Object localObject = paramBundle.get(str);
          if ((localObject instanceof String)) {
            paramContext.addHeader(str, (String)localObject);
          }
        }
      }
      paramContext.setEntity(new ByteArrayEntity(paramString1));
      if (!TextUtils.isEmpty(paramString2)) {
        paramContext.getParams().setParameter("http.virtual-host", new HttpHost(paramString2));
      }
    }
    try
    {
      paramContext = paramString3.execute(paramContext);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QRHttpUtil", 2, "openRequestWithJson fail Exception", paramContext);
        return null;
        if (QLog.isColorLevel())
        {
          QLog.d("QRHttpUtil", 2, "openRequestWithJson fail OutOfMemoryError");
          return null;
        }
      }
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QRHttpUtil", 2, "openRequestWithJson fail IOException", paramContext);
      }
      return null;
    }
    catch (OutOfMemoryError paramContext)
    {
      label273:
      break label273;
    }
  }
  
  public static byte[] postUrlForByteWithJson(Context paramContext, String paramString, JSONObject paramJSONObject, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    String str1 = Uri.parse(paramString).getHost();
    try
    {
      paramJSONObject = postRequestWithJson(paramContext, paramString, null, localJSONObject, paramBundle, 15000, 30000, null);
      paramContext = paramJSONObject;
    }
    catch (IOException paramJSONObject)
    {
      if (!str1.equals(BaseQRUtil.f)) {
        break label222;
      }
    }
    String str2 = BaseQRUtil.a(paramContext, str1);
    paramJSONObject = paramString;
    if (str2 != null) {
      paramJSONObject = paramString.replace(str1, str2);
    }
    paramString = new StringBuilder();
    paramString.append("ClientProtocolException reopen: ");
    paramString.append(paramJSONObject);
    QLog.d("QRHttpUtil", 2, paramString.toString());
    paramContext = postRequestWithJson(paramContext, paramJSONObject, str1, localJSONObject, paramBundle, 15000, 30000, null);
    if (paramContext != null)
    {
      int i = paramContext.getStatusLine().getStatusCode();
      if (i == 200) {
        return readHttpResponseSteam(paramContext).toByteArray();
      }
      paramContext = new StringBuilder();
      paramContext.append("Http statusCode:");
      paramContext.append(i);
      throw new IOException(paramContext.toString());
    }
    throw new IOException("Http no response.");
    label222:
    throw paramJSONObject;
  }
  
  /* Error */
  public static com.tencent.util.Pair<Integer, String> queryImageByIP(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 77	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 858
    //   14: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 6
    //   20: aload_0
    //   21: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: ldc 226
    //   27: iconst_1
    //   28: aload 6
    //   30: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: istore 5
    //   42: aconst_null
    //   43: astore 7
    //   45: aconst_null
    //   46: astore 8
    //   48: iload 5
    //   50: ifne +862 -> 912
    //   53: aload_1
    //   54: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +855 -> 912
    //   60: aload_2
    //   61: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifeq +5 -> 69
    //   67: aconst_null
    //   68: areturn
    //   69: new 860	java/net/URL
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 861	java/net/URL:<init>	(Ljava/lang/String;)V
    //   77: invokevirtual 865	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   80: checkcast 867	javax/net/ssl/HttpsURLConnection
    //   83: astore_0
    //   84: aload_0
    //   85: astore 6
    //   87: new 869	com/tencent/biz/common/util/HttpUtil$2
    //   90: dup
    //   91: invokespecial 870	com/tencent/biz/common/util/HttpUtil$2:<init>	()V
    //   94: astore 9
    //   96: aload_0
    //   97: astore 6
    //   99: aload_0
    //   100: new 872	com/tencent/mobileqq/utils/httputils/SniSSLSocketFactory
    //   103: dup
    //   104: ldc 13
    //   106: aload 9
    //   108: invokespecial 875	com/tencent/mobileqq/utils/httputils/SniSSLSocketFactory:<init>	(Ljava/lang/String;Ljavax/net/ssl/HostnameVerifier;)V
    //   111: invokevirtual 879	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   114: aload_0
    //   115: astore 6
    //   117: aload_0
    //   118: aload 9
    //   120: invokevirtual 882	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   123: aload_0
    //   124: astore 6
    //   126: aload_0
    //   127: sipush 5000
    //   130: invokevirtual 886	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   133: aload_0
    //   134: astore 6
    //   136: aload_0
    //   137: sipush 30000
    //   140: invokevirtual 889	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   143: aload_0
    //   144: astore 6
    //   146: aload_0
    //   147: ldc 7
    //   149: invokevirtual 892	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   152: aload_0
    //   153: astore 6
    //   155: aload_0
    //   156: ldc_w 721
    //   159: ldc_w 894
    //   162: invokevirtual 897	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_0
    //   166: astore 6
    //   168: new 77	java/lang/StringBuilder
    //   171: dup
    //   172: ldc_w 899
    //   175: invokespecial 900	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: astore 9
    //   180: aload_0
    //   181: astore 6
    //   183: aload 9
    //   185: ldc_w 440
    //   188: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_0
    //   193: astore 6
    //   195: aload 9
    //   197: getstatic 438	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   200: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_0
    //   205: astore 6
    //   207: aload 9
    //   209: ldc_w 440
    //   212: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_0
    //   217: astore 6
    //   219: aload 9
    //   221: getstatic 445	android/os/Build:DEVICE	Ljava/lang/String;
    //   224: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_0
    //   229: astore 6
    //   231: aload 9
    //   233: ldc_w 440
    //   236: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_0
    //   241: astore 6
    //   243: aload 9
    //   245: getstatic 448	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   248: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_0
    //   253: astore 6
    //   255: aload 9
    //   257: ldc_w 440
    //   260: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_0
    //   265: astore 6
    //   267: aload 9
    //   269: ldc_w 902
    //   272: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_0
    //   277: astore 6
    //   279: aload_0
    //   280: ldc_w 904
    //   283: aload 9
    //   285: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokevirtual 897	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload_0
    //   292: astore 6
    //   294: aload_0
    //   295: ldc_w 336
    //   298: ldc_w 906
    //   301: invokevirtual 897	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_0
    //   305: astore 6
    //   307: aload_0
    //   308: ldc_w 908
    //   311: ldc 13
    //   313: invokevirtual 897	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_0
    //   317: astore 6
    //   319: invokestatic 59	com/tencent/biz/common/util/HttpUtil:getRunTime	()Lmqq/app/AppRuntime;
    //   322: iconst_2
    //   323: invokevirtual 69	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   326: checkcast 71	mqq/manager/TicketManager
    //   329: aload_1
    //   330: ldc 13
    //   332: invokeinterface 330 3 0
    //   337: astore 9
    //   339: aload_0
    //   340: astore 6
    //   342: aload 9
    //   344: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   347: istore 5
    //   349: iload 5
    //   351: ifne +72 -> 423
    //   354: aload_0
    //   355: astore 6
    //   357: new 77	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   364: astore_2
    //   365: aload_0
    //   366: astore 6
    //   368: aload_2
    //   369: ldc_w 332
    //   372: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_0
    //   377: astore 6
    //   379: aload_2
    //   380: aload_1
    //   381: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_0
    //   386: astore 6
    //   388: aload_2
    //   389: ldc_w 334
    //   392: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_0
    //   397: astore 6
    //   399: aload_2
    //   400: aload 9
    //   402: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_0
    //   407: astore 6
    //   409: aload_0
    //   410: ldc_w 910
    //   413: aload_2
    //   414: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokevirtual 897	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: goto +72 -> 492
    //   423: aload_0
    //   424: astore 6
    //   426: new 77	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   433: astore 9
    //   435: aload_0
    //   436: astore 6
    //   438: aload 9
    //   440: ldc 80
    //   442: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload_0
    //   447: astore 6
    //   449: aload 9
    //   451: aload_1
    //   452: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload_0
    //   457: astore 6
    //   459: aload 9
    //   461: ldc 86
    //   463: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload_0
    //   468: astore 6
    //   470: aload 9
    //   472: aload_2
    //   473: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload_0
    //   478: astore 6
    //   480: aload_0
    //   481: ldc_w 910
    //   484: aload 9
    //   486: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokevirtual 897	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: aload_0
    //   493: astore 6
    //   495: aload_0
    //   496: invokevirtual 913	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   499: istore_3
    //   500: iload_3
    //   501: sipush 200
    //   504: if_icmpeq +74 -> 578
    //   507: aload_0
    //   508: astore 6
    //   510: new 77	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   517: astore_1
    //   518: aload_0
    //   519: astore 6
    //   521: aload_1
    //   522: ldc_w 915
    //   525: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload_0
    //   530: astore 6
    //   532: aload_1
    //   533: iload_3
    //   534: invokevirtual 822	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload_0
    //   539: astore 6
    //   541: ldc 226
    //   543: iconst_1
    //   544: aload_1
    //   545: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: aload_0
    //   552: astore 6
    //   554: new 917	com/tencent/util/Pair
    //   557: dup
    //   558: iload_3
    //   559: invokestatic 920	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   562: ldc 239
    //   564: invokespecial 923	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   567: astore_1
    //   568: aload_0
    //   569: ifnull +7 -> 576
    //   572: aload_0
    //   573: invokevirtual 926	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   576: aload_1
    //   577: areturn
    //   578: aload_0
    //   579: astore 6
    //   581: new 77	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   588: astore_1
    //   589: aload_0
    //   590: astore 6
    //   592: new 928	java/io/BufferedReader
    //   595: dup
    //   596: new 930	java/io/InputStreamReader
    //   599: dup
    //   600: aload_0
    //   601: invokevirtual 934	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   604: invokespecial 937	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   607: invokespecial 940	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   610: astore_2
    //   611: aload_0
    //   612: astore 6
    //   614: aload_2
    //   615: invokevirtual 943	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   618: astore 9
    //   620: aload 9
    //   622: ifnull +27 -> 649
    //   625: aload_0
    //   626: astore 6
    //   628: aload_1
    //   629: aload 9
    //   631: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload_0
    //   636: astore 6
    //   638: aload_1
    //   639: ldc_w 945
    //   642: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: goto -35 -> 611
    //   649: aload_0
    //   650: astore 6
    //   652: aload_2
    //   653: invokevirtual 947	java/io/BufferedReader:close	()V
    //   656: aload_0
    //   657: astore 6
    //   659: aload_1
    //   660: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: astore_1
    //   664: aload_0
    //   665: astore 6
    //   667: aload_1
    //   668: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   671: ifne +114 -> 785
    //   674: aload_0
    //   675: astore 6
    //   677: new 159	org/json/JSONObject
    //   680: dup
    //   681: aload_1
    //   682: invokespecial 162	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   685: astore_1
    //   686: aload_0
    //   687: astore 6
    //   689: aload_1
    //   690: ldc 164
    //   692: invokevirtual 168	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   695: istore_3
    //   696: iload_3
    //   697: ifne +34 -> 731
    //   700: aload_0
    //   701: astore 6
    //   703: aload_1
    //   704: ldc 174
    //   706: invokevirtual 950	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   709: ifeq +22 -> 731
    //   712: aload_0
    //   713: astore 6
    //   715: aload_1
    //   716: ldc 174
    //   718: invokevirtual 178	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   721: ldc_w 952
    //   724: invokevirtual 953	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   727: astore_1
    //   728: goto +62 -> 790
    //   731: aload_0
    //   732: astore 6
    //   734: new 77	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   741: astore_1
    //   742: aload_0
    //   743: astore 6
    //   745: aload_1
    //   746: ldc_w 955
    //   749: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: pop
    //   753: aload_0
    //   754: astore 6
    //   756: aload_1
    //   757: iload_3
    //   758: invokevirtual 822	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload_0
    //   763: astore 6
    //   765: ldc 226
    //   767: iconst_1
    //   768: aload_1
    //   769: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: aload 8
    //   777: astore_1
    //   778: goto +12 -> 790
    //   781: astore_1
    //   782: goto +45 -> 827
    //   785: iconst_1
    //   786: istore_3
    //   787: aload 8
    //   789: astore_1
    //   790: aload_1
    //   791: astore_2
    //   792: iload_3
    //   793: istore 4
    //   795: aload_0
    //   796: ifnull +89 -> 885
    //   799: aload_0
    //   800: invokevirtual 926	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   803: aload_1
    //   804: astore_2
    //   805: iload_3
    //   806: istore 4
    //   808: goto +77 -> 885
    //   811: astore_1
    //   812: goto +13 -> 825
    //   815: astore_0
    //   816: aconst_null
    //   817: astore 6
    //   819: goto +81 -> 900
    //   822: astore_1
    //   823: aconst_null
    //   824: astore_0
    //   825: iconst_1
    //   826: istore_3
    //   827: aload_0
    //   828: astore 6
    //   830: new 77	java/lang/StringBuilder
    //   833: dup
    //   834: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   837: astore_2
    //   838: aload_0
    //   839: astore 6
    //   841: aload_2
    //   842: ldc_w 957
    //   845: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: pop
    //   849: aload_0
    //   850: astore 6
    //   852: aload_2
    //   853: aload_1
    //   854: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload_0
    //   859: astore 6
    //   861: ldc 226
    //   863: iconst_1
    //   864: aload_2
    //   865: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   871: aload_0
    //   872: ifnull +7 -> 879
    //   875: aload_0
    //   876: invokevirtual 926	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   879: iload_3
    //   880: istore 4
    //   882: aload 7
    //   884: astore_2
    //   885: new 917	com/tencent/util/Pair
    //   888: dup
    //   889: iload 4
    //   891: invokestatic 920	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   894: aload_2
    //   895: invokespecial 923	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   898: areturn
    //   899: astore_0
    //   900: aload 6
    //   902: ifnull +8 -> 910
    //   905: aload 6
    //   907: invokevirtual 926	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   910: aload_0
    //   911: athrow
    //   912: aconst_null
    //   913: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	914	0	paramString1	String
    //   0	914	1	paramString2	String
    //   0	914	2	paramString3	String
    //   499	381	3	i	int
    //   793	97	4	j	int
    //   40	310	5	bool	boolean
    //   7	899	6	localObject1	Object
    //   43	840	7	localObject2	Object
    //   46	742	8	localObject3	Object
    //   94	536	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   703	712	781	java/lang/Exception
    //   715	728	781	java/lang/Exception
    //   734	742	781	java/lang/Exception
    //   745	753	781	java/lang/Exception
    //   756	762	781	java/lang/Exception
    //   765	775	781	java/lang/Exception
    //   87	96	811	java/lang/Exception
    //   99	114	811	java/lang/Exception
    //   117	123	811	java/lang/Exception
    //   126	133	811	java/lang/Exception
    //   136	143	811	java/lang/Exception
    //   146	152	811	java/lang/Exception
    //   155	165	811	java/lang/Exception
    //   168	180	811	java/lang/Exception
    //   183	192	811	java/lang/Exception
    //   195	204	811	java/lang/Exception
    //   207	216	811	java/lang/Exception
    //   219	228	811	java/lang/Exception
    //   231	240	811	java/lang/Exception
    //   243	252	811	java/lang/Exception
    //   255	264	811	java/lang/Exception
    //   267	276	811	java/lang/Exception
    //   279	291	811	java/lang/Exception
    //   294	304	811	java/lang/Exception
    //   307	316	811	java/lang/Exception
    //   319	339	811	java/lang/Exception
    //   342	349	811	java/lang/Exception
    //   357	365	811	java/lang/Exception
    //   368	376	811	java/lang/Exception
    //   379	385	811	java/lang/Exception
    //   388	396	811	java/lang/Exception
    //   399	406	811	java/lang/Exception
    //   409	420	811	java/lang/Exception
    //   426	435	811	java/lang/Exception
    //   438	446	811	java/lang/Exception
    //   449	456	811	java/lang/Exception
    //   459	467	811	java/lang/Exception
    //   470	477	811	java/lang/Exception
    //   480	492	811	java/lang/Exception
    //   495	500	811	java/lang/Exception
    //   510	518	811	java/lang/Exception
    //   521	529	811	java/lang/Exception
    //   532	538	811	java/lang/Exception
    //   541	551	811	java/lang/Exception
    //   554	568	811	java/lang/Exception
    //   581	589	811	java/lang/Exception
    //   592	611	811	java/lang/Exception
    //   614	620	811	java/lang/Exception
    //   628	635	811	java/lang/Exception
    //   638	646	811	java/lang/Exception
    //   652	656	811	java/lang/Exception
    //   659	664	811	java/lang/Exception
    //   667	674	811	java/lang/Exception
    //   677	686	811	java/lang/Exception
    //   689	696	811	java/lang/Exception
    //   69	84	815	finally
    //   69	84	822	java/lang/Exception
    //   87	96	899	finally
    //   99	114	899	finally
    //   117	123	899	finally
    //   126	133	899	finally
    //   136	143	899	finally
    //   146	152	899	finally
    //   155	165	899	finally
    //   168	180	899	finally
    //   183	192	899	finally
    //   195	204	899	finally
    //   207	216	899	finally
    //   219	228	899	finally
    //   231	240	899	finally
    //   243	252	899	finally
    //   255	264	899	finally
    //   267	276	899	finally
    //   279	291	899	finally
    //   294	304	899	finally
    //   307	316	899	finally
    //   319	339	899	finally
    //   342	349	899	finally
    //   357	365	899	finally
    //   368	376	899	finally
    //   379	385	899	finally
    //   388	396	899	finally
    //   399	406	899	finally
    //   409	420	899	finally
    //   426	435	899	finally
    //   438	446	899	finally
    //   449	456	899	finally
    //   459	467	899	finally
    //   470	477	899	finally
    //   480	492	899	finally
    //   495	500	899	finally
    //   510	518	899	finally
    //   521	529	899	finally
    //   532	538	899	finally
    //   541	551	899	finally
    //   554	568	899	finally
    //   581	589	899	finally
    //   592	611	899	finally
    //   614	620	899	finally
    //   628	635	899	finally
    //   638	646	899	finally
    //   652	656	899	finally
    //   659	664	899	finally
    //   667	674	899	finally
    //   677	686	899	finally
    //   689	696	899	finally
    //   703	712	899	finally
    //   715	728	899	finally
    //   734	742	899	finally
    //   745	753	899	finally
    //   756	762	899	finally
    //   765	775	899	finally
    //   830	838	899	finally
    //   841	849	899	finally
    //   852	858	899	finally
    //   861	871	899	finally
  }
  
  public static String readHttpResponse(HttpResponse paramHttpResponse)
  {
    return new String(readHttpResponseSteam(paramHttpResponse).toByteArray());
  }
  
  /* Error */
  public static ByteArrayOutputStream readHttpResponseSteam(HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 963 1 0
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_2
    //   15: aload 5
    //   17: invokeinterface 968 1 0
    //   22: astore 5
    //   24: aload 5
    //   26: astore_2
    //   27: aload 5
    //   29: astore_3
    //   30: aload 5
    //   32: astore 4
    //   34: new 833	java/io/ByteArrayOutputStream
    //   37: dup
    //   38: invokespecial 969	java/io/ByteArrayOutputStream:<init>	()V
    //   41: astore 6
    //   43: aload 5
    //   45: astore_2
    //   46: aload 5
    //   48: astore_3
    //   49: aload 5
    //   51: astore 4
    //   53: aload_0
    //   54: ldc_w 971
    //   57: invokeinterface 975 2 0
    //   62: astore 7
    //   64: aload 5
    //   66: astore_0
    //   67: aload 7
    //   69: ifnull +55 -> 124
    //   72: aload 5
    //   74: astore_0
    //   75: aload 5
    //   77: astore_2
    //   78: aload 5
    //   80: astore_3
    //   81: aload 5
    //   83: astore 4
    //   85: aload 7
    //   87: invokeinterface 980 1 0
    //   92: invokevirtual 983	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   95: ldc_w 714
    //   98: invokevirtual 690	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +23 -> 124
    //   104: aload 5
    //   106: astore_2
    //   107: aload 5
    //   109: astore_3
    //   110: aload 5
    //   112: astore 4
    //   114: new 985	java/util/zip/GZIPInputStream
    //   117: dup
    //   118: aload 5
    //   120: invokespecial 986	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   123: astore_0
    //   124: aload_0
    //   125: astore_2
    //   126: aload_0
    //   127: astore_3
    //   128: aload_0
    //   129: astore 4
    //   131: sipush 512
    //   134: newarray byte
    //   136: astore 5
    //   138: aload_0
    //   139: astore_2
    //   140: aload_0
    //   141: astore_3
    //   142: aload_0
    //   143: astore 4
    //   145: aload_0
    //   146: aload 5
    //   148: invokevirtual 992	java/io/InputStream:read	([B)I
    //   151: istore_1
    //   152: iload_1
    //   153: iconst_m1
    //   154: if_icmpeq +22 -> 176
    //   157: aload_0
    //   158: astore_2
    //   159: aload_0
    //   160: astore_3
    //   161: aload_0
    //   162: astore 4
    //   164: aload 6
    //   166: aload 5
    //   168: iconst_0
    //   169: iload_1
    //   170: invokevirtual 996	java/io/ByteArrayOutputStream:write	([BII)V
    //   173: goto -35 -> 138
    //   176: aload_0
    //   177: ifnull +7 -> 184
    //   180: aload_0
    //   181: invokevirtual 997	java/io/InputStream:close	()V
    //   184: aload 6
    //   186: areturn
    //   187: astore_0
    //   188: goto +19 -> 207
    //   191: aload 4
    //   193: astore_2
    //   194: new 323	java/io/IOException
    //   197: dup
    //   198: invokespecial 998	java/io/IOException:<init>	()V
    //   201: athrow
    //   202: astore_0
    //   203: aload_3
    //   204: astore_2
    //   205: aload_0
    //   206: athrow
    //   207: aload_2
    //   208: ifnull +7 -> 215
    //   211: aload_2
    //   212: invokevirtual 997	java/io/InputStream:close	()V
    //   215: goto +5 -> 220
    //   218: aload_0
    //   219: athrow
    //   220: goto -2 -> 218
    //   223: astore_0
    //   224: goto -33 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramHttpResponse	HttpResponse
    //   151	19	1	i	int
    //   14	198	2	localObject1	Object
    //   9	195	3	localObject2	Object
    //   11	181	4	localObject3	Object
    //   6	161	5	localObject4	Object
    //   41	144	6	localByteArrayOutputStream	ByteArrayOutputStream
    //   62	24	7	localHeader	org.apache.http.Header
    // Exception table:
    //   from	to	target	type
    //   15	24	187	finally
    //   34	43	187	finally
    //   53	64	187	finally
    //   85	104	187	finally
    //   114	124	187	finally
    //   131	138	187	finally
    //   145	152	187	finally
    //   164	173	187	finally
    //   194	202	187	finally
    //   205	207	187	finally
    //   15	24	202	java/io/IOException
    //   34	43	202	java/io/IOException
    //   53	64	202	java/io/IOException
    //   85	104	202	java/io/IOException
    //   114	124	202	java/io/IOException
    //   131	138	202	java/io/IOException
    //   145	152	202	java/io/IOException
    //   164	173	202	java/io/IOException
    //   15	24	223	java/lang/Exception
    //   34	43	223	java/lang/Exception
    //   53	64	223	java/lang/Exception
    //   85	104	223	java/lang/Exception
    //   114	124	223	java/lang/Exception
    //   131	138	223	java/lang/Exception
    //   145	152	223	java/lang/Exception
    //   164	173	223	java/lang/Exception
  }
  
  public static String removeHtmlTags(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject1 = new String[27];
    int i = 0;
    localObject1[0] = "li";
    localObject1[1] = "del";
    localObject1[2] = "ins";
    localObject1[3] = "fieldset";
    localObject1[4] = "legend";
    localObject1[5] = "tr";
    localObject1[6] = "th";
    localObject1[7] = "caption";
    localObject1[8] = "thead";
    localObject1[9] = "tbody";
    localObject1[10] = "tfoot";
    localObject1[11] = "p";
    localObject1[12] = "h[1-6]";
    localObject1[13] = "dl";
    localObject1[14] = "dt";
    localObject1[15] = "dd";
    localObject1[16] = "ol";
    localObject1[17] = "ul";
    localObject1[18] = "dir";
    localObject1[19] = "address";
    localObject1[20] = "blockquote";
    localObject1[21] = "center";
    localObject1[22] = "hr";
    localObject1[23] = "pre";
    localObject1[24] = "form";
    localObject1[25] = "textarea";
    localObject1[26] = "table";
    int j = localObject1.length;
    while (i < j)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<(\\s*");
      ((StringBuilder)localObject2).append(localObject1[i]);
      ((StringBuilder)localObject2).append(")[^>]*>");
      localObject2 = Pattern.compile(((StringBuilder)localObject2).toString()).matcher(paramString);
      if (((Matcher)localObject2).find()) {
        paramString = ((Matcher)localObject2).replaceAll(" ");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("</?(\\s*");
      ((StringBuilder)localObject2).append(localObject1[i]);
      ((StringBuilder)localObject2).append(")[^>]*>");
      localObject2 = Pattern.compile(((StringBuilder)localObject2).toString()).matcher(paramString);
      if (((Matcher)localObject2).find()) {
        paramString = ((Matcher)localObject2).replaceAll("\n");
      }
      i += 1;
    }
    localObject1 = Pattern.compile("<br>").matcher(paramString);
    if (((Matcher)localObject1).find()) {
      paramString = ((Matcher)localObject1).replaceAll("\n");
    }
    return paramString.replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
  }
  
  public static final HashMap<String, String> shortenUrlBatch(HashMap<String, String> paramHashMap)
  {
    return shortenUrlBatch(paramHashMap, null);
  }
  
  public static final HashMap<String, String> shortenUrlBatch(HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    if (paramHashMap == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap(paramHashMap);
    Object localObject1 = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = (String)paramHashMap.get(localObject3);
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        ((JSONArray)localObject1).put(localObject4);
        localArrayList.add(localObject3);
      }
    }
    Object localObject3 = new Bundle();
    localObject2 = getAccount();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      Object localObject5 = (TicketManager)getRunTime().getManager(2);
      localObject4 = ((TicketManager)localObject5).getPskey((String)localObject2, "openmobile.qq.com");
      localObject5 = ((TicketManager)localObject5).getSkey((String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("p_uin=");
        ((StringBuilder)localObject5).append((String)localObject2);
        ((StringBuilder)localObject5).append(";p_skey=");
        ((StringBuilder)localObject5).append((String)localObject4);
        ((Bundle)localObject3).putString("cookie", ((StringBuilder)localObject5).toString());
      }
      else
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("uin=");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append(";skey=");
        ((StringBuilder)localObject4).append((String)localObject5);
        ((Bundle)localObject3).putString("cookie", ((StringBuilder)localObject4).toString());
      }
    }
    ((Bundle)localObject3).putString("Referer", "http://openmobile.qq.com/");
    Object localObject4 = new Bundle();
    ((Bundle)localObject4).putString("value", ((JSONArray)localObject1).toString());
    ((Bundle)localObject4).putString("mType", "qb_share");
    localObject2 = null;
    try
    {
      localObject1 = openUrl(BaseApplication.getContext(), MsfSdkUtils.insertMtype("AppDepart", "https://openmobile.qq.com/api/shortUrl"), "POST", (Bundle)localObject4, (Bundle)localObject3);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("HttpUtil", 2, localOutOfMemoryError.getMessage());
        localObject1 = localObject2;
      }
    }
    catch (IOException localIOException)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("HttpUtil", 2, localIOException.getMessage());
        localObject1 = localObject2;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return localHashMap;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        i = ((JSONObject)localObject1).getInt("retcode");
        if (paramBundle != null) {
          paramBundle.putInt("retcode", i);
        }
        if (i != 0)
        {
          if (!QLog.isColorLevel()) {
            break label696;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("shortenUrl error retcode:");
          paramBundle.append(i);
          QLog.d("HttpUtil", 2, paramBundle.toString());
          return localHashMap;
        }
        paramBundle = ((JSONObject)localObject1).getJSONObject("result");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label699;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          return localHashMap;
        }
        paramBundle = paramBundle.getJSONArray("list");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label702;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          return localHashMap;
        }
        if (paramBundle.length() == localArrayList.size())
        {
          i = 0;
          if (i < paramBundle.length())
          {
            localObject1 = paramBundle.getString(i);
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label705;
            }
            localHashMap.put(localArrayList.get(i), localObject1);
            break label705;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("HttpUtil", 2, "shortenUrl error result size");
        }
      }
      catch (JSONException paramBundle)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HttpUtil", 2, "shortenUrl parse response error");
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("shortenUrl results: ");
        paramBundle.append(localHashMap.toString());
        paramBundle.append(", input: ");
        paramBundle.append(paramHashMap);
        QLog.d("HttpUtil", 2, paramBundle.toString());
      }
      return localHashMap;
      label696:
      return localHashMap;
      label699:
      return localHashMap;
      label702:
      return localHashMap;
      label705:
      i += 1;
    }
  }
  
  private static String truncateUrlPage(String paramString)
  {
    paramString = paramString.trim();
    String[] arrayOfString = paramString.split("[?]");
    if ((paramString.length() > 1) && (arrayOfString.length > 1) && (arrayOfString[1] != null)) {
      return arrayOfString[1];
    }
    return null;
  }
  
  public static String unEscape(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
  }
  
  /* Error */
  public static final String uploadImage(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +141 -> 145
    //   7: aload_2
    //   8: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +134 -> 145
    //   14: aload_0
    //   15: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +6 -> 24
    //   21: goto +124 -> 145
    //   24: aload_0
    //   25: ldc_w 1127
    //   28: invokevirtual 647	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   31: istore 6
    //   33: new 860	java/net/URL
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 861	java/net/URL:<init>	(Ljava/lang/String;)V
    //   41: invokevirtual 865	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   44: checkcast 1129	java/net/HttpURLConnection
    //   47: astore 7
    //   49: aload 7
    //   51: aload_0
    //   52: aload_1
    //   53: aload_2
    //   54: aload_3
    //   55: aload 4
    //   57: aload 5
    //   59: iload 6
    //   61: invokestatic 1132	com/tencent/biz/common/util/HttpUtil:uploadImage	(Ljava/net/HttpURLConnection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Z)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: goto +12 -> 80
    //   71: astore_1
    //   72: goto +4 -> 76
    //   75: astore_1
    //   76: goto +37 -> 113
    //   79: astore_1
    //   80: ldc 226
    //   82: iconst_1
    //   83: iconst_4
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: ldc_w 1134
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: aload_0
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: ldc_w 1136
    //   102: aastore
    //   103: dup
    //   104: iconst_3
    //   105: aload_1
    //   106: aastore
    //   107: invokestatic 1139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_2
    //   113: ldc 226
    //   115: iconst_1
    //   116: iconst_4
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: ldc_w 1134
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: aload_0
    //   129: aastore
    //   130: dup
    //   131: iconst_2
    //   132: ldc_w 1141
    //   135: aastore
    //   136: dup
    //   137: iconst_3
    //   138: aload_1
    //   139: aastore
    //   140: invokestatic 1139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   143: aconst_null
    //   144: areturn
    //   145: ldc 226
    //   147: iconst_1
    //   148: ldc_w 1143
    //   151: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aconst_null
    //   155: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString1	String
    //   0	156	1	paramString2	String
    //   0	156	2	paramString3	String
    //   0	156	3	paramMap1	Map<String, String>
    //   0	156	4	paramMap2	Map<String, String>
    //   0	156	5	paramMap3	Map<String, String>
    //   31	29	6	bool	boolean
    //   47	3	7	localHttpURLConnection	java.net.HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   49	65	67	java/io/IOException
    //   49	65	71	java/net/MalformedURLException
    //   33	49	75	java/net/MalformedURLException
    //   33	49	79	java/io/IOException
  }
  
  /* Error */
  public static final String uploadImage(java.net.HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 9
    //   3: ldc_w 1146
    //   6: astore 11
    //   8: aload 9
    //   10: astore 10
    //   12: aload 9
    //   14: sipush 5000
    //   17: invokevirtual 1147	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   20: aload 9
    //   22: astore 10
    //   24: aload 9
    //   26: sipush 30000
    //   29: invokevirtual 1148	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   32: aload 9
    //   34: astore 10
    //   36: aload 9
    //   38: iconst_1
    //   39: invokevirtual 1152	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   42: aload 9
    //   44: astore 10
    //   46: aload 9
    //   48: iconst_1
    //   49: invokevirtual 1155	java/net/HttpURLConnection:setDoInput	(Z)V
    //   52: aload 9
    //   54: astore 10
    //   56: aload 9
    //   58: iconst_0
    //   59: invokevirtual 1158	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   62: aload 9
    //   64: astore 10
    //   66: aload 9
    //   68: ldc 21
    //   70: invokevirtual 1159	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   73: aload 9
    //   75: astore 10
    //   77: aload 9
    //   79: ldc_w 721
    //   82: ldc_w 894
    //   85: invokevirtual 1160	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 9
    //   90: astore 10
    //   92: new 77	java/lang/StringBuilder
    //   95: dup
    //   96: ldc_w 899
    //   99: invokespecial 900	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   102: astore 12
    //   104: aload 9
    //   106: astore 10
    //   108: aload 12
    //   110: ldc_w 440
    //   113: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 9
    //   119: astore 10
    //   121: aload 12
    //   123: getstatic 438	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   126: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 9
    //   132: astore 10
    //   134: aload 12
    //   136: ldc_w 440
    //   139: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 9
    //   145: astore 10
    //   147: aload 12
    //   149: getstatic 445	android/os/Build:DEVICE	Ljava/lang/String;
    //   152: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 9
    //   158: astore 10
    //   160: aload 12
    //   162: ldc_w 440
    //   165: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 9
    //   171: astore 10
    //   173: aload 12
    //   175: getstatic 448	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   178: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 9
    //   184: astore 10
    //   186: aload 12
    //   188: ldc_w 440
    //   191: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 9
    //   197: astore 10
    //   199: aload 12
    //   201: ldc_w 902
    //   204: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 9
    //   210: astore 10
    //   212: aload 9
    //   214: ldc_w 904
    //   217: aload 12
    //   219: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokevirtual 1160	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload 9
    //   227: astore 10
    //   229: new 77	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   236: astore 12
    //   238: aload 9
    //   240: astore 10
    //   242: aload 12
    //   244: ldc_w 1162
    //   247: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 9
    //   253: astore 10
    //   255: aload 12
    //   257: ldc_w 1164
    //   260: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 9
    //   266: astore 10
    //   268: aload 9
    //   270: ldc_w 732
    //   273: aload 12
    //   275: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokevirtual 1160	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload 6
    //   283: ifnonnull +25 -> 308
    //   286: aload 9
    //   288: astore 10
    //   290: new 103	java/util/HashMap
    //   293: dup
    //   294: invokespecial 104	java/util/HashMap:<init>	()V
    //   297: astore 6
    //   299: goto +9 -> 308
    //   302: astore_2
    //   303: aconst_null
    //   304: astore_0
    //   305: goto +1401 -> 1706
    //   308: iload 7
    //   310: ifeq +121 -> 431
    //   313: aload 9
    //   315: astore 10
    //   317: invokestatic 59	com/tencent/biz/common/util/HttpUtil:getRunTime	()Lmqq/app/AppRuntime;
    //   320: iconst_2
    //   321: invokevirtual 69	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   324: checkcast 71	mqq/manager/TicketManager
    //   327: aload_2
    //   328: ldc 13
    //   330: invokeinterface 330 3 0
    //   335: astore 12
    //   337: aload 9
    //   339: astore 10
    //   341: aload 12
    //   343: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   346: ifne +85 -> 431
    //   349: aload 9
    //   351: astore 10
    //   353: new 77	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   360: astore 13
    //   362: aload 9
    //   364: astore 10
    //   366: aload 13
    //   368: ldc_w 332
    //   371: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload 9
    //   377: astore 10
    //   379: aload 13
    //   381: aload_2
    //   382: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 9
    //   388: astore 10
    //   390: aload 13
    //   392: ldc_w 334
    //   395: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 9
    //   401: astore 10
    //   403: aload 13
    //   405: aload 12
    //   407: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 9
    //   413: astore 10
    //   415: aload 6
    //   417: ldc_w 910
    //   420: aload 13
    //   422: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokeinterface 1165 3 0
    //   430: pop
    //   431: aload 9
    //   433: astore 10
    //   435: aload 6
    //   437: ldc_w 910
    //   440: invokeinterface 1168 2 0
    //   445: istore 7
    //   447: iload 7
    //   449: ifne +82 -> 531
    //   452: aload 9
    //   454: astore 10
    //   456: new 77	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   463: astore 12
    //   465: aload 9
    //   467: astore 10
    //   469: aload 12
    //   471: ldc 80
    //   473: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 9
    //   479: astore 10
    //   481: aload 12
    //   483: aload_2
    //   484: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload 9
    //   490: astore 10
    //   492: aload 12
    //   494: ldc 86
    //   496: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 9
    //   502: astore 10
    //   504: aload 12
    //   506: aload_3
    //   507: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 9
    //   513: astore 10
    //   515: aload 6
    //   517: ldc_w 910
    //   520: aload 12
    //   522: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokeinterface 1165 3 0
    //   530: pop
    //   531: aload 9
    //   533: astore 10
    //   535: aload 6
    //   537: invokeinterface 1171 1 0
    //   542: invokeinterface 123 1 0
    //   547: astore_2
    //   548: aload 9
    //   550: astore 10
    //   552: aload_2
    //   553: invokeinterface 129 1 0
    //   558: istore 7
    //   560: iload 7
    //   562: ifeq +47 -> 609
    //   565: aload 9
    //   567: astore 10
    //   569: aload_2
    //   570: invokeinterface 133 1 0
    //   575: checkcast 1173	java/util/Map$Entry
    //   578: astore_3
    //   579: aload 9
    //   581: astore 10
    //   583: aload 9
    //   585: aload_3
    //   586: invokeinterface 1176 1 0
    //   591: checkcast 135	java/lang/String
    //   594: aload_3
    //   595: invokeinterface 1178 1 0
    //   600: checkcast 135	java/lang/String
    //   603: invokevirtual 1160	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   606: goto -58 -> 548
    //   609: aload 9
    //   611: astore 10
    //   613: new 1180	java/io/DataOutputStream
    //   616: dup
    //   617: aload_0
    //   618: invokevirtual 1184	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   621: invokespecial 1187	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   624: astore 6
    //   626: aload 4
    //   628: ifnull +243 -> 871
    //   631: aload 9
    //   633: astore 10
    //   635: new 1189	java/lang/StringBuffer
    //   638: dup
    //   639: invokespecial 1190	java/lang/StringBuffer:<init>	()V
    //   642: astore_2
    //   643: aload 9
    //   645: astore 10
    //   647: aload 4
    //   649: invokeinterface 1171 1 0
    //   654: invokeinterface 123 1 0
    //   659: astore_3
    //   660: aload 9
    //   662: astore 10
    //   664: aload_3
    //   665: invokeinterface 129 1 0
    //   670: ifeq +185 -> 855
    //   673: aload 9
    //   675: astore 10
    //   677: aload_3
    //   678: invokeinterface 133 1 0
    //   683: checkcast 1173	java/util/Map$Entry
    //   686: astore 12
    //   688: aload 9
    //   690: astore 10
    //   692: aload 12
    //   694: invokeinterface 1176 1 0
    //   699: checkcast 135	java/lang/String
    //   702: astore 4
    //   704: aload 9
    //   706: astore 10
    //   708: aload 12
    //   710: invokeinterface 1178 1 0
    //   715: checkcast 135	java/lang/String
    //   718: astore 12
    //   720: aload 12
    //   722: ifnonnull +6 -> 728
    //   725: goto -65 -> 660
    //   728: aload 9
    //   730: astore 10
    //   732: aload_2
    //   733: ldc_w 1192
    //   736: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   739: pop
    //   740: aload 9
    //   742: astore 10
    //   744: aload_2
    //   745: ldc_w 1197
    //   748: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   751: pop
    //   752: aload 9
    //   754: astore 10
    //   756: aload_2
    //   757: ldc_w 1164
    //   760: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   763: pop
    //   764: aload 9
    //   766: astore 10
    //   768: aload_2
    //   769: ldc_w 1192
    //   772: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   775: pop
    //   776: aload 9
    //   778: astore 10
    //   780: new 77	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   787: astore 13
    //   789: aload 9
    //   791: astore 10
    //   793: aload 13
    //   795: ldc_w 1199
    //   798: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: aload 9
    //   804: astore 10
    //   806: aload 13
    //   808: aload 4
    //   810: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: pop
    //   814: aload 9
    //   816: astore 10
    //   818: aload 13
    //   820: ldc_w 1201
    //   823: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload 9
    //   829: astore 10
    //   831: aload_2
    //   832: aload 13
    //   834: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   840: pop
    //   841: aload 9
    //   843: astore 10
    //   845: aload_2
    //   846: aload 12
    //   848: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   851: pop
    //   852: goto -192 -> 660
    //   855: aload 9
    //   857: astore 10
    //   859: aload 6
    //   861: aload_2
    //   862: invokevirtual 1202	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   865: invokevirtual 761	java/lang/String:getBytes	()[B
    //   868: invokevirtual 1206	java/io/OutputStream:write	([B)V
    //   871: aload 5
    //   873: ifnull +563 -> 1436
    //   876: aload 9
    //   878: astore 10
    //   880: aload 5
    //   882: invokeinterface 1171 1 0
    //   887: invokeinterface 123 1 0
    //   892: astore 4
    //   894: aload 11
    //   896: astore_2
    //   897: aload 9
    //   899: astore 10
    //   901: aload 4
    //   903: invokeinterface 129 1 0
    //   908: ifeq +528 -> 1436
    //   911: aload 9
    //   913: astore 10
    //   915: aload 4
    //   917: invokeinterface 133 1 0
    //   922: checkcast 1173	java/util/Map$Entry
    //   925: astore_3
    //   926: aload 9
    //   928: astore 10
    //   930: aload_3
    //   931: invokeinterface 1176 1 0
    //   936: checkcast 135	java/lang/String
    //   939: astore 11
    //   941: aload 9
    //   943: astore 10
    //   945: aload_3
    //   946: invokeinterface 1178 1 0
    //   951: checkcast 135	java/lang/String
    //   954: astore_3
    //   955: aload_3
    //   956: ifnonnull +6 -> 962
    //   959: goto -62 -> 897
    //   962: aload 9
    //   964: astore 10
    //   966: new 1208	java/io/File
    //   969: dup
    //   970: aload_3
    //   971: invokespecial 1209	java/io/File:<init>	(Ljava/lang/String;)V
    //   974: astore 5
    //   976: aload 9
    //   978: astore 10
    //   980: aload 5
    //   982: invokevirtual 1212	java/io/File:getName	()Ljava/lang/String;
    //   985: astore 12
    //   987: aload 9
    //   989: astore 10
    //   991: aload 12
    //   993: ldc_w 1214
    //   996: invokevirtual 1217	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   999: pop
    //   1000: aload 9
    //   1002: astore 10
    //   1004: aload_2
    //   1005: ldc 239
    //   1007: invokevirtual 703	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1010: istore 7
    //   1012: iload 7
    //   1014: ifeq +10 -> 1024
    //   1017: ldc_w 1219
    //   1020: astore_3
    //   1021: goto +5 -> 1026
    //   1024: aload_2
    //   1025: astore_3
    //   1026: aload 9
    //   1028: astore 10
    //   1030: new 1189	java/lang/StringBuffer
    //   1033: dup
    //   1034: invokespecial 1190	java/lang/StringBuffer:<init>	()V
    //   1037: astore 13
    //   1039: aload 9
    //   1041: astore 10
    //   1043: aload 13
    //   1045: ldc_w 1192
    //   1048: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1051: pop
    //   1052: aload 9
    //   1054: astore 10
    //   1056: aload 13
    //   1058: ldc_w 1197
    //   1061: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1064: pop
    //   1065: aload 9
    //   1067: astore 10
    //   1069: aload 13
    //   1071: ldc_w 1164
    //   1074: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1077: pop
    //   1078: aload 9
    //   1080: astore 10
    //   1082: aload 13
    //   1084: ldc_w 1192
    //   1087: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1090: pop
    //   1091: aload 9
    //   1093: astore 10
    //   1095: new 77	java/lang/StringBuilder
    //   1098: dup
    //   1099: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1102: astore 14
    //   1104: aload 9
    //   1106: astore 10
    //   1108: aload 14
    //   1110: ldc_w 1199
    //   1113: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: pop
    //   1117: aload 9
    //   1119: astore 10
    //   1121: aload 14
    //   1123: aload 11
    //   1125: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1128: pop
    //   1129: aload 9
    //   1131: astore 10
    //   1133: aload 14
    //   1135: ldc_w 1221
    //   1138: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: pop
    //   1142: aload 9
    //   1144: astore 10
    //   1146: aload 14
    //   1148: aload 12
    //   1150: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: pop
    //   1154: aload 9
    //   1156: astore 10
    //   1158: aload 14
    //   1160: ldc_w 1223
    //   1163: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: pop
    //   1167: aload 9
    //   1169: astore 10
    //   1171: aload 13
    //   1173: aload 14
    //   1175: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1178: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1181: pop
    //   1182: aload 9
    //   1184: astore 10
    //   1186: new 77	java/lang/StringBuilder
    //   1189: dup
    //   1190: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1193: astore 11
    //   1195: aload 9
    //   1197: astore 10
    //   1199: aload 11
    //   1201: ldc_w 1225
    //   1204: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: pop
    //   1208: aload 9
    //   1210: astore 10
    //   1212: aload 11
    //   1214: aload_3
    //   1215: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: pop
    //   1219: aload 9
    //   1221: astore 10
    //   1223: aload 11
    //   1225: ldc_w 1227
    //   1228: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload 9
    //   1234: astore 10
    //   1236: aload 13
    //   1238: aload 11
    //   1240: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1243: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1246: pop
    //   1247: aload 9
    //   1249: astore 10
    //   1251: aload 6
    //   1253: aload 13
    //   1255: invokevirtual 1202	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1258: invokevirtual 761	java/lang/String:getBytes	()[B
    //   1261: invokevirtual 1206	java/io/OutputStream:write	([B)V
    //   1264: aload 9
    //   1266: astore 10
    //   1268: new 1229	java/io/BufferedInputStream
    //   1271: dup
    //   1272: new 1229	java/io/BufferedInputStream
    //   1275: dup
    //   1276: new 1231	java/io/FileInputStream
    //   1279: dup
    //   1280: aload 5
    //   1282: invokespecial 1234	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1285: invokespecial 1235	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1288: invokespecial 1235	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1291: astore_3
    //   1292: aload 9
    //   1294: astore 10
    //   1296: sipush 3072
    //   1299: newarray byte
    //   1301: astore 11
    //   1303: aload_3
    //   1304: aload 11
    //   1306: invokevirtual 1236	java/io/BufferedInputStream:read	([B)I
    //   1309: istore 8
    //   1311: iload 8
    //   1313: iconst_m1
    //   1314: if_icmpeq +16 -> 1330
    //   1317: aload 6
    //   1319: aload 11
    //   1321: iconst_0
    //   1322: iload 8
    //   1324: invokevirtual 1237	java/io/OutputStream:write	([BII)V
    //   1327: goto -24 -> 1303
    //   1330: aload 9
    //   1332: astore 10
    //   1334: aload_3
    //   1335: invokevirtual 1238	java/io/BufferedInputStream:close	()V
    //   1338: goto -441 -> 897
    //   1341: astore_0
    //   1342: goto +80 -> 1422
    //   1345: ldc 29
    //   1347: iconst_1
    //   1348: iconst_4
    //   1349: anewarray 4	java/lang/Object
    //   1352: dup
    //   1353: iconst_0
    //   1354: ldc_w 1240
    //   1357: aastore
    //   1358: dup
    //   1359: iconst_1
    //   1360: aload 5
    //   1362: invokevirtual 1243	java/io/File:length	()J
    //   1365: invokestatic 1246	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1368: aastore
    //   1369: dup
    //   1370: iconst_2
    //   1371: ldc_w 1248
    //   1374: aastore
    //   1375: dup
    //   1376: iconst_3
    //   1377: aload 5
    //   1379: invokevirtual 1251	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1382: aastore
    //   1383: invokestatic 1139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1386: aload 6
    //   1388: invokevirtual 1254	java/io/OutputStream:flush	()V
    //   1391: aload 6
    //   1393: invokevirtual 1255	java/io/OutputStream:close	()V
    //   1396: aload_0
    //   1397: invokevirtual 1256	java/net/HttpURLConnection:disconnect	()V
    //   1400: aload_3
    //   1401: invokevirtual 1238	java/io/BufferedInputStream:close	()V
    //   1404: aconst_null
    //   1405: areturn
    //   1406: astore_0
    //   1407: aconst_null
    //   1408: astore_1
    //   1409: goto +291 -> 1700
    //   1412: astore_2
    //   1413: aconst_null
    //   1414: astore 9
    //   1416: aload 9
    //   1418: astore_0
    //   1419: goto +287 -> 1706
    //   1422: aload 9
    //   1424: astore 10
    //   1426: aload_3
    //   1427: invokevirtual 1238	java/io/BufferedInputStream:close	()V
    //   1430: aload 9
    //   1432: astore 10
    //   1434: aload_0
    //   1435: athrow
    //   1436: aload 9
    //   1438: astore 10
    //   1440: new 77	java/lang/StringBuilder
    //   1443: dup
    //   1444: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1447: astore_2
    //   1448: aload 9
    //   1450: astore 10
    //   1452: aload_2
    //   1453: ldc_w 1258
    //   1456: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: pop
    //   1460: aload 9
    //   1462: astore 10
    //   1464: aload_2
    //   1465: ldc_w 1164
    //   1468: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: pop
    //   1472: aload 9
    //   1474: astore 10
    //   1476: aload_2
    //   1477: ldc_w 1260
    //   1480: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: pop
    //   1484: aload 9
    //   1486: astore 10
    //   1488: aload 6
    //   1490: aload_2
    //   1491: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1494: invokevirtual 761	java/lang/String:getBytes	()[B
    //   1497: invokevirtual 1206	java/io/OutputStream:write	([B)V
    //   1500: aload 9
    //   1502: astore 10
    //   1504: aload 6
    //   1506: invokevirtual 1254	java/io/OutputStream:flush	()V
    //   1509: aload 9
    //   1511: astore 10
    //   1513: aload 6
    //   1515: invokevirtual 1255	java/io/OutputStream:close	()V
    //   1518: aload 9
    //   1520: astore 10
    //   1522: new 1189	java/lang/StringBuffer
    //   1525: dup
    //   1526: invokespecial 1190	java/lang/StringBuffer:<init>	()V
    //   1529: astore_3
    //   1530: aload 9
    //   1532: astore 10
    //   1534: new 928	java/io/BufferedReader
    //   1537: dup
    //   1538: new 930	java/io/InputStreamReader
    //   1541: dup
    //   1542: aload_0
    //   1543: invokevirtual 1261	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1546: invokespecial 937	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1549: invokespecial 940	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1552: astore_2
    //   1553: aload 9
    //   1555: astore 10
    //   1557: aload_2
    //   1558: invokevirtual 943	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1561: astore 4
    //   1563: aload 4
    //   1565: ifnull +29 -> 1594
    //   1568: aload 9
    //   1570: astore 10
    //   1572: aload_3
    //   1573: aload 4
    //   1575: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1578: pop
    //   1579: aload 9
    //   1581: astore 10
    //   1583: aload_3
    //   1584: ldc_w 945
    //   1587: invokevirtual 1195	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1590: pop
    //   1591: goto -38 -> 1553
    //   1594: aload 9
    //   1596: astore 10
    //   1598: aload_3
    //   1599: invokevirtual 1202	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1602: astore_3
    //   1603: aload 9
    //   1605: astore 10
    //   1607: aload_2
    //   1608: invokevirtual 947	java/io/BufferedReader:close	()V
    //   1611: aload_3
    //   1612: astore_1
    //   1613: aload 9
    //   1615: ifnull +214 -> 1829
    //   1618: aload_0
    //   1619: invokevirtual 1262	java/net/HttpURLConnection:getResponseCode	()I
    //   1622: istore 8
    //   1624: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1627: ifeq +50 -> 1677
    //   1630: new 77	java/lang/StringBuilder
    //   1633: dup
    //   1634: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1637: astore_1
    //   1638: aload_1
    //   1639: ldc_w 1264
    //   1642: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: pop
    //   1646: aload_1
    //   1647: iload 8
    //   1649: invokevirtual 822	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1652: pop
    //   1653: ldc 29
    //   1655: iconst_2
    //   1656: aload_1
    //   1657: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1660: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1663: goto +14 -> 1677
    //   1666: astore_1
    //   1667: ldc 29
    //   1669: iconst_1
    //   1670: ldc_w 1266
    //   1673: aload_1
    //   1674: invokestatic 1268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1677: aload_0
    //   1678: invokevirtual 1256	java/net/HttpURLConnection:disconnect	()V
    //   1681: aload_3
    //   1682: astore_1
    //   1683: goto +146 -> 1829
    //   1686: astore_2
    //   1687: aload_3
    //   1688: astore_0
    //   1689: goto +17 -> 1706
    //   1692: astore_2
    //   1693: goto +11 -> 1704
    //   1696: astore_0
    //   1697: aload 10
    //   1699: astore_1
    //   1700: goto +169 -> 1869
    //   1703: astore_2
    //   1704: aconst_null
    //   1705: astore_0
    //   1706: aload 9
    //   1708: astore 10
    //   1710: new 77	java/lang/StringBuilder
    //   1713: dup
    //   1714: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1717: astore_3
    //   1718: aload 9
    //   1720: astore 10
    //   1722: aload_3
    //   1723: ldc_w 1270
    //   1726: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: pop
    //   1730: aload 9
    //   1732: astore 10
    //   1734: aload_3
    //   1735: aload_1
    //   1736: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: pop
    //   1740: aload 9
    //   1742: astore 10
    //   1744: ldc 29
    //   1746: iconst_1
    //   1747: aload_3
    //   1748: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1751: aload_2
    //   1752: invokestatic 1268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1755: aload_0
    //   1756: astore_1
    //   1757: aload 9
    //   1759: ifnull +70 -> 1829
    //   1762: aload 9
    //   1764: invokevirtual 1262	java/net/HttpURLConnection:getResponseCode	()I
    //   1767: istore 8
    //   1769: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1772: ifeq +50 -> 1822
    //   1775: new 77	java/lang/StringBuilder
    //   1778: dup
    //   1779: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1782: astore_1
    //   1783: aload_1
    //   1784: ldc_w 1264
    //   1787: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: pop
    //   1791: aload_1
    //   1792: iload 8
    //   1794: invokevirtual 822	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1797: pop
    //   1798: ldc 29
    //   1800: iconst_2
    //   1801: aload_1
    //   1802: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1805: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1808: goto +14 -> 1822
    //   1811: astore_1
    //   1812: ldc 29
    //   1814: iconst_1
    //   1815: ldc_w 1266
    //   1818: aload_1
    //   1819: invokestatic 1268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1822: aload 9
    //   1824: invokevirtual 1256	java/net/HttpURLConnection:disconnect	()V
    //   1827: aload_0
    //   1828: astore_1
    //   1829: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1832: ifeq +35 -> 1867
    //   1835: new 77	java/lang/StringBuilder
    //   1838: dup
    //   1839: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1842: astore_0
    //   1843: aload_0
    //   1844: ldc_w 1272
    //   1847: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1850: pop
    //   1851: aload_0
    //   1852: aload_1
    //   1853: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: pop
    //   1857: ldc 29
    //   1859: iconst_2
    //   1860: aload_0
    //   1861: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1864: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1867: aload_1
    //   1868: areturn
    //   1869: aload_1
    //   1870: ifnull +66 -> 1936
    //   1873: aload_1
    //   1874: invokevirtual 1262	java/net/HttpURLConnection:getResponseCode	()I
    //   1877: istore 8
    //   1879: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1882: ifeq +50 -> 1932
    //   1885: new 77	java/lang/StringBuilder
    //   1888: dup
    //   1889: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1892: astore_2
    //   1893: aload_2
    //   1894: ldc_w 1264
    //   1897: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1900: pop
    //   1901: aload_2
    //   1902: iload 8
    //   1904: invokevirtual 822	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1907: pop
    //   1908: ldc 29
    //   1910: iconst_2
    //   1911: aload_2
    //   1912: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1915: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1918: goto +14 -> 1932
    //   1921: astore_2
    //   1922: ldc 29
    //   1924: iconst_1
    //   1925: ldc_w 1266
    //   1928: aload_2
    //   1929: invokestatic 1268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1932: aload_1
    //   1933: invokevirtual 1256	java/net/HttpURLConnection:disconnect	()V
    //   1936: goto +5 -> 1941
    //   1939: aload_0
    //   1940: athrow
    //   1941: goto -2 -> 1939
    //   1944: astore_2
    //   1945: goto -600 -> 1345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1948	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	1948	1	paramString1	String
    //   0	1948	2	paramString2	String
    //   0	1948	3	paramString3	String
    //   0	1948	4	paramMap1	Map<String, String>
    //   0	1948	5	paramMap2	Map<String, String>
    //   0	1948	6	paramMap3	Map<String, String>
    //   0	1948	7	paramBoolean	boolean
    //   1309	594	8	i	int
    //   1	1822	9	localHttpURLConnection1	java.net.HttpURLConnection
    //   10	1733	10	localHttpURLConnection2	java.net.HttpURLConnection
    //   6	1314	11	localObject1	Object
    //   102	1047	12	localObject2	Object
    //   360	894	13	localObject3	Object
    //   1102	72	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   290	299	302	java/lang/Exception
    //   317	337	302	java/lang/Exception
    //   341	349	302	java/lang/Exception
    //   353	362	302	java/lang/Exception
    //   366	375	302	java/lang/Exception
    //   379	386	302	java/lang/Exception
    //   390	399	302	java/lang/Exception
    //   403	411	302	java/lang/Exception
    //   415	431	302	java/lang/Exception
    //   456	465	302	java/lang/Exception
    //   469	477	302	java/lang/Exception
    //   481	488	302	java/lang/Exception
    //   492	500	302	java/lang/Exception
    //   504	511	302	java/lang/Exception
    //   515	531	302	java/lang/Exception
    //   569	579	302	java/lang/Exception
    //   583	606	302	java/lang/Exception
    //   635	643	302	java/lang/Exception
    //   647	660	302	java/lang/Exception
    //   664	673	302	java/lang/Exception
    //   677	688	302	java/lang/Exception
    //   692	704	302	java/lang/Exception
    //   708	720	302	java/lang/Exception
    //   732	740	302	java/lang/Exception
    //   744	752	302	java/lang/Exception
    //   756	764	302	java/lang/Exception
    //   768	776	302	java/lang/Exception
    //   780	789	302	java/lang/Exception
    //   793	802	302	java/lang/Exception
    //   806	814	302	java/lang/Exception
    //   818	827	302	java/lang/Exception
    //   831	841	302	java/lang/Exception
    //   845	852	302	java/lang/Exception
    //   859	871	302	java/lang/Exception
    //   1334	1338	302	java/lang/Exception
    //   1303	1311	1341	finally
    //   1317	1327	1341	finally
    //   1345	1400	1341	finally
    //   1400	1404	1406	finally
    //   1400	1404	1412	java/lang/Exception
    //   1618	1663	1666	java/lang/Exception
    //   1607	1611	1686	java/lang/Exception
    //   1426	1430	1692	java/lang/Exception
    //   1434	1436	1692	java/lang/Exception
    //   1440	1448	1692	java/lang/Exception
    //   1452	1460	1692	java/lang/Exception
    //   1464	1472	1692	java/lang/Exception
    //   1476	1484	1692	java/lang/Exception
    //   1488	1500	1692	java/lang/Exception
    //   1504	1509	1692	java/lang/Exception
    //   1513	1518	1692	java/lang/Exception
    //   1522	1530	1692	java/lang/Exception
    //   1534	1553	1692	java/lang/Exception
    //   1557	1563	1692	java/lang/Exception
    //   1572	1579	1692	java/lang/Exception
    //   1583	1591	1692	java/lang/Exception
    //   1598	1603	1692	java/lang/Exception
    //   12	20	1696	finally
    //   24	32	1696	finally
    //   36	42	1696	finally
    //   46	52	1696	finally
    //   56	62	1696	finally
    //   66	73	1696	finally
    //   77	88	1696	finally
    //   92	104	1696	finally
    //   108	117	1696	finally
    //   121	130	1696	finally
    //   134	143	1696	finally
    //   147	156	1696	finally
    //   160	169	1696	finally
    //   173	182	1696	finally
    //   186	195	1696	finally
    //   199	208	1696	finally
    //   212	225	1696	finally
    //   229	238	1696	finally
    //   242	251	1696	finally
    //   255	264	1696	finally
    //   268	281	1696	finally
    //   290	299	1696	finally
    //   317	337	1696	finally
    //   341	349	1696	finally
    //   353	362	1696	finally
    //   366	375	1696	finally
    //   379	386	1696	finally
    //   390	399	1696	finally
    //   403	411	1696	finally
    //   415	431	1696	finally
    //   435	447	1696	finally
    //   456	465	1696	finally
    //   469	477	1696	finally
    //   481	488	1696	finally
    //   492	500	1696	finally
    //   504	511	1696	finally
    //   515	531	1696	finally
    //   535	548	1696	finally
    //   552	560	1696	finally
    //   569	579	1696	finally
    //   583	606	1696	finally
    //   613	626	1696	finally
    //   635	643	1696	finally
    //   647	660	1696	finally
    //   664	673	1696	finally
    //   677	688	1696	finally
    //   692	704	1696	finally
    //   708	720	1696	finally
    //   732	740	1696	finally
    //   744	752	1696	finally
    //   756	764	1696	finally
    //   768	776	1696	finally
    //   780	789	1696	finally
    //   793	802	1696	finally
    //   806	814	1696	finally
    //   818	827	1696	finally
    //   831	841	1696	finally
    //   845	852	1696	finally
    //   859	871	1696	finally
    //   880	894	1696	finally
    //   901	911	1696	finally
    //   915	926	1696	finally
    //   930	941	1696	finally
    //   945	955	1696	finally
    //   966	976	1696	finally
    //   980	987	1696	finally
    //   991	1000	1696	finally
    //   1004	1012	1696	finally
    //   1030	1039	1696	finally
    //   1043	1052	1696	finally
    //   1056	1065	1696	finally
    //   1069	1078	1696	finally
    //   1082	1091	1696	finally
    //   1095	1104	1696	finally
    //   1108	1117	1696	finally
    //   1121	1129	1696	finally
    //   1133	1142	1696	finally
    //   1146	1154	1696	finally
    //   1158	1167	1696	finally
    //   1171	1182	1696	finally
    //   1186	1195	1696	finally
    //   1199	1208	1696	finally
    //   1212	1219	1696	finally
    //   1223	1232	1696	finally
    //   1236	1247	1696	finally
    //   1251	1264	1696	finally
    //   1268	1292	1696	finally
    //   1296	1303	1696	finally
    //   1334	1338	1696	finally
    //   1426	1430	1696	finally
    //   1434	1436	1696	finally
    //   1440	1448	1696	finally
    //   1452	1460	1696	finally
    //   1464	1472	1696	finally
    //   1476	1484	1696	finally
    //   1488	1500	1696	finally
    //   1504	1509	1696	finally
    //   1513	1518	1696	finally
    //   1522	1530	1696	finally
    //   1534	1553	1696	finally
    //   1557	1563	1696	finally
    //   1572	1579	1696	finally
    //   1583	1591	1696	finally
    //   1598	1603	1696	finally
    //   1607	1611	1696	finally
    //   1710	1718	1696	finally
    //   1722	1730	1696	finally
    //   1734	1740	1696	finally
    //   1744	1755	1696	finally
    //   12	20	1703	java/lang/Exception
    //   24	32	1703	java/lang/Exception
    //   36	42	1703	java/lang/Exception
    //   46	52	1703	java/lang/Exception
    //   56	62	1703	java/lang/Exception
    //   66	73	1703	java/lang/Exception
    //   77	88	1703	java/lang/Exception
    //   92	104	1703	java/lang/Exception
    //   108	117	1703	java/lang/Exception
    //   121	130	1703	java/lang/Exception
    //   134	143	1703	java/lang/Exception
    //   147	156	1703	java/lang/Exception
    //   160	169	1703	java/lang/Exception
    //   173	182	1703	java/lang/Exception
    //   186	195	1703	java/lang/Exception
    //   199	208	1703	java/lang/Exception
    //   212	225	1703	java/lang/Exception
    //   229	238	1703	java/lang/Exception
    //   242	251	1703	java/lang/Exception
    //   255	264	1703	java/lang/Exception
    //   268	281	1703	java/lang/Exception
    //   435	447	1703	java/lang/Exception
    //   535	548	1703	java/lang/Exception
    //   552	560	1703	java/lang/Exception
    //   613	626	1703	java/lang/Exception
    //   880	894	1703	java/lang/Exception
    //   901	911	1703	java/lang/Exception
    //   915	926	1703	java/lang/Exception
    //   930	941	1703	java/lang/Exception
    //   945	955	1703	java/lang/Exception
    //   966	976	1703	java/lang/Exception
    //   980	987	1703	java/lang/Exception
    //   991	1000	1703	java/lang/Exception
    //   1004	1012	1703	java/lang/Exception
    //   1030	1039	1703	java/lang/Exception
    //   1043	1052	1703	java/lang/Exception
    //   1056	1065	1703	java/lang/Exception
    //   1069	1078	1703	java/lang/Exception
    //   1082	1091	1703	java/lang/Exception
    //   1095	1104	1703	java/lang/Exception
    //   1108	1117	1703	java/lang/Exception
    //   1121	1129	1703	java/lang/Exception
    //   1133	1142	1703	java/lang/Exception
    //   1146	1154	1703	java/lang/Exception
    //   1158	1167	1703	java/lang/Exception
    //   1171	1182	1703	java/lang/Exception
    //   1186	1195	1703	java/lang/Exception
    //   1199	1208	1703	java/lang/Exception
    //   1212	1219	1703	java/lang/Exception
    //   1223	1232	1703	java/lang/Exception
    //   1236	1247	1703	java/lang/Exception
    //   1251	1264	1703	java/lang/Exception
    //   1268	1292	1703	java/lang/Exception
    //   1296	1303	1703	java/lang/Exception
    //   1762	1808	1811	java/lang/Exception
    //   1873	1918	1921	java/lang/Exception
    //   1303	1311	1944	java/lang/OutOfMemoryError
    //   1317	1327	1944	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static String uploadImageWithHttps(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 860	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 861	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 865	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 867	javax/net/ssl/HttpsURLConnection
    //   14: astore 8
    //   16: new 1277	com/tencent/biz/common/util/HttpUtil$3
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 1278	com/tencent/biz/common/util/HttpUtil$3:<init>	(Ljava/lang/String;)V
    //   24: astore 9
    //   26: iload 7
    //   28: ifne +18 -> 46
    //   31: aload 8
    //   33: new 872	com/tencent/mobileqq/utils/httputils/SniSSLSocketFactory
    //   36: dup
    //   37: aload_1
    //   38: aload 9
    //   40: invokespecial 875	com/tencent/mobileqq/utils/httputils/SniSSLSocketFactory:<init>	(Ljava/lang/String;Ljavax/net/ssl/HostnameVerifier;)V
    //   43: invokevirtual 879	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   46: aload 8
    //   48: aload 9
    //   50: invokevirtual 882	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   53: aload 8
    //   55: ldc_w 908
    //   58: aload_1
    //   59: invokevirtual 897	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload 8
    //   64: aload_0
    //   65: aload_2
    //   66: aload_3
    //   67: aload 4
    //   69: aload 5
    //   71: aload 6
    //   73: iload 7
    //   75: invokestatic 1132	com/tencent/biz/common/util/HttpUtil:uploadImage	(Ljava/net/HttpURLConnection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Z)Ljava/lang/String;
    //   78: astore_1
    //   79: aload_1
    //   80: areturn
    //   81: astore_1
    //   82: goto +12 -> 94
    //   85: astore_1
    //   86: goto +4 -> 90
    //   89: astore_1
    //   90: goto +37 -> 127
    //   93: astore_1
    //   94: ldc 226
    //   96: iconst_1
    //   97: iconst_4
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: ldc_w 1134
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: aload_0
    //   110: aastore
    //   111: dup
    //   112: iconst_2
    //   113: ldc_w 1136
    //   116: aastore
    //   117: dup
    //   118: iconst_3
    //   119: aload_1
    //   120: aastore
    //   121: invokestatic 1139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   124: aconst_null
    //   125: areturn
    //   126: astore_1
    //   127: ldc 226
    //   129: iconst_1
    //   130: iconst_4
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: ldc_w 1134
    //   139: aastore
    //   140: dup
    //   141: iconst_1
    //   142: aload_0
    //   143: aastore
    //   144: dup
    //   145: iconst_2
    //   146: ldc_w 1141
    //   149: aastore
    //   150: dup
    //   151: iconst_3
    //   152: aload_1
    //   153: aastore
    //   154: invokestatic 1139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   157: aconst_null
    //   158: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString1	String
    //   0	159	1	paramString2	String
    //   0	159	2	paramString3	String
    //   0	159	3	paramString4	String
    //   0	159	4	paramMap1	Map<String, String>
    //   0	159	5	paramMap2	Map<String, String>
    //   0	159	6	paramMap3	Map<String, String>
    //   0	159	7	paramBoolean	boolean
    //   14	49	8	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    //   24	25	9	local3	HttpUtil.3
    // Exception table:
    //   from	to	target	type
    //   62	79	81	java/io/IOException
    //   62	79	85	java/net/MalformedURLException
    //   0	26	89	java/net/MalformedURLException
    //   46	62	89	java/net/MalformedURLException
    //   0	26	93	java/io/IOException
    //   31	46	93	java/io/IOException
    //   46	62	93	java/io/IOException
    //   31	46	126	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.util.HttpUtil
 * JD-Core Version:    0.7.0.1
 */