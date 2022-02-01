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
import kzg;
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
import znl;

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
        localObject = new kzg((KeyStore)localObject);
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
      znl.a(paramContext, znl.c);
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
        while (str2.equals(znl.c))
        {
          str1 = znl.a(paramContext, str2);
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
        while (str2.equals(znl.c))
        {
          str1 = znl.a(paramContext, str2);
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
          if (!str.equals(znl.c)) {
            continue;
          }
          paramString3 = znl.a(paramContext, str);
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
          if (!str.equals(znl.c)) {
            continue;
          }
          paramString3 = znl.a(paramContext, str);
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
      znl.a(paramContext, znl.c);
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
        while (str2.equals(znl.c))
        {
          str1 = znl.a(paramContext, str2);
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
    //   398: astore_3
    //   399: aload_0
    //   400: astore 10
    //   402: aload_0
    //   403: astore 9
    //   405: aload_3
    //   406: invokeinterface 134 1 0
    //   411: ifeq +175 -> 586
    //   414: aload_0
    //   415: astore 10
    //   417: aload_0
    //   418: astore 9
    //   420: aload_3
    //   421: invokeinterface 138 1 0
    //   426: checkcast 1166	java/util/Map$Entry
    //   429: astore_2
    //   430: aload_0
    //   431: astore 10
    //   433: aload_0
    //   434: astore 9
    //   436: aload_0
    //   437: aload_2
    //   438: invokeinterface 1169 1 0
    //   443: checkcast 140	java/lang/String
    //   446: aload_2
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
    //   549: astore_0
    //   550: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   553: ifeq +31 -> 584
    //   556: ldc 29
    //   558: iconst_2
    //   559: new 84	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   566: ldc_w 1181
    //   569: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload_1
    //   573: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: aload_1
    //   583: astore_0
    //   584: aload_0
    //   585: areturn
    //   586: aload_0
    //   587: astore 10
    //   589: aload_0
    //   590: astore 9
    //   592: new 1183	java/io/DataOutputStream
    //   595: dup
    //   596: aload_0
    //   597: invokevirtual 1187	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   600: invokespecial 1190	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   603: astore_3
    //   604: aload 4
    //   606: ifnull +268 -> 874
    //   609: aload_0
    //   610: astore 10
    //   612: aload_0
    //   613: astore 9
    //   615: new 1192	java/lang/StringBuffer
    //   618: dup
    //   619: invokespecial 1193	java/lang/StringBuffer:<init>	()V
    //   622: astore_2
    //   623: aload_0
    //   624: astore 10
    //   626: aload_0
    //   627: astore 9
    //   629: aload 4
    //   631: invokeinterface 1164 1 0
    //   636: invokeinterface 128 1 0
    //   641: astore 4
    //   643: aload_0
    //   644: astore 10
    //   646: aload_0
    //   647: astore 9
    //   649: aload 4
    //   651: invokeinterface 134 1 0
    //   656: ifeq +201 -> 857
    //   659: aload_0
    //   660: astore 10
    //   662: aload_0
    //   663: astore 9
    //   665: aload 4
    //   667: invokeinterface 138 1 0
    //   672: checkcast 1166	java/util/Map$Entry
    //   675: astore 11
    //   677: aload_0
    //   678: astore 10
    //   680: aload_0
    //   681: astore 9
    //   683: aload 11
    //   685: invokeinterface 1169 1 0
    //   690: checkcast 140	java/lang/String
    //   693: astore 6
    //   695: aload_0
    //   696: astore 10
    //   698: aload_0
    //   699: astore 9
    //   701: aload 11
    //   703: invokeinterface 1171 1 0
    //   708: checkcast 140	java/lang/String
    //   711: astore 11
    //   713: aload 11
    //   715: ifnull -72 -> 643
    //   718: aload_0
    //   719: astore 10
    //   721: aload_0
    //   722: astore 9
    //   724: aload_2
    //   725: ldc_w 1195
    //   728: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   731: ldc_w 1200
    //   734: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   737: ldc_w 1157
    //   740: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   743: ldc_w 1195
    //   746: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   749: pop
    //   750: aload_0
    //   751: astore 10
    //   753: aload_0
    //   754: astore 9
    //   756: aload_2
    //   757: new 84	java/lang/StringBuilder
    //   760: dup
    //   761: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   764: ldc_w 1202
    //   767: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: aload 6
    //   772: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: ldc_w 1204
    //   778: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   787: pop
    //   788: aload_0
    //   789: astore 10
    //   791: aload_0
    //   792: astore 9
    //   794: aload_2
    //   795: aload 11
    //   797: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   800: pop
    //   801: goto -158 -> 643
    //   804: astore_1
    //   805: aload 9
    //   807: ifnull +48 -> 855
    //   810: aload 9
    //   812: invokevirtual 1176	java/net/HttpURLConnection:getResponseCode	()I
    //   815: istore 8
    //   817: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   820: ifeq +30 -> 850
    //   823: ldc 29
    //   825: iconst_2
    //   826: new 84	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   833: ldc_w 1178
    //   836: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: iload 8
    //   841: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   844: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   850: aload 9
    //   852: invokevirtual 1179	java/net/HttpURLConnection:disconnect	()V
    //   855: aload_1
    //   856: athrow
    //   857: aload_0
    //   858: astore 10
    //   860: aload_0
    //   861: astore 9
    //   863: aload_3
    //   864: aload_2
    //   865: invokevirtual 1205	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   868: invokevirtual 744	java/lang/String:getBytes	()[B
    //   871: invokevirtual 1209	java/io/OutputStream:write	([B)V
    //   874: aload 5
    //   876: ifnull +525 -> 1401
    //   879: aload_0
    //   880: astore 10
    //   882: aload_0
    //   883: astore 9
    //   885: aload 5
    //   887: invokeinterface 1164 1 0
    //   892: invokeinterface 128 1 0
    //   897: astore 4
    //   899: aload_0
    //   900: astore 10
    //   902: aload_0
    //   903: astore 9
    //   905: aload 4
    //   907: invokeinterface 134 1 0
    //   912: ifeq +489 -> 1401
    //   915: aload_0
    //   916: astore 10
    //   918: aload_0
    //   919: astore 9
    //   921: aload 4
    //   923: invokeinterface 138 1 0
    //   928: checkcast 1166	java/util/Map$Entry
    //   931: astore_2
    //   932: aload_0
    //   933: astore 10
    //   935: aload_0
    //   936: astore 9
    //   938: aload_2
    //   939: invokeinterface 1169 1 0
    //   944: checkcast 140	java/lang/String
    //   947: astore 6
    //   949: aload_0
    //   950: astore 10
    //   952: aload_0
    //   953: astore 9
    //   955: aload_2
    //   956: invokeinterface 1171 1 0
    //   961: checkcast 140	java/lang/String
    //   964: astore_2
    //   965: aload_2
    //   966: ifnull -67 -> 899
    //   969: aload_0
    //   970: astore 10
    //   972: aload_0
    //   973: astore 9
    //   975: new 1211	java/io/File
    //   978: dup
    //   979: aload_2
    //   980: invokespecial 1212	java/io/File:<init>	(Ljava/lang/String;)V
    //   983: astore 5
    //   985: aload_0
    //   986: astore 10
    //   988: aload_0
    //   989: astore 9
    //   991: aload 5
    //   993: invokevirtual 1215	java/io/File:getName	()Ljava/lang/String;
    //   996: astore 11
    //   998: aload_0
    //   999: astore 10
    //   1001: aload_0
    //   1002: astore 9
    //   1004: aload 11
    //   1006: ldc_w 1217
    //   1009: invokevirtual 1220	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1012: ifeq +3 -> 1015
    //   1015: ldc_w 1222
    //   1018: astore_2
    //   1019: ldc_w 1222
    //   1022: ifnull +636 -> 1658
    //   1025: aload_0
    //   1026: astore 10
    //   1028: aload_0
    //   1029: astore 9
    //   1031: ldc_w 1222
    //   1034: ldc 244
    //   1036: invokevirtual 698	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1039: ifeq +6 -> 1045
    //   1042: goto +616 -> 1658
    //   1045: aload_0
    //   1046: astore 10
    //   1048: aload_0
    //   1049: astore 9
    //   1051: new 1192	java/lang/StringBuffer
    //   1054: dup
    //   1055: invokespecial 1193	java/lang/StringBuffer:<init>	()V
    //   1058: astore 12
    //   1060: aload_0
    //   1061: astore 10
    //   1063: aload_0
    //   1064: astore 9
    //   1066: aload 12
    //   1068: ldc_w 1195
    //   1071: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1074: ldc_w 1200
    //   1077: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1080: ldc_w 1157
    //   1083: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1086: ldc_w 1195
    //   1089: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1092: pop
    //   1093: aload_0
    //   1094: astore 10
    //   1096: aload_0
    //   1097: astore 9
    //   1099: aload 12
    //   1101: new 84	java/lang/StringBuilder
    //   1104: dup
    //   1105: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   1108: ldc_w 1202
    //   1111: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: aload 6
    //   1116: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: ldc_w 1224
    //   1122: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: aload 11
    //   1127: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: ldc_w 1226
    //   1133: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1139: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1142: pop
    //   1143: aload_0
    //   1144: astore 10
    //   1146: aload_0
    //   1147: astore 9
    //   1149: aload 12
    //   1151: new 84	java/lang/StringBuilder
    //   1154: dup
    //   1155: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   1158: ldc_w 1228
    //   1161: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: aload_2
    //   1165: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: ldc_w 1230
    //   1171: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1174: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1177: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1180: pop
    //   1181: aload_0
    //   1182: astore 10
    //   1184: aload_0
    //   1185: astore 9
    //   1187: aload_3
    //   1188: aload 12
    //   1190: invokevirtual 1205	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1193: invokevirtual 744	java/lang/String:getBytes	()[B
    //   1196: invokevirtual 1209	java/io/OutputStream:write	([B)V
    //   1199: aload_0
    //   1200: astore 10
    //   1202: aload_0
    //   1203: astore 9
    //   1205: new 1232	java/io/BufferedInputStream
    //   1208: dup
    //   1209: new 1232	java/io/BufferedInputStream
    //   1212: dup
    //   1213: new 1234	java/io/FileInputStream
    //   1216: dup
    //   1217: aload 5
    //   1219: invokespecial 1237	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1222: invokespecial 1238	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1225: invokespecial 1238	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1228: astore_2
    //   1229: aload_0
    //   1230: astore 10
    //   1232: aload_0
    //   1233: astore 9
    //   1235: sipush 3072
    //   1238: newarray byte
    //   1240: astore 6
    //   1242: aload_2
    //   1243: aload 6
    //   1245: invokevirtual 1239	java/io/BufferedInputStream:read	([B)I
    //   1248: istore 8
    //   1250: iload 8
    //   1252: iconst_m1
    //   1253: if_icmpeq +102 -> 1355
    //   1256: aload_3
    //   1257: aload 6
    //   1259: iconst_0
    //   1260: iload 8
    //   1262: invokevirtual 1240	java/io/OutputStream:write	([BII)V
    //   1265: goto -23 -> 1242
    //   1268: astore 4
    //   1270: ldc 29
    //   1272: iconst_1
    //   1273: iconst_4
    //   1274: anewarray 4	java/lang/Object
    //   1277: dup
    //   1278: iconst_0
    //   1279: ldc_w 1242
    //   1282: aastore
    //   1283: dup
    //   1284: iconst_1
    //   1285: aload 5
    //   1287: invokevirtual 1245	java/io/File:length	()J
    //   1290: invokestatic 1248	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1293: aastore
    //   1294: dup
    //   1295: iconst_2
    //   1296: ldc_w 1250
    //   1299: aastore
    //   1300: dup
    //   1301: iconst_3
    //   1302: aload 5
    //   1304: invokevirtual 1253	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1307: aastore
    //   1308: invokestatic 1136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1311: aload_3
    //   1312: invokevirtual 1256	java/io/OutputStream:flush	()V
    //   1315: aload_3
    //   1316: invokevirtual 1257	java/io/OutputStream:close	()V
    //   1319: aload_0
    //   1320: invokevirtual 1179	java/net/HttpURLConnection:disconnect	()V
    //   1323: aconst_null
    //   1324: astore 9
    //   1326: aconst_null
    //   1327: astore 10
    //   1329: aconst_null
    //   1330: astore_0
    //   1331: aload_2
    //   1332: invokevirtual 1258	java/io/BufferedInputStream:close	()V
    //   1335: iconst_0
    //   1336: ifeq -752 -> 584
    //   1339: new 1260	java/lang/NullPointerException
    //   1342: dup
    //   1343: invokespecial 1261	java/lang/NullPointerException:<init>	()V
    //   1346: athrow
    //   1347: new 1260	java/lang/NullPointerException
    //   1350: dup
    //   1351: invokespecial 1261	java/lang/NullPointerException:<init>	()V
    //   1354: athrow
    //   1355: aload_0
    //   1356: astore 10
    //   1358: aload_0
    //   1359: astore 9
    //   1361: aload_2
    //   1362: invokevirtual 1258	java/io/BufferedInputStream:close	()V
    //   1365: goto -466 -> 899
    //   1368: astore_0
    //   1369: ldc 29
    //   1371: iconst_1
    //   1372: ldc_w 1263
    //   1375: aload_0
    //   1376: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1379: goto -32 -> 1347
    //   1382: astore_3
    //   1383: aload_0
    //   1384: astore 10
    //   1386: aload_0
    //   1387: astore 9
    //   1389: aload_2
    //   1390: invokevirtual 1258	java/io/BufferedInputStream:close	()V
    //   1393: aload_0
    //   1394: astore 10
    //   1396: aload_0
    //   1397: astore 9
    //   1399: aload_3
    //   1400: athrow
    //   1401: aload_0
    //   1402: astore 10
    //   1404: aload_0
    //   1405: astore 9
    //   1407: aload_3
    //   1408: new 84	java/lang/StringBuilder
    //   1411: dup
    //   1412: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   1415: ldc_w 1265
    //   1418: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: ldc_w 1157
    //   1424: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: ldc_w 1267
    //   1430: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1433: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1436: invokevirtual 744	java/lang/String:getBytes	()[B
    //   1439: invokevirtual 1209	java/io/OutputStream:write	([B)V
    //   1442: aload_0
    //   1443: astore 10
    //   1445: aload_0
    //   1446: astore 9
    //   1448: aload_3
    //   1449: invokevirtual 1256	java/io/OutputStream:flush	()V
    //   1452: aload_0
    //   1453: astore 10
    //   1455: aload_0
    //   1456: astore 9
    //   1458: aload_3
    //   1459: invokevirtual 1257	java/io/OutputStream:close	()V
    //   1462: aload_0
    //   1463: astore 10
    //   1465: aload_0
    //   1466: astore 9
    //   1468: new 1192	java/lang/StringBuffer
    //   1471: dup
    //   1472: invokespecial 1193	java/lang/StringBuffer:<init>	()V
    //   1475: astore 4
    //   1477: aload_0
    //   1478: astore 10
    //   1480: aload_0
    //   1481: astore 9
    //   1483: new 925	java/io/BufferedReader
    //   1486: dup
    //   1487: new 927	java/io/InputStreamReader
    //   1490: dup
    //   1491: aload_0
    //   1492: invokevirtual 1268	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1495: invokespecial 934	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1498: invokespecial 937	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1501: astore_3
    //   1502: aload_0
    //   1503: astore 10
    //   1505: aload_0
    //   1506: astore 9
    //   1508: aload_3
    //   1509: invokevirtual 940	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1512: astore_2
    //   1513: aload_2
    //   1514: ifnull +25 -> 1539
    //   1517: aload_0
    //   1518: astore 10
    //   1520: aload_0
    //   1521: astore 9
    //   1523: aload 4
    //   1525: aload_2
    //   1526: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1529: ldc_w 942
    //   1532: invokevirtual 1198	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1535: pop
    //   1536: goto -34 -> 1502
    //   1539: aload_0
    //   1540: astore 10
    //   1542: aload_0
    //   1543: astore 9
    //   1545: aload 4
    //   1547: invokevirtual 1205	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1550: astore_2
    //   1551: aload_0
    //   1552: astore 9
    //   1554: aload_3
    //   1555: invokevirtual 944	java/io/BufferedReader:close	()V
    //   1558: aload_2
    //   1559: astore_1
    //   1560: aload_0
    //   1561: ifnull -1013 -> 548
    //   1564: aload_0
    //   1565: invokevirtual 1176	java/net/HttpURLConnection:getResponseCode	()I
    //   1568: istore 8
    //   1570: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1573: ifeq +30 -> 1603
    //   1576: ldc 29
    //   1578: iconst_2
    //   1579: new 84	java/lang/StringBuilder
    //   1582: dup
    //   1583: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   1586: ldc_w 1178
    //   1589: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1592: iload 8
    //   1594: invokevirtual 820	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1597: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1600: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1603: aload_0
    //   1604: invokevirtual 1179	java/net/HttpURLConnection:disconnect	()V
    //   1607: aload_2
    //   1608: astore_1
    //   1609: goto -1061 -> 548
    //   1612: astore_1
    //   1613: ldc 29
    //   1615: iconst_1
    //   1616: ldc_w 1263
    //   1619: aload_1
    //   1620: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1623: goto -20 -> 1603
    //   1626: astore_1
    //   1627: ldc 29
    //   1629: iconst_1
    //   1630: ldc_w 1263
    //   1633: aload_1
    //   1634: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1637: goto -1095 -> 542
    //   1640: astore_0
    //   1641: ldc 29
    //   1643: iconst_1
    //   1644: ldc_w 1263
    //   1647: aload_0
    //   1648: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1651: goto -801 -> 850
    //   1654: astore_3
    //   1655: goto -1188 -> 467
    //   1658: ldc_w 1270
    //   1661: astore_2
    //   1662: goto -617 -> 1045
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1665	0	paramHttpURLConnection	HttpURLConnection
    //   0	1665	1	paramString1	String
    //   0	1665	2	paramString2	String
    //   0	1665	3	paramString3	String
    //   0	1665	4	paramMap1	Map<String, String>
    //   0	1665	5	paramMap2	Map<String, String>
    //   0	1665	6	paramMap3	Map<String, String>
    //   0	1665	7	paramBoolean	boolean
    //   507	1086	8	i	int
    //   4	1549	9	localHttpURLConnection1	HttpURLConnection
    //   1	1540	10	localHttpURLConnection2	HttpURLConnection
    //   198	928	11	localObject	Object
    //   1058	131	12	localStringBuffer	java.lang.StringBuffer
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
    //   592	604	461	java/lang/Exception
    //   615	623	461	java/lang/Exception
    //   629	643	461	java/lang/Exception
    //   649	659	461	java/lang/Exception
    //   665	677	461	java/lang/Exception
    //   683	695	461	java/lang/Exception
    //   701	713	461	java/lang/Exception
    //   724	750	461	java/lang/Exception
    //   756	788	461	java/lang/Exception
    //   794	801	461	java/lang/Exception
    //   863	874	461	java/lang/Exception
    //   885	899	461	java/lang/Exception
    //   905	915	461	java/lang/Exception
    //   921	932	461	java/lang/Exception
    //   938	949	461	java/lang/Exception
    //   955	965	461	java/lang/Exception
    //   975	985	461	java/lang/Exception
    //   991	998	461	java/lang/Exception
    //   1004	1015	461	java/lang/Exception
    //   1031	1042	461	java/lang/Exception
    //   1051	1060	461	java/lang/Exception
    //   1066	1093	461	java/lang/Exception
    //   1099	1143	461	java/lang/Exception
    //   1149	1181	461	java/lang/Exception
    //   1187	1199	461	java/lang/Exception
    //   1205	1229	461	java/lang/Exception
    //   1235	1242	461	java/lang/Exception
    //   1331	1335	461	java/lang/Exception
    //   1361	1365	461	java/lang/Exception
    //   1389	1393	461	java/lang/Exception
    //   1399	1401	461	java/lang/Exception
    //   1407	1442	461	java/lang/Exception
    //   1448	1452	461	java/lang/Exception
    //   1458	1462	461	java/lang/Exception
    //   1468	1477	461	java/lang/Exception
    //   1483	1502	461	java/lang/Exception
    //   1508	1513	461	java/lang/Exception
    //   1523	1536	461	java/lang/Exception
    //   1545	1551	461	java/lang/Exception
    //   6	13	804	finally
    //   19	26	804	finally
    //   32	37	804	finally
    //   43	48	804	finally
    //   54	59	804	finally
    //   65	71	804	finally
    //   77	87	804	finally
    //   93	161	804	finally
    //   167	196	804	finally
    //   211	220	804	finally
    //   231	254	804	finally
    //   260	268	804	finally
    //   274	316	804	finally
    //   322	335	804	finally
    //   341	380	804	finally
    //   386	399	804	finally
    //   405	414	804	finally
    //   420	430	804	finally
    //   436	458	804	finally
    //   470	497	804	finally
    //   592	604	804	finally
    //   615	623	804	finally
    //   629	643	804	finally
    //   649	659	804	finally
    //   665	677	804	finally
    //   683	695	804	finally
    //   701	713	804	finally
    //   724	750	804	finally
    //   756	788	804	finally
    //   794	801	804	finally
    //   863	874	804	finally
    //   885	899	804	finally
    //   905	915	804	finally
    //   921	932	804	finally
    //   938	949	804	finally
    //   955	965	804	finally
    //   975	985	804	finally
    //   991	998	804	finally
    //   1004	1015	804	finally
    //   1031	1042	804	finally
    //   1051	1060	804	finally
    //   1066	1093	804	finally
    //   1099	1143	804	finally
    //   1149	1181	804	finally
    //   1187	1199	804	finally
    //   1205	1229	804	finally
    //   1235	1242	804	finally
    //   1331	1335	804	finally
    //   1361	1365	804	finally
    //   1389	1393	804	finally
    //   1399	1401	804	finally
    //   1407	1442	804	finally
    //   1448	1452	804	finally
    //   1458	1462	804	finally
    //   1468	1477	804	finally
    //   1483	1502	804	finally
    //   1508	1513	804	finally
    //   1523	1536	804	finally
    //   1545	1551	804	finally
    //   1554	1558	804	finally
    //   1242	1250	1268	java/lang/OutOfMemoryError
    //   1256	1265	1268	java/lang/OutOfMemoryError
    //   1339	1347	1368	java/lang/Exception
    //   1242	1250	1382	finally
    //   1256	1265	1382	finally
    //   1270	1323	1382	finally
    //   1564	1603	1612	java/lang/Exception
    //   503	542	1626	java/lang/Exception
    //   810	850	1640	java/lang/Exception
    //   1554	1558	1654	java/lang/Exception
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