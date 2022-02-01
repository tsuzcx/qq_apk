package com.tencent.falco.base.libapi.wxsdk;

import android.app.Activity;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface WxSdkInterface
  extends ServiceBaseInterface
{
  public abstract boolean isWxInstalled();
  
  public abstract void login(WxLoginCallback paramWxLoginCallback);
  
  public abstract void share(Activity paramActivity, WxShareType paramWxShareType, WxShareData paramWxShareData, WxShareListener paramWxShareListener);
  
  public abstract void shareToMiniProgram(Activity paramActivity, WxShareType paramWxShareType, WxMiniProgramData paramWxMiniProgramData, WxShareListener paramWxShareListener);
  
  public abstract void unRegisterCallback();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.wxsdk.WxSdkInterface
 * JD-Core Version:    0.7.0.1
 */