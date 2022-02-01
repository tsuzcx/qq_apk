package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.friendship.AdditionalAnimController;
import com.tencent.mobileqq.dinifly.LottieDrawable;

class FriendShipAnimDirector$4
  implements Runnable
{
  FriendShipAnimDirector$4(FriendShipAnimDirector paramFriendShipAnimDirector) {}
  
  public void run()
  {
    if (FriendShipAnimDirector.a(this.this$0) != null) {
      FriendShipAnimDirector.a(this.this$0).a(FriendShipAnimDirector.a(this.this$0) + "icon_close.png");
    }
    if ((FriendShipAnimDirector.a(this.this$0) == null) || (FriendShipAnimDirector.a(this.this$0).isAnimating())) {
      return;
    }
    FriendShipLayout localFriendShipLayout = this.this$0.a();
    if (localFriendShipLayout != null)
    {
      if (localFriendShipLayout.getChildCount() > 0) {
        localFriendShipLayout.removeAllViews();
      }
      this.this$0.a(0);
      FriendShipAnimDirector.a(this.this$0, new ImageView(this.this$0.a()));
      FriendShipAnimDirector.a(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 81;
      View localView = new View(this.this$0.a());
      localView.setBackgroundColor(-16777216);
      localFriendShipLayout.addView(localView, localLayoutParams);
      localFriendShipLayout.addView(FriendShipAnimDirector.a(this.this$0), localLayoutParams);
      FriendShipAnimDirector.a(this.this$0).setImageDrawable(FriendShipAnimDirector.a(this.this$0));
      FriendShipAnimDirector.a(this.this$0).a(localView);
      FriendShipAnimDirector.a(this.this$0).a(localFriendShipLayout);
    }
    if (FriendShipAnimDirector.a(this.this$0).isAnimating()) {
      FriendShipAnimDirector.a(this.this$0).cancelAnimation();
    }
    if (FriendShipAnimDirector.a(this.this$0).a()) {
      FriendShipAnimDirector.a(this.this$0).b();
    }
    FriendShipAnimDirector.a(this.this$0).playAnimation();
    FriendShipAnimDirector.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.FriendShipAnimDirector.4
 * JD-Core Version:    0.7.0.1
 */