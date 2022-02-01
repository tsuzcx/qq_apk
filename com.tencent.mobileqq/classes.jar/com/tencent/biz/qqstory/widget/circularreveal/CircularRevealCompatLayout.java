package com.tencent.biz.qqstory.widget.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CircularRevealCompatLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private final Path jdField_b_of_type_AndroidGraphicsPath = new Path();
  private boolean jdField_b_of_type_Boolean;
  private float c;
  private float d;
  
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
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_AndroidGraphicsPath.isEmpty())
      {
        paramCanvas.save();
        paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
        super.dispatchDraw(paramCanvas);
        paramCanvas.restore();
        return;
      }
      super.dispatchDraw(paramCanvas);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (!this.jdField_b_of_type_AndroidGraphicsPath.isEmpty())
      {
        paramCanvas.save();
        paramCanvas.clipPath(this.jdField_b_of_type_AndroidGraphicsPath);
        super.dispatchDraw(paramCanvas);
        paramCanvas.restore();
        return;
      }
      super.dispatchDraw(paramCanvas);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void setClipRect(RectF paramRectF, float paramFloat)
  {
    if ((paramRectF.width() >= getWidth()) && (paramRectF.height() >= getHeight()))
    {
      this.jdField_b_of_type_Boolean = false;
      invalidate();
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF);
    this.d = paramFloat;
    this.jdField_b_of_type_AndroidGraphicsPath.reset();
    this.jdField_b_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.d, this.d, Path.Direction.CW);
    this.jdField_b_of_type_AndroidGraphicsPath.close();
  }
  
  public void setEnableClip(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setRevealClip(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = paramFloat3;
    float f1 = getWidth() - paramFloat1;
    float f2 = getWidth() - paramFloat2;
    if (Math.max(paramFloat1 * paramFloat1, f1 * f1) + Math.max(paramFloat2 * paramFloat2, f2 * f2) > paramFloat3 * paramFloat3) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.addCircle(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c, Path.Direction.CW);
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout
 * JD-Core Version:    0.7.0.1
 */