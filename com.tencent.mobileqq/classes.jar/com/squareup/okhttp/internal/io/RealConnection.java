package com.squareup.okhttp.internal.io;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.ConnectionSpecSelector;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.framed.FramedConnection.Builder;
import com.squareup.okhttp.internal.http.Http1xStream;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.List<Lcom.squareup.okhttp.ConnectionSpec;>;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public final class RealConnection
  implements Connection
{
  private static SSLSocketFactory lastSslSocketFactory;
  private static TrustRootIndex lastTrustRootIndex;
  public final List<Reference<StreamAllocation>> allocations = new ArrayList();
  public volatile FramedConnection framedConnection;
  private Handshake handshake;
  public long idleAtNanos = 9223372036854775807L;
  public boolean noNewStreams;
  private Protocol protocol;
  private Socket rawSocket;
  private final Route route;
  public BufferedSink sink;
  public Socket socket;
  public BufferedSource source;
  public int streamCount;
  
  public RealConnection(Route paramRoute)
  {
    this.route = paramRoute;
  }
  
  private void connectSocket(int paramInt1, int paramInt2, int paramInt3, ConnectionSpecSelector paramConnectionSpecSelector)
  {
    this.rawSocket.setSoTimeout(paramInt2);
    for (;;)
    {
      try
      {
        Platform.get().connectSocket(this.rawSocket, this.route.getSocketAddress(), paramInt1);
        this.source = Okio.buffer(Okio.source(this.rawSocket));
        this.sink = Okio.buffer(Okio.sink(this.rawSocket));
        if (this.route.getAddress().getSslSocketFactory() != null)
        {
          connectTls(paramInt2, paramInt3, paramConnectionSpecSelector);
          if ((this.protocol == Protocol.SPDY_3) || (this.protocol == Protocol.HTTP_2))
          {
            this.socket.setSoTimeout(0);
            paramConnectionSpecSelector = new FramedConnection.Builder(true).socket(this.socket, this.route.getAddress().url().host(), this.source, this.sink).protocol(this.protocol).build();
            paramConnectionSpecSelector.sendConnectionPreface();
            this.framedConnection = paramConnectionSpecSelector;
          }
          return;
        }
      }
      catch (ConnectException paramConnectionSpecSelector)
      {
        throw new ConnectException("Failed to connect to " + this.route.getSocketAddress());
      }
      this.protocol = Protocol.HTTP_1_1;
      this.socket = this.rawSocket;
    }
  }
  
  /* Error */
  private void connectTls(int paramInt1, int paramInt2, ConnectionSpecSelector paramConnectionSpecSelector)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: getfield 50	com/squareup/okhttp/internal/io/RealConnection:route	Lcom/squareup/okhttp/Route;
    //   13: invokevirtual 182	com/squareup/okhttp/Route:requiresTunnel	()Z
    //   16: ifeq +9 -> 25
    //   19: aload_0
    //   20: iload_1
    //   21: iload_2
    //   22: invokespecial 186	com/squareup/okhttp/internal/io/RealConnection:createTunnel	(II)V
    //   25: aload_0
    //   26: getfield 50	com/squareup/okhttp/internal/io/RealConnection:route	Lcom/squareup/okhttp/Route;
    //   29: invokevirtual 101	com/squareup/okhttp/Route:getAddress	()Lcom/squareup/okhttp/Address;
    //   32: astore 8
    //   34: aload 8
    //   36: invokevirtual 107	com/squareup/okhttp/Address:getSslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   39: astore 5
    //   41: aload 5
    //   43: aload_0
    //   44: getfield 57	com/squareup/okhttp/internal/io/RealConnection:rawSocket	Ljava/net/Socket;
    //   47: aload 8
    //   49: invokevirtual 189	com/squareup/okhttp/Address:getUriHost	()Ljava/lang/String;
    //   52: aload 8
    //   54: invokevirtual 193	com/squareup/okhttp/Address:getUriPort	()I
    //   57: iconst_1
    //   58: invokevirtual 199	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   61: checkcast 201	javax/net/ssl/SSLSocket
    //   64: astore 5
    //   66: aload_3
    //   67: aload 5
    //   69: invokevirtual 207	com/squareup/okhttp/internal/ConnectionSpecSelector:configureSecureSocket	(Ljavax/net/ssl/SSLSocket;)Lcom/squareup/okhttp/ConnectionSpec;
    //   72: astore 7
    //   74: aload 7
    //   76: invokevirtual 212	com/squareup/okhttp/ConnectionSpec:supportsTlsExtensions	()Z
    //   79: ifeq +21 -> 100
    //   82: invokestatic 69	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   85: aload 5
    //   87: aload 8
    //   89: invokevirtual 189	com/squareup/okhttp/Address:getUriHost	()Ljava/lang/String;
    //   92: aload 8
    //   94: invokevirtual 216	com/squareup/okhttp/Address:getProtocols	()Ljava/util/List;
    //   97: invokevirtual 220	com/squareup/okhttp/internal/Platform:configureTlsExtensions	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   100: aload 5
    //   102: invokevirtual 223	javax/net/ssl/SSLSocket:startHandshake	()V
    //   105: aload 5
    //   107: invokevirtual 227	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   110: invokestatic 232	com/squareup/okhttp/Handshake:get	(Ljavax/net/ssl/SSLSession;)Lcom/squareup/okhttp/Handshake;
    //   113: astore 4
    //   115: aload 8
    //   117: invokevirtual 236	com/squareup/okhttp/Address:getHostnameVerifier	()Ljavax/net/ssl/HostnameVerifier;
    //   120: aload 8
    //   122: invokevirtual 189	com/squareup/okhttp/Address:getUriHost	()Ljava/lang/String;
    //   125: aload 5
    //   127: invokevirtual 227	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   130: invokeinterface 242 3 0
    //   135: ifne +148 -> 283
    //   138: aload 4
    //   140: invokevirtual 245	com/squareup/okhttp/Handshake:peerCertificates	()Ljava/util/List;
    //   143: iconst_0
    //   144: invokeinterface 250 2 0
    //   149: checkcast 252	java/security/cert/X509Certificate
    //   152: astore_3
    //   153: new 254	javax/net/ssl/SSLPeerUnverifiedException
    //   156: dup
    //   157: new 157	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   164: ldc_w 256
    //   167: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 8
    //   172: invokevirtual 189	com/squareup/okhttp/Address:getUriHost	()Ljava/lang/String;
    //   175: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 258
    //   181: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_3
    //   185: invokestatic 264	com/squareup/okhttp/CertificatePinner:pin	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   188: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 266
    //   194: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_3
    //   198: invokevirtual 270	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   201: invokeinterface 275 1 0
    //   206: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc_w 277
    //   212: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_3
    //   216: invokestatic 283	com/squareup/okhttp/internal/tls/OkHostnameVerifier:allSubjectAltNames	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   219: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokespecial 284	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   228: athrow
    //   229: astore 4
    //   231: aload 5
    //   233: astore_3
    //   234: aload 4
    //   236: astore 5
    //   238: aload_3
    //   239: astore 4
    //   241: aload 5
    //   243: invokestatic 290	com/squareup/okhttp/internal/Util:isAndroidGetsocknameError	(Ljava/lang/AssertionError;)Z
    //   246: ifeq +181 -> 427
    //   249: aload_3
    //   250: astore 4
    //   252: new 292	java/io/IOException
    //   255: dup
    //   256: aload 5
    //   258: invokespecial 295	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   261: athrow
    //   262: astore_3
    //   263: aload 4
    //   265: ifnull +11 -> 276
    //   268: invokestatic 69	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   271: aload 4
    //   273: invokevirtual 299	com/squareup/okhttp/internal/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   276: aload 4
    //   278: invokestatic 303	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   281: aload_3
    //   282: athrow
    //   283: aload 8
    //   285: invokevirtual 307	com/squareup/okhttp/Address:getCertificatePinner	()Lcom/squareup/okhttp/CertificatePinner;
    //   288: getstatic 311	com/squareup/okhttp/CertificatePinner:DEFAULT	Lcom/squareup/okhttp/CertificatePinner;
    //   291: if_acmpeq +41 -> 332
    //   294: new 313	com/squareup/okhttp/internal/tls/CertificateChainCleaner
    //   297: dup
    //   298: aload 8
    //   300: invokevirtual 107	com/squareup/okhttp/Address:getSslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   303: invokestatic 317	com/squareup/okhttp/internal/io/RealConnection:trustRootIndex	(Ljavax/net/ssl/SSLSocketFactory;)Lcom/squareup/okhttp/internal/tls/TrustRootIndex;
    //   306: invokespecial 320	com/squareup/okhttp/internal/tls/CertificateChainCleaner:<init>	(Lcom/squareup/okhttp/internal/tls/TrustRootIndex;)V
    //   309: aload 4
    //   311: invokevirtual 245	com/squareup/okhttp/Handshake:peerCertificates	()Ljava/util/List;
    //   314: invokevirtual 324	com/squareup/okhttp/internal/tls/CertificateChainCleaner:clean	(Ljava/util/List;)Ljava/util/List;
    //   317: astore_3
    //   318: aload 8
    //   320: invokevirtual 307	com/squareup/okhttp/Address:getCertificatePinner	()Lcom/squareup/okhttp/CertificatePinner;
    //   323: aload 8
    //   325: invokevirtual 189	com/squareup/okhttp/Address:getUriHost	()Ljava/lang/String;
    //   328: aload_3
    //   329: invokevirtual 328	com/squareup/okhttp/CertificatePinner:check	(Ljava/lang/String;Ljava/util/List;)V
    //   332: aload 6
    //   334: astore_3
    //   335: aload 7
    //   337: invokevirtual 212	com/squareup/okhttp/ConnectionSpec:supportsTlsExtensions	()Z
    //   340: ifeq +12 -> 352
    //   343: invokestatic 69	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   346: aload 5
    //   348: invokevirtual 332	com/squareup/okhttp/internal/Platform:getSelectedProtocol	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   351: astore_3
    //   352: aload_0
    //   353: aload 5
    //   355: putfield 123	com/squareup/okhttp/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   358: aload_0
    //   359: aload_0
    //   360: getfield 123	com/squareup/okhttp/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   363: invokestatic 83	okio/Okio:source	(Ljava/net/Socket;)Lokio/Source;
    //   366: invokestatic 87	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   369: putfield 89	com/squareup/okhttp/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   372: aload_0
    //   373: aload_0
    //   374: getfield 123	com/squareup/okhttp/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   377: invokestatic 92	okio/Okio:sink	(Ljava/net/Socket;)Lokio/Sink;
    //   380: invokestatic 95	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   383: putfield 97	com/squareup/okhttp/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   386: aload_0
    //   387: aload 4
    //   389: putfield 334	com/squareup/okhttp/internal/io/RealConnection:handshake	Lcom/squareup/okhttp/Handshake;
    //   392: aload_3
    //   393: ifnull +27 -> 420
    //   396: aload_3
    //   397: invokestatic 337	com/squareup/okhttp/Protocol:get	(Ljava/lang/String;)Lcom/squareup/okhttp/Protocol;
    //   400: astore_3
    //   401: aload_0
    //   402: aload_3
    //   403: putfield 113	com/squareup/okhttp/internal/io/RealConnection:protocol	Lcom/squareup/okhttp/Protocol;
    //   406: aload 5
    //   408: ifnull +11 -> 419
    //   411: invokestatic 69	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   414: aload 5
    //   416: invokevirtual 299	com/squareup/okhttp/internal/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   419: return
    //   420: getstatic 176	com/squareup/okhttp/Protocol:HTTP_1_1	Lcom/squareup/okhttp/Protocol;
    //   423: astore_3
    //   424: goto -23 -> 401
    //   427: aload_3
    //   428: astore 4
    //   430: aload 5
    //   432: athrow
    //   433: astore_3
    //   434: aload 5
    //   436: astore 4
    //   438: goto -175 -> 263
    //   441: astore 5
    //   443: aload 7
    //   445: astore_3
    //   446: goto -208 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	this	RealConnection
    //   0	449	1	paramInt1	int
    //   0	449	2	paramInt2	int
    //   0	449	3	paramConnectionSpecSelector	ConnectionSpecSelector
    //   1	138	4	localHandshake	Handshake
    //   229	6	4	localAssertionError1	java.lang.AssertionError
    //   239	198	4	localObject1	Object
    //   39	396	5	localObject2	Object
    //   441	1	5	localAssertionError2	java.lang.AssertionError
    //   4	329	6	localObject3	Object
    //   7	437	7	localConnectionSpec	ConnectionSpec
    //   32	292	8	localAddress	Address
    // Exception table:
    //   from	to	target	type
    //   66	100	229	java/lang/AssertionError
    //   100	229	229	java/lang/AssertionError
    //   283	332	229	java/lang/AssertionError
    //   335	352	229	java/lang/AssertionError
    //   352	392	229	java/lang/AssertionError
    //   396	401	229	java/lang/AssertionError
    //   401	406	229	java/lang/AssertionError
    //   420	424	229	java/lang/AssertionError
    //   41	66	262	finally
    //   241	249	262	finally
    //   252	262	262	finally
    //   430	433	262	finally
    //   66	100	433	finally
    //   100	229	433	finally
    //   283	332	433	finally
    //   335	352	433	finally
    //   352	392	433	finally
    //   396	401	433	finally
    //   401	406	433	finally
    //   420	424	433	finally
    //   41	66	441	java/lang/AssertionError
  }
  
  private void createTunnel(int paramInt1, int paramInt2)
  {
    Object localObject1 = createTunnelRequest();
    Object localObject2 = ((Request)localObject1).httpUrl();
    String str = "CONNECT " + ((HttpUrl)localObject2).host() + ":" + ((HttpUrl)localObject2).port() + " HTTP/1.1";
    do
    {
      localObject2 = new Http1xStream(null, this.source, this.sink);
      this.source.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
      this.sink.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
      ((Http1xStream)localObject2).writeRequest(((Request)localObject1).headers(), str);
      ((Http1xStream)localObject2).finishRequest();
      localObject1 = ((Http1xStream)localObject2).readResponse().request((Request)localObject1).build();
      long l2 = OkHeaders.contentLength((Response)localObject1);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      localObject2 = ((Http1xStream)localObject2).newFixedLengthSource(l1);
      Util.skipAll((Source)localObject2, 2147483647, TimeUnit.MILLISECONDS);
      ((Source)localObject2).close();
      switch (((Response)localObject1).code())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + ((Response)localObject1).code());
      case 200: 
        if ((this.source.buffer().exhausted()) && (this.sink.buffer().exhausted())) {
          break;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
      case 407: 
        localObject2 = OkHeaders.processAuthHeader(this.route.getAddress().getAuthenticator(), (Response)localObject1, this.route.getProxy());
        localObject1 = localObject2;
      }
    } while (localObject2 != null);
    throw new IOException("Failed to authenticate with proxy");
  }
  
  private Request createTunnelRequest()
  {
    return new Request.Builder().url(this.route.getAddress().url()).header("Host", Util.hostHeader(this.route.getAddress().url())).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
  }
  
  private static TrustRootIndex trustRootIndex(SSLSocketFactory paramSSLSocketFactory)
  {
    try
    {
      if (paramSSLSocketFactory != lastSslSocketFactory)
      {
        X509TrustManager localX509TrustManager = Platform.get().trustManager(paramSSLSocketFactory);
        lastTrustRootIndex = Platform.get().trustRootIndex(localX509TrustManager);
        lastSslSocketFactory = paramSSLSocketFactory;
      }
      paramSSLSocketFactory = lastTrustRootIndex;
      return paramSSLSocketFactory;
    }
    finally {}
  }
  
  public int allocationLimit()
  {
    FramedConnection localFramedConnection = this.framedConnection;
    if (localFramedConnection != null) {
      return localFramedConnection.maxConcurrentStreams();
    }
    return 1;
  }
  
  public void cancel()
  {
    Util.closeQuietly(this.rawSocket);
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, List<ConnectionSpec> paramList, boolean paramBoolean)
  {
    if (this.protocol != null) {
      throw new IllegalStateException("already connected");
    }
    ConnectionSpecSelector localConnectionSpecSelector = new ConnectionSpecSelector(paramList);
    Proxy localProxy = this.route.getProxy();
    Address localAddress = this.route.getAddress();
    if ((this.route.getAddress().getSslSocketFactory() == null) && (!paramList.contains(ConnectionSpec.CLEARTEXT))) {
      throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + paramList));
    }
    for (;;)
    {
      try
      {
        localObject = new Socket(localProxy);
        this.rawSocket = ((Socket)localObject);
        connectSocket(paramInt1, paramInt2, paramInt3, localConnectionSpecSelector);
      }
      catch (IOException localIOException)
      {
        Util.closeQuietly(this.socket);
        Util.closeQuietly(this.rawSocket);
        this.socket = null;
        this.rawSocket = null;
        this.source = null;
        this.sink = null;
        this.handshake = null;
        this.protocol = null;
        if (paramList != null) {
          continue;
        }
        Object localObject = new RouteException(localIOException);
        if (!paramBoolean) {
          continue;
        }
        paramList = (List<ConnectionSpec>)localObject;
        if (localConnectionSpecSelector.connectionFailed(localIOException)) {
          continue;
        }
        throw ((Throwable)localObject);
        paramList.addConnectException(localIOException);
        localObject = paramList;
        continue;
      }
      if (this.protocol == null)
      {
        if ((localProxy.type() == Proxy.Type.DIRECT) || (localProxy.type() == Proxy.Type.HTTP)) {
          localObject = localAddress.getSocketFactory().createSocket();
        }
      }
      else
      {
        return;
        paramList = null;
      }
    }
  }
  
  public Handshake getHandshake()
  {
    return this.handshake;
  }
  
  public Protocol getProtocol()
  {
    if (this.protocol != null) {
      return this.protocol;
    }
    return Protocol.HTTP_1_1;
  }
  
  public Route getRoute()
  {
    return this.route;
  }
  
  public Socket getSocket()
  {
    return this.socket;
  }
  
  boolean isConnected()
  {
    return this.protocol != null;
  }
  
  public boolean isHealthy(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.socket.isClosed()) || (this.socket.isInputShutdown()) || (this.socket.isOutputShutdown())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.framedConnection != null);
      bool1 = bool2;
    } while (!paramBoolean);
    try
    {
      int i = this.socket.getSoTimeout();
      try
      {
        this.socket.setSoTimeout(1);
        paramBoolean = this.source.exhausted();
        return !paramBoolean;
      }
      finally
      {
        this.socket.setSoTimeout(i);
      }
      return true;
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
  }
  
  public boolean isMultiplexed()
  {
    return this.framedConnection != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.route.getAddress().url().host()).append(":").append(this.route.getAddress().url().port()).append(", proxy=").append(this.route.getProxy()).append(" hostAddress=").append(this.route.getSocketAddress()).append(" cipherSuite=");
    if (this.handshake != null) {}
    for (String str = this.handshake.cipherSuite();; str = "none") {
      return str + " protocol=" + this.protocol + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.io.RealConnection
 * JD-Core Version:    0.7.0.1
 */