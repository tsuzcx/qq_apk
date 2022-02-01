package com.tencent.biz.qqcircle.bizparts;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import com.tencent.qphone.base.util.QLog;

class QCircleFolderSplashPart$4$1
  implements MediaPlayer.OnInfoListener
{
  QCircleFolderSplashPart$4$1(QCircleFolderSplashPart.4 param4) {}
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3) {
      QLog.d("QCircleFolderSplashPart", 1, "videoView render start");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart.4.1
 * JD-Core Version:    0.7.0.1
 */