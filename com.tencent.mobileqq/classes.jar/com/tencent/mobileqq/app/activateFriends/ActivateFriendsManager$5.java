package com.tencent.mobileqq.app.activateFriends;

import Wallet.AcsMsg;
import aeju;
import aejx;
import aljq;
import ambl;
import android.content.SharedPreferences;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ActivateFriendsManager$5
  implements Runnable
{
  public ActivateFriendsManager$5(ambl paramambl) {}
  
  public void run()
  {
    Object localObject2;
    AcsMsg localAcsMsg;
    try
    {
      if ((ambl.a(this.this$0) != null) && (ambl.a(this.this$0) != null))
      {
        localObject2 = ambl.a(this.this$0).a();
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          aeju localaeju = (aeju)ambl.a(this.this$0).getManager(321);
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localAcsMsg = (AcsMsg)((Iterator)localObject2).next();
            if (localAcsMsg.notice_time <= NetConnInfoCenter.getServerTime()) {
              break label147;
            }
            if (localaeju != null) {
              localaeju.a(localAcsMsg);
            }
          }
        }
      }
      else
      {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ActivateFriends.Manager", 1, "checkTodayReminder throw an exception: " + localThrowable);
    }
    for (;;)
    {
      label147:
      boolean bool1 = ambl.a(this.this$0).getBoolean(localAcsMsg.msg_id + ambl.a(this.this$0).getCurrentAccountUin(), false);
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, " has notifaction: " + bool1 + " key: " + localAcsMsg.msg_id + ambl.a(this.this$0).getCurrentAccountUin());
      }
      boolean bool2 = this.this$0.a(true);
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, " isSettingOpen: " + bool2);
      }
      if ((!bool1) && (bool2))
      {
        this.this$0.a(localAcsMsg.title, localAcsMsg.msg_id);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ActivateFriends.Manager", 2, "the msg " + localAcsMsg.title + " has notifaction!!!");
      break;
      Object localObject1 = ambl.a(this.this$0).a().b(aljq.ad, 9002);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if ((localObject2 instanceof MessageForText))
          {
            localObject2 = (MessageForText)localObject2;
            ambl.a(this.this$0).a().a((MessageRecord)localObject2, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.5
 * JD-Core Version:    0.7.0.1
 */