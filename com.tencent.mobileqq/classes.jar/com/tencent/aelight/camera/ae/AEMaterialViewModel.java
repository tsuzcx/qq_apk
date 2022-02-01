package com.tencent.aelight.camera.ae;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/AEMaterialViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "materialState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/aelight/camera/ae/MaterialState;", "getMaterialState", "()Landroidx/lifecycle/MutableLiveData;", "clearMaterial", "", "updateCurrentMaterial", "type", "", "material", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEMaterialViewModel
  extends ViewModel
{
  @NotNull
  private final MutableLiveData<MaterialState> a = new MutableLiveData(null);
  
  @NotNull
  public final MutableLiveData<MaterialState> a()
  {
    return this.a;
  }
  
  public final void a(int paramInt, @Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.a.postValue(new MaterialState(paramAEMaterialMetaData, paramInt));
  }
  
  public final void b()
  {
    this.a.postValue(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEMaterialViewModel
 * JD-Core Version:    0.7.0.1
 */