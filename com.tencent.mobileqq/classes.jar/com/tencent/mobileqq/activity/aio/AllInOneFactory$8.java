package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;

final class AllInOneFactory$8
  implements AllInOneFactory.AllInOneSupplier
{
  public ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    paramString = new ProfileActivity.AllInOne(paramMessageRecord.senderuin, 21);
    paramString.l = 11;
    paramString.h = ContactUtils.g(paramQQAppInterface, paramSessionInfo.b, paramMessageRecord.senderuin);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AllInOneFactory.8
 * JD-Core Version:    0.7.0.1
 */