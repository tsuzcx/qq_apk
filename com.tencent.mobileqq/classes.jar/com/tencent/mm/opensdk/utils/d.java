package com.tencent.mm.opensdk.utils;

public final class d
{
  public static boolean h(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static int i(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return 0;
        }
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (Exception paramString) {}
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.d
 * JD-Core Version:    0.7.0.1
 */