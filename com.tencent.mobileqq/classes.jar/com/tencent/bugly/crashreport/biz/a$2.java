package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.x;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    try
    {
      a.a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      x.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.crashreport.biz.a.2
 * JD-Core Version:    0.7.0.1
 */