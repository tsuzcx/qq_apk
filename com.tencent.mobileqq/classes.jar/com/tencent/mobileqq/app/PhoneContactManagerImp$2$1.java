package com.tencent.mobileqq.app;

import ajnx;
import com.tencent.qphone.base.util.QLog;

public class PhoneContactManagerImp$2$1
  implements Runnable
{
  public PhoneContactManagerImp$2$1(ajnx paramajnx) {}
  
  public void run()
  {
    if (PhoneContactManagerImp.a(this.a.a)) {
      return;
    }
    this.a.a.a = false;
    if (this.a.a.d() <= 5) {
      try
      {
        this.a.b();
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("PhoneContact.Manager", 1, "onFirstRespQueryNotBindState fail!", localException1);
        return;
      }
    }
    try
    {
      this.a.c();
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("PhoneContact.Manager", 1, "onFirstRespQueryState fail!", localException2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp.2.1
 * JD-Core Version:    0.7.0.1
 */