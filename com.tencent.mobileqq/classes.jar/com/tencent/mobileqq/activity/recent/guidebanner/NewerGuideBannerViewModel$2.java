package com.tencent.mobileqq.activity.recent.guidebanner;

import alkj;
import alkp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class NewerGuideBannerViewModel$2
  implements Runnable
{
  public NewerGuideBannerViewModel$2(alkp paramalkp, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ((WebProcessManager)this.a.getManager(QQManagerFactory.WEBPROCESS_MANAGER)).e();
    this.this$0.a.c(this.a.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.2
 * JD-Core Version:    0.7.0.1
 */