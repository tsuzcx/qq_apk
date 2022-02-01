package com.tencent.mobileqq.activity.aio.core;

import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class FriendChatPie$3
  implements Runnable
{
  FriendChatPie$3(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    AVNotifyCenter localAVNotifyCenter = this.this$0.d.getAVNotifyCenter();
    if (this.this$0.ah == null) {
      return;
    }
    if (this.this$0.ah.a != 0) {
      return;
    }
    if (this.this$0.ah.b == null) {
      return;
    }
    try
    {
      long l = Long.valueOf(this.this$0.ah.b).longValue();
      if (localAVNotifyCenter.b(l))
      {
        FriendChatPie localFriendChatPie = this.this$0;
        localFriendChatPie.a(localFriendChatPie.ah.a, this.this$0.ah.b, this.this$0.ah.e, this.this$0.ah.f, localAVNotifyCenter.a(Long.valueOf(this.this$0.ah.b).longValue()));
        localAVNotifyCenter.a(Long.valueOf(this.this$0.ah.b).longValue(), false, -1);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.3
 * JD-Core Version:    0.7.0.1
 */