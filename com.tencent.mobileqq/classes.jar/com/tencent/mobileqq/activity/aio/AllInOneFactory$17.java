package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

final class AllInOneFactory$17
  implements AllInOneFactory.AllInOneSupplier
{
  public ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = new ProfileActivity.AllInOne(paramSessionInfo.a, 115);
    paramQQAppInterface.h = paramSessionInfo.d;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AllInOneFactory.17
 * JD-Core Version:    0.7.0.1
 */