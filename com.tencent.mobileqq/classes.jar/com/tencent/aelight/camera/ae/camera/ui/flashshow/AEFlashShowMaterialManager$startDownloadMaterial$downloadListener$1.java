package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.log.AEQLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialManager$startDownloadMaterial$downloadListener$1", "Lcom/tencent/aelight/camera/ae/download/AEMaterialDownloader$MaterialDownloadListener;", "onDownloadFinish", "", "info", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "isSuccess", "", "resCode", "", "onProgressUpdate", "progress", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMaterialManager$startDownloadMaterial$downloadListener$1
  implements AEMaterialDownloader.MaterialDownloadListener
{
  AEFlashShowMaterialManager$startDownloadMaterial$downloadListener$1(AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener) {}
  
  public void onDownloadFinish(@NotNull AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAEMaterialMetaData, "info");
    AEMaterialMetaData localAEMaterialMetaData = AEFlashShowMaterialManager.a(this.a, paramAEMaterialMetaData);
    if (localAEMaterialMetaData != null) {
      localAEMaterialMetaData.A = this.a.a(paramAEMaterialMetaData);
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      ((AEMaterialDownloader.MaterialDownloadListener)localObject).onDownloadFinish(paramAEMaterialMetaData, paramBoolean, paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("【END】onDownloadFinish :");
      if (localAEMaterialMetaData != null) {
        paramAEMaterialMetaData = localAEMaterialMetaData.m;
      } else {
        paramAEMaterialMetaData = null;
      }
      ((StringBuilder)localObject).append(paramAEMaterialMetaData);
      AEQLog.b("AEFlashShowMaterialManager", ((StringBuilder)localObject).toString());
    }
  }
  
  public void onProgressUpdate(@NotNull AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAEMaterialMetaData, "info");
    AEMaterialDownloader.MaterialDownloadListener localMaterialDownloadListener = this.b;
    if (localMaterialDownloadListener != null) {
      localMaterialDownloadListener.onProgressUpdate(paramAEMaterialMetaData, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager.startDownloadMaterial.downloadListener.1
 * JD-Core Version:    0.7.0.1
 */