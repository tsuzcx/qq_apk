package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.text.TextUtils;
import bmqa;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tmf;

public class ViolaReportDelegate$2
  implements Runnable
{
  public ViolaReportDelegate$2(tmf paramtmf) {}
  
  public void run()
  {
    try
    {
      String str = bmqa.d();
      if ((!TextUtils.isEmpty(str)) && (new JSONObject(str) != null))
      {
        bmqa.g("");
        bmqa.f(false);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(tmf.a, 2, "clearCachePageOpenData Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.2
 * JD-Core Version:    0.7.0.1
 */