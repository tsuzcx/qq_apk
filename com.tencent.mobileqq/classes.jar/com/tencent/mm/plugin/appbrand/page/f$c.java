package com.tencent.mm.plugin.appbrand.page;

abstract class f$c
  implements Runnable
{
  private boolean a = false;
  private boolean b = false;
  
  private boolean c()
  {
    return (!this.a) && (!this.b);
  }
  
  public abstract void a();
  
  public void b()
  {
    this.b = true;
  }
  
  public final void run()
  {
    if (!c()) {
      return;
    }
    this.a = true;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f.c
 * JD-Core Version:    0.7.0.1
 */