package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.widget.QQViewPager;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AEFlashShowMaterialProviderView$selectCategoryAndItem$1
  implements Runnable
{
  AEFlashShowMaterialProviderView$selectCategoryAndItem$1(AEFlashShowMaterialProviderView paramAEFlashShowMaterialProviderView, int paramInt) {}
  
  public final void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select category: ");
    ((StringBuilder)localObject).append(this.a);
    AEQLog.b("AEFlashShowMaterialProviderView", ((StringBuilder)localObject).toString());
    localObject = AEFlashShowMaterialProviderView.c(this.this$0);
    if (localObject != null) {
      ((QQViewPager)localObject).setCurrentItem(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialProviderView.selectCategoryAndItem.1
 * JD-Core Version:    0.7.0.1
 */