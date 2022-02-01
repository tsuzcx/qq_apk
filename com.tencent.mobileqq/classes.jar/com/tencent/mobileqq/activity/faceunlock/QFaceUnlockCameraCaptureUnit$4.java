package com.tencent.mobileqq.activity.faceunlock;

import android.app.Activity;
import android.content.Intent;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

class QFaceUnlockCameraCaptureUnit$4
  implements Runnable
{
  QFaceUnlockCameraCaptureUnit$4(QFaceUnlockCameraCaptureUnit paramQFaceUnlockCameraCaptureUnit) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.FaceUnblockCameraJsApiPlugin");
    if (QFaceUnlockCameraCaptureUnit.c(this.this$0) > 10) {
      localIntent.putExtra("recording_time_out", true);
    }
    localIntent.putExtra("target_media_url", QFaceUnlockCameraCaptureUnit.a(this.this$0));
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    this.this$0.a().sendBroadcast(localIntent);
    this.this$0.a().finish();
    this.this$0.a().overridePendingTransition(2130772043, 2130772254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.4
 * JD-Core Version:    0.7.0.1
 */