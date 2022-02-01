package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class VideofeedsUserGuideController$4
  implements Runnable
{
  VideofeedsUserGuideController$4(VideofeedsUserGuideController paramVideofeedsUserGuideController) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = VideofeedsUserGuideController.b(this.this$0);
    if (localTranslateAnimation != null)
    {
      VideofeedsUserGuideController.a(this.this$0).setVisibility(0);
      VideofeedsUserGuideController.a(this.this$0).findViewById(2131381051).setVisibility(0);
      VideofeedsUserGuideController.a(this.this$0).findViewById(2131381047).setVisibility(0);
      VideofeedsUserGuideController.a(this.this$0).findViewById(2131381048).setVisibility(0);
      VideofeedsUserGuideController.a(this.this$0).bringToFront();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)VideofeedsUserGuideController.a(this.this$0).getLayoutParams();
      localMarginLayoutParams.setMargins(0, 0, 0, AIOUtils.a(187.0F, VideofeedsUserGuideController.a(this.this$0).getResources()));
      VideofeedsUserGuideController.a(this.this$0).setLayoutParams(localMarginLayoutParams);
      VideofeedsUserGuideController.a(this.this$0).startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.4
 * JD-Core Version:    0.7.0.1
 */