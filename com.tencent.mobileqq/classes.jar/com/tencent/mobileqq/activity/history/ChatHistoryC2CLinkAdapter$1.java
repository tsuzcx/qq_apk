package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryC2CLinkAdapter$1
  implements View.OnClickListener
{
  ChatHistoryC2CLinkAdapter$1(ChatHistoryC2CLinkAdapter paramChatHistoryC2CLinkAdapter, ChatHistoryC2CLinkAdapter.DividerViewHolder paramDividerViewHolder) {}
  
  public void onClick(View paramView)
  {
    String str = String.valueOf(this.a.a.getText());
    ChatHistoryC2CLinkAdapter.a(this.b, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkAdapter.1
 * JD-Core Version:    0.7.0.1
 */