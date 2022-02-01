package com.tencent.aelight.camera.ae.play;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.download.AEDownloadMaterialRunnable;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEPlayShowPart$9
  implements View.OnClickListener
{
  AEPlayShowPart$9(AEPlayShowPart paramAEPlayShowPart) {}
  
  public void onClick(View paramView)
  {
    AEPlayShowPart.access$1100(this.this$0);
    AEPlayShowPart.access$1200(this.this$0).setVisibility(8);
    AECameraPrefsUtil.a().a("ShadowBackendSvc.GetPlayShowCatMatTree", "", 4);
    ThreadManager.getSubThreadHandler().post(new AEDownloadMaterialRunnable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowPart.9
 * JD-Core Version:    0.7.0.1
 */