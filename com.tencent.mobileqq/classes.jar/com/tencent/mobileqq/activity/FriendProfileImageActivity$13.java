package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

class FriendProfileImageActivity$13
  implements Runnable
{
  FriendProfileImageActivity$13(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((FriendProfileImageActivity)localObject).f = false;
    if (!((FriendProfileImageActivity)localObject).jdField_c_of_type_Boolean) {
      this.this$0.b.setVisibility(0);
    }
    localObject = new TranslateAnimation(0.0F, 0.0F, this.this$0.getResources().getDimension(2131297609), 0.0F);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    this.this$0.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation((Animation)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.13
 * JD-Core Version:    0.7.0.1
 */