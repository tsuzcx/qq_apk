package com.tencent.avgame.gameroom.video;

import android.os.Handler;
import com.tencent.avgame.business.observer.NetObserver;
import com.tencent.qphone.base.util.QLog;

class AVGameNetWorkQualityManager$MyNetObserver
  extends NetObserver
{
  public AVGameNetWorkQualityManager$MyNetObserver(AVGameNetWorkQualityManager paramAVGameNetWorkQualityManager) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameNetWorkQualityManager", 2, "onNetTypeChange, [" + paramInt1 + "-->" + paramInt2 + "]");
    }
    AVGameNetWorkQualityManager.b(this.a).removeCallbacks(AVGameNetWorkQualityManager.a(this.a));
    AVGameNetWorkQualityManager.b(this.a).post(AVGameNetWorkQualityManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameNetWorkQualityManager.MyNetObserver
 * JD-Core Version:    0.7.0.1
 */