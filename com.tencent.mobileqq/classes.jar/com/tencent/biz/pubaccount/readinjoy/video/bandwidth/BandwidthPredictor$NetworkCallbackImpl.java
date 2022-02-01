package com.tencent.biz.pubaccount.readinjoy.video.bandwidth;

import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import org.jetbrains.annotations.Nullable;

@RequiresApi(21)
final class BandwidthPredictor$NetworkCallbackImpl
  extends ConnectivityManager.NetworkCallback
{
  private BandwidthPredictor$NetworkCallbackImpl(BandwidthPredictor paramBandwidthPredictor) {}
  
  public void onAvailable(@Nullable Network paramNetwork)
  {
    BandwidthPredictor.a(this.a).post(new BandwidthPredictor.NetworkCallbackImpl.1(this));
  }
  
  public void onLost(@Nullable Network paramNetwork)
  {
    BandwidthPredictor.a(this.a).post(new BandwidthPredictor.NetworkCallbackImpl.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor.NetworkCallbackImpl
 * JD-Core Version:    0.7.0.1
 */