package com.tencent.mobileqq.activity.richmedia;

import android.media.MediaPlayer;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.OnTrimVDPlayCompelteListener;
import com.tencent.qphone.base.util.QLog;

class EditLocalVideoActivity$14
  implements FixedSizeVideoView.OnTrimVDPlayCompelteListener
{
  EditLocalVideoActivity$14(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void a(MediaPlayer paramMediaPlayer)
  {
    if (EditLocalVideoActivity.b(this.a))
    {
      QLog.e("EditLocalVideoActivity", 2, "onComplete() ---------------1   mStartTime=" + EditLocalVideoActivity.c(this.a) + " mEndTime=" + EditLocalVideoActivity.d(this.a) + "   mCurrentStartTime=" + EditLocalVideoActivity.e(this.a));
      EditLocalVideoActivity.a(this.a).pause();
      paramMediaPlayer.seekTo(EditLocalVideoActivity.e(this.a));
      EditLocalVideoActivity.b(this.a, false);
      EditLocalVideoActivity.a(this.a).setVisibility(0);
      return;
    }
    QLog.e("EditLocalVideoActivity", 2, "onComplete() ---------------2   mStartTime=" + EditLocalVideoActivity.c(this.a) + " mEndTime=" + EditLocalVideoActivity.d(this.a) + "   mCurrentStartTime=" + EditLocalVideoActivity.e(this.a));
    paramMediaPlayer.seekTo(EditLocalVideoActivity.c(this.a));
    EditLocalVideoActivity.a(this.a).start();
  }
  
  public void a(FixedSizeVideoView paramFixedSizeVideoView, int paramInt1, int paramInt2)
  {
    if (EditLocalVideoActivity.b(this.a))
    {
      QLog.e("EditLocalVideoActivity", 2, "onArriveTrimEnd() ---------------3   mStartTime=" + EditLocalVideoActivity.c(this.a) + " mEndTime=" + EditLocalVideoActivity.d(this.a) + "   mCurrentStartTime=" + EditLocalVideoActivity.e(this.a));
      paramFixedSizeVideoView.pause();
      paramFixedSizeVideoView.seekTo(EditLocalVideoActivity.e(this.a));
      EditLocalVideoActivity.b(this.a, false);
      EditLocalVideoActivity.a(this.a).setVisibility(0);
    }
    for (;;)
    {
      if (EditLocalVideoActivity.a(this.a) != null) {
        EditLocalVideoActivity.a(this.a).b();
      }
      do
      {
        return;
      } while (EditLocalVideoActivity.d(this.a) == 0);
      QLog.e("EditLocalVideoActivity", 2, "onArriveTrimEnd() ---------------4   mStartTime=" + EditLocalVideoActivity.c(this.a) + " mEndTime=" + EditLocalVideoActivity.d(this.a) + "   mCurrentStartTime=" + EditLocalVideoActivity.e(this.a));
      paramFixedSizeVideoView.setPlayDuration(EditLocalVideoActivity.c(this.a), EditLocalVideoActivity.d(this.a) - EditLocalVideoActivity.c(this.a));
      paramFixedSizeVideoView.seekTo(EditLocalVideoActivity.c(this.a));
      paramFixedSizeVideoView.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.14
 * JD-Core Version:    0.7.0.1
 */