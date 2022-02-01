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
  
  public abstract int a(String paramString);
  
  public abstract int a(String paramString, int paramInt);
  
  public abstract int a(String paramString, int paramInt, long paramLong);
  
  public abstract SubscriptionInfo a(int paramInt, String paramString);
  
  public abstract SubscriptionInfo a(String paramString1, String paramString2);
  
  public abstract String a(int paramInt, String paramString1, String paramString2);
  
  public abstract List<SubscriptionInfo> a(String paramString);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, String paramString1, String paramString2);
  
  public abstract boolean a(int paramInt);
  
  public abstract int[] a();
  
  public abstract int[] a(int paramInt);
  
  public abstract int b();
  
  public abstract int b(int paramInt);
  
  public abstract int b(int paramInt1, int paramInt2);
  
  public abstract int b(String paramString);
  
  public abstract int b(String paramString, int paramInt);
  
  public abstract SubscriptionInfo b(int paramInt, String paramString);
  
  public abstract List<SubscriptionInfo> b(String paramString);
  
  public abstract void b(int paramInt);
  
  public abstract int c();
  
  public abstract int c(int paramInt);
  
  public abstract int c(String paramString, int paramInt);
  
  public abstract void c(int paramInt);
  
  public abstract int d();
  
  public abstract int e();
  
  public abstract int f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.android.internal.telephony.ISub
 * JD-Core Version:    0.7.0.1
 */