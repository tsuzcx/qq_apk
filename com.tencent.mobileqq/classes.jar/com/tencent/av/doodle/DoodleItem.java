package com.tencent.av.doodle;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.tencent.av.AVLog;

public abstract class DoodleItem
{
  public int a;
  public long a;
  public PointF a;
  public String a;
  public int b = 12;
  public int c;
  public int d;
  public int e = -65536;
  
  public DoodleItem()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = "unused";
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF();
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF.x = paramFloat1;
    this.jdField_a_of_type_AndroidGraphicsPointF.y = paramFloat2;
  }
  
  public abstract void a(long paramLong);
  
  public void a(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean)
  {
    float f2 = 0.0F;
    int i = paramMySurfaceView.getWidth();
    int j = paramMySurfaceView.getHeight();
    int k = this.d;
    int m = this.c;
    float f3;
    if (i * k < j * m) {
      f3 = i / m;
    }
    for (float f1 = (j - k * f3) / 2.0F;; f1 = 0.0F)
    {
      if (paramCanvas != null)
      {
        paramCanvas.save();
        paramCanvas.translate(f2, f1);
        paramCanvas.scale(f3, f3);
        b(paramCanvas, paramMySurfaceView, paramBoolean);
      }
      try
      {
        paramCanvas.restore();
        return;
      }
      catch (Exception paramCanvas)
      {
        AVLog.e("DoodleItem", paramCanvas.getMessage());
      }
      f3 = j / k;
      f2 = (i - m * f3) / 2.0F;
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    float f1 = Math.abs(paramFloat1 - this.jdField_a_of_type_AndroidGraphicsPointF.x);
    float f2 = Math.abs(paramFloat2 - this.jdField_a_of_type_AndroidGraphicsPointF.y);
    if ((f1 >= 8.0F) || (f2 >= 8.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        b(paramFloat1, paramFloat2);
        this.jdField_a_of_type_AndroidGraphicsPointF.x = paramFloat1;
        this.jdField_a_of_type_AndroidGraphicsPointF.y = paramFloat2;
      }
      return bool;
    }
  }
  
  public abstract void b(float paramFloat1, float paramFloat2);
  
  public abstract void b(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean);
  
  public abstract void c(float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleItem
 * JD-Core Version:    0.7.0.1
 */