package com.tencent.aelight.camera.aeeditor.module.edit;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.aelight.camera.aeeditor.module.MaterialViewModel;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.List;

class AEEditorCommonEditFragment$11
  implements Observer<List<MetaCategory>>
{
  AEEditorCommonEditFragment$11(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void a(@Nullable List<MetaCategory> paramList)
  {
    AEQLog.b(AEEditorCommonEditFragment.c(), "mFiltersObserver-onChanged");
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setFiltersMaterials(paramList, AEEditorCommonEditFragment.jdField_a_of_type_Int, this.a.b());
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMaterialViewModel.a(paramList);
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMaterialViewModel.a();
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMaterialViewModel.a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment.11
 * JD-Core Version:    0.7.0.1
 */