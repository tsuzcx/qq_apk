package com.tencent.aelight.camera.aeeditor.module.edit;

import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.aelight.camera.aeeditor.module.MaterialViewModel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel;
import java.util.List;

class AEEditorCommonEditFragment$12
  implements Observer<List<MetaCategory>>
{
  AEEditorCommonEditFragment$12(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void a(List<MetaCategory> paramList)
  {
    this.a.h.setStickerCategories(paramList);
    this.a.u.b(paramList);
    this.a.u.c();
    this.a.u.a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment.12
 * JD-Core Version:    0.7.0.1
 */