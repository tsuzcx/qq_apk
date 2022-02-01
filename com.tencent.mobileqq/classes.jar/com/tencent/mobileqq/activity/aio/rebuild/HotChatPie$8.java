package com.tencent.mobileqq.activity.aio.rebuild;

import aibs;
import anwq;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.HotChatInfo;

public class HotChatPie$8
  implements Runnable
{
  public HotChatPie$8(aibs paramaibs) {}
  
  public void run()
  {
    int i = this.this$0.a.state;
    anwq.a(this.this$0.app, this.this$0.sessionInfo.curFriendUin, i);
    anwq.a(this.this$0.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.8
 * JD-Core Version:    0.7.0.1
 */