package com.tencent.biz.qcircleshadow.lib;

import auoi;

final class HostStaticInvokeHelper$2
  implements auoi
{
  HostStaticInvokeHelper$2(HostStaticInvokeHelper.FlutterInstallCallBack paramFlutterInstallCallBack) {}
  
  public void onProgress(int paramInt)
  {
    this.val$callBack.onProgress(paramInt);
  }
  
  public void onResult(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.val$callBack.onResult(paramBoolean1, paramString, paramBoolean2, paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.2
 * JD-Core Version:    0.7.0.1
 */