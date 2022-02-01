package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;

public class ContainerDrawable
  extends Drawable
  implements Animatable
{
  private int jdField_a_of_type_Int = 127;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  Property<ContainerDrawable, Integer> jdField_a_of_type_AndroidUtilProperty = new ContainerDrawable.1(this, Integer.class, "backAlpha");
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  
  private int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    if (paramInt1 == 1)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.jdField_a_of_type_AndroidUtilProperty, new int[] { 0, 127 }) });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
    }
    else if (paramInt1 == 2)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.jdField_a_of_type_AndroidUtilProperty, new int[] { 127, 0 }) });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
    }
    localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.setRepeatMode(1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setStartDelay(0L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ContainerDrawable.2(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new ContainerDrawable.3(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_AndroidUtilProperty = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Int == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_a_of_type_Int);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRect);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (localPaint != null) {
      localPaint.setColorFilter(paramColorFilter);
    }
  }
  
  public void start()
  {
    if (isRunning()) {
      stop();
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start :");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d("HintDrawable", 2, localStringBuilder.toString());
    }
    int j = this.jdField_b_of_type_Int;
    if (j == 1)
    {
      int i;
      if (this.jdField_b_of_type_Boolean) {
        i = 150;
      } else {
        i = 300;
      }
      a(j, i);
      return;
    }
    if (j == 2) {
      a(j, 200);
    }
  }
  
  public void stop()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_b_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.ContainerDrawable
 * JD-Core Version:    0.7.0.1
 */