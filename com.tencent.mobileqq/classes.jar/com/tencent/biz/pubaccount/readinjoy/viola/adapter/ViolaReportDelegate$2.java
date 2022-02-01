package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.text.TextUtils;
import bmhv;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tut;

public class ViolaReportDelegate$2
  implements Runnable
{
  public ViolaReportDelegate$2(tut paramtut) {}
  
  public void run()
  {
    try
    {
      String str = bmhv.d();
      if ((!TextUtils.isEmpty(str)) && (new JSONObject(str) != null))
      {
        bmhv.h("");
        bmhv.f(false);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(tut.a, 2, "clearCachePageOpenData Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.2
 * JD-Core Version:    0.7.0.1
 */