package com.tencent.liteav;

import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;

class d$19
  implements Runnable
{
  d$19(d paramd, int paramInt) {}
  
  public void run()
  {
    if (d.c(this.b).encoderMode == this.a) {
      return;
    }
    d.c(this.b).encoderMode = this.a;
    d.h(this.b).encoderMode = this.a;
    d.g(this.b);
    d.i(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.d.19
 * JD-Core Version:    0.7.0.1
 */