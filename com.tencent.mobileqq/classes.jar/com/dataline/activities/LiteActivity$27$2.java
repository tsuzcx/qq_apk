package com.dataline.activities;

import com.dataline.util.DatalineSessionAdapter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;

class LiteActivity$27$2
  implements Runnable
{
  LiteActivity$27$2(LiteActivity.27 param27, boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  public void run()
  {
    if (!this.a) {
      this.e.a.a(1048576L);
    }
    DataLineMsgRecord localDataLineMsgRecord = this.e.a.app.getMessageFacade().d(this.b).a(this.c);
    DataLineMsgSet localDataLineMsgSet = this.e.a.app.getDataLineMsgProxy(this.b).c(this.c);
    if ((localDataLineMsgSet != null) && (!localDataLineMsgSet.isSingle()))
    {
      if (!this.e.a.m.a(this.c, this.e.a.f)) {
        this.e.a.m.notifyDataSetChanged();
      }
    }
    else
    {
      this.e.a.m.notifyDataSetChanged();
      if ((localDataLineMsgRecord != null) && (!localDataLineMsgRecord.bIsResendOrRecvFile))
      {
        LiteActivity.a(this.e.a.g, this.e.a.f);
        LiteActivity.a(this.e.a.f);
      }
    }
    this.e.a.app.getMessageFacade().d(this.b).g();
    if (QLog.isColorLevel())
    {
      String str = LiteActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LiteActivity.onRecvFile, msgId[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("], sPath = ");
      localStringBuilder.append(this.d);
      localStringBuilder.append("], set[");
      localStringBuilder.append(localDataLineMsgSet);
      localStringBuilder.append("], msgItem[");
      localStringBuilder.append(localDataLineMsgRecord);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.2
 * JD-Core Version:    0.7.0.1
 */