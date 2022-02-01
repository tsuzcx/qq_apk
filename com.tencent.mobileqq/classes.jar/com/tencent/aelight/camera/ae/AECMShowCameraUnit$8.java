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
    AECMShowCameraUnit.i(this.this$0).setImageDrawable(this.this$0.s().getResources().getDrawable(2063925307));
    AECMShowCameraUnit.d(this.this$0).setTag(Integer.valueOf(3));
    AECMShowCameraUnit.d(this.this$0).setText(2064187651);
    AECMShowCameraUnit.d(this.this$0).setClickable(true);
    AECMShowCameraUnit.d(this.this$0).setTextColor(-16777216);
    Log.d(this.this$0.a, "switch2CameraUI: 设置为白色背景");
    AECMShowCameraUnit.d(this.this$0).setBackgroundDrawable(this.this$0.s().getResources().getDrawable(2063925303));
    AECMShowCameraUnit.d(this.this$0).setVisibility(0);
    AECMShowCameraUnit.h(this.this$0).setTag(Integer.valueOf(5));
    AECMShowCameraUnit.h(this.this$0).setImageDrawable(this.this$0.s().getResources().getDrawable(2063925301));
    AECMShowCameraUnit.h(this.this$0).setClickable(true);
    AECMShowCameraUnit.h(this.this$0).setVisibility(0);
    AECMShowCameraUnit.j(this.this$0).setVisibility(8);
    AECMShowCameraUnit.g(this.this$0).setText("");
    AECMShowCameraUnit.g(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.8
 * JD-Core Version:    0.7.0.1
 */