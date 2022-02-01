package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditInfoActivity$4
  implements View.OnClickListener
{
  EditInfoActivity$4(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    EditInfoActivity.d(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.4
 * JD-Core Version:    0.7.0.1
 */