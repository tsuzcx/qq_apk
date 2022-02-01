package com.tencent.mobileqq.activity.aio.rebuild;

import ahey;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class ConfessChatPie$4
  implements Runnable
{
  public ConfessChatPie$4(ahey paramahey) {}
  
  public void run()
  {
    this.this$0.app.getMessageFacade().getAndParseAIOList(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, this.this$0.sessionInfo.topicId, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.4
 * JD-Core Version:    0.7.0.1
 */