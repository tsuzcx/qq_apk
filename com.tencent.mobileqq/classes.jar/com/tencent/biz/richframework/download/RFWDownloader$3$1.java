package com.tencent.biz.richframework.download;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import java.util.Set;

class RFWDownloader$3$1
  implements RFWCheckResourceListener
{
  RFWDownloader$3$1(RFWDownloader.3 param3) {}
  
  public void onCheckResult(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if ((!paramBoolean2) || (paramBoolean3))
    {
      if (RFWDownloader.access$300(this.this$1.this$0).contains(this.this$1.val$downloadUrl))
      {
        RFLog.i("RFWDownloader", RFLog.USR, "getFile ..., file is downloading");
        return;
      }
      RFLog.i("RFWDownloader", RFLog.USR, "getFile ..., start download");
      RFWDownloadInfo localRFWDownloadInfo = RFWDownloader.access$200(this.this$1.this$0, this.this$1.val$downloadUrl);
      localRFWDownloadInfo.setMD5(paramString);
      RFWDownloader.access$500(this.this$1.this$0, localRFWDownloadInfo);
      return;
    }
    paramString = this.this$1.this$0.getContentFilePath(this.this$1.val$downloadUrl);
    RFLog.i("RFWDownloader", RFLog.USR, "getFile success, the file is exist path:" + paramString);
    RFWDownloader.access$600(this.this$1.this$0, this.this$1.val$downloadUrl, true, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.3.1
 * JD-Core Version:    0.7.0.1
 */