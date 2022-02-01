package com.tencent.liteav;

import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;

class d$23
  implements Runnable
{
  d$23(d paramd) {}
  
  public void run()
  {
    if (d.f(this.a) != null) {
      d.f(this.a).b(true);
    }
    d locald = this.a;
    d.a(locald, d.c(locald).width, d.c(this.a).height);
    locald = this.a;
    locald.a(d.j(locald));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.d.23
 * JD-Core Version:    0.7.0.1
 */