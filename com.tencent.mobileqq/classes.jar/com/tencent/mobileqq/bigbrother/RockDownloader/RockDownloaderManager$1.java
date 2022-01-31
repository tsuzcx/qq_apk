package com.tencent.mobileqq.bigbrother.RockDownloader;

import amap;
import com.tencent.qphone.base.util.QLog;

public class RockDownloaderManager$1
  implements Runnable
{
  public RockDownloaderManager$1(amap paramamap) {}
  
  public void run()
  {
    try
    {
      amap.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RockDownloaderManager", 2, "autoCleanOverdueFile exception, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderManager.1
 * JD-Core Version:    0.7.0.1
 */