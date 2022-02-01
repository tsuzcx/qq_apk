package com.tencent.mobileqq.activity.main;

import aixk;
import aizi;
import ajmy;
import akam;
import android.os.Handler;
import android.os.Message;
import aoce;
import aqxe;
import aqxv;
import bdzy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

public class MainAssistObserver$15
  implements Runnable
{
  public MainAssistObserver$15(akam paramakam, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    label412:
    label494:
    for (;;)
    {
      Object localObject3;
      try
      {
        Object localObject1 = (ajmy)this.a.getManager(QQManagerFactory.CTENTRY_MNG);
        localObject3 = (aizi)this.a.getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
        int i = ((aizi)localObject3).d();
        if (QLog.isColorLevel()) {
          QLog.d("MainAssistObserver", 1, "updateTabContactNotify, totalCount = " + i);
        }
        aqxv localaqxv = (aqxv)aqxe.a().a(691);
        if ((localaqxv == null) || (!localaqxv.a(this.a.getCurrentAccountUin()))) {
          break label494;
        }
        int k = aoce.b(this.a);
        int m = bdzy.a().a(this.a);
        int j = i + k + m;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("MainAssistObserver", 1, "updateTabContactNotify, totalCount = " + j + " recommendUnreadCount" + k + " notificationUnreadCount" + m);
          i = j;
        }
        if (i > 0)
        {
          localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(5);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set(i + "");
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("{'cn':'#FF0000'}");
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("UndealCount.updateTabContactNotify", 2, "unread=" + i);
            localObject1 = localObject3;
          }
          localObject3 = this.this$0.a.obtainMessage(3);
          ((Message)localObject3).obj = localObject1;
          this.this$0.a.sendMessage((Message)localObject3);
          return;
        }
        if (((aizi)localObject3).a())
        {
          localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(0);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set("");
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("");
          localObject1 = localObject3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("UndealCount.updateTabContactNotify", 2, "redpoint");
          localObject1 = localObject3;
          continue;
        }
        if (localException == null) {
          break label412;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject2;
      if (localException.a())
      {
        localObject2 = null;
      }
      else if (aixk.a(this.a).a())
      {
        localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set("");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("");
        localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("NewFriendVerification.manager", 2, "updateTabContactNotify redpoint");
          localObject2 = localObject3;
        }
      }
      else
      {
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.15
 * JD-Core Version:    0.7.0.1
 */