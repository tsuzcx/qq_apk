package com.tencent.mobileqq.activity.aio.ecommerce;

import com.tencent.mobileqq.activity.aio.messageexpose.OnAIOMessageExposeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class ECommerceExposeBusiness
  implements OnAIOMessageExposeListener
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    ECommerceDataReportUtil.a(paramQQAppInterface, paramMessageRecord, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ecommerce.ECommerceExposeBusiness
 * JD-Core Version:    0.7.0.1
 */