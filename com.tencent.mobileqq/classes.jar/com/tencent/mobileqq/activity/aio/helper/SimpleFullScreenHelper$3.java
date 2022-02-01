package com.tencent.mobileqq.activity.aio.helper;

import android.animation.Animator;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.richmedia.AnimatorAdapter;
import com.tencent.widget.XEditTextEx;

class SimpleFullScreenHelper$3
  extends AnimatorAdapter
{
  SimpleFullScreenHelper$3(SimpleFullScreenHelper paramSimpleFullScreenHelper) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SimpleFullScreenHelper.c(this.a).Y.setAlpha(1.0F);
    SimpleFullScreenHelper.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SimpleFullScreenHelper.3
 * JD-Core Version:    0.7.0.1
 */