package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.qphone.base.util.QLog;

class FansTroopTipsBarHelper$2
  extends TroopPushObserver
{
  FansTroopTipsBarHelper$2(FansTroopTipsBarHelper paramFansTroopTipsBarHelper) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBarHelper", 2, new Object[] { "onTroopClassExtChanged.", Boolean.valueOf(paramBoolean), " oldClassExt=", Long.valueOf(paramLong) });
    }
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if ((FansTroopTipsBarHelper.a(this.a) != null) && (TextUtils.equals(paramString, FansTroopTipsBarHelper.a(this.a).b))) {
        this.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FansTroopTipsBarHelper.2
 * JD-Core Version:    0.7.0.1
 */