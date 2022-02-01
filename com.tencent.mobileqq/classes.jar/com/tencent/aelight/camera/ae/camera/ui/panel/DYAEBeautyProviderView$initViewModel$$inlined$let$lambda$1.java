package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "configs", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;", "kotlin.jvm.PlatformType", "onChanged", "com/tencent/aelight/camera/ae/camera/ui/panel/DYAEBeautyProviderView$initViewModel$1$1"}, k=3, mv={1, 1, 16})
final class DYAEBeautyProviderView$initViewModel$$inlined$let$lambda$1<T>
  implements Observer<List<? extends AEBeautyConfigModel>>
{
  DYAEBeautyProviderView$initViewModel$$inlined$let$lambda$1(DYAEBeautyProviderView paramDYAEBeautyProviderView) {}
  
  public final void a(List<? extends AEBeautyConfigModel> paramList)
  {
    DYAEEffectListHolder localDYAEEffectListHolder = DYAEBeautyProviderView.a(this.a);
    Intrinsics.checkExpressionValueIsNotNull(paramList, "configs");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(new DYAEBeautyItem((AEBeautyConfigModel)((Iterator)localObject).next()));
    }
    localDYAEEffectListHolder.a((List)paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEBeautyProviderView.initViewModel..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */