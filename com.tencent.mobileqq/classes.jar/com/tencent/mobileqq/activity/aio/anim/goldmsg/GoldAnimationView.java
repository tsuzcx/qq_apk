package com.tencent.mobileqq.activity.aio.anim.goldmsg;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class GoldAnimationView
  extends View
  implements ValueAnimator.AnimatorUpdateListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private int c;
  
  public GoldAnimationView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GoldAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GoldAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.end();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, float paramFloat)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.jdField_b_of_type_Float = ((float)(paramFloat / (paramInt1 - 1) / paramFloat * 3.141592653589793D));
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#FFAA00"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramLong);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this);
  }
  
  public void clearAnimation()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      float f1 = (float)(getWidth() / 2.0F - this.jdField_b_of_type_Int / 2.0F + this.c * Math.cos(this.jdField_b_of_type_Float * i) * this.jdField_a_of_type_Float);
      float f2 = (float)(getHeight() - this.c * Math.sin(this.jdField_b_of_type_Float * i) * this.jdField_a_of_type_Float);
      float f3 = this.jdField_b_of_type_Int;
      float f4 = this.jdField_a_of_type_Float;
      paramCanvas.drawCircle(f1 + this.jdField_b_of_type_Int / 2, f2 - this.jdField_b_of_type_Int, f3 * (1.0F - f4), this.jdField_a_of_type_AndroidGraphicsPaint);
      i += 1;
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Float = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldAnimationView
 * JD-Core Version:    0.7.0.1
 */