package com.tencent.mobileqq.activity.main;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendCardUtils;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationEntryConfig;
import com.tencent.mobileqq.troop.utils.RecommendTroopUtils;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$19
  implements Runnable
{
  MainAssistObserver$19(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = (CTEntryMng)this.a.getManager(QQManagerFactory.CTENTRY_MNG);
      Object localObject1 = null;
      Object localObject3 = (INewFriendService)this.a.getRuntimeService(INewFriendService.class);
      int j = ((INewFriendService)localObject3).getAllUnreadMessageCount();
      boolean bool = QLog.isColorLevel();
      if (bool)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("updateTabContactNotify, totalCount = ");
        ((StringBuilder)localObject4).append(j);
        QLog.d("MainAssistObserver", 1, ((StringBuilder)localObject4).toString());
      }
      Object localObject4 = (TroopNotificationEntryConfig)QConfigManager.b().b(691);
      int i = j;
      if (localObject4 != null)
      {
        i = j;
        if (((TroopNotificationEntryConfig)localObject4).b(this.a.getCurrentAccountUin()))
        {
          int k = RecommendTroopUtils.b(this.a);
          int m = GroupSystemMsgController.a().b(this.a);
          j = j + k + m;
          i = j;
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("updateTabContactNotify, totalCount = ");
            ((StringBuilder)localObject4).append(j);
            ((StringBuilder)localObject4).append(" recommendUnreadCount");
            ((StringBuilder)localObject4).append(k);
            ((StringBuilder)localObject4).append(" notificationUnreadCount");
            ((StringBuilder)localObject4).append(m);
            QLog.d("MainAssistObserver", 1, ((StringBuilder)localObject4).toString());
            i = j;
          }
        }
      }
      j = ExtendFriendCardUtils.d(this.a);
      i += j;
      if (i > 0)
      {
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(5);
        localObject1 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("");
        ((PBStringField)localObject1).set(((StringBuilder)localObject3).toString());
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("{'cn':'#FF0000'}");
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("unread=");
          ((StringBuilder)localObject1).append(i);
          QLog.d("UndealCount.updateTabContactNotify", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      else if (((INewFriendService)localObject3).needShowAvatar())
      {
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set("");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("");
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("UndealCount.updateTabContactNotify", 2, "redpoint");
          localObject1 = localObject2;
        }
      }
      else if (((localObject2 == null) || (!((CTEntryMng)localObject2).b())) && (((INewFriendVerificationService)this.a.getRuntimeService(INewFriendVerificationService.class)).isShowRedPoint()))
      {
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set("");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("");
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("MainAssistObserver", 2, "updateTabContactNotify redpoint");
          localObject1 = localObject2;
        }
      }
      localObject2 = this.this$0.j.obtainMessage(3);
      ((Message)localObject2).obj = localObject1;
      this.this$0.j.sendMessage((Message)localObject2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.19
 * JD-Core Version:    0.7.0.1
 */