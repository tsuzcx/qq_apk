package com.tencent.mobileqq.app;

import amxz;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ugf;

public class PublicAccountDataManager$5
  implements Runnable
{
  public PublicAccountDataManager$5(amxz paramamxz) {}
  
  public void run()
  {
    QLog.d("Q.contacttab.pub", 2, "preGetKandianSubscribe account info!");
    ugf.a(this.this$0.a, BaseApplication.getContext(), null, AppConstants.KANDIAN_SUBSCRIBE_UIN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountDataManager.5
 * JD-Core Version:    0.7.0.1
 */