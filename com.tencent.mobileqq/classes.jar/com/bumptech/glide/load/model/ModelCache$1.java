package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.util.LruCache;

class ModelCache$1
  extends LruCache<ModelCache.ModelKey<A>, B>
{
  ModelCache$1(ModelCache paramModelCache, long paramLong)
  {
    super(paramLong);
  }
  
  protected void a(@NonNull ModelCache.ModelKey<A> paramModelKey, @Nullable B paramB)
  {
    paramModelKey.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ModelCache.1
 * JD-Core Version:    0.7.0.1
 */