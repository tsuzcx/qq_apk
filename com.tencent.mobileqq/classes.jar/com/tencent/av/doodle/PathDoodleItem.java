package com.tencent.av.doodle;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;

public abstract class PathDoodleItem
  extends DoodleItem
{
  protected Path a;
  protected PathMeasure a;
  
  public PathDoodleItem()
  {
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPathMeasure = null;
    this.jdField_a_of_type_AndroidGraphicsPathMeasure = new PathMeasure(this.jdField_a_of_type_AndroidGraphicsPath, false);
  }
  
  public abstract void a();
  
  public void a(float paramFloat1, float paramFloat2)
  {
    super.a(paramFloat1, paramFloat2);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(paramFloat1, paramFloat2);
    this.jdField_a_of_type_AndroidGraphicsPathMeasure.setPath(this.jdField_a_of_type_AndroidGraphicsPath, false);
    a();
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, (paramFloat1 + this.jdField_a_of_type_AndroidGraphicsPointF.x) / 2.0F, (paramFloat2 + this.jdField_a_of_type_AndroidGraphicsPointF.y) / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsPathMeasure.setPath(this.jdField_a_of_type_AndroidGraphicsPath, false);
    a();
  }
  
  public void c(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF.x = paramFloat1;
    this.jdField_a_of_type_AndroidGraphicsPointF.y = paramFloat2;
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
    this.jdField_a_of_type_AndroidGraphicsPathMeasure.setPath(this.jdField_a_of_type_AndroidGraphicsPath, false);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathDoodleItem
 * JD-Core Version:    0.7.0.1
 */