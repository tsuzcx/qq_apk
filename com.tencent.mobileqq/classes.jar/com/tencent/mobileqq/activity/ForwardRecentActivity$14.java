package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import java.util.ArrayList;

class ForwardRecentActivity$14
  extends TroopObserver
{
  ForwardRecentActivity$14(ForwardRecentActivity paramForwardRecentActivity) {}
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean1, ArrayList<TroopMemberCardInfo> paramArrayList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramArrayList != null) && (paramArrayList.size() > 0) && (paramBoolean2)) {
      ForwardRecentActivity.access$1900(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.14
 * JD-Core Version:    0.7.0.1
 */