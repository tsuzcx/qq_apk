package com.tencent.mobileqq.apollo.utils;

import android.text.TextUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ApolloResUtil
{
  public static String a(String paramString)
  {
    return a(paramString, "face.json");
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return paramString1 + File.separator + paramString2;
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = MD5Utils.toMD5(paramString);
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        return a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/" + paramString, "face.json");
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QLog.e("ApolloResUtil", 1, "[getFaceJsonFilePathByUr]l error! " + paramString);
          paramString = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloResUtil
 * JD-Core Version:    0.7.0.1
 */