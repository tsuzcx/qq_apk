package com.tencent.luggage.wxa.sd;

import android.os.Looper;
import android.os.Message;

public abstract interface a
{
  public abstract Looper a();
  
  public abstract Message a(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  
  public abstract void a(Object paramObject);
  
  public abstract boolean a(int paramInt);
  
  public abstract boolean a(int paramInt, long paramLong);
  
  public abstract boolean a(Message paramMessage, long paramLong);
  
  public abstract boolean a(Runnable paramRunnable);
  
  public abstract String b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(Runnable paramRunnable);
  
  public abstract boolean b(Message paramMessage);
  
  public abstract boolean b(Runnable paramRunnable, long paramLong);
  
  public abstract boolean c(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sd.a
 * JD-Core Version:    0.7.0.1
 */