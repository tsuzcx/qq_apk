package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.common.app.AppInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AEFlashShowMaterialManager$startDownloadDataAsync$1
  implements Runnable
{
  AEFlashShowMaterialManager$startDownloadDataAsync$1(AEFlashShowMaterialManager paramAEFlashShowMaterialManager, AppInterface paramAppInterface, String paramString, AEMaterialMetaData paramAEMaterialMetaData, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener) {}
  
  public final void run()
  {
    AEFlashShowMaterialManager localAEFlashShowMaterialManager = this.this$0;
    AppInterface localAppInterface = this.a;
    if (localAppInterface == null) {
      Intrinsics.throwNpe();
    }
    String str = this.b;
    if (str == null) {
      Intrinsics.throwNpe();
    }
    AEFlashShowMaterialManager.a(localAEFlashShowMaterialManager, localAppInterface, str, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager.startDownloadDataAsync.1
 * JD-Core Version:    0.7.0.1
 */