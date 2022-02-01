package com.tencent.mobileqq.ar.arcore;

import android.os.Build;
import com.tencent.mobileqq.utils.StringUtil;

public class ARCoreManager
{
  private static volatile ARCoreManager jdField_a_of_type_ComTencentMobileqqArArcoreARCoreManager = null;
  volatile IARCoreAbilityManager jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreAbilityManager = null;
  
  public static boolean a(String paramString)
  {
    if (StringUtil.a(paramString)) {}
    while (!("" + Build.MANUFACTURER).equalsIgnoreCase(paramString)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcore.ARCoreManager
 * JD-Core Version:    0.7.0.1
 */