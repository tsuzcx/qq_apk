package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class Conversation$29
  implements Runnable
{
  Conversation$29(Conversation paramConversation) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "delayUpdateMayKnowRecommendRunnable");
    }
    Conversation.k(this.this$0);
    this.this$0.a.sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.29
 * JD-Core Version:    0.7.0.1
 */