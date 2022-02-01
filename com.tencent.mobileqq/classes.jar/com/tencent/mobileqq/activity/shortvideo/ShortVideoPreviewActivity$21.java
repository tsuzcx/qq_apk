package com.tencent.mobileqq.activity.shortvideo;

import android.os.Message;
import android.widget.SeekBar;
import com.tencent.mobileqq.video.IMediaPlayer;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ShortVideoPreviewActivity$21
  implements Runnable
{
  ShortVideoPreviewActivity$21(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void run()
  {
    if ((this.this$0.mMediaPlayer.b()) && (this.this$0.mSurfaceView != null))
    {
      Message localMessage = Message.obtain();
      localMessage.arg1 = this.this$0.mMediaPlayer.b();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("此时时间为+");
        localStringBuilder.append(localMessage.arg1);
        QLog.d("ShortVideoPreviewActivity", 2, localStringBuilder.toString());
      }
      this.this$0.seekBarMp.setProgress(localMessage.arg1);
      if (this.this$0.updateBarHandler == null) {
        return;
      }
      this.this$0.updateBarHandler.sendMessage(localMessage);
      this.this$0.updateBarHandler.post(this.this$0.updateSeekBarThread);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.21
 * JD-Core Version:    0.7.0.1
 */