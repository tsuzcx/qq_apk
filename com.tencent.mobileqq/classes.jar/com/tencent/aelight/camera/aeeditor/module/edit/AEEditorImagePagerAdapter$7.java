package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.view.TAVCutImageView.GestureCallback;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.GestureModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class AEEditorImagePagerAdapter$7
  implements TAVCutImageView.GestureCallback
{
  AEEditorImagePagerAdapter$7(AEEditorImagePagerAdapter paramAEEditorImagePagerAdapter) {}
  
  public float a()
  {
    return ((MediaModel)AEEditorImagePagerAdapter.a(this.a).getMediaModels().get(0)).getMediaEffectModel().getGestureModel().getRotate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImagePagerAdapter.7
 * JD-Core Version:    0.7.0.1
 */