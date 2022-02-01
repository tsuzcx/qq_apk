package com.tencent.mobileqq.app;

import anvk;
import anwr;

public class HotChatShare$2
  implements Runnable
{
  public HotChatShare$2(anwr paramanwr, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.a != null) {
      ((anvk)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatShare.2
 * JD-Core Version:    0.7.0.1
 */