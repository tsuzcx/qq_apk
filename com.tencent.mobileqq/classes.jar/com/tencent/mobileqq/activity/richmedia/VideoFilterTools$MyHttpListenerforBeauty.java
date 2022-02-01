package com.tencent.mobileqq.activity.richmedia;

import com.tencent.av.AVLog;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class VideoFilterTools$MyHttpListenerforBeauty
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (VideoFilterTools.SkinColorFilterDesc)paramNetResp.mReq.getUserData();
    AVLog.printColorLog("VideoFilterTools", "download file call back. file = " + ((VideoFilterTools.SkinColorFilterDesc)localObject).a);
    if (paramNetResp.mResult != 0)
    {
      AVLog.printColorLog("VideoFilterTools", "download file faild. errcode = " + paramNetResp.mErrCode);
      return;
    }
    if (!((VideoFilterTools.SkinColorFilterDesc)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
    {
      AVLog.printColorLog("VideoFilterTools", "download file faild : md5 is not match.");
      FileUtils.e(paramNetResp.mReq.mOutPath);
      return;
    }
    AVLog.printColorLog("VideoFilterTools", "download file successed.");
    try
    {
      localObject = VideoFilterTools.a();
      FileUtils.a(paramNetResp.mReq.mOutPath, (String)localObject, false);
      FileUtils.e(paramNetResp.mReq.mOutPath);
      return;
    }
    catch (IOException paramNetResp)
    {
      paramNetResp.printStackTrace();
      AVLog.printColorLog("VideoFilterTools", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.VideoFilterTools.MyHttpListenerforBeauty
 * JD-Core Version:    0.7.0.1
 */