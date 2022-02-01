package com.tencent.luggage.wxa.he;

public class a
{
  private static Object[] a = new Object[0];
  private static Object[] b = new Object[73];
  
  public static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static <T> boolean a(T[] paramArrayOfT, T paramT)
  {
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (? == null)
      {
        if (paramT == null) {
          return true;
        }
      }
      else if ((paramT != null) && (?.equals(paramT))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.he.a
 * JD-Core Version:    0.7.0.1
 */