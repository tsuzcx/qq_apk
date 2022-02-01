package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.MutableLiveData;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AEBeautyProviderViewModel$1
  implements Runnable
{
  AEBeautyProviderViewModel$1(AEBeautyProviderViewModel paramAEBeautyProviderViewModel) {}
  
  public final void run()
  {
    Object localObject = this.this$0.l();
    AEBeautyProviderViewModel.a(this.this$0).postValue(localObject);
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      AEBeautyConfigModel localAEBeautyConfigModel = (AEBeautyConfigModel)localObject;
      int i;
      if ((!DYAEEffectItemExtKt.a(localAEBeautyConfigModel)) && (localAEBeautyConfigModel.k() != BeautyItem.RESET)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        break label86;
      }
    }
    localObject = null;
    label86:
    localObject = (AEBeautyConfigModel)localObject;
    if (localObject != null) {
      this.this$0.a((AEBeautyConfigModel)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderViewModel.1
 * JD-Core Version:    0.7.0.1
 */