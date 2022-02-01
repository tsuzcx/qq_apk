package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AuthDevEnableCompleteActivity$1
  implements View.OnClickListener
{
  AuthDevEnableCompleteActivity$1(AuthDevEnableCompleteActivity paramAuthDevEnableCompleteActivity) {}
  
  public void onClick(View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131368486);
    if (localImageView != null)
    {
      int i = 0;
      if (localImageView.getVisibility() == 0) {
        i = 4;
      }
      localImageView.setVisibility(i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevEnableCompleteActivity.1
 * JD-Core Version:    0.7.0.1
 */