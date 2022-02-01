package com.tencent.aelight.camera.aebase;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.qphone.base.util.QLog;

class QIMWebEffectCameraCaptureUnit$1
  extends BroadcastReceiver
{
  QIMWebEffectCameraCaptureUnit$1(QIMWebEffectCameraCaptureUnit paramQIMWebEffectCameraCaptureUnit) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.video.q2v.startUploadPTV".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMWebEffectCameraCaptureUnit", 2, "receive ACTION_BLESS_UPLOAD_PTV.");
      }
      if (paramIntent.getIntExtra("broadcastType", 1) != 1) {
        return;
      }
      paramContext = QIMWebEffectCameraCaptureUnit.a(this.a).a();
      if (paramContext != null)
      {
        if (paramContext.isFinishing()) {
          return;
        }
        paramContext.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QIMWebEffectCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */