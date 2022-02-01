package com.tencent.component.media.image;

import java.util.LinkedList;

public abstract class BucketPool<T>
  implements Releaser<T>
{
  private static final String TAG = "BucketPool";
  private static int[] dat = new int[30];
  private int bucketSize;
  private BucketPool.Bucket[] buckets;
  
  public BucketPool(PoolParams paramPoolParams)
  {
    int i = 0;
    this.bucketSize = 0;
    this.bucketSize = paramPoolParams.getBucketPoolSize();
    int j = this.bucketSize;
    if (j > 0)
    {
      this.buckets = new BucketPool.Bucket[j];
      PoolParams.BucketParams localBucketParams;
      for (Object localObject = null; i < this.bucketSize; localObject = localBucketParams)
      {
        localBucketParams = paramPoolParams.getBucketParams(i);
        checkByteArrayParams(localBucketParams, (PoolParams.BucketParams)localObject);
        this.buckets[i] = getBuck(localBucketParams);
        i += 1;
      }
      return;
    }
    paramPoolParams = new RuntimeException("bucket size <= 0 !!");
    for (;;)
    {
      throw paramPoolParams;
    }
  }
  
  private static void checkByteArrayParams(PoolParams.BucketParams paramBucketParams1, PoolParams.BucketParams paramBucketParams2)
  {
    if ((paramBucketParams1.arraysSize > 0) && (paramBucketParams1.bucketMinSize > 0))
    {
      int i = 0;
      if (paramBucketParams2 != null) {
        i = paramBucketParams2.bucketMinSize;
      }
      if (i < paramBucketParams1.bucketMinSize) {
        return;
      }
      paramBucketParams2 = new StringBuilder();
      paramBucketParams2.append("byteArrayParams.minSize can not smaller than pre ");
      paramBucketParams2.append(i);
      paramBucketParams2.append(", bucketMinSize ");
      paramBucketParams2.append(paramBucketParams1.bucketMinSize);
      throw new RuntimeException(paramBucketParams2.toString());
    }
    throw new RuntimeException("byteArrayParams is wrong ");
  }
  
  protected abstract T allocData(int paramInt);
  
  public T get(int paramInt)
  {
    Object localObject3 = null;
    int i = 0;
    Object localObject1 = localObject3;
    for (;;)
    {
      try
      {
        if (i >= this.bucketSize) {
          break label112;
        }
        BucketPool.Bucket localBucket = this.buckets[i];
        if (localBucket.minSize >= paramInt)
        {
          localObject3 = localBucket.dataList.poll();
          localObject1 = localObject3;
          if (localObject3 != null) {
            break label112;
          }
          i = handleBucketListEmpty(localBucket);
          localObject1 = localObject3;
          if (localObject1 == null)
          {
            localObject1 = allocData(i);
            miss(paramInt);
          }
          else
          {
            hit(paramInt, localObject1);
          }
          return localObject1;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i += 1;
      }
      break;
      label112:
      i = paramInt;
    }
  }
  
  protected BucketPool.Bucket getBuck(PoolParams.BucketParams paramBucketParams)
  {
    BucketPool.Bucket localBucket = new BucketPool.Bucket(this);
    localBucket.itemSize = paramBucketParams.arraysSize;
    localBucket.minSize = paramBucketParams.bucketMinSize;
    localBucket.allocCount = localBucket.itemSize;
    localBucket.dataList = new LinkedList();
    int i = 0;
    while (i < localBucket.itemSize)
    {
      localBucket.dataList.add(allocData(localBucket.minSize));
      i += 1;
    }
    return localBucket;
  }
  
  protected abstract int getSizeForData(T paramT);
  
  protected abstract int handleBucketListEmpty(BucketPool<T>.Bucket<T> paramBucketPool);
  
  protected abstract boolean handleRecyleData(BucketPool<T>.Bucket<T> paramBucketPool, T paramT);
  
  protected void hit(int paramInt, T paramT) {}
  
  protected void miss(int paramInt) {}
  
  public void release(T paramT)
  {
    if (paramT == null) {
      return;
    }
    try
    {
      j = getSizeForData(paramT);
      i = this.bucketSize;
      bool2 = true;
      i -= 1;
    }
    finally
    {
      for (;;)
      {
        int j;
        int i;
        boolean bool2;
        boolean bool1;
        BucketPool.Bucket localBucket;
        for (;;)
        {
          throw paramT;
        }
        i -= 1;
      }
    }
    bool1 = bool2;
    if (i >= 0)
    {
      localBucket = this.buckets[i];
      if (j > localBucket.minSize + 2500)
      {
        releaseData(paramT);
        return;
      }
      if (j < localBucket.minSize) {
        break label109;
      }
      bool1 = handleRecyleData(localBucket, paramT);
    }
    if (bool1) {
      releaseData(paramT);
    }
  }
  
  protected abstract void releaseData(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.BucketPool
 * JD-Core Version:    0.7.0.1
 */