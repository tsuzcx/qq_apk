package com.tencent.aelight.camera.aeeditor.module.autotemplate;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateRet;

class AEEditorAutoTemplatePanel$2$1
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AEEditorAutoTemplatePanel$2$1(AEEditorAutoTemplatePanel.2 param2, MetaMaterial paramMetaMaterial) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      MetaMaterialKt.b(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, AEEditorResourceManager.a().a(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial));
    }
    else
    {
      AEEditorAutoTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel$2.a).b(-1);
      new Handler(Looper.getMainLooper()).post(new AEEditorAutoTemplatePanel.2.1.1(this));
    }
    if (paramBoolean)
    {
      AEEditorAutoTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel$2.a).postValue(new AEAutoTemplateRet(2L, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial));
      return;
    }
    AEEditorAutoTemplatePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel$2.a).postValue(new AEAutoTemplateRet(3L, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.2.1
 * JD-Core Version:    0.7.0.1
 */