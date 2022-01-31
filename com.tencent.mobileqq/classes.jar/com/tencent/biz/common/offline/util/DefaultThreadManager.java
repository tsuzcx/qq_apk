package com.tencent.biz.common.offline.util;

public class DefaultThreadManager
  implements IThreadManager
{
  public void a(Runnable paramRunnable)
  {
    new Thread(paramRunnable).start();
  }
  
  public void b(Runnable paramRunnable)
  {
    new Thread(paramRunnable).start();
  }
  
  public void c(Runnable paramRunnable)
  {
    new Thread(paramRunnable).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.common.offline.util.DefaultThreadManager
 * JD-Core Version:    0.7.0.1
 */