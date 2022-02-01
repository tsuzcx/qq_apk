package com.tencent.commonsdk.cache;

public class LruCacheInfo
  extends CacheInfo
{
  public int evictionCount;
  
  public LruCacheInfo(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LruCacheInfo{");
    localStringBuilder.append("tagId=");
    localStringBuilder.append(this.tagId);
    localStringBuilder.append(", capacity=");
    localStringBuilder.append(this.capacity);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(", getCount=");
    localStringBuilder.append(this.getCount);
    localStringBuilder.append(", putCount=");
    localStringBuilder.append(this.putCount);
    localStringBuilder.append(", removeCount=");
    localStringBuilder.append(this.removeCount);
    localStringBuilder.append(", hitCount=");
    localStringBuilder.append(this.hitCount);
    localStringBuilder.append(", missCount=");
    localStringBuilder.append(this.missCount);
    localStringBuilder.append(", lifeTime=");
    localStringBuilder.append(this.lifeTime);
    localStringBuilder.append(", gapTime=");
    localStringBuilder.append(this.gapTime);
    localStringBuilder.append(", evictionCount=");
    localStringBuilder.append(this.evictionCount);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.commonsdk.cache.LruCacheInfo
 * JD-Core Version:    0.7.0.1
 */