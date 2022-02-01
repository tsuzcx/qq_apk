package com.tencent.aelight.camera.aebase;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.INetEngineListener;

class AECameraPlugin$DownloadRunnable
  implements Runnable
{
  AppInterface a;
  String b;
  String c;
  INetEngineListener d;
  String e;
  
  public void run()
  {
    AECameraPlugin.a(this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.AECameraPlugin.DownloadRunnable
 * JD-Core Version:    0.7.0.1
 */