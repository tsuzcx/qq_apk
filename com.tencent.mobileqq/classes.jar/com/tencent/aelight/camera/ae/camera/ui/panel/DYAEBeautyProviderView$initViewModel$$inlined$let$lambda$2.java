package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.Observer;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "config", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;", "kotlin.jvm.PlatformType", "onChanged", "com/tencent/aelight/camera/ae/camera/ui/panel/DYAEBeautyProviderView$initViewModel$1$2"}, k=3, mv={1, 1, 16})
final class DYAEBeautyProviderView$initViewModel$$inlined$let$lambda$2<T>
  implements Observer<AEBeautyConfigModel>
{
  DYAEBeautyProviderView$initViewModel$$inlined$let$lambda$2(DYAEBeautyProviderView paramDYAEBeautyProviderView) {}
  
  public final void a(AEBeautyConfigModel paramAEBeautyConfigModel)
  {
    if (paramAEBeautyConfigModel.a() == BeautyItem.NONE.getType())
    {
      DYAEBeautyProviderView.a(this.a).a();
      return;
    }
    DYAEEffectListHolder localDYAEEffectListHolder = DYAEBeautyProviderView.a(this.a);
    if (paramAEBeautyConfigModel != null)
    {
      paramAEBeautyConfigModel = paramAEBeautyConfigModel.a();
      if (paramAEBeautyConfigModel != null)
      {
        paramAEBeautyConfigModel = String.valueOf(paramAEBeautyConfigModel.ordinal());
        break label58;
      }
    }
    paramAEBeautyConfigModel = null;
    label58:
    DYAEEffectListHolder.a(localDYAEEffectListHolder, paramAEBeautyConfigModel, false, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEBeautyProviderView.initViewModel..inlined.let.lambda.2
 * JD-Core Version:    0.7.0.1
 */