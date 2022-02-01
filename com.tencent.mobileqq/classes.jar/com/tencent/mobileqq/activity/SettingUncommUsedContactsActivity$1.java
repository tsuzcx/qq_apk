package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;

class SettingUncommUsedContactsActivity$1
  extends FriendListObserver
{
  SettingUncommUsedContactsActivity$1(SettingUncommUsedContactsActivity paramSettingUncommUsedContactsActivity) {}
  
  protected void onGetBothDongtaiPermissions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      SettingUncommUsedContactsActivity localSettingUncommUsedContactsActivity = this.a;
      SettingUncommUsedContactsActivity.a(localSettingUncommUsedContactsActivity, localSettingUncommUsedContactsActivity.a.a(), paramBoolean2);
      localSettingUncommUsedContactsActivity = this.a;
      SettingUncommUsedContactsActivity.a(localSettingUncommUsedContactsActivity, localSettingUncommUsedContactsActivity.b.a(), paramBoolean3);
    }
  }
  
  protected void onSetNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.a.a(2131718834, 1);
      SettingUncommUsedContactsActivity localSettingUncommUsedContactsActivity = this.a;
      SettingUncommUsedContactsActivity.a(localSettingUncommUsedContactsActivity, localSettingUncommUsedContactsActivity.a.a(), paramBoolean2);
    }
  }
  
  protected void onSetShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.a.a(2131718834, 1);
      SettingUncommUsedContactsActivity localSettingUncommUsedContactsActivity = this.a;
      SettingUncommUsedContactsActivity.a(localSettingUncommUsedContactsActivity, localSettingUncommUsedContactsActivity.b.a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity.1
 * JD-Core Version:    0.7.0.1
 */