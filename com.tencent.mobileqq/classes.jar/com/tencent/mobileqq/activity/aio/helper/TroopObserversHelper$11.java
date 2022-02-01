package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.data.TroopAIONotifyItem;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.observer.TroopAioNotifyObserver;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class TroopObserversHelper$11
  extends TroopAioNotifyObserver
{
  TroopObserversHelper$11(TroopObserversHelper paramTroopObserversHelper) {}
  
  protected void a(boolean paramBoolean, String paramString, List<TroopAIONotifyItem> paramList)
  {
    if ((TroopObserversHelper.a(this.a) != null) && (!TextUtils.isEmpty(TroopObserversHelper.a(this.a).a)))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (!TroopObserversHelper.a(this.a).a.equals(paramString)) {
        return;
      }
      if (TroopObserversHelper.a(this.a).a != null)
      {
        Object localObject = TroopObserversHelper.a(this.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("");
        localObject = TroopAioNotifyManager.a((QQAppInterface)localObject, localStringBuilder.toString());
        localObject = TroopAioNotifyManager.a(TroopObserversHelper.a(this.a), paramList, (List)localObject);
        boolean bool1 = TroopObserversHelper.a(this.a).a.a();
        boolean bool2 = TroopObserversHelper.a(this.a).a.d();
        int j = 0;
        int i = j;
        if (localObject != null)
        {
          i = j;
          if (((List)localObject).size() > 0)
          {
            TroopObserversHelper.a(this.a).a.a((List)localObject);
            i = j;
            if (!bool2)
            {
              i = j;
              if (!bool1)
              {
                TroopObserversHelper.a(this.a).a.f();
                i = 1;
              }
            }
          }
        }
        boolean bool3 = ((TroopManager)TroopObserversHelper.a(this.a).getManager(QQManagerFactory.TROOP_MANAGER)).m(TroopObserversHelper.a(this.a).a);
        if ((!bool1) && (!bool2) && (i == 0) && (!bool3)) {
          ThreadManager.getUIHandler().postDelayed(new TroopObserversHelper.11.1(this), 500L);
        }
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("onGetTroopAioNotifyFeeds, isSucc=");
          paramList.append(paramBoolean);
          paramList.append(", troopUin=");
          paramList.append(paramString);
          paramList.append(", size=");
          if (localObject == null) {
            paramString = " ";
          } else {
            paramString = Integer.valueOf(((List)localObject).size());
          }
          paramList.append(paramString);
          paramList.append(", isMsgBarNeedShow=");
          paramList.append(bool1);
          paramList.append(", hasMsgBar=");
          paramList.append(bool2);
          paramList.append(", isQidianPrivateTroop=");
          paramList.append(bool3);
          QLog.d(".troop.notify_feeds.aio", 2, paramList.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.11
 * JD-Core Version:    0.7.0.1
 */