package com.tencent.aelight.camera.aebase.activity;

import android.os.Bundle;
import com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadActivity$1
  implements Runnable
{
  CaptureQmcfSoDownloadActivity$1(CaptureQmcfSoDownloadActivity paramCaptureQmcfSoDownloadActivity) {}
  
  public void run()
  {
    if ((BaseActivity.sTopActivity instanceof CaptureQmcfSoDownloadActivity))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("is top activity, hasRequest: ");
      ((StringBuilder)localObject).append(CaptureQmcfSoDownloadActivity.a(this.this$0));
      QLog.d("qqBaseActivity", 4, ((StringBuilder)localObject).toString());
      CaptureQmcfSoDownloadActivity.a(this.this$0).putString("KEY_ISENTER_SO_DOWNLOAD", "true");
      if (CaptureQmcfSoDownloadActivity.a(this.this$0))
      {
        if ((CaptureQmcfSoDownloadActivity.a(this.this$0) instanceof CaptureQmcfSoDownloadFragment)) {
          ((CaptureQmcfSoDownloadFragment)CaptureQmcfSoDownloadActivity.a(this.this$0)).a();
        } else {
          AEQLog.d(CaptureQmcfSoDownloadActivity.a, "[onFinish]soDownloadFragment not instanceof CaptureQmcfSoDownloadFragment");
        }
        localObject = (IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class);
        localCaptureQmcfSoDownloadActivity = this.this$0;
        ((IQIMCameraCapture)localObject).launchForResult(localCaptureQmcfSoDownloadActivity, CaptureQmcfSoDownloadActivity.a(localCaptureQmcfSoDownloadActivity), CaptureQmcfSoDownloadActivity.a(this.this$0));
        return;
      }
      AEQLog.d(CaptureQmcfSoDownloadActivity.a, "[onFinish]hasRequest false");
      localObject = (IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class);
      CaptureQmcfSoDownloadActivity localCaptureQmcfSoDownloadActivity = this.this$0;
      ((IQIMCameraCapture)localObject).launch(localCaptureQmcfSoDownloadActivity, CaptureQmcfSoDownloadActivity.a(localCaptureQmcfSoDownloadActivity));
      this.this$0.finish();
      return;
    }
    AEQLog.d(CaptureQmcfSoDownloadActivity.a, "[onFinish]BaseActivity.sTopActivity not instanceof CaptureQmcfSoDownloadActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.activity.CaptureQmcfSoDownloadActivity.1
 * JD-Core Version:    0.7.0.1
 */