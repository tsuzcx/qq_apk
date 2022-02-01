package com.tencent.imsdk.common;

import android.os.Debug;
import android.os.Debug.MemoryInfo;
import com.tencent.imsdk.manager.BaseManager;

final class SystemUtil$1
  implements Runnable
{
  public void run()
  {
    System.currentTimeMillis();
    SystemUtil.access$002(false);
    try
    {
      Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
      Debug.getMemoryInfo(localMemoryInfo);
      int i = localMemoryInfo.getTotalPss();
      SystemUtil.access$102(BaseManager.getInstance().getTimeTick());
      SystemUtil.access$202(i / 1024);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.SystemUtil.1
 * JD-Core Version:    0.7.0.1
 */