package com.tencent.liteav;

import com.tencent.liteav.basic.b.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;

class d$12
  implements Runnable
{
  d$12(d paramd, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4) {}
  
  public void run()
  {
    int i;
    if ((this.a == d.c(this.f).width) && (this.b == d.c(this.f).height) && (this.c <= d.c(this.f).fps)) {
      i = 0;
    } else {
      i = 1;
    }
    int j = i;
    if (!this.d)
    {
      j = i;
      if (d.d(this.f))
      {
        TXCLog.i("TXCCaptureAndEnc", "disable h265 encoder from QoS. prepare to restart.");
        d.a(this.f, false);
        j = 1;
      }
    }
    if (j != 0)
    {
      TXCLog.i("TXCCaptureAndEnc", "restart encoder when QoS changed.");
      i = this.a;
      j = this.b;
      if (i > j) {
        d.e(this.f).m = 0;
      } else if (i < j) {
        d.e(this.f).m = 1;
      }
      Object localObject = d.e(this.f);
      j = this.a;
      int k = this.b;
      i = j;
      if (j > k) {
        i = k;
      }
      ((g)localObject).a = i;
      localObject = d.e(this.f);
      i = this.a;
      j = this.b;
      if (i <= j) {
        i = j;
      }
      ((g)localObject).b = i;
      localObject = d.f(this.f);
      if (localObject != null)
      {
        ((k)localObject).a(c.a);
        ((k)localObject).b(d.e(this.f).a, d.e(this.f).b);
        ((k)localObject).e(d.e(this.f).m);
      }
      d.e(this.f).c = this.e;
      d.e(this.f).i = this.c;
      d.g(this.f);
      TXCLog.e("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", new Object[] { Integer.valueOf(d.c(this.f).width), Integer.valueOf(d.c(this.f).height), Integer.valueOf(d.c(this.f).fps), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.d.12
 * JD-Core Version:    0.7.0.1
 */