package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.statemachine;

import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.OnVideoPluginInstallListener;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onInstallComplete"}, k=3, mv={1, 1, 16})
final class InstallingState$installVideoPlugin$1
  implements VideoPluginInstall.OnVideoPluginInstallListener
{
  InstallingState$installVideoPlugin$1(InstallingState paramInstallingState) {}
  
  public final void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.a().get() < 2)) {
      this.a.a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.statemachine.InstallingState.installVideoPlugin.1
 * JD-Core Version:    0.7.0.1
 */