package com.tencent.mobileqq.ar;

final class FaceScanDownloadManager$1
  implements Runnable
{
  FaceScanDownloadManager$1(FaceScanDownloadManager.DownloadCallback paramDownloadCallback, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    FaceScanDownloadManager.DownloadCallback localDownloadCallback = this.jdField_a_of_type_ComTencentMobileqqArFaceScanDownloadManager$DownloadCallback;
    if (localDownloadCallback != null) {
      localDownloadCallback.a(this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FaceScanDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */