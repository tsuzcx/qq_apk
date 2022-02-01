package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.lottie.LottieAnimController;
import com.tencent.mobileqq.dinifly.LottieDrawable;

class LottieAnimDirector$5
  implements Runnable
{
  LottieAnimDirector$5(LottieAnimDirector paramLottieAnimDirector) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    if (LottieAnimDirector.e(this.this$0) != null)
    {
      localObject1 = LottieAnimDirector.e(this.this$0);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(LottieAnimDirector.d(this.this$0));
      ((StringBuilder)localObject2).append("icon_close.png");
      ((LottieAnimController)localObject1).a(((StringBuilder)localObject2).toString());
    }
    if (LottieAnimDirector.f(this.this$0) != null)
    {
      if (LottieAnimDirector.f(this.this$0).isAnimating()) {
        return;
      }
      localObject1 = this.this$0.h();
      if (localObject1 != null)
      {
        if (((FriendShipLayout)localObject1).getChildCount() > 0) {
          ((FriendShipLayout)localObject1).removeAllViews();
        }
        this.this$0.a(0);
        localObject2 = this.this$0;
        LottieAnimDirector.a((LottieAnimDirector)localObject2, new ImageView(((LottieAnimDirector)localObject2).g()));
        LottieAnimDirector.g(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject2).gravity = 81;
        View localView = new View(this.this$0.g());
        localView.setBackgroundColor(-16777216);
        ((FriendShipLayout)localObject1).addView(localView, (ViewGroup.LayoutParams)localObject2);
        ((FriendShipLayout)localObject1).addView(LottieAnimDirector.g(this.this$0), (ViewGroup.LayoutParams)localObject2);
        LottieAnimDirector.g(this.this$0).setImageDrawable(LottieAnimDirector.f(this.this$0));
        LottieAnimDirector.e(this.this$0).a(localView);
        LottieAnimDirector.e(this.this$0).a((FriendShipLayout)localObject1);
      }
      if (LottieAnimDirector.f(this.this$0).isAnimating()) {
        LottieAnimDirector.f(this.this$0).cancelAnimation();
      }
      if (LottieAnimDirector.e(this.this$0).b()) {
        LottieAnimDirector.e(this.this$0).c();
      }
      LottieAnimDirector.f(this.this$0).playAnimation();
      LottieAnimDirector.e(this.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.5
 * JD-Core Version:    0.7.0.1
 */