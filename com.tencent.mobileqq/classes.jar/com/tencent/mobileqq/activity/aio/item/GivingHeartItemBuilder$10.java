package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationSet;
import com.tencent.qphone.base.util.QLog;

class GivingHeartItemBuilder$10
  implements Runnable
{
  GivingHeartItemBuilder$10(GivingHeartItemBuilder paramGivingHeartItemBuilder, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (((Build.VERSION.SDK_INT > 16) && (this.a.isDestroyed())) || (this.a.isFinishing())) {
      return;
    }
    View localView = ((ViewGroup)this.a.getWindow().getDecorView()).getChildAt(0).findViewById(2131427887);
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "start to shake");
    }
    AnimationSet localAnimationSet;
    if (this.b) {
      localAnimationSet = GivingHeartItemBuilder.a(this.this$0, this.c);
    } else {
      localAnimationSet = GivingHeartItemBuilder.a(this.this$0.e, this.c);
    }
    localAnimationSet.setAnimationListener(new GivingHeartItemBuilder.10.1(this));
    if (localView != null) {
      localView.startAnimation(localAnimationSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */