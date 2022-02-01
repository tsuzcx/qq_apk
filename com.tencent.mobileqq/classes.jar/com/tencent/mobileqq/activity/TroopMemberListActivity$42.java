package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;

class TroopMemberListActivity$42
  extends TroopSettingObserver
{
  TroopMemberListActivity$42(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    if (!this.a.mTroopUin.equals(paramString1)) {
      return;
    }
    ThreadManager.post(new TroopMemberListActivity.42.1(this, paramString2), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.42
 * JD-Core Version:    0.7.0.1
 */