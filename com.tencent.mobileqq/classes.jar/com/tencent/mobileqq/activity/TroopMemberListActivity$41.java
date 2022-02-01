package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.robot.api.TroopRobotObserver;

class TroopMemberListActivity$41
  extends TroopRobotObserver
{
  TroopMemberListActivity$41(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (this.a.mTroopInfo.troopuin != null))
    {
      if (!paramString1.equals(this.a.mTroopInfo.troopuin)) {
        return;
      }
      this.a.removeItem(paramString2);
      this.a.mHandler.sendMessage(this.a.mHandler.obtainMessage(9));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.41
 * JD-Core Version:    0.7.0.1
 */