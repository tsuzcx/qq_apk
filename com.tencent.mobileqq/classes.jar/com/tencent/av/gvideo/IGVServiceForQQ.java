package com.tencent.av.gvideo;

import android.app.Notification;
import android.os.IInterface;
import com.tencent.av.service.IAVServiceCallback;

public abstract interface IGVServiceForQQ
  extends IInterface
{
  public abstract int a(long paramLong, int paramInt);
  
  public abstract void a();
  
  public abstract void a(IAVServiceCallback paramIAVServiceCallback);
  
  public abstract void a(boolean paramBoolean, Notification paramNotification);
  
  public abstract void a(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gvideo.IGVServiceForQQ
 * JD-Core Version:    0.7.0.1
 */