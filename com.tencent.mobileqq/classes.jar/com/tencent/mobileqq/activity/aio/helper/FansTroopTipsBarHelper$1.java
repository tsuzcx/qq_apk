package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.utils.FansTroopUtils;
import com.tencent.qphone.base.util.QLog;

class FansTroopTipsBarHelper$1
  extends TroopObserver
{
  FansTroopTipsBarHelper$1(FansTroopTipsBarHelper paramFansTroopTipsBarHelper) {}
  
  protected void onGetTroopInfoExtComplete(boolean paramBoolean, String paramString, TroopInfoExt paramTroopInfoExt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBarHelper", 2, new Object[] { "onGetTroopInfoExtComplete. ", Boolean.valueOf(paramBoolean), "troopUin=", paramString });
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      if (FansTroopTipsBarHelper.a(this.a) == null) {
        return;
      }
      if ((TextUtils.equals(paramString, FansTroopTipsBarHelper.a(this.a).b)) && (FansTroopUtils.a(FansTroopTipsBarHelper.b(this.a), paramString, paramTroopInfoExt))) {
        this.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FansTroopTipsBarHelper.1
 * JD-Core Version:    0.7.0.1
 */