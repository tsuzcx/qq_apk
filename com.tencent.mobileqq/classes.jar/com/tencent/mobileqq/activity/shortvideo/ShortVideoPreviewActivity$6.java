package com.tencent.mobileqq.activity.shortvideo;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.SurfaceViewUtil;
import com.tencent.mobileqq.video.IMediaPlayer;
import com.tencent.mobileqq.video.IMediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class ShortVideoPreviewActivity$6
  implements IMediaPlayer.OnPreparedListener
{
  ShortVideoPreviewActivity$6(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mMediaPlayer onPrepared: mDuration=");
      ((StringBuilder)localObject).append(this.a.mDuration);
      QLog.d("ShortVideoPreviewActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.mSurfaceView.getHolder();
    if ((localObject != null) && (((SurfaceHolder)localObject).getSurface().isValid()))
    {
      SurfaceViewUtil.a(this.a.mSurfaceView, this.a.mSurfaceViewWidth, this.a.mSurfaceViewHeight, this.a.mMediaPlayer.d(), this.a.mMediaPlayer.e());
      if (this.a.mDestType == 10)
      {
        paramIMediaPlayer.a((SurfaceHolder)localObject);
        this.a.duration = paramIMediaPlayer.c();
        if (this.a.duration > 0)
        {
          if (QLog.isColorLevel())
          {
            paramIMediaPlayer = new StringBuilder();
            paramIMediaPlayer.append("此时的时长为");
            paramIMediaPlayer.append(ShortVideoUtils.stringForTime(this.a.duration));
            QLog.d("ShortVideoPreviewActivity", 2, paramIMediaPlayer.toString());
          }
          this.a.totalTimeMp.setText(ShortVideoUtils.stringForTime(this.a.duration));
          this.a.seekBarMp.setMax(this.a.duration);
        }
      }
      return;
    }
    FMToastUtil.a(2131691305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.6
 * JD-Core Version:    0.7.0.1
 */