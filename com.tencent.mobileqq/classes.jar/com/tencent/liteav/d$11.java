package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.b;
import java.nio.ByteBuffer;

class d$11
  implements Runnable
{
  d$11(d paramd, Bitmap paramBitmap, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if (((d.n(this.e) == 2) || (d.o(this.e))) && (this.a != null))
      {
        if (this.b == null) {
          return;
        }
        boolean bool = d.c(this.e).isH265EncoderEnabled;
        int j = 0;
        int i = j;
        if (!bool)
        {
          i = j;
          if (d.c(this.e).encodeType != 2) {
            i = 1;
          }
        }
        if ((d.a(this.e) == null) || (d.p(this.e)) || (d.c(this.e).width != this.c) || (d.c(this.e).height != this.d) || (i != 0) || (d.c(this.e).gop != d.e(this.e).j) || (d.d(this.e) != d.c(this.e).isH265EncoderEnabled)) {
          if (d.c(this.e).isH265EncoderEnabled) {
            d.a(this.e, this.c, this.d, d.c(this.e).encodeType, null, d.e(this.e).D, true);
          } else {
            d.a(this.e, this.c, this.d, 2, null, d.e(this.e).D, true);
          }
        }
        if (((d.b(this.e) == null) || (d.h(this.e).encodeType != 2)) && (d.q(this.e))) {
          d.a(this.e, null, 2, true);
        }
        i = this.a.getWidth();
        j = this.a.getHeight();
        b localb = d.a(this.e);
        if (localb != null) {
          localb.a(this.b.array(), 2, i, j, TXCTimeUtil.generatePtsMS());
        }
        localb = d.b(this.e);
        if (localb != null) {
          localb.a(this.b.array(), 2, i, j, TXCTimeUtil.generatePtsMS());
        }
      }
      else {}
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPushBitmap failed.");
      localStringBuilder.append(localException.getMessage());
      TXCLog.e("TXCCaptureAndEnc", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.d.11
 * JD-Core Version:    0.7.0.1
 */