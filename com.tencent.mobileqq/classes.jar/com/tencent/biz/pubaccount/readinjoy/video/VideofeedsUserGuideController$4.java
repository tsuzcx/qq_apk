package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import src;

public class VideofeedsUserGuideController$4
  implements Runnable
{
  public VideofeedsUserGuideController$4(src paramsrc) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = src.b(this.this$0);
    if (localTranslateAnimation != null)
    {
      src.a(this.this$0).setVisibility(0);
      src.a(this.this$0).findViewById(2131380606).setVisibility(0);
      src.a(this.this$0).findViewById(2131380602).setVisibility(0);
      src.a(this.this$0).findViewById(2131380603).setVisibility(0);
      src.a(this.this$0).bringToFront();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)src.a(this.this$0).getLayoutParams();
      localMarginLayoutParams.setMargins(0, 0, 0, AIOUtils.dp2px(187.0F, src.a(this.this$0).getResources()));
      src.a(this.this$0).setLayoutParams(localMarginLayoutParams);
      src.a(this.this$0).startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.4
 * JD-Core Version:    0.7.0.1
 */