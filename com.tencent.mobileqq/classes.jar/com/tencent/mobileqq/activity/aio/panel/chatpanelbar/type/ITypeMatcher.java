package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract interface ITypeMatcher
{
  public abstract boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type.ITypeMatcher
 * JD-Core Version:    0.7.0.1
 */