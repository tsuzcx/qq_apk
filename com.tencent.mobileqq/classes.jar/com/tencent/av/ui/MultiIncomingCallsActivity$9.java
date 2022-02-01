package com.tencent.av.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.app.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiIncomingCallsActivity$9
  implements View.OnClickListener
{
  MultiIncomingCallsActivity$9(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, long paramLong, Intent paramIntent, SessionInfo paramSessionInfo) {}
  
  public void onClick(View paramView)
  {
    this.d.a(this.a, this.b, this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.9
 * JD-Core Version:    0.7.0.1
 */