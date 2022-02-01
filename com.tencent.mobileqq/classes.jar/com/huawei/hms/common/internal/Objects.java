package com.huawei.hms.common.internal;

import java.util.Arrays;

public final class Objects
{
  private Objects()
  {
    throw new AssertionError("Uninstantiable");
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {}
    while ((paramObject1 != null) && (paramObject1.equals(paramObject2))) {
      return true;
    }
    return false;
  }
  
  public static int hashCode(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static Objects.ToStringHelper toStringHelper(Object paramObject)
  {
    return new Objects.ToStringHelper(paramObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.Objects
 * JD-Core Version:    0.7.0.1
 */