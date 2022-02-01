package com.tencent.biz.qqstory.widget.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RectangleClipLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_a_of_type_Boolean = true;
  
  public RectangleClipLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RectangleClipLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RectangleClipLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_AndroidGraphicsPath.isEmpty()))
    {
      paramCanvas.save();
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void setClipRect(RectF paramRectF, float paramFloat)
  {
    if ((paramRectF.width() >= getWidth()) && (paramRectF.height() >= getHeight()))
    {
      this.jdField_a_of_type_Boolean = false;
      invalidate();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF);
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    paramRectF = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    paramFloat = this.jdField_a_of_type_Float;
    paramRectF.addRoundRect(localRectF, paramFloat, paramFloat, Path.Direction.CW);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.circularreveal.RectangleClipLayout
 * JD-Core Version:    0.7.0.1
 */