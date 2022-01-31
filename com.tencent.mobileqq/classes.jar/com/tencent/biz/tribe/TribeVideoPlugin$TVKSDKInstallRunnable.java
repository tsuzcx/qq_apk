package com.tencent.biz.tribe;

import begz;
import com.tencent.common.app.AppInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.lang.ref.WeakReference;
import yqp;

public class TribeVideoPlugin$TVKSDKInstallRunnable
  implements Runnable
{
  private WeakReference<TribeVideoPlugin> a;
  
  TribeVideoPlugin$TVKSDKInstallRunnable(TribeVideoPlugin paramTribeVideoPlugin)
  {
    this.a = new WeakReference(paramTribeVideoPlugin);
  }
  
  public void run()
  {
    TribeVideoPlugin localTribeVideoPlugin = (TribeVideoPlugin)this.a.get();
    if (localTribeVideoPlugin == null) {
      return;
    }
    TVK_SDKMgr.installPlugin(localTribeVideoPlugin.mRuntime.a().getApplication(), new yqp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin.TVKSDKInstallRunnable
 * JD-Core Version:    0.7.0.1
 */