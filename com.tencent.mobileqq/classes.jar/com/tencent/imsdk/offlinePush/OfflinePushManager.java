package com.tencent.imsdk.offlinePush;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.manager.BaseManager;

public class OfflinePushManager
{
  public static OfflinePushManager getInstance()
  {
    return OfflinePushManager.OfflinePushManagerHolder.access$000();
  }
  
  public void doEnterBackground(EnterBackgroundParam paramEnterBackgroundParam, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDoEnterBackground(paramEnterBackgroundParam, paramIMCallback);
  }
  
  public void doEnterForeground(EnterForegroundParam paramEnterForegroundParam, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDoEnterForeground(paramEnterForegroundParam, paramIMCallback);
  }
  
  public void getOfflinePushConfig(IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetOfflinePushConfig(paramIMCallback);
  }
  
  protected native void nativeDoEnterBackground(EnterBackgroundParam paramEnterBackgroundParam, IMCallback paramIMCallback);
  
  protected native void nativeDoEnterForeground(EnterForegroundParam paramEnterForegroundParam, IMCallback paramIMCallback);
  
  protected native void nativeGetOfflinePushConfig(IMCallback paramIMCallback);
  
  protected native void nativeSetOfflinePushConfig(OfflinePushConfig paramOfflinePushConfig, IMCallback paramIMCallback);
  
  protected native void nativeSetOfflinePushToken(OfflinePushToken paramOfflinePushToken, IMCallback paramIMCallback);
  
  public void setOfflinePushConfig(OfflinePushConfig paramOfflinePushConfig, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetOfflinePushConfig(paramOfflinePushConfig, paramIMCallback);
  }
  
  public void setOfflinePushToken(OfflinePushToken paramOfflinePushToken, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetOfflinePushToken(paramOfflinePushToken, paramIMCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.offlinePush.OfflinePushManager
 * JD-Core Version:    0.7.0.1
 */