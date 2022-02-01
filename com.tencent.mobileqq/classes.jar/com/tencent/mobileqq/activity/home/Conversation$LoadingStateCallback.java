package com.tencent.mobileqq.activity.home;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.managers.LoadingStateManager;

class Conversation$LoadingStateCallback
  implements Handler.Callback
{
  Conversation$LoadingStateCallback(Conversation paramConversation) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    LoadingStateManager.a().a(paramMessage.what);
    if (paramMessage.what == 4)
    {
      this.a.a(1134013, 0L, false);
      return true;
    }
    this.a.e(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.LoadingStateCallback
 * JD-Core Version:    0.7.0.1
 */