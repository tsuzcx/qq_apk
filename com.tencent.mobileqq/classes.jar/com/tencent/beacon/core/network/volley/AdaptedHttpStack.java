package com.tencent.beacon.core.network.volley;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;

class AdaptedHttpStack
  extends BaseHttpStack
{
  private final HttpStack mHttpStack;
  
  AdaptedHttpStack(HttpStack paramHttpStack)
  {
    this.mHttpStack = paramHttpStack;
  }
  
  public HttpResponse executeRequest(Request<?> paramRequest, Map<String, String> paramMap)
  {
    try
    {
      paramRequest = this.mHttpStack.performRequest(paramRequest, paramMap);
      int j = paramRequest.getStatusLine().getStatusCode();
      paramMap = paramRequest.getAllHeaders();
      ArrayList localArrayList = new ArrayList(paramMap.length);
      int k = paramMap.length;
      int i = 0;
      while (i < k)
      {
        Object localObject = paramMap[i];
        localArrayList.add(new Header(localObject.getName(), localObject.getValue()));
        i += 1;
      }
      if (paramRequest.getEntity() == null) {
        return new HttpResponse(j, localArrayList);
      }
      long l = paramRequest.getEntity().getContentLength();
      if ((int)l == l) {
        return new HttpResponse(j, localArrayList, (int)paramRequest.getEntity().getContentLength(), paramRequest.getEntity().getContent());
      }
      throw new IOException("Response too large: " + l);
    }
    catch (ConnectTimeoutException paramRequest)
    {
      throw new SocketTimeoutException(paramRequest.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.AdaptedHttpStack
 * JD-Core Version:    0.7.0.1
 */