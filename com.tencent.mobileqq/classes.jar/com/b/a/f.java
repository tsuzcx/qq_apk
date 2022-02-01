package com.b.a;

final class f
  implements Runnable
{
  private final m a;
  private final o b;
  private final Runnable c;
  
  public f(p paramp, m paramm, o paramo, Runnable paramRunnable)
  {
    this.a = paramm;
    this.b = paramo;
    this.c = paramRunnable;
  }
  
  public final void run()
  {
    if (this.a.f())
    {
      this.a.b("canceled-at-delivery");
      return;
    }
    int i;
    if (this.b.c == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      this.a.a(this.b.a);
    } else {
      this.a.b(this.b.c);
    }
    if (this.b.d) {
      this.a.a("intermediate-response");
    } else {
      this.a.b("done");
    }
    Runnable localRunnable = this.c;
    if (localRunnable != null) {
      localRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.f
 * JD-Core Version:    0.7.0.1
 */