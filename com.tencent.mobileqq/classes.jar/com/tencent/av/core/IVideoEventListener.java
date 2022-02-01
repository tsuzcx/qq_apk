package com.tencent.av.core;

import com.tencent.avcore.engine.dav.IDavEventListener;

public abstract interface IVideoEventListener
  extends IDavEventListener
{
  public abstract void a(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void a(String paramString, int paramInt, byte[] paramArrayOfByte);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2);
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public abstract void b(int paramInt, String paramString);
  
  public abstract void c(int paramInt, String paramString);
  
  public abstract void j(String paramString);
  
  public abstract void k(String paramString);
  
  public abstract void l(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.core.IVideoEventListener
 * JD-Core Version:    0.7.0.1
 */