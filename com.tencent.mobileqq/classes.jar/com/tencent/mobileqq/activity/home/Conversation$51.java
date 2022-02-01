package com.tencent.mobileqq.activity.home;

import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.support.logging.SLog;

class Conversation$51
  extends QQStoryObserver
{
  Conversation$51(Conversation paramConversation) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.51
 * JD-Core Version:    0.7.0.1
 */