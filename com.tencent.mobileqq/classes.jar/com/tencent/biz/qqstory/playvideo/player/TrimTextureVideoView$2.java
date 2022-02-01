package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.support.logging.SLog;

class TrimTextureVideoView$2
  implements Runnable
{
  TrimTextureVideoView$2(TrimTextureVideoView paramTrimTextureVideoView) {}
  
  @TargetApi(14)
  public void run()
  {
    if (!this.this$0.O)
    {
      SLog.a(this.this$0.c, "[%d]not attach! not schedule!", Integer.valueOf(this.this$0.E));
      return;
    }
    int i = this.this$0.getCurrentPosition();
    SLog.b(this.this$0.c, "[%d]mCheckNeedRestart check enter! isPlaying = %b, mEndTime = %d, pos = %d, mPositionNotChangeCount = %d, mPausedPositionChangeCount = %d", new Object[] { Integer.valueOf(this.this$0.E), Boolean.valueOf(this.this$0.isPlaying()), Integer.valueOf(this.this$0.H), Integer.valueOf(i), Integer.valueOf(this.this$0.M), Integer.valueOf(this.this$0.K) });
    if ((this.this$0.isPlaying()) && (i == this.this$0.L) && (this.this$0.M > 0))
    {
      if (this.this$0.M > 1)
      {
        SLog.e(this.this$0.c, "[%d]Position not change for %d times, restart! 命中异常播放容错逻辑", new Object[] { Integer.valueOf(this.this$0.E), Integer.valueOf(this.this$0.M) });
        this.this$0.a(true);
        return;
      }
      this.this$0.postDelayed(this, 250L);
      return;
    }
    if ((!this.this$0.isPlaying()) && (i != this.this$0.J))
    {
      if (this.this$0.K > 1)
      {
        SLog.e(this.this$0.c, "[%d]Position change for %d times, but is pause, restart! 命中异常播放容错逻辑", new Object[] { Integer.valueOf(this.this$0.E), Integer.valueOf(this.this$0.K) });
        this.this$0.a(true);
        return;
      }
      this.this$0.postDelayed(this, 250L);
      return;
    }
    SLog.b(this.this$0.c, "[%d] CheckNeedRestart good for now", Integer.valueOf(this.this$0.E));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.2
 * JD-Core Version:    0.7.0.1
 */