package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import mqq.app.AppRuntime;

public abstract interface IMessageDecoder
{
  public abstract void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.IMessageDecoder
 * JD-Core Version:    0.7.0.1
 */