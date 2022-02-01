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
    if (this.a.f()) {
      this.a.b("canceled-at-delivery");
    }
    label50:
    label91:
    label108:
    label118:
    for (;;)
    {
      return;
      int i;
      if (this.b.c == null)
      {
        i = 1;
        if (i == 0) {
          break label91;
        }
        this.a.a(this.b.a);
        if (!this.b.d) {
          break label108;
        }
        this.a.a("intermediate-response");
      }
      for (;;)
      {
        if (this.c == null) {
          break label118;
        }
        this.c.run();
        return;
        i = 0;
        break;
        this.a.b(this.b.c);
        break label50;
        this.a.b("done");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.b.a.f
 * JD-Core Version:    0.7.0.1
 */