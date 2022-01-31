package com.tencent.component.network.utils.http;

import android.content.Context;
import android.text.TextUtils;
import com.squareup.okhttp.Request.Builder;
import com.tencent.component.network.Global;
import com.tencent.component.network.downloader.impl.DownloaderImpl;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.http.base.QZoneHttp2Client;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import com.tencent.component.network.utils.http.base.SNIVerifier;
import com.tencent.component.network.utils.http.base.SniSSLSocketFactory;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
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
  private static final HttpUtil.ClientOptions a = new HttpUtil.ClientOptions();
  
  public static Request.Builder a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = a(paramString1);
    paramString3 = b(paramString3);
    paramString3 = new Request.Builder().url(paramString3);
    paramString3.addHeader("x-online-host", paramString2);
    paramString3.addHeader("Host", paramString2);
    paramString2 = Config.e();
    if (!TextUtils.isEmpty(paramString2)) {
      paramString3.addHeader("Q-UA", paramString2);
    }
    if (!TextUtils.isEmpty(paramContext)) {
      paramString3.addHeader("Referer", paramContext);
    }
    for (;;)
    {
      paramContext = Config.d();
      if ((paramString3 != null) && (!TextUtils.isEmpty(paramContext))) {
        paramString3.header("User-Agent", paramContext);
      }
      return paramString3;
      paramString3.addHeader("Referer", paramString1);
    }
  }
  
  public static Request.Builder a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramContext = b(paramString3);
    paramContext = new Request.Builder().url(paramContext);
    paramContext.addHeader("x-online-host", paramString2);
    paramContext.addHeader("Host", paramString2);
    paramString1 = Config.e();
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.addHeader("Q-UA", paramString1);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramContext.addHeader("Referer", paramString4);
    }
    paramString1 = Config.d();
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1))) {
      paramContext.header("User-Agent", paramString1);
    }
    return paramContext;
  }
  
  public static QZoneHttp2Client a(HttpUtil.ClientOptions paramClientOptions)
  {
    HttpUtil.ClientOptions localClientOptions = paramClientOptions;
    if (paramClientOptions == null) {
      localClientOptions = a;
    }
    return new QZoneHttp2Client(localClientOptions);
  }
  
  public static QZoneHttpClient a()
  {
    HttpUtil.ClientOptions localClientOptions = new HttpUtil.ClientOptions();
    localClientOptions.jdField_a_of_type_Boolean = true;
    localClientOptions.jdField_a_of_type_Int = DownloaderImpl.MAX_CONNECTION;
    localClientOptions.b = DownloaderImpl.MAX_CONNECTION_PER_ROUTE;
    localClientOptions.jdField_a_of_type_Long = DownloaderImpl.TIME_TO_LIVE_HTTP;
    localClientOptions.jdField_a_of_type_JavaUtilConcurrentTimeUnit = DownloaderImpl.TIME_TO_LIVE_UNIT;
    return a(localClientOptions);
  }
  
  public static QZoneHttpClient a(HttpUtil.ClientOptions paramClientOptions)
  {
    Object localObject1 = paramClientOptions;
    if (paramClientOptions == null) {
      localObject1 = a;
    }
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, ((HttpUtil.ClientOptions)localObject1).c);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, ((HttpUtil.ClientOptions)localObject1).e);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, Config.d());
    paramClientOptions = new SchemeRegistry();
    try
    {
      paramClientOptions.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      Object localObject2 = new SniSSLSocketFactory(null);
      ((SSLSocketFactory)localObject2).setHostnameVerifier(new SNIVerifier());
      paramClientOptions.register(new Scheme("https", (SocketFactory)localObject2, 443));
      if (((HttpUtil.ClientOptions)localObject1).jdField_a_of_type_Boolean)
      {
        localObject2 = new PoolingClientConnectionManager(paramClientOptions, ((HttpUtil.ClientOptions)localObject1).jdField_a_of_type_Long, ((HttpUtil.ClientOptions)localObject1).jdField_a_of_type_JavaUtilConcurrentTimeUnit);
        if (((HttpUtil.ClientOptions)localObject1).b > 0) {
          ((PoolingClientConnectionManager)localObject2).b(((HttpUtil.ClientOptions)localObject1).b);
        }
        paramClientOptions = (HttpUtil.ClientOptions)localObject2;
        if (((HttpUtil.ClientOptions)localObject1).jdField_a_of_type_Int > 0)
        {
          ((PoolingClientConnectionManager)localObject2).a(((HttpUtil.ClientOptions)localObject1).jdField_a_of_type_Int);
          paramClientOptions = (HttpUtil.ClientOptions)localObject2;
        }
        ConnManagerParams.setTimeout(localBasicHttpParams, ((HttpUtil.ClientOptions)localObject1).d);
        localObject1 = new QZoneHttpClient(paramClientOptions, localBasicHttpParams);
        ((QZoneHttpClient)localObject1).setRoutePlanner(new DefaultHttpRoutePlanner(paramClientOptions.getSchemeRegistry()));
        return localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QDLog.d("downloader", "", localThrowable);
        continue;
        paramClientOptions = new SingleClientConnManager(localBasicHttpParams, paramClientOptions);
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (paramString != null) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.a(bool);
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
  
  public static Proxy a(HttpUtil.RequestOptions paramRequestOptions)
  {
    Object localObject = Proxy.NO_PROXY;
    Context localContext = Global.a();
    if (localContext == null) {}
    label159:
    label162:
    for (;;)
    {
      return localObject;
      if ((paramRequestOptions != null) && (paramRequestOptions.jdField_a_of_type_JavaNetProxy != null) && (NetworkUtils.isMobileConnected(localContext))) {
        return paramRequestOptions.jdField_a_of_type_JavaNetProxy;
      }
      boolean bool1;
      if (paramRequestOptions != null)
      {
        bool1 = paramRequestOptions.jdField_a_of_type_Boolean;
        if (paramRequestOptions == null) {
          break label159;
        }
      }
      for (boolean bool2 = paramRequestOptions.b;; bool2 = false)
      {
        if ((!bool1) || (!NetworkUtils.isMobileConnected(localContext))) {
          break label162;
        }
        paramRequestOptions = NetworkUtils.getProxy(localContext, bool2);
        if ((paramRequestOptions != null) && (QDLog.a()) && ((paramRequestOptions.address() instanceof InetSocketAddress)))
        {
          localObject = (InetSocketAddress)paramRequestOptions.address();
          QDLog.a("downloader", "use proxy[host:" + ((InetSocketAddress)localObject).getHostName() + ",port:" + ((InetSocketAddress)localObject).getPort() + "]");
        }
        return paramRequestOptions;
        bool1 = true;
        break;
      }
    }
  }
  
  public static HttpResponse a(Context paramContext, String paramString, HttpEntity paramHttpEntity)
  {
    return a(paramContext, paramString, paramHttpEntity, null);
  }
  
  public static HttpResponse a(Context paramContext, String paramString, HttpEntity paramHttpEntity, HttpUtil.RequestOptions paramRequestOptions)
  {
    return a().execute(a(paramContext, paramString, paramHttpEntity, paramRequestOptions));
  }
  
  public static HttpClient a()
  {
    return a(null);
  }
  
  public static HttpGet a(Context paramContext, String paramString1, String paramString2, String paramString3, HttpUtil.RequestOptions paramRequestOptions)
  {
    String str = a(paramString1);
    paramString3 = new HttpGet(b(paramString3));
    paramString3.addHeader("x-online-host", paramString2);
    paramString3.addHeader("Host", paramString2);
    paramString2 = Config.e();
    if (!TextUtils.isEmpty(paramString2)) {
      paramString3.addHeader("Q-UA", paramString2);
    }
    if (!TextUtils.isEmpty(str)) {
      paramString3.addHeader("Referer", str);
    }
    for (;;)
    {
      a(paramContext, paramString3, paramRequestOptions);
      return paramString3;
      paramString3.addHeader("Referer", paramString1);
    }
  }
  
  public static HttpGet a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, HttpUtil.RequestOptions paramRequestOptions)
  {
    paramString1 = new HttpGet(b(paramString3));
    paramString1.addHeader("x-online-host", paramString2);
    paramString1.addHeader("Host", paramString2);
    paramString2 = Config.e();
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.addHeader("Q-UA", paramString2);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramString1.addHeader("Referer", paramString4);
    }
    a(paramContext, paramString1, paramRequestOptions);
    return paramString1;
  }
  
  public static HttpPost a(Context paramContext, String paramString, HttpEntity paramHttpEntity, HttpUtil.RequestOptions paramRequestOptions)
  {
    Object localObject = b(paramString);
    paramString = c((String)localObject);
    localObject = new HttpPost((String)localObject);
    ((HttpPost)localObject).addHeader("Host", paramString);
    ((HttpPost)localObject).addHeader("x-online-host", paramString);
    paramString = Config.e();
    if (!TextUtils.isEmpty(paramString)) {
      ((HttpPost)localObject).addHeader("Q-UA", paramString);
    }
    if ((paramHttpEntity instanceof ByteArrayEntity)) {
      ((HttpPost)localObject).addHeader("Content-Type", "application/octet-stream");
    }
    ((HttpPost)localObject).setEntity(paramHttpEntity);
    a(paramContext, (HttpRequest)localObject, paramRequestOptions);
    return localObject;
  }
  
  public static HttpContext a()
  {
    return new BasicHttpContext();
  }
  
  private static void a(Context paramContext, HttpRequest paramHttpRequest, HttpUtil.RequestOptions paramRequestOptions)
  {
    if ((paramRequestOptions != null) && (paramRequestOptions.jdField_a_of_type_JavaNetProxy != null) && (NetworkUtils.isMobileConnected(paramContext))) {
      paramHttpRequest.getParams().setParameter("http.route.default-proxy", paramRequestOptions.jdField_a_of_type_JavaNetProxy);
    }
    label47:
    label182:
    label186:
    for (;;)
    {
      return;
      boolean bool1;
      if (paramRequestOptions != null)
      {
        bool1 = paramRequestOptions.jdField_a_of_type_Boolean;
        if (paramRequestOptions == null) {
          break label182;
        }
      }
      for (boolean bool2 = paramRequestOptions.b;; bool2 = false)
      {
        if ((!bool1) || (!NetworkUtils.isMobileConnected(paramContext))) {
          break label186;
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
        if (!QDLog.a()) {
          break;
        }
        QDLog.a("downloader", "use proxy[host:" + paramContext.getHostName() + ",port:" + paramContext.getPort() + "]");
        return;
        bool1 = true;
        break label47;
      }
    }
  }
  
  public static void a(HttpRequest paramHttpRequest, Request.Builder paramBuilder, boolean paramBoolean)
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
  
  public static boolean a(HttpRequest paramHttpRequest, HttpUtil.RequestOptions paramRequestOptions)
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
      paramHttpRequest = a(paramRequestOptions);
    } while ((paramHttpRequest != null) && (paramHttpRequest.address() != null));
    return false;
  }
  
  private static String b(String paramString)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.a(bool);
      String str = paramString.trim().replace(" ", "");
      int i = str.indexOf('#');
      paramString = str;
      if (i > 0) {
        paramString = str.substring(0, i);
      }
      return paramString;
    }
  }
  
  private static String c(String paramString)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.a(bool);
      return new URL(paramString).getAuthority();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.HttpUtil
 * JD-Core Version:    0.7.0.1
 */