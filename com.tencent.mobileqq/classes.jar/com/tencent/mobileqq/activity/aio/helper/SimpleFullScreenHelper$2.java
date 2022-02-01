package com.tencent.mobileqq.activity.aio.helper;

import android.animation.Animator;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.richmedia.AnimatorAdapter;
import com.tencent.widget.XEditTextEx;

class SimpleFullScreenHelper$2
  extends AnimatorAdapter
{
  SimpleFullScreenHelper$2(SimpleFullScreenHelper paramSimpleFullScreenHelper) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SimpleFullScreenHelper.a(this.a).setVisibility(8);
    SimpleFullScreenHelper.b(this.a).b();
    SimpleFullScreenHelper.c(this.a).Y.setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SimpleFullScreenHelper.2
 * JD-Core Version:    0.7.0.1
 */