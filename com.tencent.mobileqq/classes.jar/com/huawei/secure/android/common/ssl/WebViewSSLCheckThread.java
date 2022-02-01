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
  private static final String i = "WebViewSSLCheckThread";
  private javax.net.ssl.SSLSocketFactory a;
  private HostnameVerifier b;
  private org.apache.http.conn.ssl.SSLSocketFactory c;
  private X509HostnameVerifier d;
  private SslErrorHandler e;
  private String f;
  private WebViewSSLCheckThread.Callback g;
  private Context h;
  
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
    }
    catch (UnrecoverableKeyException paramSslErrorHandler)
    {
      paramString = i;
      paramContext = new StringBuilder();
      paramContext.append("WebViewSSLCheckThread: UnrecoverableKeyException : ");
      paramContext.append(paramSslErrorHandler.getMessage());
      g.b(paramString, paramContext.toString());
    }
    setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
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
    this.e = paramSslErrorHandler;
    this.f = paramString;
    this.c = paramSSLSocketFactory;
    this.d = paramX509HostnameVerifier;
    this.g = paramCallback;
    this.h = paramContext;
  }
  
  private void b()
  {
    g.c(i, "callbackCancel: ");
    WebViewSSLCheckThread.Callback localCallback = this.g;
    if (localCallback != null)
    {
      localCallback.onCancel(this.h, this.f);
      return;
    }
    if (this.e != null)
    {
      g.c(i, "callbackCancel 2: ");
      this.e.cancel();
    }
  }
  
  private void c()
  {
    g.c(i, "callbackProceed: ");
    Object localObject = this.g;
    if (localObject != null)
    {
      ((WebViewSSLCheckThread.Callback)localObject).onProceed(this.h, this.f);
      return;
    }
    localObject = this.e;
    if (localObject != null) {
      ((SslErrorHandler)localObject).proceed();
    }
  }
  
  public static void checkServerCertificateWithOK(SslErrorHandler paramSslErrorHandler, String paramString, Context paramContext)
  {
    checkServerCertificateWithOK(paramSslErrorHandler, paramString, paramContext, null);
  }
  
  public static void checkServerCertificateWithOK(SslErrorHandler paramSslErrorHandler, String paramString, Context paramContext, WebViewSSLCheckThread.Callback paramCallback)
  {
    if ((paramSslErrorHandler != null) && (!TextUtils.isEmpty(paramString)) && (paramContext != null))
    {
      OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
      try
      {
        Object localObject = new SecureSSLSocketFactory(new c(paramContext));
        ((SecureSSLSocketFactory)localObject).setContext(paramContext);
        localBuilder.sslSocketFactory((javax.net.ssl.SSLSocketFactory)localObject, new c(paramContext));
        localBuilder.hostnameVerifier(SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        localObject = new Request.Builder().url(paramString).build();
        localBuilder.build().newCall((Request)localObject).enqueue(new WebViewSSLCheckThread.a(paramCallback, paramContext, paramString, paramSslErrorHandler));
        return;
      }
      catch (Exception paramString)
      {
        paramContext = i;
        paramCallback = new StringBuilder();
        paramCallback.append("checkServerCertificateWithOK: exception : ");
        paramCallback.append(paramString.getMessage());
        g.b(paramContext, paramCallback.toString());
        paramSslErrorHandler.cancel();
        return;
      }
    }
    g.b(i, "checkServerCertificateWithOK: handler or url or context is null");
  }
  
  public X509HostnameVerifier getApacheHostnameVerifier()
  {
    return this.d;
  }
  
  public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory()
  {
    return this.c;
  }
  
  public WebViewSSLCheckThread.Callback getCallback()
  {
    return this.g;
  }
  
  public Context getContext()
  {
    return this.h;
  }
  
  public HostnameVerifier getHostnameVerifier()
  {
    return this.b;
  }
  
  public SslErrorHandler getSslErrorHandler()
  {
    return this.e;
  }
  
  public javax.net.ssl.SSLSocketFactory getSslSocketFactory()
  {
    return this.a;
  }
  
  public String getUrl()
  {
    return this.f;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 225	java/lang/Thread:run	()V
    //   4: aload_0
    //   5: getfield 112	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:c	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   8: ifnull +309 -> 317
    //   11: aload_0
    //   12: getfield 114	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:d	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   15: ifnull +302 -> 317
    //   18: aload_0
    //   19: getfield 108	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:e	Landroid/webkit/SslErrorHandler;
    //   22: ifnull +281 -> 303
    //   25: aload_0
    //   26: getfield 110	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:f	Ljava/lang/String;
    //   29: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +6 -> 38
    //   35: goto +268 -> 303
    //   38: aload_0
    //   39: getfield 112	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:c	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   42: aload_0
    //   43: getfield 114	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:d	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   46: invokevirtual 229	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
    //   49: aload_0
    //   50: getfield 112	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:c	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   53: instanceof 66
    //   56: ifeq +17 -> 73
    //   59: aload_0
    //   60: getfield 112	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:c	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   63: checkcast 66	com/huawei/secure/android/common/ssl/SecureApacheSSLSocketFactory
    //   66: aload_0
    //   67: getfield 118	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:h	Landroid/content/Context;
    //   70: invokevirtual 230	com/huawei/secure/android/common/ssl/SecureApacheSSLSocketFactory:setContext	(Landroid/content/Context;)V
    //   73: new 232	org/apache/http/params/BasicHttpParams
    //   76: dup
    //   77: invokespecial 233	org/apache/http/params/BasicHttpParams:<init>	()V
    //   80: astore_1
    //   81: aload_1
    //   82: sipush 30000
    //   85: invokestatic 239	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   88: aload_1
    //   89: sipush 30000
    //   92: invokestatic 242	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   95: new 244	org/apache/http/conn/scheme/SchemeRegistry
    //   98: dup
    //   99: invokespecial 245	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   102: astore_2
    //   103: aload_2
    //   104: new 247	org/apache/http/conn/scheme/Scheme
    //   107: dup
    //   108: ldc 249
    //   110: aload_0
    //   111: getfield 112	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:c	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   114: sipush 443
    //   117: invokespecial 252	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   120: invokevirtual 256	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   123: pop
    //   124: aload_2
    //   125: new 247	org/apache/http/conn/scheme/Scheme
    //   128: dup
    //   129: ldc_w 258
    //   132: invokestatic 264	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   135: bipush 80
    //   137: invokespecial 252	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   140: invokevirtual 256	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   143: pop
    //   144: new 266	org/apache/http/impl/client/DefaultHttpClient
    //   147: dup
    //   148: new 268	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   151: dup
    //   152: aload_1
    //   153: aload_2
    //   154: invokespecial 271	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   157: aload_1
    //   158: invokespecial 274	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   161: astore_1
    //   162: new 276	org/apache/http/client/methods/HttpGet
    //   165: dup
    //   166: invokespecial 277	org/apache/http/client/methods/HttpGet:<init>	()V
    //   169: astore_2
    //   170: aload_2
    //   171: new 279	java/net/URI
    //   174: dup
    //   175: aload_0
    //   176: getfield 110	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:f	Ljava/lang/String;
    //   179: invokespecial 281	java/net/URI:<init>	(Ljava/lang/String;)V
    //   182: invokevirtual 285	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   185: aload_1
    //   186: aload_2
    //   187: invokeinterface 291 2 0
    //   192: astore_1
    //   193: getstatic 75	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:i	Ljava/lang/String;
    //   196: astore_2
    //   197: new 77	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   204: astore_3
    //   205: aload_3
    //   206: ldc_w 293
    //   209: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_3
    //   214: aload_1
    //   215: invokeinterface 299 1 0
    //   220: invokeinterface 305 1 0
    //   225: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_2
    //   230: aload_3
    //   231: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 122	com/huawei/secure/android/common/ssl/util/g:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aconst_null
    //   238: invokestatic 313	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/Reader;)V
    //   241: aload_0
    //   242: invokespecial 315	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:c	()V
    //   245: return
    //   246: astore_1
    //   247: goto +50 -> 297
    //   250: astore_1
    //   251: getstatic 75	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:i	Ljava/lang/String;
    //   254: astore_2
    //   255: new 77	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   262: astore_3
    //   263: aload_3
    //   264: ldc_w 317
    //   267: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_3
    //   272: aload_1
    //   273: invokevirtual 201	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   276: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_2
    //   281: aload_3
    //   282: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 96	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload_0
    //   289: invokespecial 319	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:b	()V
    //   292: aconst_null
    //   293: invokestatic 313	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/Reader;)V
    //   296: return
    //   297: aconst_null
    //   298: invokestatic 313	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/Reader;)V
    //   301: aload_1
    //   302: athrow
    //   303: getstatic 75	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:i	Ljava/lang/String;
    //   306: ldc_w 321
    //   309: invokestatic 96	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload_0
    //   313: invokespecial 319	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:b	()V
    //   316: return
    //   317: aload_0
    //   318: getfield 221	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:a	Ljavax/net/ssl/SSLSocketFactory;
    //   321: ifnull +204 -> 525
    //   324: aload_0
    //   325: getfield 215	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:b	Ljavax/net/ssl/HostnameVerifier;
    //   328: ifnull +197 -> 525
    //   331: new 323	java/net/URL
    //   334: dup
    //   335: aload_0
    //   336: getfield 110	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:f	Ljava/lang/String;
    //   339: invokespecial 324	java/net/URL:<init>	(Ljava/lang/String;)V
    //   342: invokevirtual 328	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   345: astore_1
    //   346: aload_1
    //   347: instanceof 330
    //   350: ifeq +68 -> 418
    //   353: aload_1
    //   354: checkcast 330	javax/net/ssl/HttpsURLConnection
    //   357: astore_2
    //   358: aload_2
    //   359: astore_1
    //   360: aload_2
    //   361: aload_0
    //   362: getfield 221	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:a	Ljavax/net/ssl/SSLSocketFactory;
    //   365: invokevirtual 333	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   368: aload_2
    //   369: astore_1
    //   370: aload_2
    //   371: aload_0
    //   372: getfield 215	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:b	Ljavax/net/ssl/HostnameVerifier;
    //   375: invokevirtual 334	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   378: aload_2
    //   379: astore_1
    //   380: aload_2
    //   381: ldc_w 336
    //   384: invokevirtual 339	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   387: aload_2
    //   388: astore_1
    //   389: aload_2
    //   390: sipush 10000
    //   393: invokevirtual 343	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   396: aload_2
    //   397: astore_1
    //   398: aload_2
    //   399: sipush 20000
    //   402: invokevirtual 346	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   405: aload_2
    //   406: astore_1
    //   407: aload_2
    //   408: invokevirtual 349	javax/net/ssl/HttpsURLConnection:connect	()V
    //   411: goto +9 -> 420
    //   414: astore_3
    //   415: goto +29 -> 444
    //   418: aconst_null
    //   419: astore_2
    //   420: aload_2
    //   421: ifnull +7 -> 428
    //   424: aload_2
    //   425: invokevirtual 352	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   428: aload_0
    //   429: invokespecial 315	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:c	()V
    //   432: return
    //   433: astore_1
    //   434: aconst_null
    //   435: astore_2
    //   436: aload_1
    //   437: astore_3
    //   438: goto +77 -> 515
    //   441: astore_3
    //   442: aconst_null
    //   443: astore_2
    //   444: aload_2
    //   445: astore_1
    //   446: getstatic 75	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:i	Ljava/lang/String;
    //   449: astore 4
    //   451: aload_2
    //   452: astore_1
    //   453: new 77	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   460: astore 5
    //   462: aload_2
    //   463: astore_1
    //   464: aload 5
    //   466: ldc_w 354
    //   469: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload_2
    //   474: astore_1
    //   475: aload 5
    //   477: aload_3
    //   478: invokevirtual 201	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   481: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload_2
    //   486: astore_1
    //   487: aload 4
    //   489: aload 5
    //   491: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 96	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: aload_2
    //   498: astore_1
    //   499: aload_0
    //   500: invokespecial 319	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:b	()V
    //   503: aload_2
    //   504: ifnull +7 -> 511
    //   507: aload_2
    //   508: invokevirtual 352	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   511: return
    //   512: astore_3
    //   513: aload_1
    //   514: astore_2
    //   515: aload_2
    //   516: ifnull +7 -> 523
    //   519: aload_2
    //   520: invokevirtual 352	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   523: aload_3
    //   524: athrow
    //   525: aload_0
    //   526: invokespecial 319	com/huawei/secure/android/common/ssl/WebViewSSLCheckThread:b	()V
    //   529: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	this	WebViewSSLCheckThread
    //   80	135	1	localObject1	Object
    //   246	1	1	localObject2	Object
    //   250	52	1	localException1	Exception
    //   345	62	1	localObject3	Object
    //   433	4	1	localObject4	Object
    //   445	69	1	localObject5	Object
    //   102	418	2	localObject6	Object
    //   204	78	3	localStringBuilder1	StringBuilder
    //   414	1	3	localException2	Exception
    //   437	1	3	localObject7	Object
    //   441	37	3	localException3	Exception
    //   512	12	3	localObject8	Object
    //   449	39	4	str	String
    //   460	30	5	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	73	246	finally
    //   73	103	246	finally
    //   103	124	246	finally
    //   124	237	246	finally
    //   251	292	246	finally
    //   38	73	250	java/lang/Exception
    //   73	103	250	java/lang/Exception
    //   103	124	250	java/lang/Exception
    //   124	237	250	java/lang/Exception
    //   360	368	414	java/lang/Exception
    //   370	378	414	java/lang/Exception
    //   380	387	414	java/lang/Exception
    //   389	396	414	java/lang/Exception
    //   398	405	414	java/lang/Exception
    //   407	411	414	java/lang/Exception
    //   331	358	433	finally
    //   331	358	441	java/lang/Exception
    //   360	368	512	finally
    //   370	378	512	finally
    //   380	387	512	finally
    //   389	396	512	finally
    //   398	405	512	finally
    //   407	411	512	finally
    //   446	451	512	finally
    //   453	462	512	finally
    //   464	473	512	finally
    //   475	485	512	finally
    //   487	497	512	finally
    //   499	503	512	finally
  }
  
  public void setApacheHostnameVerifier(X509HostnameVerifier paramX509HostnameVerifier)
  {
    this.d = paramX509HostnameVerifier;
  }
  
  public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory paramSSLSocketFactory)
  {
    this.c = paramSSLSocketFactory;
  }
  
  public void setCallback(WebViewSSLCheckThread.Callback paramCallback)
  {
    this.g = paramCallback;
  }
  
  public void setContext(Context paramContext)
  {
    this.h = paramContext;
  }
  
  public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.b = paramHostnameVerifier;
  }
  
  public void setSslErrorHandler(SslErrorHandler paramSslErrorHandler)
  {
    this.e = paramSslErrorHandler;
  }
  
  public void setSslSocketFactory(javax.net.ssl.SSLSocketFactory paramSSLSocketFactory)
  {
    this.a = paramSSLSocketFactory;
  }
  
  public void setUrl(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.WebViewSSLCheckThread
 * JD-Core Version:    0.7.0.1
 */