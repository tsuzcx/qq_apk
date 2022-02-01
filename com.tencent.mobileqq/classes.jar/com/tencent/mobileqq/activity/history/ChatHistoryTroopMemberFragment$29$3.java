package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopMemberFragment$29$3
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$29$3(ChatHistoryTroopMemberFragment.29 param29) {}
  
  public void onClick(View paramView)
  {
    this.a.a.A = false;
    this.a.a.O.setVisibility(0);
    if (this.a.a.az != 22) {
      this.a.a.P.setVisibility(0);
    }
    this.a.a.N.setVisibility(8);
    this.a.a.T.setVisibility(8);
    this.a.a.T = ((TextView)ChatHistoryTroopMemberFragment.b(this.a.a, 2131436180));
    this.a.a.T.setVisibility(0);
    this.a.a.T.setOnClickListener(this.a.a.bi);
    if (this.a.a.K != null) {
      this.a.a.K.c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.29.3
 * JD-Core Version:    0.7.0.1
 */