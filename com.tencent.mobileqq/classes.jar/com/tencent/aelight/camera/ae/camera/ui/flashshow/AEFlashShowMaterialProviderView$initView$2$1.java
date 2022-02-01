package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AEFlashShowMaterialProviderView$initView$2$1
  implements View.OnClickListener
{
  AEFlashShowMaterialProviderView$initView$2$1(AEFlashShowMaterialProviderView paramAEFlashShowMaterialProviderView) {}
  
  public final void onClick(View paramView)
  {
    paramView = AEFlashShowMaterialProviderView.a(this.a);
    if (paramView != null) {
      paramView.a(AEMaterialMetaData.l, false);
    }
    paramView = AEFlashShowMaterialProviderView.b(this.a);
    if (paramView != null) {
      paramView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialProviderView.initView.2.1
 * JD-Core Version:    0.7.0.1
 */