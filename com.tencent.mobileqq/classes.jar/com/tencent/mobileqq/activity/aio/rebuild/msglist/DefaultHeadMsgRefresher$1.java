package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class DefaultHeadMsgRefresher$1
  implements Runnable
{
  DefaultHeadMsgRefresher$1(DefaultHeadMsgRefresher paramDefaultHeadMsgRefresher, AIOContext paramAIOContext, long paramLong1, int paramInt1, long paramLong2, int paramInt2, Runnable paramRunnable) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.a.a().getMessageFacade().b(this.a.O().b, this.a.O().a, this.b);
    this.a.b().runOnUiThread(new DefaultHeadMsgRefresher.1.1(this, localMessageRecord));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.DefaultHeadMsgRefresher.1
 * JD-Core Version:    0.7.0.1
 */