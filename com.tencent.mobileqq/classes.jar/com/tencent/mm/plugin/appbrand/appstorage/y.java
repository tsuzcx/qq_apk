package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.m;
import com.tencent.mm.plugin.appbrand.appcache.v.a;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Deprecated
public final class y
  extends g
{
  private final com.tencent.mm.plugin.appbrand.appcache.v b;
  private Map<String, Long> c = new HashMap();
  
  public y(@NonNull com.tencent.mm.plugin.appbrand.appcache.v paramv)
  {
    if ((!a) && (paramv == null)) {
      throw new AssertionError();
    }
    this.b = paramv;
  }
  
  private j b(String paramString, FileStructStat paramFileStructStat)
  {
    StringBuilder localStringBuilder;
    if (!paramString.endsWith("/"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("/");
      paramString = localStringBuilder.toString();
    }
    if (!paramString.startsWith("/"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
    }
    if ((l(paramString) == j.g) && (b(paramString) == j.a))
    {
      this.b.a().fillAnother(paramFileStructStat);
      paramFileStructStat.makeItIsDir();
      paramFileStructStat.st_size = 0L;
      paramString = (Long)this.c.get(paramString);
      if (paramString != null) {
        paramFileStructStat.st_atime = paramString.longValue();
      }
      return j.a;
    }
    return j.g;
  }
  
  private j l(String paramString)
  {
    paramString = this.b.c(paramString);
    if (paramString == null) {
      return j.g;
    }
    af.a(paramString);
    return j.a;
  }
  
  private void m(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.startsWith("/"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    if ((!((String)localObject).contains("\\")) && (!((String)localObject).trim().isEmpty()))
    {
      paramString = n((String)localObject).iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        this.c.put(localObject, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
      return;
    }
    o.b("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { localObject });
  }
  
  private List<String> n(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    while (!paramString.equals("")) {
      if (!paramString.endsWith("/"))
      {
        paramString = paramString.substring(0, paramString.lastIndexOf("/"));
        if (paramString.equals(""))
        {
          localArrayList.add("/");
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("/");
          localArrayList.add(localStringBuilder.toString());
        }
      }
      else
      {
        o.b("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: file = [%s] is illegal", new Object[] { paramString });
      }
    }
    return localArrayList;
  }
  
  @Nullable
  public com.tencent.luggage.wxa.rt.i a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      int i;
      if (c(paramString) == j.a) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return null;
      }
    }
    paramString = m.a(this.b, paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return new com.tencent.luggage.wxa.rt.i(paramString);
    }
    return null;
  }
  
  /* Error */
  @NonNull
  public j a(String paramString, long paramLong1, long paramLong2, com.tencent.luggage.wxa.pc.i<java.nio.ByteBuffer> parami)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/mm/plugin/appbrand/appstorage/y:b	Lcom/tencent/mm/plugin/appbrand/appcache/v;
    //   4: aload_1
    //   5: invokevirtual 112	com/tencent/mm/plugin/appbrand/appcache/v:c	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore 8
    //   10: aload 8
    //   12: ifnonnull +7 -> 19
    //   15: getstatic 72	com/tencent/mm/plugin/appbrand/appstorage/j:g	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   18: areturn
    //   19: aload_0
    //   20: lload_2
    //   21: lload 4
    //   23: aload 8
    //   25: invokevirtual 227	java/io/InputStream:available	()I
    //   28: i2l
    //   29: invokevirtual 230	com/tencent/mm/plugin/appbrand/appstorage/y:a	(JJJ)Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   32: astore 9
    //   34: getstatic 76	com/tencent/mm/plugin/appbrand/appstorage/j:a	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   37: astore 10
    //   39: aload 9
    //   41: aload 10
    //   43: if_acmpeq +11 -> 54
    //   46: aload 8
    //   48: invokestatic 117	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   51: aload 9
    //   53: areturn
    //   54: lload 4
    //   56: ldc2_w 231
    //   59: lcmp
    //   60: ifne +160 -> 220
    //   63: aload 8
    //   65: invokevirtual 227	java/io/InputStream:available	()I
    //   68: i2l
    //   69: lload_2
    //   70: lsub
    //   71: lstore 4
    //   73: goto +3 -> 76
    //   76: aload 8
    //   78: invokevirtual 227	java/io/InputStream:available	()I
    //   81: invokestatic 238	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   84: astore 9
    //   86: lload_2
    //   87: lconst_0
    //   88: lcmp
    //   89: ifne +134 -> 223
    //   92: lload 4
    //   94: aload 8
    //   96: invokevirtual 227	java/io/InputStream:available	()I
    //   99: i2l
    //   100: lcmp
    //   101: ifne +122 -> 223
    //   104: iconst_1
    //   105: istore 7
    //   107: goto +3 -> 110
    //   110: iload 7
    //   112: ifeq +28 -> 140
    //   115: aload 8
    //   117: instanceof 240
    //   120: ifeq +20 -> 140
    //   123: aload 9
    //   125: aload 8
    //   127: checkcast 240	com/tencent/luggage/util/a
    //   130: invokevirtual 243	com/tencent/luggage/util/a:b	()Ljava/nio/ByteBuffer;
    //   133: invokevirtual 246	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   136: pop
    //   137: goto +20 -> 157
    //   140: aload 9
    //   142: aload 8
    //   144: lload_2
    //   145: lload 4
    //   147: invokestatic 251	com/tencent/luggage/wxa/pc/c:a	(Ljava/io/InputStream;JJ)[B
    //   150: invokestatic 255	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   153: invokevirtual 246	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   156: pop
    //   157: aload 9
    //   159: invokevirtual 259	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   162: pop
    //   163: aload 6
    //   165: aload 9
    //   167: putfield 264	com/tencent/luggage/wxa/pc/i:a	Ljava/lang/Object;
    //   170: aload_0
    //   171: aload_1
    //   172: invokespecial 266	com/tencent/mm/plugin/appbrand/appstorage/y:m	(Ljava/lang/String;)V
    //   175: getstatic 76	com/tencent/mm/plugin/appbrand/appstorage/j:a	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   178: astore_1
    //   179: aload 8
    //   181: invokestatic 117	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   184: aload_1
    //   185: areturn
    //   186: astore_1
    //   187: goto +26 -> 213
    //   190: astore_1
    //   191: ldc 167
    //   193: aload_1
    //   194: ldc_w 268
    //   197: iconst_0
    //   198: anewarray 171	java/lang/Object
    //   201: invokestatic 271	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload 8
    //   206: invokestatic 117	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   209: getstatic 273	com/tencent/mm/plugin/appbrand/appstorage/j:b	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   212: areturn
    //   213: aload 8
    //   215: invokestatic 117	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   218: aload_1
    //   219: athrow
    //   220: goto -144 -> 76
    //   223: iconst_0
    //   224: istore 7
    //   226: goto -116 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	y
    //   0	229	1	paramString	String
    //   0	229	2	paramLong1	long
    //   0	229	4	paramLong2	long
    //   0	229	6	parami	com.tencent.luggage.wxa.pc.i<java.nio.ByteBuffer>
    //   105	120	7	i	int
    //   8	206	8	localInputStream	InputStream
    //   32	134	9	localObject	Object
    //   37	5	10	localj	j
    // Exception table:
    //   from	to	target	type
    //   19	39	186	finally
    //   63	73	186	finally
    //   76	86	186	finally
    //   92	104	186	finally
    //   115	137	186	finally
    //   140	157	186	finally
    //   157	179	186	finally
    //   191	204	186	finally
    //   19	39	190	java/lang/Exception
    //   63	73	190	java/lang/Exception
    //   76	86	190	java/lang/Exception
    //   92	104	190	java/lang/Exception
    //   115	137	190	java/lang/Exception
    //   140	157	190	java/lang/Exception
    //   157	179	190	java/lang/Exception
  }
  
  @NonNull
  public j a(String paramString, com.tencent.luggage.wxa.pc.i<List<h>> parami)
  {
    if (l(paramString) == j.a) {
      return j.i;
    }
    String str1 = k.b(paramString);
    paramString = this.b.f();
    String str2 = Pattern.quote(str1);
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      paramString = (v.a)localIterator.next();
      if (paramString.b.startsWith(str1))
      {
        paramString = paramString.b.replaceFirst(str2, "");
        if (paramString.split("/").length <= 1)
        {
          h localh = new h();
          localh.a = paramString;
          if (parami.a == null) {
            paramString = new LinkedList();
          } else {
            paramString = (List)parami.a;
          }
          parami.a = paramString;
          ((List)parami.a).add(localh);
        }
      }
    }
    if (parami.a == null) {
      return j.g;
    }
    return j.a;
  }
  
  @NonNull
  public j a(String paramString, FileStructStat paramFileStructStat)
  {
    InputStream localInputStream = this.b.c(paramString);
    if (localInputStream == null) {
      return b(paramString, paramFileStructStat);
    }
    this.b.a().fillAnother(paramFileStructStat);
    for (;;)
    {
      try
      {
        try
        {
          paramFileStructStat.st_size = localInputStream.available();
          af.a(localInputStream);
        }
        finally
        {
          continue;
        }
      }
      catch (Exception paramFileStructStat)
      {
        continue;
      }
      o.b("MicroMsg.WxaPkgFileSystem", "stat(), %s stream.available fail", new Object[] { paramString });
    }
    return j.a;
    af.a(localInputStream);
    for (;;)
    {
      throw paramString;
    }
  }
  
  @NonNull
  public j a(String paramString, List<v> paramList)
  {
    Object localObject;
    if (!paramString.endsWith("/"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("/");
      paramString = ((StringBuilder)localObject).toString();
    }
    if (!paramString.startsWith("/"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
    }
    if ((!paramString.contains("\\")) && (!paramString.trim().isEmpty()))
    {
      localObject = this.b.g().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        if (str1.startsWith(paramString))
        {
          v localv = new v(str1);
          String str2 = a(str1, localv).name();
          if (str2.equals(j.a.name())) {
            paramList.add(localv);
          } else {
            o.c("MicroMsg.WxaPkgFileSystem", "statDir: stat [%s] fail:[%s]", new Object[] { str1, str2 });
          }
        }
      }
      return j.a;
    }
    o.b("MicroMsg.WxaPkgFileSystem", "statDir: path = [%s] is illegal", new Object[] { paramString });
    return super.a(paramString, paramList);
  }
  
  public void a()
  {
    this.b.e();
  }
  
  public boolean a(String paramString)
  {
    return true;
  }
  
  @NonNull
  public j b(String paramString)
  {
    j localj = l(paramString);
    Object localObject = localj;
    if (localj == j.g)
    {
      if (paramString.length() == 0) {
        return j.g;
      }
      localObject = k.b(paramString);
      paramString = (String)localObject;
      if (!((String)localObject).substring(((String)localObject).length() - 1).equals("/"))
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject);
        paramString.append("/");
        paramString = paramString.toString();
      }
      Iterator localIterator = this.b.f().iterator();
      do
      {
        localObject = localj;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((v.a)localIterator.next()).b.startsWith(paramString));
      localObject = j.a;
    }
    return localObject;
  }
  
  /* Error */
  @NonNull
  public j b(String paramString, com.tencent.luggage.wxa.pc.i<java.nio.ByteBuffer> parami)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/mm/plugin/appbrand/appstorage/y:b	Lcom/tencent/mm/plugin/appbrand/appcache/v;
    //   4: aload_1
    //   5: invokevirtual 112	com/tencent/mm/plugin/appbrand/appcache/v:c	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore 4
    //   10: aload 4
    //   12: ifnonnull +7 -> 19
    //   15: getstatic 72	com/tencent/mm/plugin/appbrand/appstorage/j:g	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   18: areturn
    //   19: aload 4
    //   21: invokevirtual 227	java/io/InputStream:available	()I
    //   24: istore_3
    //   25: aload 4
    //   27: invokestatic 117	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   30: aload_0
    //   31: aload_1
    //   32: lconst_0
    //   33: iload_3
    //   34: i2l
    //   35: aload_2
    //   36: invokevirtual 351	com/tencent/mm/plugin/appbrand/appstorage/y:a	(Ljava/lang/String;JJLcom/tencent/luggage/wxa/pc/i;)Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   39: areturn
    //   40: astore_1
    //   41: goto +28 -> 69
    //   44: astore_1
    //   45: ldc 167
    //   47: aload_1
    //   48: ldc_w 268
    //   51: iconst_0
    //   52: anewarray 171	java/lang/Object
    //   55: invokestatic 271	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: getstatic 273	com/tencent/mm/plugin/appbrand/appstorage/j:b	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   61: astore_1
    //   62: aload 4
    //   64: invokestatic 117	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   67: aload_1
    //   68: areturn
    //   69: aload 4
    //   71: invokestatic 117	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	y
    //   0	76	1	paramString	String
    //   0	76	2	parami	com.tencent.luggage.wxa.pc.i<java.nio.ByteBuffer>
    //   24	10	3	i	int
    //   8	62	4	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   19	25	40	finally
    //   45	62	40	finally
    //   19	25	44	java/io/IOException
  }
  
  public void b()
  {
    this.b.close();
  }
  
  @NonNull
  public j c(String paramString)
  {
    return a(paramString, new com.tencent.luggage.wxa.pc.i());
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.v d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.y
 * JD-Core Version:    0.7.0.1
 */