package com.tencent.aelight.camera.aeeditor.module.edit;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.aelight.camera.aeeditor.module.MaterialViewModel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import java.util.List;

class AEEditorCommonEditFragment$13
  implements Observer<List<MetaCategory>>
{
  AEEditorCommonEditFragment$13(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void a(@Nullable List<MetaCategory> paramList)
  {
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(paramList);
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMaterialViewModel.c(paramList);
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMaterialViewModel.a();
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMaterialViewModel.a(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment.13
 * JD-Core Version:    0.7.0.1
 */