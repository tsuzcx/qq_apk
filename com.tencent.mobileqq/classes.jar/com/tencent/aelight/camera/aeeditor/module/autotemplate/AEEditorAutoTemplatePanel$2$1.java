package com.tencent.aelight.camera.aeeditor.module.autotemplate;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;

class AEEditorAutoTemplatePanel$2$1
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AEEditorAutoTemplatePanel$2$1(AEEditorAutoTemplatePanel.2 param2, MetaMaterial paramMetaMaterial) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      MetaMaterialKt.b(this.a, AEEditorResourceManager.a().a(this.a));
    }
    else
    {
      AEEditorAutoTemplatePanel.d(this.b.a).b(-1);
      new Handler(Looper.getMainLooper()).post(new AEEditorAutoTemplatePanel.2.1.1(this));
    }
    if (paramBoolean)
    {
      AEEditorAutoTemplatePanel.e(this.b.a).postValue(new AEAutoTemplateRet(2, this.a));
      return;
    }
    AEEditorAutoTemplatePanel.e(this.b.a).postValue(new AEAutoTemplateRet(3, this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.2.1
 * JD-Core Version:    0.7.0.1
 */