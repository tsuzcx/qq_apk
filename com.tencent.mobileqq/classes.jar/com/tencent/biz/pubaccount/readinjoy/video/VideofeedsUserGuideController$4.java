package com.tencent.biz.pubaccount.readinjoy.video;

import afur;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import sgp;

public class VideofeedsUserGuideController$4
  implements Runnable
{
  public VideofeedsUserGuideController$4(sgp paramsgp) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = sgp.b(this.this$0);
    if (localTranslateAnimation != null)
    {
      sgp.a(this.this$0).setVisibility(0);
      sgp.a(this.this$0).findViewById(2131380361).setVisibility(0);
      sgp.a(this.this$0).findViewById(2131380357).setVisibility(0);
      sgp.a(this.this$0).findViewById(2131380358).setVisibility(0);
      sgp.a(this.this$0).bringToFront();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)sgp.a(this.this$0).getLayoutParams();
      localMarginLayoutParams.setMargins(0, 0, 0, afur.a(187.0F, sgp.a(this.this$0).getResources()));
      sgp.a(this.this$0).setLayoutParams(localMarginLayoutParams);
      sgp.a(this.this$0).startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.4
 * JD-Core Version:    0.7.0.1
 */