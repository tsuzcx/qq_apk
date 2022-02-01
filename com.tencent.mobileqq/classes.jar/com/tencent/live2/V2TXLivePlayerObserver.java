package com.tencent.live2;

import android.graphics.Bitmap;
import android.os.Bundle;

public abstract class V2TXLivePlayerObserver
{
  public void onAudioPlayStatusUpdate(V2TXLivePlayer paramV2TXLivePlayer, V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason, Bundle paramBundle) {}
  
  public void onError(V2TXLivePlayer paramV2TXLivePlayer, int paramInt, String paramString, Bundle paramBundle) {}
  
  public void onPlayoutVolumeUpdate(V2TXLivePlayer paramV2TXLivePlayer, int paramInt) {}
  
  public void onRenderVideoFrame(V2TXLivePlayer paramV2TXLivePlayer, V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame) {}
  
  public void onSnapshotComplete(V2TXLivePlayer paramV2TXLivePlayer, Bitmap paramBitmap) {}
  
  public void onStatisticsUpdate(V2TXLivePlayer paramV2TXLivePlayer, V2TXLiveDef.V2TXLivePlayerStatistics paramV2TXLivePlayerStatistics) {}
  
  public void onVideoPlayStatusUpdate(V2TXLivePlayer paramV2TXLivePlayer, V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason, Bundle paramBundle) {}
  
  public void onWarning(V2TXLivePlayer paramV2TXLivePlayer, int paramInt, String paramString, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.V2TXLivePlayerObserver
 * JD-Core Version:    0.7.0.1
 */