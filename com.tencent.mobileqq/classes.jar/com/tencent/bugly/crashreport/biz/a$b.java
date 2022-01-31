package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.w;

final class a$b
  implements Runnable
{
  a$b(a parama) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    if (l < a.b(this.a))
    {
      w.a().a(new b(this.a), a.b(this.a) - l + 5000L);
      return;
    }
    this.a.a(3, false, 0L);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.biz.a.b
 * JD-Core Version:    0.7.0.1
 */