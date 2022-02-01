package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AECosmeticsProviderView$loadCosmeticList$1
  implements Runnable
{
  AECosmeticsProviderView$loadCosmeticList$1(AECosmeticsProviderView paramAECosmeticsProviderView) {}
  
  public final void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (AECosmeticsProviderView.d(this.this$0)) {
      localObject = DYAEEffectItemExtKt.a();
    } else {
      localObject = DYAEEffectItemExtKt.b();
    }
    Object localObject = (DYAEEffectItem)localObject;
    localArrayList.add(localObject);
    try
    {
      if (AECosmeticsProviderView.d(this.this$0)) {
        localArrayList.addAll((Collection)AECosmeticsProviderView.e(this.this$0));
      } else {
        localArrayList.addAll((Collection)AECosmeticsProviderView.f(this.this$0));
      }
    }
    catch (Error localError)
    {
      AEQLog.a("AECosmeticProviderView", "load cosmetic data fail", (Throwable)localError);
    }
    AECosmeticsProviderView.c(this.this$0).a(AECosmeticsProviderView.a(this.this$0, (List)localArrayList));
    AECosmeticsProviderView.c(this.this$0).a((DYAEEffectItem)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsProviderView.loadCosmeticList.1
 * JD-Core Version:    0.7.0.1
 */