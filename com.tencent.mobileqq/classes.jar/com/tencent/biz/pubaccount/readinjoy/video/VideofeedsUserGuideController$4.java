package com.tencent.biz.pubaccount.readinjoy.video;

import aepi;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import rlo;

public class VideofeedsUserGuideController$4
  implements Runnable
{
  public VideofeedsUserGuideController$4(rlo paramrlo) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = rlo.b(this.this$0);
    if (localTranslateAnimation != null)
    {
      rlo.a(this.this$0).setVisibility(0);
      rlo.a(this.this$0).findViewById(2131379437).setVisibility(0);
      rlo.a(this.this$0).findViewById(2131379431).setVisibility(0);
      rlo.a(this.this$0).findViewById(2131379432).setVisibility(0);
      rlo.a(this.this$0).bringToFront();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)rlo.a(this.this$0).getLayoutParams();
      localMarginLayoutParams.setMargins(0, 0, 0, aepi.a(187.0F, rlo.a(this.this$0).getResources()));
      rlo.a(this.this$0).setLayoutParams(localMarginLayoutParams);
      rlo.a(this.this$0).startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.4
 * JD-Core Version:    0.7.0.1
 */