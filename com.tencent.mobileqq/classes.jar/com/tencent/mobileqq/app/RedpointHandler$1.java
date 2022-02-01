package com.tencent.mobileqq.app;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class RedpointHandler$1
  extends LbsManagerServiceOnLocationChangeListener
{
  RedpointHandler$1(RedpointHandler paramRedpointHandler, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLocationFinish errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",info:");
    ((StringBuilder)localObject).append(paramSosoLbsInfo);
    QLog.d("RedPointLog.RedpointHandler", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    RedpointHandler.a((RedpointHandler)localObject, paramInt, paramSosoLbsInfo, RedpointHandler.a((RedpointHandler)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RedpointHandler.1
 * JD-Core Version:    0.7.0.1
 */