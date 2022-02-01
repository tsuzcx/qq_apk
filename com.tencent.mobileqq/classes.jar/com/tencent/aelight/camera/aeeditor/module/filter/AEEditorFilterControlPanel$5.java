package com.tencent.aelight.camera.aeeditor.module.filter;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

class AEEditorFilterControlPanel$5
  implements Runnable
{
  AEEditorFilterControlPanel$5(AEEditorFilterControlPanel paramAEEditorFilterControlPanel, MetaMaterial paramMetaMaterial, ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback) {}
  
  public void run()
  {
    File localFile = new File(AEEditorResourceManager.a().d(this.a));
    if (localFile.exists())
    {
      if (AEEditorFilterControlPanel.a(this.this$0, this.a, FileUtils.readFileContent(localFile)))
      {
        AEEditorFilterControlPanel.a(this.this$0, this.a, this.b);
        return;
      }
      this.b.a(ApplyMaterialTask.Status.FAILED, -1);
      return;
    }
    this.b.a(ApplyMaterialTask.Status.FAILED, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel.5
 * JD-Core Version:    0.7.0.1
 */