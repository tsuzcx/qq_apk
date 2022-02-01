package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.qphone.base.util.QLog;

class TroopManager$11
  extends TroopBusinessObserver
{
  TroopManager$11(TroopManager paramTroopManager) {}
  
  protected void onActiveExtTroop(boolean paramBoolean, String paramString)
  {
    QLog.i("troop_ext", 1, "onActiveExtTroop success: " + paramBoolean + " troopUin: " + paramString);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      ((TroopInfoHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).b(paramString);
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    TroopManager.a(this.a, paramInt1, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.11
 * JD-Core Version:    0.7.0.1
 */