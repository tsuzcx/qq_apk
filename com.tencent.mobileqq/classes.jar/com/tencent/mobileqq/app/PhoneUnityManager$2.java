package com.tencent.mobileqq.app;

import aluc;
import alud;
import alxt;
import com.tencent.qphone.base.util.QLog;

public class PhoneUnityManager$2
  implements Runnable
{
  public PhoneUnityManager$2(alud paramalud) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MobileUnityManager", 4, "load phone local data");
    }
    aluc localaluc = this.this$0.a();
    ((alxt)this.this$0.a.a(34)).notifyUI(9, true, localaluc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneUnityManager.2
 * JD-Core Version:    0.7.0.1
 */