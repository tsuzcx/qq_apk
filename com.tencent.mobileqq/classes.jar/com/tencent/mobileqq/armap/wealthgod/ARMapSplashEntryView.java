package com.tencent.mobileqq.armap.wealthgod;

import abpr;
import abps;
import abpt;
import abpu;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ARMapSplashEntryView
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ARMapSplashEntryView.ARMapSplashEntryListener jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashEntryView$ARMapSplashEntryListener;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  private ImageView d;
  
  public ARMapSplashEntryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ARMapSplashEntryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2130970250, this, true);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369778));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369779));
    this.c = ((ImageView)findViewById(2131369780));
    this.d = ((ImageView)findViewById(2131369781));
    Drawable localDrawable = SplashBitmapUtils.a(this.jdField_a_of_type_AndroidContentContext, "KEY_SPLASH_ENTRY_CLOUD");
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localDrawable);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(localDrawable);
    this.c.setBackgroundDrawable(localDrawable);
    this.d.setBackgroundDrawable(localDrawable);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Float = 0.0F;
    c();
  }
  
  @TargetApi(11)
  private void c()
  {
    float f1 = getWidth();
    float f2 = this.jdField_a_of_type_Float;
    float f3 = (float)(0.3749999940395355D * getHeight() * this.jdField_a_of_type_Float);
    float f4 = 2.0F * this.jdField_a_of_type_Float + 1.0F;
    this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(0.334F * f1 * f2);
    this.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(f3);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(f4);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(f4);
    f1 = getWidth();
    f2 = this.jdField_a_of_type_Float;
    f3 = (float)(0.3370000059604645D * getHeight() * this.jdField_a_of_type_Float);
    f4 = 1.7F * this.jdField_a_of_type_Float + 1.0F;
    this.jdField_b_of_type_AndroidWidgetImageView.setTranslationX(-0.4530001F * f1 * f2);
    this.jdField_b_of_type_AndroidWidgetImageView.setTranslationY(f3);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleX(f4);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleY(f4);
    f1 = getWidth();
    f2 = this.jdField_a_of_type_Float;
    f3 = getHeight();
    f4 = this.jdField_a_of_type_Float;
    float f5 = 2.2F * this.jdField_a_of_type_Float + 1.0F;
    this.c.setTranslationX(0.427F * f1 * f2);
    this.c.setTranslationY(-0.3750001F * f3 * f4);
    this.c.setScaleX(f5);
    this.c.setScaleY(f5);
    f1 = getWidth();
    f2 = this.jdField_a_of_type_Float;
    f3 = getHeight();
    f4 = this.jdField_a_of_type_Float;
    f5 = 2.5F * this.jdField_a_of_type_Float + 1.0F;
    this.d.setTranslationX(-0.534F * f1 * f2);
    this.d.setTranslationY(-0.113F * f3 * f4);
    this.d.setScaleX(f5);
    this.d.setScaleY(f5);
  }
  
  @TargetApi(11)
  private void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(1000L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new abpr(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new abps(this));
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  @TargetApi(11)
  private void e()
  {
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(1000L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new abpt(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new abpu(this));
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void a(ARMapSplashEntryView.ARMapSplashEntryListener paramARMapSplashEntryListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashEntryView$ARMapSplashEntryListener = paramARMapSplashEntryListener;
    d();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    paramInt3 = (int)(-0.2F * paramInt1) - this.jdField_a_of_type_AndroidWidgetImageView.getWidth() / 2;
    paramInt4 = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
    int i = (int)(-0.15F * paramInt2) - this.jdField_a_of_type_AndroidWidgetImageView.getHeight() / 2;
    int j = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
    this.jdField_a_of_type_AndroidWidgetImageView.layout(paramInt3, i, paramInt4 + paramInt3, j + i);
    paramInt3 = (int)(paramInt1 * 1.2F) - this.jdField_b_of_type_AndroidWidgetImageView.getWidth() / 2;
    paramInt4 = this.jdField_b_of_type_AndroidWidgetImageView.getWidth();
    i = (int)(-0.187F * paramInt2) - this.jdField_b_of_type_AndroidWidgetImageView.getHeight() / 2;
    j = this.jdField_b_of_type_AndroidWidgetImageView.getHeight();
    this.jdField_b_of_type_AndroidWidgetImageView.layout(paramInt3, i, paramInt4 + paramInt3, j + i);
    paramInt3 = (int)(-0.214F * paramInt1) - this.c.getWidth() / 2;
    paramInt4 = this.c.getWidth();
    i = (int)(paramInt2 * 1.2F) - this.c.getHeight() / 2;
    j = this.c.getHeight();
    this.c.layout(paramInt3, i, paramInt4 + paramInt3, j + i);
    paramInt1 = (int)(paramInt1 * 1.334F) - this.d.getWidth() / 2;
    paramInt3 = this.d.getWidth();
    paramInt2 = (int)(paramInt2 * 0.75F) - this.d.getHeight() / 2;
    paramInt4 = this.d.getHeight();
    this.d.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.wealthgod.ARMapSplashEntryView
 * JD-Core Version:    0.7.0.1
 */