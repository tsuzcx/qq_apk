package com.tencent.biz.richframework.download;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.utils.SdCardUtil;

class RFWDownloader$3
  implements Runnable
{
  RFWDownloader$3(RFWDownloader paramRFWDownloader, RFWDownloader.RFWDownloadListener paramRFWDownloadListener, String paramString) {}
  
  public void run()
  {
    if (SdCardUtil.getSdCardDirectory() == null)
    {
      RFLog.i("RFWDownloader", RFLog.USR, "downloadOrUpdateFile error, SdCardUtil.getSdCardDirectory() == null");
      if (this.val$downloadListener != null) {
        this.val$downloadListener.onRspCallback(false, "");
      }
    }
    if (this.val$downloadListener != null) {
      RFWDownloader.access$100(this.this$0, this.val$downloadUrl, this.val$downloadListener);
    }
    RFWDownloader.access$700(this.this$0, this.val$downloadUrl, new RFWDownloader.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.3
 * JD-Core Version:    0.7.0.1
 */