package com.tencent.mobileqq.activity.aio.item;

import afzw;
import afzy;
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
  public GivingHeartItemBuilder$10(afzw paramafzw, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (((Build.VERSION.SDK_INT > 16) && (this.jdField_a_of_type_AndroidAppActivity.isDestroyed())) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    View localView = ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).getChildAt(0).findViewById(2131362294);
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "start to shake");
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (AnimationSet localAnimationSet = afzw.a(this.this$0, this.b);; localAnimationSet = afzw.a(this.this$0.a, this.b))
    {
      localAnimationSet.setAnimationListener(new afzy(this));
      if (localView == null) {
        break;
      }
      localView.startAnimation(localAnimationSet);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */