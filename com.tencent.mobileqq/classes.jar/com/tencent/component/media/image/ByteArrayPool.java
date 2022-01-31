package com.tencent.component.media.image;

import java.util.LinkedList;

public class ByteArrayPool
  extends BucketPool<byte[]>
{
  public ByteArrayPool(PoolParams paramPoolParams)
  {
    super(paramPoolParams);
  }
  
  protected byte[] allocData(int paramInt)
  {
    return new byte[paramInt];
  }
  
  protected BucketPool.Bucket getBuck(PoolParams.BucketParams paramBucketParams)
  {
    BucketPool.Bucket localBucket = new BucketPool.Bucket(this);
    localBucket.itemSize = paramBucketParams.arraysSize;
    localBucket.minSize = paramBucketParams.bucketMinSize;
    localBucket.allocCount = localBucket.itemSize;
    localBucket.dataList = new LinkedList();
    return localBucket;
  }
  
  protected int getSizeForData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.length;
    }
    return 0;
  }
  
  protected int handleBucketListEmpty(BucketPool<byte[]>.Bucket<byte[]> paramBucketPool)
  {
    return paramBucketPool.minSize;
  }
  
  protected boolean handleRecyleData(BucketPool<byte[]>.Bucket<byte[]> paramBucketPool, byte[] paramArrayOfByte)
  {
    if (paramBucketPool.dataList.size() < paramBucketPool.itemSize)
    {
      paramBucketPool.dataList.add(paramArrayOfByte);
      return false;
    }
    return true;
  }
  
  protected void releaseData(byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.ByteArrayPool
 * JD-Core Version:    0.7.0.1
 */