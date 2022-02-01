package com.tencent.mobileqq.activity.contacts.topentry;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class CardUtil
{
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramQQAppInterface.getAccount(), "sp_key_card_redpoint_count", Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.i("CardUtil", 2, String.format("updateCardRedPoint count:%d", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CardUtil
 * JD-Core Version:    0.7.0.1
 */