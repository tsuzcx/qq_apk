package com.tencent.av.mediacodec.config;

import android.os.Build.VERSION;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig.TestInfo;
import com.tencent.avcore.util.AVCoreUtil;
import com.tencent.avcore.util.ArrayUtils;

public class CodecConfigUtil
{
  public static int a(AVTestforEncDecConfig.TestInfo paramTestInfo)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return 0;
    }
    if (paramTestInfo == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT < paramTestInfo.c) {
      return 0;
    }
    if (!a(paramTestInfo.jdField_a_of_type_JavaLangString, null)) {
      return 0;
    }
    if (ArrayUtils.contains(paramTestInfo.jdField_a_of_type_JavaUtilArrayList, Integer.valueOf(Build.VERSION.SDK_INT))) {
      return 0;
    }
    if ((paramTestInfo.d != 0) && (Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= paramTestInfo.d)) {
      return 2;
    }
    return 1;
  }
  
  public static boolean a(String paramString, String[] paramArrayOfString)
  {
    int j = AVCoreUtil.getQQVersion();
    if (AVCoreUtil.strVersionToInt(paramString) > j) {
      return false;
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int k = paramArrayOfString.length;
      int i = 0;
      while (i < k)
      {
        if (AVCoreUtil.strVersionToInt(paramArrayOfString[i]) == j) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.mediacodec.config.CodecConfigUtil
 * JD-Core Version:    0.7.0.1
 */