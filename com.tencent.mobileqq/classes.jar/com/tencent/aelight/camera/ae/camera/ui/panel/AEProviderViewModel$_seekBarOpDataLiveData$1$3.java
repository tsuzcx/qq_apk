package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "config", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class AEProviderViewModel$_seekBarOpDataLiveData$1$3<T>
  implements Observer<S>
{
  AEProviderViewModel$_seekBarOpDataLiveData$1$3(MediatorLiveData paramMediatorLiveData) {}
  
  public final void a(AEBeautyConfigModel paramAEBeautyConfigModel)
  {
    AEQLog.b("AEProviderViewModel", "seekBarOpDataChange from beautySelectedLiveData");
    this.a.postValue(new SeekBarOpDataWrapper(2, paramAEBeautyConfigModel, paramAEBeautyConfigModel.i().isEmpty()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel._seekBarOpDataLiveData.1.3
 * JD-Core Version:    0.7.0.1
 */