package com.tencent.biz.richframework.download;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import java.util.Set;

class RFWDownloader$3$1
  implements RFWCheckResourceListener
{
  RFWDownloader$3$1(RFWDownloader.3 param3) {}
  
  public void onCheckResult(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if ((paramBoolean2) && (!paramBoolean3))
    {
      paramString = this.this$1.this$0.getContentFilePath(this.this$1.val$downloadUrl);
      int i = RFLog.USR;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFile success, the file is exist path:");
      ((StringBuilder)localObject).append(paramString);
      RFLog.i("RFWDownloader", i, ((StringBuilder)localObject).toString());
      RFWDownloader.access$600(this.this$1.this$0, this.this$1.val$downloadUrl, true, paramString);
      return;
    }
    if (RFWDownloader.access$300(this.this$1.this$0).contains(this.this$1.val$downloadUrl))
    {
      RFLog.i("RFWDownloader", RFLog.USR, "getFile ..., file is downloading");
      return;
    }
    RFLog.i("RFWDownloader", RFLog.USR, "getFile ..., start download");
    Object localObject = RFWDownloader.access$200(this.this$1.this$0, this.this$1.val$downloadUrl);
    ((RFWDownloadInfo)localObject).setMD5(paramString);
    RFWDownloader.access$500(this.this$1.this$0, (RFWDownloadInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.3.1
 * JD-Core Version:    0.7.0.1
 */