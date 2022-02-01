package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AuthDevActivity$9
  implements View.OnClickListener
{
  AuthDevActivity$9(AuthDevActivity paramAuthDevActivity) {}
  
  public void onClick(View paramView)
  {
    AuthDevActivity.access$2900(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.9
 * JD-Core Version:    0.7.0.1
 */