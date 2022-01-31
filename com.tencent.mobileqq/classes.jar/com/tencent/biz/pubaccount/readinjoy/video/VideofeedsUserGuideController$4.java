package com.tencent.biz.pubaccount.readinjoy.video;

import actn;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import qwa;

public class VideofeedsUserGuideController$4
  implements Runnable
{
  public VideofeedsUserGuideController$4(qwa paramqwa) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = qwa.b(this.this$0);
    if (localTranslateAnimation != null)
    {
      qwa.a(this.this$0).setVisibility(0);
      qwa.a(this.this$0).findViewById(2131378756).setVisibility(0);
      qwa.a(this.this$0).findViewById(2131378750).setVisibility(0);
      qwa.a(this.this$0).findViewById(2131378751).setVisibility(0);
      qwa.a(this.this$0).bringToFront();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)qwa.a(this.this$0).getLayoutParams();
      localMarginLayoutParams.setMargins(0, 0, 0, actn.a(187.0F, qwa.a(this.this$0).getResources()));
      qwa.a(this.this$0).setLayoutParams(localMarginLayoutParams);
      qwa.a(this.this$0).startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.4
 * JD-Core Version:    0.7.0.1
 */