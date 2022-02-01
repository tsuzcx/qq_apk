package com.tencent.biz.qcircleshadow.local;

import java.util.HashMap;
import java.util.Map;

final class QCircleLoggerFactory$MessageFormatter
{
  public static final QCircleLoggerFactory.FormattingTuple a(String paramString, Object paramObject)
  {
    return a(paramString, new Object[] { paramObject });
  }
  
  public static final QCircleLoggerFactory.FormattingTuple a(String paramString, Object paramObject1, Object paramObject2)
  {
    return a(paramString, new Object[] { paramObject1, paramObject2 });
  }
  
  public static final QCircleLoggerFactory.FormattingTuple a(String paramString, Object[] paramArrayOfObject)
  {
    Throwable localThrowable = a(paramArrayOfObject);
    Object[] arrayOfObject = paramArrayOfObject;
    if (localThrowable != null) {
      arrayOfObject = b(paramArrayOfObject);
    }
    return a(paramString, arrayOfObject, localThrowable);
  }
  
  public static final QCircleLoggerFactory.FormattingTuple a(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    if (paramString == null) {
      return new QCircleLoggerFactory.FormattingTuple(null, paramArrayOfObject, paramThrowable);
    }
    if (paramArrayOfObject == null) {
      return new QCircleLoggerFactory.FormattingTuple(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 50);
    int i = 0;
    int j = 0;
    while (i < paramArrayOfObject.length)
    {
      int k = paramString.indexOf("{}", j);
      if (k == -1)
      {
        if (j == 0) {
          return new QCircleLoggerFactory.FormattingTuple(paramString, paramArrayOfObject, paramThrowable);
        }
        localStringBuilder.append(paramString, j, paramString.length());
        return new QCircleLoggerFactory.FormattingTuple(localStringBuilder.toString(), paramArrayOfObject, paramThrowable);
      }
      if (a(paramString, k))
      {
        if (!b(paramString, k))
        {
          i -= 1;
          localStringBuilder.append(paramString, j, k - 1);
          localStringBuilder.append('{');
          j = k + 1;
          break label230;
        }
        localStringBuilder.append(paramString, j, k - 1);
        a(localStringBuilder, paramArrayOfObject[i], new HashMap());
      }
      else
      {
        localStringBuilder.append(paramString, j, k);
        a(localStringBuilder, paramArrayOfObject[i], new HashMap());
      }
      j = k + 2;
      label230:
      i += 1;
    }
    localStringBuilder.append(paramString, j, paramString.length());
    return new QCircleLoggerFactory.FormattingTuple(localStringBuilder.toString(), paramArrayOfObject, paramThrowable);
  }
  
  static final Throwable a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      if (paramArrayOfObject.length == 0) {
        return null;
      }
      paramArrayOfObject = paramArrayOfObject[(paramArrayOfObject.length - 1)];
      if ((paramArrayOfObject instanceof Throwable)) {
        return (Throwable)paramArrayOfObject;
      }
    }
    return null;
  }
  
  private static void a(StringBuilder paramStringBuilder, Object paramObject)
  {
    try
    {
      paramStringBuilder.append(paramObject.toString());
      return;
    }
    catch (Throwable paramObject)
    {
      label10:
      break label10;
    }
    paramStringBuilder.append("[FAILED toString()]");
  }
  
  private static void a(StringBuilder paramStringBuilder, Object paramObject, Map<Object[], Object> paramMap)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("null");
      return;
    }
    if (!paramObject.getClass().isArray())
    {
      a(paramStringBuilder, paramObject);
      return;
    }
    if ((paramObject instanceof boolean[]))
    {
      a(paramStringBuilder, (boolean[])paramObject);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      a(paramStringBuilder, (byte[])paramObject);
      return;
    }
    if ((paramObject instanceof char[]))
    {
      a(paramStringBuilder, (char[])paramObject);
      return;
    }
    if ((paramObject instanceof short[]))
    {
      a(paramStringBuilder, (short[])paramObject);
      return;
    }
    if ((paramObject instanceof int[]))
    {
      a(paramStringBuilder, (int[])paramObject);
      return;
    }
    if ((paramObject instanceof long[]))
    {
      a(paramStringBuilder, (long[])paramObject);
      return;
    }
    if ((paramObject instanceof float[]))
    {
      a(paramStringBuilder, (float[])paramObject);
      return;
    }
    if ((paramObject instanceof double[]))
    {
      a(paramStringBuilder, (double[])paramObject);
      return;
    }
    a(paramStringBuilder, (Object[])paramObject, paramMap);
  }
  
  private static void a(StringBuilder paramStringBuilder, byte[] paramArrayOfByte)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfByte[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static void a(StringBuilder paramStringBuilder, char[] paramArrayOfChar)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfChar[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static void a(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfDouble[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static void a(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfFloat[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static void a(StringBuilder paramStringBuilder, int[] paramArrayOfInt)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfInt[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static void a(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfLong[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static void a(StringBuilder paramStringBuilder, Object[] paramArrayOfObject, Map<Object[], Object> paramMap)
  {
    paramStringBuilder.append('[');
    if (!paramMap.containsKey(paramArrayOfObject))
    {
      paramMap.put(paramArrayOfObject, null);
      int j = paramArrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        a(paramStringBuilder, paramArrayOfObject[i], paramMap);
        if (i != j - 1) {
          paramStringBuilder.append(", ");
        }
        i += 1;
      }
      paramMap.remove(paramArrayOfObject);
    }
    else
    {
      paramStringBuilder.append("...");
    }
    paramStringBuilder.append(']');
  }
  
  private static void a(StringBuilder paramStringBuilder, short[] paramArrayOfShort)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfShort[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static void a(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfBoolean[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  static final boolean a(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    return paramString.charAt(paramInt - 1) == '\\';
  }
  
  static final boolean b(String paramString, int paramInt)
  {
    return (paramInt >= 2) && (paramString.charAt(paramInt - 2) == '\\');
  }
  
  private static Object[] b(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length != 0))
    {
      int i = paramArrayOfObject.length - 1;
      Object[] arrayOfObject = new Object[i];
      System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, i);
      return arrayOfObject;
    }
    throw new IllegalStateException("non-sensical empty or null argument array");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCircleLoggerFactory.MessageFormatter
 * JD-Core Version:    0.7.0.1
 */