package com.tencent.biz.richframework.download;

import bfys;
import com.tencent.qphone.base.util.QLog;

class RFWDownloader$3
  implements Runnable
{
  RFWDownloader$3(RFWDownloader paramRFWDownloader, RFWDownloader.GetFileListener paramGetFileListener, String paramString) {}
  
  public void run()
  {
    if (bfys.a() == null)
    {
      QLog.i("RFWDownloader", 1, "downloadOrUpdateFile error, SdCardUtil.getSdCardDirectory() == null");
      if (this.val$downloadListener != null) {
        this.val$downloadListener.onRspCallback(false, "");
      }
    }
    if (this.val$downloadListener != null) {
      RFWDownloader.access$000(this.this$0, this.val$downloadUrl, this.val$downloadListener);
    }
    this.this$0.checkResource(this.val$downloadUrl, new RFWDownloader.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.3
 * JD-Core Version:    0.7.0.1
 */