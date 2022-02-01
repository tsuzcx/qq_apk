package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import sex;

public class VideofeedsUserGuideController$4
  implements Runnable
{
  public VideofeedsUserGuideController$4(sex paramsex) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = sex.b(this.this$0);
    if (localTranslateAnimation != null)
    {
      sex.a(this.this$0).setVisibility(0);
      sex.a(this.this$0).findViewById(2131380271).setVisibility(0);
      sex.a(this.this$0).findViewById(2131380267).setVisibility(0);
      sex.a(this.this$0).findViewById(2131380268).setVisibility(0);
      sex.a(this.this$0).bringToFront();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)sex.a(this.this$0).getLayoutParams();
      localMarginLayoutParams.setMargins(0, 0, 0, AIOUtils.dp2px(187.0F, sex.a(this.this$0).getResources()));
      sex.a(this.this$0).setLayoutParams(localMarginLayoutParams);
      sex.a(this.this$0).startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.4
 * JD-Core Version:    0.7.0.1
 */