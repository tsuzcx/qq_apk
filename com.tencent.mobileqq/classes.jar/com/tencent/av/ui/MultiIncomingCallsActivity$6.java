package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiIncomingCallsActivity$6
  implements View.OnClickListener
{
  MultiIncomingCallsActivity$6(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, long paramLong) {}
  
  public void onClick(View paramView)
  {
    this.b.c(2);
    this.b.a(this.a, "onClickIgnore", true, null, -1);
    this.b.b("onClickIgnore");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.6
 * JD-Core Version:    0.7.0.1
 */