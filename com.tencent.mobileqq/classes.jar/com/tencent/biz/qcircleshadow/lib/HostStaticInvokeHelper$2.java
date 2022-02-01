package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.flutter.download.InstallCallback;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.FlutterInstallCallBack;

final class HostStaticInvokeHelper$2
  implements InstallCallback
{
  HostStaticInvokeHelper$2(FlutterInstallCallBack paramFlutterInstallCallBack) {}
  
  public void onProgress(int paramInt)
  {
    this.val$callBack.onProgress(paramInt);
  }
  
  public void onResult(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.val$callBack.onResult(paramBoolean1, paramString, paramBoolean2, paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.2
 * JD-Core Version:    0.7.0.1
 */