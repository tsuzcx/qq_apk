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
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetTroopMemberCardInfoResult suc=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" size=");
      int i;
      if (paramArrayList == null) {
        i = 0;
      } else {
        i = paramArrayList.size();
      }
      localStringBuilder.append(i);
      QLog.d("TroopNickNameManager", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      ThreadManager.executeOnSubThread(new TroopNickNameManager.1.1(this, paramArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopNickNameManager.1
 * JD-Core Version:    0.7.0.1
 */