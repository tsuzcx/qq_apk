package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import afwy;
import afxx;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;

public class LottieAnimDirector$5
  implements Runnable
{
  public LottieAnimDirector$5(afwy paramafwy) {}
  
  public void run()
  {
    if (afwy.a(this.this$0) != null) {
      afwy.a(this.this$0).a(afwy.a(this.this$0) + "icon_close.png");
    }
    if ((afwy.a(this.this$0) == null) || (afwy.a(this.this$0).isAnimating())) {
      return;
    }
    FriendShipLayout localFriendShipLayout = this.this$0.a();
    if (localFriendShipLayout != null)
    {
      if (localFriendShipLayout.getChildCount() > 0) {
        localFriendShipLayout.removeAllViews();
      }
      this.this$0.a(0);
      afwy.a(this.this$0, new ImageView(this.this$0.a()));
      afwy.a(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 81;
      View localView = new View(this.this$0.a());
      localView.setBackgroundColor(-16777216);
      localFriendShipLayout.addView(localView, localLayoutParams);
      localFriendShipLayout.addView(afwy.a(this.this$0), localLayoutParams);
      afwy.a(this.this$0).setImageDrawable(afwy.a(this.this$0));
      afwy.a(this.this$0).a(localView);
      afwy.a(this.this$0).a(localFriendShipLayout);
    }
    if (afwy.a(this.this$0).isAnimating()) {
      afwy.a(this.this$0).cancelAnimation();
    }
    if (afwy.a(this.this$0).a()) {
      afwy.a(this.this$0).b();
    }
    afwy.a(this.this$0).playAnimation();
    afwy.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.5
 * JD-Core Version:    0.7.0.1
 */