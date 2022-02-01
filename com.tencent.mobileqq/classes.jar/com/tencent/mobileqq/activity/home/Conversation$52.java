package com.tencent.mobileqq.activity.home;

import android.os.Handler;
import com.tencent.mobileqq.activity.QZoneFeedsObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;

class Conversation$52
  extends QZoneFeedsObserver
{
  Conversation$52(Conversation paramConversation) {}
  
  protected void a()
  {
    ThreadManagerV2.getUIHandlerV2().post(new Conversation.52.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.52
 * JD-Core Version:    0.7.0.1
 */