package com.tencent.liteav;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;

class d$19
  implements Runnable
{
  d$19(d paramd, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    TXCLog.w("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", new Object[] { Integer.valueOf(d.h(this.d).width), Integer.valueOf(d.h(this.d).height), Integer.valueOf(d.h(this.d).fps), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c) }));
    d.h(this.d).width = this.a;
    d.h(this.d).height = this.b;
    d.i(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.d.19
 * JD-Core Version:    0.7.0.1
 */