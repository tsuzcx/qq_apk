package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.RegisterProxySvcPackObserver;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.qphone.base.util.QLog;

class Conversation$49
  extends RegisterProxySvcPackObserver
{
  Conversation$49(Conversation paramConversation) {}
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "onRegPrxyUpdateLoginDevStatus int iState = ", Integer.valueOf(paramInt) });
    }
    if (paramInt == 1)
    {
      this.a.a.a(31, 2, null);
      return;
    }
    this.a.a.b(31, 2000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.49
 * JD-Core Version:    0.7.0.1
 */