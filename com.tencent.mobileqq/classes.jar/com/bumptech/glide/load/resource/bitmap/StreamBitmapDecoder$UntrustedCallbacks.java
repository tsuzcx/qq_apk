package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import java.io.IOException;

class StreamBitmapDecoder$UntrustedCallbacks
  implements Downsampler.DecodeCallbacks
{
  private final RecyclableBufferedInputStream a;
  private final ExceptionCatchingInputStream b;
  
  StreamBitmapDecoder$UntrustedCallbacks(RecyclableBufferedInputStream paramRecyclableBufferedInputStream, ExceptionCatchingInputStream paramExceptionCatchingInputStream)
  {
    this.a = paramRecyclableBufferedInputStream;
    this.b = paramExceptionCatchingInputStream;
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(BitmapPool paramBitmapPool, Bitmap paramBitmap)
  {
    IOException localIOException = this.b.a();
    if (localIOException != null)
    {
      if (paramBitmap != null) {
        paramBitmapPool.a(paramBitmap);
      }
      throw localIOException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder.UntrustedCallbacks
 * JD-Core Version:    0.7.0.1
 */