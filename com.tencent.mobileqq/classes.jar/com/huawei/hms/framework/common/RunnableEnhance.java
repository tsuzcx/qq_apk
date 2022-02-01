package com.huawei.hms.framework.common;

public class RunnableEnhance
  implements Runnable
{
  static final String TRANCELOGO = " -->";
  private String parentName = Thread.currentThread().getName();
  private Runnable proxy;
  
  RunnableEnhance(Runnable paramRunnable)
  {
    this.proxy = paramRunnable;
  }
  
  public String getParentName()
  {
    return this.parentName;
  }
  
  public void run()
  {
    this.proxy.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.RunnableEnhance
 * JD-Core Version:    0.7.0.1
 */