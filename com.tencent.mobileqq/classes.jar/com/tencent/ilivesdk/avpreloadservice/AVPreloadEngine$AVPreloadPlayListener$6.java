package com.tencent.ilivesdk.avpreloadservice;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;

class AVPreloadEngine$AVPreloadPlayListener$6
  implements Runnable
{
  AVPreloadEngine$AVPreloadPlayListener$6(AVPreloadEngine.AVPreloadPlayListener paramAVPreloadPlayListener, AVPreloadEngine.FrameData paramFrameData) {}
  
  public void run()
  {
    AVPreloadLog.a("AVPreloadEngine", "start decoder", new Object[0]);
    FrameDecoder localFrameDecoder = FrameDecoder.a();
    int i = this.a.a;
    int j = this.a.b;
    if (i * j > 92000.0F)
    {
      float f;
      if (i < j)
      {
        f = j / 400.0F;
        j = (int)400.0F;
        i = (int)(i / f);
      }
      else
      {
        f = i / 400.0F;
        i = (int)400.0F;
        j = (int)(j / f);
      }
    }
    else
    {
      i = 0;
      j = 0;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap2 = localFrameDecoder.a(AVPreloadEngine.f(this.b.a), this.a.c, this.a.d, this.a.a, this.a.b, i, j);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      AVPreloadLog.c("AVPreload|Core", "------first frame decoder fail! Retry one!!", new Object[0]);
      localBitmap1 = localFrameDecoder.a(AVPreloadEngine.f(this.b.a), this.a.c, this.a.d, this.a.a, this.a.b, i, j);
    }
    AVPreloadEngine.AVPreloadPlayListener.a(this.b).a(this.a.a);
    AVPreloadEngine.AVPreloadPlayListener.a(this.b).b(this.a.b);
    AVPreloadEngine.AVPreloadPlayListener.a(this.b).h(AVPreloadEngine.e(this.b.a));
    AVPreloadEngine.AVPreloadPlayListener.a(this.b).d(System.currentTimeMillis() - l);
    AVPreloadEngine.AVPreloadPlayListener.a(this.b).e(System.nanoTime() / 1000L);
    if (localBitmap1 == null)
    {
      AVPreloadLog.c("AVPreload|Core", "------first frame decoder fail, bitmap is null", new Object[0]);
      return;
    }
    AVPreloadEngine.c(this.b.a).post(new AVPreloadEngine.AVPreloadPlayListener.BitmapRunnable(this.b, localBitmap1, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.AVPreloadPlayListener.6
 * JD-Core Version:    0.7.0.1
 */