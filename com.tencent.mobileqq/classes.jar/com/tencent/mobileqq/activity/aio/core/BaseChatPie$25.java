package com.tencent.mobileqq.activity.aio.core;

import afrb;
import android.view.ViewGroup;
import behu;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import java.io.File;
import mqq.os.MqqHandler;

class BaseChatPie$25
  implements Runnable
{
  BaseChatPie$25(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (behu.a().k_()) {}
    do
    {
      return;
      if ((afrb.a(this.this$0.mContext, this.this$0.app.getCurrentAccountUin(), this.this$0.sessionInfo.curFriendUin, true, 3, this.this$0.sessionInfo.chatBg)) || (this.this$0.sessionInfo.chatBg.a != this.this$0.afRoot.getBackground())) {
        this.this$0.uiHandler.sendMessage(this.this$0.uiHandler.obtainMessage(60, this.this$0.sessionInfo.chatBg.a));
      }
    } while (!ChatBackgroundManager.b(new File(afrb.a(this.this$0.mContext, this.this$0.app.getCurrentAccountUin(), this.this$0.sessionInfo.curFriendUin))));
    ThreadManager.getSubThreadHandler().postDelayed(new BaseChatPie.25.1(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.25
 * JD-Core Version:    0.7.0.1
 */