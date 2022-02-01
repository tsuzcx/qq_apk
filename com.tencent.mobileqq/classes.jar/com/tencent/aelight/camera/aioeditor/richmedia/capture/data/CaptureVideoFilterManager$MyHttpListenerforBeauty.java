package com.tencent.aelight.camera.aioeditor.richmedia.capture.data;

import com.tencent.av.AVLog;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class CaptureVideoFilterManager$MyHttpListenerforBeauty
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (CaptureVideoFilterManager.SkinColorFilterDesc)paramNetResp.mReq.getUserData();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download file call back. file = ");
    localStringBuilder.append(((CaptureVideoFilterManager.SkinColorFilterDesc)localObject).a);
    AVLog.printColorLog("CaptureVideoFilterManager", localStringBuilder.toString());
    if (paramNetResp.mResult != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download file faild. errcode = ");
      ((StringBuilder)localObject).append(paramNetResp.mErrCode);
      AVLog.printColorLog("CaptureVideoFilterManager", ((StringBuilder)localObject).toString());
      return;
    }
    if (!((CaptureVideoFilterManager.SkinColorFilterDesc)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
    {
      AVLog.printColorLog("CaptureVideoFilterManager", "download file faild : md5 is not match.");
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      return;
    }
    AVLog.printColorLog("CaptureVideoFilterManager", "download file successed.");
    try
    {
      localObject = CaptureVideoFilterManager.d();
      FileUtils.uncompressZip(paramNetResp.mReq.mOutPath, (String)localObject, false);
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      return;
    }
    catch (IOException paramNetResp)
    {
      paramNetResp.printStackTrace();
      AVLog.printColorLog("CaptureVideoFilterManager", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureVideoFilterManager.MyHttpListenerforBeauty
 * JD-Core Version:    0.7.0.1
 */