package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_cosmeticsLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "_selectedMaterial", "captureMode", "Lcom/tencent/aelight/camera/ae/mode/AECaptureMode;", "cosmeticsLiveData", "getCosmeticsLiveData", "()Landroidx/lifecycle/MutableLiveData;", "material", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "selectedMaterial", "Landroidx/lifecycle/LiveData;", "getSelectedMaterial", "()Landroidx/lifecycle/LiveData;", "checkEnable", "", "refreshSelectEffect", "", "selectMaterial", "dummyData", "setCosmeticList", "cosmeticList", "updateCaptureMode", "mode", "updateCosmeticListEnable", "updateVideoMaterial", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AECosmeticsViewModel
  extends ViewModel
{
  private AEMaterialMetaData a;
  private AECaptureMode b;
  private final MutableLiveData<List<DYAEEffectItem>> c = new MutableLiveData();
  private final MutableLiveData<DYAEEffectItem> d = new MutableLiveData();
  
  private final void d()
  {
    boolean bool = e();
    Object localObject = (List)this.c.getValue();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "_cosmeticsLiveData.value ?: return");
      Iterator localIterator = ((Iterable)localObject).iterator();
      while (localIterator.hasNext()) {
        ((DYAEEffectItem)localIterator.next()).a(bool);
      }
      this.c.postValue(localObject);
      localObject = (DYAEEffectItem)this.d.getValue();
      this.d.postValue(localObject);
    }
  }
  
  private final boolean e()
  {
    if (this.b != AECaptureMode.GIF)
    {
      AEMaterialMetaData localAEMaterialMetaData = this.a;
      if ((localAEMaterialMetaData == null) || (AEMaterialMetaData.a(localAEMaterialMetaData))) {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public final MutableLiveData<List<DYAEEffectItem>> a()
  {
    return this.c;
  }
  
  public final void a(@NotNull DYAEEffectItem paramDYAEEffectItem)
  {
    Intrinsics.checkParameterIsNotNull(paramDYAEEffectItem, "dummyData");
    this.d.postValue(paramDYAEEffectItem);
  }
  
  public final void a(@Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.a = paramAEMaterialMetaData;
    d();
  }
  
  public final void a(@Nullable AECaptureMode paramAECaptureMode)
  {
    this.b = paramAECaptureMode;
    d();
  }
  
  public final void a(@NotNull List<? extends DYAEEffectItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "cosmeticList");
    boolean bool = e();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext()) {
      ((DYAEEffectItem)localIterator.next()).a(bool);
    }
    this.c.postValue(paramList);
  }
  
  @NotNull
  public final LiveData<DYAEEffectItem> b()
  {
    return (LiveData)this.d;
  }
  
  public final void c()
  {
    DYAEEffectItem localDYAEEffectItem = (DYAEEffectItem)this.d.getValue();
    if (localDYAEEffectItem != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localDYAEEffectItem, "_selectedMaterial.value ?: return");
      this.d.postValue(localDYAEEffectItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsViewModel
 * JD-Core Version:    0.7.0.1
 */