package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.w;

final class a$c
  implements Runnable
{
  private long a = 21600000L;
  
  public a$c(a parama, long paramLong)
  {
    this.a = paramLong;
  }
  
  public final void run()
  {
    a locala = this.b;
    w localw = w.a();
    if (localw != null) {
      localw.a(new a.2(locala));
    }
    locala = this.b;
    long l = this.a;
    w.a().a(new c(locala, l), l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.crashreport.biz.a.c
 * JD-Core Version:    0.7.0.1
 */