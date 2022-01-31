package com.tencent.mobileqq.app.memory;

import com.tencent.common.cache.ClearMemoryConfig.MemoryLevelInfo;

public abstract interface MemoryReporter$IMemoryListener
{
  public abstract void a(int paramInt, ClearMemoryConfig.MemoryLevelInfo paramMemoryLevelInfo);
  
  public abstract void a(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.memory.MemoryReporter.IMemoryListener
 * JD-Core Version:    0.7.0.1
 */