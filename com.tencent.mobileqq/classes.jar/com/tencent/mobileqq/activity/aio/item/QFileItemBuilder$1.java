package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.bubble.QFileBubbleModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileItemBuilder$1
  implements View.OnClickListener
{
  QFileItemBuilder$1(QFileItemBuilder paramQFileItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = this.a.f(paramView);
    this.a.a.b(localChatMessage);
    this.a.a.u();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QFileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */