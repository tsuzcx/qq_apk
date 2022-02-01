package com.tencent.luggage.wxa.hv;

import java.util.Iterator;

public abstract interface c
{
  public abstract c a(String paramString, double paramDouble);
  
  public abstract c a(String paramString, int paramInt);
  
  public abstract c a(String paramString, long paramLong);
  
  public abstract c a(String paramString, Object paramObject);
  
  public abstract c a(String paramString, boolean paramBoolean);
  
  public abstract String a(String paramString);
  
  public abstract a b(String paramString);
  
  public abstract c b(String paramString, Object paramObject);
  
  public abstract a c(String paramString);
  
  public abstract c d(String paramString);
  
  public abstract c e(String paramString);
  
  public abstract Object get(String paramString);
  
  public abstract boolean getBoolean(String paramString);
  
  public abstract double getDouble(String paramString);
  
  public abstract int getInt(String paramString);
  
  public abstract long getLong(String paramString);
  
  public abstract String getString(String paramString);
  
  public abstract boolean has(String paramString);
  
  public abstract boolean isNull(String paramString);
  
  public abstract Iterator<String> keys();
  
  public abstract int length();
  
  public abstract Object opt(String paramString);
  
  public abstract boolean optBoolean(String paramString, boolean paramBoolean);
  
  public abstract double optDouble(String paramString, double paramDouble);
  
  public abstract int optInt(String paramString, int paramInt);
  
  public abstract long optLong(String paramString, long paramLong);
  
  public abstract String optString(String paramString);
  
  public abstract String optString(String paramString1, String paramString2);
  
  public abstract Object remove(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hv.c
 * JD-Core Version:    0.7.0.1
 */