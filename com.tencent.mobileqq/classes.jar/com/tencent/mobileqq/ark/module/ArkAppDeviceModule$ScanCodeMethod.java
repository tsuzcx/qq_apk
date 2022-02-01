package com.tencent.mobileqq.ark.module;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.BaseApplication;

class ArkAppDeviceModule$ScanCodeMethod
  implements ArkAppDeviceModule.DeviceMethodWrap
{
  private ArkAppDeviceModule$ScanCodeMethod(ArkAppDeviceModule paramArkAppDeviceModule) {}
  
  public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    long l;
    if (("ScanCode".equals(paramString)) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
    {
      if (!paramArrayOfVariantWrapper[0].IsFunction()) {
        return false;
      }
      l = this.a.a(paramArrayOfVariantWrapper[0].Copy());
      paramString = new Intent();
      paramString.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.qrscan.activity.ScannerActivity");
      paramString.putExtra("from", "com.tencent.ark.scan");
      if (ArkAppDeviceModule.a(this.a) == null) {}
    }
    try
    {
      BaseApplication.getContext().unregisterReceiver(ArkAppDeviceModule.a(this.a));
      label94:
      ArkAppDeviceModule.a(this.a, null);
      ArkAppDeviceModule.a(this.a, new ArkAppDeviceModule.ScanCodeMethod.1(this, l));
      paramArrayOfVariantWrapper = new IntentFilter("com.tencent.mobileqq.ark.api.scanResultAction");
      BaseApplication.getContext().registerReceiver(ArkAppDeviceModule.a(this.a), paramArrayOfVariantWrapper, "com.tencent.msg.permission.pushnotify", null);
      paramArrayOfVariantWrapper = ArkAppModuleBase.b();
      if (paramArrayOfVariantWrapper != null) {
        paramArrayOfVariantWrapper.startActivity(paramString);
      }
      return false;
    }
    catch (Exception paramArrayOfVariantWrapper)
    {
      break label94;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ScanCodeMethod
 * JD-Core Version:    0.7.0.1
 */