package com.tencent.livesdk.livesdkplayer;

import android.os.Handler;
import android.os.Message;

class LiveSdkPlayerHelper$3
  extends Handler
{
  LiveSdkPlayerHelper$3(LiveSdkPlayerHelper paramLiveSdkPlayerHelper) {}
  
  public void handleMessage(Message paramMessage)
  {
    LiveSdkPlayerHelper.access$100(this.this$0).removeCallbacksAndMessages(null);
    if (((paramMessage != null) || (paramMessage.what == 100)) && (LiveSdkPlayerHelper.access$200(this.this$0) != null))
    {
      if (LiveSdkPlayerHelper.access$300(this.this$0) != null)
      {
        long l = (LiveSdkPlayerHelper.access$300(this.this$0).d() - LiveSdkPlayerHelper.access$300(this.this$0).i()) / 2L;
        if (l <= 0L)
        {
          LiveSdkPlayerHelper.access$100(this.this$0).sendEmptyMessageDelayed(100, 2000L);
          return;
        }
        if (l <= 5L) {
          LiveSdkPlayerHelper.access$300(this.this$0).a(LiveSdkPlayerHelper.access$300(this.this$0).a() + 1L);
        } else if (l <= 10L) {
          LiveSdkPlayerHelper.access$300(this.this$0).b(LiveSdkPlayerHelper.access$300(this.this$0).b() + 1L);
        } else {
          LiveSdkPlayerHelper.access$300(this.this$0).c(LiveSdkPlayerHelper.access$300(this.this$0).c() + 1L);
        }
        LiveSdkPlayerHelper.access$300(this.this$0).i(LiveSdkPlayerHelper.access$300(this.this$0).d());
      }
      LiveSdkPlayerHelper.access$100(this.this$0).sendEmptyMessageDelayed(100, 2000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.3
 * JD-Core Version:    0.7.0.1
 */