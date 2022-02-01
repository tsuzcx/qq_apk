package com.tencent.mobileqq.ar.arcore;

import android.os.Build;
import com.tencent.mobileqq.utils.StringUtil;

public class ARCoreManager
{
  private static volatile ARCoreManager jdField_a_of_type_ComTencentMobileqqArArcoreARCoreManager;
  volatile IARCoreAbilityManager jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreAbilityManager;
  
  public ARCoreManager()
  {
    this.a = null;
  }
  
  public static boolean a(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Build.MANUFACTURER);
    return localStringBuilder.toString().equalsIgnoreCase(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcore.ARCoreManager
 * JD-Core Version:    0.7.0.1
 */