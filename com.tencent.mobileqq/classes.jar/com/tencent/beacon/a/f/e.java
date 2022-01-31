package com.tencent.beacon.a.f;

import android.content.Context;
import android.net.Proxy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public abstract class e
{
  private static e a = null;
  
  public static e a(Context paramContext)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        bool = com.tencent.beacon.a.e.a.a().h();
        if ((a == null) && (paramContext != null))
        {
          if (bool)
          {
            a = new b(paramContext);
            paramContext = a;
            return paramContext;
          }
          a = new a(paramContext);
          continue;
        }
        if (a == null) {
          continue;
        }
      }
      finally {}
      if (a.a() != bool) {
        if (bool) {
          a = new b(paramContext);
        } else {
          a = new a(paramContext);
        }
      }
    }
  }
  
  public abstract boolean a();
  
  public byte[] a(String paramString, int paramInt, byte[] paramArrayOfByte, a parama, d paramd)
    throws Exception
  {
    return null;
  }
  
  public byte[] a(String paramString, byte[] paramArrayOfByte, a parama, d paramd)
    throws Exception
  {
    return null;
  }
  
  static final class a
    extends e
  {
    private Context a;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    private static b a(String paramString1, byte[] paramArrayOfByte, String paramString2, int paramInt)
      throws Exception
    {
      if (paramString1 == null)
      {
        com.tencent.beacon.a.g.a.d("[net] destUrl is null.", new Object[0]);
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
            com.tencent.beacon.a.g.a.d("[net] no httpClient!", new Object[0]);
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
        com.tencent.beacon.a.g.a.a(paramString1);
        com.tencent.beacon.a.g.a.d("[net] execute error:%s", new Object[] { paramString1.toString() });
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
          paramString1 = com.tencent.beacon.a.e.a.a();
          if (paramString1 != null) {
            paramString2.setHeader("bea_key", paramString1.n());
          }
          paramString2.setEntity(paramArrayOfByte);
          paramString1 = new BasicHttpContext();
          paramArrayOfByte = localHttpClient.execute(paramString2, paramString1);
          com.tencent.beacon.a.g.a.h("[net] execute request:\n %s", new Object[] { ((HttpRequest)paramString1.getAttribute("http.request")).getRequestLine().toString() });
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
        localDefaultHttpClient.setHttpRequestRetryHandler(new HttpRequestRetryHandler()
        {
          public final boolean retryRequest(IOException paramAnonymousIOException, int paramAnonymousInt, HttpContext paramAnonymousHttpContext)
          {
            if (paramAnonymousInt >= 3) {}
            do
            {
              return false;
              if ((paramAnonymousIOException instanceof NoHttpResponseException)) {
                return true;
              }
            } while (!(paramAnonymousIOException instanceof ClientProtocolException));
            return true;
          }
        });
        if ((paramString != null) && (paramString.toLowerCase(Locale.US).contains("wap")) && (paramInt != 2))
        {
          com.tencent.beacon.a.g.a.a("[net] use proxy: %s, try time: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
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
            com.tencent.beacon.a.g.a.a("[net] Don't use proxy: %s, try time: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
          }
          localDefaultHttpClient.getParams().removeParameter("http.route.default-proxy");
          return localDefaultHttpClient;
        }
      }
      catch (Throwable paramString)
      {
        com.tencent.beacon.a.g.a.a(paramString);
        com.tencent.beacon.a.g.a.d("[net] httpclient error!", new Object[0]);
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
      //   15: invokeinterface 236 1 0
      //   20: invokeinterface 241 1 0
      //   25: istore_3
      //   26: iload_3
      //   27: sipush 200
      //   30: if_icmpeq +30 -> 60
      //   33: ldc 243
      //   35: iconst_2
      //   36: anewarray 25	java/lang/Object
      //   39: dup
      //   40: iconst_0
      //   41: iload_3
      //   42: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   45: aastore
      //   46: dup
      //   47: iconst_1
      //   48: aload_1
      //   49: invokeinterface 236 1 0
      //   54: aastore
      //   55: invokestatic 246	com/tencent/beacon/a/g/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   58: aconst_null
      //   59: areturn
      //   60: aload_1
      //   61: ldc 248
      //   63: invokeinterface 251 2 0
      //   68: ifeq +58 -> 126
      //   71: aload_1
      //   72: ldc 253
      //   74: invokeinterface 251 2 0
      //   79: ifeq +47 -> 126
      //   82: aload_1
      //   83: ldc 248
      //   85: invokeinterface 257 2 0
      //   90: invokeinterface 262 1 0
      //   95: astore 4
      //   97: aload_1
      //   98: ldc 253
      //   100: invokeinterface 257 2 0
      //   105: invokeinterface 262 1 0
      //   110: astore 5
      //   112: invokestatic 88	com/tencent/beacon/a/e/a:a	()Lcom/tencent/beacon/a/e/a;
      //   115: aload_0
      //   116: getfield 15	com/tencent/beacon/a/f/e$a:a	Landroid/content/Context;
      //   119: aload 4
      //   121: aload 5
      //   123: invokevirtual 265	com/tencent/beacon/a/e/a:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
      //   126: aload_1
      //   127: invokeinterface 269 1 0
      //   132: astore_1
      //   133: aload_1
      //   134: ifnonnull +15 -> 149
      //   137: ldc_w 271
      //   140: iconst_0
      //   141: anewarray 25	java/lang/Object
      //   144: invokestatic 31	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   147: aconst_null
      //   148: areturn
      //   149: new 273	java/io/BufferedInputStream
      //   152: dup
      //   153: new 275	java/io/DataInputStream
      //   156: dup
      //   157: aload_1
      //   158: invokeinterface 281 1 0
      //   163: invokespecial 284	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   166: invokespecial 285	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   169: astore 4
      //   171: aload 4
      //   173: astore_1
      //   174: new 287	java/io/ByteArrayOutputStream
      //   177: dup
      //   178: invokespecial 288	java/io/ByteArrayOutputStream:<init>	()V
      //   181: astore 5
      //   183: aload 4
      //   185: astore_1
      //   186: aload 4
      //   188: invokevirtual 291	java/io/BufferedInputStream:read	()I
      //   191: istore_3
      //   192: iload_3
      //   193: iconst_m1
      //   194: if_icmpeq +70 -> 264
      //   197: aload 4
      //   199: astore_1
      //   200: aload 5
      //   202: iload_3
      //   203: invokevirtual 295	java/io/ByteArrayOutputStream:write	(I)V
      //   206: goto -23 -> 183
      //   209: astore 5
      //   211: aload 4
      //   213: astore_1
      //   214: aload 5
      //   216: invokestatic 44	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
      //   219: aload 4
      //   221: astore_1
      //   222: ldc_w 297
      //   225: iconst_1
      //   226: anewarray 25	java/lang/Object
      //   229: dup
      //   230: iconst_0
      //   231: aload 5
      //   233: invokevirtual 50	java/lang/Throwable:toString	()Ljava/lang/String;
      //   236: aastore
      //   237: invokestatic 31	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   240: aload 4
      //   242: ifnull +8 -> 250
      //   245: aload 4
      //   247: invokevirtual 300	java/io/BufferedInputStream:close	()V
      //   250: aload 6
      //   252: astore 4
      //   254: aload_2
      //   255: ifnull -244 -> 11
      //   258: aload_2
      //   259: invokevirtual 55	org/apache/http/client/methods/HttpPost:abort	()V
      //   262: aconst_null
      //   263: areturn
      //   264: aload 4
      //   266: astore_1
      //   267: aload 5
      //   269: invokevirtual 303	java/io/ByteArrayOutputStream:flush	()V
      //   272: aload 4
      //   274: astore_1
      //   275: aload 5
      //   277: invokevirtual 306	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   280: astore 5
      //   282: aload 5
      //   284: astore_1
      //   285: aload 4
      //   287: invokevirtual 300	java/io/BufferedInputStream:close	()V
      //   290: aload_1
      //   291: astore 4
      //   293: aload_2
      //   294: ifnull -283 -> 11
      //   297: aload_2
      //   298: invokevirtual 55	org/apache/http/client/methods/HttpPost:abort	()V
      //   301: aload_1
      //   302: areturn
      //   303: astore 4
      //   305: aload 4
      //   307: invokestatic 44	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
      //   310: goto -20 -> 290
      //   313: astore_1
      //   314: aload_1
      //   315: invokestatic 44	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
      //   318: goto -68 -> 250
      //   321: astore 4
      //   323: aconst_null
      //   324: astore_1
      //   325: aload_1
      //   326: ifnull +7 -> 333
      //   329: aload_1
      //   330: invokevirtual 300	java/io/BufferedInputStream:close	()V
      //   333: aload_2
      //   334: ifnull +7 -> 341
      //   337: aload_2
      //   338: invokevirtual 55	org/apache/http/client/methods/HttpPost:abort	()V
      //   341: aload 4
      //   343: athrow
      //   344: astore_1
      //   345: aload_1
      //   346: invokestatic 44	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
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
    
    public final byte[] a(String paramString, byte[] paramArrayOfByte, a parama, d paramd)
      throws Exception
    {
      if (paramString == null)
      {
        com.tencent.beacon.a.g.a.d("[net] destUrl is null.", new Object[0]);
        return null;
      }
      com.tencent.beacon.a.g.a.b("[net] HTTP requestCmd(%d) moduleId(%d) eventCnt(%d)", new Object[] { Integer.valueOf(parama.a), Integer.valueOf(parama.b), Integer.valueOf(parama.e) });
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
        com.tencent.beacon.a.g.a.h("[net] request url:%s sz:%d", new Object[] { paramString, Long.valueOf(l2) });
        i = 0;
        localObject1 = null;
        localObject3 = paramString;
        paramString = "";
        k = 0;
        localObject2 = "";
        m = k + 1;
        if ((k >= 3) || (j >= 2)) {
          break label827;
        }
        if (i == 0) {
          break;
        }
        throw new Exception("net redirect");
      }
      if (m > 1)
      {
        com.tencent.beacon.a.g.a.h("[net] try time:" + m, new Object[0]);
        if ((m == 2) && (parama.c() == 2)) {
          parama.b(false);
        }
      }
      long l1;
      long l4;
      int i2;
      try
      {
        Thread.sleep(5000L);
        Object localObject5 = com.tencent.beacon.a.a.i(this.a);
        paramd.a((String)localObject3, l2, (String)localObject5, m);
        l1 = new Date().getTime();
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
            break label492;
          }
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
            break label564;
          }
          for (l1 = 0L;; l1 = paramString.length)
          {
            paramd.a(l1, l4);
            return paramString;
          }
          if (i2 == 301) {
            break label604;
          }
        }
        l4 = new Date().getTime() - l1;
        if (localObject2 == null) {
          break label800;
        }
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
        com.tencent.beacon.a.g.a.h("[net] response code:%d ", new Object[] { Integer.valueOf(i2) });
        if (i2 == 200) {
          if (((HttpResponse)localObject5).containsHeader("encrypt-status"))
          {
            com.tencent.beacon.a.g.a.d("[net] svr encry failed: " + ((HttpResponse)localObject5).getFirstHeader("encrypt-status").getValue(), new Object[0]);
            return null;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          com.tencent.beacon.a.g.a.a(localInterruptedException);
        }
      }
      Object localObject6;
      label492:
      if ((i2 == 302) || (i2 == 303) || (i2 == 307))
      {
        k = 1;
        if (k == 0) {
          break label862;
        }
        m = 1;
        localObject3 = ((HttpResponse)localObject6).getFirstHeader("Location");
        if (localObject3 != null) {
          break label687;
        }
        com.tencent.beacon.a.g.a.d("[net] redirect code:" + i2 + " Location is null! return", new Object[0]);
      }
      for (;;)
      {
        try
        {
          label564:
          label604:
          label607:
          if (((b)localObject2).b != null) {
            ((b)localObject2).b.abort();
          }
          return null;
          k = 0;
          break label607;
          label687:
          n = j + 1;
          i1 = 0;
          localObject6 = ((Header)localObject3).getValue();
          com.tencent.beacon.a.g.a.h("[net] redirect code:%d , to:%s", new Object[] { Integer.valueOf(i2), localObject6 });
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
            label800:
            label827:
            i = m;
            j = n;
            k = i1;
            Object localObject4 = localObject6;
            continue;
          }
          paramd.a(l1, l4);
          localObject6 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject6;
          break;
          paramd.a(0L, l4);
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
        label862:
        k = m;
      }
    }
  }
  
  static final class b
    extends e
  {
    private Context a;
    
    public b(Context paramContext)
    {
      this.a = paramContext;
    }
    
    private static byte[] a(Socket paramSocket)
      throws IOException
    {
      paramSocket = paramSocket.getInputStream();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[2048];
      for (;;)
      {
        int i = paramSocket.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localByteArrayOutputStream.flush();
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length - 4);
      localByteBuffer.put(arrayOfByte, 2, arrayOfByte.length - 4);
      arrayOfByte = localByteBuffer.array();
      localByteArrayOutputStream.close();
      paramSocket.close();
      return arrayOfByte;
    }
    
    public final boolean a()
    {
      return true;
    }
    
    /* Error */
    public final byte[] a(String paramString, int paramInt, byte[] paramArrayOfByte, a parama, d paramd)
      throws Exception
    {
      // Byte code:
      //   0: aload_1
      //   1: ifnull +7 -> 8
      //   4: iload_2
      //   5: ifgt +14 -> 19
      //   8: ldc 74
      //   10: iconst_0
      //   11: anewarray 76	java/lang/Object
      //   14: invokestatic 82	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   17: aconst_null
      //   18: areturn
      //   19: ldc 84
      //   21: iconst_3
      //   22: anewarray 76	java/lang/Object
      //   25: dup
      //   26: iconst_0
      //   27: aload 4
      //   29: getfield 89	com/tencent/beacon/a/f/a:a	I
      //   32: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   35: aastore
      //   36: dup
      //   37: iconst_1
      //   38: aload 4
      //   40: getfield 97	com/tencent/beacon/a/f/a:b	I
      //   43: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   46: aastore
      //   47: dup
      //   48: iconst_2
      //   49: aload 4
      //   51: getfield 100	com/tencent/beacon/a/f/a:e	I
      //   54: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   57: aastore
      //   58: invokestatic 102	com/tencent/beacon/a/g/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   61: ldc 104
      //   63: astore 12
      //   65: iconst_0
      //   66: istore 6
      //   68: iload 6
      //   70: iconst_1
      //   71: iadd
      //   72: istore 7
      //   74: iload 6
      //   76: iconst_3
      //   77: if_icmpge +959 -> 1036
      //   80: iload 7
      //   82: iconst_1
      //   83: if_icmple +54 -> 137
      //   86: new 106	java/lang/StringBuilder
      //   89: dup
      //   90: ldc 108
      //   92: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   95: iload 7
      //   97: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   100: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   103: iconst_0
      //   104: anewarray 76	java/lang/Object
      //   107: invokestatic 122	com/tencent/beacon/a/g/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   110: iload 7
      //   112: iconst_2
      //   113: if_icmpne +18 -> 131
      //   116: aload 4
      //   118: invokevirtual 126	com/tencent/beacon/a/f/a:c	()I
      //   121: iconst_2
      //   122: if_icmpne +9 -> 131
      //   125: aload 4
      //   127: iconst_0
      //   128: invokevirtual 129	com/tencent/beacon/a/f/a:b	(Z)V
      //   131: ldc2_w 130
      //   134: invokestatic 137	java/lang/Thread:sleep	(J)V
      //   137: aload_3
      //   138: ifnonnull +597 -> 735
      //   141: lconst_0
      //   142: lstore 8
      //   144: aload 5
      //   146: new 106	java/lang/StringBuilder
      //   149: dup
      //   150: invokespecial 138	java/lang/StringBuilder:<init>	()V
      //   153: aload_1
      //   154: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   157: ldc 143
      //   159: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   162: iload_2
      //   163: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   166: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   169: lload 8
      //   171: aload_0
      //   172: getfield 14	com/tencent/beacon/a/f/e$b:a	Landroid/content/Context;
      //   175: invokestatic 149	com/tencent/beacon/a/a:i	(Landroid/content/Context;)Ljava/lang/String;
      //   178: iload 7
      //   180: invokevirtual 154	com/tencent/beacon/a/f/d:a	(Ljava/lang/String;JLjava/lang/String;I)V
      //   183: new 156	java/util/Date
      //   186: dup
      //   187: invokespecial 157	java/util/Date:<init>	()V
      //   190: invokevirtual 161	java/util/Date:getTime	()J
      //   193: lstore 8
      //   195: aload_1
      //   196: invokestatic 167	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
      //   199: astore 13
      //   201: aconst_null
      //   202: astore 14
      //   204: aconst_null
      //   205: astore 15
      //   207: new 20	java/net/Socket
      //   210: dup
      //   211: aload 13
      //   213: invokevirtual 170	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   216: iload_2
      //   217: invokespecial 173	java/net/Socket:<init>	(Ljava/lang/String;I)V
      //   220: astore 13
      //   222: aload 13
      //   224: astore 14
      //   226: aload 13
      //   228: sipush 30000
      //   231: invokevirtual 177	java/net/Socket:setSoTimeout	(I)V
      //   234: aload 13
      //   236: astore 14
      //   238: ldc 179
      //   240: iconst_3
      //   241: anewarray 76	java/lang/Object
      //   244: dup
      //   245: iconst_0
      //   246: aload 13
      //   248: invokevirtual 183	java/net/Socket:getLocalAddress	()Ljava/net/InetAddress;
      //   251: invokevirtual 186	java/net/InetAddress:getHostName	()Ljava/lang/String;
      //   254: aastore
      //   255: dup
      //   256: iconst_1
      //   257: aload 13
      //   259: invokevirtual 189	java/net/Socket:getLocalPort	()I
      //   262: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   265: aastore
      //   266: dup
      //   267: iconst_2
      //   268: aload_3
      //   269: arraylength
      //   270: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   273: aastore
      //   274: invokestatic 102	com/tencent/beacon/a/g/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   277: aload 13
      //   279: astore 14
      //   281: new 191	java/util/HashMap
      //   284: dup
      //   285: invokespecial 192	java/util/HashMap:<init>	()V
      //   288: astore 15
      //   290: aload 13
      //   292: astore 14
      //   294: aload 4
      //   296: invokevirtual 194	com/tencent/beacon/a/f/a:d	()Ljava/lang/String;
      //   299: astore 16
      //   301: aload 16
      //   303: ifnull +36 -> 339
      //   306: aload 13
      //   308: astore 14
      //   310: ldc 104
      //   312: aload 16
      //   314: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   317: ifne +22 -> 339
      //   320: aload 13
      //   322: astore 14
      //   324: aload 15
      //   326: ldc 202
      //   328: aload 4
      //   330: invokevirtual 194	com/tencent/beacon/a/f/a:d	()Ljava/lang/String;
      //   333: invokeinterface 207 3 0
      //   338: pop
      //   339: aload 13
      //   341: astore 14
      //   343: invokestatic 212	com/tencent/beacon/a/e/a:a	()Lcom/tencent/beacon/a/e/a;
      //   346: invokevirtual 215	com/tencent/beacon/a/e/a:p	()Ljava/lang/String;
      //   349: astore 16
      //   351: aload 16
      //   353: ifnull +33 -> 386
      //   356: aload 13
      //   358: astore 14
      //   360: ldc 104
      //   362: aload 16
      //   364: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   367: ifne +19 -> 386
      //   370: aload 13
      //   372: astore 14
      //   374: aload 15
      //   376: ldc 217
      //   378: aload 16
      //   380: invokeinterface 207 3 0
      //   385: pop
      //   386: aload 13
      //   388: astore 14
      //   390: aload 15
      //   392: ldc 219
      //   394: ldc 221
      //   396: invokeinterface 207 3 0
      //   401: pop
      //   402: aload 13
      //   404: astore 14
      //   406: aload 15
      //   408: ldc 223
      //   410: ldc 225
      //   412: invokeinterface 207 3 0
      //   417: pop
      //   418: aload 13
      //   420: astore 14
      //   422: aload 15
      //   424: ldc 227
      //   426: ldc 229
      //   428: invokeinterface 207 3 0
      //   433: pop
      //   434: aload 13
      //   436: astore 14
      //   438: invokestatic 212	com/tencent/beacon/a/e/a:a	()Lcom/tencent/beacon/a/e/a;
      //   441: astore 16
      //   443: aload 16
      //   445: ifnull +22 -> 467
      //   448: aload 13
      //   450: astore 14
      //   452: aload 15
      //   454: ldc 231
      //   456: aload 16
      //   458: invokevirtual 234	com/tencent/beacon/a/e/a:n	()Ljava/lang/String;
      //   461: invokeinterface 207 3 0
      //   466: pop
      //   467: aload 13
      //   469: astore 14
      //   471: new 236	com/tencent/beacon/a/d/a/d
      //   474: dup
      //   475: aload 15
      //   477: aload_3
      //   478: invokespecial 239	com/tencent/beacon/a/d/a/d:<init>	(Ljava/util/Map;[B)V
      //   481: astore 15
      //   483: aload 13
      //   485: astore 14
      //   487: new 241	com/tencent/beacon/a/h/b
      //   490: dup
      //   491: invokespecial 242	com/tencent/beacon/a/h/b:<init>	()V
      //   494: astore 16
      //   496: aload 13
      //   498: astore 14
      //   500: aload 15
      //   502: aload 16
      //   504: invokevirtual 245	com/tencent/beacon/a/d/a/d:a	(Lcom/tencent/beacon/a/h/b;)V
      //   507: aload 13
      //   509: astore 14
      //   511: aload 13
      //   513: invokevirtual 249	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
      //   516: astore 15
      //   518: aload 13
      //   520: astore 14
      //   522: aload 16
      //   524: invokevirtual 251	com/tencent/beacon/a/h/b:b	()[B
      //   527: astore 16
      //   529: aload 13
      //   531: astore 14
      //   533: aload 16
      //   535: arraylength
      //   536: istore 6
      //   538: aload 13
      //   540: astore 14
      //   542: iload 6
      //   544: iconst_4
      //   545: iadd
      //   546: invokestatic 50	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
      //   549: astore 17
      //   551: aload 13
      //   553: astore 14
      //   555: aload 17
      //   557: getstatic 257	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
      //   560: invokevirtual 261	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
      //   563: pop
      //   564: aload 13
      //   566: astore 14
      //   568: aload 17
      //   570: iload 6
      //   572: iconst_4
      //   573: iadd
      //   574: i2s
      //   575: invokevirtual 265	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
      //   578: pop
      //   579: aload 13
      //   581: astore 14
      //   583: aload 17
      //   585: aload 16
      //   587: invokevirtual 268	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
      //   590: pop
      //   591: aload 13
      //   593: astore 14
      //   595: aload 17
      //   597: bipush 13
      //   599: invokevirtual 271	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
      //   602: pop
      //   603: aload 13
      //   605: astore 14
      //   607: aload 17
      //   609: bipush 10
      //   611: invokevirtual 271	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
      //   614: pop
      //   615: iload 6
      //   617: ldc_w 272
      //   620: if_icmplt +17 -> 637
      //   623: aload 13
      //   625: astore 14
      //   627: ldc_w 274
      //   630: iconst_0
      //   631: anewarray 76	java/lang/Object
      //   634: invokestatic 82	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   637: aload 13
      //   639: astore 14
      //   641: aload 15
      //   643: aload 17
      //   645: invokevirtual 57	java/nio/ByteBuffer:array	()[B
      //   648: invokevirtual 279	java/io/OutputStream:write	([B)V
      //   651: aload 13
      //   653: astore 14
      //   655: aload 15
      //   657: invokevirtual 280	java/io/OutputStream:flush	()V
      //   660: aload 13
      //   662: astore 14
      //   664: aload 13
      //   666: invokestatic 282	com/tencent/beacon/a/f/e$b:a	(Ljava/net/Socket;)[B
      //   669: astore 15
      //   671: aload 15
      //   673: astore 14
      //   675: aload 13
      //   677: invokevirtual 283	java/net/Socket:close	()V
      //   680: aload 14
      //   682: astore 13
      //   684: aload 13
      //   686: ifnonnull +335 -> 1021
      //   689: iconst_0
      //   690: istore 6
      //   692: new 156	java/util/Date
      //   695: dup
      //   696: invokespecial 157	java/util/Date:<init>	()V
      //   699: invokevirtual 161	java/util/Date:getTime	()J
      //   702: lstore 10
      //   704: aload 5
      //   706: iload 6
      //   708: i2l
      //   709: lload 10
      //   711: lload 8
      //   713: lsub
      //   714: invokevirtual 286	com/tencent/beacon/a/f/d:a	(JJ)V
      //   717: aload 13
      //   719: ifnull +310 -> 1029
      //   722: aload 13
      //   724: areturn
      //   725: astore 13
      //   727: aload 13
      //   729: invokestatic 289	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
      //   732: goto -595 -> 137
      //   735: aload_3
      //   736: arraylength
      //   737: i2l
      //   738: lstore 8
      //   740: goto -596 -> 144
      //   743: astore 13
      //   745: aload 14
      //   747: astore 13
      //   749: goto -65 -> 684
      //   752: astore 13
      //   754: aconst_null
      //   755: astore 15
      //   757: aload 15
      //   759: astore 14
      //   761: ldc_w 291
      //   764: iconst_0
      //   765: anewarray 76	java/lang/Object
      //   768: invokestatic 122	com/tencent/beacon/a/g/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   771: aload 15
      //   773: astore 14
      //   775: new 106	java/lang/StringBuilder
      //   778: dup
      //   779: invokespecial 138	java/lang/StringBuilder:<init>	()V
      //   782: aload 12
      //   784: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   787: iload 7
      //   789: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   792: ldc_w 293
      //   795: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   798: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   801: astore 13
      //   803: aload 13
      //   805: astore 12
      //   807: aload 15
      //   809: ifnull +276 -> 1085
      //   812: aload 15
      //   814: invokevirtual 283	java/net/Socket:close	()V
      //   817: aconst_null
      //   818: astore 14
      //   820: aload 13
      //   822: astore 12
      //   824: aload 14
      //   826: astore 13
      //   828: goto -144 -> 684
      //   831: astore 12
      //   833: aconst_null
      //   834: astore 14
      //   836: aload 13
      //   838: astore 12
      //   840: aload 14
      //   842: astore 13
      //   844: goto -160 -> 684
      //   847: astore 13
      //   849: aconst_null
      //   850: astore 15
      //   852: aload 15
      //   854: astore 14
      //   856: new 106	java/lang/StringBuilder
      //   859: dup
      //   860: invokespecial 138	java/lang/StringBuilder:<init>	()V
      //   863: aload 12
      //   865: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   868: iload 7
      //   870: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   873: ldc_w 295
      //   876: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   879: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   882: astore 13
      //   884: aload 13
      //   886: astore 12
      //   888: aload 15
      //   890: ifnull +195 -> 1085
      //   893: aload 15
      //   895: invokevirtual 283	java/net/Socket:close	()V
      //   898: aconst_null
      //   899: astore 14
      //   901: aload 13
      //   903: astore 12
      //   905: aload 14
      //   907: astore 13
      //   909: goto -225 -> 684
      //   912: astore 12
      //   914: aconst_null
      //   915: astore 14
      //   917: aload 13
      //   919: astore 12
      //   921: aload 14
      //   923: astore 13
      //   925: goto -241 -> 684
      //   928: astore 13
      //   930: aload 15
      //   932: astore 14
      //   934: new 106	java/lang/StringBuilder
      //   937: dup
      //   938: invokespecial 138	java/lang/StringBuilder:<init>	()V
      //   941: aload 12
      //   943: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   946: ldc 143
      //   948: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   951: aload 13
      //   953: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   956: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   959: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   962: astore 13
      //   964: aload 13
      //   966: astore 12
      //   968: aload 15
      //   970: ifnull +115 -> 1085
      //   973: aload 15
      //   975: invokevirtual 283	java/net/Socket:close	()V
      //   978: aconst_null
      //   979: astore 14
      //   981: aload 13
      //   983: astore 12
      //   985: aload 14
      //   987: astore 13
      //   989: goto -305 -> 684
      //   992: astore 12
      //   994: aconst_null
      //   995: astore 14
      //   997: aload 13
      //   999: astore 12
      //   1001: aload 14
      //   1003: astore 13
      //   1005: goto -321 -> 684
      //   1008: astore_1
      //   1009: aload 14
      //   1011: ifnull +8 -> 1019
      //   1014: aload 14
      //   1016: invokevirtual 283	java/net/Socket:close	()V
      //   1019: aload_1
      //   1020: athrow
      //   1021: aload 13
      //   1023: arraylength
      //   1024: istore 6
      //   1026: goto -334 -> 692
      //   1029: iload 7
      //   1031: istore 6
      //   1033: goto -965 -> 68
      //   1036: new 72	java/net/ConnectException
      //   1039: dup
      //   1040: aload 12
      //   1042: invokespecial 299	java/net/ConnectException:<init>	(Ljava/lang/String;)V
      //   1045: athrow
      //   1046: astore_3
      //   1047: goto -28 -> 1019
      //   1050: astore_1
      //   1051: goto -42 -> 1009
      //   1054: astore 14
      //   1056: aload 13
      //   1058: astore 15
      //   1060: aload 14
      //   1062: astore 13
      //   1064: goto -134 -> 930
      //   1067: astore 14
      //   1069: aload 13
      //   1071: astore 15
      //   1073: goto -221 -> 852
      //   1076: astore 14
      //   1078: aload 13
      //   1080: astore 15
      //   1082: goto -325 -> 757
      //   1085: aconst_null
      //   1086: astore 13
      //   1088: goto -404 -> 684
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1091	0	this	b
      //   0	1091	1	paramString	String
      //   0	1091	2	paramInt	int
      //   0	1091	3	paramArrayOfByte	byte[]
      //   0	1091	4	parama	a
      //   0	1091	5	paramd	d
      //   66	966	6	i	int
      //   72	958	7	j	int
      //   142	597	8	l1	long
      //   702	8	10	l2	long
      //   63	760	12	localObject1	Object
      //   831	1	12	localIOException1	IOException
      //   838	66	12	localObject2	Object
      //   912	1	12	localIOException2	IOException
      //   919	65	12	localObject3	Object
      //   992	1	12	localIOException3	IOException
      //   999	42	12	localObject4	Object
      //   199	524	13	localObject5	Object
      //   725	3	13	localInterruptedException	InterruptedException
      //   743	1	13	localIOException4	IOException
      //   747	1	13	localObject6	Object
      //   752	1	13	localSocketTimeoutException1	java.net.SocketTimeoutException
      //   801	42	13	localObject7	Object
      //   847	1	13	localConnectException1	java.net.ConnectException
      //   882	42	13	localObject8	Object
      //   928	24	13	localException1	Exception
      //   962	125	13	localObject9	Object
      //   202	813	14	localObject10	Object
      //   1054	7	14	localException2	Exception
      //   1067	1	14	localConnectException2	java.net.ConnectException
      //   1076	1	14	localSocketTimeoutException2	java.net.SocketTimeoutException
      //   205	876	15	localObject11	Object
      //   299	287	16	localObject12	Object
      //   549	95	17	localByteBuffer	ByteBuffer
      // Exception table:
      //   from	to	target	type
      //   131	137	725	java/lang/InterruptedException
      //   675	680	743	java/io/IOException
      //   207	222	752	java/net/SocketTimeoutException
      //   812	817	831	java/io/IOException
      //   207	222	847	java/net/ConnectException
      //   893	898	912	java/io/IOException
      //   207	222	928	java/lang/Exception
      //   973	978	992	java/io/IOException
      //   207	222	1008	finally
      //   934	964	1008	finally
      //   1014	1019	1046	java/io/IOException
      //   226	234	1050	finally
      //   238	277	1050	finally
      //   281	290	1050	finally
      //   294	301	1050	finally
      //   310	320	1050	finally
      //   324	339	1050	finally
      //   343	351	1050	finally
      //   360	370	1050	finally
      //   374	386	1050	finally
      //   390	402	1050	finally
      //   406	418	1050	finally
      //   422	434	1050	finally
      //   438	443	1050	finally
      //   452	467	1050	finally
      //   471	483	1050	finally
      //   487	496	1050	finally
      //   500	507	1050	finally
      //   511	518	1050	finally
      //   522	529	1050	finally
      //   533	538	1050	finally
      //   542	551	1050	finally
      //   555	564	1050	finally
      //   568	579	1050	finally
      //   583	591	1050	finally
      //   595	603	1050	finally
      //   607	615	1050	finally
      //   627	637	1050	finally
      //   641	651	1050	finally
      //   655	660	1050	finally
      //   664	671	1050	finally
      //   761	771	1050	finally
      //   775	803	1050	finally
      //   856	884	1050	finally
      //   226	234	1054	java/lang/Exception
      //   238	277	1054	java/lang/Exception
      //   281	290	1054	java/lang/Exception
      //   294	301	1054	java/lang/Exception
      //   310	320	1054	java/lang/Exception
      //   324	339	1054	java/lang/Exception
      //   343	351	1054	java/lang/Exception
      //   360	370	1054	java/lang/Exception
      //   374	386	1054	java/lang/Exception
      //   390	402	1054	java/lang/Exception
      //   406	418	1054	java/lang/Exception
      //   422	434	1054	java/lang/Exception
      //   438	443	1054	java/lang/Exception
      //   452	467	1054	java/lang/Exception
      //   471	483	1054	java/lang/Exception
      //   487	496	1054	java/lang/Exception
      //   500	507	1054	java/lang/Exception
      //   511	518	1054	java/lang/Exception
      //   522	529	1054	java/lang/Exception
      //   533	538	1054	java/lang/Exception
      //   542	551	1054	java/lang/Exception
      //   555	564	1054	java/lang/Exception
      //   568	579	1054	java/lang/Exception
      //   583	591	1054	java/lang/Exception
      //   595	603	1054	java/lang/Exception
      //   607	615	1054	java/lang/Exception
      //   627	637	1054	java/lang/Exception
      //   641	651	1054	java/lang/Exception
      //   655	660	1054	java/lang/Exception
      //   664	671	1054	java/lang/Exception
      //   226	234	1067	java/net/ConnectException
      //   238	277	1067	java/net/ConnectException
      //   281	290	1067	java/net/ConnectException
      //   294	301	1067	java/net/ConnectException
      //   310	320	1067	java/net/ConnectException
      //   324	339	1067	java/net/ConnectException
      //   343	351	1067	java/net/ConnectException
      //   360	370	1067	java/net/ConnectException
      //   374	386	1067	java/net/ConnectException
      //   390	402	1067	java/net/ConnectException
      //   406	418	1067	java/net/ConnectException
      //   422	434	1067	java/net/ConnectException
      //   438	443	1067	java/net/ConnectException
      //   452	467	1067	java/net/ConnectException
      //   471	483	1067	java/net/ConnectException
      //   487	496	1067	java/net/ConnectException
      //   500	507	1067	java/net/ConnectException
      //   511	518	1067	java/net/ConnectException
      //   522	529	1067	java/net/ConnectException
      //   533	538	1067	java/net/ConnectException
      //   542	551	1067	java/net/ConnectException
      //   555	564	1067	java/net/ConnectException
      //   568	579	1067	java/net/ConnectException
      //   583	591	1067	java/net/ConnectException
      //   595	603	1067	java/net/ConnectException
      //   607	615	1067	java/net/ConnectException
      //   627	637	1067	java/net/ConnectException
      //   641	651	1067	java/net/ConnectException
      //   655	660	1067	java/net/ConnectException
      //   664	671	1067	java/net/ConnectException
      //   226	234	1076	java/net/SocketTimeoutException
      //   238	277	1076	java/net/SocketTimeoutException
      //   281	290	1076	java/net/SocketTimeoutException
      //   294	301	1076	java/net/SocketTimeoutException
      //   310	320	1076	java/net/SocketTimeoutException
      //   324	339	1076	java/net/SocketTimeoutException
      //   343	351	1076	java/net/SocketTimeoutException
      //   360	370	1076	java/net/SocketTimeoutException
      //   374	386	1076	java/net/SocketTimeoutException
      //   390	402	1076	java/net/SocketTimeoutException
      //   406	418	1076	java/net/SocketTimeoutException
      //   422	434	1076	java/net/SocketTimeoutException
      //   438	443	1076	java/net/SocketTimeoutException
      //   452	467	1076	java/net/SocketTimeoutException
      //   471	483	1076	java/net/SocketTimeoutException
      //   487	496	1076	java/net/SocketTimeoutException
      //   500	507	1076	java/net/SocketTimeoutException
      //   511	518	1076	java/net/SocketTimeoutException
      //   522	529	1076	java/net/SocketTimeoutException
      //   533	538	1076	java/net/SocketTimeoutException
      //   542	551	1076	java/net/SocketTimeoutException
      //   555	564	1076	java/net/SocketTimeoutException
      //   568	579	1076	java/net/SocketTimeoutException
      //   583	591	1076	java/net/SocketTimeoutException
      //   595	603	1076	java/net/SocketTimeoutException
      //   607	615	1076	java/net/SocketTimeoutException
      //   627	637	1076	java/net/SocketTimeoutException
      //   641	651	1076	java/net/SocketTimeoutException
      //   655	660	1076	java/net/SocketTimeoutException
      //   664	671	1076	java/net/SocketTimeoutException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.f.e
 * JD-Core Version:    0.7.0.1
 */