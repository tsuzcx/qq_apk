package com.tencent.mobileqq.activity.aio.core;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import java.io.File;
import mqq.os.MqqHandler;

class BaseChatPie$13
  implements Runnable
{
  BaseChatPie$13(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (AIOMusicSkin.a().du_()) {
      return;
    }
    if ((ChatBackground.a(this.this$0.e, this.this$0.d.getCurrentAccountUin(), this.this$0.ah.b, true, 3, this.this$0.ah.H)) || (this.this$0.ah.H.c != this.this$0.ba.getBackground())) {
      this.this$0.m.sendMessage(this.this$0.m.obtainMessage(60, this.this$0.ah.H.c));
    }
    if (ChatBackgroundManager.b(new File(ChatBackgroundUtil.a(this.this$0.e, this.this$0.d.getCurrentAccountUin(), this.this$0.ah.b)))) {
      ThreadManager.getSubThreadHandler().postDelayed(new BaseChatPie.13.1(this), 2000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.13
 * JD-Core Version:    0.7.0.1
 */