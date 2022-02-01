package com.tencent.common.app;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class ThirdAppReportImpl$1
  implements Runnable
{
  ThirdAppReportImpl$1(ThirdAppReportImpl paramThirdAppReportImpl, Intent paramIntent, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void run()
  {
    try
    {
      ThirdAppReportImpl.a(this.a, this.b, this.c, this.d, this.e);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ThirdAppReport", 2, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.ThirdAppReportImpl.1
 * JD-Core Version:    0.7.0.1
 */