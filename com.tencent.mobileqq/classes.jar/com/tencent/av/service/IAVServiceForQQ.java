package com.tencent.av.service;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.IInterface;

public abstract interface IAVServiceForQQ
  extends IInterface
{
  public abstract int a(long paramLong, int paramInt);
  
  public abstract AVPbInfo a(byte[] paramArrayOfByte);
  
  public abstract void a();
  
  public abstract void a(long paramLong);
  
  public abstract void a(long paramLong, String paramString);
  
  public abstract void a(IAVServiceCallback paramIAVServiceCallback);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, Bitmap paramBitmap);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, Notification paramNotification);
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public abstract void b();
  
  public abstract void b(byte[] paramArrayOfByte);
  
  public abstract void c();
  
  public abstract void c(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.service.IAVServiceForQQ
 * JD-Core Version:    0.7.0.1
 */