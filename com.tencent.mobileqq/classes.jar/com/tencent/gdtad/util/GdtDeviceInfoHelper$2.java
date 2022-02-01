package com.tencent.gdtad.util;

import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gathererga.core.IExecutor;

final class GdtDeviceInfoHelper$2
  implements IExecutor
{
  public void a(Runnable paramRunnable)
  {
    AdThreadManager.INSTANCE.post(paramRunnable, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceInfoHelper.2
 * JD-Core Version:    0.7.0.1
 */