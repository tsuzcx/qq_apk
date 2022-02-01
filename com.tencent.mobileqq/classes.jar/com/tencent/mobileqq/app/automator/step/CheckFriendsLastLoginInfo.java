package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckFriendsLastLoginInfo
  extends AsyncStep
{
  private FriendListObserver a;
  
  protected int doStep()
  {
    if (((FriendListHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getLastLoginInfo())
    {
      if (this.a == null)
      {
        this.a = new CheckFriendsLastLoginInfo.MyFriendListObserver(this, null);
        this.mAutomator.k.addObserver(this.a);
      }
      return 2;
    }
    return 7;
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.mAutomator.k.removeObserver(this.a);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckFriendsLastLoginInfo
 * JD-Core Version:    0.7.0.1
 */