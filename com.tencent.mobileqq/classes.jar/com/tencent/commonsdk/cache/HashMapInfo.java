package com.tencent.commonsdk.cache;

public class HashMapInfo
  extends CacheInfo
{
  public int traversalCount;
  
  public HashMapInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    this.mItemSize = paramInt3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("HashMapInfo{");
    localStringBuilder.append("tagId=").append(this.tagId);
    localStringBuilder.append(", capacity=").append(this.capacity);
    localStringBuilder.append(", size=").append(this.size);
    localStringBuilder.append(", getCount=").append(this.getCount);
    localStringBuilder.append(", putCount=").append(this.putCount);
    localStringBuilder.append(", removeCount=").append(this.removeCount);
    localStringBuilder.append(", hitCount=").append(this.hitCount);
    localStringBuilder.append(", missCount=").append(this.missCount);
    localStringBuilder.append(", lifeTime=").append(this.lifeTime);
    localStringBuilder.append(", gapTime=").append(this.gapTime);
    localStringBuilder.append(", mMemorySize=").append(this.mMemorySize);
    localStringBuilder.append(", traversalCount=").append(this.traversalCount);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.cache.HashMapInfo
 * JD-Core Version:    0.7.0.1
 */