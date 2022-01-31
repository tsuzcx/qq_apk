package com.tencent.biz.pubaccount.readinjoy.video;

import actj;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import qvx;

public class VideofeedsUserGuideController$4
  implements Runnable
{
  public VideofeedsUserGuideController$4(qvx paramqvx) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = qvx.b(this.this$0);
    if (localTranslateAnimation != null)
    {
      qvx.a(this.this$0).setVisibility(0);
      qvx.a(this.this$0).findViewById(2131378761).setVisibility(0);
      qvx.a(this.this$0).findViewById(2131378755).setVisibility(0);
      qvx.a(this.this$0).findViewById(2131378756).setVisibility(0);
      qvx.a(this.this$0).bringToFront();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)qvx.a(this.this$0).getLayoutParams();
      localMarginLayoutParams.setMargins(0, 0, 0, actj.a(187.0F, qvx.a(this.this$0).getResources()));
      qvx.a(this.this$0).setLayoutParams(localMarginLayoutParams);
      qvx.a(this.this$0).startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.4
 * JD-Core Version:    0.7.0.1
 */