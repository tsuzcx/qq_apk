package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Date;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;

public final class HttpEngine
{
  private static final ResponseBody EMPTY_BODY = new HttpEngine.1();
  public static final int MAX_FOLLOW_UPS = 20;
  public final boolean bufferRequestBody;
  private BufferedSink bufferedRequestBody;
  private Response cacheResponse;
  private CacheStrategy cacheStrategy;
  private final boolean callerWritesRequestBody;
  final OkHttpClient client;
  private final boolean forWebSocket;
  private HttpStream httpStream;
  private Request networkRequest;
  private final Response priorResponse;
  private Sink requestBodyOut;
  long sentRequestMillis = -1L;
  private CacheRequest storeRequest;
  public final StreamAllocation streamAllocation;
  private boolean transparentGzip;
  private final Request userRequest;
  private Response userResponse;
  
  public HttpEngine(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, StreamAllocation paramStreamAllocation, RetryableSink paramRetryableSink, Response paramResponse)
  {
    this.client = paramOkHttpClient;
    this.userRequest = paramRequest;
    this.bufferRequestBody = paramBoolean1;
    this.callerWritesRequestBody = paramBoolean2;
    this.forWebSocket = paramBoolean3;
    if (paramStreamAllocation != null) {}
    for (;;)
    {
      this.streamAllocation = paramStreamAllocation;
      this.requestBodyOut = paramRetryableSink;
      this.priorResponse = paramResponse;
      return;
      paramStreamAllocation = new StreamAllocation(paramOkHttpClient.getConnectionPool(), createAddress(paramOkHttpClient, paramRequest));
    }
  }
  
  private Response cacheWritingResponse(CacheRequest paramCacheRequest, Response paramResponse)
  {
    if (paramCacheRequest == null) {}
    Sink localSink;
    do
    {
      return paramResponse;
      localSink = paramCacheRequest.body();
    } while (localSink == null);
    paramCacheRequest = new HttpEngine.2(this, paramResponse.body().source(), paramCacheRequest, Okio.buffer(localSink));
    return paramResponse.newBuilder().body(new RealResponseBody(paramResponse.headers(), Okio.buffer(paramCacheRequest))).build();
  }
  
