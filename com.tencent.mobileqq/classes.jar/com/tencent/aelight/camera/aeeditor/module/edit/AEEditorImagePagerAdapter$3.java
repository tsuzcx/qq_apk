package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.qcircle.tavcut.view.ext.OnRotationListener;

class AEEditorImagePagerAdapter$3
  implements OnRotationListener
{
  AEEditorImagePagerAdapter$3(AEEditorImagePagerAdapter paramAEEditorImagePagerAdapter) {}
  
  public void onRotation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (AEEditorImagePagerAdapter.a(this.a) != null) {
      AEEditorImagePagerAdapter.a(this.a).b(paramFloat1, paramFloat2, paramFloat3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImagePagerAdapter.3
 * JD-Core Version:    0.7.0.1
 */