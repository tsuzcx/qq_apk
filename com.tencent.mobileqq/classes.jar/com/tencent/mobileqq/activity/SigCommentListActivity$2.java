package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SigCommentListActivity$2
  implements View.OnClickListener
{
  SigCommentListActivity$2(SigCommentListActivity paramSigCommentListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a(true, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SigCommentListActivity.2
 * JD-Core Version:    0.7.0.1
 */