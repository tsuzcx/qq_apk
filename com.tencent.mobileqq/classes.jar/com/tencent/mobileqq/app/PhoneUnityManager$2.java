package com.tencent.mobileqq.app;

import akco;
import akcp;
import akge;
import com.tencent.qphone.base.util.QLog;

public class PhoneUnityManager$2
  implements Runnable
{
  public PhoneUnityManager$2(akcp paramakcp) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MobileUnityManager", 4, "load phone local data");
    }
    akco localakco = this.this$0.a();
    ((akge)this.this$0.a.a(34)).notifyUI(9, true, localakco);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneUnityManager.2
 * JD-Core Version:    0.7.0.1
 */