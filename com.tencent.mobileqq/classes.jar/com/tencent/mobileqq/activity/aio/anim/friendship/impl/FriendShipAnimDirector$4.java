package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
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
    Object localObject1;
    Object localObject2;
    if (FriendShipAnimDirector.b(this.this$0) != null)
    {
      localObject1 = FriendShipAnimDirector.b(this.this$0);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FriendShipAnimDirector.a(this.this$0));
      ((StringBuilder)localObject2).append("icon_close.png");
      ((AdditionalAnimController)localObject1).a(((StringBuilder)localObject2).toString());
    }
    if (FriendShipAnimDirector.c(this.this$0) != null)
    {
      if (FriendShipAnimDirector.c(this.this$0).isAnimating()) {
        return;
      }
      localObject1 = this.this$0.h();
      if (localObject1 != null)
      {
        if (((FriendShipLayout)localObject1).getChildCount() > 0) {
          ((FriendShipLayout)localObject1).removeAllViews();
        }
        this.this$0.a(0);
        localObject2 = this.this$0;
        FriendShipAnimDirector.a((FriendShipAnimDirector)localObject2, new ImageView(((FriendShipAnimDirector)localObject2).g()));
        FriendShipAnimDirector.d(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject2).gravity = 81;
        View localView = new View(this.this$0.g());
        localView.setBackgroundColor(-16777216);
        ((FriendShipLayout)localObject1).addView(localView, (ViewGroup.LayoutParams)localObject2);
        ((FriendShipLayout)localObject1).addView(FriendShipAnimDirector.d(this.this$0), (ViewGroup.LayoutParams)localObject2);
        FriendShipAnimDirector.d(this.this$0).setImageDrawable(FriendShipAnimDirector.c(this.this$0));
        FriendShipAnimDirector.b(this.this$0).a(localView);
        FriendShipAnimDirector.b(this.this$0).a((FriendShipLayout)localObject1);
      }
      if (FriendShipAnimDirector.c(this.this$0).isAnimating()) {
        FriendShipAnimDirector.c(this.this$0).cancelAnimation();
      }
      if (FriendShipAnimDirector.b(this.this$0).b()) {
        FriendShipAnimDirector.b(this.this$0).c();
      }
      FriendShipAnimDirector.c(this.this$0).playAnimation();
      FriendShipAnimDirector.b(this.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.FriendShipAnimDirector.4
 * JD-Core Version:    0.7.0.1
 */