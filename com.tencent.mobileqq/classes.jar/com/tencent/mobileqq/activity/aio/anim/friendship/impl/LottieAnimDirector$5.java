package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import adag;
import adbf;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;

public class LottieAnimDirector$5
  implements Runnable
{
  public LottieAnimDirector$5(adag paramadag) {}
  
  public void run()
  {
    if (adag.a(this.this$0) != null) {
      adag.a(this.this$0).a(adag.a(this.this$0) + "icon_close.png");
    }
    if ((adag.a(this.this$0) == null) || (adag.a(this.this$0).isAnimating())) {
      return;
    }
    FriendShipLayout localFriendShipLayout = this.this$0.a();
    if (localFriendShipLayout != null)
    {
      if (localFriendShipLayout.getChildCount() > 0) {
        localFriendShipLayout.removeAllViews();
      }
      this.this$0.a(0);
      adag.a(this.this$0, new ImageView(this.this$0.a()));
      adag.a(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 81;
      View localView = new View(this.this$0.a());
      localView.setBackgroundColor(-16777216);
      localFriendShipLayout.addView(localView, localLayoutParams);
      localFriendShipLayout.addView(adag.a(this.this$0), localLayoutParams);
      adag.a(this.this$0).setImageDrawable(adag.a(this.this$0));
      adag.a(this.this$0).a(localView);
      adag.a(this.this$0).a(localFriendShipLayout);
    }
    if (adag.a(this.this$0).isAnimating()) {
      adag.a(this.this$0).cancelAnimation();
    }
    if (adag.a(this.this$0).a()) {
      adag.a(this.this$0).b();
    }
    adag.a(this.this$0).playAnimation();
    adag.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.5
 * JD-Core Version:    0.7.0.1
 */