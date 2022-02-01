package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;", "kotlin.jvm.PlatformType", "onChanged", "com/tencent/aelight/camera/ae/camera/ui/panel/AEProviderViewModel$_seekBarOpDataLiveData$1$5"}, k=3, mv={1, 1, 16})
final class AEProviderViewModel$$special$$inlined$apply$lambda$2<T>
  implements Observer<S>
{
  AEProviderViewModel$$special$$inlined$apply$lambda$2(MediatorLiveData paramMediatorLiveData, AEProviderViewModel paramAEProviderViewModel) {}
  
  public final void a(List<? extends AEBeautyConfigModel> paramList)
  {
    AEQLog.b("AEProviderViewModel", "seekBarOpDataChange from beautyConfigSetLiveData");
    this.a.postValue(new SeekBarOpDataWrapper(2, AEProviderViewModel.a(this.b).e().getValue(), false, 4, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel..special..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */