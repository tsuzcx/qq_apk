package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.View;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.flashshow.FlashShowDtReportHelper;
import com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"bindBeautyItemDtElement", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "reportBeautyItemDtClick", "reportBeautyItemDtExpose", "dtReportKey", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautySecondaryItem;", "aelight_impl_release"}, k=2, mv={1, 1, 16})
public final class DYAEEffectListHolderKt
{
  private static final String a(@NotNull BeautyItem paramBeautyItem)
  {
    switch (DYAEEffectListHolderKt.WhenMappings.$EnumSwitchMapping$2[paramBeautyItem.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 19: 
      return "shouquangu";
    case 18: 
      return "shoubi";
    case 17: 
      return "xiaolian";
    case 16: 
      return "zhailian";
    case 15: 
      return "zuixing";
    case 14: 
      return "dayan";
    case 13: 
      return "etou";
    case 12: 
      return "meibai";
    case 11: 
      return "qingxi";
    case 10: 
      return "falingwen";
    case 9: 
      return "heiyanquan";
    case 8: 
      return "kouhong";
    case 7: 
      return "saihong";
    case 6: 
      return "liti";
    case 5: 
      return "baiya";
    case 4: 
      return "shoulian";
    case 3: 
      return "mopi";
    case 2: 
      return "reset";
    }
    return "none";
  }
  
  private static final String a(@NotNull BeautySecondaryItem paramBeautySecondaryItem)
  {
    int i = DYAEEffectListHolderKt.WhenMappings.$EnumSwitchMapping$3[paramBeautySecondaryItem.ordinal()];
    paramBeautySecondaryItem = "ziran";
    switch (i)
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 19: 
      return "junlang";
    case 18: 
      return "qingxin";
    case 16: 
      return "guangmang";
    case 14: 
      return "shengxia";
    case 13: 
      return "haixiu";
    case 12: 
      return "chengshu";
    case 11: 
      return "jianyue";
    case 9: 
      return "fugu";
    case 8: 
      return "huoli";
    case 7: 
      return "wenrou";
    case 6: 
      return "shanhu";
    case 5: 
      return "mitao";
    case 4: 
    case 10: 
    case 15: 
      return "none";
    case 3: 
      return "yingjun";
    case 2: 
      paramBeautySecondaryItem = "qizhi";
    }
    return paramBeautySecondaryItem;
  }
  
