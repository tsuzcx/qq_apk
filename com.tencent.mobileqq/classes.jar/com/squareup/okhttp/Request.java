package com.squareup.okhttp;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public final class Request
{
  private final RequestBody body;
  private volatile CacheControl cacheControl;
  private final Headers headers;
  private volatile URI javaNetUri;
  private volatile URL javaNetUrl;
  private final String method;
  private final Object tag;
  private final HttpUrl url;
  
  private Request(Request.Builder paramBuilder)
  {
    this.url = Request.Builder.access$000(paramBuilder);
    this.method = Request.Builder.access$100(paramBuilder);
    this.headers = Request.Builder.access$200(paramBuilder).build();
    this.body = Request.Builder.access$300(paramBuilder);
    if (Request.Builder.access$400(paramBuilder) != null) {}
    for (paramBuilder = Request.Builder.access$400(paramBuilder);; paramBuilder = this)
    {
      this.tag = paramBuilder;
      return;
    }
  }
  
  public RequestBody body()
  {
    return this.body;
  }
  
  public CacheControl cacheControl()
  {
    CacheControl localCacheControl = this.cacheControl;
    if (localCacheControl != null) {
      return localCacheControl;
    }
    localCacheControl = CacheControl.parse(this.headers);
    this.cacheControl = localCacheControl;
    return localCacheControl;
  }
  
  public String header(String paramString)
  {
    return this.headers.get(paramString);
  }
  
  public Headers headers()
  {
    return this.headers;
  }
  
  public List<String> headers(String paramString)
  {
    return this.headers.values(paramString);
  }
  
  public HttpUrl httpUrl()
  {
    return this.url;
  }
  
  public boolean isHttps()
  {
    return this.url.isHttps();
  }
  
  public String method()
  {
    return this.method;
  }
  
  public Request.Builder newBuilder()
  {
    return new Request.Builder(this, null);
  }
  
  public Object tag()
  {
    return this.tag;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Request{method=").append(this.method).append(", url=").append(this.url).append(", tag=");
    if (this.tag != this) {}
    for (Object localObject = this.tag;; localObject = null) {
      return localObject + '}';
    }
  }
  
  public URI uri()
  {
    try
    {
      URI localURI = this.javaNetUri;
      if (localURI != null) {
        return localURI;
      }
      localURI = this.url.uri();
      this.javaNetUri = localURI;
      return localURI;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new IOException(localIllegalStateException.getMessage());
    }
  }
  
  public URL url()
  {
    URL localURL = this.javaNetUrl;
    if (localURL != null) {
      return localURL;
    }
    localURL = this.url.url();
    this.javaNetUrl = localURL;
    return localURL;
  }
  
  public String urlString()
  {
    return this.url.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Request
 * JD-Core Version:    0.7.0.1
 */