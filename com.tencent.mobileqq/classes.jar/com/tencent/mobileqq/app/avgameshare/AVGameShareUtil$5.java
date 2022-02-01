package com.tencent.mobileqq.app.avgameshare;

import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class AVGameShareUtil$5
  extends AvGameRoomListObserver
{
  AVGameShareUtil$5(AVGameShareUtil paramAVGameShareUtil, long paramLong, Map paramMap, AppInterface paramAppInterface, AVGameShareUtil.AVGameShareProxy paramAVGameShareProxy) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong3 != this.a)
    {
      QLog.e("AvGameRoomListObserver", 1, "onShareInviteBackflow fail: observer not match");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onShareInviteBackflow isSuccess: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" roomId: ");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" shareUin: ");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("");
    ((StringBuilder)localObject).append(AuthorityUtil.a(localStringBuilder.toString()));
    ((StringBuilder)localObject).append(" mark: ");
    ((StringBuilder)localObject).append(paramLong3);
    ((StringBuilder)localObject).append(" shareType: ");
    ((StringBuilder)localObject).append(paramLong4);
    QLog.d("AvGameRoomListObserver", 1, ((StringBuilder)localObject).toString());
    localObject = (AvGameRoomListObserver)this.c.remove(Long.valueOf(this.a));
    if (localObject == null)
    {
      QLog.e("AvGameRoomListObserver", 1, "onShareInviteBackflow fail: observer not exist");
      return;
    }
    this.d.removeObserver((BusinessObserver)localObject);
    localObject = this.e;
    if (localObject != null) {
      try
      {
        ((AVGameShareUtil.AVGameShareProxy)localObject).a(paramBoolean, paramLong1, paramLong2, paramLong4);
        return;
      }
      catch (Exception localException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onShareInviteBackflow exception: ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("AvGameRoomListObserver", 1, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.5
 * JD-Core Version:    0.7.0.1
 */