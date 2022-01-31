package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import naj;

public final class ProteusReportUtil$2
  implements Runnable
{
  public ProteusReportUtil$2(String paramString) {}
  
  public void run()
  {
    try
    {
      naj.a(BaseActivity.sTopActivity, this.a, "GET", null, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProteusReportUtil", 1, "UG report error" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ProteusReportUtil.2
 * JD-Core Version:    0.7.0.1
 */