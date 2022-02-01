package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.log.AEQLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "material", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class AEProviderViewModel$_seekBarOpDataLiveData$1$2<T>
  implements Observer<S>
{
  AEProviderViewModel$_seekBarOpDataLiveData$1$2(MediatorLiveData paramMediatorLiveData) {}
  
  public final void a(DYAEEffectItem paramDYAEEffectItem)
  {
    AEQLog.b("AEProviderViewModel", "seekBarOpDataChange from cosmetics selectedMaterial");
    this.a.postValue(new SeekBarOpDataWrapper(3, paramDYAEEffectItem, false, 4, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel._seekBarOpDataLiveData.1.2
 * JD-Core Version:    0.7.0.1
 */