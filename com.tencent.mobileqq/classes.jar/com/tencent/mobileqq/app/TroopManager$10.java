package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class TroopManager$10
  extends TroopObserver
{
  TroopManager$10(TroopManager paramTroopManager) {}
  
  public void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    QLog.i("troop_ext", 1, "onGetTroopInfoResult success: troopUin: " + paramString);
  }
  
  public void onModifyTroopInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
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
  
  public void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    TroopManager.a(this.a, paramString, paramBoolean, paramList, paramInt1, paramLong, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.10
 * JD-Core Version:    0.7.0.1
 */