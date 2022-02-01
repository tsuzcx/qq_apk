package com.tencent.imcore.message.core;

import com.tencent.mobileqq.data.ConversationInfo;

public abstract interface GetUnreadMsgNumCallback
{
  public abstract int a(String paramString, StringBuilder paramStringBuilder);
  
  public abstract boolean a(ConversationInfo paramConversationInfo);
  
  public abstract boolean a(ConversationInfo paramConversationInfo, boolean[] paramArrayOfBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.core.GetUnreadMsgNumCallback
 * JD-Core Version:    0.7.0.1
 */