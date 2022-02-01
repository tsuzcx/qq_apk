package com.tencent.gdtad.api.motivevideo;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.open.appstore.dl.DownloadManagerV2;

final class GdtMvDownloadBtnManager$2
  implements Runnable
{
  GdtMvDownloadBtnManager$2(String paramString) {}
  
  public void run()
  {
    if (DownloadManagerV2.a().a(this.a) == null) {
      GdtLog.a("GdtMvDownloadBtnManager", "run: taskInfoFromSDK == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnManager.2
 * JD-Core Version:    0.7.0.1
 */