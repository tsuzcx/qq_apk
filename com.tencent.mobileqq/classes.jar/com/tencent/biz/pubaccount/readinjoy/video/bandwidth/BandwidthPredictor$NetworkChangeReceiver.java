package com.tencent.biz.pubaccount.readinjoy.video.bandwidth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import org.jetbrains.annotations.NotNull;

final class BandwidthPredictor$NetworkChangeReceiver
  extends BroadcastReceiver
{
  private BandwidthPredictor$NetworkChangeReceiver(BandwidthPredictor paramBandwidthPredictor) {}
  
  public void onReceive(@NotNull Context paramContext, @NotNull Intent paramIntent)
  {
    BandwidthPredictor.a(this.a).post(new BandwidthPredictor.NetworkChangeReceiver.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor.NetworkChangeReceiver
 * JD-Core Version:    0.7.0.1
 */