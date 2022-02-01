package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PathDrawer
  implements MyParcelable
{
  public static final MyParcelable.Creator<PathDrawer> b = new PathDrawer.1();
  public int a = -1;
  private Path c = new Path();
  private ArrayList<PathDrawer.PathSegment> d = new ArrayList();
  private Paint e = new Paint();
  private int f = -1;
  private Rect g = new Rect();
  private Rect h = new Rect();
  private List<PathData.PointData> i = new ArrayList();
  private PathData.PointData j = null;
  private PathAlgorithm k = null;
  
  public PathDrawer(MyParcel paramMyParcel)
  {
    paramMyParcel.b();
    List localList = this.i;
    if (localList != null) {
      paramMyParcel.a(localList, PathData.PointData.a);
    }
    paramMyParcel.a(this.d, PathDrawer.PathSegment.a);
    int m = paramMyParcel.b();
    a(paramMyParcel.b(), m);
    this.g = paramMyParcel.c();
    this.h = paramMyParcel.c();
    this.j = ((PathData.PointData)paramMyParcel.a(PathData.PointData.a));
    this.a = paramMyParcel.b();
    this.k = new HalfAlgorithm();
    paramMyParcel = this.i;
    if (paramMyParcel != null)
    {
      this.k.a(paramMyParcel, this.c, this.d);
      this.i = null;
    }
    else
    {
      this.c.reset();
    }
    this.k = null;
    if ((!this.h.equals(this.g)) && (this.h != null) && (this.g != null))
    {
      float f1 = g();
      paramMyParcel = new StringBuilder();
      paramMyParcel.append("scale:");
      paramMyParcel.append(f1);
      QLog.d("PathDrawer", 2, paramMyParcel.toString());
      a(f1, false);
      return;
    }
    QLog.d("PathDrawer", 2, "data area equal draw area, no scale.");
  }
  
  public PathDrawer(PathData paramPathData, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat)
  {
    this.a = paramPathData.a;
    this.g.set(0, 0, paramInt1, paramInt2);
    this.i.addAll(paramPathData.e());
    this.k = new HalfAlgorithm();
    this.k.a(paramInt5, paramInt6, paramFloat);
    this.k.a(paramPathData.e(), this.c, this.d, 1000);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("after transPath, segments count:");
    localStringBuilder.append(this.d.size());
    QLog.d("PathDrawer", 2, localStringBuilder.toString());
    this.k = null;
    if (paramPathData.d() > 0) {
      this.j = new PathData.PointData(paramPathData.g());
    }
    a(paramPathData.c(), paramPathData.b());
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      a(0, 0, paramInt3, paramInt4);
      return;
    }
    this.h.set(this.g);
  }
  
  private int a(long paramLong, boolean paramBoolean)
  {
    int i1 = this.d.size();
    if (i1 == 0) {
      return -1;
    }
    int n = 0;
    long l;
    if (i1 == 1)
    {
      l = ((PathDrawer.PathSegment)this.d.get(0)).d();
      if (paramBoolean)
      {
        if (l >= paramLong) {
          return 0;
        }
        return -1;
      }
      if (l > paramLong) {
        return 0;
      }
      return -1;
    }
    int m = i1;
    if (((PathDrawer.PathSegment)this.d.get(i1 - 1)).d() < paramLong) {
      return -1;
    }
    while (m > n)
    {
      i1 = (m + n) / 2;
      l = ((PathDrawer.PathSegment)this.d.get(i1)).d();
      if (l == paramLong)
      {
        if (paramBoolean) {
          return i1 - ((PathDrawer.PathSegment)this.d.get(i1)).e();
        }
        m = i1 + 1;
        while ((m < this.d.size()) && (l >= ((PathDrawer.PathSegment)this.d.get(m)).d())) {
          m += 1;
        }
        if (m == this.d.size()) {
          return -1;
        }
        return m;
      }
      if (l < paramLong) {
        n = i1 + 1;
      } else if (l > paramLong) {
        m = i1 - ((PathDrawer.PathSegment)this.d.get(i1)).e();
      }
    }
    return m - ((PathDrawer.PathSegment)this.d.get(m)).e();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.e.setAntiAlias(true);
    this.e.setStyle(Paint.Style.STROKE);
    this.e.setStrokeJoin(Paint.Join.ROUND);
    this.e.setStrokeCap(Paint.Cap.ROUND);
    this.e.setXfermode(null);
    a(paramInt1);
    b(paramInt2);
  }
  
  private void a(Canvas paramCanvas, PathData.PointData paramPointData)
  {
    if ((paramCanvas != null) && (paramPointData != null))
    {
      Paint localPaint = this.e;
      if (localPaint != null)
      {
        localPaint.setStrokeWidth(paramPointData.c() / 2.0F);
        paramCanvas.drawCircle(paramPointData.a(), paramPointData.b(), paramPointData.c() / 4.0F, this.e);
      }
    }
  }
  
  private void a(Canvas paramCanvas, PathDrawer.PathSegment paramPathSegment)
  {
    if (paramCanvas != null)
    {
      this.e.setStrokeWidth(paramPathSegment.b());
      paramCanvas.drawPath(paramPathSegment.a(), this.e);
    }
  }
  
  private float g()
  {
    float f1 = this.h.width() * 1.0F / this.g.width();
    float f2 = this.h.height() * 1.0F / this.g.height();
    if (f1 < f2) {
      return f1;
    }
    return f2;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.j = new PathData.PointData(paramFloat1, paramFloat2, paramFloat3, paramLong);
    if (this.k == null) {
      this.k = new HalfAlgorithm();
    }
    this.k.a(paramFloat1, paramFloat2, paramFloat3, 0L, this.c, this.d);
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (!this.c.isEmpty())
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).postScale(paramFloat, paramFloat);
      localObject2 = new Path();
      ((Path)localObject2).addPath(this.c, (Matrix)localObject1);
      this.c = ((Path)localObject2);
    }
    if (this.d.size() > 0)
    {
      localObject1 = this.d.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PathDrawer.PathSegment)((Iterator)localObject1).next();
        ((PathDrawer.PathSegment)localObject2).c(paramFloat);
        if (paramBoolean) {
          ((PathDrawer.PathSegment)localObject2).a(((PathDrawer.PathSegment)localObject2).b() * paramFloat);
        }
      }
    }
    if (paramBoolean)
    {
      localObject1 = this.j;
      if (localObject1 != null) {
        ((PathData.PointData)localObject1).d(paramFloat);
      }
    }
  }
  
  public void a(int paramInt)
  {
    b(-1);
    this.e.setColor(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = paramInt3 - paramInt1;
    if (m != 0)
    {
      int n = paramInt4 - paramInt2;
      if (n == 0) {
        return;
      }
      Object localObject = this.h;
      if (localObject == null) {
        return;
      }
      if ((((Rect)localObject).width() == m) && (this.h.height() == n))
      {
        QLog.d("PathDrawer", 2, "draw area not change.");
        return;
      }
      if ((!this.h.isEmpty()) && (!this.g.isEmpty()) && (!this.h.equals(this.g))) {
        f1 = g();
      } else {
        f1 = 1.0F;
      }
      this.h.set(paramInt1, paramInt2, paramInt3, paramInt4);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setArea:");
      ((StringBuilder)localObject).append(this.h);
      QLog.d("PathDrawer", 2, ((StringBuilder)localObject).toString());
      float f2 = g();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scale:");
      ((StringBuilder)localObject).append(f2);
      ((StringBuilder)localObject).append("  Old:");
      ((StringBuilder)localObject).append(f1);
      QLog.d("PathDrawer", 2, ((StringBuilder)localObject).toString());
      float f1 = f2 / f1;
      double d1 = f1 - 1.0F;
      if ((d1 < 1.0E-006D) && (d1 > -1.0E-006D)) {
        QLog.d("PathDrawer", 2, "scale no change, return:");
      }
      a(f1, true);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.d.size() == 0)
    {
      localObject = this.j;
      if (localObject != null) {
        a(paramCanvas, (PathData.PointData)localObject);
      }
      return;
    }
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext()) {
      a(paramCanvas, (PathDrawer.PathSegment)((Iterator)localObject).next());
    }
  }
  
  public void a(MyParcel paramMyParcel, int paramInt)
  {
    paramMyParcel.a(1);
    paramMyParcel.a(this.i);
    paramMyParcel.a(this.d);
    paramMyParcel.a(this.f);
    paramMyParcel.a(this.e.getColor());
    paramMyParcel.a(this.g);
    paramMyParcel.a(this.h);
    paramMyParcel.a(this.j);
    paramMyParcel.a(this.a);
  }
  
  public void a(boolean paramBoolean)
  {
    PathAlgorithm localPathAlgorithm = this.k;
    if (localPathAlgorithm != null)
    {
      if (!paramBoolean)
      {
        localPathAlgorithm.a(this.c, this.d);
        return;
      }
      localPathAlgorithm.a(this.d, 0);
      this.k = null;
    }
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      return false;
    }
    if (paramInt1 > paramInt2) {
      return false;
    }
    int m = paramInt1;
    if (paramInt1 < 0) {
      m = 0;
    }
    PathData.PointData localPointData;
    if ((paramInt2 == 0) && (this.d.size() == 0))
    {
      localPointData = this.j;
      if (localPointData != null) {
        a(paramCanvas, localPointData);
      }
      return true;
    }
    if (this.d.size() == 0)
    {
      if (m == 0)
      {
        localPointData = this.j;
        if (localPointData != null) {
          a(paramCanvas, localPointData);
        }
      }
      return false;
    }
    int n = m;
    paramInt1 = paramInt2;
    if (paramInt2 > this.d.size())
    {
      paramInt1 = this.d.size();
      n = m;
    }
    while (n < paramInt1)
    {
      a(paramCanvas, (PathDrawer.PathSegment)this.d.get(n));
      n += 1;
    }
    return paramInt1 < this.d.size();
  }
  
  public boolean a(Canvas paramCanvas, long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L) {
      return false;
    }
    if (paramLong1 > paramLong2) {
      return false;
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    PathData.PointData localPointData;
    if ((paramLong2 == 0L) && (this.d.size() == 0))
    {
      localPointData = this.j;
      if (localPointData != null) {
        a(paramCanvas, localPointData);
      }
      return true;
    }
    if (this.d.size() == 0)
    {
      if (l == 0L)
      {
        localPointData = this.j;
        if (localPointData != null) {
          a(paramCanvas, localPointData);
        }
      }
      return false;
    }
    if ((paramLong2 == 0L) && (this.d.size() != 0)) {
      return true;
    }
    int i1 = a(l, true);
    int i2 = a(paramLong2, false);
    if (i1 < 0) {
      return true;
    }
    int n;
    int m;
    if (i2 < 0)
    {
      n = this.d.size();
      m = i1;
    }
    else
    {
      m = i1;
      n = i2;
      if (i2 == i1)
      {
        if (this.d.size() <= i2) {
          return true;
        }
        a(paramCanvas, (PathDrawer.PathSegment)this.d.get(i1));
        return false;
      }
    }
    while (m < n)
    {
      a(paramCanvas, (PathDrawer.PathSegment)this.d.get(m));
      m += 1;
    }
    return n < this.d.size();
  }
  
  public void b()
  {
    this.e.reset();
    this.c.reset();
    this.d.clear();
    this.j = null;
    this.f = -1;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    PathAlgorithm localPathAlgorithm = this.k;
    if (localPathAlgorithm != null) {
      localPathAlgorithm.b(paramFloat1, paramFloat2, paramFloat3, paramLong, this.c, this.d);
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt > 0)
    {
      this.e.setShader(null);
      Object localObject = DoodleResHelper.a().e(0, paramInt);
      if (localObject != null)
      {
        localObject = new BitmapShader((Bitmap)localObject, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.e.setShader((Shader)localObject);
      }
    }
    else
    {
      this.e.setShader(null);
    }
    this.f = paramInt;
  }
  
  public int c()
  {
    if (this.d.size() > 0) {
      return this.d.size();
    }
    if (this.j != null) {
      return 1;
    }
    return 0;
  }
  
  public long d()
  {
    if (this.d.size() > 0)
    {
      ArrayList localArrayList = this.d;
      return ((PathDrawer.PathSegment)localArrayList.get(localArrayList.size() - 1)).d();
    }
    if (this.j != null) {}
    return 0L;
  }
  
  public void e()
  {
    this.i = null;
  }
  
  public boolean f()
  {
    return ((this.d.size() > 0) && (!this.c.isEmpty())) || ((this.d.size() == 0) && (this.j != null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PathDrawer
 * JD-Core Version:    0.7.0.1
 */