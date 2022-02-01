package com.tencent.imcore.message;

import mqq.app.AppRuntime;

public abstract interface MessageRecordCursor$Callback
{
  public abstract Object a(String paramString, AppRuntime paramAppRuntime);
  
  public abstract Object a(AppRuntime paramAppRuntime, String paramString, int paramInt);
  
  public abstract Object a(AppRuntime paramAppRuntime, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.MessageRecordCursor.Callback
 * JD-Core Version:    0.7.0.1
 */