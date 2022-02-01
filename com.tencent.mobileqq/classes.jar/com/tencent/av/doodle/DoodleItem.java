package com.tencent.av.doodle;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.tencent.av.AVLog;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public abstract class DoodleItem
{
  public int a;
  public long a;
  public PointF a;
  final String a;
  public int b;
  public String b;
  public int c = 0;
  public int d = 0;
  public int e = -65536;
  
  public DoodleItem()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_JavaLangString = "unused";
    this.jdField_b_of_type_Int = 12;
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF();
    this.jdField_a_of_type_Long = -1L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoodleItem_");
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    if (AudioHelper.b()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, getClass().getSimpleName());
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    PointF localPointF = this.jdField_a_of_type_AndroidGraphicsPointF;
    localPointF.x = paramFloat1;
    localPointF.y = paramFloat2;
  }
  
  public abstract void a(long paramLong);
  
  public void a(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean)
  {
    int i = paramMySurfaceView.getWidth();
    int j = paramMySurfaceView.getHeight();
    int k = this.d;
    int m = this.c;
    float f1;
    float f3;
    float f2;
    if (i * k < j * m)
    {
      f1 = i / m;
      f3 = (j - k * f1) / 2.0F;
      f2 = 0.0F;
    }
    else
    {
      f1 = j / k;
      f2 = (i - m * f1) / 2.0F;
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
        AVLog.printErrorLog(this.jdField_a_of_type_JavaLangString, paramCanvas.getMessage());
      }
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    float f1 = Math.abs(paramFloat1 - this.jdField_a_of_type_AndroidGraphicsPointF.x);
    float f2 = Math.abs(paramFloat2 - this.jdField_a_of_type_AndroidGraphicsPointF.y);
    boolean bool;
    if ((f1 < 8.0F) && (f2 < 8.0F)) {
      bool = false;
    } else {
      bool = true;
    }
    if (bool)
    {
      b(paramFloat1, paramFloat2);
      PointF localPointF = this.jdField_a_of_type_AndroidGraphicsPointF;
      localPointF.x = paramFloat1;
      localPointF.y = paramFloat2;
    }
    return bool;
  }
  
  public abstract void b(float paramFloat1, float paramFloat2);
  
  public abstract void b(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean);
  
  public abstract void c(float paramFloat1, float paramFloat2);
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mPenType[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("], mPoint[");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsPointF.x);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsPointF.y);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleItem
 * JD-Core Version:    0.7.0.1
 */