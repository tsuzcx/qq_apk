package com.tencent.biz.qqcircle.utils;

import android.app.Application;
import android.content.res.Resources;
import com.tencent.qcircle.application.QCircleApplication;

public class HardCodeUtil
{
  public static String a(int paramInt)
  {
    try
    {
      String str = QCircleApplication.APP.getResources().getString(paramInt);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.HardCodeUtil
 * JD-Core Version:    0.7.0.1
 */