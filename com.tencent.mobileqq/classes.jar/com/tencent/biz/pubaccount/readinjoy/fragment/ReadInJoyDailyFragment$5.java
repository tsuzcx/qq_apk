package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import pnn;

class ReadInJoyDailyFragment$5
  implements Runnable
{
  ReadInJoyDailyFragment$5(ReadInJoyDailyFragment paramReadInJoyDailyFragment) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = pnn.a();
    if (localQQAppInterface == null) {
      return;
    }
    ((WebProcessManager)localQQAppInterface.getManager(QQManagerFactory.WEBPROCESS_MANAGER)).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment.5
 * JD-Core Version:    0.7.0.1
 */