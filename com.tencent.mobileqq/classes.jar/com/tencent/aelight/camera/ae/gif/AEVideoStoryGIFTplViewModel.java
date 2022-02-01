package com.tencent.aelight.camera.ae.gif;

import android.support.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager.DownloadCallback;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.download.AEDownloadStateWrapper;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.HashMap;
import java.util.Map;

public class AEVideoStoryGIFTplViewModel
  extends ViewModel
{
  private MutableLiveData<AEDownloadStateWrapper> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private Map<String, AEGifMaterialManager.DownloadCallback> jdField_a_of_type_JavaUtilMap = new HashMap();
  private MutableLiveData<AEMaterialWrapper> b = new MutableLiveData();
  private MutableLiveData<String> c = new MutableLiveData();
  private MutableLiveData<String> d = new MutableLiveData();
  
  public MutableLiveData<AEDownloadStateWrapper> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public void a()
  {
    AEMaterialWrapper localAEMaterialWrapper = (AEMaterialWrapper)this.b.getValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[applyGIFTplAgain], lastMaterial=");
    localStringBuilder.append(localAEMaterialWrapper);
    AEQLog.b("AEVideoStoryGIFTplViewModel", localStringBuilder.toString());
    this.b.postValue(localAEMaterialWrapper);
  }
  
  public void a(AEMaterialWrapper paramAEMaterialWrapper)
  {
    AEVideoStoryGIFTplViewModel.1 local1 = new AEVideoStoryGIFTplViewModel.1(this);
    this.jdField_a_of_type_JavaUtilMap.put(paramAEMaterialWrapper.jdField_a_of_type_JavaLangString, local1);
    AEGifMaterialManager.a().a(AECaptureContext.a(), paramAEMaterialWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, local1);
  }
  
  public MutableLiveData<AEMaterialWrapper> b()
  {
    return this.b;
  }
  
  public void b(@Nullable AEMaterialWrapper paramAEMaterialWrapper)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[applyGIFTpl], material=");
    localStringBuilder.append(paramAEMaterialWrapper);
    AEQLog.b("AEVideoStoryGIFTplViewModel", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[applyGIFTpl], material=");
    localStringBuilder.append(paramAEMaterialWrapper);
    AEQLog.b("AEGIFStickerListPart", localStringBuilder.toString());
    this.b.postValue(paramAEMaterialWrapper);
  }
  
  public MutableLiveData<String> c()
  {
    return this.c;
  }
  
  public void c(@Nullable AEMaterialWrapper paramAEMaterialWrapper)
  {
    if (paramAEMaterialWrapper != null)
    {
      paramAEMaterialWrapper = (String)paramAEMaterialWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename");
      this.c.postValue(paramAEMaterialWrapper);
      return;
    }
    this.c.postValue(null);
  }
  
  public MutableLiveData<String> d()
  {
    return this.d;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEVideoStoryGIFTplViewModel
 * JD-Core Version:    0.7.0.1
 */