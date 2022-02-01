package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.util.g;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.HostnameVerifier;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class WebViewSSLCheckThread
  extends Thread
{
  private static final String TAG = WebViewSSLCheckThread.class.getSimpleName();
  private javax.net.ssl.SSLSocketFactory L;
  private org.apache.http.conn.ssl.SSLSocketFactory M;
  private X509HostnameVerifier N;
  private SslErrorHandler O;
  private String P;
  private WebViewSSLCheckThread.Callback Q;
  private HostnameVerifier hostnameVerifier;
  private Context u;
  
  public WebViewSSLCheckThread() {}
  
  public WebViewSSLCheckThread(SslErrorHandler paramSslErrorHandler, String paramString, Context paramContext)
  {
    setSslErrorHandler(paramSslErrorHandler);
    setUrl(paramString);
    setContext(paramContext);
    setSslSocketFactory(new SecureSSLSocketFactory(new c(paramContext)));
    setHostnameVerifier(SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    try
    {
      setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory(null, new c(paramContext)));
      setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      return;
    }
    catch (UnrecoverableKeyException paramSslErrorHandler)
    {
      for (;;)
      {
        g.e(TAG, "WebViewSSLCheckThread: UnrecoverableKeyException : " + paramSslErrorHandler.getMessage());
      }
    }
  }
  
  @Deprecated
  public WebViewSSLCheckThread(SslErrorHandler paramSslErrorHandler, String paramString, javax.net.ssl.SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier)
  {
    setSslErrorHandler(paramSslErrorHandler);
    setUrl(paramString);
    setSslSocketFactory(paramSSLSocketFactory);
    setHostnameVerifier(paramHostnameVerifier);
  }
  
  @Deprecated
  public WebViewSSLCheckThread(SslErrorHandler paramSslErrorHandler, String paramString, org.apache.http.conn.ssl.SSLSocketFactory paramSSLSocketFactory, X509HostnameVerifier paramX509HostnameVerifier)
  {
    setSslErrorHandler(paramSslErrorHandler);
    setUrl(paramString);
    setApacheSSLSocketFactory(paramSSLSocketFactory);
    setApacheHostnameVerifier(paramX509HostnameVerifier);
  }
  
  @Deprecated
  public WebViewSSLCheckThread(SslErrorHandler paramSslErrorHandler, String paramString, org.apache.http.conn.ssl.SSLSocketFactory paramSSLSocketFactory, X509HostnameVerifier paramX509HostnameVerifier, WebViewSSLCheckThread.Callback paramCallback, Context paramContext)
  {
    this.O = paramSslErrorHandler;
    this.P = paramString;
    this.M = paramSSLSocketFactory;
    this.N = paramX509HostnameVerifier;
    this.Q = paramCallback;
    this.u = paramContext;
  }
  
  private void b()
  {
    g.c(TAG, "callbackCancel: ");
    if (this.Q != null) {
      this.Q.onCancel(this.u, this.P);
    }
    while (this.O == null) {
      return;
    }
    g.c(TAG, "callbackCancel 2: ");
    this.O.cancel();
  }
  
  private void c()
  {
    g.c(TAG, "callbackProceed: ");
    if (this.Q != null) {
      this.Q.onProceed(this.u, this.P);
    }
    while (this.O == null) {
      return;
    }
    this.O.proceed();
  }
  
  public static void checkServerCertificateWithOK(SslErrorHandler paramSslErrorHandler, String paramString, Context paramContext)
  {
    checkServerCertificateWithOK(paramSslErrorHandler, paramString, paramContext, null);
  }
  
  public static void checkServerCertificateWithOK(SslErrorHandler paramSslErrorHandler, String paramString, Context paramContext, WebViewSSLCheckThread.Callback paramCallback)
  {
    if ((paramSslErrorHandler == null) || (TextUtils.isEmpty(paramString)) || (paramContext == null))
    {
      g.e(TAG, "checkServerCertificateWithOK: handler or url or context is null");
      return;
    }
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    try
    {
      Object localObject = new SecureSSLSocketFactory(new c(paramContext));
      ((SecureSSLSocketFactory)localObject).setContext(paramContext);
      localBuilder.sslSocketFactory((javax.net.ssl.SSLSocketFactory)localObject, new c(paramContext));
      localBuilder.hostnameVerifier(SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      localObject = new Request.Builder().url(paramString).build();
      localBuilder.build().newCall((Request)localObject).enqueue(new WebViewSSLCheckThread.1(paramCallback, paramContext, paramString, paramSslErrorHandler));
      return;
    }
    catch (Exception paramString)
    {
      g.e(TAG, "checkServerCertificateWithOK: exception : " + paramString.getMessage());
      paramSslErrorHandler.cancel();
    }
  }
  
  public X509HostnameVerifier getApacheHostnameVerifier()
  {
    return this.N;
  }
  
  public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory()
  {
    return this.M;
  }
  
  public WebViewSSLCheckThread.Callback getCallback()
  {
    return this.Q;
  }
  
  public Context getContext()
  {
    return this.u;
  }
  
  public HostnameVerifier getHostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public SslErrorHandler getSslErrorHandler()
  {
    return this.O;
  }
  
  public javax.net.ssl.SSLSocketFactory getSslSocketFactory()
  {
    return this.L;
  }
  
  public String getUrl()
  {
    return this.P;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: invokespecial 231	java/lang/Thread:run	()V
    //   8: aload_0
    //   9: getfield 116	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:M	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   12: ifnull +287 -> 299
    //   15: aload_0
    //   16: getfield 118	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:N	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   19: ifnull +280 -> 299
    //   22: aload_0
    //   23: getfield 112	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:O	Landroid/webkit/SslErrorHandler;
    //   26: ifnull +13 -> 39
    //   29: aload_0
    //   30: getfield 114	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:P	Ljava/lang/String;
    //   33: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +16 -> 52
    //   39: getstatic 31	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:TAG	Ljava/lang/String;
    //   42: ldc 233
    //   44: invokestatic 105	com/huawei/secure/android/common/ssl/util/g:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_0
    //   48: invokespecial 235	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:b	()V
    //   51: return
    //   52: aload_0
    //   53: getfield 116	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:M	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   56: aload_0
    //   57: getfield 118	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:N	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   60: invokevirtual 239	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
    //   63: aload_0
    //   64: getfield 116	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:M	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   67: instanceof 72
    //   70: ifeq +17 -> 87
    //   73: aload_0
    //   74: getfield 116	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:M	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   77: checkcast 72	com/huawei/secure/android/common/ssl/SecureApacheSSLSocketFactory
    //   80: aload_0
    //   81: getfield 122	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:u	Landroid/content/Context;
    //   84: invokevirtual 240	com/huawei/secure/android/common/ssl/SecureApacheSSLSocketFactory:setContext	(Landroid/content/Context;)V
    //   87: new 242	org/apache/http/params/BasicHttpParams
    //   90: dup
    //   91: invokespecial 243	org/apache/http/params/BasicHttpParams:<init>	()V
    //   94: astore_1
    //   95: aload_1
    //   96: sipush 30000
    //   99: invokestatic 249	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   102: aload_1
    //   103: sipush 30000
    //   106: invokestatic 252	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   109: new 254	org/apache/http/conn/scheme/SchemeRegistry
    //   112: dup
    //   113: invokespecial 255	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   116: astore_2
    //   117: aload_2
    //   118: new 257	org/apache/http/conn/scheme/Scheme
    //   121: dup
    //   122: ldc_w 259
    //   125: aload_0
    //   126: getfield 116	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:M	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   129: sipush 443
    //   132: invokespecial 262	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   135: invokevirtual 266	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   138: pop
    //   139: aload_2
    //   140: new 257	org/apache/http/conn/scheme/Scheme
    //   143: dup
    //   144: ldc_w 268
    //   147: invokestatic 274	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   150: bipush 80
    //   152: invokespecial 262	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   155: invokevirtual 266	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   158: pop
    //   159: new 276	org/apache/http/impl/client/DefaultHttpClient
    //   162: dup
    //   163: new 278	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   166: dup
    //   167: aload_1
    //   168: aload_2
    //   169: invokespecial 281	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   172: aload_1
    //   173: invokespecial 284	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   176: astore_1
    //   177: new 286	org/apache/http/client/methods/HttpGet
    //   180: dup
    //   181: invokespecial 287	org/apache/http/client/methods/HttpGet:<init>	()V
    //   184: astore_2
    //   185: aload_2
    //   186: new 289	java/net/URI
    //   189: dup
    //   190: aload_0
    //   191: getfield 114	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:P	Ljava/lang/String;
    //   194: invokespecial 291	java/net/URI:<init>	(Ljava/lang/String;)V
    //   197: invokevirtual 295	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   200: aload_1
    //   201: aload_2
    //   202: invokeinterface 301 2 0
    //   207: astore_1
    //   208: getstatic 31	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:TAG	Ljava/lang/String;
    //   211: new 86	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 303
    //   221: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_1
    //   225: invokeinterface 309 1 0
    //   230: invokeinterface 315 1 0
    //   235: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 128	com/huawei/secure/android/common/ssl/util/g:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aconst_null
    //   245: invokestatic 324	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/Reader;)V
    //   248: aload_0
    //   249: invokespecial 326	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:c	()V
    //   252: return
    //   253: astore_1
    //   254: getstatic 31	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:TAG	Ljava/lang/String;
    //   257: new 86	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   264: ldc_w 328
    //   267: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload_1
    //   271: invokevirtual 208	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   274: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 105	com/huawei/secure/android/common/ssl/util/g:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_0
    //   284: invokespecial 235	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:b	()V
    //   287: aconst_null
    //   288: invokestatic 324	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/Reader;)V
    //   291: return
    //   292: astore_1
    //   293: aconst_null
    //   294: invokestatic 324	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/Reader;)V
    //   297: aload_1
    //   298: athrow
    //   299: aload_0
    //   300: getfield 227	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:L	Ljavax/net/ssl/SSLSocketFactory;
    //   303: ifnull +166 -> 469
    //   306: aload_0
    //   307: getfield 221	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:hostnameVerifier	Ljavax/net/ssl/HostnameVerifier;
    //   310: ifnull +159 -> 469
    //   313: aload_2
    //   314: astore_1
    //   315: new 330	java/net/URL
    //   318: dup
    //   319: aload_0
    //   320: getfield 114	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:P	Ljava/lang/String;
    //   323: invokespecial 331	java/net/URL:<init>	(Ljava/lang/String;)V
    //   326: invokevirtual 335	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   329: astore 4
    //   331: aload_2
    //   332: astore_1
    //   333: aload 4
    //   335: instanceof 337
    //   338: ifeq +144 -> 482
    //   341: aload_2
    //   342: astore_1
    //   343: aload 4
    //   345: checkcast 337	javax/net/ssl/HttpsURLConnection
    //   348: astore_2
    //   349: aload_2
    //   350: aload_0
    //   351: getfield 227	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:L	Ljavax/net/ssl/SSLSocketFactory;
    //   354: invokevirtual 340	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   357: aload_2
    //   358: aload_0
    //   359: getfield 221	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:hostnameVerifier	Ljavax/net/ssl/HostnameVerifier;
    //   362: invokevirtual 341	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   365: aload_2
    //   366: ldc_w 343
    //   369: invokevirtual 346	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   372: aload_2
    //   373: sipush 10000
    //   376: invokevirtual 350	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   379: aload_2
    //   380: sipush 20000
    //   383: invokevirtual 353	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   386: aload_2
    //   387: invokevirtual 356	javax/net/ssl/HttpsURLConnection:connect	()V
    //   390: aload_2
    //   391: ifnull +7 -> 398
    //   394: aload_2
    //   395: invokevirtual 359	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   398: aload_0
    //   399: invokespecial 326	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:c	()V
    //   402: return
    //   403: astore_1
    //   404: aload_3
    //   405: astore_2
    //   406: aload_1
    //   407: astore_3
    //   408: aload_2
    //   409: astore_1
    //   410: getstatic 31	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:TAG	Ljava/lang/String;
    //   413: new 86	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   420: ldc_w 361
    //   423: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload_3
    //   427: invokevirtual 208	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   430: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 105	com/huawei/secure/android/common/ssl/util/g:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: aload_2
    //   440: astore_1
    //   441: aload_0
    //   442: invokespecial 235	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:b	()V
    //   445: aload_2
    //   446: ifnull -395 -> 51
    //   449: aload_2
    //   450: invokevirtual 359	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   453: return
    //   454: astore_3
    //   455: aload_1
    //   456: astore_2
    //   457: aload_3
    //   458: astore_1
    //   459: aload_2
    //   460: ifnull +7 -> 467
    //   463: aload_2
    //   464: invokevirtual 359	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   467: aload_1
    //   468: athrow
    //   469: aload_0
    //   470: invokespecial 235	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:b	()V
    //   473: return
    //   474: astore_1
    //   475: goto -16 -> 459
    //   478: astore_3
    //   479: goto -71 -> 408
    //   482: aconst_null
    //   483: astore_2
    //   484: goto -94 -> 390
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	this	WebViewSSLCheckThread
    //   94	131	1	localObject1	Object
    //   253	18	1	localException1	Exception
    //   292	6	1	localObject2	Object
    //   314	29	1	localObject3	Object
    //   403	4	1	localException2	Exception
    //   409	59	1	localObject4	Object
    //   474	1	1	localObject5	Object
    //   1	483	2	localObject6	Object
    //   3	424	3	localObject7	Object
    //   454	4	3	localObject8	Object
    //   478	1	3	localException3	Exception
    //   329	15	4	localURLConnection	java.net.URLConnection
    // Exception table:
    //   from	to	target	type
    //   52	87	253	java/lang/Exception
    //   87	244	253	java/lang/Exception
    //   52	87	292	finally
    //   87	244	292	finally
    //   254	287	292	finally
    //   315	331	403	java/lang/Exception
    //   333	341	403	java/lang/Exception
    //   343	349	403	java/lang/Exception
    //   315	331	454	finally
    //   333	341	454	finally
    //   343	349	454	finally
    //   410	439	454	finally
    //   441	445	454	finally
    //   349	390	474	finally
    //   349	390	478	java/lang/Exception
  }
  
  public void setApacheHostnameVerifier(X509HostnameVerifier paramX509HostnameVerifier)
  {
    this.N = paramX509HostnameVerifier;
  }
  
  public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory paramSSLSocketFactory)
  {
    this.M = paramSSLSocketFactory;
  }
  
  public void setCallback(WebViewSSLCheckThread.Callback paramCallback)
  {
    this.Q = paramCallback;
  }
  
  public void setContext(Context paramContext)
  {
    this.u = paramContext;
  }
  
  public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.hostnameVerifier = paramHostnameVerifier;
  }
  
  public void setSslErrorHandler(SslErrorHandler paramSslErrorHandler)
  {
    this.O = paramSslErrorHandler;
  }
  
  public void setSslSocketFactory(javax.net.ssl.SSLSocketFactory paramSSLSocketFactory)
  {
    this.L = paramSSLSocketFactory;
  }
  
  public void setUrl(String paramString)
  {
    this.P = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.WebViewSSLCheckThread
 * JD-Core Version:    0.7.0.1
 */