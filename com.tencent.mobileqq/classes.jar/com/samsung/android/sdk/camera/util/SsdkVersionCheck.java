package com.samsung.android.sdk.camera.util;

public class SsdkVersionCheck
{
  public static int compareVersion(String paramString1, String paramString2)
  {
    boolean bool = paramString1.equals(paramString2);
    int i = 0;
    if (bool) {
      return 0;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int j = Math.min(paramString1.length, paramString2.length);
    while (i < j)
    {
      int k = new Integer(paramString1[i]).compareTo(Integer.valueOf(Integer.parseInt(paramString2[i])));
      if (k != 0) {
        return k;
      }
      i += 1;
    }
    return Integer.compare(paramString1.length, paramString2.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samsung.android.sdk.camera.util.SsdkVersionCheck
 * JD-Core Version:    0.7.0.1
 */