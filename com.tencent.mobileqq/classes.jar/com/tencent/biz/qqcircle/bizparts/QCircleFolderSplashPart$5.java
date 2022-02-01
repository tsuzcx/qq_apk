package com.tencent.biz.qqcircle.bizparts;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class QCircleFolderSplashPart$5
  implements MediaPlayer.OnErrorListener
{
  QCircleFolderSplashPart$5(QCircleFolderSplashPart paramQCircleFolderSplashPart) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QCircleFolderSplashPart.d(this.a);
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("play splash video error!what:");
    paramMediaPlayer.append(paramInt1);
    paramMediaPlayer.append(",extra:");
    paramMediaPlayer.append(paramInt2);
    QLog.e("QCircleFolderSplashPart", 1, paramMediaPlayer.toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart.5
 * JD-Core Version:    0.7.0.1
 */