package com.tencent.mobileqq.app;

import ajed;
import ajoy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import rtr;

public class PublicAccountDataManager$2
  implements Runnable
{
  public PublicAccountDataManager$2(ajoy paramajoy) {}
  
  public void run()
  {
    QLog.d("Q.contacttab.pub", 2, "preGetKandianSubscribe account info!");
    rtr.a(this.this$0.a, BaseApplication.getContext(), null, ajed.aP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountDataManager.2
 * JD-Core Version:    0.7.0.1
 */