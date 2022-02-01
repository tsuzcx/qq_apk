package com.tencent.aelight.camera.aeeditor.module.filter;

import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialClassifierView.CategoryItemListener;

class AEEditorFilterControlPanel$4
  implements MaterialClassifierView.CategoryItemListener
{
  AEEditorFilterControlPanel$4(AEEditorFilterControlPanel paramAEEditorFilterControlPanel) {}
  
  public void a(int paramInt, @Nullable MetaCategory paramMetaCategory) {}
  
  public void b(int paramInt, @Nullable MetaCategory paramMetaCategory)
  {
    if (paramMetaCategory != null) {
      AEReportUtils.b(AEEditorFilterControlPanel.d(this.a), paramMetaCategory.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel.4
 * JD-Core Version:    0.7.0.1
 */