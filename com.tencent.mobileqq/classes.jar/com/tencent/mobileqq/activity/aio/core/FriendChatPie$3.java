package com.tencent.mobileqq.activity.aio.core;

import agab;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendChatPie$3
  implements Runnable
{
  public FriendChatPie$3(agab paramagab) {}
  
  public void run()
  {
    AVNotifyCenter localAVNotifyCenter = this.this$0.app.getAVNotifyCenter();
    if (this.this$0.sessionInfo == null) {}
    for (;;)
    {
      return;
      if ((this.this$0.sessionInfo.curType == 0) && (this.this$0.sessionInfo.curFriendUin != null)) {
        try
        {
          long l = Long.valueOf(this.this$0.sessionInfo.curFriendUin).longValue();
          if (localAVNotifyCenter.a(l))
          {
            this.this$0.a(this.this$0.sessionInfo.curType, this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curFriendNick, this.this$0.sessionInfo.phoneNum, localAVNotifyCenter.a(Long.valueOf(this.this$0.sessionInfo.curFriendUin).longValue()));
            localAVNotifyCenter.a(Long.valueOf(this.this$0.sessionInfo.curFriendUin).longValue(), false, -1);
            return;
          }
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.3
 * JD-Core Version:    0.7.0.1
 */