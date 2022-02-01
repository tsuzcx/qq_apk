package com.tencent.mobileqq.ar;

final class FaceScanDownloadManager$2
  implements Runnable
{
  FaceScanDownloadManager$2(FaceScanDownloadManager.DownloadCallback paramDownloadCallback, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    FaceScanDownloadManager.DownloadCallback localDownloadCallback = this.a;
    if (localDownloadCallback != null) {
      localDownloadCallback.a(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FaceScanDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */