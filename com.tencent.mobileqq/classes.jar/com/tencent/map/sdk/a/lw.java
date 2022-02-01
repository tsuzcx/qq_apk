package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import com.tencent.map.sdk.engine.jni.JNI;
import com.tencent.map.sdk.engine.jni.models.CircleInfo;
import com.tencent.map.sdk.engine.jni.models.Polygon2D;
import com.tencent.tencentmap.io.QStorageManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.opengles.GL10;

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
    paramContext = this.l;
    if (paramContext != null)
    {
      double d1 = paramContext.getResources().getDisplayMetrics().density * 6.0F;
      Double.isNaN(d1);
      this.G = ((int)(d1 + 0.5D));
      return;
    }
    this.G = 6;
  }
  
  public final int a(CircleInfo paramCircleInfo)
  {
    pf localpf = this.a;
    if ((localpf != null) && (paramCircleInfo != null)) {
      return localpf.a(paramCircleInfo);
    }
    return -1;
  }
  
  public final int a(Polygon2D paramPolygon2D)
  {
    pf localpf = this.a;
    if ((localpf != null) && (paramPolygon2D != null))
    {
      int i1 = localpf.a(paramPolygon2D);
      if (this.J == null) {
        this.J = new ox();
      }
      this.J.a(Integer.valueOf(i1), Integer.valueOf(paramPolygon2D.borldLineId));
      return i1;
    }
    return -1;
  }
  
  public final void a() {}
  
  public final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.M = paramFloat1;
    this.N = paramFloat2;
    double d5 = paramFloat1;
    double d2 = paramFloat2;
    Rect localRect = this.i;
    double d4 = d5;
    double d3 = d2;
    if (localRect != null)
    {
      double d1 = d2;
      if (this.z > 0)
      {
        Double.isNaN(d2);
        d1 = localRect.height();
        Double.isNaN(d1);
        d3 = this.z;
        Double.isNaN(d3);
        d1 = 0.5D - (0.5D - d2) * d1 / d3;
      }
      d4 = d5;
      d3 = d1;
      if (this.y > 0)
      {
        Double.isNaN(d5);
        d2 = this.i.width();
        Double.isNaN(d2);
        d3 = this.y;
        Double.isNaN(d3);
        d4 = 0.5D - (0.5D - d5) * d2 / d3;
        d3 = d1;
      }
    }
    this.a.a((float)d4, (float)d3, paramBoolean);
  }
  
  public final void a(int paramInt)
  {
    pf localpf = this.a;
    if (localpf == null) {
      return;
    }
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
    pf localpf = this.a;
    if (localpf != null) {
      localpf.a(paramInt1 + 50, paramInt2 + 50);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    pf localpf = this.a;
    if ((0L != localpf.b) && (localpf.f != null)) {
      localpf.f.a(new pf.23(localpf, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    this.y = paramInt3;
    this.z = paramInt4;
    if (paramBoolean) {
      a(this.M, this.N, this.O);
    }
  }
  
  public final void a(int paramInt, CircleInfo paramCircleInfo)
  {
    pf localpf = this.a;
    if (localpf != null)
    {
      if (paramCircleInfo == null) {
        return;
      }
      if (localpf.b != 0L) {
        try
        {
          localpf.a.nativeUpdateCircle(localpf.b, paramInt, paramCircleInfo);
          return;
        }
        finally {}
      }
    }
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
    pf localpf = this.a;
    if (localpf != null) {
      localpf.e = parammg;
    }
  }
  
  public final void a(mi parammi)
  {
    List localList = this.F;
    if (localList != null) {
      localList.add(parammi);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    pf localpf = this.a;
    if (localpf == null) {
      return;
    }
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
  
  public final void a(boolean paramBoolean)
  {
    long l1;
    if (this.d != null)
    {
      this.k = paramBoolean;
      if (paramBoolean)
      {
        localObject1 = this.a;
        if (localObject1 != null) {
          try
          {
            ((pf)localObject1).y();
            l1 = ((pf)localObject1).b;
            if (l1 == 0L) {}
            for (;;)
            {
              ((pf)localObject1).z();
              break;
              ((pf)localObject1).f.a(new pf.29((pf)localObject1));
            }
            localObject1 = this.d;
          }
          finally
          {
            ((pf)localObject1).z();
          }
        }
        if (((jq)localObject1).a == null) {
          break label221;
        }
        ((jq)localObject1).a.c.a((he)localObject1);
        if (((jq)localObject1).b == null) {
          ((jq)localObject1).b = new jp(((jq)localObject1).a, ((jq)localObject1).c);
        }
      }
    }
    try
    {
      ((jq)localObject1).b.start();
      return;
    }
    catch (Exception localException) {}
    Object localObject1 = this.a;
    if (localObject1 != null) {
      try
      {
        ((pf)localObject1).y();
        l1 = ((pf)localObject1).b;
        if (l1 == 0L) {}
        for (;;)
        {
          ((pf)localObject1).z();
          break;
          ((pf)localObject1).f.a(new pf.30((pf)localObject1));
        }
        this.d.c();
      }
      finally
      {
        ((pf)localObject1).z();
      }
    }
    label221:
    return;
  }
  
  public final void a(String[] paramArrayOfString)
  {
    pf localpf = this.a;
    if ((localpf != null) && (localpf.b != 0L)) {
      localpf.f.a(new pf.12(localpf, paramArrayOfString));
    }
  }
  
  /* Error */
  public final boolean a(Context arg1, ly paramly, qe paramqe)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: putfield 371	com/tencent/map/sdk/a/lw:p	Lcom/tencent/map/sdk/a/ly;
    //   5: invokestatic 376	com/tencent/map/sdk/a/or:a	()Z
    //   8: ifeq +142 -> 150
    //   11: new 378	java/io/File
    //   14: dup
    //   15: invokestatic 384	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   18: ldc_w 386
    //   21: invokespecial 389	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore 6
    //   26: aload 6
    //   28: invokevirtual 392	java/io/File:exists	()Z
    //   31: ifne +9 -> 40
    //   34: aload 6
    //   36: invokevirtual 395	java/io/File:createNewFile	()Z
    //   39: pop
    //   40: new 397	java/io/FileWriter
    //   43: dup
    //   44: aload 6
    //   46: iconst_1
    //   47: invokespecial 400	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   50: astore 6
    //   52: new 402	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 403	java/lang/StringBuilder:<init>	()V
    //   59: astore 7
    //   61: aload 7
    //   63: new 405	java/text/SimpleDateFormat
    //   66: dup
    //   67: ldc_w 407
    //   70: getstatic 413	java/util/Locale:CHINA	Ljava/util/Locale;
    //   73: invokespecial 416	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   76: new 418	java/util/Date
    //   79: dup
    //   80: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   83: invokespecial 427	java/util/Date:<init>	(J)V
    //   86: invokevirtual 431	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   89: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 7
    //   95: ldc_w 437
    //   98: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 7
    //   104: ldc_w 439
    //   107: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 7
    //   113: ldc_w 441
    //   116: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 6
    //   122: aload 7
    //   124: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokevirtual 449	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   130: aload 6
    //   132: invokevirtual 452	java/io/FileWriter:flush	()V
    //   135: aload 6
    //   137: invokevirtual 455	java/io/FileWriter:close	()V
    //   140: goto +10 -> 150
    //   143: astore 6
    //   145: aload 6
    //   147: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   150: aload_2
    //   151: invokeinterface 461 1 0
    //   156: astore 6
    //   158: aload_0
    //   159: aload 6
    //   161: putfield 463	com/tencent/map/sdk/a/lw:o	Lcom/tencent/map/sdk/a/md;
    //   164: aload_0
    //   165: new 465	com/tencent/map/sdk/a/oz
    //   168: dup
    //   169: invokespecial 466	com/tencent/map/sdk/a/oz:<init>	()V
    //   172: putfield 468	com/tencent/map/sdk/a/lw:b	Lcom/tencent/map/sdk/a/oz;
    //   175: aload_0
    //   176: aload_2
    //   177: invokeinterface 471 1 0
    //   182: putfield 473	com/tencent/map/sdk/a/lw:K	Lcom/tencent/map/sdk/a/lz;
    //   185: aload_0
    //   186: new 475	com/tencent/map/sdk/a/ke
    //   189: dup
    //   190: aload_1
    //   191: aload_0
    //   192: aload 6
    //   194: aload_0
    //   195: getfield 473	com/tencent/map/sdk/a/lw:K	Lcom/tencent/map/sdk/a/lz;
    //   198: invokespecial 478	com/tencent/map/sdk/a/ke:<init>	(Landroid/content/Context;Lcom/tencent/map/sdk/a/lg;Lcom/tencent/map/sdk/a/md;Lcom/tencent/map/sdk/a/lz;)V
    //   201: putfield 480	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   204: aload 6
    //   206: invokeinterface 484 1 0
    //   211: astore_2
    //   212: aload 6
    //   214: invokeinterface 486 1 0
    //   219: astore 7
    //   221: aload 6
    //   223: invokeinterface 488 1 0
    //   228: astore 6
    //   230: aload_0
    //   231: getfield 480	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   234: getfield 491	com/tencent/map/sdk/a/ke:d	Ljava/util/concurrent/locks/Lock;
    //   237: invokeinterface 496 1 0
    //   242: aload_0
    //   243: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   246: aload_1
    //   247: aload_0
    //   248: getfield 480	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   251: aload_2
    //   252: aload 7
    //   254: aload 6
    //   256: invokevirtual 499	com/tencent/map/sdk/a/pf:a	(Landroid/content/Context;Lcom/tencent/map/sdk/a/ke;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   259: istore 5
    //   261: aload_0
    //   262: getfield 480	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   265: invokevirtual 501	com/tencent/map/sdk/a/ke:a	()V
    //   268: aload_0
    //   269: new 503	com/tencent/map/sdk/a/lv
    //   272: dup
    //   273: aload_0
    //   274: aload_0
    //   275: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   278: invokespecial 506	com/tencent/map/sdk/a/lv:<init>	(Lcom/tencent/map/sdk/a/lg;Lcom/tencent/map/sdk/a/pf;)V
    //   281: putfield 508	com/tencent/map/sdk/a/lw:f	Lcom/tencent/map/sdk/a/lv;
    //   284: aload_0
    //   285: getfield 329	com/tencent/map/sdk/a/lw:d	Lcom/tencent/map/sdk/a/jq;
    //   288: ifnonnull +16 -> 304
    //   291: aload_0
    //   292: new 338	com/tencent/map/sdk/a/jq
    //   295: dup
    //   296: aload_0
    //   297: aload_3
    //   298: invokespecial 509	com/tencent/map/sdk/a/jq:<init>	(Lcom/tencent/map/sdk/a/lw;Lcom/tencent/map/sdk/a/qe;)V
    //   301: putfield 329	com/tencent/map/sdk/a/lw:d	Lcom/tencent/map/sdk/a/jq;
    //   304: aload_0
    //   305: getfield 511	com/tencent/map/sdk/a/lw:v	Lcom/tencent/map/sdk/a/id;
    //   308: ifnonnull +24 -> 332
    //   311: aload_0
    //   312: new 513	com/tencent/map/sdk/a/ib
    //   315: dup
    //   316: aload_0
    //   317: aload_0
    //   318: getfield 371	com/tencent/map/sdk/a/lw:p	Lcom/tencent/map/sdk/a/ly;
    //   321: invokeinterface 516 1 0
    //   326: invokespecial 517	com/tencent/map/sdk/a/ib:<init>	(Lcom/tencent/map/sdk/a/lw;Lcom/tencent/map/sdk/a/qe;)V
    //   329: putfield 511	com/tencent/map/sdk/a/lw:v	Lcom/tencent/map/sdk/a/id;
    //   332: aload_0
    //   333: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   336: invokevirtual 519	com/tencent/map/sdk/a/pf:h	()V
    //   339: aload_0
    //   340: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   343: astore_1
    //   344: lconst_0
    //   345: aload_1
    //   346: getfield 255	com/tencent/map/sdk/a/pf:b	J
    //   349: lcmp
    //   350: ifeq +18 -> 368
    //   353: aload_1
    //   354: getfield 273	com/tencent/map/sdk/a/pf:f	Lcom/tencent/map/sdk/a/lw;
    //   357: new 521	com/tencent/map/sdk/a/pf$14
    //   360: dup
    //   361: aload_1
    //   362: invokespecial 522	com/tencent/map/sdk/a/pf$14:<init>	(Lcom/tencent/map/sdk/a/pf;)V
    //   365: invokevirtual 281	com/tencent/map/sdk/a/lw:a	(Lcom/tencent/map/sdk/a/lw$a;)V
    //   368: aload_0
    //   369: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   372: bipush 20
    //   374: invokevirtual 524	com/tencent/map/sdk/a/pf:a	(I)V
    //   377: aload_0
    //   378: getfield 130	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   381: iconst_3
    //   382: invokevirtual 526	com/tencent/map/sdk/a/pf:b	(I)V
    //   385: aload_0
    //   386: getfield 166	com/tencent/map/sdk/a/lw:c	Lcom/tencent/map/sdk/a/kl;
    //   389: astore_2
    //   390: aload_2
    //   391: getfield 528	com/tencent/map/sdk/a/kl:f	Ljava/util/List;
    //   394: astore_1
    //   395: aload_1
    //   396: monitorenter
    //   397: ldc_w 530
    //   400: invokestatic 532	com/tencent/map/sdk/a/or:a	(Ljava/lang/String;)V
    //   403: aload_2
    //   404: getfield 528	com/tencent/map/sdk/a/kl:f	Ljava/util/List;
    //   407: aload_0
    //   408: invokeinterface 535 2 0
    //   413: ifne +14 -> 427
    //   416: aload_2
    //   417: getfield 528	com/tencent/map/sdk/a/kl:f	Ljava/util/List;
    //   420: aload_0
    //   421: invokeinterface 315 2 0
    //   426: pop
    //   427: aload_1
    //   428: monitorexit
    //   429: aload_0
    //   430: getfield 214	com/tencent/map/sdk/a/lw:G	I
    //   433: istore 4
    //   435: aload_0
    //   436: iload 4
    //   438: iload 4
    //   440: invokevirtual 536	com/tencent/map/sdk/a/lw:a	(II)V
    //   443: iload 5
    //   445: ireturn
    //   446: astore_2
    //   447: aload_1
    //   448: monitorexit
    //   449: aload_2
    //   450: athrow
    //   451: astore_1
    //   452: aload_0
    //   453: getfield 480	com/tencent/map/sdk/a/lw:m	Lcom/tencent/map/sdk/a/ke;
    //   456: invokevirtual 501	com/tencent/map/sdk/a/ke:a	()V
    //   459: aload_1
    //   460: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	this	lw
    //   0	461	2	paramly	ly
    //   0	461	3	paramqe	qe
    //   433	6	4	i1	int
    //   259	185	5	bool	boolean
    //   24	112	6	localObject1	Object
    //   143	3	6	localException	Exception
    //   156	99	6	localObject2	Object
    //   59	194	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	40	143	java/lang/Exception
    //   40	140	143	java/lang/Exception
    //   397	427	446	finally
    //   427	429	446	finally
    //   447	449	446	finally
    //   230	261	451	finally
  }
  
  public final boolean a(GL10 paramGL10)
  {
    ??? = this.a;
    if (??? == null) {
      return false;
    }
    for (;;)
    {
      try
      {
        this.c.a.d();
        if (this.I.size() == 0) {
          continue;
        }
        i1 = 1;
      }
      finally
      {
        lw.a locala;
        long l1;
        boolean bool1;
        Object localObject4;
        boolean bool2;
        continue;
        throw paramGL10;
        continue;
        int i1 = 0;
        continue;
      }
      if (i1 == 0) {
        continue;
      }
      locala = (lw.a)this.I.poll();
      if (locala == null) {
        continue;
      }
      try
      {
        locala.a();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    ??? = this.a;
    try
    {
      ((pf)???).y();
      l1 = ((pf)???).b;
      if (0L == l1) {}
      for (;;)
      {
        ((pf)???).z();
        try
        {
          l1 = System.currentTimeMillis();
          if (((pf)???).g == 0L) {
            ((pf)???).a.nativeUpdateFrame(((pf)???).b, 0.0D);
          } else {
            ((pf)???).a.nativeUpdateFrame(((pf)???).b, l1 - ((pf)???).g);
          }
          ((pf)???).g = l1;
        }
        finally {}
      }
      if ((!this.a.o()) && (!this.q)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if (bool1)
      {
        localObject4 = this.H.b();
        if (localObject4 == null) {
          this.e.a(paramGL10);
        } else if ((this.H != null) && (this.a.f())) {
          this.H.a(paramGL10, this.f);
        }
        synchronized (this.a)
        {
          this.a.d();
          this.q = false;
          if ((!this.H.a()) && (localObject4 != null)) {
            if (!((lw.e)localObject4).c())
            {
              if ((!this.a.f()) && (((lw.e)localObject4).a < 100))
              {
                ((lw.e)localObject4).a += 1;
              }
              else
              {
                ((lw.e)localObject4).a = 0;
                this.H.a(paramGL10);
              }
            }
            else {
              ((lw.e)localObject4).a = 0;
            }
          }
          ??? = this.f;
          if ((??? != null) && (((lv)???).e != null) && (((lv)???).e.size() > 0))
          {
            localObject4 = ((lv)???).e.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              i1 = ((Integer)((Iterator)localObject4).next()).intValue();
              if (!((lv)???).g.contains(Integer.valueOf(i1)))
              {
                paramGL10 = ((lv)???).a.g();
                bool2 = ((lv)???).f.get(i1);
                try
                {
                  paramGL10.y();
                  l1 = paramGL10.b;
                  if (l1 == 0L) {}
                  for (;;)
                  {
                    paramGL10.z();
                    break label532;
                    if (i1 != -1) {}
                    label532:
                    try
                    {
                      paramGL10.a.nativeDeleteLine(paramGL10.b, i1, bool2);
                    }
                    finally {}
                  }
                  ((lv)???).f.delete(i1);
                  ((lv)???).e.remove(Integer.valueOf(i1));
                }
                finally {}
              }
            }
            localObject3.g.clear();
          }
        }
      }
      paramGL10 = this.f;
      if (paramGL10 != null) {}
      return bool1;
    }
    finally
    {
      localObject3.z();
    }
  }
  
  public final kl b()
  {
    return this.c;
  }
  
  public final void b(int paramInt)
  {
    if (this.a != null)
    {
      Object localObject1 = this.J;
      if (localObject1 != null)
      {
        int i1 = 0;
        if ((Integer)((ox)localObject1).a(Integer.valueOf(paramInt)) != null) {
          i1 = ((Integer)this.J.a(Integer.valueOf(paramInt))).intValue();
        }
        localObject1 = this.a;
        try
        {
          ((pf)localObject1).y();
          if ((((pf)localObject1).b != 0L) && (paramInt >= 0) && (((pf)localObject1).f != null))
          {
            ((pf)localObject1).f.a(new pf.10((pf)localObject1, paramInt, i1));
            return;
          }
          return;
        }
        finally
        {
          ((pf)localObject1).z();
        }
      }
    }
  }
  
  public final void b(Polygon2D paramPolygon2D)
  {
    pf localpf = this.a;
    if (localpf != null)
    {
      if (paramPolygon2D == null) {
        return;
      }
      try
      {
        localpf.y();
        long l1 = localpf.b;
        if (l1 == 0L) {
          return;
        }
        try
        {
          localpf.a.nativeUpdatePolygon(localpf.b, paramPolygon2D.polygonId, paramPolygon2D.borldLineId, paramPolygon2D);
          return;
        }
        finally {}
        return;
      }
      finally
      {
        localpf.z();
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    if (this.L == paramBoolean) {
      return;
    }
    this.L = paramBoolean;
    pf localpf = this.a;
    if (localpf != null) {
      localpf.a(paramBoolean);
    }
  }
  
  public final WeakReference<lf> c()
  {
    return this.g;
  }
  
  public final void c(boolean paramBoolean)
  {
    pf localpf = this.a;
    if ((localpf != null) && (localpf.b != 0L))
    {
      if (localpf.f == null) {
        return;
      }
      localpf.f.a(new pf.9(localpf, paramBoolean));
    }
  }
  
  public final lm d()
  {
    return this.e;
  }
  
  public final void d(boolean paramBoolean)
  {
    pf localpf = this.a;
    if (localpf != null) {
      localpf.c(paramBoolean);
    }
  }
  
  public final fu e()
  {
    return this.h;
  }
  
  public final void e(boolean paramBoolean)
  {
    pf localpf = this.a;
    if (localpf != null) {
      localpf.d(paramBoolean);
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
    Context localContext = this.l;
    if (localContext == null) {
      return 1.0F;
    }
    return pz.a(localContext);
  }
  
  public final void j()
  {
    ??? = this.D;
    int i2 = 0;
    int i1;
    if ((??? != null) && (((iy)???).b != null) && (!((iy)???).b.isEmpty()))
    {
      ??? = (ix[])((iy)???).b.values().toArray(new ix[((iy)???).b.keySet().size()]);
      i1 = 0;
      while (i1 < ???.length)
      {
        ???[i1].b();
        i1 += 1;
      }
    }
    ??? = this.l;
    if (??? != null)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(QStorageManager.getInstance((Context)???).getDataDir().getPath());
      ((StringBuilder)???).append("/tile/");
      ??? = new File(((StringBuilder)???).toString());
      if (((File)???).exists())
      {
        ??? = ((File)???).listFiles();
        if ((??? != null) && (???.length != 0))
        {
          long l1 = System.currentTimeMillis();
          int i3 = ???.length;
          i1 = i2;
          while (i1 < i3)
          {
            ??? = ???[i1];
            if (l1 - ((File)???).lastModified() > TimeUnit.DAYS.toMillis(7L)) {
              om.b((File)???);
            }
            i1 += 1;
          }
        }
      }
    }
    a(null);
    this.C = null;
    ??? = this.c;
    Object localObject3;
    synchronized (((kl)???).f)
    {
      or.a("skew addSkewListener");
      ((kl)???).f.remove(this);
      this.F.clear();
      ??? = this.u;
      if (??? != null)
      {
        ??? = ((lw.c)???).c;
        if (((lw)???).t == null) {
          ((lw)???).t = new lw.b((lw)???);
        }
        lw.b localb = ((lw)???).t;
        if (??? != null) {
          synchronized (localb.a)
          {
            if (localb.a.contains(???)) {
              localb.a.remove(???);
            }
          }
        }
      }
      localObject3 = this.c;
      if (((kl)localObject3).a != null)
      {
        localObject3 = ((kl)localObject3).a;
        if (((kf)localObject3).a != null) {
          ((kf)localObject3).a.destroy();
        }
      }
      this.r = true;
      localObject3 = this.v;
      if (localObject3 != null) {
        ((id)localObject3).e();
      }
      localObject3 = this.d;
      if (localObject3 != null) {
        ((jq)localObject3).c();
      }
      localObject3 = this.a;
      if (localObject3 != null) {
        try
        {
          ((pf)localObject3).A();
          ((pf)localObject3).d.a();
          if (((pf)localObject3).d != null) {
            ((pf)localObject3).d.c.remove(localObject3);
          }
          if (((pf)localObject3).b != 0L)
          {
            ((pf)localObject3).a.nativeDestroyEngine(((pf)localObject3).b);
            ((pf)localObject3).b = 0L;
          }
          ((pf)localObject3).f = null;
        }
        finally
        {
          ((pf)localObject3).B();
        }
      }
      this.l = null;
      return;
    }
    for (;;)
    {
      throw localObject6;
    }
  }
  
  public final void k()
  {
    this.c.a.b();
    this.q = true;
  }
  
  public final String l()
  {
    pf localpf = this.a;
    if (localpf != null) {
      return localpf.u();
    }
    return null;
  }
  
  public final String toString()
  {
    kc localkc = this.n;
    if (localkc != null) {
      return localkc.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.lw
 * JD-Core Version:    0.7.0.1
 */