package com.tencent.livesdk.livesdkplayer;

import android.view.View;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase;
import com.tencent.thumbplayer.utils.TPLogUtil;

class LiveSdkPlayerHelper$4
  implements IMediaPlayerMgr.OnPreparedListener
{
  LiveSdkPlayerHelper$4(LiveSdkPlayerHelper paramLiveSdkPlayerHelper) {}
  
  public void onPrepared(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    TPLogUtil.i("LiveSdkPlayerHelper", "onVideoPrepared:  调用 videoPlayer.start() 开始播放");
    if (LiveSdkPlayerHelper.access$400(this.this$0) == null)
    {
      TPLogUtil.e("LiveSdkPlayerHelper", "player status listener is null");
      return;
    }
    if (LiveSdkPlayerHelper.access$500(this.this$0) == null) {
      return;
    }
    if (!LiveSdkPlayerHelper.access$600(this.this$0))
    {
      if (LiveSdkPlayerHelper.access$700(this.this$0))
      {
        LiveSdkPlayerHelper.access$500(this.this$0).setRenderGravity(17);
        ((View)LiveSdkPlayerHelper.access$500(this.this$0)).setPadding(0, 0, 0, 0);
        LiveSdkPlayerHelper.access$500(this.this$0).setXYAxis(2);
      }
      else if (this.this$0.getVideoWidth() > this.this$0.getVideoHeight())
      {
        LiveSdkPlayerHelper.access$500(this.this$0).setRenderGravity(48);
        ((View)LiveSdkPlayerHelper.access$500(this.this$0)).setPadding(0, LiveSdkPlayerHelper.access$800(this.this$0), 0, 0);
        LiveSdkPlayerHelper.access$500(this.this$0).setXYAxis(0);
        LiveSdkPlayerHelper.access$902(this.this$0, true);
      }
      else
      {
        LiveSdkPlayerHelper.access$500(this.this$0).setRenderGravity(17);
        ((View)LiveSdkPlayerHelper.access$500(this.this$0)).setPadding(0, 0, 0, 0);
        LiveSdkPlayerHelper.access$500(this.this$0).setXYAxis(2);
      }
      LiveSdkPlayerHelper.access$500(this.this$0).setFixedSize(this.this$0.getVideoWidth(), this.this$0.getVideoHeight());
    }
    LiveSdkPlayerHelper.access$400(this.this$0).onReadyLayout(LiveSdkPlayerHelper.access$500(this.this$0), paramIMediaPlayerMgr.getVideoWidth(), paramIMediaPlayerMgr.getVideoHeight());
    LiveSdkPlayerHelper.access$400(this.this$0).onReadyCompleted(paramIMediaPlayerMgr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.4
 * JD-Core Version:    0.7.0.1
 */