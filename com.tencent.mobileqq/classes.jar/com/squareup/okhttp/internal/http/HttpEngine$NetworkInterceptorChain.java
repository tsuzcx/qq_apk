package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import java.net.ProtocolException;
import java.util.List;
import okio.BufferedSink;
import okio.Okio;

class HttpEngine$NetworkInterceptorChain
  implements Interceptor.Chain
{
  private int calls;
  private final int index;
  private final Request request;
  
  HttpEngine$NetworkInterceptorChain(HttpEngine paramHttpEngine, int paramInt, Request paramRequest)
  {
    this.index = paramInt;
    this.request = paramRequest;
  }
  
  public Connection connection()
  {
    return this.this$0.streamAllocation.connection();
  }
  
  public Response proceed(Request paramRequest)
  {
    this.calls += 1;
    Object localObject1;
    Object localObject2;
    if (this.index > 0)
    {
      localObject1 = (Interceptor)this.this$0.client.networkInterceptors().get(this.index - 1);
      localObject2 = connection().getRoute().getAddress();
      if ((!paramRequest.httpUrl().host().equals(((Address)localObject2).getUriHost())) || (paramRequest.httpUrl().port() != ((Address)localObject2).getUriPort())) {
        throw new IllegalStateException("network interceptor " + localObject1 + " must retain the same host and port");
      }
      if (this.calls > 1) {
        throw new IllegalStateException("network interceptor " + localObject1 + " must call proceed() exactly once");
      }
    }
    if (this.index < this.this$0.client.networkInterceptors().size())
    {
      localObject1 = new NetworkInterceptorChain(this.this$0, this.index + 1, paramRequest);
      localObject2 = (Interceptor)this.this$0.client.networkInterceptors().get(this.index);
      paramRequest = ((Interceptor)localObject2).intercept((Interceptor.Chain)localObject1);
      if (((NetworkInterceptorChain)localObject1).calls != 1) {
        throw new IllegalStateException("network interceptor " + localObject2 + " must call proceed() exactly once");
      }
      if (paramRequest == null) {
        throw new NullPointerException("network interceptor " + localObject2 + " returned null");
      }
    }
    int i;
    do
    {
      do
      {
        return paramRequest;
        HttpEngine.access$000(this.this$0).writeRequestHeaders(paramRequest);
        HttpEngine.access$102(this.this$0, paramRequest);
        if ((this.this$0.permitsRequestBody(paramRequest)) && (paramRequest.body() != null))
        {
          localObject1 = Okio.buffer(HttpEngine.access$000(this.this$0).createRequestBody(paramRequest, paramRequest.body().contentLength()));
          paramRequest.body().writeTo((BufferedSink)localObject1);
          ((BufferedSink)localObject1).close();
        }
        localObject1 = HttpEngine.access$200(this.this$0);
        i = ((Response)localObject1).code();
        if (i == 204) {
          break;
        }
        paramRequest = (Request)localObject1;
      } while (i != 205);
      paramRequest = (Request)localObject1;
    } while (((Response)localObject1).body().contentLength() <= 0L);
    throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + ((Response)localObject1).body().contentLength());
  }
  
  public Request request()
  {
    return this.request;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.HttpEngine.NetworkInterceptorChain
 * JD-Core Version:    0.7.0.1
 */