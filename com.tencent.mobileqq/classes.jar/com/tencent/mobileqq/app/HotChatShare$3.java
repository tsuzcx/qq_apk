package com.tencent.mobileqq.app;

class HotChatShare$3
  implements Runnable
{
  HotChatShare$3(HotChatShare paramHotChatShare, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.a != null) {
      ((FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatShare.3
 * JD-Core Version:    0.7.0.1
 */