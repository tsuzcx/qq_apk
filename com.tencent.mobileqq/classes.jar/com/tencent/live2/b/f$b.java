package com.tencent.live2.b;

import android.view.Surface;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayStatus;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCRenderParams;

class f$b
{
  public a a;
  public TXCloudVideoView b;
  public Surface c;
  public int d;
  public int e;
  public V2TXLivePlayerObserver f;
  public V2TXLivePlayer g;
  public boolean h;
  public boolean i;
  public boolean j;
  public final TRTCCloudDef.TRTCRenderParams k = new TRTCCloudDef.TRTCRenderParams();
  private V2TXLiveDef.V2TXLivePlayStatus l = V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped;
  private V2TXLiveDef.V2TXLivePlayStatus m = V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped;
  
  public f$b()
  {
    TRTCCloudDef.TRTCRenderParams localTRTCRenderParams = this.k;
    localTRTCRenderParams.rotation = 0;
    localTRTCRenderParams.fillMode = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[urlParam:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("][isAudioMuted:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("][isVideoMuted:");
    localStringBuilder.append(this.j);
    localStringBuilder.append("][audioPlayStatus:");
    localStringBuilder.append(this.l);
    localStringBuilder.append("][videoPlayStatus:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.b
 * JD-Core Version:    0.7.0.1
 */