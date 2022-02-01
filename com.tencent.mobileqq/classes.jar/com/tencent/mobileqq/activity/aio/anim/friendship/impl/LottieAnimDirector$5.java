package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import android.view.View;
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
    if (LottieAnimDirector.a(this.this$0) != null) {
      LottieAnimDirector.a(this.this$0).a(LottieAnimDirector.a(this.this$0) + "icon_close.png");
    }
    if ((LottieAnimDirector.a(this.this$0) == null) || (LottieAnimDirector.a(this.this$0).isAnimating())) {
      return;
    }
    FriendShipLayout localFriendShipLayout = this.this$0.a();
    if (localFriendShipLayout != null)
    {
      if (localFriendShipLayout.getChildCount() > 0) {
        localFriendShipLayout.removeAllViews();
      }
      this.this$0.a(0);
      LottieAnimDirector.a(this.this$0, new ImageView(this.this$0.a()));
      LottieAnimDirector.a(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 81;
      View localView = new View(this.this$0.a());
      localView.setBackgroundColor(-16777216);
      localFriendShipLayout.addView(localView, localLayoutParams);
      localFriendShipLayout.addView(LottieAnimDirector.a(this.this$0), localLayoutParams);
      LottieAnimDirector.a(this.this$0).setImageDrawable(LottieAnimDirector.a(this.this$0));
      LottieAnimDirector.a(this.this$0).a(localView);
      LottieAnimDirector.a(this.this$0).a(localFriendShipLayout);
    }
    if (LottieAnimDirector.a(this.this$0).isAnimating()) {
      LottieAnimDirector.a(this.this$0).cancelAnimation();
    }
    if (LottieAnimDirector.a(this.this$0).a()) {
      LottieAnimDirector.a(this.this$0).b();
    }
    LottieAnimDirector.a(this.this$0).playAnimation();
    LottieAnimDirector.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.5
 * JD-Core Version:    0.7.0.1
 */