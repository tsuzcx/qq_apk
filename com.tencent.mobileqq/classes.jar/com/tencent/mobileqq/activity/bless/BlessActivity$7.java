package com.tencent.mobileqq.activity.bless;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.qphone.base.util.QLog;

class BlessActivity$7
  implements MediaPlayer.OnPreparedListener
{
  BlessActivity$7(BlessActivity paramBlessActivity) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.f(this.a), 2, "videoview onPrepared");
    }
    if (BlessActivity.g(this.a) != null) {
      BlessActivity.g(this.a).start();
    }
    BlessActivity.i(this.a).postDelayed(new BlessActivity.7.1(this), 800L);
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.f(this.a), 2, "videoview onPrepared");
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X800632D", "0X800632D", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity.7
 * JD-Core Version:    0.7.0.1
 */