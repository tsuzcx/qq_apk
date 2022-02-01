package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;

public abstract interface ResourceEncoder<T>
  extends Encoder<Resource<T>>
{
  @NonNull
  public abstract EncodeStrategy a(@NonNull Options paramOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.ResourceEncoder
 * JD-Core Version:    0.7.0.1
 */