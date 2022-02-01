package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.os.Message;
import bgkf;
import bgkl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class TroopChatPie$16
  implements Runnable
{
  TroopChatPie$16(TroopChatPie paramTroopChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    bgkl localbgkl = ((bgkf)this.this$0.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.this$0.sessionInfo.curFriendUin, this.a);
    Message localMessage = this.this$0.b.obtainMessage(2);
    localMessage.obj = localbgkl;
    this.this$0.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.16
 * JD-Core Version:    0.7.0.1
 */