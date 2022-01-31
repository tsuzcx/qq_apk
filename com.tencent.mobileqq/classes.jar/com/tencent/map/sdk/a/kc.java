package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;

public final class kc
  implements Cloneable
{
  public int a = -1;
  public kc.a b = new kc.a();
  public Rect c = new Rect();
  public int d;
  public double e;
  public double f;
  public double g = 0.0D;
  public double h = 1.0D;
  public double i = 0.0D;
  public double j = 1.0D;
  public double k = 0.0D;
  public double l = 1.0D;
  public GeoPoint m = new GeoPoint();
  public Rect n;
  public lw o;
  public pf p;
  public DoublePoint q = new DoublePoint();
  public kc.b r;
  private Integer s = Integer.valueOf(0);
  
  public kc(lw paramlw)
  {
    this.o = paramlw;
    this.p = paramlw.a;
  }
  
  /* Error */
  public final float a(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	com/tencent/map/sdk/a/kc:p	Lcom/tencent/map/sdk/a/pf;
    //   4: invokevirtual 97	com/tencent/map/sdk/a/pf:q	()F
    //   7: fload_1
    //   8: fcmpl
    //   9: ifne +5 -> 14
    //   12: fload_1
    //   13: freturn
    //   14: fload_1
    //   15: ldc 98
    //   17: frem
    //   18: fstore 4
    //   20: fload_1
    //   21: f2d
    //   22: invokestatic 104	java/lang/Math:toRadians	(D)D
    //   25: dstore_2
    //   26: aload_0
    //   27: dload_2
    //   28: invokestatic 107	java/lang/Math:sin	(D)D
    //   31: putfield 42	com/tencent/map/sdk/a/kc:g	D
    //   34: aload_0
    //   35: dload_2
    //   36: invokestatic 110	java/lang/Math:cos	(D)D
    //   39: putfield 44	com/tencent/map/sdk/a/kc:h	D
    //   42: aload_0
    //   43: getfield 90	com/tencent/map/sdk/a/kc:p	Lcom/tencent/map/sdk/a/pf;
    //   46: ifnull +33 -> 79
    //   49: aload_0
    //   50: getfield 90	com/tencent/map/sdk/a/kc:p	Lcom/tencent/map/sdk/a/pf;
    //   53: astore 7
    //   55: aload 7
    //   57: invokevirtual 113	com/tencent/map/sdk/a/pf:y	()V
    //   60: aload 7
    //   62: getfield 116	com/tencent/map/sdk/a/pf:b	J
    //   65: lstore 5
    //   67: lconst_0
    //   68: lload 5
    //   70: lcmp
    //   71: ifne +11 -> 82
    //   74: aload 7
    //   76: invokevirtual 119	com/tencent/map/sdk/a/pf:z	()V
    //   79: fload 4
    //   81: freturn
    //   82: aload 7
    //   84: monitorenter
    //   85: aload 7
    //   87: getfield 122	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   90: aload 7
    //   92: getfield 116	com/tencent/map/sdk/a/pf:b	J
    //   95: fload 4
    //   97: iconst_0
    //   98: invokevirtual 128	com/tencent/map/sdk/engine/jni/JNI:nativeSetRotate	(JFZ)V
    //   101: aload 7
    //   103: monitorexit
    //   104: aload 7
    //   106: invokevirtual 119	com/tencent/map/sdk/a/pf:z	()V
    //   109: goto -30 -> 79
    //   112: astore 8
    //   114: aload 7
    //   116: monitorexit
    //   117: aload 8
    //   119: athrow
    //   120: astore 8
    //   122: aload 7
    //   124: invokevirtual 119	com/tencent/map/sdk/a/pf:z	()V
    //   127: aload 8
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	kc
    //   0	130	1	paramFloat	float
    //   25	11	2	d1	double
    //   18	78	4	f1	float
    //   65	4	5	l1	long
    //   53	70	7	localpf	pf
    //   112	6	8	localObject1	Object
    //   120	8	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   85	104	112	finally
    //   114	117	112	finally
    //   55	67	120	finally
    //   82	85	120	finally
    //   117	120	120	finally
  }
  
  public final boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.r == null) {
      this.r = new kc.b(paramFloat1, paramFloat2);
    }
    for (;;)
    {
      this.o.a(paramFloat1, paramFloat2, paramBoolean);
      return true;
      kc.b localb = this.r;
      localb.a = paramFloat1;
      localb.b = paramFloat2;
    }
  }
  
  public final boolean a(int paramInt)
  {
    boolean bool2 = false;
    if (this.p == null) {}
    int i1;
    do
    {
      return false;
      i1 = this.p.r();
    } while (i1 == paramInt);
    if (i1 == 11) {
      this.o.b(false);
    }
    if (paramInt == 11) {
      this.o.b(true);
    }
    this.a = paramInt;
    pf localpf = this.p;
    boolean bool1;
    if (i1 != paramInt) {
      if ((i1 == 11) && (paramInt != 13)) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if (0L != localpf.b) {
        localpf.f.a(new pf.24(localpf, paramInt, bool1));
      }
      return true;
      if (i1 == 13)
      {
        bool1 = bool2;
        if (paramInt != 11) {}
      }
      else if (paramInt == 11)
      {
        bool1 = bool2;
        if (i1 != 13) {}
      }
      else if (paramInt == 13)
      {
        bool1 = bool2;
        if (i1 != 11) {}
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    int i1;
    int i2;
    if (1 << 20 - this.b.f < 0)
    {
      i1 = 0;
      if (131072 <= i1) {
        break label322;
      }
      i2 = (this.n.width() * 131072 - this.n.width() * i1) / 2;
      i1 = (this.n.height() * 131072 - i1 * this.n.height()) / 2;
    }
    for (;;)
    {
      int i3 = this.c.left - i2;
      i2 += this.c.right;
      int i5 = this.c.top - i1;
      int i4 = i1 + this.c.bottom;
      if (paramInt1 < i5) {
        paramInt1 = i5;
      }
      for (;;)
      {
        i1 = paramInt1;
        if (paramInt1 > i4) {
          i1 = i4;
        }
        if (paramInt2 < i3) {}
        for (paramInt1 = i3;; paramInt1 = paramInt2)
        {
          paramInt2 = paramInt1;
          if (paramInt1 > i2) {
            paramInt2 = i2;
          }
          if ((i1 != this.m.getLatitudeE6()) || (paramInt2 != this.m.getLongitudeE6())) {
            bool = true;
          }
          this.m.setLatitudeE6(i1);
          this.m.setLongitudeE6(paramInt2);
          Object localObject = kd.a(this, this.m);
          double d1 = ((DoublePoint)localObject).x;
          double d2 = ((DoublePoint)localObject).y;
          this.q.set(d1, d2);
          localObject = this.p;
          GeoPoint localGeoPoint = this.m;
          if ((0L == ((pf)localObject).b) || (((pf)localObject).f == null))
          {
            return bool;
            i1 = 20 - this.b.f;
            break;
          }
          ((pf)localObject).f.a(new pf.16((pf)localObject, localGeoPoint));
          return bool;
        }
      }
      label322:
      i1 = 0;
      i2 = 0;
    }
  }
  
  /* Error */
  public final float b(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	com/tencent/map/sdk/a/kc:p	Lcom/tencent/map/sdk/a/pf;
    //   4: invokevirtual 219	com/tencent/map/sdk/a/pf:p	()F
    //   7: fload_1
    //   8: fcmpl
    //   9: ifne +5 -> 14
    //   12: fload_1
    //   13: freturn
    //   14: fconst_0
    //   15: ldc 220
    //   17: fload_1
    //   18: invokestatic 224	java/lang/Math:min	(FF)F
    //   21: invokestatic 227	java/lang/Math:max	(FF)F
    //   24: fstore 4
    //   26: fload_1
    //   27: f2d
    //   28: invokestatic 104	java/lang/Math:toRadians	(D)D
    //   31: dstore_2
    //   32: aload_0
    //   33: dload_2
    //   34: invokestatic 107	java/lang/Math:sin	(D)D
    //   37: putfield 46	com/tencent/map/sdk/a/kc:i	D
    //   40: aload_0
    //   41: dload_2
    //   42: invokestatic 110	java/lang/Math:cos	(D)D
    //   45: putfield 48	com/tencent/map/sdk/a/kc:j	D
    //   48: ldc2_w 228
    //   51: dload_2
    //   52: dsub
    //   53: dstore_2
    //   54: aload_0
    //   55: dload_2
    //   56: invokestatic 110	java/lang/Math:cos	(D)D
    //   59: putfield 52	com/tencent/map/sdk/a/kc:l	D
    //   62: aload_0
    //   63: dload_2
    //   64: invokestatic 107	java/lang/Math:sin	(D)D
    //   67: putfield 50	com/tencent/map/sdk/a/kc:k	D
    //   70: aload_0
    //   71: getfield 90	com/tencent/map/sdk/a/kc:p	Lcom/tencent/map/sdk/a/pf;
    //   74: ifnull +33 -> 107
    //   77: aload_0
    //   78: getfield 90	com/tencent/map/sdk/a/kc:p	Lcom/tencent/map/sdk/a/pf;
    //   81: astore 7
    //   83: aload 7
    //   85: invokevirtual 113	com/tencent/map/sdk/a/pf:y	()V
    //   88: aload 7
    //   90: getfield 116	com/tencent/map/sdk/a/pf:b	J
    //   93: lstore 5
    //   95: lconst_0
    //   96: lload 5
    //   98: lcmp
    //   99: ifne +11 -> 110
    //   102: aload 7
    //   104: invokevirtual 119	com/tencent/map/sdk/a/pf:z	()V
    //   107: fload 4
    //   109: freturn
    //   110: aload 7
    //   112: monitorenter
    //   113: aload 7
    //   115: getfield 122	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   118: aload 7
    //   120: getfield 116	com/tencent/map/sdk/a/pf:b	J
    //   123: fload 4
    //   125: iconst_0
    //   126: invokevirtual 232	com/tencent/map/sdk/engine/jni/JNI:nativeSetSkew	(JFZ)V
    //   129: aload 7
    //   131: monitorexit
    //   132: aload 7
    //   134: invokevirtual 119	com/tencent/map/sdk/a/pf:z	()V
    //   137: goto -30 -> 107
    //   140: astore 8
    //   142: aload 7
    //   144: monitorexit
    //   145: aload 8
    //   147: athrow
    //   148: astore 8
    //   150: aload 7
    //   152: invokevirtual 119	com/tencent/map/sdk/a/pf:z	()V
    //   155: aload 8
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	kc
    //   0	158	1	paramFloat	float
    //   31	33	2	d1	double
    //   24	100	4	f1	float
    //   93	4	5	l1	long
    //   81	70	7	localpf	pf
    //   140	6	8	localObject1	Object
    //   148	8	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   113	132	140	finally
    //   142	145	140	finally
    //   83	95	148	finally
    //   110	113	148	finally
    //   145	148	148	finally
  }
  
  public final boolean b(int paramInt)
  {
    return c(kc.a.a(paramInt)) == kc.c.c;
  }
  
  public final int c(float paramFloat)
  {
    int i2 = kc.c.a;
    float f1 = this.b.e;
    int i3 = this.b.f;
    Object localObject;
    double d1;
    int i1;
    if (this.p != null)
    {
      localObject = this.p;
      d1 = paramFloat;
      if ((0L == ((pf)localObject).b) || (((pf)localObject).f == null))
      {
        paramFloat = this.p.l();
        i1 = this.p.m();
      }
    }
    for (;;)
    {
      this.b.a(i1, paramFloat);
      if (i1 != i3) {
        i1 = kc.c.c;
      }
      for (;;)
      {
        label96:
        switch (kc.1.a[(i1 - 1)])
        {
        }
        for (;;)
        {
          localObject = kd.a(this, this.m);
          this.q.set(((DoublePoint)localObject).x, ((DoublePoint)localObject).y);
          return i1;
          ((pf)localObject).f.a(new pf.17((pf)localObject, d1));
          break;
          if (paramFloat == f1) {
            break label232;
          }
          i1 = kc.c.b;
          break label96;
          d1 = (1 << this.b.f) * 256;
          this.d = ((int)d1);
          this.e = (d1 / 360.0D);
          this.f = (d1 / 6.283185307179586D);
        }
        label232:
        i1 = i2;
      }
      i1 = i3;
      paramFloat = f1;
    }
  }
  
  public final void c(int paramInt)
  {
    this.b.d = paramInt;
  }
  
  public final Object clone()
  {
    kc localkc = (kc)super.clone();
    localkc.c = new Rect(this.c);
    localkc.b = ((kc.a)this.b.clone());
    localkc.m = new GeoPoint(this.m);
    localkc.q = new DoublePoint(this.q.x, this.q.y);
    return localkc;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof kc)) {}
    do
    {
      return false;
      paramObject = (kc)paramObject;
    } while ((!paramObject.m.equals(this.m)) || (!paramObject.b.equals(this.b)) || (paramObject.a != this.a));
    return true;
  }
  
  public final int hashCode()
  {
    return toString().hashCode();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    GeoPoint localGeoPoint = this.m;
    localStringBuilder.append("mapParam: ");
    localStringBuilder.append("center:" + localGeoPoint.toString() + " ");
    localStringBuilder.append("mode:" + this.a + " ");
    localStringBuilder.append("mapScale:" + this.b.toString() + " ");
    localStringBuilder.append("screenRect:" + this.n.toString() + " ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.kc
 * JD-Core Version:    0.7.0.1
 */