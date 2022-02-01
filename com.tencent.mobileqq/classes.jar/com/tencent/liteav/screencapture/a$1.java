package com.tencent.liteav.screencapture;

import com.tencent.liteav.basic.util.h;

class a$1
  implements c.b
{
  a$1(a parama) {}
  
  public void a()
  {
    h.a(a.a(this.a), -7001, "Screen recording stopped. It may be preempted by other apps");
    a.a locala = a.b(this.a);
    a.a(this.a, null);
    if (locala != null) {
      locala.onScreenCaptureStopped(1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a.c(this.a))
    {
      this.a.b(paramBoolean);
      a locala = this.a;
      locala.b(105, a.d(locala), a.e(this.a));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.a.b(106);
      return;
    }
    a.a(this.a, null);
    h.a(a.a(this.a), -1308, "Failed to share screen");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.screencapture.a.1
 * JD-Core Version:    0.7.0.1
 */