package com.tencent.mobileqq.app;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.TbsLogClient;
import mqq.os.MqqHandler;

class BrowserAppInterface$2
  extends TbsLogClient
{
  BrowserAppInterface$2(BrowserAppInterface paramBrowserAppInterface, Context paramContext)
  {
    super(paramContext);
  }
  
  public void d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e(paramString1, 2, paramString2);
    }
  }
  
  public void i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public void showLog(String paramString)
  {
    if (this.f.f == -1) {
      this.f.f = 0;
    }
    if (this.f.f == 1) {
      this.f.getHandler(BrowserAppInterface.class).post(new BrowserAppInterface.TBSLogRunnable(this.f, paramString));
    }
  }
  
  public void w(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BrowserAppInterface.2
 * JD-Core Version:    0.7.0.1
 */