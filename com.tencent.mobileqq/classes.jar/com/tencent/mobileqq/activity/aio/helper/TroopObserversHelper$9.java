package com.tencent.mobileqq.activity.aio.helper;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class TroopObserversHelper$9
  extends TroopRedDotObserver
{
  TroopObserversHelper$9(TroopObserversHelper paramTroopObserversHelper) {}
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      String str;
      if (paramString1 == null) {
        str = "";
      } else {
        str = paramString1;
      }
      QLog.d("TroopObserversHelper", 2, new Object[] { "onChangeTroopAIORedPoint. isSuc=", Boolean.valueOf(paramBoolean1), ", troopUin=", str, ", type = ", paramString2, ", from0x8c2=", Boolean.valueOf(paramBoolean2) });
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return;
      }
      if ((TextUtils.equals(paramString1, TroopObserversHelper.a(this.a).jdField_a_of_type_JavaLangString)) && (((TroopManager)TroopObserversHelper.a(this.a).getManager(QQManagerFactory.TROOP_MANAGER)).n(TroopObserversHelper.a(this.a).jdField_a_of_type_JavaLangString)) && (String.valueOf(1104445552).equals(paramString2)))
      {
        paramString1 = TroopObserversHelper.a(this.a);
        if ((paramString1 != null) && ((paramString1.a instanceof HomeworkTroopController))) {
          ((HomeworkTroopController)paramString1.a).a(false, TroopObserversHelper.a(this.a));
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      if (!TextUtils.equals(paramString, TroopObserversHelper.a(this.a).jdField_a_of_type_JavaLangString)) {
        return;
      }
      Object localObject = ChatActivityUtils.a(TroopObserversHelper.a(this.a).jdField_a_of_type_JavaLangString, TroopObserversHelper.a(this.a).getCurrentAccountUin());
      boolean bool;
      if ((localObject != null) && (-1 == ((Integer)localObject).intValue())) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTroopNewFeedsComing, isSuc:");
        ((StringBuilder)localObject).append(paramBoolean1);
        ((StringBuilder)localObject).append(", troopUin=");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(",bDeleted:");
        ((StringBuilder)localObject).append(paramBoolean2);
        ((StringBuilder)localObject).append(", isFromPush=");
        ((StringBuilder)localObject).append(paramBoolean3);
        ((StringBuilder)localObject).append(", hasNewNotify=");
        ((StringBuilder)localObject).append(bool);
        QLog.d(".troop.notify_feeds.aio", 2, ((StringBuilder)localObject).toString());
      }
      if (!paramBoolean3) {
        TroopAioNotifyManager.a(TroopObserversHelper.a(this.a), TroopObserversHelper.a(this.a).jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<TroopUnreadMsgInfo> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopObserversHelper", 2, new Object[] { "onUpdateTroopUnreadMsg. isSuc=", Boolean.valueOf(paramBoolean1), ", isPush=", Boolean.valueOf(paramBoolean2) });
    }
    if ((paramBoolean1) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      TroopManager localTroopManager = (TroopManager)TroopObserversHelper.a(this.a).getManager(QQManagerFactory.TROOP_MANAGER);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (TroopUnreadMsgInfo)paramList.next();
        if (TextUtils.equals(TroopObserversHelper.a(this.a).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString))
        {
          Object localObject2;
          if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1104445552L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopObserversHelper", 2, new Object[] { "onUpdateTroopUnreadMsg homework. num=", Integer.valueOf(((TroopUnreadMsgInfo)localObject1).b) });
            }
            if (localTroopManager.n(TroopObserversHelper.a(this.a).jdField_a_of_type_JavaLangString))
            {
              localObject2 = TroopObserversHelper.a(this.a);
              if ((localObject2 != null) && ((((TroopClassControllerManager)localObject2).a instanceof HomeworkTroopController))) {
                ((HomeworkTroopController)((TroopClassControllerManager)localObject2).a).a(false, TroopObserversHelper.a(this.a));
              }
            }
          }
          if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 2L)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("receive troop album  red dot, push=");
              ((StringBuilder)localObject2).append(paramBoolean2);
              ((StringBuilder)localObject2).append(", num=");
              ((StringBuilder)localObject2).append(((TroopUnreadMsgInfo)localObject1).b);
              QLog.d("TroopObserversHelper", 2, ((StringBuilder)localObject2).toString());
            }
            localObject1 = TroopObserversHelper.a(this.a).a();
            TroopObserversHelper.a(this.a);
            ((MqqHandler)localObject1).obtainMessage(85).sendToTarget();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.9
 * JD-Core Version:    0.7.0.1
 */