package com.tencent.av.service;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface IQQServiceCallback
  extends IInterface
{
  public abstract Bundle a(String paramString, int paramInt1, int paramInt2, Bundle paramBundle);
  
  public abstract void a(RecvMsg paramRecvMsg);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void a(String paramString, int paramInt, byte[] paramArrayOfByte);
  
  public abstract void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.IQQServiceCallback
 * JD-Core Version:    0.7.0.1
 */