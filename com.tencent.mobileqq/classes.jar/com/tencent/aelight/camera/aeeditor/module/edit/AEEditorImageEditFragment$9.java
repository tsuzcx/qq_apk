package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.qcircle.tavcut.session.TAVCutImageSession;

class AEEditorImageEditFragment$9
  implements AEEditorImagePagerAdapter.ImagePagerAdapterCallback
{
  AEEditorImageEditFragment$9(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AEEditorImageEditFragment.f(this.a).postTranslate(AEEditorImageEditFragment.e(this.a), paramFloat1, paramFloat2);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AEEditorImageEditFragment.f(this.a).postScale(AEEditorImageEditFragment.e(this.a), paramFloat2, paramFloat3, paramFloat1);
  }
  
  public void a(int paramInt)
  {
    AEEditorImageEditFragment.f(this.a).loadFromCache(paramInt);
    if (AEEditorImageEditFragment.k(this.a))
    {
      AEEditorImageEditFragment.a(this.a, false);
      this.a.t();
      if (paramInt == 0) {
        AEEditorImageEditFragment.b(this.a, paramInt);
      }
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AEEditorImageEditFragment.f(this.a).postRotation(AEEditorImageEditFragment.e(this.a), paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.9
 * JD-Core Version:    0.7.0.1
 */