package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/AdVPNGImageView;", "Lcom/tencent/mobileqq/vpng/view/VPNGImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "muteVolume", "", "getMuteVolume", "()Z", "setMuteVolume", "(Z)V", "stopPlay", "getStopPlay", "setStopPlay", "muteVideo", "", "playRender", "stopRender", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AdVPNGImageView
  extends VPNGImageView
{
  private boolean a;
  private volatile boolean b;
  
  public AdVPNGImageView(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a()
  {
    this.b = true;
    if (this.mVPNGRenderer != null) {
      this.mVPNGRenderer.b();
    }
  }
  
  public final void b()
  {
    this.a = true;
    if (this.mVPNGRenderer != null) {
      this.mVPNGRenderer.k();
    }
  }
  
  public final boolean getMuteVolume()
  {
    return this.a;
  }
  
  public final boolean getStopPlay()
  {
    return this.b;
  }
  
  protected void playRender()
  {
    this.b = false;
    if (!this.playOnSubThread)
    {
      VPNGRenderer localVPNGRenderer = this.mVPNGRenderer;
      if (localVPNGRenderer != null) {
        localVPNGRenderer.h();
      }
      if (this.a) {
        this.mVPNGRenderer.k();
      }
    }
    else
    {
      ThreadManager.excute((Runnable)new AdVPNGImageView.playRender.1(this), 128, null, true);
    }
  }
  
  public final void setMuteVolume(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final void setStopPlay(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.AdVPNGImageView
 * JD-Core Version:    0.7.0.1
 */