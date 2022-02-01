package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.offlinePush.EnterBackgroundParam;
import com.tencent.imsdk.offlinePush.EnterForegroundParam;
import com.tencent.imsdk.offlinePush.OfflinePushManager;
import com.tencent.imsdk.offlinePush.OfflinePushToken;

public class V2TIMOfflinePushManagerImpl
  extends V2TIMOfflinePushManager
{
  private final String TAG = "V2TIMOfflinePushManagerImpl";
  
  static V2TIMOfflinePushManagerImpl getInstance()
  {
    return V2TIMOfflinePushManagerImpl.V2TIMOfflinePushManagerImplHolder.access$000();
  }
  
  public void doBackground(int paramInt, V2TIMCallback paramV2TIMCallback)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = SystemUtil.getInstanceType();
    EnterBackgroundParam localEnterBackgroundParam = new EnterBackgroundParam();
    localEnterBackgroundParam.setC2cUnreadMessageCount(i);
    localEnterBackgroundParam.setDeviceBrand(paramInt);
    OfflinePushManager.getInstance().doEnterBackground(localEnterBackgroundParam, new V2TIMOfflinePushManagerImpl.2(this, paramV2TIMCallback));
  }
  
  public void doForeground(V2TIMCallback paramV2TIMCallback)
  {
    int i = SystemUtil.getInstanceType();
    EnterForegroundParam localEnterForegroundParam = new EnterForegroundParam();
    localEnterForegroundParam.setDeviceBrand(i);
    OfflinePushManager.getInstance().doEnterForeground(localEnterForegroundParam, new V2TIMOfflinePushManagerImpl.3(this, paramV2TIMCallback));
  }
  
  public void setOfflinePushConfig(V2TIMOfflinePushConfig paramV2TIMOfflinePushConfig, V2TIMCallback paramV2TIMCallback)
  {
    if (paramV2TIMOfflinePushConfig == null)
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "config is null");
      }
      IMLog.e("V2TIMOfflinePushManagerImpl", "setOfflinePushConfig config is null");
      return;
    }
    int i = SystemUtil.getInstanceType();
    paramV2TIMOfflinePushConfig.getOfflinePushToken().setDeviceBrand(i);
    OfflinePushManager.getInstance().setOfflinePushToken(paramV2TIMOfflinePushConfig.getOfflinePushToken(), new V2TIMOfflinePushManagerImpl.1(this, paramV2TIMCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMOfflinePushManagerImpl
 * JD-Core Version:    0.7.0.1
 */