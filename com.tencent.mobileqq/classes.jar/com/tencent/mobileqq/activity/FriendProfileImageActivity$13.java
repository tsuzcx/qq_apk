package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

class FriendProfileImageActivity$13
  implements Runnable
{
  FriendProfileImageActivity$13(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void run()
  {
    this.this$0.f = false;
    if (!this.this$0.jdField_c_of_type_Boolean) {
      this.this$0.b.setVisibility(0);
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.this$0.getResources().getDimension(2131297483), 0.0F);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.this$0.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.13
 * JD-Core Version:    0.7.0.1
 */