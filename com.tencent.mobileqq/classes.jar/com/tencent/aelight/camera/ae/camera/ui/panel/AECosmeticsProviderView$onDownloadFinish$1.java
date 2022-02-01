package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AECosmeticsProviderView$onDownloadFinish$1
  implements Runnable
{
  AECosmeticsProviderView$onDownloadFinish$1(AECosmeticsProviderView paramAECosmeticsProviderView, boolean paramBoolean, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public final void run()
  {
    if (this.a)
    {
      if ((AECosmeticsProviderView.b(this.this$0) instanceof DYAEMaterialItem))
      {
        Object localObject = AECosmeticsProviderView.b(this.this$0);
        if (localObject != null)
        {
          if (Intrinsics.areEqual(((DYAEMaterialItem)localObject).g().m, this.b.m))
          {
            localObject = AECosmeticsProviderView.c(this.this$0);
            DYAEEffectItem localDYAEEffectItem = AECosmeticsProviderView.b(this.this$0);
            if (localDYAEEffectItem == null) {
              Intrinsics.throwNpe();
            }
            ((AECosmeticsViewModel)localObject).a(localDYAEEffectItem);
            AECosmeticsProviderView.a(this.this$0, (DYAEEffectItem)null);
          }
        }
        else {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.ae.camera.ui.panel.DYAEMaterialItem");
        }
      }
    }
    else {
      QQToast.makeText(this.this$0.getContext(), (CharSequence)HardCodeUtil.a(2131907502), 0).show();
    }
    AECosmeticsProviderView.a(this.this$0).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsProviderView.onDownloadFinish.1
 * JD-Core Version:    0.7.0.1
 */