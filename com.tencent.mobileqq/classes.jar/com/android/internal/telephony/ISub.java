package com.android.internal.telephony;

import android.os.IInterface;
import android.telephony.SubscriptionInfo;
import java.util.List;

public abstract interface ISub
  extends IInterface
{
  public abstract int a();
  
  public abstract int a(int paramInt);
  
  public abstract int a(int paramInt1, int paramInt2);
  
  public abstract int a(String paramString, int paramInt);
  
  public abstract int a(String paramString, int paramInt, long paramLong);
  
  public abstract SubscriptionInfo a(int paramInt, String paramString);
  
  public abstract SubscriptionInfo a(String paramString1, String paramString2);
  
  public abstract List<SubscriptionInfo> a(String paramString);
  
  public abstract void a(int paramInt, String paramString1, String paramString2);
  
  public abstract int b();
  
  public abstract int b(int paramInt1, int paramInt2);
  
  public abstract int b(String paramString);
  
  public abstract int b(String paramString, int paramInt);
  
  public abstract SubscriptionInfo b(int paramInt, String paramString);
  
  public abstract String b(int paramInt, String paramString1, String paramString2);
  
  public abstract int[] b(int paramInt);
  
  public abstract int c();
  
  public abstract int c(int paramInt);
  
  public abstract int c(String paramString, int paramInt);
  
  public abstract List<SubscriptionInfo> c(String paramString);
  
  public abstract int d();
  
  public abstract int d(String paramString);
  
  public abstract void d(int paramInt);
  
  public abstract int e();
  
  public abstract void e(int paramInt);
  
  public abstract int f();
  
  public abstract void f(int paramInt);
  
  public abstract int g(int paramInt);
  
  public abstract void g();
  
  public abstract boolean h(int paramInt);
  
  public abstract int[] h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.android.internal.telephony.ISub
 * JD-Core Version:    0.7.0.1
 */