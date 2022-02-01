package com.tencent.commonsdk.cache;

public class CacheInfo
{
  public int capacity;
  public long gapTime;
  public int getCount;
  public int hitCount;
  public long lifeTime;
  public int mClearSize;
  public int mItemSize;
  public int mMemorySize;
  public int missCount;
  public int putCount;
  public int removeCount;
  public int size;
  public int tagId;
  
  public CacheInfo(int paramInt1, int paramInt2)
  {
    this.tagId = paramInt1;
    this.capacity = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.cache.CacheInfo
 * JD-Core Version:    0.7.0.1
 */