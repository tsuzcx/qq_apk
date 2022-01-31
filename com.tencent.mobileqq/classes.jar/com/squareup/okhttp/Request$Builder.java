package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HttpMethod;
import java.net.URL;

public class Request$Builder
{
  private RequestBody body;
  private Headers.Builder headers;
  private String method;
  private Object tag;
  private HttpUrl url;
  
  public Request$Builder()
  {
    this.method = "GET";
    this.headers = new Headers.Builder();
  }
  
  private Request$Builder(Request paramRequest)
  {
    this.url = Request.access$600(paramRequest);
    this.method = Request.access$700(paramRequest);
    this.body = Request.access$800(paramRequest);
    this.tag = Request.access$900(paramRequest);
    this.headers = Request.access$1000(paramRequest).newBuilder();
  }
  
  public Builder addHeader(String paramString1, String paramString2)
  {
    this.headers.add(paramString1, paramString2);
    return this;
  }
  
  public Request build()
  {
    if (this.url == null) {
      throw new IllegalStateException("url == null");
    }
    return new Request(this, null);
  }
  
  public Builder cacheControl(CacheControl paramCacheControl)
  {
    paramCacheControl = paramCacheControl.toString();
    if (paramCacheControl.isEmpty()) {
      return removeHeader("Cache-Control");
    }
    return header("Cache-Control", paramCacheControl);
  }
  
  public Builder delete()
  {
    return delete(RequestBody.create(null, new byte[0]));
  }
  
  public Builder delete(RequestBody paramRequestBody)
  {
    return method("DELETE", paramRequestBody);
  }
  
  public Builder get()
  {
    return method("GET", null);
  }
  
  public Builder head()
  {
    return method("HEAD", null);
  }
  
  public Builder header(String paramString1, String paramString2)
  {
    this.headers.set(paramString1, paramString2);
    return this;
  }
  
  public Builder headers(Headers paramHeaders)
  {
    this.headers = paramHeaders.newBuilder();
    return this;
  }
  
  public Builder method(String paramString, RequestBody paramRequestBody)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("method == null || method.length() == 0");
    }
    if ((paramRequestBody != null) && (!HttpMethod.permitsRequestBody(paramString))) {
      throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
    }
    if ((paramRequestBody == null) && (HttpMethod.requiresRequestBody(paramString))) {
      throw new IllegalArgumentException("method " + paramString + " must have a request body.");
    }
    this.method = paramString;
    this.body = paramRequestBody;
    return this;
  }
  
  public Builder patch(RequestBody paramRequestBody)
  {
    return method("PATCH", paramRequestBody);
  }
  
  public Builder post(RequestBody paramRequestBody)
  {
    return method("POST", paramRequestBody);
  }
  
  public Builder put(RequestBody paramRequestBody)
  {
    return method("PUT", paramRequestBody);
  }
  
  public Builder removeHeader(String paramString)
  {
    this.headers.removeAll(paramString);
    return this;
  }
  
  public Builder tag(Object paramObject)
  {
    this.tag = paramObject;
    return this;
  }
  
  public Builder url(HttpUrl paramHttpUrl)
  {
    if (paramHttpUrl == null) {
      throw new IllegalArgumentException("url == null");
    }
    this.url = paramHttpUrl;
    return this;
  }
  
  public Builder url(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("url == null");
    }
    String str;
    if (paramString.regionMatches(true, 0, "ws:", 0, 3)) {
      str = "http:" + paramString.substring(3);
    }
    for (;;)
    {
      paramString = HttpUrl.parse(str);
      if (paramString != null) {
        break;
      }
      throw new IllegalArgumentException("unexpected url: " + str);
      str = paramString;
      if (paramString.regionMatches(true, 0, "wss:", 0, 4)) {
        str = "https:" + paramString.substring(4);
      }
    }
    return url(paramString);
  }
  
  public Builder url(URL paramURL)
  {
    if (paramURL == null) {
      throw new IllegalArgumentException("url == null");
    }
    HttpUrl localHttpUrl = HttpUrl.get(paramURL);
    if (localHttpUrl == null) {
      throw new IllegalArgumentException("unexpected url: " + paramURL);
    }
    return url(localHttpUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Request.Builder
 * JD-Core Version:    0.7.0.1
 */