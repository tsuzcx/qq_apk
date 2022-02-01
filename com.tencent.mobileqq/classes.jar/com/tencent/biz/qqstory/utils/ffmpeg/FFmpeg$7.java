package com.tencent.biz.qqstory.utils.ffmpeg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import anvx;
import ykq;

class FFmpeg$7
  extends BroadcastReceiver
{
  FFmpeg$7(FFmpeg paramFFmpeg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF")) {
      if ((this.this$0.ffmpegExecuteAsyncTask != null) && (!this.this$0.ffmpegExecuteAsyncTask.isProcessCompleted()))
      {
        this.this$0.mIsFFmpegingCloseScreen = true;
        ykq.d("Q.qqstory.ffmpeg.FFmpegCmd", "屏幕灭屏了，FFmpeg还在执行当中");
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramContext.equals("android.intent.action.SCREEN_ON")) || (!this.this$0.mIsFFmpegingCloseScreen));
      this.this$0.mIsFFmpegingCloseScreen = false;
    } while ((this.this$0.mCurrentCommandUnit == null) || (this.this$0.mLastTaskResult == -9999) || (this.this$0.mCurrentCommandUnit.callback == null));
    if (this.this$0.mLastTaskResult == 1)
    {
      paramContext = anvx.a(2131703961);
      this.this$0.mCurrentCommandUnit.callback.onSuccess(paramContext);
      this.this$0.mCurrentCommandUnit.callback.onFinish(true);
      ykq.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
    for (;;)
    {
      this.this$0.mLastTaskResult = -9999;
      return;
      paramContext = anvx.a(2131703960);
      this.this$0.mCurrentCommandUnit.callback.onFailure(paramContext);
      this.this$0.mCurrentCommandUnit.callback.onFinish(false);
      ykq.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg.7
 * JD-Core Version:    0.7.0.1
 */