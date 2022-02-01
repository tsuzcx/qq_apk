package com.huawei.hms.hatool;

public class n0$a
  implements Runnable
{
  public Runnable a;
  
  public n0$a(Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }
  
  public void run()
  {
    Runnable localRunnable = this.a;
    if (localRunnable != null) {}
    try
    {
      localRunnable.run();
      return;
    }
    catch (Exception localException)
    {
      label16:
      break label16;
    }
    y.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.n0.a
 * JD-Core Version:    0.7.0.1
 */