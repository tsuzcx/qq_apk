package com.samsung.android.sdk.camera.util;

public class SsdkVersionCheck
{
  public static int compareVersion(String paramString1, String paramString2)
  {
    int i = 0;
    if (paramString1.equals(paramString2)) {
      return i;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int m = Math.min(paramString1.length, paramString2.length);
    int j = 0;
    for (;;)
    {
      if (j >= m) {
        break label82;
      }
      int k = new Integer(paramString1[j]).compareTo(Integer.valueOf(Integer.parseInt(paramString2[j])));
      i = k;
      if (k != 0) {
        break;
      }
      j += 1;
    }
    label82:
    return Integer.compare(paramString1.length, paramString2.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.samsung.android.sdk.camera.util.SsdkVersionCheck
 * JD-Core Version:    0.7.0.1
 */