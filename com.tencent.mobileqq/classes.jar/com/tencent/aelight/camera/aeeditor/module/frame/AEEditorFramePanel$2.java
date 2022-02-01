package com.tencent.aelight.camera.aeeditor.module.frame;

import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialClassifierView.CategoryItemListener;

class AEEditorFramePanel$2
  implements MaterialClassifierView.CategoryItemListener
{
  AEEditorFramePanel$2(AEEditorFramePanel paramAEEditorFramePanel) {}
  
  public void a(int paramInt, @Nullable MetaCategory paramMetaCategory) {}
  
  public void b(int paramInt, @Nullable MetaCategory paramMetaCategory)
  {
    if (paramMetaCategory != null) {
      AEReportUtils.h(paramMetaCategory.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.frame.AEEditorFramePanel.2
 * JD-Core Version:    0.7.0.1
 */