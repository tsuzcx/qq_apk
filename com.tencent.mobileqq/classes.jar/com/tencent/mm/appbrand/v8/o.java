package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.MultiContextV8;
import java.util.Timer;

class o
{
  final Runnable a = new o.3(this);
  private final MultiContextV8 b;
  private final c c;
  private Timer d;
  
  public o(MultiContextV8 paramMultiContextV8, c paramc)
  {
    this.b = paramMultiContextV8;
    this.c = paramc;
  }
  
  private void a()
  {
    if (this.d != null) {
      return;
    }
    this.d = new Timer();
    this.d.schedule(new o.4(this), 2000L, 2000L);
  }
  
  public void a(String paramString)
  {
    this.c.a(new o.1(this, paramString));
    this.c.b(new o.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.o
 * JD-Core Version:    0.7.0.1
 */