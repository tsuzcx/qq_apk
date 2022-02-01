package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;

abstract interface DecodeJob$Callback<R>
{
  public abstract void a(DecodeJob<?> paramDecodeJob);
  
  public abstract void a(GlideException paramGlideException);
  
  public abstract void a(Resource<R> paramResource, DataSource paramDataSource);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.DecodeJob.Callback
 * JD-Core Version:    0.7.0.1
 */