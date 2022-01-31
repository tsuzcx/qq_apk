import java.util.HashMap;
import java.util.Map;

final class arep
{
  public static final aref a(String paramString, Object paramObject)
  {
    return a(paramString, new Object[] { paramObject });
  }
  
  public static final aref a(String paramString, Object paramObject1, Object paramObject2)
  {
    return a(paramString, new Object[] { paramObject1, paramObject2 });
  }
  
  public static final aref a(String paramString, Object[] paramArrayOfObject)
  {
    Throwable localThrowable = a(paramArrayOfObject);
    Object[] arrayOfObject = paramArrayOfObject;
    if (localThrowable != null) {
      arrayOfObject = a(paramArrayOfObject);
    }
    return a(paramString, arrayOfObject, localThrowable);
  }
  
  public static final aref a(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    int j = 0;
    if (paramString == null) {
      return new aref(null, paramArrayOfObject, paramThrowable);
    }
    if (paramArrayOfObject == null) {
      return new aref(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 50);
    int i = 0;
    if (j < paramArrayOfObject.length)
    {
      int k = paramString.indexOf("{}", i);
      if (k == -1)
      {
        if (i == 0) {
          return new aref(paramString, paramArrayOfObject, paramThrowable);
        }
        localStringBuilder.append(paramString, i, paramString.length());
        return new aref(localStringBuilder.toString(), paramArrayOfObject, paramThrowable);
      }
      if (a(paramString, k)) {
        if (!b(paramString, k))
        {
          j -= 1;
          localStringBuilder.append(paramString, i, k - 1);
          localStringBuilder.append('{');
          i = k + 1;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuilder.append(paramString, i, k - 1);
        a(localStringBuilder, paramArrayOfObject[j], new HashMap());
        i = k + 2;
        continue;
        localStringBuilder.append(paramString, i, k);
        a(localStringBuilder, paramArrayOfObject[j], new HashMap());
        i = k + 2;
      }
    }
    localStringBuilder.append(paramString, i, paramString.length());
    return new aref(localStringBuilder.toString(), paramArrayOfObject, paramThrowable);
  }
  
  static final Throwable a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      return null;
    }
    paramArrayOfObject = paramArrayOfObject[(paramArrayOfObject.length - 1)];
    if ((paramArrayOfObject instanceof Throwable)) {
      return (Throwable)paramArrayOfObject;
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
      paramStringBuilder.append("[FAILED toString()]");
    }
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
    for (;;)
    {
      paramStringBuilder.append(']');
      return;
      paramStringBuilder.append("...");
    }
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
    if (paramInt == 0) {}
    while (paramString.charAt(paramInt - 1) != '\\') {
      return false;
    }
    return true;
  }
  
  private static Object[] a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      throw new IllegalStateException("non-sensical empty or null argument array");
    }
    int i = paramArrayOfObject.length - 1;
    Object[] arrayOfObject = new Object[i];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, i);
    return arrayOfObject;
  }
  
  static final boolean b(String paramString, int paramInt)
  {
    return (paramInt >= 2) && (paramString.charAt(paramInt - 2) == '\\');
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arep
 * JD-Core Version:    0.7.0.1
 */