package com.tencent.mobileqq.app;

import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.imcore.message.facade.unread.count.UnreadCountUtil;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.util.api.IBadgeCountInjector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class AppBadgeCountInjector
  implements IBadgeCountInjector
{
  public int a()
  {
    Object localObject1 = MobileQQ.sMobileQQ.peekAppRuntime();
    boolean bool = localObject1 instanceof QQAppInterface;
    int j = 0;
    if (bool)
    {
      localObject1 = (QQAppInterface)localObject1;
      Object localObject2 = ((QQAppInterface)localObject1).getCallFacade();
      int i = j;
      if (localObject2 != null)
      {
        i = j;
        if (!((QQAppInterface)localObject1).getAVNotifyCenter().j())
        {
          j = ((QCallFacade)localObject2).a();
          i = j;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("callUnread: ");
            ((StringBuilder)localObject2).append(j);
            QLog.d("AppBadgeCountInjector", 2, ((StringBuilder)localObject2).toString());
            i = j;
          }
        }
      }
      return UnreadCountUtil.a((QQAppInterface)localObject1, ((QQAppInterface)localObject1).getApplicationContext()) + i + ((INewFriendService)((QQAppInterface)localObject1).getRuntimeService(INewFriendService.class)).getAllUnreadMessageCount();
    }
    if (QLog.isColorLevel()) {
      QLog.e("AppBadgeCountInjector", 2, "not appinterface");
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.AppBadgeCountInjector
 * JD-Core Version:    0.7.0.1
 */