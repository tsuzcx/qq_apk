package com.tencent.mobileqq.bubble;

import almr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class BubbleDiyFetcher$1
  implements Runnable
{
  public BubbleDiyFetcher$1(almr paramalmr) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.this$0.b((QQAppInterface)localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher.1
 * JD-Core Version:    0.7.0.1
 */