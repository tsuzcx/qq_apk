package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.ProfileConfigHelper.OnConfigUpdateListener;
import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$22
  implements ProfileConfigHelper.OnConfigUpdateListener
{
  FriendProfileCardActivity$22(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onConfigUpdate(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("onConfigUpdate configId=%s tag=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    }
    this.a.runOnUiThread(new FriendProfileCardActivity.22.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.22
 * JD-Core Version:    0.7.0.1
 */