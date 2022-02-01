package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationSet;

class UnlimitedBladeWorks$6
  implements Runnable
{
  UnlimitedBladeWorks$6(UnlimitedBladeWorks paramUnlimitedBladeWorks, Activity paramActivity, int paramInt) {}
  
  public void run()
  {
    if (((Build.VERSION.SDK_INT > 16) && (this.jdField_a_of_type_AndroidAppActivity.isDestroyed())) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    View localView = ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).getChildAt(0).findViewById(2131362288);
    AnimationSet localAnimationSet = UnlimitedBladeWorks.a(this.this$0, this.jdField_a_of_type_Int);
    if (localView != null) {
      localView.startAnimation(localAnimationSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.6
 * JD-Core Version:    0.7.0.1
 */