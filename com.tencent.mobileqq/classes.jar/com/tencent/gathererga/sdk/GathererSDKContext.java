package com.tencent.gathererga.sdk;

import com.tencent.gathererga.core.internal.BaseContext;

public class GathererSDKContext
  extends BaseContext
{
  private static final GathererSDKContext a = new GathererSDKContext();
  
  public static <T> T a(Class<T> paramClass)
  {
    return a.b(paramClass);
  }
  
  public static <T> void a(Class<T> paramClass, Class<?> paramClass1)
  {
    a.b(paramClass, paramClass1);
  }
  
  protected Object a(Class<?> paramClass, Object paramObject)
  {
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.sdk.GathererSDKContext
 * JD-Core Version:    0.7.0.1
 */