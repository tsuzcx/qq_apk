package com.tencent.luggage.wxa.pw;

import androidx.annotation.Nullable;

public enum b
{
  public final int g;
  
  private b(int paramInt)
  {
    this.g = paramInt;
  }
  
  @Nullable
  public static b a(String paramString)
  {
    return (b)d.a(paramString, b.class);
  }
  
  public static b a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return f;
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pw.b
 * JD-Core Version:    0.7.0.1
 */