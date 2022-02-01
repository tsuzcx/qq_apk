package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WriteTogetherItemBuilder$3
  implements View.OnClickListener
{
  WriteTogetherItemBuilder$3(WriteTogetherItemBuilder paramWriteTogetherItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    WriteTogetherItemBuilder.a(this.a, localChatMessage, 5);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.WriteTogetherItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */