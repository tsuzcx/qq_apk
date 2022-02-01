package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class FriendProfileCardActivity$6
  extends ContactBindObserver
{
  FriendProfileCardActivity$6(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onUpdateContact(boolean paramBoolean, int paramInt)
  {
    super.onUpdateContact(paramBoolean, paramInt);
    if ((this.a.g) && (paramBoolean)) {
      this.a.a(0L, null, null, false);
    }
    this.a.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.6
 * JD-Core Version:    0.7.0.1
 */