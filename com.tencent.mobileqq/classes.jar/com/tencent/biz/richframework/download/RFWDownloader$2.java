package com.tencent.biz.richframework.download;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.utils.SdCardUtil;
import cooperation.qzone.util.FileUtils;
import java.io.File;
import java.util.Set;

class RFWDownloader$2
  implements Runnable
{
  RFWDownloader$2(RFWDownloader paramRFWDownloader, String paramString, RFWDownloader.RFWDownloadListener paramRFWDownloadListener) {}
  
  public void run()
  {
    Object localObject = this.this$0.getContentFilePath(this.val$downloadUrl);
    File localFile = new File((String)localObject);
    if (SdCardUtil.getSdCardDirectory() == null)
    {
      RFLog.i("RFWDownloader", RFLog.USR, "getFile error, SdCardUtil.getSdCardDirectory() == null");
      if (this.val$downloadListener != null) {
        this.val$downloadListener.onRspCallback(false, "");
      }
    }
    if (this.this$0.isFileDownLoaded(this.val$downloadUrl))
    {
      if (this.val$downloadListener != null) {
        this.val$downloadListener.onRspCallback(true, (String)localObject);
      }
      return;
    }
    if (this.val$downloadListener != null) {
      RFWDownloader.access$100(this.this$0, this.val$downloadUrl, this.val$downloadListener);
    }
    localObject = RFWDownloader.access$200(this.this$0, this.val$downloadUrl);
    if (RFWDownloader.access$300(this.this$0).contains(this.val$downloadUrl))
    {
      RFWDownloader.access$400(this.this$0, (RFWDownloadInfo)localObject, new Object[] { "getFile ..., file is downloading" });
      return;
    }
    FileUtils.deleteFile(localFile);
    RFWDownloader.access$400(this.this$0, (RFWDownloadInfo)localObject, new Object[] { "getFile ..., start download" });
    RFWDownloader.access$500(this.this$0, (RFWDownloadInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.2
 * JD-Core Version:    0.7.0.1
 */