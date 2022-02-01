package com.tencent.aelight.camera.aeeditor.module.text;

import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.List;

class AEEditorTextControlPanel$5
  implements Observer<List<MetaMaterial>>
{
  AEEditorTextControlPanel$5(AEEditorTextControlPanel paramAEEditorTextControlPanel) {}
  
  public void a(List<MetaMaterial> paramList)
  {
    if (paramList == null) {
      return;
    }
    AEEditorTextControlPanel.a(this.a).a(paramList);
    AEEditorTextControlPanel.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextControlPanel.5
 * JD-Core Version:    0.7.0.1
 */