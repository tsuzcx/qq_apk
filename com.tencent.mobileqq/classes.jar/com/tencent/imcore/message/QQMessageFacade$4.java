package com.tencent.imcore.message;

import adml;
import aopk;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;

class QQMessageFacade$4
  implements Runnable
{
  QQMessageFacade$4(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList paramArrayList, adml paramadml) {}
  
  public void run()
  {
    this.val$app.getMsgHandler().a().a(this.val$mr, this.val$uinList, this.val$params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.4
 * JD-Core Version:    0.7.0.1
 */