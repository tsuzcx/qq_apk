package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.homework.observer.HomeworkObserver;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;

class TroopObserversHelper$12
  extends HomeworkObserver
{
  TroopObserversHelper$12(TroopObserversHelper paramTroopObserversHelper) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    paramString3 = (TroopManager)TroopObserversHelper.a(this.a).getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramBoolean) && (TextUtils.equals(paramString1, TroopObserversHelper.b(this.a).b)) && (TextUtils.equals(paramString2, TroopObserversHelper.a(this.a).getCurrentAccountUin())) && (paramString3.aa(paramString1)))
    {
      paramString1 = TroopObserversHelper.f(this.a);
      if ((!((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).hasHomeworkTroopIdentity(paramInt)) && (paramString1 != null) && ((paramString1.a instanceof HomeworkTroopController))) {
        ((HomeworkTroopController)paramString1.a).b(TroopObserversHelper.d(this.a));
      }
      if (paramString1 != null) {
        paramString1.a(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.12
 * JD-Core Version:    0.7.0.1
 */