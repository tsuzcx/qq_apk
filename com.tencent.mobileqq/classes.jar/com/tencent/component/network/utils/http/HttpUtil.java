package com.tencent.component.network.utils.http;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.Global;
import com.tencent.component.network.downloader.impl.DownloaderImpl;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.dns.OkHttpDNS;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import com.tencent.component.network.utils.http.base.SNIVerifier;
import com.tencent.component.network.utils.http.base.SniSSLSocketFactory;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.internal.Util;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class HttpUtil
{
  private static final int CONNECTION_TIMEOUT = 30000;
  private static final HttpUtil.ClientOptions DEFAULT_CLIENT_OPTIONS = new HttpUtil.ClientOptions();
  private static final int SO_TIMEOUT = 55000;
  
  public static QZoneHttpClient CreateDefaultHttpClient()
  {
    return CreateDefaultHttpClient(null);
  }
  
  public static QZoneHttpClient CreateDefaultHttpClient(CustomDnsResolve paramCustomDnsResolve)
  {
    HttpUtil.ClientOptions localClientOptions = new HttpUtil.ClientOptions();
    localClientOptions.multiConnection = true;
    localClientOptions.maxConnection = DownloaderImpl.MAX_CONNECTION;
    localClientOptions.maxConnectionPerRoute = DownloaderImpl.MAX_CONNECTION_PER_ROUTE;
    localClientOptions.timeToLive = DownloaderImpl.TIME_TO_LIVE_HTTP;
    localClientOptions.timeToLiveUnit = DownloaderImpl.TIME_TO_LIVE_UNIT;
    localClientOptions.dnsResolve = paramCustomDnsResolve;
    return createHttpClient(localClientOptions);
  }
  
  public static boolean containsProxy(HttpRequest paramHttpRequest, HttpUtil.RequestOptions paramRequestOptions)
  {
    if (paramHttpRequest != null)
    {
      paramHttpRequest = paramHttpRequest.getParams().getParameter("http.route.default-proxy");
      if ((paramHttpRequest == null) || (!(paramHttpRequest instanceof HttpHost))) {}
    }
    do
    {
      return true;
      return false;
      paramHttpRequest = prepareRequest(paramRequestOptions);
    } while ((paramHttpRequest != null) && (paramHttpRequest.address() != null));
    return false;
  }
  
  public static OkHttpClient createHttp2Client()
  {
    return createHttp2Client(null, null);
  }
  
  public static OkHttpClient createHttp2Client(HttpUtil.ClientOptions paramClientOptions, CustomDnsResolve paramCustomDnsResolve)
  {
    HttpUtil.ClientOptions localClientOptions = paramClientOptions;
    if (paramClientOptions == null) {
      localClientOptions = DEFAULT_CLIENT_OPTIONS;
    }
    paramClientOptions = new OkHttpClient.Builder();
    if (localClientOptions != null) {
      paramClientOptions.connectTimeout(localClientOptions.connTimeout, TimeUnit.MILLISECONDS).readTimeout(localClientOptions.soTimeout, TimeUnit.MILLISECONDS).writeTimeout(localClientOptions.soTimeout, TimeUnit.MILLISECONDS);
    }
    long l = localClientOptions.timeToLive;
    paramClientOptions.connectionPool(new ConnectionPool(localClientOptions.maxConnection, l * 1000L, TimeUnit.MILLISECONDS)).hostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER).protocols(Util.immutableList(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 })).dns(new OkHttpDNS(paramCustomDnsResolve));
    return paramClientOptions.build();
  }
  
  public static QZoneHttpClient createHttpClient(HttpUtil.ClientOptions paramClientOptions)
  {
    Object localObject1 = paramClientOptions;
    if (paramClientOptions == null) {
      localObject1 = DEFAULT_CLIENT_OPTIONS;
    }
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, ((HttpUtil.ClientOptions)localObject1).connTimeout);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, ((HttpUtil.ClientOptions)localObject1).soTimeout);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, Config.getUserAgent());
    paramClientOptions = new SchemeRegistry();
    try
    {
      paramClientOptions.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      Object localObject2 = new SniSSLSocketFactory(null);
      ((SSLSocketFactory)localObject2).setHostnameVerifier(new SNIVerifier());
      paramClientOptions.register(new Scheme("https", (SocketFactory)localObject2, 443));
      if (((HttpUtil.ClientOptions)localObject1).multiConnection)
      {
        localObject2 = new PoolingClientConnectionManager(paramClientOptions, ((HttpUtil.ClientOptions)localObject1).timeToLive, ((HttpUtil.ClientOptions)localObject1).timeToLiveUnit, new SystemDefaultDnsResolver(), ((HttpUtil.ClientOptions)localObject1).dnsResolve);
        if (((HttpUtil.ClientOptions)localObject1).maxConnectionPerRoute > 0) {
          ((PoolingClientConnectionManager)localObject2).setDefaultMaxPerRoute(((HttpUtil.ClientOptions)localObject1).maxConnectionPerRoute);
        }
        paramClientOptions = (HttpUtil.ClientOptions)localObject2;
        if (((HttpUtil.ClientOptions)localObject1).maxConnection > 0)
        {
          ((PoolingClientConnectionManager)localObject2).setMaxTotal(((HttpUtil.ClientOptions)localObject1).maxConnection);
          paramClientOptions = (HttpUtil.ClientOptions)localObject2;
        }
        ConnManagerParams.setTimeout(localBasicHttpParams, ((HttpUtil.ClientOptions)localObject1).connManagerTimeout);
        localObject1 = new QZoneHttpClient(paramClientOptions, localBasicHttpParams);
        ((QZoneHttpClient)localObject1).setRoutePlanner(new DefaultHttpRoutePlanner(paramClientOptions.getSchemeRegistry()));
        return localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QDLog.e("downloader", "", localThrowable);
        continue;
        paramClientOptions = new SingleClientConnManager(localBasicHttpParams, paramClientOptions);
      }
    }
  }
  
  public static HttpClient createHttpClient()
  {
    return createHttpClient(null);
  }
  
  public static HttpContext createHttpContext()
  {
    return new BasicHttpContext();
  }
  
  public static HttpGet createHttpGet(Context paramContext, String paramString)
  {
    return createHttpGet(paramContext, paramString, null);
  }
  
  public static HttpGet createHttpGet(Context paramContext, String paramString, HttpUtil.RequestOptions paramRequestOptions)
  {
    String str = prepareRefer(paramString);
    Object localObject = prepareUrl(paramString);
    paramString = prepareHost((String)localObject);
    localObject = new HttpGet((String)localObject);
    ((HttpGet)localObject).addHeader("x-online-host", paramString);
    ((HttpGet)localObject).addHeader("Host", paramString);
    paramString = Config.getQUA();
    if (!TextUtils.isEmpty(paramString)) {
      ((HttpGet)localObject).addHeader("Q-UA", paramString);
    }
    if (!TextUtils.isEmpty(str)) {
      ((HttpGet)localObject).addHeader("Referer", str);
    }
    prepareRequest(paramContext, (HttpRequest)localObject, paramRequestOptions);
    return localObject;
  }
  
  public static HttpGet createHttpGet(Context paramContext, String paramString1, String paramString2, HttpUtil.RequestOptions paramRequestOptions)
  {
    String str = prepareRefer(paramString1);
    paramString1 = prepareUrl(paramString1);
    paramString2 = prepareUrl(paramString2);
    paramString1 = prepareHost(paramString1);
    paramString2 = new HttpGet(paramString2);
    paramString2.addHeader("x-online-host", paramString1);
    paramString2.addHeader("Host", paramString1);
    paramString1 = Config.getQUA();
    if (!TextUtils.isEmpty(paramString1)) {
      paramString2.addHeader("Q-UA", paramString1);
    }
    if (!TextUtils.isEmpty(str)) {
      paramString2.addHeader("Referer", str);
    }
    prepareRequest(paramContext, paramString2, paramRequestOptions);
    return paramString2;
  }
  
  public static HttpGet createHttpGet(Context paramContext, String paramString1, String paramString2, String paramString3, HttpUtil.RequestOptions paramRequestOptions)
  {
    paramString1 = prepareRefer(paramString1);
    paramString3 = new HttpGet(prepareUrl(paramString3));
    paramString3.addHeader("x-online-host", paramString2);
    paramString3.addHeader("Host", paramString2);
    paramString2 = Config.getQUA();
    if (!TextUtils.isEmpty(paramString2)) {
      paramString3.addHeader("Q-UA", paramString2);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramString3.addHeader("Referer", paramString1);
    }
    prepareRequest(paramContext, paramString3, paramRequestOptions);
    return paramString3;
  }
  
  public static HttpGet createHttpGet(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, HttpUtil.RequestOptions paramRequestOptions)
  {
    paramString1 = new HttpGet(prepareUrl(paramString3));
    paramString1.addHeader("x-online-host", paramString2);
    paramString1.addHeader("Host", paramString2);
    paramString2 = Config.getQUA();
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.addHeader("Q-UA", paramString2);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramString1.addHeader("Referer", paramString4);
    }
    prepareRequest(paramContext, paramString1, paramRequestOptions);
    return paramString1;
  }
  
  public static HttpPost createHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity)
  {
    return createHttpPost(paramContext, paramString, paramHttpEntity, null);
  }
  
  public static HttpPost createHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity, HttpUtil.RequestOptions paramRequestOptions)
  {
    Object localObject = prepareUrl(paramString);
    paramString = prepareHost((String)localObject);
    localObject = new HttpPost((String)localObject);
    ((HttpPost)localObject).addHeader("Host", paramString);
    ((HttpPost)localObject).addHeader("x-online-host", paramString);
    paramString = Config.getQUA();
    if (!TextUtils.isEmpty(paramString)) {
      ((HttpPost)localObject).addHeader("Q-UA", paramString);
    }
    if ((paramHttpEntity instanceof ByteArrayEntity)) {
      ((HttpPost)localObject).addHeader("Content-Type", "application/octet-stream");
    }
    ((HttpPost)localObject).setEntity(paramHttpEntity);
    prepareRequest(paramContext, (HttpRequest)localObject, paramRequestOptions);
    return localObject;
  }
  
  public static Request.Builder createOkHttpGet(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = prepareRefer(paramString1);
    paramString3 = prepareUrl(paramString3);
    paramString3 = new Request.Builder().url(paramString3);
    paramString3.addHeader("x-online-host", paramString2);
    paramString3.addHeader("Host", paramString2);
    paramString2 = Config.getQUA();
    if (!TextUtils.isEmpty(paramString2)) {
      paramString3.addHeader("Q-UA", paramString2);
    }
    if (!TextUtils.isEmpty(paramContext)) {
      paramString3.addHeader("Referer", paramContext);
    }
    for (;;)
    {
      paramContext = Config.getUserAgent();
      if ((paramString3 != null) && (!TextUtils.isEmpty(paramContext))) {
        paramString3.header("User-Agent", paramContext);
      }
      return paramString3;
      paramString3.addHeader("Referer", paramString1);
    }
  }
  
  public static Request.Builder createOkHttpGet(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramContext = prepareUrl(paramString3);
    paramContext = new Request.Builder().url(paramContext);
    paramString1 = Config.getQUA();
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.addHeader("Q-UA", paramString1);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramContext.addHeader("Referer", paramString4);
    }
    paramString1 = Config.getUserAgent();
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1))) {
      paramContext.header("User-Agent", paramString1);
    }
    return paramContext;
  }
  
  public static Request createOkHttpGet(Context paramContext, String paramString)
  {
    paramContext = prepareRefer(paramString);
    Object localObject = prepareUrl(paramString);
    paramString = prepareHost((String)localObject);
    localObject = new Request.Builder().url((String)localObject);
    ((Request.Builder)localObject).addHeader("x-online-host", paramString);
    ((Request.Builder)localObject).addHeader("Host", paramString);
    paramString = Config.getQUA();
    if (!TextUtils.isEmpty(paramString)) {
      ((Request.Builder)localObject).addHeader("Q-UA", paramString);
    }
    if (!TextUtils.isEmpty(paramContext)) {
      ((Request.Builder)localObject).addHeader("Referer", paramContext);
    }
    return ((Request.Builder)localObject).build();
  }
  
  public static HttpResponse executeHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity)
  {
    return executeHttpPost(paramContext, paramString, paramHttpEntity, null);
  }
  
  public static HttpResponse executeHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity, HttpUtil.RequestOptions paramRequestOptions)
  {
    return createHttpClient().execute(createHttpPost(paramContext, paramString, paramHttpEntity, paramRequestOptions));
  }
  
  private static String prepareHost(String paramString)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      return new URL(paramString).getAuthority();
    }
  }
  
  public static String prepareRefer(String paramString)
  {
    if (paramString != null) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      i = paramString.indexOf("&rf=");
      if (i >= 0) {
        break;
      }
      return "";
    }
    int j = paramString.indexOf("&", "&rf=".length() + i);
    if (j > "&rf=".length() + i) {
      return paramString.substring("&rf=".length() + i, j);
    }
    return paramString.substring("&rf=".length() + i);
  }
  
  public static Proxy prepareRequest(HttpUtil.RequestOptions paramRequestOptions)
  {
    Object localObject = Proxy.NO_PROXY;
    Context localContext = Global.getContext();
    if (localContext == null) {}
    label160:
    label163:
    for (;;)
    {
      return localObject;
      if ((paramRequestOptions != null) && (paramRequestOptions.mobileProxy != null) && (NetworkUtils.isMobileConnected(localContext))) {
        return paramRequestOptions.mobileProxy;
      }
      boolean bool1;
      if (paramRequestOptions != null)
      {
        bool1 = paramRequestOptions.allowProxy;
        if (paramRequestOptions == null) {
          break label160;
        }
      }
      for (boolean bool2 = paramRequestOptions.apnProxy;; bool2 = false)
      {
        if ((!bool1) || (!NetworkUtils.isMobileConnected(localContext))) {
          break label163;
        }
        paramRequestOptions = NetworkUtils.getProxy(localContext, bool2);
        if ((paramRequestOptions != null) && (QDLog.isDebugEnable()) && ((paramRequestOptions.address() instanceof InetSocketAddress)))
        {
          localObject = (InetSocketAddress)paramRequestOptions.address();
          QDLog.d("downloader", "use proxy[host:" + ((InetSocketAddress)localObject).getHostName() + ",port:" + ((InetSocketAddress)localObject).getPort() + "]");
        }
        return paramRequestOptions;
        bool1 = true;
        break;
      }
    }
  }
  
  private static void prepareRequest(Context paramContext, HttpRequest paramHttpRequest, HttpUtil.RequestOptions paramRequestOptions)
  {
    if ((paramRequestOptions != null) && (paramRequestOptions.mobileProxy != null) && (NetworkUtils.isMobileConnected(paramContext))) {
      paramHttpRequest.getParams().setParameter("http.route.default-proxy", paramRequestOptions.mobileProxy);
    }
    label46:
    label181:
    label185:
    for (;;)
    {
      return;
      boolean bool1;
      if (paramRequestOptions != null)
      {
        bool1 = paramRequestOptions.allowProxy;
        if (paramRequestOptions == null) {
          break label181;
        }
      }
      for (boolean bool2 = paramRequestOptions.apnProxy;; bool2 = false)
      {
        if ((!bool1) || (!NetworkUtils.isMobileConnected(paramContext))) {
          break label185;
        }
        paramContext = NetworkUtils.getProxy(paramContext, bool2);
        if (paramContext == null) {
          break;
        }
        paramContext = (InetSocketAddress)paramContext.address();
        if (paramContext == null) {
          break;
        }
        paramRequestOptions = new HttpHost(paramContext.getHostName(), paramContext.getPort());
        paramHttpRequest.getParams().setParameter("http.route.default-proxy", paramRequestOptions);
        if (!QDLog.isDebugEnable()) {
          break;
        }
        QDLog.d("downloader", "use proxy[host:" + paramContext.getHostName() + ",port:" + paramContext.getPort() + "]");
        return;
        bool1 = true;
        break label46;
      }
    }
  }
  
  private static String prepareUrl(String paramString)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      String str = paramString.trim().replace(" ", "");
      int i = str.indexOf('#');
      paramString = str;
      if (i > 0) {
        paramString = str.substring(0, i);
      }
      return paramString;
    }
  }
  
  public static void setKeepAliveEnabled(HttpRequest paramHttpRequest, Request.Builder paramBuilder, boolean paramBoolean)
  {
    if (paramHttpRequest != null) {
      if (paramBoolean)
      {
        paramBuilder = "Keep-Alive";
        paramHttpRequest.setHeader("Connection", paramBuilder);
      }
    }
    while (paramBuilder == null) {
      for (;;)
      {
        return;
        paramBuilder = "Close";
      }
    }
    if (paramBoolean) {}
    for (paramHttpRequest = "Keep-Alive";; paramHttpRequest = "Close")
    {
      paramBuilder.header("Connection", paramHttpRequest);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.utils.http.HttpUtil
 * JD-Core Version:    0.7.0.1
 */