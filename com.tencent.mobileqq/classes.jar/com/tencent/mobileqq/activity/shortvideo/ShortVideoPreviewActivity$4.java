package com.tencent.mobileqq.activity.shortvideo;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.widget.ImageView;
import com.tencent.mobileqq.video.IMediaPlayer;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ShortVideoPreviewActivity$4
  implements SurfaceHolder.Callback
{
  ShortVideoPreviewActivity$4(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel())
    {
      paramSurfaceHolder = new StringBuilder();
      paramSurfaceHolder.append("surfaceCreated: mSavedCurPosition:");
      paramSurfaceHolder.append(this.a.mSavedCurPosition);
      paramSurfaceHolder.append(",mSavedPlayState : ");
      ShortVideoPreviewActivity localShortVideoPreviewActivity = this.a;
      paramSurfaceHolder.append(localShortVideoPreviewActivity.getPlayStateStr(localShortVideoPreviewActivity.mSavedPlayState));
      QLog.d("ShortVideoPreviewActivity", 2, paramSurfaceHolder.toString());
    }
    if ((this.a.mSavedPlayState == 1) && (this.a.mSavedCurPosition > 0))
    {
      paramSurfaceHolder = this.a;
      paramSurfaceHolder.play(paramSurfaceHolder.mSavedCurPosition);
      paramSurfaceHolder = this.a;
      paramSurfaceHolder.mSavedCurPosition = 0;
      paramSurfaceHolder.mSavedPlayState = 0;
      return;
    }
    this.a.mCover.setVisibility(0);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "surfaceDestroyed ");
    }
    if (this.a.mMediaPlayer != null) {
      this.a.mMediaPlayer.f();
    }
    if (this.a.updateBarHandler != null) {
      this.a.updateBarHandler.removeCallbacks(this.a.updateSeekBarThread);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */