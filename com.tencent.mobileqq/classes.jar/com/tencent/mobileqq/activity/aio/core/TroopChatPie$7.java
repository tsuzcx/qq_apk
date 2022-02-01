package com.tencent.mobileqq.activity.aio.core;

import azkq;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.PicPreDownloader;

class TroopChatPie$7
  implements Runnable
{
  TroopChatPie$7(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (this.this$0.sessionInfo != null)
    {
      String str = this.this$0.sessionInfo.curFriendUin;
      this.this$0.app.getPicPreDownloader().a.b(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.7
 * JD-Core Version:    0.7.0.1
 */