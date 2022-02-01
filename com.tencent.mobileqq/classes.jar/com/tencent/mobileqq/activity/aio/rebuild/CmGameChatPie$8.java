package com.tencent.mobileqq.activity.aio.rebuild;

import ahzc;
import amme;
import amuf;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class CmGameChatPie$8
  implements Runnable
{
  public CmGameChatPie$8(ahzc paramahzc) {}
  
  public void run()
  {
    ((amme)this.this$0.app.getManager(QQManagerFactory.APOLLO_MANAGER)).a().a(this.this$0.sessionInfo.curFriendUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.8
 * JD-Core Version:    0.7.0.1
 */