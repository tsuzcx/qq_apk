package com.tencent.biz.qqstory.model;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopNickNameManager$1
  extends TroopObserver
{
  TroopNickNameManager$1(TroopNickNameManager paramTroopNickNameManager) {}
  
  public void onGetTroopMemberCardInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onGetTroopMemberCardInfoResult suc=").append(paramBoolean).append(" size=");
      if (paramArrayList != null) {
        break label78;
      }
    }
    label78:
    for (int i = 0;; i = paramArrayList.size())
    {
      QLog.d("TroopNickNameManager", 2, i);
      if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
        ThreadManager.executeOnSubThread(new TroopNickNameManager.1.1(this, paramArrayList));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopNickNameManager.1
 * JD-Core Version:    0.7.0.1
 */