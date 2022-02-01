package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

abstract interface AllInOneFactory$AllInOneSupplier
{
  public abstract ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AllInOneFactory.AllInOneSupplier
 * JD-Core Version:    0.7.0.1
 */