package com.tencent.liteav.videoencoder;

import android.media.MediaCodec;
import com.tencent.liteav.basic.log.TXCLog;

class a$11
  implements Runnable
{
  a$11(a parama) {}
  
  public void run()
  {
    if (a.e(this.a) == null) {
      return;
    }
    try
    {
      a.e(this.a).signalEndOfInputStream();
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCHWVideoEncoder", "signalEndOfInputStream failed.", localException);
    }
    while (a.c(this.a, 10) >= 0) {}
    a.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a.11
 * JD-Core Version:    0.7.0.1
 */