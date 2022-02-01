package com.tencent.mobileqq.activity.aio.rebuild;

import ahgz;
import amtp;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class HotChatPie$9
  implements Runnable
{
  public HotChatPie$9(ahgz paramahgz) {}
  
  public void run()
  {
    ((amtp)this.this$0.app.getBusinessHandler(35)).a(this.this$0.app.getLongAccountUin(), this.this$0.sessionInfo.curFriendUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.9
 * JD-Core Version:    0.7.0.1
 */