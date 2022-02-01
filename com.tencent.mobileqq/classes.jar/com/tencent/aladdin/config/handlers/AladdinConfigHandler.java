package com.tencent.aladdin.config.handlers;

public abstract interface AladdinConfigHandler
{
  public abstract boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onWipeConfig(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.handlers.AladdinConfigHandler
 * JD-Core Version:    0.7.0.1
 */