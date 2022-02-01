package com.tencent.gdtad.api.motivevideo;

import acqy;
import java.lang.ref.WeakReference;

class GdtMvDownloadBtnManager$FirstLoadDataTask$1
  implements Runnable
{
  GdtMvDownloadBtnManager$FirstLoadDataTask$1(GdtMvDownloadBtnManager.FirstLoadDataTask paramFirstLoadDataTask, GdtMvAppBtnData paramGdtMvAppBtnData) {}
  
  public void run()
  {
    acqy.a("FirstLoadDataTask", "run() called");
    if (GdtMvDownloadBtnManager.FirstLoadDataTask.a(this.this$0)) {}
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager;
    do
    {
      return;
      localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)GdtMvDownloadBtnManager.FirstLoadDataTask.a(this.this$0).get();
    } while (localGdtMvDownloadBtnManager == null);
    GdtMvDownloadBtnManager.a(localGdtMvDownloadBtnManager, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnManager.FirstLoadDataTask.1
 * JD-Core Version:    0.7.0.1
 */