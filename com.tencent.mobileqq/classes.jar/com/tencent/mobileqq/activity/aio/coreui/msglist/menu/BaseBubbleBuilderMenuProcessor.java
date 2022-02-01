package com.tencent.mobileqq.activity.aio.coreui.msglist.menu;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class BaseBubbleBuilderMenuProcessor
{
  protected QQAppInterface a;
  protected SessionInfo b;
  
  public BaseBubbleBuilderMenuProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.a = paramQQAppInterface;
    this.b = paramSessionInfo;
  }
  
  public abstract boolean a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor
 * JD-Core Version:    0.7.0.1
 */