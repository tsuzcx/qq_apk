package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;

class SettingUncommUsedContactsActivity$1
  extends FriendListObserver
{
  SettingUncommUsedContactsActivity$1(SettingUncommUsedContactsActivity paramSettingUncommUsedContactsActivity) {}
  
  public void onGetBothDongtaiPermissions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      SettingUncommUsedContactsActivity.a(this.a, this.a.a.a(), paramBoolean2);
      SettingUncommUsedContactsActivity.a(this.a, this.a.b.a(), paramBoolean3);
    }
  }
  
  public void onSetNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.a.a(2131719116, 1);
      SettingUncommUsedContactsActivity.a(this.a, this.a.a.a(), paramBoolean2);
    }
  }
  
  public void onSetShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.a.a(2131719116, 1);
      SettingUncommUsedContactsActivity.a(this.a, this.a.b.a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity.1
 * JD-Core Version:    0.7.0.1
 */