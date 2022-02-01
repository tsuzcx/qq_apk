package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import ykq;

class TrimTextureVideoView$2
  implements Runnable
{
  TrimTextureVideoView$2(TrimTextureVideoView paramTrimTextureVideoView) {}
  
  @TargetApi(14)
  public void run()
  {
    if (!this.this$0.jdField_i_of_type_Boolean)
    {
      ykq.a(this.this$0.a, "[%d]not attach! not schedule!", Integer.valueOf(this.this$0.jdField_i_of_type_Int));
      return;
    }
    int i = this.this$0.getCurrentPosition();
    ykq.b(this.this$0.a, "[%d]mCheckNeedRestart check enter! isPlaying = %b, mEndTime = %d, pos = %d, mPositionNotChangeCount = %d, mPausedPositionChangeCount = %d", new Object[] { Integer.valueOf(this.this$0.jdField_i_of_type_Int), Boolean.valueOf(this.this$0.isPlaying()), Integer.valueOf(this.this$0.l), Integer.valueOf(i), Integer.valueOf(this.this$0.q), Integer.valueOf(this.this$0.o) });
    if ((this.this$0.isPlaying()) && (i == this.this$0.p) && (this.this$0.q > 0))
    {
      if (this.this$0.q > 1)
      {
        ykq.e(this.this$0.a, "[%d]Position not change for %d times, restart! 命中异常播放容错逻辑", new Object[] { Integer.valueOf(this.this$0.jdField_i_of_type_Int), Integer.valueOf(this.this$0.q) });
        this.this$0.a(true);
        return;
      }
      this.this$0.postDelayed(this, 250L);
      return;
    }
    if ((!this.this$0.isPlaying()) && (i != this.this$0.n))
    {
      if (this.this$0.o > 1)
      {
        ykq.e(this.this$0.a, "[%d]Position change for %d times, but is pause, restart! 命中异常播放容错逻辑", new Object[] { Integer.valueOf(this.this$0.jdField_i_of_type_Int), Integer.valueOf(this.this$0.o) });
        this.this$0.a(true);
        return;
      }
      this.this$0.postDelayed(this, 250L);
      return;
    }
    ykq.b(this.this$0.a, "[%d] CheckNeedRestart good for now", Integer.valueOf(this.this$0.jdField_i_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.2
 * JD-Core Version:    0.7.0.1
 */