package com.tencent.aelight.camera.aeeditor.module.autotemplate;

import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import java.util.List;

class AEEditorAutoTemplatePanel$1
  implements Observer<List<MetaCategory>>
{
  AEEditorAutoTemplatePanel$1(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  public void a(List<MetaCategory> paramList)
  {
    AEEditorAutoTemplatePanel.a(this.a).clear();
    AEEditorAutoTemplatePanel.a(this.a).addAll(paramList);
    AEEditorAutoTemplatePanel.b(this.a);
    this.a.a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.1
 * JD-Core Version:    0.7.0.1
 */