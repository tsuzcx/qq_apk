package com.tencent.mobileqq.addon;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

class DiyPendantFetcher$1
  implements Runnable
{
  DiyPendantFetcher$1(DiyPendantFetcher paramDiyPendantFetcher) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.this$0.a((QQAppInterface)localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.1
 * JD-Core Version:    0.7.0.1
 */