package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import aert;
import aess;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;

public class LottieAnimDirector$5
  implements Runnable
{
  public LottieAnimDirector$5(aert paramaert) {}
  
  public void run()
  {
    if (aert.a(this.this$0) != null) {
      aert.a(this.this$0).a(aert.a(this.this$0) + "icon_close.png");
    }
    if ((aert.a(this.this$0) == null) || (aert.a(this.this$0).isAnimating())) {
      return;
    }
    FriendShipLayout localFriendShipLayout = this.this$0.a();
    if (localFriendShipLayout != null)
    {
      if (localFriendShipLayout.getChildCount() > 0) {
        localFriendShipLayout.removeAllViews();
      }
      this.this$0.a(0);
      aert.a(this.this$0, new ImageView(this.this$0.a()));
      aert.a(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 81;
      View localView = new View(this.this$0.a());
      localView.setBackgroundColor(-16777216);
      localFriendShipLayout.addView(localView, localLayoutParams);
      localFriendShipLayout.addView(aert.a(this.this$0), localLayoutParams);
      aert.a(this.this$0).setImageDrawable(aert.a(this.this$0));
      aert.a(this.this$0).a(localView);
      aert.a(this.this$0).a(localFriendShipLayout);
    }
    if (aert.a(this.this$0).isAnimating()) {
      aert.a(this.this$0).cancelAnimation();
    }
    if (aert.a(this.this$0).a()) {
      aert.a(this.this$0).b();
    }
    aert.a(this.this$0).playAnimation();
    aert.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.5
 * JD-Core Version:    0.7.0.1
 */