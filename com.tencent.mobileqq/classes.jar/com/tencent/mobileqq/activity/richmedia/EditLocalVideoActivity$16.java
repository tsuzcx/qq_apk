package com.tencent.mobileqq.activity.richmedia;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.FileUtils;

class EditLocalVideoActivity$16
  implements MediaPlayer.OnPreparedListener
{
  EditLocalVideoActivity$16(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPrepared, duration:");
      localStringBuilder.append(paramMediaPlayer.getDuration());
      QLog.d("EditLocalVideoActivity", 2, localStringBuilder.toString());
    }
    EditLocalVideoActivity.a(this.a).removeMessages(9999);
    EditLocalVideoActivity.h(this.a);
    EditLocalVideoActivity.a(this.a).a(EditLocalVideoActivity.a(this.a), EditLocalVideoActivity.a(this.a));
    EditLocalVideoActivity.a(this.a).a(EditLocalVideoActivity.c(this.a), EditLocalVideoActivity.d(this.a));
    EditLocalVideoActivity.a(this.a).a(paramMediaPlayer.getDuration());
    if (!EditLocalVideoActivity.a(this.a).a())
    {
      EditLocalVideoActivity.d(this.a, paramMediaPlayer.getDuration());
      if ((FileUtils.getFileSize(EditLocalVideoActivity.b(this.a)) / EditLocalVideoActivity.a(this.a).getDuration() * 15000L > this.a.a(EditLocalVideoActivity.a())) && (QLog.isColorLevel())) {
        QLog.d("EditLocalVideoActivity", 2, "prepared, there is not enough space on sdcard");
      }
      int i = paramMediaPlayer.getVideoWidth();
      int j = paramMediaPlayer.getVideoHeight();
      if ((i > 0) && (j > 0))
      {
        EditLocalVideoActivity.e(this.a, i);
        EditLocalVideoActivity.f(this.a, j);
        EditLocalVideoActivity.a(this.a, i, j);
        return;
      }
      Toast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131703800), 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.16
 * JD-Core Version:    0.7.0.1
 */