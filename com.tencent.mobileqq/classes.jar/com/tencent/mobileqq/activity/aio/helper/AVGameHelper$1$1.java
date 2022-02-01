package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.avgame.business.observer.AvGameRoomListObserver.BatchGetGroupGameRoomListResult;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.tips.AVGameStatusTipsBar;
import java.util.List;

class AVGameHelper$1$1
  implements Runnable
{
  AVGameHelper$1$1(AVGameHelper.1 param1, AvGameRoomListObserver.BatchGetGroupGameRoomListResult paramBatchGetGroupGameRoomListResult) {}
  
  public void run()
  {
    AvGameRoomListObserver.BatchGetGroupGameRoomListResult localBatchGetGroupGameRoomListResult = this.a;
    if ((localBatchGetGroupGameRoomListResult != null) && (localBatchGetGroupGameRoomListResult.a != null) && (AVGameHelper.a(this.b.a).b.equals(this.a.a)))
    {
      if (AVGameHelper.b(this.b.a) == null) {
        return;
      }
      if ((this.a.b != null) && (this.a.b.size() > 0))
      {
        AVGameHelper.b(this.b.a).a(this.a.b, this.a.c);
        return;
      }
      AVGameHelper.b(this.b.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.1
 * JD-Core Version:    0.7.0.1
 */