package com.bumptech.glide.load.resource.gif;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;

public class GifDrawableEncoder
  implements ResourceEncoder<GifDrawable>
{
  @NonNull
  public EncodeStrategy a(@NonNull Options paramOptions)
  {
    return EncodeStrategy.SOURCE;
  }
  
  public boolean a(@NonNull Resource<GifDrawable> paramResource, @NonNull File paramFile, @NonNull Options paramOptions)
  {
    paramResource = (GifDrawable)paramResource.d();
    try
    {
      ByteBufferUtil.a(paramResource.c(), paramFile);
      return true;
    }
    catch (IOException paramResource)
    {
      if (Log.isLoggable("GifEncoder", 5)) {
        Log.w("GifEncoder", "Failed to encode GIF drawable data", paramResource);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.gif.GifDrawableEncoder
 * JD-Core Version:    0.7.0.1
 */