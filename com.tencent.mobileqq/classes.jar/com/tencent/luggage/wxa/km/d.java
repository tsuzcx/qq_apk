package com.tencent.luggage.wxa.km;

import java.util.Arrays;

class d
{
  static int a(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  static String a(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return paramObject.toString();
  }
  
  static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  static boolean b(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      if (((paramObject1 instanceof Object[])) && ((paramObject2 instanceof Object[]))) {
        return Arrays.deepEquals((Object[])paramObject1, (Object[])paramObject2);
      }
      if (((paramObject1 instanceof boolean[])) && ((paramObject2 instanceof boolean[]))) {
        return Arrays.equals((boolean[])paramObject1, (boolean[])paramObject2);
      }
      if (((paramObject1 instanceof byte[])) && ((paramObject2 instanceof byte[]))) {
        return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
      }
      if (((paramObject1 instanceof char[])) && ((paramObject2 instanceof char[]))) {
        return Arrays.equals((char[])paramObject1, (char[])paramObject2);
      }
      if (((paramObject1 instanceof double[])) && ((paramObject2 instanceof double[]))) {
        return Arrays.equals((double[])paramObject1, (double[])paramObject2);
      }
      if (((paramObject1 instanceof float[])) && ((paramObject2 instanceof float[]))) {
        return Arrays.equals((float[])paramObject1, (float[])paramObject2);
      }
      if (((paramObject1 instanceof int[])) && ((paramObject2 instanceof int[]))) {
        return Arrays.equals((int[])paramObject1, (int[])paramObject2);
      }
      if (((paramObject1 instanceof long[])) && ((paramObject2 instanceof long[]))) {
        return Arrays.equals((long[])paramObject1, (long[])paramObject2);
      }
      if (((paramObject1 instanceof short[])) && ((paramObject2 instanceof short[]))) {
        return Arrays.equals((short[])paramObject1, (short[])paramObject2);
      }
      return paramObject1.equals(paramObject2);
    }
    return paramObject1 == paramObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.d
 * JD-Core Version:    0.7.0.1
 */