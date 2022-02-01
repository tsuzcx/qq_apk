package com.bumptech.glide.load.resource.bitmap;

import android.support.annotation.NonNull;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class TransformationUtils$NoLock
  implements Lock
{
  public void lock() {}
  
  public void lockInterruptibly() {}
  
  @NonNull
  public Condition newCondition()
  {
    throw new UnsupportedOperationException("Should not be called");
  }
  
  public boolean tryLock()
  {
    return true;
  }
  
  public boolean tryLock(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    return true;
  }
  
  public void unlock() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.TransformationUtils.NoLock
 * JD-Core Version:    0.7.0.1
 */