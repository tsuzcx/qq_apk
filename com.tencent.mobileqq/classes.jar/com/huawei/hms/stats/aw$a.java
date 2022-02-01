package com.huawei.hms.stats;

class aw$a
  implements Runnable
{
  private Runnable a;
  
  public aw$a(Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }
  
  public void run()
  {
    if (this.a != null) {}
    try
    {
      this.a.run();
      return;
    }
    catch (Exception localException)
    {
      af.c("TaskThread", "InnerTask : Exception has happened,From internal operations!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.aw.a
 * JD-Core Version:    0.7.0.1
 */