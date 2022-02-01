package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialManager$Companion;", "", "()V", "AE_CAMERA_UPDATE_PENDING_JSON", "", "AE_FLASH_SHOW_UPDATE_PENDING_JSON", "COSMETIC_CATEGORY_ID", "", "FILTER_CATEGORY_ID", "RECENT_TEMPLATE_CAMERA_LIST", "RECENT_TEMPLATE_FLASH_SHOW_LIST", "SICKER_MATERIAL_CATEGORY_ID", "TAG", "sessionSelectedMaterial", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "getSelectedMaterial", "getUpdateConfigFilePath", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMaterialManager$Companion
{
  @JvmStatic
  @NotNull
  public final String a()
  {
    Object localObject = new File(AEPath.CAMERA.FILES.j);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new File(((File)localObject).getPath(), "camera_flash_show_update_template.json").getPath();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "File(dir.path, AE_FLASH_…UPDATE_PENDING_JSON).path");
    return localObject;
  }
  
  @JvmStatic
  @Nullable
  public final AEMaterialMetaData b()
  {
    return AEFlashShowMaterialManager.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager.Companion
 * JD-Core Version:    0.7.0.1
 */