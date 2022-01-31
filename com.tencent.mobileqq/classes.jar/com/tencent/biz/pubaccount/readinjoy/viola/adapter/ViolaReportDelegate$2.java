package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.text.TextUtils;
import bgmq;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import rkb;

public class ViolaReportDelegate$2
  implements Runnable
{
  public ViolaReportDelegate$2(rkb paramrkb) {}
  
  public void run()
  {
    try
    {
      String str = bgmq.c();
      if ((!TextUtils.isEmpty(str)) && (new JSONObject(str) != null))
      {
        bgmq.h("");
        bgmq.g(false);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(rkb.a, 2, "clearCachePageOpenData Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.2
 * JD-Core Version:    0.7.0.1
 */