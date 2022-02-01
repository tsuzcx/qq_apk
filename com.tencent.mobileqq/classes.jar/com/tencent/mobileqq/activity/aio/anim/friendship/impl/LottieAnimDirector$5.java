package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import agcu;
import agdt;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;

public class LottieAnimDirector$5
  implements Runnable
{
  public LottieAnimDirector$5(agcu paramagcu) {}
  
  public void run()
  {
    if (agcu.a(this.this$0) != null) {
      agcu.a(this.this$0).a(agcu.a(this.this$0) + "icon_close.png");
    }
    if ((agcu.a(this.this$0) == null) || (agcu.a(this.this$0).isAnimating())) {
      return;
    }
    FriendShipLayout localFriendShipLayout = this.this$0.a();
    if (localFriendShipLayout != null)
    {
      if (localFriendShipLayout.getChildCount() > 0) {
        localFriendShipLayout.removeAllViews();
      }
      this.this$0.a(0);
      agcu.a(this.this$0, new ImageView(this.this$0.a()));
      agcu.a(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 81;
      View localView = new View(this.this$0.a());
      localView.setBackgroundColor(-16777216);
      localFriendShipLayout.addView(localView, localLayoutParams);
      localFriendShipLayout.addView(agcu.a(this.this$0), localLayoutParams);
      agcu.a(this.this$0).setImageDrawable(agcu.a(this.this$0));
      agcu.a(this.this$0).a(localView);
      agcu.a(this.this$0).a(localFriendShipLayout);
    }
    if (agcu.a(this.this$0).isAnimating()) {
      agcu.a(this.this$0).cancelAnimation();
    }
    if (agcu.a(this.this$0).a()) {
      agcu.a(this.this$0).b();
    }
    agcu.a(this.this$0).playAnimation();
    agcu.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.5
 * JD-Core Version:    0.7.0.1
 */