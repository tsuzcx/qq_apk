package com.tencent.mobileqq.app.api.impl;

import com.tencent.mobileqq.app.api.IMemoryManagerApi;
import com.tencent.qqperf.monitor.memory.MemoryManager;

public class MemoryManagerApiImpl
  implements IMemoryManagerApi
{
  public long getAvailClassSize()
  {
    return MemoryManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.api.impl.MemoryManagerApiImpl
 * JD-Core Version:    0.7.0.1
 */