package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AuthDevActivity$1
  implements CompoundButton.OnCheckedChangeListener
{
  AuthDevActivity$1(AuthDevActivity paramAuthDevActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == AuthDevActivity.access$000(this.a).a()) {
      AuthDevActivity.access$100(this.a);
    } else if (paramCompoundButton == AuthDevActivity.access$200(this.a).a()) {
      AuthDevActivity.access$300(this.a);
    } else if (paramCompoundButton == AuthDevActivity.access$400(this.a).a()) {
      AuthDevActivity.access$500(this.a, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.1
 * JD-Core Version:    0.7.0.1
 */