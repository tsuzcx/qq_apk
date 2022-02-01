package com.bumptech.glide.load.model;

import android.support.annotation.Nullable;
import com.bumptech.glide.util.LruCache;

public class ModelCache<A, B>
{
  private final LruCache<ModelCache.ModelKey<A>, B> a;
  
  public ModelCache()
  {
    this(250L);
  }
  
  public ModelCache(long paramLong)
  {
    this.a = new ModelCache.1(this, paramLong);
  }
  
  @Nullable
  public B a(A paramA, int paramInt1, int paramInt2)
  {
    paramA = ModelCache.ModelKey.a(paramA, paramInt1, paramInt2);
    Object localObject = this.a.b(paramA);
    paramA.a();
    return localObject;
  }
  
  public void a(A paramA, int paramInt1, int paramInt2, B paramB)
  {
    paramA = ModelCache.ModelKey.a(paramA, paramInt1, paramInt2);
    this.a.b(paramA, paramB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ModelCache
 * JD-Core Version:    0.7.0.1
 */