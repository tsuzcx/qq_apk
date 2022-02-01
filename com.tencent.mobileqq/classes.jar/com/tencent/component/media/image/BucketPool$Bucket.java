package com.tencent.component.media.image;

import java.util.LinkedList;

class BucketPool$Bucket<T>
{
  int allocCount;
  LinkedList<T> dataList;
  int getCount = 0;
  int itemSize;
  int minSize;
  int releaseCount = 0;
  
  BucketPool$Bucket(BucketPool paramBucketPool) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.BucketPool.Bucket
 * JD-Core Version:    0.7.0.1
 */