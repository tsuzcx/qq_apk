package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper.LottieDrawableLoadedListener;
import com.tencent.widget.ListView;

class LevelEggsElement$1
  implements LottieHelper.LottieDrawableLoadedListener
{
  LevelEggsElement$1(LevelEggsElement paramLevelEggsElement) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    LevelEggsElement.a(this.a, paramLottieDrawable);
    LevelEggsElement.a(this.a).addAnimatorListener(new LevelEggsElement.1.1(this));
    paramLottieDrawable = this.a;
    LevelEggsElement.a(paramLottieDrawable, new DiniFlyAnimationView(LevelEggsElement.a(paramLottieDrawable).getContext()));
    ((DiniFlyAnimationView)LevelEggsElement.a(this.a)).setImageDrawable(LevelEggsElement.a(this.a));
    paramLottieDrawable = new ViewGroup.LayoutParams(-2, -2);
    paramLottieDrawable.height = (LevelEggsElement.a(this.a).getBottom() - LevelEggsElement.a(this.a).getTop());
    paramLottieDrawable.width = (LevelEggsElement.a(this.a).getRight() - LevelEggsElement.a(this.a).getLeft());
    LevelEggsElement.a(this.a).addViewInLayout(LevelEggsElement.a(this.a), -1, paramLottieDrawable, false);
    LevelEggsElement.a(this.a).layout(0, 0, paramLottieDrawable.width, paramLottieDrawable.height);
    LevelEggsElement.a(this.a).setRepeatCount(-1);
    if ((LevelEggsElement.a(this.a) != null) && (!LevelEggsElement.a(this.a).isAnimating())) {
      LevelEggsElement.a(this.a).playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.LevelEggsElement.1
 * JD-Core Version:    0.7.0.1
 */