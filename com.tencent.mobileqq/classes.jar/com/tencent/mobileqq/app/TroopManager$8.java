package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.qphone.base.util.QLog;

class TroopManager$8
  extends TroopManagerBizObserver
{
  TroopManager$8(TroopManager paramTroopManager) {}
  
  protected void onActiveExtTroop(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActiveExtTroop success: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" troopUin: ");
    localStringBuilder.append(paramString);
    QLog.i("troop_ext", 1, localStringBuilder.toString());
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      ((ITroopInfoHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.8
 * JD-Core Version:    0.7.0.1
 */