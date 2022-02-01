package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerSdkMgr;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.WSPlayerWrapHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;

public class WSVideoPluginInstall
{
  private static volatile boolean d;
  private WSVideoPluginInstall.OnVideoPluginInstallListener a;
  private IWSPlayerSdkMgr b = WSPlayerWrapHelper.a().c();
  private boolean c;
  private Handler e = new Handler(new WSVideoPluginInstall.3(this));
  
  public WSVideoPluginInstall()
  {
    ThreadManager.executeOnSubThread(new WSVideoPluginInstall.1(this));
  }
  
  private void e()
  {
    this.b.a();
    try
    {
      if (!d)
      {
        this.b.a(BaseApplicationImpl.getContext());
        WSLog.f("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][initVideoSDK] finish!");
        d = true;
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    boolean bool = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVideoPluginInstall.java][installPlugin] isPluginInstalled:");
    localStringBuilder.append(bool);
    localStringBuilder.append(", mIsInstalling:");
    localStringBuilder.append(this.c);
    WSLog.e("WS_VIDEO_WSVideoPluginInstall", localStringBuilder.toString());
    if ((!bool) && (!this.c)) {
      ThreadManager.post(new WSVideoPluginInstall.2(this), 8, null, true);
    }
  }
  
  public void a(WSVideoPluginInstall.OnVideoPluginInstallListener paramOnVideoPluginInstallListener)
  {
    this.a = paramOnVideoPluginInstallListener;
  }
  
  public boolean b()
  {
    return this.b.b(BaseApplicationImpl.getContext());
  }
  
  public void c()
  {
    this.a = null;
    this.e.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall
 * JD-Core Version:    0.7.0.1
 */