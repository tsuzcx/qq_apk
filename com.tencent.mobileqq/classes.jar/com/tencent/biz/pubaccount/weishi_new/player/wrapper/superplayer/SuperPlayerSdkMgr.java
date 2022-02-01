package com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerSdkMgr;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerSdkMgr.InstallListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;

public class SuperPlayerSdkMgr
  implements IWSPlayerSdkMgr, SDKInitListener
{
  private IWSPlayerSdkMgr.InstallListener a;
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    WSLog.e("WS_VIDEO_PLAYER", "[SuperPlayerSdkMgr.java][initSDK]");
    QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getContext(), this);
  }
  
  public void a(Context paramContext, IWSPlayerSdkMgr.InstallListener paramInstallListener)
  {
    WSLog.e("WS_VIDEO_PLAYER", "[SuperPlayerSdkMgr.java][installPlugin]");
    this.a = paramInstallListener;
    QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getContext(), this);
  }
  
  public boolean b(Context paramContext)
  {
    return QQVideoPlaySDKManager.isSDKReady();
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    IWSPlayerSdkMgr.InstallListener localInstallListener = this.a;
    if (localInstallListener == null) {
      return;
    }
    if (paramBoolean)
    {
      localInstallListener.a();
      return;
    }
    localInstallListener.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer.SuperPlayerSdkMgr
 * JD-Core Version:    0.7.0.1
 */