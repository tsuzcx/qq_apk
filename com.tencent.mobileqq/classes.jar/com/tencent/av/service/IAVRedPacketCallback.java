package com.tencent.av.service;

import android.os.IInterface;

public abstract interface IAVRedPacketCallback
  extends IInterface
{
  public abstract void a(boolean paramBoolean, AVRedPacketConfig paramAVRedPacketConfig);
  
  public abstract void a(boolean paramBoolean, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.service.IAVRedPacketCallback
 * JD-Core Version:    0.7.0.1
 */