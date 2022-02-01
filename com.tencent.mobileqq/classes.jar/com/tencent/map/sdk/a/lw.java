package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.map.sdk.engine.jni.JNI;
import com.tencent.map.sdk.engine.jni.models.CircleInfo;
import com.tencent.map.sdk.engine.jni.models.Polygon2D;
import com.tencent.tencentmap.io.QStorageManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class lw
  implements hd, lg
{
  public Rect A;
  public boolean B = false;
  public mk C;
  public iy D;
  public jg E;
  public List<mi> F;
  private final int G;
  private lw.d H;
  private LinkedBlockingQueue<lw.a> I;
  private ox<Integer, Integer> J;
  private lz K;
  private boolean L = false;
  private float M = 0.5F;
  private float N = 0.5F;
  private boolean O = true;
  private int P = 18;
  private int Q = 14;
  public pf a;
  public oz b;
  public kl c;
  public jq d;
  public lm e;
  public lv f;
  public WeakReference<lf> g;
  public kd h;
  public Rect i;
  public boolean j;
  public boolean k;
  public Context l;
  public ke m;
  public kc n;
  public md o;
  public ly p;
  public volatile boolean q = false;
  public boolean r = true;
  public boolean s = true;
  public lw.b t;
  public lw.c u;
  public id v;
  public String w;
  public boolean x = true;
  public int y = 0;
  public int z = 0;
  
  public lw(Context paramContext, lf paramlf)
  {
    this.l = paramContext;
    this.g = new WeakReference(paramlf);
    this.a = new pf(paramContext, this);
    this.n = new kc(this);
    this.i = new Rect();
    this.e = new lm(this);
    this.D = new iy(this.l, this);
    this.h = new kd(this.n, this);
    this.c = new kl(this);
    this.a.c = this.c;
    this.H = new lw.d(this, (byte)0);
    this.I = new LinkedBlockingQueue();
    this.F = new ArrayList();
    if (this.l != null)
    {
      this.G = ((int)(this.l.getResources().getDisplayMetrics().density * 6.0F + 0.5D));
      return;
    }
    this.G = 6;
  }
  
  public final int a(CircleInfo paramCircleInfo)
  {
    if ((this.a == null) || (paramCircleInfo == null)) {
      return -1;
    }
    return this.a.a(paramCircleInfo);
  }
  
  public final int a(Polygon2D paramPolygon2D)
  {
    if ((this.a == null) || (paramPolygon2D == null)) {
      return -1;
    }
    int i1 = this.a.a(paramPolygon2D);
    if (this.J == null) {
      this.J = new ox();
    }
    this.J.a(Integer.valueOf(i1), Integer.valueOf(paramPolygon2D.borldLineId));
    return i1;
  }
  
  public final void a()
  {
    if (("original".equals("tencentmap")) && (this.c.k())) {
      this.a.h();
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.M = paramFloat1;
    this.N = paramFloat2;
    double d4 = paramFloat1;
    double d1 = paramFloat2;
    double d2 = d1;
    double d3 = d4;
    if (this.i != null)
    {
      if (this.z > 0) {
        d1 = 0.5D - (0.5D - paramFloat2) * this.i.height() / this.z;
      }
      d2 = d1;
      d3 = d4;
      if (this.y > 0)
      {
        d3 = 0.5D - (0.5D - paramFloat1) * this.i.width() / this.y;
        d2 = d1;
      }
    }
    this.a.a((float)d3, (float)d2, paramBoolean);
  }
  
  public final void a(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    pf localpf = this.a;
    try
    {
      localpf.y();
      long l1 = localpf.b;
      if (l1 == 0L) {
        return;
      }
      localpf.a.nativeRemoveMaskLayer(localpf.b, paramInt);
      return;
    }
    finally
    {
      localpf.z();
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.a(paramInt1 + 50, paramInt2 + 50);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    pf localpf = this.a;
    if ((0L == localpf.b) || (localpf.f == null)) {}
    for (;;)
    {
      this.y = paramInt3;
      this.z = paramInt4;
      if (paramBoolean) {
        a(this.M, this.N, this.O);
      }
      return;
      localpf.f.a(new pf.23(localpf, paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  public final void a(int paramInt, CircleInfo paramCircleInfo)
  {
    if ((this.a == null) || (paramCircleInfo == null)) {}
    pf localpf;
    do
    {
      return;
      localpf = this.a;
    } while (localpf.b == 0L);
    try
    {
      localpf.a.nativeUpdateCircle(localpf.b, paramInt, paramCircleInfo);
      return;
    }
    finally {}
  }
  
  public final void a(lw.a parama)
  {
    try
    {
      this.I.put(parama);
      return;
    }
    catch (InterruptedException parama)
    {
      parama.printStackTrace();
      Thread.currentThread().interrupt();
    }
  }
  
  public final void a(mg parammg)
  {
    if (this.a != null) {
      this.a.e = parammg;
    }
  }
  
  public final void a(mi parammi)
  {
    if (this.F != null) {
      this.F.add(parammi);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      return;
    }
    pf localpf = this.a;
    try
    {
      localpf.y();
      long l1 = localpf.b;
      if (l1 == 0L) {
        return;
      }
      localpf.a.nativeSetBuildingToSpecificFloor(localpf.b, paramString1, paramString2);
      if (localpf.e != null) {
        localpf.e.b();
      }
      return;
    }
    finally
    {
      localpf.z();
    }
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 337	com/tencent/map/sdk/a/lw:d	Lcom/tencent/map/sdk/a/jq;
    //   4: ifnull +112 -> 116
    //   7: aload_0
    //   8: iload_1
    //   9: putfield 339	com/tencent/map/sdk/a/lw:k	Z
    //   12: iload_1
    //   13: ifeq +139 -> 152
    //   16: aload_0
    //   17: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   20: ifnull +31 -> 51
    //   23: aload_0
    //   24: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   27: astore 4
    //   29: aload 4
    //   31: invokevirtual 262	com/tencent/map/sdk/a/pf:y	()V
    //   34: aload 4
    //   36: getfield 264	com/tencent/map/sdk/a/pf:b	J
    //   39: lstore_2
    //   40: lload_2
    //   41: lconst_0
    //   42: lcmp
    //   43: ifne +74 -> 117
    //   46: aload 4
    //   48: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   51: aload_0
    //   52: getfield 337	com/tencent/map/sdk/a/lw:d	Lcom/tencent/map/sdk/a/jq;
    //   55: astore 4
    //   57: aload 4
    //   59: getfield 343	com/tencent/map/sdk/a/jq:a	Lcom/tencent/map/sdk/a/lw;
    //   62: ifnull +54 -> 116
    //   65: aload 4
    //   67: getfield 343	com/tencent/map/sdk/a/jq:a	Lcom/tencent/map/sdk/a/lw;
    //   70: getfield 166	com/tencent/map/sdk/a/lw:c	Lcom/tencent/map/sdk/a/kl;
    //   73: aload 4
    //   75: invokevirtual 346	com/tencent/map/sdk/a/kl:a	(Lcom/tencent/map/sdk/a/he;)V
    //   78: aload 4
    //   80: getfield 349	com/tencent/map/sdk/a/jq:b	Lcom/tencent/map/sdk/a/jp;
    //   83: ifnonnull +25 -> 108
    //   86: aload 4
    //   88: new 351	com/tencent/map/sdk/a/jp
    //   91: dup
    //   92: aload 4
    //   94: getfield 343	com/tencent/map/sdk/a/jq:a	Lcom/tencent/map/sdk/a/lw;
    //   97: aload 4
    //   99: getfield 354	com/tencent/map/sdk/a/jq:c	Lcom/tencent/map/sdk/a/qe;
    //   102: invokespecial 357	com/tencent/map/sdk/a/jp:<init>	(Lcom/tencent/map/sdk/a/lw;Lcom/tencent/map/sdk/a/qe;)V
    //   105: putfield 349	com/tencent/map/sdk/a/jq:b	Lcom/tencent/map/sdk/a/jp;
    //   108: aload 4
    //   110: getfield 349	com/tencent/map/sdk/a/jq:b	Lcom/tencent/map/sdk/a/jp;
    //   113: invokevirtual 360	com/tencent/map/sdk/a/jp:start	()V
    //   116: return
    //   117: aload 4
    //   119: getfield 282	com/tencent/map/sdk/a/pf:f	Lcom/tencent/map/sdk/a/lw;
    //   122: new 362	com/tencent/map/sdk/a/pf$29
    //   125: dup
    //   126: aload 4
    //   128: invokespecial 365	com/tencent/map/sdk/a/pf$29:<init>	(Lcom/tencent/map/sdk/a/pf;)V
    //   131: invokevirtual 291	com/tencent/map/sdk/a/lw:a	(Lcom/tencent/map/sdk/a/lw$a;)V
    //   134: aload 4
    //   136: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   139: goto -88 -> 51
    //   142: astore 5
    //   144: aload 4
    //   146: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   149: aload 5
    //   151: athrow
    //   152: aload_0
    //   153: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   156: ifnull +31 -> 187
    //   159: aload_0
    //   160: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   163: astore 4
    //   165: aload 4
    //   167: invokevirtual 262	com/tencent/map/sdk/a/pf:y	()V
    //   170: aload 4
    //   172: getfield 264	com/tencent/map/sdk/a/pf:b	J
    //   175: lstore_2
    //   176: lload_2
    //   177: lconst_0
    //   178: lcmp
    //   179: ifne +16 -> 195
    //   182: aload 4
    //   184: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   187: aload_0
    //   188: getfield 337	com/tencent/map/sdk/a/lw:d	Lcom/tencent/map/sdk/a/jq;
    //   191: invokevirtual 367	com/tencent/map/sdk/a/jq:c	()V
    //   194: return
    //   195: aload 4
    //   197: getfield 282	com/tencent/map/sdk/a/pf:f	Lcom/tencent/map/sdk/a/lw;
    //   200: new 369	com/tencent/map/sdk/a/pf$30
    //   203: dup
    //   204: aload 4
    //   206: invokespecial 370	com/tencent/map/sdk/a/pf$30:<init>	(Lcom/tencent/map/sdk/a/pf;)V
    //   209: invokevirtual 291	com/tencent/map/sdk/a/lw:a	(Lcom/tencent/map/sdk/a/lw$a;)V
    //   212: aload 4
    //   214: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   217: goto -30 -> 187
    //   220: astore 5
    //   222: aload 4
    //   224: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   227: aload 5
    //   229: athrow
    //   230: astore 4
    //   232: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	lw
    //   0	233	1	paramBoolean	boolean
    //   39	138	2	l1	long
    //   27	196	4	localObject1	Object
    //   230	1	4	localException	java.lang.Exception
    //   142	8	5	localObject2	Object
    //   220	8	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   29	40	142	finally
    //   117	134	142	finally
    //   165	176	220	finally
    //   195	212	220	finally
    //   108	116	230	java/lang/Exception
  }
  
  public final void a(String[] paramArrayOfString)
  {
    if (this.a != null)
    {
      pf localpf = this.a;
      if (localpf.b != 0L) {
        localpf.f.a(new pf.12(localpf, paramArrayOfString));
      }
    }
  }
  
  /* Error */
  public final boolean a(Context arg1, ly paramly, qe paramqe)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: putfield 379	com/tencent/map/sdk/a/lw:p	Lcom/tencent/map/sdk/a/ly;
    //   5: invokestatic 383	com/tencent/map/sdk/a/or:a	()Z
    //   8: ifeq +116 -> 124
    //   11: new 385	java/io/File
    //   14: dup
    //   15: invokestatic 391	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   18: ldc_w 393
    //   21: invokespecial 396	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore 5
    //   26: aload 5
    //   28: invokevirtual 399	java/io/File:exists	()Z
    //   31: ifne +9 -> 40
    //   34: aload 5
    //   36: invokevirtual 402	java/io/File:createNewFile	()Z
    //   39: pop
    //   40: new 404	java/io/FileWriter
    //   43: dup
    //   44: aload 5
    //   46: iconst_1
    //   47: invokespecial 407	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   50: astore 5
    //   52: aload 5
    //   54: new 409	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 410	java/lang/StringBuilder:<init>	()V
    //   61: new 412	java/text/SimpleDateFormat
    //   64: dup
    //   65: ldc_w 414
    //   68: getstatic 420	java/util/Locale:CHINA	Ljava/util/Locale;
    //   71: invokespecial 423	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   74: new 425	java/util/Date
    //   77: dup
    //   78: invokestatic 431	java/lang/System:currentTimeMillis	()J
    //   81: invokespecial 434	java/util/Date:<init>	(J)V
    //   84: invokevirtual 438	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   87: invokevirtual 442	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 444
    //   93: invokevirtual 442	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc_w 446
    //   99: invokevirtual 442	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc_w 448
    //   105: invokevirtual 442	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 452	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokevirtual 456	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   114: aload 5
    //   116: invokevirtual 459	java/io/FileWriter:flush	()V
    //   119: aload 5
    //   121: invokevirtual 462	java/io/FileWriter:close	()V
    //   124: aload_2
    //   125: invokeinterface 467 1 0
    //   130: astore 5
    //   132: aload_0
    //   133: aload 5
    //   135: putfield 469	com/tencent/map/sdk/a/lw:o	Lcom/tencent/map/sdk/a/md;
    //   138: aload_0
    //   139: new 471	com/tencent/map/sdk/a/oz
    //   142: dup
    //   143: invokespecial 472	com/tencent/map/sdk/a/oz:<init>	()V
    //   146: putfield 474	com/tencent/map/sdk/a/lw:b	Lcom/tencent/map/sdk/a/oz;
    //   149: aload_0
    //   150: aload_2
    //   151: invokeinterface 477 1 0
    //   156: putfield 479	com/tencent/map/sdk/a/lw:K	Lcom/tencent/map/sdk/a/lz;
    //   159: aload_0
    //   160: new 481	com/tencent/map/sdk/a/ke
    //   163: dup
    //   164: aload_1
    //   165: aload_0
    //   166: aload 5
    //   168: aload_0
    //   169: getfield 479	com/tencent/map/sdk/a/lw:K	Lcom/tencent/map/sdk/a/lz;
    //   172: invokespecial 484	com/tencent/map/sdk/a/ke:<init>	(Landroid/content/Context;Lcom/tencent/map/sdk/a/lg;Lcom/tencent/map/sdk/a/md;Lcom/tencent/map/sdk/a/lz;)V
    //   175: putfield 486	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   178: aload 5
    //   180: invokeinterface 490 1 0
    //   185: astore_2
    //   186: aload 5
    //   188: invokeinterface 492 1 0
    //   193: astore 6
    //   195: aload 5
    //   197: invokeinterface 494 1 0
    //   202: astore 5
    //   204: aload_0
    //   205: getfield 486	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   208: getfield 497	com/tencent/map/sdk/a/ke:d	Ljava/util/concurrent/locks/Lock;
    //   211: invokeinterface 502 1 0
    //   216: aload_0
    //   217: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   220: aload_1
    //   221: aload_0
    //   222: getfield 486	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   225: aload_2
    //   226: aload 6
    //   228: aload 5
    //   230: invokevirtual 505	com/tencent/map/sdk/a/pf:a	(Landroid/content/Context;Lcom/tencent/map/sdk/a/ke;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   233: istore 4
    //   235: aload_0
    //   236: getfield 486	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   239: invokevirtual 507	com/tencent/map/sdk/a/ke:a	()V
    //   242: aload_0
    //   243: new 509	com/tencent/map/sdk/a/lv
    //   246: dup
    //   247: aload_0
    //   248: aload_0
    //   249: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   252: invokespecial 512	com/tencent/map/sdk/a/lv:<init>	(Lcom/tencent/map/sdk/a/lg;Lcom/tencent/map/sdk/a/pf;)V
    //   255: putfield 514	com/tencent/map/sdk/a/lw:f	Lcom/tencent/map/sdk/a/lv;
    //   258: aload_0
    //   259: getfield 337	com/tencent/map/sdk/a/lw:d	Lcom/tencent/map/sdk/a/jq;
    //   262: ifnonnull +16 -> 278
    //   265: aload_0
    //   266: new 341	com/tencent/map/sdk/a/jq
    //   269: dup
    //   270: aload_0
    //   271: aload_3
    //   272: invokespecial 515	com/tencent/map/sdk/a/jq:<init>	(Lcom/tencent/map/sdk/a/lw;Lcom/tencent/map/sdk/a/qe;)V
    //   275: putfield 337	com/tencent/map/sdk/a/lw:d	Lcom/tencent/map/sdk/a/jq;
    //   278: aload_0
    //   279: getfield 517	com/tencent/map/sdk/a/lw:v	Lcom/tencent/map/sdk/a/id;
    //   282: ifnonnull +24 -> 306
    //   285: aload_0
    //   286: new 519	com/tencent/map/sdk/a/ib
    //   289: dup
    //   290: aload_0
    //   291: aload_0
    //   292: getfield 379	com/tencent/map/sdk/a/lw:p	Lcom/tencent/map/sdk/a/ly;
    //   295: invokeinterface 522 1 0
    //   300: invokespecial 523	com/tencent/map/sdk/a/ib:<init>	(Lcom/tencent/map/sdk/a/lw;Lcom/tencent/map/sdk/a/qe;)V
    //   303: putfield 517	com/tencent/map/sdk/a/lw:v	Lcom/tencent/map/sdk/a/id;
    //   306: aload_0
    //   307: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   310: invokevirtual 249	com/tencent/map/sdk/a/pf:h	()V
    //   313: aload_0
    //   314: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   317: astore_1
    //   318: lconst_0
    //   319: aload_1
    //   320: getfield 264	com/tencent/map/sdk/a/pf:b	J
    //   323: lcmp
    //   324: ifeq +18 -> 342
    //   327: aload_1
    //   328: getfield 282	com/tencent/map/sdk/a/pf:f	Lcom/tencent/map/sdk/a/lw;
    //   331: new 525	com/tencent/map/sdk/a/pf$14
    //   334: dup
    //   335: aload_1
    //   336: invokespecial 526	com/tencent/map/sdk/a/pf$14:<init>	(Lcom/tencent/map/sdk/a/pf;)V
    //   339: invokevirtual 291	com/tencent/map/sdk/a/lw:a	(Lcom/tencent/map/sdk/a/lw$a;)V
    //   342: aload_0
    //   343: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   346: bipush 20
    //   348: invokevirtual 528	com/tencent/map/sdk/a/pf:a	(I)V
    //   351: aload_0
    //   352: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   355: iconst_3
    //   356: invokevirtual 530	com/tencent/map/sdk/a/pf:b	(I)V
    //   359: aload_0
    //   360: getfield 166	com/tencent/map/sdk/a/lw:c	Lcom/tencent/map/sdk/a/kl;
    //   363: astore_2
    //   364: aload_2
    //   365: getfield 532	com/tencent/map/sdk/a/kl:f	Ljava/util/List;
    //   368: astore_1
    //   369: aload_1
    //   370: monitorenter
    //   371: ldc_w 534
    //   374: invokestatic 536	com/tencent/map/sdk/a/or:a	(Ljava/lang/String;)V
    //   377: aload_2
    //   378: getfield 532	com/tencent/map/sdk/a/kl:f	Ljava/util/List;
    //   381: aload_0
    //   382: invokeinterface 539 2 0
    //   387: ifne +14 -> 401
    //   390: aload_2
    //   391: getfield 532	com/tencent/map/sdk/a/kl:f	Ljava/util/List;
    //   394: aload_0
    //   395: invokeinterface 323 2 0
    //   400: pop
    //   401: aload_1
    //   402: monitorexit
    //   403: aload_0
    //   404: aload_0
    //   405: getfield 208	com/tencent/map/sdk/a/lw:G	I
    //   408: aload_0
    //   409: getfield 208	com/tencent/map/sdk/a/lw:G	I
    //   412: invokevirtual 540	com/tencent/map/sdk/a/lw:a	(II)V
    //   415: iload 4
    //   417: ireturn
    //   418: astore 5
    //   420: aload 5
    //   422: invokevirtual 541	java/lang/Exception:printStackTrace	()V
    //   425: goto -301 -> 124
    //   428: astore_1
    //   429: aload_0
    //   430: getfield 486	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   433: invokevirtual 507	com/tencent/map/sdk/a/ke:a	()V
    //   436: aload_1
    //   437: athrow
    //   438: astore_2
    //   439: aload_1
    //   440: monitorexit
    //   441: aload_2
    //   442: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	lw
    //   0	443	2	paramly	ly
    //   0	443	3	paramqe	qe
    //   233	183	4	bool	boolean
    //   24	205	5	localObject	Object
    //   418	3	5	localException	java.lang.Exception
    //   193	34	6	str	String
    // Exception table:
    //   from	to	target	type
    //   11	40	418	java/lang/Exception
    //   40	124	418	java/lang/Exception
    //   204	235	428	finally
    //   371	401	438	finally
    //   401	403	438	finally
    //   439	441	438	finally
  }
  
  /* Error */
  public final boolean a(javax.microedition.khronos.opengles.GL10 paramGL10)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   7: ifnonnull +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: aload_0
    //   13: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   16: astore 7
    //   18: aload 7
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 166	com/tencent/map/sdk/a/lw:c	Lcom/tencent/map/sdk/a/kl;
    //   25: getfield 545	com/tencent/map/sdk/a/kl:a	Lcom/tencent/map/sdk/a/kf;
    //   28: invokevirtual 549	com/tencent/map/sdk/a/kf:d	()Z
    //   31: pop
    //   32: aload_0
    //   33: getfield 181	com/tencent/map/sdk/a/lw:I	Ljava/util/concurrent/LinkedBlockingQueue;
    //   36: invokevirtual 552	java/util/concurrent/LinkedBlockingQueue:size	()I
    //   39: ifeq +57 -> 96
    //   42: iconst_1
    //   43: istore_2
    //   44: iload_2
    //   45: ifeq +51 -> 96
    //   48: aload_0
    //   49: getfield 181	com/tencent/map/sdk/a/lw:I	Ljava/util/concurrent/LinkedBlockingQueue;
    //   52: invokevirtual 556	java/util/concurrent/LinkedBlockingQueue:poll	()Ljava/lang/Object;
    //   55: checkcast 558	com/tencent/map/sdk/a/lw$a
    //   58: astore 8
    //   60: aload 8
    //   62: ifnull +29 -> 91
    //   65: aload 8
    //   67: invokeinterface 559 1 0
    //   72: goto -28 -> 44
    //   75: astore 8
    //   77: aload 8
    //   79: invokevirtual 541	java/lang/Exception:printStackTrace	()V
    //   82: goto -38 -> 44
    //   85: astore_1
    //   86: aload 7
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: iconst_0
    //   92: istore_2
    //   93: goto -49 -> 44
    //   96: aload 7
    //   98: monitorexit
    //   99: aload_0
    //   100: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   103: astore 7
    //   105: aload 7
    //   107: invokevirtual 262	com/tencent/map/sdk/a/pf:y	()V
    //   110: aload 7
    //   112: getfield 264	com/tencent/map/sdk/a/pf:b	J
    //   115: lstore 5
    //   117: lconst_0
    //   118: lload 5
    //   120: lcmp
    //   121: ifne +289 -> 410
    //   124: aload 7
    //   126: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   129: iload 4
    //   131: istore_3
    //   132: aload_0
    //   133: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   136: invokevirtual 561	com/tencent/map/sdk/a/pf:o	()Z
    //   139: ifne +13 -> 152
    //   142: aload_0
    //   143: getfield 89	com/tencent/map/sdk/a/lw:q	Z
    //   146: ifeq +353 -> 499
    //   149: iload 4
    //   151: istore_3
    //   152: iload_3
    //   153: ifeq +475 -> 628
    //   156: aload_0
    //   157: getfield 176	com/tencent/map/sdk/a/lw:H	Lcom/tencent/map/sdk/a/lw$d;
    //   160: invokevirtual 564	com/tencent/map/sdk/a/lw$d:b	()Lcom/tencent/map/sdk/a/lw$e;
    //   163: astore 8
    //   165: aload 8
    //   167: ifnonnull +337 -> 504
    //   170: aload_0
    //   171: getfield 149	com/tencent/map/sdk/a/lw:e	Lcom/tencent/map/sdk/a/lm;
    //   174: aload_1
    //   175: invokevirtual 566	com/tencent/map/sdk/a/lm:a	(Ljavax/microedition/khronos/opengles/GL10;)Z
    //   178: pop
    //   179: aload_0
    //   180: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   183: astore 7
    //   185: aload 7
    //   187: monitorenter
    //   188: aload_0
    //   189: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   192: invokevirtual 567	com/tencent/map/sdk/a/pf:d	()Z
    //   195: pop
    //   196: aload_0
    //   197: iconst_0
    //   198: putfield 89	com/tencent/map/sdk/a/lw:q	Z
    //   201: aload 7
    //   203: monitorexit
    //   204: aload_0
    //   205: getfield 176	com/tencent/map/sdk/a/lw:H	Lcom/tencent/map/sdk/a/lw$d;
    //   208: invokevirtual 568	com/tencent/map/sdk/a/lw$d:a	()Z
    //   211: ifne +50 -> 261
    //   214: aload 8
    //   216: ifnull +45 -> 261
    //   219: aload 8
    //   221: invokevirtual 572	com/tencent/map/sdk/a/lw$e:c	()Z
    //   224: ifne +333 -> 557
    //   227: aload_0
    //   228: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   231: invokevirtual 574	com/tencent/map/sdk/a/pf:f	()Z
    //   234: ifne +13 -> 247
    //   237: aload 8
    //   239: getfield 576	com/tencent/map/sdk/a/lw$e:a	I
    //   242: bipush 100
    //   244: if_icmplt +298 -> 542
    //   247: aload 8
    //   249: iconst_0
    //   250: putfield 576	com/tencent/map/sdk/a/lw$e:a	I
    //   253: aload_0
    //   254: getfield 176	com/tencent/map/sdk/a/lw:H	Lcom/tencent/map/sdk/a/lw$d;
    //   257: aload_1
    //   258: invokevirtual 579	com/tencent/map/sdk/a/lw$d:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   261: aload_0
    //   262: getfield 514	com/tencent/map/sdk/a/lw:f	Lcom/tencent/map/sdk/a/lv;
    //   265: ifnull +363 -> 628
    //   268: aload_0
    //   269: getfield 514	com/tencent/map/sdk/a/lw:f	Lcom/tencent/map/sdk/a/lv;
    //   272: astore 7
    //   274: aload 7
    //   276: getfield 582	com/tencent/map/sdk/a/lv:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   279: ifnull +349 -> 628
    //   282: aload 7
    //   284: getfield 582	com/tencent/map/sdk/a/lv:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   287: invokevirtual 585	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   290: ifle +338 -> 628
    //   293: aload 7
    //   295: getfield 582	com/tencent/map/sdk/a/lv:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   298: invokevirtual 589	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   301: astore 8
    //   303: aload 8
    //   305: invokeinterface 594 1 0
    //   310: ifeq +310 -> 620
    //   313: aload 8
    //   315: invokeinterface 597 1 0
    //   320: checkcast 222	java/lang/Integer
    //   323: invokevirtual 600	java/lang/Integer:intValue	()I
    //   326: istore_2
    //   327: aload 7
    //   329: getfield 603	com/tencent/map/sdk/a/lv:g	Ljava/util/ArrayList;
    //   332: iload_2
    //   333: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   336: invokevirtual 604	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   339: ifne -36 -> 303
    //   342: aload 7
    //   344: getfield 607	com/tencent/map/sdk/a/lv:a	Lcom/tencent/map/sdk/a/lg;
    //   347: invokeinterface 610 1 0
    //   352: astore_1
    //   353: aload 7
    //   355: getfield 613	com/tencent/map/sdk/a/lv:f	Landroid/util/SparseBooleanArray;
    //   358: iload_2
    //   359: invokevirtual 619	android/util/SparseBooleanArray:get	(I)Z
    //   362: istore 4
    //   364: aload_1
    //   365: invokevirtual 262	com/tencent/map/sdk/a/pf:y	()V
    //   368: aload_1
    //   369: getfield 264	com/tencent/map/sdk/a/pf:b	J
    //   372: lstore 5
    //   374: lload 5
    //   376: lconst_0
    //   377: lcmp
    //   378: ifne +188 -> 566
    //   381: aload_1
    //   382: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   385: aload 7
    //   387: getfield 613	com/tencent/map/sdk/a/lv:f	Landroid/util/SparseBooleanArray;
    //   390: iload_2
    //   391: invokevirtual 622	android/util/SparseBooleanArray:delete	(I)V
    //   394: aload 7
    //   396: getfield 582	com/tencent/map/sdk/a/lv:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   399: iload_2
    //   400: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: invokevirtual 625	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   406: pop
    //   407: goto -104 -> 303
    //   410: aload 7
    //   412: monitorenter
    //   413: invokestatic 431	java/lang/System:currentTimeMillis	()J
    //   416: lstore 5
    //   418: aload 7
    //   420: getfield 627	com/tencent/map/sdk/a/pf:g	J
    //   423: lconst_0
    //   424: lcmp
    //   425: ifne +35 -> 460
    //   428: aload 7
    //   430: getfield 269	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   433: aload 7
    //   435: getfield 264	com/tencent/map/sdk/a/pf:b	J
    //   438: dconst_0
    //   439: invokevirtual 631	com/tencent/map/sdk/engine/jni/JNI:nativeUpdateFrame	(JD)V
    //   442: aload 7
    //   444: lload 5
    //   446: putfield 627	com/tencent/map/sdk/a/pf:g	J
    //   449: aload 7
    //   451: monitorexit
    //   452: aload 7
    //   454: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   457: goto -328 -> 129
    //   460: aload 7
    //   462: getfield 269	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   465: aload 7
    //   467: getfield 264	com/tencent/map/sdk/a/pf:b	J
    //   470: lload 5
    //   472: aload 7
    //   474: getfield 627	com/tencent/map/sdk/a/pf:g	J
    //   477: lsub
    //   478: l2d
    //   479: invokevirtual 631	com/tencent/map/sdk/engine/jni/JNI:nativeUpdateFrame	(JD)V
    //   482: goto -40 -> 442
    //   485: astore_1
    //   486: aload 7
    //   488: monitorexit
    //   489: aload_1
    //   490: athrow
    //   491: astore_1
    //   492: aload 7
    //   494: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   497: aload_1
    //   498: athrow
    //   499: iconst_0
    //   500: istore_3
    //   501: goto -349 -> 152
    //   504: aload_0
    //   505: getfield 176	com/tencent/map/sdk/a/lw:H	Lcom/tencent/map/sdk/a/lw$d;
    //   508: ifnull -329 -> 179
    //   511: aload_0
    //   512: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   515: invokevirtual 574	com/tencent/map/sdk/a/pf:f	()Z
    //   518: ifeq -339 -> 179
    //   521: aload_0
    //   522: getfield 176	com/tencent/map/sdk/a/lw:H	Lcom/tencent/map/sdk/a/lw$d;
    //   525: aload_1
    //   526: aload_0
    //   527: getfield 514	com/tencent/map/sdk/a/lw:f	Lcom/tencent/map/sdk/a/lv;
    //   530: invokevirtual 634	com/tencent/map/sdk/a/lw$d:a	(Ljavax/microedition/khronos/opengles/GL10;Lcom/tencent/map/sdk/a/lv;)V
    //   533: goto -354 -> 179
    //   536: astore_1
    //   537: aload 7
    //   539: monitorexit
    //   540: aload_1
    //   541: athrow
    //   542: aload 8
    //   544: aload 8
    //   546: getfield 576	com/tencent/map/sdk/a/lw$e:a	I
    //   549: iconst_1
    //   550: iadd
    //   551: putfield 576	com/tencent/map/sdk/a/lw$e:a	I
    //   554: goto -293 -> 261
    //   557: aload 8
    //   559: iconst_0
    //   560: putfield 576	com/tencent/map/sdk/a/lw$e:a	I
    //   563: goto -302 -> 261
    //   566: iload_2
    //   567: iconst_m1
    //   568: if_icmpne +10 -> 578
    //   571: aload_1
    //   572: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   575: goto -190 -> 385
    //   578: aload_1
    //   579: monitorenter
    //   580: aload_1
    //   581: getfield 269	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   584: aload_1
    //   585: getfield 264	com/tencent/map/sdk/a/pf:b	J
    //   588: iload_2
    //   589: i2l
    //   590: iload 4
    //   592: invokevirtual 638	com/tencent/map/sdk/engine/jni/JNI:nativeDeleteLine	(JJZ)V
    //   595: aload_1
    //   596: monitorexit
    //   597: aload_1
    //   598: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   601: goto -216 -> 385
    //   604: astore 7
    //   606: aload_1
    //   607: monitorexit
    //   608: aload 7
    //   610: athrow
    //   611: astore 7
    //   613: aload_1
    //   614: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   617: aload 7
    //   619: athrow
    //   620: aload 7
    //   622: getfield 603	com/tencent/map/sdk/a/lv:g	Ljava/util/ArrayList;
    //   625: invokevirtual 641	java/util/ArrayList:clear	()V
    //   628: aload_0
    //   629: getfield 514	com/tencent/map/sdk/a/lw:f	Lcom/tencent/map/sdk/a/lv;
    //   632: ifnull +10 -> 642
    //   635: aload_0
    //   636: getfield 514	com/tencent/map/sdk/a/lw:f	Lcom/tencent/map/sdk/a/lv;
    //   639: invokevirtual 642	com/tencent/map/sdk/a/lv:a	()V
    //   642: iload_3
    //   643: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	lw
    //   0	644	1	paramGL10	javax.microedition.khronos.opengles.GL10
    //   43	546	2	i1	int
    //   131	512	3	bool1	boolean
    //   1	590	4	bool2	boolean
    //   115	356	5	l1	long
    //   604	5	7	localObject2	Object
    //   611	10	7	localObject3	Object
    //   58	8	8	locala	lw.a
    //   75	3	8	localException	java.lang.Exception
    //   163	395	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   65	72	75	java/lang/Exception
    //   21	42	85	finally
    //   48	60	85	finally
    //   65	72	85	finally
    //   77	82	85	finally
    //   86	89	85	finally
    //   96	99	85	finally
    //   413	442	485	finally
    //   442	452	485	finally
    //   460	482	485	finally
    //   486	489	485	finally
    //   105	117	491	finally
    //   410	413	491	finally
    //   489	491	491	finally
    //   188	204	536	finally
    //   537	540	536	finally
    //   580	597	604	finally
    //   606	608	604	finally
    //   364	374	611	finally
    //   578	580	611	finally
    //   608	611	611	finally
  }
  
  public final kl b()
  {
    return this.c;
  }
  
  public final void b(int paramInt)
  {
    if ((this.a != null) && (this.J != null)) {
      if ((Integer)this.J.a(Integer.valueOf(paramInt)) == null) {
        break label118;
      }
    }
    label118:
    for (int i1 = ((Integer)this.J.a(Integer.valueOf(paramInt))).intValue();; i1 = 0)
    {
      pf localpf = this.a;
      try
      {
        localpf.y();
        if ((localpf.b != 0L) && (paramInt >= 0))
        {
          lw locallw = localpf.f;
          if (locallw != null) {}
        }
        else
        {
          return;
        }
        localpf.f.a(new pf.10(localpf, paramInt, i1));
        return;
      }
      finally
      {
        localpf.z();
      }
    }
  }
  
  /* Error */
  public final void b(Polygon2D paramPolygon2D)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   4: ifnull +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: aload_0
    //   13: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   16: astore 4
    //   18: aload 4
    //   20: invokevirtual 262	com/tencent/map/sdk/a/pf:y	()V
    //   23: aload 4
    //   25: getfield 264	com/tencent/map/sdk/a/pf:b	J
    //   28: lstore_2
    //   29: lload_2
    //   30: lconst_0
    //   31: lcmp
    //   32: ifne +9 -> 41
    //   35: aload 4
    //   37: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   40: return
    //   41: aload 4
    //   43: monitorenter
    //   44: aload 4
    //   46: getfield 269	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   49: aload 4
    //   51: getfield 264	com/tencent/map/sdk/a/pf:b	J
    //   54: aload_1
    //   55: getfield 655	com/tencent/map/sdk/engine/jni/models/Polygon2D:polygonId	I
    //   58: aload_1
    //   59: getfield 231	com/tencent/map/sdk/engine/jni/models/Polygon2D:borldLineId	I
    //   62: aload_1
    //   63: invokevirtual 659	com/tencent/map/sdk/engine/jni/JNI:nativeUpdatePolygon	(JIILcom/tencent/map/sdk/engine/jni/models/Polygon2D;)V
    //   66: aload 4
    //   68: monitorexit
    //   69: aload 4
    //   71: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   74: return
    //   75: astore_1
    //   76: aload 4
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    //   81: astore_1
    //   82: aload 4
    //   84: invokevirtual 266	com/tencent/map/sdk/a/pf:z	()V
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	lw
    //   0	89	1	paramPolygon2D	Polygon2D
    //   28	2	2	l1	long
    //   16	67	4	localpf	pf
    // Exception table:
    //   from	to	target	type
    //   44	69	75	finally
    //   76	79	75	finally
    //   18	29	81	finally
    //   41	44	81	finally
    //   79	81	81	finally
  }
  
  public final void b(boolean paramBoolean)
  {
    if (this.L == paramBoolean) {}
    do
    {
      return;
      this.L = paramBoolean;
    } while (this.a == null);
    this.a.a(paramBoolean);
  }
  
  public final WeakReference<lf> c()
  {
    return this.g;
  }
  
  public final void c(boolean paramBoolean)
  {
    pf localpf;
    if (this.a != null)
    {
      localpf = this.a;
      if ((localpf.b != 0L) && (localpf.f != null)) {}
    }
    else
    {
      return;
    }
    localpf.f.a(new pf.9(localpf, paramBoolean));
  }
  
  public final lm d()
  {
    return this.e;
  }
  
  public final void d(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.c(paramBoolean);
    }
  }
  
  public final fu e()
  {
    return this.h;
  }
  
  public final void e(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.d(paramBoolean);
    }
  }
  
  public final kc f()
  {
    return this.n;
  }
  
  public final pf g()
  {
    return this.a;
  }
  
  public final Rect h()
  {
    return this.i;
  }
  
  public final float i()
  {
    if (this.l == null) {
      return 1.0F;
    }
    return pz.a(this.l);
  }
  
  public final void j()
  {
    if (this.D != null)
    {
      ??? = this.D;
      if ((((iy)???).b != null) && (!((iy)???).b.isEmpty())) {
        break label429;
      }
    }
    for (;;)
    {
      ??? = this.l;
      if (??? != null)
      {
        ??? = new File(QStorageManager.getInstance((Context)???).getDataDir().getPath() + "/tile/");
        if (((File)???).exists())
        {
          ??? = ((File)???).listFiles();
          if ((??? != null) && (???.length != 0)) {
            break label490;
          }
        }
      }
      a(null);
      this.C = null;
      ??? = this.c;
      lw.b localb;
      synchronized (((kl)???).f)
      {
        or.a("skew addSkewListener");
        ((kl)???).f.remove(this);
        this.F.clear();
        if (this.u != null)
        {
          ??? = this.u;
          ??? = ((lw.c)???).c;
          if (((lw)???).t == null) {
            ((lw)???).t = new lw.b((lw)???);
          }
          localb = ((lw)???).t;
          if (??? == null) {}
        }
      }
      synchronized (localb.a)
      {
        if (localb.a.contains(???)) {
          localb.a.remove(???);
        }
        ??? = this.c;
        if (((kl)???).a != null)
        {
          ??? = ((kl)???).a;
          if (((kf)???).a != null) {
            ((kf)???).a.destroy();
          }
        }
        this.r = true;
        if (this.v != null) {
          this.v.e();
        }
        if (this.d != null) {
          this.d.c();
        }
        if (this.a != null) {
          ??? = this.a;
        }
        try
        {
          ((pf)???).A();
          ((pf)???).d.a();
          if (((pf)???).d != null) {
            ((pf)???).d.c.remove(???);
          }
          if (((pf)???).b != 0L)
          {
            ((pf)???).a.nativeDestroyEngine(((pf)???).b);
            ((pf)???).b = 0L;
          }
          ((pf)???).f = null;
          ((pf)???).B();
          this.l = null;
          return;
        }
        finally
        {
          label429:
          int i1;
          long l1;
          int i2;
          localObject2.B();
        }
        ??? = (ix[])((iy)???).b.values().toArray(new ix[((iy)???).b.keySet().size()]);
        i1 = 0;
        while (i1 < ???.length)
        {
          ???[i1].b();
          i1 += 1;
        }
        label490:
        l1 = System.currentTimeMillis();
        i2 = ???.length;
        i1 = 0;
        while (i1 < i2)
        {
          ??? = ???[i1];
          if (l1 - ((File)???).lastModified() > TimeUnit.DAYS.toMillis(7L)) {
            om.b((File)???);
          }
          i1 += 1;
        }
        localObject4 = finally;
        throw localObject4;
      }
    }
  }
  
  public final void k()
  {
    this.c.a.b();
    this.q = true;
  }
  
  public final String l()
  {
    String str = null;
    if (this.a != null) {
      str = this.a.u();
    }
    return str;
  }
  
  public final String toString()
  {
    if (this.n != null) {
      return this.n.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.lw
 * JD-Core Version:    0.7.0.1
 */