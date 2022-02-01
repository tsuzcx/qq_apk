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
    EditLocalVideoActivity.y(this.a).removeMessages(9999);
    EditLocalVideoActivity.z(this.a);
    EditLocalVideoActivity.x(this.a).a(EditLocalVideoActivity.A(this.a), EditLocalVideoActivity.B(this.a));
    EditLocalVideoActivity.x(this.a).a(EditLocalVideoActivity.u(this.a), EditLocalVideoActivity.v(this.a));
    EditLocalVideoActivity.x(this.a).a(paramMediaPlayer.getDuration());
    if (!EditLocalVideoActivity.c(this.a).a())
    {
      EditLocalVideoActivity.e(this.a, paramMediaPlayer.getDuration());
      if ((FileUtils.getFileSize(EditLocalVideoActivity.C(this.a)) / EditLocalVideoActivity.q(this.a).getDuration() * 15000L > this.a.a(EditLocalVideoActivity.c())) && (QLog.isColorLevel())) {
        QLog.d("EditLocalVideoActivity", 2, "prepared, there is not enough space on sdcard");
      }
      int i = paramMediaPlayer.getVideoWidth();
      int j = paramMediaPlayer.getVideoHeight();
      if ((i > 0) && (j > 0))
      {
        EditLocalVideoActivity.f(this.a, i);
        EditLocalVideoActivity.g(this.a, j);
        EditLocalVideoActivity.a(this.a, i, j);
        return;
      }
      Toast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131901747), 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.16
 * JD-Core Version:    0.7.0.1
 */