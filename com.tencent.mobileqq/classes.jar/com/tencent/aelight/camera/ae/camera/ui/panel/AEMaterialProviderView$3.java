package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AEMaterialProviderView$3
  implements Runnable
{
  AEMaterialProviderView$3(AEMaterialProviderView paramAEMaterialProviderView, int paramInt, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void run()
  {
    AEGridView localAEGridView = (AEGridView)AEMaterialProviderView.c(this.this$0).a.get(Integer.valueOf(this.a));
    if (localAEGridView != null)
    {
      AEMaterialAdapter localAEMaterialAdapter = (AEMaterialAdapter)localAEGridView.getAdapter();
      localAEGridView.a(this.b.p);
      localAEMaterialAdapter.a(this.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialProviderView", 2, "gridView is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialProviderView.3
 * JD-Core Version:    0.7.0.1
 */