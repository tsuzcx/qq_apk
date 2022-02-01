package com.tencent.aelight.camera.aeeditor.module.text;

import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.AdapterUtil;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialCategoryAdapter.ItemListener;

class AEEditorStickerControlPanel$1
  implements MaterialCategoryAdapter.ItemListener
{
  AEEditorStickerControlPanel$1(AEEditorStickerControlPanel paramAEEditorStickerControlPanel) {}
  
  public void a(int paramInt, @Nullable MetaCategory paramMetaCategory) {}
  
  public void b(int paramInt, @Nullable MetaCategory paramMetaCategory)
  {
    if (paramMetaCategory != null) {
      AEReportUtils.e(AEEditorStickerControlPanel.a(this.a), paramMetaCategory.id);
    }
    AEEditorStickerControlPanel.a(this.a, true);
    paramInt = MetaMaterialKt.b(AEEditorStickerControlPanel.b(this.a), AEEditorStickerControlPanel.c(this.a), paramInt);
    AdapterUtil.b(AEEditorStickerControlPanel.d(this.a), AEEditorStickerControlPanel.e(this.a).c(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel.1
 * JD-Core Version:    0.7.0.1
 */