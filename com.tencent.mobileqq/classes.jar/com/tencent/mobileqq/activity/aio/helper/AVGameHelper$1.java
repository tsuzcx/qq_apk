package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.business.observer.AvGameRoomListObserver.BatchGetGroupGameRoomListResult;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AVGameHelper$1
  extends AvGameRoomListObserver
{
  AVGameHelper$1(AVGameHelper paramAVGameHelper) {}
  
  public void a(int paramInt, String paramString, AvGameRoomListObserver.BatchGetGroupGameRoomListResult paramBatchGetGroupGameRoomListResult)
  {
    ThreadManager.getUIHandler().post(new AVGameHelper.1.1(this, paramBatchGetGroupGameRoomListResult));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (AVGameHelper.a(this.a).b.equals(paramString1)))
    {
      paramString1 = (IAvGameManager)AVGameHelper.c(this.a).getRuntimeService(IAvGameManager.class, "");
      if (paramString1 != null) {
        paramString1.requestGameRoomListForGroup(AVGameHelper.a(this.a).b, 0, 1);
      }
    }
  }
  
  public void b(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (AVGameHelper.a(this.a).b.equals(paramString2)) && (AVGameHelper.b(this.a) != null)) {
      ThreadManager.getUIHandler().post(new AVGameHelper.1.2(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1
 * JD-Core Version:    0.7.0.1
 */