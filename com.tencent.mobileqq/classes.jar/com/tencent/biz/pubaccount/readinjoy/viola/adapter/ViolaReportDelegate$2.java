package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.text.TextUtils;
import bhvy;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import rwt;

public class ViolaReportDelegate$2
  implements Runnable
{
  public ViolaReportDelegate$2(rwt paramrwt) {}
  
  public void run()
  {
    try
    {
      String str = bhvy.c();
      if ((!TextUtils.isEmpty(str)) && (new JSONObject(str) != null))
      {
        bhvy.h("");
        bhvy.f(false);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(rwt.a, 2, "clearCachePageOpenData Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.2
 * JD-Core Version:    0.7.0.1
 */