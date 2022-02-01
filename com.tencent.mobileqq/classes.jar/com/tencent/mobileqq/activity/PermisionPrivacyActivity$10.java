package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;

class PermisionPrivacyActivity$10
  extends FriendListObserver
{
  PermisionPrivacyActivity$10(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onGetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean2);
    }
  }
  
  public void onSetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      this.a.a(2131719116, 1);
    }
    PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.10
 * JD-Core Version:    0.7.0.1
 */