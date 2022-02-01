package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class AEBeautyProviderViewModel$beautyConfigSetOnCreateLiveData$1$1<T>
  implements Observer<S>
{
  AEBeautyProviderViewModel$beautyConfigSetOnCreateLiveData$1$1(MediatorLiveData paramMediatorLiveData) {}
  
  public final void a(List<? extends AEBeautyConfigModel> paramList)
  {
    this.a.postValue(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderViewModel.beautyConfigSetOnCreateLiveData.1.1
 * JD-Core Version:    0.7.0.1
 */