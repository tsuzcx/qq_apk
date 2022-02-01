package com.tencent.aelight.camera.ae;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

class AECMShowCameraUnit$4
  implements Runnable
{
  AECMShowCameraUnit$4(AECMShowCameraUnit paramAECMShowCameraUnit) {}
  
  public void run()
  {
    AECMShowCameraUnit.a(this.this$0).setText(this.this$0.a().getResources().getString(2064515084));
    AECMShowCameraUnit.a(this.this$0).setClickable(false);
    AECMShowCameraUnit.a(this.this$0).setText(this.this$0.a().getResources().getString(2064515309));
    AECMShowCameraUnit.a(this.this$0).setVisibility(0);
    AECMShowCameraUnit.a(this.this$0).setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.4
 * JD-Core Version:    0.7.0.1
 */