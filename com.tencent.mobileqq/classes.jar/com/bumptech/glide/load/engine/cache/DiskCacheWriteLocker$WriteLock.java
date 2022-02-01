package com.bumptech.glide.load.engine.cache;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiskCacheWriteLocker$WriteLock
{
  final Lock a = new ReentrantLock();
  int b;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock
 * JD-Core Version:    0.7.0.1
 */