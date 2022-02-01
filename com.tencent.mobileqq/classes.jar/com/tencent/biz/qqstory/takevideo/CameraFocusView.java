package com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

public class CameraFocusView
  extends ImageView
{
  protected int a = 0;
  protected int b = 0;
  
  public CameraFocusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setDrawableRes(2130848309);
  }
  
  public void a()
  {
    clearAnimation();
    setVisibility(4);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setDuration(800L);
    localAlphaAnimation.setFillAfter(true);
    setPadding((int)paramFloat1 - this.a / 2, (int)paramFloat2 - this.b / 2, 0, 0);
    startAnimation(localAlphaAnimation);
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return a(paramMotionEvent.getX(), paramMotionEvent.getY());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setDrawableRes(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt);
    if (localDrawable != null)
    {
      this.a = localDrawable.getMinimumWidth();
      this.b = localDrawable.getMinimumHeight();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.CameraFocusView
 * JD-Core Version:    0.7.0.1
 */