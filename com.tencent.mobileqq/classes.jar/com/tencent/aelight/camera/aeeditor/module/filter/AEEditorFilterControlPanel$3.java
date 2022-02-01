package com.tencent.aelight.camera.aeeditor.module.filter;

import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.ItemListener;

class AEEditorFilterControlPanel$3
  implements MaterialContentAdapter.ItemListener
{
  AEEditorFilterControlPanel$3(AEEditorFilterControlPanel paramAEEditorFilterControlPanel) {}
  
  public void a(int paramInt, @Nullable MetaMaterial paramMetaMaterial) {}
  
  public void b(int paramInt, @Nullable MetaMaterial paramMetaMaterial)
  {
    if ((AEEditorFilterControlPanel.c(this.a).c() == paramInt) && (AEEditorFilterControlPanel.b(this.a) != null)) {
      AEEditorFilterControlPanel.b(this.a).a(paramInt, paramMetaMaterial);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel.3
 * JD-Core Version:    0.7.0.1
 */