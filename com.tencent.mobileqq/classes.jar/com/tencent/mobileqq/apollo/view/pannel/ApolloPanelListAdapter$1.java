package com.tencent.mobileqq.apollo.view.pannel;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

class ApolloPanelListAdapter$1
  implements Runnable
{
  ApolloPanelListAdapter$1(ApolloPanelListAdapter paramApolloPanelListAdapter, ImageView paramImageView, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, ApolloLinearLayout.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -0.5F, 1, 0.5F, 1, -0.5F, 1, 0.5F);
    localTranslateAnimation.setDuration(400L);
    localTranslateAnimation.setRepeatCount(1);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new ApolloPanelListAdapter.1.1(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListAdapter.1
 * JD-Core Version:    0.7.0.1
 */