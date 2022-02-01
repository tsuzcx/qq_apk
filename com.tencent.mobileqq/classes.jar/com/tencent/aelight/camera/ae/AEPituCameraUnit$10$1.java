package com.tencent.aelight.camera.ae;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;

class AEPituCameraUnit$10$1
  implements Runnable
{
  AEPituCameraUnit$10$1(AEPituCameraUnit.10 param10) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", false);
    this.a.a.a().sendBroadcast(localIntent);
    this.a.a.a.a(131078, new Object[0]);
    AEBaseDataReporter.a().av();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.10.1
 * JD-Core Version:    0.7.0.1
 */