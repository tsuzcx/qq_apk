package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi.TroopGiftCallbackTemp;
import com.tencent.qphone.base.util.QLog;

class TroopMemberListActivity$27
  extends ITroopMemberListActivityApi.TroopGiftCallbackTemp
{
  TroopMemberListActivity$27(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onGetGiftMemberList error");
    }
    TroopMemberListActivity.access$1502(this.a, true);
    if (TroopMemberListActivity.access$1600(this.a))
    {
      paramString = this.a.mHandler.obtainMessage(12, null);
      this.a.mHandler.sendMessage(paramString);
    }
  }
  
  public void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onGetGiftMemberList");
    }
    TroopMemberListActivity.access$1202(this.a, paramArrayOfLong1);
    TroopMemberListActivity.access$1302(this.a, paramArrayOfLong2);
    TroopMemberListActivity.access$1402(this.a, paramArrayOfLong3);
    TroopMemberListActivity.access$1502(this.a, true);
    if (TroopMemberListActivity.access$1600(this.a))
    {
      paramArrayOfLong1 = this.a.mHandler.obtainMessage(12, null);
      this.a.mHandler.sendMessage(paramArrayOfLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.27
 * JD-Core Version:    0.7.0.1
 */