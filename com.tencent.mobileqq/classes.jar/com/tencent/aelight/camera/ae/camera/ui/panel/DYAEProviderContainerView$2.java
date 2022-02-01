package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.lifecycle.LiveData;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.log.AEQLog;

class DYAEProviderContainerView$2
  implements View.OnClickListener
{
  DYAEProviderContainerView$2(DYAEProviderContainerView paramDYAEProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (DYAEProviderContainerView.b(this.a) != null)
    {
      paramView = (Boolean)DYAEProviderContainerView.b(this.a).c().getValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("click toggle ai beauty, current state=");
      localStringBuilder.append(paramView);
      AEQLog.b("AEProviderContainerView", localStringBuilder.toString());
      if (paramView != null)
      {
        DYAEProviderContainerView.b(this.a).a(paramView.booleanValue() ^ true);
        AEBaseReportParam.a().d(paramView.booleanValue() ^ true);
        AEBaseDataReporter.a().aW();
      }
    }
    DYAEProviderContainerView.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEProviderContainerView.2
 * JD-Core Version:    0.7.0.1
 */