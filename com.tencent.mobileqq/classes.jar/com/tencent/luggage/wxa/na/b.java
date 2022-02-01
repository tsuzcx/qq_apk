package com.tencent.luggage.wxa.na;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.e;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.zip.ZipInputStream;

public class b
{
  private static ConcurrentMap<String, Boolean> a = new ConcurrentHashMap();
  private static Map<String, List<b.a>> b = new HashMap();
  private static final String c;
  
  static
  {
    Object localObject2 = com.tencent.luggage.wxa.hz.a.d();
    Object localObject1 = localObject2;
    if (!((String)localObject2).endsWith("/"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("wxacache/");
    c = ((StringBuilder)localObject2).toString();
    e.a(c);
  }
  
  @Nullable
  private static d a(com.tencent.luggage.wxa.jx.c paramc)
  {
    if (paramc == null)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, component is null");
      return null;
    }
    if (!(paramc instanceof h))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, can not get runtime from component");
      return null;
    }
    paramc = ((h)paramc).q();
    if (paramc == null) {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, runtime is null");
    }
    return paramc;
  }
  
  private static String a(String paramString)
  {
    if (!af.c(paramString)) {
      return com.tencent.luggage.wxa.gl.c.a(paramString.getBytes());
    }
    return null;
  }
  
  public static void a(com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2, b.a parama)
  {
    a(paramc, paramString1, false, paramString2, parama);
  }
  
  public static void a(com.tencent.luggage.wxa.jx.c paramc, String paramString1, boolean paramBoolean, String paramString2, b.a parama)
  {
    if (af.c(paramString1)) {
      return;
    }
    if (parama == null) {
      return;
    }
    if (paramString1.startsWith("wxfile://"))
    {
      if (!b(paramc, paramString1, paramBoolean, paramString2, parama)) {
        a(parama);
      }
    }
    else if ((!paramString1.startsWith("http://")) && (!paramString1.startsWith("https://")))
    {
      if (!c(paramc, paramString1, paramBoolean, paramString2, parama)) {
        a(parama);
      }
    }
    else {
      d(paramc, paramString1, paramBoolean, paramString2, parama);
    }
  }
  
  private static void a(b.a parama)
  {
    if (parama != null) {
      parama.a(null);
    }
  }
  
