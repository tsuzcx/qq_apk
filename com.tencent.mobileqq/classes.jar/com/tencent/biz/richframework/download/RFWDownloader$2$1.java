package com.tencent.biz.richframework.download;

import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Set;
import nwp;

class RFWDownloader$2$1
  implements INetEngine.INetEngineListener
{
  RFWDownloader$2$1(RFWDownloader.2 param2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    RFWDownloader.access$100(this.this$1.this$0).remove(this.this$1.val$downloadUrl);
    QLog.i("RFWDownloader", 1, "download  onResp url:  resultcode: " + paramNetResp.mHttpCode);
    QLog.i("RFWDownloader", 1, "downloadFinish downloadSavePath" + this.this$1.val$downloadSavePath);
    if (RFWDownloader.access$300(this.this$1.this$0, this.this$1.val$downloadUrl)) {
      try
      {
        paramNetResp = this.this$1.this$0.getUnZipPath(this.this$1.val$downloadUrl);
        File localFile = new File(this.this$1.val$downloadSavePath);
        QLog.d("RFWDownloader", 4, "start unzip file to folderPath:" + paramNetResp);
        nwp.a(localFile, paramNetResp);
        FileUtils.deleteFile(localFile);
        QLog.i("RFWDownloader", 1, "unzip success");
        RFWDownloader.access$400(this.this$1.this$0, this.this$1.val$downloadUrl, this.this$1.val$fileMd5);
        RFWDownloader.access$500(this.this$1.this$0, this.this$1.val$downloadUrl, true, paramNetResp);
        return;
      }
      catch (Exception paramNetResp)
      {
        RFWDownloader.access$500(this.this$1.this$0, this.this$1.val$downloadUrl, false, "");
        QLog.i("DownLoadZipFile", 1, "unzip file failed" + paramNetResp);
        return;
      }
    }
    QLog.i("RFWDownloader", 1, "is not zip file, not need upzip");
    RFWDownloader.access$400(this.this$1.this$0, this.this$1.val$downloadUrl, this.this$1.val$fileMd5);
    RFWDownloader.access$500(this.this$1.this$0, this.this$1.val$downloadUrl, true, this.this$1.val$downloadSavePath);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.2.1
 * JD-Core Version:    0.7.0.1
 */