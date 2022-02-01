package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;

public abstract interface IAIOImageProvider
  extends IInterface
{
  public abstract int a(long paramLong, int paramInt);
  
  public abstract String a(String paramString1, String paramString2);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void a(long paramLong, int paramInt, Bundle paramBundle);
  
  public abstract void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack);
  
  public abstract void a(MessageForShortVideo paramMessageForShortVideo);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract Intent b(long paramLong, int paramInt);
  
  public abstract MessageForShortVideo b(long paramLong);
  
  public abstract void b(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void b(String paramString, int paramInt);
  
  public abstract void b(long[] paramArrayOfLong);
  
  public abstract Intent c(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void c();
  
  public abstract void c(long paramLong);
  
  public abstract void c(long paramLong, int paramInt);
  
  public abstract void d(long paramLong);
  
  public abstract void e(long paramLong);
  
  public abstract void f(long paramLong);
  
  public abstract void g(long paramLong);
  
  public abstract void h(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider
 * JD-Core Version:    0.7.0.1
 */