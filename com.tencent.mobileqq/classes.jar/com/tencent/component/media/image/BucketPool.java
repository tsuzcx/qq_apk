package com.tencent.component.media.image;

import java.util.LinkedList;

public abstract class BucketPool<T>
  implements Releaser<T>
{
  private static final String TAG = "BucketPool";
  private static int[] dat = new int[30];
  private int bucketSize = 0;
  private BucketPool.Bucket[] buckets;
  
  public BucketPool(PoolParams paramPoolParams)
  {
    this.bucketSize = paramPoolParams.getBucketPoolSize();
    if (this.bucketSize <= 0) {
      throw new RuntimeException("bucket size <= 0 !!");
    }
    this.buckets = new BucketPool.Bucket[this.bucketSize];
    PoolParams.BucketParams localBucketParams;
    for (Object localObject = null; i < this.bucketSize; localObject = localBucketParams)
    {
      localBucketParams = paramPoolParams.getBucketParams(i);
      checkByteArrayParams(localBucketParams, (PoolParams.BucketParams)localObject);
      this.buckets[i] = getBuck(localBucketParams);
      i += 1;
    }
  }
  
  private static void checkByteArrayParams(PoolParams.BucketParams paramBucketParams1, PoolParams.BucketParams paramBucketParams2)
  {
    if ((paramBucketParams1.arraysSize <= 0) || (paramBucketParams1.bucketMinSize <= 0)) {
      throw new RuntimeException("byteArrayParams is wrong ");
    }
    int i = 0;
    if (paramBucketParams2 != null) {
      i = paramBucketParams2.bucketMinSize;
    }
    if (i >= paramBucketParams1.bucketMinSize) {
      throw new RuntimeException("byteArrayParams.minSize can not smaller than pre " + i + ", bucketMinSize " + paramBucketParams1.bucketMinSize);
    }
  }
  
  protected abstract T allocData(int paramInt);
  
  public T get(int paramInt)
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.bucketSize) {
          break label96;
        }
        BucketPool.Bucket localBucket = this.buckets[i];
        if (localBucket.minSize >= paramInt)
        {
          localObject1 = localBucket.dataList.poll();
          if (localObject1 != null) {
            break label91;
          }
          i = handleBucketListEmpty(localBucket);
          if (localObject1 == null)
          {
            localObject1 = allocData(i);
            miss(paramInt);
            return localObject1;
          }
        }
        else
        {
          i += 1;
          continue;
        }
        hit(paramInt, localObject1);
        continue;
        i = paramInt;
      }
      finally {}
      label91:
      continue;
      label96:
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
    for (;;)
    {
      int j;
      int i;
      boolean bool1;
      BucketPool.Bucket localBucket;
      try
      {
        j = getSizeForData(paramT);
        boolean bool2 = true;
        i = this.bucketSize - 1;
        bool1 = bool2;
        if (i < 0) {
          break label85;
        }
        localBucket = this.buckets[i];
        if (j > localBucket.minSize + 2500)
        {
          releaseData(paramT);
          break;
        }
      }
      finally {}
      if (j >= localBucket.minSize)
      {
        bool1 = handleRecyleData(localBucket, paramT);
        label85:
        if (!bool1) {
          break;
        }
        releaseData(paramT);
        break;
      }
      i -= 1;
    }
  }
  
  protected abstract void releaseData(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.BucketPool
 * JD-Core Version:    0.7.0.1
 */