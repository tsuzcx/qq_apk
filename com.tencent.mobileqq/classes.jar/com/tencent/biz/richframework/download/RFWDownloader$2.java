package com.tencent.biz.richframework.download;

import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.FileUtils;
import java.io.File;
import java.util.Set;

class RFWDownloader$2
  implements Runnable
{
  RFWDownloader$2(RFWDownloader paramRFWDownloader, String paramString, RFWDownloader.RFWDownloadListener paramRFWDownloadListener) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.getContentFilePath(this.val$downloadUrl);
    Object localObject1 = new File((String)localObject2);
    if (SdCardUtil.getSdCardDirectory() == null)
    {
      QLog.i("RFWDownloader", 1, "getFile error, SdCardUtil.getSdCardDirectory() == null");
      RFWDownloader.RFWDownloadListener localRFWDownloadListener = this.val$downloadListener;
      if (localRFWDownloadListener != null) {
        localRFWDownloadListener.onRspCallback(false, "");
      }
    }
    if (this.this$0.isFileDownLoaded(this.val$downloadUrl))
    {
      localObject1 = this.val$downloadListener;
      if (localObject1 != null) {
        ((RFWDownloader.RFWDownloadListener)localObject1).onRspCallback(true, (String)localObject2);
      }
    }
    else
    {
      localObject2 = this.val$downloadListener;
      if (localObject2 != null) {
        RFWDownloader.access$100(this.this$0, this.val$downloadUrl, (RFWDownloader.RFWDownloadListener)localObject2);
      }
      localObject2 = RFWDownloader.access$200(this.this$0, this.val$downloadUrl);
      if (RFWDownloader.access$300(this.this$0).contains(this.val$downloadUrl))
      {
        RFWDownloader.access$400(this.this$0, (RFWDownloadInfo)localObject2, new Object[] { "getFile ..., file is downloading" });
        return;
      }
      FileUtils.deleteFile((File)localObject1);
      RFWDownloader.access$400(this.this$0, (RFWDownloadInfo)localObject2, new Object[] { "getFile ..., start download" });
      RFWDownloader.access$500(this.this$0, (RFWDownloadInfo)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.2
 * JD-Core Version:    0.7.0.1
 */