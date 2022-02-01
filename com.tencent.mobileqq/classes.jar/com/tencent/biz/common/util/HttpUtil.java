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
import com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BaseQRUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
import javax.net.ssl.HttpsURLConnection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
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
    paramBundle.putString("cookie", "uin=" + str1 + ";skey=" + str2);
  }
  
  public static final HashMap<String, String> batchUrlExchange(Context paramContext, String paramString1, String paramString2, int paramInt, HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    if (paramHashMap == null) {
      paramContext = new HashMap();
    }
    HashMap localHashMap;
    for (;;)
    {
      return paramContext;
      localHashMap = new HashMap(paramHashMap);
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
            paramContext = paramContext.getJSONArray("list");
            if (paramContext == null) {
              return localHashMap;
            }
            if (paramContext.length() != localArrayList.size()) {
              break label320;
            }
            paramString1 = new HashMap();
            paramInt = 0;
            while (paramInt < paramContext.length())
            {
              paramString1.put(localArrayList.get(paramInt), paramContext.getString(paramInt));
              paramInt += 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d("HttpUtil", 2, "batchUrlExchange results: " + paramString1.toString() + ", input: " + paramHashMap);
            }
            paramContext = paramString1;
            if (paramBundle == null) {
              continue;
            }
            paramBundle.putBoolean("isSuccess", true);
            return paramString1;
          }
        }
        catch (JSONException paramContext)
        {
          QLog.d("Q.share.sdk", 4, paramContext.getMessage());
        }
      }
    }
    for (;;)
    {
      return localHashMap;
      label320:
      QLog.e("Q.share.sdk", 4, "!!!!urlArray.length() != srcKeyArray.size()");
    }
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
    if (paramString == null) {}
    do
    {
      return localHashMap;
      paramString = truncateUrlPage(paramString);
    } while (paramString == null);
    paramString = paramString.split("[&]");
    int j = paramString.length;
    int i = 0;
    label36:
    String[] arrayOfString;
    if (i < j)
    {
      arrayOfString = paramString[i].split("[=]");
      if (arrayOfString.length <= 1) {
        break label85;
      }
      localHashMap.put(URLDecoder.decode(arrayOfString[0]), URLDecoder.decode(arrayOfString[1]));
    }
    for (;;)
    {
      i += 1;
      break label36;
      break;
      label85:
      if (!TextUtils.isEmpty(arrayOfString[0])) {
        localHashMap.put(arrayOfString[0], "");
      }
    }
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
      if (((localObject2 instanceof String)) || ((localObject2 instanceof String[]))) {
        if ((localObject2 instanceof String[]))
        {
          int j;
          if (i != 0)
          {
            i = 0;
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=");
            localObject1 = (String[])paramBundle.getStringArray((String)localObject1);
            j = 0;
            label130:
            if (j >= localObject1.length) {
              break label205;
            }
            if (j != 0) {
              break label171;
            }
            localStringBuilder.append(URLEncoder.encode(localObject1[j]));
          }
          for (;;)
          {
            j += 1;
            break label130;
            localStringBuilder.append("&");
            break;
            label171:
            localStringBuilder.append(URLEncoder.encode("," + localObject1[j]));
          }
        }
        else
        {
          label205:
          if (i != 0) {
            i = 0;
          }
          for (;;)
          {
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=" + URLEncoder.encode(paramBundle.getString((String)localObject1)));
            break;
            localStringBuilder.append("&");
          }
        }
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
    String str = ((TicketManager)getRunTime().getManager(2)).getPskey(paramString1, "openmobile.qq.com");
    if (!TextUtils.isEmpty(str)) {
      localBundle.putString("cookie", "p_uin=" + paramString1 + ";p_skey=" + str);
    }
    for (;;)
    {
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
      localBundle.putString("cookie", "uin=" + paramString1 + ";skey=" + paramString2);
    }
    return null;
  }
  
  private static String getAccount()
  {
    Object localObject = getRunTime();
    if (localObject == null) {
      localObject = "0";
    }
    String str;
    do
    {
      return localObject;
      str = ((AppRuntime)localObject).getAccount();
      localObject = str;
    } while (str != null);
    return "0";
  }
  
  private static HttpClient getHttpClient(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = null;
    if (paramContext == null)
    {
      paramContext = (Context)localObject;
      return paramContext;
    }
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      try
      {
        localObject = KeyStore.getInstance(KeyStore.getDefaultType());
        ((KeyStore)localObject).load(null, null);
        localObject = new CustomSSLSocketFactory((KeyStore)localObject);
        ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        if (!TextUtils.isEmpty(paramString)) {
          ((SSLSocketFactory)localObject).setHostnameVerifier(new HttpUtil.1(paramString));
        }
        paramString = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(paramString, paramInt1);
        HttpConnectionParams.setSoTimeout(paramString, paramInt2);
        HttpProtocolParams.setVersion(paramString, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(paramString, "UTF-8");
        HttpProtocolParams.setUserAgent(paramString, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject, 443));
        paramString = new DefaultHttpClient(new ThreadSafeClientConnManager(paramString, localSchemeRegistry), paramString);
        localObject = getProxy(paramContext);
        paramContext = paramString;
        if (localObject == null) {
          break;
        }
        paramContext = new HttpHost(((HttpUtil.NetworkProxy)localObject).host, ((HttpUtil.NetworkProxy)localObject).port);
        paramString.getParams().setParameter("http.route.default-proxy", paramContext);
        return paramString;
      }
      catch (Exception localException)
      {
        localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        localSSLSocketFactory.setHostnameVerifier(httpVerifier);
        continue;
      }
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    }
  }
  
  public static int getNetWorkType()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      return 0;
      if (AppNetConnInfo.isWifiConn()) {
        return 1;
      }
    } while (!AppNetConnInfo.isMobileConn());
    switch (AppNetConnInfo.getMobileInfo())
    {
    case -1: 
    default: 
      return -1;
    case 0: 
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 4;
  }
  
  public static String getNetWorkTypeByStr()
  {
    switch ()
    {
    default: 
      return null;
    case -1: 
      return "UNKNOWN";
    case 0: 
      return "NONE";
    case 1: 
      return "WIFI";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    case 6: 
      return "5G";
    }
    return "CABLE";
  }
  
  public static int getNetWorkTypeContain5G()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      return 0;
      if (AppNetConnInfo.isWifiConn()) {
        return 1;
      }
    } while (!AppNetConnInfo.isMobileConn());
    switch (AppNetConnInfo.getMobileInfo())
    {
    case -1: 
    default: 
      return -1;
    case 0: 
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 6;
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
    if (NetworkUtil.a((NetworkInfo)localObject))
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
          paramContext = Proxy.getDefaultHost();
        }
        return paramContext;
      }
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  public static int getProxyPort(Context paramContext)
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11) {
      if (paramContext != null)
      {
        int j = Proxy.getPort(paramContext);
        i = j;
        if (j < 0) {
          i = Proxy.getDefaultPort();
        }
      }
    }
    do
    {
      return i;
      return Proxy.getDefaultPort();
      paramContext = System.getProperty("http.proxyPort");
    } while (isEmpty(paramContext));
    try
    {
      i = Integer.parseInt(paramContext);
      return i;
    }
    catch (NumberFormatException paramContext) {}
    return -1;
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
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  public static String mapToParams(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str3);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      if (i != 0)
      {
        localStringBuilder.append(str3 + "=" + URLEncoder.encode(str1, "utf-8"));
        i = 0;
      }
      for (;;)
      {
        break;
        if (str1 != null) {
          localStringBuilder.append("&" + str3 + "=" + URLEncoder.encode(str1, "utf-8"));
        } else {
          localStringBuilder.append("&" + str3 + "=");
        }
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
  
  public static HttpResponse openRequest(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt1, int paramInt2, String paramString4)
  {
    if (!hasLookupQrDNS)
    {
      hasLookupQrDNS = true;
      BaseQRUtil.a(paramContext, BaseQRUtil.f);
    }
    if (paramContext == null) {
      return null;
    }
    paramString4 = getHttpClient(paramContext, paramInt1, paramInt2, paramString4);
    if (paramString4 == null) {
      return null;
    }
    QLog.d("QRHttpUtil", 2, paramString1);
    paramContext = paramString1;
    if (paramString1.contains("#")) {
      paramContext = paramString1.substring(0, paramString1.indexOf('#'));
    }
    paramString1 = paramContext.replace(" ", "%20");
    if ("GET".equals(paramString3))
    {
      paramString3 = encodeUrl(paramBundle1);
      paramContext = paramString1;
      if (paramString3 != null)
      {
        paramContext = paramString1;
        if (paramString3.length() > 0)
        {
          paramBundle1 = new StringBuilder().append(paramString1);
          if (!paramString1.contains("?")) {
            break label254;
          }
          paramContext = "&";
        }
      }
      for (;;)
      {
        paramContext = paramContext + paramString3;
        try
        {
          paramContext = new HttpGet(paramContext);
          paramContext.addHeader("Accept-Encoding", "gzip");
          paramContext.addHeader("Connection", "close");
          if (paramBundle2 != null)
          {
            paramString1 = paramBundle2.keySet().iterator();
            while (paramString1.hasNext())
            {
              paramString3 = (String)paramString1.next();
              paramBundle1 = paramBundle2.get(paramString3);
              if ((paramBundle1 instanceof String))
              {
                paramContext.addHeader(paramString3, (String)paramBundle1);
                continue;
                label254:
                paramContext = "?";
              }
            }
          }
        }
        catch (Exception paramContext)
        {
          return null;
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        paramContext.getParams().setParameter("http.virtual-host", new HttpHost(paramString2));
      }
      try
      {
        paramContext = paramString4.execute(paramContext);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail IOException", paramContext);
        return null;
      }
      catch (OutOfMemoryError paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label709;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail OutOfMemoryError");
        return null;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label729;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail Exception", paramContext);
      }
      paramString1 = new HttpPost(paramString1);
      paramString1.addHeader("Accept-Encoding", "gzip");
      paramString1.addHeader("Connection", "close");
      paramContext = "";
      paramInt1 = paramBundle1.getInt("PostBodyType");
      if (paramInt1 == 0)
      {
        paramContext = encodeUrl(paramBundle1);
        paramString1.setHeader("Content-Type", "application/x-www-form-urlencoded");
      }
      for (;;)
      {
        paramContext = paramContext.getBytes();
        if (paramBundle2 == null) {
          break;
        }
        paramString3 = paramBundle2.keySet().iterator();
        Object localObject1;
        while (paramString3.hasNext())
        {
          paramBundle1 = (String)paramString3.next();
          localObject1 = paramBundle2.get(paramBundle1);
          if ((localObject1 instanceof String)) {
            paramString1.addHeader(paramBundle1, (String)localObject1);
          }
        }
        if (paramInt1 == 1)
        {
          paramString1.setHeader("Content-Type", "application/json; charset=UTF-8");
          paramBundle1.remove("PostBodyType");
          paramContext = new JSONObject();
          paramString3 = paramBundle1.keySet().iterator();
          while (paramString3.hasNext())
          {
            localObject1 = (String)paramString3.next();
            Object localObject2 = paramBundle1.get((String)localObject1);
            try
            {
              if (!(localObject2 instanceof String)) {
                break label561;
              }
              paramContext.put(URLEncoder.encode((String)localObject1), paramBundle1.getString((String)localObject1));
            }
            catch (JSONException localJSONException) {}
            if (QLog.isColorLevel())
            {
              QLog.d("QRHttpUtil", 2, "postBodyType=POST_BODY_TYPE_JSON parse Params to Json failed.");
              continue;
              label561:
              if (((localObject2 instanceof Long)) || ((localObject2 instanceof Integer)) || ((localObject2 instanceof Float)) || ((localObject2 instanceof Double)) || ((localObject2 instanceof Byte))) {
                paramContext.put(URLEncoder.encode(localJSONException), localObject2);
              } else if (((localObject2 instanceof JSONObject)) || ((localObject2 instanceof JSONArray))) {
                paramContext.put(URLEncoder.encode(localJSONException), localObject2);
              }
            }
          }
          paramContext = paramContext.toString();
        }
      }
      paramString1.setEntity(new ByteArrayEntity(paramContext));
      paramContext = paramString1;
    }
    label709:
    label729:
    return null;
  }
  
  public static String openUrl(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str2 = Uri.parse(paramString1).getHost();
      try
      {
        HttpResponse localHttpResponse = openRequest(paramContext, paramString1, null, paramString2, paramBundle1, paramBundle2);
        paramContext = localHttpResponse;
      }
      catch (IOException localIOException)
      {
        while (str2.equals(BaseQRUtil.f))
        {
          str1 = BaseQRUtil.a(paramContext, str2);
          if (str1 == null) {
            break label186;
          }
          paramString1 = paramString1.replace(str2, str1);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = openRequest(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        }
        throw str1;
      }
      if (paramContext == null) {
        throw new IOException("Http no response.");
      }
      label186:
      for (;;)
      {
        String str1;
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return readHttpResponse(paramContext);
        }
        throw new IOException("Http statusCode:" + i);
      }
    }
  }
  
  public static byte[] openUrlForByte(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str2 = Uri.parse(paramString1).getHost();
      try
      {
        HttpResponse localHttpResponse = openRequest(paramContext, paramString1, null, paramString2, paramBundle1, paramBundle2);
        paramContext = localHttpResponse;
      }
      catch (IOException localIOException)
      {
        while (str2.equals(BaseQRUtil.f))
        {
          str1 = BaseQRUtil.a(paramContext, str2);
          if (str1 == null) {
            break label198;
          }
          paramString1 = paramString1.replace(str2, str1);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = openRequest(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        }
        throw str1;
      }
      if (paramContext == null) {
        throw new IOException("Http no response.");
      }
      label198:
      for (;;)
      {
        String str1;
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return readHttpResponseSteam(paramContext).toByteArray();
        }
        throw new IOException("Http statusCode:" + i);
      }
    }
  }
  
  public static byte[] openUrlForByteForPubAccount(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str = Uri.parse(paramString1).getHost();
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramString3)) {
            continue;
          }
          paramString3 = openRequest(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          paramContext = paramString3;
        }
        catch (IOException paramString3)
        {
          if (!str.equals(BaseQRUtil.f)) {
            continue;
          }
          paramString3 = BaseQRUtil.a(paramContext, str);
          if (paramString3 == null) {
            break label241;
          }
          paramString1 = paramString1.replace(str, paramString3);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = openRequest(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          continue;
          throw new IOException("0");
        }
        if (paramContext != null) {
          break label184;
        }
        throw new IOException("0");
        paramString3 = openRequest(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2, 15000, 30000, paramString3);
        paramContext = paramString3;
      }
      label184:
      label241:
      for (;;)
      {
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return readHttpResponseSteam(paramContext).toByteArray();
        }
        throw new IOException("" + i);
      }
    }
  }
  
  public static String openUrlForPubAccount(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2, String paramString3)
  {
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str = Uri.parse(paramString1).getHost();
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramString3)) {
            continue;
          }
          paramString3 = openRequest(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          paramContext = paramString3;
        }
        catch (IOException paramString3)
        {
          if (!str.equals(BaseQRUtil.f)) {
            continue;
          }
          paramString3 = BaseQRUtil.a(paramContext, str);
          if (paramString3 == null) {
            break label264;
          }
          paramString1 = paramString1.replace(str, paramString3);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = openRequest(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          continue;
          throw new IOException("0");
        }
        catch (OutOfMemoryError paramContext)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("HttpUtil", 2, "openRequest fail OutOfMemoryError");
          paramContext = null;
          continue;
          int i = paramContext.getStatusLine().getStatusCode();
          if (i != 200) {
            continue;
          }
          try
          {
            paramContext = readHttpResponse(paramContext);
            return paramContext;
          }
          catch (OutOfMemoryError paramContext)
          {
            throw new IOException("-1");
          }
          throw new IOException("" + i);
        }
        if (paramContext != null) {
          continue;
        }
        throw new IOException("0");
        paramString3 = openRequest(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2, 15000, 30000, paramString3);
        paramContext = paramString3;
      }
      label264:
      for (;;) {}
    }
  }
  
  public static HttpResponse postRequestWithJson(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject, Bundle paramBundle, int paramInt1, int paramInt2, String paramString3)
  {
    if (!hasLookupQrDNS)
    {
      hasLookupQrDNS = true;
      BaseQRUtil.a(paramContext, BaseQRUtil.f);
    }
    if ((paramContext == null) || (paramJSONObject == null)) {}
    do
    {
      for (;;)
      {
        return null;
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
        try
        {
          paramContext = paramString3.execute(paramContext);
          return paramContext;
        }
        catch (IOException paramContext)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("QRHttpUtil", 2, "openRequestWithJson fail IOException", paramContext);
            return null;
          }
        }
        catch (OutOfMemoryError paramContext)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("QRHttpUtil", 2, "openRequestWithJson fail OutOfMemoryError");
            return null;
          }
        }
        catch (Exception paramContext) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("QRHttpUtil", 2, "openRequestWithJson fail Exception", paramContext);
    return null;
  }
  
  public static byte[] postUrlForByteWithJson(Context paramContext, String paramString, JSONObject paramJSONObject, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    for (;;)
    {
      String str2 = Uri.parse(paramString).getHost();
      try
      {
        HttpResponse localHttpResponse = postRequestWithJson(paramContext, paramString, null, paramJSONObject, paramBundle, 15000, 30000, null);
        paramContext = localHttpResponse;
      }
      catch (IOException localIOException)
      {
        while (str2.equals(BaseQRUtil.f))
        {
          str1 = BaseQRUtil.a(paramContext, str2);
          if (str1 == null) {
            break label208;
          }
          paramString = paramString.replace(str2, str1);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString);
          paramContext = postRequestWithJson(paramContext, paramString, str2, paramJSONObject, paramBundle, 15000, 30000, null);
        }
        throw str1;
      }
      if (paramContext == null) {
        throw new IOException("Http no response.");
      }
      label208:
      for (;;)
      {
        String str1;
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return readHttpResponseSteam(paramContext).toByteArray();
        }
        throw new IOException("Http statusCode:" + i);
      }
    }
  }
  
  /* Error */
  public static com.tencent.util.Pair<Integer, String> queryImageByIP(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: iconst_1
    //   4: istore 4
    //   6: iconst_1
    //   7: istore 5
    //   9: ldc 227
    //   11: iconst_1
    //   12: new 80	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 856
    //   22: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +17 -> 56
    //   42: aload_1
    //   43: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +10 -> 56
    //   49: aload_2
    //   50: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +5 -> 58
    //   56: aconst_null
    //   57: areturn
    //   58: new 858	java/net/URL
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 859	java/net/URL:<init>	(Ljava/lang/String;)V
    //   66: invokevirtual 863	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   69: checkcast 865	javax/net/ssl/HttpsURLConnection
    //   72: astore 7
    //   74: iload 5
    //   76: istore_3
    //   77: new 867	com/tencent/biz/common/util/HttpUtil$2
    //   80: dup
    //   81: invokespecial 868	com/tencent/biz/common/util/HttpUtil$2:<init>	()V
    //   84: astore_0
    //   85: iload 5
    //   87: istore_3
    //   88: aload 7
    //   90: new 870	com/tencent/mobileqq/utils/httputils/SniSSLSocketFactory
    //   93: dup
    //   94: ldc 13
    //   96: aload_0
    //   97: invokespecial 873	com/tencent/mobileqq/utils/httputils/SniSSLSocketFactory:<init>	(Ljava/lang/String;Ljavax/net/ssl/HostnameVerifier;)V
    //   100: invokevirtual 877	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   103: iload 5
    //   105: istore_3
    //   106: aload 7
    //   108: aload_0
    //   109: invokevirtual 880	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   112: iload 5
    //   114: istore_3
    //   115: aload 7
    //   117: sipush 5000
    //   120: invokevirtual 884	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   123: iload 5
    //   125: istore_3
    //   126: aload 7
    //   128: sipush 30000
    //   131: invokevirtual 887	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   134: iload 5
    //   136: istore_3
    //   137: aload 7
    //   139: ldc 7
    //   141: invokevirtual 890	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   144: iload 5
    //   146: istore_3
    //   147: aload 7
    //   149: ldc_w 719
    //   152: ldc_w 892
    //   155: invokevirtual 895	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: iload 5
    //   160: istore_3
    //   161: aload 7
    //   163: ldc_w 897
    //   166: new 80	java/lang/StringBuilder
    //   169: dup
    //   170: ldc_w 899
    //   173: invokespecial 900	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   176: ldc_w 437
    //   179: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: getstatic 435	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   185: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: ldc_w 437
    //   191: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: getstatic 442	android/os/Build:DEVICE	Ljava/lang/String;
    //   197: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 437
    //   203: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: getstatic 445	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   209: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 437
    //   215: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 902
    //   221: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokevirtual 895	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: iload 5
    //   232: istore_3
    //   233: aload 7
    //   235: ldc_w 337
    //   238: ldc_w 904
    //   241: invokevirtual 895	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: iload 5
    //   246: istore_3
    //   247: aload 7
    //   249: ldc_w 906
    //   252: ldc 13
    //   254: invokevirtual 895	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: iload 5
    //   259: istore_3
    //   260: invokestatic 60	com/tencent/biz/common/util/HttpUtil:getRunTime	()Lmqq/app/AppRuntime;
    //   263: iconst_2
    //   264: invokevirtual 70	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   267: checkcast 72	mqq/manager/TicketManager
    //   270: aload_1
    //   271: ldc 13
    //   273: invokeinterface 331 3 0
    //   278: astore_0
    //   279: iload 5
    //   281: istore_3
    //   282: aload_0
    //   283: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   286: ifne +122 -> 408
    //   289: iload 5
    //   291: istore_3
    //   292: aload 7
    //   294: ldc_w 908
    //   297: new 80	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   304: ldc_w 333
    //   307: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_1
    //   311: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc_w 335
    //   317: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_0
    //   321: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokevirtual 895	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: iload 5
    //   332: istore_3
    //   333: aload 7
    //   335: invokevirtual 911	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   338: istore 6
    //   340: iload 6
    //   342: sipush 200
    //   345: if_icmpeq +158 -> 503
    //   348: iload 5
    //   350: istore_3
    //   351: ldc 227
    //   353: iconst_1
    //   354: new 80	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   361: ldc_w 913
    //   364: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: iload 6
    //   369: invokevirtual 823	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: iload 5
    //   380: istore_3
    //   381: new 915	com/tencent/util/Pair
    //   384: dup
    //   385: iload 6
    //   387: invokestatic 918	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   390: ldc 240
    //   392: invokespecial 921	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   395: astore_0
    //   396: aload 7
    //   398: ifnull +8 -> 406
    //   401: aload 7
    //   403: invokevirtual 924	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   406: aload_0
    //   407: areturn
    //   408: iload 5
    //   410: istore_3
    //   411: aload 7
    //   413: ldc_w 908
    //   416: new 80	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   423: ldc 83
    //   425: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload_1
    //   429: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc 89
    //   434: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_2
    //   438: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokevirtual 895	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: goto -117 -> 330
    //   450: astore_1
    //   451: aload 7
    //   453: astore_0
    //   454: ldc 227
    //   456: iconst_1
    //   457: new 80	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   464: ldc_w 926
    //   467: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_1
    //   471: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 235	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: aload_0
    //   481: ifnull +254 -> 735
    //   484: aload_0
    //   485: invokevirtual 924	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   488: aconst_null
    //   489: astore_0
    //   490: new 915	com/tencent/util/Pair
    //   493: dup
    //   494: iload_3
    //   495: invokestatic 918	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: aload_0
    //   499: invokespecial 921	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   502: areturn
    //   503: iload 5
    //   505: istore_3
    //   506: new 80	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   513: astore_0
    //   514: iload 5
    //   516: istore_3
    //   517: new 928	java/io/BufferedReader
    //   520: dup
    //   521: new 930	java/io/InputStreamReader
    //   524: dup
    //   525: aload 7
    //   527: invokevirtual 934	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   530: invokespecial 937	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   533: invokespecial 940	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   536: astore_1
    //   537: iload 5
    //   539: istore_3
    //   540: aload_1
    //   541: invokevirtual 943	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   544: astore_2
    //   545: aload_2
    //   546: ifnull +35 -> 581
    //   549: iload 5
    //   551: istore_3
    //   552: aload_0
    //   553: aload_2
    //   554: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: ldc_w 945
    //   560: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: goto -27 -> 537
    //   567: astore_1
    //   568: aload 7
    //   570: astore_0
    //   571: aload_0
    //   572: ifnull +7 -> 579
    //   575: aload_0
    //   576: invokevirtual 924	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   579: aload_1
    //   580: athrow
    //   581: iload 5
    //   583: istore_3
    //   584: aload_1
    //   585: invokevirtual 947	java/io/BufferedReader:close	()V
    //   588: iload 5
    //   590: istore_3
    //   591: aload_0
    //   592: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: astore_0
    //   596: iload 5
    //   598: istore_3
    //   599: aload_0
    //   600: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   603: ifne +105 -> 708
    //   606: iload 5
    //   608: istore_3
    //   609: new 160	org/json/JSONObject
    //   612: dup
    //   613: aload_0
    //   614: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   617: astore_0
    //   618: iload 5
    //   620: istore_3
    //   621: aload_0
    //   622: ldc 165
    //   624: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   627: istore 4
    //   629: iload 4
    //   631: ifne +47 -> 678
    //   634: iload 4
    //   636: istore_3
    //   637: aload_0
    //   638: ldc 175
    //   640: invokevirtual 950	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   643: ifeq +35 -> 678
    //   646: iload 4
    //   648: istore_3
    //   649: aload_0
    //   650: ldc 175
    //   652: invokevirtual 179	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   655: ldc_w 952
    //   658: invokevirtual 953	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   661: astore_0
    //   662: iload 4
    //   664: istore_3
    //   665: aload 7
    //   667: ifnull +73 -> 740
    //   670: aload 7
    //   672: invokevirtual 924	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   675: goto -185 -> 490
    //   678: iload 4
    //   680: istore_3
    //   681: ldc 227
    //   683: iconst_1
    //   684: new 80	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   691: ldc_w 955
    //   694: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: iload 4
    //   699: invokevirtual 823	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   702: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: iload 4
    //   710: istore_3
    //   711: aload 8
    //   713: astore_0
    //   714: goto -49 -> 665
    //   717: astore_1
    //   718: aconst_null
    //   719: astore_0
    //   720: goto -149 -> 571
    //   723: astore_1
    //   724: goto -153 -> 571
    //   727: astore_1
    //   728: iconst_1
    //   729: istore_3
    //   730: aconst_null
    //   731: astore_0
    //   732: goto -278 -> 454
    //   735: aconst_null
    //   736: astore_0
    //   737: goto -247 -> 490
    //   740: goto -250 -> 490
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	paramString1	String
    //   0	743	1	paramString2	String
    //   0	743	2	paramString3	String
    //   76	654	3	i	int
    //   4	705	4	j	int
    //   7	612	5	k	int
    //   338	48	6	m	int
    //   72	599	7	localHttpsURLConnection	HttpsURLConnection
    //   1	711	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   77	85	450	java/lang/Exception
    //   88	103	450	java/lang/Exception
    //   106	112	450	java/lang/Exception
    //   115	123	450	java/lang/Exception
    //   126	134	450	java/lang/Exception
    //   137	144	450	java/lang/Exception
    //   147	158	450	java/lang/Exception
    //   161	230	450	java/lang/Exception
    //   233	244	450	java/lang/Exception
    //   247	257	450	java/lang/Exception
    //   260	279	450	java/lang/Exception
    //   282	289	450	java/lang/Exception
    //   292	330	450	java/lang/Exception
    //   333	340	450	java/lang/Exception
    //   351	378	450	java/lang/Exception
    //   381	396	450	java/lang/Exception
    //   411	447	450	java/lang/Exception
    //   506	514	450	java/lang/Exception
    //   517	537	450	java/lang/Exception
    //   540	545	450	java/lang/Exception
    //   552	564	450	java/lang/Exception
    //   584	588	450	java/lang/Exception
    //   591	596	450	java/lang/Exception
    //   599	606	450	java/lang/Exception
    //   609	618	450	java/lang/Exception
    //   621	629	450	java/lang/Exception
    //   637	646	450	java/lang/Exception
    //   649	662	450	java/lang/Exception
    //   681	708	450	java/lang/Exception
    //   77	85	567	finally
    //   88	103	567	finally
    //   106	112	567	finally
    //   115	123	567	finally
    //   126	134	567	finally
    //   137	144	567	finally
    //   147	158	567	finally
    //   161	230	567	finally
    //   233	244	567	finally
    //   247	257	567	finally
    //   260	279	567	finally
    //   282	289	567	finally
    //   292	330	567	finally
    //   333	340	567	finally
    //   351	378	567	finally
    //   381	396	567	finally
    //   411	447	567	finally
    //   506	514	567	finally
    //   517	537	567	finally
    //   540	545	567	finally
    //   552	564	567	finally
    //   584	588	567	finally
    //   591	596	567	finally
    //   599	606	567	finally
    //   609	618	567	finally
    //   621	629	567	finally
    //   637	646	567	finally
    //   649	662	567	finally
    //   681	708	567	finally
    //   58	74	717	finally
    //   454	480	723	finally
    //   58	74	727	java/lang/Exception
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
    //   1: invokeinterface 961 1 0
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload 5
    //   17: invokeinterface 966 1 0
    //   22: astore 5
    //   24: aload 5
    //   26: astore_3
    //   27: aload 5
    //   29: astore_2
    //   30: aload 5
    //   32: astore 4
    //   34: new 831	java/io/ByteArrayOutputStream
    //   37: dup
    //   38: invokespecial 967	java/io/ByteArrayOutputStream:<init>	()V
    //   41: astore 6
    //   43: aload 5
    //   45: astore_3
    //   46: aload 5
    //   48: astore_2
    //   49: aload 5
    //   51: astore 4
    //   53: aload_0
    //   54: ldc_w 969
    //   57: invokeinterface 973 2 0
    //   62: astore 7
    //   64: aload 5
    //   66: astore_0
    //   67: aload 7
    //   69: ifnull +55 -> 124
    //   72: aload 5
    //   74: astore_0
    //   75: aload 5
    //   77: astore_3
    //   78: aload 5
    //   80: astore_2
    //   81: aload 5
    //   83: astore 4
    //   85: aload 7
    //   87: invokeinterface 978 1 0
    //   92: invokevirtual 981	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   95: ldc_w 712
    //   98: invokevirtual 688	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +23 -> 124
    //   104: aload 5
    //   106: astore_3
    //   107: aload 5
    //   109: astore_2
    //   110: aload 5
    //   112: astore 4
    //   114: new 983	java/util/zip/GZIPInputStream
    //   117: dup
    //   118: aload 5
    //   120: invokespecial 984	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   123: astore_0
    //   124: aload_0
    //   125: astore_3
    //   126: aload_0
    //   127: astore_2
    //   128: aload_0
    //   129: astore 4
    //   131: sipush 512
    //   134: newarray byte
    //   136: astore 5
    //   138: aload_0
    //   139: astore_3
    //   140: aload_0
    //   141: astore_2
    //   142: aload_0
    //   143: astore 4
    //   145: aload_0
    //   146: aload 5
    //   148: invokevirtual 990	java/io/InputStream:read	([B)I
    //   151: istore_1
    //   152: iload_1
    //   153: iconst_m1
    //   154: if_icmpeq +38 -> 192
    //   157: aload_0
    //   158: astore_3
    //   159: aload_0
    //   160: astore_2
    //   161: aload_0
    //   162: astore 4
    //   164: aload 6
    //   166: aload 5
    //   168: iconst_0
    //   169: iload_1
    //   170: invokevirtual 994	java/io/ByteArrayOutputStream:write	([BII)V
    //   173: goto -35 -> 138
    //   176: astore_0
    //   177: aload_3
    //   178: astore_2
    //   179: aload_0
    //   180: athrow
    //   181: astore_0
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 995	java/io/InputStream:close	()V
    //   190: aload_0
    //   191: athrow
    //   192: aload_0
    //   193: ifnull +7 -> 200
    //   196: aload_0
    //   197: invokevirtual 995	java/io/InputStream:close	()V
    //   200: aload 6
    //   202: areturn
    //   203: astore_0
    //   204: aload 4
    //   206: astore_2
    //   207: new 324	java/io/IOException
    //   210: dup
    //   211: invokespecial 996	java/io/IOException:<init>	()V
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramHttpResponse	HttpResponse
    //   151	19	1	i	int
    //   9	198	2	localObject1	Object
    //   14	164	3	localObject2	Object
    //   11	194	4	localObject3	Object
    //   6	161	5	localObject4	Object
    //   41	160	6	localByteArrayOutputStream	ByteArrayOutputStream
    //   62	24	7	localHeader	org.apache.http.Header
    // Exception table:
    //   from	to	target	type
    //   15	24	176	java/io/IOException
    //   34	43	176	java/io/IOException
    //   53	64	176	java/io/IOException
    //   85	104	176	java/io/IOException
    //   114	124	176	java/io/IOException
    //   131	138	176	java/io/IOException
    //   145	152	176	java/io/IOException
    //   164	173	176	java/io/IOException
    //   15	24	181	finally
    //   34	43	181	finally
    //   53	64	181	finally
    //   85	104	181	finally
    //   114	124	181	finally
    //   131	138	181	finally
    //   145	152	181	finally
    //   164	173	181	finally
    //   179	181	181	finally
    //   207	215	181	finally
    //   15	24	203	java/lang/Exception
    //   34	43	203	java/lang/Exception
    //   53	64	203	java/lang/Exception
    //   85	104	203	java/lang/Exception
    //   114	124	203	java/lang/Exception
    //   131	138	203	java/lang/Exception
    //   145	152	203	java/lang/Exception
    //   164	173	203	java/lang/Exception
  }
  
  public static String removeHtmlTags(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = new String[27];
    localObject[0] = "li";
    localObject[1] = "del";
    localObject[2] = "ins";
    localObject[3] = "fieldset";
    localObject[4] = "legend";
    localObject[5] = "tr";
    localObject[6] = "th";
    localObject[7] = "caption";
    localObject[8] = "thead";
    localObject[9] = "tbody";
    localObject[10] = "tfoot";
    localObject[11] = "p";
    localObject[12] = "h[1-6]";
    localObject[13] = "dl";
    localObject[14] = "dt";
    localObject[15] = "dd";
    localObject[16] = "ol";
    localObject[17] = "ul";
    localObject[18] = "dir";
    localObject[19] = "address";
    localObject[20] = "blockquote";
    localObject[21] = "center";
    localObject[22] = "hr";
    localObject[23] = "pre";
    localObject[24] = "form";
    localObject[25] = "textarea";
    localObject[26] = "table";
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      Matcher localMatcher = Pattern.compile("<(\\s*" + localObject[i] + ")[^>]*>").matcher(paramString);
      if (localMatcher.find()) {
        paramString = localMatcher.replaceAll(" ");
      }
      localMatcher = Pattern.compile("</?(\\s*" + localObject[i] + ")[^>]*>").matcher(paramString);
      if (localMatcher.find()) {
        paramString = localMatcher.replaceAll("\n");
      }
      i += 1;
    }
    localObject = Pattern.compile("<br>").matcher(paramString);
    if (((Matcher)localObject).find()) {
      paramString = ((Matcher)localObject).replaceAll("\n");
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
    Object localObject4;
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
    Object localObject5;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject5 = (TicketManager)getRunTime().getManager(2);
      localObject4 = ((TicketManager)localObject5).getPskey((String)localObject2, "openmobile.qq.com");
      localObject5 = ((TicketManager)localObject5).getSkey((String)localObject2);
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label292;
      }
      ((Bundle)localObject3).putString("cookie", "p_uin=" + (String)localObject2 + ";p_skey=" + (String)localObject4);
    }
    for (;;)
    {
      ((Bundle)localObject3).putString("Referer", "http://openmobile.qq.com/");
      localObject4 = new Bundle();
      ((Bundle)localObject4).putString("value", ((JSONArray)localObject1).toString());
      ((Bundle)localObject4).putString("mType", "qb_share");
      localObject2 = null;
      try
      {
        localObject1 = openUrl(BaseApplication.getContext(), MsfSdkUtils.insertMtype("AppDepart", "https://openmobile.qq.com/api/shortUrl"), "POST", (Bundle)localObject4, (Bundle)localObject3);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          return localHashMap;
          label292:
          ((Bundle)localObject3).putString("cookie", "uin=" + (String)localObject2 + ";skey=" + (String)localObject5);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("HttpUtil", 2, localIOException.getMessage());
            localObject1 = localObject2;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("HttpUtil", 2, localOutOfMemoryError.getMessage());
            localObject1 = localObject2;
          }
        }
      }
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
            break label645;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error retcode:" + i);
          break label645;
        }
        paramBundle = ((JSONObject)localObject1).getJSONObject("result");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label648;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          break label648;
        }
        paramBundle = paramBundle.getJSONArray("list");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label651;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          break label651;
        }
        if (paramBundle.length() == localArrayList.size())
        {
          i = 0;
          if (i < paramBundle.length())
          {
            localObject1 = paramBundle.getString(i);
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label654;
            }
            localHashMap.put(localArrayList.get(i), localObject1);
            break label654;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("HttpUtil", 2, "shortenUrl error result size");
        }
      }
      catch (JSONException paramBundle)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("HttpUtil", 2, "shortenUrl parse response error");
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HttpUtil", 2, "shortenUrl results: " + localHashMap.toString() + ", input: " + paramHashMap);
      }
      return localHashMap;
      label645:
      return localHashMap;
      label648:
      return localHashMap;
      label651:
      return localHashMap;
      label654:
      i += 1;
    }
  }
  
  private static String truncateUrlPage(String paramString)
  {
    Object localObject = null;
    String str = paramString.trim();
    String[] arrayOfString = str.split("[?]");
    paramString = localObject;
    if (str.length() > 1)
    {
      paramString = localObject;
      if (arrayOfString.length > 1)
      {
        paramString = localObject;
        if (arrayOfString[1] != null) {
          paramString = arrayOfString[1];
        }
      }
    }
    return paramString;
  }
  
  public static String unEscape(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
  }
  
  public static final String uploadImage(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      QLog.d("Q.share.sdk", 1, "uploadImage param invalid");
      return null;
    }
    boolean bool = paramString1.startsWith("http://cgi.connect.qq.com/qqconnectopen/upload_share_image");
    try
    {
      paramString2 = uploadImage((HttpURLConnection)new URL(paramString1).openConnection(), paramString1, paramString2, paramString3, paramMap1, paramMap2, paramMap3, bool);
      return paramString2;
    }
    catch (MalformedURLException paramString2)
    {
      QLog.e("Q.share.sdk", 1, new Object[] { "urlStr=", paramString1, ", MalformedURLException uploadImage|err=", paramString2 });
      return null;
    }
    catch (IOException paramString2)
    {
      QLog.e("Q.share.sdk", 1, new Object[] { "urlStr=", paramString1, ", IOException uploadImage|err=", paramString2 });
    }
    return null;
  }
  
  /* Error */
  public static final String uploadImage(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 10
    //   3: aload_0
    //   4: astore 9
    //   6: aload_0
    //   7: sipush 5000
    //   10: invokevirtual 1143	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   13: aload_0
    //   14: astore 10
    //   16: aload_0
    //   17: astore 9
    //   19: aload_0
    //   20: sipush 30000
    //   23: invokevirtual 1144	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   26: aload_0
    //   27: astore 10
    //   29: aload_0
    //   30: astore 9
    //   32: aload_0
    //   33: iconst_1
    //   34: invokevirtual 1148	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   37: aload_0
    //   38: astore 10
    //   40: aload_0
    //   41: astore 9
    //   43: aload_0
    //   44: iconst_1
    //   45: invokevirtual 1151	java/net/HttpURLConnection:setDoInput	(Z)V
    //   48: aload_0
    //   49: astore 10
    //   51: aload_0
    //   52: astore 9
    //   54: aload_0
    //   55: iconst_0
    //   56: invokevirtual 1154	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   59: aload_0
    //   60: astore 10
    //   62: aload_0
    //   63: astore 9
    //   65: aload_0
    //   66: ldc 21
    //   68: invokevirtual 1155	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: astore 10
    //   74: aload_0
    //   75: astore 9
    //   77: aload_0
    //   78: ldc_w 719
    //   81: ldc_w 892
    //   84: invokevirtual 1156	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_0
    //   88: astore 10
    //   90: aload_0
    //   91: astore 9
    //   93: aload_0
    //   94: ldc_w 897
    //   97: new 80	java/lang/StringBuilder
    //   100: dup
    //   101: ldc_w 899
    //   104: invokespecial 900	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: ldc_w 437
    //   110: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: getstatic 435	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   116: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc_w 437
    //   122: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: getstatic 442	android/os/Build:DEVICE	Ljava/lang/String;
    //   128: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 437
    //   134: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: getstatic 445	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   140: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 437
    //   146: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 902
    //   152: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokevirtual 1156	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_0
    //   162: astore 10
    //   164: aload_0
    //   165: astore 9
    //   167: aload_0
    //   168: ldc_w 738
    //   171: new 80	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 1158
    //   181: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 1160
    //   187: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokevirtual 1156	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload 6
    //   198: astore 11
    //   200: aload 6
    //   202: ifnonnull +18 -> 220
    //   205: aload_0
    //   206: astore 10
    //   208: aload_0
    //   209: astore 9
    //   211: new 104	java/util/HashMap
    //   214: dup
    //   215: invokespecial 105	java/util/HashMap:<init>	()V
    //   218: astore 11
    //   220: iload 7
    //   222: ifeq +91 -> 313
    //   225: aload_0
    //   226: astore 10
    //   228: aload_0
    //   229: astore 9
    //   231: invokestatic 60	com/tencent/biz/common/util/HttpUtil:getRunTime	()Lmqq/app/AppRuntime;
    //   234: iconst_2
    //   235: invokevirtual 70	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   238: checkcast 72	mqq/manager/TicketManager
    //   241: aload_2
    //   242: ldc 13
    //   244: invokeinterface 331 3 0
    //   249: astore 6
    //   251: aload_0
    //   252: astore 10
    //   254: aload_0
    //   255: astore 9
    //   257: aload 6
    //   259: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   262: ifne +51 -> 313
    //   265: aload_0
    //   266: astore 10
    //   268: aload_0
    //   269: astore 9
    //   271: aload 11
    //   273: ldc_w 908
    //   276: new 80	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 333
    //   286: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_2
    //   290: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 335
    //   296: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 6
    //   301: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokeinterface 1161 3 0
    //   312: pop
    //   313: aload_0
    //   314: astore 10
    //   316: aload_0
    //   317: astore 9
    //   319: aload 11
    //   321: ldc_w 908
    //   324: invokeinterface 1164 2 0
    //   329: ifne +48 -> 377
    //   332: aload_0
    //   333: astore 10
    //   335: aload_0
    //   336: astore 9
    //   338: aload 11
    //   340: ldc_w 908
    //   343: new 80	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   350: ldc 83
    //   352: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_2
    //   356: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc 89
    //   361: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload_3
    //   365: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokeinterface 1161 3 0
    //   376: pop
    //   377: aload_0
    //   378: astore 10
    //   380: aload_0
    //   381: astore 9
    //   383: aload 11
    //   385: invokeinterface 1167 1 0
    //   390: invokeinterface 124 1 0
    //   395: astore_3
    //   396: aload_0
    //   397: astore 10
    //   399: aload_0
    //   400: astore 9
    //   402: aload_3
    //   403: invokeinterface 130 1 0
    //   408: ifeq +175 -> 583
    //   411: aload_0
    //   412: astore 10
    //   414: aload_0
    //   415: astore 9
    //   417: aload_3
    //   418: invokeinterface 134 1 0
    //   423: checkcast 1169	java/util/Map$Entry
    //   426: astore_2
    //   427: aload_0
    //   428: astore 10
    //   430: aload_0
    //   431: astore 9
    //   433: aload_0
    //   434: aload_2
    //   435: invokeinterface 1172 1 0
    //   440: checkcast 136	java/lang/String
    //   443: aload_2
    //   444: invokeinterface 1174 1 0
    //   449: checkcast 136	java/lang/String
    //   452: invokevirtual 1156	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: goto -59 -> 396
    //   458: astore_3
    //   459: aconst_null
    //   460: astore_2
    //   461: aload 10
    //   463: astore_0
    //   464: aload_0
    //   465: astore 9
    //   467: ldc 29
    //   469: iconst_1
    //   470: new 80	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   477: ldc_w 1176
    //   480: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload_1
    //   484: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: aload_3
    //   491: invokestatic 1178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   494: aload_2
    //   495: astore_1
    //   496: aload_0
    //   497: ifnull +48 -> 545
    //   500: aload_0
    //   501: invokevirtual 1179	java/net/HttpURLConnection:getResponseCode	()I
    //   504: istore 8
    //   506: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq +30 -> 539
    //   512: ldc 29
    //   514: iconst_2
    //   515: new 80	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   522: ldc_w 1181
    //   525: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: iload 8
    //   530: invokevirtual 823	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   533: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: aload_0
    //   540: invokevirtual 1182	java/net/HttpURLConnection:disconnect	()V
    //   543: aload_2
    //   544: astore_1
    //   545: aload_1
    //   546: astore_0
    //   547: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +31 -> 581
    //   553: ldc 29
    //   555: iconst_2
    //   556: new 80	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   563: ldc_w 1184
    //   566: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload_1
    //   570: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: aload_1
    //   580: astore_0
    //   581: aload_0
    //   582: areturn
    //   583: aload_0
    //   584: astore 10
    //   586: aload_0
    //   587: astore 9
    //   589: new 1186	java/io/DataOutputStream
    //   592: dup
    //   593: aload_0
    //   594: invokevirtual 1190	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   597: invokespecial 1193	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   600: astore_3
    //   601: aload 4
    //   603: ifnull +268 -> 871
    //   606: aload_0
    //   607: astore 10
    //   609: aload_0
    //   610: astore 9
    //   612: new 1195	java/lang/StringBuffer
    //   615: dup
    //   616: invokespecial 1196	java/lang/StringBuffer:<init>	()V
    //   619: astore_2
    //   620: aload_0
    //   621: astore 10
    //   623: aload_0
    //   624: astore 9
    //   626: aload 4
    //   628: invokeinterface 1167 1 0
    //   633: invokeinterface 124 1 0
    //   638: astore 6
    //   640: aload_0
    //   641: astore 10
    //   643: aload_0
    //   644: astore 9
    //   646: aload 6
    //   648: invokeinterface 130 1 0
    //   653: ifeq +201 -> 854
    //   656: aload_0
    //   657: astore 10
    //   659: aload_0
    //   660: astore 9
    //   662: aload 6
    //   664: invokeinterface 134 1 0
    //   669: checkcast 1169	java/util/Map$Entry
    //   672: astore 11
    //   674: aload_0
    //   675: astore 10
    //   677: aload_0
    //   678: astore 9
    //   680: aload 11
    //   682: invokeinterface 1172 1 0
    //   687: checkcast 136	java/lang/String
    //   690: astore 4
    //   692: aload_0
    //   693: astore 10
    //   695: aload_0
    //   696: astore 9
    //   698: aload 11
    //   700: invokeinterface 1174 1 0
    //   705: checkcast 136	java/lang/String
    //   708: astore 11
    //   710: aload 11
    //   712: ifnull -72 -> 640
    //   715: aload_0
    //   716: astore 10
    //   718: aload_0
    //   719: astore 9
    //   721: aload_2
    //   722: ldc_w 1198
    //   725: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   728: ldc_w 1203
    //   731: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   734: ldc_w 1160
    //   737: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   740: ldc_w 1198
    //   743: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   746: pop
    //   747: aload_0
    //   748: astore 10
    //   750: aload_0
    //   751: astore 9
    //   753: aload_2
    //   754: new 80	java/lang/StringBuilder
    //   757: dup
    //   758: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   761: ldc_w 1205
    //   764: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: aload 4
    //   769: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: ldc_w 1207
    //   775: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   784: pop
    //   785: aload_0
    //   786: astore 10
    //   788: aload_0
    //   789: astore 9
    //   791: aload_2
    //   792: aload 11
    //   794: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   797: pop
    //   798: goto -158 -> 640
    //   801: astore_0
    //   802: aload 9
    //   804: ifnull +48 -> 852
    //   807: aload 9
    //   809: invokevirtual 1179	java/net/HttpURLConnection:getResponseCode	()I
    //   812: istore 8
    //   814: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   817: ifeq +30 -> 847
    //   820: ldc 29
    //   822: iconst_2
    //   823: new 80	java/lang/StringBuilder
    //   826: dup
    //   827: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   830: ldc_w 1181
    //   833: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: iload 8
    //   838: invokevirtual 823	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   841: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: aload 9
    //   849: invokevirtual 1182	java/net/HttpURLConnection:disconnect	()V
    //   852: aload_0
    //   853: athrow
    //   854: aload_0
    //   855: astore 10
    //   857: aload_0
    //   858: astore 9
    //   860: aload_3
    //   861: aload_2
    //   862: invokevirtual 1208	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   865: invokevirtual 747	java/lang/String:getBytes	()[B
    //   868: invokevirtual 1212	java/io/OutputStream:write	([B)V
    //   871: aload 5
    //   873: ifnull +525 -> 1398
    //   876: aload_0
    //   877: astore 10
    //   879: aload_0
    //   880: astore 9
    //   882: aload 5
    //   884: invokeinterface 1167 1 0
    //   889: invokeinterface 124 1 0
    //   894: astore 4
    //   896: aload_0
    //   897: astore 10
    //   899: aload_0
    //   900: astore 9
    //   902: aload 4
    //   904: invokeinterface 130 1 0
    //   909: ifeq +489 -> 1398
    //   912: aload_0
    //   913: astore 10
    //   915: aload_0
    //   916: astore 9
    //   918: aload 4
    //   920: invokeinterface 134 1 0
    //   925: checkcast 1169	java/util/Map$Entry
    //   928: astore_2
    //   929: aload_0
    //   930: astore 10
    //   932: aload_0
    //   933: astore 9
    //   935: aload_2
    //   936: invokeinterface 1172 1 0
    //   941: checkcast 136	java/lang/String
    //   944: astore 6
    //   946: aload_0
    //   947: astore 10
    //   949: aload_0
    //   950: astore 9
    //   952: aload_2
    //   953: invokeinterface 1174 1 0
    //   958: checkcast 136	java/lang/String
    //   961: astore_2
    //   962: aload_2
    //   963: ifnull -67 -> 896
    //   966: aload_0
    //   967: astore 10
    //   969: aload_0
    //   970: astore 9
    //   972: new 1214	java/io/File
    //   975: dup
    //   976: aload_2
    //   977: invokespecial 1215	java/io/File:<init>	(Ljava/lang/String;)V
    //   980: astore 5
    //   982: aload_0
    //   983: astore 10
    //   985: aload_0
    //   986: astore 9
    //   988: aload 5
    //   990: invokevirtual 1218	java/io/File:getName	()Ljava/lang/String;
    //   993: astore 11
    //   995: aload_0
    //   996: astore 10
    //   998: aload_0
    //   999: astore 9
    //   1001: aload 11
    //   1003: ldc_w 1220
    //   1006: invokevirtual 1223	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1009: ifeq +3 -> 1012
    //   1012: ldc_w 1225
    //   1015: astore_2
    //   1016: ldc_w 1225
    //   1019: ifnull +636 -> 1655
    //   1022: aload_0
    //   1023: astore 10
    //   1025: aload_0
    //   1026: astore 9
    //   1028: ldc_w 1225
    //   1031: ldc 240
    //   1033: invokevirtual 701	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1036: ifeq +6 -> 1042
    //   1039: goto +616 -> 1655
    //   1042: aload_0
    //   1043: astore 10
    //   1045: aload_0
    //   1046: astore 9
    //   1048: new 1195	java/lang/StringBuffer
    //   1051: dup
    //   1052: invokespecial 1196	java/lang/StringBuffer:<init>	()V
    //   1055: astore 12
    //   1057: aload_0
    //   1058: astore 10
    //   1060: aload_0
    //   1061: astore 9
    //   1063: aload 12
    //   1065: ldc_w 1198
    //   1068: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1071: ldc_w 1203
    //   1074: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1077: ldc_w 1160
    //   1080: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1083: ldc_w 1198
    //   1086: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1089: pop
    //   1090: aload_0
    //   1091: astore 10
    //   1093: aload_0
    //   1094: astore 9
    //   1096: aload 12
    //   1098: new 80	java/lang/StringBuilder
    //   1101: dup
    //   1102: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1105: ldc_w 1205
    //   1108: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: aload 6
    //   1113: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: ldc_w 1227
    //   1119: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: aload 11
    //   1124: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: ldc_w 1229
    //   1130: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1136: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1139: pop
    //   1140: aload_0
    //   1141: astore 10
    //   1143: aload_0
    //   1144: astore 9
    //   1146: aload 12
    //   1148: new 80	java/lang/StringBuilder
    //   1151: dup
    //   1152: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1155: ldc_w 1231
    //   1158: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: aload_2
    //   1162: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: ldc_w 1233
    //   1168: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1174: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1177: pop
    //   1178: aload_0
    //   1179: astore 10
    //   1181: aload_0
    //   1182: astore 9
    //   1184: aload_3
    //   1185: aload 12
    //   1187: invokevirtual 1208	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1190: invokevirtual 747	java/lang/String:getBytes	()[B
    //   1193: invokevirtual 1212	java/io/OutputStream:write	([B)V
    //   1196: aload_0
    //   1197: astore 10
    //   1199: aload_0
    //   1200: astore 9
    //   1202: new 1235	java/io/BufferedInputStream
    //   1205: dup
    //   1206: new 1235	java/io/BufferedInputStream
    //   1209: dup
    //   1210: new 1237	java/io/FileInputStream
    //   1213: dup
    //   1214: aload 5
    //   1216: invokespecial 1240	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1219: invokespecial 1241	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1222: invokespecial 1241	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1225: astore_2
    //   1226: aload_0
    //   1227: astore 10
    //   1229: aload_0
    //   1230: astore 9
    //   1232: sipush 3072
    //   1235: newarray byte
    //   1237: astore 6
    //   1239: aload_2
    //   1240: aload 6
    //   1242: invokevirtual 1242	java/io/BufferedInputStream:read	([B)I
    //   1245: istore 8
    //   1247: iload 8
    //   1249: iconst_m1
    //   1250: if_icmpeq +102 -> 1352
    //   1253: aload_3
    //   1254: aload 6
    //   1256: iconst_0
    //   1257: iload 8
    //   1259: invokevirtual 1243	java/io/OutputStream:write	([BII)V
    //   1262: goto -23 -> 1239
    //   1265: astore 4
    //   1267: ldc 29
    //   1269: iconst_1
    //   1270: iconst_4
    //   1271: anewarray 4	java/lang/Object
    //   1274: dup
    //   1275: iconst_0
    //   1276: ldc_w 1245
    //   1279: aastore
    //   1280: dup
    //   1281: iconst_1
    //   1282: aload 5
    //   1284: invokevirtual 1248	java/io/File:length	()J
    //   1287: invokestatic 1251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1290: aastore
    //   1291: dup
    //   1292: iconst_2
    //   1293: ldc_w 1253
    //   1296: aastore
    //   1297: dup
    //   1298: iconst_3
    //   1299: aload 5
    //   1301: invokevirtual 1256	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1304: aastore
    //   1305: invokestatic 1139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1308: aload_3
    //   1309: invokevirtual 1259	java/io/OutputStream:flush	()V
    //   1312: aload_3
    //   1313: invokevirtual 1260	java/io/OutputStream:close	()V
    //   1316: aload_0
    //   1317: invokevirtual 1182	java/net/HttpURLConnection:disconnect	()V
    //   1320: aconst_null
    //   1321: astore 9
    //   1323: aconst_null
    //   1324: astore 10
    //   1326: aconst_null
    //   1327: astore_0
    //   1328: aload_2
    //   1329: invokevirtual 1261	java/io/BufferedInputStream:close	()V
    //   1332: iconst_0
    //   1333: ifeq -752 -> 581
    //   1336: new 1263	java/lang/NullPointerException
    //   1339: dup
    //   1340: invokespecial 1264	java/lang/NullPointerException:<init>	()V
    //   1343: athrow
    //   1344: new 1263	java/lang/NullPointerException
    //   1347: dup
    //   1348: invokespecial 1264	java/lang/NullPointerException:<init>	()V
    //   1351: athrow
    //   1352: aload_0
    //   1353: astore 10
    //   1355: aload_0
    //   1356: astore 9
    //   1358: aload_2
    //   1359: invokevirtual 1261	java/io/BufferedInputStream:close	()V
    //   1362: goto -466 -> 896
    //   1365: astore_0
    //   1366: ldc 29
    //   1368: iconst_1
    //   1369: ldc_w 1266
    //   1372: aload_0
    //   1373: invokestatic 1178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1376: goto -32 -> 1344
    //   1379: astore_3
    //   1380: aload_0
    //   1381: astore 10
    //   1383: aload_0
    //   1384: astore 9
    //   1386: aload_2
    //   1387: invokevirtual 1261	java/io/BufferedInputStream:close	()V
    //   1390: aload_0
    //   1391: astore 10
    //   1393: aload_0
    //   1394: astore 9
    //   1396: aload_3
    //   1397: athrow
    //   1398: aload_0
    //   1399: astore 10
    //   1401: aload_0
    //   1402: astore 9
    //   1404: aload_3
    //   1405: new 80	java/lang/StringBuilder
    //   1408: dup
    //   1409: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1412: ldc_w 1268
    //   1415: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: ldc_w 1160
    //   1421: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: ldc_w 1270
    //   1427: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1433: invokevirtual 747	java/lang/String:getBytes	()[B
    //   1436: invokevirtual 1212	java/io/OutputStream:write	([B)V
    //   1439: aload_0
    //   1440: astore 10
    //   1442: aload_0
    //   1443: astore 9
    //   1445: aload_3
    //   1446: invokevirtual 1259	java/io/OutputStream:flush	()V
    //   1449: aload_0
    //   1450: astore 10
    //   1452: aload_0
    //   1453: astore 9
    //   1455: aload_3
    //   1456: invokevirtual 1260	java/io/OutputStream:close	()V
    //   1459: aload_0
    //   1460: astore 10
    //   1462: aload_0
    //   1463: astore 9
    //   1465: new 1195	java/lang/StringBuffer
    //   1468: dup
    //   1469: invokespecial 1196	java/lang/StringBuffer:<init>	()V
    //   1472: astore 4
    //   1474: aload_0
    //   1475: astore 10
    //   1477: aload_0
    //   1478: astore 9
    //   1480: new 928	java/io/BufferedReader
    //   1483: dup
    //   1484: new 930	java/io/InputStreamReader
    //   1487: dup
    //   1488: aload_0
    //   1489: invokevirtual 1271	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1492: invokespecial 937	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1495: invokespecial 940	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1498: astore_3
    //   1499: aload_0
    //   1500: astore 10
    //   1502: aload_0
    //   1503: astore 9
    //   1505: aload_3
    //   1506: invokevirtual 943	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1509: astore_2
    //   1510: aload_2
    //   1511: ifnull +25 -> 1536
    //   1514: aload_0
    //   1515: astore 10
    //   1517: aload_0
    //   1518: astore 9
    //   1520: aload 4
    //   1522: aload_2
    //   1523: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1526: ldc_w 945
    //   1529: invokevirtual 1201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1532: pop
    //   1533: goto -34 -> 1499
    //   1536: aload_0
    //   1537: astore 10
    //   1539: aload_0
    //   1540: astore 9
    //   1542: aload 4
    //   1544: invokevirtual 1208	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1547: astore_2
    //   1548: aload_0
    //   1549: astore 9
    //   1551: aload_3
    //   1552: invokevirtual 947	java/io/BufferedReader:close	()V
    //   1555: aload_2
    //   1556: astore_1
    //   1557: aload_0
    //   1558: ifnull -1013 -> 545
    //   1561: aload_0
    //   1562: invokevirtual 1179	java/net/HttpURLConnection:getResponseCode	()I
    //   1565: istore 8
    //   1567: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1570: ifeq +30 -> 1600
    //   1573: ldc 29
    //   1575: iconst_2
    //   1576: new 80	java/lang/StringBuilder
    //   1579: dup
    //   1580: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1583: ldc_w 1181
    //   1586: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1589: iload 8
    //   1591: invokevirtual 823	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1594: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1597: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1600: aload_0
    //   1601: invokevirtual 1182	java/net/HttpURLConnection:disconnect	()V
    //   1604: aload_2
    //   1605: astore_1
    //   1606: goto -1061 -> 545
    //   1609: astore_1
    //   1610: ldc 29
    //   1612: iconst_1
    //   1613: ldc_w 1266
    //   1616: aload_1
    //   1617: invokestatic 1178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1620: goto -20 -> 1600
    //   1623: astore_1
    //   1624: ldc 29
    //   1626: iconst_1
    //   1627: ldc_w 1266
    //   1630: aload_1
    //   1631: invokestatic 1178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1634: goto -1095 -> 539
    //   1637: astore_1
    //   1638: ldc 29
    //   1640: iconst_1
    //   1641: ldc_w 1266
    //   1644: aload_1
    //   1645: invokestatic 1178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1648: goto -801 -> 847
    //   1651: astore_3
    //   1652: goto -1188 -> 464
    //   1655: ldc_w 1273
    //   1658: astore_2
    //   1659: goto -617 -> 1042
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1662	0	paramHttpURLConnection	HttpURLConnection
    //   0	1662	1	paramString1	String
    //   0	1662	2	paramString2	String
    //   0	1662	3	paramString3	String
    //   0	1662	4	paramMap1	Map<String, String>
    //   0	1662	5	paramMap2	Map<String, String>
    //   0	1662	6	paramMap3	Map<String, String>
    //   0	1662	7	paramBoolean	boolean
    //   504	1086	8	i	int
    //   4	1546	9	localHttpURLConnection1	HttpURLConnection
    //   1	1537	10	localHttpURLConnection2	HttpURLConnection
    //   198	925	11	localObject	Object
    //   1055	131	12	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   6	13	458	java/lang/Exception
    //   19	26	458	java/lang/Exception
    //   32	37	458	java/lang/Exception
    //   43	48	458	java/lang/Exception
    //   54	59	458	java/lang/Exception
    //   65	71	458	java/lang/Exception
    //   77	87	458	java/lang/Exception
    //   93	161	458	java/lang/Exception
    //   167	196	458	java/lang/Exception
    //   211	220	458	java/lang/Exception
    //   231	251	458	java/lang/Exception
    //   257	265	458	java/lang/Exception
    //   271	313	458	java/lang/Exception
    //   319	332	458	java/lang/Exception
    //   338	377	458	java/lang/Exception
    //   383	396	458	java/lang/Exception
    //   402	411	458	java/lang/Exception
    //   417	427	458	java/lang/Exception
    //   433	455	458	java/lang/Exception
    //   589	601	458	java/lang/Exception
    //   612	620	458	java/lang/Exception
    //   626	640	458	java/lang/Exception
    //   646	656	458	java/lang/Exception
    //   662	674	458	java/lang/Exception
    //   680	692	458	java/lang/Exception
    //   698	710	458	java/lang/Exception
    //   721	747	458	java/lang/Exception
    //   753	785	458	java/lang/Exception
    //   791	798	458	java/lang/Exception
    //   860	871	458	java/lang/Exception
    //   882	896	458	java/lang/Exception
    //   902	912	458	java/lang/Exception
    //   918	929	458	java/lang/Exception
    //   935	946	458	java/lang/Exception
    //   952	962	458	java/lang/Exception
    //   972	982	458	java/lang/Exception
    //   988	995	458	java/lang/Exception
    //   1001	1012	458	java/lang/Exception
    //   1028	1039	458	java/lang/Exception
    //   1048	1057	458	java/lang/Exception
    //   1063	1090	458	java/lang/Exception
    //   1096	1140	458	java/lang/Exception
    //   1146	1178	458	java/lang/Exception
    //   1184	1196	458	java/lang/Exception
    //   1202	1226	458	java/lang/Exception
    //   1232	1239	458	java/lang/Exception
    //   1328	1332	458	java/lang/Exception
    //   1358	1362	458	java/lang/Exception
    //   1386	1390	458	java/lang/Exception
    //   1396	1398	458	java/lang/Exception
    //   1404	1439	458	java/lang/Exception
    //   1445	1449	458	java/lang/Exception
    //   1455	1459	458	java/lang/Exception
    //   1465	1474	458	java/lang/Exception
    //   1480	1499	458	java/lang/Exception
    //   1505	1510	458	java/lang/Exception
    //   1520	1533	458	java/lang/Exception
    //   1542	1548	458	java/lang/Exception
    //   6	13	801	finally
    //   19	26	801	finally
    //   32	37	801	finally
    //   43	48	801	finally
    //   54	59	801	finally
    //   65	71	801	finally
    //   77	87	801	finally
    //   93	161	801	finally
    //   167	196	801	finally
    //   211	220	801	finally
    //   231	251	801	finally
    //   257	265	801	finally
    //   271	313	801	finally
    //   319	332	801	finally
    //   338	377	801	finally
    //   383	396	801	finally
    //   402	411	801	finally
    //   417	427	801	finally
    //   433	455	801	finally
    //   467	494	801	finally
    //   589	601	801	finally
    //   612	620	801	finally
    //   626	640	801	finally
    //   646	656	801	finally
    //   662	674	801	finally
    //   680	692	801	finally
    //   698	710	801	finally
    //   721	747	801	finally
    //   753	785	801	finally
    //   791	798	801	finally
    //   860	871	801	finally
    //   882	896	801	finally
    //   902	912	801	finally
    //   918	929	801	finally
    //   935	946	801	finally
    //   952	962	801	finally
    //   972	982	801	finally
    //   988	995	801	finally
    //   1001	1012	801	finally
    //   1028	1039	801	finally
    //   1048	1057	801	finally
    //   1063	1090	801	finally
    //   1096	1140	801	finally
    //   1146	1178	801	finally
    //   1184	1196	801	finally
    //   1202	1226	801	finally
    //   1232	1239	801	finally
    //   1328	1332	801	finally
    //   1358	1362	801	finally
    //   1386	1390	801	finally
    //   1396	1398	801	finally
    //   1404	1439	801	finally
    //   1445	1449	801	finally
    //   1455	1459	801	finally
    //   1465	1474	801	finally
    //   1480	1499	801	finally
    //   1505	1510	801	finally
    //   1520	1533	801	finally
    //   1542	1548	801	finally
    //   1551	1555	801	finally
    //   1239	1247	1265	java/lang/OutOfMemoryError
    //   1253	1262	1265	java/lang/OutOfMemoryError
    //   1336	1344	1365	java/lang/Exception
    //   1239	1247	1379	finally
    //   1253	1262	1379	finally
    //   1267	1320	1379	finally
    //   1561	1600	1609	java/lang/Exception
    //   500	539	1623	java/lang/Exception
    //   807	847	1637	java/lang/Exception
    //   1551	1555	1651	java/lang/Exception
  }
  
  public static String uploadImageWithHttps(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, boolean paramBoolean)
  {
    try
    {
      HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)new URL(paramString1).openConnection();
      HttpUtil.3 local3 = new HttpUtil.3(paramString2);
      if (!paramBoolean) {
        localHttpsURLConnection.setSSLSocketFactory(new SniSSLSocketFactory(paramString2, local3));
      }
      localHttpsURLConnection.setHostnameVerifier(local3);
      localHttpsURLConnection.setRequestProperty("Host", paramString2);
      paramString2 = uploadImage(localHttpsURLConnection, paramString1, paramString3, paramString4, paramMap1, paramMap2, paramMap3, paramBoolean);
      return paramString2;
    }
    catch (MalformedURLException paramString2)
    {
      QLog.e("Q.share.sdk", 1, new Object[] { "urlStr=", paramString1, ", MalformedURLException uploadImage|err=", paramString2 });
      return null;
    }
    catch (IOException paramString2)
    {
      QLog.e("Q.share.sdk", 1, new Object[] { "urlStr=", paramString1, ", IOException uploadImage|err=", paramString2 });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.biz.common.util.HttpUtil
 * JD-Core Version:    0.7.0.1
 */