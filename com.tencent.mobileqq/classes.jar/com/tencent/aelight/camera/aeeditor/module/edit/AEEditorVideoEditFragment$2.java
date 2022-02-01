package com.tencent.aelight.camera.aeeditor.module.edit;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.util.AEQCircleReport;
import com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateRet;
import java.util.concurrent.CopyOnWriteArrayList;

class AEEditorVideoEditFragment$2
  implements Observer<AEAutoTemplateRet>
{
  AEEditorVideoEditFragment$2(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void a(@Nullable AEAutoTemplateRet paramAEAutoTemplateRet)
  {
    if (paramAEAutoTemplateRet == null) {
      return;
    }
    int i = (int)paramAEAutoTemplateRet.a();
    if (i != 0)
    {
      if (i != 5)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getString(2064515202), 1).a();
          if (this.a.a != null)
          {
            this.a.a.a();
            this.a.a = null;
          }
          AEEditorVideoEditFragment.a(this.a).remove(paramAEAutoTemplateRet.a().id);
          AEQCircleReport.a().a(paramAEAutoTemplateRet.a().id, QCircleConstants.KEY_VIDEO, "-90000000");
          return;
        }
        if (!AEEditorVideoEditFragment.b(this.a).contains(paramAEAutoTemplateRet.a().id))
        {
          paramAEAutoTemplateRet = paramAEAutoTemplateRet.a();
          this.a.a(paramAEAutoTemplateRet);
          this.a.getActivity().runOnUiThread(new AEEditorVideoEditFragment.2.1(this));
          return;
        }
        AEEditorVideoEditFragment.b(this.a).remove(paramAEAutoTemplateRet.a().id);
        return;
      }
      this.a.a(null);
      return;
    }
    AEEditorVideoEditFragment.a(this.a).add(paramAEAutoTemplateRet.a().id);
    AEEditorVideoEditFragment.b(this.a).remove(paramAEAutoTemplateRet.a().id);
    AEEditorVideoEditFragment.a(this.a, paramAEAutoTemplateRet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.2
 * JD-Core Version:    0.7.0.1
 */