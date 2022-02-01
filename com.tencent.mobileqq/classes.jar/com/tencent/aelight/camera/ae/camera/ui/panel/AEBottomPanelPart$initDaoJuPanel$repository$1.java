package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.AEMaterialViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AEMaterialRepository;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/camera/ui/panel/AEBottomPanelPart$initDaoJuPanel$repository$1", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AEMaterialRepository;", "downloadMaterial", "", "material", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "listener", "Lcom/tencent/aelight/camera/ae/download/AEMaterialDownloader$MaterialDownloadListener;", "getPendingSelectMaterialId", "", "getSelectedMaterialId", "selectMaterial", "setPendingSelectMaterial", "id", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEBottomPanelPart$initDaoJuPanel$repository$1
  implements AEMaterialRepository
{
  @Nullable
  public String a()
  {
    return AEBottomPanelPart.a(this.a).b();
  }
  
  public void a(@NotNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    Intrinsics.checkParameterIsNotNull(paramAEMaterialMetaData, "material");
    AEBottomPanelPart.a(this.a).a((String)null);
    AEBottomPanelPart.a(this.a).a(paramAEMaterialMetaData, true);
    AEBottomPanelPart.b(this.a).a(4, paramAEMaterialMetaData);
  }
  
  public void a(@NotNull AEMaterialMetaData paramAEMaterialMetaData, @NotNull AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    Intrinsics.checkParameterIsNotNull(paramAEMaterialMetaData, "material");
    Intrinsics.checkParameterIsNotNull(paramMaterialDownloadListener, "listener");
    AEBottomPanelPart.a(this.a).a(AEBottomPanelPart.a(this.a).getApp(), paramAEMaterialMetaData, paramMaterialDownloadListener);
  }
  
  public void a(@Nullable String paramString)
  {
    AEBottomPanelPart.a(this.a).a(paramString);
  }
  
  @Nullable
  public String b()
  {
    AEMaterialMetaData localAEMaterialMetaData = AEMaterialManager.n();
    if (localAEMaterialMetaData != null) {
      return localAEMaterialMetaData.m;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelPart.initDaoJuPanel.repository.1
 * JD-Core Version:    0.7.0.1
 */