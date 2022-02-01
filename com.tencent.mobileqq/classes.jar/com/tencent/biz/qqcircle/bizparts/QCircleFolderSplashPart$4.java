package com.tencent.biz.qqcircle.bizparts;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCircleFolderSplashPart$4
  implements MediaPlayer.OnPreparedListener
{
  QCircleFolderSplashPart$4(QCircleFolderSplashPart paramQCircleFolderSplashPart) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    QLog.d("QCircleFolderSplashPart", 1, "videoView onPrepared!");
    paramMediaPlayer.start();
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(19).setSubActionType(3).setThrActionType(0).setvid("1"));
    paramMediaPlayer.setOnInfoListener(new QCircleFolderSplashPart.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart.4
 * JD-Core Version:    0.7.0.1
 */