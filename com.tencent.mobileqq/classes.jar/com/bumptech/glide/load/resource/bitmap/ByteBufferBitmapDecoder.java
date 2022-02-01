package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.nio.ByteBuffer;

public class ByteBufferBitmapDecoder
  implements ResourceDecoder<ByteBuffer, Bitmap>
{
  private final Downsampler a;
  
  public ByteBufferBitmapDecoder(Downsampler paramDownsampler)
  {
    this.a = paramDownsampler;
  }
  
  public Resource<Bitmap> a(@NonNull ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    paramByteBuffer = ByteBufferUtil.b(paramByteBuffer);
    return this.a.a(paramByteBuffer, paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(@NonNull ByteBuffer paramByteBuffer, @NonNull Options paramOptions)
  {
    return this.a.a(paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder
 * JD-Core Version:    0.7.0.1
 */