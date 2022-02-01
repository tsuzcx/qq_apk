package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.qphone.base.util.QLog;

class FansTroopTipsBarHelper$2
  extends TroopBusinessObserver
{
  FansTroopTipsBarHelper$2(FansTroopTipsBarHelper paramFansTroopTipsBarHelper) {}
  
  public void onTroopClassExtChanged(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBarHelper", 2, new Object[] { "onChangeGroupClassExt.", Boolean.valueOf(paramBoolean), " oldClassExt=", Long.valueOf(paramLong) });
    }
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((FansTroopTipsBarHelper.a(this.a) == null) || (!TextUtils.equals(paramString, FansTroopTipsBarHelper.a(this.a).a))) {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FansTroopTipsBarHelper.2
 * JD-Core Version:    0.7.0.1
 */