package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.tavcut.session.TAVCutImageSession;

class AEEditorImageEditFragment$9
  implements AEEditorImagePagerAdapter.ImagePagerAdapterCallback
{
  AEEditorImageEditFragment$9(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AEEditorImageEditFragment.a(this.a).postTranslate(AEEditorImageEditFragment.a(this.a), paramFloat1, paramFloat2);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AEEditorImageEditFragment.a(this.a).postScale(AEEditorImageEditFragment.a(this.a), paramFloat2, paramFloat3, paramFloat1);
  }
  
  public void a(int paramInt)
  {
    AEEditorImageEditFragment.a(this.a).loadFromCache(paramInt);
    if (AEEditorImageEditFragment.a(this.a))
    {
      AEEditorImageEditFragment.a(this.a, false);
      this.a.j();
      if (paramInt == 0) {
        AEEditorImageEditFragment.b(this.a, paramInt);
      }
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AEEditorImageEditFragment.a(this.a).postRotation(AEEditorImageEditFragment.a(this.a), paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.9
 * JD-Core Version:    0.7.0.1
 */