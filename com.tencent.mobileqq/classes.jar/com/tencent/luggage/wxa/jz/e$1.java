package com.tencent.luggage.wxa.jz;

import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.nq.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.Vector;

final class e$1
  extends c.c
{
  e$1(String paramString) {}
  
  public void a()
  {
    a.a(this.a, true);
  }
  
  public void a(c.d paramd)
  {
    o.d("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", new Object[] { this.a });
    a.a(this.a, false);
    paramd = new e.a();
    paramd.d = 1;
    paramd.a = this.a;
    paramd.a();
  }
  
  public void b()
  {
    a.a(this.a, true);
  }
  
  public void c()
  {
    o.d("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", new Object[] { this.a });
    e.a locala = new e.a();
    locala.d = 2;
    locala.a = this.a;
    locala.b();
    c.b(this.a, this);
    e.b().remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.e.1
 * JD-Core Version:    0.7.0.1
 */