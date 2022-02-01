package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.app.MessageObserver;
import mqq.os.MqqHandler;

class ChatHistory$23
  extends MessageObserver
{
  ChatHistory$23(ChatHistory paramChatHistory) {}
  
  protected void onUpdateDelRoamChat(boolean paramBoolean)
  {
    this.a.r();
    if (!paramBoolean)
    {
      Message localMessage = this.a.a.obtainMessage(5);
      this.a.a(localMessage);
    }
  }
  
  protected void onUpdateSetRoamChat(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localMessage = this.a.a.obtainMessage(3);
      this.a.a(localMessage);
      return;
    }
    Message localMessage = this.a.a.obtainMessage(2);
    this.a.a(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.23
 * JD-Core Version:    0.7.0.1
 */