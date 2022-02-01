package com.tencent.liteav.basic.util;

import android.os.Debug;
import android.os.Debug.MemoryInfo;

final class f$2
  implements Runnable
{
  public void run()
  {
    System.currentTimeMillis();
    f.a(false);
    try
    {
      Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
      Debug.getMemoryInfo(localMemoryInfo);
      int i = localMemoryInfo.getTotalPss();
      f.a(TXCTimeUtil.getTimeTick());
      f.b(i / 1024);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.util.f.2
 * JD-Core Version:    0.7.0.1
 */