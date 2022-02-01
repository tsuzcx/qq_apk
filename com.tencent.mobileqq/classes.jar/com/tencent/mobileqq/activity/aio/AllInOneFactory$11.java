package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.data.AllInOne;

final class AllInOneFactory$11
  implements AllInOneFactory.AllInOneSupplier
{
  public AllInOne a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = new AllInOne(paramMessageRecord.senderuin, 2);
    paramQQAppInterface.nickname = paramSessionInfo.e;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AllInOneFactory.11
 * JD-Core Version:    0.7.0.1
 */