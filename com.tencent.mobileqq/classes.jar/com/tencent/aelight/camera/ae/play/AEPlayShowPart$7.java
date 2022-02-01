package com.tencent.aelight.camera.ae.play;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;

class AEPlayShowPart$7
  implements Observer<AECaptureModeChangingEvent>
{
  AEPlayShowPart$7(AEPlayShowPart paramAEPlayShowPart) {}
  
  public void onChanged(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {
      return;
    }
    paramAECaptureModeChangingEvent = paramAECaptureModeChangingEvent.b;
    if (paramAECaptureModeChangingEvent == AECaptureMode.NORMAL)
    {
      if ((AEPlayShowGridAdapter.selectedMaterial == null) || (AEPlayShowGridAdapter.selectedMaterial != AEMaterialManager.n())) {
        AEBaseReportParam.a().r("none");
      }
      if (this.this$0.hasInflated()) {
        AEPlayShowPart.access$800(this.this$0).setVisibility(8);
      }
    }
    else if (paramAECaptureModeChangingEvent == AECaptureMode.GIF)
    {
      if (this.this$0.hasInflated()) {
        AEPlayShowPart.access$800(this.this$0).setVisibility(8);
      }
    }
    else if (paramAECaptureModeChangingEvent == AECaptureMode.PLAY)
    {
      AEPlayShowPart.access$900(this.this$0);
      if (AEPlayShowPart.access$700(this.this$0) != null)
      {
        paramAECaptureModeChangingEvent = AEPlayShowPart.access$700(this.this$0).getLastMaterialTabId();
        if ((!TextUtils.isEmpty(paramAECaptureModeChangingEvent)) && (!"-1".equals(paramAECaptureModeChangingEvent))) {
          AEBaseReportParam.a().r(paramAECaptureModeChangingEvent);
        }
      }
      AEPlayShowPart.access$800(this.this$0).setVisibility(0);
      AEPlayShowPart.access$1000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowPart.7
 * JD-Core Version:    0.7.0.1
 */