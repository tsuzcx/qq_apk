package com.tencent.av.opengl.effects;

import com.tencent.av.AVLog;
import com.tencent.av.AVPathUtil;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class EffectFilterTools$MyHttpListener
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (EffectFilterTools.FilterDesc)paramNetResp.mReq.getUserData();
    AVLog.printColorLog("EffectFilterTools", "download file call back. file = " + ((EffectFilterTools.FilterDesc)localObject).a);
    if (paramNetResp.mResult != 0)
    {
      AVLog.printColorLog("EffectFilterTools", "download file faild. errcode = " + paramNetResp.mErrCode);
      return;
    }
    if (!((EffectFilterTools.FilterDesc)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
    {
      AVLog.printColorLog("EffectFilterTools", "download file faild : md5 is not match.");
      FileUtils.e(paramNetResp.mReq.mOutPath);
      return;
    }
    AVLog.printColorLog("EffectFilterTools", "download file successed.");
    try
    {
      localObject = AVPathUtil.e();
      FileUtils.a(paramNetResp.mReq.mOutPath, (String)localObject, false);
      FileUtils.e(paramNetResp.mReq.mOutPath);
      return;
    }
    catch (IOException paramNetResp)
    {
      paramNetResp.printStackTrace();
      AVLog.printColorLog("EffectFilterTools", "unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectFilterTools.MyHttpListener
 * JD-Core Version:    0.7.0.1
 */