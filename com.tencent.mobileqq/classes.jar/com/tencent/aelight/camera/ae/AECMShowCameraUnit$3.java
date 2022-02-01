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
    if ((this.this$0.jdField_a_of_type_Long == -1L) && (this.this$0.d))
    {
      if (!AECMShowCameraUnit.b(this.this$0))
      {
        AECMShowCameraUnit.a(this.this$0).setClickable(true);
        Log.d(this.this$0.jdField_a_of_type_JavaLangString, "tips: 设置为白色背景");
        AECMShowCameraUnit.a(this.this$0).setBackgroundDrawable(this.this$0.a().getResources().getDrawable(2064056366));
        AECMShowCameraUnit.a(this.this$0).setTextColor(-16777216);
      }
    }
    else if (!AECMShowCameraUnit.b(this.this$0))
    {
      AECMShowCameraUnit.a(this.this$0).setClickable(false);
      Log.d(this.this$0.jdField_a_of_type_JavaLangString, "tips: 设置为白色背景 disable");
      AECMShowCameraUnit.a(this.this$0).setBackgroundDrawable(this.this$0.a().getResources().getDrawable(2064056367));
      AECMShowCameraUnit.a(this.this$0).setTextColor(Color.parseColor("#8F8F91"));
    }
    if (this.this$0.b >= 5000L)
    {
      if (!AECMShowCameraUnit.b(this.this$0)) {
        AECMShowCameraUnit.a(this.this$0).a(1000, AECMShowCameraUnit.a(this.this$0));
      }
      AECMShowCameraUnit.a(this.this$0).setText(2064515310);
      AEBaseDataReporter.a().aF();
      return;
    }
    if (!AECMShowCameraUnit.b(this.this$0))
    {
      AECMShowCameraUnit.a(this.this$0).a(1003, null);
      AECMShowCameraUnit.a(this.this$0).setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.3
 * JD-Core Version:    0.7.0.1
 */