package com.tencent.aelight.camera.aeeditor.module.autotemplate;

import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialClassifierView.CategoryItemListener;

class AEEditorAutoTemplatePanel$3
  implements MaterialClassifierView.CategoryItemListener
{
  AEEditorAutoTemplatePanel$3(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  public void a(int paramInt, @Nullable MetaCategory paramMetaCategory)
  {
    if (paramMetaCategory != null) {
      AEReportUtils.a(paramMetaCategory.id);
    }
  }
  
  public void b(int paramInt, @Nullable MetaCategory paramMetaCategory)
  {
    if (paramMetaCategory != null) {
      AEReportUtils.b(paramMetaCategory.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.3
 * JD-Core Version:    0.7.0.1
 */