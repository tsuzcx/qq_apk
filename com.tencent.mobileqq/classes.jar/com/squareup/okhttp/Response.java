package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.OkHeaders;
import java.util.Collections;
import java.util.List;

public final class Response
{
  private final ResponseBody body;
  private volatile CacheControl cacheControl;
  private Response cacheResponse;
  private final int code;
  private final Handshake handshake;
  private final Headers headers;
  private final String message;
  private Response networkResponse;
  private final Response priorResponse;
  private final Protocol protocol;
  private final Request request;
  
  private Response(Response.Builder paramBuilder)
  {
    this.request = Response.Builder.access$000(paramBuilder);
    this.protocol = Response.Builder.access$100(paramBuilder);
    this.code = Response.Builder.access$200(paramBuilder);
    this.message = Response.Builder.access$300(paramBuilder);
    this.handshake = Response.Builder.access$400(paramBuilder);
    this.headers = Response.Builder.access$500(paramBuilder).build();
    this.body = Response.Builder.access$600(paramBuilder);
    this.networkResponse = Response.Builder.access$700(paramBuilder);
    this.cacheResponse = Response.Builder.access$800(paramBuilder);
    this.priorResponse = Response.Builder.access$900(paramBuilder);
  }
  
  public ResponseBody body()
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
  
  public Response cacheResponse()
  {
    return this.cacheResponse;
  }
  
  public List<Challenge> challenges()
  {
    if (this.code == 401) {}
    for (String str = "WWW-Authenticate";; str = "Proxy-Authenticate")
    {
      return OkHeaders.parseChallenges(headers(), str);
      if (this.code != 407) {
        break;
      }
    }
    return Collections.emptyList();
  }
  
  public int code()
  {
    return this.code;
  }
  
  public Handshake handshake()
  {
    return this.handshake;
  }
  
  public String header(String paramString)
  {
    return header(paramString, null);
  }
  
  public String header(String paramString1, String paramString2)
  {
    paramString1 = this.headers.get(paramString1);
    if (paramString1 != null) {
      paramString2 = paramString1;
    }
    return paramString2;
  }
  
  public Headers headers()
  {
    return this.headers;
  }
  
  public List<String> headers(String paramString)
  {
    return this.headers.values(paramString);
  }
  
  public boolean isRedirect()
  {
    switch (this.code)
    {
    case 304: 
    case 305: 
    case 306: 
    default: 
      return false;
    }
    return true;
  }
  
  public boolean isSuccessful()
  {
    return (this.code >= 200) && (this.code < 300);
  }
  
  public String message()
  {
    return this.message;
  }
  
  public Response networkResponse()
  {
    return this.networkResponse;
  }
  
  public Response.Builder newBuilder()
  {
    return new Response.Builder(this, null);
  }
  
  public Response priorResponse()
  {
    return this.priorResponse;
  }
  
  public Protocol protocol()
  {
    return this.protocol;
  }
  
  public Request request()
  {
    return this.request;
  }
  
  public String toString()
  {
    return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.urlString() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Response
 * JD-Core Version:    0.7.0.1
 */