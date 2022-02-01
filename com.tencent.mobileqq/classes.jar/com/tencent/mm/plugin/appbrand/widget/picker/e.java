package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.luggage.wxa.qz.af;

public final class e
{
  private static int a(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString, 10);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  static boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 59);
  }
  
  public static int[] a(String paramString)
  {
    boolean bool = af.c(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    String[] arrayOfString = paramString.split(":");
    paramString = localObject;
    if (arrayOfString != null)
    {
      if (arrayOfString.length != 2) {
        return null;
      }
      int i = a(arrayOfString[0], -1);
      int j = a(arrayOfString[1], -1);
      paramString = localObject;
      if (b(i))
      {
        if (!a(j)) {
          return null;
        }
        paramString = new int[2];
        paramString[0] = i;
        paramString[1] = j;
      }
    }
    return paramString;
  }
  
  static boolean b(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 23);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.e
 * JD-Core Version:    0.7.0.1
 */