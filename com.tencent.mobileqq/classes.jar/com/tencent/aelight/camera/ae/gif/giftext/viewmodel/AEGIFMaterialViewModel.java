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
  private MutableLiveData<AEDownloadStateWrapper> a = new MutableLiveData();
  private Map<String, AEGifMaterialManager.DownloadCallback> b = new HashMap();
  
  public MutableLiveData<AEDownloadStateWrapper> a()
  {
    return this.a;
  }
  
  public void a(AppInterface paramAppInterface, AEGIFPreviewWrapper paramAEGIFPreviewWrapper)
  {
    AEGIFMaterialViewModel.1 local1 = new AEGIFMaterialViewModel.1(this);
    this.b.put(paramAEGIFPreviewWrapper.c.id, local1);
    AEGifMaterialManager.a().a(paramAppInterface, paramAEGIFPreviewWrapper.c, local1);
  }
  
  public void onCleared()
  {
    super.onCleared();
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel
 * JD-Core Version:    0.7.0.1
 */