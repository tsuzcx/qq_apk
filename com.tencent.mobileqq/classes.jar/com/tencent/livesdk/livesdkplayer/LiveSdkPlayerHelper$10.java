package com.tencent.livesdk.livesdkplayer;

class LiveSdkPlayerHelper$10
  implements IMediaPlayerMgr.OnSurfaceChangeListener
{
  LiveSdkPlayerHelper$10(LiveSdkPlayerHelper paramLiveSdkPlayerHelper) {}
  
  public void onSurfaceCreated()
  {
    if (LiveSdkPlayerHelper.access$400(this.this$0) != null) {
      LiveSdkPlayerHelper.access$400(this.this$0).onSurfaceCreated();
    }
  }
  
  public void onSurfaceDestroyed()
  {
    if (LiveSdkPlayerHelper.access$400(this.this$0) != null) {
      LiveSdkPlayerHelper.access$400(this.this$0).onSurfaceDestroyed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.10
 * JD-Core Version:    0.7.0.1
 */