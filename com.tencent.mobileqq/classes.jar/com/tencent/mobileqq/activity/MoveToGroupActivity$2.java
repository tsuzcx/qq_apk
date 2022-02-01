package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MoveToGroupActivity$2
  implements View.OnClickListener
{
  MoveToGroupActivity$2(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public void onClick(View paramView)
  {
    MoveToGroupActivity.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity.2
 * JD-Core Version:    0.7.0.1
 */