package com.huawei.hms.common.internal;

public final class Asserter
{
  private Asserter()
  {
    throw new AssertionError("Cannot use constructor to make a new instance");
  }
  
  public static void checkNotNull(Object paramObject)
  {
    if (paramObject != null) {
      return;
    }
    throw new IllegalArgumentException("checked object is null");
  }
  
  public static void checkNotNull(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null) {
      return;
    }
    throw new IllegalArgumentException(paramObject2.toString());
  }
  
  public static void checkNull(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.toString());
    localStringBuilder.append(" is not null");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static void checkState(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.Asserter
 * JD-Core Version:    0.7.0.1
 */