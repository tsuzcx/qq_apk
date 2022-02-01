package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.utils.ContactUtils;

final class AllInOneFactory$8
  implements AllInOneFactory.AllInOneSupplier
{
  public AllInOne a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    paramString = new AllInOne(paramMessageRecord.senderuin, 21);
    paramString.subSourceId = 11;
    paramString.nickname = ContactUtils.b(paramQQAppInterface, paramSessionInfo.b, paramMessageRecord.senderuin);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AllInOneFactory.8
 * JD-Core Version:    0.7.0.1
 */