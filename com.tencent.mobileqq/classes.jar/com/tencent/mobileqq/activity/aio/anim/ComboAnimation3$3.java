package com.tencent.mobileqq.activity.aio.anim;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class ComboAnimation3$3
  extends AnimateUtils.AnimationAdapter
{
  ComboAnimation3$3(ComboAnimation3 paramComboAnimation3) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((ComboAnimation3.a(this.a) != null) && (ComboAnimation3.a(this.a).isShown())) {
      this.a.a.post(new ComboAnimation3.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.ComboAnimation3.3
 * JD-Core Version:    0.7.0.1
 */