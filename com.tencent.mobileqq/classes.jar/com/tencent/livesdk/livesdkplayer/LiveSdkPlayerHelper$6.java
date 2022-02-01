package com.tencent.livesdk.livesdkplayer;

import android.os.Handler;
import android.view.View;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase;
import com.tencent.thumbplayer.utils.TPLogUtil;

class LiveSdkPlayerHelper$6
  implements IMediaPlayerMgr.OnInfoListener
{
  LiveSdkPlayerHelper$6(LiveSdkPlayerHelper paramLiveSdkPlayerHelper) {}
  
  public void onInfo(IMediaPlayerMgr paramIMediaPlayerMgr, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          TPLogUtil.i("LiveSdkPlayerHelper", "onInfoListener 开始缓冲");
        } while (LiveSdkPlayerHelper.access$400(this.this$0) == null);
        LiveSdkPlayerHelper.access$400(this.this$0).onStartBuffer(LiveSdkPlayerHelper.access$200(this.this$0));
        return;
        TPLogUtil.i("LiveSdkPlayerHelper", "onInfoListener 结束缓冲");
      } while (LiveSdkPlayerHelper.access$400(this.this$0) == null);
      LiveSdkPlayerHelper.access$400(this.this$0).onStopBuffer(LiveSdkPlayerHelper.access$200(this.this$0));
      return;
      if (LiveSdkPlayerHelper.access$400(this.this$0) != null) {
        LiveSdkPlayerHelper.access$400(this.this$0).onFirstFrameCome(LiveSdkPlayerHelper.access$200(this.this$0));
      }
      LiveSdkPlayerHelper.access$300(this.this$0).e(System.currentTimeMillis());
      LiveSdkPlayerHelper.access$300(this.this$0).a(paramIMediaPlayerMgr.getVideoWidth(), paramIMediaPlayerMgr.getVideoHeight());
      LiveSdkPlayerHelper.access$100(this.this$0).removeCallbacksAndMessages(null);
      LiveSdkPlayerHelper.access$100(this.this$0).sendEmptyMessage(100);
      return;
    } while (LiveSdkPlayerHelper.access$500(this.this$0) == null);
    TPLogUtil.i("LiveSdkPlayerHelper", "width :" + paramIMediaPlayerMgr.getVideoWidth() + " height:" + paramIMediaPlayerMgr.getVideoHeight());
    if (paramIMediaPlayerMgr.getVideoWidth() > paramIMediaPlayerMgr.getVideoHeight()) {
      if (!LiveSdkPlayerHelper.access$700(this.this$0))
      {
        if (LiveSdkPlayerHelper.access$800(this.this$0))
        {
          LiveSdkPlayerHelper.access$500(this.this$0).setRenderGravity(17);
          ((View)LiveSdkPlayerHelper.access$500(this.this$0)).setPadding(0, 0, 0, 0);
        }
      }
      else
      {
        LiveSdkPlayerHelper.access$500(this.this$0).setXYAxis(0);
        LiveSdkPlayerHelper.access$702(this.this$0, true);
      }
    }
    for (;;)
    {
      LiveSdkPlayerHelper.access$500(this.this$0).setFixedSize(paramIMediaPlayerMgr.getVideoWidth(), paramIMediaPlayerMgr.getVideoHeight());
      return;
      LiveSdkPlayerHelper.access$500(this.this$0).setRenderGravity(48);
      ((View)LiveSdkPlayerHelper.access$500(this.this$0)).setPadding(0, LiveSdkPlayerHelper.access$900(this.this$0), 0, 0);
      break;
      LiveSdkPlayerHelper.access$500(this.this$0).setRenderGravity(17);
      ((View)LiveSdkPlayerHelper.access$500(this.this$0)).setPadding(0, 0, 0, 0);
      LiveSdkPlayerHelper.access$500(this.this$0).setXYAxis(2);
      LiveSdkPlayerHelper.access$702(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.6
 * JD-Core Version:    0.7.0.1
 */