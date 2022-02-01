package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.Queue;

class ReadInJoyAdBubbleView$SingleBubble
{
  public int a;
  public Context a;
  public TextView a;
  public Queue<String> a;
  
  public ReadInJoyAdBubbleView$SingleBubble(TextView paramTextView, int paramInt, Context paramContext, Queue<String> paramQueue)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilQueue = paramQueue;
  }
  
  public void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int == 3) {
        this.jdField_a_of_type_Int = 0;
      }
      return;
      Object localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GradientDrawable)localObject).setColor(Color.argb(102, 0, 0, 0));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(255, 255, 255, 255));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
      localObject = (String)this.jdField_a_of_type_JavaUtilQueue.poll();
      this.jdField_a_of_type_JavaUtilQueue.offer(localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, "translationY", new float[] { 0.0F, -AIOUtils.a(29.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) }).setDuration(300L).start();
      continue;
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -AIOUtils.a(29.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -AIOUtils.a(59.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) });
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener(new ReadInJoyAdBubbleView.SingleBubble.1(this, (GradientDrawable)localObject));
      localValueAnimator.start();
      continue;
      ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, "translationY", new float[] { -AIOUtils.a(59.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -AIOUtils.a(110.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) }).setDuration(300L).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleView.SingleBubble
 * JD-Core Version:    0.7.0.1
 */