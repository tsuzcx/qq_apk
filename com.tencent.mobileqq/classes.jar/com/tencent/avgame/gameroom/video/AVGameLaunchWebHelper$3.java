package com.tencent.avgame.gameroom.video;

import com.tencent.biz.qrcode.ipc.PreCallUpToolProc.Callback;
import com.tencent.qphone.base.util.QLog;

class AVGameLaunchWebHelper$3
  implements PreCallUpToolProc.Callback
{
  AVGameLaunchWebHelper$3(AVGameLaunchWebHelper paramAVGameLaunchWebHelper, Runnable paramRunnable, long paramLong) {}
  
  public void a()
  {
    AVGameLaunchWebHelper.a(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameLaunchWebHelper, this.jdField_a_of_type_JavaLangRunnable);
    QLog.d("AVGameLaunchWebHelper", 2, "preLoadToolProcAndExecuteCallable time end: " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameLaunchWebHelper.3
 * JD-Core Version:    0.7.0.1
 */