package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerApi;
import com.tencent.mobileqq.avatar.handler.AvatarHandler;

public class QQAvatarHandlerApiImpl
  implements IQQAvatarHandlerApi
{
  public static final String MESSAGE_HANDLER = AvatarHandler.class.getName();
  
  public String getClassName()
  {
    return MESSAGE_HANDLER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarHandlerApiImpl
 * JD-Core Version:    0.7.0.1
 */