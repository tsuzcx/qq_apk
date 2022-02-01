package com.tencent.gdtad.api.motivevideo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;

public class GdtMvButtonHighLight
  extends Button
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private boolean jdField_a_of_type_Boolean;
  
  public GdtMvButtonHighLight(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtMvButtonHighLight(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130840216);
    this.jdField_a_of_type_AndroidGraphicsPaint = getPaint();
  }
  
  public GdtMvButtonHighLight(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_Boolean = false;
      invalidate();
    }
    clearAnimation();
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() != 4)) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvButtonHighLight
 * JD-Core Version:    0.7.0.1
 */