package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountListActivity$7
  implements View.OnClickListener
{
  PublicAccountListActivity$7(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.7
 * JD-Core Version:    0.7.0.1
 */