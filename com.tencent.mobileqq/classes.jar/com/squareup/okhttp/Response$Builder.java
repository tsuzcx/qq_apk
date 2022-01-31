package com.squareup.okhttp;

public class Response$Builder
{
  private ResponseBody body;
  private Response cacheResponse;
  private int code = -1;
  private Handshake handshake;
  private Headers.Builder headers;
  private String message;
  private Response networkResponse;
  private Response priorResponse;
  private Protocol protocol;
  private Request request;
  
  public Response$Builder()
  {
    this.headers = new Headers.Builder();
  }
  
  private Response$Builder(Response paramResponse)
  {
    this.request = Response.access$1100(paramResponse);
    this.protocol = Response.access$1200(paramResponse);
    this.code = Response.access$1300(paramResponse);
    this.message = Response.access$1400(paramResponse);
    this.handshake = Response.access$1500(paramResponse);
    this.headers = Response.access$1600(paramResponse).newBuilder();
    this.body = Response.access$1700(paramResponse);
    this.networkResponse = Response.access$1800(paramResponse);
    this.cacheResponse = Response.access$1900(paramResponse);
    this.priorResponse = Response.access$2000(paramResponse);
  }
  
  private void checkPriorResponse(Response paramResponse)
  {
    if (Response.access$1700(paramResponse) != null) {
      throw new IllegalArgumentException("priorResponse.body != null");
    }
  }
  
  private void checkSupportResponse(String paramString, Response paramResponse)
  {
    if (Response.access$1700(paramResponse) != null) {
      throw new IllegalArgumentException(paramString + ".body != null");
    }
    if (Response.access$1800(paramResponse) != null) {
      throw new IllegalArgumentException(paramString + ".networkResponse != null");
    }
    if (Response.access$1900(paramResponse) != null) {
      throw new IllegalArgumentException(paramString + ".cacheResponse != null");
    }
    if (Response.access$2000(paramResponse) != null) {
      throw new IllegalArgumentException(paramString + ".priorResponse != null");
    }
  }
  
  public Builder addHeader(String paramString1, String paramString2)
  {
    this.headers.add(paramString1, paramString2);
    return this;
  }
  
  public Builder body(ResponseBody paramResponseBody)
  {
    this.body = paramResponseBody;
    return this;
  }
  
  public Response build()
  {
    if (this.request == null) {
      throw new IllegalStateException("request == null");
    }
    if (this.protocol == null) {
      throw new IllegalStateException("protocol == null");
    }
    if (this.code < 0) {
      throw new IllegalStateException("code < 0: " + this.code);
    }
    return new Response(this, null);
  }
  
  public Builder cacheResponse(Response paramResponse)
  {
    if (paramResponse != null) {
      checkSupportResponse("cacheResponse", paramResponse);
    }
    this.cacheResponse = paramResponse;
    return this;
  }
  
  public Builder code(int paramInt)
  {
    this.code = paramInt;
    return this;
  }
  
  public Builder handshake(Handshake paramHandshake)
  {
    this.handshake = paramHandshake;
    return this;
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
  
  public Builder message(String paramString)
  {
    this.message = paramString;
    return this;
  }
  
  public Builder networkResponse(Response paramResponse)
  {
    if (paramResponse != null) {
      checkSupportResponse("networkResponse", paramResponse);
    }
    this.networkResponse = paramResponse;
    return this;
  }
  
  public Builder priorResponse(Response paramResponse)
  {
    if (paramResponse != null) {
      checkPriorResponse(paramResponse);
    }
    this.priorResponse = paramResponse;
    return this;
  }
  
  public Builder protocol(Protocol paramProtocol)
  {
    this.protocol = paramProtocol;
    return this;
  }
  
  public Builder removeHeader(String paramString)
  {
    this.headers.removeAll(paramString);
    return this;
  }
  
  public Builder request(Request paramRequest)
  {
    this.request = paramRequest;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Response.Builder
 * JD-Core Version:    0.7.0.1
 */