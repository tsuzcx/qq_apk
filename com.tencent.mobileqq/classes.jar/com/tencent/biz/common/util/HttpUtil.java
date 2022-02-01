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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.http.base.SNIVerifier;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import kzd;
import mqq.app.AppRuntime;
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
import yyi;

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
  private static boolean hasLookupQrDNS;
  private static final SNIVerifier httpVerifier = new SNIVerifier();
  
  public static void addCookie(Bundle paramBundle)
  {
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getSkey(str1);
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
    String str = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getPskey(paramString1, "openmobile.qq.com");
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
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.getApplication();
    if (localObject2 != null) {
      localObject1 = ((BaseApplicationImpl)localObject2).getRuntime();
    }
    if (localObject1 == null) {
      localObject1 = "0";
    }
    do
    {
      return localObject1;
      localObject2 = ((AppRuntime)localObject1).getAccount();
      localObject1 = localObject2;
    } while (localObject2 != null);
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
        localObject = new kzd((KeyStore)localObject);
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
      yyi.a(paramContext, yyi.c);
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
        while (str2.equals(yyi.c))
        {
          str1 = yyi.a(paramContext, str2);
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
        while (str2.equals(yyi.c))
        {
          str1 = yyi.a(paramContext, str2);
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
          if (!str.equals(yyi.c)) {
            continue;
          }
          paramString3 = yyi.a(paramContext, str);
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
          if (!str.equals(yyi.c)) {
            continue;
          }
          paramString3 = yyi.a(paramContext, str);
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
      yyi.a(paramContext, yyi.c);
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
        while (str2.equals(yyi.c))
        {
          str1 = yyi.a(paramContext, str2);
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
    //   9: ldc 231
    //   11: iconst_1
    //   12: new 84	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 853
    //   22: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +17 -> 56
    //   42: aload_1
    //   43: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +10 -> 56
    //   49: aload_2
    //   50: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +5 -> 58
    //   56: aconst_null
    //   57: areturn
    //   58: new 855	java/net/URL
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 856	java/net/URL:<init>	(Ljava/lang/String;)V
    //   66: invokevirtual 860	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   69: checkcast 862	javax/net/ssl/HttpsURLConnection
    //   72: astore 7
    //   74: iload 5
    //   76: istore_3
    //   77: new 864	com/tencent/biz/common/util/HttpUtil$2
    //   80: dup
    //   81: invokespecial 865	com/tencent/biz/common/util/HttpUtil$2:<init>	()V
    //   84: astore_0
    //   85: iload 5
    //   87: istore_3
    //   88: aload 7
    //   90: new 867	com/tencent/mobileqq/utils/httputils/SniSSLSocketFactory
    //   93: dup
    //   94: ldc 13
    //   96: aload_0
    //   97: invokespecial 870	com/tencent/mobileqq/utils/httputils/SniSSLSocketFactory:<init>	(Ljava/lang/String;Ljavax/net/ssl/HostnameVerifier;)V
    //   100: invokevirtual 874	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   103: iload 5
    //   105: istore_3
    //   106: aload 7
    //   108: aload_0
    //   109: invokevirtual 877	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   112: iload 5
    //   114: istore_3
    //   115: aload 7
    //   117: sipush 5000
    //   120: invokevirtual 881	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   123: iload 5
    //   125: istore_3
    //   126: aload 7
    //   128: sipush 30000
    //   131: invokevirtual 884	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   134: iload 5
    //   136: istore_3
    //   137: aload 7
    //   139: ldc 7
    //   141: invokevirtual 887	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   144: iload 5
    //   146: istore_3
    //   147: aload 7
    //   149: ldc_w 716
    //   152: ldc_w 889
    //   155: invokevirtual 892	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: iload 5
    //   160: istore_3
    //   161: aload 7
    //   163: ldc_w 894
    //   166: new 84	java/lang/StringBuilder
    //   169: dup
    //   170: ldc_w 896
    //   173: invokespecial 897	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   176: ldc_w 441
    //   179: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: getstatic 439	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   185: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: ldc_w 441
    //   191: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: getstatic 446	android/os/Build:DEVICE	Ljava/lang/String;
    //   197: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 441
    //   203: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: getstatic 449	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   209: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 441
    //   215: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 899
    //   221: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokevirtual 892	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: iload 5
    //   232: istore_3
    //   233: aload 7
    //   235: ldc_w 341
    //   238: ldc_w 901
    //   241: invokevirtual 892	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: iload 5
    //   246: istore_3
    //   247: aload 7
    //   249: ldc_w 903
    //   252: ldc 13
    //   254: invokevirtual 892	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: iload 5
    //   259: istore_3
    //   260: invokestatic 60	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   263: invokevirtual 64	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   266: iconst_2
    //   267: invokevirtual 74	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   270: checkcast 76	mqq/manager/TicketManager
    //   273: aload_1
    //   274: ldc 13
    //   276: invokeinterface 335 3 0
    //   281: astore_0
    //   282: iload 5
    //   284: istore_3
    //   285: aload_0
    //   286: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   289: ifne +122 -> 411
    //   292: iload 5
    //   294: istore_3
    //   295: aload 7
    //   297: ldc_w 905
    //   300: new 84	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 337
    //   310: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_1
    //   314: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc_w 339
    //   320: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_0
    //   324: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokevirtual 892	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: iload 5
    //   335: istore_3
    //   336: aload 7
    //   338: invokevirtual 908	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   341: istore 6
    //   343: iload 6
    //   345: sipush 200
    //   348: if_icmpeq +158 -> 506
    //   351: iload 5
    //   353: istore_3
    //   354: ldc 231
    //   356: iconst_1
    //   357: new 84	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   364: ldc_w 910
    //   367: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: iload 6
    //   372: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: iload 5
    //   383: istore_3
    //   384: new 912	com/tencent/util/Pair
    //   387: dup
    //   388: iload 6
    //   390: invokestatic 915	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   393: ldc 244
    //   395: invokespecial 918	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   398: astore_0
    //   399: aload 7
    //   401: ifnull +8 -> 409
    //   404: aload 7
    //   406: invokevirtual 921	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   409: aload_0
    //   410: areturn
    //   411: iload 5
    //   413: istore_3
    //   414: aload 7
    //   416: ldc_w 905
    //   419: new 84	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   426: ldc 87
    //   428: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_1
    //   432: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: ldc 93
    //   437: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_2
    //   441: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokevirtual 892	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: goto -117 -> 333
    //   453: astore_1
    //   454: aload 7
    //   456: astore_0
    //   457: ldc 231
    //   459: iconst_1
    //   460: new 84	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   467: ldc_w 923
    //   470: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload_1
    //   474: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 239	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: aload_0
    //   484: ifnull +254 -> 738
    //   487: aload_0
    //   488: invokevirtual 921	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   491: aconst_null
    //   492: astore_0
    //   493: new 912	com/tencent/util/Pair
    //   496: dup
    //   497: iload_3
    //   498: invokestatic 915	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   501: aload_0
    //   502: invokespecial 918	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   505: areturn
    //   506: iload 5
    //   508: istore_3
    //   509: new 84	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   516: astore_0
    //   517: iload 5
    //   519: istore_3
    //   520: new 925	java/io/BufferedReader
    //   523: dup
    //   524: new 927	java/io/InputStreamReader
    //   527: dup
    //   528: aload 7
    //   530: invokevirtual 931	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   533: invokespecial 934	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   536: invokespecial 937	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   539: astore_1
    //   540: iload 5
    //   542: istore_3
    //   543: aload_1
    //   544: invokevirtual 940	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   547: astore_2
    //   548: aload_2
    //   549: ifnull +35 -> 584
    //   552: iload 5
    //   554: istore_3
    //   555: aload_0
    //   556: aload_2
    //   557: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc_w 942
    //   563: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: goto -27 -> 540
    //   570: astore_1
    //   571: aload 7
    //   573: astore_0
    //   574: aload_0
    //   575: ifnull +7 -> 582
    //   578: aload_0
    //   579: invokevirtual 921	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   582: aload_1
    //   583: athrow
    //   584: iload 5
    //   586: istore_3
    //   587: aload_1
    //   588: invokevirtual 944	java/io/BufferedReader:close	()V
    //   591: iload 5
    //   593: istore_3
    //   594: aload_0
    //   595: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: astore_0
    //   599: iload 5
    //   601: istore_3
    //   602: aload_0
    //   603: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   606: ifne +105 -> 711
    //   609: iload 5
    //   611: istore_3
    //   612: new 164	org/json/JSONObject
    //   615: dup
    //   616: aload_0
    //   617: invokespecial 167	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   620: astore_0
    //   621: iload 5
    //   623: istore_3
    //   624: aload_0
    //   625: ldc 169
    //   627: invokevirtual 173	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   630: istore 4
    //   632: iload 4
    //   634: ifne +47 -> 681
    //   637: iload 4
    //   639: istore_3
    //   640: aload_0
    //   641: ldc 179
    //   643: invokevirtual 947	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   646: ifeq +35 -> 681
    //   649: iload 4
    //   651: istore_3
    //   652: aload_0
    //   653: ldc 179
    //   655: invokevirtual 183	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   658: ldc_w 949
    //   661: invokevirtual 950	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   664: astore_0
    //   665: iload 4
    //   667: istore_3
    //   668: aload 7
    //   670: ifnull +73 -> 743
    //   673: aload 7
    //   675: invokevirtual 921	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   678: goto -185 -> 493
    //   681: iload 4
    //   683: istore_3
    //   684: ldc 231
    //   686: iconst_1
    //   687: new 84	java/lang/StringBuilder
    //   690: dup
    //   691: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   694: ldc_w 952
    //   697: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: iload 4
    //   702: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   705: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   711: iload 4
    //   713: istore_3
    //   714: aload 8
    //   716: astore_0
    //   717: goto -49 -> 668
    //   720: astore_1
    //   721: aconst_null
    //   722: astore_0
    //   723: goto -149 -> 574
    //   726: astore_1
    //   727: goto -153 -> 574
    //   730: astore_1
    //   731: iconst_1
    //   732: istore_3
    //   733: aconst_null
    //   734: astore_0
    //   735: goto -278 -> 457
    //   738: aconst_null
    //   739: astore_0
    //   740: goto -247 -> 493
    //   743: goto -250 -> 493
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	746	0	paramString1	String
    //   0	746	1	paramString2	String
    //   0	746	2	paramString3	String
    //   76	657	3	i	int
    //   4	708	4	j	int
    //   7	615	5	k	int
    //   341	48	6	m	int
    //   72	602	7	localHttpsURLConnection	HttpsURLConnection
    //   1	714	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   77	85	453	java/lang/Exception
    //   88	103	453	java/lang/Exception
    //   106	112	453	java/lang/Exception
    //   115	123	453	java/lang/Exception
    //   126	134	453	java/lang/Exception
    //   137	144	453	java/lang/Exception
    //   147	158	453	java/lang/Exception
    //   161	230	453	java/lang/Exception
    //   233	244	453	java/lang/Exception
    //   247	257	453	java/lang/Exception
    //   260	282	453	java/lang/Exception
    //   285	292	453	java/lang/Exception
    //   295	333	453	java/lang/Exception
    //   336	343	453	java/lang/Exception
    //   354	381	453	java/lang/Exception
    //   384	399	453	java/lang/Exception
    //   414	450	453	java/lang/Exception
    //   509	517	453	java/lang/Exception
    //   520	540	453	java/lang/Exception
    //   543	548	453	java/lang/Exception
    //   555	567	453	java/lang/Exception
    //   587	591	453	java/lang/Exception
    //   594	599	453	java/lang/Exception
    //   602	609	453	java/lang/Exception
    //   612	621	453	java/lang/Exception
    //   624	632	453	java/lang/Exception
    //   640	649	453	java/lang/Exception
    //   652	665	453	java/lang/Exception
    //   684	711	453	java/lang/Exception
    //   77	85	570	finally
    //   88	103	570	finally
    //   106	112	570	finally
    //   115	123	570	finally
    //   126	134	570	finally
    //   137	144	570	finally
    //   147	158	570	finally
    //   161	230	570	finally
    //   233	244	570	finally
    //   247	257	570	finally
    //   260	282	570	finally
    //   285	292	570	finally
    //   295	333	570	finally
    //   336	343	570	finally
    //   354	381	570	finally
    //   384	399	570	finally
    //   414	450	570	finally
    //   509	517	570	finally
    //   520	540	570	finally
    //   543	548	570	finally
    //   555	567	570	finally
    //   587	591	570	finally
    //   594	599	570	finally
    //   602	609	570	finally
    //   612	621	570	finally
    //   624	632	570	finally
    //   640	649	570	finally
    //   652	665	570	finally
    //   684	711	570	finally
    //   58	74	720	finally
    //   457	483	726	finally
    //   58	74	730	java/lang/Exception
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
    //   1: invokeinterface 958 1 0
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload 5
    //   17: invokeinterface 963 1 0
    //   22: astore 5
    //   24: aload 5
    //   26: astore_3
    //   27: aload 5
    //   29: astore_2
    //   30: aload 5
    //   32: astore 4
    //   34: new 828	java/io/ByteArrayOutputStream
    //   37: dup
    //   38: invokespecial 964	java/io/ByteArrayOutputStream:<init>	()V
    //   41: astore 6
    //   43: aload 5
    //   45: astore_3
    //   46: aload 5
    //   48: astore_2
    //   49: aload 5
    //   51: astore 4
    //   53: aload_0
    //   54: ldc_w 966
    //   57: invokeinterface 970 2 0
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
    //   87: invokeinterface 975 1 0
    //   92: invokevirtual 978	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   95: ldc_w 709
    //   98: invokevirtual 685	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +23 -> 124
    //   104: aload 5
    //   106: astore_3
    //   107: aload 5
    //   109: astore_2
    //   110: aload 5
    //   112: astore 4
    //   114: new 980	java/util/zip/GZIPInputStream
    //   117: dup
    //   118: aload 5
    //   120: invokespecial 981	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
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
    //   148: invokevirtual 987	java/io/InputStream:read	([B)I
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
    //   170: invokevirtual 991	java/io/ByteArrayOutputStream:write	([BII)V
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
    //   187: invokevirtual 992	java/io/InputStream:close	()V
    //   190: aload_0
    //   191: athrow
    //   192: aload_0
    //   193: ifnull +7 -> 200
    //   196: aload_0
    //   197: invokevirtual 992	java/io/InputStream:close	()V
    //   200: aload 6
    //   202: areturn
    //   203: astore_0
    //   204: aload 4
    //   206: astore_2
    //   207: new 328	java/io/IOException
    //   210: dup
    //   211: invokespecial 993	java/io/IOException:<init>	()V
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
      localObject5 = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
      localObject4 = ((TicketManager)localObject5).getPskey((String)localObject2, "openmobile.qq.com");
      localObject5 = ((TicketManager)localObject5).getSkey((String)localObject2);
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label295;
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
          label295:
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
            break label648;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error retcode:" + i);
          break label648;
        }
        paramBundle = ((JSONObject)localObject1).getJSONObject("result");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label651;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          break label651;
        }
        paramBundle = paramBundle.getJSONArray("list");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label654;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          break label654;
        }
        if (paramBundle.length() == localArrayList.size())
        {
          i = 0;
          if (i < paramBundle.length())
          {
            localObject1 = paramBundle.getString(i);
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label657;
            }
            localHashMap.put(localArrayList.get(i), localObject1);
            break label657;
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
      label648:
      return localHashMap;
      label651:
      return localHashMap;
      label654:
      return localHashMap;
      label657:
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
    //   10: invokevirtual 1140	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   13: aload_0
    //   14: astore 10
    //   16: aload_0
    //   17: astore 9
    //   19: aload_0
    //   20: sipush 30000
    //   23: invokevirtual 1141	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   26: aload_0
    //   27: astore 10
    //   29: aload_0
    //   30: astore 9
    //   32: aload_0
    //   33: iconst_1
    //   34: invokevirtual 1145	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   37: aload_0
    //   38: astore 10
    //   40: aload_0
    //   41: astore 9
    //   43: aload_0
    //   44: iconst_1
    //   45: invokevirtual 1148	java/net/HttpURLConnection:setDoInput	(Z)V
    //   48: aload_0
    //   49: astore 10
    //   51: aload_0
    //   52: astore 9
    //   54: aload_0
    //   55: iconst_0
    //   56: invokevirtual 1151	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   59: aload_0
    //   60: astore 10
    //   62: aload_0
    //   63: astore 9
    //   65: aload_0
    //   66: ldc 21
    //   68: invokevirtual 1152	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: astore 10
    //   74: aload_0
    //   75: astore 9
    //   77: aload_0
    //   78: ldc_w 716
    //   81: ldc_w 889
    //   84: invokevirtual 1153	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_0
    //   88: astore 10
    //   90: aload_0
    //   91: astore 9
    //   93: aload_0
    //   94: ldc_w 894
    //   97: new 84	java/lang/StringBuilder
    //   100: dup
    //   101: ldc_w 896
    //   104: invokespecial 897	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: ldc_w 441
    //   110: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: getstatic 439	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   116: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc_w 441
    //   122: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: getstatic 446	android/os/Build:DEVICE	Ljava/lang/String;
    //   128: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 441
    //   134: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: getstatic 449	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   140: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 441
    //   146: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 899
    //   152: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokevirtual 1153	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_0
    //   162: astore 10
    //   164: aload_0
    //   165: astore 9
    //   167: aload_0
    //   168: ldc_w 735
    //   171: new 84	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 1155
    //   181: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 1157
    //   187: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokevirtual 1153	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload 6
    //   198: astore 11
    //   200: aload 6
    //   202: ifnonnull +18 -> 220
    //   205: aload_0
    //   206: astore 10
    //   208: aload_0
    //   209: astore 9
    //   211: new 108	java/util/HashMap
    //   214: dup
    //   215: invokespecial 109	java/util/HashMap:<init>	()V
    //   218: astore 11
    //   220: iload 7
    //   222: ifeq +94 -> 316
    //   225: aload_0
    //   226: astore 10
    //   228: aload_0
    //   229: astore 9
    //   231: invokestatic 60	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   234: invokevirtual 64	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   237: iconst_2
    //   238: invokevirtual 74	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   241: checkcast 76	mqq/manager/TicketManager
    //   244: aload_2
    //   245: ldc 13
    //   247: invokeinterface 335 3 0
    //   252: astore 6
    //   254: aload_0
    //   255: astore 10
    //   257: aload_0
    //   258: astore 9
    //   260: aload 6
    //   262: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: ifne +51 -> 316
    //   268: aload_0
    //   269: astore 10
    //   271: aload_0
    //   272: astore 9
    //   274: aload 11
    //   276: ldc_w 905
    //   279: new 84	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 337
    //   289: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_2
    //   293: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: ldc_w 339
    //   299: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload 6
    //   304: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokeinterface 1158 3 0
    //   315: pop
    //   316: aload_0
    //   317: astore 10
    //   319: aload_0
    //   320: astore 9
    //   322: aload 11
    //   324: ldc_w 905
    //   327: invokeinterface 1161 2 0
    //   332: ifne +48 -> 380
    //   335: aload_0
    //   336: astore 10
    //   338: aload_0
    //   339: astore 9
    //   341: aload 11
    //   343: ldc_w 905
    //   346: new 84	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   353: ldc 87
    //   355: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_2
    //   359: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc 93
    //   364: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_3
    //   368: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokeinterface 1158 3 0
    //   379: pop
    //   380: aload_0
    //   381: astore 10
    //   383: aload_0
    //   384: astore 9
    //   386: aload 11
    //   388: invokeinterface 1164 1 0
    //   393: invokeinterface 128 1 0
    //   398: astore_2
    //   399: aload_0
    //   400: astore 10
    //   402: aload_0
    //   403: astore 9
    //   405: aload_2
    //   406: invokeinterface 134 1 0
    //   411: ifeq +139 -> 550
    //   414: aload_0
    //   415: astore 10
    //   417: aload_0
    //   418: astore 9
    //   420: aload_2
    //   421: invokeinterface 138 1 0
    //   426: checkcast 1166	java/util/Map$Entry
    //   429: astore_3
    //   430: aload_0
    //   431: astore 10
    //   433: aload_0
    //   434: astore 9
    //   436: aload_0
    //   437: aload_3
    //   438: invokeinterface 1169 1 0
    //   443: checkcast 140	java/lang/String
    //   446: aload_3
    //   447: invokeinterface 1171 1 0
    //   452: checkcast 140	java/lang/String
    //   455: invokevirtual 1153	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   458: goto -59 -> 399
    //   461: astore_3
    //   462: aconst_null
    //   463: astore_2
    //   464: aload 10
    //   466: astore_0
    //   467: aload_0
    //   468: astore 9
    //   470: ldc 29
    //   472: iconst_1
    //   473: new 84	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   480: ldc_w 1173
    //   483: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload_1
    //   487: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: aload_3
    //   494: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   497: aload_2
    //   498: astore_1
    //   499: aload_0
    //   500: ifnull +48 -> 548
    //   503: aload_0
    //   504: invokevirtual 1176	java/net/HttpURLConnection:getResponseCode	()I
    //   507: istore 8
    //   509: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq +30 -> 542
    //   515: ldc 29
    //   517: iconst_2
    //   518: new 84	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   525: ldc_w 1178
    //   528: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: iload 8
    //   533: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: aload_0
    //   543: invokevirtual 1179	java/net/HttpURLConnection:disconnect	()V
    //   546: aload_2
    //   547: astore_1
    //   548: aload_1
    //   549: areturn
    //   550: aload_0
    //   551: astore 10
    //   553: aload_0
    //   554: astore 9
    //   556: new 1181	java/io/DataOutputStream
    //   559: dup
    //   560: aload_0
    //   561: invokevirtual 1185	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   564: invokespecial 1188	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   567: astore_3
    //   568: aload 4
    //   570: ifnull +268 -> 838
    //   573: aload_0
    //   574: astore 10
    //   576: aload_0
    //   577: astore 9
    //   579: new 1190	java/lang/StringBuffer
    //   582: dup
    //   583: invokespecial 1191	java/lang/StringBuffer:<init>	()V
    //   586: astore_2
    //   587: aload_0
    //   588: astore 10
    //   590: aload_0
    //   591: astore 9
    //   593: aload 4
    //   595: invokeinterface 1164 1 0
    //   600: invokeinterface 128 1 0
    //   605: astore 6
    //   607: aload_0
    //   608: astore 10
    //   610: aload_0
    //   611: astore 9
    //   613: aload 6
    //   615: invokeinterface 134 1 0
    //   620: ifeq +201 -> 821
    //   623: aload_0
    //   624: astore 10
    //   626: aload_0
    //   627: astore 9
    //   629: aload 6
    //   631: invokeinterface 138 1 0
    //   636: checkcast 1166	java/util/Map$Entry
    //   639: astore 11
    //   641: aload_0
    //   642: astore 10
    //   644: aload_0
    //   645: astore 9
    //   647: aload 11
    //   649: invokeinterface 1169 1 0
    //   654: checkcast 140	java/lang/String
    //   657: astore 4
    //   659: aload_0
    //   660: astore 10
    //   662: aload_0
    //   663: astore 9
    //   665: aload 11
    //   667: invokeinterface 1171 1 0
    //   672: checkcast 140	java/lang/String
    //   675: astore 11
    //   677: aload 11
    //   679: ifnull -72 -> 607
    //   682: aload_0
    //   683: astore 10
    //   685: aload_0
    //   686: astore 9
    //   688: aload_2
    //   689: ldc_w 1193
    //   692: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   695: ldc_w 1198
    //   698: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   701: ldc_w 1157
    //   704: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   707: ldc_w 1193
    //   710: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   713: pop
    //   714: aload_0
    //   715: astore 10
    //   717: aload_0
    //   718: astore 9
    //   720: aload_2
    //   721: new 84	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   728: ldc_w 1200
    //   731: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: aload 4
    //   736: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: ldc_w 1202
    //   742: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   751: pop
    //   752: aload_0
    //   753: astore 10
    //   755: aload_0
    //   756: astore 9
    //   758: aload_2
    //   759: aload 11
    //   761: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   764: pop
    //   765: goto -158 -> 607
    //   768: astore_1
    //   769: aload 9
    //   771: ifnull +48 -> 819
    //   774: aload 9
    //   776: invokevirtual 1176	java/net/HttpURLConnection:getResponseCode	()I
    //   779: istore 8
    //   781: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   784: ifeq +30 -> 814
    //   787: ldc 29
    //   789: iconst_2
    //   790: new 84	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   797: ldc_w 1178
    //   800: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: iload 8
    //   805: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   808: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   814: aload 9
    //   816: invokevirtual 1179	java/net/HttpURLConnection:disconnect	()V
    //   819: aload_1
    //   820: athrow
    //   821: aload_0
    //   822: astore 10
    //   824: aload_0
    //   825: astore 9
    //   827: aload_3
    //   828: aload_2
    //   829: invokevirtual 1203	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   832: invokevirtual 744	java/lang/String:getBytes	()[B
    //   835: invokevirtual 1207	java/io/OutputStream:write	([B)V
    //   838: aload 5
    //   840: ifnull +527 -> 1367
    //   843: aload_0
    //   844: astore 10
    //   846: aload_0
    //   847: astore 9
    //   849: aload 5
    //   851: invokeinterface 1164 1 0
    //   856: invokeinterface 128 1 0
    //   861: astore 4
    //   863: aload_0
    //   864: astore 10
    //   866: aload_0
    //   867: astore 9
    //   869: aload 4
    //   871: invokeinterface 134 1 0
    //   876: ifeq +491 -> 1367
    //   879: aload_0
    //   880: astore 10
    //   882: aload_0
    //   883: astore 9
    //   885: aload 4
    //   887: invokeinterface 138 1 0
    //   892: checkcast 1166	java/util/Map$Entry
    //   895: astore_2
    //   896: aload_0
    //   897: astore 10
    //   899: aload_0
    //   900: astore 9
    //   902: aload_2
    //   903: invokeinterface 1169 1 0
    //   908: checkcast 140	java/lang/String
    //   911: astore 6
    //   913: aload_0
    //   914: astore 10
    //   916: aload_0
    //   917: astore 9
    //   919: aload_2
    //   920: invokeinterface 1171 1 0
    //   925: checkcast 140	java/lang/String
    //   928: astore_2
    //   929: aload_2
    //   930: ifnull -67 -> 863
    //   933: aload_0
    //   934: astore 10
    //   936: aload_0
    //   937: astore 9
    //   939: new 1209	java/io/File
    //   942: dup
    //   943: aload_2
    //   944: invokespecial 1210	java/io/File:<init>	(Ljava/lang/String;)V
    //   947: astore 5
    //   949: aload_0
    //   950: astore 10
    //   952: aload_0
    //   953: astore 9
    //   955: aload 5
    //   957: invokevirtual 1213	java/io/File:getName	()Ljava/lang/String;
    //   960: astore 11
    //   962: aload_0
    //   963: astore 10
    //   965: aload_0
    //   966: astore 9
    //   968: aload 11
    //   970: ldc_w 1215
    //   973: invokevirtual 1218	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   976: ifeq +3 -> 979
    //   979: ldc_w 1220
    //   982: astore_2
    //   983: ldc_w 1220
    //   986: ifnull +635 -> 1621
    //   989: aload_0
    //   990: astore 10
    //   992: aload_0
    //   993: astore 9
    //   995: ldc_w 1220
    //   998: ldc 244
    //   1000: invokevirtual 698	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1003: ifeq +6 -> 1009
    //   1006: goto +615 -> 1621
    //   1009: aload_0
    //   1010: astore 10
    //   1012: aload_0
    //   1013: astore 9
    //   1015: new 1190	java/lang/StringBuffer
    //   1018: dup
    //   1019: invokespecial 1191	java/lang/StringBuffer:<init>	()V
    //   1022: astore 12
    //   1024: aload_0
    //   1025: astore 10
    //   1027: aload_0
    //   1028: astore 9
    //   1030: aload 12
    //   1032: ldc_w 1193
    //   1035: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1038: ldc_w 1198
    //   1041: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1044: ldc_w 1157
    //   1047: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1050: ldc_w 1193
    //   1053: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1056: pop
    //   1057: aload_0
    //   1058: astore 10
    //   1060: aload_0
    //   1061: astore 9
    //   1063: aload 12
    //   1065: new 84	java/lang/StringBuilder
    //   1068: dup
    //   1069: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   1072: ldc_w 1200
    //   1075: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: aload 6
    //   1080: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: ldc_w 1222
    //   1086: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: aload 11
    //   1091: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: ldc_w 1224
    //   1097: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1103: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1106: pop
    //   1107: aload_0
    //   1108: astore 10
    //   1110: aload_0
    //   1111: astore 9
    //   1113: aload 12
    //   1115: new 84	java/lang/StringBuilder
    //   1118: dup
    //   1119: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   1122: ldc_w 1226
    //   1125: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1128: aload_2
    //   1129: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: ldc_w 1228
    //   1135: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1141: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1144: pop
    //   1145: aload_0
    //   1146: astore 10
    //   1148: aload_0
    //   1149: astore 9
    //   1151: aload_3
    //   1152: aload 12
    //   1154: invokevirtual 1203	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1157: invokevirtual 744	java/lang/String:getBytes	()[B
    //   1160: invokevirtual 1207	java/io/OutputStream:write	([B)V
    //   1163: aload_0
    //   1164: astore 10
    //   1166: aload_0
    //   1167: astore 9
    //   1169: new 1230	java/io/BufferedInputStream
    //   1172: dup
    //   1173: new 1230	java/io/BufferedInputStream
    //   1176: dup
    //   1177: new 1232	java/io/FileInputStream
    //   1180: dup
    //   1181: aload 5
    //   1183: invokespecial 1235	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1186: invokespecial 1236	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1189: invokespecial 1236	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1192: astore_2
    //   1193: aload_0
    //   1194: astore 10
    //   1196: aload_0
    //   1197: astore 9
    //   1199: sipush 3072
    //   1202: newarray byte
    //   1204: astore 6
    //   1206: aload_2
    //   1207: aload 6
    //   1209: invokevirtual 1237	java/io/BufferedInputStream:read	([B)I
    //   1212: istore 8
    //   1214: iload 8
    //   1216: iconst_m1
    //   1217: if_icmpeq +104 -> 1321
    //   1220: aload_3
    //   1221: aload 6
    //   1223: iconst_0
    //   1224: iload 8
    //   1226: invokevirtual 1238	java/io/OutputStream:write	([BII)V
    //   1229: goto -23 -> 1206
    //   1232: astore 4
    //   1234: ldc 29
    //   1236: iconst_1
    //   1237: iconst_4
    //   1238: anewarray 4	java/lang/Object
    //   1241: dup
    //   1242: iconst_0
    //   1243: ldc_w 1240
    //   1246: aastore
    //   1247: dup
    //   1248: iconst_1
    //   1249: aload 5
    //   1251: invokevirtual 1243	java/io/File:length	()J
    //   1254: invokestatic 1246	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1257: aastore
    //   1258: dup
    //   1259: iconst_2
    //   1260: ldc_w 1248
    //   1263: aastore
    //   1264: dup
    //   1265: iconst_3
    //   1266: aload 5
    //   1268: invokevirtual 1251	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1271: aastore
    //   1272: invokestatic 1136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1275: aload_3
    //   1276: invokevirtual 1254	java/io/OutputStream:flush	()V
    //   1279: aload_3
    //   1280: invokevirtual 1255	java/io/OutputStream:close	()V
    //   1283: aload_0
    //   1284: invokevirtual 1179	java/net/HttpURLConnection:disconnect	()V
    //   1287: aconst_null
    //   1288: astore 9
    //   1290: aconst_null
    //   1291: astore 10
    //   1293: aconst_null
    //   1294: astore_0
    //   1295: aload_2
    //   1296: invokevirtual 1256	java/io/BufferedInputStream:close	()V
    //   1299: aload_0
    //   1300: astore_1
    //   1301: iconst_0
    //   1302: ifeq -754 -> 548
    //   1305: new 1258	java/lang/NullPointerException
    //   1308: dup
    //   1309: invokespecial 1259	java/lang/NullPointerException:<init>	()V
    //   1312: athrow
    //   1313: new 1258	java/lang/NullPointerException
    //   1316: dup
    //   1317: invokespecial 1259	java/lang/NullPointerException:<init>	()V
    //   1320: athrow
    //   1321: aload_0
    //   1322: astore 10
    //   1324: aload_0
    //   1325: astore 9
    //   1327: aload_2
    //   1328: invokevirtual 1256	java/io/BufferedInputStream:close	()V
    //   1331: goto -468 -> 863
    //   1334: astore_0
    //   1335: ldc 29
    //   1337: iconst_1
    //   1338: ldc_w 1261
    //   1341: aload_0
    //   1342: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1345: goto -32 -> 1313
    //   1348: astore_3
    //   1349: aload_0
    //   1350: astore 10
    //   1352: aload_0
    //   1353: astore 9
    //   1355: aload_2
    //   1356: invokevirtual 1256	java/io/BufferedInputStream:close	()V
    //   1359: aload_0
    //   1360: astore 10
    //   1362: aload_0
    //   1363: astore 9
    //   1365: aload_3
    //   1366: athrow
    //   1367: aload_0
    //   1368: astore 10
    //   1370: aload_0
    //   1371: astore 9
    //   1373: aload_3
    //   1374: new 84	java/lang/StringBuilder
    //   1377: dup
    //   1378: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   1381: ldc_w 1263
    //   1384: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: ldc_w 1157
    //   1390: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: ldc_w 1265
    //   1396: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1402: invokevirtual 744	java/lang/String:getBytes	()[B
    //   1405: invokevirtual 1207	java/io/OutputStream:write	([B)V
    //   1408: aload_0
    //   1409: astore 10
    //   1411: aload_0
    //   1412: astore 9
    //   1414: aload_3
    //   1415: invokevirtual 1254	java/io/OutputStream:flush	()V
    //   1418: aload_0
    //   1419: astore 10
    //   1421: aload_0
    //   1422: astore 9
    //   1424: aload_3
    //   1425: invokevirtual 1255	java/io/OutputStream:close	()V
    //   1428: aload_0
    //   1429: astore 10
    //   1431: aload_0
    //   1432: astore 9
    //   1434: new 1190	java/lang/StringBuffer
    //   1437: dup
    //   1438: invokespecial 1191	java/lang/StringBuffer:<init>	()V
    //   1441: astore 4
    //   1443: aload_0
    //   1444: astore 10
    //   1446: aload_0
    //   1447: astore 9
    //   1449: new 925	java/io/BufferedReader
    //   1452: dup
    //   1453: new 927	java/io/InputStreamReader
    //   1456: dup
    //   1457: aload_0
    //   1458: invokevirtual 1266	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1461: invokespecial 934	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1464: invokespecial 937	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1467: astore_3
    //   1468: aload_0
    //   1469: astore 10
    //   1471: aload_0
    //   1472: astore 9
    //   1474: aload_3
    //   1475: invokevirtual 940	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1478: astore_2
    //   1479: aload_2
    //   1480: ifnull +25 -> 1505
    //   1483: aload_0
    //   1484: astore 10
    //   1486: aload_0
    //   1487: astore 9
    //   1489: aload 4
    //   1491: aload_2
    //   1492: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1495: ldc_w 942
    //   1498: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1501: pop
    //   1502: goto -34 -> 1468
    //   1505: aload_0
    //   1506: astore 10
    //   1508: aload_0
    //   1509: astore 9
    //   1511: aload 4
    //   1513: invokevirtual 1203	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1516: astore_2
    //   1517: aload_0
    //   1518: astore 9
    //   1520: aload_3
    //   1521: invokevirtual 944	java/io/BufferedReader:close	()V
    //   1524: aload_2
    //   1525: astore_1
    //   1526: aload_0
    //   1527: ifnull -979 -> 548
    //   1530: aload_0
    //   1531: invokevirtual 1176	java/net/HttpURLConnection:getResponseCode	()I
    //   1534: istore 8
    //   1536: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1539: ifeq +30 -> 1569
    //   1542: ldc 29
    //   1544: iconst_2
    //   1545: new 84	java/lang/StringBuilder
    //   1548: dup
    //   1549: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   1552: ldc_w 1178
    //   1555: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: iload 8
    //   1560: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1563: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1566: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1569: aload_0
    //   1570: invokevirtual 1179	java/net/HttpURLConnection:disconnect	()V
    //   1573: aload_2
    //   1574: areturn
    //   1575: astore_1
    //   1576: ldc 29
    //   1578: iconst_1
    //   1579: ldc_w 1261
    //   1582: aload_1
    //   1583: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1586: goto -17 -> 1569
    //   1589: astore_1
    //   1590: ldc 29
    //   1592: iconst_1
    //   1593: ldc_w 1261
    //   1596: aload_1
    //   1597: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1600: goto -1058 -> 542
    //   1603: astore_0
    //   1604: ldc 29
    //   1606: iconst_1
    //   1607: ldc_w 1261
    //   1610: aload_0
    //   1611: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1614: goto -800 -> 814
    //   1617: astore_3
    //   1618: goto -1151 -> 467
    //   1621: ldc_w 1268
    //   1624: astore_2
    //   1625: goto -616 -> 1009
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1628	0	paramHttpURLConnection	HttpURLConnection
    //   0	1628	1	paramString1	String
    //   0	1628	2	paramString2	String
    //   0	1628	3	paramString3	String
    //   0	1628	4	paramMap1	Map<String, String>
    //   0	1628	5	paramMap2	Map<String, String>
    //   0	1628	6	paramMap3	Map<String, String>
    //   0	1628	7	paramBoolean	boolean
    //   507	1052	8	i	int
    //   4	1515	9	localHttpURLConnection1	HttpURLConnection
    //   1	1506	10	localHttpURLConnection2	HttpURLConnection
    //   198	892	11	localObject	Object
    //   1022	131	12	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   6	13	461	java/lang/Exception
    //   19	26	461	java/lang/Exception
    //   32	37	461	java/lang/Exception
    //   43	48	461	java/lang/Exception
    //   54	59	461	java/lang/Exception
    //   65	71	461	java/lang/Exception
    //   77	87	461	java/lang/Exception
    //   93	161	461	java/lang/Exception
    //   167	196	461	java/lang/Exception
    //   211	220	461	java/lang/Exception
    //   231	254	461	java/lang/Exception
    //   260	268	461	java/lang/Exception
    //   274	316	461	java/lang/Exception
    //   322	335	461	java/lang/Exception
    //   341	380	461	java/lang/Exception
    //   386	399	461	java/lang/Exception
    //   405	414	461	java/lang/Exception
    //   420	430	461	java/lang/Exception
    //   436	458	461	java/lang/Exception
    //   556	568	461	java/lang/Exception
    //   579	587	461	java/lang/Exception
    //   593	607	461	java/lang/Exception
    //   613	623	461	java/lang/Exception
    //   629	641	461	java/lang/Exception
    //   647	659	461	java/lang/Exception
    //   665	677	461	java/lang/Exception
    //   688	714	461	java/lang/Exception
    //   720	752	461	java/lang/Exception
    //   758	765	461	java/lang/Exception
    //   827	838	461	java/lang/Exception
    //   849	863	461	java/lang/Exception
    //   869	879	461	java/lang/Exception
    //   885	896	461	java/lang/Exception
    //   902	913	461	java/lang/Exception
    //   919	929	461	java/lang/Exception
    //   939	949	461	java/lang/Exception
    //   955	962	461	java/lang/Exception
    //   968	979	461	java/lang/Exception
    //   995	1006	461	java/lang/Exception
    //   1015	1024	461	java/lang/Exception
    //   1030	1057	461	java/lang/Exception
    //   1063	1107	461	java/lang/Exception
    //   1113	1145	461	java/lang/Exception
    //   1151	1163	461	java/lang/Exception
    //   1169	1193	461	java/lang/Exception
    //   1199	1206	461	java/lang/Exception
    //   1295	1299	461	java/lang/Exception
    //   1327	1331	461	java/lang/Exception
    //   1355	1359	461	java/lang/Exception
    //   1365	1367	461	java/lang/Exception
    //   1373	1408	461	java/lang/Exception
    //   1414	1418	461	java/lang/Exception
    //   1424	1428	461	java/lang/Exception
    //   1434	1443	461	java/lang/Exception
    //   1449	1468	461	java/lang/Exception
    //   1474	1479	461	java/lang/Exception
    //   1489	1502	461	java/lang/Exception
    //   1511	1517	461	java/lang/Exception
    //   6	13	768	finally
    //   19	26	768	finally
    //   32	37	768	finally
    //   43	48	768	finally
    //   54	59	768	finally
    //   65	71	768	finally
    //   77	87	768	finally
    //   93	161	768	finally
    //   167	196	768	finally
    //   211	220	768	finally
    //   231	254	768	finally
    //   260	268	768	finally
    //   274	316	768	finally
    //   322	335	768	finally
    //   341	380	768	finally
    //   386	399	768	finally
    //   405	414	768	finally
    //   420	430	768	finally
    //   436	458	768	finally
    //   470	497	768	finally
    //   556	568	768	finally
    //   579	587	768	finally
    //   593	607	768	finally
    //   613	623	768	finally
    //   629	641	768	finally
    //   647	659	768	finally
    //   665	677	768	finally
    //   688	714	768	finally
    //   720	752	768	finally
    //   758	765	768	finally
    //   827	838	768	finally
    //   849	863	768	finally
    //   869	879	768	finally
    //   885	896	768	finally
    //   902	913	768	finally
    //   919	929	768	finally
    //   939	949	768	finally
    //   955	962	768	finally
    //   968	979	768	finally
    //   995	1006	768	finally
    //   1015	1024	768	finally
    //   1030	1057	768	finally
    //   1063	1107	768	finally
    //   1113	1145	768	finally
    //   1151	1163	768	finally
    //   1169	1193	768	finally
    //   1199	1206	768	finally
    //   1295	1299	768	finally
    //   1327	1331	768	finally
    //   1355	1359	768	finally
    //   1365	1367	768	finally
    //   1373	1408	768	finally
    //   1414	1418	768	finally
    //   1424	1428	768	finally
    //   1434	1443	768	finally
    //   1449	1468	768	finally
    //   1474	1479	768	finally
    //   1489	1502	768	finally
    //   1511	1517	768	finally
    //   1520	1524	768	finally
    //   1206	1214	1232	java/lang/OutOfMemoryError
    //   1220	1229	1232	java/lang/OutOfMemoryError
    //   1305	1313	1334	java/lang/Exception
    //   1206	1214	1348	finally
    //   1220	1229	1348	finally
    //   1234	1287	1348	finally
    //   1530	1569	1575	java/lang/Exception
    //   503	542	1589	java/lang/Exception
    //   774	814	1603	java/lang/Exception
    //   1520	1524	1617	java/lang/Exception
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