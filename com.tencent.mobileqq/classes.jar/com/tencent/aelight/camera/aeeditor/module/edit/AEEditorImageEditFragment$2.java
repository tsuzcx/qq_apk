package com.tencent.aelight.camera.aeeditor.module.edit;

import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.aelight.camera.aeeditor.module.MaterialViewModel;
import com.tencent.aelight.camera.aeeditor.module.frame.AEEditorFramePanel;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.List;

class AEEditorImageEditFragment$2
  implements Observer<List<MetaCategory>>
{
  AEEditorImageEditFragment$2(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(List<MetaCategory> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChanged... FrameLiveData size:");
    Object localObject;
    if (paramList != null) {
      localObject = Integer.valueOf(paramList.size());
    } else {
      localObject = "0";
    }
    localStringBuilder.append(localObject);
    AEQLog.a("AEEditorImageEditFragment", localStringBuilder.toString());
    AEEditorImageEditFragment.a(this.a).setTemplateMaterials(paramList, AEEditorCommonEditFragment.a, this.a.b());
    this.a.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.2
 * JD-Core Version:    0.7.0.1
 */