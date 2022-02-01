package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AuthDevActivity$8
  implements View.OnClickListener
{
  AuthDevActivity$8(AuthDevActivity paramAuthDevActivity) {}
  
  public void onClick(View paramView)
  {
    AuthDevActivity.access$4200(this.a);
    Intent localIntent = new Intent();
    localIntent.putExtra("DevlockInfo", AuthDevActivity.access$3800(this.a));
    this.a.startActivityForResult(localIntent, 0);
    RouteUtils.a(this.a, localIntent, "/base/safe/authDevOpenActivity", 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.8
 * JD-Core Version:    0.7.0.1
 */