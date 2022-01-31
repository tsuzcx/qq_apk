package com.tencent.beacon.core.c;

import android.content.Context;
import android.net.Proxy;
import com.tencent.beacon.core.d.d;
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

final class f$a
  extends f
{
  private Context a;
  
  public f$a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static b a(String paramString1, byte[] paramArrayOfByte, String paramString2, int paramInt)
  {
    if (paramString1 == null)
    {
      com.tencent.beacon.core.d.b.d("[net] destUrl is null.", new Object[0]);
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
          com.tencent.beacon.core.d.b.d("[net] no httpClient!", new Object[0]);
          return null;
        }
      }
      catch (Throwable paramString1)
      {
        paramArrayOfByte = null;
      }
    }
    for (;;)
    {
      com.tencent.beacon.core.d.b.a(paramString1);
      com.tencent.beacon.core.d.b.d("[net] execute error:%s", new Object[] { paramString1.toString() });
      if (paramArrayOfByte != null) {
        paramArrayOfByte.abort();
      }
      throw new Exception(paramString1.toString());
      paramArrayOfByte = new ByteArrayEntity("".getBytes());
      break;
      paramString2 = new HttpPost(paramString1);
      try
      {
        paramString2.setHeader("wup_version", "3.0");
        paramString2.setHeader("TYPE_COMPRESS", "2");
        paramString2.setHeader("encr_type", "rsapost");
        paramString1 = com.tencent.beacon.core.strategy.a.a();
        if (paramString1 != null) {
          paramString2.setHeader("bea_key", paramString1.n());
        }
        paramString2.setEntity(paramArrayOfByte);
        paramString1 = new BasicHttpContext();
        paramArrayOfByte = localHttpClient.execute(paramString2, paramString1);
        com.tencent.beacon.core.d.b.h("[net] execute request:\n %s", new Object[] { ((HttpRequest)paramString1.getAttribute("http.request")).getRequestLine().toString() });
        paramString1 = new b(paramArrayOfByte, paramString2);
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        paramArrayOfByte = paramString2;
      }
    }
  }
  
  private static HttpClient a(String paramString, int paramInt)
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
      localDefaultHttpClient.setHttpRequestRetryHandler(new f.a.1());
      if ((paramString != null) && (paramString.toLowerCase(Locale.US).contains("wap")) && (paramInt != 2))
      {
        com.tencent.beacon.core.d.b.a("[net] use proxy: %s, try time: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
        localObject = Proxy.getDefaultHost();
        paramInt = Proxy.getDefaultPort();
        paramString = localDefaultHttpClient;
        if (localObject != null)
        {
          paramString = new HttpHost((String)localObject, paramInt);
          localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", paramString);
          return localDefaultHttpClient;
        }
      }
      else
      {
        if (paramString != null) {
          com.tencent.beacon.core.d.b.a("[net] Don't use proxy: %s, try time: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
        }
        localDefaultHttpClient.getParams().removeParameter("http.route.default-proxy");
        return localDefaultHttpClient;
      }
    }
    catch (Throwable paramString)
    {
      com.tencent.beacon.core.d.b.a(paramString);
      com.tencent.beacon.core.d.b.d("[net] httpclient error!", new Object[0]);
      paramString = null;
    }
    return paramString;
  }
  
  /* Error */
  private byte[] a(HttpResponse paramHttpResponse, HttpPost paramHttpPost)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: ifnonnull +10 -> 14
    //   7: aload 6
    //   9: astore 4
    //   11: aload 4
    //   13: areturn
    //   14: aload_1
    //   15: invokeinterface 235 1 0
    //   20: invokeinterface 240 1 0
    //   25: istore_3
    //   26: iload_3
    //   27: sipush 200
    //   30: if_icmpeq +30 -> 60
    //   33: ldc 242
    //   35: iconst_2
    //   36: anewarray 21	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: iload_3
    //   42: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: aload_1
    //   49: invokeinterface 235 1 0
    //   54: aastore
    //   55: invokestatic 245	com/tencent/beacon/core/d/b:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: aconst_null
    //   59: areturn
    //   60: aload_1
    //   61: ldc 247
    //   63: invokeinterface 250 2 0
    //   68: ifeq +58 -> 126
    //   71: aload_1
    //   72: ldc 252
    //   74: invokeinterface 250 2 0
    //   79: ifeq +47 -> 126
    //   82: aload_1
    //   83: ldc 247
    //   85: invokeinterface 256 2 0
    //   90: invokeinterface 261 1 0
    //   95: astore 4
    //   97: aload_1
    //   98: ldc 252
    //   100: invokeinterface 256 2 0
    //   105: invokeinterface 261 1 0
    //   110: astore 5
    //   112: invokestatic 86	com/tencent/beacon/core/strategy/a:a	()Lcom/tencent/beacon/core/strategy/a;
    //   115: aload_0
    //   116: getfield 13	com/tencent/beacon/core/c/f$a:a	Landroid/content/Context;
    //   119: aload 4
    //   121: aload 5
    //   123: invokevirtual 264	com/tencent/beacon/core/strategy/a:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_1
    //   127: invokeinterface 268 1 0
    //   132: astore_1
    //   133: aload_1
    //   134: ifnonnull +15 -> 149
    //   137: ldc_w 270
    //   140: iconst_0
    //   141: anewarray 21	java/lang/Object
    //   144: invokestatic 27	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: aconst_null
    //   148: areturn
    //   149: new 272	java/io/BufferedInputStream
    //   152: dup
    //   153: new 274	java/io/DataInputStream
    //   156: dup
    //   157: aload_1
    //   158: invokeinterface 280 1 0
    //   163: invokespecial 283	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   166: invokespecial 284	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   169: astore 4
    //   171: aload 4
    //   173: astore_1
    //   174: new 286	java/io/ByteArrayOutputStream
    //   177: dup
    //   178: invokespecial 287	java/io/ByteArrayOutputStream:<init>	()V
    //   181: astore 5
    //   183: aload 4
    //   185: astore_1
    //   186: aload 4
    //   188: invokevirtual 290	java/io/BufferedInputStream:read	()I
    //   191: istore_3
    //   192: iload_3
    //   193: iconst_m1
    //   194: if_icmpeq +70 -> 264
    //   197: aload 4
    //   199: astore_1
    //   200: aload 5
    //   202: iload_3
    //   203: invokevirtual 294	java/io/ByteArrayOutputStream:write	(I)V
    //   206: goto -23 -> 183
    //   209: astore 5
    //   211: aload 4
    //   213: astore_1
    //   214: aload 5
    //   216: invokestatic 40	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   219: aload 4
    //   221: astore_1
    //   222: ldc_w 296
    //   225: iconst_1
    //   226: anewarray 21	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload 5
    //   233: invokevirtual 46	java/lang/Throwable:toString	()Ljava/lang/String;
    //   236: aastore
    //   237: invokestatic 27	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: aload 4
    //   242: ifnull +8 -> 250
    //   245: aload 4
    //   247: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   250: aload 6
    //   252: astore 4
    //   254: aload_2
    //   255: ifnull -244 -> 11
    //   258: aload_2
    //   259: invokevirtual 51	org/apache/http/client/methods/HttpPost:abort	()V
    //   262: aconst_null
    //   263: areturn
    //   264: aload 4
    //   266: astore_1
    //   267: aload 5
    //   269: invokevirtual 302	java/io/ByteArrayOutputStream:flush	()V
    //   272: aload 4
    //   274: astore_1
    //   275: aload 5
    //   277: invokevirtual 305	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   280: astore 5
    //   282: aload 5
    //   284: astore_1
    //   285: aload 4
    //   287: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   290: aload_1
    //   291: astore 4
    //   293: aload_2
    //   294: ifnull -283 -> 11
    //   297: aload_2
    //   298: invokevirtual 51	org/apache/http/client/methods/HttpPost:abort	()V
    //   301: aload_1
    //   302: areturn
    //   303: astore 4
    //   305: aload 4
    //   307: invokestatic 40	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   310: goto -20 -> 290
    //   313: astore_1
    //   314: aload_1
    //   315: invokestatic 40	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   318: goto -68 -> 250
    //   321: astore 4
    //   323: aconst_null
    //   324: astore_1
    //   325: aload_1
    //   326: ifnull +7 -> 333
    //   329: aload_1
    //   330: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   333: aload_2
    //   334: ifnull +7 -> 341
    //   337: aload_2
    //   338: invokevirtual 51	org/apache/http/client/methods/HttpPost:abort	()V
    //   341: aload 4
    //   343: athrow
    //   344: astore_1
    //   345: aload_1
    //   346: invokestatic 40	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   349: goto -16 -> 333
    //   352: astore 4
    //   354: goto -29 -> 325
    //   357: astore 5
    //   359: aconst_null
    //   360: astore 4
    //   362: goto -151 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	a
    //   0	365	1	paramHttpResponse	HttpResponse
    //   0	365	2	paramHttpPost	HttpPost
    //   25	178	3	i	int
    //   9	283	4	localObject1	Object
    //   303	3	4	localThrowable1	Throwable
    //   321	21	4	localObject2	Object
    //   352	1	4	localObject3	Object
    //   360	1	4	localObject4	Object
    //   110	91	5	localObject5	Object
    //   209	67	5	localThrowable2	Throwable
    //   280	3	5	arrayOfByte	byte[]
    //   357	1	5	localThrowable3	Throwable
    //   1	250	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   174	183	209	java/lang/Throwable
    //   186	192	209	java/lang/Throwable
    //   200	206	209	java/lang/Throwable
    //   267	272	209	java/lang/Throwable
    //   275	282	209	java/lang/Throwable
    //   285	290	303	java/lang/Throwable
    //   245	250	313	java/lang/Throwable
    //   149	171	321	finally
    //   329	333	344	java/lang/Throwable
    //   174	183	352	finally
    //   186	192	352	finally
    //   200	206	352	finally
    //   214	219	352	finally
    //   222	240	352	finally
    //   267	272	352	finally
    //   275	282	352	finally
    //   149	171	357	java/lang/Throwable
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final byte[] a(String paramString, byte[] paramArrayOfByte, a parama, e parame)
  {
    if (paramString == null)
    {
      com.tencent.beacon.core.d.b.d("[net] destUrl is null.", new Object[0]);
      return null;
    }
    com.tencent.beacon.core.d.b.b("[net] HTTP requestCmd(%d) moduleId(%d) eventCnt(%d)", new Object[] { Integer.valueOf(parama.a), Integer.valueOf(parama.b), Integer.valueOf(parama.e) });
    int j = 0;
    if (paramArrayOfByte == null) {}
    int i;
    Object localObject1;
    Object localObject3;
    int k;
    Object localObject2;
    int m;
    for (long l2 = 0L;; l2 = paramArrayOfByte.length)
    {
      com.tencent.beacon.core.d.b.h("[net] request url:%s sz:%d", new Object[] { paramString, Long.valueOf(l2) });
      i = 0;
      localObject1 = null;
      localObject3 = paramString;
      paramString = "";
      k = 0;
      localObject2 = "";
      m = k + 1;
      if ((k >= 3) || (j >= 2)) {
        break label822;
      }
      if (i == 0) {
        break;
      }
      throw new Exception("net redirect");
    }
    if (m > 1)
    {
      com.tencent.beacon.core.d.b.h("[net] try time:" + m, new Object[0]);
      if ((m == 2) && (parama.c() == 2)) {
        parama.b(false);
      }
      b();
    }
    Object localObject5 = d.c(this.a);
    parame.a((String)localObject3, l2, (String)localObject5, m);
    long l1 = new Date().getTime();
    try
    {
      localObject5 = a((String)localObject3, paramArrayOfByte, (String)localObject5, m);
      localObject1 = localObject2;
      localObject2 = localObject5;
    }
    catch (Exception localException2)
    {
      long l3;
      Object localObject7 = localException2.toString();
      if (!paramString.equals(localObject7)) {
        break label481;
      }
      label481:
      for (localObject2 = (String)localObject2 + m + ":same ";; localObject2 = (String)localObject2 + m + ":" + (String)localObject7 + " ")
      {
        localObject6 = localObject1;
        paramString = (String)localObject7;
        localObject1 = localObject2;
        localObject2 = localObject6;
        break;
      }
      paramString = a((HttpResponse)localObject6, ((b)localObject2).b);
      if (paramString != null) {
        break label555;
      }
      label555:
      for (l1 = 0L;; l1 = paramString.length)
      {
        parame.a(l1, l4);
        return paramString;
      }
      if (i2 == 301) {
        break label595;
      }
    }
    long l4 = new Date().getTime() - l1;
    int i2;
    Object localObject6;
    if (localObject2 != null)
    {
      localObject5 = ((b)localObject2).a;
      localObject7 = ((HttpResponse)localObject5).getEntity();
      l1 = 0L;
      if (localObject7 != null)
      {
        l3 = ((HttpEntity)localObject7).getContentLength();
        l1 = l3;
        if (l3 < 0L) {
          l1 = 0L;
        }
      }
      i2 = ((HttpResponse)localObject5).getStatusLine().getStatusCode();
      com.tencent.beacon.core.d.b.h("[net] response code:%d ", new Object[] { Integer.valueOf(i2) });
      if (i2 == 200) {
        if (((HttpResponse)localObject5).containsHeader("encrypt-status"))
        {
          com.tencent.beacon.core.d.b.d("[net] svr encry failed: " + ((HttpResponse)localObject5).getFirstHeader("encrypt-status").getValue(), new Object[0]);
          return null;
        }
      }
      if ((i2 == 302) || (i2 == 303) || (i2 == 307))
      {
        label595:
        k = 1;
        label598:
        if (k == 0) {
          break label857;
        }
        m = 1;
        localObject3 = ((HttpResponse)localObject6).getFirstHeader("Location");
        if (localObject3 != null) {
          break label678;
        }
        com.tencent.beacon.core.d.b.d("[net] redirect code:" + i2 + " Location is null! return", new Object[0]);
      }
    }
    for (;;)
    {
      try
      {
        if (((b)localObject2).b != null) {
          ((b)localObject2).b.abort();
        }
        return null;
        k = 0;
        break label598;
        label678:
        n = j + 1;
        i1 = 0;
        localObject6 = ((Header)localObject3).getValue();
        com.tencent.beacon.core.d.b.h("[net] redirect code:%d , to:%s", new Object[] { Integer.valueOf(i2), localObject6 });
        i = m;
        j = n;
        k = i1;
        localObject3 = localObject6;
        try
        {
          if (((b)localObject2).b != null)
          {
            ((b)localObject2).b.abort();
            localObject3 = localObject6;
            k = i1;
            j = n;
            i = m;
          }
        }
        catch (Exception localException1)
        {
          label822:
          i = m;
          j = n;
          k = i1;
          Object localObject4 = localObject6;
          continue;
        }
        parame.a(l1, l4);
        localObject6 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject6;
        break;
        parame.a(0L, l4);
        localObject6 = localObject2;
        k = m;
        localObject2 = localObject1;
        localObject1 = localObject6;
        break;
        throw new Exception((String)localObject2);
      }
      catch (Exception paramString)
      {
        int n;
        int i1;
        continue;
      }
      label857:
      k = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.c.f.a
 * JD-Core Version:    0.7.0.1
 */