package com.dataline.activities;

import com.dataline.util.DatalineSessionAdapter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class LiteActivity$27$4
  implements Runnable
{
  LiteActivity$27$4(LiteActivity.27 param27, int paramInt, long paramLong) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.c.a.app.getMessageFacade().d(this.a).a(this.b);
    if (localDataLineMsgRecord == null) {
      return;
    }
    if (localDataLineMsgRecord.isSendFromLocal()) {
      return;
    }
    DataLineMsgSet localDataLineMsgSet = this.c.a.app.getDataLineMsgProxy(this.a).c(this.b);
    if ((localDataLineMsgSet != null) && (!localDataLineMsgSet.isSingle()))
    {
      if (!this.c.a.m.a(this.b, this.c.a.f)) {
        this.c.a.m.notifyDataSetChanged();
      }
    }
    else
    {
      this.c.a.m.notifyDataSetChanged();
      if (!localDataLineMsgRecord.bIsResendOrRecvFile)
      {
        LiteActivity.a(this.c.a.g, this.c.a.f);
        LiteActivity.a(this.c.a.f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.4
 * JD-Core Version:    0.7.0.1
 */