package com.tencent.av.opengl.effects;

import com.tencent.av.AVLog;
import com.tencent.av.AVPathUtil;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class EffectBeautyTools$MyHttpListener
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (EffectBeautyTools.SkinColorFilterDesc)paramNetResp.mReq.getUserData();
    AVLog.printColorLog("EffectBeautyTools", "download file call back. file = " + ((EffectBeautyTools.SkinColorFilterDesc)localObject).a);
    if (paramNetResp.mResult != 0)
    {
      AVLog.printColorLog("EffectBeautyTools", "download file faild. errcode = " + paramNetResp.mErrCode);
      return;
    }
    if (!((EffectBeautyTools.SkinColorFilterDesc)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
    {
      AVLog.printColorLog("EffectBeautyTools", "download file faild : md5 is not match.");
      FileUtils.e(paramNetResp.mReq.mOutPath);
      return;
    }
    AVLog.printColorLog("EffectBeautyTools", "download file successed.");
    try
    {
      localObject = AVPathUtil.i();
      FileUtils.a(paramNetResp.mReq.mOutPath, (String)localObject, false);
      FileUtils.e(paramNetResp.mReq.mOutPath);
      return;
    }
    catch (IOException paramNetResp)
    {
      paramNetResp.printStackTrace();
      AVLog.printColorLog("EffectBeautyTools", "unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectBeautyTools.MyHttpListener
 * JD-Core Version:    0.7.0.1
 */