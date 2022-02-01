package com.tencent.mobileqq.ar.arcore;

import android.os.Build;
import com.tencent.mobileqq.utils.StringUtil;

public class ARCoreManager
{
  private static volatile ARCoreManager b;
  volatile IARCoreAbilityManager a = null;
  
  public static boolean a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Build.MANUFACTURER);
    return localStringBuilder.toString().equalsIgnoreCase(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcore.ARCoreManager
 * JD-Core Version:    0.7.0.1
 */