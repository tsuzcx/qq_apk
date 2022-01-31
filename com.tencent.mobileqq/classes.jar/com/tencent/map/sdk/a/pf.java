package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.engine.jni.JNI;
import com.tencent.map.sdk.engine.jni.models.CircleInfo;
import com.tencent.map.sdk.engine.jni.models.DataSource;
import com.tencent.map.sdk.engine.jni.models.MapTileID;
import com.tencent.map.sdk.engine.jni.models.MaskLayer;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class pf
  implements ma, me, mf, mg, mi, mk, ml, qf
{
  private static boolean j = true;
  public JNI a = new JNI();
  public long b;
  public mc c;
  public qg d = new qg();
  public mg e;
  public lw f;
  public long g = 0L;
  public String h = null;
  private qf i;
  private int k = 0;
  private int l = 0;
  private float m = 1.0F;
  private ReentrantReadWriteLock n = new ReentrantReadWriteLock();
  
  public pf(Context paramContext, lw paramlw)
  {
    this.d.a(this);
    this.f = paramlw;
    this.m = paramContext.getResources().getDisplayMetrics().density;
    if (j) {
      op.a(paramContext, "txmapengine");
    }
  }
  
  public final void A()
  {
    this.n.writeLock().lock();
  }
  
  public final void B()
  {
    this.n.writeLock().unlock();
  }
  
  /* Error */
  public final double a(android.graphics.Rect paramRect1, android.graphics.Rect paramRect2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore 5
    //   10: lconst_0
    //   11: lload 5
    //   13: lcmp
    //   14: ifne +9 -> 23
    //   17: aload_0
    //   18: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   21: dconst_1
    //   22: dreturn
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   29: aload_0
    //   30: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual 139	com/tencent/map/sdk/engine/jni/JNI:nativeGetTargetScale	(JLandroid/graphics/Rect;Landroid/graphics/Rect;)D
    //   38: dstore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_0
    //   42: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   45: dload_3
    //   46: dreturn
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: aload_0
    //   54: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	pf
    //   0	59	1	paramRect1	android.graphics.Rect
    //   0	59	2	paramRect2	android.graphics.Rect
    //   38	8	3	d1	double
    //   8	4	5	l1	long
    // Exception table:
    //   from	to	target	type
    //   25	41	47	finally
    //   48	50	47	finally
    //   0	10	52	finally
    //   23	25	52	finally
    //   50	52	52	finally
  }
  
  public final int a(ip paramip)
  {
    for (;;)
    {
      long l1;
      int i2;
      boolean bool1;
      int i1;
      boolean bool2;
      Object localObject1;
      Object localObject2;
      try
      {
        y();
        l1 = this.b;
        if (l1 == 0L) {
          return -1;
        }
        z();
        i2 = paramip.a.o;
        bool1 = false;
        i1 = i2;
        if (i2 == 3)
        {
          i1 = 0;
          bool1 = true;
        }
        bool2 = false;
        localObject1 = paramip.c;
        if (localObject1[0] == 33)
        {
          i1 = 2;
          localObject2 = new int[0];
          if (paramip.a.x == null) {
            break label187;
          }
          localObject1 = new int[paramip.a.x.size()];
          i2 = 0;
          localObject2 = localObject1;
          if (i2 >= paramip.a.x.size()) {
            break label187;
          }
          localObject1[i2] = ((Integer)paramip.a.x.get(i2)).intValue();
          i2 += 1;
          continue;
        }
        bool2 = true;
      }
      finally
      {
        z();
      }
      continue;
      label187:
      Object localObject3 = new int[0];
      if (paramip.a.f != null)
      {
        localObject1 = new int[paramip.a.f.length];
        i2 = 0;
        for (;;)
        {
          localObject3 = localObject1;
          if (i2 >= paramip.a.f.length) {
            break;
          }
          localObject1[i2] = paramip.a.f[i2];
          i2 += 1;
        }
      }
      try
      {
        y();
        l1 = this.b;
        if (l1 == 0L) {
          return -1;
        }
        try
        {
          JNI localJNI = this.a;
          l1 = this.b;
          int[] arrayOfInt1 = paramip.c;
          int[] arrayOfInt2 = paramip.b;
          GeoPoint[] arrayOfGeoPoint = (GeoPoint[])paramip.a.b.toArray(new GeoPoint[0]);
          float f2;
          boolean bool3;
          boolean bool4;
          boolean bool5;
          int[] arrayOfInt3;
          float f3;
          if ((paramip.a.d != null) && (paramip.a.d.length > 0)) {
            if (paramip.a.d[0] == 33)
            {
              localObject1 = "color_point_texture.png";
              f2 = paramip.a.j;
              bool3 = paramip.a.n;
              bool4 = paramip.a.i;
              i2 = paramip.a.s;
              bool5 = paramip.a.h;
              arrayOfInt3 = paramip.a.e;
              f3 = paramip.a.g;
              if (paramip.a != null) {
                break label546;
              }
            }
          }
          label546:
          for (float f1 = 1.0F;; f1 = paramip.a.m)
          {
            i1 = localJNI.nativeCreateLine(l1, arrayOfInt1, arrayOfInt2, arrayOfGeoPoint, (String)localObject1, f2, i1, bool1, bool2, bool3, bool4, i2, bool5, arrayOfInt3, (int[])localObject3, f3, (int[])localObject2, f1, paramip.a.y);
            return i1;
            if (paramip.a.d[0] == 20)
            {
              localObject1 = "color_texture_line_v2.png";
              break;
            }
            if (nl.a(paramip.a.k))
            {
              localObject1 = "color_texture_flat_style.png";
              break;
            }
            localObject1 = paramip.a.k;
            break;
          }
          paramip = finally;
        }
        finally {}
      }
      finally
      {
        z();
      }
    }
  }
  
  /* Error */
  public final int a(com.tencent.map.sdk.engine.jni.callbacks.TileOverlayCallback paramTileOverlayCallback, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore 4
    //   10: lload 4
    //   12: lconst_0
    //   13: lcmp
    //   14: ifne +9 -> 23
    //   17: aload_0
    //   18: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   21: iconst_m1
    //   22: ireturn
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   29: aload_0
    //   30: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   33: aload_1
    //   34: iload_2
    //   35: invokevirtual 231	com/tencent/map/sdk/engine/jni/JNI:nativeAddTileOverlay	(JLcom/tencent/map/sdk/engine/jni/callbacks/TileOverlayCallback;Z)I
    //   38: istore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_0
    //   42: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   45: iload_3
    //   46: ireturn
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: aload_0
    //   54: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	pf
    //   0	59	1	paramTileOverlayCallback	com.tencent.map.sdk.engine.jni.callbacks.TileOverlayCallback
    //   0	59	2	paramBoolean	boolean
    //   38	8	3	i1	int
    //   8	3	4	l1	long
    // Exception table:
    //   from	to	target	type
    //   25	41	47	finally
    //   48	50	47	finally
    //   0	10	52	finally
    //   23	25	52	finally
    //   50	52	52	finally
  }
  
  public final int a(CircleInfo paramCircleInfo)
  {
    if (this.b == 0L) {
      return 0;
    }
    try
    {
      int i1 = this.a.nativeAddCircle(this.b, paramCircleInfo);
      return i1;
    }
    finally {}
  }
  
  public final int a(MaskLayer paramMaskLayer)
  {
    try
    {
      y();
      long l1 = this.b;
      if (l1 == 0L) {
        return 0;
      }
      int i1 = this.a.nativeAddMaskLayer(this.b, paramMaskLayer);
      return i1;
    }
    finally
    {
      z();
    }
  }
  
  /* Error */
  public final int a(com.tencent.map.sdk.engine.jni.models.Polygon2D paramPolygon2D)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_3
    //   9: lload_3
    //   10: lconst_0
    //   11: lcmp
    //   12: ifne +9 -> 21
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   27: aload_0
    //   28: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   31: aload_1
    //   32: invokevirtual 246	com/tencent/map/sdk/engine/jni/JNI:nativeAddPolygon	(JLcom/tencent/map/sdk/engine/jni/models/Polygon2D;)I
    //   35: istore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_0
    //   39: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   42: iload_2
    //   43: ireturn
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    //   49: astore_1
    //   50: aload_0
    //   51: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	pf
    //   0	56	1	paramPolygon2D	com.tencent.map.sdk.engine.jni.models.Polygon2D
    //   35	8	2	i1	int
    //   8	2	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   23	38	44	finally
    //   45	47	44	finally
    //   0	9	49	finally
    //   21	23	49	finally
    //   47	49	49	finally
  }
  
  /* Error */
  public final int a(String paramString, double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore 18
    //   10: lconst_0
    //   11: lload 18
    //   13: lcmp
    //   14: ifne +9 -> 23
    //   17: aload_0
    //   18: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   29: aload_0
    //   30: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   33: aload_1
    //   34: dload_2
    //   35: dload 4
    //   37: fload 6
    //   39: fload 7
    //   41: fload 8
    //   43: fload 9
    //   45: fload 10
    //   47: fload 11
    //   49: iload 12
    //   51: iload 13
    //   53: iload 14
    //   55: iload 15
    //   57: iload 16
    //   59: iload 17
    //   61: invokevirtual 251	com/tencent/map/sdk/engine/jni/JNI:nativeAddMarker	(JLjava/lang/String;DDFFFFFFZZZZII)I
    //   64: istore 16
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_0
    //   69: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   72: iload 16
    //   74: ireturn
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    //   80: astore_1
    //   81: aload_0
    //   82: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	pf
    //   0	87	1	paramString	String
    //   0	87	2	paramDouble1	double
    //   0	87	4	paramDouble2	double
    //   0	87	6	paramFloat1	float
    //   0	87	7	paramFloat2	float
    //   0	87	8	paramFloat3	float
    //   0	87	9	paramFloat4	float
    //   0	87	10	paramFloat5	float
    //   0	87	11	paramFloat6	float
    //   0	87	12	paramBoolean1	boolean
    //   0	87	13	paramBoolean2	boolean
    //   0	87	14	paramBoolean3	boolean
    //   0	87	15	paramBoolean4	boolean
    //   0	87	16	paramInt1	int
    //   0	87	17	paramInt2	int
    //   8	4	18	l1	long
    // Exception table:
    //   from	to	target	type
    //   25	68	75	finally
    //   76	78	75	finally
    //   0	10	80	finally
    //   23	25	80	finally
    //   78	80	80	finally
  }
  
  /* Error */
  public final int a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   10: lconst_0
    //   11: lcmp
    //   12: ifne +11 -> 23
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_0
    //   18: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   21: iconst_m1
    //   22: ireturn
    //   23: aload_0
    //   24: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   27: aload_0
    //   28: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   31: aload_1
    //   32: iload_2
    //   33: iconst_1
    //   34: iconst_0
    //   35: invokevirtual 256	com/tencent/map/sdk/engine/jni/JNI:nativeRefreshTrafficData	(J[BIZZ)I
    //   38: istore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_0
    //   42: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   45: iload_2
    //   46: ireturn
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: aload_0
    //   54: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	pf
    //   0	59	1	paramArrayOfByte	byte[]
    //   0	59	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   6	17	47	finally
    //   23	41	47	finally
    //   48	50	47	finally
    //   0	6	52	finally
    //   50	52	52	finally
  }
  
  public final int a(GeoPoint[] paramArrayOfGeoPoint, PolylineOptions.Text paramText)
  {
    try
    {
      y();
      long l1 = this.b;
      if (l1 == 0L) {
        return -1;
      }
      int i1 = this.a.addLineText(this.b, paramArrayOfGeoPoint, paramText);
      return i1;
    }
    finally
    {
      z();
    }
  }
  
  /* Error */
  public final android.graphics.PointF a(double paramDouble1, double paramDouble2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lconst_0
    //   9: lcmp
    //   10: ifne +19 -> 29
    //   13: new 264	android/graphics/PointF
    //   16: dup
    //   17: invokespecial 265	android/graphics/PointF:<init>	()V
    //   20: astore 5
    //   22: aload_0
    //   23: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   26: aload 5
    //   28: areturn
    //   29: aload_0
    //   30: monitorenter
    //   31: iconst_2
    //   32: newarray float
    //   34: astore 5
    //   36: aload_0
    //   37: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   40: aload_0
    //   41: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   44: aconst_null
    //   45: dload_1
    //   46: dload_3
    //   47: aload 5
    //   49: invokevirtual 269	com/tencent/map/sdk/engine/jni/JNI:nativeToScreenLocation	(J[BDD[F)V
    //   52: new 264	android/graphics/PointF
    //   55: dup
    //   56: aload 5
    //   58: iconst_0
    //   59: faload
    //   60: aload 5
    //   62: iconst_1
    //   63: faload
    //   64: invokespecial 272	android/graphics/PointF:<init>	(FF)V
    //   67: astore 5
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_0
    //   72: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   75: aload 5
    //   77: areturn
    //   78: astore 5
    //   80: aload_0
    //   81: monitorexit
    //   82: aload 5
    //   84: athrow
    //   85: astore 5
    //   87: aload_0
    //   88: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   91: aload 5
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	pf
    //   0	94	1	paramDouble1	double
    //   0	94	3	paramDouble2	double
    //   20	56	5	localObject1	Object
    //   78	5	5	localObject2	Object
    //   85	7	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   31	71	78	finally
    //   80	82	78	finally
    //   0	22	85	finally
    //   29	31	85	finally
    //   82	85	85	finally
  }
  
  /* Error */
  public final GeoPoint a(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lconst_0
    //   9: lcmp
    //   10: ifne +19 -> 29
    //   13: new 181	com/tencent/map/lib/basemap/data/GeoPoint
    //   16: dup
    //   17: invokespecial 274	com/tencent/map/lib/basemap/data/GeoPoint:<init>	()V
    //   20: astore 4
    //   22: aload_0
    //   23: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   26: aload 4
    //   28: areturn
    //   29: aload_0
    //   30: monitorenter
    //   31: iconst_2
    //   32: newarray double
    //   34: astore 4
    //   36: aload_0
    //   37: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   40: aload_0
    //   41: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   44: aconst_null
    //   45: fload_1
    //   46: fload_2
    //   47: aload 4
    //   49: invokevirtual 278	com/tencent/map/sdk/engine/jni/JNI:nativeFromScreenLocation	(J[BFF[D)V
    //   52: aload 4
    //   54: iconst_0
    //   55: daload
    //   56: ldc2_w 279
    //   59: dmul
    //   60: d2i
    //   61: istore_3
    //   62: new 181	com/tencent/map/lib/basemap/data/GeoPoint
    //   65: dup
    //   66: aload 4
    //   68: iconst_1
    //   69: daload
    //   70: ldc2_w 279
    //   73: dmul
    //   74: d2i
    //   75: iload_3
    //   76: invokespecial 283	com/tencent/map/lib/basemap/data/GeoPoint:<init>	(II)V
    //   79: astore 4
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_0
    //   84: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   87: aload 4
    //   89: areturn
    //   90: astore 4
    //   92: aload_0
    //   93: monitorexit
    //   94: aload 4
    //   96: athrow
    //   97: astore 4
    //   99: aload_0
    //   100: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   103: aload 4
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	pf
    //   0	106	1	paramFloat1	float
    //   0	106	2	paramFloat2	float
    //   61	15	3	i1	int
    //   20	68	4	localObject1	Object
    //   90	5	4	localObject2	Object
    //   97	7	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   31	52	90	finally
    //   62	83	90	finally
    //   92	94	90	finally
    //   0	22	97	finally
    //   29	31	97	finally
    //   94	97	97	finally
  }
  
  public final String a(GeoPoint paramGeoPoint)
  {
    try
    {
      y();
      if (this.b == 0L) {
        return "";
      }
      paramGeoPoint = this.a.nativeGetCityName(this.b, paramGeoPoint);
      if (paramGeoPoint != null) {
        try
        {
          paramGeoPoint = new String(paramGeoPoint, "GBK").trim();
          return paramGeoPoint;
        }
        catch (UnsupportedEncodingException paramGeoPoint) {}
      }
      return "";
    }
    finally
    {
      z();
    }
  }
  
  /* Error */
  public final List<Integer> a(android.graphics.Rect paramRect, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore 4
    //   10: lconst_0
    //   11: lload 4
    //   13: lcmp
    //   14: ifne +9 -> 23
    //   17: aload_0
    //   18: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   21: aconst_null
    //   22: areturn
    //   23: aload_0
    //   24: monitorenter
    //   25: bipush 100
    //   27: newarray int
    //   29: astore 6
    //   31: aload_0
    //   32: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   35: aload_0
    //   36: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   39: aload_1
    //   40: iload_2
    //   41: aload 6
    //   43: bipush 100
    //   45: invokevirtual 311	com/tencent/map/sdk/engine/jni/JNI:nativeQueryCityCodeList	(JLandroid/graphics/Rect;I[II)I
    //   48: istore_3
    //   49: iload_3
    //   50: ifle +48 -> 98
    //   53: new 183	java/util/ArrayList
    //   56: dup
    //   57: iload_3
    //   58: invokespecial 314	java/util/ArrayList:<init>	(I)V
    //   61: astore_1
    //   62: iconst_0
    //   63: istore_2
    //   64: iload_2
    //   65: iload_3
    //   66: if_icmpge +24 -> 90
    //   69: aload_1
    //   70: aload 6
    //   72: iload_2
    //   73: iaload
    //   74: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: invokeinterface 322 2 0
    //   82: pop
    //   83: iload_2
    //   84: iconst_1
    //   85: iadd
    //   86: istore_2
    //   87: goto -23 -> 64
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_0
    //   93: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   96: aload_1
    //   97: areturn
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_0
    //   101: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   104: aconst_null
    //   105: areturn
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	pf
    //   0	118	1	paramRect	android.graphics.Rect
    //   0	118	2	paramInt	int
    //   48	19	3	i1	int
    //   8	4	4	l1	long
    //   29	42	6	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   25	49	106	finally
    //   53	62	106	finally
    //   69	83	106	finally
    //   90	92	106	finally
    //   98	100	106	finally
    //   107	109	106	finally
    //   0	10	111	finally
    //   23	25	111	finally
    //   109	111	111	finally
  }
  
  public final void a()
  {
    kc localkc;
    if (this.f != null)
    {
      localkc = this.f.n;
      if ((localkc != null) && (localkc.o != null)) {}
    }
    else
    {
      return;
    }
    localkc.m = localkc.p.k();
    int i1 = localkc.p.m();
    float f1 = localkc.p.l();
    if (i1 != localkc.b.f) {
      localkc.o.c.c(kc.c.c);
    }
    for (;;)
    {
      if (localkc.b != null) {
        localkc.b.a(i1, f1);
      }
      localkc.a = localkc.p.r();
      return;
      if (f1 != localkc.b.e) {
        localkc.o.c.c(kc.c.b);
      }
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((0L == this.b) || (this.f == null)) {
      return;
    }
    this.f.a(new pf.21(this, paramBoolean, paramFloat1, paramFloat2));
  }
  
  /* Error */
  public final void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_2
    //   9: lconst_0
    //   10: lload_2
    //   11: lcmp
    //   12: ifne +8 -> 20
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: return
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   26: aload_0
    //   27: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   30: iload_1
    //   31: invokevirtual 391	com/tencent/map/sdk/engine/jni/JNI:nativeSetMaxScaleLevel	(JI)V
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_0
    //   37: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   40: return
    //   41: astore 4
    //   43: aload_0
    //   44: monitorexit
    //   45: aload 4
    //   47: athrow
    //   48: astore 4
    //   50: aload_0
    //   51: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   54: aload 4
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	pf
    //   0	57	1	paramInt	int
    //   8	3	2	l1	long
    //   41	5	4	localObject1	Object
    //   48	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	36	41	finally
    //   43	45	41	finally
    //   0	9	48	finally
    //   20	22	48	finally
    //   45	48	48	finally
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (0L == this.b) {
      return;
    }
    this.f.a(new pf.7(this, paramInt1, paramInt2));
  }
  
  /* Error */
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lconst_0
    //   9: lcmp
    //   10: ifeq +25 -> 35
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   19: aload_0
    //   20: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   23: iload_1
    //   24: iload_2
    //   25: iload_3
    //   26: iload 4
    //   28: iload 5
    //   30: invokevirtual 401	com/tencent/map/sdk/engine/jni/JNI:nativeCheckTrafficBlockCache	(JIIIII)V
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_0
    //   36: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   39: return
    //   40: astore 6
    //   42: aload_0
    //   43: monitorexit
    //   44: aload 6
    //   46: athrow
    //   47: astore 6
    //   49: aload_0
    //   50: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   53: aload 6
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	pf
    //   0	56	1	paramInt1	int
    //   0	56	2	paramInt2	int
    //   0	56	3	paramInt3	int
    //   0	56	4	paramInt4	int
    //   0	56	5	paramInt5	int
    //   40	5	6	localObject1	Object
    //   47	7	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	35	40	finally
    //   42	44	40	finally
    //   0	15	47	finally
    //   44	47	47	finally
  }
  
  public final void a(String paramString)
  {
    if (this.i != null) {
      this.i.a(paramString);
    }
  }
  
  public final void a(String paramString, qd paramqd)
  {
    if (DataSource.get(paramqd.b) == DataSource.TILE_OVERLAY)
    {
      paramqd = (MapTileID)paramqd.d;
      int i1 = paramqd.getTileTag();
      ix localix = this.f.D.a(i1);
      if (localix != null)
      {
        or.a("Use TileOverlay DownloadMgr to cancel request..");
        localix.e().a(paramString);
        os.e();
        new StringBuilder("C/").append(paramqd.getX()).append("-").append(paramqd.getY()).append("-").append(paramqd.getZ());
        os.e();
        return;
      }
    }
    or.a("Use Default DownloadMgr to cancel request..");
    this.d.a(paramString);
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte)
  {
    os.a();
    this.f.a(new pf.3(this, paramString, paramArrayOfByte));
    if ((paramArrayOfByte != null) && (paramArrayOfByte != fy.a())) {}
    for (int i1 = paramArrayOfByte.length;; i1 = 0)
    {
      os.a("sketch", "data-length", i1);
      os.e();
      os.d();
      os.d();
      os.a();
      if (this.i != null) {
        this.i.a(paramString, paramArrayOfByte);
      }
      return;
    }
  }
  
  public final void a(List<ia> paramList)
  {
    for (;;)
    {
      try
      {
        y();
        long l1 = this.b;
        if (0L == l1) {
          return;
        }
        int i1;
        try
        {
          if (paramList.isEmpty()) {
            return;
          }
          int i2 = paramList.size();
          int[] arrayOfInt1 = new int[i2];
          int[] arrayOfInt2 = new int[i2];
          i1 = 0;
          if (i1 < i2)
          {
            ia localia = (ia)paramList.get(i1);
            if (localia != null)
            {
              arrayOfInt1[i1] = localia.a;
              arrayOfInt2[i1] = localia.b;
            }
          }
          else
          {
            this.a.nativeLoadBlockRouteCityList(this.b, arrayOfInt1, arrayOfInt2, i2);
            return;
          }
        }
        finally {}
        i1 += 1;
      }
      finally
      {
        z();
      }
    }
  }
  
  public final void a(List<hk> paramList, List<GeoPoint> paramList1)
  {
    for (;;)
    {
      try
      {
        y();
        long l1 = this.b;
        if (0L == l1) {
          return;
        }
        if (paramList != null) {}
        int i1;
        try
        {
          if ((!paramList.isEmpty()) && (paramList1 != null) && (!paramList1.isEmpty()))
          {
            int i2 = paramList.size();
            byte[][] arrayOfByte = new byte[i2][];
            i1 = 0;
            if (i1 < i2)
            {
              hk localhk = (hk)paramList.get(i1);
              if (localhk != null) {
                arrayOfByte[i1] = localhk.a();
              }
            }
            else
            {
              i1 = paramList1.size();
              this.a.nativeAddRouteNameSegments(this.b, arrayOfByte, i2, (GeoPoint[])paramList1.toArray(new GeoPoint[i1]), i1);
            }
          }
          else
          {
            return;
          }
        }
        finally {}
        i1 += 1;
      }
      finally
      {
        z();
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      y();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.f.a(new pf.22(this, paramBoolean));
      return;
    }
    finally
    {
      z();
    }
  }
  
  public final void a(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, int paramInt)
  {
    try
    {
      y();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.a.setRestrictBounds(this.b, paramArrayOfDouble1, paramArrayOfDouble2, paramInt);
      return;
    }
    finally
    {
      z();
    }
  }
  
  /* Error */
  public final void a(int[] paramArrayOfInt, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_3
    //   9: lconst_0
    //   10: lload_3
    //   11: lcmp
    //   12: ifne +8 -> 20
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: return
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   26: aload_0
    //   27: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   30: aload_1
    //   31: iload_2
    //   32: invokevirtual 543	com/tencent/map/sdk/engine/jni/JNI:nativeDeleteIcons	(J[II)V
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_0
    //   38: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   41: return
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	pf
    //   0	54	1	paramArrayOfInt	int[]
    //   0	54	2	paramInt	int
    //   8	3	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   22	37	42	finally
    //   43	45	42	finally
    //   0	9	47	finally
    //   20	22	47	finally
    //   45	47	47	finally
  }
  
  /* Error */
  public final boolean a(Context paramContext, ke paramke, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: iconst_1
    //   1: newarray int
    //   3: astore 6
    //   5: aload_0
    //   6: invokevirtual 546	com/tencent/map/sdk/a/pf:A	()V
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   14: aload_3
    //   15: aload 4
    //   17: aload 5
    //   19: aload_1
    //   20: invokestatic 551	com/tencent/map/sdk/a/pz:a	(Landroid/content/Context;)F
    //   23: sipush 256
    //   26: aload_1
    //   27: invokestatic 551	com/tencent/map/sdk/a/pz:a	(Landroid/content/Context;)F
    //   30: aload 6
    //   32: iconst_0
    //   33: getstatic 557	com/tencent/map/lib/MapLanguage:LAN_CHINESE	Lcom/tencent/map/lib/MapLanguage;
    //   36: invokevirtual 560	com/tencent/map/lib/MapLanguage:ordinal	()I
    //   39: invokevirtual 564	com/tencent/map/sdk/engine/jni/JNI:nativeInitEngine	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FIF[IZI)J
    //   42: putfield 112	com/tencent/map/sdk/a/pf:b	J
    //   45: aload 6
    //   47: iconst_0
    //   48: iaload
    //   49: ifeq +37 -> 86
    //   52: new 453	java/lang/StringBuilder
    //   55: dup
    //   56: ldc_w 566
    //   59: invokespecial 457	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload 6
    //   64: iconst_0
    //   65: iaload
    //   66: invokevirtual 464	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: invokevirtual 569	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 441	com/tencent/map/sdk/a/or:a	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: lconst_0
    //   77: putfield 112	com/tencent/map/sdk/a/pf:b	J
    //   80: aload_0
    //   81: invokevirtual 571	com/tencent/map/sdk/a/pf:B	()V
    //   84: iconst_0
    //   85: ireturn
    //   86: aload_0
    //   87: invokevirtual 571	com/tencent/map/sdk/a/pf:B	()V
    //   90: aload_0
    //   91: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   94: aload_0
    //   95: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   98: lconst_0
    //   99: lcmp
    //   100: ifeq +52 -> 152
    //   103: aload_0
    //   104: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   107: aload_2
    //   108: aload_0
    //   109: aload_0
    //   110: aload_0
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 85	com/tencent/map/sdk/a/pf:f	Lcom/tencent/map/sdk/a/lw;
    //   116: getfield 358	com/tencent/map/sdk/a/lw:c	Lcom/tencent/map/sdk/a/kl;
    //   119: aload_0
    //   120: aload_0
    //   121: aload_0
    //   122: aload_0
    //   123: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   126: invokevirtual 575	com/tencent/map/sdk/engine/jni/JNI:initCallback	(Lcom/tencent/map/sdk/a/ke;Lcom/tencent/map/sdk/a/mf;Lcom/tencent/map/sdk/a/me;Lcom/tencent/map/sdk/a/mk;Lcom/tencent/map/sdk/a/mg;Lcom/tencent/map/sdk/a/mj;Lcom/tencent/map/sdk/a/ma;Lcom/tencent/map/sdk/a/ml;Lcom/tencent/map/sdk/a/mi;J)V
    //   129: aload_0
    //   130: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   133: aload_0
    //   134: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   137: ldc_w 576
    //   140: ldc_w 577
    //   143: ldc_w 578
    //   146: ldc_w 579
    //   149: invokevirtual 583	com/tencent/map/sdk/engine/jni/JNI:nativeSetTrafficColor	(JIIII)V
    //   152: aload_0
    //   153: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore_1
    //   159: aload_0
    //   160: invokevirtual 571	com/tencent/map/sdk/a/pf:B	()V
    //   163: aload_1
    //   164: athrow
    //   165: astore_1
    //   166: aload_0
    //   167: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   170: aload_1
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	pf
    //   0	172	1	paramContext	Context
    //   0	172	2	paramke	ke
    //   0	172	3	paramString1	String
    //   0	172	4	paramString2	String
    //   0	172	5	paramString3	String
    //   3	60	6	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   5	45	158	finally
    //   52	80	158	finally
    //   90	152	165	finally
  }
  
  /* Error */
  public final ii b(GeoPoint paramGeoPoint)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_3
    //   9: lconst_0
    //   10: lload_3
    //   11: lcmp
    //   12: ifne +9 -> 21
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   27: aload_0
    //   28: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   31: invokevirtual 588	com/tencent/map/sdk/engine/jni/JNI:nativeGetActiveIndoorBuildingGUID	(J)Ljava/lang/String;
    //   34: astore 5
    //   36: aload_0
    //   37: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   40: aload_0
    //   41: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   44: aload_1
    //   45: invokevirtual 592	com/tencent/map/sdk/engine/jni/JNI:nativeGetCurIndoorName	(JLcom/tencent/map/lib/basemap/data/GeoPoint;)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_0
    //   50: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   53: aload_0
    //   54: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   57: invokevirtual 596	com/tencent/map/sdk/engine/jni/JNI:nativeGetIndoorCurrentFloorId	(J)I
    //   60: istore_2
    //   61: new 598	com/tencent/map/sdk/a/ii
    //   64: dup
    //   65: aload 5
    //   67: aload_1
    //   68: aload_0
    //   69: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   72: aload_0
    //   73: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   76: invokevirtual 602	com/tencent/map/sdk/engine/jni/JNI:nativeGetIndoorFloorNames	(J)[Ljava/lang/String;
    //   79: iload_2
    //   80: invokespecial 605	com/tencent/map/sdk/a/ii:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;I)V
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_0
    //   87: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   90: aload_1
    //   91: areturn
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: astore_1
    //   98: aload_0
    //   99: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	pf
    //   0	104	1	paramGeoPoint	GeoPoint
    //   60	20	2	i1	int
    //   8	3	3	l1	long
    //   34	32	5	str	String
    // Exception table:
    //   from	to	target	type
    //   23	86	92	finally
    //   93	95	92	finally
    //   0	9	97	finally
    //   21	23	97	finally
    //   95	97	97	finally
  }
  
  /* Error */
  public final com.tencent.map.sdk.engine.jni.models.TappedElement b(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_3
    //   9: lload_3
    //   10: lconst_0
    //   11: lcmp
    //   12: ifne +9 -> 21
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   27: aload_0
    //   28: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   31: fload_1
    //   32: fload_2
    //   33: invokevirtual 612	com/tencent/map/sdk/engine/jni/JNI:nativeOnTap	(JFF)[B
    //   36: astore 5
    //   38: aload 5
    //   40: ifnonnull +11 -> 51
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_0
    //   46: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   49: aconst_null
    //   50: areturn
    //   51: aload 5
    //   53: invokestatic 618	com/tencent/map/sdk/engine/jni/models/TappedElement:fromBytes	([B)Lcom/tencent/map/sdk/engine/jni/models/TappedElement;
    //   56: astore 5
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_0
    //   61: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   64: aload 5
    //   66: areturn
    //   67: astore 5
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_0
    //   72: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   75: aconst_null
    //   76: areturn
    //   77: astore 5
    //   79: aload_0
    //   80: monitorexit
    //   81: aload 5
    //   83: athrow
    //   84: astore 5
    //   86: aload_0
    //   87: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   90: aload 5
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	pf
    //   0	93	1	paramFloat1	float
    //   0	93	2	paramFloat2	float
    //   8	2	3	l1	long
    //   36	29	5	localObject1	Object
    //   67	1	5	localException	java.lang.Exception
    //   77	5	5	localObject2	Object
    //   84	7	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   51	58	67	java/lang/Exception
    //   23	38	77	finally
    //   43	45	77	finally
    //   51	58	77	finally
    //   58	60	77	finally
    //   69	71	77	finally
    //   79	81	77	finally
    //   0	9	84	finally
    //   21	23	84	finally
    //   81	84	84	finally
  }
  
  public final void b()
  {
    if (this.e != null) {
      this.e.b();
    }
  }
  
  /* Error */
  public final void b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_2
    //   9: lconst_0
    //   10: lload_2
    //   11: lcmp
    //   12: ifne +8 -> 20
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: return
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   26: aload_0
    //   27: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   30: iload_1
    //   31: invokevirtual 625	com/tencent/map/sdk/engine/jni/JNI:nativeSetMinScaleLevel	(JI)V
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_0
    //   37: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   40: return
    //   41: astore 4
    //   43: aload_0
    //   44: monitorexit
    //   45: aload 4
    //   47: athrow
    //   48: astore 4
    //   50: aload_0
    //   51: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   54: aload 4
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	pf
    //   0	57	1	paramInt	int
    //   8	3	2	l1	long
    //   41	5	4	localObject1	Object
    //   48	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	36	41	finally
    //   43	45	41	finally
    //   0	9	48	finally
    //   20	22	48	finally
    //   45	48	48	finally
  }
  
  /* Error */
  public final void b(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_3
    //   9: lload_3
    //   10: lconst_0
    //   11: lcmp
    //   12: ifne +8 -> 20
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: return
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   26: aload_0
    //   27: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   30: iload_1
    //   31: iload_2
    //   32: invokevirtual 629	com/tencent/map/sdk/engine/jni/JNI:nativeSetTileOverlayPriority	(JII)V
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_0
    //   38: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   41: return
    //   42: astore 5
    //   44: aload_0
    //   45: monitorexit
    //   46: aload 5
    //   48: athrow
    //   49: astore 5
    //   51: aload_0
    //   52: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   55: aload 5
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	pf
    //   0	58	1	paramInt1	int
    //   0	58	2	paramInt2	int
    //   8	2	3	l1	long
    //   42	5	5	localObject1	Object
    //   49	7	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	37	42	finally
    //   44	46	42	finally
    //   0	9	49	finally
    //   20	22	49	finally
    //   46	49	49	finally
  }
  
  public final void b(String paramString)
  {
    this.k += 1;
    this.l += 1;
    new StringBuilder("fail : ").append(this.l).toString();
    os.a();
    if (this.k >= 30)
    {
      if (this.b != 0L) {
        this.f.a(new pf.2(this));
      }
      this.k = 0;
    }
    if (this.i != null) {
      this.i.b(paramString);
    }
  }
  
  public final void b(String paramString, qd paramqd)
  {
    if (DataSource.get(paramqd.b) == DataSource.TILE_OVERLAY)
    {
      MapTileID localMapTileID = (MapTileID)paramqd.d;
      int i1 = localMapTileID.getTileTag();
      ix localix = this.f.D.a(i1);
      if (localix != null)
      {
        or.a("Use TileOverlay DownloadMgr to request download..");
        qg localqg = localix.e();
        localqg.a(this);
        localqg.a(paramString, new iw(localix.k), paramqd.c);
        os.e();
        new StringBuilder("R/").append(localMapTileID.getX()).append("-").append(localMapTileID.getY()).append("-").append(localMapTileID.getZ());
        os.e();
        return;
      }
    }
    or.a("Use Default DownloadMgr to request download..");
    this.d.a(paramString, this.f.p.b());
  }
  
  public final void b(boolean paramBoolean)
  {
    if (0L == this.b) {
      return;
    }
    this.f.a(new pf.6(this, paramBoolean));
  }
  
  public final void c(float paramFloat1, float paramFloat2)
  {
    if ((0L == this.b) || (this.f == null)) {
      return;
    }
    this.f.a(new pf.15(this, paramFloat1, paramFloat2));
  }
  
  public final void c(String paramString)
  {
    this.h = paramString;
  }
  
  public final void c(boolean paramBoolean)
  {
    try
    {
      y();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.a.nativeEnablePOI(this.b, paramBoolean);
      return;
    }
    finally
    {
      z();
    }
  }
  
  public final boolean c()
  {
    try
    {
      y();
      long l1 = this.b;
      if (l1 == 0L) {
        return false;
      }
      boolean bool = this.a.nativeGenerateTextures(this.b);
      return bool;
    }
    finally
    {
      z();
    }
  }
  
  public final void d(float paramFloat1, float paramFloat2)
  {
    if ((0L == this.b) || (this.f == null)) {
      return;
    }
    this.f.a(new pf.19(this, paramFloat1, paramFloat2));
  }
  
  public final void d(boolean paramBoolean)
  {
    try
    {
      y();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.a.nativeEnableVectorMap(this.b, paramBoolean);
      return;
    }
    finally
    {
      z();
    }
  }
  
  public final boolean d()
  {
    try
    {
      y();
      long l1 = this.b;
      if (l1 == 0L) {
        return false;
      }
      this.a.nativeDrawFrame(this.b);
      return true;
    }
    finally
    {
      z();
    }
  }
  
  public final void e()
  {
    if (this.f != null)
    {
      lw locallw = this.f;
      if (locallw.C != null) {
        locallw.C.e();
      }
    }
  }
  
  /* Error */
  @java.lang.Deprecated
  public final boolean f()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_1
    //   9: lload_1
    //   10: lconst_0
    //   11: lcmp
    //   12: ifne +9 -> 21
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: iconst_1
    //   20: ireturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   27: aload_0
    //   28: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   31: invokevirtual 701	com/tencent/map/sdk/engine/jni/JNI:nativeIsMapDrawFinished	(J)Z
    //   34: istore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_0
    //   38: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   41: iload_3
    //   42: ireturn
    //   43: astore 4
    //   45: aload_0
    //   46: monitorexit
    //   47: aload 4
    //   49: athrow
    //   50: astore 4
    //   52: aload_0
    //   53: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   56: aload 4
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	pf
    //   8	2	1	l1	long
    //   34	8	3	bool	boolean
    //   43	5	4	localObject1	Object
    //   50	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	37	43	finally
    //   45	47	43	finally
    //   0	9	50	finally
    //   21	23	50	finally
    //   47	50	50	finally
  }
  
  /* Error */
  public final jo[] g()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_2
    //   9: lload_2
    //   10: lconst_0
    //   11: lcmp
    //   12: ifne +9 -> 21
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   27: aload_0
    //   28: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   31: invokevirtual 707	com/tencent/map/sdk/engine/jni/JNI:nativeFetchLackedTrafficBlocks	(J)[I
    //   34: astore 4
    //   36: aload 4
    //   38: ifnull +9 -> 47
    //   41: aload 4
    //   43: arraylength
    //   44: ifne +11 -> 55
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   53: aconst_null
    //   54: areturn
    //   55: aload 4
    //   57: arraylength
    //   58: bipush 7
    //   60: idiv
    //   61: anewarray 709	com/tencent/map/sdk/a/jo
    //   64: astore 5
    //   66: iconst_0
    //   67: istore_1
    //   68: iload_1
    //   69: aload 4
    //   71: arraylength
    //   72: bipush 7
    //   74: idiv
    //   75: if_icmpge +132 -> 207
    //   78: aload 5
    //   80: iload_1
    //   81: new 709	com/tencent/map/sdk/a/jo
    //   84: dup
    //   85: invokespecial 710	com/tencent/map/sdk/a/jo:<init>	()V
    //   88: aastore
    //   89: aload 5
    //   91: iload_1
    //   92: aaload
    //   93: aload 4
    //   95: iload_1
    //   96: bipush 7
    //   98: imul
    //   99: iaload
    //   100: putfield 711	com/tencent/map/sdk/a/jo:a	I
    //   103: aload 5
    //   105: iload_1
    //   106: aaload
    //   107: aload 4
    //   109: iload_1
    //   110: bipush 7
    //   112: imul
    //   113: iconst_1
    //   114: iadd
    //   115: iaload
    //   116: putfield 712	com/tencent/map/sdk/a/jo:b	I
    //   119: aload 5
    //   121: iload_1
    //   122: aaload
    //   123: aload 4
    //   125: iload_1
    //   126: bipush 7
    //   128: imul
    //   129: iconst_2
    //   130: iadd
    //   131: iaload
    //   132: putfield 714	com/tencent/map/sdk/a/jo:d	I
    //   135: aload 5
    //   137: iload_1
    //   138: aaload
    //   139: aload 4
    //   141: iload_1
    //   142: bipush 7
    //   144: imul
    //   145: iconst_3
    //   146: iadd
    //   147: iaload
    //   148: putfield 715	com/tencent/map/sdk/a/jo:c	I
    //   151: aload 5
    //   153: iload_1
    //   154: aaload
    //   155: aload 4
    //   157: iload_1
    //   158: bipush 7
    //   160: imul
    //   161: iconst_4
    //   162: iadd
    //   163: iaload
    //   164: putfield 716	com/tencent/map/sdk/a/jo:f	I
    //   167: aload 5
    //   169: iload_1
    //   170: aaload
    //   171: aload 4
    //   173: iload_1
    //   174: bipush 7
    //   176: imul
    //   177: iconst_5
    //   178: iadd
    //   179: iaload
    //   180: putfield 718	com/tencent/map/sdk/a/jo:e	I
    //   183: aload 5
    //   185: iload_1
    //   186: aaload
    //   187: aload 4
    //   189: iload_1
    //   190: bipush 7
    //   192: imul
    //   193: bipush 6
    //   195: iadd
    //   196: iaload
    //   197: putfield 720	com/tencent/map/sdk/a/jo:g	I
    //   200: iload_1
    //   201: iconst_1
    //   202: iadd
    //   203: istore_1
    //   204: goto -136 -> 68
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_0
    //   210: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   213: aload 5
    //   215: areturn
    //   216: astore 4
    //   218: aload_0
    //   219: monitorexit
    //   220: aload 4
    //   222: athrow
    //   223: astore 4
    //   225: aload_0
    //   226: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   229: aload 4
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	pf
    //   67	137	1	i1	int
    //   8	2	2	l1	long
    //   34	154	4	arrayOfInt	int[]
    //   216	5	4	localObject1	Object
    //   223	7	4	localObject2	Object
    //   64	150	5	arrayOfjo	jo[]
    // Exception table:
    //   from	to	target	type
    //   23	36	216	finally
    //   41	47	216	finally
    //   47	49	216	finally
    //   55	66	216	finally
    //   68	200	216	finally
    //   207	209	216	finally
    //   218	220	216	finally
    //   0	9	223	finally
    //   21	23	223	finally
    //   220	223	223	finally
  }
  
  public final void h()
  {
    if (0L == this.b) {
      return;
    }
    this.f.a(new pf.4(this));
  }
  
  public final void i()
  {
    if (this.f != null)
    {
      Object localObject = this.f;
      if ((((lw)localObject).F != null) && (!((lw)localObject).F.isEmpty()))
      {
        localObject = ((lw)localObject).F.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((mi)((Iterator)localObject).next()).i();
        }
      }
    }
  }
  
  public final void j()
  {
    if (this.f != null)
    {
      Object localObject = this.f;
      if ((((lw)localObject).F != null) && (!((lw)localObject).F.isEmpty()))
      {
        localObject = ((lw)localObject).F.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((mi)((Iterator)localObject).next()).j();
        }
      }
    }
  }
  
  /* Error */
  public final GeoPoint k()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_1
    //   9: lconst_0
    //   10: lload_1
    //   11: lcmp
    //   12: ifne +9 -> 21
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_0
    //   22: monitorenter
    //   23: new 181	com/tencent/map/lib/basemap/data/GeoPoint
    //   26: dup
    //   27: invokespecial 274	com/tencent/map/lib/basemap/data/GeoPoint:<init>	()V
    //   30: astore_3
    //   31: aload_0
    //   32: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   35: aload_0
    //   36: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   39: aload_3
    //   40: invokevirtual 746	com/tencent/map/sdk/engine/jni/JNI:nativeGetCenterMapPoint	(JLcom/tencent/map/lib/basemap/data/GeoPoint;)V
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_0
    //   46: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   49: aload_3
    //   50: areturn
    //   51: astore_3
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_3
    //   55: athrow
    //   56: astore_3
    //   57: aload_0
    //   58: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   61: aload_3
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	pf
    //   8	3	1	l1	long
    //   30	20	3	localGeoPoint	GeoPoint
    //   51	4	3	localObject1	Object
    //   56	6	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	45	51	finally
    //   52	54	51	finally
    //   0	9	56	finally
    //   21	23	56	finally
    //   54	56	56	finally
  }
  
  /* Error */
  public final float l()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_2
    //   9: lconst_0
    //   10: lload_2
    //   11: lcmp
    //   12: ifne +9 -> 21
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: fconst_1
    //   20: freturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   27: aload_0
    //   28: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   31: invokevirtual 750	com/tencent/map/sdk/engine/jni/JNI:nativeGetScale	(J)D
    //   34: d2f
    //   35: fstore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_0
    //   39: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   42: fload_1
    //   43: freturn
    //   44: astore 4
    //   46: aload_0
    //   47: monitorexit
    //   48: aload 4
    //   50: athrow
    //   51: astore 4
    //   53: aload_0
    //   54: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   57: aload 4
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	pf
    //   35	8	1	f1	float
    //   8	3	2	l1	long
    //   44	5	4	localObject1	Object
    //   51	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	38	44	finally
    //   46	48	44	finally
    //   0	9	51	finally
    //   21	23	51	finally
    //   48	51	51	finally
  }
  
  /* Error */
  public final int m()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_2
    //   9: lconst_0
    //   10: lload_2
    //   11: lcmp
    //   12: ifne +10 -> 22
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: bipush 20
    //   21: ireturn
    //   22: aload_0
    //   23: monitorenter
    //   24: aload_0
    //   25: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   28: aload_0
    //   29: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   32: invokevirtual 753	com/tencent/map/sdk/engine/jni/JNI:nativeGetScaleLevel	(J)I
    //   35: istore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_0
    //   39: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   42: iload_1
    //   43: ireturn
    //   44: astore 4
    //   46: aload_0
    //   47: monitorexit
    //   48: aload 4
    //   50: athrow
    //   51: astore 4
    //   53: aload_0
    //   54: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   57: aload 4
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	pf
    //   35	8	1	i1	int
    //   8	3	2	l1	long
    //   44	5	4	localObject1	Object
    //   51	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	38	44	finally
    //   46	48	44	finally
    //   0	9	51	finally
    //   22	24	51	finally
    //   48	51	51	finally
  }
  
  public final void n()
  {
    if ((0L == this.b) || (this.f == null)) {
      return;
    }
    this.f.a(new pf.20(this));
  }
  
  /* Error */
  public final boolean o()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_1
    //   9: lconst_0
    //   10: lload_1
    //   11: lcmp
    //   12: ifne +9 -> 21
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   27: aload_0
    //   28: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   31: invokevirtual 759	com/tencent/map/sdk/engine/jni/JNI:nativeNeedDispaly	(J)Z
    //   34: istore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_0
    //   38: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   41: iload_3
    //   42: ireturn
    //   43: astore 4
    //   45: aload_0
    //   46: monitorexit
    //   47: aload 4
    //   49: athrow
    //   50: astore 4
    //   52: aload_0
    //   53: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   56: aload 4
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	pf
    //   8	3	1	l1	long
    //   34	8	3	bool	boolean
    //   43	5	4	localObject1	Object
    //   50	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	37	43	finally
    //   45	47	43	finally
    //   0	9	50	finally
    //   21	23	50	finally
    //   47	50	50	finally
  }
  
  public final float p()
  {
    try
    {
      y();
      long l1 = this.b;
      if (0L == l1) {
        return 0.0F;
      }
      float f1 = this.a.nativeGetSkew(this.b);
      return f1;
    }
    finally
    {
      z();
    }
  }
  
  public final float q()
  {
    try
    {
      y();
      long l1 = this.b;
      if (0L == l1) {
        return 0.0F;
      }
      float f1 = this.a.nativeGetRotate(this.b);
      return f1;
    }
    finally
    {
      z();
    }
  }
  
  /* Error */
  public final int r()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_2
    //   9: lconst_0
    //   10: lload_2
    //   11: lcmp
    //   12: ifne +9 -> 21
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: iconst_1
    //   20: ireturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   27: aload_0
    //   28: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   31: invokevirtual 770	com/tencent/map/sdk/engine/jni/JNI:nativeGetMapMode	(J)I
    //   34: istore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_0
    //   38: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   41: iload_1
    //   42: ireturn
    //   43: astore 4
    //   45: aload_0
    //   46: monitorexit
    //   47: aload 4
    //   49: athrow
    //   50: astore 4
    //   52: aload_0
    //   53: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   56: aload 4
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	pf
    //   34	8	1	i1	int
    //   8	3	2	l1	long
    //   43	5	4	localObject1	Object
    //   50	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	37	43	finally
    //   45	47	43	finally
    //   0	9	50	finally
    //   21	23	50	finally
    //   47	50	50	finally
  }
  
  /* Error */
  public final void s()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_1
    //   9: lconst_0
    //   10: lload_1
    //   11: lcmp
    //   12: ifne +8 -> 20
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: return
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   26: aload_0
    //   27: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   30: invokevirtual 774	com/tencent/map/sdk/engine/jni/JNI:nativeClearRouteNameSegments	(J)V
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_0
    //   36: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   39: return
    //   40: astore_3
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_3
    //   44: athrow
    //   45: astore_3
    //   46: aload_0
    //   47: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   50: aload_3
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	pf
    //   8	3	1	l1	long
    //   40	4	3	localObject1	Object
    //   45	6	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	35	40	finally
    //   41	43	40	finally
    //   0	9	45	finally
    //   20	22	45	finally
    //   43	45	45	finally
  }
  
  /* Error */
  public final int t()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 132	com/tencent/map/sdk/a/pf:y	()V
    //   4: aload_0
    //   5: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   8: lstore_2
    //   9: lload_2
    //   10: lconst_0
    //   11: lcmp
    //   12: ifne +9 -> 21
    //   15: aload_0
    //   16: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 75	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   27: aload_0
    //   28: getfield 112	com/tencent/map/sdk/a/pf:b	J
    //   31: invokevirtual 778	com/tencent/map/sdk/engine/jni/JNI:nativeGetLanguage	(J)I
    //   34: istore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_0
    //   38: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   41: iload_1
    //   42: ireturn
    //   43: astore 4
    //   45: aload_0
    //   46: monitorexit
    //   47: aload 4
    //   49: athrow
    //   50: astore 4
    //   52: aload_0
    //   53: invokevirtual 135	com/tencent/map/sdk/a/pf:z	()V
    //   56: aload 4
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	pf
    //   34	8	1	i1	int
    //   8	2	2	l1	long
    //   43	5	4	localObject1	Object
    //   50	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	37	43	finally
    //   45	47	43	finally
    //   0	9	50	finally
    //   21	23	50	finally
    //   47	50	50	finally
  }
  
  public final String u()
  {
    try
    {
      y();
      if (this.b == 0L) {
        return "";
      }
      String str = this.a.nativeGetDataEngineVersion(this.b);
      return str;
    }
    finally
    {
      z();
    }
  }
  
  public final String v()
  {
    try
    {
      y();
      long l1 = this.b;
      if (l1 == 0L) {
        return null;
      }
      String str = this.a.getMapEngineRenderStatus(this.b);
      return str;
    }
    finally
    {
      z();
    }
  }
  
  public final ArrayList<MapPoi> w()
  {
    try
    {
      y();
      long l1 = this.b;
      if (l1 == 0L) {
        return null;
      }
      ArrayList localArrayList = this.a.nativeGetPoisInScreen(this.b);
      return localArrayList;
    }
    finally
    {
      z();
    }
  }
  
  public final boolean x()
  {
    try
    {
      y();
      long l1 = this.b;
      if (l1 == 0L) {
        return false;
      }
      boolean bool = this.a.checkMapLoadFinishedTask(this.b, 1);
      return bool;
    }
    finally
    {
      z();
    }
  }
  
  public final void y()
  {
    this.n.readLock().lock();
  }
  
  public final void z()
  {
    this.n.readLock().unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.pf
 * JD-Core Version:    0.7.0.1
 */