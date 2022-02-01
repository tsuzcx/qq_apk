package com.tencent.mobileqq.activity.messagesearch;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MessageSearchDialog$3
  implements View.OnClickListener
{
  MessageSearchDialog$3(MessageSearchDialog paramMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog.3
 * JD-Core Version:    0.7.0.1
 */