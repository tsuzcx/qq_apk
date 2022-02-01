package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.qphone.base.util.QLog;

public class GuideLineLayer
  extends BaseLayer
{
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  public int b;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  public int c;
  private boolean c;
  public int d;
  int e;
  int f;
  private int g;
  
  public String a()
  {
    return "GuideLineLayer";
  }
  
  public void a() {}
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (Math.abs((int)this.jdField_b_of_type_Float % 45) < 3))
    {
      paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      paramCanvas.translate(this.e, this.f);
      int i = Math.round(this.jdField_b_of_type_Float / 45.0F) * 45;
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "currentDegree : " + this.jdField_b_of_type_Float + "   guideLine Angle : " + i);
      }
      paramCanvas.rotate(i);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(-this.g, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.g, 0.0F);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw angle guide line");
      }
    }
    paramCanvas.restore();
    paramCanvas.save();
    if ((this.jdField_c_of_type_Boolean) && (Math.abs(this.jdField_a_of_type_AndroidGraphicsPointF.x + this.e - (this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2) < 4.0F))
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2, this.d);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw X guide line");
      }
    }
    if ((this.jdField_c_of_type_Boolean) && (Math.abs(this.jdField_a_of_type_AndroidGraphicsPointF.y + this.f - (this.jdField_c_of_type_Int + this.d) / 2) < 4.0F))
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_Int, (this.d - this.jdField_c_of_type_Int) / 2 + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_b_of_type_Int, (this.d - this.jdField_c_of_type_Int) / 2 + this.jdField_c_of_type_Int);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw Y guide line");
      }
    }
    paramCanvas.restore();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(Canvas paramCanvas) {}
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.layer.GuideLineLayer
 * JD-Core Version:    0.7.0.1
 */