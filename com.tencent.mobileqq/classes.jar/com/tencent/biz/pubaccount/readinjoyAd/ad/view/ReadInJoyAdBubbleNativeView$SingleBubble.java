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
  public int a;
  public Context a;
  public TextView a;
  public Queue<String> a;
  
  public ReadInJoyAdBubbleNativeView$SingleBubble(TextView paramTextView, int paramInt, Context paramContext, Queue<String> paramQueue)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilQueue = paramQueue;
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, "translationY", new float[] { -((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(59.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(110.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) }).setDuration(300L).start();
        }
      }
      else
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(29.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(59.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) });
        localValueAnimator.setDuration(300L);
        localValueAnimator.addUpdateListener(new ReadInJoyAdBubbleNativeView.SingleBubble.1(this, (GradientDrawable)localObject));
        localValueAnimator.start();
      }
    }
    else
    {
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GradientDrawable)localObject).setColor(Color.argb(102, 0, 0, 0));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(255, 255, 255, 255));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
      localObject = (String)this.jdField_a_of_type_JavaUtilQueue.poll();
      this.jdField_a_of_type_JavaUtilQueue.offer(localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, "translationY", new float[] { 0.0F, -((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(29.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) }).setDuration(300L).start();
    }
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int == 3) {
      this.jdField_a_of_type_Int = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleNativeView.SingleBubble
 * JD-Core Version:    0.7.0.1
 */