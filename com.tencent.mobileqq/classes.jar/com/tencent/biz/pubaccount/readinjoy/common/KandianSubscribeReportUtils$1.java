package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import pkh;

public final class KandianSubscribeReportUtils$1
  implements Runnable
{
  public KandianSubscribeReportUtils$1(MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.a.extLong = 0;
    ((QQAppInterface)pkh.a()).getMessageFacade().updateMsgFieldByUniseq(this.a.frienduin, this.a.istroop, this.a.uniseq, "extLong", Integer.valueOf(this.a.extLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.KandianSubscribeReportUtils.1
 * JD-Core Version:    0.7.0.1
 */