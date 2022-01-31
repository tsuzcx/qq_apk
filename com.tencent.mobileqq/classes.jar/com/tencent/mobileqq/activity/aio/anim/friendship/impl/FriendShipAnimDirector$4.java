package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import adac;
import adbc;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;

public class FriendShipAnimDirector$4
  implements Runnable
{
  public FriendShipAnimDirector$4(adac paramadac) {}
  
  public void run()
  {
    if (adac.a(this.this$0) != null) {
      adac.a(this.this$0).a(adac.a(this.this$0) + "icon_close.png");
    }
    if ((adac.a(this.this$0) == null) || (adac.a(this.this$0).isAnimating())) {
      return;
    }
    FriendShipLayout localFriendShipLayout = this.this$0.a();
    if (localFriendShipLayout != null)
    {
      if (localFriendShipLayout.getChildCount() > 0) {
        localFriendShipLayout.removeAllViews();
      }
      this.this$0.a(0);
      adac.a(this.this$0, new ImageView(this.this$0.a()));
      adac.a(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 81;
      View localView = new View(this.this$0.a());
      localView.setBackgroundColor(-16777216);
      localFriendShipLayout.addView(localView, localLayoutParams);
      localFriendShipLayout.addView(adac.a(this.this$0), localLayoutParams);
      adac.a(this.this$0).setImageDrawable(adac.a(this.this$0));
      adac.a(this.this$0).a(localView);
      adac.a(this.this$0).a(localFriendShipLayout);
    }
    if (adac.a(this.this$0).isAnimating()) {
      adac.a(this.this$0).cancelAnimation();
    }
    if (adac.a(this.this$0).a()) {
      adac.a(this.this$0).b();
    }
    adac.a(this.this$0).playAnimation();
    adac.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.FriendShipAnimDirector.4
 * JD-Core Version:    0.7.0.1
 */