package com.tencent.map.sdk.a;

import android.content.Context;
import com.tencent.tencentmap.io.QStorageManager;
import java.lang.ref.WeakReference;
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
    if (this.e != null) {
      this.e.a(new String[] { "mapPoiIconIndoorVersion", "poiIconIndoorMd5" });
    }
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/tencent/map/sdk/a/hz:c	Ljava/lang/ref/WeakReference;
    //   4: ifnull +39 -> 43
    //   7: aload_0
    //   8: getfield 72	com/tencent/map/sdk/a/hz:c	Ljava/lang/ref/WeakReference;
    //   11: invokevirtual 293	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   14: checkcast 51	com/tencent/map/sdk/a/ln
    //   17: astore 7
    //   19: aload 7
    //   21: ifnull +22 -> 43
    //   24: aload 7
    //   26: getfield 54	com/tencent/map/sdk/a/ln:b	Lcom/tencent/map/sdk/a/pn;
    //   29: ifnull +14 -> 43
    //   32: aload 7
    //   34: getfield 54	com/tencent/map/sdk/a/ln:b	Lcom/tencent/map/sdk/a/pn;
    //   37: getfield 60	com/tencent/map/sdk/a/pt:az	Lcom/tencent/map/sdk/a/pm;
    //   40: ifnonnull +5 -> 45
    //   43: iconst_0
    //   44: ireturn
    //   45: aload 7
    //   47: getfield 54	com/tencent/map/sdk/a/ln:b	Lcom/tencent/map/sdk/a/pn;
    //   50: getfield 60	com/tencent/map/sdk/a/pt:az	Lcom/tencent/map/sdk/a/pm;
    //   53: astore 8
    //   55: new 387	java/io/File
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 390	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: astore 7
    //   65: aload 7
    //   67: invokevirtual 393	java/io/File:exists	()Z
    //   70: ifeq +11 -> 81
    //   73: aload 7
    //   75: invokevirtual 396	java/io/File:isDirectory	()Z
    //   78: ifne +18 -> 96
    //   81: ldc_w 398
    //   84: aload_1
    //   85: invokestatic 402	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 405	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 409	com/tencent/map/sdk/a/or:b	(Ljava/lang/String;)V
    //   94: iconst_0
    //   95: ireturn
    //   96: aload 7
    //   98: invokevirtual 413	java/io/File:listFiles	()[Ljava/io/File;
    //   101: astore 9
    //   103: aload 9
    //   105: ifnull -62 -> 43
    //   108: iconst_1
    //   109: istore 5
    //   111: aconst_null
    //   112: astore_1
    //   113: aload 9
    //   115: arraylength
    //   116: istore 4
    //   118: iconst_0
    //   119: istore_3
    //   120: iload_3
    //   121: iload 4
    //   123: if_icmpge +262 -> 385
    //   126: aload 9
    //   128: iload_3
    //   129: aaload
    //   130: astore 10
    //   132: new 415	java/io/FileInputStream
    //   135: dup
    //   136: aload 10
    //   138: invokespecial 418	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   141: astore 7
    //   143: aload 10
    //   145: invokevirtual 421	java/io/File:length	()J
    //   148: l2i
    //   149: newarray byte
    //   151: astore_1
    //   152: aload 7
    //   154: aload_1
    //   155: iconst_0
    //   156: aload_1
    //   157: arraylength
    //   158: invokevirtual 427	java/io/InputStream:read	([BII)I
    //   161: pop
    //   162: aload_2
    //   163: aload_0
    //   164: getfield 189	com/tencent/map/sdk/a/hz:h	Ljava/lang/String;
    //   167: invokevirtual 247	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifeq +97 -> 267
    //   173: aload 10
    //   175: invokevirtual 430	java/io/File:getName	()Ljava/lang/String;
    //   178: astore 10
    //   180: aload 8
    //   182: getfield 300	com/tencent/map/sdk/a/pm:b	Lcom/tencent/map/sdk/a/lw;
    //   185: getfield 306	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   188: astore 11
    //   190: aload 11
    //   192: ifnonnull +28 -> 220
    //   195: iconst_0
    //   196: istore 6
    //   198: iload 6
    //   200: iload 5
    //   202: iand
    //   203: istore 5
    //   205: aload 7
    //   207: invokestatic 433	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   210: aload 7
    //   212: astore_1
    //   213: iload_3
    //   214: iconst_1
    //   215: iadd
    //   216: istore_3
    //   217: goto -97 -> 120
    //   220: aload 11
    //   222: getfield 436	com/tencent/map/sdk/a/ke:b	Lcom/tencent/map/sdk/a/md;
    //   225: ifnonnull +9 -> 234
    //   228: iconst_0
    //   229: istore 6
    //   231: goto -33 -> 198
    //   234: new 387	java/io/File
    //   237: dup
    //   238: aload 11
    //   240: getfield 436	com/tencent/map/sdk/a/ke:b	Lcom/tencent/map/sdk/a/md;
    //   243: invokeinterface 440 1 0
    //   248: invokespecial 390	java/io/File:<init>	(Ljava/lang/String;)V
    //   251: aload 10
    //   253: aload_1
    //   254: aload 11
    //   256: getfield 443	com/tencent/map/sdk/a/ke:d	Ljava/util/concurrent/locks/Lock;
    //   259: invokestatic 446	com/tencent/map/sdk/a/ke:a	(Ljava/io/File;Ljava/lang/String;[BLjava/util/concurrent/locks/Lock;)Z
    //   262: istore 6
    //   264: goto -66 -> 198
    //   267: aload_2
    //   268: aload_0
    //   269: getfield 194	com/tencent/map/sdk/a/hz:i	Ljava/lang/String;
    //   272: invokevirtual 247	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   275: ifeq +127 -> 402
    //   278: aload 10
    //   280: invokevirtual 430	java/io/File:getName	()Ljava/lang/String;
    //   283: astore 10
    //   285: aload 8
    //   287: getfield 300	com/tencent/map/sdk/a/pm:b	Lcom/tencent/map/sdk/a/lw;
    //   290: getfield 306	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   293: astore 11
    //   295: aload 11
    //   297: ifnonnull +9 -> 306
    //   300: iconst_0
    //   301: istore 6
    //   303: goto +102 -> 405
    //   306: aload 11
    //   308: getfield 436	com/tencent/map/sdk/a/ke:b	Lcom/tencent/map/sdk/a/md;
    //   311: ifnonnull +9 -> 320
    //   314: iconst_0
    //   315: istore 6
    //   317: goto +88 -> 405
    //   320: new 387	java/io/File
    //   323: dup
    //   324: aload 11
    //   326: getfield 436	com/tencent/map/sdk/a/ke:b	Lcom/tencent/map/sdk/a/md;
    //   329: invokeinterface 448 1 0
    //   334: invokespecial 390	java/io/File:<init>	(Ljava/lang/String;)V
    //   337: aload 10
    //   339: aload_1
    //   340: aload 11
    //   342: getfield 450	com/tencent/map/sdk/a/ke:e	Ljava/util/concurrent/locks/Lock;
    //   345: invokestatic 446	com/tencent/map/sdk/a/ke:a	(Ljava/io/File;Ljava/lang/String;[BLjava/util/concurrent/locks/Lock;)Z
    //   348: istore 6
    //   350: goto +55 -> 405
    //   353: astore_1
    //   354: aload 7
    //   356: astore_1
    //   357: aload_1
    //   358: invokestatic 433	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   361: goto -148 -> 213
    //   364: astore_1
    //   365: aload 7
    //   367: astore_1
    //   368: aload_1
    //   369: invokestatic 433	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   372: goto -159 -> 213
    //   375: astore_2
    //   376: aload 7
    //   378: astore_1
    //   379: aload_1
    //   380: invokestatic 433	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   383: aload_2
    //   384: athrow
    //   385: iload 5
    //   387: ireturn
    //   388: astore_2
    //   389: goto -10 -> 379
    //   392: astore 7
    //   394: goto -26 -> 368
    //   397: astore 7
    //   399: goto -42 -> 357
    //   402: goto -197 -> 205
    //   405: iload 6
    //   407: iload 5
    //   409: iand
    //   410: istore 5
    //   412: goto -207 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	this	hz
    //   0	415	1	paramString1	String
    //   0	415	2	paramString2	String
    //   119	98	3	m	int
    //   116	8	4	n	int
    //   109	302	5	bool1	boolean
    //   196	214	6	bool2	boolean
    //   17	360	7	localObject1	Object
    //   392	1	7	localIOException	java.io.IOException
    //   397	1	7	localFileNotFoundException	java.io.FileNotFoundException
    //   53	233	8	localpm	pm
    //   101	26	9	arrayOfFile	java.io.File[]
    //   130	208	10	localObject2	Object
    //   188	153	11	localke	ke
    // Exception table:
    //   from	to	target	type
    //   143	190	353	java/io/FileNotFoundException
    //   220	228	353	java/io/FileNotFoundException
    //   234	264	353	java/io/FileNotFoundException
    //   267	295	353	java/io/FileNotFoundException
    //   306	314	353	java/io/FileNotFoundException
    //   320	350	353	java/io/FileNotFoundException
    //   143	190	364	java/io/IOException
    //   220	228	364	java/io/IOException
    //   234	264	364	java/io/IOException
    //   267	295	364	java/io/IOException
    //   306	314	364	java/io/IOException
    //   320	350	364	java/io/IOException
    //   143	190	375	finally
    //   220	228	375	finally
    //   234	264	375	finally
    //   267	295	375	finally
    //   306	314	375	finally
    //   320	350	375	finally
    //   132	143	388	finally
    //   132	143	392	java/io/IOException
    //   132	143	397	java/io/FileNotFoundException
  }
  
  public final String a()
  {
    String str = this.g;
    if (nl.a(this.g)) {
      str = pz.a;
    }
    return str;
  }
  
  /* Error */
  public final void a(String paramString, WeakReference<ln> paramWeakReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 32	com/tencent/map/sdk/a/hz:b	Ljava/util/Map;
    //   5: aload_1
    //   6: invokeinterface 461 2 0
    //   11: ifeq +25 -> 36
    //   14: getstatic 32	com/tencent/map/sdk/a/hz:b	Ljava/util/Map;
    //   17: aload_1
    //   18: invokeinterface 279 2 0
    //   23: checkcast 281	java/util/List
    //   26: aload_2
    //   27: invokeinterface 462 2 0
    //   32: pop
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: new 98	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 99	java/util/ArrayList:<init>	()V
    //   43: astore_3
    //   44: aload_3
    //   45: aload_2
    //   46: invokeinterface 462 2 0
    //   51: pop
    //   52: getstatic 32	com/tencent/map/sdk/a/hz:b	Ljava/util/Map;
    //   55: aload_1
    //   56: aload_3
    //   57: invokeinterface 466 3 0
    //   62: pop
    //   63: goto -30 -> 33
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	hz
    //   0	71	1	paramString	String
    //   0	71	2	paramWeakReference	WeakReference<ln>
    //   43	14	3	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	33	66	finally
    //   36	63	66	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.hz
 * JD-Core Version:    0.7.0.1
 */