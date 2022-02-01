package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.MultiContextV8;

class o$1
  implements Runnable
{
  o$1(o paramo, String paramString) {}
  
  public void run()
  {
    if (o.a(this.b) != null)
    {
      o.a(this.b).waitForDebugger(this.a);
      o.b(this.b);
      return;
    }
    throw new IllegalStateException("V8DebuggerHelper v8 null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.o.1
 * JD-Core Version:    0.7.0.1
 */