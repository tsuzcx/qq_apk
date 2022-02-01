package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.InputStream;

public class StreamBitmapDecoder
  implements ResourceDecoder<InputStream, Bitmap>
{
  private final Downsampler a;
  private final ArrayPool b;
  
  public StreamBitmapDecoder(Downsampler paramDownsampler, ArrayPool paramArrayPool)
  {
    this.a = paramDownsampler;
    this.b = paramArrayPool;
  }
  
  public Resource<Bitmap> a(@NonNull InputStream paramInputStream, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    int i;
    if ((paramInputStream instanceof RecyclableBufferedInputStream))
    {
      paramInputStream = (RecyclableBufferedInputStream)paramInputStream;
      i = 0;
    }
    else
    {
      paramInputStream = new RecyclableBufferedInputStream(paramInputStream, this.b);
      i = 1;
    }
    ExceptionCatchingInputStream localExceptionCatchingInputStream = ExceptionCatchingInputStream.a(paramInputStream);
    MarkEnforcingInputStream localMarkEnforcingInputStream = new MarkEnforcingInputStream(localExceptionCatchingInputStream);
    StreamBitmapDecoder.UntrustedCallbacks localUntrustedCallbacks = new StreamBitmapDecoder.UntrustedCallbacks(paramInputStream, localExceptionCatchingInputStream);
    try
    {
      paramOptions = this.a.a(localMarkEnforcingInputStream, paramInt1, paramInt2, paramOptions, localUntrustedCallbacks);
      return paramOptions;
    }
    finally
    {
      localExceptionCatchingInputStream.b();
      if (i != 0) {
        paramInputStream.b();
      }
    }
  }
  
  public boolean a(@NonNull InputStream paramInputStream, @NonNull Options paramOptions)
  {
    return this.a.a(paramInputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder
 * JD-Core Version:    0.7.0.1
 */