package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditInfoActivity$3
  implements View.OnClickListener
{
  EditInfoActivity$3(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.m();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.3
 * JD-Core Version:    0.7.0.1
 */