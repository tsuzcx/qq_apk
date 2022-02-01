package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/MaterialPanelOpenState;", "kotlin.jvm.PlatformType", "onChanged", "com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowBottomPanelViewModel$bottomPanelShowLiveData$1$1"}, k=3, mv={1, 1, 16})
final class AEFlashShowBottomPanelViewModel$$special$$inlined$apply$lambda$1<T>
  implements Observer<S>
{
  AEFlashShowBottomPanelViewModel$$special$$inlined$apply$lambda$1(MediatorLiveData paramMediatorLiveData, AEFlashShowBottomPanelViewModel paramAEFlashShowBottomPanelViewModel) {}
  
  public final void a(MaterialPanelOpenState paramMaterialPanelOpenState)
  {
    this.a.postValue(Boolean.valueOf(paramMaterialPanelOpenState.a() | this.b.g()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPanelViewModel..special..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */