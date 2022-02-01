package com.tencent.mobileqq.bigbrother.RockDownloader;

import com.tencent.qphone.base.util.QLog;

class RockDownloaderManager$1
  implements Runnable
{
  RockDownloaderManager$1(RockDownloaderManager paramRockDownloaderManager) {}
  
  public void run()
  {
    try
    {
      RockDownloaderManager.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloaderManager", 2, "autoCleanOverdueFile exception, ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderManager.1
 * JD-Core Version:    0.7.0.1
 */