  private static Headers combine(Headers paramHeaders1, Headers paramHeaders2)
  {
    int j = 0;
    Headers.Builder localBuilder = new Headers.Builder();
    int k = paramHeaders1.size();
    int i = 0;
    if (i < k)
    {
      String str1 = paramHeaders1.name(i);
      String str2 = paramHeaders1.value(i);
      if (("Warning".equalsIgnoreCase(str1)) && (str2.startsWith("1"))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!OkHeaders.isEndToEnd(str1)) || (paramHeaders2.get(str1) == null)) {
          localBuilder.add(str1, str2);
        }
      }
    }
    k = paramHeaders2.size();
    i = j;
    if (i < k)
    {
      paramHeaders1 = paramHeaders2.name(i);
      if ("Content-Length".equalsIgnoreCase(paramHeaders1)) {}
      for (;;)
      {
        i += 1;
        break;
        if (OkHeaders.isEndToEnd(paramHeaders1)) {
          localBuilder.add(paramHeaders1, paramHeaders2.value(i));
        }
      }
    }
    return localBuilder.build();
  }
  
  private HttpStream connect()
  {
    if (!this.networkRequest.method().equals("GET")) {}
    for (boolean bool = true;; bool = false) {
      return this.streamAllocation.newStream(this.client.getConnectTimeout(), this.client.getReadTimeout(), this.client.getWriteTimeout(), this.client.getRetryOnConnectionFailure(), bool);
    }
  }
  
  private static Address createAddress(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    CertificatePinner localCertificatePinner = null;
    SSLSocketFactory localSSLSocketFactory;
    HostnameVerifier localHostnameVerifier;
    if (paramRequest.isHttps())
    {
      localSSLSocketFactory = paramOkHttpClient.getSslSocketFactory();
      localHostnameVerifier = paramOkHttpClient.getHostnameVerifier();
      localCertificatePinner = paramOkHttpClient.getCertificatePinner();
    }
    for (;;)
    {
      return new Address(paramRequest.httpUrl().host(), paramRequest.httpUrl().port(), paramOkHttpClient.getDns(), paramOkHttpClient.getSocketFactory(), localSSLSocketFactory, localHostnameVerifier, localCertificatePinner, paramOkHttpClient.getAuthenticator(), paramOkHttpClient.getProxy(), paramOkHttpClient.getProtocols(), paramOkHttpClient.getConnectionSpecs(), paramOkHttpClient.getProxySelector());
      localHostnameVerifier = null;
      localSSLSocketFactory = null;
    }
  }
  
  public static boolean hasBody(Response paramResponse)
  {
    if (paramResponse.request().method().equals("HEAD")) {}
    do
    {
      return false;
      int i = paramResponse.code();
      if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304)) {
        return true;
      }
    } while ((OkHeaders.contentLength(paramResponse) == -1L) && (!"chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding"))));
    return true;
  }
  
  private void maybeCache()
  {
    InternalCache localInternalCache = Internal.instance.internalCache(this.client);
    if (localInternalCache == null) {}
    do
    {
      return;
      if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
        break;
      }
    } while (!HttpMethod.invalidatesCache(this.networkRequest.method()));
    try
    {
      localInternalCache.remove(this.networkRequest);
      return;
    }
    catch (IOException localIOException)
    {
      return;
    }
    this.storeRequest = localIOException.put(stripBody(this.userResponse));
  }
  
  private Request networkRequest(Request paramRequest)
  {
    Request.Builder localBuilder = paramRequest.newBuilder();
    if (paramRequest.header("Host") == null) {
      localBuilder.header("Host", Util.hostHeader(paramRequest.httpUrl()));
    }
    if (paramRequest.header("Connection") == null) {
      localBuilder.header("Connection", "Keep-Alive");
    }
    if (paramRequest.header("Accept-Encoding") == null)
    {
      this.transparentGzip = true;
      localBuilder.header("Accept-Encoding", "gzip");
    }
    CookieHandler localCookieHandler = this.client.getCookieHandler();
    if (localCookieHandler != null)
    {
      Map localMap = OkHeaders.toMultimap(localBuilder.build().headers(), null);
      OkHeaders.addCookies(localBuilder, localCookieHandler.get(paramRequest.uri(), localMap));
    }
    if (paramRequest.header("User-Agent") == null) {
      localBuilder.header("User-Agent", Version.userAgent());
    }
    return localBuilder.build();
  }
  
  private Response readNetworkResponse()
  {
    this.httpStream.finishRequest();
    Response localResponse2 = this.httpStream.readResponseHeaders().request(this.networkRequest).handshake(this.streamAllocation.connection().getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
    Response localResponse1 = localResponse2;
    if (!this.forWebSocket) {
      localResponse1 = localResponse2.newBuilder().body(this.httpStream.openResponseBody(localResponse2)).build();
    }
    if (("close".equalsIgnoreCase(localResponse1.request().header("Connection"))) || ("close".equalsIgnoreCase(localResponse1.header("Connection")))) {
      this.streamAllocation.noNewStreams();
    }
    return localResponse1;
  }
  
  private static Response stripBody(Response paramResponse)
  {
    Response localResponse = paramResponse;
    if (paramResponse != null)
    {
      localResponse = paramResponse;
      if (paramResponse.body() != null) {
        localResponse = paramResponse.newBuilder().body(null).build();
      }
    }
    return localResponse;
  }
  
  private Response unzip(Response paramResponse)
  {
    if ((!this.transparentGzip) || (!"gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding")))) {}
    while (paramResponse.body() == null) {
      return paramResponse;
    }
    GzipSource localGzipSource = new GzipSource(paramResponse.body().source());
    Headers localHeaders = paramResponse.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
    return paramResponse.newBuilder().headers(localHeaders).body(new RealResponseBody(localHeaders, Okio.buffer(localGzipSource))).build();
  }
  
  private static boolean validate(Response paramResponse1, Response paramResponse2)
  {
    if (paramResponse2.code() == 304) {}
    do
    {
      return true;
      paramResponse1 = paramResponse1.headers().getDate("Last-Modified");
      if (paramResponse1 == null) {
        break;
      }
      paramResponse2 = paramResponse2.headers().getDate("Last-Modified");
    } while ((paramResponse2 != null) && (paramResponse2.getTime() < paramResponse1.getTime()));
    return false;
  }
  
  public void cancel()
  {
    this.streamAllocation.cancel();
  }
  
  public StreamAllocation close()
  {
    if (this.bufferedRequestBody != null)
    {
      Util.closeQuietly(this.bufferedRequestBody);
      if (this.userResponse == null) {
        break label53;
      }
      Util.closeQuietly(this.userResponse.body());
    }
    for (;;)
    {
      return this.streamAllocation;
      if (this.requestBodyOut == null) {
        break;
      }
      Util.closeQuietly(this.requestBodyOut);
      break;
      label53:
      this.streamAllocation.connectionFailed();
    }
  }
  
  public Request followUpRequest()
  {
    if (this.userResponse == null) {
      throw new IllegalStateException();
    }
    Object localObject = this.streamAllocation.connection();
    if (localObject != null)
    {
      localObject = ((Connection)localObject).getRoute();
      label34:
      if (localObject == null) {
        break label143;
      }
    }
    String str;
    label143:
    for (localObject = ((Route)localObject).getProxy();; localObject = this.client.getProxy())
    {
      int i = this.userResponse.code();
      str = this.userRequest.method();
      switch (i)
      {
      default: 
        return null;
        localObject = null;
        break label34;
      }
    }
    if (((Proxy)localObject).type() != Proxy.Type.HTTP) {
      throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    }
    return OkHeaders.processAuthHeader(this.client.getAuthenticator(), this.userResponse, (Proxy)localObject);
    if ((!str.equals("GET")) && (!str.equals("HEAD"))) {
      return null;
    }
    if (!this.client.getFollowRedirects()) {
      return null;
    }
    localObject = this.userResponse.header("Location");
    if (localObject == null) {
      return null;
    }
    localObject = this.userRequest.httpUrl().resolve((String)localObject);
    if (localObject == null) {
      return null;
    }
    if ((!((HttpUrl)localObject).scheme().equals(this.userRequest.httpUrl().scheme())) && (!this.client.getFollowSslRedirects())) {
      return null;
    }
    Request.Builder localBuilder = this.userRequest.newBuilder();
    if (HttpMethod.permitsRequestBody(str))
    {
      if (!HttpMethod.redirectsToGet(str)) {
        break label376;
      }
      localBuilder.method("GET", null);
    }
    for (;;)
    {
      localBuilder.removeHeader("Transfer-Encoding");
      localBuilder.removeHeader("Content-Length");
      localBuilder.removeHeader("Content-Type");
      if (!sameConnection((HttpUrl)localObject)) {
        localBuilder.removeHeader("Authorization");
      }
      return localBuilder.url((HttpUrl)localObject).build();
      label376:
      localBuilder.method(str, null);
    }
  }
  
  public BufferedSink getBufferedRequestBody()
  {
    Object localObject = this.bufferedRequestBody;
    if (localObject != null) {
      return localObject;
    }
    localObject = getRequestBody();
    if (localObject != null)
    {
      localObject = Okio.buffer((Sink)localObject);
      this.bufferedRequestBody = ((BufferedSink)localObject);
      return localObject;
    }
    return null;
  }
  
  public Connection getConnection()
  {
    return this.streamAllocation.connection();
  }
  
  public Request getRequest()
  {
    return this.userRequest;
  }
  
  public Sink getRequestBody()
  {
    if (this.cacheStrategy == null) {
      throw new IllegalStateException();
    }
    return this.requestBodyOut;
  }
  
  public Response getResponse()
  {
    if (this.userResponse == null) {
      throw new IllegalStateException();
    }
    return this.userResponse;
  }
  
  public boolean hasResponse()
  {
    return this.userResponse != null;
  }
  
  boolean permitsRequestBody(Request paramRequest)
  {
    return HttpMethod.permitsRequestBody(paramRequest.method());
  }
  
  public void readResponse()
  {
    if (this.userResponse != null) {}
    label418:
    label430:
    label440:
    do
    {
      do
      {
        return;
        if ((this.networkRequest == null) && (this.cacheResponse == null)) {
          throw new IllegalStateException("call sendRequest() first!");
        }
      } while (this.networkRequest == null);
      if (this.forWebSocket) {
        this.httpStream.writeRequestHeaders(this.networkRequest);
      }
      for (Object localObject = readNetworkResponse();; localObject = new HttpEngine.NetworkInterceptorChain(this, 0, this.networkRequest).proceed(this.networkRequest))
      {
        receiveHeaders(((Response)localObject).headers());
        if (this.cacheResponse == null) {
          break label440;
        }
        if (!validate(this.cacheResponse, (Response)localObject)) {
          break label430;
        }
        this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), ((Response)localObject).headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody((Response)localObject)).build();
        ((Response)localObject).body().close();
        releaseStreamAllocation();
        localObject = Internal.instance.internalCache(this.client);
        ((InternalCache)localObject).trackConditionalCacheHit();
        ((InternalCache)localObject).update(this.cacheResponse, stripBody(this.userResponse));
        this.userResponse = unzip(this.userResponse);
        return;
        if (this.callerWritesRequestBody) {
          break;
        }
      }
      if ((this.bufferedRequestBody != null) && (this.bufferedRequestBody.buffer().size() > 0L)) {
        this.bufferedRequestBody.emit();
      }
      if (this.sentRequestMillis == -1L)
      {
        if ((OkHeaders.contentLength(this.networkRequest) == -1L) && ((this.requestBodyOut instanceof RetryableSink)))
        {
          long l = ((RetryableSink)this.requestBodyOut).contentLength();
          this.networkRequest = this.networkRequest.newBuilder().header("Content-Length", Long.toString(l)).build();
        }
        this.httpStream.writeRequestHeaders(this.networkRequest);
      }
      if (this.requestBodyOut != null)
      {
        if (this.bufferedRequestBody == null) {
          break label418;
        }
        this.bufferedRequestBody.close();
      }
      for (;;)
      {
        if ((this.requestBodyOut instanceof RetryableSink)) {
          this.httpStream.writeRequestBody((RetryableSink)this.requestBodyOut);
        }
        localObject = readNetworkResponse();
        break;
        this.requestBodyOut.close();
      }
      Util.closeQuietly(this.cacheResponse.body());
      this.userResponse = ((Response)localObject).newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody((Response)localObject)).build();
    } while (!hasBody(this.userResponse));
    maybeCache();
    this.userResponse = unzip(cacheWritingResponse(this.storeRequest, this.userResponse));
  }
  
  public void receiveHeaders(Headers paramHeaders)
  {
    CookieHandler localCookieHandler = this.client.getCookieHandler();
    if (localCookieHandler != null) {
      localCookieHandler.put(this.userRequest.uri(), OkHeaders.toMultimap(paramHeaders, null));
    }
  }
  
  public HttpEngine recover(RouteException paramRouteException)
  {
    if (!this.streamAllocation.recover(paramRouteException)) {}
    while (!this.client.getRetryOnConnectionFailure()) {
      return null;
    }
    paramRouteException = close();
    return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, paramRouteException, (RetryableSink)this.requestBodyOut, this.priorResponse);
  }
  
  public HttpEngine recover(IOException paramIOException)
  {
    return recover(paramIOException, this.requestBodyOut);
  }
  
  public HttpEngine recover(IOException paramIOException, Sink paramSink)
  {
    if (!this.streamAllocation.recover(paramIOException, paramSink)) {}
    while (!this.client.getRetryOnConnectionFailure()) {
      return null;
    }
    paramIOException = close();
    return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, paramIOException, (RetryableSink)paramSink, this.priorResponse);
  }
  
  public void releaseStreamAllocation()
  {
    this.streamAllocation.release();
  }
  
  public boolean sameConnection(HttpUrl paramHttpUrl)
  {
    HttpUrl localHttpUrl = this.userRequest.httpUrl();
    return (localHttpUrl.host().equals(paramHttpUrl.host())) && (localHttpUrl.port() == paramHttpUrl.port()) && (localHttpUrl.scheme().equals(paramHttpUrl.scheme()));
  }
  
  public void sendRequest()
  {
    if (this.cacheStrategy != null) {
      return;
    }
    if (this.httpStream != null) {
      throw new IllegalStateException();
    }
    Request localRequest = networkRequest(this.userRequest);
    InternalCache localInternalCache = Internal.instance.internalCache(this.client);
    if (localInternalCache != null) {}
    long l;
    for (Response localResponse = localInternalCache.get(localRequest);; localResponse = null)
    {
      this.cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), localRequest, localResponse).get();
      this.networkRequest = this.cacheStrategy.networkRequest;
      this.cacheResponse = this.cacheStrategy.cacheResponse;
      if (localInternalCache != null) {
        localInternalCache.trackResponse(this.cacheStrategy);
      }
      if ((localResponse != null) && (this.cacheResponse == null)) {
        Util.closeQuietly(localResponse.body());
      }
      if (this.networkRequest == null) {
        break label302;
      }
      this.httpStream = connect();
      this.httpStream.setHttpEngine(this);
      if ((!this.callerWritesRequestBody) || (!permitsRequestBody(this.networkRequest)) || (this.requestBodyOut != null)) {
        break;
      }
      l = OkHeaders.contentLength(localRequest);
      if (!this.bufferRequestBody) {
        break label270;
      }
      if (l <= 2147483647L) {
        break label223;
      }
      throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
    }
    label223:
    if (l != -1L)
    {
      this.httpStream.writeRequestHeaders(this.networkRequest);
      this.requestBodyOut = new RetryableSink((int)l);
      return;
    }
    this.requestBodyOut = new RetryableSink();
    return;
    label270:
    this.httpStream.writeRequestHeaders(this.networkRequest);
    this.requestBodyOut = this.httpStream.createRequestBody(this.networkRequest, l);
    return;
    label302:
    if (this.cacheResponse != null) {}
    for (this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build();; this.userResponse = new Response.Builder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build())
    {
      this.userResponse = unzip(this.userResponse);
      return;
    }
  }
  
  public void writingRequestHeaders()
  {
    if (this.sentRequestMillis != -1L) {
      throw new IllegalStateException();
    }
    this.sentRequestMillis = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.HttpEngine
 * JD-Core Version:    0.7.0.1
 */