package com.tencent.mobileqq.app.automator.step;

import QC.HamletCheck;
import QC.UniBusinessCheckItem;
import QC.UniLoginCheckRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class ChatBackgroundAuth$ChatBgAuthBusinessObserver
  implements BusinessObserver
{
  private WeakReference<QQAppInterface> a;
  
  public ChatBackgroundAuth$ChatBgAuthBusinessObserver(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null) {
      return;
    }
    if ((paramObject instanceof UniLoginCheckRsp))
    {
      Object localObject = TroopKeywordManager.a(localQQAppInterface);
      paramObject = (UniLoginCheckRsp)paramObject;
      ((TroopKeywordManager)localObject).a(paramObject.stKeyWord);
      if (paramObject.ret == 0)
      {
        ChatBackgroundManager localChatBackgroundManager = (ChatBackgroundManager)localQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
        localChatBackgroundManager.e();
        localChatBackgroundManager.f();
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "bg and effect id clear");
        }
        Iterator localIterator = paramObject.stHamletList.iterator();
        while (localIterator.hasNext())
        {
          HamletCheck localHamletCheck = (HamletCheck)localIterator.next();
          if ((localHamletCheck.itemlist != null) && (localHamletCheck.itemlist.size() > 0))
          {
            paramObject = localHamletCheck.itemlist.iterator();
            int i = -1;
            paramInt = -1;
            while (paramObject.hasNext())
            {
              localObject = (UniBusinessCheckItem)paramObject.next();
              if (((UniBusinessCheckItem)localObject).appid == 8) {
                i = ((UniBusinessCheckItem)localObject).itemid;
              } else if (((UniBusinessCheckItem)localObject).appid == 35) {
                paramInt = ((UniBusinessCheckItem)localObject).itemid;
              }
            }
            if (i >= 0)
            {
              if (QLog.isColorLevel())
              {
                paramObject = new StringBuilder();
                paramObject.append("bgId:");
                paramObject.append(i);
                paramObject.append(" effectId:");
                paramObject.append(paramInt);
                QLog.d("QQInitHandler", 2, paramObject.toString());
              }
              localObject = String.valueOf(localHamletCheck.uid);
              paramObject = localObject;
              if (localQQAppInterface.getAccount().equals(localObject))
              {
                paramObject = localObject;
                if (localHamletCheck.locationtype == 1) {
                  paramObject = null;
                }
              }
              if ((!"99".equals(String.valueOf(i))) || (paramInt > 0)) {
                localChatBackgroundManager.a(i, paramInt, paramObject, "chatbgAuth", ChatBackgroundAuth.a(localHamletCheck.locationtype));
              }
            }
          }
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse: ret:");
      ((StringBuilder)localObject).append(paramObject.ret);
      ((StringBuilder)localObject).append(" errmsg:");
      ((StringBuilder)localObject).append(paramObject.errmsg);
      QLog.e("QQInitHandler", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth.ChatBgAuthBusinessObserver
 * JD-Core Version:    0.7.0.1
 */