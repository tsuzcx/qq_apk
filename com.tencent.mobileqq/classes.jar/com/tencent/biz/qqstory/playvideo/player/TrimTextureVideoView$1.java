package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.support.logging.SLog;

class TrimTextureVideoView$1
  implements Runnable
{
  TrimTextureVideoView$1(TrimTextureVideoView paramTrimTextureVideoView) {}
  
  @TargetApi(14)
  public void run()
  {
    if (!this.this$0.O)
    {
      SLog.a(this.this$0.c, "[%d]not attach! not schedule!", Integer.valueOf(this.this$0.E));
      return;
    }
    int i = this.this$0.getCurrentPosition();
    SLog.a(this.this$0.c, "[%d]mRestartRunnable check enter! isPlaying = %b, mEndTime = %d, pos = %d", Integer.valueOf(this.this$0.E), Boolean.valueOf(this.this$0.isPlaying()), Integer.valueOf(this.this$0.H), Integer.valueOf(i));
    if (this.this$0.H != 0)
    {
      TrimTextureVideoView localTrimTextureVideoView;
      if (this.this$0.isPlaying())
      {
        if (i == this.this$0.L)
        {
          localTrimTextureVideoView = this.this$0;
          localTrimTextureVideoView.M += 1;
        }
        else
        {
          this.this$0.M = 0;
        }
        this.this$0.L = i;
      }
      else
      {
        if (i == this.this$0.J)
        {
          this.this$0.K = 0;
        }
        else
        {
          localTrimTextureVideoView = this.this$0;
          localTrimTextureVideoView.K += 1;
        }
        this.this$0.J = i;
      }
    }
    if ((this.this$0.isPlaying()) && (this.this$0.H > 0) && (i >= this.this$0.H)) {
      this.this$0.a(true);
    } else if (this.this$0.f == 5) {
      this.this$0.a(true);
    }
    SLog.b(this.this$0.c, "schedule next!");
    this.this$0.postDelayed(this, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.1
 * JD-Core Version:    0.7.0.1
 */