  /* Error */
  private static void a(String paramString, i parami)
  {
    // Byte code:
    //   0: new 132	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 134	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 138	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 140	java/net/HttpURLConnection
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 144	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   19: astore 5
    //   21: aload_1
    //   22: invokestatic 149	com/tencent/luggage/wxa/rt/k:b	(Lcom/tencent/luggage/wxa/rt/i;)Ljava/io/OutputStream;
    //   25: astore 4
    //   27: new 151	java/io/BufferedInputStream
    //   30: dup
    //   31: aload 5
    //   33: invokespecial 154	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore 6
    //   38: aload_3
    //   39: astore 7
    //   41: aload 4
    //   43: astore 8
    //   45: aload 6
    //   47: astore 9
    //   49: sipush 16384
    //   52: newarray byte
    //   54: astore 5
    //   56: aload_3
    //   57: astore 7
    //   59: aload 4
    //   61: astore 8
    //   63: aload 6
    //   65: astore 9
    //   67: aload 6
    //   69: aload 5
    //   71: iconst_0
    //   72: aload 5
    //   74: arraylength
    //   75: invokevirtual 160	java/io/InputStream:read	([BII)I
    //   78: istore_2
    //   79: iload_2
    //   80: iconst_m1
    //   81: if_icmpeq +26 -> 107
    //   84: aload_3
    //   85: astore 7
    //   87: aload 4
    //   89: astore 8
    //   91: aload 6
    //   93: astore 9
    //   95: aload 4
    //   97: aload 5
    //   99: iconst_0
    //   100: iload_2
    //   101: invokevirtual 166	java/io/OutputStream:write	([BII)V
    //   104: goto -48 -> 56
    //   107: aload_3
    //   108: astore 7
    //   110: aload 4
    //   112: astore 8
    //   114: aload 6
    //   116: astore 9
    //   118: aload 4
    //   120: invokevirtual 169	java/io/OutputStream:flush	()V
    //   123: aload_3
    //   124: invokevirtual 144	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   127: invokevirtual 172	java/io/InputStream:close	()V
    //   130: aload_3
    //   131: astore 5
    //   133: goto +155 -> 288
    //   136: astore_0
    //   137: goto +139 -> 276
    //   140: astore 10
    //   142: aload_3
    //   143: astore 5
    //   145: aload 6
    //   147: astore_3
    //   148: goto +63 -> 211
    //   151: astore_0
    //   152: aconst_null
    //   153: astore 9
    //   155: goto +157 -> 312
    //   158: astore 5
    //   160: goto +12 -> 172
    //   163: astore_0
    //   164: goto +27 -> 191
    //   167: astore 5
    //   169: aconst_null
    //   170: astore 4
    //   172: aconst_null
    //   173: astore 6
    //   175: aload 5
    //   177: astore 10
    //   179: aload_3
    //   180: astore 5
    //   182: aload 6
    //   184: astore_3
    //   185: goto +26 -> 211
    //   188: astore_0
    //   189: aconst_null
    //   190: astore_3
    //   191: aconst_null
    //   192: astore 4
    //   194: aconst_null
    //   195: astore 9
    //   197: goto +115 -> 312
    //   200: astore 10
    //   202: aconst_null
    //   203: astore 4
    //   205: aload 4
    //   207: astore_3
    //   208: aload_3
    //   209: astore 5
    //   211: aload 5
    //   213: astore 7
    //   215: aload 4
    //   217: astore 8
    //   219: aload_3
    //   220: astore 9
    //   222: aload_1
    //   223: invokevirtual 178	com/tencent/luggage/wxa/rt/i:w	()Z
    //   226: pop
    //   227: aload 5
    //   229: astore 7
    //   231: aload 4
    //   233: astore 8
    //   235: aload_3
    //   236: astore 9
    //   238: ldc 63
    //   240: aload 10
    //   242: ldc 180
    //   244: iconst_1
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload_0
    //   251: aastore
    //   252: invokestatic 183	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: aload 5
    //   257: invokevirtual 144	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   260: invokevirtual 172	java/io/InputStream:close	()V
    //   263: aload_3
    //   264: astore 6
    //   266: goto +22 -> 288
    //   269: astore_0
    //   270: aload_3
    //   271: astore 6
    //   273: aload 5
    //   275: astore_3
    //   276: ldc 63
    //   278: aload_0
    //   279: invokevirtual 186	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   282: invokestatic 188	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_3
    //   286: astore 5
    //   288: aload 4
    //   290: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   293: aload 6
    //   295: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   298: aload 5
    //   300: invokevirtual 194	java/net/HttpURLConnection:disconnect	()V
    //   303: return
    //   304: astore_0
    //   305: aload 8
    //   307: astore 4
    //   309: aload 7
    //   311: astore_3
    //   312: aload_3
    //   313: invokevirtual 144	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   316: invokevirtual 172	java/io/InputStream:close	()V
    //   319: goto +13 -> 332
    //   322: astore_1
    //   323: ldc 63
    //   325: aload_1
    //   326: invokevirtual 186	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   329: invokestatic 188	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload 4
    //   334: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   337: aload 9
    //   339: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   342: aload_3
    //   343: invokevirtual 194	java/net/HttpURLConnection:disconnect	()V
    //   346: goto +5 -> 351
    //   349: aload_0
    //   350: athrow
    //   351: goto -2 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramString	String
    //   0	354	1	parami	i
    //   78	23	2	i	int
    //   14	329	3	localObject1	Object
    //   25	308	4	localObject2	Object
    //   19	125	5	localObject3	Object
    //   158	1	5	localException1	Exception
    //   167	9	5	localException2	Exception
    //   180	119	5	localObject4	Object
    //   36	258	6	localObject5	Object
    //   39	271	7	localObject6	Object
    //   43	263	8	localObject7	Object
    //   47	291	9	localObject8	Object
    //   140	1	10	localException3	Exception
    //   177	1	10	localException4	Exception
    //   200	41	10	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   123	130	136	java/lang/Exception
    //   49	56	140	java/lang/Exception
    //   67	79	140	java/lang/Exception
    //   95	104	140	java/lang/Exception
    //   118	123	140	java/lang/Exception
    //   27	38	151	finally
    //   27	38	158	java/lang/Exception
    //   15	27	163	finally
    //   15	27	167	java/lang/Exception
    //   0	15	188	finally
    //   0	15	200	java/lang/Exception
    //   255	263	269	java/lang/Exception
    //   49	56	304	finally
    //   67	79	304	finally
    //   95	104	304	finally
    //   118	123	304	finally
    //   222	227	304	finally
    //   238	255	304	finally
    //   312	319	322	java/lang/Exception
  }
  
