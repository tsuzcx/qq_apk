package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import cooperation.troop.TroopManageCmd;

class TroopMemberApiService$3
  extends TroopManagerBizObserver
{
  TroopMemberApiService$3(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void onConfessTalkSwitchChange(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      TroopMemberApiService.a(this.a, TYPE_CONFESS_TALK_SWITCH, paramBoolean, (Object[])paramObject, getClass().getSuperclass().getName(), "");
    }
  }
  
  protected void onGetMaxTroopAdminNum(boolean paramBoolean, String paramString, int paramInt)
  {
    TroopMemberApiService localTroopMemberApiService = this.a;
    int i = TYPE_GET_MAX_TROOP_ADMIN_NUM;
    String str = getClass().getSuperclass().getName();
    TroopMemberApiService.a(localTroopMemberApiService, i, paramBoolean, new Object[] { paramString, Integer.valueOf(paramInt) }, str, "");
  }
  
  protected void onGetPayToJoinTroopStatus(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2)
  {
    TroopMemberApiService localTroopMemberApiService = this.a;
    int i = TYPE_GET_PAY_TO_JOIN_TROOP_STATUS;
    String str = getClass().getSuperclass().getName();
    TroopMemberApiService.a(localTroopMemberApiService, i, paramBoolean1, new Object[] { paramString1, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4), paramString2 }, str, paramString2);
  }
  
  protected void onGetTroopInfoForSetJoinTypeRet(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo, Object[] paramArrayOfObject)
  {
    paramTroopInfo = new TroopManageCmd((QQAppInterface)TroopMemberApiService.a(this.a));
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null) {
      localPluginCommunicationHandler.register(paramTroopInfo);
    }
    paramTroopInfo = new Bundle();
    paramTroopInfo.putBoolean("isSuccess", paramBoolean);
    paramTroopInfo.putInt("seq", ((Integer)paramArrayOfObject[0]).intValue());
    paramTroopInfo.putString("processName", (String)paramArrayOfObject[1]);
    this.a.a(59, paramTroopInfo);
  }
  
  protected void onGetTroopMemberMaxNum(boolean paramBoolean, String paramString, int paramInt)
  {
    TroopMemberApiService localTroopMemberApiService = this.a;
    int i = TYPE_GET_TROOP_MEMBER_MAX_NUM;
    String str = getClass().getSuperclass().getName();
    TroopMemberApiService.a(localTroopMemberApiService, i, paramBoolean, new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) }, str, "");
  }
  
  protected void onNotifyTroopUpgradeSuccess(String paramString, int paramInt)
  {
    TroopMemberApiService localTroopMemberApiService = this.a;
    int i = TYPE_NOTIFY_TROOP_UPGRADE_SUCCESS;
    String str = getClass().getSuperclass().getName();
    TroopMemberApiService.a(localTroopMemberApiService, i, true, new Object[] { paramString, Integer.valueOf(paramInt) }, str, "");
  }
  
  protected void onSetAnonymousChatResult(boolean paramBoolean1, boolean paramBoolean2)
  {
    TroopMemberApiService.a(this.a, TYPE_ANONYMOUS_CHAT_SET_RESULT, paramBoolean1, Boolean.valueOf(paramBoolean2), getClass().getSuperclass().getName(), "com.tencent.mobileqq:troopmanage");
  }
  
  protected void onWriteTogetherSwitchChange(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      TroopMemberApiService.a(this.a, TYPE_WRITE_TOGETHER_SWITCH, paramBoolean, (Object[])paramObject, getClass().getSuperclass().getName(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.3
 * JD-Core Version:    0.7.0.1
 */