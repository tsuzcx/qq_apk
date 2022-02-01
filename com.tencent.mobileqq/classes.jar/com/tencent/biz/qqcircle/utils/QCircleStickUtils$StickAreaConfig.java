package com.tencent.biz.qqcircle.utils;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleFeedBase.StKuoliePasterData;

public class QCircleStickUtils$StickAreaConfig
{
  private Rect a;
  private Rect b;
  private Rect c;
  private Rect d;
  private QQCircleFeedBase.StKuoliePasterData e;
  private QCircleStickUtils.StickArea f;
  private float g = 0.0F;
  private float h = 0.0F;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private ImageView.ScaleType s;
  private float t = 0.0F;
  private float u = 0.0F;
  private int v;
  private int w;
  private int x;
  private int y;
  
  private QCircleStickUtils$StickAreaConfig(QQCircleFeedBase.StKuoliePasterData paramStKuoliePasterData, Rect paramRect1, Rect paramRect2, Rect paramRect3, ImageView.ScaleType paramScaleType)
  {
    this.e = paramStKuoliePasterData;
    this.b = paramRect1;
    this.a = paramRect2;
    this.c = paramRect3;
    this.s = paramScaleType;
  }
  
  public static StickAreaConfig a(QQCircleFeedBase.StKuoliePasterData paramStKuoliePasterData, Rect paramRect1, Rect paramRect2, Rect paramRect3, ImageView.ScaleType paramScaleType)
  {
    if ((paramStKuoliePasterData != null) && (paramRect1 != null) && (paramRect2 != null))
    {
      if ((paramRect1.width() > 0) && (paramRect1.height() > 0)) {
        try
        {
          paramStKuoliePasterData = new StickAreaConfig(paramStKuoliePasterData, paramRect1, paramRect2, paramRect3, paramScaleType);
          paramStKuoliePasterData.e();
          paramStKuoliePasterData.f();
          paramStKuoliePasterData.g();
          QLog.d("Stick-QCircleStickUtils", 1, new Object[] { "[build] stick param: ", paramStKuoliePasterData.toString() });
          return paramStKuoliePasterData;
        }
        catch (Throwable paramStKuoliePasterData)
        {
          paramStKuoliePasterData.printStackTrace();
          QLog.e("Stick-QCircleStickUtils", 1, paramStKuoliePasterData, new Object[0]);
          return null;
        }
      }
      QLog.e("Stick-QCircleStickUtils", 1, "[build] originRect.width() <= 0 || originRect.height() <= 0.", new Exception());
      return null;
    }
    QLog.d("Stick-QCircleStickUtils", 1, "[build] data == null || originRect == null || displayRect == null.");
    return null;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    float f3 = paramInt1;
    this.t = (f3 / paramFloat1);
    float f2 = paramInt2;
    this.u = (f2 / paramFloat2);
    float f1 = Math.min(this.t, this.u);
    if (QCircleCodeUtils.a(f1, this.t))
    {
      paramFloat2 /= f2;
      this.g = ((paramFloat1 - f3 * paramFloat2) * 0.5F);
      paramFloat1 = paramFloat2;
    }
    else if (QCircleCodeUtils.a(f1, this.u))
    {
      paramFloat2 = paramFloat1 / f3;
      f1 = (paramFloat1 - f3 * paramFloat2) * 0.5F;
      if (Math.min(paramFloat1, f3) == paramFloat1) {
        paramFloat1 = f1;
      } else {
        paramFloat1 = -f1;
      }
      this.t = paramFloat1;
      paramFloat1 = paramFloat2;
    }
    else
    {
      paramFloat1 = 1.0F;
    }
    int i1 = Math.round(f3 * paramFloat1);
    paramFloat2 = f2 * paramFloat1;
    this.d = new Rect(0, 0, i1, Math.round(paramFloat2));
    this.h = ((f2 - paramFloat2) * 0.5F);
    this.t = paramFloat1;
    this.u = paramFloat1;
    a(paramInt1, paramInt2);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1;
    this.i = ((int)(this.t * f1 * this.e.center_x.get()));
    float f2 = paramInt2;
    this.j = ((int)(this.u * f2 * this.e.center_y.get()));
    this.k = (this.i - (int)(this.t * f1 * this.e.width.get() * 0.5F));
    this.l = (this.j - (int)(this.u * f2 * this.e.height.get() * 0.5F));
    this.m = (this.i + (int)(f1 * this.t * this.e.width.get() * 0.5F));
    this.n = this.l;
    this.o = this.k;
    this.p = (this.j + (int)(f2 * this.u * this.e.height.get() * 0.5F));
    paramInt1 = this.m;
    this.q = paramInt1;
    this.r = this.p;
    this.v = Math.min(Math.min(this.k, paramInt1), Math.min(this.o, this.q));
    this.w = Math.max(Math.max(this.k, this.m), Math.max(this.o, this.q));
    this.x = Math.min(Math.min(this.l, this.n), Math.min(this.p, this.r));
    this.y = Math.max(Math.max(this.l, this.n), Math.max(this.p, this.r));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1;
    if (paramInt1 * paramInt4 > paramInt3 * paramInt2)
    {
      f1 = paramInt4 / paramInt2;
      this.g = ((paramInt3 - paramInt1 * f1) * 0.5F);
    }
    else
    {
      f1 = paramInt3 / paramInt1;
      this.h = ((paramInt4 - paramInt2 * f1) * 0.5F);
    }
    this.d = new Rect(0, 0, paramInt3, paramInt4);
    this.t = f1;
    this.u = f1;
    a(paramInt1, paramInt2);
  }
  
