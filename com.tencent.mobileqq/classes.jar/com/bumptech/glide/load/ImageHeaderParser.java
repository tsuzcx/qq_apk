package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract interface ImageHeaderParser
{
  public abstract int a(@NonNull InputStream paramInputStream, @NonNull ArrayPool paramArrayPool);
  
  @NonNull
  public abstract ImageHeaderParser.ImageType a(@NonNull InputStream paramInputStream);
  
  @NonNull
  public abstract ImageHeaderParser.ImageType a(@NonNull ByteBuffer paramByteBuffer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.ImageHeaderParser
 * JD-Core Version:    0.7.0.1
 */