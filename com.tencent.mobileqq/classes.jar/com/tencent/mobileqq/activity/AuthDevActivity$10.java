package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AuthDevActivity$10
  implements View.OnClickListener
{
  AuthDevActivity$10(AuthDevActivity paramAuthDevActivity) {}
  
  public void onClick(View paramView)
  {
    AuthDevActivity.access$2900(this.a);
    Intent localIntent = new Intent(this.a, AuthDevOpenUgActivity.class);
    localIntent.putExtra("DevlockInfo", AuthDevActivity.access$2500(this.a));
    this.a.startActivityForResult(localIntent, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.10
 * JD-Core Version:    0.7.0.1
 */