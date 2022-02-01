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
  
  public void onGetTroopInfoExtComplete(boolean paramBoolean, String paramString, TroopInfoExt paramTroopInfoExt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBarHelper", 2, new Object[] { "onGetTroopInfoExtComplete. ", Boolean.valueOf(paramBoolean), "troopUin=", paramString });
    }
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (FansTroopTipsBarHelper.a(this.a) == null)) {}
    while ((!TextUtils.equals(paramString, FansTroopTipsBarHelper.a(this.a).a)) || (!FansTroopUtils.a(FansTroopTipsBarHelper.a(this.a), paramString, paramTroopInfoExt))) {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FansTroopTipsBarHelper.1
 * JD-Core Version:    0.7.0.1
 */