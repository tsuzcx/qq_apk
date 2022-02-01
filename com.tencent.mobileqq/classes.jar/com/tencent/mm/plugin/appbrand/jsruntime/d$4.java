package com.tencent.mm.plugin.appbrand.jsruntime;

class d$4
  implements Runnable
{
  d$4(d paramd) {}
  
  public void run()
  {
    if (d.a(this.a) != 0L)
    {
      JsBridgeBinding.nativeDestroyRuntime(d.a(this.a));
      d.a(this.a, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.d.4
 * JD-Core Version:    0.7.0.1
 */