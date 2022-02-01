package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.log.TXCLog;

class b$8
  implements Runnable
{
  b$8(b paramb) {}
  
  public void run()
  {
    b.a(this.a, 1107, "Switches from software encoding to hardware encoding");
    if (b.d(this.a) != null)
    {
      b.d(this.a).setListener(null);
      b.d(this.a).stop();
    }
    b.a(this.a, new a());
    TXCLog.w("TXCVideoEncoder", "create hw encoder");
    b.a(this.a, b.a.a);
    if (b.g(this.a).isH265EncoderEnabled)
    {
      TXCLog.w(b.f(), "can not switch from 265 sw to hw!");
      b.g(this.a).isH265EncoderEnabled = false;
    }
    b localb = this.a;
    localb.setStatusValue(4007, Long.valueOf(b.h(localb).a()));
    b.d(this.a).start(b.g(this.a));
    if (b.e(this.a) != null) {
      b.d(this.a).setListener(b.e(this.a));
    }
    if (b.f(this.a) != 0) {
      b.d(this.a).setBitrate(b.f(this.a));
    }
    b.d(this.a).setID(this.a.getID());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b.8
 * JD-Core Version:    0.7.0.1
 */