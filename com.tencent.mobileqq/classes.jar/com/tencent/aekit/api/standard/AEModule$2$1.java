package com.tencent.aekit.api.standard;

import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.ttpic.baseutils.device.DeviceAttrs.UpdateListener;
import com.tencent.ttpic.baseutils.device.DeviceInstance.SOC_CLASS;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.device.DeviceUtils;

class AEModule$2$1
  implements DeviceAttrs.UpdateListener
{
  AEModule$2$1(AEModule.2 param2) {}
  
  public void onFailed(String paramString)
  {
    AEOpenRenderConfig.checkStrictMode(false, "phone_attrs_config.dat decrypt faild.");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DeviceAttrs update][onFailed] errorMsg = ");
    localStringBuilder.append(paramString);
    LogUtils.w("AEKitModule", localStringBuilder.toString());
  }
  
  public void onSuccess(String paramString)
  {
    Object localObject = DeviceUtils.getDeviceSocClass(AEModule.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateDeviceInfo socClass = ");
    localStringBuilder.append(((DeviceInstance.SOC_CLASS)localObject).desc);
    LogUtils.e("AEKitModule", localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[DeviceAttrs update][onSuccess] okMsg = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtils.d("AEKitModule", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.AEModule.2.1
 * JD-Core Version:    0.7.0.1
 */