package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopManager$7
  extends TroopObserver
{
  TroopManager$7(TroopManager paramTroopManager) {}
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetTroopInfoResult success: troopUin: ");
    localStringBuilder.append(paramString);
    QLog.i("troop_ext", 1, localStringBuilder.toString());
  }
  
  protected void onModifyTroopInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        paramString = (TroopMemberCardInfo)paramArrayList.get(i);
        ((ITroopMemberInfoService)this.a.a.getRuntimeService(ITroopMemberInfoService.class, "")).notifyChangeMember(paramString.troopuin, paramString.memberuin);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.7
 * JD-Core Version:    0.7.0.1
 */