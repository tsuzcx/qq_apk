package com.tencent.mobileqq.activity.aio.helper;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;

class JdTipHelper$1
  implements Animation.AnimationListener
{
  JdTipHelper$1(JdTipHelper paramJdTipHelper) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      if ((this.a.e != null) && (this.a.a != null) && (paramAnimation == this.a.d))
      {
        paramAnimation = AnimationUtils.loadAnimation(BaseApplicationImpl.getContext(), 2130772397);
        paramAnimation.setInterpolator(new LinearInterpolator());
        this.a.g = ((ImageView)this.a.a.findViewById(2131433488));
        this.a.h = ((ImageView)this.a.a.findViewById(2131433489));
        this.a.a.clearAnimation();
        this.a.a.startAnimation(this.a.e);
        this.a.g.startAnimation(paramAnimation);
        this.a.h.startAnimation(paramAnimation);
        return;
      }
      if ((paramAnimation == this.a.f) && (this.a.c != null) && (this.a.a != null) && (this.a.c.indexOfChild(this.a.a) != -1)) {
        this.a.c.removeView(this.a.a);
      }
      return;
    }
    catch (Throwable paramAnimation) {}
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.JdTipHelper.1
 * JD-Core Version:    0.7.0.1
 */