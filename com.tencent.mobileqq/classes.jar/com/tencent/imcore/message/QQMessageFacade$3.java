package com.tencent.imcore.message;

import com.tencent.mobileqq.activity.ChatActivityFacade.HongbaoParams;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;

class QQMessageFacade$3
  implements Runnable
{
  QQMessageFacade$3(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList paramArrayList, ChatActivityFacade.HongbaoParams paramHongbaoParams) {}
  
  public void run()
  {
    this.a.getMsgHandler().E().a(this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.3
 * JD-Core Version:    0.7.0.1
 */