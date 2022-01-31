package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.IInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;

public abstract interface IAIOImageProvider
  extends IInterface
{
  public abstract Intent a(long paramLong, int paramInt);
  
  public abstract Intent a(long paramLong, int paramInt1, int paramInt2);
  
  public abstract MessageForShortVideo a(long paramLong);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong);
  
  public abstract void a(long paramLong, int paramInt);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void b(long paramLong);
  
  public abstract void b(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void c();
  
  public abstract void c(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider
 * JD-Core Version:    0.7.0.1
 */