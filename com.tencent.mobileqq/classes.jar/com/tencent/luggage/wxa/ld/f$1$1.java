package com.tencent.luggage.wxa.ld;

import com.tencent.luggage.wxa.nz.p;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;

class f$1$1
  implements Runnable
{
  f$1$1(f.1 param1) {}
  
  public void run()
  {
    synchronized (f.a(this.a.d))
    {
      if (!f.a(this.a.d).containsKey(f.a(this.a.d, this.a.a, this.a.b)))
      {
        o.d("MicroMsg.JsApiOperateLocalServicesScan", "scan task not exist, cancel auto stop");
        return;
      }
      p.a.a(this.a.c);
      f.a(this.a.d).remove(f.a(this.a.d, this.a.a, this.a.b));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ld.f.1.1
 * JD-Core Version:    0.7.0.1
 */