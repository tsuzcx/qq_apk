package com.tencent.aekit.api.standard;

import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.ttpic.baseutils.device.DeviceAttrs.UpdateListener;
import com.tencent.ttpic.baseutils.device.DeviceInstance.SOC_CLASS;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;

class AEModule$2$1
  implements DeviceAttrs.UpdateListener
{
  AEModule$2$1(AEModule.2 param2) {}
  
  public void onFailed(String paramString)
  {
    AEOpenRenderConfig.checkStrictMode(false, "phone_attrs_config.dat decrypt faild.");
    LogUtils.w("AEKitModule", "[DeviceAttrs update][onFailed] errorMsg = " + paramString);
  }
  
  public void onSuccess(String paramString)
  {
    DeviceInstance.SOC_CLASS localSOC_CLASS = DeviceUtils.getDeviceSocClass(AEModule.getContext());
    LogUtils.e("AEKitModule", "updateDeviceInfo socClass = " + localSOC_CLASS.desc);
    LogUtils.d("AEKitModule", "[DeviceAttrs update][onSuccess] okMsg = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.AEModule.2.1
 * JD-Core Version:    0.7.0.1
 */