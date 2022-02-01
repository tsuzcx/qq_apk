package com.tencent.aelight.camera.ae;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.cmshow.AECMShowLoadingView;

class AECMShowCameraUnit$8
  implements Runnable
{
  AECMShowCameraUnit$8(AECMShowCameraUnit paramAECMShowCameraUnit) {}
  
  public void run()
  {
    AECMShowCameraUnit.b(this.this$0).setImageDrawable(this.this$0.a().getResources().getDrawable(2064056370));
    AECMShowCameraUnit.a(this.this$0).setTag(Integer.valueOf(3));
    AECMShowCameraUnit.a(this.this$0).setText(2064515308);
    AECMShowCameraUnit.a(this.this$0).setClickable(true);
    AECMShowCameraUnit.a(this.this$0).setTextColor(-16777216);
    Log.d(this.this$0.a, "switch2CameraUI: 设置为白色背景");
    AECMShowCameraUnit.a(this.this$0).setBackgroundDrawable(this.this$0.a().getResources().getDrawable(2064056366));
    AECMShowCameraUnit.a(this.this$0).setVisibility(0);
    AECMShowCameraUnit.a(this.this$0).setTag(Integer.valueOf(5));
    AECMShowCameraUnit.a(this.this$0).setImageDrawable(this.this$0.a().getResources().getDrawable(2064056364));
    AECMShowCameraUnit.a(this.this$0).setClickable(true);
    AECMShowCameraUnit.a(this.this$0).setVisibility(0);
    AECMShowCameraUnit.a(this.this$0).setVisibility(8);
    AECMShowCameraUnit.a(this.this$0).setText("");
    AECMShowCameraUnit.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.8
 * JD-Core Version:    0.7.0.1
 */