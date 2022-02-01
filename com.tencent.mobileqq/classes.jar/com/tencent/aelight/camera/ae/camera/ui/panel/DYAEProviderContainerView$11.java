package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.qphone.base.util.QLog;

class DYAEProviderContainerView$11
  implements Observer<Boolean>
{
  DYAEProviderContainerView$11(DYAEProviderContainerView paramDYAEProviderContainerView) {}
  
  public void a(Boolean paramBoolean)
  {
    Object localObject = DYAEProviderContainerView.n(this.a);
    if (paramBoolean.booleanValue()) {
      i = 0;
    } else {
      i = 4;
    }
    ((StartPointSeekBar)localObject).setVisibility(i);
    localObject = DYAEProviderContainerView.o(this.a);
    if (paramBoolean.booleanValue()) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    if (!paramBoolean.booleanValue()) {
      return;
    }
    paramBoolean = (SeekBarOpDataWrapper)DYAEProviderContainerView.b(this.a).d().getValue();
    if (paramBoolean == null) {
      return;
    }
    localObject = paramBoolean.b();
    if (localObject == null) {
      return;
    }
    DYAEProviderContainerView.a(this.a, localObject);
    int i = AEProviderViewModel.a(localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onProgressChanged, type = ");
    ((StringBuilder)localObject).append(paramBoolean.a());
    ((StringBuilder)localObject).append(", progress = ");
    ((StringBuilder)localObject).append(i);
    QLog.d("AEProviderContainerView", 2, ((StringBuilder)localObject).toString());
    localObject = (AEPituCameraUnit)DYAEProviderContainerView.p(this.a).a(65537, new Object[0]);
    if ((localObject != null) && (paramBoolean.c())) {
      ((AEPituCameraUnit)localObject).a(paramBoolean.a(), paramBoolean.b(), i, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEProviderContainerView.11
 * JD-Core Version:    0.7.0.1
 */