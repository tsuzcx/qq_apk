package com.tencent.aelight.camera.ae.gif.giftext.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager.DownloadCallback;
import com.tencent.aelight.camera.ae.download.AEDownloadStateWrapper;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFPreviewWrapper;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;
import java.util.Map;

public class AEGIFMaterialViewModel
  extends ViewModel
{
  private MutableLiveData<AEDownloadStateWrapper> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private Map<String, AEGifMaterialManager.DownloadCallback> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public MutableLiveData<AEDownloadStateWrapper> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public void a(AppInterface paramAppInterface, AEGIFPreviewWrapper paramAEGIFPreviewWrapper)
  {
    AEGIFMaterialViewModel.1 local1 = new AEGIFMaterialViewModel.1(this);
    this.jdField_a_of_type_JavaUtilMap.put(paramAEGIFPreviewWrapper.a.id, local1);
    AEGifMaterialManager.a().a(paramAppInterface, paramAEGIFPreviewWrapper.a, local1);
  }
  
  public void onCleared()
  {
    super.onCleared();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel
 * JD-Core Version:    0.7.0.1
 */