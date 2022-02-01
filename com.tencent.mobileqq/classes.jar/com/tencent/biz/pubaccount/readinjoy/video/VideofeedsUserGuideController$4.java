package com.tencent.biz.pubaccount.readinjoy.video;

import agej;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import rxt;

public class VideofeedsUserGuideController$4
  implements Runnable
{
  public VideofeedsUserGuideController$4(rxt paramrxt) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = rxt.b(this.this$0);
    if (localTranslateAnimation != null)
    {
      rxt.a(this.this$0).setVisibility(0);
      rxt.a(this.this$0).findViewById(2131380547).setVisibility(0);
      rxt.a(this.this$0).findViewById(2131380543).setVisibility(0);
      rxt.a(this.this$0).findViewById(2131380544).setVisibility(0);
      rxt.a(this.this$0).bringToFront();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)rxt.a(this.this$0).getLayoutParams();
      localMarginLayoutParams.setMargins(0, 0, 0, agej.a(187.0F, rxt.a(this.this$0).getResources()));
      rxt.a(this.this$0).setLayoutParams(localMarginLayoutParams);
      rxt.a(this.this$0).startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.4
 * JD-Core Version:    0.7.0.1
 */