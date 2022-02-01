package com.bumptech.glide.load.resource.bitmap;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Option.CacheKeyUpdater;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

class VideoDecoder$2
  implements Option.CacheKeyUpdater<Integer>
{
  private final ByteBuffer a = ByteBuffer.allocate(4);
  
  public void a(@NonNull byte[] arg1, @NonNull Integer paramInteger, @NonNull MessageDigest paramMessageDigest)
  {
    if (paramInteger == null) {
      return;
    }
    paramMessageDigest.update(???);
    synchronized (this.a)
    {
      this.a.position(0);
      paramMessageDigest.update(this.a.putInt(paramInteger.intValue()).array());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.VideoDecoder.2
 * JD-Core Version:    0.7.0.1
 */