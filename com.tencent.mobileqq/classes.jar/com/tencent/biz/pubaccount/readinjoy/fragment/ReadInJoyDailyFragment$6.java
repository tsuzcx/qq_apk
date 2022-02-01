package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import ozs;

class ReadInJoyDailyFragment$6
  implements Runnable
{
  ReadInJoyDailyFragment$6(ReadInJoyDailyFragment paramReadInJoyDailyFragment) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = ozs.a();
    if (localQQAppInterface == null) {
      return;
    }
    ((WebProcessManager)localQQAppInterface.getManager(13)).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment.6
 * JD-Core Version:    0.7.0.1
 */