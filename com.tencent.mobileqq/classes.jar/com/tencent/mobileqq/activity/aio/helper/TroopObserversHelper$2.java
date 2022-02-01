package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.troop.troopgag.api.TroopGagObserver;
import com.tencent.mobileqq.troop.troopgag.data.GagStatus;
import com.tencent.qphone.base.util.QLog;

class TroopObserversHelper$2
  extends TroopGagObserver
{
  TroopObserversHelper$2(TroopObserversHelper paramTroopObserversHelper) {}
  
  protected void a(GagStatus paramGagStatus)
  {
    if ((paramGagStatus.b == 2) && (paramGagStatus.d != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onTroopGagStatusChange:");
        localStringBuilder.append(paramGagStatus.a);
        QLog.d("troop_gag", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(TroopObserversHelper.b(this.a).b))
      {
        if (TextUtils.isEmpty(paramGagStatus.a)) {
          return;
        }
        if (TroopObserversHelper.b(this.a).b.equals(paramGagStatus.a)) {
          TroopObserversHelper.d(this.a).a(paramGagStatus.d, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.2
 * JD-Core Version:    0.7.0.1
 */