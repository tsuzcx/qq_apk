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
    if (EditLocalVideoActivity.t(this.a))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onComplete() ---------------1   mStartTime=");
      localStringBuilder.append(EditLocalVideoActivity.u(this.a));
      localStringBuilder.append(" mEndTime=");
      localStringBuilder.append(EditLocalVideoActivity.v(this.a));
      localStringBuilder.append("   mCurrentStartTime=");
      localStringBuilder.append(EditLocalVideoActivity.w(this.a));
      QLog.e("EditLocalVideoActivity", 2, localStringBuilder.toString());
      EditLocalVideoActivity.q(this.a).pause();
      paramMediaPlayer.seekTo(EditLocalVideoActivity.w(this.a));
      EditLocalVideoActivity.d(this.a, false);
      EditLocalVideoActivity.r(this.a).setVisibility(0);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onComplete() ---------------2   mStartTime=");
    localStringBuilder.append(EditLocalVideoActivity.u(this.a));
    localStringBuilder.append(" mEndTime=");
    localStringBuilder.append(EditLocalVideoActivity.v(this.a));
    localStringBuilder.append("   mCurrentStartTime=");
    localStringBuilder.append(EditLocalVideoActivity.w(this.a));
    QLog.e("EditLocalVideoActivity", 2, localStringBuilder.toString());
    paramMediaPlayer.seekTo(EditLocalVideoActivity.u(this.a));
    EditLocalVideoActivity.q(this.a).start();
  }
  
  public void a(FixedSizeVideoView paramFixedSizeVideoView, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if (EditLocalVideoActivity.t(this.a))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onArriveTrimEnd() ---------------3   mStartTime=");
      localStringBuilder.append(EditLocalVideoActivity.u(this.a));
      localStringBuilder.append(" mEndTime=");
      localStringBuilder.append(EditLocalVideoActivity.v(this.a));
      localStringBuilder.append("   mCurrentStartTime=");
      localStringBuilder.append(EditLocalVideoActivity.w(this.a));
      QLog.e("EditLocalVideoActivity", 2, localStringBuilder.toString());
      paramFixedSizeVideoView.pause();
      paramFixedSizeVideoView.seekTo(EditLocalVideoActivity.w(this.a));
      EditLocalVideoActivity.d(this.a, false);
      EditLocalVideoActivity.r(this.a).setVisibility(0);
    }
    else
    {
      if (EditLocalVideoActivity.v(this.a) == 0) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onArriveTrimEnd() ---------------4   mStartTime=");
      localStringBuilder.append(EditLocalVideoActivity.u(this.a));
      localStringBuilder.append(" mEndTime=");
      localStringBuilder.append(EditLocalVideoActivity.v(this.a));
      localStringBuilder.append("   mCurrentStartTime=");
      localStringBuilder.append(EditLocalVideoActivity.w(this.a));
      QLog.e("EditLocalVideoActivity", 2, localStringBuilder.toString());
      paramFixedSizeVideoView.setPlayDuration(EditLocalVideoActivity.u(this.a), EditLocalVideoActivity.v(this.a) - EditLocalVideoActivity.u(this.a));
      paramFixedSizeVideoView.seekTo(EditLocalVideoActivity.u(this.a));
      paramFixedSizeVideoView.start();
    }
    if (EditLocalVideoActivity.x(this.a) != null) {
      EditLocalVideoActivity.x(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.14
 * JD-Core Version:    0.7.0.1
 */