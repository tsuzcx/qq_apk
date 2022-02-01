package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;

class ForwardRecentActivity$12
  extends TroopBusinessObserver
{
  ForwardRecentActivity$12(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onTroopSearch(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      ForwardRecentActivity.f(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.12
 * JD-Core Version:    0.7.0.1
 */