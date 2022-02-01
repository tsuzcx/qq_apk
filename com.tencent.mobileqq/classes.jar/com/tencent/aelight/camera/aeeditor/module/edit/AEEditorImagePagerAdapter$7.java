package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.qcircle.tavcut.view.TAVCutImageView.GestureCallback;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.GestureModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

class AEEditorImagePagerAdapter$7
  implements TAVCutImageView.GestureCallback
{
  AEEditorImagePagerAdapter$7(AEEditorImagePagerAdapter paramAEEditorImagePagerAdapter) {}
  
  @Nullable
  public ArrayList<float[]> getPoints()
  {
    return null;
  }
  
  public float getRotate()
  {
    return ((MediaModel)AEEditorImagePagerAdapter.b(this.a).getMediaModels().get(0)).getMediaEffectModel().getGestureModel().getRotate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImagePagerAdapter.7
 * JD-Core Version:    0.7.0.1
 */