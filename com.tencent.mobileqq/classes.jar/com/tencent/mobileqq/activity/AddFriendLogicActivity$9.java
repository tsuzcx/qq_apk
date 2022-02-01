package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

class AddFriendLogicActivity$9
  extends OpenIdObserver
{
  AddFriendLogicActivity$9(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if (!this.a.isFinishing())
    {
      if (this.a.c) {
        return;
      }
      if (this.a.b != null) {
        this.a.b.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, "openIdObserver success");
        }
        if (!paramOpenID.openID.equals(AddFriendLogicActivity.a))
        {
          AddFriendLogicActivity.a(this.a, true);
          this.a.a();
          return;
        }
        AddFriendLogicActivity.b(this.a);
        return;
      }
      AddFriendLogicActivity.b(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "openIdObserver fail");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity.9
 * JD-Core Version:    0.7.0.1
 */