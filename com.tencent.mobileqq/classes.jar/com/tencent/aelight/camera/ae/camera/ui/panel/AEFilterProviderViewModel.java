package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEFilterProviderViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_selectedFilter", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem;", "selectedFilter", "Landroidx/lifecycle/LiveData;", "getSelectedFilter", "()Landroidx/lifecycle/LiveData;", "getActualLutFromSeekProgress", "", "filter", "seekBarValue", "", "refreshSelectEffect", "", "updateSelectedFilter", "appliedFilter", "Companion", "LutMappingData", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFilterProviderViewModel
  extends ViewModel
{
  public static final AEFilterProviderViewModel.Companion a = new AEFilterProviderViewModel.Companion(null);
  private static final Map<String, AEFilterProviderViewModel.LutMappingData> d = MapsKt.mapOf(new Pair[] { TuplesKt.to("蓝岛", new AEFilterProviderViewModel.LutMappingData(0.01125F, 0.005F, 80)), TuplesKt.to("奶茶", new AEFilterProviderViewModel.LutMappingData(0.01125F, 0.005F, 80)), TuplesKt.to("焦糖", new AEFilterProviderViewModel.LutMappingData(0.010625F, 0.0075F, 80)), TuplesKt.to("蜜桃粉", new AEFilterProviderViewModel.LutMappingData(0.010625F, 0.0075F, 80)), TuplesKt.to("风景/小樽", new AEFilterProviderViewModel.LutMappingData(0.00875F, 0.011875F, 80)), TuplesKt.to("新锐/拍立得", new AEFilterProviderViewModel.LutMappingData(0.01125F, 0.005F, 80)), TuplesKt.to("新锐/菲林", new AEFilterProviderViewModel.LutMappingData(0.01125F, 0.005F, 80)) });
  private final MediatorLiveData<QIMFilterCategoryItem> b = new MediatorLiveData();
  @NotNull
  private final LiveData<QIMFilterCategoryItem> c;
  
  public AEFilterProviderViewModel()
  {
    MediatorLiveData localMediatorLiveData = this.b;
    if (localMediatorLiveData != null)
    {
      this.c = ((LiveData)localMediatorLiveData);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem?>");
  }
  
  @NotNull
  public final LiveData<QIMFilterCategoryItem> a()
  {
    return this.c;
  }
  
  public final void a(@Nullable QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    this.b.postValue(paramQIMFilterCategoryItem);
  }
  
  public final void b()
  {
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.b.getValue();
    if (localQIMFilterCategoryItem != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localQIMFilterCategoryItem, "_selectedFilter.value ?: return");
      this.b.postValue(localQIMFilterCategoryItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEFilterProviderViewModel
 * JD-Core Version:    0.7.0.1
 */