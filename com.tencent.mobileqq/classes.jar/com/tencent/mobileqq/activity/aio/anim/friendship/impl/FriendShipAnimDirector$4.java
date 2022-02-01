package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import agmq;
import agnq;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;

public class FriendShipAnimDirector$4
  implements Runnable
{
  public FriendShipAnimDirector$4(agmq paramagmq) {}
  
  public void run()
  {
    if (agmq.a(this.this$0) != null) {
      agmq.a(this.this$0).a(agmq.a(this.this$0) + "icon_close.png");
    }
    if ((agmq.a(this.this$0) == null) || (agmq.a(this.this$0).isAnimating())) {
      return;
    }
    FriendShipLayout localFriendShipLayout = this.this$0.a();
    if (localFriendShipLayout != null)
    {
      if (localFriendShipLayout.getChildCount() > 0) {
        localFriendShipLayout.removeAllViews();
      }
      this.this$0.a(0);
      agmq.a(this.this$0, new ImageView(this.this$0.a()));
      agmq.a(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 81;
      View localView = new View(this.this$0.a());
      localView.setBackgroundColor(-16777216);
      localFriendShipLayout.addView(localView, localLayoutParams);
      localFriendShipLayout.addView(agmq.a(this.this$0), localLayoutParams);
      agmq.a(this.this$0).setImageDrawable(agmq.a(this.this$0));
      agmq.a(this.this$0).a(localView);
      agmq.a(this.this$0).a(localFriendShipLayout);
    }
    if (agmq.a(this.this$0).isAnimating()) {
      agmq.a(this.this$0).cancelAnimation();
    }
    if (agmq.a(this.this$0).a()) {
      agmq.a(this.this$0).b();
    }
    agmq.a(this.this$0).playAnimation();
    agmq.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.FriendShipAnimDirector.4
 * JD-Core Version:    0.7.0.1
 */