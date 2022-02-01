package com.bumptech.glide.load.resource.transcode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

public abstract interface ResourceTranscoder<Z, R>
{
  @Nullable
  public abstract Resource<R> a(@NonNull Resource<Z> paramResource, @NonNull Options paramOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.transcode.ResourceTranscoder
 * JD-Core Version:    0.7.0.1
 */