package com.tencent.mobileqq.activity.main;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$14
  implements Runnable
{
  MainAssistObserver$14(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.a.getRuntimeService(IRedTouchManager.class, "");
        Object localObject2 = localIRedTouchManager.getRedTouchInfoByAppSet(1);
        if (localObject2 == null)
        {
          Object localObject3 = (LocalRedTouchManager)this.a.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
          ((LocalRedTouchManager)localObject3).a(100601, false);
          boolean bool1 = ((LocalRedTouchManager)localObject3).a(10015, false);
          boolean bool2 = ((LocalRedTouchManager)localObject3).a(10016, false);
          ProfileCardUtil.b(this.a);
          Object localObject1 = ((LocalRedTouchManager)localObject3).a(-3);
          if (((LocalRedTouchManager)localObject3).a((RedTouchItem)localObject1, true))
          {
            localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
            if ((bool1 | bool2)) {
              MainAssistObserver.a(this.this$0, this.a);
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("updateTabSettingNotify me count=");
            ((StringBuilder)localObject3).append(((RedTouchItem)localObject1).count);
            QLog.d("MainAssistObserver", 1, ((StringBuilder)localObject3).toString());
            j = 1;
            localObject1 = localObject2;
            int i = j;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              i = j;
              if (UpgradeController.a(this.a))
              {
                localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
                i = 2;
              }
            }
            localObject3 = (CardHandler)this.a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            localObject2 = localObject1;
            j = i;
            if (localObject1 == null)
            {
              localObject2 = localObject1;
              j = i;
              if (!((CardHandler)localObject3).b())
              {
                localObject2 = localObject1;
                j = i;
                if (((CardHandler)localObject3).a())
                {
                  localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
                  j = 3;
                }
              }
            }
            localObject1 = localObject2;
            i = j;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              i = j;
              if (PrivacyPolicyHelper.a(1))
              {
                localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
                i = 4;
              }
            }
            j = localIRedTouchManager.getNumRedShowNumByAppSet(1);
            if (localObject1 != null) {
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
            }
            if (j > 0)
            {
              localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
              i = 5;
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("updateTabSettingNotify: showRedFromWhere=");
              ((StringBuilder)localObject2).append(i);
              QLog.d("MainAssistObserver", 2, ((StringBuilder)localObject2).toString());
            }
            localObject2 = this.this$0.a.obtainMessage(0);
            ((Message)localObject2).obj = localObject1;
            this.this$0.a.sendMessage((Message)localObject2);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.14
 * JD-Core Version:    0.7.0.1
 */