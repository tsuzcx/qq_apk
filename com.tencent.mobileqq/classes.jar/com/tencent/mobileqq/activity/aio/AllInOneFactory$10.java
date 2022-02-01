package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

final class AllInOneFactory$10
  implements AllInOneFactory.AllInOneSupplier
{
  public ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = new ProfileActivity.AllInOne(paramMessageRecord.frienduin, 47);
    paramQQAppInterface.h = paramSessionInfo.d;
    paramQQAppInterface.e = paramSessionInfo.b;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AllInOneFactory.10
 * JD-Core Version:    0.7.0.1
 */