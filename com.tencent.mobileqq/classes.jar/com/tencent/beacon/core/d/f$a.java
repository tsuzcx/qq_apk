package com.tencent.beacon.core.d;

import android.content.Context;
import android.net.Proxy;
import com.tencent.beacon.core.strategy.g;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

class f$a
  extends f
{
  protected Context b;
  
  public f$a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  b a(String paramString1, byte[] paramArrayOfByte, String paramString2, int paramInt)
  {
    Object localObject = null;
    if (paramString1 == null)
    {
      com.tencent.beacon.core.e.d.b("[net] destUrl is null.", new Object[0]);
      return null;
    }
    HttpClient localHttpClient;
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = new ByteArrayEntity(paramArrayOfByte);
        localHttpClient = a(paramString2, paramInt);
        if (localHttpClient == null)
        {
          com.tencent.beacon.core.e.d.b("[net] no httpClient!", new Object[0]);
          return null;
        }
      }
      catch (Throwable paramString1)
      {
        paramArrayOfByte = localObject;
      }
    }
    for (;;)
    {
      i.a(this.b).a("499", "[net] http execute error!", paramString1);
      com.tencent.beacon.core.e.d.a(paramString1);
      com.tencent.beacon.core.e.d.b("[net] execute error:%s", new Object[] { paramString1.toString() });
      if (paramArrayOfByte != null) {
        paramArrayOfByte.abort();
      }
      throw new Exception(paramString1.toString());
      paramArrayOfByte = new ByteArrayEntity("".getBytes(Charset.forName("UTF-8")));
      break;
      paramString2 = new HttpPost(paramString1);
      try
      {
        paramString2.setHeader("wup_version", "3.0");
        paramString2.setHeader("TYPE_COMPRESS", String.valueOf(2));
        paramString2.setHeader("encr_type", "rsapost");
        paramString1 = g.b(this.b);
        if (paramString1 != null) {
          paramString2.setHeader("bea_key", paramString1.c());
        }
        paramString2.setEntity(paramArrayOfByte);
        paramString1 = new BasicHttpContext();
        paramArrayOfByte = localHttpClient.execute(paramString2, paramString1);
        paramString1 = (HttpRequest)paramString1.getAttribute("http.request");
        if (paramString1 != null) {
          com.tencent.beacon.core.e.d.h("[net] execute request:\n %s", new Object[] { paramString1.getRequestLine().toString() });
        }
        paramString1 = new b(paramArrayOfByte, paramString2);
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        paramArrayOfByte = paramString2;
      }
    }
  }
  
  HttpClient a(String paramString, int paramInt)
  {
    try
    {
      Object localObject = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 30000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject, 20000);
      HttpConnectionParams.setSocketBufferSize((HttpParams)localObject, 2000);
      ((BasicHttpParams)localObject).setBooleanParameter("http.protocol.handle-redirects", false);
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient((HttpParams)localObject);
      HttpProtocolParams.setUseExpectContinue((HttpParams)localObject, false);
      localDefaultHttpClient.setHttpRequestRetryHandler(new e(this));
      if (paramString != null)
      {
        localObject = paramString.toLowerCase(Locale.US);
        boolean bool = ((String)localObject).contains("wap");
        if ((bool) && (paramInt != 2))
        {
          com.tencent.beacon.core.e.d.d("[net] use proxy: %s, try time: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
          paramString = Proxy.getDefaultHost();
          paramInt = Proxy.getDefaultPort();
          if (paramString != null)
          {
            paramString = new HttpHost(paramString, paramInt);
            localObject = localDefaultHttpClient.getParams();
            ((HttpParams)localObject).setParameter("http.route.default-proxy", paramString);
          }
          return localDefaultHttpClient;
        }
      }
      if (paramString != null) {
        com.tencent.beacon.core.e.d.d("[net] Don't use proxy: %s, try time: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
      }
      paramString = localDefaultHttpClient.getParams();
      paramString.removeParameter("http.route.default-proxy");
      return localDefaultHttpClient;
    }
    catch (Throwable paramString)
    {
      i.a(this.b).a("499", "[net] http getClient error!", paramString);
      com.tencent.beacon.core.e.d.a(paramString);
      com.tencent.beacon.core.e.d.b("[net] httpclient error!", new Object[0]);
    }
    return null;
  }
  
  public boolean a()
  {
    return false;
  }
  
  boolean a(int paramInt)
  {
    return (paramInt == 301) || (paramInt == 302) || (paramInt == 303) || (paramInt == 307);
  }
  
  public byte[] a(String paramString, byte[] paramArrayOfByte, a parama, d paramd)
  {
    if (paramString == null)
    {
      com.tencent.beacon.core.e.d.b("[net] destUrl is null.", new Object[0]);
      return null;
    }
    com.tencent.beacon.core.e.d.a("[net] HTTP requestCmd(%d) moduleId(%d) eventCnt(%d)", new Object[] { Integer.valueOf(parama.a), Integer.valueOf(parama.b), Integer.valueOf(parama.e) });
    Object localObject2 = null;
    int i = 0;
    if (paramArrayOfByte == null) {}
    int j;
    StringBuilder localStringBuilder;
    Object localObject1;
    int m;
    int k;
    long l1;
    long l4;
    int i2;
    for (long l2 = 0L;; l2 = paramArrayOfByte.length)
    {
      com.tencent.beacon.core.e.d.h("[net] request url:%s sz:%d", new Object[] { paramString, Long.valueOf(l2) });
      j = 0;
      localStringBuilder = new StringBuilder();
      localObject1 = "";
      m = 0;
      k = m + 1;
      if ((m >= 3) || (i >= 2)) {
        break label920;
      }
      if (j != 0) {
        break label854;
      }
      if (k > 1)
      {
        com.tencent.beacon.core.e.d.h("[net] try time:" + k, new Object[0]);
        if ((k == 2) && (parama.c() == 2)) {
          parama.a(false);
        }
        a(5000L);
      }
      Object localObject3 = com.tencent.beacon.core.e.e.b(this.b);
      if (paramd != null) {
        paramd.a(paramString, l2, (String)localObject3, k);
      }
      l1 = new Date().getTime();
      try
      {
        localObject3 = a(paramString, paramArrayOfByte, (String)localObject3, k);
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      catch (Exception localException1)
      {
        HttpEntity localHttpEntity;
        long l3;
        localObject4 = localException1.toString();
        if (!((String)localObject1).equals(localObject4)) {
          break label473;
        }
        localStringBuilder.append(k).append(":").append("same ");
        for (;;)
        {
          localObject1 = localObject2;
          localObject2 = localObject4;
          break;
          localStringBuilder.append(k).append(":").append((String)localObject4).append(" ");
        }
        paramString = a((HttpResponse)localObject4, ((b)localObject1).b, paramString, k);
        if (paramd == null) {
          break label539;
        }
        if (paramString != null) {
          break label541;
        }
        l1 = 0L;
        paramd.a(l1, l4);
        return paramString;
      }
      l4 = new Date().getTime() - l1;
      if (localObject1 == null) {
        break label824;
      }
      localObject3 = ((b)localObject1).a;
      localHttpEntity = ((HttpResponse)localObject3).getEntity();
      l1 = 0L;
      if (localHttpEntity != null)
      {
        l3 = localHttpEntity.getContentLength();
        l1 = l3;
        if (l3 < 0L) {
          l1 = 0L;
        }
      }
      i2 = ((HttpResponse)localObject3).getStatusLine().getStatusCode();
      com.tencent.beacon.core.e.d.h("[net] response code:%d ", new Object[] { Integer.valueOf(i2) });
      if (i2 != 200) {
        break label549;
      }
      if (!((HttpResponse)localObject3).containsHeader("encrypt-status")) {
        break label501;
      }
      com.tencent.beacon.core.e.d.b("[net] svr encry failed: " + ((HttpResponse)localObject3).getFirstHeader("encrypt-status").getValue(), new Object[0]);
      return null;
    }
    Object localObject4;
    label539:
    label541:
    for (;;)
    {
      label473:
      label501:
      l1 = paramString.length;
    }
    label549:
    if (a(i2))
    {
      m = 1;
      paramString = ((HttpResponse)localObject4).getFirstHeader("Location");
      if (paramString == null)
      {
        com.tencent.beacon.core.e.d.b("[net] redirect code:" + i2 + " Location is null! return", new Object[0]);
        i.a(this.b).a("499", "[net] http redirect code: " + i2 + ", location is null!");
      }
    }
    for (;;)
    {
      try
      {
        if (((b)localObject1).b != null) {
          ((b)localObject1).b.abort();
        }
        return null;
        n = i + 1;
        i1 = 0;
        paramString = paramString.getValue();
        com.tencent.beacon.core.e.d.h("[net] redirect code:%d , to:%s", new Object[] { Integer.valueOf(i2), paramString });
        i = m;
        j = n;
        localObject4 = paramString;
        k = i1;
        try
        {
          if (((b)localObject1).b != null)
          {
            ((b)localObject1).b.abort();
            k = i1;
            localObject4 = paramString;
            j = n;
            i = m;
          }
        }
        catch (Exception localException2)
        {
          i = m;
          j = n;
          str = paramString;
          k = i1;
          continue;
        }
        m = i;
        n = j;
        paramString = (String)localObject4;
        i1 = k;
        if (paramd != null)
        {
          paramd.a(l1, l4);
          i1 = k;
          paramString = (String)localObject4;
          n = j;
          m = i;
        }
        localObject4 = localObject2;
        j = m;
        i = n;
        m = i1;
        localObject2 = localObject1;
        localObject1 = localObject4;
        break;
        label824:
        if (paramd != null) {
          paramd.a(0L, l4);
        }
        m = j;
        n = i;
        i1 = k;
        continue;
        label854:
        paramArrayOfByte = new StringBuilder("net redirect");
        i.a(this.b).a("499", "[net] http redirect ! url: " + paramString + ", tryTime: " + k);
        throw new Exception(paramArrayOfByte.toString());
        label920:
        throw new Exception(localStringBuilder.toString());
      }
      catch (Exception paramString)
      {
        int n;
        int i1;
        continue;
      }
      m = i;
      i = j;
      j = m;
      String str = paramString;
    }
  }
  
  /* Error */
  byte[] a(HttpResponse paramHttpResponse, HttpPost paramHttpPost, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_1
    //   7: ifnonnull +8 -> 15
    //   10: aload 7
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: aload_1
    //   16: invokeinterface 338 1 0
    //   21: invokeinterface 343 1 0
    //   26: istore 5
    //   28: iload 5
    //   30: sipush 200
    //   33: if_icmpeq +32 -> 65
    //   36: ldc_w 406
    //   39: iconst_2
    //   40: anewarray 22	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: iload 5
    //   47: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_1
    //   54: invokeinterface 338 1 0
    //   59: aastore
    //   60: invokestatic 409	com/tencent/beacon/core/e/d:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aconst_null
    //   64: areturn
    //   65: aload_1
    //   66: ldc_w 411
    //   69: invokeinterface 350 2 0
    //   74: ifeq +65 -> 139
    //   77: aload_1
    //   78: ldc_w 413
    //   81: invokeinterface 350 2 0
    //   86: ifeq +53 -> 139
    //   89: aload_1
    //   90: ldc_w 411
    //   93: invokeinterface 356 2 0
    //   98: invokeinterface 361 1 0
    //   103: astore 8
    //   105: aload_1
    //   106: ldc_w 413
    //   109: invokeinterface 356 2 0
    //   114: invokeinterface 361 1 0
    //   119: astore 9
    //   121: aload_0
    //   122: getfield 13	com/tencent/beacon/core/d/f$a:b	Landroid/content/Context;
    //   125: invokestatic 108	com/tencent/beacon/core/strategy/g:b	(Landroid/content/Context;)Lcom/tencent/beacon/core/strategy/g;
    //   128: aload_0
    //   129: getfield 13	com/tencent/beacon/core/d/f$a:b	Landroid/content/Context;
    //   132: aload 8
    //   134: aload 9
    //   136: invokevirtual 416	com/tencent/beacon/core/strategy/g:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_1
    //   140: invokeinterface 329 1 0
    //   145: astore_1
    //   146: aload_1
    //   147: ifnonnull +15 -> 162
    //   150: ldc_w 418
    //   153: iconst_0
    //   154: anewarray 22	java/lang/Object
    //   157: invokestatic 27	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: aconst_null
    //   161: areturn
    //   162: new 420	java/io/BufferedInputStream
    //   165: dup
    //   166: new 422	java/io/DataInputStream
    //   169: dup
    //   170: aload_1
    //   171: invokeinterface 426 1 0
    //   176: invokespecial 429	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   179: invokespecial 430	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   182: astore_1
    //   183: new 432	java/io/ByteArrayOutputStream
    //   186: dup
    //   187: invokespecial 433	java/io/ByteArrayOutputStream:<init>	()V
    //   190: astore 6
    //   192: aload_1
    //   193: invokevirtual 436	java/io/BufferedInputStream:read	()I
    //   196: istore 5
    //   198: iload 5
    //   200: iconst_m1
    //   201: if_icmpeq +115 -> 316
    //   204: aload 6
    //   206: iload 5
    //   208: invokevirtual 440	java/io/ByteArrayOutputStream:write	(I)V
    //   211: goto -19 -> 192
    //   214: astore 6
    //   216: aload_0
    //   217: getfield 13	com/tencent/beacon/core/d/f$a:b	Landroid/content/Context;
    //   220: invokestatic 42	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   223: astore 8
    //   225: new 280	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   232: astore 9
    //   234: aload 9
    //   236: ldc_w 442
    //   239: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_3
    //   243: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: astore_3
    //   247: aload 8
    //   249: ldc_w 444
    //   252: aload_3
    //   253: ldc_w 446
    //   256: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: iload 4
    //   261: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: aload 6
    //   269: invokevirtual 49	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload 6
    //   274: invokestatic 52	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   277: ldc_w 448
    //   280: iconst_1
    //   281: anewarray 22	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: aload 6
    //   288: invokevirtual 58	java/lang/Throwable:toString	()Ljava/lang/String;
    //   291: aastore
    //   292: invokestatic 27	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: aload_1
    //   296: ifnull +7 -> 303
    //   299: aload_1
    //   300: invokevirtual 451	java/io/BufferedInputStream:close	()V
    //   303: aload 7
    //   305: astore_1
    //   306: aload_2
    //   307: ifnull -294 -> 13
    //   310: aload_2
    //   311: invokevirtual 63	org/apache/http/client/methods/HttpPost:abort	()V
    //   314: aconst_null
    //   315: areturn
    //   316: aload 6
    //   318: invokevirtual 454	java/io/ByteArrayOutputStream:flush	()V
    //   321: aload 6
    //   323: invokevirtual 458	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   326: astore 6
    //   328: aload 6
    //   330: astore_3
    //   331: aload_1
    //   332: invokevirtual 451	java/io/BufferedInputStream:close	()V
    //   335: aload_3
    //   336: astore_1
    //   337: aload_2
    //   338: ifnull -325 -> 13
    //   341: aload_2
    //   342: invokevirtual 63	org/apache/http/client/methods/HttpPost:abort	()V
    //   345: aload_3
    //   346: areturn
    //   347: astore_1
    //   348: aload_1
    //   349: invokestatic 52	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   352: goto -17 -> 335
    //   355: astore 6
    //   357: aconst_null
    //   358: astore_1
    //   359: goto -143 -> 216
    //   362: astore_1
    //   363: aload_1
    //   364: invokestatic 52	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   367: goto -64 -> 303
    //   370: astore_3
    //   371: aload_1
    //   372: astore 6
    //   374: aload_3
    //   375: astore_1
    //   376: aload 6
    //   378: ifnull +8 -> 386
    //   381: aload 6
    //   383: invokevirtual 451	java/io/BufferedInputStream:close	()V
    //   386: aload_2
    //   387: ifnull +7 -> 394
    //   390: aload_2
    //   391: invokevirtual 63	org/apache/http/client/methods/HttpPost:abort	()V
    //   394: aload_1
    //   395: athrow
    //   396: astore_3
    //   397: aload_3
    //   398: invokestatic 52	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   401: goto -15 -> 386
    //   404: astore_3
    //   405: goto -34 -> 371
    //   408: astore_1
    //   409: goto -33 -> 376
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	a
    //   0	412	1	paramHttpResponse	HttpResponse
    //   0	412	2	paramHttpPost	HttpPost
    //   0	412	3	paramString	String
    //   0	412	4	paramInt	int
    //   26	181	5	i	int
    //   1	204	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   214	108	6	localThrowable1	Throwable
    //   326	3	6	arrayOfByte	byte[]
    //   355	1	6	localThrowable2	Throwable
    //   372	10	6	localHttpResponse	HttpResponse
    //   4	300	7	localObject1	Object
    //   103	145	8	localObject2	Object
    //   119	116	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   183	192	214	java/lang/Throwable
    //   192	198	214	java/lang/Throwable
    //   204	211	214	java/lang/Throwable
    //   316	328	214	java/lang/Throwable
    //   331	335	347	java/lang/Throwable
    //   162	183	355	java/lang/Throwable
    //   299	303	362	java/lang/Throwable
    //   183	192	370	finally
    //   192	198	370	finally
    //   204	211	370	finally
    //   316	328	370	finally
    //   381	386	396	java/lang/Throwable
    //   216	225	404	finally
    //   225	234	404	finally
    //   234	247	404	finally
    //   247	277	404	finally
    //   277	295	404	finally
    //   162	183	408	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.d.f.a
 * JD-Core Version:    0.7.0.1
 */