package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

final class AllInOneFactory$3
  implements AllInOneFactory.AllInOneSupplier
{
  public ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 86);
    paramQQAppInterface.h = paramSessionInfo.d;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AllInOneFactory.3
 * JD-Core Version:    0.7.0.1
 */