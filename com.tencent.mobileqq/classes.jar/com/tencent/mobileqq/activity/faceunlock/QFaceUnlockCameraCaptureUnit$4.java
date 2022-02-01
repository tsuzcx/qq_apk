package com.tencent.mobileqq.activity.faceunlock;

import ajql;
import android.app.Activity;
import android.content.Intent;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class QFaceUnlockCameraCaptureUnit$4
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$4(ajql paramajql) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.FaceUnblockCameraJsApiPlugin");
    if (ajql.c(this.this$0) > 10) {
      localIntent.putExtra("recording_time_out", true);
    }
    localIntent.putExtra("target_media_url", ajql.a(this.this$0));
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    this.this$0.a().sendBroadcast(localIntent);
    this.this$0.a().finish();
    this.this$0.a().overridePendingTransition(2130772039, 2130772240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.4
 * JD-Core Version:    0.7.0.1
 */