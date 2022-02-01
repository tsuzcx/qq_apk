package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.utils.ContactUtils;

final class AllInOneFactory$5
  implements AllInOneFactory.AllInOneSupplier
{
  public AllInOne a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    paramSessionInfo = new AllInOne(paramString, 70);
    paramSessionInfo.nickname = ContactUtils.c(paramQQAppInterface, paramString);
    return paramSessionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AllInOneFactory.5
 * JD-Core Version:    0.7.0.1
 */