package com.tencent.imcore.message.facade.unread.count;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract interface UnreadCountCalculateStrategy
{
  public abstract int a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, StringBuilder paramStringBuilder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.count.UnreadCountCalculateStrategy
 * JD-Core Version:    0.7.0.1
 */