package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.qcircle.tavcut.aekit.AEKitModel;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.qcircle.tavcut.view.ext.OnLongPressListener;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class AEEditorImagePagerAdapter$6
  implements OnLongPressListener
{
  AEEditorImagePagerAdapter$6(AEEditorImagePagerAdapter paramAEEditorImagePagerAdapter, int paramInt) {}
  
  public void onLongPress()
  {
    AEEditorImagePagerAdapter.b(this.b).toggleAEKit(this.a, false);
  }
  
  public void onLongPressRelease()
  {
    AEKitModel localAEKitModel = ((MediaModel)AEEditorImagePagerAdapter.b(this.b).getMediaModels().get(this.a)).getMediaEffectModel().getAeKitModel();
    if ((localAEKitModel != null) && (localAEKitModel.isDisable())) {
      AEEditorImagePagerAdapter.b(this.b).toggleAEKit(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImagePagerAdapter.6
 * JD-Core Version:    0.7.0.1
 */