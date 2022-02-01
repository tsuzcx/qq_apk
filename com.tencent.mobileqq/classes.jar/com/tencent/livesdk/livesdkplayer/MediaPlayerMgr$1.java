package com.tencent.livesdk.livesdkplayer;

import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase.IVideoViewCallback;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.utils.TPLogUtil;

class MediaPlayerMgr$1
  implements ITPPlayerVideoViewBase.IVideoViewCallback
{
  MediaPlayerMgr$1(MediaPlayerMgr paramMediaPlayerMgr) {}
  
  public void onSurfaceChanged(Object paramObject)
  {
    TPLogUtil.i(MediaPlayerMgr.access$200(this.this$0), "OnSurfaceChanged");
  }
  
  public void onSurfaceCreated(Object paramObject)
  {
    if ((MediaPlayerMgr.access$000(this.this$0) != null) && (MediaPlayerMgr.access$100(this.this$0) != null))
    {
      MediaPlayerMgr.access$000(this.this$0).setSurface(MediaPlayerMgr.access$100(this.this$0).getViewSurface());
      TPLogUtil.i(MediaPlayerMgr.access$200(this.this$0), "onSurfaceCreated: player setSurface");
      if (MediaPlayerMgr.access$300(this.this$0) != null) {
        MediaPlayerMgr.access$300(this.this$0).onSurfaceCreated();
      }
    }
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    TPLogUtil.i(MediaPlayerMgr.access$200(this.this$0), "OnSurfaceDestroy");
    if (MediaPlayerMgr.access$000(this.this$0) != null) {
      MediaPlayerMgr.access$000(this.this$0).setSurface(null);
    }
    if (MediaPlayerMgr.access$300(this.this$0) != null) {
      MediaPlayerMgr.access$300(this.this$0).onSurfaceDestroyed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.MediaPlayerMgr.1
 * JD-Core Version:    0.7.0.1
 */