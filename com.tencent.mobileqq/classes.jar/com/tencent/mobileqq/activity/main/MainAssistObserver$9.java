package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class MainAssistObserver$9
  implements NewFriendManager.INewFriendListener
{
  MainAssistObserver$9(MainAssistObserver paramMainAssistObserver) {}
  
  public void ae_() {}
  
  public void b()
  {
    if ((this.a.a == null) || (this.a.a.app == null)) {
      return;
    }
    ((NewFriendManager)this.a.a.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d();
  }
  
  public void k_(int paramInt)
  {
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.9
 * JD-Core Version:    0.7.0.1
 */