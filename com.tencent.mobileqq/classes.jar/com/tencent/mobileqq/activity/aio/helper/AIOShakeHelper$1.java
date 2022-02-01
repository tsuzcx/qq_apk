package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;

class AIOShakeHelper$1
  implements Runnable
{
  AIOShakeHelper$1(AIOShakeHelper paramAIOShakeHelper, Activity paramActivity) {}
  
  public void run()
  {
    AIOShakeHelper.a(this.this$0, new View(this.a));
    AIOShakeHelper.a(this.this$0).setOnTouchListener(new AIOShakeHelper.1.1(this));
    this.a.addContentView(AIOShakeHelper.a(this.this$0), new ViewGroup.LayoutParams(-1, -1));
    Object localObject = (ViewGroup)this.a.getWindow().getDecorView();
    int i = 0;
    localObject = ((ViewGroup)localObject).getChildAt(0);
    AnimationSet localAnimationSet = new AnimationSet(false);
    long[] arrayOfLong = new long[6];
    long[] tmp103_101 = arrayOfLong;
    tmp103_101[0] = 200L;
    long[] tmp109_103 = tmp103_101;
    tmp109_103[1] = 300L;
    long[] tmp115_109 = tmp109_103;
    tmp115_109[2] = 200L;
    long[] tmp121_115 = tmp115_109;
    tmp121_115[3] = 300L;
    long[] tmp127_121 = tmp121_115;
    tmp127_121[4] = 200L;
    long[] tmp133_127 = tmp127_121;
    tmp133_127[5] = 300L;
    tmp133_127;
    long l = 0L;
    while (i < arrayOfLong.length)
    {
      if (i % 2 != 0)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 10.0F, 0.0F, 10.0F);
        localTranslateAnimation.setDuration(arrayOfLong[i]);
        localTranslateAnimation.setStartOffset(l);
        localTranslateAnimation.setInterpolator(new CycleInterpolator((float)localTranslateAnimation.getDuration() / 60.0F));
        localAnimationSet.addAnimation(localTranslateAnimation);
      }
      l += arrayOfLong[i];
      i += 1;
    }
    localAnimationSet.setAnimationListener(new AIOShakeHelper.1.2(this));
    ((View)localObject).startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.1
 * JD-Core Version:    0.7.0.1
 */