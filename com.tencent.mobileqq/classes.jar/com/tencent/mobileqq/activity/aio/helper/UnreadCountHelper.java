package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.PushNotificationManager;
import com.tencent.qphone.base.util.QLog;

public class UnreadCountHelper
  implements ILifeCycleHelper
{
  private QQAppInterface a;
  private Context b;
  private Activity c;
  private BaseChatPie d;
  private SessionInfo e;
  private int f = 0;
  
  public UnreadCountHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie.d;
    this.b = paramBaseChatPie.e;
    this.c = paramBaseChatPie.f;
    this.d = paramBaseChatPie;
    this.e = paramBaseChatPie.ah;
  }
  
  private void b()
  {
    if (this.f > 0)
    {
      PushNotificationManager localPushNotificationManager = (PushNotificationManager)this.a.getManager(QQManagerFactory.PUSH_NOTIFICATION_MANAGER);
      if (localPushNotificationManager != null)
      {
        int i = this.e.a;
        if (i != 0)
        {
          if ((i != 1) && (i != 3000)) {
            return;
          }
          localPushNotificationManager.a(this.e, PushNotificationManager.c);
          return;
        }
        localPushNotificationManager.a(this.e, PushNotificationManager.b);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("UnreadCountHelper", 2, "PushNotificationManager is null");
      }
    }
  }
  
  public Runnable a()
  {
    return new UnreadCountHelper.1(this);
  }
  
  public String getTag()
  {
    return "UnreadCountHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 8) {
      return;
    }
    this.f = this.a.getConversationFacade().a(this.e.b, this.e.a);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.UnreadCountHelper
 * JD-Core Version:    0.7.0.1
 */