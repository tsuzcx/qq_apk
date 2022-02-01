package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.view.ext.OnLongPressListener;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class AEEditorImagePagerAdapter$6
  implements OnLongPressListener
{
  AEEditorImagePagerAdapter$6(AEEditorImagePagerAdapter paramAEEditorImagePagerAdapter, int paramInt) {}
  
  public void a()
  {
    AEEditorImagePagerAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImagePagerAdapter).toggleAEKit(this.jdField_a_of_type_Int, false);
  }
  
  public void b()
  {
    AEKitModel localAEKitModel = ((MediaModel)AEEditorImagePagerAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImagePagerAdapter).getMediaModels().get(this.jdField_a_of_type_Int)).getMediaEffectModel().getAeKitModel();
    if ((localAEKitModel != null) && (localAEKitModel.isDisable())) {
      AEEditorImagePagerAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImagePagerAdapter).toggleAEKit(this.jdField_a_of_type_Int, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImagePagerAdapter.6
 * JD-Core Version:    0.7.0.1
 */