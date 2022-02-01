package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager;
import com.tencent.mobileqq.utils.SoLibraryChecker;
import com.tencent.qphone.base.util.QLog;

class TroopObserversHelper$3
  extends TroopModifyObserver
{
  TroopObserversHelper$3(TroopObserversHelper paramTroopObserversHelper) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      TroopObserversHelper.a(this.a, paramTroopInfo);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    boolean bool = QLog.isColorLevel();
    int i = 1;
    if (bool) {
      QLog.d("TroopObserversHelper", 2, new Object[] { "onChangeGroupClassExt. oldClassExt=", Long.valueOf(paramLong1), ", newClassExt=", Long.valueOf(paramLong2) });
    }
    if (paramLong2 != 32L) {
      i = 0;
    }
    if (i != 0) {
      new SoLibraryChecker(TroopObserversHelper.d(this.a).e, "3171", "libWXVoice.so", "WXVoice").a();
    }
    if ((TextUtils.equals(paramString, TroopObserversHelper.b(this.a).b)) && (paramBoolean) && (paramLong1 != paramLong2))
    {
      TroopClassControllerManager localTroopClassControllerManager = TroopObserversHelper.f(this.a);
      if (localTroopClassControllerManager != null) {
        localTroopClassControllerManager.a(paramLong2, true, TroopObserversHelper.d(this.a), paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.3
 * JD-Core Version:    0.7.0.1
 */