package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.qphone.base.util.BaseApplication;

public class HardCodeUtil
{
  public static Context a = ;
  
  public static String a(int paramInt)
  {
    try
    {
      String str = a.getResources().getString(paramInt);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HardCodeUtil
 * JD-Core Version:    0.7.0.1
 */