package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.login.ui.AddAccountBaseUI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddAccountActivity$1
  implements View.OnClickListener
{
  AddAccountActivity$1(AddAccountActivity paramAddAccountActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.mBaseUI.t();
    AddAccountActivity.access$000(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity.1
 * JD-Core Version:    0.7.0.1
 */