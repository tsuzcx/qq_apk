package com.tencent.biz.qqstory.widget.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CircularRevealCompatLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private boolean jdField_a_of_type_Boolean;
  private float b;
  private float c;
  
  public CircularRevealCompatLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircularRevealCompatLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircularRevealCompatLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.c;
    }
    return -1.0F;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidGraphicsPath.isEmpty()))
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    paramCanvas.save();
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setEnableClip(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setRevealClip(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    float f1 = getWidth() - paramFloat1;
    float f2 = getWidth() - paramFloat2;
    if (Math.max(paramFloat1 * paramFloat1, f1 * f1) + Math.max(paramFloat2 * paramFloat2, f2 * f2) > paramFloat3 * paramFloat3) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.addCircle(this.jdField_a_of_type_Float, this.b, this.c, Path.Direction.CW);
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout
 * JD-Core Version:    0.7.0.1
 */