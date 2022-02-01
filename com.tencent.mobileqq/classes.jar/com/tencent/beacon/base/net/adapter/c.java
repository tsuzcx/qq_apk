package com.tencent.beacon.base.net.adapter;

import com.tencent.beacon.base.net.a.b;
import com.tencent.beacon.base.net.a.f;
import com.tencent.beacon.base.net.a.k;
import com.tencent.beacon.base.net.e;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
  extends a
{
  private com.tencent.beacon.base.net.a a(String paramString1, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    paramString1 = a(paramString1, paramString2, paramMap);
    paramString1.connect();
    paramString2 = paramString1.getOutputStream();
    if ((paramString2 != null) && (paramArrayOfByte != null))
    {
      paramString2.write(paramArrayOfByte);
      paramString2.close();
    }
    int i = paramString1.getResponseCode();
    paramString2 = paramString1.getResponseMessage();
    paramMap = a(paramString1.getInputStream());
    return new com.tencent.beacon.base.net.a(paramString1.getHeaderFields(), i, paramString2, paramMap);
  }
  
  private HttpURLConnection a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    paramString1 = (HttpURLConnection)new URL(paramString1).openConnection();
    paramString1.setConnectTimeout(30000);
    paramString1.setReadTimeout(10000);
    paramString1.setRequestMethod(paramString2);
    paramString1.setDoOutput(true);
    paramString1.setDoInput(true);
    paramString1.setInstanceFollowRedirects(false);
    paramString2 = paramMap.entrySet().iterator();
    while (paramString2.hasNext())
    {
      paramMap = (Map.Entry)paramString2.next();
      paramString1.setRequestProperty((String)paramMap.getKey(), (String)paramMap.getValue());
    }
    return paramString1;
  }
  
  /* Error */
  private byte[] a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 128	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 129	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: astore_3
    //   12: sipush 2048
    //   15: newarray byte
    //   17: astore 5
    //   19: aload 4
    //   21: astore_3
    //   22: aload_1
    //   23: aload 5
    //   25: invokevirtual 135	java/io/InputStream:read	([B)I
    //   28: istore_2
    //   29: iload_2
    //   30: iconst_m1
    //   31: if_icmpeq +18 -> 49
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: aload 5
    //   41: iconst_0
    //   42: iload_2
    //   43: invokevirtual 138	java/io/ByteArrayOutputStream:write	([BII)V
    //   46: goto -27 -> 19
    //   49: aload 4
    //   51: astore_3
    //   52: aload 4
    //   54: invokevirtual 141	java/io/ByteArrayOutputStream:flush	()V
    //   57: aload 4
    //   59: astore_3
    //   60: aload 4
    //   62: invokevirtual 145	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   65: astore 5
    //   67: aload 4
    //   69: astore_3
    //   70: aload 4
    //   72: invokevirtual 146	java/io/ByteArrayOutputStream:close	()V
    //   75: aload 4
    //   77: astore_3
    //   78: aload_1
    //   79: invokevirtual 147	java/io/InputStream:close	()V
    //   82: iconst_2
    //   83: anewarray 149	java/io/Closeable
    //   86: dup
    //   87: iconst_0
    //   88: aload_1
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: aload 4
    //   94: aastore
    //   95: invokestatic 154	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   98: aload 5
    //   100: areturn
    //   101: astore 5
    //   103: goto +15 -> 118
    //   106: astore_3
    //   107: aconst_null
    //   108: astore 4
    //   110: goto +43 -> 153
    //   113: astore 5
    //   115: aconst_null
    //   116: astore 4
    //   118: aload 4
    //   120: astore_3
    //   121: aload 5
    //   123: invokestatic 159	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   126: iconst_2
    //   127: anewarray 149	java/io/Closeable
    //   130: dup
    //   131: iconst_0
    //   132: aload_1
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: aload 4
    //   138: aastore
    //   139: invokestatic 154	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   142: aload 5
    //   144: athrow
    //   145: astore 5
    //   147: aload_3
    //   148: astore 4
    //   150: aload 5
    //   152: astore_3
    //   153: iconst_2
    //   154: anewarray 149	java/io/Closeable
    //   157: dup
    //   158: iconst_0
    //   159: aload_1
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: aload 4
    //   165: aastore
    //   166: invokestatic 154	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   169: goto +5 -> 174
    //   172: aload_3
    //   173: athrow
    //   174: goto -2 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	c
    //   0	177	1	paramInputStream	java.io.InputStream
    //   28	15	2	i	int
    //   11	67	3	localObject1	Object
    //   106	1	3	localObject2	Object
    //   120	53	3	localObject3	Object
    //   7	157	4	localObject4	Object
    //   17	82	5	arrayOfByte	byte[]
    //   101	1	5	localIOException1	java.io.IOException
    //   113	30	5	localIOException2	java.io.IOException
    //   145	6	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   12	19	101	java/io/IOException
    //   22	29	101	java/io/IOException
    //   37	46	101	java/io/IOException
    //   52	57	101	java/io/IOException
    //   60	67	101	java/io/IOException
    //   70	75	101	java/io/IOException
    //   78	82	101	java/io/IOException
    //   0	9	106	finally
    //   0	9	113	java/io/IOException
    //   12	19	145	finally
    //   22	29	145	finally
    //   37	46	145	finally
    //   52	57	145	finally
    //   60	67	145	finally
    //   70	75	145	finally
    //   78	82	145	finally
    //   121	126	145	finally
  }
  
  private byte[] buildBody(f paramf)
  {
    int i = b.a[paramf.a().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return null;
        }
        return paramf.f().getBytes("UTF-8");
      }
      return com.tencent.beacon.base.net.c.d.b(paramf.d()).getBytes("UTF-8");
    }
    return paramf.c();
  }
  
  public void request(f paramf, b<com.tencent.beacon.base.net.a> paramb)
  {
    String str = paramf.h();
    try
    {
      localObject = buildBody(paramf);
      paramf = a(paramf.i(), paramf.g().name(), paramf.e(), (byte[])localObject);
      if (paramf.b != 200)
      {
        int i = paramf.b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("response status code != 2XX. msg: ");
        ((StringBuilder)localObject).append(paramf.c);
        paramb.a(new e(str, "452", i, ((StringBuilder)localObject).toString()));
        return;
      }
      paramb.a(paramf);
      return;
    }
    catch (Throwable paramf)
    {
      com.tencent.beacon.base.util.c.a(paramf);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https connect error: ");
      ((StringBuilder)localObject).append(paramf.getMessage());
      paramb.a(new e(str, "499", -1, ((StringBuilder)localObject).toString(), paramf));
      return;
    }
    catch (ConnectException paramf)
    {
      com.tencent.beacon.base.util.c.a(paramf);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https connect timeout: ");
      ((StringBuilder)localObject).append(paramf.getMessage());
      paramb.a(new e(str, "451", -1, ((StringBuilder)localObject).toString(), paramf));
    }
  }
  
  public void request(k paramk, b<byte[]> paramb)
  {
    String str = paramk.g().name();
    try
    {
      localObject = paramk.h();
      paramk = a((String)localObject, "POST", paramk.d(), paramk.b());
      int i;
      if (paramk.b != 200)
      {
        i = paramk.b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("response status code != 2XX. msg: ");
        ((StringBuilder)localObject).append(paramk.c);
        paramb.a(new e(str, "452", i, ((StringBuilder)localObject).toString()));
        return;
      }
      if (!com.tencent.beacon.base.net.c.d.a(paramk.a))
      {
        i = paramk.b;
        paramb.a(new e(str, "454", i, "server encrypt-status error!"));
        return;
      }
      paramb.a(paramk.d);
      return;
    }
    catch (Throwable paramk)
    {
      com.tencent.beacon.base.util.c.a(paramk);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https connect error: ");
      ((StringBuilder)localObject).append(paramk.getMessage());
      paramb.a(new e(str, "499", -1, ((StringBuilder)localObject).toString(), paramk));
      com.tencent.beacon.base.net.d.c().b(this);
      return;
    }
    catch (ConnectException paramk)
    {
      com.tencent.beacon.base.util.c.a(paramk);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https connect timeout: ");
      ((StringBuilder)localObject).append(paramk.getMessage());
      paramb.a(new e(str, "451", -1, ((StringBuilder)localObject).toString(), paramk));
      com.tencent.beacon.base.net.d.c().b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.adapter.c
 * JD-Core Version:    0.7.0.1
 */