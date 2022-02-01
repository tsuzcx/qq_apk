package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.text.TextUtils;
import bnrf;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tdd;

public class ViolaReportDelegate$2
  implements Runnable
{
  public ViolaReportDelegate$2(tdd paramtdd) {}
  
  public void run()
  {
    try
    {
      String str = bnrf.d();
      if ((!TextUtils.isEmpty(str)) && (new JSONObject(str) != null))
      {
        bnrf.g("");
        bnrf.f(false);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(tdd.a, 2, "clearCachePageOpenData Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.2
 * JD-Core Version:    0.7.0.1
 */