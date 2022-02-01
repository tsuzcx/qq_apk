package com.tencent.livesdk.livesdkplayer;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase;
import com.tencent.thumbplayer.utils.TPLogUtil;

class LiveSdkPlayerHelper$6
  implements IMediaPlayerMgr.OnInfoListener
{
  LiveSdkPlayerHelper$6(LiveSdkPlayerHelper paramLiveSdkPlayerHelper) {}
  
  public void onInfo(IMediaPlayerMgr paramIMediaPlayerMgr, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (paramInt != 106)
    {
      if (paramInt != 500)
      {
        if (paramInt != 200)
        {
          if (paramInt != 201) {
            return;
          }
          TPLogUtil.i("LiveSdkPlayerHelper", "onInfoListener 结束缓冲");
          if (LiveSdkPlayerHelper.access$400(this.this$0) != null) {
            LiveSdkPlayerHelper.access$400(this.this$0).onStopBuffer(LiveSdkPlayerHelper.access$200(this.this$0));
          }
        }
        else
        {
          TPLogUtil.i("LiveSdkPlayerHelper", "onInfoListener 开始缓冲");
          if (LiveSdkPlayerHelper.access$400(this.this$0) != null) {
            LiveSdkPlayerHelper.access$400(this.this$0).onStartBuffer(LiveSdkPlayerHelper.access$200(this.this$0));
          }
        }
      }
      else
      {
        if (LiveSdkPlayerHelper.access$500(this.this$0) == null) {
          return;
        }
        paramObject = new StringBuilder();
        paramObject.append("width :");
        paramObject.append(paramIMediaPlayerMgr.getVideoWidth());
        paramObject.append(" height:");
        paramObject.append(paramIMediaPlayerMgr.getVideoHeight());
        TPLogUtil.i("LiveSdkPlayerHelper", paramObject.toString());
        if (paramIMediaPlayerMgr.getVideoWidth() > paramIMediaPlayerMgr.getVideoHeight())
        {
          if (!LiveSdkPlayerHelper.access$900(this.this$0)) {
            if (LiveSdkPlayerHelper.access$700(this.this$0))
            {
              LiveSdkPlayerHelper.access$500(this.this$0).setRenderGravity(17);
              ((View)LiveSdkPlayerHelper.access$500(this.this$0)).setPadding(0, 0, 0, 0);
              LiveSdkPlayerHelper.access$1100(this.this$0).setPadding(0, 0, 0, 0);
            }
            else
            {
              LiveSdkPlayerHelper.access$500(this.this$0).setRenderGravity(48);
              ((View)LiveSdkPlayerHelper.access$500(this.this$0)).setPadding(0, LiveSdkPlayerHelper.access$800(this.this$0), 0, 0);
              LiveSdkPlayerHelper.access$1100(this.this$0).setPadding(0, LiveSdkPlayerHelper.access$800(this.this$0), 0, 0);
            }
          }
          LiveSdkPlayerHelper.access$500(this.this$0).setXYAxis(0);
          LiveSdkPlayerHelper.access$902(this.this$0, true);
        }
        else
        {
          LiveSdkPlayerHelper.access$500(this.this$0).setRenderGravity(17);
          ((View)LiveSdkPlayerHelper.access$500(this.this$0)).setPadding(0, 0, 0, 0);
          LiveSdkPlayerHelper.access$1100(this.this$0).setPadding(0, 0, 0, 0);
          LiveSdkPlayerHelper.access$500(this.this$0).setXYAxis(2);
          LiveSdkPlayerHelper.access$902(this.this$0, false);
        }
        paramObject = LiveSdkPlayerHelper.access$1100(this.this$0).getLayoutParams();
        paramObject.width = paramIMediaPlayerMgr.getVideoWidth();
        paramObject.height = paramIMediaPlayerMgr.getVideoHeight();
        LiveSdkPlayerHelper.access$1100(this.this$0).setLayoutParams(paramObject);
        LiveSdkPlayerHelper.access$500(this.this$0).setFixedSize(paramIMediaPlayerMgr.getVideoWidth(), paramIMediaPlayerMgr.getVideoHeight());
      }
    }
    else
    {
      if (LiveSdkPlayerHelper.access$400(this.this$0) != null) {
        LiveSdkPlayerHelper.access$400(this.this$0).onFirstFrameCome(LiveSdkPlayerHelper.access$200(this.this$0));
      }
      LiveSdkPlayerHelper.access$300(this.this$0).e(System.currentTimeMillis());
      LiveSdkPlayerHelper.access$300(this.this$0).a(paramIMediaPlayerMgr.getVideoWidth(), paramIMediaPlayerMgr.getVideoHeight());
      LiveSdkPlayerHelper.access$100(this.this$0).removeCallbacksAndMessages(null);
      LiveSdkPlayerHelper.access$100(this.this$0).sendEmptyMessage(100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.6
 * JD-Core Version:    0.7.0.1
 */