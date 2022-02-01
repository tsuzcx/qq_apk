package com.tencent.av.opengl.effects;

import com.tencent.av.AVLog;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

class EffectFilterTools$MyIconHttpListener
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    EffectFilterTools.FilterDesc localFilterDesc = (EffectFilterTools.FilterDesc)paramNetResp.mReq.getUserData();
    if (paramNetResp.mResult != 0)
    {
      AVLog.printColorLog("EffectFilterTools", "download IconFile. errcode = " + paramNetResp.mErrCode + "|" + localFilterDesc.e);
      return;
    }
    AVLog.printColorLog("EffectFilterTools", "download IconFile OK " + localFilterDesc.e);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectFilterTools.MyIconHttpListener
 * JD-Core Version:    0.7.0.1
 */