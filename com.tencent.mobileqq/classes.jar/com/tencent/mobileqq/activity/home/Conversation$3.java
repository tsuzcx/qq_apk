package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

class Conversation$3
  implements Runnable
{
  Conversation$3(Conversation paramConversation, QQAppInterface paramQQAppInterface, List paramList) {}
  
  public void run()
  {
    RecentParcelUtil.a(this.a, this.b, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.3
 * JD-Core Version:    0.7.0.1
 */