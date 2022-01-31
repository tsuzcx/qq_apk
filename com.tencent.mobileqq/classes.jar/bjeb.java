import android.content.Context;
import com.tencent.component.network.utils.NetworkUtils;
import cooperation.qzone.util.NetworkState;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class bjeb
{
  public static final int a = "http://".length();
  
  /* Error */
  public static int a(String paramString, java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 6
    //   12: invokestatic 30	cooperation/qzone/util/NetworkState:isWap	()Z
    //   15: ifeq +231 -> 246
    //   18: getstatic 35	bjec:a	Lbjec;
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +395 -> 420
    //   28: aload_0
    //   29: invokestatic 38	bjeb:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   32: astore 5
    //   34: new 40	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   41: aload 4
    //   43: invokevirtual 47	bjec:toString	()Ljava/lang/String;
    //   46: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 5
    //   51: iconst_1
    //   52: aaload
    //   53: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 55	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   64: ldc 10
    //   66: invokevirtual 59	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   69: ifeq +183 -> 252
    //   72: new 61	java/net/URL
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 64	java/net/URL:<init>	(Ljava/lang/String;)V
    //   80: invokevirtual 68	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   83: checkcast 70	java/net/HttpURLConnection
    //   86: astore_0
    //   87: aload_0
    //   88: sipush 30000
    //   91: invokevirtual 74	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   94: aload_0
    //   95: sipush 15000
    //   98: invokevirtual 77	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   101: aload_0
    //   102: ldc 79
    //   104: invokevirtual 82	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: iconst_1
    //   109: invokevirtual 86	java/net/HttpURLConnection:setDoInput	(Z)V
    //   112: aload 4
    //   114: ifnull +13 -> 127
    //   117: aload_0
    //   118: ldc 88
    //   120: aload 5
    //   122: iconst_0
    //   123: aaload
    //   124: invokevirtual 92	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_0
    //   128: invokevirtual 95	java/net/HttpURLConnection:getResponseCode	()I
    //   131: istore_2
    //   132: aload 9
    //   134: astore 4
    //   136: iload_2
    //   137: invokestatic 98	bjeb:a	(I)Z
    //   140: ifeq +133 -> 273
    //   143: new 100	java/io/BufferedOutputStream
    //   146: dup
    //   147: new 102	java/io/FileOutputStream
    //   150: dup
    //   151: aload_1
    //   152: iconst_1
    //   153: invokespecial 105	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   156: invokespecial 108	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   159: astore_1
    //   160: aload_0
    //   161: invokevirtual 112	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   164: astore 4
    //   166: sipush 8192
    //   169: newarray byte
    //   171: astore 5
    //   173: aload 4
    //   175: aload 5
    //   177: iconst_0
    //   178: aload 5
    //   180: arraylength
    //   181: invokevirtual 118	java/io/InputStream:read	([BII)I
    //   184: istore_3
    //   185: iconst_m1
    //   186: iload_3
    //   187: if_icmpeq +75 -> 262
    //   190: aload_1
    //   191: aload 5
    //   193: iconst_0
    //   194: iload_3
    //   195: invokevirtual 122	java/io/BufferedOutputStream:write	([BII)V
    //   198: goto -25 -> 173
    //   201: astore 5
    //   203: aload_1
    //   204: astore 6
    //   206: aload_0
    //   207: astore_1
    //   208: aload 6
    //   210: astore 4
    //   212: ldc 124
    //   214: iconst_1
    //   215: ldc 126
    //   217: aload 5
    //   219: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   222: sipush 1024
    //   225: istore_3
    //   226: aload 6
    //   228: invokestatic 138	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   231: pop
    //   232: iload_3
    //   233: istore_2
    //   234: aload_0
    //   235: ifnull +9 -> 244
    //   238: aload_0
    //   239: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   242: iload_3
    //   243: istore_2
    //   244: iload_2
    //   245: ireturn
    //   246: aconst_null
    //   247: astore 4
    //   249: goto -226 -> 23
    //   252: ldc 10
    //   254: aload_0
    //   255: invokevirtual 145	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   258: astore_0
    //   259: goto -187 -> 72
    //   262: aload_1
    //   263: invokevirtual 148	java/io/BufferedOutputStream:flush	()V
    //   266: aload_1
    //   267: invokevirtual 151	java/io/BufferedOutputStream:close	()V
    //   270: aload_1
    //   271: astore 4
    //   273: aload 4
    //   275: invokestatic 138	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   278: pop
    //   279: aload_0
    //   280: ifnull +138 -> 418
    //   283: aload_0
    //   284: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   287: iload_2
    //   288: ireturn
    //   289: astore 5
    //   291: aconst_null
    //   292: astore_0
    //   293: aload 7
    //   295: astore 6
    //   297: aload_0
    //   298: astore_1
    //   299: aload 6
    //   301: astore 4
    //   303: ldc 124
    //   305: iconst_1
    //   306: ldc 153
    //   308: aload 5
    //   310: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   313: sipush 4096
    //   316: istore_2
    //   317: aload 6
    //   319: invokestatic 138	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   322: pop
    //   323: aload_0
    //   324: ifnull -80 -> 244
    //   327: aload_0
    //   328: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   331: sipush 4096
    //   334: ireturn
    //   335: astore_0
    //   336: aconst_null
    //   337: astore_1
    //   338: aload 8
    //   340: astore 4
    //   342: aload 4
    //   344: invokestatic 138	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   347: pop
    //   348: aload_1
    //   349: ifnull +7 -> 356
    //   352: aload_1
    //   353: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   356: aload_0
    //   357: athrow
    //   358: astore 4
    //   360: aload_0
    //   361: astore_1
    //   362: aload 4
    //   364: astore_0
    //   365: aload 8
    //   367: astore 4
    //   369: goto -27 -> 342
    //   372: astore 5
    //   374: aload_1
    //   375: astore 4
    //   377: aload_0
    //   378: astore_1
    //   379: aload 5
    //   381: astore_0
    //   382: goto -40 -> 342
    //   385: astore_0
    //   386: goto -44 -> 342
    //   389: astore 5
    //   391: aload 7
    //   393: astore 6
    //   395: goto -98 -> 297
    //   398: astore 5
    //   400: aload_1
    //   401: astore 6
    //   403: goto -106 -> 297
    //   406: astore 5
    //   408: aconst_null
    //   409: astore_0
    //   410: goto -204 -> 206
    //   413: astore 5
    //   415: goto -209 -> 206
    //   418: iload_2
    //   419: ireturn
    //   420: aconst_null
    //   421: astore 5
    //   423: goto -363 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	paramString	String
    //   0	426	1	paramFile	java.io.File
    //   131	288	2	i	int
    //   184	59	3	j	int
    //   21	322	4	localObject1	Object
    //   358	5	4	localObject2	Object
    //   367	9	4	localObject3	Object
    //   32	160	5	localObject4	Object
    //   201	17	5	localIOException1	java.io.IOException
    //   289	20	5	localException1	Exception
    //   372	8	5	localObject5	Object
    //   389	1	5	localException2	Exception
    //   398	1	5	localException3	Exception
    //   406	1	5	localIOException2	java.io.IOException
    //   413	1	5	localIOException3	java.io.IOException
    //   421	1	5	localObject6	Object
    //   10	392	6	localObject7	Object
    //   4	388	7	localObject8	Object
    //   7	359	8	localObject9	Object
    //   1	132	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   160	173	201	java/io/IOException
    //   173	185	201	java/io/IOException
    //   190	198	201	java/io/IOException
    //   262	270	201	java/io/IOException
    //   28	60	289	java/lang/Exception
    //   60	72	289	java/lang/Exception
    //   72	87	289	java/lang/Exception
    //   252	259	289	java/lang/Exception
    //   28	60	335	finally
    //   60	72	335	finally
    //   72	87	335	finally
    //   252	259	335	finally
    //   87	112	358	finally
    //   117	127	358	finally
    //   127	132	358	finally
    //   136	160	358	finally
    //   160	173	372	finally
    //   173	185	372	finally
    //   190	198	372	finally
    //   262	270	372	finally
    //   212	222	385	finally
    //   303	313	385	finally
    //   87	112	389	java/lang/Exception
    //   117	127	389	java/lang/Exception
    //   127	132	389	java/lang/Exception
    //   136	160	389	java/lang/Exception
    //   160	173	398	java/lang/Exception
    //   173	185	398	java/lang/Exception
    //   190	198	398	java/lang/Exception
    //   262	270	398	java/lang/Exception
    //   28	60	406	java/io/IOException
    //   60	72	406	java/io/IOException
    //   72	87	406	java/io/IOException
    //   252	259	406	java/io/IOException
    //   87	112	413	java/io/IOException
    //   117	127	413	java/io/IOException
    //   127	132	413	java/io/IOException
    //   136	160	413	java/io/IOException
  }
  
  private static String a(String paramString)
  {
    String str = paramString.trim().replace(" ", "");
    int i = str.indexOf('#');
    paramString = str;
    if (i > 0) {
      paramString = str.substring(0, i);
    }
    return paramString;
  }
  
  public static HttpResponse a(Context paramContext, String paramString, HttpEntity paramHttpEntity)
  {
    return a(paramContext, paramString, paramHttpEntity, null);
  }
  
  public static HttpResponse a(Context paramContext, String paramString, HttpEntity paramHttpEntity, bjee parambjee)
  {
    return a(false).execute(a(paramContext, paramString, paramHttpEntity, parambjee));
  }
  
  public static HttpClient a(boolean paramBoolean)
  {
    Object localObject2 = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled((HttpParams)localObject2, false);
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, 20000);
    HttpConnectionParams.setTcpNoDelay((HttpParams)localObject2, true);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject2, 45000);
    HttpConnectionParams.setSocketBufferSize((HttpParams)localObject2, 8192);
    HttpProtocolParams.setVersion((HttpParams)localObject2, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent((HttpParams)localObject2, "android-qzone");
    Object localObject1 = new SchemeRegistry();
    ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      label98:
      if (paramBoolean) {}
      for (localObject1 = new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);; localObject1 = new SingleClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1))
      {
        localObject2 = new DefaultHttpClient((ClientConnectionManager)localObject1, (HttpParams)localObject2);
        ((DefaultHttpClient)localObject2).setRoutePlanner(new DefaultHttpRoutePlanner(((ClientConnectionManager)localObject1).getSchemeRegistry()));
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      break label98;
    }
  }
  
  public static HttpPost a(Context paramContext, String paramString, HttpEntity paramHttpEntity, bjee parambjee)
  {
    Object localObject = a(paramString);
    paramString = b((String)localObject);
    localObject = new HttpPost((String)localObject);
    ((HttpPost)localObject).addHeader("Host", paramString);
    ((HttpPost)localObject).addHeader("x-online-host", paramString);
    if ((paramHttpEntity instanceof ByteArrayEntity)) {
      ((HttpPost)localObject).addHeader("Content-Type", "application/octet-stream");
    }
    ((HttpPost)localObject).setEntity(paramHttpEntity);
    a(paramContext, (HttpRequest)localObject, parambjee);
    return localObject;
  }
  
  private static void a(Context paramContext, HttpRequest paramHttpRequest, bjee parambjee)
  {
    boolean bool1;
    if (parambjee != null)
    {
      bool1 = parambjee.a;
      if (parambjee == null) {
        break label90;
      }
    }
    label90:
    for (boolean bool2 = parambjee.b;; bool2 = false)
    {
      if ((bool1) && (NetworkState.isMobile()))
      {
        paramContext = NetworkUtils.getProxy(paramContext, bool2);
        if (paramContext != null)
        {
          paramContext = (InetSocketAddress)paramContext.address();
          if (paramContext != null)
          {
            paramContext = new HttpHost(paramContext.getHostName(), paramContext.getPort());
            paramHttpRequest.getParams().setParameter("http.route.default-proxy", paramContext);
          }
        }
      }
      return;
      bool1 = true;
      break;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 200) && (paramInt < 299);
  }
  
  public static String[] a(String paramString)
  {
    String[] arrayOfString = new String[2];
    if ((paramString == null) || (paramString.length() < a)) {
      return arrayOfString;
    }
    if (paramString.toLowerCase().startsWith("http://"))
    {
      int j = paramString.indexOf('/', a);
      int i = j;
      if (j <= a) {
        i = paramString.length();
      }
      arrayOfString[0] = paramString.substring(a, i);
      if (i >= paramString.length()) {
        break label100;
      }
      arrayOfString[1] = paramString.substring(i, paramString.length());
    }
    for (;;)
    {
      return arrayOfString;
      paramString = "http://".concat(paramString);
      break;
      label100:
      arrayOfString[1] = "";
    }
  }
  
  private static String b(String paramString)
  {
    return new URL(paramString).getAuthority();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjeb
 * JD-Core Version:    0.7.0.1
 */