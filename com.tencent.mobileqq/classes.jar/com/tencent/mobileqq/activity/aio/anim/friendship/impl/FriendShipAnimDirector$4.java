package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import aewe;
import aexe;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;

public class FriendShipAnimDirector$4
  implements Runnable
{
  public FriendShipAnimDirector$4(aewe paramaewe) {}
  
  public void run()
  {
    if (aewe.a(this.this$0) != null) {
      aewe.a(this.this$0).a(aewe.a(this.this$0) + "icon_close.png");
    }
    if ((aewe.a(this.this$0) == null) || (aewe.a(this.this$0).isAnimating())) {
      return;
    }
    FriendShipLayout localFriendShipLayout = this.this$0.a();
    if (localFriendShipLayout != null)
    {
      if (localFriendShipLayout.getChildCount() > 0) {
        localFriendShipLayout.removeAllViews();
      }
      this.this$0.a(0);
      aewe.a(this.this$0, new ImageView(this.this$0.a()));
      aewe.a(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 81;
      View localView = new View(this.this$0.a());
      localView.setBackgroundColor(-16777216);
      localFriendShipLayout.addView(localView, localLayoutParams);
      localFriendShipLayout.addView(aewe.a(this.this$0), localLayoutParams);
      aewe.a(this.this$0).setImageDrawable(aewe.a(this.this$0));
      aewe.a(this.this$0).a(localView);
      aewe.a(this.this$0).a(localFriendShipLayout);
    }
    if (aewe.a(this.this$0).isAnimating()) {
      aewe.a(this.this$0).cancelAnimation();
    }
    if (aewe.a(this.this$0).a()) {
      aewe.a(this.this$0).b();
    }
    aewe.a(this.this$0).playAnimation();
    aewe.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.FriendShipAnimDirector.4
 * JD-Core Version:    0.7.0.1
 */