package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.log.AEQLog;

class AETopRightBarPart$1
  implements Observer<AECaptureModeChangingEvent>
{
  AETopRightBarPart$1(AETopRightBarPart paramAETopRightBarPart) {}
  
  public void a(AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent != null)
    {
      if (this.a.a == null) {
        return;
      }
      if (AECameraEntryManager.o(AETopRightBarPart.a(this.a).getIntent()))
      {
        AETopRightBarPart.b(this.a).setVisibility(8);
        return;
      }
      AETopRightBarPart.a(this.a, paramAECaptureModeChangingEvent.b);
      if (AETopRightBarPart.c(this.a) != AECaptureMode.NORMAL)
      {
        AETopRightBarPart.b(this.a).setVisibility(8);
        return;
      }
      paramAECaptureModeChangingEvent = AETopRightBarPart.b(this.a);
      int i = 0;
      paramAECaptureModeChangingEvent.setVisibility(0);
      if ((AETopRightBarPart.d(this.a) != null) && (AETopRightBarPart.d(this.a).a != null))
      {
        int j = AECameraPrefsUtil.a().b("sp_key_ae_camera_ratio", AEVideoStoryTopBarViewModel.Ratio.FULL.code, 0);
        AETopRightBarPart.d(this.a).a.postValue(AEVideoStoryTopBarViewModel.Ratio.fromCode(j));
      }
      if (AETopRightBarPart.e(this.a) != null)
      {
        AEQLog.a("AETopRightBarPart", "mRatioSwitchView");
        paramAECaptureModeChangingEvent = AETopRightBarPart.e(this.a);
        if (!AETopRightBarPart.f(this.a)) {
          i = 8;
        }
        paramAECaptureModeChangingEvent.setVisibility(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AETopRightBarPart.1
 * JD-Core Version:    0.7.0.1
 */