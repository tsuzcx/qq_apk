package com.huawei.hms.framework.common;

import android.util.Base64;
import com.huawei.secure.android.common.util.SafeBase64;

public class SecurityBase64Utils
{
  private static boolean IS_AEGIS_BASE64_LIBRARY_LOADED = false;
  private static final String SAFE_BASE64_PATH = "com.huawei.secure.android.common.util.SafeBase64";
  
  private static boolean checkCompatible(String paramString)
  {
    ClassLoader localClassLoader = SecurityBase64Utils.class.getClassLoader();
    if (localClassLoader == null) {
      return false;
    }
    try
    {
      localClassLoader.loadClass(paramString);
      try
      {
        IS_AEGIS_BASE64_LIBRARY_LOADED = true;
        return true;
      }
      finally {}
      return false;
    }
    catch (ClassNotFoundException paramString) {}
  }
  
  public static byte[] decode(String paramString, int paramInt)
  {
    if ((!IS_AEGIS_BASE64_LIBRARY_LOADED) && (!checkCompatible("com.huawei.secure.android.common.util.SafeBase64"))) {}
    try
    {
      paramString = Base64.decode(paramString, paramInt);
      return paramString;
    }
    catch (Exception paramString)
    {
      label25:
      break label25;
    }
    return new byte[0];
    return SafeBase64.decode(paramString, paramInt);
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    if ((!IS_AEGIS_BASE64_LIBRARY_LOADED) && (!checkCompatible("com.huawei.secure.android.common.util.SafeBase64"))) {}
    try
    {
      paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, paramInt);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      label25:
      break label25;
    }
    return null;
    return SafeBase64.encodeToString(paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.SecurityBase64Utils
 * JD-Core Version:    0.7.0.1
 */