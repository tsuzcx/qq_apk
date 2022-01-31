package com.tencent.mobileqq.activity.aio.item;

import afmy;
import afna;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationSet;
import com.tencent.qphone.base.util.QLog;

public class GivingHeartItemBuilder$10
  implements Runnable
{
  public GivingHeartItemBuilder$10(afmy paramafmy, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (((Build.VERSION.SDK_INT > 16) && (this.jdField_a_of_type_AndroidAppActivity.isDestroyed())) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    View localView = ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).getChildAt(0).findViewById(2131362208);
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "start to shake");
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (AnimationSet localAnimationSet = afmy.a(this.this$0, this.b);; localAnimationSet = afmy.a(this.this$0.a, this.b))
    {
      localAnimationSet.setAnimationListener(new afna(this));
      if (localView == null) {
        break;
      }
      localView.startAnimation(localAnimationSet);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */