package com.tencent.luggage.wxa.jz;

import android.text.TextUtils;
import com.tencent.luggage.wxa.if.c;
import com.tencent.luggage.wxa.qz.o;

class e$a
  extends a
{
  public String a = "";
  public String b = "";
  public String c = "";
  public int d = 0;
  
  public void c()
  {
    super.c();
    int i = this.d;
    if (i == 0)
    {
      if (!TextUtils.isEmpty(this.b))
      {
        o.d("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
        return;
      }
      o.b("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
      return;
    }
    if (i == 1) {
      return;
    }
    o.b("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
  }
  
  public void d()
  {
    o.d("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", new Object[] { Integer.valueOf(this.d) });
    this.c = "";
    int i = this.d;
    if (i == 0)
    {
      this.b = c.a(this.a, this.b);
      o.d("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", new Object[] { this.b });
      if (TextUtils.isEmpty(this.b)) {
        this.c = "fail to create audio instance";
      }
    }
    else if (i == 1)
    {
      o.d("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
      c.g(this.a);
    }
    else if (i == 2)
    {
      o.d("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
      c.h(this.a);
      com.tencent.luggage.wxa.nq.a.d(this.a);
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.e.a
 * JD-Core Version:    0.7.0.1
 */