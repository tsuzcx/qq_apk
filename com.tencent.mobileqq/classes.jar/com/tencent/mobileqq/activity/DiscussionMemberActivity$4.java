package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DiscussionMemberActivity$4
  implements View.OnClickListener
{
  DiscussionMemberActivity$4(DiscussionMemberActivity paramDiscussionMemberActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.e.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.4
 * JD-Core Version:    0.7.0.1
 */