package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import agmu;
import agnt;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;

public class LottieAnimDirector$5
  implements Runnable
{
  public LottieAnimDirector$5(agmu paramagmu) {}
  
  public void run()
  {
    if (agmu.a(this.this$0) != null) {
      agmu.a(this.this$0).a(agmu.a(this.this$0) + "icon_close.png");
    }
    if ((agmu.a(this.this$0) == null) || (agmu.a(this.this$0).isAnimating())) {
      return;
    }
    FriendShipLayout localFriendShipLayout = this.this$0.a();
    if (localFriendShipLayout != null)
    {
      if (localFriendShipLayout.getChildCount() > 0) {
        localFriendShipLayout.removeAllViews();
      }
      this.this$0.a(0);
      agmu.a(this.this$0, new ImageView(this.this$0.a()));
      agmu.a(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 81;
      View localView = new View(this.this$0.a());
      localView.setBackgroundColor(-16777216);
      localFriendShipLayout.addView(localView, localLayoutParams);
      localFriendShipLayout.addView(agmu.a(this.this$0), localLayoutParams);
      agmu.a(this.this$0).setImageDrawable(agmu.a(this.this$0));
      agmu.a(this.this$0).a(localView);
      agmu.a(this.this$0).a(localFriendShipLayout);
    }
    if (agmu.a(this.this$0).isAnimating()) {
      agmu.a(this.this$0).cancelAnimation();
    }
    if (agmu.a(this.this$0).a()) {
      agmu.a(this.this$0).b();
    }
    agmu.a(this.this$0).playAnimation();
    agmu.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.5
 * JD-Core Version:    0.7.0.1
 */