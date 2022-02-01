package com.rookery.asyncHttpClient;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class AsyncHttpClient
{
  private static String a = "UTF-8";
  private static int b = 6;
  private static int c = 10000;
  private final DefaultHttpClient d;
  private final HttpContext e;
  private ThreadPoolExecutor f;
  private final Map<Context, List<WeakReference<Future<?>>>> g;
  private final Map<String, String> h;
  
  public AsyncHttpClient()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    ConnManagerParams.setTimeout(localBasicHttpParams, c);
    try
    {
      ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(b));
      ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 6);
    }
    catch (NoSuchMethodError localNoSuchMethodError1)
    {
      try
      {
        for (;;)
        {
          HttpConnectionParams.setSoTimeout(localBasicHttpParams, c);
          HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, c);
          HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
          HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
          HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
          label73:
          Object localObject1 = new SchemeRegistry();
          ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
          if (Build.VERSION.SDK_INT < 11) {
            try
            {
              Object localObject2 = KeyStore.getInstance(KeyStore.getDefaultType());
              ((KeyStore)localObject2).load(null, null);
              localObject2 = new CustomSSLSocketFactory((KeyStore)localObject2);
              ((SSLSocketFactory)localObject2).setHostnameVerifier(new AsyncHttpClient.1(this));
              ((SchemeRegistry)localObject1).register(new Scheme("https", (SocketFactory)localObject2, 443));
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("accept all ssl factory error");
                localStringBuilder.append(localException);
                QLog.e("Translator", 2, localStringBuilder.toString());
              }
              ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            }
          } else {
            ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
          }
          localObject1 = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject1);
          this.e = new SyncBasicHttpContext(new BasicHttpContext());
          this.d = new DefaultHttpClient((ClientConnectionManager)localObject1, localBasicHttpParams);
          this.d.addRequestInterceptor(new AsyncHttpClient.2(this));
          this.d.addResponseInterceptor(new AsyncHttpClient.3(this));
          this.d.setHttpRequestRetryHandler(new RetryHandler(3));
          this.f = ((ThreadPoolExecutor)Executors.newCachedThreadPool());
          this.g = new WeakHashMap();
          this.h = new HashMap();
          return;
          localNoSuchMethodError1 = localNoSuchMethodError1;
        }
      }
      catch (NoSuchMethodError localNoSuchMethodError2)
      {
        break label73;
      }
    }
  }
  
  public static String a(String paramString, List<Pair<String, String>> paramList)
  {
    Object localObject = paramString;
    if (paramList != null)
    {
      localObject = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Pair localPair = (Pair)paramList.next();
        ((List)localObject).add(new BasicNameValuePair((String)localPair.first, (String)localPair.second));
      }
      paramList = URLEncodedUtils.format((List)localObject, a);
      if (paramString.indexOf("?") == -1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("?");
        ((StringBuilder)localObject).append(paramList);
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(paramList);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public void a(Context paramContext, String paramString, Header[] paramArrayOfHeader, List<Pair<String, String>> paramList, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    paramString = new HttpGet(a(paramString, paramList));
    if (paramArrayOfHeader != null) {
      paramString.setHeaders(paramArrayOfHeader);
    }
    a(this.d, this.e, paramString, null, paramAsyncHttpResponseHandler, paramContext);
  }
  
  public void a(Context paramContext, String paramString1, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString2, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    paramString1 = new HttpPost(paramString1);
    if (paramHttpEntity != null) {
      paramString1.setEntity(paramHttpEntity);
    }
    if (paramArrayOfHeader != null) {
      paramString1.setHeaders(paramArrayOfHeader);
    }
    a(this.d, this.e, paramString1, paramString2, paramAsyncHttpResponseHandler, paramContext);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = (List)this.g.get(paramContext);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Future localFuture = (Future)((WeakReference)((Iterator)localObject).next()).get();
        if (localFuture != null)
        {
          localFuture.cancel(paramBoolean);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[cancel] cancel task");
            localStringBuilder.append(localFuture.toString());
            QLog.e("Translator", 2, localStringBuilder.toString());
          }
        }
      }
    }
    this.g.remove(paramContext);
  }
  
  protected void a(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString, AsyncHttpResponseHandler paramAsyncHttpResponseHandler, Context paramContext)
  {
    if (paramString != null) {
      paramHttpUriRequest.addHeader("Content-Type", paramString);
    }
    paramHttpUriRequest = this.f.submit(new AsyncHttpRequest(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, paramAsyncHttpResponseHandler));
    if (paramContext != null)
    {
      paramHttpContext = (List)this.g.get(paramContext);
      paramDefaultHttpClient = paramHttpContext;
      if (paramHttpContext == null)
      {
        paramDefaultHttpClient = new LinkedList();
        this.g.put(paramContext, paramDefaultHttpClient);
      }
      paramDefaultHttpClient.add(new WeakReference(paramHttpUriRequest));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.asyncHttpClient.AsyncHttpClient
 * JD-Core Version:    0.7.0.1
 */