package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.qphone.base.util.QLog;

class TroopObserversHelper$6
  extends TroopPushObserver
{
  TroopObserversHelper$6(TroopObserversHelper paramTroopObserversHelper) {}
  
  protected void a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(TroopObserversHelper.b(this.a).b)))
    {
      TroopObserversHelper.d(this.a).D();
      TroopObserversHelper.d(this.a).z();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopObserversHelper", 2, String.format("onPassiveExit, troopUin: %s, reason: %s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    paramString = (AVGameHelper)TroopObserversHelper.d(this.a).q(71);
    if (paramString != null) {
      paramString.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.6
 * JD-Core Version:    0.7.0.1
 */