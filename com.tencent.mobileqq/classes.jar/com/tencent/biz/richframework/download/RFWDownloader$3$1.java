package com.tencent.biz.richframework.download;

import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class RFWDownloader$3$1
  implements RFWCheckResourceListener
{
  RFWDownloader$3$1(RFWDownloader.3 param3) {}
  
  public void onCheckResult(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if ((!paramBoolean2) || (paramBoolean3))
    {
      if (RFWDownloader.access$100(this.this$1.this$0).contains(this.this$1.val$downloadUrl))
      {
        QLog.i("RFWDownloader", 1, "getFile ..., file is downloading");
        return;
      }
      QLog.i("RFWDownloader", 1, "getFile ..., start download");
      RFWDownloader.access$600(this.this$1.this$0, this.this$1.val$downloadUrl, paramString);
      return;
    }
    paramString = this.this$1.this$0.getUnZipPath(this.this$1.val$downloadUrl);
    QLog.i("RFWDownloader", 1, "getFile success, the file is exist path:" + paramString);
    RFWDownloader.access$500(this.this$1.this$0, this.this$1.val$downloadUrl, true, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.3.1
 * JD-Core Version:    0.7.0.1
 */