package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.text.TextUtils;
import bjxj;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import sng;

public class ViolaReportDelegate$2
  implements Runnable
{
  public ViolaReportDelegate$2(sng paramsng) {}
  
  public void run()
  {
    try
    {
      String str = bjxj.c();
      if ((!TextUtils.isEmpty(str)) && (new JSONObject(str) != null))
      {
        bjxj.h("");
        bjxj.f(false);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(sng.a, 2, "clearCachePageOpenData Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.2
 * JD-Core Version:    0.7.0.1
 */