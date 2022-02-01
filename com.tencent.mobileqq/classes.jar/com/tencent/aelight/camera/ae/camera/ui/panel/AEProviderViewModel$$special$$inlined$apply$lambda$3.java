package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.log.AEQLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "index", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V", "com/tencent/aelight/camera/ae/camera/ui/panel/AEProviderViewModel$_seekBarOpDataLiveData$1$6"}, k=3, mv={1, 1, 16})
final class AEProviderViewModel$$special$$inlined$apply$lambda$3<T>
  implements Observer<S>
{
  AEProviderViewModel$$special$$inlined$apply$lambda$3(MediatorLiveData paramMediatorLiveData, AEProviderViewModel paramAEProviderViewModel) {}
  
  public final void a(Integer paramInteger)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seekBarOpDataChange from selectedPanelTabIndex, index = ");
    localStringBuilder.append(paramInteger);
    AEQLog.b("AEProviderViewModel", localStringBuilder.toString());
    if ((paramInteger != null) && (paramInteger.intValue() == 1))
    {
      this.a.postValue(new SeekBarOpDataWrapper(2, AEProviderViewModel.a(this.b).e().getValue(), false));
      return;
    }
    if ((paramInteger != null) && (paramInteger.intValue() == 2))
    {
      this.a.postValue(new SeekBarOpDataWrapper(3, AEProviderViewModel.b(this.b).b().getValue(), false, 4, null));
      return;
    }
    if (paramInteger == null) {
      return;
    }
    if (paramInteger.intValue() == 0) {
      this.a.postValue(new SeekBarOpDataWrapper(1, AEProviderViewModel.c(this.b).a().getValue(), false, 4, null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel..special..inlined.apply.lambda.3
 * JD-Core Version:    0.7.0.1
 */