  private static boolean a(String paramString, InputStream paramInputStream)
  {
    if (af.c(paramString))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid target nil, no check");
      return true;
    }
    paramInputStream = com.tencent.luggage.wxa.gl.c.a(paramInputStream, 4096);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid file:%s target:%s", new Object[] { paramInputStream, paramString });
    return paramString.equals(paramInputStream);
  }
  
  private static void b(com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2)
  {
    if (a.containsKey(paramString1))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "download ing: %s", new Object[] { paramString1 });
      return;
    }
    a.put(paramString1, Boolean.valueOf(true));
    paramc = c(paramc, paramString1, paramString2);
    a.remove(paramString1);
    if (paramc != null)
    {
      d(paramString1, paramc.l());
      return;
    }
    d(paramString1, null);
  }
  
  /* Error */
  private static boolean b(@NonNull com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2, b.a parama)
  {
    // Byte code:
    //   0: getstatic 249	com/tencent/luggage/wxa/na/f:a	Lcom/tencent/luggage/wxa/na/f;
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 252	com/tencent/luggage/wxa/na/f:a	(Lcom/tencent/luggage/wxa/jx/c;Ljava/lang/String;)Lcom/tencent/luggage/wxa/rt/i;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnonnull +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aconst_null
    //   18: astore 4
    //   20: aload_0
    //   21: invokeinterface 258 1 0
    //   26: aload_1
    //   27: invokeinterface 264 2 0
    //   32: astore 5
    //   34: aload 5
    //   36: ifnonnull +10 -> 46
    //   39: aload 5
    //   41: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload 5
    //   48: astore 4
    //   50: aload_2
    //   51: aload 5
    //   53: invokestatic 266	com/tencent/luggage/wxa/na/b:a	(Ljava/lang/String;Ljava/io/InputStream;)Z
    //   56: ifne +22 -> 78
    //   59: aload 5
    //   61: astore 4
    //   63: ldc 63
    //   65: ldc_w 268
    //   68: invokestatic 70	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload 5
    //   73: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   76: iconst_0
    //   77: ireturn
    //   78: aload 5
    //   80: astore_2
    //   81: aload 5
    //   83: astore 4
    //   85: getstatic 249	com/tencent/luggage/wxa/na/f:a	Lcom/tencent/luggage/wxa/na/f;
    //   88: aload 6
    //   90: invokevirtual 271	com/tencent/luggage/wxa/na/f:a	(Lcom/tencent/luggage/wxa/rt/i;)Z
    //   93: ifne +83 -> 176
    //   96: aload 5
    //   98: astore 4
    //   100: aload 5
    //   102: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   105: aload 5
    //   107: astore 4
    //   109: aload_0
    //   110: invokeinterface 258 1 0
    //   115: aload_1
    //   116: invokeinterface 264 2 0
    //   121: astore_0
    //   122: aload_0
    //   123: ifnonnull +9 -> 132
    //   126: aload_0
    //   127: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   130: iconst_0
    //   131: ireturn
    //   132: aload_0
    //   133: astore 4
    //   135: new 273	java/util/zip/ZipInputStream
    //   138: dup
    //   139: aload_0
    //   140: invokespecial 274	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   143: astore_0
    //   144: getstatic 249	com/tencent/luggage/wxa/na/f:a	Lcom/tencent/luggage/wxa/na/f;
    //   147: aload_0
    //   148: checkcast 273	java/util/zip/ZipInputStream
    //   151: aload 6
    //   153: invokevirtual 277	com/tencent/luggage/wxa/na/f:a	(Ljava/util/zip/ZipInputStream;Lcom/tencent/luggage/wxa/rt/i;)Lcom/tencent/luggage/wxa/rt/i;
    //   156: astore_1
    //   157: aload_1
    //   158: ifnonnull +9 -> 167
    //   161: aload_0
    //   162: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   165: iconst_0
    //   166: ireturn
    //   167: aload_0
    //   168: astore_2
    //   169: goto +7 -> 176
    //   172: astore_1
    //   173: goto +37 -> 210
    //   176: aload_3
    //   177: ifnull +23 -> 200
    //   180: aload_2
    //   181: astore 4
    //   183: aload_3
    //   184: aload 6
    //   186: invokevirtual 238	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   189: invokeinterface 127 2 0
    //   194: aload_2
    //   195: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   198: iconst_1
    //   199: ireturn
    //   200: aload_2
    //   201: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   204: iconst_0
    //   205: ireturn
    //   206: astore_1
    //   207: aload 4
    //   209: astore_0
    //   210: aload_0
    //   211: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   214: aload_1
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramc	com.tencent.luggage.wxa.jx.c
    //   0	216	1	paramString1	String
    //   0	216	2	paramString2	String
    //   0	216	3	parama	b.a
    //   18	190	4	localObject	Object
    //   32	74	5	localInputStream	InputStream
    //   8	177	6	locali	i
    // Exception table:
    //   from	to	target	type
    //   144	157	172	finally
    //   20	34	206	finally
    //   50	59	206	finally
    //   63	71	206	finally
    //   85	96	206	finally
    //   100	105	206	finally
    //   109	122	206	finally
    //   135	144	206	finally
    //   183	194	206	finally
  }
  
  private static boolean b(com.tencent.luggage.wxa.jx.c paramc, String paramString1, boolean paramBoolean, String paramString2, b.a parama)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, url:%s", new Object[] { paramString1 });
    if (paramc == null)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, component is null");
      return false;
    }
    if (paramBoolean) {
      return b(paramc, paramString1, paramString2, parama);
    }
    return c(paramc, paramString1, paramString2, parama);
  }
  
  @Nullable
  private static i c(com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2)
  {
    i locali = f.a.a(paramc, paramString1);
    if (locali == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(c);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramc.getAppId());
        localStringBuilder.append("_");
        localStringBuilder.append(paramString1);
        ((StringBuilder)localObject).append(a(localStringBuilder.toString()));
        paramc = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloadAndUnzipInner, cachedZipPath: ");
        ((StringBuilder)localObject).append(paramc);
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", ((StringBuilder)localObject).toString());
        localObject = new i(paramc);
        if (((i)localObject).j())
        {
          if (f(paramString2, paramc))
          {
            i = 0;
          }
          else
          {
            com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "downloadAndUnzipInner, cachedZipPath is invalid 1");
            ((i)localObject).w();
            break label279;
          }
          if (i != 0)
          {
            a(paramString1, (i)localObject);
            if (!f(paramString2, paramc))
            {
              com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "downloadAndUnzipInner, cachedZipPath is invalid 2");
              ((i)localObject).w();
              return null;
            }
          }
          if (!f.a.a(locali))
          {
            paramc = new ZipInputStream(k.a((i)localObject));
            if (f.a.a(paramc, locali) == null)
            {
              af.a(paramc);
              return null;
            }
          }
        }
      }
      catch (Exception paramc)
      {
        com.tencent.luggage.wxa.qz.o.a("MicroMsg.AppBrandLiveFileLoadHelper", paramc, "download file url %s ", new Object[] { paramString1 });
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "download done");
        return locali;
      }
      label279:
      int i = 1;
    }
  }
  
  private static void c(String paramString1, String paramString2)
  {
    String str = a(paramString1);
    str = String.format("%s%s", new Object[] { c, str });
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, localPath:%s", new Object[] { str });
    i locali = new i(str);
    if (locali.j())
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "download already exists: %s", new Object[] { paramString1 });
      if (f(paramString2, str))
      {
        d(paramString1, str);
        return;
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "download already exists, but md5 not valid. deleted:%b", new Object[] { Boolean.valueOf(locali.w()) });
    }
    if (a.containsKey(paramString1))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "download ing: %s", new Object[] { paramString1 });
      return;
    }
    a.put(paramString1, Boolean.valueOf(true));
    a(paramString1, locali);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "download done");
    a.remove(paramString1);
    if (f(paramString2, str))
    {
      d(paramString1, str);
      return;
    }
    com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandLiveFileLoadHelper", "download md5 not valid");
    d(paramString1, null);
  }
  
  private static boolean c(@NonNull com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2, b.a parama)
  {
    paramc = paramc.getFileSystem().g(paramString1);
    if (paramc == null) {
      return false;
    }
    if (paramc.j())
    {
      paramc = paramc.l();
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, localPath:%s", new Object[] { paramc });
      if ((f(paramString2, paramc)) && (parama != null))
      {
        parama.a(paramc);
        return true;
      }
    }
    return false;
  }
  
  private static boolean c(com.tencent.luggage.wxa.jx.c paramc, String paramString1, boolean paramBoolean, String paramString2, b.a parama)
  {
    if (paramBoolean) {
      return d(paramc, paramString1, paramString2, parama);
    }
    return e(paramc, paramString1, paramString2, parama);
  }
  
  private static void d(com.tencent.luggage.wxa.jx.c paramc, String paramString1, boolean paramBoolean, String paramString2, b.a parama)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, url:%s", new Object[] { paramString1 });
    t.a(new b.1(paramString1, parama));
    com.tencent.luggage.wxa.rd.a.b(new b.2(paramBoolean, paramc, paramString1, paramString2), "AppBrandLiveFileLoadHelperThread");
  }
  
  private static void d(String paramString1, String paramString2)
  {
    t.a(new b.3(paramString1, paramString2));
  }
  
  /* Error */
  private static boolean d(com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2, b.a parama)
  {
    // Byte code:
    //   0: ldc 63
    //   2: ldc_w 369
    //   5: iconst_1
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_1
    //   12: aastore
    //   13: invokestatic 207	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: getstatic 249	com/tencent/luggage/wxa/na/f:a	Lcom/tencent/luggage/wxa/na/f;
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 252	com/tencent/luggage/wxa/na/f:a	(Lcom/tencent/luggage/wxa/jx/c;Ljava/lang/String;)Lcom/tencent/luggage/wxa/rt/i;
    //   24: astore 6
    //   26: aload 6
    //   28: ifnonnull +5 -> 33
    //   31: iconst_0
    //   32: ireturn
    //   33: aload_0
    //   34: invokestatic 371	com/tencent/luggage/wxa/na/b:a	(Lcom/tencent/luggage/wxa/jx/c;)Lcom/tencent/luggage/wxa/iu/d;
    //   37: astore 7
    //   39: aload 7
    //   41: ifnonnull +13 -> 54
    //   44: ldc 63
    //   46: ldc_w 373
    //   49: invokestatic 70	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: iconst_0
    //   53: ireturn
    //   54: aload 7
    //   56: aload_1
    //   57: invokestatic 378	com/tencent/mm/plugin/appbrand/appcache/ad:c	(Lcom/tencent/luggage/wxa/iu/d;Ljava/lang/String;)Ljava/io/InputStream;
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +218 -> 282
    //   67: aload 5
    //   69: astore_0
    //   70: aload 5
    //   72: astore 4
    //   74: aload 5
    //   76: invokevirtual 382	java/io/InputStream:available	()I
    //   79: ifgt +6 -> 85
    //   82: goto +200 -> 282
    //   85: aload 5
    //   87: astore_0
    //   88: aload 5
    //   90: astore 4
    //   92: aload_2
    //   93: aload 5
    //   95: invokestatic 266	com/tencent/luggage/wxa/na/b:a	(Ljava/lang/String;Ljava/io/InputStream;)Z
    //   98: ifne +30 -> 128
    //   101: aload 5
    //   103: astore_0
    //   104: aload 5
    //   106: astore 4
    //   108: ldc 63
    //   110: ldc_w 384
    //   113: invokestatic 70	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload 5
    //   118: ifnull +8 -> 126
    //   121: aload 5
    //   123: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   126: iconst_0
    //   127: ireturn
    //   128: aload 5
    //   130: astore_2
    //   131: aload 5
    //   133: astore_0
    //   134: aload 5
    //   136: astore 4
    //   138: getstatic 249	com/tencent/luggage/wxa/na/f:a	Lcom/tencent/luggage/wxa/na/f;
    //   141: aload 6
    //   143: invokevirtual 271	com/tencent/luggage/wxa/na/f:a	(Lcom/tencent/luggage/wxa/rt/i;)Z
    //   146: ifne +88 -> 234
    //   149: aload 5
    //   151: astore_0
    //   152: aload 5
    //   154: astore 4
    //   156: aload 5
    //   158: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   161: aload 5
    //   163: astore_0
    //   164: aload 5
    //   166: astore 4
    //   168: aload 7
    //   170: aload_1
    //   171: invokestatic 378	com/tencent/mm/plugin/appbrand/appcache/ad:c	(Lcom/tencent/luggage/wxa/iu/d;Ljava/lang/String;)Ljava/io/InputStream;
    //   174: astore_1
    //   175: aload_1
    //   176: astore_0
    //   177: aload_1
    //   178: astore 4
    //   180: new 273	java/util/zip/ZipInputStream
    //   183: dup
    //   184: aload_1
    //   185: invokespecial 274	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   188: astore_1
    //   189: getstatic 249	com/tencent/luggage/wxa/na/f:a	Lcom/tencent/luggage/wxa/na/f;
    //   192: aload_1
    //   193: checkcast 273	java/util/zip/ZipInputStream
    //   196: aload 6
    //   198: invokevirtual 277	com/tencent/luggage/wxa/na/f:a	(Ljava/util/zip/ZipInputStream;Lcom/tencent/luggage/wxa/rt/i;)Lcom/tencent/luggage/wxa/rt/i;
    //   201: astore_0
    //   202: aload_0
    //   203: ifnonnull +9 -> 212
    //   206: aload_1
    //   207: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   210: iconst_0
    //   211: ireturn
    //   212: aload_1
    //   213: astore_2
    //   214: goto +20 -> 234
    //   217: astore_2
    //   218: aload_1
    //   219: astore_0
    //   220: aload_2
    //   221: astore_1
    //   222: goto +142 -> 364
    //   225: astore_0
    //   226: aload_1
    //   227: astore 4
    //   229: aload_0
    //   230: astore_1
    //   231: goto +78 -> 309
    //   234: aload_3
    //   235: ifnull +29 -> 264
    //   238: aload_2
    //   239: astore_0
    //   240: aload_2
    //   241: astore 4
    //   243: aload_3
    //   244: aload 6
    //   246: invokevirtual 238	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   249: invokeinterface 127 2 0
    //   254: aload_2
    //   255: ifnull +7 -> 262
    //   258: aload_2
    //   259: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   262: iconst_1
    //   263: ireturn
    //   264: aload_2
    //   265: ifnull +7 -> 272
    //   268: aload_2
    //   269: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   272: iconst_0
    //   273: ireturn
    //   274: astore_1
    //   275: goto +89 -> 364
    //   278: astore_1
    //   279: goto +30 -> 309
    //   282: aload 5
    //   284: astore_0
    //   285: aload 5
    //   287: astore 4
    //   289: ldc 63
    //   291: ldc_w 386
    //   294: invokestatic 70	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload 5
    //   299: ifnull +8 -> 307
    //   302: aload 5
    //   304: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   307: iconst_0
    //   308: ireturn
    //   309: aload 4
    //   311: astore_0
    //   312: new 42	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   319: astore_2
    //   320: aload 4
    //   322: astore_0
    //   323: aload_2
    //   324: ldc_w 388
    //   327: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 4
    //   333: astore_0
    //   334: aload_2
    //   335: aload_1
    //   336: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 4
    //   342: astore_0
    //   343: ldc 63
    //   345: aload_2
    //   346: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 329	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload 4
    //   354: ifnull +8 -> 362
    //   357: aload 4
    //   359: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   362: iconst_0
    //   363: ireturn
    //   364: aload_0
    //   365: ifnull +7 -> 372
    //   368: aload_0
    //   369: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   372: aload_1
    //   373: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramc	com.tencent.luggage.wxa.jx.c
    //   0	374	1	paramString1	String
    //   0	374	2	paramString2	String
    //   0	374	3	parama	b.a
    //   72	286	4	localObject	Object
    //   60	243	5	localInputStream	InputStream
    //   24	221	6	locali	i
    //   37	132	7	locald	d
    // Exception table:
    //   from	to	target	type
    //   189	202	217	finally
    //   189	202	225	java/lang/Exception
    //   74	82	274	finally
    //   92	101	274	finally
    //   108	116	274	finally
    //   138	149	274	finally
    //   156	161	274	finally
    //   168	175	274	finally
    //   180	189	274	finally
    //   243	254	274	finally
    //   289	297	274	finally
    //   312	320	274	finally
    //   323	331	274	finally
    //   334	340	274	finally
    //   343	352	274	finally
    //   74	82	278	java/lang/Exception
    //   92	101	278	java/lang/Exception
    //   108	116	278	java/lang/Exception
    //   138	149	278	java/lang/Exception
    //   156	161	278	java/lang/Exception
    //   168	175	278	java/lang/Exception
    //   180	189	278	java/lang/Exception
    //   243	254	278	java/lang/Exception
    //   289	297	278	java/lang/Exception
  }
  
  private static void e(String paramString1, String paramString2)
  {
    int i = 0;
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "doCallback url:%s, localPath:%s", new Object[] { paramString1, paramString2 });
    List localList = (List)b.get(paramString1);
    if ((localList != null) && (localList.size() != 0))
    {
      while (i < localList.size())
      {
        ((b.a)localList.get(i)).a(paramString2);
        i += 1;
      }
      b.remove(paramString1);
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "doCallback callbacks nil");
  }
  
  /* Error */
  private static boolean e(com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2, b.a parama)
  {
    // Byte code:
    //   0: ldc 63
    //   2: ldc_w 413
    //   5: iconst_1
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_1
    //   12: aastore
    //   13: invokestatic 207	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aload_0
    //   17: invokestatic 371	com/tencent/luggage/wxa/na/b:a	(Lcom/tencent/luggage/wxa/jx/c;)Lcom/tencent/luggage/wxa/iu/d;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnonnull +13 -> 37
    //   27: ldc 63
    //   29: ldc_w 415
    //   32: invokestatic 70	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_1
    //   38: invokestatic 418	com/tencent/mm/plugin/appbrand/appstorage/k:a	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_1
    //   42: aload_1
    //   43: invokestatic 86	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   46: ifeq +13 -> 59
    //   49: ldc 63
    //   51: ldc_w 420
    //   54: invokestatic 70	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iconst_0
    //   58: ireturn
    //   59: aload_1
    //   60: invokestatic 293	com/tencent/luggage/wxa/na/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   63: astore_0
    //   64: ldc_w 316
    //   67: iconst_2
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: getstatic 54	com/tencent/luggage/wxa/na/b:c	Ljava/lang/String;
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: aload_0
    //   80: aastore
    //   81: invokestatic 320	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   84: astore 6
    //   86: ldc 63
    //   88: ldc_w 422
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload 6
    //   99: aastore
    //   100: invokestatic 207	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: new 174	com/tencent/luggage/wxa/rt/i
    //   106: dup
    //   107: aload 6
    //   109: invokespecial 296	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   112: invokevirtual 299	com/tencent/luggage/wxa/rt/i:j	()Z
    //   115: ifne +316 -> 431
    //   118: aload 5
    //   120: aload_1
    //   121: invokestatic 378	com/tencent/mm/plugin/appbrand/appcache/ad:c	(Lcom/tencent/luggage/wxa/iu/d;Ljava/lang/String;)Ljava/io/InputStream;
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +236 -> 362
    //   129: aload_0
    //   130: invokevirtual 382	java/io/InputStream:available	()I
    //   133: ifgt +6 -> 139
    //   136: goto +226 -> 362
    //   139: aload_2
    //   140: aload_0
    //   141: invokestatic 266	com/tencent/luggage/wxa/na/b:a	(Ljava/lang/String;Ljava/io/InputStream;)Z
    //   144: ifne +21 -> 165
    //   147: ldc 63
    //   149: ldc_w 424
    //   152: invokestatic 70	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_0
    //   156: ifnull +7 -> 163
    //   159: aload_0
    //   160: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   163: iconst_0
    //   164: ireturn
    //   165: aload 5
    //   167: aload_1
    //   168: invokestatic 429	com/tencent/mm/plugin/appbrand/page/r:a	(Lcom/tencent/luggage/wxa/iu/d;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   171: astore_1
    //   172: aload_1
    //   173: ifnull +163 -> 336
    //   176: aload_1
    //   177: invokevirtual 434	android/graphics/Bitmap:isRecycled	()Z
    //   180: istore 4
    //   182: iload 4
    //   184: ifne +152 -> 336
    //   187: aload_1
    //   188: bipush 100
    //   190: getstatic 440	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   193: aload 6
    //   195: iconst_1
    //   196: invokestatic 445	com/tencent/luggage/wxa/qz/b:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   199: aload_1
    //   200: ifnull +30 -> 230
    //   203: aload_1
    //   204: invokevirtual 434	android/graphics/Bitmap:isRecycled	()Z
    //   207: ifne +23 -> 230
    //   210: ldc 63
    //   212: ldc_w 447
    //   215: iconst_1
    //   216: anewarray 4	java/lang/Object
    //   219: dup
    //   220: iconst_0
    //   221: aload_1
    //   222: aastore
    //   223: invokestatic 207	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: aload_1
    //   227: invokevirtual 450	android/graphics/Bitmap:recycle	()V
    //   230: aload_0
    //   231: ifnull +200 -> 431
    //   234: aload_0
    //   235: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   238: goto +193 -> 431
    //   241: astore_2
    //   242: goto +61 -> 303
    //   245: astore_2
    //   246: ldc 63
    //   248: ldc_w 452
    //   251: iconst_1
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: aload_2
    //   258: aastore
    //   259: invokestatic 454	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: aload_1
    //   263: ifnull +30 -> 293
    //   266: aload_1
    //   267: invokevirtual 434	android/graphics/Bitmap:isRecycled	()Z
    //   270: ifne +23 -> 293
    //   273: ldc 63
    //   275: ldc_w 447
    //   278: iconst_1
    //   279: anewarray 4	java/lang/Object
    //   282: dup
    //   283: iconst_0
    //   284: aload_1
    //   285: aastore
    //   286: invokestatic 207	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: aload_1
    //   290: invokevirtual 450	android/graphics/Bitmap:recycle	()V
    //   293: aload_0
    //   294: ifnull +7 -> 301
    //   297: aload_0
    //   298: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   301: iconst_0
    //   302: ireturn
    //   303: aload_1
    //   304: ifnull +30 -> 334
    //   307: aload_1
    //   308: invokevirtual 434	android/graphics/Bitmap:isRecycled	()Z
    //   311: ifne +23 -> 334
    //   314: ldc 63
    //   316: ldc_w 447
    //   319: iconst_1
    //   320: anewarray 4	java/lang/Object
    //   323: dup
    //   324: iconst_0
    //   325: aload_1
    //   326: aastore
    //   327: invokestatic 207	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   330: aload_1
    //   331: invokevirtual 450	android/graphics/Bitmap:recycle	()V
    //   334: aload_2
    //   335: athrow
    //   336: ldc 63
    //   338: ldc_w 456
    //   341: invokestatic 188	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload_0
    //   345: ifnull +7 -> 352
    //   348: aload_0
    //   349: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   352: iconst_0
    //   353: ireturn
    //   354: astore_1
    //   355: goto +66 -> 421
    //   358: astore_1
    //   359: goto +21 -> 380
    //   362: ldc 63
    //   364: ldc_w 458
    //   367: invokestatic 70	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload_0
    //   371: ifnull +7 -> 378
    //   374: aload_0
    //   375: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   378: iconst_0
    //   379: ireturn
    //   380: new 42	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   387: astore_2
    //   388: aload_2
    //   389: ldc_w 460
    //   392: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_2
    //   397: aload_1
    //   398: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: ldc 63
    //   404: aload_2
    //   405: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 329	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: aload_0
    //   412: ifnull +7 -> 419
    //   415: aload_0
    //   416: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   419: iconst_0
    //   420: ireturn
    //   421: aload_0
    //   422: ifnull +7 -> 429
    //   425: aload_0
    //   426: invokestatic 191	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   429: aload_1
    //   430: athrow
    //   431: aload_3
    //   432: ifnull +13 -> 445
    //   435: aload_3
    //   436: aload 6
    //   438: invokeinterface 127 2 0
    //   443: iconst_1
    //   444: ireturn
    //   445: iconst_0
    //   446: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	paramc	com.tencent.luggage.wxa.jx.c
    //   0	447	1	paramString1	String
    //   0	447	2	paramString2	String
    //   0	447	3	parama	b.a
    //   180	3	4	bool	boolean
    //   20	146	5	locald	d
    //   84	353	6	str	String
    // Exception table:
    //   from	to	target	type
    //   187	199	241	finally
    //   246	262	241	finally
    //   187	199	245	java/io/IOException
    //   129	136	354	finally
    //   139	155	354	finally
    //   165	172	354	finally
    //   176	182	354	finally
    //   203	230	354	finally
    //   266	293	354	finally
    //   307	334	354	finally
    //   334	336	354	finally
    //   336	344	354	finally
    //   362	370	354	finally
    //   380	411	354	finally
    //   129	136	358	java/lang/Exception
    //   139	155	358	java/lang/Exception
    //   165	172	358	java/lang/Exception
    //   176	182	358	java/lang/Exception
    //   203	230	358	java/lang/Exception
    //   266	293	358	java/lang/Exception
    //   307	334	358	java/lang/Exception
    //   334	336	358	java/lang/Exception
    //   336	344	358	java/lang/Exception
    //   362	370	358	java/lang/Exception
  }
  
  private static boolean f(String paramString1, String paramString2)
  {
    if (af.c(paramString1))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid target nil, no check");
      return true;
    }
    paramString2 = com.tencent.luggage.wxa.gl.c.a(paramString2);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid file:%s target:%s", new Object[] { paramString2, paramString1 });
    return paramString1.equals(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.na.b
 * JD-Core Version:    0.7.0.1
 */