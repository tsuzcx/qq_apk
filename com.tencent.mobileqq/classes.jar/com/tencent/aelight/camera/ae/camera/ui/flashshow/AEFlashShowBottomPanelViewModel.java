package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowBottomPanelViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "beautifyPanelShowLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getBeautifyPanelShowLiveData", "()Landroidx/lifecycle/MutableLiveData;", "bottomPanelShowLiveData", "Landroidx/lifecycle/MediatorLiveData;", "getBottomPanelShowLiveData", "()Landroidx/lifecycle/MediatorLiveData;", "cutDownShowLiveData", "getCutDownShowLiveData", "filterPanelShowLiveData", "getFilterPanelShowLiveData", "isBottomPanelShow", "()Z", "materialPanelShowLiveData", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/MaterialPanelOpenState;", "getMaterialPanelShowLiveData", "musicPanelShowLiveData", "getMusicPanelShowLiveData", "closeBottomPanel", "", "onCleared", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowBottomPanelViewModel
  extends ViewModel
{
  public static final AEFlashShowBottomPanelViewModel.Companion a = new AEFlashShowBottomPanelViewModel.Companion(null);
  @NotNull
  private static final MutableLiveData<AEMaterialMetaData> h = new MutableLiveData(null);
  @NotNull
  private static final MutableLiveData<AEMaterialMetaData> i = new MutableLiveData();
  @NotNull
  private final MutableLiveData<MaterialPanelOpenState> b = new MutableLiveData();
  @NotNull
  private final MutableLiveData<Boolean> c = new MutableLiveData();
  @NotNull
  private final MutableLiveData<Boolean> d = new MutableLiveData();
  @NotNull
  private final MutableLiveData<Boolean> e = new MutableLiveData();
  @NotNull
  private final MutableLiveData<Boolean> f = new MutableLiveData();
  @NotNull
  private final MediatorLiveData<Boolean> g;
  
  public AEFlashShowBottomPanelViewModel()
  {
    MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    localMediatorLiveData.addSource((LiveData)this.b, (Observer)new AEFlashShowBottomPanelViewModel..special..inlined.apply.lambda.1(localMediatorLiveData, this));
    localMediatorLiveData.addSource((LiveData)this.c, (Observer)new AEFlashShowBottomPanelViewModel..special..inlined.apply.lambda.2(localMediatorLiveData, this));
    localMediatorLiveData.addSource((LiveData)this.d, (Observer)new AEFlashShowBottomPanelViewModel..special..inlined.apply.lambda.3(localMediatorLiveData, this));
    localMediatorLiveData.addSource((LiveData)this.e, (Observer)new AEFlashShowBottomPanelViewModel..special..inlined.apply.lambda.4(localMediatorLiveData, this));
    this.g = localMediatorLiveData;
  }
  
  @NotNull
  public static final MutableLiveData<AEMaterialMetaData> k()
  {
    AEFlashShowBottomPanelViewModel.Companion localCompanion = a;
    return h;
  }
  
  @NotNull
  public static final MutableLiveData<AEMaterialMetaData> l()
  {
    AEFlashShowBottomPanelViewModel.Companion localCompanion = a;
    return i;
  }
  
  @NotNull
  public final MutableLiveData<MaterialPanelOpenState> a()
  {
    return this.b;
  }
  
  @NotNull
  public final MutableLiveData<Boolean> b()
  {
    return this.c;
  }
  
  @NotNull
  public final MutableLiveData<Boolean> c()
  {
    return this.d;
  }
  
  @NotNull
  public final MutableLiveData<Boolean> d()
  {
    return this.e;
  }
  
  @NotNull
  public final MutableLiveData<Boolean> e()
  {
    return this.f;
  }
  
  @NotNull
  public final MediatorLiveData<Boolean> f()
  {
    return this.g;
  }
  
  public final boolean g()
  {
    Object localObject2 = (MaterialPanelOpenState)this.b.getValue();
    boolean bool1 = false;
    Object localObject1 = Boolean.valueOf(false);
    if (localObject2 != null) {
      bool1 = ((MaterialPanelOpenState)localObject2).a();
    }
    localObject2 = (Boolean)this.c.getValue();
    if (localObject2 == null) {
      localObject2 = localObject1;
    }
    boolean bool2 = ((Boolean)localObject2).booleanValue();
    localObject2 = (Boolean)this.d.getValue();
    if (localObject2 == null) {
      localObject2 = localObject1;
    }
    boolean bool3 = ((Boolean)localObject2).booleanValue();
    localObject2 = (Boolean)this.e.getValue();
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    return bool2 | bool1 | bool3 | ((Boolean)localObject1).booleanValue();
  }
  
  public final void h()
  {
    MaterialPanelOpenState localMaterialPanelOpenState = (MaterialPanelOpenState)this.b.getValue();
    Boolean localBoolean1 = Boolean.valueOf(false);
    Boolean localBoolean2 = Boolean.valueOf(true);
    if ((localMaterialPanelOpenState != null) && (localMaterialPanelOpenState.a() == true)) {
      this.b.postValue(new MaterialPanelOpenState(false, null, 2, null));
    }
    if (Intrinsics.areEqual((Boolean)this.c.getValue(), localBoolean2)) {
      this.c.postValue(localBoolean1);
    }
    if (Intrinsics.areEqual((Boolean)this.d.getValue(), localBoolean2)) {
      this.d.postValue(localBoolean1);
    }
    if (Intrinsics.areEqual((Boolean)this.e.getValue(), localBoolean2)) {
      this.e.postValue(localBoolean1);
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    h.setValue(null);
    i.setValue(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPanelViewModel
 * JD-Core Version:    0.7.0.1
 */