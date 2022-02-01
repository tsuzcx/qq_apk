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
    if (!this.this$0.jdField_i_of_type_Boolean)
    {
      SLog.a(this.this$0.jdField_a_of_type_JavaLangString, "[%d]not attach! not schedule!", Integer.valueOf(this.this$0.jdField_i_of_type_Int));
      return;
    }
    int i = this.this$0.getCurrentPosition();
    SLog.a(this.this$0.jdField_a_of_type_JavaLangString, "[%d]mRestartRunnable check enter! isPlaying = %b, mEndTime = %d, pos = %d", Integer.valueOf(this.this$0.jdField_i_of_type_Int), Boolean.valueOf(this.this$0.isPlaying()), Integer.valueOf(this.this$0.l), Integer.valueOf(i));
    if (this.this$0.l != 0)
    {
      TrimTextureVideoView localTrimTextureVideoView;
      if (this.this$0.isPlaying())
      {
        if (i == this.this$0.p)
        {
          localTrimTextureVideoView = this.this$0;
          localTrimTextureVideoView.q += 1;
        }
        else
        {
          this.this$0.q = 0;
        }
        this.this$0.p = i;
      }
      else
      {
        if (i == this.this$0.n)
        {
          this.this$0.o = 0;
        }
        else
        {
          localTrimTextureVideoView = this.this$0;
          localTrimTextureVideoView.o += 1;
        }
        this.this$0.n = i;
      }
    }
    if ((this.this$0.isPlaying()) && (this.this$0.l > 0) && (i >= this.this$0.l)) {
      this.this$0.a(true);
    } else if (this.this$0.jdField_a_of_type_Int == 5) {
      this.this$0.a(true);
    }
    SLog.b(this.this$0.jdField_a_of_type_JavaLangString, "schedule next!");
    this.this$0.postDelayed(this, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.1
 * JD-Core Version:    0.7.0.1
 */