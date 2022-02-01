package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.View;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper;

class DYAEProviderContainerView$1
  implements DYTabLayout.TabSelectListener
{
  DYAEProviderContainerView$1(DYAEProviderContainerView paramDYAEProviderContainerView) {}
  
  public void a(View paramView, int paramInt)
  {
    paramInt = DYAEBeautyPanelConfigUtil.a(DYAEProviderContainerView.a(this.a), paramInt);
    if (DYAEProviderContainerView.b(this.a) != null) {
      DYAEProviderContainerView.b(this.a).a(paramInt);
    }
    if (paramInt == 1)
    {
      AEBaseDataReporter.a().af();
      DYAEProviderContainerView.c(this.a);
      return;
    }
    if (paramInt == 2)
    {
      AEBaseDataReporter.a().ag();
      DYAEProviderContainerView.d(this.a);
      return;
    }
    if (paramInt == 0)
    {
      AEBaseDataReporter.a().ah();
      AECameraDaTongHelper.a.a(DYAEProviderContainerView.e(this.a), "em_ae_filter_tab");
      AECameraDaTongHelper.a.a(DYAEProviderContainerView.e(this.a), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEProviderContainerView.1
 * JD-Core Version:    0.7.0.1
 */