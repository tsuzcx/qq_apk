package com.tencent.aelight.camera.aebase;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

final class AECameraPlugin$5
  implements INetEngineListener
{
  AECameraPlugin$5(INetEngineListener paramINetEngineListener) {}
  
  public void onResp(NetResp paramNetResp)
  {
    INetEngineListener localINetEngineListener = this.a;
    if (localINetEngineListener != null) {
      localINetEngineListener.onResp(paramNetResp);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    INetEngineListener localINetEngineListener = this.a;
    if (localINetEngineListener != null) {
      localINetEngineListener.onUpdateProgeress(paramNetReq, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.AECameraPlugin.5
 * JD-Core Version:    0.7.0.1
 */