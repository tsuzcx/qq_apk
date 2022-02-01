package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUIService;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Queue;

class ReadInJoyAdBubbleNativeView$SingleBubble
{
  public TextView a;
  public int b = 0;
  public Context c;
  public Queue<String> d;
  
  public ReadInJoyAdBubbleNativeView$SingleBubble(TextView paramTextView, int paramInt, Context paramContext, Queue<String> paramQueue)
  {
    this.a = paramTextView;
    this.b = paramInt;
    this.c = paramContext;
    this.d = paramQueue;
  }
  
  public void a()
  {
    int i = this.b;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          ObjectAnimator.ofFloat(this.a, "translationY", new float[] { -((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(59.0F, this.c.getResources()), -((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(110.0F, this.c.getResources()) }).setDuration(300L).start();
        }
      }
      else
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(11.0F, this.c.getResources()));
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(29.0F, this.c.getResources()), -((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(59.0F, this.c.getResources()) });
        localValueAnimator.setDuration(300L);
        localValueAnimator.addUpdateListener(new ReadInJoyAdBubbleNativeView.SingleBubble.1(this, (GradientDrawable)localObject));
        localValueAnimator.start();
      }
    }
    else
    {
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(11.0F, this.c.getResources()));
      ((GradientDrawable)localObject).setColor(Color.argb(102, 0, 0, 0));
      this.a.setTextColor(Color.argb(255, 255, 255, 255));
      this.a.setBackgroundDrawable((Drawable)localObject);
      localObject = (String)this.d.poll();
      this.d.offer(localObject);
      this.a.setText((CharSequence)localObject);
      this.a.setVisibility(0);
      ObjectAnimator.ofFloat(this.a, "translationY", new float[] { 0.0F, -((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(29.0F, this.c.getResources()) }).setDuration(300L).start();
    }
    this.b += 1;
    if (this.b == 3) {
      this.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleNativeView.SingleBubble
 * JD-Core Version:    0.7.0.1
 */