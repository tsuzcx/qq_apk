package com.tencent.acstat.common;

import java.io.File;

class l
{
  public static boolean a()
  {
    int i = 0;
    for (;;)
    {
      if (i < 6) {}
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(new java.lang.String[] { "/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/" }[i]);
        localStringBuilder.append("su");
        boolean bool = new File(localStringBuilder.toString()).exists();
        if (bool) {
          return true;
        }
        i += 1;
      }
      catch (Exception localException) {}
    }
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.common.l
 * JD-Core Version:    0.7.0.1
 */