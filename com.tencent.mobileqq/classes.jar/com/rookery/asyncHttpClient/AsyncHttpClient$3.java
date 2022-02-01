package com.rookery.asyncHttpClient;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

class AsyncHttpClient$3
  implements HttpResponseInterceptor
{
  AsyncHttpClient$3(AsyncHttpClient paramAsyncHttpClient) {}
  
  public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    paramHttpContext = paramHttpResponse.getEntity();
    if (paramHttpContext == null) {
      return;
    }
    paramHttpContext = paramHttpContext.getContentEncoding();
    if (paramHttpContext != null)
    {
      paramHttpContext = paramHttpContext.getElements();
      int j = paramHttpContext.length;
      int i = 0;
      while (i < j)
      {
        if (paramHttpContext[i].getName().equalsIgnoreCase("gzip"))
        {
          paramHttpResponse.setEntity(new AsyncHttpClient.InflatingEntity(paramHttpResponse.getEntity()));
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.asyncHttpClient.AsyncHttpClient.3
 * JD-Core Version:    0.7.0.1
 */