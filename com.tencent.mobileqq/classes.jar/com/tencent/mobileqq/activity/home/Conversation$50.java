package com.tencent.mobileqq.activity.home;

import android.os.Handler;
import com.tencent.mobileqq.activity.QZoneFeedsObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;

class Conversation$50
  extends QZoneFeedsObserver
{
  Conversation$50(Conversation paramConversation) {}
  
  public void a()
  {
    ThreadManagerV2.getUIHandlerV2().post(new Conversation.50.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.50
 * JD-Core Version:    0.7.0.1
 */