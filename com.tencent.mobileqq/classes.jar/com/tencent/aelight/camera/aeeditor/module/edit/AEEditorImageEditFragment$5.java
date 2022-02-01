package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipPanel.CropChangeCallback;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import java.util.List;

class AEEditorImageEditFragment$5
  implements AEEditorClipPanel.CropChangeCallback
{
  AEEditorImageEditFragment$5(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a()
  {
    AEEditorImageEditFragment localAEEditorImageEditFragment = this.a;
    if (localAEEditorImageEditFragment.b(AEEditorImageEditFragment.e(localAEEditorImageEditFragment)))
    {
      AEEditorImageEditFragment.f(this.a).updateTemplateCrop(AEEditorImageEditFragment.e(this.a), ((AEEditorImageInfo)AEEditorImageEditFragment.d(this.a).get(AEEditorImageEditFragment.e(this.a))).d);
      AEEditorImageEditFragment.f(this.a).updateAndRenderTemplate(AEEditorImageEditFragment.e(this.a), true, new AEEditorImageEditFragment.5.1(this));
      return;
    }
    AEEditorImageEditFragment.f(this.a).setCrop(AEEditorImageEditFragment.e(this.a), ((AEEditorImageInfo)AEEditorImageEditFragment.d(this.a).get(AEEditorImageEditFragment.e(this.a))).d);
    localAEEditorImageEditFragment = this.a;
    AEEditorImageEditFragment.a(localAEEditorImageEditFragment, AEEditorImageEditFragment.e(localAEEditorImageEditFragment));
    this.a.N();
  }
  
  public void a(int paramInt, List<CropConfig> paramList)
  {
    int i = 0;
    while (i < AEEditorImageEditFragment.d(this.a).size())
    {
      if ((i != AEEditorImageEditFragment.e(this.a)) && (!this.a.b(i)))
      {
        ((AEEditorImageInfo)AEEditorImageEditFragment.d(this.a).get(i)).a(paramInt);
        ((AEEditorImageInfo)AEEditorImageEditFragment.d(this.a).get(i)).a((CropConfig)paramList.get(i));
        AEEditorImageEditFragment.f(this.a).setCrop(i, (CropConfig)paramList.get(i));
        AEEditorImageEditFragment.a(this.a, i);
      }
      i += 1;
    }
  }
  
  public void b()
  {
    this.a.N();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.5
 * JD-Core Version:    0.7.0.1
 */