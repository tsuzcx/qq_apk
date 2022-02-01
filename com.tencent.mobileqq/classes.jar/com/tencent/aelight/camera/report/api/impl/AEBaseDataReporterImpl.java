package com.tencent.aelight.camera.report.api.impl;

import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;

public class AEBaseDataReporterImpl
  implements IAEBaseDataReporter
{
  public void reportARVideoDownloadBtn()
  {
    AEBaseDataReporter.a().f();
  }
  
  public void reportARVideoExpose()
  {
    AEBaseDataReporter.a().h();
  }
  
  public void reportARVideoShareBtn()
  {
    AEBaseDataReporter.a().g();
  }
  
  public void reportClickFilterItem(String paramString)
  {
    AEBaseDataReporter.a().e(paramString);
  }
  
  public void reportCmShowPhotoListClickCloseBtn()
  {
    AEBaseDataReporter.a().aK();
  }
  
  public void reportCmShowPhotoListExit(long paramLong)
  {
    AEBaseDataReporter.a().f(paramLong);
  }
  
  public void reportCmShowPhotoListExpose()
  {
    AEBaseDataReporter.a().aI();
  }
  
  public void reportCmShowPhotoListPickPhoto()
  {
    AEBaseDataReporter.a().aJ();
  }
  
  public void reportCmShowPhotoPreviewClickBackBtn()
  {
    AEBaseDataReporter.a().aM();
  }
  
  public void reportCmShowPhotoPreviewClickConfirmBtn()
  {
    AEBaseDataReporter.a().aL();
  }
  
  public void reportDownloadBtn()
  {
    AEBaseDataReporter.a().e();
  }
  
  public void reportEditView()
  {
    AEBaseDataReporter.a().b();
  }
  
  public void reportEditViewExpose()
  {
    AEBaseDataReporter.a().a();
  }
  
  public void reportEmoFilterItem(String paramString)
  {
    AEBaseDataReporter.a().j(paramString);
  }
  
  public void reportPicChooseNextBtn()
  {
    AEBaseDataReporter.a().Z();
  }
  
  public void reportPostBtn()
  {
    AEBaseDataReporter.a().c();
  }
  
  public void reportPostBtn(String paramString, int paramInt)
  {
    AEBaseDataReporter.a().a(paramString, paramInt);
  }
  
  public void reportRephotoBtn()
  {
    AEBaseDataReporter.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.report.api.impl.AEBaseDataReporterImpl
 * JD-Core Version:    0.7.0.1
 */