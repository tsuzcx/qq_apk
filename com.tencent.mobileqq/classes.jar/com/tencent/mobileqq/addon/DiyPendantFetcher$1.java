package com.tencent.mobileqq.addon;

import aieg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class DiyPendantFetcher$1
  implements Runnable
{
  public DiyPendantFetcher$1(aieg paramaieg) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.this$0.a((QQAppInterface)localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.1
 * JD-Core Version:    0.7.0.1
 */