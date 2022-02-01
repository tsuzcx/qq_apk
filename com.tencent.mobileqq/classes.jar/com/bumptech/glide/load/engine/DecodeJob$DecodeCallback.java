package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.DataSource;

final class DecodeJob$DecodeCallback<Z>
  implements DecodePath.DecodeCallback<Z>
{
  private final DataSource b;
  
  DecodeJob$DecodeCallback(DecodeJob paramDecodeJob, DataSource paramDataSource)
  {
    this.b = paramDataSource;
  }
  
  @NonNull
  public Resource<Z> a(@NonNull Resource<Z> paramResource)
  {
    return this.a.a(this.b, paramResource);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.DecodeJob.DecodeCallback
 * JD-Core Version:    0.7.0.1
 */