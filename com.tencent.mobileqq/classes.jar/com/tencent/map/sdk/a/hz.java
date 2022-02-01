package com.tencent.map.sdk.a;

import android.content.Context;
import com.tencent.tencentmap.io.QStorageManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class hz
{
  public static volatile Map<String, List<WeakReference<ln>>> b = new HashMap();
  public volatile boolean a = false;
  public WeakReference<ln> c;
  private String d;
  private gc e;
  private QStorageManager f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  public hz(Context paramContext, ln paramln, String paramString)
  {
    this.f = QStorageManager.getInstance(paramContext);
    this.d = "";
    if ((paramln != null) && (paramln.b != null) && (paramln.b.az != null)) {
      this.d = paramln.b.az.k();
    }
    this.c = new WeakReference(paramln);
    this.g = paramString;
    this.e = ge.a(paramContext, this.g);
    paramContext = this.e;
    if (paramContext != null) {
      paramContext.a(new String[] { "mapPoiIconIndoorVersion", "poiIconIndoorMd5" });
    }
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/tencent/map/sdk/a/hz:c	Ljava/lang/ref/WeakReference;
    //   4: astore 7
    //   6: aload 7
    //   8: ifnull +372 -> 380
    //   11: aload 7
    //   13: invokevirtual 293	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   16: checkcast 51	com/tencent/map/sdk/a/ln
    //   19: astore 7
    //   21: aload 7
    //   23: ifnull +357 -> 380
    //   26: aload 7
    //   28: getfield 54	com/tencent/map/sdk/a/ln:b	Lcom/tencent/map/sdk/a/pn;
    //   31: ifnull +349 -> 380
    //   34: aload 7
    //   36: getfield 54	com/tencent/map/sdk/a/ln:b	Lcom/tencent/map/sdk/a/pn;
    //   39: getfield 60	com/tencent/map/sdk/a/pt:az	Lcom/tencent/map/sdk/a/pm;
    //   42: ifnonnull +5 -> 47
    //   45: iconst_0
    //   46: ireturn
    //   47: aload 7
    //   49: getfield 54	com/tencent/map/sdk/a/ln:b	Lcom/tencent/map/sdk/a/pn;
    //   52: getfield 60	com/tencent/map/sdk/a/pt:az	Lcom/tencent/map/sdk/a/pm;
    //   55: astore 8
    //   57: new 387	java/io/File
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 390	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore 7
    //   67: aload 7
    //   69: invokevirtual 393	java/io/File:exists	()Z
    //   72: ifeq +295 -> 367
    //   75: aload 7
    //   77: invokevirtual 396	java/io/File:isDirectory	()Z
    //   80: ifne +6 -> 86
    //   83: goto +284 -> 367
    //   86: aload 7
    //   88: invokevirtual 400	java/io/File:listFiles	()[Ljava/io/File;
    //   91: astore 9
    //   93: aload 9
    //   95: ifnonnull +5 -> 100
    //   98: iconst_0
    //   99: ireturn
    //   100: aload 9
    //   102: arraylength
    //   103: istore 4
    //   105: iconst_1
    //   106: istore 5
    //   108: aconst_null
    //   109: astore_1
    //   110: iconst_0
    //   111: istore_3
    //   112: iload_3
    //   113: iload 4
    //   115: if_icmpge +249 -> 364
    //   118: aload 9
    //   120: iload_3
    //   121: aaload
    //   122: astore 10
    //   124: new 402	java/io/FileInputStream
    //   127: dup
    //   128: aload 10
    //   130: invokespecial 405	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   133: astore 7
    //   135: aload 10
    //   137: invokevirtual 408	java/io/File:length	()J
    //   140: l2i
    //   141: newarray byte
    //   143: astore_1
    //   144: aload 7
    //   146: aload_1
    //   147: iconst_0
    //   148: aload_1
    //   149: arraylength
    //   150: invokevirtual 414	java/io/InputStream:read	([BII)I
    //   153: pop
    //   154: aload_2
    //   155: aload_0
    //   156: getfield 195	com/tencent/map/sdk/a/hz:h	Ljava/lang/String;
    //   159: invokevirtual 247	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   162: ifeq +72 -> 234
    //   165: aload 10
    //   167: invokevirtual 417	java/io/File:getName	()Ljava/lang/String;
    //   170: astore 10
    //   172: aload 8
    //   174: getfield 300	com/tencent/map/sdk/a/pm:b	Lcom/tencent/map/sdk/a/lw;
    //   177: getfield 306	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   180: astore 11
    //   182: aload 11
    //   184: ifnonnull +6 -> 190
    //   187: goto +204 -> 391
    //   190: aload 11
    //   192: getfield 420	com/tencent/map/sdk/a/ke:b	Lcom/tencent/map/sdk/a/md;
    //   195: ifnonnull +6 -> 201
    //   198: goto +193 -> 391
    //   201: new 387	java/io/File
    //   204: dup
    //   205: aload 11
    //   207: getfield 420	com/tencent/map/sdk/a/ke:b	Lcom/tencent/map/sdk/a/md;
    //   210: invokeinterface 424 1 0
    //   215: invokespecial 390	java/io/File:<init>	(Ljava/lang/String;)V
    //   218: aload 10
    //   220: aload_1
    //   221: aload 11
    //   223: getfield 427	com/tencent/map/sdk/a/ke:d	Ljava/util/concurrent/locks/Lock;
    //   226: invokestatic 430	com/tencent/map/sdk/a/ke:a	(Ljava/io/File;Ljava/lang/String;[BLjava/util/concurrent/locks/Lock;)Z
    //   229: istore 6
    //   231: goto +163 -> 394
    //   234: iload 5
    //   236: istore 6
    //   238: aload_2
    //   239: aload_0
    //   240: getfield 200	com/tencent/map/sdk/a/hz:i	Ljava/lang/String;
    //   243: invokevirtual 247	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   246: ifeq +72 -> 318
    //   249: aload 10
    //   251: invokevirtual 417	java/io/File:getName	()Ljava/lang/String;
    //   254: astore 10
    //   256: aload 8
    //   258: getfield 300	com/tencent/map/sdk/a/pm:b	Lcom/tencent/map/sdk/a/lw;
    //   261: getfield 306	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   264: astore 11
    //   266: aload 11
    //   268: ifnonnull +6 -> 274
    //   271: goto +133 -> 404
    //   274: aload 11
    //   276: getfield 420	com/tencent/map/sdk/a/ke:b	Lcom/tencent/map/sdk/a/md;
    //   279: ifnonnull +6 -> 285
    //   282: goto +122 -> 404
    //   285: new 387	java/io/File
    //   288: dup
    //   289: aload 11
    //   291: getfield 420	com/tencent/map/sdk/a/ke:b	Lcom/tencent/map/sdk/a/md;
    //   294: invokeinterface 432 1 0
    //   299: invokespecial 390	java/io/File:<init>	(Ljava/lang/String;)V
    //   302: aload 10
    //   304: aload_1
    //   305: aload 11
    //   307: getfield 434	com/tencent/map/sdk/a/ke:e	Ljava/util/concurrent/locks/Lock;
    //   310: invokestatic 430	com/tencent/map/sdk/a/ke:a	(Ljava/io/File;Ljava/lang/String;[BLjava/util/concurrent/locks/Lock;)Z
    //   313: istore 6
    //   315: goto +79 -> 394
    //   318: aload 7
    //   320: invokestatic 437	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   323: aload 7
    //   325: astore_1
    //   326: iload 6
    //   328: istore 5
    //   330: goto +27 -> 357
    //   333: astore_2
    //   334: aload 7
    //   336: astore_1
    //   337: goto +10 -> 347
    //   340: aload 7
    //   342: astore_1
    //   343: goto +10 -> 353
    //   346: astore_2
    //   347: aload_1
    //   348: invokestatic 437	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   351: aload_2
    //   352: athrow
    //   353: aload_1
    //   354: invokestatic 437	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   357: iload_3
    //   358: iconst_1
    //   359: iadd
    //   360: istore_3
    //   361: goto -249 -> 112
    //   364: iload 5
    //   366: ireturn
    //   367: ldc_w 439
    //   370: aload_1
    //   371: invokestatic 443	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   374: invokevirtual 446	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   377: invokestatic 450	com/tencent/map/sdk/a/or:b	(Ljava/lang/String;)V
    //   380: iconst_0
    //   381: ireturn
    //   382: astore 7
    //   384: goto -31 -> 353
    //   387: astore_1
    //   388: goto -48 -> 340
    //   391: iconst_0
    //   392: istore 6
    //   394: iload 5
    //   396: iload 6
    //   398: iand
    //   399: istore 6
    //   401: goto -83 -> 318
    //   404: goto -13 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	hz
    //   0	407	1	paramString1	String
    //   0	407	2	paramString2	String
    //   111	250	3	m	int
    //   103	13	4	n	int
    //   106	293	5	bool1	boolean
    //   229	171	6	bool2	boolean
    //   4	337	7	localObject1	Object
    //   382	1	7	localFileNotFoundException	java.io.FileNotFoundException
    //   55	202	8	localpm	pm
    //   91	28	9	arrayOfFile	java.io.File[]
    //   122	181	10	localObject2	Object
    //   180	126	11	localke	ke
    // Exception table:
    //   from	to	target	type
    //   135	182	333	finally
    //   190	198	333	finally
    //   201	231	333	finally
    //   238	266	333	finally
    //   274	282	333	finally
    //   285	315	333	finally
    //   124	135	346	finally
    //   124	135	382	java/io/FileNotFoundException
    //   124	135	382	java/io/IOException
    //   135	182	387	java/io/FileNotFoundException
    //   135	182	387	java/io/IOException
    //   190	198	387	java/io/FileNotFoundException
    //   190	198	387	java/io/IOException
    //   201	231	387	java/io/FileNotFoundException
    //   201	231	387	java/io/IOException
    //   238	266	387	java/io/FileNotFoundException
    //   238	266	387	java/io/IOException
    //   274	282	387	java/io/FileNotFoundException
    //   274	282	387	java/io/IOException
    //   285	315	387	java/io/FileNotFoundException
    //   285	315	387	java/io/IOException
  }
  
  public final String a()
  {
    String str2 = this.g;
    String str1 = str2;
    if (nl.a(str2)) {
      str1 = pz.a;
    }
    return str1;
  }
  
  public final void a(String paramString, WeakReference<ln> paramWeakReference)
  {
    try
    {
      if (b.containsKey(paramString))
      {
        ((List)b.get(paramString)).add(paramWeakReference);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramWeakReference);
      b.put(paramString, localArrayList);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.hz
 * JD-Core Version:    0.7.0.1
 */