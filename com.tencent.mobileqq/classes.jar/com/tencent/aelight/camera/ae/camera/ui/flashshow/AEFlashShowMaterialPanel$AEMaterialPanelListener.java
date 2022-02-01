package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialPanel$AEMaterialPanelListener;", "", "onMaterialSelected", "", "material", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "onNoneMaterialSelected", "onPanelClosed", "onPanelOpened", "onTabSelected", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface AEFlashShowMaterialPanel$AEMaterialPanelListener
{
  public abstract void a();
  
  public abstract void a(@Nullable AEMaterialMetaData paramAEMaterialMetaData);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialPanel.AEMaterialPanelListener
 * JD-Core Version:    0.7.0.1
 */