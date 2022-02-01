package com.tencent.aelight.camera.aeeditor.module.text;

import androidx.lifecycle.Observer;

class AEEditorTextControlPanel$6
  implements Observer<Integer>
{
  AEEditorTextControlPanel$6(AEEditorTextControlPanel paramAEEditorTextControlPanel) {}
  
  public void a(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      AEEditorTextControlPanel.a(this.a, false);
      return;
    }
    AEEditorTextControlPanel.a(this.a, true);
    this.a.a(paramInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextControlPanel.6
 * JD-Core Version:    0.7.0.1
 */