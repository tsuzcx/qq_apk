package com.tencent.aelight.camera.report.api.impl;

import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;

public class AEBaseDataReporterImpl
  implements IAEBaseDataReporter
{
  public void reportARVideoDownloadBtn()
  {
    AEBaseDataReporter.a().g();
  }
  
  public void reportARVideoExpose()
  {
    AEBaseDataReporter.a().i();
  }
  
  public void reportARVideoShareBtn()
  {
    AEBaseDataReporter.a().h();
  }
  
  public void reportClickFilterItem(String paramString)
  {
    AEBaseDataReporter.a().e(paramString);
  }
  
  public void reportCmShowPhotoListClickCloseBtn()
  {
    AEBaseDataReporter.a().aP();
  }
  
  public void reportCmShowPhotoListExit(long paramLong)
  {
    AEBaseDataReporter.a().f(paramLong);
  }
  
  public void reportCmShowPhotoListExpose()
  {
    AEBaseDataReporter.a().aN();
  }
  
  public void reportCmShowPhotoListPickPhoto()
  {
    AEBaseDataReporter.a().aO();
  }
  
  public void reportCmShowPhotoPreviewClickBackBtn()
  {
    AEBaseDataReporter.a().aR();
  }
  
  public void reportCmShowPhotoPreviewClickConfirmBtn()
  {
    AEBaseDataReporter.a().aQ();
  }
  
  public void reportDownloadBtn()
  {
    AEBaseDataReporter.a().f();
  }
  
  public void reportEditView()
  {
    AEBaseDataReporter.a().c();
  }
  
  public void reportEditViewExpose()
  {
    AEBaseDataReporter.a().b();
  }
  
  public void reportEmoFilterItem(String paramString)
  {
    AEBaseDataReporter.a().l(paramString);
  }
  
  public void reportPicChooseNextBtn()
  {
    AEBaseDataReporter.a().aa();
  }
  
  public void reportPostBtn()
  {
    AEBaseDataReporter.a().d();
  }
  
  public void reportPostBtn(String paramString, int paramInt)
  {
    AEBaseDataReporter.a().a(paramString, paramInt);
  }
  
  public void reportRephotoBtn()
  {
    AEBaseDataReporter.a().e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.report.api.impl.AEBaseDataReporterImpl
 * JD-Core Version:    0.7.0.1
 */