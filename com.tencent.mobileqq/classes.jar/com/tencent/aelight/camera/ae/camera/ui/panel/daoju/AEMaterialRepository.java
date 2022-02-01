package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AEMaterialRepository;", "", "downloadMaterial", "", "material", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "listener", "Lcom/tencent/aelight/camera/ae/download/AEMaterialDownloader$MaterialDownloadListener;", "getPendingSelectMaterialId", "", "getSelectedMaterialId", "selectMaterial", "setPendingSelectMaterial", "id", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface AEMaterialRepository
{
  @Nullable
  public abstract String a();
  
  public abstract void a(@NotNull AEMaterialMetaData paramAEMaterialMetaData);
  
  public abstract void a(@NotNull AEMaterialMetaData paramAEMaterialMetaData, @NotNull AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener);
  
  public abstract void a(@Nullable String paramString);
  
  @Nullable
  public abstract String b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AEMaterialRepository
 * JD-Core Version:    0.7.0.1
 */