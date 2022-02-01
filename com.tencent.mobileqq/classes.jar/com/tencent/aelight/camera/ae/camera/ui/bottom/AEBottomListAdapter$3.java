package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.aelight.camera.ae.AEMaterialViewModel;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;

class AEBottomListAdapter$3
  implements Runnable
{
  AEBottomListAdapter$3(AEBottomListAdapter paramAEBottomListAdapter, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void run()
  {
    if (AEBottomListAdapter.b(this.this$0).getVisibility() == 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("### [bottom list] visible, select material ");
      localStringBuilder.append(this.a.m);
      QLog.d("AEBottomListAdapter", 4, localStringBuilder.toString());
      AEBottomListAdapter.c(this.this$0).a(this.a, true);
    }
    if (AEBottomListAdapter.b(this.this$0).getVisibility() == 0)
    {
      if (AEBottomListAdapter.d(this.this$0).b())
      {
        if (AEBottomListAdapter.e(this.this$0) != null)
        {
          AEBottomListAdapter.e(this.this$0).a(0, this.a);
          return;
        }
        AEBottomListAdapter.f(this.this$0).a(this.a);
        return;
      }
      AEQLog.d("AEBottomListAdapter", "selectMaterial---but current capture mode is not normal");
      return;
    }
    AEQLog.d("AEBottomListAdapter", "selectMaterial---list not visible, not apply");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.3
 * JD-Core Version:    0.7.0.1
 */