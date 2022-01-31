package com.squareup.okhttp.internal;

import android.util.Log;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.tls.AndroidTrustRootIndex;
import com.squareup.okhttp.internal.tls.RealTrustRootIndex;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;

public class Platform
{
  private static final Platform PLATFORM = ;
  
  static byte[] concatLengthPrefixed(List<Protocol> paramList)
  {
    Buffer localBuffer = new Buffer();
    int i = 0;
    int j = paramList.size();
    if (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol == Protocol.HTTP_1_0) {}
      for (;;)
      {
        i += 1;
        break;
        localBuffer.writeByte(localProtocol.toString().length());
        localBuffer.writeUtf8(localProtocol.toString());
      }
    }
    return localBuffer.readByteArray();
  }
  
  /* Error */
  private static Platform findPlatform()
  {
    // Byte code:
    //   0: ldc 80
    //   2: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore 5
    //   7: new 88	com/squareup/okhttp/internal/OptionalMethod
    //   10: dup
    //   11: aconst_null
    //   12: ldc 90
    //   14: iconst_1
    //   15: anewarray 82	java/lang/Class
    //   18: dup
    //   19: iconst_0
    //   20: getstatic 96	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   23: aastore
    //   24: invokespecial 99	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   27: astore 10
    //   29: new 88	com/squareup/okhttp/internal/OptionalMethod
    //   32: dup
    //   33: aconst_null
    //   34: ldc 101
    //   36: iconst_1
    //   37: anewarray 82	java/lang/Class
    //   40: dup
    //   41: iconst_0
    //   42: ldc 57
    //   44: aastore
    //   45: invokespecial 99	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   48: astore 11
    //   50: aconst_null
    //   51: astore 9
    //   53: aconst_null
    //   54: astore_1
    //   55: aconst_null
    //   56: astore 8
    //   58: aconst_null
    //   59: astore 4
    //   61: aconst_null
    //   62: astore 7
    //   64: aconst_null
    //   65: astore 6
    //   67: aload_1
    //   68: astore_2
    //   69: aload 9
    //   71: astore_3
    //   72: aload 8
    //   74: astore_0
    //   75: ldc 103
    //   77: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   80: astore 12
    //   82: aload_1
    //   83: astore_2
    //   84: aload 9
    //   86: astore_3
    //   87: aload 8
    //   89: astore_0
    //   90: aload 12
    //   92: ldc 105
    //   94: iconst_1
    //   95: anewarray 82	java/lang/Class
    //   98: dup
    //   99: iconst_0
    //   100: ldc 107
    //   102: aastore
    //   103: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   106: astore_1
    //   107: aload_1
    //   108: astore_2
    //   109: aload_1
    //   110: astore_3
    //   111: aload 8
    //   113: astore_0
    //   114: aload 12
    //   116: ldc 113
    //   118: iconst_1
    //   119: anewarray 82	java/lang/Class
    //   122: dup
    //   123: iconst_0
    //   124: ldc 107
    //   126: aastore
    //   127: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   130: astore 8
    //   132: aload 8
    //   134: astore_2
    //   135: aload_1
    //   136: astore_3
    //   137: aload_2
    //   138: astore_0
    //   139: ldc 115
    //   141: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   144: pop
    //   145: aload_1
    //   146: astore_3
    //   147: aload_2
    //   148: astore_0
    //   149: new 88	com/squareup/okhttp/internal/OptionalMethod
    //   152: dup
    //   153: ldc 117
    //   155: ldc 119
    //   157: iconst_0
    //   158: anewarray 82	java/lang/Class
    //   161: invokespecial 99	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   164: astore 4
    //   166: new 88	com/squareup/okhttp/internal/OptionalMethod
    //   169: dup
    //   170: aconst_null
    //   171: ldc 121
    //   173: iconst_1
    //   174: anewarray 82	java/lang/Class
    //   177: dup
    //   178: iconst_0
    //   179: ldc 117
    //   181: aastore
    //   182: invokespecial 99	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   185: astore_3
    //   186: aload 4
    //   188: astore_0
    //   189: new 6	com/squareup/okhttp/internal/Platform$Android
    //   192: dup
    //   193: aload 5
    //   195: aload 10
    //   197: aload 11
    //   199: aload_1
    //   200: aload_2
    //   201: aload_0
    //   202: aload_3
    //   203: invokespecial 124	com/squareup/okhttp/internal/Platform$Android:<init>	(Ljava/lang/Class;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;)V
    //   206: areturn
    //   207: astore_0
    //   208: ldc 126
    //   210: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   213: astore 5
    //   215: goto -208 -> 7
    //   218: astore_0
    //   219: ldc 128
    //   221: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   224: astore_0
    //   225: ldc 130
    //   227: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   230: astore_1
    //   231: new 132	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   238: ldc 130
    //   240: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc 139
    //   245: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   254: astore_2
    //   255: new 132	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   262: ldc 130
    //   264: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 142
    //   269: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   278: astore_3
    //   279: new 132	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   286: ldc 130
    //   288: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc 144
    //   293: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   302: astore 4
    //   304: new 12	com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform
    //   307: dup
    //   308: aload_0
    //   309: aload_1
    //   310: ldc 146
    //   312: iconst_2
    //   313: anewarray 82	java/lang/Class
    //   316: dup
    //   317: iconst_0
    //   318: ldc 148
    //   320: aastore
    //   321: dup
    //   322: iconst_1
    //   323: aload_2
    //   324: aastore
    //   325: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   328: aload_1
    //   329: ldc 149
    //   331: iconst_1
    //   332: anewarray 82	java/lang/Class
    //   335: dup
    //   336: iconst_0
    //   337: ldc 148
    //   339: aastore
    //   340: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   343: aload_1
    //   344: ldc 151
    //   346: iconst_1
    //   347: anewarray 82	java/lang/Class
    //   350: dup
    //   351: iconst_0
    //   352: ldc 148
    //   354: aastore
    //   355: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   358: aload_3
    //   359: aload 4
    //   361: invokespecial 154	com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform:<init>	(Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   364: astore_1
    //   365: aload_1
    //   366: areturn
    //   367: astore_1
    //   368: new 9	com/squareup/okhttp/internal/Platform$JdkPlatform
    //   371: dup
    //   372: aload_0
    //   373: invokespecial 157	com/squareup/okhttp/internal/Platform$JdkPlatform:<init>	(Ljava/lang/Class;)V
    //   376: astore_0
    //   377: aload_0
    //   378: areturn
    //   379: astore_0
    //   380: new 2	com/squareup/okhttp/internal/Platform
    //   383: dup
    //   384: invokespecial 158	com/squareup/okhttp/internal/Platform:<init>	()V
    //   387: areturn
    //   388: astore_1
    //   389: goto -21 -> 368
    //   392: astore_0
    //   393: aload_2
    //   394: astore_1
    //   395: aload 4
    //   397: astore_2
    //   398: aload 7
    //   400: astore_0
    //   401: aload 6
    //   403: astore_3
    //   404: goto -215 -> 189
    //   407: astore_1
    //   408: aload_3
    //   409: astore_1
    //   410: aload_0
    //   411: astore_2
    //   412: aload 7
    //   414: astore_0
    //   415: aload 6
    //   417: astore_3
    //   418: goto -229 -> 189
    //   421: astore_0
    //   422: aload 4
    //   424: astore_0
    //   425: aload 6
    //   427: astore_3
    //   428: goto -239 -> 189
    //   431: astore_0
    //   432: aload 7
    //   434: astore_0
    //   435: aload 6
    //   437: astore_3
    //   438: goto -249 -> 189
    //   441: astore_0
    //   442: aload 4
    //   444: astore_0
    //   445: aload 6
    //   447: astore_3
    //   448: goto -259 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   74	128	0	localObject1	Object
    //   207	1	0	localClassNotFoundException1	ClassNotFoundException
    //   218	1	0	localClassNotFoundException2	ClassNotFoundException
    //   224	154	0	localObject2	Object
    //   379	1	0	localClassNotFoundException3	ClassNotFoundException
    //   392	1	0	localClassNotFoundException4	ClassNotFoundException
    //   400	15	0	localObject3	Object
    //   421	1	0	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   424	1	0	localObject4	Object
    //   431	1	0	localClassNotFoundException5	ClassNotFoundException
    //   434	1	0	localObject5	Object
    //   441	1	0	localClassNotFoundException6	ClassNotFoundException
    //   444	1	0	localObject6	Object
    //   54	312	1	localObject7	Object
    //   367	1	1	localClassNotFoundException7	ClassNotFoundException
    //   388	1	1	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   394	1	1	localObject8	Object
    //   407	1	1	localNoSuchMethodException3	java.lang.NoSuchMethodException
    //   409	1	1	localObject9	Object
    //   68	344	2	localObject10	Object
    //   71	377	3	localObject11	Object
    //   59	384	4	localObject12	Object
    //   5	209	5	localClass1	Class
    //   65	381	6	localObject13	Object
    //   62	371	7	localObject14	Object
    //   56	77	8	localMethod	Method
    //   51	34	9	localObject15	Object
    //   27	169	10	localOptionalMethod1	OptionalMethod
    //   48	150	11	localOptionalMethod2	OptionalMethod
    //   80	35	12	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   0	7	207	java/lang/ClassNotFoundException
    //   7	50	218	java/lang/ClassNotFoundException
    //   189	207	218	java/lang/ClassNotFoundException
    //   208	215	218	java/lang/ClassNotFoundException
    //   225	365	367	java/lang/ClassNotFoundException
    //   219	225	379	java/lang/ClassNotFoundException
    //   368	377	379	java/lang/ClassNotFoundException
    //   225	365	388	java/lang/NoSuchMethodException
    //   75	82	392	java/lang/ClassNotFoundException
    //   90	107	392	java/lang/ClassNotFoundException
    //   114	132	392	java/lang/ClassNotFoundException
    //   75	82	407	java/lang/NoSuchMethodException
    //   90	107	407	java/lang/NoSuchMethodException
    //   114	132	407	java/lang/NoSuchMethodException
    //   139	145	407	java/lang/NoSuchMethodException
    //   149	166	407	java/lang/NoSuchMethodException
    //   166	186	421	java/lang/NoSuchMethodException
    //   139	145	431	java/lang/ClassNotFoundException
    //   149	166	431	java/lang/ClassNotFoundException
    //   166	186	441	java/lang/ClassNotFoundException
  }
  
  public static Platform get()
  {
    return PLATFORM;
  }
  
  static <T> T readFieldOrNull(Object paramObject, Class<T> paramClass, String paramString)
  {
    Object localObject3 = null;
    Class localClass = paramObject.getClass();
    while (localClass != Object.class) {
      try
      {
        Object localObject1 = localClass.getDeclaredField(paramString);
        ((Field)localObject1).setAccessible(true);
        Object localObject4 = ((Field)localObject1).get(paramObject);
        localObject1 = localObject3;
        if (localObject4 == null) {
          break label123;
        }
        if (!paramClass.isInstance(localObject4)) {
          return null;
        }
        localObject1 = paramClass.cast(localObject4);
        return localObject1;
      }
      catch (IllegalAccessException paramObject)
      {
        throw new AssertionError();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    Object localObject2 = localObject3;
    if (!paramString.equals("delegate"))
    {
      paramObject = readFieldOrNull(paramObject, Object.class, "delegate");
      localObject2 = localObject3;
      if (paramObject != null) {
        localObject2 = readFieldOrNull(paramObject, paramClass, paramString);
      }
    }
    label123:
    return localObject2;
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket) {}
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {}
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public String getPrefix()
  {
    return "OkHttp";
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public void log(String paramString)
  {
    System.out.println(paramString);
  }
  
  public void logW(String paramString)
  {
    System.out.println(paramString);
  }
  
  public void tagSocket(Socket paramSocket)
    throws SocketException
  {}
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    return null;
  }
  
  public TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager)
  {
    return new RealTrustRootIndex(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public void untagSocket(Socket paramSocket)
    throws SocketException
  {}
  
  private static class Android
    extends Platform
  {
    private static final int MAX_LOG_LENGTH = 4000;
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    private final OptionalMethod<Socket> setAlpnProtocols;
    private final OptionalMethod<Socket> setHostname;
    private final OptionalMethod<Socket> setUseSessionTickets;
    private final Class<?> sslParametersClass;
    private final Method trafficStatsTagSocket;
    private final Method trafficStatsUntagSocket;
    
    public Android(Class<?> paramClass, OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, Method paramMethod1, Method paramMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4)
    {
      this.sslParametersClass = paramClass;
      this.setUseSessionTickets = paramOptionalMethod1;
      this.setHostname = paramOptionalMethod2;
      this.trafficStatsTagSocket = paramMethod1;
      this.trafficStatsUntagSocket = paramMethod2;
      this.getAlpnSelectedProtocol = paramOptionalMethod3;
      this.setAlpnProtocols = paramOptionalMethod4;
    }
    
    public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
    {
      if (paramString != null)
      {
        this.setUseSessionTickets.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
        this.setHostname.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
      }
      if ((this.setAlpnProtocols != null) && (this.setAlpnProtocols.isSupported(paramSSLSocket)))
      {
        paramString = concatLengthPrefixed(paramList);
        this.setAlpnProtocols.invokeWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
      }
    }
    
    public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
      throws IOException
    {
      try
      {
        paramSocket.connect(paramInetSocketAddress, paramInt);
        return;
      }
      catch (AssertionError paramSocket)
      {
        if (Util.isAndroidGetsocknameError(paramSocket)) {
          throw new IOException(paramSocket);
        }
        throw paramSocket;
      }
      catch (SecurityException paramSocket)
      {
        paramInetSocketAddress = new IOException("Exception in connect");
        paramInetSocketAddress.initCause(paramSocket);
        throw paramInetSocketAddress;
      }
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      if (this.getAlpnSelectedProtocol == null) {}
      while (!this.getAlpnSelectedProtocol.isSupported(paramSSLSocket)) {
        return null;
      }
      paramSSLSocket = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
      if (paramSSLSocket != null) {}
      for (paramSSLSocket = new String(paramSSLSocket, Util.UTF_8);; paramSSLSocket = null) {
        return paramSSLSocket;
      }
    }
    
    public void log(String paramString)
    {
      int i = 0;
      int m = paramString.length();
      if (i < m)
      {
        int j = paramString.indexOf('\n', i);
        if (j != -1) {}
        for (;;)
        {
          int k = Math.min(j, i + 4000);
          Log.d("OkHttp", paramString.substring(i, k));
          i = k;
          if (k >= j)
          {
            i = k + 1;
            break;
            j = m;
          }
        }
      }
    }
    
    public void tagSocket(Socket paramSocket)
      throws SocketException
    {
      if (this.trafficStatsTagSocket == null) {
        return;
      }
      try
      {
        this.trafficStatsTagSocket.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
      catch (InvocationTargetException paramSocket)
      {
        throw new RuntimeException(paramSocket.getCause());
      }
    }
    
    public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
    {
      Object localObject2 = readFieldOrNull(paramSSLSocketFactory, this.sslParametersClass, "sslParameters");
      Object localObject1 = localObject2;
      if (localObject2 == null) {}
      try
      {
        localObject1 = readFieldOrNull(paramSSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, paramSSLSocketFactory.getClass().getClassLoader()), "sslParameters");
        paramSSLSocketFactory = (X509TrustManager)readFieldOrNull(localObject1, X509TrustManager.class, "x509TrustManager");
        if (paramSSLSocketFactory != null) {
          return paramSSLSocketFactory;
        }
      }
      catch (ClassNotFoundException paramSSLSocketFactory)
      {
        return null;
      }
      return (X509TrustManager)readFieldOrNull(localObject1, X509TrustManager.class, "trustManager");
    }
    
    public TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager)
    {
      TrustRootIndex localTrustRootIndex = AndroidTrustRootIndex.get(paramX509TrustManager);
      if (localTrustRootIndex != null) {
        return localTrustRootIndex;
      }
      return super.trustRootIndex(paramX509TrustManager);
    }
    
    public void untagSocket(Socket paramSocket)
      throws SocketException
    {
      if (this.trafficStatsUntagSocket == null) {
        return;
      }
      try
      {
        this.trafficStatsUntagSocket.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
      catch (InvocationTargetException paramSocket)
      {
        throw new RuntimeException(paramSocket.getCause());
      }
    }
  }
  
  private static class JdkPlatform
    extends Platform
  {
    private final Class<?> sslContextClass;
    
    public JdkPlatform(Class<?> paramClass)
    {
      this.sslContextClass = paramClass;
    }
    
    public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
    {
      paramSSLSocketFactory = readFieldOrNull(paramSSLSocketFactory, this.sslContextClass, "context");
      if (paramSSLSocketFactory == null) {
        return null;
      }
      return (X509TrustManager)readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "trustManager");
    }
  }
  
  private static class JdkWithJettyBootPlatform
    extends Platform.JdkPlatform
  {
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;
    
    public JdkWithJettyBootPlatform(Class<?> paramClass1, Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass2, Class<?> paramClass3)
    {
      super();
      this.putMethod = paramMethod1;
      this.getMethod = paramMethod2;
      this.removeMethod = paramMethod3;
      this.clientProviderClass = paramClass2;
      this.serverProviderClass = paramClass3;
    }
    
    public void afterHandshake(SSLSocket paramSSLSocket)
    {
      try
      {
        this.removeMethod.invoke(null, new Object[] { paramSSLSocket });
        return;
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        label19:
        break label19;
      }
    }
    
    public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
    {
      paramString = new ArrayList(paramList.size());
      int i = 0;
      int j = paramList.size();
      Object localObject;
      if (i < j)
      {
        localObject = (Protocol)paramList.get(i);
        if (localObject == Protocol.HTTP_1_0) {}
        for (;;)
        {
          i += 1;
          break;
          paramString.add(((Protocol)localObject).toString());
        }
      }
      try
      {
        paramList = Platform.class.getClassLoader();
        localObject = this.clientProviderClass;
        Class localClass = this.serverProviderClass;
        paramString = new Platform.JettyNegoProvider(paramString);
        paramString = Proxy.newProxyInstance(paramList, new Class[] { localObject, localClass }, paramString);
        this.putMethod.invoke(null, new Object[] { paramSSLSocket, paramString });
        return;
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        label147:
        break label147;
      }
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      try
      {
        paramSSLSocket = (Platform.JettyNegoProvider)Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[] { paramSSLSocket }));
        if ((!Platform.JettyNegoProvider.access$000(paramSSLSocket)) && (Platform.JettyNegoProvider.access$100(paramSSLSocket) == null))
        {
          Internal.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
          return null;
        }
        if (!Platform.JettyNegoProvider.access$000(paramSSLSocket))
        {
          paramSSLSocket = Platform.JettyNegoProvider.access$100(paramSSLSocket);
          return paramSSLSocket;
        }
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        label65:
        break label65;
      }
      return null;
    }
  }
  
  private static class JettyNegoProvider
    implements InvocationHandler
  {
    private final List<String> protocols;
    private String selected;
    private boolean unsupported;
    
    public JettyNegoProvider(List<String> paramList)
    {
      this.protocols = paramList;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      String str = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = Util.EMPTY_STRING_ARRAY;
      }
      if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
        return Boolean.valueOf(true);
      }
      if ((str.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.unsupported = true;
        return null;
      }
      if ((str.equals("protocols")) && (paramObject.length == 0)) {
        return this.protocols;
      }
      if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        paramObject = (List)paramObject[0];
        int i = 0;
        int j = paramObject.size();
        while (i < j)
        {
          if (this.protocols.contains(paramObject.get(i)))
          {
            paramObject = (String)paramObject.get(i);
            this.selected = paramObject;
            return paramObject;
          }
          i += 1;
        }
        paramObject = (String)this.protocols.get(0);
        this.selected = paramObject;
        return paramObject;
      }
      if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
      {
        this.selected = ((String)paramObject[0]);
        return null;
      }
      return paramMethod.invoke(this, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.Platform
 * JD-Core Version:    0.7.0.1
 */