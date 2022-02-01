package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.text.TextUtils;
import bkwm;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import thh;

public class ViolaReportDelegate$2
  implements Runnable
{
  public ViolaReportDelegate$2(thh paramthh) {}
  
  public void run()
  {
    try
    {
      String str = bkwm.d();
      if ((!TextUtils.isEmpty(str)) && (new JSONObject(str) != null))
      {
        bkwm.h("");
        bkwm.f(false);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(thh.a, 2, "clearCachePageOpenData Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.2
 * JD-Core Version:    0.7.0.1
 */