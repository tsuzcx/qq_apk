package com.tencent.luggage.wxa.pd;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.e;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.rd.a;
import com.tencent.luggage.wxa.rt.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class b
{
  private static ConcurrentMap<String, Boolean> a = new ConcurrentHashMap();
  private static Map<String, List<b.a>> b = new HashMap();
  private static final String c;
  
  static
  {
    Object localObject2 = com.tencent.luggage.wxa.pc.c.a();
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
  
  private static String a(String paramString)
  {
    paramString = b(paramString);
    return String.format("%s%s", new Object[] { c, paramString });
  }
  
  public static void a(com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2, b.a parama)
  {
    if (af.c(paramString1)) {
      return;
    }
    if (parama == null) {
      return;
    }
    if (paramString1.startsWith("wxfile://"))
    {
      if (!b(paramc, paramString1, paramString2, parama)) {
        a(parama);
      }
    }
    else if ((!paramString1.startsWith("http://")) && (!paramString1.startsWith("https://")))
    {
      if (!c(paramc, paramString1, paramString2, parama)) {
        a(parama);
      }
    }
    else {
      a(paramString1, paramString2, parama);
    }
  }
  
  private static void a(b.a parama)
  {
    if (parama != null) {
      parama.a(null);
    }
  }
  
  private static void a(String paramString1, String paramString2, b.a parama)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, url:%s", new Object[] { paramString1 });
    String str = a(paramString1);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, localPath:%s", new Object[] { str });
    t.a(new b.1(paramString1, parama));
    a.b(new b.2(paramString1, paramString2, str), "AppBrandLiveFileLoadHelperThread");
  }
  
  private static String b(String paramString)
  {
    if (!af.c(paramString)) {
      return com.tencent.luggage.wxa.gl.c.a(paramString.getBytes());
    }
    return null;
  }
  
  private static void b(String paramString1, String paramString2)
  {
    t.a(new b.3(paramString1, paramString2));
  }
  
  /* Error */
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 156	com/tencent/luggage/wxa/rt/i
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 158	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   8: astore 11
    //   10: aload 11
    //   12: invokevirtual 162	com/tencent/luggage/wxa/rt/i:j	()Z
    //   15: ifeq +54 -> 69
    //   18: ldc 103
    //   20: ldc 164
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: aastore
    //   30: invokestatic 111	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_1
    //   34: aload_2
    //   35: invokestatic 167	com/tencent/luggage/wxa/pd/b:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   38: ifeq +9 -> 47
    //   41: aload_0
    //   42: aload_2
    //   43: invokestatic 169	com/tencent/luggage/wxa/pd/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: return
    //   47: ldc 103
    //   49: ldc 171
    //   51: iconst_1
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload 11
    //   59: invokevirtual 174	com/tencent/luggage/wxa/rt/i:w	()Z
    //   62: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   65: aastore
    //   66: invokestatic 111	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: getstatic 21	com/tencent/luggage/wxa/pd/b:a	Ljava/util/concurrent/ConcurrentMap;
    //   72: aload_0
    //   73: invokeinterface 186 2 0
    //   78: ifeq +19 -> 97
    //   81: ldc 103
    //   83: ldc 188
    //   85: iconst_1
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: aload_0
    //   92: aastore
    //   93: invokestatic 111	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: return
    //   97: getstatic 21	com/tencent/luggage/wxa/pd/b:a	Ljava/util/concurrent/ConcurrentMap;
    //   100: aload_0
    //   101: iconst_1
    //   102: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   105: invokeinterface 192 3 0
    //   110: pop
    //   111: new 194	java/net/URL
    //   114: dup
    //   115: aload_0
    //   116: invokespecial 195	java/net/URL:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 199	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   122: checkcast 201	java/net/HttpURLConnection
    //   125: astore 4
    //   127: aload 11
    //   129: invokestatic 206	com/tencent/luggage/wxa/rt/k:b	(Lcom/tencent/luggage/wxa/rt/i;)Ljava/io/OutputStream;
    //   132: astore 5
    //   134: new 208	java/io/BufferedInputStream
    //   137: dup
    //   138: aload 4
    //   140: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   143: invokespecial 215	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   146: astore 7
    //   148: aload 4
    //   150: astore 8
    //   152: aload 5
    //   154: astore 9
    //   156: aload 7
    //   158: astore 10
    //   160: sipush 16384
    //   163: newarray byte
    //   165: astore 6
    //   167: aload 4
    //   169: astore 8
    //   171: aload 5
    //   173: astore 9
    //   175: aload 7
    //   177: astore 10
    //   179: aload 7
    //   181: aload 6
    //   183: iconst_0
    //   184: aload 6
    //   186: arraylength
    //   187: invokevirtual 221	java/io/InputStream:read	([BII)I
    //   190: istore_3
    //   191: iload_3
    //   192: iconst_m1
    //   193: if_icmpeq +27 -> 220
    //   196: aload 4
    //   198: astore 8
    //   200: aload 5
    //   202: astore 9
    //   204: aload 7
    //   206: astore 10
    //   208: aload 5
    //   210: aload 6
    //   212: iconst_0
    //   213: iload_3
    //   214: invokevirtual 227	java/io/OutputStream:write	([BII)V
    //   217: goto -50 -> 167
    //   220: aload 4
    //   222: astore 8
    //   224: aload 5
    //   226: astore 9
    //   228: aload 7
    //   230: astore 10
    //   232: aload 5
    //   234: invokevirtual 230	java/io/OutputStream:flush	()V
    //   237: aload 4
    //   239: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   242: invokevirtual 233	java/io/InputStream:close	()V
    //   245: aload 4
    //   247: astore 6
    //   249: goto +175 -> 424
    //   252: astore 6
    //   254: goto +156 -> 410
    //   257: astore 8
    //   259: aload 4
    //   261: astore 6
    //   263: aload 7
    //   265: astore 4
    //   267: aload 8
    //   269: astore 7
    //   271: goto +63 -> 334
    //   274: astore_0
    //   275: aconst_null
    //   276: astore 10
    //   278: goto +215 -> 493
    //   281: astore 7
    //   283: aconst_null
    //   284: astore 8
    //   286: aload 4
    //   288: astore 6
    //   290: aload 8
    //   292: astore 4
    //   294: goto +40 -> 334
    //   297: astore_0
    //   298: goto +16 -> 314
    //   301: astore 7
    //   303: aload 4
    //   305: astore 6
    //   307: goto +21 -> 328
    //   310: astore_0
    //   311: aconst_null
    //   312: astore 4
    //   314: aconst_null
    //   315: astore 5
    //   317: aconst_null
    //   318: astore 10
    //   320: goto +173 -> 493
    //   323: astore 7
    //   325: aconst_null
    //   326: astore 6
    //   328: aconst_null
    //   329: astore 5
    //   331: aconst_null
    //   332: astore 4
    //   334: aload 6
    //   336: astore 8
    //   338: aload 5
    //   340: astore 9
    //   342: aload 4
    //   344: astore 10
    //   346: aload 11
    //   348: invokevirtual 174	com/tencent/luggage/wxa/rt/i:w	()Z
    //   351: pop
    //   352: aload 6
    //   354: astore 8
    //   356: aload 5
    //   358: astore 9
    //   360: aload 4
    //   362: astore 10
    //   364: ldc 103
    //   366: aload 7
    //   368: ldc 235
    //   370: iconst_1
    //   371: anewarray 4	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload_0
    //   377: aastore
    //   378: invokestatic 238	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   381: aload 6
    //   383: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   386: invokevirtual 233	java/io/InputStream:close	()V
    //   389: aload 4
    //   391: astore 7
    //   393: goto +31 -> 424
    //   396: astore 8
    //   398: aload 4
    //   400: astore 7
    //   402: aload 6
    //   404: astore 4
    //   406: aload 8
    //   408: astore 6
    //   410: ldc 103
    //   412: aload 6
    //   414: invokevirtual 241	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   417: invokestatic 242	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: aload 4
    //   422: astore 6
    //   424: aload 5
    //   426: invokestatic 245	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   429: aload 7
    //   431: invokestatic 245	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   434: aload 6
    //   436: invokevirtual 248	java/net/HttpURLConnection:disconnect	()V
    //   439: ldc 103
    //   441: ldc 250
    //   443: invokestatic 252	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: getstatic 21	com/tencent/luggage/wxa/pd/b:a	Ljava/util/concurrent/ConcurrentMap;
    //   449: aload_0
    //   450: invokeinterface 256 2 0
    //   455: pop
    //   456: aload_1
    //   457: aload_2
    //   458: invokestatic 167	com/tencent/luggage/wxa/pd/b:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   461: ifeq +9 -> 470
    //   464: aload_0
    //   465: aload_2
    //   466: invokestatic 169	com/tencent/luggage/wxa/pd/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: return
    //   470: ldc 103
    //   472: ldc_w 258
    //   475: invokestatic 259	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   478: aload_0
    //   479: aconst_null
    //   480: invokestatic 169	com/tencent/luggage/wxa/pd/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   483: return
    //   484: astore_0
    //   485: aload 9
    //   487: astore 5
    //   489: aload 8
    //   491: astore 4
    //   493: aload 4
    //   495: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   498: invokevirtual 233	java/io/InputStream:close	()V
    //   501: goto +13 -> 514
    //   504: astore_1
    //   505: ldc 103
    //   507: aload_1
    //   508: invokevirtual 241	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   511: invokestatic 242	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload 5
    //   516: invokestatic 245	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   519: aload 10
    //   521: invokestatic 245	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   524: aload 4
    //   526: invokevirtual 248	java/net/HttpURLConnection:disconnect	()V
    //   529: goto +5 -> 534
    //   532: aload_0
    //   533: athrow
    //   534: goto -2 -> 532
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	paramString1	String
    //   0	537	1	paramString2	String
    //   0	537	2	paramString3	String
    //   190	24	3	i	int
    //   125	400	4	localObject1	Object
    //   132	383	5	localObject2	Object
    //   165	83	6	localObject3	Object
    //   252	1	6	localException1	java.lang.Exception
    //   261	174	6	localObject4	Object
    //   146	124	7	localObject5	Object
    //   281	1	7	localException2	java.lang.Exception
    //   301	1	7	localException3	java.lang.Exception
    //   323	44	7	localException4	java.lang.Exception
    //   391	39	7	localObject6	Object
    //   150	73	8	localObject7	Object
    //   257	11	8	localException5	java.lang.Exception
    //   284	71	8	localObject8	Object
    //   396	94	8	localException6	java.lang.Exception
    //   154	332	9	localObject9	Object
    //   158	362	10	localObject10	Object
    //   8	339	11	locali	i
    // Exception table:
    //   from	to	target	type
    //   237	245	252	java/lang/Exception
    //   160	167	257	java/lang/Exception
    //   179	191	257	java/lang/Exception
    //   208	217	257	java/lang/Exception
    //   232	237	257	java/lang/Exception
    //   134	148	274	finally
    //   134	148	281	java/lang/Exception
    //   127	134	297	finally
    //   127	134	301	java/lang/Exception
    //   111	127	310	finally
    //   111	127	323	java/lang/Exception
    //   381	389	396	java/lang/Exception
    //   160	167	484	finally
    //   179	191	484	finally
    //   208	217	484	finally
    //   232	237	484	finally
    //   346	352	484	finally
    //   364	381	484	finally
    //   493	501	504	java/lang/Exception
  }
  
  private static boolean b(com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2, b.a parama)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, url:%s", new Object[] { paramString1 });
    if (paramc == null)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, component is null");
      return false;
    }
    paramc = paramc.getFileSystem().g(paramString1);
    if ((paramc != null) && (paramc.j()))
    {
      paramc = paramc.l();
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, localPath:%s", new Object[] { paramc });
      if ((d(paramString2, paramc)) && (parama != null))
      {
        parama.a(paramc);
        return true;
      }
    }
    return false;
  }
  
  private static void c(String paramString1, String paramString2)
  {
    int i = 0;
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "doCallback url:%s, localPath:%s", new Object[] { paramString1, paramString2 });
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
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "doCallback callbacks nil");
  }
  
  /* Error */
  private static boolean c(com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2, b.a parama)
  {
    // Byte code:
    //   0: ldc 103
    //   2: ldc_w 303
    //   5: iconst_1
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_1
    //   12: aastore
    //   13: invokestatic 111	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aload_0
    //   17: ifnonnull +13 -> 30
    //   20: ldc 103
    //   22: ldc_w 305
    //   25: invokestatic 252	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_0
    //   31: instanceof 307
    //   34: ifne +13 -> 47
    //   37: ldc 103
    //   39: ldc_w 309
    //   42: invokestatic 252	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: iconst_0
    //   46: ireturn
    //   47: aload_0
    //   48: checkcast 307	com/tencent/luggage/wxa/jx/h
    //   51: invokeinterface 313 1 0
    //   56: astore 5
    //   58: aload 5
    //   60: ifnonnull +13 -> 73
    //   63: ldc 103
    //   65: ldc_w 315
    //   68: invokestatic 252	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iconst_0
    //   72: ireturn
    //   73: aload_1
    //   74: invokestatic 113	com/tencent/luggage/wxa/pd/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_0
    //   78: ldc 103
    //   80: ldc_w 317
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_0
    //   90: aastore
    //   91: invokestatic 111	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: new 156	com/tencent/luggage/wxa/rt/i
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 158	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   102: astore 4
    //   104: aload 4
    //   106: invokevirtual 162	com/tencent/luggage/wxa/rt/i:j	()Z
    //   109: ifne +163 -> 272
    //   112: aload 5
    //   114: aload_1
    //   115: invokestatic 322	com/tencent/mm/plugin/appbrand/page/r:a	(Lcom/tencent/luggage/wxa/iu/d;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   118: astore_1
    //   119: aload_1
    //   120: ifnull +142 -> 262
    //   123: aload_1
    //   124: invokevirtual 327	android/graphics/Bitmap:isRecycled	()Z
    //   127: ifne +135 -> 262
    //   130: aload_1
    //   131: bipush 100
    //   133: getstatic 333	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   136: aload_0
    //   137: iconst_1
    //   138: invokestatic 338	com/tencent/luggage/wxa/qz/b:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   141: aload_1
    //   142: ifnull +130 -> 272
    //   145: aload_1
    //   146: invokevirtual 327	android/graphics/Bitmap:isRecycled	()Z
    //   149: ifne +123 -> 272
    //   152: ldc 103
    //   154: ldc_w 340
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_1
    //   164: aastore
    //   165: invokestatic 111	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_1
    //   169: invokevirtual 343	android/graphics/Bitmap:recycle	()V
    //   172: goto +100 -> 272
    //   175: astore_0
    //   176: goto +53 -> 229
    //   179: astore_0
    //   180: ldc 103
    //   182: ldc_w 345
    //   185: iconst_1
    //   186: anewarray 4	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: aload_0
    //   192: aastore
    //   193: invokestatic 347	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload_1
    //   197: ifnull +30 -> 227
    //   200: aload_1
    //   201: invokevirtual 327	android/graphics/Bitmap:isRecycled	()Z
    //   204: ifne +23 -> 227
    //   207: ldc 103
    //   209: ldc_w 340
    //   212: iconst_1
    //   213: anewarray 4	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: aload_1
    //   219: aastore
    //   220: invokestatic 111	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: aload_1
    //   224: invokevirtual 343	android/graphics/Bitmap:recycle	()V
    //   227: iconst_0
    //   228: ireturn
    //   229: aload_1
    //   230: ifnull +30 -> 260
    //   233: aload_1
    //   234: invokevirtual 327	android/graphics/Bitmap:isRecycled	()Z
    //   237: ifne +23 -> 260
    //   240: ldc 103
    //   242: ldc_w 340
    //   245: iconst_1
    //   246: anewarray 4	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: aload_1
    //   252: aastore
    //   253: invokestatic 111	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: aload_1
    //   257: invokevirtual 343	android/graphics/Bitmap:recycle	()V
    //   260: aload_0
    //   261: athrow
    //   262: ldc 103
    //   264: ldc_w 349
    //   267: invokestatic 242	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: iconst_0
    //   271: ireturn
    //   272: aload_2
    //   273: aload_0
    //   274: invokestatic 167	com/tencent/luggage/wxa/pd/b:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   277: ifeq +16 -> 293
    //   280: aload_3
    //   281: ifnull +35 -> 316
    //   284: aload_3
    //   285: aload_0
    //   286: invokeinterface 98 2 0
    //   291: iconst_1
    //   292: ireturn
    //   293: ldc 103
    //   295: ldc_w 351
    //   298: iconst_1
    //   299: anewarray 4	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: aload 4
    //   306: invokevirtual 174	com/tencent/luggage/wxa/rt/i:w	()Z
    //   309: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   312: aastore
    //   313: invokestatic 111	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: iconst_0
    //   317: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	paramc	com.tencent.luggage.wxa.jx.c
    //   0	318	1	paramString1	String
    //   0	318	2	paramString2	String
    //   0	318	3	parama	b.a
    //   102	203	4	locali	i
    //   56	57	5	locald	com.tencent.luggage.wxa.iu.d
    // Exception table:
    //   from	to	target	type
    //   130	141	175	finally
    //   180	196	175	finally
    //   130	141	179	java/io/IOException
  }
  
  private static boolean d(String paramString1, String paramString2)
  {
    if (af.c(paramString1))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid target nil, no check");
      return true;
    }
    paramString2 = com.tencent.luggage.wxa.gl.c.a(paramString2);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid file:%s target:%s", new Object[] { paramString2, paramString1 });
    return paramString1.equals(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.b
 * JD-Core Version:    0.7.0.1
 */