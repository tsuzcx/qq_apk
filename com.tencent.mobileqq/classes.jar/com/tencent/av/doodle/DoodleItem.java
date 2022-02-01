package com.tencent.av.doodle;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.tencent.av.AVLog;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public abstract class DoodleItem
{
  final String a;
  public int b = 1;
  public String c = "unused";
  public int d = 12;
  public int e = 0;
  public int f = 0;
  public int g = -65536;
  public PointF h = new PointF();
  public long i = -1L;
  
  public DoodleItem()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoodleItem_");
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(AudioHelper.c());
    this.a = localStringBuilder.toString();
    if (AudioHelper.e()) {
      QLog.w(this.a, 1, getClass().getSimpleName());
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    PointF localPointF = this.h;
    localPointF.x = paramFloat1;
    localPointF.y = paramFloat2;
  }
  
  public abstract void a(long paramLong);
  
  public void a(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean)
  {
    int j = paramMySurfaceView.getWidth();
    int k = paramMySurfaceView.getHeight();
    int m = this.f;
    int n = this.e;
    float f1;
    float f3;
    float f2;
    if (j * m < k * n)
    {
      f1 = j / n;
      f3 = (k - m * f1) / 2.0F;
      f2 = 0.0F;
    }
    else
    {
      f1 = k / m;
      f2 = (j - n * f1) / 2.0F;
      f3 = 0.0F;
    }
    if (paramCanvas != null)
    {
      paramCanvas.save();
      paramCanvas.translate(f2, f3);
      paramCanvas.scale(f1, f1);
      b(paramCanvas, paramMySurfaceView, paramBoolean);
      try
      {
        paramCanvas.restore();
        return;
      }
      catch (Exception paramCanvas)
      {
        AVLog.printErrorLog(this.a, paramCanvas.getMessage());
      }
    }
  }
  
  public abstract void b(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean);
  
  public boolean b(float paramFloat1, float paramFloat2)
  {
    float f1 = Math.abs(paramFloat1 - this.h.x);
    float f2 = Math.abs(paramFloat2 - this.h.y);
    boolean bool;
    if ((f1 < 8.0F) && (f2 < 8.0F)) {
      bool = false;
    } else {
      bool = true;
    }
    if (bool)
    {
      c(paramFloat1, paramFloat2);
      PointF localPointF = this.h;
      localPointF.x = paramFloat1;
      localPointF.y = paramFloat2;
    }
    return bool;
  }
  
  public abstract void c(float paramFloat1, float paramFloat2);
  
  public abstract void d(float paramFloat1, float paramFloat2);
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mPenType[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], mPoint[");
    localStringBuilder.append(this.h.x);
    localStringBuilder.append(",");
    localStringBuilder.append(this.h.y);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleItem
 * JD-Core Version:    0.7.0.1
 */