package com.tencent.aelight.camera.aeeditor.module.edit;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.autotemplate.AEAutoTemplateRet;
import com.tencent.aelight.camera.aeeditor.util.AEQCircleReport;
import com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
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
    int i = paramAEAutoTemplateRet.a();
    if (i != 0)
    {
      if (i != 5)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          QQToast.makeText(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getString(2064187548), 1).show();
          if (this.a.j != null)
          {
            this.a.j.a();
            this.a.j = null;
          }
          AEEditorVideoEditFragment.d(this.a).remove(paramAEAutoTemplateRet.b().id);
          AEQCircleReport.a().a(paramAEAutoTemplateRet.b().id, QCircleConstants.x, "-90000000");
          return;
        }
        if (!AEEditorVideoEditFragment.e(this.a).contains(paramAEAutoTemplateRet.b().id))
        {
          paramAEAutoTemplateRet = paramAEAutoTemplateRet.b();
          this.a.a(paramAEAutoTemplateRet);
          this.a.getActivity().runOnUiThread(new AEEditorVideoEditFragment.2.1(this));
        }
        else
        {
          AEEditorVideoEditFragment.e(this.a).remove(paramAEAutoTemplateRet.b().id);
        }
        if ((AEEditorVideoEditFragment.f(this.a).booleanValue()) && (TextUtils.isEmpty(AEEditorVideoEditFragment.g(this.a))))
        {
          paramAEAutoTemplateRet = this.a;
          AEEditorVideoEditFragment.a(paramAEAutoTemplateRet, paramAEAutoTemplateRet.af());
          AEEditorVideoEditFragment.a(this.a, Boolean.valueOf(false));
        }
      }
      else
      {
        this.a.a(null);
      }
    }
    else
    {
      AEEditorVideoEditFragment.d(this.a).add(paramAEAutoTemplateRet.b().id);
      AEEditorVideoEditFragment.e(this.a).remove(paramAEAutoTemplateRet.b().id);
      AEEditorVideoEditFragment.a(this.a, paramAEAutoTemplateRet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.2
 * JD-Core Version:    0.7.0.1
 */