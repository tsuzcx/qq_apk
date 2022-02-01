package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorCropperPanel.CropChangeCallback;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.session.TAVCutImageSession;
import java.util.List;

class AEEditorImageEditFragment$5
  implements AEEditorCropperPanel.CropChangeCallback
{
  AEEditorImageEditFragment$5(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a()
  {
    AEEditorImageEditFragment localAEEditorImageEditFragment = this.a;
    if (localAEEditorImageEditFragment.a(AEEditorImageEditFragment.a(localAEEditorImageEditFragment)))
    {
      AEEditorImageEditFragment.a(this.a).updateTemplateCrop(AEEditorImageEditFragment.a(this.a), ((AEEditorImageInfo)AEEditorImageEditFragment.a(this.a).get(AEEditorImageEditFragment.a(this.a))).a);
      AEEditorImageEditFragment.a(this.a).updateAndRenderTemplate(AEEditorImageEditFragment.a(this.a), true, new AEEditorImageEditFragment.5.1(this));
      return;
    }
    AEEditorImageEditFragment.a(this.a).setCrop(AEEditorImageEditFragment.a(this.a), ((AEEditorImageInfo)AEEditorImageEditFragment.a(this.a).get(AEEditorImageEditFragment.a(this.a))).a);
    localAEEditorImageEditFragment = this.a;
    AEEditorImageEditFragment.a(localAEEditorImageEditFragment, AEEditorImageEditFragment.a(localAEEditorImageEditFragment));
    this.a.x();
  }
  
  public void a(int paramInt, List<CropConfig> paramList)
  {
    int i = 0;
    while (i < AEEditorImageEditFragment.a(this.a).size())
    {
      if ((i != AEEditorImageEditFragment.a(this.a)) && (!this.a.a(i)))
      {
        ((AEEditorImageInfo)AEEditorImageEditFragment.a(this.a).get(i)).a(paramInt);
        ((AEEditorImageInfo)AEEditorImageEditFragment.a(this.a).get(i)).a((CropConfig)paramList.get(i));
        AEEditorImageEditFragment.a(this.a).setCrop(i, (CropConfig)paramList.get(i));
        AEEditorImageEditFragment.a(this.a, i);
      }
      i += 1;
    }
  }
  
  public void b()
  {
    this.a.x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.5
 * JD-Core Version:    0.7.0.1
 */