package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;

class MainAssistObserver$12
  implements INewFriendListener
{
  MainAssistObserver$12(MainAssistObserver paramMainAssistObserver) {}
  
  public void b()
  {
    if (this.a.a != null)
    {
      if (this.a.a.app == null) {
        return;
      }
      ((INewFriendService)this.a.a.app.getRuntimeService(INewFriendService.class)).getUnreadMessageCountAsync();
    }
  }
  
  public void bR_() {}
  
  public void i_(int paramInt)
  {
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.12
 * JD-Core Version:    0.7.0.1
 */