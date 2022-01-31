package com.tencent.biz.pubaccount.readinjoy.video;

import aciy;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import qjv;

public class VideofeedsUserGuideController$4
  implements Runnable
{
  public VideofeedsUserGuideController$4(qjv paramqjv) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = qjv.b(this.this$0);
    if (localTranslateAnimation != null)
    {
      qjv.a(this.this$0).setVisibility(0);
      qjv.a(this.this$0).findViewById(2131312931).setVisibility(0);
      qjv.a(this.this$0).findViewById(2131312925).setVisibility(0);
      qjv.a(this.this$0).findViewById(2131312926).setVisibility(0);
      qjv.a(this.this$0).bringToFront();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)qjv.a(this.this$0).getLayoutParams();
      localMarginLayoutParams.setMargins(0, 0, 0, aciy.a(187.0F, qjv.a(this.this$0).getResources()));
      qjv.a(this.this$0).setLayoutParams(localMarginLayoutParams);
      qjv.a(this.this$0).startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.4
 * JD-Core Version:    0.7.0.1
 */