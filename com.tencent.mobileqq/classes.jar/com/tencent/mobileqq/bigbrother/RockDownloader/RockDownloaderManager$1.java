package com.tencent.mobileqq.bigbrother.RockDownloader;

import aqjs;
import com.tencent.qphone.base.util.QLog;

public class RockDownloaderManager$1
  implements Runnable
{
  public RockDownloaderManager$1(aqjs paramaqjs) {}
  
  public void run()
  {
    try
    {
      aqjs.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RockDownloaderManager", 2, "autoCleanOverdueFile exception, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderManager.1
 * JD-Core Version:    0.7.0.1
 */