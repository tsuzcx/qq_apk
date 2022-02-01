package com.tencent.featuretoggle.models;

import androidx.annotation.Nullable;

public class FeatureTypedTriggered<T>
{
  private int a;
  private String b;
  private String c;
  private int d;
  private String e;
  private String f;
  @Nullable
  private T g;
  private String h;
  
  @Nullable
  public T a()
  {
    return this.g;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(@Nullable T paramT)
  {
    this.g = paramT;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
  
  public void d(String paramString)
  {
    this.f = paramString;
  }
  
  public void e(String paramString)
  {
    this.h = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.models.FeatureTypedTriggered
 * JD-Core Version:    0.7.0.1
 */