  private void e()
  {
    int i1 = this.b.width();
    int i2 = this.b.height();
    int i3 = this.a.width();
    int i4 = this.a.height();
    if (this.s == ImageView.ScaleType.FIT_CENTER)
    {
      a(i1, i2, i3, i4);
      return;
    }
    a(i1, i2, i3, i4);
  }
  
  private void f()
  {
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = this.k;
    arrayOfFloat[1] = this.l;
    arrayOfFloat[2] = this.m;
    arrayOfFloat[3] = this.n;
    arrayOfFloat[4] = this.o;
    arrayOfFloat[5] = this.p;
    arrayOfFloat[6] = this.q;
    arrayOfFloat[7] = this.r;
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(this.e.rotation.get(), this.i, this.j);
    localMatrix.mapPoints(arrayOfFloat);
    this.k = ((int)arrayOfFloat[0]);
    this.l = ((int)arrayOfFloat[1]);
    this.m = ((int)arrayOfFloat[2]);
    this.n = ((int)arrayOfFloat[3]);
    this.o = ((int)arrayOfFloat[4]);
    this.p = ((int)arrayOfFloat[5]);
    this.q = ((int)arrayOfFloat[6]);
    this.r = ((int)arrayOfFloat[7]);
  }
  
  private void g()
  {
    this.f = new QCircleStickUtils.StickArea();
    Object localObject = this.c;
    float f2 = 0.0F;
    float f1 = 0.0F;
    if (localObject == null)
    {
      this.f.b = new Point(this.i + (int)this.g, this.j + (int)this.h);
      this.f.c = new Point(this.k + (int)this.g, this.l + (int)this.h);
      this.f.d = new Point(this.o + (int)this.g, this.p + (int)this.h);
      this.f.e = new Point(this.q + (int)this.g, this.r + (int)this.h);
      this.f.f = new Point(this.m + (int)this.g, this.n + (int)this.h);
      localObject = this.f;
      localStKuoliePasterData = this.e;
      if (localStKuoliePasterData != null) {
        f1 = localStKuoliePasterData.rotation.get();
      }
      ((QCircleStickUtils.StickArea)localObject).a = f1;
      return;
    }
    int i1 = (int)((((Rect)localObject).height() - this.a.height()) * 0.5F);
    this.f.b = new Point(this.i + (int)this.g, this.j + (int)this.h + i1);
    this.f.c = new Point(this.k + (int)this.g, this.l + (int)this.h + i1);
    this.f.d = new Point(this.o + (int)this.g, this.p + (int)this.h + i1);
    this.f.e = new Point(this.q + (int)this.g, this.r + (int)this.h + i1);
    this.f.f = new Point(this.m + (int)this.g, this.n + (int)this.h + i1);
    localObject = this.f;
    QQCircleFeedBase.StKuoliePasterData localStKuoliePasterData = this.e;
    f1 = f2;
    if (localStKuoliePasterData != null) {
      f1 = localStKuoliePasterData.rotation.get();
    }
    ((QCircleStickUtils.StickArea)localObject).a = f1;
  }
  
  public Rect a()
  {
    return this.d;
  }
  
  public float b()
  {
    return this.g;
  }
  
  public float c()
  {
    return this.h;
  }
  
  public QCircleStickUtils.StickArea d()
  {
    return this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StickAreaConfig{mStickOffsetX=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mStickOffsetY=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mStickCenterX=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", mStickCenterY=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", mStickTopLeftX=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", mStickTopLeftY=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", mStickTopRightX=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", mStickTopRightY=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", mStickBottomLeftX=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", mStickBottomLeftY=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", mStickBottomRightX=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", mStickBottomRightY=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", mScaleType=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", mStickScaleX=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", mStickScaleY=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", mStickMinX=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", mStickMaxX=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", mStickMinY=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", mStickMaxY=");
    localStringBuilder.append(this.y);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleStickUtils.StickAreaConfig
 * JD-Core Version:    0.7.0.1
 */