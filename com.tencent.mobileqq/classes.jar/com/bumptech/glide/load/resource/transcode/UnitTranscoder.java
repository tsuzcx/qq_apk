package com.bumptech.glide.load.resource.transcode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

public class UnitTranscoder<Z>
  implements ResourceTranscoder<Z, Z>
{
  private static final UnitTranscoder<?> a = new UnitTranscoder();
  
  public static <Z> ResourceTranscoder<Z, Z> a()
  {
    return a;
  }
  
  @Nullable
  public Resource<Z> a(@NonNull Resource<Z> paramResource, @NonNull Options paramOptions)
  {
    return paramResource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.transcode.UnitTranscoder
 * JD-Core Version:    0.7.0.1
 */