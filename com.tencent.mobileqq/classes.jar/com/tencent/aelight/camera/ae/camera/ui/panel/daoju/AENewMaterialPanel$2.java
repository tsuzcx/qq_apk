package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AENewMaterialPanel$2
  implements View.OnClickListener
{
  AENewMaterialPanel$2(AENewMaterialPanel paramAENewMaterialPanel) {}
  
  public final void onClick(View paramView)
  {
    paramView = AENewMaterialPanel.b(this.a);
    AEMaterialMetaData localAEMaterialMetaData = AEMaterialMetaData.l;
    Intrinsics.checkExpressionValueIsNotNull(localAEMaterialMetaData, "AEMaterialMetaData.MATERIAL_NONE");
    paramView.a(localAEMaterialMetaData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel.2
 * JD-Core Version:    0.7.0.1
 */