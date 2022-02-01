package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import junit.framework.a;

public class w
  extends g
  implements IWxaFileSystemWithModularizing
{
  private final i a;
  private Map<String, Long> b = new HashMap();
  
  public w(@NonNull h paramh)
  {
    a.a(paramh instanceof i);
    this.a = ((i)paramh);
  }
  
  private j b(String paramString, FileStructStat paramFileStructStat)
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
    if (l(paramString) == j.g)
    {
      localObject = this.a.a(paramString);
      if (localObject != null)
      {
        ((v)localObject).a().fillAnother(paramFileStructStat);
        paramFileStructStat.makeItIsDir();
        paramFileStructStat.st_size = 0L;
        paramString = (Long)this.b.get(paramString);
        if (paramString != null) {
          paramFileStructStat.st_atime = paramString.longValue();
        }
        return j.a;
      }
    }
    return j.g;
  }
  
  private j l(String paramString)
  {
    if (!this.a.d(paramString)) {
      return j.g;
    }
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
    if (!((String)localObject).contains("\\"))
    {
      paramString = (String)localObject;
      if (!((String)localObject).trim().isEmpty())
      {
        while (!paramString.equals("")) {
          if (!paramString.endsWith("/"))
          {
            paramString = paramString.substring(0, paramString.lastIndexOf("/"));
            if (paramString.equals(""))
            {
              this.b.put("/", Long.valueOf(System.currentTimeMillis() / 1000L));
            }
            else
            {
              localObject = this.b;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramString);
              localStringBuilder.append("/");
              ((Map)localObject).put(localStringBuilder.toString(), Long.valueOf(System.currentTimeMillis() / 1000L));
            }
          }
          else
          {
            o.b("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramString });
          }
        }
        return;
      }
    }
    o.b("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { localObject });
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
    paramString = this.a.c(paramString);
    if (paramString == null) {
      return null;
    }
    paramString = m.a(paramString.g, paramString.i);
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
    //   1: getfield 31	com/tencent/mm/plugin/appbrand/appcache/w:a	Lcom/tencent/mm/plugin/appbrand/appcache/i;
    //   4: aload_1
    //   5: invokeinterface 199 2 0
    //   10: astore 8
    //   12: aload 8
    //   14: ifnonnull +7 -> 21
    //   17: getstatic 66	com/tencent/mm/plugin/appbrand/appstorage/j:g	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   20: areturn
    //   21: aload_0
    //   22: lload_2
    //   23: lload 4
    //   25: aload 8
    //   27: invokevirtual 205	java/io/InputStream:available	()I
    //   30: i2l
    //   31: invokevirtual 208	com/tencent/mm/plugin/appbrand/appcache/w:a	(JJJ)Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   34: astore 9
    //   36: getstatic 104	com/tencent/mm/plugin/appbrand/appstorage/j:a	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   39: astore 10
    //   41: aload 9
    //   43: aload 10
    //   45: if_acmpeq +11 -> 56
    //   48: aload 8
    //   50: invokestatic 213	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   53: aload 9
    //   55: areturn
    //   56: lload 4
    //   58: ldc2_w 214
    //   61: lcmp
    //   62: ifne +159 -> 221
    //   65: aload 8
    //   67: invokevirtual 205	java/io/InputStream:available	()I
    //   70: i2l
    //   71: lload_2
    //   72: lsub
    //   73: lstore 4
    //   75: goto +3 -> 78
    //   78: aload 8
    //   80: invokevirtual 205	java/io/InputStream:available	()I
    //   83: invokestatic 221	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   86: astore 9
    //   88: lload_2
    //   89: lconst_0
    //   90: lcmp
    //   91: ifne +133 -> 224
    //   94: lload 4
    //   96: aload 8
    //   98: invokevirtual 205	java/io/InputStream:available	()I
    //   101: i2l
    //   102: lcmp
    //   103: ifne +121 -> 224
    //   106: iconst_1
    //   107: istore 7
    //   109: goto +3 -> 112
    //   112: iload 7
    //   114: ifeq +28 -> 142
    //   117: aload 8
    //   119: instanceof 223
    //   122: ifeq +20 -> 142
    //   125: aload 9
    //   127: aload 8
    //   129: checkcast 223	com/tencent/luggage/util/a
    //   132: invokevirtual 226	com/tencent/luggage/util/a:b	()Ljava/nio/ByteBuffer;
    //   135: invokevirtual 229	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   138: pop
    //   139: goto +20 -> 159
    //   142: aload 9
    //   144: aload 8
    //   146: lload_2
    //   147: lload 4
    //   149: invokestatic 234	com/tencent/luggage/wxa/pc/c:a	(Ljava/io/InputStream;JJ)[B
    //   152: invokestatic 238	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   155: invokevirtual 229	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   158: pop
    //   159: aload 9
    //   161: invokevirtual 242	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   164: pop
    //   165: aload 6
    //   167: aload 9
    //   169: putfield 247	com/tencent/luggage/wxa/pc/i:a	Ljava/lang/Object;
    //   172: aload_0
    //   173: aload_1
    //   174: invokespecial 249	com/tencent/mm/plugin/appbrand/appcache/w:m	(Ljava/lang/String;)V
    //   177: getstatic 104	com/tencent/mm/plugin/appbrand/appstorage/j:a	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   180: astore_1
    //   181: aload 8
    //   183: invokestatic 213	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   186: aload_1
    //   187: areturn
    //   188: astore_1
    //   189: goto +25 -> 214
    //   192: astore_1
    //   193: ldc 153
    //   195: aload_1
    //   196: ldc 251
    //   198: iconst_0
    //   199: anewarray 157	java/lang/Object
    //   202: invokestatic 254	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: aload 8
    //   207: invokestatic 213	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   210: getstatic 256	com/tencent/mm/plugin/appbrand/appstorage/j:b	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   213: areturn
    //   214: aload 8
    //   216: invokestatic 213	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   219: aload_1
    //   220: athrow
    //   221: goto -143 -> 78
    //   224: iconst_0
    //   225: istore 7
    //   227: goto -115 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	w
    //   0	230	1	paramString	String
    //   0	230	2	paramLong1	long
    //   0	230	4	paramLong2	long
    //   0	230	6	parami	com.tencent.luggage.wxa.pc.i<java.nio.ByteBuffer>
    //   107	119	7	i	int
    //   10	205	8	localInputStream	java.io.InputStream
    //   34	134	9	localObject	Object
    //   39	5	10	localj	j
    // Exception table:
    //   from	to	target	type
    //   21	41	188	finally
    //   65	75	188	finally
    //   78	88	188	finally
    //   94	106	188	finally
    //   117	139	188	finally
    //   142	159	188	finally
    //   159	181	188	finally
    //   193	205	188	finally
    //   21	41	192	java/lang/Exception
    //   65	75	192	java/lang/Exception
    //   78	88	192	java/lang/Exception
    //   94	106	192	java/lang/Exception
    //   117	139	192	java/lang/Exception
    //   142	159	192	java/lang/Exception
    //   159	181	192	java/lang/Exception
  }
  
  @NonNull
  public j a(String paramString, com.tencent.luggage.wxa.pc.i<List<com.tencent.mm.plugin.appbrand.appstorage.h>> parami)
  {
    if (l(paramString) == j.a) {
      return j.i;
    }
    String str1 = k.b(paramString);
    paramString = this.a.c();
    String str2 = Pattern.quote(str1);
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      paramString = (String)localIterator.next();
      if (af.b(paramString).startsWith(str1))
      {
        paramString = paramString.replaceFirst(str2, "");
        if (paramString.split("/").length <= 1)
        {
          com.tencent.mm.plugin.appbrand.appstorage.h localh = new com.tencent.mm.plugin.appbrand.appstorage.h();
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
    h.a locala = this.a.c(paramString);
    if (locala == null) {
      return b(paramString, paramFileStructStat);
    }
    locala.g.a().fillAnother(paramFileStructStat);
    paramFileStructStat.st_size = locala.k;
    return j.a;
  }
  
  @NonNull
  public j a(String paramString, List<com.tencent.mm.plugin.appbrand.appstorage.v> paramList)
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
      localObject = this.a.c().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        if ((str1 != null) && (str1.startsWith(paramString)))
        {
          com.tencent.mm.plugin.appbrand.appstorage.v localv = new com.tencent.mm.plugin.appbrand.appstorage.v(str1);
          String str2 = a(str1, localv).name();
          if (str2.equals(j.a.name())) {
            paramList.add(localv);
          } else {
            o.c("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "statDir: stat [%s] fail:[%s]", new Object[] { str1, str2 });
          }
        }
      }
      return j.a;
    }
    o.b("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "statDir: path = [%s] is illegal", new Object[] { paramString });
    return super.a(paramString, paramList);
  }
  
  public void a() {}
  
  public boolean a(String paramString)
  {
    try
    {
      this.a.e(paramString);
      return true;
    }
    catch (IllegalArgumentException paramString)
    {
      label13:
      break label13;
    }
    return false;
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
      Iterator localIterator = this.a.c().iterator();
      do
      {
        localObject = localj;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!af.b((String)localIterator.next()).startsWith(paramString));
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
    //   1: getfield 31	com/tencent/mm/plugin/appbrand/appcache/w:a	Lcom/tencent/mm/plugin/appbrand/appcache/i;
    //   4: aload_1
    //   5: invokeinterface 199 2 0
    //   10: astore 4
    //   12: aload 4
    //   14: ifnonnull +7 -> 21
    //   17: getstatic 66	com/tencent/mm/plugin/appbrand/appstorage/j:g	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   20: areturn
    //   21: aload 4
    //   23: invokevirtual 205	java/io/InputStream:available	()I
    //   26: istore_3
    //   27: aload 4
    //   29: invokestatic 213	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   32: aload_0
    //   33: aload_1
    //   34: lconst_0
    //   35: iload_3
    //   36: i2l
    //   37: aload_2
    //   38: invokevirtual 349	com/tencent/mm/plugin/appbrand/appcache/w:a	(Ljava/lang/String;JJLcom/tencent/luggage/wxa/pc/i;)Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   41: areturn
    //   42: astore_1
    //   43: goto +27 -> 70
    //   46: astore_1
    //   47: ldc 153
    //   49: aload_1
    //   50: ldc 251
    //   52: iconst_0
    //   53: anewarray 157	java/lang/Object
    //   56: invokestatic 254	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: getstatic 256	com/tencent/mm/plugin/appbrand/appstorage/j:b	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   62: astore_1
    //   63: aload 4
    //   65: invokestatic 213	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   68: aload_1
    //   69: areturn
    //   70: aload 4
    //   72: invokestatic 213	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	w
    //   0	77	1	paramString	String
    //   0	77	2	parami	com.tencent.luggage.wxa.pc.i<java.nio.ByteBuffer>
    //   26	10	3	i	int
    //   10	61	4	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   21	27	42	finally
    //   47	63	42	finally
    //   21	27	46	java/io/IOException
  }
  
  public void b()
  {
    this.a.close();
  }
  
  @NonNull
  public j c(String paramString)
  {
    return a(paramString, new com.tencent.luggage.wxa.pc.i());
  }
  
  @Nullable
  public v.a openReadPartialInfo(String paramString)
  {
    paramString = this.a.c(paramString);
    if (paramString != null) {
      return paramString.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.w
 * JD-Core Version:    0.7.0.1
 */