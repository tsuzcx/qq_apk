package com.tencent.aelight.camera.aeeditor.module.filter;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;

class AEEditorFilterControlPanel$7
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AEEditorFilterControlPanel$7(AEEditorFilterControlPanel paramAEEditorFilterControlPanel, MetaMaterial paramMetaMaterial, ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback) {}
  
  public void a(int paramInt)
  {
    this.b.a(ApplyMaterialTask.Status.ONGOING, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FilterMetaMaterialKt.a(this.a, true);
      this.b.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    this.b.a(ApplyMaterialTask.Status.FAILED, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel.7
 * JD-Core Version:    0.7.0.1
 */