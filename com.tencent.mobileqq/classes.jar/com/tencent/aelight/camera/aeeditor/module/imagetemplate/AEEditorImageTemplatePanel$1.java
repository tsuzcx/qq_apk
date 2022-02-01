package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialClassifierView.CategoryItemListener;

class AEEditorImageTemplatePanel$1
  implements MaterialClassifierView.CategoryItemListener
{
  AEEditorImageTemplatePanel$1(AEEditorImageTemplatePanel paramAEEditorImageTemplatePanel) {}
  
  public void a(int paramInt, @Nullable MetaCategory paramMetaCategory) {}
  
  public void b(int paramInt, @Nullable MetaCategory paramMetaCategory)
  {
    if (paramMetaCategory != null) {
      AEReportUtils.e(paramMetaCategory.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.AEEditorImageTemplatePanel.1
 * JD-Core Version:    0.7.0.1
 */