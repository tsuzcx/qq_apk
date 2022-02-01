package com.tencent.mobileqq.app.utils;

import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

public class PokeBigResHandler$NetEngine
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 0) {
      ThreadManagerV2.excute(new PokeBigResHandler.NetEngine.1(this, paramNetResp.mReq.mOutPath), 64, null, true);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("req:[");
    localStringBuilder.append(paramNetReq.toString());
    localStringBuilder.append("\n curOffset");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("\n totalLen");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("]");
    Log.e("Ron", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.PokeBigResHandler.NetEngine
 * JD-Core Version:    0.7.0.1
 */