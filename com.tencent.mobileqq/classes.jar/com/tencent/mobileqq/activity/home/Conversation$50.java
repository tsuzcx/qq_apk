package com.tencent.mobileqq.activity.home;

import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.support.logging.SLog;

class Conversation$50
  extends QQStoryObserver
{
  Conversation$50(Conversation paramConversation) {}
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      SLog.b("Q.recent", "onMsgTabStoryShowChange() sendEmptyMessageDelayedToHandler MSG_INIT_MSGTAG_STORY process, send");
      this.a.a(1055, 0L, false);
      return;
    }
    Conversation.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.50
 * JD-Core Version:    0.7.0.1
 */