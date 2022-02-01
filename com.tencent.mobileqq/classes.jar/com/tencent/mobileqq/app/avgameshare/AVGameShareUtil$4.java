package com.tencent.mobileqq.app.avgameshare;

import com.tencent.avgame.gamelogic.observer.GameRoomObserver;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class AVGameShareUtil$4
  extends GameRoomObserver
{
  AVGameShareUtil$4(AVGameShareUtil paramAVGameShareUtil, long paramLong, Map paramMap, BaseAVGameAppInterface paramBaseAVGameAppInterface, AVGameShareUtil.AVGameShareProxy paramAVGameShareProxy) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramLong != this.a)
    {
      QLog.e("GameRoomObserver", 1, "onGameShare fail: observer not match");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGameShare isSuccess: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" shareUrl: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" mark: ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("GameRoomObserver", 1, ((StringBuilder)localObject).toString());
    localObject = (GameRoomObserver)this.b.remove(Long.valueOf(this.a));
    if (localObject == null)
    {
      QLog.e("GameRoomObserver", 1, "onGameShare fail: observer not exist");
      return;
    }
    this.c.removeObserver((BusinessObserver)localObject);
    localObject = this.d;
    if (localObject != null) {
      try
      {
        ((AVGameShareUtil.AVGameShareProxy)localObject).a(paramBoolean, paramString);
        return;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGameShare exception: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.e("GameRoomObserver", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.4
 * JD-Core Version:    0.7.0.1
 */