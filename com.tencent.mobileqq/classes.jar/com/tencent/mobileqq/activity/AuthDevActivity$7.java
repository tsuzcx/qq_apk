package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AuthDevActivity$7
  implements View.OnClickListener
{
  AuthDevActivity$7(AuthDevActivity paramAuthDevActivity) {}
  
  public void onClick(View paramView)
  {
    AuthDevActivity.access$4200(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.7
 * JD-Core Version:    0.7.0.1
 */