package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import aerp;
import aesp;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;

public class FriendShipAnimDirector$4
  implements Runnable
{
  public FriendShipAnimDirector$4(aerp paramaerp) {}
  
  public void run()
  {
    if (aerp.a(this.this$0) != null) {
      aerp.a(this.this$0).a(aerp.a(this.this$0) + "icon_close.png");
    }
    if ((aerp.a(this.this$0) == null) || (aerp.a(this.this$0).isAnimating())) {
      return;
    }
    FriendShipLayout localFriendShipLayout = this.this$0.a();
    if (localFriendShipLayout != null)
    {
      if (localFriendShipLayout.getChildCount() > 0) {
        localFriendShipLayout.removeAllViews();
      }
      this.this$0.a(0);
      aerp.a(this.this$0, new ImageView(this.this$0.a()));
      aerp.a(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 81;
      View localView = new View(this.this$0.a());
      localView.setBackgroundColor(-16777216);
      localFriendShipLayout.addView(localView, localLayoutParams);
      localFriendShipLayout.addView(aerp.a(this.this$0), localLayoutParams);
      aerp.a(this.this$0).setImageDrawable(aerp.a(this.this$0));
      aerp.a(this.this$0).a(localView);
      aerp.a(this.this$0).a(localFriendShipLayout);
    }
    if (aerp.a(this.this$0).isAnimating()) {
      aerp.a(this.this$0).cancelAnimation();
    }
    if (aerp.a(this.this$0).a()) {
      aerp.a(this.this$0).b();
    }
    aerp.a(this.this$0).playAnimation();
    aerp.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.FriendShipAnimDirector.4
 * JD-Core Version:    0.7.0.1
 */