package com.tencent.mobileqq.app;

import android.support.annotation.NonNull;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.imcore.message.facade.unread.count.UnreadCountUtil;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.util.api.IBadgeCountInjector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class AppBadgeCountInjector
  implements IBadgeCountInjector
{
  private int a(@NonNull QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (IGuildUnreadCntService)paramQQAppInterface.getRuntimeService(IGuildUnreadCntService.class, "");
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAllGuildAtUnreadCntInfo();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.b == 1)) {
        return (int)paramQQAppInterface.a;
      }
    }
    return 0;
  }
  
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
        if (!((QQAppInterface)localObject1).getAVNotifyCenter().C())
        {
          j = ((QCallFacade)localObject2).b();
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
      return UnreadCountUtil.a((QQAppInterface)localObject1, ((QQAppInterface)localObject1).getApplicationContext()) + i + a((QQAppInterface)localObject1) + ((INewFriendService)((QQAppInterface)localObject1).getRuntimeService(INewFriendService.class)).getAllUnreadMessageCount();
    }
    if (QLog.isColorLevel()) {
      QLog.e("AppBadgeCountInjector", 2, "not appinterface");
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.AppBadgeCountInjector
 * JD-Core Version:    0.7.0.1
 */