package com.tencent.mobileqq.activity.aio.rebuild;

import ahik;
import anca;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyChatPie$14
  implements Runnable
{
  public NearbyChatPie$14(ahik paramahik) {}
  
  public void run()
  {
    if (!ahik.a(this.this$0)) {
      ((anca)this.this$0.app.getBusinessHandler(20)).s(this.this$0.sessionInfo.curFriendUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.14
 * JD-Core Version:    0.7.0.1
 */