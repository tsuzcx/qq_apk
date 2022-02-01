package com.tencent.mobileqq.activity.aio.core;

import aezp;
import bdav;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

class BaseChatPie$26$1
  implements Runnable
{
  BaseChatPie$26$1(BaseChatPie.26 param26) {}
  
  public void run()
  {
    if (bdav.a().c()) {}
    do
    {
      return;
      this.this$1.this$0.sessionInfo.chatBg.jdField_a_of_type_Boolean = false;
    } while (!aezp.a(this.this$1.this$0.mContext, this.this$1.this$0.app.getCurrentAccountUin(), this.this$1.this$0.sessionInfo.curFriendUin, true, 7, this.this$1.this$0.sessionInfo.chatBg));
    this.this$1.this$0.uiHandler.sendMessage(this.this$1.this$0.uiHandler.obtainMessage(60, this.this$1.this$0.sessionInfo.chatBg.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.26.1
 * JD-Core Version:    0.7.0.1
 */