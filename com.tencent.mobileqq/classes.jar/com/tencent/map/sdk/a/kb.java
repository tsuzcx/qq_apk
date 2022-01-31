package com.tencent.map.sdk.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.engine.jni.JNI;
import java.util.List;

public final class kb
  implements fu
{
  kc a;
  lw b;
  private pf c;
  
  public kb(lg paramlg)
  {
    this.b = ((lw)paramlg);
    this.a = paramlg.b().f();
    this.c = paramlg.g();
  }
  
  public final double a(double paramDouble)
  {
    float f = this.a.b.f;
    double d = this.a.b.a();
    return 40076000.0D / (Math.pow(2.0D, (float)(f + Math.log(d) / Math.log(2.0D))) * 256.0D * fz.v) * Math.cos(3.141592653589793D * paramDouble / 180.0D);
  }
  
  public final double a(Point paramPoint1, Point paramPoint2)
  {
    GeoPoint localGeoPoint1 = a(new DoublePoint(paramPoint1.x, paramPoint1.y));
    GeoPoint localGeoPoint2 = a(new DoublePoint(paramPoint2.x, paramPoint2.y));
    float[] arrayOfFloat = new float[1];
    Location.distanceBetween(localGeoPoint1.getLatitudeE6() / 1000000.0D, localGeoPoint1.getLongitudeE6() / 1000000.0D, localGeoPoint2.getLatitudeE6() / 1000000.0D, localGeoPoint2.getLongitudeE6() / 1000000.0D, arrayOfFloat);
    int i = (int)Math.sqrt(Math.pow(paramPoint1.x - paramPoint2.x, 2.0D) + Math.pow(paramPoint1.y - paramPoint2.y, 2.0D));
    return arrayOfFloat[0] / i;
  }
  
  public final DoublePoint a(GeoPoint paramGeoPoint)
  {
    double d1 = paramGeoPoint.getLatitudeE6() / 1000000.0D;
    double d2 = paramGeoPoint.getLongitudeE6() / 1000000.0D;
    paramGeoPoint = this.c.a(d1, d2);
    return new DoublePoint(paramGeoPoint.x, paramGeoPoint.y);
  }
  
  public final GeoPoint a(DoublePoint paramDoublePoint)
  {
    float f1 = (float)paramDoublePoint.x;
    float f2 = (float)paramDoublePoint.y;
    return this.c.a(f1, f2);
  }
  
  /* Error */
  public final void a(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/tencent/map/sdk/a/kb:a	Lcom/tencent/map/sdk/a/kc;
    //   4: astore 6
    //   6: aload 6
    //   8: getfield 144	com/tencent/map/sdk/a/kc:p	Lcom/tencent/map/sdk/a/pf;
    //   11: ifnull +45 -> 56
    //   14: aload 6
    //   16: getfield 144	com/tencent/map/sdk/a/kc:p	Lcom/tencent/map/sdk/a/pf;
    //   19: astore 5
    //   21: fload_1
    //   22: f2d
    //   23: dstore_2
    //   24: aload 5
    //   26: invokevirtual 146	com/tencent/map/sdk/a/pf:y	()V
    //   29: lconst_0
    //   30: aload 5
    //   32: getfield 149	com/tencent/map/sdk/a/pf:b	J
    //   35: lcmp
    //   36: ifeq +15 -> 51
    //   39: aload 5
    //   41: getfield 151	com/tencent/map/sdk/a/pf:f	Lcom/tencent/map/sdk/a/lw;
    //   44: astore 7
    //   46: aload 7
    //   48: ifnonnull +23 -> 71
    //   51: aload 5
    //   53: invokevirtual 154	com/tencent/map/sdk/a/pf:z	()V
    //   56: aload 6
    //   58: getfield 47	com/tencent/map/sdk/a/kc:b	Lcom/tencent/map/sdk/a/kc$a;
    //   61: fload_1
    //   62: putfield 157	com/tencent/map/sdk/a/kc$a:e	F
    //   65: getstatic 161	com/tencent/map/sdk/a/kc$c:c	I
    //   68: istore 4
    //   70: return
    //   71: aload 5
    //   73: getfield 164	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   76: aload 5
    //   78: getfield 149	com/tencent/map/sdk/a/pf:b	J
    //   81: dload_2
    //   82: iconst_0
    //   83: invokevirtual 170	com/tencent/map/sdk/engine/jni/JNI:nativeSetScale	(JDZ)V
    //   86: aload 5
    //   88: invokevirtual 154	com/tencent/map/sdk/a/pf:z	()V
    //   91: goto -35 -> 56
    //   94: astore 6
    //   96: aload 5
    //   98: invokevirtual 154	com/tencent/map/sdk/a/pf:z	()V
    //   101: aload 6
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	kb
    //   0	104	1	paramFloat	float
    //   23	59	2	d	double
    //   68	1	4	i	int
    //   19	78	5	localpf	pf
    //   4	53	6	localkc	kc
    //   94	8	6	localObject	Object
    //   44	3	7	locallw	lw
    // Exception table:
    //   from	to	target	type
    //   24	46	94	finally
    //   71	86	94	finally
  }
  
  public final void a(List<? extends gg> paramList, List<GeoPoint> paramList1, Rect paramRect, kb.a parama)
  {
    if ((paramList.isEmpty()) && ((paramList1 == null) || (paramList1.isEmpty()))) {}
    Object localObject;
    int k;
    do
    {
      return;
      localObject = new Rect(this.b.i);
      ((Rect)localObject).left += paramRect.left;
      ((Rect)localObject).right -= paramRect.right;
      ((Rect)localObject).top += paramRect.top;
      ((Rect)localObject).bottom -= paramRect.bottom;
      int i = ((Rect)localObject).width();
      int j = ((Rect)localObject).height();
      localObject = this.b.c.a;
      k = ((kf)localObject).b;
      this.b.a(new kb.1(this, paramList, paramList1, i, j, paramRect, k, (kf)localObject, parama));
    } while (k == 60);
    ((kf)localObject).b = 60;
  }
  
  public final void b(GeoPoint paramGeoPoint)
  {
    int i = 0;
    Object localObject = this.a;
    int n = paramGeoPoint.getLatitudeE6();
    int k = paramGeoPoint.getLongitudeE6();
    int m = 1 << 20 - ((kc)localObject).b.f;
    int j;
    if (131072 > m)
    {
      j = (((kc)localObject).n.width() * 131072 - ((kc)localObject).n.width() * m) / 2;
      i = (((kc)localObject).n.height() * 131072 - m * ((kc)localObject).n.height()) / 2;
    }
    for (;;)
    {
      int i1 = ((kc)localObject).c.left - j;
      m = j + ((kc)localObject).c.right;
      j = ((kc)localObject).c.top - i;
      int i2 = i + ((kc)localObject).c.bottom;
      if (n < j) {}
      for (i = j;; i = n)
      {
        j = i;
        if (i > i2) {
          j = i2;
        }
        if (k < i1) {}
        for (i = i1;; i = k)
        {
          k = i;
          if (i > m) {
            k = m;
          }
          paramGeoPoint = new GeoPoint(j, k);
          localObject = ((kc)localObject).p;
          try
          {
            ((pf)localObject).y();
            if (0L != ((pf)localObject).b)
            {
              lw locallw = ((pf)localObject).f;
              if (locallw != null) {}
            }
            else
            {
              return;
            }
            ((pf)localObject).a.nativeSetCenter(((pf)localObject).b, paramGeoPoint, false);
            return;
          }
          finally
          {
            ((pf)localObject).z();
          }
        }
      }
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.kb
 * JD-Core Version:    0.7.0.1
 */