package com.tencent.mobileqq.app;

import alyr;
import alys;
import amci;
import com.tencent.qphone.base.util.QLog;

public class PhoneUnityManager$2
  implements Runnable
{
  public PhoneUnityManager$2(alys paramalys) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MobileUnityManager", 4, "load phone local data");
    }
    alyr localalyr = this.this$0.a();
    ((amci)this.this$0.a.a(34)).notifyUI(9, true, localalyr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneUnityManager.2
 * JD-Core Version:    0.7.0.1
 */