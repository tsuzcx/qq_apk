package com.tencent.biz.officialaccount;

import com.tencent.mobileqq.activity.aio.messageexpose.OnAIOMessageExposeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class OfficialAccountExposeBusiness
  implements OnAIOMessageExposeListener
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    OfficialAccountReporter.a.a(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.officialaccount.OfficialAccountExposeBusiness
 * JD-Core Version:    0.7.0.1
 */