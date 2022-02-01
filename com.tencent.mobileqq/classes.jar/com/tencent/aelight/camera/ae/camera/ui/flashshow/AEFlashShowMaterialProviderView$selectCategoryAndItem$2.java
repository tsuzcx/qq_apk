package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AEFlashShowMaterialProviderView$selectCategoryAndItem$2
  implements Runnable
{
  AEFlashShowMaterialProviderView$selectCategoryAndItem$2(AEFlashShowMaterialProviderView paramAEFlashShowMaterialProviderView, int paramInt, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public final void run()
  {
    Object localObject1 = AEFlashShowMaterialProviderView.d(this.this$0);
    if (localObject1 != null)
    {
      localObject1 = ((AEFlashShowMaterialTabAdapter)localObject1).a();
      if (localObject1 != null)
      {
        localObject1 = (AEFlashShowGridView)((HashMap)localObject1).get(Integer.valueOf(this.a));
        break label41;
      }
    }
    localObject1 = null;
    label41:
    if (localObject1 != null)
    {
      Object localObject2 = ((AEFlashShowGridView)localObject1).getAdapter();
      if (localObject2 != null)
      {
        localObject2 = (AEFlashShowMaterialAdapter)localObject2;
        ((AEFlashShowGridView)localObject1).a(this.b.p);
        ((AEFlashShowMaterialAdapter)localObject2).a(this.b);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialAdapter");
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEFlashShowMaterialProviderView", 2, "gridView is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialProviderView.selectCategoryAndItem.2
 * JD-Core Version:    0.7.0.1
 */