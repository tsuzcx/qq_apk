package com.tencent.avcore.util;

import java.util.List;

public class ArrayUtils
{
  public static <T> boolean contains(List<T> paramList, T paramT)
  {
    boolean bool = false;
    if (paramList == null) {
      return false;
    }
    if (paramList.indexOf(paramT) >= 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    return indexOf(paramArrayOfInt, paramInt) != -1;
  }
  
  public static boolean contains(Object[] paramArrayOfObject, Object paramObject)
  {
    return indexOf(paramArrayOfObject, paramObject) != -1;
  }
  
  public static int indexOf(int[] paramArrayOfInt, int paramInt)
  {
    return indexOf(paramArrayOfInt, paramInt, 0);
  }
  
  public static int indexOf(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null) {
      return -1;
    }
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    while (i < paramArrayOfInt.length)
    {
      if (paramInt1 == paramArrayOfInt[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static int indexOf(Object[] paramArrayOfObject, Object paramObject)
  {
    return indexOf(paramArrayOfObject, paramObject, 0);
  }
  
  public static int indexOf(Object[] paramArrayOfObject, Object paramObject, int paramInt)
  {
    if (paramArrayOfObject == null) {
      return -1;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (paramObject == null) {
      while (i < paramArrayOfObject.length)
      {
        if (paramArrayOfObject[i] == null) {
          return i;
        }
        i += 1;
      }
    }
    if (paramArrayOfObject.getClass().getComponentType().isInstance(paramObject)) {
      while (i < paramArrayOfObject.length)
      {
        if (paramObject.equals(paramArrayOfObject[i])) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static int lastIndexOf(Object[] paramArrayOfObject, Object paramObject)
  {
    return lastIndexOf(paramArrayOfObject, paramObject, 2147483647);
  }
  
  public static int lastIndexOf(Object[] paramArrayOfObject, Object paramObject, int paramInt)
  {
    if (paramArrayOfObject == null) {
      return -1;
    }
    if (paramInt < 0) {
      return -1;
    }
    int i = paramInt;
    if (paramInt >= paramArrayOfObject.length) {
      i = paramArrayOfObject.length - 1;
    }
    if (paramObject == null) {
      while (i >= 0)
      {
        if (paramArrayOfObject[i] == null) {
          return i;
        }
        i -= 1;
      }
    }
    if (paramArrayOfObject.getClass().getComponentType().isInstance(paramObject)) {
      while (i >= 0)
      {
        if (paramObject.equals(paramArrayOfObject[i])) {
          return i;
        }
        i -= 1;
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.util.ArrayUtils
 * JD-Core Version:    0.7.0.1
 */