package com.tencent.luggage.wxa.gq;

import com.tencent.luggage.wxa.gp.f;
import com.tencent.luggage.wxa.gp.i;
import com.tencent.luggage.wxa.gw.b;
import com.tencent.mm.audio.mix.jni.AudioFFmpegDecodeJni;

public class d
  extends c
{
  public d(com.tencent.luggage.wxa.gt.d paramd, com.tencent.luggage.wxa.gv.c paramc)
  {
    super(paramd, paramc);
  }
  
  public void A()
  {
    if (this.e != null)
    {
      this.e.d();
      this.e = null;
    }
  }
  
  protected void r()
  {
    com.tencent.luggage.wxa.gm.d locald = n();
    locald.a();
    this.e = new f(locald, 44100, 2, 2, this.g);
    d.1 local1 = new d.1(this);
    if (AudioFFmpegDecodeJni.decode(44100, 2, 2, this.g, local1) != 0)
    {
      b.b("MicroMsg.Mix.AudioDecoderFFmpeg", "decode fail");
      return;
    }
    this.e.c();
    locald.f();
    if (j())
    {
      b.b("MicroMsg.Mix.AudioDecoderFFmpeg", "flushCache");
      this.e.c();
      return;
    }
    if (i())
    {
      b.b("MicroMsg.Mix.AudioDecoderFFmpeg", "flushCache and readCacheAndPlay");
      this.e.c();
      s();
      return;
    }
    b.b("MicroMsg.Mix.AudioDecoderFFmpeg", "writeCacheAndPlay");
    a(locald);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gq.d
 * JD-Core Version:    0.7.0.1
 */