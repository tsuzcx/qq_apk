package com.bumptech.glide.load.engine.bitmap_recycle;

final class LruArrayPool$KeyPool
  extends BaseKeyPool<LruArrayPool.Key>
{
  protected LruArrayPool.Key a()
  {
    return new LruArrayPool.Key(this);
  }
  
  LruArrayPool.Key a(int paramInt, Class<?> paramClass)
  {
    LruArrayPool.Key localKey = (LruArrayPool.Key)c();
    localKey.a(paramInt, paramClass);
    return localKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.KeyPool
 * JD-Core Version:    0.7.0.1
 */