  private static final void d(View paramView, DYAEEffectItem paramDYAEEffectItem)
  {
    Object localObject1;
    Object localObject2;
    StringBuilder localStringBuilder;
    if ((paramDYAEEffectItem instanceof DYAEBeautyItem))
    {
      localObject1 = (DYAEBeautyItem)paramDYAEEffectItem;
      localObject2 = ((DYAEBeautyItem)localObject1).g().k();
      int i = DYAEEffectListHolderKt.WhenMappings.$EnumSwitchMapping$0[localObject2.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          VideoReport.setElementId(paramView, "em_xsj_beauty_item");
          localObject2 = FlashShowDtReportHelper.a().d();
          ((HashMap)localObject2).put("xsj_beauty_name", a(((DYAEBeautyItem)localObject1).g().k()));
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("xsj_");
          localStringBuilder.append(a(((DYAEBeautyItem)localObject1).g().k()));
          localStringBuilder.append("_value");
          ((HashMap)localObject2).put(localStringBuilder.toString(), Integer.valueOf(AEProviderViewModel.a.b(paramDYAEEffectItem)));
          VideoReport.setElementParams(paramView, (Map)localObject2);
        }
        else
        {
          VideoReport.setElementId(paramView, "em_xsj_beauty_reset");
          VideoReport.setElementParams(paramView, (Map)FlashShowDtReportHelper.a().d());
        }
      }
      else
      {
        VideoReport.setElementId(paramView, "em_xsj_beauty_clear");
        VideoReport.setElementParams(paramView, (Map)FlashShowDtReportHelper.a().d());
      }
    }
    if ((paramDYAEEffectItem instanceof DYAESecondaryBeautyItem))
    {
      VideoReport.setElementId(paramView, "em_xsj_beauty_item");
      localObject1 = FlashShowDtReportHelper.a().d();
      localObject2 = (DYAESecondaryBeautyItem)paramDYAEEffectItem;
      ((HashMap)localObject1).put("xsj_beauty_name", a(((DYAESecondaryBeautyItem)localObject2).g().k()));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xsj_");
      localStringBuilder.append(a(((DYAESecondaryBeautyItem)localObject2).g().k()));
      localStringBuilder.append("_value");
      ((HashMap)localObject1).put(localStringBuilder.toString(), Integer.valueOf(AEProviderViewModel.a.b(paramDYAEEffectItem)));
      VideoReport.setElementParams(paramView, (Map)localObject1);
    }
    if ((paramDYAEEffectItem instanceof DYAEMaterialItem))
    {
      VideoReport.setElementId(paramView, "em_xsj_makeup_item");
      localObject1 = FlashShowDtReportHelper.a().d();
      localObject2 = (DYAEMaterialItem)paramDYAEEffectItem;
      ((HashMap)localObject1).put("xsj_makeup_name", ((DYAEMaterialItem)localObject2).g().t);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xsj_");
      localStringBuilder.append(((DYAEMaterialItem)localObject2).g().t);
      localStringBuilder.append("_value");
      ((HashMap)localObject1).put(localStringBuilder.toString(), Integer.valueOf(AEProviderViewModel.a.b(paramDYAEEffectItem)));
      VideoReport.setElementParams(paramView, (Map)localObject1);
    }
  }
  
  private static final void e(View paramView, DYAEEffectItem paramDYAEEffectItem)
  {
    Object localObject1;
    Object localObject2;
    StringBuilder localStringBuilder;
    if ((paramDYAEEffectItem instanceof DYAEBeautyItem))
    {
      localObject1 = (DYAEBeautyItem)paramDYAEEffectItem;
      localObject2 = ((DYAEBeautyItem)localObject1).g().k();
      int i = DYAEEffectListHolderKt.WhenMappings.$EnumSwitchMapping$1[localObject2.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          localObject2 = TuplesKt.to("xsj_beauty_name", a(((DYAEBeautyItem)localObject1).g().k()));
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("xsj_");
          localStringBuilder.append(a(((DYAEBeautyItem)localObject1).g().k()));
          localStringBuilder.append("_value");
          VideoReport.reportEvent("dt_clck", paramView, MapsKt.mapOf(new Pair[] { localObject2, TuplesKt.to(localStringBuilder.toString(), Integer.valueOf(AEProviderViewModel.a.b(paramDYAEEffectItem))) }));
          AECameraDaTongHelper.a.a(paramView, "em_ae_beauty_item", paramDYAEEffectItem.a());
          AECameraDaTongHelper.a.a(paramView, MapsKt.mapOf(TuplesKt.to("ae_beauty_name", a(((DYAEBeautyItem)localObject1).g().k()))));
        }
        else
        {
          VideoReport.reportEvent("dt_clck", paramView, (Map)FlashShowDtReportHelper.a().d());
          AECameraDaTongHelper.a.a(paramView, "em_ae_beauty_item", paramDYAEEffectItem.a());
          AECameraDaTongHelper.a.a(paramView, MapsKt.mapOf(TuplesKt.to("ae_beauty_name", "reset")));
        }
      }
      else
      {
        VideoReport.reportEvent("dt_clck", paramView, (Map)FlashShowDtReportHelper.a().d());
        AECameraDaTongHelper.a.a(paramView, "em_ae_beauty_item", paramDYAEEffectItem.a());
        AECameraDaTongHelper.a.a(paramView, MapsKt.mapOf(TuplesKt.to("ae_beauty_name", "none")));
      }
    }
    if ((paramDYAEEffectItem instanceof DYAESecondaryBeautyItem))
    {
      localObject1 = (DYAESecondaryBeautyItem)paramDYAEEffectItem;
      localObject2 = TuplesKt.to("xsj_beauty_name", a(((DYAESecondaryBeautyItem)localObject1).g().k()));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xsj_");
      localStringBuilder.append(a(((DYAESecondaryBeautyItem)localObject1).g().k()));
      localStringBuilder.append("_value");
      VideoReport.reportEvent("dt_clck", paramView, MapsKt.mapOf(new Pair[] { localObject2, TuplesKt.to(localStringBuilder.toString(), Integer.valueOf(AEProviderViewModel.a.b(paramDYAEEffectItem))) }));
      AECameraDaTongHelper.a.a(paramView, "em_ae_beauty_item", paramDYAEEffectItem.a());
      AECameraDaTongHelper.a.a(paramView, MapsKt.mapOf(TuplesKt.to("ae_beauty_name", a(((DYAESecondaryBeautyItem)localObject1).g().k()))));
    }
    if ((paramDYAEEffectItem instanceof DYAEMaterialItem))
    {
      localObject1 = (DYAEMaterialItem)paramDYAEEffectItem;
      localObject2 = TuplesKt.to("xsj_makeup_name", ((DYAEMaterialItem)localObject1).g().t);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xsj_");
      localStringBuilder.append(((DYAEMaterialItem)localObject1).g().t);
      localStringBuilder.append("_value");
      VideoReport.reportEvent("dt_clck", paramView, MapsKt.mapOf(new Pair[] { localObject2, TuplesKt.to(localStringBuilder.toString(), Integer.valueOf(AEProviderViewModel.a.b(paramDYAEEffectItem))) }));
      AECameraDaTongHelper.a.a(paramView, "em_ae_cosmetic_item", paramDYAEEffectItem.a());
      AECameraDaTongHelper.a.a(paramView, MapsKt.mapOf(TuplesKt.to("ae_cosmetic_name", ((DYAEMaterialItem)localObject1).g().t)));
    }
    if ((paramDYAEEffectItem instanceof DYAEFilterItem))
    {
      AECameraDaTongHelper.a.a(paramView, "em_ae_filter_item", paramDYAEEffectItem.a());
      AECameraDaTongHelper.a.a(paramView, MapsKt.mapOf(TuplesKt.to("ae_filter_name", ((DYAEFilterItem)paramDYAEEffectItem).g().a)));
    }
  }
  
  private static final void f(View paramView, DYAEEffectItem paramDYAEEffectItem)
  {
    Object localObject;
    Pair localPair;
    StringBuilder localStringBuilder;
    if ((paramDYAEEffectItem instanceof DYAEBeautyItem))
    {
      localObject = (DYAEBeautyItem)paramDYAEEffectItem;
      localPair = TuplesKt.to("xsj_beauty_name", a(((DYAEBeautyItem)localObject).g().k()));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xsj_");
      localStringBuilder.append(a(((DYAEBeautyItem)localObject).g().k()));
      localStringBuilder.append("_value");
      VideoReport.reportEvent("dt_imp", paramView, MapsKt.mapOf(new Pair[] { localPair, TuplesKt.to(localStringBuilder.toString(), Integer.valueOf(AEProviderViewModel.a.b(paramDYAEEffectItem))) }));
    }
    if ((paramDYAEEffectItem instanceof DYAESecondaryBeautyItem))
    {
      localObject = (DYAESecondaryBeautyItem)paramDYAEEffectItem;
      localPair = TuplesKt.to("xsj_beauty_name", a(((DYAESecondaryBeautyItem)localObject).g().k()));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xsj_");
      localStringBuilder.append(a(((DYAESecondaryBeautyItem)localObject).g().k()));
      localStringBuilder.append("_value");
      VideoReport.reportEvent("dt_imp", paramView, MapsKt.mapOf(new Pair[] { localPair, TuplesKt.to(localStringBuilder.toString(), Integer.valueOf(AEProviderViewModel.a.b(paramDYAEEffectItem))) }));
    }
    if ((paramDYAEEffectItem instanceof DYAEMaterialItem))
    {
      localObject = (DYAEMaterialItem)paramDYAEEffectItem;
      localPair = TuplesKt.to("xsj_makeup_name", ((DYAEMaterialItem)localObject).g().t);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xsj_");
      localStringBuilder.append(((DYAEMaterialItem)localObject).g().t);
      localStringBuilder.append("_value");
      VideoReport.reportEvent("dt_imp", paramView, MapsKt.mapOf(new Pair[] { localPair, TuplesKt.to(localStringBuilder.toString(), Integer.valueOf(AEProviderViewModel.a.b(paramDYAEEffectItem))) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolderKt
 * JD-Core Version:    0.7.0.1
 */