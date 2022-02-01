package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

public class ShapeAppearancePathProvider
{
  private final ShapePath[] a = new ShapePath[4];
  private final Matrix[] b = new Matrix[4];
  private final Matrix[] c = new Matrix[4];
  private final PointF d = new PointF();
  private final Path e = new Path();
  private final Path f = new Path();
  private final ShapePath g = new ShapePath();
  private final float[] h = new float[2];
  private final float[] i = new float[2];
  private final Path j = new Path();
  private final Path k = new Path();
  private boolean l = true;
  
  public ShapeAppearancePathProvider()
  {
    int m = 0;
    while (m < 4)
    {
      this.a[m] = new ShapePath();
      this.b[m] = new Matrix();
      this.c[m] = new Matrix();
      m += 1;
    }
  }
  
  private float a(@NonNull RectF paramRectF, int paramInt)
  {
    this.h[0] = this.a[paramInt].c;
    this.h[1] = this.a[paramInt].d;
    this.b[paramInt].mapPoints(this.h);
    if ((paramInt != 1) && (paramInt != 3)) {
      return Math.abs(paramRectF.centerY() - this.h[1]);
    }
    return Math.abs(paramRectF.centerX() - this.h[0]);
  }
  
  private CornerTreatment a(int paramInt, @NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramShapeAppearanceModel.c();
        }
        return paramShapeAppearanceModel.b();
      }
      return paramShapeAppearanceModel.e();
    }
    return paramShapeAppearanceModel.d();
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  @UiThread
  public static ShapeAppearancePathProvider a()
  {
    return ShapeAppearancePathProvider.Lazy.a;
  }
  
  private void a(int paramInt)
  {
    this.h[0] = this.a[paramInt].d();
    this.h[1] = this.a[paramInt].e();
    this.b[paramInt].mapPoints(this.h);
    float f1 = b(paramInt);
    this.c[paramInt].reset();
    Matrix localMatrix = this.c[paramInt];
    float[] arrayOfFloat = this.h;
    localMatrix.setTranslate(arrayOfFloat[0], arrayOfFloat[1]);
    this.c[paramInt].preRotate(f1);
  }
  
  private void a(int paramInt, @NonNull RectF paramRectF, @NonNull PointF paramPointF)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          paramPointF.set(paramRectF.right, paramRectF.top);
          return;
        }
        paramPointF.set(paramRectF.left, paramRectF.top);
        return;
      }
      paramPointF.set(paramRectF.left, paramRectF.bottom);
      return;
    }
    paramPointF.set(paramRectF.right, paramRectF.bottom);
  }
  
  private void a(@NonNull ShapeAppearancePathProvider.ShapeAppearancePathSpec paramShapeAppearancePathSpec, int paramInt)
  {
    CornerSize localCornerSize = b(paramInt, paramShapeAppearancePathSpec.a);
    a(paramInt, paramShapeAppearancePathSpec.a).a(this.a[paramInt], 90.0F, paramShapeAppearancePathSpec.e, paramShapeAppearancePathSpec.c, localCornerSize);
    float f1 = b(paramInt);
    this.b[paramInt].reset();
    a(paramInt, paramShapeAppearancePathSpec.c, this.d);
    this.b[paramInt].setTranslate(this.d.x, this.d.y);
    this.b[paramInt].preRotate(f1);
  }
  
  @RequiresApi(19)
  private boolean a(Path paramPath, int paramInt)
  {
    this.k.reset();
    this.a[paramInt].a(this.b[paramInt], this.k);
    RectF localRectF = new RectF();
    boolean bool = true;
    paramPath.computeBounds(localRectF, true);
    this.k.computeBounds(localRectF, true);
    paramPath.op(this.k, Path.Op.INTERSECT);
    paramPath.computeBounds(localRectF, true);
    if (localRectF.isEmpty())
    {
      if ((localRectF.width() > 1.0F) && (localRectF.height() > 1.0F)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private float b(int paramInt)
  {
    return (paramInt + 1) * 90;
  }
  
  private CornerSize b(int paramInt, @NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramShapeAppearanceModel.g();
        }
        return paramShapeAppearanceModel.f();
      }
      return paramShapeAppearanceModel.i();
    }
    return paramShapeAppearanceModel.h();
  }
  
  private void b(@NonNull ShapeAppearancePathProvider.ShapeAppearancePathSpec paramShapeAppearancePathSpec, int paramInt)
  {
    this.h[0] = this.a[paramInt].b();
    this.h[1] = this.a[paramInt].c();
    this.b[paramInt].mapPoints(this.h);
    Path localPath;
    float[] arrayOfFloat;
    if (paramInt == 0)
    {
      localPath = paramShapeAppearancePathSpec.b;
      arrayOfFloat = this.h;
      localPath.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
    }
    else
    {
      localPath = paramShapeAppearancePathSpec.b;
      arrayOfFloat = this.h;
      localPath.lineTo(arrayOfFloat[0], arrayOfFloat[1]);
    }
    this.a[paramInt].a(this.b[paramInt], paramShapeAppearancePathSpec.b);
    if (paramShapeAppearancePathSpec.d != null) {
      paramShapeAppearancePathSpec.d.a(this.a[paramInt], this.b[paramInt], paramInt);
    }
  }
  
  private EdgeTreatment c(int paramInt, @NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramShapeAppearanceModel.l();
        }
        return paramShapeAppearanceModel.k();
      }
      return paramShapeAppearanceModel.j();
    }
    return paramShapeAppearanceModel.m();
  }
  
  private void c(@NonNull ShapeAppearancePathProvider.ShapeAppearancePathSpec paramShapeAppearancePathSpec, int paramInt)
  {
    int m = (paramInt + 1) % 4;
    this.h[0] = this.a[paramInt].d();
    this.h[1] = this.a[paramInt].e();
    this.b[paramInt].mapPoints(this.h);
    this.i[0] = this.a[m].b();
    this.i[1] = this.a[m].c();
    this.b[m].mapPoints(this.i);
    Object localObject = this.h;
    float f1 = localObject[0];
    float[] arrayOfFloat = this.i;
    f1 = Math.max((float)Math.hypot(f1 - arrayOfFloat[0], localObject[1] - arrayOfFloat[1]) - 0.001F, 0.0F);
    float f2 = a(paramShapeAppearancePathSpec.c, paramInt);
    this.g.a(0.0F, 0.0F);
    localObject = c(paramInt, paramShapeAppearancePathSpec.a);
    ((EdgeTreatment)localObject).a(f1, f2, paramShapeAppearancePathSpec.e, this.g);
    this.j.reset();
    this.g.a(this.c[paramInt], this.j);
    if ((this.l) && (Build.VERSION.SDK_INT >= 19) && ((((EdgeTreatment)localObject).f()) || (a(this.j, paramInt)) || (a(this.j, m))))
    {
      localObject = this.j;
      ((Path)localObject).op((Path)localObject, this.f, Path.Op.DIFFERENCE);
      this.h[0] = this.g.b();
      this.h[1] = this.g.c();
      this.c[paramInt].mapPoints(this.h);
      localObject = this.e;
      arrayOfFloat = this.h;
      ((Path)localObject).moveTo(arrayOfFloat[0], arrayOfFloat[1]);
      this.g.a(this.c[paramInt], this.e);
    }
    else
    {
      this.g.a(this.c[paramInt], paramShapeAppearancePathSpec.b);
    }
    if (paramShapeAppearancePathSpec.d != null) {
      paramShapeAppearancePathSpec.d.b(this.g, this.c[paramInt], paramInt);
    }
  }
  
  public void a(ShapeAppearanceModel paramShapeAppearanceModel, float paramFloat, RectF paramRectF, @NonNull Path paramPath)
  {
    a(paramShapeAppearanceModel, paramFloat, paramRectF, null, paramPath);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void a(ShapeAppearanceModel paramShapeAppearanceModel, float paramFloat, RectF paramRectF, ShapeAppearancePathProvider.PathListener paramPathListener, @NonNull Path paramPath)
  {
    paramPath.rewind();
    this.e.rewind();
    this.f.rewind();
    this.f.addRect(paramRectF, Path.Direction.CW);
    paramShapeAppearanceModel = new ShapeAppearancePathProvider.ShapeAppearancePathSpec(paramShapeAppearanceModel, paramFloat, paramRectF, paramPathListener, paramPath);
    int i1 = 0;
    int m = 0;
    int n;
    for (;;)
    {
      n = i1;
      if (m >= 4) {
        break;
      }
      a(paramShapeAppearanceModel, m);
      a(m);
      m += 1;
    }
    while (n < 4)
    {
      b(paramShapeAppearanceModel, n);
      c(paramShapeAppearanceModel, n);
      n += 1;
    }
    paramPath.close();
    this.e.close();
    if ((Build.VERSION.SDK_INT >= 19) && (!this.e.isEmpty())) {
      paramPath.op(this.e, Path.Op.UNION);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.ShapeAppearancePathProvider
 * JD-Core Version:    0.7.0.1
 */