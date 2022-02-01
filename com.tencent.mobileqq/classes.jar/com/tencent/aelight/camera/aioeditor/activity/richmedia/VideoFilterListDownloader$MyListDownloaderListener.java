package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class VideoFilterListDownloader$MyListDownloaderListener
  implements INetEngineListener
{
  VideoFilterListDownloader$MyListDownloaderListener(VideoFilterListDownloader paramVideoFilterListDownloader) {}
  
  public void onResp(NetResp paramNetResp)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramNetResp.mReq.getUserData();
    if (localFilterDesc != null)
    {
      int i = paramNetResp.mResult;
      boolean bool = false;
      Object localObject;
      if (i != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MyListDownloaderListener file failed. errorCode: ");
        ((StringBuilder)localObject).append(paramNetResp.mErrCode);
        ((StringBuilder)localObject).append(", errorMsg: ");
        ((StringBuilder)localObject).append(paramNetResp.mErrDesc);
        ((StringBuilder)localObject).append(", file: ");
        ((StringBuilder)localObject).append(localFilterDesc.resurl);
        QLog.e("VideoFilterListDownloader", 2, ((StringBuilder)localObject).toString());
        VideoFilterListDownloader.a(this.a, localFilterDesc, 0L, 5);
      }
      else if (!localFilterDesc.resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
      {
        QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed: md5 is not match.");
        FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MyListDownloaderListener resFile success. file: ");
        ((StringBuilder)localObject).append(localFilterDesc.name);
        ((StringBuilder)localObject).append(localFilterDesc.resurl);
        QLog.i("VideoFilterListDownloader", 2, ((StringBuilder)localObject).toString());
        try
        {
          localObject = CaptureVideoFilterManager.b;
          FileUtils.uncompressZip(paramNetResp.mReq.mOutPath, (String)localObject, false);
          if (localFilterDesc.bundle == null) {
            localFilterDesc.bundle = new Bundle();
          }
          VideoFilterListDownloader.a(this.a, localFilterDesc, FileUtils.getFileSizes(paramNetResp.mReq.mOutPath), 0);
          FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
          bool = true;
        }
        catch (IOException paramNetResp)
        {
          paramNetResp.printStackTrace();
          QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener  unzip file failed.");
          VideoFilterListDownloader.a(this.a, localFilterDesc, 0L, 4);
        }
      }
      VideoFilterListDownloader.a(this.a, localFilterDesc, bool);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterListDownloader.MyListDownloaderListener
 * JD-Core Version:    0.7.0.1
 */