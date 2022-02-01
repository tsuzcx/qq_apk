package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import com.tencent.mobileqq.app.MessageObserver;

class BusinessCmrTmpChatPie$14
  extends MessageObserver
{
  BusinessCmrTmpChatPie$14(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void onGetMsgFin(boolean paramBoolean)
  {
    super.onGetMsgFin(paramBoolean);
    this.a.bP.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.14
 * JD-Core Version:    0.7.0.1
 */