package com.huawei.hms.opendevice;

import android.text.TextUtils;

public class t
{
  public static boolean a(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (TextUtils.isEmpty(paramVarArgs[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.opendevice.t
 * JD-Core Version:    0.7.0.1
 */