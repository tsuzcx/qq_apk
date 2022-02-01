package com.tencent.mobileqq.activity.contacts.topentry;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.qphone.base.util.QLog;

public class CardUtil
{
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      NearbySPUtil.a(paramQQAppInterface.getAccount(), "sp_key_card_redpoint_count", Integer.valueOf(paramInt));
    } while (!QLog.isColorLevel());
    QLog.i("CardUtil", 2, String.format("updateCardRedPoint count:%d", new Object[] { Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CardUtil
 * JD-Core Version:    0.7.0.1
 */