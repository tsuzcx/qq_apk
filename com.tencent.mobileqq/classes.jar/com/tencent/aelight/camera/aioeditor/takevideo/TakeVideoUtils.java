package com.tencent.aelight.camera.aioeditor.takevideo;

import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.AlphaAnimation;

@TargetApi(14)
public class TakeVideoUtils
{
  private static int a;
  private static int b;
  private static float c;
  
  public static void a(View paramView)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new TakeVideoUtils.1(paramView));
    paramView.setVisibility(8);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    if (paramBoolean) {
      localAlphaAnimation.setStartOffset(500L);
    }
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new TakeVideoUtils.2(paramView));
    paramView.setVisibility(0);
    paramView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.TakeVideoUtils
 * JD-Core Version:    0.7.0.1
 */