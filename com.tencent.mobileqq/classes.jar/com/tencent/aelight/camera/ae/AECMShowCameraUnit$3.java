package com.tencent.aelight.camera.ae;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView;

class AECMShowCameraUnit$3
  implements Runnable
{
  AECMShowCameraUnit$3(AECMShowCameraUnit paramAECMShowCameraUnit) {}
  
  public void run()
  {
    if ((this.this$0.E == -1L) && (this.this$0.H))
    {
      if (!AECMShowCameraUnit.c(this.this$0))
      {
        AECMShowCameraUnit.d(this.this$0).setClickable(true);
        Log.d(this.this$0.a, "tips: 设置为白色背景");
        AECMShowCameraUnit.d(this.this$0).setBackgroundDrawable(this.this$0.s().getResources().getDrawable(2063925303));
        AECMShowCameraUnit.d(this.this$0).setTextColor(-16777216);
      }
    }
    else if (!AECMShowCameraUnit.c(this.this$0))
    {
      AECMShowCameraUnit.d(this.this$0).setClickable(false);
      Log.d(this.this$0.a, "tips: 设置为白色背景 disable");
      AECMShowCameraUnit.d(this.this$0).setBackgroundDrawable(this.this$0.s().getResources().getDrawable(2063925304));
      AECMShowCameraUnit.d(this.this$0).setTextColor(Color.parseColor("#8F8F91"));
    }
    if (this.this$0.F >= 5000L)
    {
      if (!AECMShowCameraUnit.c(this.this$0)) {
        AECMShowCameraUnit.f(this.this$0).a(1000, AECMShowCameraUnit.e(this.this$0));
      }
      AECMShowCameraUnit.g(this.this$0).setText(2064187653);
      AEBaseDataReporter.a().aK();
      return;
    }
    if (!AECMShowCameraUnit.c(this.this$0))
    {
      AECMShowCameraUnit.f(this.this$0).a(1003, null);
      AECMShowCameraUnit.g(this.this$0).setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.3
 * JD-Core Version:    0.7.0.1
 */