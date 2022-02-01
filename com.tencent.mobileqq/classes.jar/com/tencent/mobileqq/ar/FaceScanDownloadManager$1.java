package com.tencent.mobileqq.ar;

final class FaceScanDownloadManager$1
  implements Runnable
{
  FaceScanDownloadManager$1(FaceScanDownloadManager.DownloadCallback paramDownloadCallback, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    FaceScanDownloadManager.DownloadCallback localDownloadCallback = this.a;
    if (localDownloadCallback != null) {
      localDownloadCallback.a(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FaceScanDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */