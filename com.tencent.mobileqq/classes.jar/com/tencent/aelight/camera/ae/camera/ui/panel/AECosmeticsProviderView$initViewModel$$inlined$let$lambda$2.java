package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "list", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "kotlin.jvm.PlatformType", "onChanged", "com/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsProviderView$initViewModel$1$2"}, k=3, mv={1, 1, 16})
final class AECosmeticsProviderView$initViewModel$$inlined$let$lambda$2<T>
  implements Observer<List<? extends DYAEEffectItem>>
{
  AECosmeticsProviderView$initViewModel$$inlined$let$lambda$2(AECosmeticsProviderView paramAECosmeticsProviderView) {}
  
  public final void a(List<? extends DYAEEffectItem> paramList)
  {
    DYAEEffectListHolder localDYAEEffectListHolder = AECosmeticsProviderView.a(this.a);
    Intrinsics.checkExpressionValueIsNotNull(paramList, "list");
    localDYAEEffectListHolder.a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsProviderView.initViewModel..inlined.let.lambda.2
 * JD-Core Version:    0.7.0.1
 */