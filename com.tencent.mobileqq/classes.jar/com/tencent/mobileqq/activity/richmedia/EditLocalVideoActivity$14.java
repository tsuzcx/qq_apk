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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onComplete() ---------------1   mStartTime=");
      localStringBuilder.append(EditLocalVideoActivity.c(this.a));
      localStringBuilder.append(" mEndTime=");
      localStringBuilder.append(EditLocalVideoActivity.d(this.a));
      localStringBuilder.append("   mCurrentStartTime=");
      localStringBuilder.append(EditLocalVideoActivity.e(this.a));
      QLog.e("EditLocalVideoActivity", 2, localStringBuilder.toString());
      EditLocalVideoActivity.a(this.a).pause();
      paramMediaPlayer.seekTo(EditLocalVideoActivity.e(this.a));
      EditLocalVideoActivity.b(this.a, false);
      EditLocalVideoActivity.a(this.a).setVisibility(0);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onComplete() ---------------2   mStartTime=");
    localStringBuilder.append(EditLocalVideoActivity.c(this.a));
    localStringBuilder.append(" mEndTime=");
    localStringBuilder.append(EditLocalVideoActivity.d(this.a));
    localStringBuilder.append("   mCurrentStartTime=");
    localStringBuilder.append(EditLocalVideoActivity.e(this.a));
    QLog.e("EditLocalVideoActivity", 2, localStringBuilder.toString());
    paramMediaPlayer.seekTo(EditLocalVideoActivity.c(this.a));
    EditLocalVideoActivity.a(this.a).start();
  }
  
  public void a(FixedSizeVideoView paramFixedSizeVideoView, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if (EditLocalVideoActivity.b(this.a))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onArriveTrimEnd() ---------------3   mStartTime=");
      localStringBuilder.append(EditLocalVideoActivity.c(this.a));
      localStringBuilder.append(" mEndTime=");
      localStringBuilder.append(EditLocalVideoActivity.d(this.a));
      localStringBuilder.append("   mCurrentStartTime=");
      localStringBuilder.append(EditLocalVideoActivity.e(this.a));
      QLog.e("EditLocalVideoActivity", 2, localStringBuilder.toString());
      paramFixedSizeVideoView.pause();
      paramFixedSizeVideoView.seekTo(EditLocalVideoActivity.e(this.a));
      EditLocalVideoActivity.b(this.a, false);
      EditLocalVideoActivity.a(this.a).setVisibility(0);
    }
    else
    {
      if (EditLocalVideoActivity.d(this.a) == 0) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onArriveTrimEnd() ---------------4   mStartTime=");
      localStringBuilder.append(EditLocalVideoActivity.c(this.a));
      localStringBuilder.append(" mEndTime=");
      localStringBuilder.append(EditLocalVideoActivity.d(this.a));
      localStringBuilder.append("   mCurrentStartTime=");
      localStringBuilder.append(EditLocalVideoActivity.e(this.a));
      QLog.e("EditLocalVideoActivity", 2, localStringBuilder.toString());
      paramFixedSizeVideoView.setPlayDuration(EditLocalVideoActivity.c(this.a), EditLocalVideoActivity.d(this.a) - EditLocalVideoActivity.c(this.a));
      paramFixedSizeVideoView.seekTo(EditLocalVideoActivity.c(this.a));
      paramFixedSizeVideoView.start();
    }
    if (EditLocalVideoActivity.a(this.a) != null) {
      EditLocalVideoActivity.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.14
 * JD-Core Version:    0.7.0.1
 */