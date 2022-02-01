package com.tencent.hippy.qq.update.sso;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class HippyUnissoHandler$1
  implements WadlTrpcListener
{
  HippyUnissoHandler$1(HippyUnissoHandler paramHippyUnissoHandler) {}
  
  public HashSet<String> getFilterCmds()
  {
    return new HippyUnissoHandler.1.1(this);
  }
  
  public void onTrpcRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hippyUpdateAction-");
      ((StringBuilder)localObject).append(HippyUnissoHandler.access$000());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WadlTrpcListener onTrpcRsp cmd:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ret:");
      localStringBuilder.append(paramLong);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
    }
    if ("/v1/33".equals(paramString)) {
      HippyUpdateManager.getInstance().handleAllResponses(paramIntent, paramLong, paramTrpcInovkeRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.sso.HippyUnissoHandler.1
 * JD-Core Version:    0.7.0.1
 */