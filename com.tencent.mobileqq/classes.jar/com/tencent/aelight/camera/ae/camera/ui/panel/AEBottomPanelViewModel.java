package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBottomPanelViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "daoJuPanelShowLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DaoJuPanelOpenState;", "getDaoJuPanelShowLiveData", "()Landroidx/lifecycle/MutableLiveData;", "hasBottomPanelShow", "", "getHasBottomPanelShow", "()Z", "isDaoJuPanelShow", "closeBottomPanel", "", "closeDaoJuPanel", "openDaoJuPanel", "locateMaterial", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEBottomPanelViewModel
  extends ViewModel
{
  @NotNull
  private final MutableLiveData<DaoJuPanelOpenState> a = new MutableLiveData();
  
  private final void e()
  {
    DaoJuPanelOpenState localDaoJuPanelOpenState = (DaoJuPanelOpenState)this.a.getValue();
    if ((localDaoJuPanelOpenState != null) && (localDaoJuPanelOpenState.a() == true)) {
      this.a.postValue(new DaoJuPanelOpenState(false, null, 2, null));
    }
  }
  
  @NotNull
  public final MutableLiveData<DaoJuPanelOpenState> a()
  {
    return this.a;
  }
  
  public final void a(@Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.a.postValue(new DaoJuPanelOpenState(true, paramAEMaterialMetaData));
  }
  
  public final boolean b()
  {
    DaoJuPanelOpenState localDaoJuPanelOpenState = (DaoJuPanelOpenState)this.a.getValue();
    if (localDaoJuPanelOpenState != null) {
      return localDaoJuPanelOpenState.a();
    }
    return false;
  }
  
  public final boolean c()
  {
    return b();
  }
  
  public final void d()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelViewModel
 * JD-Core Version:    0.7.0.1
 */