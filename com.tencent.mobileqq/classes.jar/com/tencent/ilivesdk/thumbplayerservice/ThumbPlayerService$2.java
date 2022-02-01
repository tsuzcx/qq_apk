package com.tencent.ilivesdk.thumbplayerservice;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerStatusListener;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr;
import com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.PlayerStatusListener;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase;

class ThumbPlayerService$2
  implements LiveSdkPlayerHelper.PlayerStatusListener
{
  ThumbPlayerService$2(ThumbPlayerService paramThumbPlayerService, PlayerStatusListener paramPlayerStatusListener) {}
  
  public void onError(IMediaPlayerMgr paramIMediaPlayerMgr, int paramInt, String paramString)
  {
    ThumbPlayerService.access$1000(this.this$0).getLogger().i("ThumbPlayerService", "errorCode: " + paramInt + " msg: " + paramString, new Object[0]);
    if (this.val$listener != null) {
      this.val$listener.onError(paramInt, paramString);
    }
    if (ThumbPlayerService.access$700(this.this$0) != null)
    {
      ThumbPlayerService.access$700(this.this$0).onError(paramInt, paramString);
      ThumbPlayerService.access$702(this.this$0, null);
    }
  }
  
  public void onFirstFrameCome(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    ThumbPlayerService.access$800(this.this$0).getLogger().i("ThumbPlayerService", "onFirstFrameCome", new Object[0]);
    if (this.val$listener != null) {
      this.val$listener.onFirstFrameCome();
    }
  }
  
  public void onNetworkAnomaly()
  {
    ThumbPlayerService.access$1300(this.this$0).getLogger().i("ThumbPlayerService", "onNetworkAnomaly 网络异常", new Object[0]);
    if (this.val$listener != null) {
      this.val$listener.onNetworkAnomaly();
    }
  }
  
  public void onNetworkChanged(int paramInt)
  {
    if (this.val$listener != null) {
      this.val$listener.onNetworkChanged(paramInt);
    }
  }
  
  public void onPlayCompleted(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    ThumbPlayerService.access$900(this.this$0).getLogger().i("ThumbPlayerService", "onPlayCompleted", new Object[0]);
    if (this.val$listener != null) {
      this.val$listener.onPlayCompleted();
    }
  }
  
  public void onReadyCompleted(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    ThumbPlayerService.access$600(this.this$0).getLogger().i("ThumbPlayerService", "onReadyCompleted", new Object[0]);
    if (this.val$listener != null) {
      this.val$listener.onReadyCompleted();
    }
    if (ThumbPlayerService.access$700(this.this$0) != null)
    {
      ThumbPlayerService.access$700(this.this$0).onReadyCompleted();
      ThumbPlayerService.access$702(this.this$0, null);
    }
  }
  
  public void onReadyLayout(ITPPlayerVideoViewBase paramITPPlayerVideoViewBase, int paramInt1, int paramInt2)
  {
    ThumbPlayerService.access$500(this.this$0).getLogger().i("ThumbPlayerService", "videoWidth = " + paramInt1 + " videoHeight=" + paramInt2, new Object[0]);
  }
  
  public long onReportRoomId()
  {
    if (ThumbPlayerService.access$1400(this.this$0) != null) {
      return ThumbPlayerService.access$1500(this.this$0).getRoomId();
    }
    return 0L;
  }
  
  public void onStartBuffer(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    ThumbPlayerService.access$1100(this.this$0).getLogger().i("ThumbPlayerService", "onStartBuffer", new Object[0]);
    if (this.val$listener != null) {
      this.val$listener.onStartBuffer();
    }
  }
  
  public void onStopBuffer(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    ThumbPlayerService.access$1200(this.this$0).getLogger().i("ThumbPlayerService", "onStopBuffer", new Object[0]);
    if (this.val$listener != null) {
      this.val$listener.onStopBuffer();
    }
  }
  
  public void onSurfaceCreated()
  {
    if (this.val$listener != null) {
      this.val$listener.onSurfaceCreated();
    }
  }
  
  public void onSurfaceDestroyed()
  {
    if (this.val$listener != null) {
      this.val$listener.onSurfaceDestroyed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.thumbplayerservice.ThumbPlayerService.2
 * JD-Core Version:    0.7.0.1
 */