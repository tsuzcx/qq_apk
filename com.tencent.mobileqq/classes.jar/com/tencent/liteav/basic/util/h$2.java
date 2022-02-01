package com.tencent.liteav.basic.util;

import android.os.Debug;
import android.os.Debug.MemoryInfo;

final class h$2
  implements Runnable
{
  public void run()
  {
    System.currentTimeMillis();
    h.a(false);
    try
    {
      Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
      Debug.getMemoryInfo(localMemoryInfo);
      int i = localMemoryInfo.getTotalPss();
      h.a(TXCTimeUtil.getTimeTick());
      h.b(i / 1024);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.h.2
 * JD-Core Version:    0.7.0.1
 */