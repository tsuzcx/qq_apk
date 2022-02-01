package com.tencent.aelight.camera.aioeditor.richmedia.capture.data;

import com.tencent.av.AVLog;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class CaptureVideoFilterManager$MyHttpListener
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (FilterDesc)paramNetResp.mReq.getUserData();
    if (paramNetResp.mResult != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download file failed. errorCode: ");
      localStringBuilder.append(paramNetResp.mErrCode);
      localStringBuilder.append(", errorMsg: ");
      localStringBuilder.append(paramNetResp.mErrDesc);
      localStringBuilder.append(", file: ");
      localStringBuilder.append(((FilterDesc)localObject).resurl);
      AVLog.printColorLog("CaptureVideoFilterManager", localStringBuilder.toString());
      return;
    }
    if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
    {
      AVLog.printColorLog("CaptureVideoFilterManager", "download file failed: md5 is not match.");
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download resFile success. file: ");
    localStringBuilder.append(((FilterDesc)localObject).resurl);
    AVLog.printColorLog("CaptureVideoFilterManager", localStringBuilder.toString());
    try
    {
      localObject = CaptureVideoFilterManager.b;
      FileUtils.uncompressZip(paramNetResp.mReq.mOutPath, (String)localObject, false);
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      if ((CaptureVideoFilterManager.a(this.a).decrementAndGet() == 0) && (CaptureVideoFilterManager.b(this.a) != null))
      {
        CaptureVideoFilterManager.b(this.a).a(true);
        return;
      }
    }
    catch (IOException paramNetResp)
    {
      paramNetResp.printStackTrace();
      AVLog.printColorLog("CaptureVideoFilterManager", "unzip file failed.");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureVideoFilterManager.MyHttpListener
 * JD-Core Version:    0.7.0.1
 */