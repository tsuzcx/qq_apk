package com.tencent.aelight.camera.ae;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.cmshow.AECMShowLoadingView;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView;

class AECMShowCameraUnit$5
  implements Runnable
{
  AECMShowCameraUnit$5(AECMShowCameraUnit paramAECMShowCameraUnit) {}
  
  public void run()
  {
    AECMShowCameraUnit.g(this.this$0).setVisibility(8);
    AECMShowCameraUnit.h(this.this$0).setVisibility(8);
    AECMShowCameraUnit.d(this.this$0).setClickable(true);
    AECMShowCameraUnit.d(this.this$0).setVisibility(8);
    AECMShowCameraUnit.f(this.this$0).a(1003, null);
    AECMShowCameraUnit.i(this.this$0).setImageDrawable(this.this$0.s().getResources().getDrawable(2063925306));
    AECMShowCameraUnit.j(this.this$0).a(1, null);
    AECMShowCameraUnit.j(this.this$0).setAlpha(1.0F);
    AECMShowCameraUnit.j(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.5
 * JD-Core Version:    0.7.0.1
 */