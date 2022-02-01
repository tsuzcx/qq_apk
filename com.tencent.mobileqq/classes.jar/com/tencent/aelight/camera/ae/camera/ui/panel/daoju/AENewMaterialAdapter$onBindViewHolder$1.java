package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AENewMaterialAdapter$onBindViewHolder$1
  implements View.OnClickListener
{
  AENewMaterialAdapter$onBindViewHolder$1(AENewMaterialAdapter paramAENewMaterialAdapter, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public final void onClick(View paramView)
  {
    AENewMaterialAdapter.a(this.a, this.b);
    AECameraDaTongHelper localAECameraDaTongHelper = AECameraDaTongHelper.a;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "it");
    String str = this.b.m;
    Intrinsics.checkExpressionValueIsNotNull(str, "material.id");
    localAECameraDaTongHelper.a(paramView, "em_ae_motion_item", str);
    AECameraDaTongHelper.a.a(paramView, MapsKt.mapOf(new Pair[] { TuplesKt.to("ae_motion_name", this.b.m), TuplesKt.to("ae_props_category", this.b.o) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialAdapter.onBindViewHolder.1
 * JD-Core Version:    0.7.0.1
 */