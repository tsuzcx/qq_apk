package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.qphone.base.util.QLog;

class TroopMemberListActivity$27
  extends TroopGiftCallback
{
  TroopMemberListActivity$27(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onGetGiftMemberList error");
    }
    TroopMemberListActivity.a(this.a, true);
    if (TroopMemberListActivity.b(this.a))
    {
      paramString = this.a.a.obtainMessage(12, null);
      this.a.a.sendMessage(paramString);
    }
  }
  
  public void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onGetGiftMemberList");
    }
    TroopMemberListActivity.a(this.a, paramArrayOfLong1);
    TroopMemberListActivity.b(this.a, paramArrayOfLong2);
    TroopMemberListActivity.c(this.a, paramArrayOfLong3);
    TroopMemberListActivity.a(this.a, true);
    if (TroopMemberListActivity.b(this.a))
    {
      paramArrayOfLong1 = this.a.a.obtainMessage(12, null);
      this.a.a.sendMessage(paramArrayOfLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.27
 * JD-Core Version:    0.7.0.1
 */