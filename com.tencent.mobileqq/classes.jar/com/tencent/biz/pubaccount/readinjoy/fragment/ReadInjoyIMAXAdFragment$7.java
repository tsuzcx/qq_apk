package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.os.Handler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class ReadInjoyIMAXAdFragment$7
  implements TVK_SDKMgr.InstallListener
{
  ReadInjoyIMAXAdFragment$7(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment) {}
  
  public void onInstallProgress(float paramFloat)
  {
    GdtLog.a("ReadInjoyIMAXAdFragment", "installSDK onInstallProgress arg0=");
  }
  
  public void onInstalledFailed(int paramInt)
  {
    GdtLog.a("ReadInjoyIMAXAdFragment", "installSDK onInstalledFailed arg0=");
  }
  
  public void onInstalledSuccessed()
  {
    GdtLog.a("ReadInjoyIMAXAdFragment", "installSDK onInstalledSuccessed");
    if ((ReadInjoyIMAXAdFragment.a()) && (ReadInjoyIMAXAdFragment.b(this.a) != null)) {
      ReadInjoyIMAXAdFragment.b(this.a).post(new ReadInjoyIMAXAdFragment.WeakReferenceRunnable(this.a, 4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.7
 * JD-Core Version:    0.7.0.1
 */