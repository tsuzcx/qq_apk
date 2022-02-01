package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.proxy.ProxyObserver;
import mqq.os.MqqHandler;

class ChatHistoryC2CAllFragment$11
  extends ProxyObserver
{
  ChatHistoryC2CAllFragment$11(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onProxySaveToDbFinished()
  {
    this.a.a.sendEmptyMessage(41);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.11
 * JD-Core Version:    0.7.0.1
 */