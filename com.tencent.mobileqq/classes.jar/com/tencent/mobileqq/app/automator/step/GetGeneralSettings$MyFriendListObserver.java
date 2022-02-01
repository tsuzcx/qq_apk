package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.FriendListObserver;

class GetGeneralSettings$MyFriendListObserver
  extends FriendListObserver
{
  private GetGeneralSettings$MyFriendListObserver(GetGeneralSettings paramGetGeneralSettings) {}
  
  public void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      this.a.a.a = 3;
      this.a.a(7);
      return;
    }
    this.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetGeneralSettings.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */