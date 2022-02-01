package com.tencent.biz.richframework.download;

import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.qphone.base.util.QLog;

class RFWDownloader$3
  implements Runnable
{
  RFWDownloader$3(RFWDownloader paramRFWDownloader, RFWDownloader.RFWDownloadListener paramRFWDownloadListener, String paramString) {}
  
  public void run()
  {
    if (SdCardUtil.getSdCardDirectory() == null)
    {
      QLog.i("RFWDownloader", 1, "downloadOrUpdateFile error, SdCardUtil.getSdCardDirectory() == null");
      localRFWDownloadListener = this.val$downloadListener;
      if (localRFWDownloadListener != null) {
        localRFWDownloadListener.onRspCallback(false, "");
      }
    }
    RFWDownloader.RFWDownloadListener localRFWDownloadListener = this.val$downloadListener;
    if (localRFWDownloadListener != null) {
      RFWDownloader.access$100(this.this$0, this.val$downloadUrl, localRFWDownloadListener);
    }
    RFWDownloader.access$700(this.this$0, this.val$downloadUrl, new RFWDownloader.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.3
 * JD-Core Version:    0.7.0.1
 */