package com.tencent.mfsdk.impls.memory;

import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMModuleLeak;

class MemoryDumpHelper$7
  implements Runnable
{
  public void run()
  {
    MagnifierSDK.b().c().a(System.currentTimeMillis(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper.7
 * JD-Core Version:    0.7.0.1
 */