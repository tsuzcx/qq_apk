package com.tencent.component.network.utils.http.base;

import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import java.net.URI;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.DefaultRequestDirector;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.client.RoutedRequest;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

public class QZoneRequestDirector
  extends DefaultRequestDirector
{
  private boolean mDirected = false;
  private String mHost = null;
  
  public QZoneRequestDirector(HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectHandler paramRedirectHandler, AuthenticationHandler paramAuthenticationHandler1, AuthenticationHandler paramAuthenticationHandler2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams)
  {
    super(paramHttpRequestExecutor, paramClientConnectionManager, paramConnectionReuseStrategy, paramConnectionKeepAliveStrategy, paramHttpRoutePlanner, paramHttpProcessor, paramHttpRequestRetryHandler, paramRedirectHandler, paramAuthenticationHandler1, paramAuthenticationHandler2, paramUserTokenHandler, paramHttpParams);
  }
  
  protected RoutedRequest handleResponse(RoutedRequest paramRoutedRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    paramRoutedRequest = super.handleResponse(paramRoutedRequest, paramHttpResponse, paramHttpContext);
    if ((paramRoutedRequest != null) && (HttpClientParams.isRedirecting(this.params))) {
      try
      {
        this.mDirected = true;
        paramHttpResponse = paramRoutedRequest.getRequest();
        if (paramHttpResponse != null)
        {
          if (paramHttpResponse.getURI() == null) {
            return paramRoutedRequest;
          }
          paramHttpContext.setAttribute("RedirectURI", paramHttpResponse.getURI().toString());
          paramHttpContext = paramHttpResponse.getURI().getAuthority();
          this.mHost = paramHttpContext;
          Header[] arrayOfHeader = paramHttpResponse.getAllHeaders();
          if (arrayOfHeader == null) {
            return paramRoutedRequest;
          }
          int j = arrayOfHeader.length;
          int i = 0;
          while (i < j)
          {
            StringBuilder localStringBuilder;
            if ("Host".equals(arrayOfHeader[i].getName()))
            {
              paramHttpResponse.removeHeader(arrayOfHeader[i]);
              if (!TextUtils.isEmpty(paramHttpContext)) {
                paramHttpResponse.addHeader("Host", paramHttpContext);
              }
              if (QDLog.isInfoEnable())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("download redirect orig host:");
                localStringBuilder.append(arrayOfHeader[i].getValue());
                localStringBuilder.append(" new host:");
                localStringBuilder.append(paramHttpContext);
                QDLog.i("http", localStringBuilder.toString());
              }
            }
            if ("x-online-host".equals(arrayOfHeader[i].getName()))
            {
              paramHttpResponse.removeHeader(arrayOfHeader[i]);
              if (!TextUtils.isEmpty(paramHttpContext)) {
                paramHttpResponse.addHeader("x-online-host", paramHttpContext);
              }
              if (QDLog.isInfoEnable())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("download redirect orig x-online-host:");
                localStringBuilder.append(arrayOfHeader[i].getValue());
                localStringBuilder.append(" new x-online-host:");
                localStringBuilder.append(paramHttpContext);
                QDLog.i("http", localStringBuilder.toString());
              }
            }
            i += 1;
          }
        }
        return paramRoutedRequest;
      }
      catch (Throwable paramHttpResponse)
      {
        QDLog.e("http", "handleResponse error", paramHttpResponse);
      }
    }
    return paramRoutedRequest;
  }
  
  protected void rewriteRequestURI(RequestWrapper paramRequestWrapper, HttpRoute paramHttpRoute)
  {
    super.rewriteRequestURI(paramRequestWrapper, paramHttpRoute);
    if (this.mDirected)
    {
      if (paramRequestWrapper == null) {
        return;
      }
      paramRequestWrapper.removeHeaders("Host");
      paramRequestWrapper.removeHeaders("x-online-host");
      if (!TextUtils.isEmpty(this.mHost))
      {
        paramRequestWrapper.addHeader("Host", this.mHost);
        paramRequestWrapper.addHeader("x-online-host", this.mHost);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.base.QZoneRequestDirector
 * JD-Core Version:    0.7.0.1
 */