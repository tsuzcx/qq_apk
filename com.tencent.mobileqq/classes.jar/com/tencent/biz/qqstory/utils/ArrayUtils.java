package com.tencent.biz.qqstory.utils;

public class ArrayUtils
{
  public static String a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramArrayOfInt[0]);
    int i = 1;
    while (i < paramArrayOfInt.length)
    {
      localStringBuilder.append(",");
      localStringBuilder.append(paramArrayOfInt[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ArrayUtils
 * JD-Core Version:    0.7.0.1
 */