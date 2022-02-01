package com.tencent.aelight.camera.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAEBaseDataReporter
  extends QRouteApi
{
  public abstract void reportARVideoDownloadBtn();
  
  public abstract void reportARVideoExpose();
  
  public abstract void reportARVideoShareBtn();
  
  public abstract void reportClickFilterItem(String paramString);
  
  public abstract void reportCmShowPhotoListClickCloseBtn();
  
  public abstract void reportCmShowPhotoListExit(long paramLong);
  
  public abstract void reportCmShowPhotoListExpose();
  
  public abstract void reportCmShowPhotoListPickPhoto();
  
  public abstract void reportCmShowPhotoPreviewClickBackBtn();
  
  public abstract void reportCmShowPhotoPreviewClickConfirmBtn();
  
  public abstract void reportDownloadBtn();
  
  public abstract void reportEditView();
  
  public abstract void reportEditViewExpose();
  
  public abstract void reportEmoFilterItem(String paramString);
  
  public abstract void reportPicChooseNextBtn();
  
  public abstract void reportPostBtn();
  
  public abstract void reportPostBtn(String paramString, int paramInt);
  
  public abstract void reportRephotoBtn();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.report.api.IAEBaseDataReporter
 * JD-Core Version:    0.7.0.1
 */