package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/SeekBarOpDataWrapper;", "kotlin.jvm.PlatformType", "onChanged", "com/tencent/aelight/camera/ae/camera/ui/panel/AEProviderViewModel$_seekBarShowLiveData$1$1"}, k=3, mv={1, 1, 16})
final class AEProviderViewModel$$special$$inlined$apply$lambda$4<T>
  implements Observer<S>
{
  AEProviderViewModel$$special$$inlined$apply$lambda$4(MediatorLiveData paramMediatorLiveData, AEProviderViewModel paramAEProviderViewModel) {}
  
  public final void a(SeekBarOpDataWrapper paramSeekBarOpDataWrapper)
  {
    paramSeekBarOpDataWrapper = (Integer)AEProviderViewModel.d(this.b).getValue();
    boolean bool2 = true;
    Object localObject;
    if ((paramSeekBarOpDataWrapper != null) && (paramSeekBarOpDataWrapper.intValue() == 0))
    {
      paramSeekBarOpDataWrapper = AEProviderViewModel.c(this.b).a().getValue();
    }
    else if ((paramSeekBarOpDataWrapper != null) && (paramSeekBarOpDataWrapper.intValue() == 1))
    {
      localObject = (AEBeautyConfigModel)AEProviderViewModel.a(this.b).e().getValue();
      paramSeekBarOpDataWrapper = (SeekBarOpDataWrapper)localObject;
      if (localObject != null)
      {
        paramSeekBarOpDataWrapper = (SeekBarOpDataWrapper)localObject;
        if ((((Collection)((AEBeautyConfigModel)localObject).i()).isEmpty() ^ true)) {
          paramSeekBarOpDataWrapper = AEProviderViewModel.a.b((AEBeautyConfigModel)localObject);
        }
      }
    }
    else if ((paramSeekBarOpDataWrapper != null) && (paramSeekBarOpDataWrapper.intValue() == 2))
    {
      paramSeekBarOpDataWrapper = AEProviderViewModel.b(this.b).b().getValue();
    }
    else
    {
      paramSeekBarOpDataWrapper = null;
    }
    if (paramSeekBarOpDataWrapper != null)
    {
      localObject = this.a;
      boolean bool3 = DYAEEffectItemExtKt.a(paramSeekBarOpDataWrapper);
      boolean bool1;
      if ((paramSeekBarOpDataWrapper instanceof DYAEEffectItem))
      {
        bool1 = ((DYAEEffectItem)paramSeekBarOpDataWrapper).f();
      }
      else if ((paramSeekBarOpDataWrapper instanceof AEBeautyConfigModel))
      {
        bool1 = ((AEBeautyConfigModel)paramSeekBarOpDataWrapper).h();
      }
      else
      {
        bool1 = bool2;
        if ((paramSeekBarOpDataWrapper instanceof AEBeautySecondaryConfigModel)) {
          if ((((AEBeautySecondaryConfigModel)paramSeekBarOpDataWrapper).j()) && ((Intrinsics.areEqual((Boolean)AEProviderViewModel.a(this.b).h().getValue(), Boolean.valueOf(false)) ^ true))) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
      }
      ((MediatorLiveData)localObject).postValue(Boolean.valueOf((bool3 ^ true) & bool1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel..special..inlined.apply.lambda.4
 * JD-Core Version:    0.7.0.1
 */