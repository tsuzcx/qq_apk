package com.tencent.biz.richframework.download;

import bfys;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Set;

class RFWDownloader$1
  implements Runnable
{
  RFWDownloader$1(RFWDownloader paramRFWDownloader, String paramString, RFWDownloader.GetFileListener paramGetFileListener) {}
  
  public void run()
  {
    String str = this.this$0.getUnZipPath(this.val$downloadUrl);
    File localFile = new File(str);
    if (bfys.a() == null)
    {
      QLog.i("RFWDownloader", 1, "getFile error, SdCardUtil.getSdCardDirectory() == null");
      if (this.val$downloadListener != null) {
        this.val$downloadListener.onRspCallback(false, "");
      }
    }
    if (this.this$0.isFileDownLoaded(this.val$downloadUrl))
    {
      QLog.i("RFWDownloader", 1, "getFile success, the file is exist path:" + str);
      if (this.val$downloadListener != null) {
        this.val$downloadListener.onRspCallback(true, str);
      }
      return;
    }
    if (this.val$downloadListener != null) {
      RFWDownloader.access$000(this.this$0, this.val$downloadUrl, this.val$downloadListener);
    }
    if (RFWDownloader.access$100(this.this$0).contains(this.val$downloadUrl))
    {
      QLog.i("RFWDownloader", 1, "getFile ..., file is downloading");
      return;
    }
    FileUtils.deleteFile(localFile);
    QLog.i("RFWDownloader", 1, "getFile ..., start download");
    RFWDownloader.access$200(this.this$0, this.val$downloadUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.1
 * JD-Core Version:    0.7.0.1
 */