package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.ResDownLoadListener;
import com.tencent.mobileqq.wink.editor.filter.FilterMetaMaterialKt;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.Status;

class AEFlashShowFilterPanelViewHolder$6
  implements WinkEditorResourceDownloader.ResDownLoadListener
{
  AEFlashShowFilterPanelViewHolder$6(AEFlashShowFilterPanelViewHolder paramAEFlashShowFilterPanelViewHolder, MetaMaterial paramMetaMaterial, ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback) {}
  
  public void a(int paramInt)
  {
    this.b.onStatusChanged(ApplyMaterialTask.Status.ONGOING, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FilterMetaMaterialKt.a(this.a, true);
      this.b.onStatusChanged(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    this.b.onStatusChanged(ApplyMaterialTask.Status.FAILED, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowFilterPanelViewHolder.6
 * JD-Core Version:    0.7.0.1
 */