package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForAutoReply;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoReplyTextItemBuilder$1
  implements View.OnClickListener
{
  AutoReplyTextItemBuilder$1(AutoReplyTextItemBuilder paramAutoReplyTextItemBuilder, MessageForAutoReply paramMessageForAutoReply) {}
  
  public void onClick(View paramView)
  {
    AutoReplyTextItemBuilder.a(this.b, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AutoReplyTextItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */