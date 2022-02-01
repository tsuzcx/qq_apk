package com.tencent.component.network.utils.http.base;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

public class QZoneHttpClient
  extends DefaultHttpClient
{
  public QZoneHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    super(paramClientConnectionManager, paramHttpParams);
  }
  
  protected AuthSchemeRegistry createAuthSchemeRegistry()
  {
    return super.createAuthSchemeRegistry();
  }
  
  protected ClientConnectionManager createClientConnectionManager()
  {
    return super.createClientConnectionManager();
  }
  
  protected RequestDirector createClientRequestDirector(HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectHandler paramRedirectHandler, AuthenticationHandler paramAuthenticationHandler1, AuthenticationHandler paramAuthenticationHandler2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams)
  {
    return new QZoneRequestDirector(paramHttpRequestExecutor, paramClientConnectionManager, paramConnectionReuseStrategy, paramConnectionKeepAliveStrategy, paramHttpRoutePlanner, paramHttpProcessor, paramHttpRequestRetryHandler, paramRedirectHandler, paramAuthenticationHandler1, paramAuthenticationHandler2, paramUserTokenHandler, paramHttpParams);
  }
  
  protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy()
  {
    return super.createConnectionKeepAliveStrategy();
  }
  
  protected ConnectionReuseStrategy createConnectionReuseStrategy()
  {
    return super.createConnectionReuseStrategy();
  }
  
  protected CookieSpecRegistry createCookieSpecRegistry()
  {
    return super.createCookieSpecRegistry();
  }
  
  protected CookieStore createCookieStore()
  {
    return super.createCookieStore();
  }
  
  protected CredentialsProvider createCredentialsProvider()
  {
    return super.createCredentialsProvider();
  }
  
  protected HttpContext createHttpContext()
  {
    return super.createHttpContext();
  }
  
  protected HttpParams createHttpParams()
  {
    return super.createHttpParams();
  }
  
  protected BasicHttpProcessor createHttpProcessor()
  {
    return super.createHttpProcessor();
  }
  
  protected HttpRequestRetryHandler createHttpRequestRetryHandler()
  {
    return super.createHttpRequestRetryHandler();
  }
  
  protected HttpRoutePlanner createHttpRoutePlanner()
  {
    return super.createHttpRoutePlanner();
  }
  
  protected AuthenticationHandler createProxyAuthenticationHandler()
  {
    return super.createProxyAuthenticationHandler();
  }
  
  protected RedirectHandler createRedirectHandler()
  {
    return super.createRedirectHandler();
  }
  
  protected HttpRequestExecutor createRequestExecutor()
  {
    return super.createRequestExecutor();
  }
  
  protected AuthenticationHandler createTargetAuthenticationHandler()
  {
    return super.createTargetAuthenticationHandler();
  }
  
  protected UserTokenHandler createUserTokenHandler()
  {
    return super.createUserTokenHandler();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.http.base.QZoneHttpClient
 * JD-Core Version:    0.7.0.1
 */